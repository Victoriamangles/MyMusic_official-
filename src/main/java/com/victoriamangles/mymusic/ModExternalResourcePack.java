package com.victoriamangles.mymusic;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

/**
 * Registriert automatisch einen externen, FLACHEN Ordner als zusätzliches Resource Pack,
 * OHNE dass der Spieler es in den Optionen aktivieren muss.
 *
 * Ordner: .minecraft/config/MyMusic/Musics/
 * Dort legt der Spieler direkt disc1.ogg, disc2.ogg, ... disc40.ogg rein - KEINE
 * Unterordner nötig. Diese Klasse übersetzt intern die Anfrage nach
 * "assets/mymusic/sounds/records/discX.ogg" automatisch auf die flache Datei "discX.ogg".
 *
 * EXPERIMENTELL: Diese Datei nutzt tiefere Forge-Resource-System-APIs, die sich
 * zwischen Versionen öfter ändern. Konnte hier nicht kompiliert werden.
 */
@Mod.EventBusSubscriber(modid = MyMusic.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModExternalResourcePack {

    private static final String FOLDER_NAME = "MyMusic/Musics";
    private static final String NAMESPACE = "mymusic";
    private static final String SOUND_PREFIX = "sounds/records/";

    public static Path getExternalMusicFolder() {
        return FMLPaths.CONFIGDIR.get().resolve(FOLDER_NAME);
    }

    /**
     * Legt NUR den Ordner config/MyMusic/Musics an (keine Unterordner) plus eine
     * automatisch generierte pack.mcmeta (Pflicht-Metadatei für jedes Resource Pack,
     * aber kein Unterordner - liegt direkt neben den .ogg Dateien).
     */
    public static void ensureFolderExists() {
        try {
            Path folder = getExternalMusicFolder();
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }
            Path packMeta = folder.resolve("pack.mcmeta");
            if (!Files.exists(packMeta)) {
                Files.writeString(packMeta,
                        "{\"pack\":{\"pack_format\":15,\"description\":\"MyMusic external tracks\"}}");
            }
        } catch (IOException e) {
            System.err.println("[MyMusic] Konnte externen Musik-Ordner nicht anlegen: " + e.getMessage());
        }
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) {
            return;
        }

        ensureFolderExists();
        Path folder = getExternalMusicFolder();
        if (!Files.isDirectory(folder)) {
            return;
        }

        event.addRepositorySource((consumer) -> {
            Pack.ResourcesSupplier resourcesSupplier =
                    (id) -> new FlatFolderPackResources(id, folder);

            Pack pack = Pack.readMetaAndCreate(
                    "mymusic_external",
                    Component.literal("MyMusic External Tracks"),
                    true,
                    resourcesSupplier,
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    PackSource.DEFAULT
            );
            if (pack != null) {
                consumer.accept(pack);
            }
        });
    }

    /**
     * Wrappt PathPackResources, leitet aber Anfragen nach
     * assets/mymusic/sounds/records/discX.ogg auf die flache Datei
     * discX.ogg im externen Ordner um.
     */
    private static class FlatFolderPackResources implements PackResources {

        private final PathPackResources delegate;
        private final Path root;

        FlatFolderPackResources(String id, Path root) {
            this.delegate = new PathPackResources(id, root, false);
            this.root = root;
        }

        @Override
        public IoSupplier<InputStream> getRootResource(String... elements) {
            return delegate.getRootResource(elements);
        }

        @Override
        public IoSupplier<InputStream> getResource(PackType type, ResourceLocation location) {
            if (type == PackType.CLIENT_RESOURCES
                    && NAMESPACE.equals(location.getNamespace())
                    && location.getPath().startsWith(SOUND_PREFIX)) {

                String fileName = location.getPath().substring(SOUND_PREFIX.length());
                Path filePath = root.resolve(fileName);
                if (Files.exists(filePath)) {
                    return () -> Files.newInputStream(filePath);
                }
                return null;
            }
            return delegate.getResource(type, location);
        }

        @Override
        public void listResources(PackType type, String namespace, String path, ResourceOutput resourceOutput) {
            if (type == PackType.CLIENT_RESOURCES && NAMESPACE.equals(namespace)) {
                try (var stream = Files.list(root)) {
                    stream.filter(p -> p.getFileName().toString().toLowerCase().endsWith(".ogg"))
                            .forEach(oggFile -> {
                                String fileName = oggFile.getFileName().toString();
                                ResourceLocation location =
                                        new ResourceLocation(NAMESPACE, SOUND_PREFIX + fileName);
                                if (location.getPath().startsWith(path)) {
                                    resourceOutput.accept(location, () -> Files.newInputStream(oggFile));
                                }
                            });
                } catch (IOException e) {
                    System.err.println("[MyMusic] Fehler beim Auflisten externer Musikdateien: " + e.getMessage());
                }
                return;
            }
            delegate.listResources(type, namespace, path, resourceOutput);
        }

        @Override
        public Set<String> getNamespaces(PackType type) {
            return type == PackType.CLIENT_RESOURCES ? Set.of(NAMESPACE) : Set.of();
        }

        @Override
        public <T> T getMetadataSection(MetadataSectionSerializer<T> serializer) throws IOException {
            return delegate.getMetadataSection(serializer);
        }

        @Override
        public String packId() {
            return delegate.packId();
        }

        @Override
        public void close() {
            delegate.close();
        }
    }
}
