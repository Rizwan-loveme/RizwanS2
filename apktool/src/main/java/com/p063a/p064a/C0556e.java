package com.p063a.p064a;

import org.p210a.p211a.p212a.AbstractC1873u;
import org.p210a.p211a.p212a.C1817aa;
import org.p210a.p211a.p212a.C1824ah;
import org.p210a.p211a.p212a.C1872t;
import org.p210a.p211a.p212a.C1874v;
import org.p210a.p211a.p212a.C1876x;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1823ag;
import org.p210a.p211a.p212a.p213a.C1759a;
import org.p210a.p211a.p212a.p213a.C1771al;
import org.p210a.p211a.p212a.p213a.C1777ar;
import org.p210a.p211a.p212a.p213a.C1795e;
import org.p210a.p211a.p212a.p214b.C1827a;
import org.p210a.p211a.p212a.p216d.InterfaceC1851f;

/* compiled from: JSONParser.java */
/* renamed from: com.a.a.e */
/* loaded from: classes.dex */
public class C0556e extends AbstractC1873u {

    /* renamed from: a */
    protected static final C1827a[] f3728a;

    /* renamed from: b */
    protected static final C1777ar f3729b;

    /* renamed from: c */
    public static final String[] f3730c;

    /* renamed from: d */
    public static final InterfaceC1823ag f3731d;

    /* renamed from: e */
    @Deprecated
    public static final String[] f3732e;

    /* renamed from: f */
    public static final C1759a f3733f;

    /* renamed from: g */
    private static final String[] f3734g;

    /* renamed from: p */
    private static final String[] f3735p;

    static {
        C1817aa.m13671a("4.7.2", "4.7.2");
        f3729b = new C1777ar();
        f3730c = m4493j();
        f3734g = m4494k();
        f3735p = m4495l();
        f3731d = new C1824ah(f3734g, f3735p);
        f3732e = new String[f3735p.length];
        for (int i = 0; i < f3732e.length; i++) {
            f3732e[i] = f3731d.mo13691a(i);
            if (f3732e[i] == null) {
                f3732e[i] = f3731d.mo13692b(i);
            }
            if (f3732e[i] == null) {
                f3732e[i] = "<INVALID>";
            }
        }
        f3733f = new C1795e().m13619a("\u0003悋Ꜫ脳맭䅼㯧瞆奤\u0003\u000e:\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0003\u0002\u0003\u0002\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0007\u0003\u0013\n\u0003\f\u0003\u000e\u0003\u0016\u000b\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0005\u0003\u001c\n\u0003\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0007\u0005&\n\u0005\f\u0005\u000e\u0005)\u000b\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005/\n\u0005\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0005\u00068\n\u0006\u0003\u0006\u0002\u0002\u0007\u0002\u0004\u0006\b\n\u0002\u0002\u0002>\u0002\f\u0003\u0002\u0002\u0002\u0004\u001b\u0003\u0002\u0002\u0002\u0006\u001d\u0003\u0002\u0002\u0002\b.\u0003\u0002\u0002\u0002\n7\u0003\u0002\u0002\u0002\f\r\u0005\n\u0006\u0002\r\u0003\u0003\u0002\u0002\u0002\u000e\u000f\u0007\u0007\u0002\u0002\u000f\u0014\u0005\u0006\u0004\u0002\u0010\u0011\u0007\u000b\u0002\u0002\u0011\u0013\u0005\u0006\u0004\u0002\u0012\u0010\u0003\u0002\u0002\u0002\u0013\u0016\u0003\u0002\u0002\u0002\u0014\u0012\u0003\u0002\u0002\u0002\u0014\u0015\u0003\u0002\u0002\u0002\u0015\u0017\u0003\u0002\u0002\u0002\u0016\u0014\u0003\u0002\u0002\u0002\u0017\u0018\u0007\b\u0002\u0002\u0018\u001c\u0003\u0002\u0002\u0002\u0019\u001a\u0007\u0007\u0002\u0002\u001a\u001c\u0007\b\u0002\u0002\u001b\u000e\u0003\u0002\u0002\u0002\u001b\u0019\u0003\u0002\u0002\u0002\u001c\u0005\u0003\u0002\u0002\u0002\u001d\u001e\u0007\u0006\u0002\u0002\u001e\u001f\u0007\f\u0002\u0002\u001f \u0005\n\u0006\u0002 \u0007\u0003\u0002\u0002\u0002!\"\u0007\t\u0002\u0002\"'\u0005\n\u0006\u0002#$\u0007\u000b\u0002\u0002$&\u0005\n\u0006\u0002%#\u0003\u0002\u0002\u0002&)\u0003\u0002\u0002\u0002'%\u0003\u0002\u0002\u0002'(\u0003\u0002\u0002\u0002(*\u0003\u0002\u0002\u0002)'\u0003\u0002\u0002\u0002*+\u0007\n\u0002\u0002+/\u0003\u0002\u0002\u0002,-\u0007\t\u0002\u0002-/\u0007\n\u0002\u0002.!\u0003\u0002\u0002\u0002.,\u0003\u0002\u0002\u0002/\t\u0003\u0002\u0002\u000208\u0007\u0006\u0002\u000218\u0007\r\u0002\u000228\u0005\u0004\u0003\u000238\u0005\b\u0005\u000248\u0007\u0003\u0002\u000258\u0007\u0004\u0002\u000268\u0007\u0005\u0002\u000270\u0003\u0002\u0002\u000271\u0003\u0002\u0002\u000272\u0003\u0002\u0002\u000273\u0003\u0002\u0002\u000274\u0003\u0002\u0002\u000275\u0003\u0002\u0002\u000276\u0003\u0002\u0002\u00028\u000b\u0003\u0002\u0002\u0002\u0007\u0014\u001b'.7".toCharArray());
        f3728a = new C1827a[f3733f.m13481a()];
        for (int i2 = 0; i2 < f3733f.m13481a(); i2++) {
            f3728a[i2] = new C1827a(f3733f.m13483a(i2), i2);
        }
    }

