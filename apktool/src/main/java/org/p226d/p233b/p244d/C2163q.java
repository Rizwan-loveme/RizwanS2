package org.p226d.p233b.p244d;

import com.p129f.p130a.p133c.C1156ai;
import com.p129f.p130a.p135e.C1213a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.p226d.p233b.C2359g;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2270k;
import org.p226d.p233b.p263h.C2382b;

/* compiled from: ZipDexContainer.java */
/* renamed from: org.d.b.d.q */
/* loaded from: classes.dex */
public class C2163q implements InterfaceC2270k<b> {

    /* renamed from: a */
    private final File f12111a;

    /* renamed from: b */
    private final C2359g f12112b;

    /* compiled from: ZipDexContainer.java */
    /* renamed from: org.d.b.d.q$a */
    public static class a extends RuntimeException {
    }

    public C2163q(File file, C2359g c2359g) {
        this.f12111a = file;
        this.f12112b = c2359g;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2270k
    /* renamed from: a */
    public List<String> mo14511a() {
        ArrayList m9909a = C1156ai.m9909a();
        ZipFile m14857c = m14857c();
        try {
            Enumeration<? extends ZipEntry> entries = m14857c.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (m14854a(m14857c, nextElement)) {
                    m9909a.add(nextElement.getName());
                }
            }
            return m9909a;
        } finally {
            m14857c.close();
        }
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2270k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b mo14513b(String str) {
        ZipFile m14857c = m14857c();
        try {
            ZipEntry entry = m14857c.getEntry(str);
            if (entry == null) {
                return null;
            }
            return m14855b(m14857c, entry);
        } finally {
            m14857c.close();
        }
    }

    /* renamed from: b */
    public boolean m14856b() {
        boolean z = false;
        AutoCloseable autoCloseable = null;
        try {
            ZipFile m14857c = m14857c();
            z = true;
            if (m14857c != null) {
                try {
                    m14857c.close();
                } catch (IOException e2) {
                }
            }
        } catch (IOException e3) {
            if (0 != 0) {
                try {
                    autoCloseable.close();
                } catch (IOException e4) {
                }
            }
        } catch (a e5) {
            if (0 != 0) {
                try {
                    autoCloseable.close();
                } catch (IOException e6) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    autoCloseable.close();
                } catch (IOException e7) {
                }
            }
            throw th;
        }
        return z;
    }

    /* compiled from: ZipDexContainer.java */
    /* renamed from: org.d.b.d.q$b */
    public class b extends C2153g implements InterfaceC2270k.a {

        /* renamed from: d */
        private final String f12114d;

        protected b(C2359g c2359g, byte[] bArr, String str) {
            super(c2359g, bArr, 0);
            this.f12114d = str;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2270k.a
        /* renamed from: f */
        public InterfaceC2270k mo14827f() {
            return C2163q.this;
        }
    }

    /* renamed from: a */
    protected boolean m14854a(ZipFile zipFile, ZipEntry zipEntry) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        try {
            C2382b.m15073a(bufferedInputStream);
            bufferedInputStream.close();
            return true;
        } catch (C2153g.b e2) {
            bufferedInputStream.close();
            return false;
        } catch (C2382b.a e3) {
            bufferedInputStream.close();
            return false;
        } catch (C2382b.b e4) {
            bufferedInputStream.close();
            return false;
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }

    /* renamed from: c */
    protected ZipFile m14857c() {
        try {
            return new ZipFile(this.f12111a);
        } catch (IOException e2) {
            throw new a();
        }
    }

    /* renamed from: b */
    protected b m14855b(ZipFile zipFile, ZipEntry zipEntry) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            return new b(this.f12112b, C1213a.m10161a(inputStream), zipEntry.getName());
        } finally {
            inputStream.close();
        }
    }
}
