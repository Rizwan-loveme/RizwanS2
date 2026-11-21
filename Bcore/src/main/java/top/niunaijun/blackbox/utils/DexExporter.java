package top.niunaijun.blackbox.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import top.niunaijun.blackbox.core.env.BEnvironment;

/**
 * Debug helper: zips every *.dex found in a guest app's virtual data dir and saves it to
 * Downloads/BlackBoxDebug/<pkg>-dex.zip. No root, no storage permission (uses MediaStore, API 29+).
 */
public final class DexExporter {
    private static final String TAG = "DexExporter";
    private static final AtomicBoolean RUNNING = new AtomicBoolean(false);

    private DexExporter() {
    }

    public static void exportAsync(final Context context, final String pkg, final int userId) {
        if (pkg == null || !RUNNING.compareAndSet(false, true)) return;
        final Context app = context.getApplicationContext();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msg;
                try {
                    msg = export(app, pkg, userId);
                } catch (Throwable t) {
                    Log.e(TAG, "export failed", t);
                    msg = "DEX export failed: " + t;
                } finally {
                    RUNNING.set(false);
                }
                final String m = msg;
                android.os.Handler h = new android.os.Handler(android.os.Looper.getMainLooper());
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(app, m, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }, "bb-dex-export").start();
    }

    private static String export(Context ctx, String pkg, int userId) throws Exception {
        File root = BEnvironment.getDataDir(pkg, userId);
        if (!root.isDirectory()) return "No data dir yet: " + root;
        if (Build.VERSION.SDK_INT < 29) return "Needs Android 10+";

        ContentResolver cr = ctx.getContentResolver();
        ContentValues v = new ContentValues();
        v.put(MediaStore.MediaColumns.DISPLAY_NAME, pkg + "-dex.zip");
        v.put(MediaStore.MediaColumns.MIME_TYPE, "application/zip");
        v.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS + "/BlackBoxDebug");
        Uri uri = cr.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, v);
        if (uri == null) return "MediaStore insert failed";

        int count = 0;
        OutputStream os = cr.openOutputStream(uri);
        if (os == null) return "Cannot open output";
        ZipOutputStream zos = new ZipOutputStream(os);
        try {
            count = addDexFiles(zos, root, root, 0);
        } finally {
            zos.close();
        }
        if (count == 0) {
            cr.delete(uri, null, null);
            return "No .dex files under " + root;
        }
        return "Saved " + count + " dex file(s): Downloads/BlackBoxDebug/" + pkg + "-dex.zip";
    }

    private static int addDexFiles(ZipOutputStream zos, File root, File dir, int depth) throws Exception {
        File[] list = dir.listFiles();
        if (list == null || depth > 6) return 0;
        int n = 0;
        byte[] buf = new byte[64 * 1024];
        for (File f : list) {
            if (f.isDirectory()) {
                n += addDexFiles(zos, root, f, depth + 1);
            } else if (f.getName().endsWith(".dex") || f.getName().endsWith(".odex") || f.getName().endsWith(".vdex")) {
                zos.putNextEntry(new ZipEntry(f.getAbsolutePath().substring(root.getAbsolutePath().length() + 1)));
                FileInputStream in = new FileInputStream(f);
                try {
                    int r;
                    while ((r = in.read(buf)) > 0) zos.write(buf, 0, r);
                } finally {
                    in.close();
                }
                zos.closeEntry();
                n++;
            }
        }
        return n;
    }
}
