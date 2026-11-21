package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Decides whether an app (base APK + all its splits) can run in the box. This is the one rule
 * used by the installer, the "clone from phone" list and the native library installer
 * ({@link NativeLibInstaller}), so they always agree.
 *
 * <ul>
 *   <li>The native libraries of <b>all</b> APKs are looked at, not only the base APK. A Play Store
 *       app has its libraries in {@code split_config.arm64_v8a.apk}; the base APK has none.</li>
 *   <li>No native code anywhere: supported (pure Java / Kotlin app).</li>
 *   <li>Otherwise supported when at least one of the ABIs the box can run (same bitness as the box,
 *       see {@link DeviceProfile#abis}) has libraries. {@code armeabi} counts on a device with
 *       {@code armeabi-v7a}. An app that only has x86 libraries is not supported.</li>
 * </ul>
 */
public final class AbiCheck {

    /** Outcome of {@link #check}. */
    public static final class Result {
        public final boolean supported;
        /** ABIs that have native libraries in the APKs, sorted, canonical names. Empty = no native code. */
        public final Set<String> abisInApks;
        /** ABI the box would use, null when there is no native code or it is not supported. */
        public final String abi;
        private final List<String> deviceAbis;

        Result(boolean supported, Set<String> abisInApks, String abi, List<String> deviceAbis) {
            this.supported = supported;
            this.abisInApks = abisInApks;
            this.abi = abi;
            this.deviceAbis = deviceAbis;
        }

        /** Readable reason for the user; empty when supported. */
        public String message() {
            return supported ? "" : wrongArchitectureMessage(abisInApks, deviceAbis);
        }

        @Override
        public String toString() {
            return "AbiCheck{supported=" + supported + ", inApks=" + abisInApks + ", use=" + abi + "}";
        }
    }

    private AbiCheck() {
    }

    /** Scans the APKs (central directory only, fast) and decides. A file that cannot be read counts as "no libraries". */
    public static Result check(List<File> apks, List<String> deviceAbis) {
        Set<String> abis = new TreeSet<>();
        for (File apk : apks) {
            try {
                for (ApkNativeLibs.Lib lib : ApkNativeLibs.scan(apk)) {
                    abis.add(SplitPicker.canonicalAbi(lib.abi));
                }
            } catch (IOException | RuntimeException ignored) {
                // damaged or missing file: the parser reports that problem with a better message
            }
        }
        return decide(abis, deviceAbis);
    }

    /** Same decision from an ABI set that was scanned earlier (used by the cache in AbiUtils). */
    public static Result decide(Set<String> abisInApks, List<String> deviceAbis) {
        if (abisInApks.isEmpty()) {
            return new Result(true, abisInApks, null, deviceAbis);
        }
        String abi = NativeLibInstaller.chooseAbi(abisInApks, deviceAbis);
        return new Result(abi != null, abisInApks, abi, deviceAbis);
    }

    /** ABI names found in one APK (canonical, sorted). */
    public static Set<String> scanAbis(File apk) {
        Set<String> abis = new TreeSet<>();
        try {
            for (ApkNativeLibs.Lib lib : ApkNativeLibs.scan(apk)) {
                abis.add(SplitPicker.canonicalAbi(lib.abi));
            }
        } catch (IOException | RuntimeException ignored) {
        }
        return abis;
    }

    static String wrongArchitectureMessage(Set<String> abisInApks, List<String> deviceAbis) {
        return "This app does not run on this phone: it only has native code for " + join(abisInApks)
                + ", but the box needs " + join(NativeLibInstaller.canonical(deviceAbis)) + ".";
    }

    private static String join(Iterable<String> items) {
        StringBuilder sb = new StringBuilder();
        for (String s : items) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(s);
        }
        return sb.length() == 0 ? "(nothing)" : sb.toString();
    }
}
