package com.winlator.xenvironment;

import android.content.Context;
import android.os.StatFs;

import androidx.appcompat.app.AppCompatActivity;

import com.winlator.MainActivity;
import com.winlator.R;
import com.winlator.SettingsFragment;
import com.winlator.container.Container;
import com.winlator.container.ContainerManager;
import com.winlator.contentdialog.ContentDialog;
import com.winlator.core.AppUtils;
import com.winlator.core.DownloadProgressDialog;
import com.winlator.core.FileUtils;
import com.winlator.core.PreloaderDialog;
import com.winlator.core.TarCompressorUtils;
import com.winlator.core.WinlatorLog;
import com.winlator.core.WineInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public abstract class RootFSInstaller {
    public static final byte LATEST_VERSION = 23; // TODO increment it on rootfs update
    public static final byte UPDATE_WINEPREFIX_VERSION = 16; // set it if main wine version change
    public static final String FILENAME = "rootfs.tzst";

    private static void resetContainerRFSVersions(Context context) {
        ContainerManager manager = new ContainerManager(context);
        for (Container container : manager.getContainers()) {
            String rfsVersion = container.getExtra("rfsVersion");
            String wineVersion = container.getWineVersion();
            if (!rfsVersion.isEmpty() && WineInfo.isMainWineVersion(wineVersion) && Short.parseShort(rfsVersion) <= UPDATE_WINEPREFIX_VERSION) {
                container.putExtra("wineprefixNeedsUpdate", "t");
            }

            container.putExtra("rfsVersion", null);
            container.saveData();
        }
    }

    /** Part 7: free space needed for the very first set-up (rootfs 0.4 GB unpacked + Wine + the first container) / for an update. */
    private static final long MIN_FREE_BYTES_FIRST_SETUP = 1536L * 1024 * 1024;
    private static final long MIN_FREE_BYTES_UPDATE = 700L * 1024 * 1024;

    public static void install(final MainActivity activity) {
        install(activity, false, null);
    }

    /**
     * Part 7: the one-time set-up with a two-step progress screen.
     * Step 1: unpack rootfs.tzst (percent, the paths are relocated while unpacking, see PathRelocator).
     * Step 2 (only when [createFirstContainer]): create the first container "Win11" (spinning ring).
     * [onDone] runs on the UI thread after a successful set-up. If something fails the user can retry.
     */
    public static void install(final MainActivity activity, final boolean createFirstContainer, final Runnable onDone) {
        AppUtils.keepScreenOn(activity);
        RootFS rootFS = RootFS.find(activity);
        final File rootDir = rootFS.getRootDir();

        long needed = rootFS.isValid() ? MIN_FREE_BYTES_UPDATE : MIN_FREE_BYTES_FIRST_SETUP;
        long freeBytes = getFreeBytes(activity);
        WinlatorLog.i("Setup", "install rootfs: free "+(freeBytes / (1024 * 1024))+" MB, needed "+(needed / (1024 * 1024))+" MB, first container "+createFirstContainer);
        if (freeBytes < needed) {
            WinlatorLog.w("Setup", "not enough free storage, set-up stopped");
            ContentDialog.alert(activity, R.string.not_enough_storage, null);
            return;
        }

        SettingsFragment.resetPreferenceVersions(activity);

        final DownloadProgressDialog dialog = new DownloadProgressDialog(activity);
        dialog.show(createFirstContainer ? R.string.installing_system_files_step : R.string.installing_system_files);
        if (createFirstContainer) dialog.setHint(R.string.setup_hint);
        Executors.newSingleThreadExecutor().execute(() -> {
            clearRootDir(rootDir);
            final long contentLength = TarCompressorUtils.getContentLength(TarCompressorUtils.Type.ZSTD, activity, FILENAME, rootDir);
            AtomicLong totalSizeRef = new AtomicLong();

            boolean success = TarCompressorUtils.extract(TarCompressorUtils.Type.ZSTD, activity, FILENAME, rootDir, (file, size) -> {
                if (size > 0) {
                    long totalSize = totalSizeRef.addAndGet(size);
                    final int progress = (int)(((float)totalSize / contentLength) * 100);
                    activity.runOnUiThread(() -> dialog.setProgress(progress));
                }
                return file;
            });

            if (success) {
                rootFS.createRFSVersionFile(LATEST_VERSION);
                resetContainerRFSVersions(activity);

                if (createFirstContainer) {
                    dialog.setText(R.string.creating_first_container_step);
                    dialog.setIndeterminate(true);
                    success = (new ContainerManager(activity)).ensureDefaultContainer() != null;
                    if (!success) AppUtils.showToast(activity, R.string.unable_to_create_first_container);
                }
            }
            else {
                WinlatorLog.e("Setup", "rootfs.tzst could not be unpacked", null);
                AppUtils.showToast(activity, R.string.unable_to_install_system_files);
            }
            if (success) WinlatorLog.i("Setup", "set-up finished");
            else WinlatorLog.e("Setup", "set-up failed (rootfs or first container)", null);

            dialog.closeOnUiThread();
            final boolean finished = success;
            activity.runOnUiThread(() -> {
                if (finished) {
                    if (onDone != null) onDone.run();
                }
                else ContentDialog.confirm(activity, R.string.setup_failed_retry, () -> install(activity, createFirstContainer, onDone));
            });
        });
    }

    private static long getFreeBytes(Context context) {
        try {
            return (new StatFs(context.getFilesDir().getPath())).getAvailableBytes();
        }
        catch (Exception e) {
            return Long.MAX_VALUE; // cannot measure: do not block the set-up
        }
    }

    /**
     * Part 7: install / update the rootfs when needed, and (when [needContainer]) make sure a first container exists,
     * for example because a .exe was started from the Win11 File Manager. [onDone] runs on the UI thread when everything is ready.
     */
    public static void setupIfNeeded(final MainActivity activity, final boolean needContainer, final Runnable onDone) {
        RootFS rootFS = RootFS.find(activity);
        if (!rootFS.isValid() || rootFS.getVersion() < LATEST_VERSION) {
            // a fresh set-up always ends with a first container; an update of a working rootfs only when one is needed
            install(activity, needContainer || !rootFS.isValid(), onDone);
        }
        else if (needContainer && (new ContainerManager(activity)).getContainers().isEmpty()) {
            final DownloadProgressDialog dialog = new DownloadProgressDialog(activity);
            dialog.show(R.string.creating_first_container_step);
            dialog.setIndeterminate(true);
            (new ContainerManager(activity)).ensureDefaultContainerAsync((container) -> {
                dialog.close();
                if (container != null) {
                    if (onDone != null) onDone.run();
                }
                else ContentDialog.confirm(activity, R.string.setup_failed_retry, () -> setupIfNeeded(activity, true, onDone));
            });
        }
        else if (onDone != null) onDone.run();
    }

    public static void installIfNeeded(final MainActivity activity) {
        setupIfNeeded(activity, false, null);
    }

    private static void clearOptDir(File optDir) {
        File[] files = optDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals("installed-wine")) continue;
                FileUtils.delete(file);
            }
        }
    }

    private static void clearRootDir(File rootDir) {
        if (rootDir.isDirectory()) {
            File[] files = rootDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String name = file.getName();
                        if (name.equals("home") || name.equals("opt")) {
                            if (name.equals("opt")) clearOptDir(file);
                            continue;
                        }
                    }
                    FileUtils.delete(file);
                }
            }
        }
        else rootDir.mkdirs();
    }

    public static void generateCompactContainerPattern(final AppCompatActivity activity) {
        AppUtils.keepScreenOn(activity);
        PreloaderDialog preloaderDialog = new PreloaderDialog(activity);
        preloaderDialog.show(R.string.loading);
        Executors.newSingleThreadExecutor().execute(() -> {
            File[] srcFiles, dstFiles;
            File rootDir = RootFS.find(activity).getRootDir();
            File wineSystem32Dir = new File(rootDir, "/opt/wine/lib/wine/x86_64-windows");
            File wineSysWoW64Dir = new File(rootDir, "/opt/wine/lib/wine/i386-windows");

            File containerPatternDir = new File(activity.getCacheDir(), "container_pattern");
            FileUtils.delete(containerPatternDir);
            TarCompressorUtils.extract(TarCompressorUtils.Type.ZSTD, activity, "container_pattern.tzst", containerPatternDir);

            File containerSystem32Dir = new File(containerPatternDir, ".wine/drive_c/windows/system32");
            File containerSysWoW64Dir = new File(containerPatternDir, ".wine/drive_c/windows/syswow64");

            dstFiles = containerSystem32Dir.listFiles();
            srcFiles = wineSystem32Dir.listFiles();

            ArrayList<String> system32Files = new ArrayList<>();
            ArrayList<String> syswow64Files = new ArrayList<>();

            for (File dstFile : dstFiles) {
                for (File srcFile : srcFiles) {
                    if (dstFile.getName().equals(srcFile.getName())) {
                        if (FileUtils.contentEquals(srcFile, dstFile)) system32Files.add(srcFile.getName());
                        break;
                    }
                }
            }

            dstFiles = containerSysWoW64Dir.listFiles();
            srcFiles = wineSysWoW64Dir.listFiles();

            for (File dstFile : dstFiles) {
                for (File srcFile : srcFiles) {
                    if (dstFile.getName().equals(srcFile.getName())) {
                        if (FileUtils.contentEquals(srcFile, dstFile)) syswow64Files.add(srcFile.getName());
                        break;
                    }
                }
            }

            try {
                JSONObject data = new JSONObject();

                JSONArray system32JSONArray = new JSONArray();
                for (String name : system32Files) {
                    FileUtils.delete(new File(containerSystem32Dir, name));
                    system32JSONArray.put(name);
                }
                data.put("system32", system32JSONArray);

                JSONArray syswow64JSONArray = new JSONArray();
                for (String name : syswow64Files) {
                    FileUtils.delete(new File(containerSysWoW64Dir, name));
                    syswow64JSONArray.put(name);
                }
                data.put("syswow64", syswow64JSONArray);

                FileUtils.writeString(new File(activity.getCacheDir(), "common_dlls.json"), data.toString());

                File outputFile = new File(activity.getCacheDir(), "container_pattern.tzst");
                FileUtils.delete(outputFile);
                TarCompressorUtils.compress(TarCompressorUtils.Type.ZSTD, new File(containerPatternDir, ".wine"), outputFile, 22);

                FileUtils.delete(containerPatternDir);
                preloaderDialog.closeOnUiThread();
            }
            catch (JSONException e) {}
        });
    }
}
