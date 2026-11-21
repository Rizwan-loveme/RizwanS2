package top.niunaijun.blackbox.fake.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.core.system.permission.HostBridgePlan;
import top.niunaijun.blackbox.utils.Slog;

/**
 * "What does the host app really hold?" (part 18).
 *
 * Inside a clone every permission check is answered by {@link PermissionPolicy}, which looks at
 * the clone's store and the old forced grants, not at the host. To see the truth this class sets
 * a per-thread "real check" flag, runs the normal Android check and clears the flag; while it is
 * set, {@link PermissionPolicy} has no opinion and the hooks let the system answer for the host
 * uid.
 */
public final class HostPermissionCheck {
    private static final String TAG = "HostPermissionCheck";

    /** A "granted" answer is reused for this long; "denied" is never cached (the user may just have allowed it). */
    private static final long GRANTED_CACHE_MS = 3000;

    private static final ThreadLocal<Boolean> sRealCheck = new ThreadLocal<>();
    private static final Map<String, Long> sGrantedAt = new ConcurrentHashMap<>();

    private HostPermissionCheck() {
    }

    /** True while this thread is asking what the host really holds. {@link PermissionPolicy} reads it. */
    public static boolean isRealCheck() {
        return Boolean.TRUE.equals(sRealCheck.get());
    }

    /** The host really holds the permission (true as well when this Android version has no such permission). */
    public static boolean holds(Context context, String permission) {
        if (permission == null) return true;
        if (!HostBridgePlan.appliesOnSdk(permission, Build.VERSION.SDK_INT)) return true;
        Boolean previous = sRealCheck.get();
        sRealCheck.set(Boolean.TRUE);
        try {
            Context c = context != null ? context : BlackBoxCore.getContext();
            boolean granted = c.checkPermission(permission, Process.myPid(), Process.myUid())
                    == PackageManager.PERMISSION_GRANTED;
            if (granted) {
                sGrantedAt.put(permission, System.currentTimeMillis());
            } else {
                sGrantedAt.remove(permission);
            }
            return granted;
        } catch (Throwable t) {
            Slog.w(TAG, "could not check " + permission + ": " + t);
            return true; // cannot tell: keep the old behaviour instead of blocking the app
        } finally {
            if (previous == null) sRealCheck.remove();
            else sRealCheck.set(previous);
        }
    }

    /** Same as {@link #holds(Context, String)}, but a recent "granted" is reused (hot path of the hooks). */
    public static boolean holdsCached(String permission) {
        Long at = sGrantedAt.get(permission);
        if (at != null && System.currentTimeMillis() - at < GRANTED_CACHE_MS) return true;
        return holds(null, permission);
    }

    /** Drops cached answers (after the host was asked). */
    public static void forget() {
        sGrantedAt.clear();
    }

    /** The host app's manifest declares the permission. Without it Android never shows a dialog. */
    public static boolean declared(Context context, String permission) {
        try {
            PackageInfo info = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            if (info.requestedPermissions == null) return false;
            for (String p : info.requestedPermissions) {
                if (permission.equals(p)) return true;
            }
        } catch (Throwable t) {
            Slog.w(TAG, "could not read the host manifest: " + t);
            return true; // cannot tell: let the system decide
        }
        return false;
    }

    /** A {@link HostBridgePlan.Host} backed by the real device state. */
    public static HostBridgePlan.Host host(final Context context) {
        return new HostBridgePlan.Host() {
            @Override
            public boolean holds(String permission) {
                return HostPermissionCheck.holds(context, permission);
            }

            @Override
            public boolean declared(String permission) {
                return HostPermissionCheck.declared(context, permission);
            }
        };
    }
}
