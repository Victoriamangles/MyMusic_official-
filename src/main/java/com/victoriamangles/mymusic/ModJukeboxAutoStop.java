package com.victoriamangles.mymusic;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

/**
 * Erzwingt einen ECHTEN Stopp nach der konfigurierten Disc-Laenge, unabhaengig
 * davon, ob die eigentliche Audiodatei laenger ist oder Sophisticated Backpacks
 * den natuerlichen Stopp ignoriert.
 *
 * Funktionsweise: Beim Einlegen einer unserer Discs merken wir uns Position +
 * Zeitpunkt. Nach Ablauf der konfigurierten Sekunden simulieren wir per
 * FakePlayer einen leeren Rechtsklick auf die Jukebox - EXAKT derselbe
 * Code-Pfad, der beim manuellen Auswerfen zuverlaessig den Ton stoppt.
 *
 * EXPERIMENTELL - hoechste Unsicherheit aller bisherigen Features dieser Mod.
 */
@Mod.EventBusSubscriber(modid = MyMusic.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModJukeboxAutoStop {

    private record ScheduledStop(
            ResourceKey<Level> dimension,
            BlockPos pos,
            long stopAtGameTime
    ) {}

    private static final List<ScheduledStop> SCHEDULED = new ArrayList<>();

    @SubscribeEvent
    public static void onRightClickJukebox(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        if (level.isClientSide()) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (!(state.getBlock() instanceof JukeboxBlock)) {
            return;
        }
        if (state.getValue(JukeboxBlock.HAS_RECORD)) {
            return; // schon belegt, kein Insert-Vorgang
        }

        ItemStack heldItem = event.getItemStack();
        Item item = heldItem.getItem();
        if (!(item instanceof RecordItem)) {
            return;
        }

        String discId = null;
        for (var entry : ModItems.ITEM_MAP.entrySet()) {
            if (entry.getValue().isPresent() && entry.getValue().get() == item) {
                discId = entry.getKey();
                break;
            }
        }
        if (discId == null) {
            return; // fremde Disc, nicht unsere - nicht anfassen
        }

        int lengthSeconds = 180;
        for (ModDiscs.DiscDefinition disc : ModDiscs.ALL) {
            if (disc.id().equals(discId)) {
                lengthSeconds = disc.lengthInSeconds();
                break;
            }
        }

        long stopAtTick = level.getGameTime() + ((long) lengthSeconds * 20L);
        SCHEDULED.add(new ScheduledStop(level.dimension(), pos.immutable(), stopAtTick));
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }
        if (SCHEDULED.isEmpty()) {
            return;
        }

        List<ScheduledStop> due = new ArrayList<>();
        for (ScheduledStop stop : SCHEDULED) {
            ServerLevel level = event.getServer().getLevel(stop.dimension());
            if (level == null) {
                due.add(stop);
                continue;
            }
            if (level.getGameTime() >= stop.stopAtGameTime) {
                forceStop(level, stop.pos);
                due.add(stop);
            }
        }
        SCHEDULED.removeAll(due);
    }

    private static void forceStop(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (!(state.getBlock() instanceof JukeboxBlock)) {
            return;
        }
        if (!state.getValue(JukeboxBlock.HAS_RECORD)) {
            return; // wurde in der Zwischenzeit schon manuell ausgeworfen
        }

        FakePlayer fakePlayer = FakePlayerFactory.getMinecraft(level);
        fakePlayer.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);

        BlockHitResult hitResult = new BlockHitResult(
                Vec3.atCenterOf(pos), Direction.UP, pos, false);

        state.getBlock().use(state, level, pos, fakePlayer, InteractionHand.MAIN_HAND, hitResult);
    }
}
