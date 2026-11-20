package com.p065b.p066a.p068b.p083i;

import android.widget.ExpandableListView;
import com.p065b.p066a.C0681h;
import com.p065b.p066a.p068b.p081g.C0643b;
import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0676a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: LocalFileRecord.java */
/* renamed from: com.b.a.b.i.c */
/* loaded from: classes.dex */
public class C0666c {
    private static final int COMPRESSED_SIZE_OFFSET = 18;
    private static final int CRC32_OFFSET = 14;
    private static final int DATA_DESCRIPTOR_SIGNATURE = 134695760;
    private static final int DATA_DESCRIPTOR_SIZE_BYTES_WITHOUT_SIGNATURE = 12;
    private static final ByteBuffer EMPTY_BYTE_BUFFER = ByteBuffer.allocate(0);
    private static final int EXTRA_LENGTH_OFFSET = 28;
    private static final int GP_FLAGS_OFFSET = 6;
    private static final int HEADER_SIZE_BYTES = 30;
    private static final int NAME_LENGTH_OFFSET = 26;
    private static final int NAME_OFFSET = 30;
    private static final int RECORD_SIGNATURE = 67324752;
    private static final int UNCOMPRESSED_SIZE_OFFSET = 22;

    /* renamed from: a */
    private final boolean f4276a;

    /* renamed from: b */
    private final long f4277b;

    /* renamed from: c */
    private final int f4278c;

    /* renamed from: d */
    private final ByteBuffer f4279d;

    /* renamed from: e */
    private final String f4280e;

    /* renamed from: f */
    private final int f4281f;

    /* renamed from: g */
    private final long f4282g;

    /* renamed from: h */
    private final long f4283h;

    /* renamed from: i */
    private final long f4284i;

    private C0666c(String str, int i, ByteBuffer byteBuffer, long j, long j2, int i2, long j3, boolean z, long j4) {
        this.f4280e = str;
        this.f4281f = i;
        this.f4279d = byteBuffer;
        this.f4283h = j;
        this.f4282g = j2;
        this.f4278c = i2;
        this.f4277b = j3;
        this.f4276a = z;
        this.f4284i = j4;
    }

    /* renamed from: d */
    public String m6305d() {
        return this.f4280e;
    }

    /* renamed from: b */
    public ByteBuffer m6302b() {
        return this.f4279d.capacity() > 0 ? this.f4279d.slice() : this.f4279d;
    }

    /* renamed from: c */
    public int m6304c() {
        return this.f4281f + 30;
    }

    /* renamed from: f */
    public long m6307f() {
        return this.f4283h;
    }

    /* renamed from: a */
    public int m6299a() {
        return this.f4278c;
    }

    /* renamed from: e */
    public long m6306e() {
        return this.f4282g;
    }

    /* renamed from: g */
    public boolean m6308g() {
        return this.f4276a;
    }

    /* renamed from: a */
    public static C0666c m6295a(InterfaceC0671c interfaceC0671c, C0664a c0664a, long j) {
        return m6296a(interfaceC0671c, c0664a, j, true, true);
    }

