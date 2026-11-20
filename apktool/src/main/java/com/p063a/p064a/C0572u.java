package com.p063a.p064a;

import android.content.ContentResolver;
import java.util.List;
import org.p210a.p211a.p212a.AbstractC1873u;
import org.p210a.p211a.p212a.C1817aa;
import org.p210a.p211a.p212a.C1824ah;
import org.p210a.p211a.p212a.C1872t;
import org.p210a.p211a.p212a.C1874v;
import org.p210a.p211a.p212a.C1876x;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.InterfaceC1823ag;
import org.p210a.p211a.p212a.p213a.C1759a;
import org.p210a.p211a.p212a.p213a.C1771al;
import org.p210a.p211a.p212a.p213a.C1777ar;
import org.p210a.p211a.p212a.p213a.C1795e;
import org.p210a.p211a.p212a.p214b.C1827a;
import org.p210a.p211a.p212a.p216d.InterfaceC1851f;
import org.p210a.p211a.p212a.p216d.InterfaceC1854i;

/* compiled from: XMLParser.java */
/* renamed from: com.a.a.u */
/* loaded from: classes.dex */
public class C0572u extends AbstractC1873u {

    /* renamed from: a */
    protected static final C1827a[] f3880a;

    /* renamed from: b */
    protected static final C1777ar f3881b;

    /* renamed from: c */
    public static final String[] f3882c;

    /* renamed from: d */
    public static final InterfaceC1823ag f3883d;

    /* renamed from: e */
    @Deprecated
    public static final String[] f3884e;

    /* renamed from: f */
    public static final C1759a f3885f;

    /* renamed from: g */
    private static final String[] f3886g;

    /* renamed from: p */
    private static final String[] f3887p;

