package com.p065b.p111c.p113b.p119d;

import android.widget.ExpandableListView;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p111c.p121d.C1072a;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

/* compiled from: CentralDirectoryRecord.java */
/* renamed from: com.b.c.b.d.a */
/* loaded from: classes.dex */
public class C1062a {

    /* renamed from: a */
    public static final Comparator<C1062a> f6708a = new a(null);

    /* renamed from: b */
    private final long f6709b;

    /* renamed from: c */
    private final short f6710c;

    /* renamed from: d */
    private final long f6711d;

    /* renamed from: e */
    private final ByteBuffer f6712e;

    /* renamed from: f */
    private final short f6713f;

    /* renamed from: g */
    private final int f6714g;

    /* renamed from: h */
    private final int f6715h;

    /* renamed from: i */
    private final long f6716i;

    /* renamed from: j */
    private final String f6717j;

    /* renamed from: k */
    private final int f6718k;

    /* renamed from: l */
    private final long f6719l;

    private C1062a(ByteBuffer byteBuffer, short s, short s2, int i, int i2, long j, long j2, long j3, long j4, String str, int i3) {
        this.f6712e = byteBuffer;
        this.f6713f = s;
        this.f6710c = s2;
        this.f6714g = i2;
        this.f6715h = i;
        this.f6711d = j;
        this.f6709b = j2;
        this.f6719l = j3;
        this.f6716i = j4;
        this.f6717j = str;
        this.f6718k = i3;
    }

    /* renamed from: j */
    public int m8872j() {
        return this.f6712e.remaining();
    }

    /* renamed from: h */
    public String m8870h() {
        return this.f6717j;
    }

    /* renamed from: i */
    public int m8871i() {
        return this.f6718k;
    }

    /* renamed from: d */
    public short m8866d() {
        return this.f6713f;
    }

    /* renamed from: b */
    public short m8863b() {
        return this.f6710c;
    }

    /* renamed from: f */
    public int m8868f() {
        return this.f6715h;
    }

    /* renamed from: e */
    public int m8867e() {
        return this.f6714g;
    }

    /* renamed from: c */
    public long m8865c() {
        return this.f6711d;
    }

    /* renamed from: a */
    public long m8861a() {
        return this.f6709b;
    }

    /* renamed from: k */
    public long m8873k() {
        return this.f6719l;
    }

    /* renamed from: g */
    public long m8869g() {
        return this.f6716i;
    }

    /* renamed from: a */
    public static C1062a m8859a(ByteBuffer byteBuffer) {
        AbstractC1065d.m8896a(byteBuffer);
        if (byteBuffer.remaining() < 46) {
            throw new C1072a("Input too short. Need at least: 46 bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        int position = byteBuffer.position();
        int i = byteBuffer.getInt();
        if (i != 33639248) {
            throw new C1072a("Not a Central Directory record. Signature: 0x" + Long.toHexString(i & ExpandableListView.PACKED_POSITION_VALUE_NULL));
        }
        byteBuffer.position(position + 8);
        short s = byteBuffer.getShort();
        short s2 = byteBuffer.getShort();
        int m8903c = AbstractC1065d.m8903c(byteBuffer);
        int m8903c2 = AbstractC1065d.m8903c(byteBuffer);
        long m8905d = AbstractC1065d.m8905d(byteBuffer);
        long m8905d2 = AbstractC1065d.m8905d(byteBuffer);
        long m8905d3 = AbstractC1065d.m8905d(byteBuffer);
        int m8903c3 = AbstractC1065d.m8903c(byteBuffer);
        int m8903c4 = AbstractC1065d.m8903c(byteBuffer);
        int m8903c5 = AbstractC1065d.m8903c(byteBuffer);
        byteBuffer.position(position + 42);
        long m8905d4 = AbstractC1065d.m8905d(byteBuffer);
        byteBuffer.position(position);
        int i2 = m8903c4 + m8903c3 + 46 + m8903c5;
        if (i2 > byteBuffer.remaining()) {
            throw new C1072a("Input too short. Need: " + i2 + " bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
        }
        String m8860a = m8860a(byteBuffer, position + 46, m8903c3);
        byteBuffer.position(position);
        int limit = byteBuffer.limit();
        int i3 = position + i2;
        try {
            byteBuffer.limit(i3);
            ByteBuffer slice = byteBuffer.slice();
            byteBuffer.limit(limit);
            byteBuffer.position(i3);
            return new C1062a(slice, s, s2, m8903c, m8903c2, m8905d, m8905d2, m8905d3, m8905d4, m8860a, m8903c3);
        } catch (Throwable th) {
            byteBuffer.limit(limit);
            throw th;
        }
    }

    /* renamed from: b */
    public void m8864b(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f6712e.slice());
    }

    /* renamed from: a */
    public C1062a m8862a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(this.f6712e.remaining());
        allocate.put(this.f6712e.slice());
        allocate.flip();
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        AbstractC1065d.m8898a(allocate, 42, j);
        return new C1062a(allocate, this.f6713f, this.f6710c, this.f6715h, this.f6714g, this.f6711d, this.f6709b, this.f6719l, j, this.f6717j, this.f6718k);
    }

    /* renamed from: a */
    public static C1062a m8858a(String str, int i, int i2, long j, long j2, long j3, long j4) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 46);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(33639248);
        AbstractC1065d.m8904c(allocate, 20);
        AbstractC1065d.m8904c(allocate, 20);
        allocate.putShort(AbstractC0667d.GP_FLAG_EFS);
        allocate.putShort((short) 8);
        AbstractC1065d.m8904c(allocate, i);
        AbstractC1065d.m8904c(allocate, i2);
        AbstractC1065d.m8899a(allocate, j);
        AbstractC1065d.m8899a(allocate, j2);
        AbstractC1065d.m8899a(allocate, j3);
        AbstractC1065d.m8904c(allocate, bytes.length);
        AbstractC1065d.m8904c(allocate, 0);
        AbstractC1065d.m8904c(allocate, 0);
        AbstractC1065d.m8904c(allocate, 0);
        AbstractC1065d.m8904c(allocate, 0);
        AbstractC1065d.m8899a(allocate, 0L);
        AbstractC1065d.m8899a(allocate, j4);
        allocate.put(bytes);
        if (allocate.hasRemaining()) {
            throw new RuntimeException("pos: " + allocate.position() + ", limit: " + allocate.limit());
        }
        allocate.flip();
        return new C1062a(allocate, AbstractC0667d.GP_FLAG_EFS, (short) 8, i, i2, j, j2, j3, j4, str, bytes.length);
    }

    /* renamed from: a */
    static String m8860a(ByteBuffer byteBuffer, int i, int i2) {
        byte[] bArr;
        int i3;
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i3 = byteBuffer.arrayOffset() + i;
        } else {
            bArr = new byte[i2];
            i3 = 0;
            int position = byteBuffer.position();
            try {
                byteBuffer.position(i);
                byteBuffer.get(bArr);
            } finally {
                byteBuffer.position(position);
            }
        }
        return new String(bArr, i3, i2, StandardCharsets.UTF_8);
    }

    /* compiled from: CentralDirectoryRecord.java */
    /* renamed from: com.b.c.b.d.a$a */
    private static class a implements Comparator<C1062a> {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1062a c1062a, C1062a c1062a2) {
            long m8869g = c1062a.m8869g();
            long m8869g2 = c1062a2.m8869g();
            if (m8869g > m8869g2) {
                return 1;
            }
            if (m8869g < m8869g2) {
                return -1;
            }
            return 0;
        }
    }
}
