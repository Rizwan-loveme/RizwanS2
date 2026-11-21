package top.niunaijun.blackbox.fake.service;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.app.InstallRequestActivity;
import top.niunaijun.blackbox.utils.Slog;

/**
 * Part 31: install from inside the box.
 *
 * A clone that wants to install an APK (browser download, file manager, "update" button of an app,
 * ACTION_INSTALL_PACKAGE ...) starts the system package installer. That would put the new app on the
 * PHONE, next to the real apps, which is not what the user wants inside a box.
 *
 * So the start of that activity is redirected to our own {@link InstallRequestActivity} (host
 * process). It asks once, then installs the file into the SAME space as the clone that asked
 * (an app that is already there is updated, its data stays) and answers with the same result codes
 * as the system installer, so the clone's startActivityForResult() works as usual.
 */
public final class InstallRequestRedirect {
    private static final String TAG = "InstallRequest";

    private InstallRequestRedirect() {
    }

    /**
     * Rewrites the intent in place so it opens the install dialog of the box.
     *
     * @param file the file behind the intent's uri when the clone's own FileProvider could map it, else null
     * @return true if the intent was redirected and must now be started as it is; false if nothing was
     * changed and the old flow (system installer) should run
     */
    public static boolean redirect(Intent intent, File file) {
        try {
            if (intent == null) return false;
            // only inside a clone process; the host's own installs are left alone
            if (BActivityThread.getAppConfig() == null) return false;
            if (!BlackBoxCore.get().isInstallInsideBox()) return false;
            String pkg = BActivityThread.getAppPackageName();
            if (pkg == null) return false;

            Uri data = intent.getData();
            String path = null;
            if (file != null && file.isFile()) {
                path = file.getAbsolutePath();
            } else if (data != null && "file".equals(data.getScheme()) && data.getPath() != null) {
                path = data.getPath();
            }
            // a content:// uri that is not ours and cannot be mapped is read by the dialog through the resolver
            if (path == null && data == null) return false;

            intent.setComponent(new ComponentName(BlackBoxCore.getHostPkg(), InstallRequestActivity.class.getName()));
            intent.setPackage(BlackBoxCore.getHostPkg());
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.putExtra(InstallRequestActivity.EXTRA_CLONE_PACKAGE, pkg);
            intent.putExtra(InstallRequestActivity.EXTRA_CLONE_USER, BActivityThread.getUserId());
            intent.putExtra(InstallRequestActivity.EXTRA_CLONE_LABEL, labelOf(pkg));
            if (path != null) {
                intent.putExtra(InstallRequestActivity.EXTRA_FILE, path);
            }
            Slog.d(TAG, "install dialog for " + pkg + " (user " + BActivityThread.getUserId() + "): "
                    + (path != null ? path : String.valueOf(data)));
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
