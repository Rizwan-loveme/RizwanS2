package top.niunaijun.blackbox.core.system.permission;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * "Allow this time" decisions from the Ask dialog (part 17).
 *
 * A temporary grant lives only in memory and ends after {@link #DEFAULT_TTL_MS}, or earlier when
 * the user changes the rules of that clone (the permissions screen), the clone is removed, or
 * everything is reset. It is never written to the permission file, so a restart of the box
 * always forgets it.
 *
 * Pure Java (no Android classes) so it can be unit-tested on the JVM. The clock can be replaced
 * in tests.
 */
public class TemporaryGrants {
    /** 30 minutes: long enough for one session in the app, short enough to be "this time". */
    public static final long DEFAULT_TTL_MS = 30L * 60L * 1000L;

    public interface Clock {
        long now();
    }

    private static final Clock SYSTEM_CLOCK = new Clock() {
        @Override
        public long now() {
            return System.currentTimeMillis();
        }
    };

    private final Clock mClock;
    private final Map<String, Long> mExpiry = new HashMap<>();

    public TemporaryGrants() {
        this(SYSTEM_CLOCK);
    }

    public TemporaryGrants(Clock clock) {
        mClock = clock;
    }

    private static String key(int userId, String pkg, String permission) {
        return userId + "|" + pkg + "|" + permission;
    }

    public synchronized void grant(int userId, String pkg, String permission) {
        grant(userId, pkg, permission, DEFAULT_TTL_MS);
    }

    public synchronized void grant(int userId, String pkg, String permission, long ttlMs) {
        if (pkg == null || permission == null || ttlMs <= 0) return;
        mExpiry.put(key(userId, pkg, permission), mClock.now() + ttlMs);
    }

    public synchronized boolean isGranted(int userId, String pkg, String permission) {
        if (pkg == null || permission == null) return false;
        String k = key(userId, pkg, permission);
        Long until = mExpiry.get(k);
        if (until == null) return false;
        if (mClock.now() >= until) {
            mExpiry.remove(k);
            return false;
        }
        return true;
    }

    public synchronized void clearPackage(int userId, String pkg) {
        removeWithPrefix(userId + "|" + pkg + "|");
    }

    public synchronized void clearUser(int userId) {
        removeWithPrefix(userId + "|");
    }

    public synchronized void clearAll() {
        mExpiry.clear();
    }

    /** Number of grants that are still valid (expired ones are dropped on the way). */
    public synchronized int size() {
        long now = mClock.now();
        int count = 0;
        Iterator<Map.Entry<String, Long>> it = mExpiry.entrySet().iterator();
        while (it.hasNext()) {
            if (now >= it.next().getValue()) {
                it.remove();
            } else {
                count++;
            }
        }
        return count;
    }

    private void removeWithPrefix(String prefix) {
        Iterator<String> it = mExpiry.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().startsWith(prefix)) it.remove();
        }
    }
}
