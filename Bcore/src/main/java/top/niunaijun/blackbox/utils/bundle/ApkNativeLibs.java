package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Lists the native libraries ({@code lib/<abi>/<name>.so}) inside one APK and says whether each
 * of them can be loaded straight from the APK.
 *
 * <p>An app with {@code android:extractNativeLibs="false"} keeps its libraries uncompressed in the
 * APK and the linker maps them from there ({@code apk!/lib/<abi>}). That only works when the
 * entry is STORED and its data starts at a page boundary (4 KB, 16 KB on newer devices), so both
 * facts are read here. The data offset is not available from {@link ZipFile}, so the central
 * directory and the local file header are read directly. For zip64 files (or anything unusual) the
 * scan falls back to {@link ZipFile} and reports {@code mappable = false}: the caller then simply
 * extracts the library, which always works.
 */
public final class ApkNativeLibs {

    /** Alignment the linker needs for libraries mapped from an APK. 16 KB also satisfies 4 KB. */
    public static final int PAGE_ALIGNMENT = 16 * 1024;

    /** One library entry in an APK. */
    public static final class Lib {
        /** ABI folder name as written in the APK, for example {@code arm64-v8a}. */
        public final String abi;
        /** File name, for example {@code libmain.so}. Never contains a slash or "..". */
        public final String fileName;
        /** Full entry name, for example {@code lib/arm64-v8a/libmain.so}. */
        public final String entryName;
        /** True when the entry is stored without compression. */
        public final boolean stored;
        /** True when {@link #stored} and the data starts at a multiple of {@link #PAGE_ALIGNMENT}. */
        public final boolean mappable;

        Lib(String abi, String fileName, String entryName, boolean stored, boolean mappable) {
            this.abi = abi;
            this.fileName = fileName;
            this.entryName = entryName;
            this.stored = stored;
            this.mappable = mappable;
        }

        @Override
        public String toString() {
            return entryName + (mappable ? " (mappable)" : stored ? " (stored, not aligned)" : " (compressed)");
        }
    }

    private ApkNativeLibs() {
    }

    /**
     * Parses {@code lib/<abi>/<file>.so} (exactly that depth). Returns null for every other
     * entry name, including names with sub folders, "..", back slashes or empty parts, so a
     * crafted APK cannot write outside the library folder.
     */
    static String[] parseLibEntry(String entryName) {
        if (entryName == null || !entryName.startsWith("lib/") || entryName.indexOf('\\') >= 0) {
            return null;
        }
        String[] parts = entryName.split("/", -1);
        if (parts.length != 3) {
            return null;
        }
        String abi = parts[1];
        String file = parts[2];
        if (abi.isEmpty() || file.isEmpty() || abi.equals("..") || abi.equals(".") || file.equals("..")
                || file.equals(".") || !file.endsWith(".so")) {
            return null;
        }
        return new String[]{abi, file};
    }

    /** All native libraries of the APK, any ABI. Empty list when there are none. */
    public static List<Lib> scan(File apk) throws IOException {
        List<Lib> fast = null;
        try {
            fast = scanDirect(apk);
        } catch (IOException | RuntimeException ignored) {
            // zip64, damaged or unusual file: use the slower but tolerant way below
        }
        if (fast != null) {
            return fast;
        }
        return scanWithZipFile(apk);
    }

