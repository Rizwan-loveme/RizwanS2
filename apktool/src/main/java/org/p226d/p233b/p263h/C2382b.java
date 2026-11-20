package org.p226d.p233b.p263h;

import com.p129f.p130a.p135e.C1213a;
import java.p209io.EOFException;
import java.p209io.InputStream;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2158l;
import org.p226d.p233b.p244d.p246b.C2117a;
import org.p226d.p233b.p244d.p246b.C2119c;

/* compiled from: DexUtil.java */
/* renamed from: org.d.b.h.b */
/* loaded from: classes.dex */
public class C2382b {
    /* renamed from: a */
    public static int m15073a(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark");
        }
        inputStream.mark(44);
        byte[] bArr = new byte[44];
        try {
            try {
                C1213a.m10158a(inputStream, bArr);
                inputStream.reset();
                return m15074a(bArr, 0);
            } catch (EOFException e2) {
                throw new C2153g.b("File is too short");
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    /* renamed from: a */
    public static int m15074a(byte[] bArr, int i) {
        int m14657b = C2117a.m14657b(bArr, i);
        if (m14657b == -1) {
            StringBuilder sb = new StringBuilder("Not a valid dex magic value:");
            for (int i2 = 0; i2 < 8; i2++) {
                sb.append(String.format(" %02x", Byte.valueOf(bArr[i2])));
            }
            throw new C2153g.b(sb.toString());
        }
        if (!C2117a.m14660c(m14657b)) {
            throw new b(String.format("Dex version %03d is not supported", Integer.valueOf(m14657b)));
        }
        int m14659c = C2117a.m14659c(bArr, i);
        if (m14659c == 2018915346) {
            throw new b("Big endian dex files are not supported");
        }
        if (m14659c != 305419896) {
            throw new a(String.format("Invalid endian tag: 0x%x", Integer.valueOf(m14659c)));
        }
        return m14657b;
    }

    /* renamed from: b */
    public static void m15075b(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            throw new IllegalArgumentException("InputStream must support mark");
        }
        inputStream.mark(8);
        byte[] bArr = new byte[8];
        try {
            try {
                C1213a.m10158a(inputStream, bArr);
                inputStream.reset();
                m15076b(bArr, 0);
            } catch (EOFException e2) {
                throw new C2158l.a("File is too short");
            }
        } catch (Throwable th) {
            inputStream.reset();
            throw th;
        }
    }

    /* renamed from: b */
    public static void m15076b(byte[] bArr, int i) {
        int m14669b = C2119c.m14669b(bArr, i);
        if (m14669b == -1) {
            StringBuilder sb = new StringBuilder("Not a valid odex magic value:");
            for (int i2 = 0; i2 < 8; i2++) {
                sb.append(String.format(" %02x", Byte.valueOf(bArr[i2])));
            }
            throw new C2158l.a(sb.toString());
        }
        if (!C2119c.m14666a(m14669b)) {
            throw new b(String.format("Odex version %03d is not supported", Integer.valueOf(m14669b)));
        }
    }

    /* compiled from: DexUtil.java */
    /* renamed from: org.d.b.h.b$a */
    public static class a extends RuntimeException {
        public a() {
        }

        public a(String str) {
            super(str);
        }
    }

    /* compiled from: DexUtil.java */
    /* renamed from: org.d.b.h.b$b */
    public static class b extends RuntimeException {
        public b() {
        }

        public b(String str) {
            super(str);
        }
    }
}
