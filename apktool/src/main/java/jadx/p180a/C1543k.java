package jadx.p180a;

import jadx.core.p203d.p205b.C1727d;
import jadx.core.p203d.p206c.C1732b;
import jadx.core.p203d.p206c.C1734d;
import jadx.core.p207e.C1754e;
import jadx.p180a.C1541i;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: ResourcesLoader.java */
/* renamed from: jadx.a.k */
/* loaded from: classes.dex */
public final class C1543k {

    /* renamed from: a */
    private static final InterfaceC2558b f9897a = C2568c.m15995a((Class<?>) C1543k.class);

    /* renamed from: b */
    private final C1536d f9898b;

    /* compiled from: ResourcesLoader.java */
    /* renamed from: jadx.a.k$a */
    public interface a {
        /* renamed from: a */
        C1754e mo11829a(long j, InputStream inputStream);
    }

    C1543k(C1536d c1536d) {
        this.f9898b = c1536d;
    }

    /* renamed from: a */
    List<C1541i> m11828a(List<C1732b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<C1732b> it = list.iterator();
        while (it.hasNext()) {
            m11825a(arrayList, it.next().m13245a());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C1754e m11824a(C1541i c1541i, a aVar) {
        Throwable th = null;
        try {
            C1541i.a m11819c = c1541i.m11819c();
            if (m11819c == null) {
                File file = new File(c1541i.m11816a());
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        C1754e mo11829a = aVar.mo11829a(file.length(), bufferedInputStream);
                        if (bufferedInputStream == null) {
                            return mo11829a;
                        }
                        bufferedInputStream.close();
                        return mo11829a;
                    } finally {
                    }
                } catch (Throwable th2) {
                    if (0 == 0) {
                        throw th2;
                    }
                    if (null != th2) {
                        th.addSuppressed(th2);
                    }
                    throw null;
                }
            } else {
                try {
                    ZipFile zipFile = new ZipFile(m11819c.m11820a());
                    try {
                        ZipEntry entry = zipFile.getEntry(m11819c.m11821b());
                        if (entry == null) {
                            throw new IOException("Zip entry not found: " + m11819c);
                        }
                        if (!C1734d.m13253b(entry)) {
                            if (zipFile != null) {
                                zipFile.close();
                            }
                            return null;
                        }
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(entry));
                            try {
                                C1754e mo11829a2 = aVar.mo11829a(entry.getSize(), bufferedInputStream2);
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (zipFile == null) {
                                    return mo11829a2;
                                }
                                zipFile.close();
                                return mo11829a2;
                            } catch (Throwable th3) {
                                th = th3;
                                if (bufferedInputStream2 == null) {
                                    throw th;
                                }
                                bufferedInputStream2.close();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            if (th == null) {
                                throw th4;
                            }
                            if (th != th4) {
                                th.addSuppressed(th4);
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (Throwable th5) {
                    if (th == null) {
                        throw th5;
                    }
                    if (th != th5) {
                        th.addSuppressed(th5);
                    }
                    throw th;
                }
            }
        } catch (Exception e2) {
            throw new C1727d("Error decode: " + c1541i.m11816a(), e2);
        }
        throw new C1727d("Error decode: " + c1541i.m11816a(), e2);
    }

    /* renamed from: a */
    private void m11825a(List<C1541i> list, File file) {
        if (file != null) {
            try {
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (C1734d.m13253b(nextElement)) {
                        m11826a(list, file, nextElement);
                    }
                }
                zipFile.close();
            } catch (Exception e2) {
                f9897a.mo15931a("Not a zip file: {}", file.getAbsolutePath());
                m11827b(list, file);
            }
        }
    }

    /* renamed from: b */
    private void m11827b(List<C1541i> list, File file) {
        String absolutePath = file.getAbsolutePath();
        C1541i m11815a = C1541i.m11815a(this.f9898b, absolutePath, EnumC1542j.m11822a(absolutePath));
        if (m11815a != null) {
            list.add(m11815a);
        }
    }

    /* renamed from: a */
    private void m11826a(List<C1541i> list, File file, ZipEntry zipEntry) {
        if (!zipEntry.isDirectory()) {
            String name = zipEntry.getName();
            C1541i m11815a = C1541i.m11815a(this.f9898b, name, EnumC1542j.m11822a(name));
            if (m11815a != null) {
                m11815a.m11817a(new C1541i.a(file, name));
                list.add(m11815a);
            }
        }
    }
}
