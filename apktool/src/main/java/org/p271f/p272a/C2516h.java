package org.p271f.p272a;

/* compiled from: ClassWriter.java */
/* renamed from: org.f.a.h */
/* loaded from: classes.dex */
public class C2516h extends AbstractC2515g {

    /* renamed from: c */
    static final byte[] f13097c;

    /* renamed from: A */
    private int f13098A;

    /* renamed from: B */
    private int f13099B;

    /* renamed from: C */
    private int[] f13100C;

    /* renamed from: D */
    private int f13101D;

    /* renamed from: E */
    private C2513e f13102E;

    /* renamed from: F */
    private int f13103F;

    /* renamed from: G */
    private int f13104G;

    /* renamed from: H */
    private C2481b f13105H;

    /* renamed from: I */
    private C2481b f13106I;

    /* renamed from: J */
    private C2481b f13107J;

    /* renamed from: K */
    private C2481b f13108K;

    /* renamed from: L */
    private C2512d f13109L;

    /* renamed from: M */
    private int f13110M;

    /* renamed from: N */
    private C2513e f13111N;

    /* renamed from: O */
    private boolean f13112O;

    /* renamed from: P */
    private boolean f13113P;

    /* renamed from: d */
    C2514f f13114d;

    /* renamed from: e */
    int f13115e;

    /* renamed from: f */
    int f13116f;

    /* renamed from: g */
    final C2513e f13117g;

    /* renamed from: h */
    C2524p[] f13118h;

    /* renamed from: i */
    int f13119i;

    /* renamed from: j */
    final C2524p f13120j;

    /* renamed from: k */
    final C2524p f13121k;

    /* renamed from: l */
    final C2524p f13122l;

    /* renamed from: m */
    final C2524p f13123m;

    /* renamed from: n */
    C2524p[] f13124n;

    /* renamed from: o */
    String f13125o;

    /* renamed from: p */
    int f13126p;

    /* renamed from: q */
    C2513e f13127q;

    /* renamed from: r */
    C2520l f13128r;

    /* renamed from: s */
    C2520l f13129s;

    /* renamed from: t */
    C2527s f13130t;

    /* renamed from: u */
    C2527s f13131u;

    /* renamed from: v */
    boolean f13132v;

    /* renamed from: w */
    private short f13133w;

    /* renamed from: x */
    private int f13134x;

    /* renamed from: y */
    private int f13135y;

    /* renamed from: z */
    private int f13136z;

