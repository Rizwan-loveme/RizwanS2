package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Chooses which split APKs of a bundle are installed.
 *
 * <p>The unpacker extracts every split of the bundle (all densities, all languages, all
 * ABIs). A phone only needs a few of them. For every module (the base and each feature module)
 * the picker keeps:
 * <ul>
 *   <li>the module's own split (base master / feature split),</li>
 *   <li>the ABI split that matches the device,</li>
 *   <li>one density split, the closest one for the screen,</li>
 *   <li>one language split for the device language, plus English,</li>
 *   <li>every other split that is not a density, language or ABI split.</li>
 * </ul>
 *
 * <p>If the bundle has ABI splits but none of them runs on this phone, a
 * {@link BundleException} with a readable message is thrown (a wrong-architecture bundle).
 *
 * <p>What a split is for is read from its manifest ({@code split}, {@code configForSplit},
 * {@code isFeatureSplit}); when the manifest cannot be read the file name is used. This class
 * does not use Android classes, so it can run in a plain JVM test. Use
 * {@link #pick(BundleInfo)} on a device.
 */
public final class SplitPicker {

    /** What a split APK is for. */
    public enum Kind {
        /** Native libraries for one ABI (config.arm64_v8a). */
        ABI,
        /** Resources for one screen density (config.xxhdpi). */
        DENSITY,
        /** Resources for one language (config.en). */
        LANGUAGE,
        /** Another config split (texture format, screen size...). Always kept. */
        OTHER_CONFIG,
        /** The code and resources of a module itself (feature split, base-master). Always kept. */
        FEATURE
    }

    /** One split APK and what it was recognised as. */
    public static final class SplitInfo {
        public final File file;
        /** "base" or the feature module name. */
        public final String module;
        public final Kind kind;
        /** For config splits: the part after "config." (arm64_v8a, xxhdpi, en); else null. */
        public final String token;

        SplitInfo(File file, String module, Kind kind, String token) {
            this.file = file;
            this.module = module;
            this.kind = kind;
            this.token = token;
        }

        @Override
        public String toString() {
            return file.getName() + "[" + module + "/" + kind + (token == null ? "" : ":" + token) + "]";
        }
    }

    /** The result of {@link #pick}. */
    public static final class Selection {
        /** Splits to install, sorted by file name. */
        public final List<File> selected = new ArrayList<>();
        /** Splits that were left out. */
        public final List<File> skipped = new ArrayList<>();
        /** How every split was recognised (selected and skipped). */
        public final List<SplitInfo> all = new ArrayList<>();
        /** ABI that was picked for the base module, for example arm64-v8a. Null if the bundle has no ABI splits. */
        public String abi;
        /** Density split that was picked for the base module, for example xxhdpi. Null if none. */
        public String density;
        /** Language split that was picked for the base module, for example bn. Null if none. */
        public String language;

        /** Absolute paths of {@link #selected}, ready for InstallOption.withSplits(). */
        public List<String> getSelectedPaths() {
            List<String> paths = new ArrayList<>(selected.size());
            for (File f : selected) {
                paths.add(f.getAbsolutePath());
            }
            return paths;
        }

        /** Deletes the skipped files from disk to free space in the temp folder. */
        public void deleteSkipped() {
            for (File f : skipped) {
                //noinspection ResultOfMethodCallIgnored
                f.delete();
            }
        }

        /**
         * Puts {@link #selected} into {@code info.splitApks}, so the rest of the install only
         * sees the splits that were picked.
         *
         * @param deleteSkipped also delete the skipped files from the temp folder
         */
        public void applyTo(BundleInfo info, boolean deleteSkipped) {
            info.splitApks.clear();
            info.splitApks.addAll(selected);
            if (deleteSkipped) {
                deleteSkipped();
            }
        }

        @Override
        public String toString() {
            return "Selection{abi=" + abi + ", density=" + density + ", language=" + language
                    + ", selected=" + selected.size() + ", skipped=" + skipped.size() + "}";
        }
    }

    private SplitPicker() {
    }

    // ------------------------------------------------------------------ entry points

    /** Picks for this phone, see {@link DeviceProfile#fromSystem()}. Needs Android. */
    public static Selection pick(BundleInfo info) throws BundleException {
        return pick(info, DeviceProfile.fromSystem());
    }

    public static Selection pick(BundleInfo info, DeviceProfile profile) throws BundleException {
        return pick(info.splitApks, info.declaredAbis, profile);
    }

    /**
     * @param splits       the split APKs of the bundle (without the base APK)
     * @param declaredAbis ABIs the bundle says it has (APKM info.json), may be empty. Only used
     *                     when the bundle has no ABI splits.
     * @throws BundleException wrong architecture
     */
    public static Selection pick(List<File> splits, List<String> declaredAbis, DeviceProfile profile)
            throws BundleException {
        Selection result = new Selection();

        // group by module, keep the order of first appearance
        Map<String, List<SplitInfo>> modules = new LinkedHashMap<>();
        for (File f : splits) {
            SplitInfo si = describe(f);
            result.all.add(si);
            List<SplitInfo> list = modules.get(si.module);
            if (list == null) {
                list = new ArrayList<>();
                modules.put(si.module, list);
            }
            list.add(si);
        }

        Set<File> keep = new LinkedHashSet<>();
        Set<String> abisInBundle = new LinkedHashSet<>();
        for (List<SplitInfo> list : modules.values()) {
            for (SplitInfo si : list) {
                if (si.kind == Kind.ABI) {
                    abisInBundle.add(canonicalAbi(si.token));
                }
            }
        }

        for (Map.Entry<String, List<SplitInfo>> e : modules.entrySet()) {
            String module = e.getKey();
            List<SplitInfo> abi = new ArrayList<>();
            List<SplitInfo> density = new ArrayList<>();
            List<SplitInfo> lang = new ArrayList<>();
            for (SplitInfo si : e.getValue()) {
                switch (si.kind) {
                    case ABI:
                        abi.add(si);
                        break;
                    case DENSITY:
                        density.add(si);
                        break;
                    case LANGUAGE:
                        lang.add(si);
                        break;
                    default:
                        keep.add(si.file); // feature + other config splits
                }
            }
            boolean isBase = "base".equals(module);

            if (!abi.isEmpty()) {
                SplitInfo chosen = chooseAbi(abi, profile.abis);
                if (chosen == null) {
                    throw wrongArchitecture(abisInBundle, profile.abis, module);
                }
                keep.add(chosen.file);
                if (isBase || result.abi == null) {
                    result.abi = canonicalAbi(chosen.token);
                }
            }
            if (!density.isEmpty()) {
                SplitInfo chosen = chooseDensity(density, profile.densityDpi);
                keep.add(chosen.file);
                if (isBase || result.density == null) {
                    result.density = chosen.token;
                }
            }
            if (!lang.isEmpty()) {
                SplitInfo chosen = chooseLanguage(lang, profile.locales);
                if (chosen != null) {
                    keep.add(chosen.file);
                    if (isBase || result.language == null) {
                        result.language = chosen.token;
                    }
                }
                SplitInfo english = findEnglish(lang);
                if (english != null) {
                    keep.add(english.file);
                }
            }
        }

        // Bundle without ABI splits: info.json may still say which ABIs the base APK holds.
        if (abisInBundle.isEmpty()) {
            checkDeclaredAbis(declaredAbis, profile.abis);
        }

        for (File f : splits) {
            if (keep.contains(f)) {
                result.selected.add(f);
            } else {
                result.skipped.add(f);
            }
        }
        Comparator<File> byName = new Comparator<File>() {
            @Override
            public int compare(File a, File b) {
                return a.getName().compareTo(b.getName());
            }
        };
        Collections.sort(result.selected, byName);
        return result;
    }

    // ------------------------------------------------------------------ choosing

    private static SplitInfo chooseAbi(List<SplitInfo> candidates, List<String> deviceAbis) {
        for (String deviceAbi : deviceAbis) {
            String want = canonicalAbi(deviceAbi);
            for (SplitInfo si : candidates) {
                if (canonicalAbi(si.token).equals(want)) {
                    return si;
                }
            }
        }
        return null;
    }

    /** The smallest density that is not lower than the screen; if all are lower, the biggest. */
    private static SplitInfo chooseDensity(List<SplitInfo> candidates, int deviceDpi) {
        SplitInfo above = null;
        int aboveDpi = Integer.MAX_VALUE;
        SplitInfo biggest = null;
        int biggestDpi = -1;
        for (SplitInfo si : candidates) {
            int dpi = densityDpi(si.token);
            if (dpi >= deviceDpi && dpi < aboveDpi) {
                above = si;
                aboveDpi = dpi;
            }
            if (dpi > biggestDpi) {
                biggest = si;
                biggestDpi = dpi;
            }
        }
        return above != null ? above : biggest;
    }

    /** Exact locale, then same language, then same language with another region. Null if none. */
    private static SplitInfo chooseLanguage(List<SplitInfo> candidates, List<String> deviceLocales) {
        for (String locale : deviceLocales) {
            String[] parts = splitLocale(locale);
            String lang = parts[0];
            String full = parts[1].isEmpty() ? lang : lang + "_" + parts[1];
            for (SplitInfo si : candidates) {
                if (normalizeLocaleToken(si.token).equals(full)) {
                    return si;
                }
            }
            for (SplitInfo si : candidates) {
                if (normalizeLocaleToken(si.token).equals(lang)) {
                    return si;
                }
            }
            for (SplitInfo si : candidates) {
                if (splitLocale(si.token)[0].equals(lang)) {
                    return si;
                }
            }
        }
        return null;
    }

    private static SplitInfo findEnglish(List<SplitInfo> candidates) {
        SplitInfo anyEnglish = null;
        for (SplitInfo si : candidates) {
            String t = normalizeLocaleToken(si.token);
            if (t.equals("en")) {
                return si;
            }
            if (anyEnglish == null && splitLocale(si.token)[0].equals("en")) {
                anyEnglish = si;
            }
        }
        return anyEnglish;
    }

    // ------------------------------------------------------------------ errors

    private static BundleException wrongArchitecture(Set<String> inBundle, List<String> device, String module) {
        StringBuilder sb = new StringBuilder();
        sb.append("This app does not run on this phone: ");
        if (!"base".equals(module)) {
            sb.append("its \"").append(module).append("\" part ");
        } else {
            sb.append("the bundle ");
        }
        sb.append("only has native code for ").append(join(inBundle))
                .append(", but the box needs ").append(join(canonicalList(device))).append(".");
        return new BundleException(sb.toString());
    }

    private static void checkDeclaredAbis(List<String> declared, List<String> deviceAbis) throws BundleException {
        if (declared == null || declared.isEmpty()) {
            return;
        }
        Set<String> declaredCanonical = new LinkedHashSet<>();
        for (String d : declared) {
            String lower = d.toLowerCase(Locale.ROOT).trim();
            if (lower.equals("universal") || lower.equals("noarch") || lower.equals("all")) {
                return; // runs everywhere
            }
            declaredCanonical.add(canonicalAbi(d));
        }
        for (String device : deviceAbis) {
            if (declaredCanonical.contains(canonicalAbi(device))) {
                return;
            }
        }
        throw new BundleException("This app does not run on this phone: the bundle only has native code for "
                + join(declaredCanonical) + ", but the box needs " + join(canonicalList(deviceAbis)) + ".");
    }

    private static List<String> canonicalList(List<String> abis) {
        List<String> out = new ArrayList<>();
        for (String a : abis) {
            out.add(canonicalAbi(a));
        }
        return out;
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

    // ------------------------------------------------------------------ recognising a split

    /** Works out what a split APK is for: manifest first, file name as fallback. */
    public static SplitInfo describe(File file) {
        SplitManifestReader.Result r = SplitManifestReader.read(file);
        if (r != null) {
            SplitInfo fromManifest = fromManifest(file, r);
            if (fromManifest != null) {
                return fromManifest;
            }
        }
        return fromFileName(file);
    }

    private static SplitInfo fromManifest(File file, SplitManifestReader.Result r) {
        String split = r.splitName == null ? "" : r.splitName.trim().toLowerCase(Locale.ROOT);
        if (split.isEmpty() && r.configForSplit == null) {
            return null; // the manifest says nothing about splits
        }
        int ci = indexOfConfig(split);
        if (ci >= 0 || r.configForSplit != null) {
            String module;
            if (r.configForSplit != null && !r.configForSplit.isEmpty()) {
                module = r.configForSplit.toLowerCase(Locale.ROOT);
            } else if (ci > 0) {
                module = split.substring(0, ci - 1);
            } else {
                module = "base";
            }
            String token = ci >= 0 ? split.substring(ci + "config.".length()) : split;
            return configSplit(file, module, token);
        }
        return new SplitInfo(file, split, Kind.FEATURE, null);
    }

    /** Index of "config." at the start of the name or after a separator, else -1. */
    private static int indexOfConfig(String name) {
        int from = 0;
        while (true) {
            int i = name.indexOf("config.", from);
            if (i < 0) {
                return -1;
            }
            if (i == 0 || name.charAt(i - 1) == '.' || name.charAt(i - 1) == '_' || name.charAt(i - 1) == '-') {
                return i;
            }
            from = i + 1;
        }
    }

    private static SplitInfo fromFileName(File file) {
        String n = file.getName().toLowerCase(Locale.ROOT);
        if (n.endsWith(".apk")) {
            n = n.substring(0, n.length() - 4);
        }
        if (n.startsWith("split_") || n.startsWith("split-")) {
            n = n.substring(6);
        }
        int ci = indexOfConfig(n);
        if (ci >= 0) {
            String module = ci == 0 ? "base" : n.substring(0, ci - 1);
            return configSplit(file, module, n.substring(ci + "config.".length()));
        }
        // bundletool style: base-xxhdpi, base-arm64_v8a, base-master, feature-en
        int dash = n.lastIndexOf('-');
        if (dash > 0 && dash < n.length() - 1) {
            String module = n.substring(0, dash);
            String token = n.substring(dash + 1);
            if (token.equals("master")) {
                return new SplitInfo(file, module, Kind.FEATURE, null);
            }
            Kind kind = classifyToken(token);
            if (kind == Kind.ABI || kind == Kind.DENSITY || kind == Kind.LANGUAGE) {
                return new SplitInfo(file, module, kind, token);
            }
        }
        return new SplitInfo(file, n, Kind.FEATURE, null);
    }

    private static SplitInfo configSplit(File file, String module, String token) {
        if (token.isEmpty()) {
            return new SplitInfo(file, module, Kind.OTHER_CONFIG, null);
        }
        return new SplitInfo(file, module, classifyToken(token), token);
    }

    static Kind classifyToken(String token) {
        if (!canonicalAbiOrNull(token).isEmpty()) {
            return Kind.ABI;
        }
        if (densityDpi(token) > 0) {
            return Kind.DENSITY;
        }
        if (isLanguageToken(token)) {
            return Kind.LANGUAGE;
        }
        return Kind.OTHER_CONFIG;
    }

    // ------------------------------------------------------------------ names and numbers

    /** arm64_v8a -> arm64-v8a, armeabi_v7a -> armeabi-v7a. Unknown names are returned as they are. */
    public static String canonicalAbi(String name) {
        String c = canonicalAbiOrNull(name);
        return c.isEmpty() ? name.toLowerCase(Locale.ROOT) : c;
    }

    /** Empty string when the name is not a known ABI. */
    private static String canonicalAbiOrNull(String name) {
        if (name == null) {
            return "";
        }
        String n = name.toLowerCase(Locale.ROOT).replace('-', '_');
        switch (n) {
            case "arm64_v8a":
                return "arm64-v8a";
            case "armeabi_v7a":
                return "armeabi-v7a";
            case "armeabi":
                return "armeabi";
            case "x86":
                return "x86";
            case "x86_64":
                return "x86_64";
            case "mips":
                return "mips";
            case "mips64":
                return "mips64";
            case "riscv64":
                return "riscv64";
            default:
                return "";
        }
    }

    /** dpi of a density name, 0 when the name is not a density split. */
    static int densityDpi(String name) {
        if (name == null) {
            return 0;
        }
        switch (name.toLowerCase(Locale.ROOT)) {
            case "ldpi":
                return 120;
            case "mdpi":
                return 160;
            case "tvdpi":
                return 213;
            case "hdpi":
                return 240;
            case "xhdpi":
                return 320;
            case "xxhdpi":
                return 480;
            case "xxxhdpi":
                return 640;
            default:
                return 0;
        }
    }

    private static boolean isLanguageToken(String token) {
        String t = token.toLowerCase(Locale.ROOT);
        if (t.startsWith("b+")) {
            return true; // BCP 47 form: b+sr+latn
        }
        if (!t.matches("[a-z]{2,3}([_-]([a-z]{2}|[0-9]{3}|[a-z]{4}))*")) {
            return false;
        }
        // "tcf_astc" (texture format) has the same shape as "pt_br": check the language code
        return knownLanguages().contains(splitLocale(t)[0]);
    }

    private static Set<String> sKnownLanguages;

    private static synchronized Set<String> knownLanguages() {
        if (sKnownLanguages == null) {
            Set<String> set = new LinkedHashSet<>();
            for (String l : Locale.getISOLanguages()) {
                set.add(l);
            }
            for (Locale l : Locale.getAvailableLocales()) {
                if (!l.getLanguage().isEmpty()) {
                    set.add(l.getLanguage());
                }
            }
            set.add("iw");
            set.add("in");
            set.add("ji");
            sKnownLanguages = set;
        }
        return sKnownLanguages;
    }

    /** "pt-BR" / "pt_br" / "b+sr+latn" -> {"pt", "br"} / {"sr", "latn"}. Old codes are mapped (iw -> he). */
    private static String[] splitLocale(String tag) {
        String t = tag == null ? "" : tag.toLowerCase(Locale.ROOT).trim();
        if (t.startsWith("b+")) {
            t = t.substring(2).replace('+', '_');
        }
        t = t.replace('-', '_');
        int us = t.indexOf('_');
        String lang = us < 0 ? t : t.substring(0, us);
        String rest = us < 0 ? "" : t.substring(us + 1);
        switch (lang) {
            case "iw":
                lang = "he";
                break;
            case "in":
                lang = "id";
                break;
            case "ji":
                lang = "yi";
                break;
            default:
        }
        return new String[]{lang, rest};
    }

    private static String normalizeLocaleToken(String token) {
        String[] p = splitLocale(token);
        return p[1].isEmpty() ? p[0] : p[0] + "_" + p[1];
    }
}
