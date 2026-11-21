package top.niunaijun.blackbox.utils.bundle;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

import java.io.File;
import java.util.List;

import black.android.content.pm.BRApplicationInfoL;
import top.niunaijun.blackbox.core.env.BEnvironment;
import top.niunaijun.blackbox.utils.compat.BuildCompat;

/**
 * "Independent copy" mode of a clone made from an app that is installed on the phone.
 *
 * <p>The normal clone (FLAG_SYSTEM) keeps pointing at the phone's own APK files and libraries. That
 * is small and follows updates, but when the original app is updated the paths change, and when it
 * is removed the clone has nothing left to run. In the independent mode the base APK and all splits
 * are copied into the box (FLAG_STORAGE, the same path an "install from file" takes), the libraries
 * are extracted there, and the phone is not looked at again: the clone survives updates and removal
 * of the original. The price is the disk space of the copy, and that the clone does not get updates
 * of the original by itself.
 *
 * <p>This class only prepares the install: which files, and whether the box can run them and has
 * the space. The copy itself is done by the normal install (CopyExecutor).
 */
public final class IndependentCopy {

    /** The files an independent copy installs. */
    public static final class Plan {
        /** The phone's base APK (read only, it is copied). */
        public final File base;
        /** The phone's split APKs, empty for an app with a single APK. */
        public final List<String> splits;
        /** Size of the base APK and all splits together. */
        public final long apkBytes;

        Plan(File base, List<String> splits, long apkBytes) {
            this.base = base;
            this.splits = splits;
            this.apkBytes = apkBytes;
        }
    }

    private IndependentCopy() {
    }

    /**
     * @param phone the phone's ApplicationInfo of the app
     * @throws BundleException the files cannot be read, the app does not run in the box, or there is
     *                         not enough free space; the message can be shown to the user
     */
    public static Plan plan(String packageName, ApplicationInfo phone) throws BundleException {
        if (phone == null || phone.sourceDir == null) {
            throw new BundleException("The original app was not found on this phone: " + packageName);
        }
        File base = new File(phone.sourceDir);
        if (!base.isFile() || !base.canRead()) {
            throw new BundleException("Cannot read the APK of " + packageName + " on this phone.");
        }
        List<String> splits = PhoneSplits.read(packageName, phone.sourceDir, phone.splitSourceDirs);
        if (!splits.isEmpty() && BuildCompat.isL()) {
            String phoneAbi = BRApplicationInfoL.get(phone).primaryCpuAbi();
            List<String> boxAbis = DeviceProfile.fromSystem().abis;
            if (!PhoneSplits.runsInBox(phoneAbi, boxAbis)) {
                throw new BundleException("This app does not run in the box: the phone runs it as " + phoneAbi
                        + ", but the box needs " + TextUtils.join(", ", boxAbis) + ".");
            }
        }
        long bytes = base.length();
        for (String s : splits) {
            bytes += new File(s).length();
        }
        File root = BEnvironment.getVirtualRoot();
        if (root.getUsableSpace() < PhoneSplits.spaceNeededForCopy(bytes)) {
            throw new BundleException(InstallErrors.MSG_NOT_ENOUGH_SPACE_FOR_COPY);
        }
        return new Plan(base, splits, bytes);
    }

    /** True when the clone's base APK is the box's own copy (an independent copy), false when it points at the phone. */
    public static boolean isIndependent(String baseCodePath) {
        return PhoneSplits.isInsideRoot(baseCodePath, BEnvironment.getVirtualRoot());
    }
}