    /* renamed from: a */
    private static C0666c m6296a(InterfaceC0671c interfaceC0671c, C0664a c0664a, long j, boolean z, boolean z2) {
        long j2;
        String m6287h = c0664a.m6287h();
        int m6288i = c0664a.m6288i();
        int i = m6288i + 30;
        long m6286g = c0664a.m6286g();
        long j3 = i + m6286g;
        if (j3 > j) {
            throw new C0676a("Local File Header of " + m6287h + " extends beyond start of Central Directory. LFH end: " + j3 + ", CD start: " + j);
        }
        try {
            ByteBuffer mo6235a = interfaceC0671c.mo6235a(m6286g, i);
            mo6235a.order(ByteOrder.LITTLE_ENDIAN);
            int i2 = mo6235a.getInt();
            if (i2 != RECORD_SIGNATURE) {
                throw new C0676a("Not a Local File Header record for entry " + m6287h + ". Signature: 0x" + Long.toHexString(i2 & ExpandableListView.PACKED_POSITION_VALUE_NULL));
            }
            int i3 = mo6235a.getShort(6) & 8;
            boolean z3 = i3 != 0;
            boolean z4 = (c0664a.m6283d() & 8) != 0;
            if (z3 != z4) {
                throw new C0676a("Data Descriptor presence mismatch between Local File Header and Central Directory for entry " + m6287h + ". LFH: " + z3 + ", CD: " + z4);
            }
            long m6282c = c0664a.m6282c();
            long m6278a = c0664a.m6278a();
            long m6290k = c0664a.m6290k();
            if (!z3) {
                long m6319b = AbstractC0667d.m6319b(mo6235a, 14);
                if (m6319b != m6282c) {
                    throw new C0676a("CRC-32 mismatch between Local File Header and Central Directory for entry " + m6287h + ". LFH: " + m6319b + ", CD: " + m6282c);
                }
                long m6319b2 = AbstractC0667d.m6319b(mo6235a, 18);
                if (m6319b2 != m6278a) {
                    throw new C0676a("Compressed size mismatch between Local File Header and Central Directory for entry " + m6287h + ". LFH: " + m6319b2 + ", CD: " + m6278a);
                }
                long m6319b3 = AbstractC0667d.m6319b(mo6235a, 22);
                if (m6319b3 != m6290k) {
                    throw new C0676a("Uncompressed size mismatch between Local File Header and Central Directory for entry " + m6287h + ". LFH: " + m6319b3 + ", CD: " + m6290k);
                }
            }
            int m6311a = AbstractC0667d.m6311a(mo6235a, 26);
            if (m6311a > m6288i) {
                throw new C0676a("Name mismatch between Local File Header and Central Directory for entry" + m6287h + ". LFH: " + m6311a + " bytes, CD: " + m6288i + " bytes");
            }
            String m6277a = C0664a.m6277a(mo6235a, 30, m6311a);
            if (!m6287h.equals(m6277a)) {
                throw new C0676a("Name mismatch between Local File Header and Central Directory. LFH: \"" + m6277a + "\", CD: \"" + m6287h + "\"");
            }
            int m6311a2 = AbstractC0667d.m6311a(mo6235a, 28);
            long j4 = m6311a + 30 + m6286g;
            long j5 = m6311a2 + j4;
            boolean z5 = c0664a.m6280b() != 0;
            if (!z5) {
                m6278a = m6290k;
            }
            long j6 = j5 + m6278a;
            if (j6 > j) {
                throw new C0676a("Local File Header data of " + m6287h + " overlaps with Central Directory. LFH data start: " + j5 + ", LFH data end: " + j6 + ", CD start: " + j);
            }
            ByteBuffer byteBuffer = EMPTY_BYTE_BUFFER;
            if (z && m6311a2 > 0) {
                byteBuffer = interfaceC0671c.mo6235a(j4, m6311a2);
            }
            if (!z2 || i3 == 0) {
                j2 = j6;
            } else {
                j2 = 12 + j6;
                if (j2 > j) {
                    throw new C0676a("Data Descriptor of " + m6287h + " overlaps with Central Directory. Data Descriptor end: " + j6 + ", CD start: " + j);
                }
                ByteBuffer mo6235a2 = interfaceC0671c.mo6235a(j6, 4);
                mo6235a2.order(ByteOrder.LITTLE_ENDIAN);
                if (mo6235a2.getInt() == DATA_DESCRIPTOR_SIGNATURE) {
                    j2 += 4;
                    if (j2 > j) {
                        throw new C0676a("Data Descriptor of " + m6287h + " overlaps with Central Directory. Data Descriptor end: " + j6 + ", CD start: " + j);
                    }
                }
            }
            return new C0666c(m6287h, m6288i, byteBuffer, m6286g, j2 - m6286g, m6311a + 30 + m6311a2, m6278a, z5, m6290k);
        } catch (IOException e2) {
            throw new IOException("Failed to read Local File Header of " + m6287h, e2);
        }
    }

    /* renamed from: a */
    public long m6300a(InterfaceC0671c interfaceC0671c, InterfaceC0669a interfaceC0669a) {
        long m6306e = m6306e();
        interfaceC0671c.mo6237a(m6307f(), m6306e, interfaceC0669a);
        return m6306e;
    }

    /* renamed from: a */
    public long m6301a(InterfaceC0671c interfaceC0671c, ByteBuffer byteBuffer, InterfaceC0669a interfaceC0669a) {
        long m6307f = m6307f();
        int m6304c = m6304c();
        int remaining = byteBuffer.remaining();
        ByteBuffer allocate = ByteBuffer.allocate(m6304c + remaining);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        interfaceC0671c.mo6236a(m6307f, m6304c, allocate);
        allocate.put(byteBuffer.slice());
        allocate.flip();
        AbstractC0667d.m6316a(allocate, 28, remaining);
        long remaining2 = allocate.remaining();
        interfaceC0669a.mo6239a(allocate);
        long m6306e = m6306e();
        int i = this.f4278c;
        long j = m6306e - i;
        interfaceC0671c.mo6237a(i + m6307f, j, interfaceC0669a);
        return remaining2 + j;
    }

    /* renamed from: a */
    public static long m6294a(String str, int i, int i2, byte[] bArr, long j, long j2, InterfaceC0669a interfaceC0669a) {
        byte[] bytes = str.getBytes(C0681h.UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 30);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(RECORD_SIGNATURE);
        AbstractC0667d.m6323c(allocate, 20);
        allocate.putShort(AbstractC0667d.GP_FLAG_EFS);
        allocate.putShort((short) 8);
        AbstractC0667d.m6323c(allocate, i);
        AbstractC0667d.m6323c(allocate, i2);
        AbstractC0667d.m6318a(allocate, j);
        AbstractC0667d.m6318a(allocate, bArr.length);
        AbstractC0667d.m6318a(allocate, j2);
        AbstractC0667d.m6323c(allocate, bytes.length);
        AbstractC0667d.m6323c(allocate, 0);
        allocate.put(bytes);
        if (allocate.hasRemaining()) {
            throw new RuntimeException("pos: " + allocate.position() + ", limit: " + allocate.limit());
        }
        allocate.flip();
        long remaining = allocate.remaining();
        interfaceC0669a.mo6239a(allocate);
        long length = bArr.length;
        interfaceC0669a.mo6240a(bArr, 0, bArr.length);
        return length + remaining;
    }

