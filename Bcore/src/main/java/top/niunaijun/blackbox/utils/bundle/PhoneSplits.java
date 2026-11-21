package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * The split APKs of an app that is installed on the phone itself ("clone from phone").
 *
 * <p>A Play Store app is not one file: the phone keeps {@code base.apk} plus
 * {@code split_config.arm64_v8a.apk}, density / language splits and feature splits, and lists them in
 * {@code ApplicationInfo.splitSourceDirs}. A clone that only knows the base APK has no native
 * libraries, no resources for the screen and no feature code, so it crashes. This class turns
 * {@code splitSourceDirs} into the list of split files the installer hands to the parser
 * ({@code InstallOption.splitPaths}).
 *
 * <p>The clone keeps pointing at the phone's own files (installs "by system" are not copied), so
 * it follows updates of the original. Copying the files is the independent copy mode (FLAG_STORAGE,
 * see {@link IndependentCopy}): the clone then has its own base APK, splits and libraries and does
 * not care when the original is updated or removed.
 *
 * <p>Free of Android classes so it can be tested on a plain JVM.
 */
public final class PhoneSplits {

    private PhoneSplits() {
    }

    /**
     * The split files of the phone's copy, in the order the phone lists them.
     *
     * <ul>
     *   <li>{@code null} / empty entries, the base APK itself and duplicates are skipped.</li>
     *   <li>No splits listed = empty list (an app with a single APK).</li>
     *   <li>A listed file that is missing or cannot be read is an error, not something to skip: a
     *       clone without one of its splits crashes later with a much worse message.</li>
     * </ul>
     *
     * @param packageName for the error message only
     * @param baseApk     path of the base APK ({@code ApplicationInfo.sourceDir})
     * @param splitDirs   {@code ApplicationInfo.splitSourceDirs}, may be null
     * @throws BundleException a split file is missing or not readable
     */
    public static List<String> read(String packageName, String baseApk, String[] splitDirs) throws BundleException {
        List<String> result = new ArrayList<>();
        if (splitDirs == null) {
            return result;
        }
        Set<String> seen = new HashSet<>();
        if (baseApk != null) {
            seen.add(new File(baseApk).getAbsolutePath());
        }
        for (String path : splitDirs) {
            if (path == null || path.isEmpty()) {
                continue;
            }
            String abs = new File(path).getAbsolutePath();
            if (!seen.add(abs)) {
                continue;
            }
            File file = new File(abs);
            if (!file.isFile() || !file.canRead()) {
                throw new BundleException("Cannot read the split file " + file.getName() + " of "
                        + (packageName == null ? "this app" : packageName)
                        + " on this phone (" + (file.exists() ? "no permission" : "file not found")
                        + "). Update the original app and try again.");
            }
            result.add(abs);
        }
        return result;
    }

    /**
     * Can the box load the libraries the phone chose for this app? The phone saves the ABI it runs
     * the app with ({@code ApplicationInfo.primaryCpuAbi}) and the clone uses the phone's extracted
     * libraries, so an app that the phone runs as 64-bit cannot run in a 32-bit box (and the other
     * way round). null / empty (pure Java app) always runs.
     */
    public static boolean runsInBox(String phoneAbi, List<String> boxAbis) {
        if (phoneAbi == null || phoneAbi.isEmpty()) {
            return true;
        }
        Set<String> abis = new TreeSet<>();
        abis.add(SplitPicker.canonicalAbi(phoneAbi));
        return NativeLibInstaller.chooseAbi(abis, boxAbis) != null;
    }

    /**
     * Has the phone's copy changed since the clone was installed? Compares the base APK and the
     * split files as sets (order does not matter). The phone changes the paths whenever the app is
     * updated, so a different path means the clone has to read the app again.
     */
    public static boolean changed(String storedBase, List<String> storedSplits,
                                  String phoneBase, String[] phoneSplits) {
        if (!same(storedBase, phoneBase)) {
            return true;
        }
        Set<String> stored = normalise(storedSplits == null ? null : storedSplits.toArray(new String[0]));
        Set<String> phone = normalise(phoneSplits);
        // the base APK is never a split, whatever the phone lists
        if (phoneBase != null) {
            phone.remove(new File(phoneBase).getAbsolutePath());
        }
        return !stored.equals(phone);
    }

    /** Array version of {@link #changed(String, List, String, String[])}. */
    public static boolean changed(String storedBase, String[] storedSplits, String phoneBase, String[] phoneSplits) {
        List<String> list = null;
        if (storedSplits != null) {
            list = new ArrayList<>();
            for (String s : storedSplits) {
                list.add(s);
            }
        }
        return changed(storedBase, list, phoneBase, phoneSplits);
    }

    /** Free space that must stay free on top of the copy, for the extracted libraries and the data. */
    public static final long COPY_SPACE_MARGIN = 64L * 1024 * 1024;

    /**
     * Space an independent copy needs: the APK files are copied once, and the native libraries are
     * extracted from them (about the size of the APKs again), plus a margin.
     */
    public static long spaceNeededForCopy(long apkBytes) {
        return Math.max(0, apkBytes) * 2 + COPY_SPACE_MARGIN;
    }

    /**
     * True when {@code path} is inside {@code root} (not the folder itself). Used to tell an
     * independent copy (its base APK lives in the box's own folder) from a clone that points at the
     * phone's files.
     */
    public static boolean isInsideRoot(String path, File root) {
        if (path == null || root == null) {
            return false;
        }
        String r = root.getAbsolutePath();
        if (!r.endsWith(File.separator)) {
            r = r + File.separator;
        }
        return new File(path).getAbsolutePath().startsWith(r);
    }

    private static boolean same(String a, String b) {
        if (a == null || b == null) {
            return a == b;
        }
        return new File(a).getAbsolutePath().equals(new File(b).getAbsolutePath());
    }

    private static Set<String> normalise(String[] paths) {
        Set<String> set = new HashSet<>();
        if (paths != null) {
            for (String p : paths) {
                if (p != null && !p.isEmpty()) {
                    set.add(new File(p).getAbsolutePath());
                }
            }
        }
        return set;
    }
}
