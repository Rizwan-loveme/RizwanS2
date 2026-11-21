package top.niunaijun.blackbox.utils.bundle;

import android.system.Os;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * A temporary folder that holds the base APK and its splits side by side, all at the top level.
 *
 * <p>The system PackageParser reads an app with splits from one folder
 * (parseClusterPackage): the base APK and every split APK in the same directory, no sub folders.
 * A bundle does not look like that (the APKS format has a splits/ folder, other files can sit
 * next to the APKs), so the files are linked into a clean folder first. A hard link is tried
 * first (no copy, same file system), then a symbolic link, then a real copy.
 *
 * <p>The folder only exists while parsing. {@link #original(String)} maps a path inside the
 * folder back to the real file, so the parsed package can point at the real files.
 */
public final class SplitCluster {

    public static final String BASE_NAME = "base.apk";

    /** The folder, give it to PackageParser. */
    public final File dir;
    /** Path inside the folder -> real file. */
    private final Map<String, File> originals = new LinkedHashMap<>();

    private SplitCluster(File dir) {
        this.dir = dir;
    }

    /**
     * @param parent folder to create the cluster folder in, for example the BlackBox cache folder
     * @param base   the base APK
     * @param splits absolute paths of the split APKs
     * @throws IOException a file is missing or cannot be linked / copied. The folder is deleted.
     */
    public static SplitCluster create(File parent, File base, List<String> splits) throws IOException {
        File dir = new File(parent, "cluster_" + UUID.randomUUID().toString().replace("-", ""));
        if (!dir.mkdirs()) {
            throw new IOException("cannot create folder " + dir);
        }
        SplitCluster cluster = new SplitCluster(dir);
        boolean ok = false;
        try {
            cluster.add(base, BASE_NAME);
            Set<String> used = new HashSet<>();
            used.add(BASE_NAME);
            int i = 0;
            for (String path : splits) {
                File src = new File(path);
                String name = src.getName();
                if (!name.toLowerCase().endsWith(".apk") || used.contains(name.toLowerCase())) {
                    name = "split_" + i + ".apk";
                }
                while (used.contains(name.toLowerCase())) {
                    name = "split_" + (++i) + "_" + name;
                }
                used.add(name.toLowerCase());
                cluster.add(src, name);
                i++;
            }
            ok = true;
            return cluster;
        } finally {
            if (!ok) {
                cluster.delete();
            }
        }
    }

    private void add(File src, String name) throws IOException {
        if (!src.isFile()) {
            throw new IOException("file not found: " + src);
        }
        File target = new File(dir, name);
        link(src, target);
        originals.put(target.getAbsolutePath(), src);
    }

    /** The real file behind a path inside the cluster folder, or null. */
    public File original(String clusterPath) {
        return clusterPath == null ? null : originals.get(clusterPath);
    }

    /** Number of files in the folder, base included. */
    public int size() {
        return originals.size();
    }

    /** Deletes the folder. Links are removed, the real files are not touched. */
    public void delete() {
        File[] children = dir.listFiles();
        if (children != null) {
            for (File c : children) {
                //noinspection ResultOfMethodCallIgnored
                c.delete();
            }
        }
        //noinspection ResultOfMethodCallIgnored
        dir.delete();
    }

    private static void link(File src, File dst) throws IOException {
        try {
            Os.link(src.getAbsolutePath(), dst.getAbsolutePath());
            return;
        } catch (Throwable ignored) {
            // other file system, or no Os class (plain JVM)
        }
        try {
            Os.symlink(src.getAbsolutePath(), dst.getAbsolutePath());
            return;
        } catch (Throwable ignored) {
        }
        copy(src, dst);
    }

    private static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[64 * 1024];
                int n;
                while ((n = in.read(buf)) > 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
