package jadx.core.p203d.p206c;

import java.io.File;
import java.util.zip.ZipEntry;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ZipSecurity.java */
/* renamed from: jadx.core.d.c.d */
/* loaded from: classes.dex */
public class C1734d {

    /* renamed from: a */
    private static final InterfaceC2558b f10589a = C2568c.m15995a((Class<?>) C1734d.class);

    private C1734d() {
    }

    /* renamed from: a */
    private static boolean m13250a(File file, File file2) {
        if (file2 == null) {
            return false;
        }
        if (file2.equals(file)) {
            return true;
        }
        return m13250a(file, file2.getParentFile());
    }

    /* renamed from: a */
    public static boolean m13251a(String str) {
        try {
            File canonicalFile = new File(".").getCanonicalFile();
            if (m13250a(canonicalFile, new File(canonicalFile, str).getCanonicalFile())) {
                return true;
            }
            f10589a.mo15946d("Path traversal attack detected, invalid name: {}", str);
            return false;
        } catch (Exception e2) {
            f10589a.mo15946d("Path traversal attack detected, invalid name: {}", str);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m13252a(ZipEntry zipEntry) {
        long compressedSize = zipEntry.getCompressedSize();
        long size = zipEntry.getSize();
        if (compressedSize < 0 || size < 0) {
            f10589a.mo15944c("Zip bomb attack detected, invalid sizes: compressed {}, uncompressed {}, name {}", Long.valueOf(compressedSize), Long.valueOf(size), zipEntry.getName());
            return true;
        }
        if (100 * compressedSize >= size) {
            return false;
        }
        f10589a.mo15944c("Zip bomb attack detected, invalid sizes: compressed {}, uncompressed {}, name {}", Long.valueOf(compressedSize), Long.valueOf(size), zipEntry.getName());
        return true;
    }

    /* renamed from: b */
    public static boolean m13253b(ZipEntry zipEntry) {
        return m13251a(zipEntry.getName()) && !m13252a(zipEntry);
    }
}
