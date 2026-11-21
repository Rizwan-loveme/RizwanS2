package top.niunaijun.blackbox.utils.bundle;

/**
 * Small checks for the split fields that are copied into {@code ApplicationInfo} and
 * {@code PackageInfo} ({@code splitSourceDirs}, {@code splitPublicSourceDirs}, {@code splitNames}).
 * Kept free of Android classes so it can be tested on a plain JVM.
 *
 * <p>The framework rule: the three arrays are either all null (app without splits) or all set with
 * the same length, one entry per split. A half filled set (for example names but no paths) makes
 * {@code LoadedApk} / {@code AssetManager} crash, so it is never handed out.
 */
public final class SplitFields {

    private SplitFields() {
    }

    /** True when there is at least one split and names and paths match one to one. */
    public static boolean usable(String[] names, String[] paths) {
        if (names == null || paths == null || paths.length == 0 || names.length != paths.length) {
            return false;
        }
        for (String path : paths) {
            if (path == null || path.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /** A copy, so that changing the ApplicationInfo handed to an app never changes the stored package. */
    public static String[] copy(String[] array) {
        return array == null ? null : array.clone();
    }
}
