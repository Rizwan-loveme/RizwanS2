package top.niunaijun.blackbox.utils.bundle;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.core.env.BEnvironment;
import top.niunaijun.blackbox.entity.pm.InstallResult;
import top.niunaijun.blackbox.utils.Slog;

/**
 * "Install from file": takes a chosen .apk / .apks / .xapk / .apkm and runs the whole way for a
 * screen: copy (only for a content:// uri), look inside, unpack, pick the splits, install, clean up.
 * Blocking, call it from a background thread. It never throws; every problem comes back in the
 * {@link Result} with a message that can be shown and a {@link InstallErrors.Kind}.
 *
 * <p>The temp files (the copy of the chosen file and the unpacked folder) are always deleted at the
 * end, also when the install failed. The file the user chose is never changed or deleted. When the
 * process was killed in the middle of an install, the next install (or {@link #cleanLeftovers()})
 * removes what was left, see {@link TempCleaner}.
 *
 * <p>OBB files of an .xapk are copied into the box's OBB folder of the chosen space
 * ({@code Android/obb/<package>/}, see {@link ObbInstaller}) <b>before</b> the app is installed. If the
 * copy or the install fails they are deleted again, so a failed install leaves no big files behind.
 */
public final class BundleInstaller {

    private static final String TAG = "BundleInstaller";
    private static final int BUFFER_SIZE = 64 * 1024;
    /** Free space that must stay free on top of what a bundle needs. */
    private static final long SPACE_MARGIN = 64L * 1024 * 1024;

    public enum Stage {
        /** Copying a content:// uri to a temp file. */
        COPYING,
        /** Unpacking the bundle. */
        UNPACKING,
        /** Looking inside the file and choosing the splits. */
        CHECKING,
        /** Copying the OBB files of an .xapk to the OBB folder of the box. */
        COPYING_OBB,
        /** The engine installs the app (no byte progress). */
        INSTALLING
    }

    public interface Listener {
        /** {@code total} is 0 when the size is not known; then show an indeterminate bar. */
        void onProgress(Stage stage, long done, long total);
    }

    /** Chooses the virtual space for the app. Return a negative number when there is none left. */
    public interface SpaceChooser {
        int spaceFor(String packageName);
    }

    public static final class Result {
        public boolean success;
        public String packageName;
        /** Space (user id) the app was installed into, -1 when it failed before that. */
        public int userId = -1;
        /** English text for the log or to show as it is. For a success: a short summary. */
        public String message;
        public InstallErrors.Kind kind = InstallErrors.Kind.UNKNOWN;
        public int splitCount;
        /** Number of OBB files that are in the OBB folder of the app now. */
        public int obbCount;
        public String format;

        static Result fail(InstallErrors.Kind kind, String message) {
            Result r = new Result();
            r.success = false;
            r.kind = kind;
            r.message = message;
            return r;
        }

        static Result fail(String message) {
            return fail(InstallErrors.classify(message), message);
        }
    }

    private BundleInstaller() {
    }

    /** Installs the file behind a content:// (or file://) uri. {@code size} may be 0 when unknown. */
    public static Result install(Context context, Uri uri, long size, SpaceChooser chooser, Listener listener) {
        File copy = null;
        enter();
        try {
            if (uri == null) {
                return Result.fail(InstallErrors.Kind.CANNOT_READ, InstallErrors.MSG_CANNOT_READ);
            }
            if ("file".equals(uri.getScheme()) && uri.getPath() != null) {
                return install(new File(uri.getPath()), chooser, listener);
            }
            File cache = BEnvironment.getCacheDir();
            if (!cache.isDirectory()) {
                cache.mkdirs();
            }
            // peak use: the copy and the unpacked files exist together for a moment
            if (size > 0 && cache.getUsableSpace() < size * 2 + SPACE_MARGIN) {
                return Result.fail(InstallErrors.Kind.NOT_ENOUGH_SPACE, InstallErrors.MSG_NOT_ENOUGH_SPACE);
            }
            copy = new File(cache, "install_" + UUID.randomUUID() + ".tmp");
            try {
                copyUri(context.getContentResolver(), uri, copy, size, listener);
            } catch (IOException e) {
                Slog.w(TAG, "copy failed: " + e);
                if (cache.getUsableSpace() < SPACE_MARGIN) {
                    return Result.fail(InstallErrors.Kind.NOT_ENOUGH_SPACE, InstallErrors.MSG_NOT_ENOUGH_SPACE);
                }
                return Result.fail(InstallErrors.Kind.CANNOT_READ,
                        InstallErrors.MSG_CANNOT_READ + " (" + e.getMessage() + ")");
            }
            return run(copy, true, chooser, listener);
        } catch (Throwable t) {
            Slog.w(TAG, "install failed: " + t);
            return Result.fail(messageOf(t));
        } finally {
            if (copy != null && copy.exists()) {
                copy.delete();
            }
            TempCleaner.end();
        }
    }

