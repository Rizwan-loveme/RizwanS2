package com.p065b.p066a.p068b.p083i;

import android.widget.ExpandableListView;
import com.p065b.p066a.C0681h;
import com.p065b.p066a.p085d.C0676a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Comparator;

/* compiled from: CentralDirectoryRecord.java */
/* renamed from: com.b.a.b.i.a */
/* loaded from: classes.dex */
public class C0664a {
    public static final Comparator<C0664a> BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR = new a();
    private static final int GP_FLAGS_OFFSET = 8;
    private static final int HEADER_SIZE_BYTES = 46;
    private static final int LOCAL_FILE_HEADER_OFFSET_OFFSET = 42;
    private static final int NAME_OFFSET = 46;
    private static final int RECORD_SIGNATURE = 33639248;

    /* renamed from: a */
    private final long f4265a;

    /* renamed from: b */
    private final short f4266b;

    /* renamed from: c */
    private final long f4267c;

    /* renamed from: d */
    private final ByteBuffer f4268d;

    /* renamed from: e */
    private final short f4269e;

    /* renamed from: f */
    private final int f4270f;

    /* renamed from: g */
    private final int f4271g;

    /* renamed from: h */
    private final long f4272h;

    /* renamed from: i */
    private final String f4273i;

    /* renamed from: j */
    private final int f4274j;

    /* renamed from: k */
    private final long f4275k;

    private C0664a(ByteBuffer byteBuffer, short s, short s2, int i, int i2, long j, long j2, long j3, long j4, String str, int i3) {
        this.f4268d = byteBuffer;
        this.f4269e = s;
        this.f4266b = s2;
        this.f4270f = i2;
        this.f4271g = i;
        this.f4267c = j;
        this.f4265a = j2;
        this.f4275k = j3;
        this.f4272h = j4;
        this.f4273i = str;
        this.f4274j = i3;
    }

    /* renamed from: j */
    public int m6289j() {
        return this.f4268d.remaining();
    }

    /* renamed from: h */
    public String m6287h() {
        return this.f4273i;
    }

    /* renamed from: i */
    public int m6288i() {
        return this.f4274j;
    }

    /* renamed from: d */
    public short m6283d() {
        return this.f4269e;
    }

    /* renamed from: b */
    public short m6280b() {
        return this.f4266b;
    }

    /* renamed from: f */
    public int m6285f() {
        return this.f4271g;
    }

    /* renamed from: e */
    public int m6284e() {
        return this.f4270f;
    }

    /* renamed from: c */
    public long m6282c() {
        return this.f4267c;
    }

    /* renamed from: a */
    public long m6278a() {
        return this.f4265a;
    }

    /* renamed from: k */
    public long m6290k() {
        return this.f4275k;
    }

    /* renamed from: g */
    public long m6286g() {
        return this.f4272h;
    }

