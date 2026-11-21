package top.niunaijun.blackbox.utils.bundle;

import android.os.Build;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import top.niunaijun.blackbox.core.env.BEnvironment;

/**
 * Unpacks split bundles (.apks, .xapk, .apkm) into a temp folder.
 *
 * <p>Only what the installer needs is extracted: APK files and OBB files. The description file
 * (manifest.json for XAPK, info.json for APKM) is read in memory.
 *
 * <p>This class does not choose which splits to install, see the split picker for that. It only
 * answers: which file is the base APK, which are the splits, and which OBB files come with it.
 */
public final class BundleUnpacker {

    private static final String EXT_APKS = ".apks";
    private static final String EXT_XAPK = ".xapk";
    private static final String EXT_APKM = ".apkm";

    private static final int BUFFER_SIZE = 64 * 1024;

    /** Reports how many bytes were unpacked so far (for a progress bar). */
    public interface Progress {
        /** @param done bytes written so far; @param total bytes that will be written in all (0 if unknown) */
        void onProgress(long done, long total);
    }

    /** Counts the bytes written by {@link #extract} and tells the {@link Progress}, at most every 256 KB. */
    private static final class Counter {
        final Progress progress;
        long done;
        long total;
        long lastReported = -1;

        Counter(Progress progress) {
            this.progress = progress;
        }

        void add(int n) {
            done += n;
            if (progress != null && done - lastReported >= 256 * 1024) {
                lastReported = done;
                progress.onProgress(done, total);
            }
        }

        void finish() {
            if (progress != null) {
                progress.onProgress(done, total);
            }
        }
    }

    private BundleUnpacker() {
    }

    /** True when the file name has a bundle extension (.apks, .xapk, .apkm). */
    public static boolean isBundleFileName(String name) {
        if (name == null) {
            return false;
        }
        String lower = name.toLowerCase(Locale.ROOT);
        return lower.endsWith(EXT_APKS) || lower.endsWith(EXT_XAPK) || lower.endsWith(EXT_APKM);
    }

    public static boolean isBundleFile(File file) {
        return file != null && isBundleFileName(file.getName());
    }

    /** Unpacks into a new folder under the BlackBox cache folder, using the device ABI list. */
    public static BundleInfo unpack(File bundleFile) throws BundleException {
        return unpack(bundleFile, (Progress) null);
    }

    /** Same as {@link #unpack(File)}, and reports the progress of the extraction. */
    public static BundleInfo unpack(File bundleFile, Progress progress) throws BundleException {
        File outDir = new File(BEnvironment.getCacheDir(),
                "bundle_" + System.currentTimeMillis() + "_" + (System.nanoTime() & 0xFFFF));
        return unpack(bundleFile, outDir, Build.SUPPORTED_ABIS, progress);
    }

    /**
     * Unpacks {@code bundleFile} into {@code outDir}.
     *
     * @param deviceAbis only used for old bundles that contain several standalone APKs and no
     *                   splits, to pick the one that matches the device
     * @throws BundleException with a message that can be shown to the user. On any failure the
     *                         output folder is deleted before the exception is thrown.
     */
    public static BundleInfo unpack(File bundleFile, File outDir, String[] deviceAbis) throws BundleException {
        return unpack(bundleFile, outDir, deviceAbis, null);
    }

