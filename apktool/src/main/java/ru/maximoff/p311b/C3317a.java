package ru.maximoff.p311b;

import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.Enumeration;
import ru.maximoff.apktool.util.C3249i;
import ru.p294a.C2602u;
import ru.p294a.C2604w;
import ru.p294a.C2606y;

/* compiled from: ZipAligner.java */
/* renamed from: ru.maximoff.b.a */
/* loaded from: classes.dex */
public final class C3317a {
    /* renamed from: a */
    public static boolean m20052a(String str, String str2) {
        return m20053a(str, str2, 4, 4096);
    }

    /* renamed from: a */
    public static boolean m20053a(String str, String str2, int i, int i2) {
        return m20051a(new File(str), new File(str2), i, i2);
    }

    /* renamed from: a */
    public static boolean m20051a(File file, File file2, int i, int i2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        C2604w c2604w = (C2604w) null;
        C2606y c2606y = (C2606y) null;
        a aVar = (a) null;
        try {
            C2604w c2604w2 = new C2604w(file);
            try {
                a aVar2 = new a(new FileOutputStream(file2));
                try {
                    C2606y c2606y2 = new C2606y(aVar2);
                    try {
                        c2606y2.m16215a(true);
                        Enumeration<C2602u> m16163b = c2604w2.m16163b();
                        byte[] bArr = new byte[C3249i.m19500a()];
                        while (m16163b.hasMoreElements()) {
                            C2602u nextElement = m16163b.nextElement();
                            C2602u c2602u = new C2602u(nextElement.getName());
                            c2602u.setTime(nextElement.getTime());
                            c2602u.setMethod(nextElement.getMethod());
                            c2602u.setCrc(nextElement.getCrc());
                            if (nextElement.getMethod() == 0) {
                                c2602u.setSize(nextElement.getSize());
                                c2602u.setCompressedSize(nextElement.getSize());
                            } else {
                                c2602u.setCompressedSize(-1L);
                            }
                            String name = nextElement.getName();
                            int i3 = (name == null || !name.endsWith(".so")) ? i : i2;
                            if (i3 > 1) {
                                c2602u.setExtra(m20054a(aVar2.m20055a(), name != null ? name.getBytes("UTF-8").length : 0, i3));
                            }
                            c2606y2.mo16214a(c2602u);
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w2.m16160a(nextElement), bArr.length);
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                c2606y2.write(bArr, 0, read);
                            }
                            bufferedInputStream.close();
                            c2606y2.m16218b();
                        }
                        c2606y2.m16211a();
                        c2606y2.close();
                        c2604w2.close();
                        aVar2.close();
                        return true;
                    } catch (IOException e2) {
                        aVar = aVar2;
                        c2606y = c2606y2;
                        c2604w = c2604w2;
                        if (c2606y != null) {
                            try {
                                c2606y.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (c2604w != null) {
                            try {
                                c2604w.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.close();
                            } catch (Exception e5) {
                            }
                        }
                        return false;
                    }
                } catch (IOException e6) {
                    aVar = aVar2;
                    c2604w = c2604w2;
                }
            } catch (IOException e7) {
                c2604w = c2604w2;
            }
        } catch (IOException e8) {
        }
    }

    /* renamed from: a */
    private static byte[] m20054a(long j, int i, int i2) {
        int i3 = ((int) ((i2 - ((((30 + j) + i) + 6) % i2)) % i2)) + 2;
        byte[] bArr = new byte[i3 + 4];
        bArr[0] = Character.FINAL_QUOTE_PUNCTUATION;
        bArr[1] = -95;
        bArr[2] = (byte) (i3 & 255);
        bArr[3] = (byte) ((i3 >> 8) & 255);
        bArr[4] = (byte) (i2 & 255);
        bArr[5] = (byte) ((i2 >> 8) & 255);
        return bArr;
    }

    /* compiled from: ZipAligner.java */
    /* renamed from: ru.maximoff.b.a$a */
    private static class a extends OutputStream {

        /* renamed from: a */
        private final OutputStream f21286a;

        /* renamed from: b */
        private long f21287b = 0;

        a(OutputStream outputStream) {
            this.f21286a = outputStream;
        }

        @Override // java.p209io.OutputStream
        public void write(int i) {
            this.f21286a.write(i);
            this.f21287b++;
        }

        @Override // java.p209io.OutputStream
        public void write(byte[] bArr) {
            this.f21286a.write(bArr);
            this.f21287b += bArr.length;
        }

        @Override // java.p209io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f21286a.write(bArr, i, i2);
            this.f21287b += i2;
        }

        @Override // java.p209io.OutputStream, java.p209io.Flushable
        public void flush() {
            this.f21286a.flush();
        }

        @Override // java.p209io.OutputStream, java.p209io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f21286a.close();
        }

        /* renamed from: a */
        long m20055a() {
            return this.f21287b;
        }
    }
}