    /** Installs a file on storage. The file is read only, it stays where it is. */
    public static Result install(File file, SpaceChooser chooser, Listener listener) {
        enter();
        try {
            if (file == null || !file.isFile() || !file.canRead()) {
                return Result.fail(InstallErrors.Kind.CANNOT_READ, InstallErrors.MSG_CANNOT_READ);
            }
            return run(file, false, chooser, listener);
        } catch (Throwable t) {
            Slog.w(TAG, "install failed: " + t);
            return Result.fail(messageOf(t));
        } finally {
            TempCleaner.end();
        }
    }

    /**
     * Marks an install as running (so the leftover sweep leaves the temp files alone) and first
     * removes the leftovers of an earlier install that was killed half way. Never throws.
     */
    private static void enter() {
        try {
            TempCleaner.Report r = TempCleaner.sweepStale(BEnvironment.getCacheDir());
            if (r.deleted > 0) {
                Slog.d(TAG, "removed old temp files: " + r);
            }
        } catch (Throwable ignored) {
            // the sweep is a bonus, the install must go on
        }
        TempCleaner.begin();
    }

    /** Removes temp files left behind by an install that was killed. Safe to call at any time. */
    public static void cleanLeftovers() {
        try {
            TempCleaner.Report r = TempCleaner.sweepStale(BEnvironment.getCacheDir());
            if (r.deleted > 0) {
                Slog.d(TAG, "removed old temp files: " + r);
            }
        } catch (Throwable ignored) {
        }
    }

    // ------------------------------------------------------------------ the steps

    private static Result run(File source, boolean ownedTemp, SpaceChooser chooser, final Listener listener) {
        BundleInfo info = null;
        ObbInstaller.Result obb = null;
        boolean installed = false;
        try {
            progress(listener, Stage.CHECKING, 0, 0);
            FileKind.Kind kind = FileKind.sniff(source);
            switch (kind) {
                case NOT_ZIP:
                    return Result.fail(InstallErrors.Kind.BAD_FILE,
                            "This file is not a valid bundle (it is not a readable zip file): " + source.getName());
                case ZIP_WITHOUT_APK:
                    return Result.fail(InstallErrors.Kind.NO_APK,
                            "No APK files were found inside the bundle: " + source.getName());
                case APK:
                    return installPlainApk(source, ownedTemp, chooser, listener);
                default:
                    break;
            }

            // A bundle: the unpacked files need about as much space as the bundle itself.
            File cache = BEnvironment.getCacheDir();
            if (!cache.isDirectory()) {
                cache.mkdirs();
            }
            if (cache.getUsableSpace() < source.length() + SPACE_MARGIN) {
                return Result.fail(InstallErrors.Kind.NOT_ENOUGH_SPACE, InstallErrors.MSG_NOT_ENOUGH_SPACE);
            }

            progress(listener, Stage.UNPACKING, 0, 0);
            info = BundleUnpacker.unpack(source, new BundleUnpacker.Progress() {
                @Override
                public void onProgress(long done, long total) {
                    progress(listener, Stage.UNPACKING, done, total);
                }
            });
            if (ownedTemp) {
                source.delete(); // the unpacked files are enough, free the space at once
            }

            progress(listener, Stage.CHECKING, 0, 0);
            SplitPicker.Selection selection = SplitPicker.pick(info);
            selection.applyTo(info, true);

            String pkg = info.packageName;
            if (pkg == null || pkg.isEmpty()) {
                pkg = packageOf(info.baseApk);
            }
            if (pkg == null) {
                return Result.fail(InstallErrors.Kind.BROKEN_APK,
                        "getPackageArchiveInfo error. Please check whether the APK is normal.");
            }
            int space = chooser == null ? 0 : chooser.spaceFor(pkg);
            if (space < 0) {
                return Result.fail(InstallErrors.Kind.NO_FREE_SPACE_SLOT, InstallErrors.MSG_NO_FREE_SLOT);
            }

            // OBB first: when it fails nothing is installed yet, so there is nothing to undo but the files.
            if (info.hasObb()) {
                progress(listener, Stage.COPYING_OBB, 0, 0);
                obb = ObbInstaller.copy(info.obbFiles, BEnvironment.getExternalObbDir(pkg, space),
                        new ObbInstaller.Progress() {
                            @Override
                            public void onProgress(long done, long total) {
                                progress(listener, Stage.COPYING_OBB, done, total);
                            }
                        });
            }

            progress(listener, Stage.INSTALLING, 0, 0);
            InstallResult r = BlackBoxCore.get().installBundleAsUser(info.baseApk, info.getSplitPaths(), space);
            Result out = fromEngine(r, pkg, space);
            out.splitCount = info.splitApks.size();
            out.obbCount = obb == null ? 0 : obb.files.size();
            out.format = String.valueOf(info.format);
            installed = out.success;
            return out;
        } catch (BundleException e) {
            return Result.fail(e.getMessage());
        } catch (Throwable t) {
            Slog.w(TAG, "bundle install failed: " + t);
            return Result.fail(messageOf(t));
        } finally {
            if (!installed && obb != null) {
                ObbInstaller.delete(obb); // failed install: do not keep gigabytes of OBB for nothing
            }
            if (info != null) {
                info.cleanup();
            }
            if (ownedTemp && source.exists()) {
                source.delete();
            }
        }
    }