    static {
        byte[] bArr = new byte[220];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i) - 'A');
        }
        f13097c = bArr;
    }

    public C2516h(int i) {
        super(327680);
        this.f13116f = 1;
        this.f13117g = new C2513e();
        this.f13118h = new C2524p[256];
        this.f13119i = (int) (0.75d * this.f13118h.length);
        this.f13120j = new C2524p();
        this.f13121k = new C2524p();
        this.f13122l = new C2524p();
        this.f13123m = new C2524p();
        this.f13112O = (i & 1) != 0;
        this.f13113P = (i & 2) != 0;
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final void mo15669a(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f13115e = i;
        this.f13134x = i2;
        this.f13135y = m15824c(str);
        this.f13125o = str;
        if (str2 != null) {
            this.f13136z = m15807a(str2);
        }
        this.f13098A = str3 == null ? 0 : m15824c(str3);
        if (strArr != null && strArr.length > 0) {
            this.f13099B = strArr.length;
            this.f13100C = new int[this.f13099B];
            for (int i3 = 0; i3 < this.f13099B; i3++) {
                this.f13100C[i3] = m15824c(strArr[i3]);
            }
        }
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final void mo15798a(String str, String str2) {
        if (str != null) {
            this.f13101D = m15807a(str);
        }
        if (str2 != null) {
            this.f13102E = new C2513e().m15768a(str2, 0, Integer.MAX_VALUE);
        }
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final void mo15670a(String str, String str2, String str3) {
        this.f13103F = m15824c(str);
        if (str2 != null && str3 != null) {
            this.f13104G = m15819b(str2, str3);
        }
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final AbstractC2473a mo15663a(String str, boolean z) {
        C2513e c2513e = new C2513e();
        c2513e.m15770b(m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this, true, c2513e, c2513e, 2);
        if (z) {
            c2481b.f12980c = this.f13105H;
            this.f13105H = c2481b;
        } else {
            c2481b.f12980c = this.f13106I;
            this.f13106I = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final AbstractC2473a mo15662a(int i, C2530v c2530v, String str, boolean z) {
        C2513e c2513e = new C2513e();
        C2481b.m15705a(i, c2530v, c2513e);
        c2513e.m15770b(m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this, true, c2513e, c2513e, c2513e.f13089b - 2);
        if (z) {
            c2481b.f12980c = this.f13107J;
            this.f13107J = c2481b;
        } else {
            c2481b.f12980c = this.f13108K;
            this.f13108K = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final void mo15799a(C2512d c2512d) {
        c2512d.f13087c = this.f13109L;
        this.f13109L = c2512d;
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final void mo15671a(String str, String str2, String str3, int i) {
        if (this.f13111N == null) {
            this.f13111N = new C2513e();
        }
        C2524p m15821b = m15821b(str);
        if (m15821b.f13194c == 0) {
            this.f13110M++;
            this.f13111N.m15770b(m15821b.f13192a);
            this.f13111N.m15770b(str2 == null ? 0 : m15824c(str2));
            this.f13111N.m15770b(str3 != null ? m15807a(str3) : 0);
            this.f13111N.m15770b(i);
            m15821b.f13194c = this.f13110M;
        }
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final AbstractC2519k mo15665a(int i, String str, String str2, String str3, Object obj) {
        return new C2520l(this, i, str, str2, str3, obj);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final AbstractC2526r mo15667a(int i, String str, String str2, String str3, String[] strArr) {
        return new C2527s(this, i, str, str2, str3, strArr, this.f13112O, this.f13113P);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public final void mo10327a() {
    }

    /* renamed from: b */
    public byte[] m15823b() {
        int i;
        int i2;
        if (this.f13116f > 65535) {
            throw new RuntimeException("Class file too large!");
        }
        int i3 = (this.f13099B * 2) + 24;
        C2520l c2520l = this.f13128r;
        int i4 = 0;
        while (c2520l != null) {
            i3 += c2520l.m15833b();
            c2520l = (C2520l) c2520l.f13161b;
            i4++;
        }
        C2527s c2527s = this.f13130t;
        int i5 = 0;
        while (c2527s != null) {
            i3 += c2527s.m15887d();
            c2527s = (C2527s) c2527s.f13214c_;
            i5++;
        }
        if (this.f13127q != null) {
            i = 1;
            i3 += this.f13127q.f13089b + 8;
            m15807a("BootstrapMethods");
        } else {
            i = 0;
        }
        if (this.f13136z != 0) {
            i++;
            i3 += 8;
            m15807a("Signature");
        }
        if (this.f13101D != 0) {
            i++;
            i3 += 8;
            m15807a("SourceFile");
        }
        if (this.f13102E != null) {
            i++;
            i3 += this.f13102E.f13089b + 6;
            m15807a("SourceDebugExtension");
        }
        if (this.f13103F != 0) {
            i++;
            i3 += 10;
            m15807a("EnclosingMethod");
        }
        if ((this.f13134x & 131072) != 0) {
            i++;
            i3 += 6;
            m15807a("Deprecated");
        }
        if ((this.f13134x & 4096) != 0 && ((this.f13115e & 65535) < 49 || (this.f13134x & 262144) != 0)) {
            i++;
            i3 += 6;
            m15807a("Synthetic");
        }
        if (this.f13111N != null) {
            i++;
            i3 += this.f13111N.f13089b + 8;
            m15807a("InnerClasses");
        }
        if (this.f13105H != null) {
            i++;
            i3 += this.f13105H.m15708b() + 8;
            m15807a("RuntimeVisibleAnnotations");
        }
        if (this.f13106I != null) {
            i++;
            i3 += this.f13106I.m15708b() + 8;
            m15807a("RuntimeInvisibleAnnotations");
        }
        if (this.f13107J != null) {
            i++;
            i3 += this.f13107J.m15708b() + 8;
            m15807a("RuntimeVisibleTypeAnnotations");
        }
        if (this.f13108K != null) {
            i++;
            i3 += this.f13108K.m15708b() + 8;
            m15807a("RuntimeInvisibleTypeAnnotations");
        }
        int i6 = i3;
        if (this.f13109L != null) {
            int m15762c = i + this.f13109L.m15762c();
            i6 += this.f13109L.m15760b(this, null, 0, -1, -1);
            i2 = m15762c;
        } else {
            i2 = i;
        }
        C2513e c2513e = new C2513e(this.f13117g.f13089b + i6);
        c2513e.m15772c(-889275714).m15772c(this.f13115e);
        c2513e.m15770b(this.f13116f).m15769a(this.f13117g.f13088a, 0, this.f13117g.f13089b);
        c2513e.m15770b(((393216 | ((this.f13134x & 262144) / 64)) ^ (-1)) & this.f13134x).m15770b(this.f13135y).m15770b(this.f13098A);
        c2513e.m15770b(this.f13099B);
        for (int i7 = 0; i7 < this.f13099B; i7++) {
            c2513e.m15770b(this.f13100C[i7]);
        }
        c2513e.m15770b(i4);
        for (C2520l c2520l2 = this.f13128r; c2520l2 != null; c2520l2 = (C2520l) c2520l2.f13161b) {
            c2520l2.m15832a(c2513e);
        }
        c2513e.m15770b(i5);
        for (C2527s c2527s2 = this.f13130t; c2527s2 != null; c2527s2 = (C2527s) c2527s2.f13214c_) {
            c2527s2.m15886a(c2513e);
        }
        c2513e.m15770b(i2);
        if (this.f13127q != null) {
            c2513e.m15770b(m15807a("BootstrapMethods"));
            c2513e.m15772c(this.f13127q.f13089b + 2).m15770b(this.f13126p);
            c2513e.m15769a(this.f13127q.f13088a, 0, this.f13127q.f13089b);
        }
        if (this.f13136z != 0) {
            c2513e.m15770b(m15807a("Signature")).m15772c(2).m15770b(this.f13136z);
        }
        if (this.f13101D != 0) {
            c2513e.m15770b(m15807a("SourceFile")).m15772c(2).m15770b(this.f13101D);
        }
        if (this.f13102E != null) {
            int i8 = this.f13102E.f13089b;
            c2513e.m15770b(m15807a("SourceDebugExtension")).m15772c(i8);
            c2513e.m15769a(this.f13102E.f13088a, 0, i8);
        }
        if (this.f13103F != 0) {
            c2513e.m15770b(m15807a("EnclosingMethod")).m15772c(4);
            c2513e.m15770b(this.f13103F).m15770b(this.f13104G);
        }
        if ((this.f13134x & 131072) != 0) {
            c2513e.m15770b(m15807a("Deprecated")).m15772c(0);
        }
        if ((this.f13134x & 4096) != 0 && ((this.f13115e & 65535) < 49 || (this.f13134x & 262144) != 0)) {
            c2513e.m15770b(m15807a("Synthetic")).m15772c(0);
        }
        if (this.f13111N != null) {
            c2513e.m15770b(m15807a("InnerClasses"));
            c2513e.m15772c(this.f13111N.f13089b + 2).m15770b(this.f13110M);
            c2513e.m15769a(this.f13111N.f13088a, 0, this.f13111N.f13089b);
        }
        if (this.f13105H != null) {
            c2513e.m15770b(m15807a("RuntimeVisibleAnnotations"));
            this.f13105H.m15707a(c2513e);
        }
        if (this.f13106I != null) {
            c2513e.m15770b(m15807a("RuntimeInvisibleAnnotations"));
            this.f13106I.m15707a(c2513e);
        }
        if (this.f13107J != null) {
            c2513e.m15770b(m15807a("RuntimeVisibleTypeAnnotations"));
            this.f13107J.m15707a(c2513e);
        }
        if (this.f13108K != null) {
            c2513e.m15770b(m15807a("RuntimeInvisibleTypeAnnotations"));
            this.f13108K.m15707a(c2513e);
        }
        if (this.f13109L != null) {
            this.f13109L.m15758a(this, (byte[]) null, 0, -1, -1, c2513e);
        }
        if (!this.f13132v) {
            return c2513e.f13088a;
        }
        this.f13105H = null;
        this.f13106I = null;
        this.f13109L = null;
        this.f13110M = 0;
        this.f13111N = null;
        this.f13126p = 0;
        this.f13127q = null;
        this.f13128r = null;
        this.f13129s = null;
        this.f13130t = null;
        this.f13131u = null;
        this.f13112O = false;
        this.f13113P = true;
        this.f13132v = false;
        new C2514f(c2513e.f13088a).m15790a(this, 4);
        return m15823b();
    }

    /* renamed from: a */
    C2524p m15814a(Object obj) {
        if (obj instanceof Integer) {
            return m15811a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return m15811a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return m15811a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return m15811a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return m15811a(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return m15810a(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return m15813a(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return m15809a(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return m15805f((String) obj);
        }
        if (obj instanceof C2529u) {
            C2529u c2529u = (C2529u) obj;
            int m15896a = c2529u.m15896a();
            if (m15896a == 10) {
                return m15821b(c2529u.m15900d());
            }
            if (m15896a == 11) {
                return m15828d(c2529u.m15901e());
            }
            return m15821b(c2529u.m15901e());
        }
        if (obj instanceof C2522n) {
            C2522n c2522n = (C2522n) obj;
            return m15812a(c2522n.f13182a, c2522n.f13183b, c2522n.f13184c, c2522n.f13185d);
        }
        throw new IllegalArgumentException("value " + obj);
    }

    /* renamed from: b */
    public int m15818b(Object obj) {
        return m15814a(obj).f13192a;
    }

    /* renamed from: a */
    public int m15807a(String str) {
        this.f13120j.m15857a(1, str, null, null);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            this.f13117g.m15764a(1).m15767a(str);
            int i = this.f13116f;
            this.f13116f = i + 1;
            m15802b = new C2524p(i, this.f13120j);
            m15804c(m15802b);
        }
        return m15802b.f13192a;
    }

    /* renamed from: b */
    C2524p m15821b(String str) {
        this.f13121k.m15857a(7, str, null, null);
        C2524p m15802b = m15802b(this.f13121k);
        if (m15802b == null) {
            this.f13117g.m15771b(7, m15807a(str));
            int i = this.f13116f;
            this.f13116f = i + 1;
            C2524p c2524p = new C2524p(i, this.f13121k);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: c */
    public int m15824c(String str) {
        return m15821b(str).f13192a;
    }

    /* renamed from: d */
    C2524p m15828d(String str) {
        this.f13121k.m15857a(16, str, null, null);
        C2524p m15802b = m15802b(this.f13121k);
        if (m15802b == null) {
            this.f13117g.m15771b(16, m15807a(str));
            int i = this.f13116f;
            this.f13116f = i + 1;
            C2524p c2524p = new C2524p(i, this.f13121k);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: a */
    C2524p m15812a(int i, String str, String str2, String str3) {
        this.f13123m.m15857a(i + 20, str, str2, str3);
        C2524p m15802b = m15802b(this.f13123m);
        if (m15802b == null) {
            if (i <= 4) {
                m15803b(15, i, m15825c(str, str2, str3));
            } else {
                m15803b(15, i, m15820b(str, str2, str3, i == 9));
            }
            int i2 = this.f13116f;
            this.f13116f = i2 + 1;
            C2524p c2524p = new C2524p(i2, this.f13123m);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: b */
    public int m15817b(int i, String str, String str2, String str3) {
        return m15812a(i, str, str2, str3).f13192a;
    }

    /* renamed from: a */
    C2524p m15816a(String str, String str2, C2522n c2522n, Object... objArr) {
        int i;
        C2513e c2513e = this.f13127q;
        if (c2513e == null) {
            c2513e = new C2513e();
            this.f13127q = c2513e;
        }
        int i2 = c2513e.f13089b;
        int hashCode = c2522n.hashCode();
        c2513e.m15770b(m15817b(c2522n.f13182a, c2522n.f13183b, c2522n.f13184c, c2522n.f13185d));
        int length = objArr.length;
        c2513e.m15770b(length);
        for (Object obj : objArr) {
            hashCode ^= obj.hashCode();
            c2513e.m15770b(m15818b(obj));
        }
        byte[] bArr = c2513e.f13088a;
        int i3 = (length + 2) << 1;
        int i4 = hashCode & Integer.MAX_VALUE;
        C2524p c2524p = this.f13118h[i4 % this.f13118h.length];
        loop1: while (c2524p != null) {
            if (c2524p.f13193b != 33 || c2524p.f13199h != i4) {
                c2524p = c2524p.f13200i;
            } else {
                int i5 = c2524p.f13194c;
                for (int i6 = 0; i6 < i3; i6++) {
                    if (bArr[i2 + i6] != bArr[i5 + i6]) {
                        c2524p = c2524p.f13200i;
                    }
                }
                break loop1;
            }
        }
        if (c2524p != null) {
            int i7 = c2524p.f13192a;
            c2513e.f13089b = i2;
            i = i7;
        } else {
            i = this.f13126p;
            this.f13126p = i + 1;
            C2524p c2524p2 = new C2524p(i);
            c2524p2.m15856a(i2, i4);
            m15804c(c2524p2);
        }
        this.f13122l.m15859a(str, str2, i);
        C2524p m15802b = m15802b(this.f13122l);
        if (m15802b != null) {
            return m15802b;
        }
        m15801a(18, i, m15819b(str, str2));
        int i8 = this.f13116f;
        this.f13116f = i8 + 1;
        C2524p c2524p3 = new C2524p(i8, this.f13122l);
        m15804c(c2524p3);
        return c2524p3;
    }

    /* renamed from: b */
    C2524p m15822b(String str, String str2, String str3) {
        this.f13122l.m15857a(9, str, str2, str3);
        C2524p m15802b = m15802b(this.f13122l);
        if (m15802b == null) {
            m15801a(9, m15824c(str), m15819b(str2, str3));
            int i = this.f13116f;
            this.f13116f = i + 1;
            C2524p c2524p = new C2524p(i, this.f13122l);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: c */
    public int m15825c(String str, String str2, String str3) {
        return m15822b(str, str2, str3).f13192a;
    }

    /* renamed from: a */
    C2524p m15815a(String str, String str2, String str3, boolean z) {
        int i = z ? 11 : 10;
        this.f13122l.m15857a(i, str, str2, str3);
        C2524p m15802b = m15802b(this.f13122l);
        if (m15802b != null) {
            return m15802b;
        }
        m15801a(i, m15824c(str), m15819b(str2, str3));
        int i2 = this.f13116f;
        this.f13116f = i2 + 1;
        C2524p c2524p = new C2524p(i2, this.f13122l);
        m15804c(c2524p);
        return c2524p;
    }

    /* renamed from: b */
    public int m15820b(String str, String str2, String str3, boolean z) {
        return m15815a(str, str2, str3, z).f13192a;
    }

    /* renamed from: a */
    C2524p m15811a(int i) {
        this.f13120j.m15855a(i);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            this.f13117g.m15764a(3).m15772c(i);
            int i2 = this.f13116f;
            this.f13116f = i2 + 1;
            C2524p c2524p = new C2524p(i2, this.f13120j);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: a */
    C2524p m15810a(float f2) {
        this.f13120j.m15854a(f2);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            this.f13117g.m15764a(4).m15772c(this.f13120j.f13194c);
            int i = this.f13116f;
            this.f13116f = i + 1;
            C2524p c2524p = new C2524p(i, this.f13120j);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: a */
    C2524p m15813a(long j) {
        this.f13120j.m15858a(j);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            this.f13117g.m15764a(5).m15766a(j);
            C2524p c2524p = new C2524p(this.f13116f, this.f13120j);
            this.f13116f += 2;
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: a */
    C2524p m15809a(double d2) {
        this.f13120j.m15853a(d2);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            this.f13117g.m15764a(6).m15766a(this.f13120j.f13195d);
            C2524p c2524p = new C2524p(this.f13116f, this.f13120j);
            this.f13116f += 2;
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: f */
    private C2524p m15805f(String str) {
        this.f13121k.m15857a(8, str, null, null);
        C2524p m15802b = m15802b(this.f13121k);
        if (m15802b == null) {
            this.f13117g.m15771b(8, m15807a(str));
            int i = this.f13116f;
            this.f13116f = i + 1;
            C2524p c2524p = new C2524p(i, this.f13121k);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: b */
    public int m15819b(String str, String str2) {
        return m15826c(str, str2).f13192a;
    }

    /* renamed from: c */
    C2524p m15826c(String str, String str2) {
        this.f13121k.m15857a(12, str, str2, null);
        C2524p m15802b = m15802b(this.f13121k);
        if (m15802b == null) {
            m15801a(12, m15807a(str), m15807a(str2));
            int i = this.f13116f;
            this.f13116f = i + 1;
            C2524p c2524p = new C2524p(i, this.f13121k);
            m15804c(c2524p);
            return c2524p;
        }
        return m15802b;
    }

    /* renamed from: e */
    int m15829e(String str) {
        this.f13120j.m15857a(30, str, null, null);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            m15802b = m15800a(this.f13120j);
        }
        return m15802b.f13192a;
    }

    /* renamed from: a */
    int m15808a(String str, int i) {
        this.f13120j.f13193b = 31;
        this.f13120j.f13194c = i;
        this.f13120j.f13196e = str;
        this.f13120j.f13199h = Integer.MAX_VALUE & (str.hashCode() + 31 + i);
        C2524p m15802b = m15802b(this.f13120j);
        if (m15802b == null) {
            m15802b = m15800a(this.f13120j);
        }
        return m15802b.f13192a;
    }

    /* renamed from: a */
    private C2524p m15800a(C2524p c2524p) {
        this.f13133w = (short) (this.f13133w + 1);
        C2524p c2524p2 = new C2524p(this.f13133w, this.f13120j);
        m15804c(c2524p2);
        if (this.f13124n == null) {
            this.f13124n = new C2524p[16];
        }
        if (this.f13133w == this.f13124n.length) {
            C2524p[] c2524pArr = new C2524p[this.f13124n.length * 2];
            System.arraycopy(this.f13124n, 0, c2524pArr, 0, this.f13124n.length);
            this.f13124n = c2524pArr;
        }
        this.f13124n[this.f13133w] = c2524p2;
        return c2524p2;
    }

    /* renamed from: a */
    int m15806a(int i, int i2) {
        this.f13121k.f13193b = 32;
        this.f13121k.f13195d = i | (i2 << 32);
        this.f13121k.f13199h = Integer.MAX_VALUE & (i + 32 + i2);
        C2524p m15802b = m15802b(this.f13121k);
        if (m15802b == null) {
            this.f13121k.f13194c = m15829e(m15827d(this.f13124n[i].f13196e, this.f13124n[i2].f13196e));
            m15802b = new C2524p(0, this.f13121k);
            m15804c(m15802b);
        }
        return m15802b.f13194c;
    }

    /* renamed from: d */
    protected String m15827d(String str, String str2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> cls = Class.forName(str.replace('/', '.'), false, classLoader);
            Class<?> cls2 = Class.forName(str2.replace('/', '.'), false, classLoader);
            if (!cls.isAssignableFrom(cls2)) {
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace('.', '/');
            }
            return str;
        } catch (Exception e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    /* renamed from: b */
    private C2524p m15802b(C2524p c2524p) {
        C2524p c2524p2 = this.f13118h[c2524p.f13199h % this.f13118h.length];
        while (c2524p2 != null && (c2524p2.f13193b != c2524p.f13193b || !c2524p.m15860a(c2524p2))) {
            c2524p2 = c2524p2.f13200i;
        }
        return c2524p2;
    }

    /* renamed from: c */
    private void m15804c(C2524p c2524p) {
        if (this.f13116f + this.f13133w > this.f13119i) {
            int length = this.f13118h.length;
            int i = (length * 2) + 1;
            C2524p[] c2524pArr = new C2524p[i];
            for (int i2 = length - 1; i2 >= 0; i2--) {
                C2524p c2524p2 = this.f13118h[i2];
                while (c2524p2 != null) {
                    int length2 = c2524p2.f13199h % c2524pArr.length;
                    C2524p c2524p3 = c2524p2.f13200i;
                    c2524p2.f13200i = c2524pArr[length2];
                    c2524pArr[length2] = c2524p2;
                    c2524p2 = c2524p3;
                }
            }
            this.f13118h = c2524pArr;
            this.f13119i = (int) (i * 0.75d);
        }
        int length3 = c2524p.f13199h % this.f13118h.length;
        c2524p.f13200i = this.f13118h[length3];
        this.f13118h[length3] = c2524p;
    }

    /* renamed from: a */
    private void m15801a(int i, int i2, int i3) {
        this.f13117g.m15771b(i, i2).m15770b(i3);
    }

    /* renamed from: b */
    private void m15803b(int i, int i2, int i3) {
        this.f13117g.m15765a(i, i2).m15770b(i3);
    }
}
