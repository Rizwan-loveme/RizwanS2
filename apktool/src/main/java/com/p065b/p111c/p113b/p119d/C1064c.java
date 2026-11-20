package com.p065b.p111c.p113b.p119d;

import android.widget.ExpandableListView;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p111c.p113b.p118c.C1054b;
import com.p065b.p111c.p120c.InterfaceC1067a;
import com.p065b.p111c.p120c.InterfaceC1069c;
import com.p065b.p111c.p121d.C1072a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.p209io.Closeable;
import java.p209io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: LocalFileRecord.java */
/* renamed from: com.b.c.b.d.c */
/* loaded from: classes.dex */
public class C1064c {

    /* renamed from: a */
    private static final ByteBuffer f6720a = ByteBuffer.allocate(0);

    /* renamed from: b */
    private final boolean f6721b;

    /* renamed from: c */
    private final long f6722c;

    /* renamed from: d */
    private final int f6723d;

    /* renamed from: e */
    private final ByteBuffer f6724e;

    /* renamed from: f */
    private final String f6725f;

    /* renamed from: g */
    private final int f6726g;

    /* renamed from: h */
    private final long f6727h;

    /* renamed from: i */
    private final long f6728i;

    /* renamed from: j */
    private final long f6729j;

    private C1064c(String str, int i, ByteBuffer byteBuffer, long j, long j2, int i2, long j3, boolean z, long j4) {
        this.f6725f = str;
        this.f6726g = i;
        this.f6724e = byteBuffer;
        this.f6728i = j;
        this.f6727h = j2;
        this.f6723d = i2;
        this.f6722c = j3;
        this.f6721b = z;
        this.f6729j = j4;
    }

    /* renamed from: d */
    public String m8887d() {
        return this.f6725f;
    }

    /* renamed from: b */
    public ByteBuffer m8884b() {
        return this.f6724e.capacity() > 0 ? this.f6724e.slice() : this.f6724e;
    }

    /* renamed from: c */
    public int m8886c() {
        return this.f6726g + 30;
    }

    /* renamed from: f */
    public long m8889f() {
        return this.f6728i;
    }

    /* renamed from: a */
    public int m8881a() {
        return this.f6723d;
    }

    /* renamed from: e */
    public long m8888e() {
        return this.f6727h;
    }

    /* renamed from: g */
    public boolean m8890g() {
        return this.f6721b;
    }

    /* renamed from: a */
    public static C1064c m8877a(InterfaceC1069c interfaceC1069c, C1062a c1062a, long j) {
        return m8878a(interfaceC1069c, c1062a, j, true, true);
    }