    /** Same as {@link #unpack(File, File, String[])}, and reports the progress of the extraction. */
    public static BundleInfo unpack(File bundleFile, File outDir, String[] deviceAbis, Progress progress)
            throws BundleException {
        if (bundleFile == null || !bundleFile.isFile()) {
            throw new BundleException("Bundle file not found: " + bundleFile);
        }
        boolean success = false;
        ZipFile zip = null;
        try {
            try {
                zip = new ZipFile(bundleFile);
            } catch (ZipException e) {
                throw new BundleException("This file is not a valid bundle (it is not a readable zip file): "
                        + bundleFile.getName(), e);
            }
            if (!outDir.isDirectory() && !outDir.mkdirs()) {
                throw new BundleException("Cannot create temp folder: " + outDir);
            }

            // ---- pass 1: look at the entries, read the description files in memory
            List<ZipEntry> apkEntries = new ArrayList<>();
            List<ZipEntry> obbEntries = new ArrayList<>();
            ZipEntry manifestJson = null;
            ZipEntry infoJson = null;
            boolean hasToc = false;
            boolean hasAndroidManifest = false;

            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry e = entries.nextElement();
                if (e.isDirectory()) {
                    continue;
                }
                String name = normalize(e.getName());
                String lower = name.toLowerCase(Locale.ROOT);
                if (lower.startsWith("__macosx/")) {
                    continue;
                }
                if (lower.equals("manifest.json")) {
                    manifestJson = e;
                } else if (lower.equals("info.json")) {
                    infoJson = e;
                } else if (lower.equals("toc.pb")) {
                    hasToc = true;
                } else if (lower.equals("androidmanifest.xml")) {
                    hasAndroidManifest = true;
                } else if (lower.endsWith(".apk")) {
                    apkEntries.add(e);
                } else if (lower.endsWith(".obb")) {
                    obbEntries.add(e);
                }
            }

            if (apkEntries.isEmpty()) {
                if (hasAndroidManifest) {
                    throw new BundleException("This is a normal APK, not a split bundle: " + bundleFile.getName());
                }
                throw new BundleException("No APK files were found inside the bundle: " + bundleFile.getName());
            }

            BundleInfo info = new BundleInfo();
            info.tempDir = outDir;

            Map<String, String> idByFileName = new HashMap<>();
            boolean isXapk = false;
            boolean isApkm = false;
            if (manifestJson != null) {
                isXapk = readManifestJson(readEntry(zip, manifestJson), info, idByFileName);
            }
            if (infoJson != null) {
                isApkm = readInfoJson(readEntry(zip, infoJson), info);
            }

            // ---- decide which APK entries to extract
            List<ZipEntry> chosen = new ArrayList<>();
            boolean standaloneOnly = false;

            List<ZipEntry> splitsDir = new ArrayList<>();
            List<ZipEntry> standalones = new ArrayList<>();
            ZipEntry universal = null;
            for (ZipEntry e : apkEntries) {
                String lower = normalize(e.getName()).toLowerCase(Locale.ROOT);
                if (lower.startsWith("splits/")) {
                    splitsDir.add(e);
                } else if (lower.startsWith("standalones/")) {
                    standalones.add(e);
                } else if (lower.equals("universal.apk")) {
                    universal = e;
                }
            }

            if (!splitsDir.isEmpty()) {
                info.format = BundleInfo.Format.APKS;
                chosen.addAll(splitsDir);
            } else if (universal != null) {
                info.format = BundleInfo.Format.APKS;
                chosen.add(universal);
                standaloneOnly = true;
            } else if (!standalones.isEmpty()) {
                info.format = BundleInfo.Format.APKS;
                chosen.add(pickStandalone(standalones, deviceAbis));
                standaloneOnly = true;
            } else {
                chosen.addAll(apkEntries);
                if (isXapk) {
                    info.format = BundleInfo.Format.XAPK;
                } else if (isApkm) {
                    info.format = BundleInfo.Format.APKM;
                } else if (hasToc) {
                    info.format = BundleInfo.Format.APKS;
                } else {
                    info.format = fromExtension(bundleFile.getName());
                }
            }

            // ---- pass 2: extract
            Counter counter = new Counter(progress);
            for (ZipEntry e : chosen) {
                counter.total += Math.max(0, e.getSize());
            }
            for (ZipEntry e : obbEntries) {
                counter.total += Math.max(0, e.getSize());
            }
            counter.finish();
            List<File> apkFiles = new ArrayList<>();
            for (ZipEntry e : chosen) {
                apkFiles.add(extract(zip, e, outDir, counter));
            }

            File base;
            if (standaloneOnly || apkFiles.size() == 1) {
                base = apkFiles.get(0);
            } else {
                base = pickBase(apkFiles, info.packageName, idByFileName);
            }
            info.baseApk = base;
            List<File> splits = new ArrayList<>();
            for (File f : apkFiles) {
                if (!f.equals(base)) {
                    splits.add(f);
                }
            }
            Collections.sort(splits, new Comparator<File>() {
                @Override
                public int compare(File a, File b) {
                    return a.getName().compareTo(b.getName());
                }
            });
            info.splitApks.addAll(splits);

            for (ZipEntry e : obbEntries) {
                String entryName = normalize(e.getName());
                File file = extract(zip, e, outDir, counter);
                info.obbFiles.add(new BundleInfo.ObbFile(file, obbPackage(entryName, info.packageName), file.getName()));
            }

            counter.finish();
            success = true;
            return info;
        } catch (BundleException e) {
            throw e;
        } catch (IOException e) {
            throw new BundleException("Could not unpack the bundle (" + e.getMessage() + ")", e);
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException ignored) {
                }
            }
            if (!success) {
                deleteRecursively(outDir);
            }
        }
    }

    // ------------------------------------------------------------------ description files

    /**
     * XAPK manifest.json. Returns true if it looks like an XAPK manifest.
     * Fields used: package_name, version_code, version_name, split_apks[{file,id}].
     */
    private static boolean readManifestJson(String json, BundleInfo info, Map<String, String> idByFileName) {
        try {
            JSONObject o = new JSONObject(json);
            boolean looksLikeXapk = o.has("package_name") || o.has("split_apks") || o.has("expansions");
            if (!looksLikeXapk) {
                return false;
            }
            info.packageName = o.optString("package_name", null);
            info.versionName = o.optString("version_name", null);
            info.versionCode = parseLong(o.optString("version_code", null), -1);
            JSONArray arr = o.optJSONArray("split_apks");
            if (arr != null) {
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject s = arr.optJSONObject(i);
                    if (s == null) {
                        continue;
                    }
                    String file = s.optString("file", null);
                    String id = s.optString("id", null);
                    if (file != null && id != null) {
                        idByFileName.put(baseName(file).toLowerCase(Locale.ROOT), id);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            // A broken manifest.json is not fatal, the file names are enough to find the base.
            return false;
        }
    }

    /**
     * APKM info.json. Returns true if it looks like an APKMirror info file.
     * Fields used: pname, versioncode, release_version, arches.
     */
    private static boolean readInfoJson(String json, BundleInfo info) {
        try {
            JSONObject o = new JSONObject(json);
            boolean looksLikeApkm = o.has("pname") || o.has("apk_title") || o.has("versioncode");
            if (!looksLikeApkm) {
                return false;
            }
            if (info.packageName == null) {
                info.packageName = o.optString("pname", null);
            }
            if (info.versionName == null) {
                info.versionName = o.optString("release_version", null);
            }
            if (info.versionCode < 0) {
                info.versionCode = parseLong(o.optString("versioncode", null), -1);
            }
            JSONArray arches = o.optJSONArray("arches");
            if (arches != null) {
                for (int i = 0; i < arches.length(); i++) {
                    String a = arches.optString(i, null);
                    if (a != null && !a.isEmpty()) {
                        info.declaredAbis.add(a);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ------------------------------------------------------------------ picking

    /**
     * Finds the base APK among the extracted files.
     * Order: id "base" from manifest.json, base.apk / base-master.apk, "&lt;package&gt;.apk",
     * the only file that does not look like a split, then the biggest file.
     */
    static File pickBase(List<File> files, String packageName, Map<String, String> idByFileName) {
        for (File f : files) {
            String id = idByFileName.get(f.getName().toLowerCase(Locale.ROOT));
            if ("base".equalsIgnoreCase(id)) {
                return f;
            }
        }
        for (File f : files) {
            String n = f.getName().toLowerCase(Locale.ROOT);
            if (n.equals("base.apk") || n.equals("base-master.apk")) {
                return f;
            }
        }
        if (packageName != null) {
            String wanted = packageName.toLowerCase(Locale.ROOT) + ".apk";
            for (File f : files) {
                if (f.getName().toLowerCase(Locale.ROOT).equals(wanted)) {
                    return f;
                }
            }
        }
        List<File> notSplitLike = new ArrayList<>();
        for (File f : files) {
            if (!looksLikeSplit(f.getName())) {
                notSplitLike.add(f);
            }
        }
        if (notSplitLike.size() == 1) {
            return notSplitLike.get(0);
        }
        return biggest(notSplitLike.isEmpty() ? files : notSplitLike);
    }

    private static boolean looksLikeSplit(String fileName) {
        String n = fileName.toLowerCase(Locale.ROOT);
        return n.startsWith("split_") || n.startsWith("split-") || n.startsWith("config.")
                || n.startsWith("base-") || n.contains("config.");
    }

    private static File biggest(List<File> files) {
        File best = files.get(0);
        for (File f : files) {
            if (f.length() > best.length()) {
                best = f;
            }
        }
        return best;
    }

    /** From several standalone APKs, take the one whose name has the first matching device ABI. */
    private static ZipEntry pickStandalone(List<ZipEntry> standalones, String[] deviceAbis) {
        List<ZipEntry> sorted = new ArrayList<>(standalones);
        Collections.sort(sorted, new Comparator<ZipEntry>() {
            @Override
            public int compare(ZipEntry a, ZipEntry b) {
                return a.getName().compareTo(b.getName());
            }
        });
        if (deviceAbis != null) {
            for (String abi : deviceAbis) {
                String token = abi.toLowerCase(Locale.ROOT).replace('-', '_');
                for (ZipEntry e : sorted) {
                    String n = baseName(e.getName()).toLowerCase(Locale.ROOT).replace('-', '_');
                    if (n.contains(token)) {
                        return e;
                    }
                }
            }
        }
        return sorted.get(0);
    }

    private static BundleInfo.Format fromExtension(String fileName) {
        String lower = fileName.toLowerCase(Locale.ROOT);
        if (lower.endsWith(EXT_XAPK)) {
            return BundleInfo.Format.XAPK;
        }
        if (lower.endsWith(EXT_APKM)) {
            return BundleInfo.Format.APKM;
        }
        if (lower.endsWith(EXT_APKS)) {
            return BundleInfo.Format.APKS;
        }
        return BundleInfo.Format.UNKNOWN;
    }

    /** Package name from ".../Android/obb/&lt;package&gt;/file.obb", else the bundle's package. */
    private static String obbPackage(String entryName, String fallback) {
        String lower = entryName.toLowerCase(Locale.ROOT);
        String marker = "android/obb/";
        int idx = lower.indexOf(marker);
        if (idx >= 0) {
            String rest = entryName.substring(idx + marker.length());
            int slash = rest.indexOf('/');
            if (slash > 0) {
                return rest.substring(0, slash);
            }
        }
        return fallback;
    }

    // ------------------------------------------------------------------ io helpers

    private static String normalize(String entryName) {
        return entryName.replace('\\', '/');
    }

    private static String baseName(String path) {
        String p = normalize(path);
        int i = p.lastIndexOf('/');
        return i >= 0 ? p.substring(i + 1) : p;
    }

    private static long parseLong(String s, long def) {
        if (s == null) {
            return def;
        }
        try {
            return Long.parseLong(s.trim());
        } catch (NumberFormatException e) {
            return def;
        }
    }

    private static String readEntry(ZipFile zip, ZipEntry e) throws IOException {
        InputStream in = zip.getInputStream(e);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
                if (out.size() > 4 * 1024 * 1024) {
                    throw new IOException("description file is too big: " + e.getName());
                }
            }
            return out.toString("UTF-8");
        } finally {
            in.close();
        }
    }

    /** Extracts one entry under outDir. Refuses names that would leave outDir (zip slip). */
    private static File extract(ZipFile zip, ZipEntry e, File outDir, Counter counter) throws IOException {
        String name = normalize(e.getName());
        File target = new File(outDir, name);
        String root = outDir.getCanonicalPath() + File.separator;
        if (!target.getCanonicalPath().startsWith(root)) {
            throw new IOException("unsafe file name in bundle: " + name);
        }
        File parent = target.getParentFile();
        if (parent != null && !parent.isDirectory() && !parent.mkdirs()) {
            throw new IOException("cannot create folder " + parent);
        }
        InputStream in = zip.getInputStream(e);
        try {
            OutputStream out = new FileOutputStream(target);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) > 0) {
                    out.write(buf, 0, n);
                    counter.add(n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
        return target;
    }

    static void deleteRecursively(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        File[] children = file.listFiles();
        if (children != null) {
            for (File c : children) {
                deleteRecursively(c);
            }
        }
        file.delete();
    }
}
