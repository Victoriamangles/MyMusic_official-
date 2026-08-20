package com.victoriamangles.mymusic;

import java.util.ArrayList;
import java.util.List;

/**
 * ZENTRALE DISC-LISTE
 * ===================
 * Hier trägst du neue Discs ein - das ist die EINZIGE Stelle im Java-Code,
 * die du für eine neue Disc anfassen musst. ModSounds, ModItems und
 * ModCreativeTab lesen automatisch aus dieser Liste.
 */
public class ModDiscs {

    public record DiscDefinition(
            String id,
            int comparatorOutput,
            int lengthInSeconds
    ) {}

    public static final List<DiscDefinition> ALL = new ArrayList<>();

    static {
        ALL.add(new DiscDefinition("disc1", 11, 590)); // Ramin Djawadi - Light of the Seven
        ALL.add(new DiscDefinition("disc2", 12, 225)); // Rick and Morty: Evil Morty Theme
        ALL.add(new DiscDefinition("disc3", 13, 317)); // Claude Debussy - Clair de Lune
        ALL.add(new DiscDefinition("disc4", 14, 266)); // Lost in Space (DjNeratops)
        ALL.add(new DiscDefinition("disc5", 15, 243)); // Hans Zimmer - Interstellar
        ALL.add(new DiscDefinition("disc6", 1, 335)); // Eminem & D12 - My Band ft. Cameo
        ALL.add(new DiscDefinition("disc7", 2, 249)); // TBS - Mein Stern
        ALL.add(new DiscDefinition("disc8", 3, 406)); // Avenged Sevenfold - Buried Alive
        ALL.add(new DiscDefinition("disc9", 4, 246)); // Dame - Pave Low
        ALL.add(new DiscDefinition("disc10", 5, 507)); // Wardruna - Lyfjaberg
        ALL.add(new DiscDefinition("disc11", 6, 323)); // K.I.Z - Neuruppin
        ALL.add(new DiscDefinition("disc12", 7, 219)); // Alligatoah - Stay In Touch
        ALL.add(new DiscDefinition("disc13", 8, 216)); // Twenty One Pilots - Heathens / Stranger Things
        ALL.add(new DiscDefinition("disc14", 9, 278)); // Hoist the Colours - The Bass Singers
        ALL.add(new DiscDefinition("disc15", 10, 206)); // Linkin Park - Castle of Glass
        ALL.add(new DiscDefinition("disc16", 1, 385)); // Metallica - Nothing Else Matters
        ALL.add(new DiscDefinition("disc17", 2, 278)); // Nirvana - Smells Like Teen Spirit
        ALL.add(new DiscDefinition("disc18", 3, 515)); // Metallica - Master of Puppets
        ALL.add(new DiscDefinition("disc19", 4, 158)); // Kids
        ALL.add(new DiscDefinition("disc20", 5, 244)); // Bloodhound Gang - The Bad Touch
        ALL.add(new DiscDefinition("disc21", 6, 254)); // Gorillaz - Feel Good Inc.
        ALL.add(new DiscDefinition("disc22", 7, 217)); // Disturbed - Down With The Sickness
        ALL.add(new DiscDefinition("disc23", 8, 249)); // Vitas - The 7th Element
        ALL.add(new DiscDefinition("disc24", 9, 321)); // Daft Punk - One More Time
        ALL.add(new DiscDefinition("disc25", 10, 219)); // Drowning Pool - Bodies
        ALL.add(new DiscDefinition("disc26", 11, 219)); // Bad Apple
        ALL.add(new DiscDefinition("disc27", 12, 491)); // Hiroki Kikuta (Koudelka) - Waterfall
        ALL.add(new DiscDefinition("disc28", 13, 235)); // Skyrim Theme Song
        ALL.add(new DiscDefinition("disc29", 14, 134)); // W&W - OIIA OIIA
        ALL.add(new DiscDefinition("disc30", 15, 206)); // Oliver Tree - Life Goes On
        ALL.add(new DiscDefinition("disc31", 1, 92)); // Prelude
        ALL.add(new DiscDefinition("disc32", 2, 169)); // Oliver Tree & Robin Schulz - Miss You
        ALL.add(new DiscDefinition("disc33", 3, 137)); // Terraria Soundtrack: Overworld Day
        ALL.add(new DiscDefinition("disc34", 4, 194)); // Noisestorm - Crab Rave
        ALL.add(new DiscDefinition("disc35", 5, 262)); // ConcernedApe - Spring (The Valley Comes Alive)
        ALL.add(new DiscDefinition("disc36", 6, 355)); // M83 - Wait
        ALL.add(new DiscDefinition("disc37", 7, 224)); // Band of Horses - The Funeral
        ALL.add(new DiscDefinition("disc38", 8, 315)); // Ludovico Einaudi - Experience
        ALL.add(new DiscDefinition("disc39", 9, 304)); // Pixies - Where Is My Mind (WhyAsk! Remix)
        ALL.add(new DiscDefinition("disc40", 10, 205)); // LUM!X, Gabry Ponte - Monster (Gabry Ponte 2023 Remix)
    }
}
