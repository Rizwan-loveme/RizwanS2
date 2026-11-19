package com.winlator.core;

import android.content.Context;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Winlator's root file system (rootfs.tzst, box64, vortek, gladio, ...) was built for the app id
 * "com.winlator": the path /data/data/com.winlator/files/rootfs is written inside binaries
 * (libc, ld.so.cache, RPATHs), config files and scripts (447 places in rootfs.tzst alone).
 * Win11 has another app id, and a longer one, so the path cannot simply be replaced.
 *
 * Trick used here: the root file system lives in /data/data/<package>/rootfs (without "files/"),
 * which is not longer than the original 36 bytes as long as the package name has 18 characters
 * or less ("com.srizwan.win11" = 17). The text is padded with extra '/' characters up to exactly
 * 36 bytes (a path with "//" is the same path), so every binary can be patched in place, byte for
 * byte, while it is extracted. See {@link PatchingOutputStream} and TarCompressorUtils.extract.
 */
public abstract class PathRelocator {
    public static final String OLD_ROOT = "/data/data/com.winlator/files/rootfs";
    public static final String OLD_APP_DIR = "/data/data/com.winlator";
    /** Used until init(Context) is called: Win11's own package name. */
    public static final String DEFAULT_PACKAGE = "com.srizwan.win11";

    private static volatile String packageName = DEFAULT_PACKAGE;

    public static void init(Context context) {
        if (context != null) packageName = context.getPackageName();
    }

    /** The data directory as a path of the form /data/data/&lt;package&gt; (valid for user 0). */
    public static String getAppDir() {
        return "/data/data/" + packageName;
    }

    public static File getRootDir() {
        return new File(getAppDir(), "rootfs");
    }

    public static String getInternalStorage() {
        return getAppDir() + "/storage";
    }

    /** The replacement for OLD_ROOT: same length, padded with '/'. */
    public static String getNewRoot() {
        String path = getAppDir() + "/rootfs";
        if (path.length() > OLD_ROOT.length()) {
            throw new IllegalStateException("Package name too long for the Winlator rootfs path: " + packageName);
        }
        StringBuilder sb = new StringBuilder(path);
        while (sb.length() < OLD_ROOT.length()) sb.append('/');
        return sb.toString();
    }

    public static String patchString(String value) {
        return value == null ? null : value.replace(OLD_ROOT, getNewRoot());
    }

    /** Replaces OLD_ROOT by the padded new root in everything written through it, across write() boundaries. */
    public static class PatchingOutputStream extends FilterOutputStream {
        private final byte[] oldBytes = OLD_ROOT.getBytes(StandardCharsets.US_ASCII);
        private final byte[] newBytes = getNewRoot().getBytes(StandardCharsets.US_ASCII);
        private final int[] skip = new int[256];
        private byte[] carry = new byte[0];

        public PatchingOutputStream(OutputStream out) {
            super(out);
            int m = oldBytes.length;
            for (int i = 0; i < 256; i++) skip[i] = m;
            for (int i = 0; i < m - 1; i++) skip[oldBytes[i] & 0xff] = m - 1 - i;
        }

        @Override
        public void write(int b) throws IOException {
            write(new byte[]{(byte)b}, 0, 1);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            if (len <= 0) return;
            int m = oldBytes.length;
            byte[] data = new byte[carry.length + len];
            System.arraycopy(carry, 0, data, 0, carry.length);
            System.arraycopy(b, off, data, carry.length, len);

            int i = 0, end = data.length;
            while (i <= end - m) {
                int j = m - 1;
                while (j >= 0 && data[i + j] == oldBytes[j]) j--;
                if (j < 0) {
                    System.arraycopy(newBytes, 0, data, i, m);
                    i += m;
                }
                else i += skip[data[i + m - 1] & 0xff];
            }

            // keep the last m-1 bytes: a match may continue in the next write
            int keep = Math.min(m - 1, end);
            out.write(data, 0, end - keep);
            carry = new byte[keep];
            System.arraycopy(data, end - keep, carry, 0, keep);
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void close() throws IOException {
            try {
                if (carry.length > 0) {
                    out.write(carry, 0, carry.length);
                    carry = new byte[0];
                }
                out.flush();
            }
            finally {
                out.close();
            }
        }
    }
}
