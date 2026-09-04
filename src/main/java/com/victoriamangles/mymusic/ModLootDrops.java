package com.victoriamangles.mymusic;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MyMusic.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModLootDrops {

    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        if (!ModConfig.LOOT_CHEST_ENABLED.get()) {
            return;
        }

        String tableId = event.getName().toString();
        List<? extends String> configuredTables = ModConfig.LOOT_CHEST_TABLES.get();

        if (!configuredTables.contains(tableId)) {
            return;
        }

        List<Item> allDiscs = getAllDiscItems();
        if (allDiscs.isEmpty()) {
            return;
        }

        LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .when(LootItemRandomChanceCondition.randomChance((float) (double) ModConfig.LOOT_CHEST_CHANCE.get()));

        for (Item disc : allDiscs) {
            poolBuilder.add(LootItem.lootTableItem(disc).setWeight(1));
        }

        event.getTable().addPool(poolBuilder.build());
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (!ModConfig.MOB_DROP_ENABLED.get()) {
            return;
        }

        Entity entity = event.getEntity();
        if (!(entity instanceof Monster)) {
            return;
        }
        if (entity instanceof PartEntity<?>) {
            return;
        }

        double chance = ModConfig.MOB_DROP_CHANCE.get();
        if (RANDOM.nextDouble() >= chance) {
            return;
        }

        List<Item> allDiscs = getAllDiscItems();
        if (allDiscs.isEmpty()) {
            return;
        }

        Item randomDisc = allDiscs.get(RANDOM.nextInt(allDiscs.size()));
        entity.spawnAtLocation(new ItemStack(randomDisc));
    }

    private static List<Item> getAllDiscItems() {
        List<Item> items = new ArrayList<>();
        for (ModDiscs.DiscDefinition disc : ModDiscs.ALL) {
            var registryObject = ModItems.ITEM_MAP.get(disc.id());
            if (registryObject != null && registryObject.isPresent()) {
                items.add(registryObject.get());
            }
        }
        return items;
    }
}
