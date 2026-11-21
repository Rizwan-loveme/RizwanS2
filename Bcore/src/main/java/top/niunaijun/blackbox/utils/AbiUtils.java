package top.niunaijun.blackbox.utils;

import android.content.pm.ApplicationInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.utils.bundle.AbiCheck;
import top.niunaijun.blackbox.utils.bundle.DeviceProfile;


/**
 * Can the box run this app? Looks at the native libraries of the base APK <b>and all splits</b>,
 * with the same rule as the native library installer ({@link AbiCheck}), so the app list ("clone
 * from phone") and the installer give the same answer.
 *
 * <p>Results are cached per file set. The key contains size and modification time of every file,
 * so an updated app is scanned again (the old cache was keyed by file name only and went stale).
 */
public class AbiUtils {
    private static final int CACHE_SIZE = 64;

    private static final Map<String, Set<String>> sCache = new LinkedHashMap<String, Set<String>>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Entry<String, Set<String>> eldest) {
            return size() > CACHE_SIZE;
        }
    };

    private AbiUtils() {
    }

    /** Base APK only (kept for old callers). */
    public static boolean isSupport(File apkFile) {
        return check(apkFile, (String[]) null).supported;
    }

    /** Base APK and the split APKs of an installed app. */
    public static boolean isSupport(ApplicationInfo info) {
        return check(info).supported;
    }

    public static boolean isSupport(File baseApk, List<String> splitPaths) {
        return check(baseApk, splitPaths == null ? null : splitPaths.toArray(new String[0])).supported;
    }

    public static AbiCheck.Result check(ApplicationInfo info) {
        if (info == null || info.sourceDir == null) {
            return AbiCheck.decide(new java.util.TreeSet<String>(), DeviceProfile.fromSystem().abis);
        }
        return check(new File(info.sourceDir), info.splitSourceDirs);
    }

    public static AbiCheck.Result check(File baseApk, String[] splitPaths) {
        List<File> files = new ArrayList<>();
        files.add(baseApk);
        if (splitPaths != null) {
            for (String split : splitPaths) {
                if (split != null && !split.isEmpty()) {
                    files.add(new File(split));
                }
            }
        }
        Set<String> abis = scan(files);
        return AbiCheck.decide(abis, DeviceProfile.fromSystem().abis);
    }

    private static Set<String> scan(List<File> files) {
        StringBuilder key = new StringBuilder();
        for (File f : files) {
            key.append(f.getAbsolutePath()).append('|').append(f.length()).append('|')
                    .append(f.lastModified()).append(';');
        }
        String k = key.toString();
        synchronized (sCache) {
            Set<String> hit = sCache.get(k);
            if (hit != null) {
                return hit;
            }
        }
        Set<String> abis = new java.util.TreeSet<>();
        for (File f : files) {
            abis.addAll(AbiCheck.scanAbis(f));
        }
        synchronized (sCache) {
            sCache.put(k, abis);
        }
        return abis;
    }

    /** Kept so that old code asking about the bitness of the box still compiles. */
    public static boolean boxIs64Bit() {
        return BlackBoxCore.is64Bit();
    }
}
