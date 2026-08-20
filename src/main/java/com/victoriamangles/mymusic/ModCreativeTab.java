package com.victoriamangles.mymusic;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyMusic.MODID);

    public static final RegistryObject<CreativeModeTab> MYMUSIC_TAB = CREATIVE_MODE_TABS.register(
            "mymusic_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mymusic"))
                    .icon(() -> new ItemStack(Items.MUSIC_DISC_13))
                    .displayItems((parameters, output) -> {
                        for (ModDiscs.DiscDefinition disc : ModDiscs.ALL) {
                            output.accept(ModItems.ITEM_MAP.get(disc.id()).get());
                        }
                    })
                    .build()
    );
}
