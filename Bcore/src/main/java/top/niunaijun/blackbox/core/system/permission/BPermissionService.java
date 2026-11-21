package top.niunaijun.blackbox.core.system.permission;

import android.os.Bundle;

import java.util.Map;

import top.niunaijun.blackbox.core.env.BEnvironment;
import top.niunaijun.blackbox.core.system.ISystemService;
import top.niunaijun.blackbox.utils.Slog;

/**
 * Stores Allow / Ask / Deny per user, package and permission, and keeps it in
 * {@link BEnvironment#getPermissionConf()}. Runs in the BlackBox system process.
 * Hooks (part 14+) read it through BPermissionManager.
 */
public class BPermissionService extends IBPermissionService.Stub implements ISystemService {
    public static final String TAG = "BPermissionService";

    private static final BPermissionService sService = new BPermissionService();
    private volatile PermissionStore mStore;
    private final TemporaryGrants mTemporary = new TemporaryGrants();

    public static BPermissionService get() {
        return sService;
    }

    private BPermissionService() {
    }

    private PermissionStore store() {
        PermissionStore s = mStore;
        if (s == null) {
            synchronized (this) {
                s = mStore;
                if (s == null) {
                    s = new PermissionStore(BEnvironment.getPermissionConf());
                    s.load();
                    mStore = s;
                }
            }
        }
        return s;
    }

    @Override
    public int getMode(int userId, String packageName, String permission) {
        int mode = store().getMode(userId, packageName, permission);
        // "Allow this time" only lifts an Ask; Allow and Deny from the store always win
        if (mode == PermissionStore.MODE_ASK && mTemporary.isGranted(userId, packageName, permission)) {
            return PermissionStore.MODE_ALLOW;
        }
        return mode;
    }

    @Override
    public int getRawMode(int userId, String packageName, String permission) {
        return store().getRawMode(userId, packageName, permission);
    }

    @Override
    public void setMode(int userId, String packageName, String permission, int mode) {
        // a new rule for this clone replaces any "allow this time" it still had
        mTemporary.clearPackage(userId, packageName);
        if (!store().setMode(userId, packageName, permission, mode)) {
            Slog.w(TAG, "setMode rejected: " + userId + "/" + packageName + "/" + permission + "=" + mode);
        }
    }

    @Override
    public Bundle getModes(int userId, String packageName) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Integer> e : store().getModes(userId, packageName).entrySet()) {
            bundle.putInt(e.getKey(), e.getValue());
        }
        return bundle;
    }

    @Override
    public void resetPackage(int userId, String packageName) {
        mTemporary.clearPackage(userId, packageName);
        store().clearPackage(userId, packageName);
    }

    @Override
    public void resetAll() {
        mTemporary.clearAll();
        store().clearAll();
    }

    @Override
    public int getGlobalDefault() {
        return store().getGlobalDefault();
    }

    @Override
    public void setGlobalDefault(int mode) {
        mTemporary.clearAll();
        if (!store().setGlobalDefault(mode)) {
            Slog.w(TAG, "setGlobalDefault rejected: " + mode);
        }
    }

    @Override
    public void grantTemporary(int userId, String packageName, String permission) {
        if (!PermissionCatalog.isManaged(permission)) return;
        mTemporary.grant(userId, packageName, permission);
    }

    @Override
    public int getVersion() {
        return store().getVersion();
    }

    /** Called by the package manager when a clone is removed, so no stale rules remain. */
    public void onPackageRemoved(int userId, String packageName) {
        if (userId < 0) {
            mTemporary.clearAll();
        } else {
            mTemporary.clearPackage(userId, packageName);
        }
        if (userId < 0) { // USER_ALL: package gone everywhere
            for (int u : store().getUserIds(packageName)) {
                store().clearPackage(u, packageName);
            }
            return;
        }
        store().clearPackage(userId, packageName);
    }

    /** Called when a whole space (user) is deleted. */
    public void onUserRemoved(int userId) {
        mTemporary.clearUser(userId);
        store().clearUser(userId);
    }

    @Override
    public void systemReady() {
        store(); // loads the file
    }
}
