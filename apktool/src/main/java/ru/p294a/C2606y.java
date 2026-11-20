package ru.p294a;

import android.widget.ExpandableListView;
import java.nio.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;

/* compiled from: ZipOutputStream.java */
/* renamed from: ru.a.y */
/* loaded from: classes.dex */
public class C2606y extends FilterOutputStream {

    /* renamed from: A */
    private InterfaceC2600s f13532A;

    /* renamed from: B */
    private final RandomAccessFile f13533B;

    /* renamed from: C */
    private boolean f13534C;

    /* renamed from: D */
    private boolean f13535D;

    /* renamed from: E */
    private b f13536E;

    /* renamed from: F */
    private boolean f13537F;

    /* renamed from: G */
    private EnumC2597p f13538G;

    /* renamed from: H */
    private final Calendar f13539H;

    /* renamed from: I */
    private final byte[] f13540I;

    /* renamed from: J */
    private boolean f13541J;

    /* renamed from: b */
    protected final Deflater f13542b;

    /* renamed from: c */
    protected byte[] f13543c;

    /* renamed from: j */
    private boolean f13544j;

    /* renamed from: l */
    private a f13545l;

    /* renamed from: m */
    private String f13546m;

    /* renamed from: n */
    private int f13547n;

    /* renamed from: o */
    private boolean f13548o;

    /* renamed from: p */
    private int f13549p;

    /* renamed from: q */
    private final List<C2602u> f13550q;

    /* renamed from: r */
    private final CRC32 f13551r;

    /* renamed from: s */
    private long f13552s;

    /* renamed from: t */
    private long f13553t;

    /* renamed from: u */
    private long f13554u;

    /* renamed from: y */
    private final Map<C2602u, Long> f13555y;

    /* renamed from: z */
    private String f13556z;

    /* renamed from: a */
    static final String f13521a = (String) null;

    /* renamed from: k */
    private static final byte[] f13528k = new byte[0];

    /* renamed from: v */
    private static final byte[] f13529v = {(byte) 0, (byte) 0};

