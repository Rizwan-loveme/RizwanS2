package top.niunaijun.blackbox.utils.bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * The library search path of an app, in the same shape the Android framework builds it:
 * the extracted library folder first, then {@code <apk>!/lib/<abi>} for the base APK and every
 * split. The second kind is what an app with {@code extractNativeLibs="false"} needs, because its
 * libraries stay inside the APK files.
 *
 * <p>Part 8 passes this list to the app's class loader ({@code PathClassLoader}).
 */
public final class NativeLibPaths {

    private NativeLibPaths() {
    }

    /**
     * @param libDir     extracted library folder, may be null
     * @param codePaths  base APK first, then all splits
     * @param abi        ABI chosen at install time, null when the app has no native code
     * @param extractNativeLibs the app's flag; with true only the folder is returned
     */
    public static List<String> build(String libDir, List<String> codePaths, String abi, boolean extractNativeLibs) {
        List<String> paths = new ArrayList<>();
        if (libDir != null && !libDir.isEmpty()) {
            paths.add(libDir);
        }
        if (!extractNativeLibs && abi != null && !abi.isEmpty() && codePaths != null) {
            for (String code : codePaths) {
                if (code != null && !code.isEmpty()) {
                    paths.add(code + "!/lib/" + abi);
                }
            }
        }
        return paths;
    }

    /** Joined with ':' for {@code PathClassLoader(dexPath, librarySearchPath, parent)}. */
    public static String join(List<String> paths) {
        StringBuilder sb = new StringBuilder();
        for (String p : paths) {
            if (sb.length() > 0) {
                sb.append(':');
            }
            sb.append(p);
        }
        return sb.toString();
    }
}
