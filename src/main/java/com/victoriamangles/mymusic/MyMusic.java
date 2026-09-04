package com.victoriamangles.mymusic;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MyMusic.MODID)
public class MyMusic {

    public static final String MODID = "mymusic";

    public MyMusic() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModSounds.SOUNDS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.CREATIVE_MODE_TABS.register(modEventBus);

        ModLoadingContext.get().registerConfig(Type.COMMON, ModConfig.COMMON_SPEC, "MyMusic/mymusic-common.toml");
    }
}
