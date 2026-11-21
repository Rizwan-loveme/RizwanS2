package top.niunaijun.blackbox.core.system.pm.installer;

import top.niunaijun.blackbox.core.env.BEnvironment;
import top.niunaijun.blackbox.core.system.pm.BPackageSettings;
import top.niunaijun.blackbox.entity.pm.InstallOption;
import top.niunaijun.blackbox.utils.FileUtils;

/**
 * Deletes the OBB folder of an app inside the box when the app is uninstalled from a space.
 * Not part of {@link RemoveUserExecutor}: "clear data" also uses that one, and clearing the data of
 * a game must not delete its OBB (Android keeps the OBB on "clear data" too).
 */
public class RemoveObbExecutor implements Executor {

    @Override
    public int exec(BPackageSettings ps, InstallOption option, int userId) {
        FileUtils.deleteDir(BEnvironment.getExternalObbDir(ps.pkg.packageName, userId));
        return 0;
    }
}
