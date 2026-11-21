package top.niunaijun.blackbox.fake.service;

import android.content.ComponentName;
import android.content.Intent;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.app.PermissionRequestActivity;
import top.niunaijun.blackbox.core.system.permission.PermissionCatalog;
import top.niunaijun.blackbox.utils.Slog;

/**
 * Part 17. A clone asks for runtime permissions with Activity.requestPermissions(), which starts
 * the system's permission controller (action REQUEST_PERMISSIONS) and waits for its result.
 * The system dialog would talk about the host app and would not follow the per-clone store.
 *
 * So the start of that activity is redirected to our own {@link PermissionRequestActivity}. It
 * looks every requested permission up in the permission store, shows the Ask dialog where the
 * mode is Ask and answers with the same result extras as the real controller, so the app gets a
 * normal onRequestPermissionsResult().
 *
 * Requests that contain no managed permission at all are left alone (old behaviour).
 */
public final class PermissionRequestRedirect {
    private static final String TAG = "PermissionRequest";

    /** PackageManager.ACTION_REQUEST_PERMISSIONS (hidden on old SDKs, so spelled out). */
    public static final String ACTION_REQUEST_PERMISSIONS = "android.content.pm.action.REQUEST_PERMISSIONS";
    /** PackageManager.EXTRA_REQUEST_PERMISSIONS_NAMES */
    public static final String EXTRA_NAMES = "android.content.pm.extra.REQUEST_PERMISSIONS_NAMES";
    /** PackageManager.EXTRA_REQUEST_PERMISSIONS_RESULTS */
    public static final String EXTRA_RESULTS = "android.content.pm.extra.REQUEST_PERMISSIONS_RESULTS";
    /** Android 14+: one device id per permission, echoed back when present. */
    public static final String EXTRA_DEVICE_IDS = "android.content.pm.extra.REQUEST_PERMISSIONS_DEVICE_IDS";

    private PermissionRequestRedirect() {
    }

    public static boolean isRequestIntent(Intent intent) {
        return intent != null && ACTION_REQUEST_PERMISSIONS.equals(intent.getAction());
    }

    /**
     * Rewrites the intent in place so it opens our dialog activity.
     *
     * @return true if the intent was redirected and must now be started as it is; false if
     * nothing was changed and the old flow should run.
     */
    public static boolean redirect(Intent intent) {
        try {
            if (!isRequestIntent(intent)) return false;
            // only inside a clone process: the host's own requests keep the system dialog
            if (BActivityThread.getAppConfig() == null) return false;
            String[] names = intent.getStringArrayExtra(EXTRA_NAMES);
            if (names == null || names.length == 0) return false;

            boolean anyManaged = false;
            for (String n : names) {
                if (PermissionCatalog.isManaged(n)) {
                    anyManaged = true;
                    break;
                }
            }
            if (!anyManaged) return false;

            String pkg = BActivityThread.getAppPackageName();
            if (pkg == null) return false;

            intent.setComponent(new ComponentName(BlackBoxCore.getHostPkg(), PermissionRequestActivity.class.getName()));
            intent.setPackage(BlackBoxCore.getHostPkg());
            intent.putExtra(PermissionRequestActivity.EXTRA_CLONE_PACKAGE, pkg);
            intent.putExtra(PermissionRequestActivity.EXTRA_CLONE_USER, BActivityThread.getUserId());
            intent.putExtra(PermissionRequestActivity.EXTRA_CLONE_LABEL, labelOf(pkg));
            Slog.d(TAG, "Ask dialog for " + pkg + " (user " + BActivityThread.getUserId() + "): "
                    + java.util.Arrays.toString(names));
            return true;
        } catch (Throwable t) {
            Slog.w(TAG, "redirect failed, using the old flow: " + t);
            return false;
        }
    }

    private static String labelOf(String pkg) {
        try {
            CharSequence label = BActivityThread.getApplication().getApplicationInfo()
                    .loadLabel(BActivityThread.getApplication().getPackageManager());
            if (label != null && label.length() > 0) return label.toString();
        } catch (Throwable ignored) {
        }
        return pkg;
    }
}
