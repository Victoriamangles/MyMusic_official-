package com.victoriamangles.mymusic;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Liest config/MyMusic/DiscLengths.txt direkt und synchron ein - UMGEHT damit
 * das Forge-ModConfig-Timing-Problem komplett (COMMON-Configs werden erst NACH
 * der Item-Registrierung geladen, Type.STARTUP existiert in Forge 47.4.2 nicht).
 *
 * Format der Datei (sehr simpel, eine Zeile pro Disc):
 * disc1=590
 * disc2=225
 * ...
 *
 * Wird beim ersten Start automatisch mit den Standardwerten aus ModDiscs
 * befuellt, falls die Datei noch nicht existiert.
 */
public class ModDiscLengths {

    private static final Pattern LINE_PATTERN = Pattern.compile("^(disc\\d+)\\s*=\\s*(\\d+)\\s*$");

    public static final Map<String, Integer> OVERRIDES = new HashMap<>();

    private static Path getConfigFile() {
        return FMLPaths.CONFIGDIR.get().resolve("MyMusic/DiscLengths.txt");
    }

    /**
     * Legt die Datei mit den Standardwerten an, falls sie noch nicht existiert.
     */
    private static void ensureConfigExists(List<String> discIds, Map<String, Integer> defaults) {
        Path path = getConfigFile();
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                StringBuilder sb = new StringBuilder();
                sb.append("// MyMusic - Disc-Laengen in Sekunden\n");
                sb.append("// Der NAME jeder Disc bleibt fest (lang-Dateien) - hier nur die Laenge\n");
                sb.append("// an deine eigene eingebundene Audiodatei anpassen.\n");
                sb.append("// Format: discX=Sekunden\n");
                sb.append("//\n");
                for (String id : discIds) {
                    sb.append(id).append("=").append(defaults.getOrDefault(id, 180)).append("\n");
                }
                Files.writeString(path, sb.toString());
            }
        } catch (IOException e) {
            System.err.println("[MyMusic] Konnte DiscLengths.txt nicht anlegen: " + e.getMessage());
        }
    }

    /**
     * Liest die Datei ein. MUSS aufgerufen werden, BEVOR ModDiscs.ALL final
     * aufgebaut wird, damit die Werte direkt in die DiscDefinition einfliessen
     * (statt spaeter versuchen zu muessen, ein bereits registriertes Item zu
     * aendern - das geht nicht mehr).
     */
    public static void load(List<String> discIds, Map<String, Integer> defaults) {
        ensureConfigExists(discIds, defaults);
        OVERRIDES.clear();

        Path path = getConfigFile();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("//")) {
                    continue;
                }
                Matcher matcher = LINE_PATTERN.matcher(line);
                if (matcher.matches()) {
                    OVERRIDES.put(matcher.group(1), Integer.parseInt(matcher.group(2)));
                }
            }
        } catch (IOException e) {
            System.err.println("[MyMusic] Konnte DiscLengths.txt nicht lesen: " + e.getMessage());
        }
    }

    public static int getLength(String discId, int defaultValue) {
        return OVERRIDES.getOrDefault(discId, defaultValue);
    }
}
