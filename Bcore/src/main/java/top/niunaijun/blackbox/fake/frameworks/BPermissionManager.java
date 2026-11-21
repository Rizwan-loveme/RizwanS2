package top.niunaijun.blackbox.fake.frameworks;

import android.os.Bundle;
import android.os.RemoteException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import top.niunaijun.blackbox.core.system.ServiceManager;
import top.niunaijun.blackbox.core.system.permission.IBPermissionService;

/**
 * Client side of the permission store. Hooks run inside the clone process and ask very
 * often, so answers are cached for a short time. Calls made from this process through the
 * setters clear the cache at once; other processes see changes within CACHE_TTL_MS.
 *
 * If the service cannot be reached the answer is MODE_ALLOW, which is the old behaviour.
 */
public class BPermissionManager extends BlackManager<IBPermissionService> {
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_ALLOW = 1;
    public static final int MODE_ASK = 2;
    public static final int MODE_DENY = 3;
    public static final String PACKAGE_DEFAULT = "*";

    private static final long CACHE_TTL_MS = 1500;
    private static final BPermissionManager sManager = new BPermissionManager();

    private static class Entry {
        final int mode;
        final long time;

        Entry(int mode, long time) {
            this.mode = mode;
            this.time = time;
        }
    }

    private final Map<String, Entry> mCache = new ConcurrentHashMap<>();

    public static BPermissionManager get() {
        return sManager;
    }

    @Override
    protected String getServiceName() {
        return ServiceManager.PERMISSION_MANAGER;
    }

    /** Effective mode: MODE_ALLOW, MODE_ASK or MODE_DENY. */
    public int getMode(int userId, String packageName, String permission) {
        String key = userId + "|" + packageName + "|" + permission;
        long now = System.currentTimeMillis();
        Entry e = mCache.get(key);
        if (e != null && now - e.time < CACHE_TTL_MS) {
            return e.mode;
        }
        try {
            IBPermissionService s = getService();
            if (s == null) return MODE_ALLOW;
            int mode = s.getMode(userId, packageName, permission);
            // Ask is never cached: the Ask dialog runs in another process and its answer
            // ("allow this time" / "always") must be seen by the very next check of the app
            if (mode != MODE_ASK) {
                mCache.put(key, new Entry(mode, now));
            }
            return mode;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return MODE_ALLOW;
        }
    }

    public boolean isAllowed(int userId, String packageName, String permission) {
        return getMode(userId, packageName, permission) == MODE_ALLOW;
    }

    public boolean isDenied(int userId, String packageName, String permission) {
        return getMode(userId, packageName, permission) == MODE_DENY;
    }

    public int getRawMode(int userId, String packageName, String permission) {
        try {
            IBPermissionService s = getService();
            if (s != null) return s.getRawMode(userId, packageName, permission);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return MODE_DEFAULT;
    }

    /** "Allow this time" (part 17). Only counts while the stored mode is Ask. */
    public void grantTemporary(int userId, String packageName, String permission) {
        try {
            IBPermissionService s = getService();
            if (s != null) s.grantTemporary(userId, packageName, permission);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } finally {
            mCache.clear();
        }
    }

    /** mode MODE_DEFAULT removes the stored value. permission PACKAGE_DEFAULT = whole package. */
    public void setMode(int userId, String packageName, String permission, int mode) {
        try {
            IBPermissionService s = getService();
            if (s != null) s.setMode(userId, packageName, permission, mode);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } finally {
            mCache.clear();
        }
    }

    /** Stored values only (permission -> mode), may contain PACKAGE_DEFAULT. */
    public Map<String, Integer> getModes(int userId, String packageName) {
        Map<String, Integer> result = new HashMap<>();
        try {
            IBPermissionService s = getService();
            if (s == null) return result;
            Bundle b = s.getModes(userId, packageName);
            if (b != null) {
                for (String k : b.keySet()) {
                    result.put(k, b.getInt(k));
                }
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void resetPackage(int userId, String packageName) {
        try {
            IBPermissionService s = getService();
            if (s != null) s.resetPackage(userId, packageName);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } finally {
            mCache.clear();
        }
    }

    public void resetAll() {
        try {
            IBPermissionService s = getService();
            if (s != null) s.resetAll();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } finally {
            mCache.clear();
        }
    }

    public int getGlobalDefault() {
        try {
            IBPermissionService s = getService();
            if (s != null) return s.getGlobalDefault();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return MODE_ALLOW;
    }

    public void setGlobalDefault(int mode) {
        try {
            IBPermissionService s = getService();
            if (s != null) s.setGlobalDefault(mode);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } finally {
            mCache.clear();
        }
    }
}