    /* renamed from: a */
    private static C1064c m8878a(InterfaceC1069c interfaceC1069c, C1062a c1062a, long j, boolean z, boolean z2) {
        long j2;
        String m8870h = c1062a.m8870h();
        int m8871i = c1062a.m8871i();
        int i = m8871i + 30;
        long m8869g = c1062a.m8869g();
        long j3 = i + m8869g;
        if (j3 > j) {
            throw new C1072a("Local File Header of " + m8870h + " extends beyond start of Central Directory. LFH end: " + j3 + ", CD start: " + j);
        }
        try {
            ByteBuffer mo8842a = interfaceC1069c.mo8842a(m8869g, i);
            mo8842a.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = mo8842a.getInt();
            if (i2 != 67324752) {
                throw new C1072a("Not a Local File Header record for entry " + m8870h + ". Signature: 0x" + Long.toHexString(i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL));
            }
            short s = mo8842a.getShort(6);
            boolean z3 = (s & 8) != 0;
            boolean z4 = (c1062a.m8866d() & 8) != 0;
            if (z3 != z4) {
                throw new C1072a("Data Descriptor presence mismatch between Local File Header and Central Directory for entry " + m8870h + ". LFH: " + z3 + ", CD: " + z4);
            }
            long m8865c = c1062a.m8865c();
            long m8861a = c1062a.m8861a();
            long m8873k = c1062a.m8873k();
            if (!z3) {
                long m8900b = AbstractC1065d.m8900b(mo8842a, 14);
                if (m8900b != m8865c) {
                    throw new C1072a("CRC-32 mismatch between Local File Header and Central Directory for entry " + m8870h + ". LFH: " + m8900b + ", CD: " + m8865c);
                }
                long m8900b2 = AbstractC1065d.m8900b(mo8842a, 18);
                if (m8900b2 != m8861a) {
                    throw new C1072a("Compressed size mismatch between Local File Header and Central Directory for entry " + m8870h + ". LFH: " + m8900b2 + ", CD: " + m8861a);
                }
                long m8900b3 = AbstractC1065d.m8900b(mo8842a, 22);
                if (m8900b3 != m8873k) {
                    throw new C1072a("Uncompressed size mismatch between Local File Header and Central Directory for entry " + m8870h + ". LFH: " + m8900b3 + ", CD: " + m8873k);
                }
            }
            int m8893a = AbstractC1065d.m8893a(mo8842a, 26);
            if (m8893a > m8871i) {
                throw new C1072a("Name mismatch between Local File Header and Central Directory for entry" + m8870h + ". LFH: " + m8893a + " bytes, CD: " + m8871i + " bytes");
            }
            String m8860a = C1062a.m8860a(mo8842a, 30, m8893a);
            if (!m8870h.equals(m8860a)) {
                throw new C1072a("Name mismatch between Local File Header and Central Directory. LFH: \"" + m8860a + "\", CD: \"" + m8870h + "\"");
            }
            int m8893a2 = AbstractC1065d.m8893a(mo8842a, 28);
            long j4 = m8893a2 + m8893a + 30 + m8869g;
            boolean z5 = c1062a.m8863b() != 0;
            if (!z5) {
                m8861a = m8873k;
            }
            long j5 = j4 + m8861a;
            if (j5 > j) {
                throw new C1072a("Local File Header data of " + m8870h + " overlaps with Central Directory. LFH data start: " + j4 + ", LFH data end: " + j5 + ", CD start: " + j);
            }
            ByteBuffer byteBuffer = f6720a;
            if (z && m8893a2 > 0) {
                byteBuffer = interfaceC1069c.mo8842a(m8893a + 30 + m8869g, m8893a2);
            }
            if (!z2 || (s & 8) == 0) {
                j2 = j5;
            } else {
                j2 = 12 + j5;
                if (j2 > j) {
                    throw new C1072a("Data Descriptor of " + m8870h + " overlaps with Central Directory. Data Descriptor end: " + j5 + ", CD start: " + j);
                }
                ByteBuffer mo8842a2 = interfaceC1069c.mo8842a(j5, 4);
                mo8842a2.order(ByteOrder.LITTLE_ENDIAN);
                if (mo8842a2.getInt() == 134695760) {
                    j2 += 4;
                    if (j2 > j) {
                        throw new C1072a("Data Descriptor of " + m8870h + " overlaps with Central Directory. Data Descriptor end: " + j5 + ", CD start: " + j);
                    }
                }
            }
            return new C1064c(m8870h, m8871i, byteBuffer, m8869g, j2 - m8869g, m8893a + 30 + m8893a2, m8861a, z5, m8873k);
        } catch (IOException e2) {
            throw new IOException("Failed to read Local File Header of " + m8870h, e2);
        }
    }

    /* renamed from: a */
    public long m8882a(InterfaceC1069c interfaceC1069c, InterfaceC1067a interfaceC1067a) {
        long m8888e = m8888e();
        interfaceC1069c.mo8844a(m8889f(), m8888e, interfaceC1067a);
        return m8888e;
    }

    /* renamed from: a */
    public long m8883a(InterfaceC1069c interfaceC1069c, ByteBuffer byteBuffer, InterfaceC1067a interfaceC1067a) {
        long m8889f = m8889f();
        int m8886c = m8886c();
        int remaining = byteBuffer.remaining();
        ByteBuffer allocate = ByteBuffer.allocate(m8886c + remaining);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        interfaceC1069c.mo8843a(m8889f, m8886c, allocate);
        allocate.put(byteBuffer.slice());
        allocate.flip();
        AbstractC1065d.m8897a(allocate, 28, remaining);
        long remaining2 = allocate.remaining();
        interfaceC1067a.mo8846a(allocate);
        long m8888e = m8888e() - this.f6723d;
        interfaceC1069c.mo8844a(this.f6723d + m8889f, m8888e, interfaceC1067a);
        return remaining2 + m8888e;
    }

