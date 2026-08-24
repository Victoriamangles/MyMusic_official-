# MyMusic Privat Mod

Forge 1.20.1 - 47.4.2 | modid: `mymusic` | Version 0.5
Autor: Victoriamangles

40 Custom Music Discs registriert (disc1 bis disc40).
8 davon zusätzlich in der normalen Ambient-Musik-Rotation (music.game + diverse Biom-Pools):
disc5, disc19, disc27, disc31, disc33, disc35, disc36, disc38

## Was du noch tun musst
1. Alle 40 .ogg Dateien (Mono! -ac 1) unter sounds/records/discX.ogg ablegen
2. Java-17-Pfad in gradle.properties eintragen: org.gradle.java.home=...
3. gradlew.bat build

JAR-Ausgabe: MyMusic_Privat_0.5_F47.4.2_Jav1.20.1.jar

## Externer Musik-Ordner (Auto-Loading ohne Resource Pack Aktivierung)
Ab dieser Version liest die Mod zusätzlich automatisch aus:
```
.minecraft/config/MyMusic/Musics/
```
Dieser Ordner wird beim ersten Start automatisch angelegt (flach, KEINE Unterordner).
Spieler müssen dort NUR ihre eigenen discX.ogg Dateien direkt reinlegen
(z.B. config/MyMusic/Musics/disc1.ogg), kein Resource Pack manuell aktivieren nötig.

HINWEIS: Dieser Teil ist experimentell und wurde nicht kompiliert/getestet.
Falls beim Build Fehler auftauchen, bitte den kompletten Fehlertext schicken -
das ist eine Forge-Versions-sensible API, die wir dann gemeinsam anpassen.

## Version 1.1 - Loot-Kisten & Mob-Drops (nur Official-Variante)
Discs können jetzt im normalen Spielverlauf gefunden werden:
- In bestimmten Loot-Kisten (Dungeons, Mineshafts, Strongholds, etc.)
- Als seltener Drop von feindlichen Mobs (Standard: 0.2% Chance pro Kill)

Beides ist konfigurierbar unter: config/mymusic-common.toml
- loot_chests.enabled / loot_chests.chance / loot_chests.tables
- mob_drops.enabled / mob_drops.chance