    private static List<Lib> scanWithZipFile(File apk) throws IOException {
        List<Lib> result = new ArrayList<>();
        ZipFile zip = new ZipFile(apk);
        try {
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry e = entries.nextElement();
                if (e.isDirectory()) {
                    continue;
                }
                String[] p = parseLibEntry(e.getName());
                if (p == null) {
                    continue;
                }
                result.add(new Lib(p[0], p[1], e.getName(), e.getMethod() == ZipEntry.STORED, false));
            }
        } finally {
            zip.close();
        }
        return result;
    }

    // ---------------------------------------------------------------- direct zip reading

    private static final int EOCD_SIG = 0x06054b50;
    private static final int CEN_SIG = 0x02014b50;
    private static final int LOC_SIG = 0x04034b50;

    /** Returns null when the file needs the fallback (zip64). */
    private static List<Lib> scanDirect(File apk) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(apk, "r");
        try {
            long length = raf.length();
            // end of central directory record: last 22 + up to 65535 bytes
            int tail = (int) Math.min(length, 22 + 65535);
            byte[] buf = new byte[tail];
            raf.seek(length - tail);
            raf.readFully(buf);
            int eocd = -1;
            for (int i = tail - 22; i >= 0; i--) {
                if (le32(buf, i) == EOCD_SIG) {
                    eocd = i;
                    break;
                }
            }
            if (eocd < 0) {
                throw new IOException("not a zip file: " + apk);
            }
            int count = le16(buf, eocd + 10);
            long cdSize = le32(buf, eocd + 12) & 0xFFFFFFFFL;
            long cdOffset = le32(buf, eocd + 16) & 0xFFFFFFFFL;
            if (count == 0xFFFF || cdSize == 0xFFFFFFFFL || cdOffset == 0xFFFFFFFFL) {
                return null; // zip64
            }
            if (cdOffset + cdSize > length) {
                throw new IOException("damaged central directory");
            }
            byte[] cd = new byte[(int) cdSize];
            raf.seek(cdOffset);
            raf.readFully(cd);

            List<Lib> result = new ArrayList<>();
            int pos = 0;
            for (int n = 0; n < count; n++) {
                if (pos + 46 > cd.length || le32(cd, pos) != CEN_SIG) {
                    throw new IOException("damaged central directory");
                }
                int method = le16(cd, pos + 10);
                long compSize = le32(cd, pos + 20) & 0xFFFFFFFFL;
                long size = le32(cd, pos + 24) & 0xFFFFFFFFL;
                int nameLen = le16(cd, pos + 28);
                int extraLen = le16(cd, pos + 30);
                int commentLen = le16(cd, pos + 32);
                long localOffset = le32(cd, pos + 42) & 0xFFFFFFFFL;
                if (pos + 46 + nameLen > cd.length) {
                    throw new IOException("damaged central directory");
                }
                String name = new String(cd, pos + 46, nameLen, "UTF-8");
                pos += 46 + nameLen + extraLen + commentLen;

                String[] p = parseLibEntry(name);
                if (p == null) {
                    continue;
                }
                if (compSize == 0xFFFFFFFFL || size == 0xFFFFFFFFL || localOffset == 0xFFFFFFFFL) {
                    return null; // zip64 entry
                }
                boolean stored = method == 0;
                boolean mappable = false;
                if (stored) {
                    mappable = (dataOffset(raf, localOffset, length) % PAGE_ALIGNMENT) == 0;
                }
                result.add(new Lib(p[0], p[1], name, stored, mappable));
            }
            return result;
        } finally {
            raf.close();
        }
    }

    private static long dataOffset(RandomAccessFile raf, long localOffset, long length) throws IOException {
        if (localOffset + 30 > length) {
            throw new IOException("damaged local header");
        }
        byte[] h = new byte[30];
        raf.seek(localOffset);
        raf.readFully(h);
        if (le32(h, 0) != LOC_SIG) {
            throw new IOException("damaged local header");
        }
        return localOffset + 30 + le16(h, 26) + le16(h, 28);
    }

    private static int le16(byte[] b, int o) {
        return (b[o] & 0xFF) | ((b[o + 1] & 0xFF) << 8);
    }

    private static int le32(byte[] b, int o) {
        return (b[o] & 0xFF) | ((b[o + 1] & 0xFF) << 8) | ((b[o + 2] & 0xFF) << 16) | ((b[o + 3] & 0xFF) << 24);
    }
}