    private static Result installPlainApk(File apk, boolean ownedTemp, SpaceChooser chooser, Listener listener) {
        File renamed = null;
        try {
            File file = apk;
            if (ownedTemp) {
                // the parser likes a name that ends with .apk
                renamed = new File(apk.getParentFile(), "install_" + UUID.randomUUID() + ".apk");
                if (apk.renameTo(renamed)) {
                    file = renamed;
                } else {
                    renamed = null;
                }
            }
            String pkg = packageOf(file);
            if (pkg == null) {
                return Result.fail(InstallErrors.Kind.BROKEN_APK,
                        "getPackageArchiveInfo error. Please check whether the APK is normal.");
            }
            int space = chooser == null ? 0 : chooser.spaceFor(pkg);
            if (space < 0) {
                return Result.fail(InstallErrors.Kind.NO_FREE_SPACE_SLOT, InstallErrors.MSG_NO_FREE_SLOT);
            }
            progress(listener, Stage.INSTALLING, 0, 0);
            Result out = fromEngine(BlackBoxCore.get().installPackageAsUser(file, space), pkg, space);
            out.format = "APK";
            return out;
        } finally {
            if (renamed != null && renamed.exists()) {
                renamed.delete();
            }
        }
    }

    private static Result fromEngine(InstallResult r, String pkg, int space) {
        if (r == null) {
            return Result.fail("install apk error.");
        }
        if (!r.success) {
            return Result.fail(r.msg == null ? "install apk error." : r.msg);
        }
        Result out = new Result();
        out.success = true;
        out.packageName = r.packageName != null ? r.packageName : pkg;
        out.userId = space;
        out.kind = InstallErrors.Kind.UNKNOWN;
        out.message = "Installed " + out.packageName + " in space " + (space + 1);
        return out;
    }

    // ------------------------------------------------------------------ helpers

    private static String packageOf(File apk) {
        try {
            PackageInfo pi = BlackBoxCore.getPackageManager().getPackageArchiveInfo(apk.getAbsolutePath(), 0);
            return pi == null ? null : pi.packageName;
        } catch (Throwable t) {
            return null;
        }
    }

    private static void copyUri(ContentResolver resolver, Uri uri, File out, long size, Listener listener)
            throws IOException {
        InputStream in = resolver.openInputStream(uri);
        if (in == null) {
            throw new IOException("no stream");
        }
        try {
            OutputStream os = new FileOutputStream(out);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                long done = 0;
                long lastReported = -1;
                int n;
                progress(listener, Stage.COPYING, 0, size);
                while ((n = in.read(buf)) > 0) {
                    os.write(buf, 0, n);
                    done += n;
                    if (done - lastReported >= 256 * 1024) {
                        lastReported = done;
                        progress(listener, Stage.COPYING, done, size);
                    }
                }
                progress(listener, Stage.COPYING, done, size > 0 ? size : done);
            } finally {
                os.close();
            }
        } finally {
            in.close();
        }
    }

    private static void progress(Listener l, Stage stage, long done, long total) {
        if (l != null) {
            try {
                l.onProgress(stage, done, total);
            } catch (Throwable ignored) {
                // a broken screen must not break the install
            }
        }
    }

    private static String messageOf(Throwable t) {
        String m = t.getMessage();
        return t.getClass().getSimpleName() + (m == null ? "" : ": " + m);
    }
}