    /* renamed from: j */
    private static String[] m4493j() {
        return new String[]{"json", "obj", "pair", "array", "value"};
    }

    /* renamed from: k */
    private static String[] m4494k() {
        String[] strArr = new String[11];
        strArr[1] = "'true'";
        strArr[2] = "'false'";
        strArr[3] = "'null'";
        strArr[5] = "'{'";
        strArr[6] = "'}'";
        strArr[7] = "'['";
        strArr[8] = "']'";
        strArr[9] = "','";
        strArr[10] = "':'";
        return strArr;
    }

    /* renamed from: l */
    private static String[] m4495l() {
        String[] strArr = new String[13];
        strArr[1] = "TRUE";
        strArr[2] = "FALSE";
        strArr[3] = "NULL";
        strArr[4] = "STRING";
        strArr[5] = "LBRACE";
        strArr[6] = "RBRACE";
        strArr[7] = "LBRACK";
        strArr[8] = "RBRACK";
        strArr[9] = "COMMA";
        strArr[10] = "COLON";
        strArr[11] = "NUMBER";
        strArr[12] = "WS";
        return strArr;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    @Deprecated
    /* renamed from: a */
    public String[] mo4046a() {
        return f3732e;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: b */
    public InterfaceC1823ag mo4047b() {
        return f3731d;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: c */
    public String[] mo4048c() {
        return f3730c;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: d */
    public C1759a mo4049d() {
        return f3733f;
    }

    public C0556e(InterfaceC1822af interfaceC1822af) {
        super(interfaceC1822af);
        this.f11013w = new C1771al(this, f3733f, f3728a, f3729b);
    }

    /* compiled from: JSONParser.java */
    /* renamed from: com.a.a.e$b */
    public static class b extends C1874v {
        public b(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 0;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0557f ? (T) ((InterfaceC0557f) interfaceC1851f).m4502a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: e */
    public final b m4496e() {
        b bVar = new b(this.f10993k, m13930cG());
        m13886a((C1874v) bVar, 0, 0);
        try {
            m13885a((C1874v) bVar, 1);
            m13931f(10);
            m4500i();
        } catch (C1876x e2) {
            bVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return bVar;
    }

    /* compiled from: JSONParser.java */
    /* renamed from: com.a.a.e$c */
    public static class c extends C1874v {
        public c(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 1;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0557f ? (T) ((InterfaceC0557f) interfaceC1851f).m4503a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: f */
    public final c m4497f() {
        c cVar = new c(this.f10993k, m13930cG());
        m13886a((C1874v) cVar, 2, 1);
        try {
            m13931f(25);
            this.f10990h.mo13700c(this);
            switch (((C1771al) m13926cC()).m13505a(this.f10991i, 1, this.f10993k)) {
                case 1:
                    m13885a((C1874v) cVar, 1);
                    m13931f(12);
                    m13878a(5);
                    m13931f(13);
                    m4498g();
                    m13931f(18);
                    this.f10990h.mo13700c(this);
                    int a2 = this.f10991i.mo13711a(1);
                    while (a2 == 9) {
                        m13931f(14);
                        m13878a(9);
                        m13931f(15);
                        m4498g();
                        m13931f(20);
                        this.f10990h.mo13700c(this);
                        a2 = this.f10991i.mo13711a(1);
                    }
                    m13931f(21);
                    m13878a(6);
                    break;
                case 2:
                    m13885a((C1874v) cVar, 2);
                    m13931f(23);
                    m13878a(5);
                    m13931f(24);
                    m13878a(6);
                    break;
            }
        } catch (C1876x e2) {
            cVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return cVar;
    }

    /* compiled from: JSONParser.java */
    /* renamed from: com.a.a.e$d */
    public static class d extends C1874v {
        public d(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 2;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0557f ? (T) ((InterfaceC0557f) interfaceC1851f).m4504a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: g */
    public final d m4498g() {
        d dVar = new d(this.f10993k, m13930cG());
        m13886a((C1874v) dVar, 4, 2);
        try {
            m13885a((C1874v) dVar, 1);
            m13931f(27);
            m13878a(4);
            m13931f(28);
            m13878a(10);
            m13931f(29);
            m4500i();
        } catch (C1876x e2) {
            dVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return dVar;
    }

    /* compiled from: JSONParser.java */
    /* renamed from: com.a.a.e$a */
    public static class a extends C1874v {
        public a(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 3;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0557f ? (T) ((InterfaceC0557f) interfaceC1851f).m4501a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: h */
    public final a m4499h() {
        a aVar = new a(this.f10993k, m13930cG());
        m13886a((C1874v) aVar, 6, 3);
        try {
            m13931f(44);
            this.f10990h.mo13700c(this);
            switch (((C1771al) m13926cC()).m13505a(this.f10991i, 3, this.f10993k)) {
                case 1:
                    m13885a((C1874v) aVar, 1);
                    m13931f(31);
                    m13878a(7);
                    m13931f(32);
                    m4500i();
                    m13931f(37);
                    this.f10990h.mo13700c(this);
                    int a2 = this.f10991i.mo13711a(1);
                    while (a2 == 9) {
                        m13931f(33);
                        m13878a(9);
                        m13931f(34);
                        m4500i();
                        m13931f(39);
                        this.f10990h.mo13700c(this);
                        a2 = this.f10991i.mo13711a(1);
                    }
                    m13931f(40);
                    m13878a(8);
                    break;
                case 2:
                    m13885a((C1874v) aVar, 2);
                    m13931f(42);
                    m13878a(7);
                    m13931f(43);
                    m13878a(8);
                    break;
            }
        } catch (C1876x e2) {
            aVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return aVar;
    }

    /* compiled from: JSONParser.java */
    /* renamed from: com.a.a.e$e */
    public static class e extends C1874v {
        public e(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 4;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0557f ? (T) ((InterfaceC0557f) interfaceC1851f).m4505a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: i */
    public final e m4500i() {
        e eVar = new e(this.f10993k, m13930cG());
        m13886a((C1874v) eVar, 8, 4);
        try {
            m13931f(53);
            this.f10990h.mo13700c(this);
            switch (this.f10991i.mo13711a(1)) {
                case 1:
                    m13885a((C1874v) eVar, 5);
                    m13931f(50);
                    m13878a(1);
                    break;
                case 2:
                    m13885a((C1874v) eVar, 6);
                    m13931f(51);
                    m13878a(2);
                    break;
                case 3:
                    m13885a((C1874v) eVar, 7);
                    m13931f(52);
                    m13878a(3);
                    break;
                case 4:
                    m13885a((C1874v) eVar, 1);
                    m13931f(46);
                    m13878a(4);
                    break;
                case 5:
                    m13885a((C1874v) eVar, 3);
                    m13931f(48);
                    m4497f();
                    break;
                case 6:
                case 8:
                case 9:
                case 10:
                default:
                    throw new C1872t(this);
                case 7:
                    m13885a((C1874v) eVar, 4);
                    m13931f(49);
                    m4499h();
                    break;
                case 11:
                    m13885a((C1874v) eVar, 2);
                    m13931f(47);
                    m13878a(11);
                    break;
            }
        } catch (C1876x e2) {
            eVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return eVar;
    }
}
