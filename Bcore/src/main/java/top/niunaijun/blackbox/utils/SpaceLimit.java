package top.niunaijun.blackbox.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Rules for the number of virtual spaces and for naming the same app in several spaces.
 * No Android classes, so it can be tested on a plain JVM.
 */
public final class SpaceLimit {

    /** What a new install of the launcher gets. */
    public static final int DEFAULT_MAX = 10;
    public static final int MIN_MAX = 1;
    /** Upper end of the setting. Every space has its own data folder and processes, so keep it sane. */
    public static final int HARD_MAX = 30;

    private SpaceLimit() {
    }

    /** Puts a requested limit into {@link #MIN_MAX}..{@link #HARD_MAX}. */
    public static int clamp(int requested) {
        return Math.max(MIN_MAX, Math.min(HARD_MAX, requested));
    }

    /** The first space id (0 based) below {@code max} that is not in {@code usedSpaces}, or -1 when all are used. */
    public static int firstFree(Set<Integer> usedSpaces, int max) {
        int limit = clamp(max);
        for (int i = 0; i < limit; i++) {
            if (usedSpaces == null || !usedSpaces.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /** Package names that appear more than once in {@code packages} (the same app in several spaces). */
    public static Set<String> duplicates(List<String> packages) {
        Map<String, Integer> counts = new HashMap<>();
        Set<String> result = new HashSet<>();
        if (packages == null) {
            return result;
        }
        for (String p : packages) {
            if (p == null) {
                continue;
            }
            Integer c = counts.get(p);
            counts.put(p, c == null ? 1 : c + 1);
        }
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            if (e.getValue() > 1) {
                result.add(e.getKey());
            }
        }
        return result;
    }
}
