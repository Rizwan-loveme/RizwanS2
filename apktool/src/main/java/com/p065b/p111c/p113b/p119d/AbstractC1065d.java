package com.p065b.p111c.p113b.p119d;

import android.widget.ExpandableListView;
import com.p065b.p111c.p113b.p118c.C1059g;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.ByteArrayOutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: ZipUtils.java */
/* renamed from: com.b.c.b.d.d */
/* loaded from: classes.dex */
public abstract class AbstractC1065d {
    /* renamed from: b */
    public static void m8902b(ByteBuffer byteBuffer, long j) {
        m8896a(byteBuffer);
        m8898a(byteBuffer, byteBuffer.position() + 16, j);
    }

    /* renamed from: e */
    public static long m8906e(ByteBuffer byteBuffer) {
        m8896a(byteBuffer);
        return m8900b(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: f */
    public static long m8907f(ByteBuffer byteBuffer) {
        m8896a(byteBuffer);
        return m8900b(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: g */
    public static int m8908g(ByteBuffer byteBuffer) {
        m8896a(byteBuffer);
        return m8893a(byteBuffer, byteBuffer.position() + 10);
    }

    /* renamed from: a */
    public static C1059g<ByteBuffer, Long> m8894a(InterfaceC1069c interfaceC1069c) {
        if (interfaceC1069c.mo8840a() < 22) {
            return null;
        }
        C1059g<ByteBuffer, Long> m8895a = m8895a(interfaceC1069c, 0);
        return m8895a == null ? m8895a(interfaceC1069c, 65535) : m8895a;
    }

    /* renamed from: a */
    private static C1059g<ByteBuffer, Long> m8895a(InterfaceC1069c interfaceC1069c, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        long mo8840a = interfaceC1069c.mo8840a();
        if (mo8840a < 22) {
            return null;
        }
        int min = ((int) Math.min(i, mo8840a - 22)) + 22;
        long j = mo8840a - min;
        ByteBuffer mo8842a = interfaceC1069c.mo8842a(j, min);
        mo8842a.order(ByteOrder.LITTLE_ENDIAN);
        int m8909h = m8909h(mo8842a);
        if (m8909h == -1) {
            return null;
        }
        mo8842a.position(m8909h);
        ByteBuffer slice = mo8842a.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return C1059g.m8851a(slice, Long.valueOf(j + m8909h));
    }

    /* renamed from: h */
    private static int m8909h(ByteBuffer byteBuffer) {
        m8896a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int min = Math.min(capacity - 22, 65535);
        for (int i = 0; i <= min; i++) {
            int i2 = (capacity - 22) - i;
            if (byteBuffer.getInt(i2) == 101010256 && m8893a(byteBuffer, i2 + 20) == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    static void m8896a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* renamed from: a */
    public static int m8893a(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    /* renamed from: c */
    public static int m8903c(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    /* renamed from: a */
    static void m8897a(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("uint16 value of out range: " + i2);
        }
        byteBuffer.putShort(i, (short) i2);
    }

    /* renamed from: a */
    static void m8898a(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt(i, (int) j);
    }

    /* renamed from: c */
    public static void m8904c(ByteBuffer byteBuffer, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("uint16 value of out range: " + i);
        }
        byteBuffer.putShort((short) i);
    }

    /* renamed from: b */
    static long m8900b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: d */
    static long m8905d(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: a */
    static void m8899a(ByteBuffer byteBuffer, long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt((int) j);
    }

    /* renamed from: b */
    public static a m8901b(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i;
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i = byteBuffer.arrayOffset() + byteBuffer.position();
            byteBuffer.position(byteBuffer.limit());
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i = 0;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, remaining);
        long value = crc32.getValue();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(9, true);
        deflater.setInput(bArr, i, remaining);
        deflater.finish();
        byte[] bArr2 = new byte[65536];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        return new a(remaining, value, byteArrayOutputStream.toByteArray());
    }

    /* compiled from: ZipUtils.java */
    /* renamed from: com.b.c.b.d.d$a */
    public static class a {

        /* renamed from: a */
        public final long f6736a;

        /* renamed from: b */
        public final int f6737b;

        /* renamed from: c */
        public final byte[] f6738c;

        public a(int i, long j, byte[] bArr) {
            this.f6737b = i;
            this.f6736a = j;
            this.f6738c = bArr;
        }
    }
}
