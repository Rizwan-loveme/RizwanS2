package p046b.p058c;

import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.util.Collection;
import p046b.p059d.C0536a;
import p046b.p059d.C0543h;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3117bs;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.C3262u;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.p294a.C2602u;

/* compiled from: ZipUtils.java */
/* renamed from: b.c.j */
/* loaded from: classes.dex */
public class C0535j {

    /* renamed from: a */
    private static Collection<String> f3630a;

    /* renamed from: a */
    public static void m3961a(File file, File file2, File file3, Collection<String> collection, C0543h c0543h) {
        f3630a = collection;
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(file2));
        m19496a.m16215a(C3102bd.f18315aw);
        m3963a(file, m19496a, c0543h, file);
        if (file3 != null) {
            m3962a(file3, m19496a, file3.getPath().length() - 6, c0543h, file);
        }
        m19496a.close();
    }

    /* renamed from: a */
    private static void m3963a(File file, C3248b c3248b, C0543h c0543h, File file2) {
        m3962a(file, c3248b, file.getPath().length() + 1, c0543h, file2);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m3962a(File file, C3248b c3248b, int i, C0543h c0543h, File file2) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        String name;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file3 : listFiles) {
            if (file3.isFile()) {
                String m3966a = C0536a.m3966a(file, file3.getPath().substring(i));
                String m4002d = c0543h != null ? c0543h.m4002d(C0536a.m3967a(m3966a)) : (String) null;
                C2602u c2602u = m4002d != null ? new C2602u(C0536a.m3967a(m4002d)) : new C2602u(C0536a.m3967a(m3966a));
                if (!file3.getAbsolutePath().startsWith(file2.getAbsolutePath())) {
                    if (c0543h != null) {
                        name = c0543h.m4001c(c2602u.getName());
                        if (name == null) {
                            name = c2602u.getName();
                        }
                    } else {
                        name = c2602u.getName();
                    }
                    if (new File(file2, name).isFile()) {
                    }
                }
                c2602u.setTime(file3.lastModified());
                String str = C3262u.m19641b(file3.getName())[1];
                if (f3630a == null || !(f3630a.contains(str) || f3630a.contains(c2602u.getName()))) {
                    c2602u.setMethod(8);
                    c2602u.setCompressedSize(-1L);
                } else {
                    c2602u.setMethod(0);
                    c2602u.setSize(file3.length());
                    c2602u.setCompressedSize(file3.length());
                    c2602u.setCrc(C3117bs.m19055a(file3));
                }
                c3248b.mo16214a(c2602u);
                FileInputStream fileInputStream2 = (FileInputStream) null;
                BufferedInputStream bufferedInputStream2 = (BufferedInputStream) null;
                try {
                    byte[] bArr = new byte[C3249i.m19500a()];
                    fileInputStream = new FileInputStream(file3);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream, bArr.length);
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    c3248b.write(bArr, 0, read);
                                }
                            } catch (Exception e2) {
                                bufferedInputStream2 = bufferedInputStream;
                                bufferedInputStream = bufferedInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (bufferedInputStream == null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream2 = bufferedInputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                if (bufferedInputStream2 == null) {
                                    throw th;
                                }
                                try {
                                    bufferedInputStream2.close();
                                    throw th;
                                } catch (IOException e4) {
                                    throw th;
                                }
                            }
                        }
                        c3248b.flush();
                        c3248b.m16218b();
                    } catch (Exception e5) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e6) {
                    fileInputStream = fileInputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                    }
                }
                if (bufferedInputStream == null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e8) {
                    }
                }
            } else if (file3.isDirectory()) {
                m3962a(file3, c3248b, i, c0543h, file2);
            }
        }
    }
}