    /* renamed from: a */
    public static long m8876a(String str, int i, int i2, byte[] bArr, long j, long j2, InterfaceC1067a interfaceC1067a) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 30);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(67324752);
        AbstractC1065d.m8904c(allocate, 20);
        allocate.putShort(AbstractC0667d.GP_FLAG_EFS);
        allocate.putShort((short) 8);
        AbstractC1065d.m8904c(allocate, i);
        AbstractC1065d.m8904c(allocate, i2);
        AbstractC1065d.m8899a(allocate, j);
        AbstractC1065d.m8899a(allocate, bArr.length);
        AbstractC1065d.m8899a(allocate, j2);
        AbstractC1065d.m8904c(allocate, bytes.length);
        AbstractC1065d.m8904c(allocate, 0);
        allocate.put(bytes);
        if (allocate.hasRemaining()) {
            throw new RuntimeException("pos: " + allocate.position() + ", limit: " + allocate.limit());
        }
        allocate.flip();
        long remaining = allocate.remaining();
        interfaceC1067a.mo8846a(allocate);
        long length = bArr.length;
        interfaceC1067a.mo8847a(bArr, 0, bArr.length);
        return length + remaining;
    }

    /* renamed from: b */
    public void m8885b(InterfaceC1069c interfaceC1069c, InterfaceC1067a interfaceC1067a) {
        long j = this.f6723d + this.f6728i;
        try {
            if (this.f6721b) {
                try {
                    a aVar = new a(interfaceC1067a, null);
                    interfaceC1069c.mo8844a(j, this.f6722c, aVar);
                    long m8892a = aVar.m8892a();
                    if (m8892a != this.f6729j) {
                        throw new C1072a("Unexpected size of uncompressed data of " + this.f6725f + ". Expected: " + this.f6729j + " bytes, actual: " + m8892a + " bytes");
                    }
                    aVar.close();
                    return;
                } catch (IOException e2) {
                    if (e2.getCause() instanceof DataFormatException) {
                        throw new C1072a("Data of entry " + this.f6725f + " malformed", e2);
                    }
                    throw e2;
                }
            }
            interfaceC1069c.mo8844a(j, this.f6722c, interfaceC1067a);
        } catch (IOException e3) {
            throw new IOException("Failed to read data of " + (this.f6721b ? "compressed" : "uncompressed") + " entry " + this.f6725f, e3);
        }
    }

    /* renamed from: a */
    public static void m8879a(InterfaceC1069c interfaceC1069c, C1062a c1062a, long j, InterfaceC1067a interfaceC1067a) {
        m8878a(interfaceC1069c, c1062a, j, false, false).m8885b(interfaceC1069c, interfaceC1067a);
    }

    /* renamed from: b */
    public static byte[] m8880b(InterfaceC1069c interfaceC1069c, C1062a c1062a, long j) {
        if (c1062a.m8873k() > 2147483647L) {
            throw new IOException(String.valueOf(c1062a.m8870h()) + " too large: " + c1062a.m8873k());
        }
        byte[] bArr = new byte[(int) c1062a.m8873k()];
        m8879a(interfaceC1069c, c1062a, j, new C1054b(ByteBuffer.wrap(bArr)));
        return bArr;
    }

    /* compiled from: LocalFileRecord.java */
    /* renamed from: com.b.c.b.d.c$a */
    private static class a implements InterfaceC1067a, Closeable {

        /* renamed from: a */
        private boolean f6730a;

        /* renamed from: b */
        private final InterfaceC1067a f6731b;

        /* renamed from: c */
        private Inflater f6732c;

        /* renamed from: d */
        private byte[] f6733d;

        /* renamed from: e */
        private byte[] f6734e;

        /* renamed from: f */
        private long f6735f;

        private a(InterfaceC1067a interfaceC1067a) {
            this.f6732c = new Inflater(true);
            this.f6731b = interfaceC1067a;
        }

        /* synthetic */ a(InterfaceC1067a interfaceC1067a, a aVar) {
            this(interfaceC1067a);
        }

        @Override // com.p065b.p111c.p120c.InterfaceC1067a
        /* renamed from: a */
        public void mo8847a(byte[] bArr, int i, int i2) {
            m8891b();
            this.f6732c.setInput(bArr, i, i2);
            if (this.f6734e == null) {
                this.f6734e = new byte[65536];
            }
            while (!this.f6732c.finished()) {
                try {
                    int inflate = this.f6732c.inflate(this.f6734e);
                    if (inflate != 0) {
                        this.f6731b.mo8847a(this.f6734e, 0, inflate);
                        this.f6735f = inflate + this.f6735f;
                    } else {
                        return;
                    }
                } catch (DataFormatException e2) {
                    throw new IOException("Failed to inflate data", e2);
                }
            }
        }

        @Override // com.p065b.p111c.p120c.InterfaceC1067a
        /* renamed from: a */
        public void mo8846a(ByteBuffer byteBuffer) {
            m8891b();
            if (byteBuffer.hasArray()) {
                mo8847a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            if (this.f6733d == null) {
                this.f6733d = new byte[65536];
            }
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(byteBuffer.remaining(), this.f6733d.length);
                byteBuffer.get(this.f6733d, 0, min);
                mo8847a(this.f6733d, 0, min);
            }
        }

        /* renamed from: a */
        public long m8892a() {
            return this.f6735f;
        }

        @Override // java.p209io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6730a = true;
            this.f6733d = null;
            this.f6734e = null;
            if (this.f6732c != null) {
                this.f6732c.end();
                this.f6732c = null;
            }
        }

        /* renamed from: b */
        private void m8891b() {
            if (this.f6730a) {
                throw new IllegalStateException("Closed");
            }
        }
    }
}
