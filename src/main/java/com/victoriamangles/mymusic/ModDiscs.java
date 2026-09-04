package com.victoriamangles.mymusic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModDiscs {

    public record DiscDefinition(
            String id,
            int comparatorOutput,
            int lengthInSeconds
    ) {}

    public static final List<DiscDefinition> ALL = new ArrayList<>();

    static {
        List<String> discIds = new ArrayList<>();
        Map<String, Integer> rawDefaults = new HashMap<>();
        Map<String, Integer> rawComparators = new HashMap<>();

        rawDefaults.put("disc1", 590);
        rawComparators.put("disc1", 11);
        discIds.add("disc1"); // Ramin Djawadi - Light of the Seven
        rawDefaults.put("disc2", 225);
        rawComparators.put("disc2", 12);
        discIds.add("disc2"); // Rick and Morty: Evil Morty Theme
        rawDefaults.put("disc3", 317);
        rawComparators.put("disc3", 13);
        discIds.add("disc3"); // Claude Debussy - Clair de Lune
        rawDefaults.put("disc4", 266);
        rawComparators.put("disc4", 14);
        discIds.add("disc4"); // Lost in Space (DjNeratops)
        rawDefaults.put("disc5", 243);
        rawComparators.put("disc5", 15);
        discIds.add("disc5"); // Hans Zimmer - Interstellar
        rawDefaults.put("disc6", 335);
        rawComparators.put("disc6", 1);
        discIds.add("disc6"); // Eminem & D12 - My Band ft. Cameo
        rawDefaults.put("disc7", 249);
        rawComparators.put("disc7", 2);
        discIds.add("disc7"); // TBS - Mein Stern
        rawDefaults.put("disc8", 406);
        rawComparators.put("disc8", 3);
        discIds.add("disc8"); // Avenged Sevenfold - Buried Alive
        rawDefaults.put("disc9", 246);
        rawComparators.put("disc9", 4);
        discIds.add("disc9"); // Dame - Pave Low
        rawDefaults.put("disc10", 507);
        rawComparators.put("disc10", 5);
        discIds.add("disc10"); // Wardruna - Lyfjaberg
        rawDefaults.put("disc11", 323);
        rawComparators.put("disc11", 6);
        discIds.add("disc11"); // K.I.Z - Neuruppin
        rawDefaults.put("disc12", 219);
        rawComparators.put("disc12", 7);
        discIds.add("disc12"); // Alligatoah - Stay In Touch
        rawDefaults.put("disc13", 216);
        rawComparators.put("disc13", 8);
        discIds.add("disc13"); // Twenty One Pilots - Heathens / Stranger Things
        rawDefaults.put("disc14", 278);
        rawComparators.put("disc14", 9);
        discIds.add("disc14"); // Hoist the Colours - The Bass Singers
        rawDefaults.put("disc15", 206);
        rawComparators.put("disc15", 10);
        discIds.add("disc15"); // Linkin Park - Castle of Glass
        rawDefaults.put("disc16", 385);
        rawComparators.put("disc16", 1);
        discIds.add("disc16"); // Metallica - Nothing Else Matters
        rawDefaults.put("disc17", 278);
        rawComparators.put("disc17", 2);
        discIds.add("disc17"); // Nirvana - Smells Like Teen Spirit
        rawDefaults.put("disc18", 515);
        rawComparators.put("disc18", 3);
        discIds.add("disc18"); // Metallica - Master of Puppets
        rawDefaults.put("disc19", 158);
        rawComparators.put("disc19", 4);
        discIds.add("disc19"); // Kids
        rawDefaults.put("disc20", 244);
        rawComparators.put("disc20", 5);
        discIds.add("disc20"); // Bloodhound Gang - The Bad Touch
        rawDefaults.put("disc21", 254);
        rawComparators.put("disc21", 6);
        discIds.add("disc21"); // Gorillaz - Feel Good Inc.
        rawDefaults.put("disc22", 217);
        rawComparators.put("disc22", 7);
        discIds.add("disc22"); // Disturbed - Down With The Sickness
        rawDefaults.put("disc23", 249);
        rawComparators.put("disc23", 8);
        discIds.add("disc23"); // Vitas - The 7th Element
        rawDefaults.put("disc24", 321);
        rawComparators.put("disc24", 9);
        discIds.add("disc24"); // Daft Punk - One More Time
        rawDefaults.put("disc25", 219);
        rawComparators.put("disc25", 10);
        discIds.add("disc25"); // Drowning Pool - Bodies
        rawDefaults.put("disc26", 219);
        rawComparators.put("disc26", 11);
        discIds.add("disc26"); // Bad Apple
        rawDefaults.put("disc27", 491);
        rawComparators.put("disc27", 12);
        discIds.add("disc27"); // Hiroki Kikuta (Koudelka) - Waterfall
        rawDefaults.put("disc28", 235);
        rawComparators.put("disc28", 13);
        discIds.add("disc28"); // Skyrim Theme Song
        rawDefaults.put("disc29", 134);
        rawComparators.put("disc29", 14);
        discIds.add("disc29"); // W&W - OIIA OIIA
        rawDefaults.put("disc30", 206);
        rawComparators.put("disc30", 15);
        discIds.add("disc30"); // Oliver Tree - Life Goes On
        rawDefaults.put("disc31", 92);
        rawComparators.put("disc31", 1);
        discIds.add("disc31"); // Prelude
        rawDefaults.put("disc32", 169);
        rawComparators.put("disc32", 2);
        discIds.add("disc32"); // Oliver Tree & Robin Schulz - Miss You
        rawDefaults.put("disc33", 137);
        rawComparators.put("disc33", 3);
        discIds.add("disc33"); // Terraria Soundtrack: Overworld Day
        rawDefaults.put("disc34", 194);
        rawComparators.put("disc34", 4);
        discIds.add("disc34"); // Noisestorm - Crab Rave
        rawDefaults.put("disc35", 262);
        rawComparators.put("disc35", 5);
        discIds.add("disc35"); // ConcernedApe - Spring (The Valley Comes Alive)
        rawDefaults.put("disc36", 355);
        rawComparators.put("disc36", 6);
        discIds.add("disc36"); // M83 - Wait
        rawDefaults.put("disc37", 224);
        rawComparators.put("disc37", 7);
        discIds.add("disc37"); // Band of Horses - The Funeral
        rawDefaults.put("disc38", 315);
        rawComparators.put("disc38", 8);
        discIds.add("disc38"); // Ludovico Einaudi - Experience
        rawDefaults.put("disc39", 304);
        rawComparators.put("disc39", 9);
        discIds.add("disc39"); // Pixies - Where Is My Mind (WhyAsk! Remix)
        rawDefaults.put("disc40", 205);
        rawComparators.put("disc40", 10);
        discIds.add("disc40"); // LUM!X, Gabry Ponte - Monster (Gabry Ponte 2023 Remix)

        // Laengen-Ueberschreibungen aus config/MyMusic/DiscLengths.txt laden -
        // MUSS vor dem Aufbau von ALL passieren, da RecordItem-Laenge nach der
        // Registrierung nicht mehr aenderbar ist (siehe ModDiscLengths.java).
        ModDiscLengths.load(discIds, rawDefaults);

        for (String id : discIds) {
            int comparator = rawComparators.get(id);
            int defaultLength = rawDefaults.get(id);
            int finalLength = ModDiscLengths.getLength(id, defaultLength);
            ALL.add(new DiscDefinition(id, comparator, finalLength));
        }
    }
}
