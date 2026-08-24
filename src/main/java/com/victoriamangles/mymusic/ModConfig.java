package com.victoriamangles.mymusic;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

/**
 * Config-Werte, die der Spieler selbst anpassen kann.
 * Datei liegt nach dem ersten Start unter: config/mymusic-common.toml
 */
public class ModConfig {

    public static final ForgeConfigSpec COMMON_SPEC;

    public static final ForgeConfigSpec.BooleanValue LOOT_CHEST_ENABLED;
    public static final ForgeConfigSpec.DoubleValue LOOT_CHEST_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> LOOT_CHEST_TABLES;

    public static final ForgeConfigSpec.BooleanValue MOB_DROP_ENABLED;
    public static final ForgeConfigSpec.DoubleValue MOB_DROP_CHANCE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("loot_chests");

        LOOT_CHEST_ENABLED = builder
                .comment("Sollen MyMusic Discs in Loot-Kisten (Dungeons, Mineshafts, etc.) auftauchen können?")
                .define("enabled", true);

        LOOT_CHEST_CHANCE = builder
                .comment("Wahrscheinlichkeit (0.0 bis 1.0), dass eine betroffene Kiste EINE zufällige Disc enthält.",
                        "0.2 = 20% Chance pro Kiste. Nur relevant wenn 'enabled' true ist.")
                .defineInRange("chance", 0.2, 0.0, 1.0);

        LOOT_CHEST_TABLES = builder
                .comment("Liste der Loot-Table-IDs, in denen Discs auftauchen können.",
                        "Eigene/modded Loot-Tables können hier ergänzt werden (z.B. \"modid:chests/xyz\").")
                .defineList("tables", Arrays.asList(
                        "minecraft:chests/simple_dungeon",
                        "minecraft:chests/abandoned_mineshaft",
                        "minecraft:chests/stronghold_corridor",
                        "minecraft:chests/stronghold_crossing",
                        "minecraft:chests/stronghold_library",
                        "minecraft:chests/jungle_temple",
                        "minecraft:chests/desert_pyramid",
                        "minecraft:chests/woodland_mansion",
                        "minecraft:chests/ancient_city",
                        "minecraft:chests/bastion_treasure",
                        "minecraft:chests/nether_bridge",
                        "minecraft:chests/shipwreck_treasure",
                        "minecraft:chests/buried_treasure",
                        "minecraft:chests/village/village_desert_house",
                        "minecraft:chests/village/village_plains_house"
                ), obj -> obj instanceof String);

        builder.pop();

        builder.push("mob_drops");

        MOB_DROP_ENABLED = builder
                .comment("Sollen feindliche Mobs beim Tod gelegentlich eine Disc fallen lassen können?")
                .define("enabled", true);

        MOB_DROP_CHANCE = builder
                .comment("Wahrscheinlichkeit (0.0 bis 1.0), dass ein getöteter feindlicher Mob EINE zufällige Disc droppt.",
                        "0.002 = 0.2% Chance pro Kill. Nur relevant wenn 'enabled' true ist.")
                .defineInRange("chance", 0.002, 0.0, 1.0);

        builder.pop();

        COMMON_SPEC = builder.build();
    }
}
