# MyMusic Privat Mod

**Forge 1.20.1 - 47.4.2** · **Mod ID:** `mymusic` · **Version:** `0.5` · **Author:** Victoriamangles

---

# 🇩🇪 Deutsch

## MyMusic Privat Mod

Der **MyMusic Privat Mod** registriert **40 individuelle Musikdiscs** (`disc1` bis `disc40`) für Minecraft Forge 1.20.1.

Zusätzlich wurden **8 Discs** in die normale Minecraft-Ambient-Musikrotation integriert (`music.game` und verschiedene Biom-Musik-Pools):

`disc5`, `disc19`, `disc27`, `disc31`, `disc33`, `disc35`, `disc36`, `disc38`

### Was du noch tun musst

1. Alle **40 `.ogg`-Dateien** als Mono-Audio (`-ac 1`) unter folgendem Pfad ablegen:
   `sounds/records/discX.ogg`
2. Den **Java-17-Pfad** in `gradle.properties` eintragen:
   `org.gradle.java.home=...`
3. Das Projekt bauen:

```bat
gradlew.bat build
```

Die fertige JAR-Datei wird als:

```text
MyMusic_Privat_0.5_F47.4.2_Jav1.20.1.jar
```

ausgegeben.

---

## Externer Musik-Ordner

### Auto-Loading ohne manuelle Resource-Pack-Aktivierung

Ab dieser Version liest die Mod zusätzlich automatisch Musikdateien aus:

```text
.minecraft/config/MyMusic/Musics/
```

Dieser Ordner wird beim **ersten Start automatisch erstellt**.

Die Dateien werden **direkt in diesem Ordner** abgelegt. Es werden keine Unterordner benötigt.

Beispiel:

```text
.minecraft/
└── config/
    └── MyMusic/
        └── Musics/
            ├── disc1.ogg
            ├── disc2.ogg
            ├── disc3.ogg
            └── ...
            └── disc40.ogg
```

Spieler müssen dort lediglich ihre eigenen `discX.ogg`-Dateien ablegen. Eine manuelle Aktivierung eines Resource Packs ist dadurch nicht erforderlich.

> **Hinweis:** Dieser Teil ist experimentell und wurde zum Zeitpunkt dieser Dokumentation noch nicht kompiliert bzw. getestet. Falls beim Build Fehler auftreten, sollte der vollständige Fehlertext überprüft werden, da diese Funktion von der verwendeten Forge-Version abhängige APIs verwendet.

---

## Version 1.1 – Loot-Kisten & Mob-Drops

> **Nur in der Official-Variante verfügbar.**

Die Discs können jetzt auch im normalen Spielverlauf gefunden werden:

* In bestimmten Loot-Kisten, z. B. Dungeons, Mineshafts und Strongholds
* Als seltener Drop von feindlichen Mobs
* Standardmäßig mit einer Drop-Chance von **0,2 % pro Kill**

Beide Funktionen können über folgende Datei konfiguriert werden:

```text
config/mymusic-common.toml
```

Relevante Einstellungen:

```text
loot_chests.enabled
loot_chests.chance
loot_chests.tables

mob_drops.enabled
mob_drops.chance
```

---

## 🎵 Musikdiscs

