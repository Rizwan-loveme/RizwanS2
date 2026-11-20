package jadx.core.p203d.p206c;

import com.p065b.p066a.p067a.AbstractC0581c;
import jadx.core.p203d.C1742k;
import jadx.core.p203d.p205b.C1729f;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.p217b.p218a.p219a.C1886d;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: FileUtils.java */
/* renamed from: jadx.core.d.c.a */
/* loaded from: classes.dex */
public class C1731a {

    /* renamed from: a */
    private static final InterfaceC2558b f10581a = C2568c.m15995a((Class<?>) C1731a.class);

    /* renamed from: b */
    private static final Object f10582b = new Object();

    private C1731a() {
    }

    /* renamed from: a */
    public static void m13229a(File file) {
        if (file != null) {
            m13230b(file.getParentFile());
        }
    }

    /* renamed from: b */
    public static void m13230b(File file) {
        if (file != null) {
            synchronized (f10582b) {
                if (!file.mkdirs() && !file.isDirectory()) {
                    throw new C1729f("Can't create directory " + file);
                }
            }
        }
    }

    /* renamed from: a */
    public static File m13227a(String str) {
        try {
            File createTempFile = File.createTempFile("jadx-tmp-", String.valueOf(System.nanoTime()) + "-" + str);
            createTempFile.deleteOnExit();
            return createTempFile;
        } catch (IOException e2) {
            throw new C1729f("Failed to create temp file with suffix: " + str);
        }
    }

    /* renamed from: c */
    public static File m13231c(File file) {
        File m13235g = m13235g(file);
        m13229a(m13235g);
        return m13235g;
    }

    /* renamed from: g */
    private static File m13235g(File file) {
        String str;
        String name = file.getName();
        if (name.length() > 128) {
            int indexOf = name.indexOf(46);
            int length = ((128 - name.length()) + indexOf) - 1;
            if (length <= 0) {
                str = name.substring(0, 127);
            } else {
                str = String.valueOf(name.substring(0, length)) + name.substring(indexOf);
            }
            return new File(file.getParentFile(), str);
        }
        return file;
    }

    /* renamed from: a */
    private static String m13228a(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = charArray[i2 >>> 4];
            cArr[(i * 2) + 1] = charArray[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: h */
    private static boolean m13236h(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[4];
            if (fileInputStream.read(bArr, 0, 4) == bArr.length && C1742k.m13287a(m13228a(bArr), "504b0304")) {
                return true;
            }
            fileInputStream.close();
            return false;
        } catch (Exception e2) {
            f10581a.mo15943c("Failed read zip file: {}", file.getAbsolutePath(), e2);
            return false;
        }
    }

    /* renamed from: i */
    private static List<String> m13237i(File file) {
        ArrayList arrayList = new ArrayList();
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                arrayList.add(entries.nextElement().getName());
            }
            zipFile.close();
        } catch (Exception e2) {
            f10581a.mo15943c("Error read zip file '{}'", file.getAbsolutePath(), e2);
        }
        return arrayList;
    }

    /* renamed from: d */
    public static boolean m13232d(File file) {
        if (!m13236h(file)) {
            return false;
        }
        List<String> m13237i = m13237i(file);
        return m13237i.contains(AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME) && m13237i.contains("classes.dex");
    }

    /* renamed from: e */
    public static boolean m13233e(File file) {
        if (!m13236h(file) || !m13238j(file)) {
            return false;
        }
        return m13237i(file).contains("classes.dex");
    }

    /* renamed from: j */
    private static boolean m13238j(File file) {
        try {
            ZipFile zipFile = new ZipFile(file);
            boolean hasMoreElements = zipFile.entries().hasMoreElements();
            zipFile.close();
            return hasMoreElements;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m13234f(File file) {
        if (file != null) {
            File file2 = new File(file, "CaseCheck");
            File file3 = new File(file, "casecheck");
            try {
                try {
                    m13230b(file);
                    if (file2.createNewFile()) {
                        boolean z = !file3.exists();
                        f10581a.mo15932a("Filesystem at {} is {}case-sensitive", file.getAbsolutePath(), z ? "" : "NOT ");
                        try {
                            m13239k(file2);
                            m13239k(file3);
                            return z;
                        } catch (Exception e2) {
                            return z;
                        }
                    }
                    f10581a.mo15931a("Failed to create file: {}", file2.getAbsolutePath());
                } catch (Exception e3) {
                    f10581a.mo15933a("Failed to detect filesystem case-sensitivity by file creation", (Throwable) e3);
                    try {
                        m13239k(file2);
                        m13239k(file3);
                    } catch (Exception e4) {
                    }
                }
            } finally {
                try {
                    m13239k(file2);
                    m13239k(file3);
                } catch (Exception e5) {
                }
            }
        }
        return C1886d.f11047c.m13961a();
    }

    /* renamed from: k */
    private static void m13239k(File file) {
        if (file.exists()) {
            file.delete();
        }
    }
}
