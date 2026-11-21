package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Puts the split APKs of an app into its app folder.
 *
 * <p>File names follow the Android convention: {@code split_<splitName>.apk}, for example
 * {@code split_config.arm64_v8a.apk}. The files are made read-only (Android 14+ refuses to load
 * code from a writable file).
 *
 * <p>A file that lies inside {@code movableRoot} (the BlackBox temp folder, where the bundle was
 * unpacked) is moved instead of copied, which is instant and needs no extra space for big games.
 * Other files (for example the real split files of an app installed on the phone) are copied.
 *
 * <p>If one file fails, everything done so far is undone: copies are deleted, moved files go back
 * to where they were.
 */
public final class SplitFileCopier {

    private static final long CHUNK = 8L * 1024 * 1024;

    private SplitFileCopier() {
    }

    /**
     * @param sources     paths of the split APKs
     * @param splitNames  split name of every source, same order and length (from the parser)
     * @param destDir     the app folder, created when missing
     * @param movableRoot files inside this folder are moved, not copied. May be null.
     * @return the new absolute paths, same order as {@code sources}
     */
    public static String[] copyAll(String[] sources, String[] splitNames, File destDir, File movableRoot)
            throws IOException {
        if (sources == null || splitNames == null || sources.length != splitNames.length) {
            throw new IOException("split paths and split names do not match");
        }
        if (!destDir.isDirectory() && !destDir.mkdirs()) {
            throw new IOException("cannot create folder " + destDir);
        }
        List<File[]> done = new ArrayList<>();   // {source, target}
        List<Boolean> moved = new ArrayList<>();
        Set<String> used = new HashSet<>();
        String[] result = new String[sources.length];
        try {
            for (int i = 0; i < sources.length; i++) {
                File src = new File(sources[i]);
                if (!src.isFile()) {
                    throw new IOException("split file not found: " + src);
                }
                File target = new File(destDir, fileNameFor(splitNames[i], i, used));
                if (target.exists() && !target.delete()) {
                    throw new IOException("cannot replace " + target);
                }
                boolean move = movableRoot != null && isInside(src, movableRoot) && src.renameTo(target);
                if (!move) {
                    copy(src, target);
                }
                done.add(new File[]{src, target});
                moved.add(move);
                //noinspection ResultOfMethodCallIgnored
                target.setReadOnly();
                result[i] = target.getAbsolutePath();
            }
            return result;
        } catch (IOException | RuntimeException e) {
            for (int i = done.size() - 1; i >= 0; i--) {
                File[] pair = done.get(i);
                if (moved.get(i)) {
                    //noinspection ResultOfMethodCallIgnored
                    pair[1].renameTo(pair[0]);
                } else {
                    //noinspection ResultOfMethodCallIgnored
                    pair[1].delete();
                }
            }
            throw e;
        }
    }

    /** split_&lt;name&gt;.apk with characters that are not safe in a file name replaced; unique in {@code used}. */
    static String fileNameFor(String splitName, int index, Set<String> used) {
        String clean = splitName == null ? "" : splitName.replaceAll("[^A-Za-z0-9._-]", "_");
        if (clean.isEmpty()) {
            clean = String.valueOf(index);
        }
        String name = "split_" + clean + ".apk";
        while (!used.add(name.toLowerCase(Locale.ROOT))) {
            name = "split_" + clean + "_" + index + ".apk";
            index++;
        }
        return name;
    }

    private static boolean isInside(File file, File root) {
        try {
            String r = root.getCanonicalPath() + File.separator;
            return file.getCanonicalPath().startsWith(r);
        } catch (IOException e) {
            return false;
        }
    }

    private static void copy(File src, File dst) throws IOException {
        FileInputStream in = new FileInputStream(src);
        try {
            FileOutputStream out = new FileOutputStream(dst);
            try {
                FileChannel from = in.getChannel();
                FileChannel to = out.getChannel();
                long size = from.size();
                long pos = 0;
                while (pos < size) {
                    long n = from.transferTo(pos, Math.min(CHUNK, size - pos), to);
                    if (n <= 0) {
                        break;
                    }
                    pos += n;
                }
                if (pos != size) {
                    throw new IOException("could not copy " + src + " completely");
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
}