    /* renamed from: w */
    private static final byte[] f13530w = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};

    /* renamed from: x */
    private static final byte[] f13531x = C2605x.m16176a(1);

    /* renamed from: d */
    protected static final byte[] f13522d = C2605x.f13517b.m16179a();

    /* renamed from: e */
    protected static final byte[] f13523e = C2605x.f13518c.m16179a();

    /* renamed from: f */
    protected static final byte[] f13524f = C2605x.f13516a.m16179a();

    /* renamed from: g */
    protected static final byte[] f13525g = C2605x.m16176a(101010256);

    /* renamed from: h */
    static final byte[] f13526h = C2605x.m16176a(101075792);

    /* renamed from: i */
    static final byte[] f13527i = C2605x.m16176a(117853008);

    public C2606y(OutputStream outputStream) {
        super(outputStream);
        this.f13544j = false;
        this.f13546m = "";
        this.f13547n = -1;
        this.f13548o = false;
        this.f13549p = 8;
        this.f13550q = new LinkedList();
        this.f13551r = new CRC32();
        this.f13552s = 0;
        this.f13553t = 0;
        this.f13554u = 0;
        this.f13555y = new HashMap();
        this.f13556z = (String) null;
        this.f13532A = AbstractC2601t.m16114a(f13521a);
        this.f13542b = new Deflater(this.f13547n, true);
        this.f13543c = new byte[512];
        this.f13534C = true;
        this.f13535D = false;
        this.f13536E = b.f13564b;
        this.f13537F = false;
        this.f13538G = EnumC2597p.AsNeeded;
        this.f13539H = Calendar.getInstance();
        this.f13540I = new byte[1];
        this.f13541J = false;
        this.f13533B = (RandomAccessFile) null;
    }

    /* renamed from: a */
    public void m16215a(boolean z) {
        this.f13541J = z;
    }

    /* renamed from: a */
    public void m16211a() {
        if (this.f13544j) {
            throw new IOException("This archive has already been finished");
        }
        if (this.f13545l != null) {
            m16218b();
        }
        this.f13553t = this.f13552s;
        m16203g();
        this.f13554u = this.f13552s - this.f13553t;
        m16224e();
        m16223d();
        this.f13555y.clear();
        this.f13550q.clear();
        this.f13542b.end();
        this.f13544j = true;
    }

    /* renamed from: g */
    private void m16203g() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(70000);
        Iterator<C2602u> it = this.f13550q.iterator();
        int i = 0;
        while (it.hasNext()) {
            byteArrayOutputStream.write(m16201f(it.next()));
            int i2 = i + 1;
            if (i2 > 1000) {
                m16193b(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.reset();
                i = 0;
            } else {
                i = i2;
            }
        }
        m16193b(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: b */
    public void m16218b() {
        m16204h();
        m16207i();
        EnumC2597p m16206i = m16206i(this.f13545l.f13557a);
        long j = this.f13552s - this.f13545l.f13559c;
        long value = this.f13551r.getValue();
        this.f13551r.reset();
        if (this.f13541J && this.f13545l.f13557a.getCrc() > 0) {
            value = this.f13545l.f13557a.getCrc();
        }
        m16192b(m16184a(j, value, m16206i));
    }

    /* renamed from: b */
    private void m16192b(boolean z) {
        if (this.f13533B != null) {
            m16196c(z);
        }
        m16222c(this.f13545l.f13557a);
        this.f13545l = (a) null;
    }

    /* renamed from: h */
    private void m16204h() {
        if (this.f13544j) {
            throw new IOException("Stream has already been finished");
        }
        if (this.f13545l == null) {
            throw new IOException("No current entry to close");
        }
        if (this.f13545l.f13562f) {
            return;
        }
        write(f13528k, 0, 0);
    }

    /* renamed from: i */
    private void m16207i() {
        if (this.f13545l.f13557a.getMethod() == 8) {
            this.f13542b.finish();
            while (!this.f13542b.finished()) {
                m16221c();
            }
        }
    }

    /* renamed from: a */
    private boolean m16184a(long j, long j2, EnumC2597p enumC2597p) {
        if (this.f13545l.f13557a.getMethod() == 8) {
            this.f13545l.f13557a.setSize(this.f13545l.f13560d);
            this.f13545l.f13557a.setCompressedSize(j);
            this.f13545l.f13557a.setCrc(j2);
            this.f13542b.reset();
        } else if (this.f13533B != null) {
            this.f13545l.f13557a.setSize(j);
            this.f13545l.f13557a.setCompressedSize(j);
            this.f13545l.f13557a.setCrc(j2);
        } else {
            if (this.f13545l.f13557a.getCrc() != j2 && !this.f13541J) {
                throw new ZipException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("bad CRC checksum for entry ").append(this.f13545l.f13557a.getName()).toString()).append(": ").toString()).append(Long.toHexString(this.f13545l.f13557a.getCrc())).toString()).append(" instead of ").toString()).append(Long.toHexString(j2)).toString());
            }
            if (this.f13545l.f13557a.getSize() != j) {
                throw new ZipException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("bad size for entry ").append(this.f13545l.f13557a.getName()).toString()).append(": ").toString()).append(this.f13545l.f13557a.getSize()).toString()).append(" instead of ").toString()).append(j).toString());
            }
        }
        return m16185a(enumC2597p);
    }

    /* renamed from: a */
    private boolean m16185a(EnumC2597p enumC2597p) {
        boolean m16186a = m16186a(this.f13545l.f13557a, enumC2597p);
        if (m16186a && enumC2597p == EnumC2597p.Never) {
            throw new C2598q(C2598q.m16104a(this.f13545l.f13557a));
        }
        return m16186a;
    }

    /* renamed from: a */
    private boolean m16186a(C2602u c2602u, EnumC2597p enumC2597p) {
        return enumC2597p == EnumC2597p.Always || m16199d(c2602u);
    }

    /* renamed from: d */
    private boolean m16199d(C2602u c2602u) {
        return c2602u.getSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || c2602u.getCompressedSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }

    /* renamed from: c */
    private void m16196c(boolean z) {
        long filePointer = this.f13533B.getFilePointer();
        this.f13533B.seek(this.f13545l.f13558b);
        m16216a(C2605x.m16176a(this.f13545l.f13557a.getCrc()));
        if (!m16205h(this.f13545l.f13557a) || !z) {
            m16216a(C2605x.m16176a(this.f13545l.f13557a.getCompressedSize()));
            m16216a(C2605x.m16176a(this.f13545l.f13557a.getSize()));
        } else {
            m16216a(C2605x.f13519d.m16179a());
            m16216a(C2605x.f13519d.m16179a());
        }
        if (m16205h(this.f13545l.f13557a)) {
            this.f13533B.seek(this.f13545l.f13558b + 12 + 4 + m16210k(this.f13545l.f13557a).limit() + 4);
            m16216a(C2599r.m16107a(this.f13545l.f13557a.getSize()));
            m16216a(C2599r.m16107a(this.f13545l.f13557a.getCompressedSize()));
            if (!z) {
                this.f13533B.seek(this.f13545l.f13558b - 10);
                m16216a(C2607z.m16240a(10));
                this.f13545l.f13557a.m16135a(C2596o.f13457a);
                this.f13545l.f13557a.m16144d();
                if (this.f13545l.f13561e) {
                    this.f13537F = false;
                }
            }
        }
        this.f13533B.seek(filePointer);
    }

    /* renamed from: a */
    public void mo16214a(C2602u c2602u) {
        C2599r c2599r;
        if (this.f13544j) {
            throw new IOException("Stream has already been finished");
        }
        if (this.f13545l != null) {
            m16218b();
        }
        this.f13545l = new a(c2602u);
        this.f13550q.add(this.f13545l.f13557a);
        m16200e(this.f13545l.f13557a);
        EnumC2597p m16206i = m16206i(this.f13545l.f13557a);
        m16191b(m16206i);
        if (m16195b(this.f13545l.f13557a, m16206i)) {
            C2596o m16202g = m16202g(this.f13545l.f13557a);
            C2599r c2599r2 = C2599r.f13468a;
            C2599r c2599r3 = C2599r.f13468a;
            if (this.f13545l.f13557a.getMethod() != 0 || this.f13545l.f13557a.getSize() == -1) {
                c2599r = c2599r2;
            } else {
                C2599r c2599r4 = new C2599r(this.f13545l.f13557a.getSize());
                c2599r3 = c2599r4;
                c2599r = c2599r4;
            }
            m16202g.m16097a(c2599r);
            m16202g.m16100b(c2599r3);
            this.f13545l.f13557a.m16144d();
        }
        if (this.f13545l.f13557a.getMethod() == 8 && this.f13548o) {
            this.f13542b.setLevel(this.f13547n);
            this.f13548o = false;
        }
        m16220b(this.f13545l.f13557a);
    }

    /* renamed from: e */
    private void m16200e(C2602u c2602u) {
        if (c2602u.getMethod() == -1) {
            c2602u.setMethod(this.f13549p);
        }
        if (c2602u.getTime() == -1) {
            c2602u.setTime(System.currentTimeMillis());
        }
    }

    /* renamed from: b */
    private void m16191b(EnumC2597p enumC2597p) {
        if (this.f13545l.f13557a.getMethod() == 0 && this.f13533B == null) {
            if (this.f13545l.f13557a.getSize() == -1) {
                throw new ZipException(new StringBuffer().append(new StringBuffer().append("uncompressed size is required for").append(" STORED method when not writing to a").toString()).append(" file").toString());
            }
            if (this.f13545l.f13557a.getCrc() == -1) {
                throw new ZipException(new StringBuffer().append("crc checksum is required for STORED").append(" method when not writing to a file").toString());
            }
            this.f13545l.f13557a.setCompressedSize(this.f13545l.f13557a.getSize());
        }
        if ((this.f13545l.f13557a.getSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13545l.f13557a.getCompressedSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL) && enumC2597p == EnumC2597p.Never) {
            throw new C2598q(C2598q.m16104a(this.f13545l.f13557a));
        }
    }

    /* renamed from: b */
    private boolean m16195b(C2602u c2602u, EnumC2597p enumC2597p) {
        return enumC2597p == EnumC2597p.Always || c2602u.getSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || c2602u.getCompressedSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || !(c2602u.getSize() != ((long) (-1)) || this.f13533B == null || enumC2597p == EnumC2597p.Never);
    }

    /* renamed from: a */
    public void m16213a(String str) {
        this.f13546m = str;
    }

    /* renamed from: a */
    public void m16212a(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid compression level: ").append(i).toString());
        }
        if (this.f13547n != i) {
            this.f13548o = true;
            this.f13547n = i;
        }
    }

    /* renamed from: b */
    public void m16219b(int i) {
        this.f13549p = i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        this.f13540I[0] = (byte) (i & 255);
        write(this.f13540I, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (this.f13545l == null) {
            throw new IllegalStateException("No current entry");
        }
        AbstractC2582aa.m16055a(this.f13545l.f13557a);
        this.f13545l.f13562f = true;
        if (this.f13545l.f13557a.getMethod() == 8) {
            m16197c(bArr, i, i2);
        } else {
            m16194b(bArr, i, i2);
        }
        this.f13551r.update(bArr, i, i2);
    }

    /* renamed from: b */
    private void m16193b(byte[] bArr) {
        m16194b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    private void m16194b(byte[] bArr, int i, int i2) {
        m16217a(bArr, i, i2);
        this.f13552s += i2;
    }

    /* renamed from: c */
    private void m16197c(byte[] bArr, int i, int i2) {
        if (i2 > 0 && !this.f13542b.finished()) {
            this.f13545l.f13560d += i2;
            if (i2 <= 8192) {
                this.f13542b.setInput(bArr, i, i2);
                m16209j();
                return;
            }
            int i3 = i2 / 8192;
            for (int i4 = 0; i4 < i3; i4++) {
                this.f13542b.setInput(bArr, (i4 * 8192) + i, 8192);
                m16209j();
            }
            int i5 = i3 * 8192;
            if (i5 < i2) {
                this.f13542b.setInput(bArr, i + i5, i2 - i5);
                m16209j();
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f13544j) {
            m16211a();
        }
        m16225f();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (this.out != null) {
            this.out.flush();
        }
    }

    /* renamed from: c */
    protected final void m16221c() {
        int deflate = this.f13542b.deflate(this.f13543c, 0, this.f13543c.length);
        if (deflate > 0) {
            m16194b(this.f13543c, 0, deflate);
        }
    }

    /* renamed from: b */
    protected void m16220b(C2602u c2602u) {
        boolean mo16078a = this.f13532A.mo16078a(c2602u.getName());
        ByteBuffer m16210k = m16210k(c2602u);
        if (this.f13536E != b.f13564b) {
            m16183a(c2602u, mo16078a, m16210k);
        }
        byte[] m16188a = m16188a(c2602u, m16210k, mo16078a);
        long j = this.f13552s;
        this.f13555y.put(c2602u, new Long(j));
        this.f13545l.f13558b = j + 14;
        m16193b(m16188a);
        this.f13545l.f13559c = this.f13552s;
    }

    /* renamed from: a */
    private byte[] m16188a(C2602u c2602u, ByteBuffer byteBuffer, boolean z) {
        byte[] m16145e = c2602u.m16145e();
        int limit = byteBuffer.limit() - byteBuffer.position();
        byte[] bArr = new byte[limit + 30 + m16145e.length];
        System.arraycopy(f13522d, 0, bArr, 0, 4);
        int method = c2602u.getMethod();
        C2607z.m16239a(m16189b(method, m16205h(c2602u)), bArr, 4);
        m16181a(method, !z && this.f13535D).m16082a(bArr, 6);
        C2607z.m16239a(method, bArr, 8);
        AbstractC2582aa.m16054a(this.f13539H, c2602u.getTime(), bArr, 10);
        if (method == 8 || this.f13533B != null) {
            System.arraycopy(f13530w, 0, bArr, 14, 4);
        } else {
            C2605x.m16175a(c2602u.getCrc(), bArr, 14);
        }
        if (m16205h(this.f13545l.f13557a)) {
            C2605x.f13519d.m16178a(bArr, 18);
            C2605x.f13519d.m16178a(bArr, 22);
        } else if (method == 8 || this.f13533B != null) {
            System.arraycopy(f13530w, 0, bArr, 18, 4);
            System.arraycopy(f13530w, 0, bArr, 22, 4);
        } else {
            C2605x.m16175a(c2602u.getSize(), bArr, 18);
            C2605x.m16175a(c2602u.getSize(), bArr, 22);
        }
        C2607z.m16239a(limit, bArr, 26);
        C2607z.m16239a(m16145e.length, bArr, 28);
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 30, limit);
        System.arraycopy(m16145e, 0, bArr, limit + 30, m16145e.length);
        return bArr;
    }

    /* renamed from: a */
    private void m16183a(C2602u c2602u, boolean z, ByteBuffer byteBuffer) {
        if (this.f13536E == b.f13563a || !z) {
            c2602u.m16134a(new C2592k(c2602u.getName(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position()));
        }
        String comment = c2602u.getComment();
        if (comment != null && !comment.isEmpty()) {
            if (this.f13536E == b.f13563a || !this.f13532A.mo16078a(comment)) {
                ByteBuffer mo16079b = m16208j(c2602u).mo16079b(comment);
                c2602u.m16134a(new C2591j(comment, mo16079b.array(), mo16079b.arrayOffset(), mo16079b.limit() - mo16079b.position()));
            }
        }
    }

    /* renamed from: c */
    protected void m16222c(C2602u c2602u) {
        if (c2602u.getMethod() == 8 && this.f13533B == null) {
            m16193b(f13523e);
            m16193b(C2605x.m16176a(c2602u.getCrc()));
            if (!m16205h(c2602u)) {
                m16193b(C2605x.m16176a(c2602u.getCompressedSize()));
                m16193b(C2605x.m16176a(c2602u.getSize()));
            } else {
                m16193b(C2599r.m16107a(c2602u.getCompressedSize()));
                m16193b(C2599r.m16107a(c2602u.getSize()));
            }
        }
    }

    /* renamed from: f */
    private byte[] m16201f(C2602u c2602u) {
        long longValue = this.f13555y.get(c2602u).longValue();
        boolean z = m16205h(c2602u) || c2602u.getCompressedSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || c2602u.getSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || longValue >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13538G == EnumC2597p.Always;
        if (z && this.f13538G == EnumC2597p.Never) {
            throw new C2598q("archive's size exceeds the limit of 4GByte.");
        }
        m16182a(c2602u, longValue, z);
        return m16187a(c2602u, m16210k(c2602u), longValue, z);
    }

    /* renamed from: a */
    private byte[] m16187a(C2602u c2602u, ByteBuffer byteBuffer, long j, boolean z) {
        byte[] m16146f = c2602u.m16146f();
        String comment = c2602u.getComment();
        if (comment == null) {
            comment = "";
        }
        ByteBuffer mo16079b = m16208j(c2602u).mo16079b(comment);
        int limit = byteBuffer.limit() - byteBuffer.position();
        int limit2 = mo16079b.limit() - mo16079b.position();
        byte[] bArr = new byte[limit + 46 + m16146f.length + limit2];
        System.arraycopy(f13524f, 0, bArr, 0, 4);
        C2607z.m16239a((!this.f13537F ? 20 : 45) | (c2602u.m16143c() << 8), bArr, 4);
        int method = c2602u.getMethod();
        boolean mo16078a = this.f13532A.mo16078a(c2602u.getName());
        C2607z.m16239a(m16189b(method, z), bArr, 6);
        m16181a(method, !mo16078a && this.f13535D).m16082a(bArr, 8);
        C2607z.m16239a(method, bArr, 10);
        AbstractC2582aa.m16054a(this.f13539H, c2602u.getTime(), bArr, 12);
        C2605x.m16175a(c2602u.getCrc(), bArr, 16);
        if (c2602u.getCompressedSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || c2602u.getSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13538G == EnumC2597p.Always) {
            C2605x.f13519d.m16178a(bArr, 20);
            C2605x.f13519d.m16178a(bArr, 24);
        } else {
            C2605x.m16175a(c2602u.getCompressedSize(), bArr, 20);
            C2605x.m16175a(c2602u.getSize(), bArr, 24);
        }
        C2607z.m16239a(limit, bArr, 28);
        C2607z.m16239a(m16146f.length, bArr, 30);
        C2607z.m16239a(limit2, bArr, 32);
        System.arraycopy(f13529v, 0, bArr, 34, 2);
        C2607z.m16239a(c2602u.m16128a(), bArr, 36);
        C2605x.m16175a(c2602u.m16139b(), bArr, 38);
        if (j >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13538G == EnumC2597p.Always) {
            C2605x.m16175a(ExpandableListView.PACKED_POSITION_VALUE_NULL, bArr, 42);
        } else {
            C2605x.m16175a(Math.min(j, ExpandableListView.PACKED_POSITION_VALUE_NULL), bArr, 42);
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 46, limit);
        int i = limit + 46;
        System.arraycopy(m16146f, 0, bArr, i, m16146f.length);
        System.arraycopy(mo16079b.array(), mo16079b.arrayOffset(), bArr, i + m16146f.length, limit2);
        return bArr;
    }

    /* renamed from: a */
    private void m16182a(C2602u c2602u, long j, boolean z) {
        if (z) {
            C2596o m16202g = m16202g(c2602u);
            if (c2602u.getCompressedSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || c2602u.getSize() >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13538G == EnumC2597p.Always) {
                m16202g.m16100b(new C2599r(c2602u.getCompressedSize()));
                m16202g.m16097a(new C2599r(c2602u.getSize()));
            } else {
                m16202g.m16100b((C2599r) null);
                m16202g.m16097a((C2599r) null);
            }
            if (j >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13538G == EnumC2597p.Always) {
                m16202g.m16101c(new C2599r(j));
            }
            c2602u.m16144d();
        }
    }

    /* renamed from: d */
    protected void m16223d() {
        m16193b(f13525g);
        m16193b(f13529v);
        m16193b(f13529v);
        int size = this.f13550q.size();
        if (size > 65535 && this.f13538G == EnumC2597p.Never) {
            throw new C2598q("archive contains more than 65535 entries.");
        }
        if (this.f13553t > ExpandableListView.PACKED_POSITION_VALUE_NULL && this.f13538G == EnumC2597p.Never) {
            throw new C2598q("archive's size exceeds the limit of 4GByte.");
        }
        byte[] m16240a = C2607z.m16240a(Math.min(size, 65535));
        m16193b(m16240a);
        m16193b(m16240a);
        m16193b(C2605x.m16176a(Math.min(this.f13554u, ExpandableListView.PACKED_POSITION_VALUE_NULL)));
        m16193b(C2605x.m16176a(Math.min(this.f13553t, ExpandableListView.PACKED_POSITION_VALUE_NULL)));
        ByteBuffer mo16079b = this.f13532A.mo16079b(m16190b(this.f13546m));
        int limit = mo16079b.limit() - mo16079b.position();
        m16193b(C2607z.m16240a(limit));
        m16194b(mo16079b.array(), mo16079b.arrayOffset(), limit);
    }

    /* renamed from: b */
    private String m16190b(String str) {
        if (str == null) {
            return (String) null;
        }
        if (this.f13532A.mo16079b(str).remaining() <= 65535) {
            return str;
        }
        int length = str.length();
        while (length > 0) {
            length--;
            if (length > 0 && Character.isLowSurrogate(str.charAt(length)) && Character.isHighSurrogate(str.charAt(length - 1))) {
                length--;
            }
            String substring = str.substring(0, length);
            if (this.f13532A.mo16079b(substring).remaining() <= 65535) {
                return substring;
            }
        }
        return "";
    }

    /* renamed from: e */
    protected void m16224e() {
        if (this.f13538G != EnumC2597p.Never) {
            if (!this.f13537F && (this.f13553t >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13554u >= ExpandableListView.PACKED_POSITION_VALUE_NULL || this.f13550q.size() >= 65535)) {
                this.f13537F = true;
            }
            if (this.f13537F) {
                long j = this.f13552s;
                m16216a(f13526h);
                m16216a(C2599r.m16107a(44));
                m16216a(C2607z.m16240a(45));
                m16216a(C2607z.m16240a(45));
                m16216a(f13530w);
                m16216a(f13530w);
                byte[] m16107a = C2599r.m16107a(this.f13550q.size());
                m16216a(m16107a);
                m16216a(m16107a);
                m16216a(C2599r.m16107a(this.f13554u));
                m16216a(C2599r.m16107a(this.f13553t));
                m16216a(f13527i);
                m16216a(f13530w);
                m16216a(C2599r.m16107a(j));
                m16216a(f13531x);
            }
        }
    }

    /* renamed from: a */
    protected final void m16216a(byte[] bArr) {
        m16217a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    protected final void m16217a(byte[] bArr, int i, int i2) {
        if (this.f13533B != null) {
            this.f13533B.write(bArr, i, i2);
        } else {
            this.out.write(bArr, i, i2);
        }
    }

    /* renamed from: j */
    private void m16209j() {
        while (!this.f13542b.needsInput()) {
            m16221c();
        }
    }

    /* renamed from: a */
    private C2587f m16181a(int i, boolean z) {
        C2587f c2587f = new C2587f();
        c2587f.m16081a(this.f13534C || z);
        if (m16198c(i)) {
            c2587f.m16084b(true);
        }
        return c2587f;
    }

    /* renamed from: b */
    private int m16189b(int i, boolean z) {
        if (z) {
            return 45;
        }
        return m16198c(i) ? 20 : 10;
    }

    /* renamed from: c */
    private boolean m16198c(int i) {
        return i == 8 && this.f13533B == null;
    }

    /* renamed from: g */
    private C2596o m16202g(C2602u c2602u) {
        if (this.f13545l != null) {
            this.f13545l.f13561e = !this.f13537F;
        }
        this.f13537F = true;
        C2596o c2596o = (C2596o) c2602u.m16140b(C2596o.f13457a);
        if (c2596o == null) {
            c2596o = new C2596o();
        }
        c2602u.m16142b(c2596o);
        return c2596o;
    }

    /* renamed from: h */
    private boolean m16205h(C2602u c2602u) {
        return c2602u.m16140b(C2596o.f13457a) != null;
    }

    /* renamed from: i */
    private EnumC2597p m16206i(C2602u c2602u) {
        return (this.f13538G == EnumC2597p.AsNeeded && this.f13533B == null && c2602u.getMethod() == 8 && c2602u.getSize() == ((long) (-1))) ? EnumC2597p.Never : this.f13538G;
    }

    /* renamed from: j */
    private InterfaceC2600s m16208j(C2602u c2602u) {
        return (this.f13532A.mo16078a(c2602u.getName()) || !this.f13535D) ? this.f13532A : AbstractC2601t.f13471b;
    }

    /* renamed from: k */
    private ByteBuffer m16210k(C2602u c2602u) {
        return m16208j(c2602u).mo16079b(c2602u.getName());
    }

    /* renamed from: f */
    void m16225f() {
        if (this.f13533B != null) {
            this.f13533B.close();
        }
        if (this.out != null) {
            this.out.close();
        }
    }

    /* compiled from: ZipOutputStream.java */
    /* renamed from: ru.a.y$b */
    public static final class b {

        /* renamed from: a */
        public static final b f13563a = new b("always");

        /* renamed from: b */
        public static final b f13564b = new b("never");

        /* renamed from: c */
        public static final b f13565c = new b("not encodeable");

        /* renamed from: d */
        private final String f13566d;

        b(String str) {
            this.f13566d = str;
        }

        public String toString() {
            return this.f13566d;
        }
    }

    /* compiled from: ZipOutputStream.java */
    /* renamed from: ru.a.y$a */
    private static final class a {

        /* renamed from: a */
        private final C2602u f13557a;

        /* renamed from: b */
        private long f13558b = 0;

        /* renamed from: c */
        private long f13559c = 0;

        /* renamed from: d */
        private long f13560d = 0;

        /* renamed from: e */
        private boolean f13561e = false;

        /* renamed from: f */
        private boolean f13562f;

        a(C2602u c2602u) {
            this.f13557a = c2602u;
        }
    }
}
