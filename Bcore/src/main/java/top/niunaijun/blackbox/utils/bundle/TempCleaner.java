package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * Removes the temp files of the install code that a crash or a killed process left behind.
 *
 * <p>During a normal install the files are deleted by the installer itself (also when the install
 * failed). This class is the safety net for the cases where that code never got to run: the app was
 * swiped away or killed in the middle of an unpack, the phone rebooted, the process ran out of
 * memory.
 *
 * <p>Only names that the install code creates are touched, in the BlackBox cache folder:
 * <ul>
 *   <li>{@code install_*} - the copy of a chosen file, or the renamed copy of a plain APK</li>
 *   <li>{@code bundle_*} - the unpacked bundle folder</li>
 *   <li>{@code cluster_*} - the folder the parser reads the splits from</li>
 *   <li>{@code <uuid>.apk} - the copy of a content:// APK made by the package manager service</li>
 * </ul>
 * Files like junit.apk or empty.apk and the cached jars are never matched. Only entries that were not
 * changed for a while are deleted, so an install that is running right now (also in another
 * process) is safe. Symbolic links are removed, never followed. This class has no Android
 * dependency so it can be tested on a plain JVM.
 */
public final class TempCleaner {

    /** An entry must be this old (no change inside it) before it counts as a leftover. */
    public static final long STALE_AGE_MS = 30L * 60L * 1000L;

    private static final Pattern UUID_APK = Pattern.compile(
            "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}\\.apk");

    private static final AtomicInteger sActive = new AtomicInteger();

    private TempCleaner() {
    }

    /** What a sweep did. */
    public static final class Report {
        public int deleted;
        public long freedBytes;

        @Override
        public String toString() {
            return "TempCleaner{deleted=" + deleted + ", freedBytes=" + freedBytes + "}";
        }
    }

    /** Call when an install starts in this process. Pair with {@link #end()} in a finally block. */
    public static void begin() {
        sActive.incrementAndGet();
    }

    public static void end() {
        if (sActive.decrementAndGet() < 0) {
            sActive.set(0);
        }
    }

    /** True while an install runs in this process. */
    public static boolean isBusy() {
        return sActive.get() > 0;
    }

    /** True for the names the install code creates in the cache folder. */
    public static boolean isTempName(String name) {
        if (name == null) {
            return false;
        }
        String n = name.toLowerCase(Locale.ROOT);
        return n.startsWith("install_") || n.startsWith("bundle_") || n.startsWith("cluster_")
                || UUID_APK.matcher(n).matches();
    }

    /**
     * Deletes the leftovers older than {@link #STALE_AGE_MS} in {@code cacheDir}. Does nothing while an
     * install runs in this process. Never throws.
     */
    public static Report sweepStale(File cacheDir) {
        if (isBusy()) {
            return new Report();
        }
        return sweep(cacheDir, STALE_AGE_MS, System.currentTimeMillis());
    }

    /**
     * @param maxAgeMs an entry is deleted when nothing inside it changed for at least this long;
     *                 0 deletes every matching entry
     * @param now      the current time in ms (a parameter so a test can set it)
     */
    public static Report sweep(File cacheDir, long maxAgeMs, long now) {
        Report report = new Report();
        try {
            File[] children = cacheDir == null ? null : cacheDir.listFiles();
            if (children == null) {
                return report;
            }
            for (File child : children) {
                if (!isTempName(child.getName())) {
                    continue;
                }
                if (maxAgeMs > 0 && now - newestChange(child, 0) < maxAgeMs) {
                    continue;
                }
                report.freedBytes += sizeOf(child, 0);
                int n = deleteTree(child);
                report.deleted += n > 0 ? 1 : 0;
            }
        } catch (Throwable ignored) {
            // a cleanup must never break the screen that called it
        }
        return report;
    }

    // ------------------------------------------------------------------ helpers

    private static long newestChange(File f, int depth) {
        long newest = f.lastModified();
        if (depth < 8 && f.isDirectory() && !isLink(f)) {
            File[] kids = f.listFiles();
            if (kids != null) {
                for (File k : kids) {
                    newest = Math.max(newest, newestChange(k, depth + 1));
                }
            }
        }
        return newest;
    }

    private static long sizeOf(File f, int depth) {
        if (isLink(f)) {
            return 0;
        }
        if (f.isFile()) {
            return f.length();
        }
        long sum = 0;
        File[] kids = depth < 8 ? f.listFiles() : null;
        if (kids != null) {
            for (File k : kids) {
                sum += sizeOf(k, depth + 1);
            }
        }
        return sum;
    }

    /** Deletes a file or folder. A link is removed itself, its target is never touched. */
    private static int deleteTree(File f) {
        int count = 0;
        if (f.isDirectory() && !isLink(f)) {
            File[] kids = f.listFiles();
            if (kids != null) {
                for (File k : kids) {
                    count += deleteTree(k);
                }
            }
        }
        if (f.delete()) {
            count++;
        }
        return count;
    }

    private static boolean isLink(File f) {
        try {
            File parent = f.getParentFile();
            File inParent = parent == null ? f : new File(parent.getCanonicalFile(), f.getName());
            return !inParent.getCanonicalFile().equals(inParent.getAbsoluteFile());
        } catch (IOException e) {
            return false;
        }
    }
}