    static {
        C1817aa.m13671a("4.7.2", "4.7.2");
        f3881b = new C1777ar();
        f3882c = m5535m();
        f3886g = m5536n();
        f3887p = m5537o();
        f3883d = new C1824ah(f3886g, f3887p);
        f3884e = new String[f3887p.length];
        for (int i = 0; i < f3884e.length; i++) {
            f3884e[i] = f3883d.mo13691a(i);
            if (f3884e[i] == null) {
                f3884e[i] = f3883d.mo13692b(i);
            }
            if (f3884e[i] == null) {
                f3884e[i] = "<INVALID>";
            }
        }
        f3885f = new C1795e().m13619a("\u0003悋Ꜫ脳맭䅼㯧瞆奤\u0003\u0014b\u0004\u0002\t\u0002\u0004\u0003\t\u0003\u0004\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004\b\t\b\u0004\t\t\t\u0003\u0002\u0005\u0002\u0014\n\u0002\u0003\u0002\u0007\u0002\u0017\n\u0002\f\u0002\u000e\u0002\u001a\u000b\u0002\u0003\u0002\u0003\u0002\u0007\u0002\u001e\n\u0002\f\u0002\u000e\u0002!\u000b\u0002\u0003\u0003\u0003\u0003\u0007\u0003%\n\u0003\f\u0003\u000e\u0003(\u000b\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0005\u0004-\n\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0005\u00044\n\u0004\u0003\u0004\u0005\u00047\n\u0004\u0007\u00049\n\u0004\f\u0004\u000e\u0004<\u000b\u0004\u0003\u0005\u0003\u0005\u0003\u0005\u0007\u0005A\n\u0005\f\u0005\u000e\u0005D\u000b\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0007\u0005P\n\u0005\f\u0005\u000e\u0005S\u000b\u0005\u0003\u0005\u0005\u0005V\n\u0005\u0003\u0006\u0003\u0006\u0003\u0007\u0003\u0007\u0003\u0007\u0003\u0007\u0003\b\u0003\b\u0003\t\u0003\t\u0003\t\u0002\u0002\n\u0002\u0004\u0006\b\n\f\u000e\u0010\u0002\u0005\u0003\u0002\u0006\u0007\u0004\u0002\b\b\u000b\u000b\u0005\u0002\u0003\u0003\b\b\u0014\u0014\u0002g\u0002\u0013\u0003\u0002\u0002\u0002\u0004\"\u0003\u0002\u0002\u0002\u0006,\u0003\u0002\u0002\u0002\bU\u0003\u0002\u0002\u0002\nW\u0003\u0002\u0002\u0002\fY\u0003\u0002\u0002\u0002\u000e]\u0003\u0002\u0002\u0002\u0010_\u0003\u0002\u0002\u0002\u0012\u0014\u0005\u0004\u0003\u0002\u0013\u0012\u0003\u0002\u0002\u0002\u0013\u0014\u0003\u0002\u0002\u0002\u0014\u0018\u0003\u0002\u0002\u0002\u0015\u0017\u0005\u0010\t\u0002\u0016\u0015\u0003\u0002\u0002\u0002\u0017\u001a\u0003\u0002\u0002\u0002\u0018\u0016\u0003\u0002\u0002\u0002\u0018\u0019\u0003\u0002\u0002\u0002\u0019\u001b\u0003\u0002\u0002\u0002\u001a\u0018\u0003\u0002\u0002\u0002\u001b\u001f\u0005\b\u0005\u0002\u001c\u001e\u0005\u0010\t\u0002\u001d\u001c\u0003\u0002\u0002\u0002\u001e!\u0003\u0002\u0002\u0002\u001f\u001d\u0003\u0002\u0002\u0002\u001f \u0003\u0002\u0002\u0002 \u0003\u0003\u0002\u0002\u0002!\u001f\u0003\u0002\u0002\u0002\"&\u0007\n\u0002\u0002#%\u0005\f\u0007\u0002$#\u0003\u0002\u0002\u0002%(\u0003\u0002\u0002\u0002&$\u0003\u0002\u0002\u0002&'\u0003\u0002\u0002\u0002')\u0003\u0002\u0002\u0002(&\u0003\u0002\u0002\u0002)*\u0007\r\u0002\u0002*\u0005\u0003\u0002\u0002\u0002+-\u0005\u000e\b\u0002,+\u0003\u0002\u0002\u0002,-\u0003\u0002\u0002\u0002-:\u0003\u0002\u0002\u0002.4\u0005\b\u0005\u0002/4\u0005\n\u0006\u000204\u0007\u0004\u0002\u000214\u0007\u0014\u0002\u000224\u0007\u0003\u0002\u00023.\u0003\u0002\u0002\u00023/\u0003\u0002\u0002\u000230\u0003\u0002\u0002\u000231\u0003\u0002\u0002\u000232\u0003\u0002\u0002\u000246\u0003\u0002\u0002\u000257\u0005\u000e\b\u000265\u0003\u0002\u0002\u000267\u0003\u0002\u0002\u000279\u0003\u0002\u0002\u000283\u0003\u0002\u0002\u00029<\u0003\u0002\u0002\u0002:8\u0003\u0002\u0002\u0002:;\u0003\u0002\u0002\u0002;\u0007\u0003\u0002\u0002\u0002<:\u0003\u0002\u0002\u0002=>\u0007\t\u0002\u0002>B\u0007\u0012\u0002\u0002?A\u0005\f\u0007\u0002@?\u0003\u0002\u0002\u0002AD\u0003\u0002\u0002\u0002B@\u0003\u0002\u0002\u0002BC\u0003\u0002\u0002\u0002CE\u0003\u0002\u0002\u0002DB\u0003\u0002\u0002\u0002EF\u0007\f\u0002\u0002FG\u0005\u0006\u0004\u0002GH\u0007\t\u0002\u0002HI\u0007\u000f\u0002\u0002IJ\u0007\u0012\u0002\u0002JK\u0007\f\u0002\u0002KV\u0003\u0002\u0002\u0002LM\u0007\t\u0002\u0002MQ\u0007\u0012\u0002\u0002NP\u0005\f\u0007\u0002ON\u0003\u0002\u0002\u0002PS\u0003\u0002\u0002\u0002QO\u0003\u0002\u0002\u0002QR\u0003\u0002\u0002\u0002RT\u0003\u0002\u0002\u0002SQ\u0003\u0002\u0002\u0002TV\u0007\u000e\u0002\u0002U=\u0003\u0002\u0002\u0002UL\u0003\u0002\u0002\u0002V\t\u0003\u0002\u0002\u0002WX\t\u0002\u0002\u0002X\u000b\u0003\u0002\u0002\u0002YZ\u0007\u0012\u0002\u0002Z[\u0007\u0010\u0002\u0002[\\\u0007\u0011\u0002\u0002\\\r\u0003\u0002\u0002\u0002]^\t\u0003\u0002\u0002^\u000f\u0003\u0002\u0002\u0002_`\t\u0004\u0002\u0002`\u0011\u0003\u0002\u0002\u0002\r\u0013\u0018\u001f&,36:BQU".toCharArray());
        f3880a = new C1827a[f3885f.m13481a()];
        for (int i2 = 0; i2 < f3885f.m13481a(); i2++) {
            f3880a[i2] = new C1827a(f3885f.m13483a(i2), i2);
        }
    }

