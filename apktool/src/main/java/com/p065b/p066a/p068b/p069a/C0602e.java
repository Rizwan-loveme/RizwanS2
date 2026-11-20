package com.p065b.p066a.p068b.p069a;

import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p067a.C0580b;
import com.p065b.p066a.p067a.C0582d;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0677b;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApkSigningBlockUtilsLite.java */
/* renamed from: com.b.a.b.a.e */
/* loaded from: classes.dex */
public class C0602e {
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();

    private C0602e() {
    }

    /* renamed from: a */
    public static C0610j m6028a(InterfaceC0671c interfaceC0671c, C0677b c0677b, int i) {
        try {
            C0582d.a m5785a = C0582d.m5785a(interfaceC0671c, c0677b);
            long m5789b = m5785a.m5789b();
            InterfaceC0671c m5788a = m5785a.m5788a();
            ByteBuffer mo6235a = m5788a.mo6235a(0L, (int) m5788a.mo6233a());
            mo6235a.order(ByteOrder.LITTLE_ENDIAN);
            return new C0610j(m6030a(mo6235a, i), m5789b, c0677b.m6355a(), c0677b.m6359e(), c0677b.m6358d());
        } catch (C0580b e2) {
            throw new C0611k(e2.getMessage(), e2);
        }
    }

    /* renamed from: a */
    public static ByteBuffer m6030a(ByteBuffer byteBuffer, int i) {
        m6033a(byteBuffer);
        ByteBuffer m6031a = m6031a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (m6031a.hasRemaining()) {
            i2++;
            if (m6031a.remaining() < 8) {
                throw new C0611k("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = m6031a.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new C0611k("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int position = m6031a.position();
            if (i3 > m6031a.remaining()) {
                throw new C0611k("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + m6031a.remaining());
            }
            if (m6031a.getInt() == i) {
                return m6036b(m6031a, i3 - 4);
            }
            m6031a.position(i3 + position);
        }
        throw new C0611k("No APK Signature Scheme block in APK Signing Block with ID: " + i);
    }

    /* renamed from: a */
    public static void m6033a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T extends C0606f> List<T> m6032a(List<T> list, int i, int i2, boolean z) {
        int m6085f;
        HashMap hashMap = new HashMap();
        int i3 = Integer.MAX_VALUE;
        for (T t : list) {
            EnumC0609i enumC0609i = t.f4181a;
            if (z) {
                m6085f = enumC0609i.m6083d();
            } else {
                m6085f = enumC0609i.m6085f();
            }
            if (m6085f <= i2) {
                int i4 = m6085f < i3 ? m6085f : i3;
                C0606f c0606f = (C0606f) hashMap.get(Integer.valueOf(m6085f));
                if (c0606f == null || m6027a(enumC0609i, c0606f.f4181a) > 0) {
                    hashMap.put(Integer.valueOf(m6085f), t);
                    i3 = i4;
                } else {
                    i3 = i4;
                }
            }
        }
        if (i < i3) {
            throw new C0608h("Minimum provided signature version " + i3 + " > minSdkVersion " + i);
        }
        if (hashMap.isEmpty()) {
            throw new C0608h("No supported signature");
        }
        ArrayList arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, new Comparator<C0606f>() { // from class: com.b.a.b.a.e.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0606f c0606f2, C0606f c0606f3) {
                return Integer.compare(c0606f2.f4181a.m6081b(), c0606f3.f4181a.m6081b());
            }
        });
        return arrayList;
    }

    /* renamed from: a */
    public static int m6027a(EnumC0609i enumC0609i, EnumC0609i enumC0609i2) {
        return m6026a(enumC0609i.m6080a(), enumC0609i2.m6080a());
    }

    /* renamed from: a */
    private static int m6026a(EnumC0607g enumC0607g, EnumC0607g enumC0607g2) {
        int i = AnonymousClass2.f4160x5cfc638a[enumC0607g.ordinal()];
        if (i == 1) {
            int i2 = AnonymousClass2.f4160x5cfc638a[enumC0607g2.ordinal()];
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown alg2: " + enumC0607g2);
        }
        if (i == 2) {
            int i3 = AnonymousClass2.f4160x5cfc638a[enumC0607g2.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return 0;
                }
                if (i3 != 3) {
                    throw new IllegalArgumentException("Unknown alg2: " + enumC0607g2);
                }
            }
            return 1;
        }
        if (i == 3) {
            int i4 = AnonymousClass2.f4160x5cfc638a[enumC0607g2.ordinal()];
            if (i4 == 1) {
                return 1;
            }
            if (i4 == 2) {
                return -1;
            }
            if (i4 == 3) {
                return 0;
            }
            throw new IllegalArgumentException("Unknown alg2: " + enumC0607g2);
        }
        throw new IllegalArgumentException("Unknown alg1: " + enumC0607g);
    }

    /* compiled from: ApkSigningBlockUtilsLite.java */
    /* renamed from: com.b.a.b.a.e$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm */
        static final int[] f4160x5cfc638a;

        static {
            int[] iArr = new int[EnumC0607g.values().length];
            f4160x5cfc638a = iArr;
            try {
                iArr[EnumC0607g.CHUNKED_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4160x5cfc638a[EnumC0607g.CHUNKED_SHA512.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4160x5cfc638a[EnumC0607g.VERITY_CHUNKED_SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: a */
    private static ByteBuffer m6031a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    /* renamed from: b */
    private static ByteBuffer m6036b(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    /* renamed from: a */
    public static String m6029a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            char[] cArr = HEX_DIGITS;
            sb.append(cArr[(b2 & 255) >>> 4]);
            sb.append(cArr[b2 & 15]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static ByteBuffer m6035b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new C0579a("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new C0579a("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return m6036b(byteBuffer, i);
    }

    /* renamed from: c */
    public static byte[] m6037c(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new C0579a("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new C0579a("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m6034a(List<C0652k<Integer, byte[]>> list) {
        int i;
        Iterator<C0652k<Integer, byte[]>> it = list.iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = it.next().m6252b().length + 12 + i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (C0652k<Integer, byte[]> c0652k : list) {
            byte[] m6252b = c0652k.m6252b();
            allocate.putInt(m6252b.length + 8);
            allocate.putInt(c0652k.m6251a().intValue());
            allocate.putInt(m6252b.length);
            allocate.put(m6252b);
        }
        return allocate.array();
    }
}
