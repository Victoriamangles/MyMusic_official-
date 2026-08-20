package com.victoriamangles.mymusic;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MyMusic.MODID);

    public static final Map<String, RegistryObject<SoundEvent>> SOUND_MAP = new HashMap<>();

    static {
        for (ModDiscs.DiscDefinition disc : ModDiscs.ALL) {
            ResourceLocation id = new ResourceLocation(MyMusic.MODID, disc.id());
            RegistryObject<SoundEvent> sound = SOUNDS.register(disc.id(),
                    () -> SoundEvent.createVariableRangeEvent(id));
            SOUND_MAP.put(disc.id(), sound);
        }
    }
}