|  # | Titel                                                 | Länge |
| -: | ----------------------------------------------------- | ----: |
|  1 | Ramin Djawadi - Light of the Seven                    |  9:50 |
|  2 | Rick and Morty: Evil Morty Theme                      |  3:45 |
|  3 | Claude Debussy - Clair de Lune                        |  5:17 |
|  4 | Lost in Space (DjNeratops)                            |  4:26 |
|  5 | Hans Zimmer - Interstellar                            |  4:03 |
|  6 | Eminem & D12 - My Band ft. Cameo                      |  5:35 |
|  7 | TBS - Mein Stern                                      |  4:09 |
|  8 | Avenged Sevenfold - Buried Alive                      |  6:46 |
|  9 | Dame - Pave Low                                       |  4:06 |
| 10 | BENNETT - Lullaby                                     |  3:24 |
| 11 | K.I.Z - Neuruppin                                     |  5:23 |
| 12 | Alligatoah - Stay In Touch                            |  3:39 |
| 13 | Twenty One Pilots - Heathens / Stranger Things        |  3:36 |
| 14 | Hoist the Colours - The Bass Singers                  |  4:38 |
| 15 | Linkin Park - Castle of Glass                         |  3:26 |
| 16 | Metallica - Nothing Else Matters                      |  6:25 |
| 17 | Nirvana - Smells Like Teen Spirit                     |  4:38 |
| 18 | Metallica - Master of Puppets                         |  8:35 |
| 19 | Kids                                                  |  2:38 |
| 20 | Bloodhound Gang - The Bad Touch                       |  4:04 |
| 21 | Gorillaz - Feel Good Inc.                             |  4:14 |
| 22 | Disturbed - Down With The Sickness                    |  3:37 |
| 23 | Vitas - The 7th Element                               |  4:09 |
| 24 | Daft Punk - One More Time                             |  5:21 |
| 25 | Drowning Pool - Bodies                                |  3:39 |
| 26 | Bad Apple                                             |  3:39 |
| 27 | Hiroki Kikuta (Koudelka) - Waterfall                  |  8:11 |
| 28 | Skyrim Theme Song                                     |  3:55 |
| 29 | W&W - OIIA OIIA                                       |  2:14 |
| 30 | Oliver Tree - Life Goes On                            |  3:26 |
| 31 | Prelude                                               |  1:32 |
| 32 | Oliver Tree & Robin Schulz - Miss You                 |  2:49 |
| 33 | Terraria Soundtrack: Overworld Day                    |  2:17 |
| 34 | Noisestorm - Crab Rave                                |  3:14 |
| 35 | ConcernedApe - Spring (The Valley Comes Alive)        |  4:22 |
| 36 | M83 - Wait                                            |  5:55 |
| 37 | Band of Horses - The Funeral                          |  3:44 |
| 38 | Ludovico Einaudi - Experience                         |  5:15 |
| 39 | Pixies - Where Is My Mind (WhyAsk! Remix)             |  5:04 |
| 40 | LUM!X, Gabry Ponte - Monster (Gabry Ponte 2023 Remix) |  3:25 |

---

# 🇬🇧 English

## MyMusic Privat Mod

The **MyMusic Privat Mod** registers **40 custom music discs** (`disc1` through `disc40`) for Minecraft Forge 1.20.1.

Additionally, **8 discs** have been added to the normal Minecraft ambient music rotation (`music.game` and various biome music pools):

`disc5`, `disc19`, `disc27`, `disc31`, `disc33`, `disc35`, `disc36`, `disc38`

### What you still need to do

1. Place all **40 `.ogg` files** as mono audio (`-ac 1`) under:
   `sounds/records/discX.ogg`
2. Add the **Java 17 path** to `gradle.properties`:
   `org.gradle.java.home=...`
3. Build the project:

```bat
gradlew.bat build
```

The resulting JAR file will be:

```text
MyMusic_Privat_0.5_F47.4.2_Jav1.20.1.jar
```

---

## External Music Folder

### Automatic loading without manually enabling a Resource Pack

Starting with this version, the mod also automatically loads music files from:

```text
.minecraft/config/MyMusic/Musics/
```

This folder is **automatically created on the first launch**.

Music files are placed **directly inside this folder**. No subfolders are required.

Example:

```text
.minecraft/
└── config/
    └── MyMusic/
        └── Musics/
            ├── disc1.ogg
            ├── disc2.ogg
            ├── disc3.ogg
            └── ...
            └── disc40.ogg
```

Players only need to place their own `discX.ogg` files directly into this folder. No manual Resource Pack activation is required.