    /* renamed from: b */
    public void m6303b(InterfaceC0671c interfaceC0671c, InterfaceC0669a interfaceC0669a) {
        long j = this.f4278c + this.f4283h;
        try {
            if (this.f4276a) {
                try {
                    a aVar = new a(interfaceC0669a);
                    interfaceC0671c.mo6237a(j, this.f4277b, aVar);
                    long m6310a = aVar.m6310a();
                    if (m6310a != this.f4284i) {
                        throw new C0676a("Unexpected size of uncompressed data of " + this.f4280e + ". Expected: " + this.f4284i + " bytes, actual: " + m6310a + " bytes");
                    }
                    return;
                } catch (IOException e2) {
                    if (e2.getCause() instanceof DataFormatException) {
                        throw new C0676a("Data of entry " + this.f4280e + " malformed", e2);
                    }
                    throw e2;
                }
            }
            interfaceC0671c.mo6237a(j, this.f4277b, interfaceC0669a);
        } catch (IOException e3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to read data of ");
            sb.append(this.f4276a ? "compressed" : "uncompressed");
            sb.append(" entry ");
            sb.append(this.f4280e);
            throw new IOException(sb.toString(), e3);
        }
    }

    /* renamed from: a */
    public static void m6297a(InterfaceC0671c interfaceC0671c, C0664a c0664a, long j, InterfaceC0669a interfaceC0669a) {
        m6296a(interfaceC0671c, c0664a, j, false, false).m6303b(interfaceC0671c, interfaceC0669a);
    }

    /* renamed from: b */
    public static byte[] m6298b(InterfaceC0671c interfaceC0671c, C0664a c0664a, long j) {
        if (c0664a.m6290k() > 2147483647L) {
            throw new IOException(c0664a.m6287h() + " too large: " + c0664a.m6290k());
        }
        byte[] bArr = new byte[(int) c0664a.m6290k()];
        m6297a(interfaceC0671c, c0664a, j, new C0643b(ByteBuffer.wrap(bArr)));
        return bArr;
    }

    /* compiled from: LocalFileRecord.java */
    /* renamed from: com.b.a.b.i.c$a */
    private static class a implements InterfaceC0669a, Closeable {

        /* renamed from: a */
        private boolean f4285a;

        /* renamed from: b */
        private final InterfaceC0669a f4286b;

        /* renamed from: c */
        private Inflater f4287c;

        /* renamed from: d */
        private byte[] f4288d;

        /* renamed from: e */
        private byte[] f4289e;

        /* renamed from: f */
        private long f4290f;

        private a(InterfaceC0669a interfaceC0669a) {
            this.f4287c = new Inflater(true);
            this.f4286b = interfaceC0669a;
        }

        @Override // com.p065b.p066a.p084c.InterfaceC0669a
        /* renamed from: a */
        public void mo6240a(byte[] bArr, int i, int i2) {
            m6309b();
            this.f4287c.setInput(bArr, i, i2);
            if (this.f4289e == null) {
                this.f4289e = new byte[65536];
            }
            while (!this.f4287c.finished()) {
                try {
                    int inflate = this.f4287c.inflate(this.f4289e);
                    if (inflate == 0) {
                        return;
                    }
                    this.f4286b.mo6240a(this.f4289e, 0, inflate);
                    this.f4290f = inflate + this.f4290f;
                } catch (DataFormatException e2) {
                    throw new IOException("Failed to inflate data", e2);
                }
            }
        }

        @Override // com.p065b.p066a.p084c.InterfaceC0669a
        /* renamed from: a */
        public void mo6239a(ByteBuffer byteBuffer) {
            m6309b();
            if (byteBuffer.hasArray()) {
                mo6240a(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            if (this.f4288d == null) {
                this.f4288d = new byte[65536];
            }
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(byteBuffer.remaining(), this.f4288d.length);
                byteBuffer.get(this.f4288d, 0, min);
                mo6240a(this.f4288d, 0, min);
            }
        }

        /* renamed from: a */
        public long m6310a() {
            return this.f4290f;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4285a = true;
            this.f4288d = null;
            this.f4289e = null;
            Inflater inflater = this.f4287c;
            if (inflater != null) {
                inflater.end();
                this.f4287c = null;
            }
        }

        /* renamed from: b */
        private void m6309b() {
            if (this.f4285a) {
                throw new IllegalStateException("Closed");
            }
        }
    }
}
