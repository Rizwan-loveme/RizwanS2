package top.niunaijun.blackbox.utils.bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Reads three attributes from the root &lt;manifest&gt; tag of an APK: {@code split},
 * {@code configForSplit} and {@code isFeatureSplit}. That is all the split picker needs to know
 * what a split is for, and it is more reliable than the file name.
 *
 * <p>AndroidManifest.xml inside an APK is binary XML. This is a small reader for that format
 * (string pool + first start tag only), no Android classes needed.
 */
final class SplitManifestReader {

    /** What the manifest said. Fields are null / false when the attribute is missing. */
    static final class Result {
        String splitName;
        /** null = attribute missing (not a config split); "" = config split of the base. */
        String configForSplit;
        boolean isFeatureSplit;
    }

    private static final int CHUNK_XML = 0x0003;
    private static final int CHUNK_STRING_POOL = 0x0001;
    private static final int CHUNK_START_ELEMENT = 0x0102;

    private static final int TYPE_STRING = 0x03;
    private static final int TYPE_BOOLEAN = 0x12;

    private static final int MAX_MANIFEST_BYTES = 8 * 1024 * 1024;

    private SplitManifestReader() {
    }

    /** @return the attributes, or null when the manifest cannot be read (caller uses file names). */
    static Result read(File apk) {
        ZipFile zip = null;
        try {
            zip = new ZipFile(apk);
            ZipEntry entry = zip.getEntry("AndroidManifest.xml");
            if (entry == null) {
                return null;
            }
            InputStream in = zip.getInputStream(entry);
            try {
                return parse(readAll(in));
            } finally {
                in.close();
            }
        } catch (Exception e) {
            return null;
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private static byte[] readAll(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = in.read(buf)) > 0) {
            out.write(buf, 0, n);
            if (out.size() > MAX_MANIFEST_BYTES) {
                throw new IOException("manifest too big");
            }
        }
        return out.toByteArray();
    }

    /** Visible for tests. */
    static Result parse(byte[] data) {
        try {
            ByteBuffer b = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
            if ((b.getShort(0) & 0xFFFF) != CHUNK_XML) {
                return null;
            }
            int pos = b.getShort(2) & 0xFFFF;
            String[] strings = null;
            while (pos + 8 <= data.length) {
                int type = b.getShort(pos) & 0xFFFF;
                int headerSize = b.getShort(pos + 2) & 0xFFFF;
                int size = b.getInt(pos + 4);
                if (size < 8 || pos + size > data.length) {
                    return null;
                }
                if (type == CHUNK_STRING_POOL) {
                    strings = readStringPool(b, pos);
                } else if (type == CHUNK_START_ELEMENT) {
                    if (strings == null) {
                        return null;
                    }
                    return readRootElement(b, pos, headerSize, strings);
                }
                pos += size;
            }
        } catch (RuntimeException e) {
            // IndexOutOfBounds / BufferUnderflow on a damaged file
        }
        return null;
    }

    private static Result readRootElement(ByteBuffer b, int pos, int headerSize, String[] strings) {
        int body = pos + headerSize;
        int nameIdx = b.getInt(body + 4);
        if (!"manifest".equals(str(strings, nameIdx))) {
            return null;
        }
        int attrStart = b.getShort(body + 8) & 0xFFFF;
        int attrSize = b.getShort(body + 10) & 0xFFFF;
        int attrCount = b.getShort(body + 12) & 0xFFFF;
        if (attrSize < 20) {
            return null;
        }
        Result r = new Result();
        int a = body + attrStart;
        for (int i = 0; i < attrCount; i++, a += attrSize) {
            String name = str(strings, b.getInt(a + 4));
            if (name == null) {
                continue;
            }
            int raw = b.getInt(a + 8);
            int dataType = b.get(a + 15) & 0xFF;
            int data = b.getInt(a + 16);
            if (name.equals("split")) {
                r.splitName = value(strings, raw, dataType, data);
            } else if (name.equals("configForSplit")) {
                String v = value(strings, raw, dataType, data);
                r.configForSplit = v == null ? "" : v;
            } else if (name.equals("isFeatureSplit")) {
                r.isFeatureSplit = dataType == TYPE_BOOLEAN ? data != 0
                        : "true".equals(value(strings, raw, dataType, data));
            }
        }
        return r;
    }

    private static String value(String[] strings, int raw, int dataType, int data) {
        if (raw != -1) {
            return str(strings, raw);
        }
        if (dataType == TYPE_STRING) {
            return str(strings, data);
        }
        return null;
    }

    private static String str(String[] strings, int idx) {
        return idx >= 0 && idx < strings.length ? strings[idx] : null;
    }

    private static String[] readStringPool(ByteBuffer b, int pos) {
        int headerSize = b.getShort(pos + 2) & 0xFFFF;
        int count = b.getInt(pos + 8);
        int flags = b.getInt(pos + 16);
        int stringsStart = b.getInt(pos + 20);
        boolean utf8 = (flags & (1 << 8)) != 0;
        if (count < 0 || count > 1_000_000) {
            throw new IllegalArgumentException("bad string count");
        }
        String[] out = new String[count];
        int offsetsAt = pos + headerSize;
        for (int i = 0; i < count; i++) {
            int off = pos + stringsStart + b.getInt(offsetsAt + i * 4);
            out[i] = utf8 ? readUtf8(b, off) : readUtf16(b, off);
        }
        return out;
    }

    private static String readUtf16(ByteBuffer b, int off) {
        int len = b.getShort(off) & 0xFFFF;
        off += 2;
        if ((len & 0x8000) != 0) {
            len = ((len & 0x7FFF) << 16) | (b.getShort(off) & 0xFFFF);
            off += 2;
        }
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = (char) (b.getShort(off + i * 2) & 0xFFFF);
        }
        return new String(chars);
    }

    private static String readUtf8(ByteBuffer b, int off) {
        // first length: characters, second length: bytes. Both use 1 or 2 bytes.
        int c = b.get(off++) & 0xFF;
        if ((c & 0x80) != 0) {
            off++;
        }
        int len = b.get(off++) & 0xFF;
        if ((len & 0x80) != 0) {
            len = ((len & 0x7F) << 8) | (b.get(off++) & 0xFF);
        }
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[i] = b.get(off + i);
        }
        return new String(bytes, Charset.forName("UTF-8"));
    }
}