    /* renamed from: a */
    public static C0664a m6276a(ByteBuffer byteBuffer) {
        AbstractC0667d.m6315a(byteBuffer);
        if (byteBuffer.remaining() < 46) {
            throw new C0676a("Input too short. Need at least: 46 bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        int position = byteBuffer.position();
        int i = byteBuffer.getInt();
        if (i != RECORD_SIGNATURE) {
            throw new C0676a("Not a Central Directory record. Signature: 0x" + Long.toHexString(i & ExpandableListView.PACKED_POSITION_VALUE_NULL));
        }
        byteBuffer.position(position + 8);
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        int m6322c = AbstractC0667d.m6322c(byteBuffer);
        int m6322c2 = AbstractC0667d.m6322c(byteBuffer);
        long m6324d = AbstractC0667d.m6324d(byteBuffer);
        long m6324d2 = AbstractC0667d.m6324d(byteBuffer);
        long m6324d3 = AbstractC0667d.m6324d(byteBuffer);
        int m6322c3 = AbstractC0667d.m6322c(byteBuffer);
        int m6322c4 = AbstractC0667d.m6322c(byteBuffer);
        int m6322c5 = AbstractC0667d.m6322c(byteBuffer);
        byteBuffer.position(position + 42);
        long m6324d4 = AbstractC0667d.m6324d(byteBuffer);
        byteBuffer.position(position);
        int i2 = m6322c4 + m6322c3 + 46 + m6322c5;
        if (i2 > byteBuffer.remaining()) {
            throw new C0676a("Input too short. Need: " + i2 + " bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        String m6277a = m6277a(byteBuffer, position + 46, m6322c3);
        byteBuffer.position(position);
        int limit = byteBuffer.limit();
        int i3 = position + i2;
        try {
            byteBuffer.limit(i3);
            ByteBuffer slice = byteBuffer.slice();
            byteBuffer.limit(limit);
            byteBuffer.position(i3);
            return new C0664a(slice, s, s2, m6322c, m6322c2, m6324d, m6324d2, m6324d3, m6324d4, m6277a, m6322c3);
        } catch (Throwable th) {
            byteBuffer.limit(limit);
            throw th;
        }
    }

    /* renamed from: b */
    public void m6281b(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f4268d.slice());
    }

    /* renamed from: a */
    public C0664a m6279a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(this.f4268d.remaining());
        allocate.put(this.f4268d.slice());
        allocate.flip();
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        AbstractC0667d.m6317a(allocate, 42, j);
        return new C0664a(allocate, this.f4269e, this.f4266b, this.f4271g, this.f4270f, this.f4267c, this.f4265a, this.f4275k, j, this.f4273i, this.f4274j);
    }

    /* renamed from: a */
    public static C0664a m6275a(String str, int i, int i2, long j, long j2, long j3, long j4) {
        byte[] bytes = str.getBytes(C0681h.UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 46);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(RECORD_SIGNATURE);
        AbstractC0667d.m6323c(allocate, 20);
        AbstractC0667d.m6323c(allocate, 20);
        allocate.putShort(AbstractC0667d.GP_FLAG_EFS);
        allocate.putShort((short) 8);
        AbstractC0667d.m6323c(allocate, i);
        AbstractC0667d.m6323c(allocate, i2);
        AbstractC0667d.m6318a(allocate, j);
        AbstractC0667d.m6318a(allocate, j2);
        AbstractC0667d.m6318a(allocate, j3);
        AbstractC0667d.m6323c(allocate, bytes.length);
        AbstractC0667d.m6323c(allocate, 0);
        AbstractC0667d.m6323c(allocate, 0);
        AbstractC0667d.m6323c(allocate, 0);
        AbstractC0667d.m6323c(allocate, 0);
        AbstractC0667d.m6318a(allocate, 0L);
        AbstractC0667d.m6318a(allocate, j4);
        allocate.put(bytes);
        if (allocate.hasRemaining()) {
            throw new RuntimeException("pos: " + allocate.position() + ", limit: " + allocate.limit());
        }
        allocate.flip();
        return new C0664a(allocate, AbstractC0667d.GP_FLAG_EFS, (short) 8, i, i2, j, j2, j3, j4, str, bytes.length);
    }

    /* renamed from: a */
    static String m6277a(ByteBuffer byteBuffer, int i, int i2) {
        byte[] bArr;
        int i3;
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i3 = byteBuffer.arrayOffset() + i;
        } else {
            bArr = new byte[i2];
            int position = byteBuffer.position();
            try {
                byteBuffer.position(i);
                byteBuffer.get(bArr);
                byteBuffer.position(position);
                i3 = 0;
            } catch (Throwable th) {
                byteBuffer.position(position);
                throw th;
            }
        }
        return new String(bArr, i3, i2, C0681h.UTF_8);
    }

    /* compiled from: CentralDirectoryRecord.java */
    /* renamed from: com.b.a.b.i.a$a */
    private static class a implements Comparator<C0664a> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0664a c0664a, C0664a c0664a2) {
            long m6286g = c0664a.m6286g();
            long m6286g2 = c0664a2.m6286g();
            if (m6286g > m6286g2) {
                return 1;
            }
            return m6286g < m6286g2 ? -1 : 0;
        }
    }
}