> **Note:** This feature is experimental and had not been compiled or tested at the time this documentation was written. If build errors occur, the complete error message should be checked, as this functionality relies on Forge-version-sensitive APIs.

---

## Version 1.1 – Loot Chests & Mob Drops

> **Available only in the Official variant.**

The discs can now also be obtained through normal gameplay:

* From specific loot chests, such as Dungeons, Mineshafts, and Strongholds
* As a rare drop from hostile mobs
* Default drop chance: **0.2% per kill**

Both features can be configured in:

```text
config/mymusic-common.toml
```

Relevant settings:

```text
loot_chests.enabled
loot_chests.chance
loot_chests.tables

mob_drops.enabled
mob_drops.chance
```

---

## 🎵 Music Discs

|  # | Title                                                 | Duration |
| -: | ----------------------------------------------------- | -------: |
|  1 | Ramin Djawadi - Light of the Seven                    |     9:50 |
|  2 | Rick and Morty: Evil Morty Theme                      |     3:45 |
|  3 | Claude Debussy - Clair de Lune                        |     5:17 |
|  4 | Lost in Space (DjNeratops)                            |     4:26 |
|  5 | Hans Zimmer - Interstellar                            |     4:03 |
|  6 | Eminem & D12 - My Band ft. Cameo                      |     5:35 |
|  7 | TBS - Mein Stern                                      |     4:09 |
|  8 | Avenged Sevenfold - Buried Alive                      |     6:46 |
|  9 | Dame - Pave Low                                       |     4:06 |
| 10 | BENNETT - Lullaby                                     |     3:24 |
| 11 | K.I.Z - Neuruppin                                     |     5:23 |
| 12 | Alligatoah - Stay In Touch                            |     3:39 |
| 13 | Twenty One Pilots - Heathens / Stranger Things        |     3:36 |
| 14 | Hoist the Colours - The Bass Singers                  |     4:38 |
| 15 | Linkin Park - Castle of Glass                         |     3:26 |
| 16 | Metallica - Nothing Else Matters                      |     6:25 |
| 17 | Nirvana - Smells Like Teen Spirit                     |     4:38 |
| 18 | Metallica - Master of Puppets                         |     8:35 |
| 19 | Kids                                                  |     2:38 |
| 20 | Bloodhound Gang - The Bad Touch                       |     4:04 |
| 21 | Gorillaz - Feel Good Inc.                             |     4:14 |
| 22 | Disturbed - Down With The Sickness                    |     3:37 |
| 23 | Vitas - The 7th Element                               |     4:09 |
| 24 | Daft Punk - One More Time                             |     5:21 |
| 25 | Drowning Pool - Bodies                                |     3:39 |
| 26 | Bad Apple                                             |     3:39 |
| 27 | Hiroki Kikuta (Koudelka) - Waterfall                  |     8:11 |
| 28 | Skyrim Theme Song                                     |     3:55 |
| 29 | W&W - OIIA OIIA                                       |     2:14 |
| 30 | Oliver Tree - Life Goes On                            |     3:26 |
| 31 | Prelude                                               |     1:32 |
| 32 | Oliver Tree & Robin Schulz - Miss You                 |     2:49 |
| 33 | Terraria Soundtrack: Overworld Day                    |     2:17 |
| 34 | Noisestorm - Crab Rave                                |     3:14 |
| 35 | ConcernedApe - Spring (The Valley Comes Alive)        |     4:22 |
| 36 | M83 - Wait                                            |     5:55 |
| 37 | Band of Horses - The Funeral                          |     3:44 |
| 38 | Ludovico Einaudi - Experience                         |     5:15 |
| 39 | Pixies - Where Is My Mind (WhyAsk! Remix)             |     5:04 |
| 40 | LUM!X, Gabry Ponte - Monster (Gabry Ponte 2023 Remix) |     3:25 |
