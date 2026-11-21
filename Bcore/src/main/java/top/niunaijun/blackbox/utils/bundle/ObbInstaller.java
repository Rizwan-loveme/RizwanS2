package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Puts the OBB files of an .xapk into the OBB folder of the app inside the box
 * (what the app sees as /sdcard/Android/obb/&lt;package&gt;/). Plain Java.
 *
 * <ul>
 *   <li>Every file goes through a {@code .part} file and is renamed at the end, so a game never
 *       finds a half copied OBB that looks complete.</li>
 *   <li>A file that is already there with the same size is kept (not copied again).</li>
 *   <li>A file is moved when the phone allows it (same storage), else copied and the source deleted.</li>
 *   <li>On any failure everything this call created is deleted again ({@link #delete}).</li>
 * </ul>
 */
public final class ObbInstaller {

    /** Free space that must stay free after a file is copied. */
    private static final long SPACE_MARGIN = 64L * 1024 * 1024;
    private static final int BUFFER_SIZE = 256 * 1024;
    private static final Pattern SAFE_NAME = Pattern.compile("[A-Za-z0-9][A-Za-z0-9._+\\- ]{0,200}");

    public interface Progress {
        void onProgress(long done, long total);
    }

    /** What {@link #copy} did, so the caller can undo it. */
    public static final class Result {
        /** Files that now exist in the destination (new, replaced or kept). */
        public final List<File> files = new ArrayList<>();
        /** Files this call wrote (new or replaced): these are deleted again on a rollback. */
        public final List<File> written = new ArrayList<>();
        /** True when the destination folder did not exist before. */
        public boolean createdDir;
        public File dir;
    }

    private ObbInstaller() {
    }

    /** A file name that is safe to create inside the OBB folder (no path, no dots-only name). */
    static boolean isSafeName(String name) {
        return name != null && SAFE_NAME.matcher(name).matches();
    }

    /**
     * Copies {@code obbs} into {@code destDir}.
     *
     * @throws BundleException with a message that can be shown; nothing is left behind then
     */
    public static Result copy(List<BundleInfo.ObbFile> obbs, File destDir, Progress progress) throws BundleException {
        Result result = new Result();
        result.dir = destDir;
        if (obbs == null || obbs.isEmpty()) {
            return result;
        }
        long total = 0;
        for (BundleInfo.ObbFile o : obbs) {
            total += o.file.length();
        }
        result.createdDir = !destDir.exists();
        if (!destDir.isDirectory() && !destDir.mkdirs()) {
            throw new BundleException("Could not copy the OBB files: cannot create the folder " + destDir);
        }
        long[] done = {0};
        try {
            for (BundleInfo.ObbFile o : obbs) {
                String name = o.name;
                if (!isSafeName(name)) {
                    throw new BundleException("Could not copy the OBB files: unsafe file name \"" + name + "\"");
                }
                File src = o.file;
                File target = new File(destDir, name);
                long size = src.length();
                if (target.isFile() && target.length() == size) {
                    // same file already there (a second space, or the same bundle again)
                    result.files.add(target);
                    done[0] += size;
                    report(progress, done[0], total);
                    continue;
                }
                File part = new File(destDir, name + ".part");
                part.delete();
                result.written.add(target);
                if (src.renameTo(part)) {
                    done[0] += size;
                } else {
                    copyFile(src, part, destDir, size, done, total, progress);
                }
                target.delete();
                if (!part.renameTo(target)) {
                    part.delete();
                    throw new BundleException("Could not copy the OBB file " + name + " (cannot rename the copy)");
                }
                src.delete();
                result.files.add(target);
                report(progress, done[0], total);
            }
            return result;
        } catch (BundleException e) {
            delete(result);
            throw e;
        } catch (IOException e) {
            delete(result);
            throw new BundleException("Could not copy the OBB files (" + e.getMessage() + ")", e);
        } catch (RuntimeException e) {
            delete(result);
            throw e;
        }
    }

    /** Undoes {@link #copy}: deletes what it wrote, and the folder when it created it and it is empty. */
    public static void delete(Result result) {
        if (result == null) {
            return;
        }
        for (File f : result.written) {
            f.delete();
            new File(f.getPath() + ".part").delete();
        }
        if (result.createdDir && result.dir != null) {
            String[] left = result.dir.list();
            if (left == null || left.length == 0) {
                result.dir.delete();
            }
        }
    }

    private static void copyFile(File src, File dst, File destDir, long size, long[] done, long total,
                                 Progress progress) throws IOException, BundleException {
        File probe = destDir;
        while (probe != null && !probe.exists()) {
            probe = probe.getParentFile();
        }
        if (probe != null && probe.getUsableSpace() < size + SPACE_MARGIN) {
            throw new BundleException(InstallErrors.MSG_OBB_NO_SPACE);
        }
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                long lastReported = -1;
                int n;
                while ((n = in.read(buf)) > 0) {
                    out.write(buf, 0, n);
                    done[0] += n;
                    if (done[0] - lastReported >= 1024 * 1024) {
                        lastReported = done[0];
                        report(progress, done[0], total);
                    }
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            dst.delete();
            if (probe != null && probe.getUsableSpace() < SPACE_MARGIN) {
                throw new BundleException(InstallErrors.MSG_OBB_NO_SPACE);
            }
            throw e;
        } finally {
            in.close();
        }
    }

    private static void report(Progress p, long done, long total) {
        if (p != null) {
            p.onProgress(done, total);
        }
    }
}
