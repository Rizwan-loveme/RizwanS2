package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Result of {@link BundleUnpacker#unpack}. Everything lives inside {@link #tempDir}, so call
 * {@link #cleanup()} when the install is finished (also when it failed).
 */
public class BundleInfo {

    public enum Format {
        /** bundletool output: splits/*.apk, toc.pb, optional standalones/ or universal.apk */
        APKS,
        /** APKPure style: manifest.json with split_apks and optional expansions (OBB) */
        XAPK,
        /** APKMirror style: info.json, base.apk and split_config.*.apk */
        APKM,
        /** A plain zip with .apk files and no known description file */
        UNKNOWN
    }

    /** An OBB file found in the bundle, already extracted to disk. */
    public static class ObbFile {
        /** The extracted file (inside the temp folder). */
        public final File file;
        /** Package folder the file belongs to (Android/obb/&lt;package&gt;/), may be null if unknown. */
        public final String packageName;
        /** File name to use at the destination, for example main.12.com.game.obb. */
        public final String name;

        public ObbFile(File file, String packageName, String name) {
            this.file = file;
            this.packageName = packageName;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ObbFile{" + packageName + "/" + name + "}";
        }
    }

    public Format format = Format.UNKNOWN;

    /** Temp folder that holds every extracted file. */
    public File tempDir;

    /** The base APK. Never null in a result returned by the unpacker. */
    public File baseApk;

    /** All other APK files (config / feature splits), sorted by name. Base is not in this list. */
    public final List<File> splitApks = new ArrayList<>();

    /** OBB files, empty when the bundle has none. */
    public final List<ObbFile> obbFiles = new ArrayList<>();

    /** From manifest.json / info.json, may be null. */
    public String packageName;
    public String versionName;
    public long versionCode = -1;

    /** ABI names the bundle says it supports (APKM info.json "arches"), may be empty. */
    public final List<String> declaredAbis = new ArrayList<>();

    public boolean hasSplits() {
        return !splitApks.isEmpty();
    }

    public boolean hasObb() {
        return !obbFiles.isEmpty();
    }

    /** Absolute paths of {@link #splitApks}. */
    public List<String> getSplitPaths() {
        List<String> paths = new ArrayList<>(splitApks.size());
        for (File f : splitApks) {
            paths.add(f.getAbsolutePath());
        }
        return paths;
    }

    /** Deletes the temp folder and everything in it. Safe to call more than once. */
    public void cleanup() {
        if (tempDir != null) {
            BundleUnpacker.deleteRecursively(tempDir);
        }
    }

    @Override
    public String toString() {
        return "BundleInfo{format=" + format + ", package=" + packageName
                + ", base=" + (baseApk == null ? null : baseApk.getName())
                + ", splits=" + splitApks.size() + ", obb=" + obbFiles.size() + "}";
    }
}
