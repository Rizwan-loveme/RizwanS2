package jadx.core.p203d.p206c;

import jadx.core.p203d.p205b.C1725b;
import jadx.core.p203d.p205b.C1729f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.p217b.p218a.p219a.C1887e;
import org.p226d.p233b.C2016c;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2264e;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: InputFile.java */
/* renamed from: jadx.core.d.c.b */
/* loaded from: classes.dex */
public class C1732b {

    /* renamed from: a */
    private static final InterfaceC2558b f10583a = C2568c.m15995a((Class<?>) C1732b.class);

    /* renamed from: b */
    private final File f10584b;

    /* renamed from: c */
    private final List<C1733c> f10585c = new ArrayList();

    /* renamed from: a */
    public static void m13241a(File file, List<C1732b> list, boolean... zArr) {
        C1732b c1732b = new C1732b(file);
        c1732b.m13243a(zArr[0]);
        list.add(c1732b);
    }

    private C1732b(File file) {
        if (!file.exists()) {
            throw new IOException("File not found: " + file.getAbsolutePath());
        }
        this.f10584b = file;
    }

    /* renamed from: a */
    private void m13243a(boolean z) {
        String name = this.f10584b.getName();
        if (name.endsWith(".dex")) {
            m13242a("", C2016c.m14453a(this.f10584b, C2359g.m15022a()));
            return;
        }
        if (C1731a.m13232d(this.f10584b) || C1731a.m13233e(this.f10584b)) {
            m13244a(".dex");
            return;
        }
        if (name.endsWith(".jar")) {
            if (!m13244a(".dex") && name.endsWith(".aar")) {
                m13244a(".jar");
                return;
            }
            return;
        }
        if (z) {
        } else {
            throw new C1725b("Unsupported input file format: " + this.f10584b);
        }
    }

    /* renamed from: a */
    private void m13242a(String str, InterfaceC2264e interfaceC2264e) {
        this.f10585c.add(new C1733c(this, str, interfaceC2264e));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a0 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m13244a(String str) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        int size;
        try {
            ZipFile zipFile = new ZipFile(this.f10584b);
            try {
                String str2 = "classes" + str;
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                int i = 0;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (C1734d.m13253b(nextElement)) {
                        String name = nextElement.getName();
                        try {
                            InputStream inputStream = zipFile.getInputStream(nextElement);
                            try {
                                if ((name.startsWith("classes") && name.endsWith(str)) || name.endsWith(str2)) {
                                    switch (str.hashCode()) {
                                        case 1469737:
                                            if (!str.equals(".dex")) {
                                                throw new C1729f("Unexpected extension in zip: " + str);
                                            }
                                            InterfaceC2264e m13240a = m13240a(name, inputStream);
                                            inputStream.close();
                                            if (m13240a != null) {
                                                m13242a(name, m13240a);
                                                size = i + 1;
                                                if (inputStream == null) {
                                                }
                                            }
                                            size = i;
                                            if (inputStream == null) {
                                            }
                                            break;
                                        default:
                                            throw new C1729f("Unexpected extension in zip: " + str);
                                    }
                                } else {
                                    if (name.equals("instant-run.zip") && str.equals(".dex")) {
                                        File m13227a = C1731a.m13227a("instant-run.zip");
                                        try {
                                            FileOutputStream fileOutputStream = new FileOutputStream(m13227a);
                                            try {
                                                C1887e.m13962a(inputStream, fileOutputStream);
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                C1732b c1732b = new C1732b(m13227a);
                                                c1732b.m13244a(str);
                                                List<C1733c> m13246b = c1732b.m13246b();
                                                if (!m13246b.isEmpty()) {
                                                    size = m13246b.size() + i;
                                                    this.f10585c.addAll(m13246b);
                                                    if (inputStream == null) {
                                                        inputStream.close();
                                                        i = size;
                                                    } else {
                                                        i = size;
                                                    }
                                                }
                                            } catch (Throwable th4) {
                                                th3 = th4;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        if (th3 == null) {
                                                            throw th;
                                                        }
                                                        if (th3 != th) {
                                                            th3.addSuppressed(th);
                                                        }
                                                        throw th3;
                                                    }
                                                }
                                                throw th3;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th3 = null;
                                        }
                                    }
                                    size = i;
                                    if (inputStream == null) {
                                    }
                                }
                            } catch (Throwable th7) {
                                th2 = th7;
                                if (inputStream == null) {
                                    throw th2;
                                }
                                try {
                                    inputStream.close();
                                    throw th2;
                                } catch (Throwable th8) {
                                    th = th8;
                                    if (th2 == null) {
                                        throw th;
                                    }
                                    if (th2 != th) {
                                        th2.addSuppressed(th);
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            th2 = null;
                        }
                    }
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                return i > 0;
            } catch (Throwable th10) {
                th = th10;
                if (zipFile == null) {
                    throw th;
                }
                try {
                    zipFile.close();
                    throw th;
                } catch (Throwable th11) {
                    th = th11;
                    if (th == null) {
                        throw th;
                    }
                    if (th != th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            }
        } catch (Throwable th12) {
            th = th12;
            th = null;
        }
    }

    /* renamed from: a */
    private InterfaceC2264e m13240a(String str, InputStream inputStream) {
        try {
            return new C2153g(C2359g.m15022a(), C1887e.m13984b(inputStream));
        } catch (Exception e2) {
            f10583a.mo15944c("Failed to load file: {}, error: {}", str, e2.getMessage(), e2);
            return null;
        }
    }

    /* renamed from: a */
    public File m13245a() {
        return this.f10584b;
    }

    /* renamed from: b */
    public List<C1733c> m13246b() {
        return this.f10585c;
    }

    public String toString() {
        return this.f10584b.getAbsolutePath();
    }
}
