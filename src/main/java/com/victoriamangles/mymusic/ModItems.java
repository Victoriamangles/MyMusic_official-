package com.victoriamangles.mymusic;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MyMusic.MODID);

    public static final Map<String, RegistryObject<Item>> ITEM_MAP = new HashMap<>();

    static {
        for (ModDiscs.DiscDefinition disc : ModDiscs.ALL) {
            int lengthInTicks = disc.lengthInSeconds() * 20;
            RegistryObject<Item> item = ITEMS.register(disc.id(), () -> new RecordItem(
                    disc.comparatorOutput(),
                    ModSounds.SOUND_MAP.get(disc.id()).get(),
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    lengthInTicks
            ));
            ITEM_MAP.put(disc.id(), item);
        }
    }
}
