package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The files an app of this box loads code and resources from: the base APK first, then every
 * split, in the order of {@code ApplicationInfo.splitSourceDirs}. Null and empty entries are
 * dropped and a path is never listed twice. No Android classes, so it is tested on a plain JVM.
 */
public final class CodePaths {

    private CodePaths() {
    }

    /** Base APK followed by the splits. Empty when there is no base path. */
    public static List<String> all(String baseApk, String[] splitApks) {
        Set<String> paths = new LinkedHashSet<>();
        if (baseApk != null && !baseApk.isEmpty()) {
            paths.add(baseApk);
        }
        if (splitApks != null) {
            for (String split : splitApks) {
                if (split != null && !split.isEmpty()) {
                    paths.add(split);
                }
            }
        }
        return new ArrayList<>(paths);
    }

    /** For {@code PathClassLoader(dexPath, ...)}: all APKs joined with ':'. Null when there is no base path. */
    public static String dexPath(String baseApk, String[] splitApks) {
        List<String> paths = all(baseApk, splitApks);
        if (paths.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String p : paths) {
            if (sb.length() > 0) {
                sb.append(File.pathSeparatorChar);
            }
            sb.append(p);
        }
        return sb.toString();
    }

    /**
     * Same list for {@code AssetManager.addAssetPath}: the base APK has to be first (it holds
     * resources.arsc and the package id 0x7f), the splits add their configuration resources
     * (density, language) and feature resources on top.
     */
    public static List<String> resourcePaths(String baseApk, String[] splitApks) {
        return all(baseApk, splitApks);
    }
}
