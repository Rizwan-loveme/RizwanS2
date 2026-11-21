package top.niunaijun.blackbox.core.system.pm.installer;


import android.content.pm.ApplicationInfo;
import android.os.Build;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import top.niunaijun.blackbox.core.env.BEnvironment;
import top.niunaijun.blackbox.core.system.pm.BPackageSettings;
import top.niunaijun.blackbox.entity.pm.InstallOption;
import top.niunaijun.blackbox.utils.FileUtils;
import top.niunaijun.blackbox.utils.NativeUtils;
import top.niunaijun.blackbox.utils.Slog;
import top.niunaijun.blackbox.utils.bundle.BundleException;
import top.niunaijun.blackbox.utils.bundle.DeviceProfile;
import top.niunaijun.blackbox.utils.bundle.NativeLibInstaller;
import top.niunaijun.blackbox.utils.bundle.SplitFileCopier;
import black.android.content.pm.BRApplicationInfoL;


public class CopyExecutor implements Executor {
    private static final String TAG = "CopyExecutor";

    @Override
    public int exec(BPackageSettings ps, InstallOption option, int userId) {
        try {
            // With splits the libraries live in the base APK and the ABI split, and the files are
            // not in their final place yet: they are extracted in installSplitNativeLibs() below.
            if (!option.isFlag(InstallOption.FLAG_SYSTEM) && !option.hasSplits()) {
                NativeUtils.copyNativeLib(new File(ps.pkg.baseCodePath), BEnvironment.getAppLibDir(ps.pkg.packageName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        if (option.isFlag(InstallOption.FLAG_STORAGE) || needsOwnCopy(option)) {
            
            File origFile = new File(ps.pkg.baseCodePath);
            File newFile = BEnvironment.getBaseApkDir(ps.pkg.packageName);
            try {
                if (option.isFlag(InstallOption.FLAG_URI_FILE)) {
                    boolean b = FileUtils.renameTo(origFile, newFile);
                    if (!b) {
                        FileUtils.copyFile(origFile, newFile);
                    }
                } else {
                    FileUtils.copyFile(origFile, newFile);
                }
                newFile.setReadOnly();
                
                ps.pkg.baseCodePath = newFile.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        } else if (option.isFlag(InstallOption.FLAG_SYSTEM)) {
            
        }
        int result = copySplits(ps, option);
        if (result != 0) {
            return result;
        }
        return installSplitNativeLibs(ps, option);
    }

    /** {@code ApplicationInfo.FLAG_EXTRACT_NATIVE_LIBS} (hidden, API 23+). */
    private static final int FLAG_EXTRACT_NATIVE_LIBS = 1 << 28;

    /**
     * Extracts the native libraries of an app with splits (base APK + ABI split + feature splits)
     * into the app's lib folder, from the final files in the app folder. Apps with
     * {@code extractNativeLibs="false"} keep their libraries inside the APKs and load them from
     * {@code apk!/lib/<abi>} (see NativeLibPaths, used by the class loader).
     *
     * <p>The chosen ABI is saved in {@code ApplicationInfo.primaryCpuAbi} of the package, so it is
     * written to package.conf and used when the app starts. If the libraries cannot be written, or
     * none of them runs on this phone, the install fails and the app folder is removed.
     */
    private static int installSplitNativeLibs(BPackageSettings ps, InstallOption option) {
        if (!option.hasSplits() || option.isFlag(InstallOption.FLAG_SYSTEM)) {
            return 0;
        }
        List<File> apks = new ArrayList<>();
        apks.add(new File(ps.pkg.baseCodePath));
        for (String split : ps.pkg.splitCodePaths) {
            apks.add(new File(split));
        }
        boolean extractLibs = true;
        if (Build.VERSION.SDK_INT >= 23 && ps.pkg.applicationInfo != null) {
            extractLibs = (ps.pkg.applicationInfo.flags & FLAG_EXTRACT_NATIVE_LIBS) != 0;
        }
        try {
            NativeLibInstaller.Result r = NativeLibInstaller.install(apks,
                    DeviceProfile.fromSystem().abis, BEnvironment.getAppLibDir(ps.pkg.packageName), extractLibs);
            Slog.d(TAG, ps.pkg.packageName + ": " + r + " extractNativeLibs=" + extractLibs);
            ApplicationInfo ai = ps.pkg.applicationInfo;
            if (ai != null) {
                ai.nativeLibraryDir = BEnvironment.getAppLibDir(ps.pkg.packageName).getAbsolutePath();
                if (r.hasNativeCode() && Build.VERSION.SDK_INT >= 21) {
                    BRApplicationInfoL.get(ai)._set_primaryCpuAbi(r.abi);
                }
            }
            return 0;
        } catch (BundleException e) {
            // readable message, shown by the installer UI in a later part
            Slog.e(TAG, e.getMessage());
        } catch (IOException e) {
            Slog.e(TAG, "cannot install native libraries of " + ps.pkg.packageName, e);
        }
        FileUtils.deleteDir(BEnvironment.getAppDir(ps.pkg.packageName));
        return -1;
    }

    /**
     * A bundle is unpacked into a temp folder that is deleted after the install, so with splits
     * the base APK has to be copied too, whatever the storage flag says. Installs "by system"
     * keep pointing at the real files of the phone.
     */
    private static boolean needsOwnCopy(InstallOption option) {
        return option.hasSplits() && !option.isFlag(InstallOption.FLAG_SYSTEM);
    }

    /**
     * Copies every split into the app folder and saves the new paths in the package settings
     * (package, ApplicationInfo and the install option), so they are written to package.conf.
     * Installs by system keep the real split paths of the phone.
     */
    private static int copySplits(BPackageSettings ps, InstallOption option) {
        if (!option.hasSplits() || option.isFlag(InstallOption.FLAG_SYSTEM)) {
            return 0;
        }
        String[] sources = ps.pkg.splitCodePaths;
        String[] names = ps.pkg.splitNames;
        if (sources == null || names == null || sources.length != names.length || sources.length == 0) {
            Slog.e(TAG, "splits were requested but the parsed package has none: " + ps.pkg.packageName);
            return -1;
        }
        try {
            String[] copied = SplitFileCopier.copyAll(sources, names,
                    BEnvironment.getAppDir(ps.pkg.packageName), BEnvironment.getCacheDir());
            ps.pkg.splitCodePaths = copied;
            if (ps.pkg.applicationInfo != null) {
                ps.pkg.applicationInfo.splitSourceDirs = copied.clone();
                ps.pkg.applicationInfo.splitPublicSourceDirs = copied.clone();
                if (Build.VERSION.SDK_INT >= 21) {
                    BRApplicationInfoL.get(ps.pkg.applicationInfo)._set_splitNames(names.clone());
                }
            }
            option.withSplits(Arrays.asList(copied));
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            // do not leave a half installed app folder behind
            FileUtils.deleteDir(BEnvironment.getAppDir(ps.pkg.packageName));
            return -1;
        }
    }
}
