package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Puts the native libraries of an app that comes from several APKs (base + splits) where the
 * app can load them.
 *
 * <ol>
 *   <li>Every APK is scanned ({@link ApkNativeLibs}).</li>
 *   <li>One ABI is chosen for the whole app: the first ABI of the device list that has libraries
 *       in <b>any</b> of the APKs (same rule as the Android installer, so libraries of two ABIs are
 *       never mixed). If the APKs have native code but none for this phone, a
 *       {@link BundleException} with a readable message is thrown.</li>
 *   <li>The libraries of that ABI are extracted into {@code libDir} (old files of a previous
 *       version are removed first). Exception: when the app has
 *       {@code extractNativeLibs="false"} and all libraries of an APK are stored and aligned, that
 *       APK is left alone and the app loads from {@code apk!/lib/<abi>} (saves a second copy of
 *       big game libraries).</li>
 * </ol>
 */
public final class NativeLibInstaller {

    /** What was done. */
    public static final class Result {
        /** Chosen ABI, for example {@code arm64-v8a}. Null when the app has no native code. */
        public final String abi;
        /** Number of files written to the library folder. */
        public final int extracted;
        /** APKs whose libraries are loaded directly from the APK ({@code apk!/lib/<abi>}). */
        public final List<String> mappedApks;

        Result(String abi, int extracted, List<String> mappedApks) {
            this.abi = abi;
            this.extracted = extracted;
            this.mappedApks = mappedApks;
        }

        public boolean hasNativeCode() {
            return abi != null;
        }

        @Override
        public String toString() {
            return "NativeLibs{abi=" + abi + ", extracted=" + extracted + ", mapped=" + mappedApks.size() + "}";
        }
    }

    private NativeLibInstaller() {
    }

    /**
     * @param apks             base APK and all splits (final paths)
     * @param deviceAbis       ABIs the box can run, best first (see {@link DeviceProfile#abis})
     * @param libDir           folder for extracted libraries, created when missing
     * @param extractNativeLibs the app's {@code android:extractNativeLibs} (true when unknown)
     */
    public static Result install(List<File> apks, List<String> deviceAbis, File libDir, boolean extractNativeLibs)
            throws IOException, BundleException {
        List<List<ApkNativeLibs.Lib>> scans = new ArrayList<>();
        Set<String> abisInApps = new TreeSet<>();
        for (File apk : apks) {
            List<ApkNativeLibs.Lib> libs = ApkNativeLibs.scan(apk);
            scans.add(libs);
            for (ApkNativeLibs.Lib lib : libs) {
                abisInApps.add(SplitPicker.canonicalAbi(lib.abi));
            }
        }
        if (abisInApps.isEmpty()) {
            clearLibDir(libDir);
            return new Result(null, 0, new ArrayList<String>());
        }

        String abi = chooseAbi(abisInApps, deviceAbis);
        if (abi == null) {
            throw new BundleException(AbiCheck.wrongArchitectureMessage(abisInApps, deviceAbis));
        }

        clearLibDir(libDir);
        if (!libDir.isDirectory() && !libDir.mkdirs()) {
            throw new IOException("cannot create folder " + libDir);
        }

        int extracted = 0;
        List<String> mapped = new ArrayList<>();
        for (int i = 0; i < apks.size(); i++) {
            List<ApkNativeLibs.Lib> mine = new ArrayList<>();
            for (ApkNativeLibs.Lib lib : scans.get(i)) {
                if (SplitPicker.canonicalAbi(lib.abi).equals(abi)) {
                    mine.add(lib);
                }
            }
            if (mine.isEmpty()) {
                continue;
            }
            if (!extractNativeLibs && allMappable(mine)) {
                mapped.add(apks.get(i).getAbsolutePath());
                continue;
            }
            extracted += extract(apks.get(i), mine, libDir);
        }
        return new Result(abi, extracted, mapped);
    }

    /**
     * First device ABI that is present in the APKs. A device that runs armeabi-v7a also runs the
     * old {@code armeabi} libraries, so that is tried last when the device list has v7a.
     */
    static String chooseAbi(Set<String> abisInApps, List<String> deviceAbis) {
        List<String> candidates = canonical(deviceAbis);
        if (candidates.contains("armeabi-v7a") && !candidates.contains("armeabi")) {
            candidates.add("armeabi");
        }
        for (String c : candidates) {
            if (abisInApps.contains(c)) {
                return c;
            }
        }
        return null;
    }

    private static boolean allMappable(List<ApkNativeLibs.Lib> libs) {
        for (ApkNativeLibs.Lib lib : libs) {
            if (!lib.mappable) {
                return false;
            }
        }
        return true;
    }

    private static int extract(File apk, List<ApkNativeLibs.Lib> libs, File libDir) throws IOException {
        int count = 0;
        ZipFile zip = new ZipFile(apk);
        try {
            byte[] buffer = new byte[64 * 1024];
            for (ApkNativeLibs.Lib lib : libs) {
                ZipEntry entry = zip.getEntry(lib.entryName);
                if (entry == null) {
                    throw new IOException("library vanished from " + apk.getName() + ": " + lib.entryName);
                }
                File target = new File(libDir, lib.fileName);
                // paranoia on top of ApkNativeLibs.parseLibEntry: stay inside libDir
                if (!target.getCanonicalPath().startsWith(libDir.getCanonicalPath() + File.separator)) {
                    throw new IOException("bad library name: " + lib.entryName);
                }
                File tmp = new File(libDir, lib.fileName + ".tmp");
                InputStream in = zip.getInputStream(entry);
                try {
                    OutputStream out = new FileOutputStream(tmp);
                    try {
                        int n;
                        while ((n = in.read(buffer)) > 0) {
                            out.write(buffer, 0, n);
                        }
                    } finally {
                        out.close();
                    }
                } finally {
                    in.close();
                }
                if (target.exists() && !target.delete()) {
                    //noinspection ResultOfMethodCallIgnored
                    tmp.delete();
                    throw new IOException("cannot replace " + target);
                }
                if (!tmp.renameTo(target)) {
                    //noinspection ResultOfMethodCallIgnored
                    tmp.delete();
                    throw new IOException("cannot write " + target);
                }
                //noinspection ResultOfMethodCallIgnored
                target.setReadable(true, false);
                //noinspection ResultOfMethodCallIgnored
                target.setWritable(false, false);
                count++;
            }
        } finally {
            zip.close();
        }
        return count;
    }

    /** Removes files left by an older version of the app (a library that no longer exists must not stay). */
    private static void clearLibDir(File libDir) {
        File[] old = libDir.listFiles();
        if (old == null) {
            return;
        }
        for (File f : old) {
            if (f.isFile()) {
                //noinspection ResultOfMethodCallIgnored
                f.delete();
            }
        }
    }

    static List<String> canonical(List<String> abis) {
        List<String> out = new ArrayList<>();
        if (abis != null) {
            for (String a : abis) {
                String c = SplitPicker.canonicalAbi(a);
                if (!out.contains(c)) {
                    out.add(c);
                }
            }
        }
        return out;
    }


}