    /* renamed from: m */
    private static String[] m5535m() {
        return new String[]{"document", "prolog", ContentResolver.SCHEME_CONTENT, "element", "reference", "attribute", "chardata", "misc"};
    }

    /* renamed from: n */
    private static String[] m5536n() {
        String[] strArr = new String[15];
        strArr[7] = "'<'";
        strArr[10] = "'>'";
        strArr[12] = "'/>'";
        strArr[13] = "'/'";
        strArr[14] = "'='";
        return strArr;
    }

    /* renamed from: o */
    private static String[] m5537o() {
        String[] strArr = new String[19];
        strArr[1] = "COMMENT";
        strArr[2] = "CDATA";
        strArr[3] = "DTD";
        strArr[4] = "EntityRef";
        strArr[5] = "CharRef";
        strArr[6] = "SEA_WS";
        strArr[7] = "OPEN";
        strArr[8] = "XMLDeclOpen";
        strArr[9] = "TEXT";
        strArr[10] = "CLOSE";
        strArr[11] = "SPECIAL_CLOSE";
        strArr[12] = "SLASH_CLOSE";
        strArr[13] = "SLASH";
        strArr[14] = "EQUALS";
        strArr[15] = "STRING";
        strArr[16] = "Name";
        strArr[17] = "S";
        strArr[18] = "PI";
        return strArr;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    @Deprecated
    /* renamed from: a */
    public String[] mo4046a() {
        return f3884e;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: b */
    public InterfaceC1823ag mo4047b() {
        return f3883d;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: c */
    public String[] mo4048c() {
        return f3882c;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    /* renamed from: d */
    public C1759a mo4049d() {
        return f3885f;
    }

    public C0572u(InterfaceC1822af interfaceC1822af) {
        super(interfaceC1822af);
        this.f11013w = new C1771al(this, f3885f, f3880a, f3881b);
    }

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$d */
    public static class d extends C1874v {
        public d(C1874v c1874v, int i) {
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
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5554a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: e */
    public final d m5538e() {
        d dVar = new d(this.f10993k, m13930cG());
        m13886a((C1874v) dVar, 0, 0);
        try {
            m13885a((C1874v) dVar, 1);
            m13931f(17);
            this.f10990h.mo13700c(this);
            if (this.f10991i.mo13711a(1) == 8) {
                m13931f(16);
                m5539f();
            }
            m13931f(22);
            this.f10990h.mo13700c(this);
            int a2 = this.f10991i.mo13711a(1);
            while ((a2 & (-64)) == 0 && ((1 << a2) & 262210) != 0) {
                m13931f(19);
                m5545l();
                m13931f(24);
                this.f10990h.mo13700c(this);
                a2 = this.f10991i.mo13711a(1);
            }
            m13931f(25);
            m5541h();
            m13931f(29);
            this.f10990h.mo13700c(this);
            int a3 = this.f10991i.mo13711a(1);
            while ((a3 & (-64)) == 0 && ((1 << a3) & 262210) != 0) {
                m13931f(26);
                m5545l();
                m13931f(31);
                this.f10990h.mo13700c(this);
                a3 = this.f10991i.mo13711a(1);
            }
        } catch (C1876x e2) {
            dVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return dVar;
    }

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$g */
    public static class g extends C1874v {
        public g(C1874v c1874v, int i) {
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
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5557a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: f */
    public final g m5539f() {
        g gVar = new g(this.f10993k, m13930cG());
        m13886a((C1874v) gVar, 2, 1);
        try {
            m13885a((C1874v) gVar, 1);
            m13931f(32);
            m13878a(8);
            m13931f(36);
            this.f10990h.mo13700c(this);
            int a2 = this.f10991i.mo13711a(1);
            while (a2 == 16) {
                m13931f(33);
                m5543j();
                m13931f(38);
                this.f10990h.mo13700c(this);
                a2 = this.f10991i.mo13711a(1);
            }
            m13931f(39);
            m13878a(11);
        } catch (C1876x e2) {
            gVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return gVar;
    }

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$c */
    public static class c extends C1874v {
        public c(C1874v c1874v, int i) {
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
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5553a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009e A[ADDED_TO_REGION] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c m5540g() {
        int a2;
        c cVar = new c(this.f10993k, m13930cG());
        m13886a((C1874v) cVar, 4, 2);
        try {
            m13885a((C1874v) cVar, 1);
            m13931f(42);
            this.f10990h.mo13700c(this);
            int a3 = this.f10991i.mo13711a(1);
            if (a3 == 6 || a3 == 9) {
                m13931f(41);
                m5544k();
            }
            m13931f(56);
            this.f10990h.mo13700c(this);
            int m13505a = ((C1771al) m13926cC()).m13505a(this.f10991i, 7, this.f10993k);
            while (m13505a != 2 && m13505a != 0) {
                if (m13505a == 1) {
                    m13931f(49);
                    this.f10990h.mo13700c(this);
                    switch (this.f10991i.mo13711a(1)) {
                        case 1:
                            m13931f(48);
                            m13878a(1);
                            m13931f(52);
                            this.f10990h.mo13700c(this);
                            a2 = this.f10991i.mo13711a(1);
                            if (a2 == 6 && a2 != 9) {
                                break;
                            } else {
                                m13931f(51);
                                m5544k();
                                break;
                            }
                        case 2:
                            m13931f(46);
                            m13878a(2);
                            m13931f(52);
                            this.f10990h.mo13700c(this);
                            a2 = this.f10991i.mo13711a(1);
                            if (a2 == 6) {
                            }
                            m13931f(51);
                            m5544k();
                            break;
                        case 4:
                        case 5:
                            m13931f(45);
                            m5542i();
                            m13931f(52);
                            this.f10990h.mo13700c(this);
                            a2 = this.f10991i.mo13711a(1);
                            if (a2 == 6) {
                            }
                            m13931f(51);
                            m5544k();
                            break;
                        case 7:
                            m13931f(44);
                            m5541h();
                            m13931f(52);
                            this.f10990h.mo13700c(this);
                            a2 = this.f10991i.mo13711a(1);
                            if (a2 == 6) {
                            }
                            m13931f(51);
                            m5544k();
                            break;
                        case 18:
                            m13931f(47);
                            m13878a(18);
                            m13931f(52);
                            this.f10990h.mo13700c(this);
                            a2 = this.f10991i.mo13711a(1);
                            if (a2 == 6) {
                            }
                            m13931f(51);
                            m5544k();
                            break;
                        default:
                            throw new C1872t(this);
                    }
                }
                m13931f(58);
                this.f10990h.mo13700c(this);
                m13505a = ((C1771al) m13926cC()).m13505a(this.f10991i, 7, this.f10993k);
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

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$e */
    public static class e extends C1874v {
        /* renamed from: a */
        public InterfaceC1854i m5548a(int i) {
            return m13911a(16, i);
        }

        /* renamed from: b */
        public c m5549b() {
            return (c) m13916b(c.class, 0);
        }

        /* renamed from: c */
        public List<a> m5550c() {
            return m13907a(a.class);
        }

        public e(C1874v c1874v, int i) {
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
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5555a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: h */
    public final e m5541h() {
        e eVar = new e(this.f10993k, m13930cG());
        m13886a((C1874v) eVar, 6, 3);
        try {
            m13931f(83);
            this.f10990h.mo13700c(this);
            switch (((C1771al) m13926cC()).m13505a(this.f10991i, 10, this.f10993k)) {
                case 1:
                    m13885a((C1874v) eVar, 1);
                    m13931f(59);
                    m13878a(7);
                    m13931f(60);
                    m13878a(16);
                    m13931f(64);
                    this.f10990h.mo13700c(this);
                    int a2 = this.f10991i.mo13711a(1);
                    while (a2 == 16) {
                        m13931f(61);
                        m5543j();
                        m13931f(66);
                        this.f10990h.mo13700c(this);
                        a2 = this.f10991i.mo13711a(1);
                    }
                    m13931f(67);
                    m13878a(10);
                    m13931f(68);
                    m5540g();
                    m13931f(69);
                    m13878a(7);
                    m13931f(70);
                    m13878a(13);
                    m13931f(71);
                    m13878a(16);
                    m13931f(72);
                    m13878a(10);
                    break;
                case 2:
                    m13885a((C1874v) eVar, 2);
                    m13931f(74);
                    m13878a(7);
                    m13931f(75);
                    m13878a(16);
                    m13931f(79);
                    this.f10990h.mo13700c(this);
                    int a3 = this.f10991i.mo13711a(1);
                    while (a3 == 16) {
                        m13931f(76);
                        m5543j();
                        m13931f(81);
                        this.f10990h.mo13700c(this);
                        a3 = this.f10991i.mo13711a(1);
                    }
                    m13931f(82);
                    m13878a(12);
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

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$h */
    public static class h extends C1874v {
        public h(C1874v c1874v, int i) {
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
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5558a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: i */
    public final h m5542i() {
        h hVar = new h(this.f10993k, m13930cG());
        m13886a((C1874v) hVar, 8, 4);
        try {
            m13885a((C1874v) hVar, 1);
            m13931f(85);
            int a2 = this.f10991i.mo13711a(1);
            if (a2 != 4 && a2 != 5) {
                this.f10990h.mo13698b(this);
            } else {
                if (this.f10991i.mo13711a(1) == -1) {
                    this.f10997o = true;
                }
                this.f10990h.mo13702e(this);
                m13903cw();
            }
        } catch (C1876x e2) {
            hVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return hVar;
    }

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$a */
    public static class a extends C1874v {

        /* renamed from: a */
        public InterfaceC1819ac f3888a;

        /* renamed from: b */
        public InterfaceC1819ac f3889b;

        /* renamed from: b */
        public InterfaceC1854i m5546b() {
            return m13911a(16, 0);
        }

        /* renamed from: c */
        public InterfaceC1854i m5547c() {
            return m13911a(15, 0);
        }

        public a(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 5;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5551a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: j */
    public final a m5543j() {
        a aVar = new a(this.f10993k, m13930cG());
        m13886a((C1874v) aVar, 10, 5);
        try {
            m13885a((C1874v) aVar, 1);
            m13931f(87);
            aVar.f3888a = m13878a(16);
            m13931f(88);
            m13878a(14);
            m13931f(89);
            aVar.f3889b = m13878a(15);
        } catch (C1876x e2) {
            aVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return aVar;
    }

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$b */
    public static class b extends C1874v {
        public b(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 6;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5552a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: k */
    public final b m5544k() {
        b bVar = new b(this.f10993k, m13930cG());
        m13886a((C1874v) bVar, 12, 6);
        try {
            m13885a((C1874v) bVar, 1);
            m13931f(91);
            int a2 = this.f10991i.mo13711a(1);
            if (a2 != 6 && a2 != 9) {
                this.f10990h.mo13698b(this);
            } else {
                if (this.f10991i.mo13711a(1) == -1) {
                    this.f10997o = true;
                }
                this.f10990h.mo13702e(this);
                m13903cw();
            }
        } catch (C1876x e2) {
            bVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return bVar;
    }

    /* compiled from: XMLParser.java */
    /* renamed from: com.a.a.u$f */
    public static class f extends C1874v {
        public f(C1874v c1874v, int i) {
            super(c1874v, i);
        }

        @Override // org.p210a.p211a.p212a.C1878z
        /* renamed from: a */
        public int mo4288a() {
            return 7;
        }

        @Override // org.p210a.p211a.p212a.C1878z, org.p210a.p211a.p212a.p216d.InterfaceC1849d
        /* renamed from: a */
        public <T> T mo4289a(InterfaceC1851f<? extends T> interfaceC1851f) {
            return interfaceC1851f instanceof InterfaceC0574w ? (T) ((InterfaceC0574w) interfaceC1851f).mo5556a(this) : interfaceC1851f.mo13782a(this);
        }
    }

    /* renamed from: l */
    public final f m5545l() {
        f fVar = new f(this.f10993k, m13930cG());
        m13886a((C1874v) fVar, 14, 7);
        try {
            m13885a((C1874v) fVar, 1);
            m13931f(93);
            int a2 = this.f10991i.mo13711a(1);
            if ((a2 & (-64)) != 0 || ((1 << a2) & 262210) == 0) {
                this.f10990h.mo13698b(this);
            } else {
                if (this.f10991i.mo13711a(1) == -1) {
                    this.f10997o = true;
                }
                this.f10990h.mo13702e(this);
                m13903cw();
            }
        } catch (C1876x e2) {
            fVar.f11002h = e2;
            this.f10990h.mo13699b(this, e2);
            this.f10990h.mo13697a(this, e2);
        } finally {
            m13905cy();
        }
        return fVar;
    }
}
