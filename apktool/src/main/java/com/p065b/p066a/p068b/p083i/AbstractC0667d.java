package com.p065b.p066a.p068b.p083i;

import android.widget.ExpandableListView;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0676a;
import com.p065b.p066a.p085d.C0677b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: ZipUtils.java */
/* renamed from: com.b.a.b.i.d */
/* loaded from: classes.dex */
public abstract class AbstractC0667d {
    public static final short COMPRESSION_METHOD_DEFLATED = 8;
    public static final short COMPRESSION_METHOD_STORED = 0;
    public static final short GP_FLAG_DATA_DESCRIPTOR_USED = 8;
    public static final short GP_FLAG_EFS = 2048;
    private static final int UINT16_MAX_VALUE = 65535;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_OFFSET = 16;
    private static final int ZIP_EOCD_CENTRAL_DIR_SIZE_FIELD_OFFSET = 12;
    private static final int ZIP_EOCD_CENTRAL_DIR_TOTAL_RECORD_COUNT_OFFSET = 10;
    private static final int ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET = 20;
    private static final int ZIP_EOCD_REC_MIN_SIZE = 22;
    private static final int ZIP_EOCD_REC_SIG = 101010256;

    private AbstractC0667d() {
    }

    /* renamed from: b */
    public static void m6321b(ByteBuffer byteBuffer, long j) {
        m6315a(byteBuffer);
        m6317a(byteBuffer, byteBuffer.position() + 16, j);
    }

    /* renamed from: h */
    public static void m6328h(ByteBuffer byteBuffer) {
        m6315a(byteBuffer);
        m6316a(byteBuffer, byteBuffer.position() + 20, byteBuffer.remaining() - 22);
    }

    /* renamed from: e */
    public static long m6325e(ByteBuffer byteBuffer) {
        m6315a(byteBuffer);
        return m6319b(byteBuffer, byteBuffer.position() + 16);
    }

    /* renamed from: f */
    public static long m6326f(ByteBuffer byteBuffer) {
        m6315a(byteBuffer);
        return m6319b(byteBuffer, byteBuffer.position() + 12);
    }

    /* renamed from: g */
    public static int m6327g(ByteBuffer byteBuffer) {
        m6315a(byteBuffer);
        return m6311a(byteBuffer, byteBuffer.position() + 10);
    }

    /* renamed from: a */
    public static C0652k<ByteBuffer, Long> m6312a(InterfaceC0671c interfaceC0671c) {
        if (interfaceC0671c.mo6233a() < 22) {
            return null;
        }
        C0652k<ByteBuffer, Long> m6313a = m6313a(interfaceC0671c, 0);
        return m6313a == null ? m6313a(interfaceC0671c, 65535) : m6313a;
    }

    /* renamed from: a */
    private static C0652k<ByteBuffer, Long> m6313a(InterfaceC0671c interfaceC0671c, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i);
        }
        long mo6233a = interfaceC0671c.mo6233a();
        if (mo6233a < 22) {
            return null;
        }
        int min = ((int) Math.min(i, mo6233a - 22)) + 22;
        long j = mo6233a - min;
        ByteBuffer mo6235a = interfaceC0671c.mo6235a(j, min);
        mo6235a.order(ByteOrder.LITTLE_ENDIAN);
        int m6329i = m6329i(mo6235a);
        if (m6329i == -1) {
            return null;
        }
        mo6235a.position(m6329i);
        ByteBuffer slice = mo6235a.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return C0652k.m6250a(slice, Long.valueOf(j + m6329i));
    }

    /* renamed from: i */
    private static int m6329i(ByteBuffer byteBuffer) {
        m6315a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i = capacity - 22;
        int min = Math.min(i, 65535);
        for (int i2 = 0; i2 <= min; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == ZIP_EOCD_REC_SIG && m6311a(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: a */
    static void m6315a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* renamed from: a */
    public static int m6311a(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    /* renamed from: c */
    public static int m6322c(ByteBuffer byteBuffer) {
        return byteBuffer.getShort() & 65535;
    }

    /* renamed from: a */
    public static List<C0664a> m6314a(InterfaceC0671c interfaceC0671c, C0677b c0677b) {
        long m6357c = c0677b.m6357c();
        if (m6357c > 2147483647L) {
            throw new C0579a("ZIP Central Directory too large: " + m6357c);
        }
        long m6355a = c0677b.m6355a();
        ByteBuffer mo6235a = interfaceC0671c.mo6235a(m6355a, (int) m6357c);
        mo6235a.order(ByteOrder.LITTLE_ENDIAN);
        int m6356b = c0677b.m6356b();
        ArrayList arrayList = new ArrayList(m6356b);
        for (int i = 0; i < m6356b; i++) {
            int position = mo6235a.position();
            try {
                C0664a m6276a = C0664a.m6276a(mo6235a);
                if (!m6276a.m6287h().endsWith("/")) {
                    arrayList.add(m6276a);
                }
            } catch (C0676a e2) {
                throw new C0579a("Malformed ZIP Central Directory record #" + (i + 1) + " at file offset " + (m6355a + position), e2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static void m6316a(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("uint16 value of out range: " + i2);
        }
        byteBuffer.putShort(i, (short) i2);
    }

    /* renamed from: a */
    static void m6317a(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt(i, (int) j);
    }

    /* renamed from: c */
    public static void m6323c(ByteBuffer byteBuffer, int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("uint16 value of out range: " + i);
        }
        byteBuffer.putShort((short) i);
    }

    /* renamed from: b */
    static long m6319b(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getInt(i) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: d */
    static long m6324d(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: a */
    static void m6318a(ByteBuffer byteBuffer, long j) {
        if (j < 0 || j > ExpandableListView.PACKED_POSITION_VALUE_NULL) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt((int) j);
    }

    /* renamed from: b */
    public static a m6320b(ByteBuffer byteBuffer) {
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
    /* renamed from: com.b.a.b.i.d$a */
    public static class a {

        /* renamed from: a */
        public final long f4291a;

        /* renamed from: b */
        public final int f4292b;

        /* renamed from: c */
        public final byte[] f4293c;

        public a(int i, long j, byte[] bArr) {
            this.f4292b = i;
            this.f4291a = j;
            this.f4293c = bArr;
        }
    }
}
