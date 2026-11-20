package com.p065b.p086b.p095c.p096a;

import com.p065b.p086b.p087a.p089b.C0712h;
import com.p065b.p086b.p087a.p089b.C0723s;
import com.p065b.p086b.p087a.p091d.C0731b;
import com.p065b.p086b.p087a.p091d.C0735f;
import com.p065b.p086b.p087a.p091d.C0739j;
import com.p065b.p086b.p087a.p092e.InterfaceC0743d;
import com.p065b.p086b.p087a.p092e.InterfaceC0744e;
import com.p065b.p086b.p087a.p092e.InterfaceC0746g;
import com.p065b.p086b.p087a.p092e.InterfaceC0747h;
import com.p065b.p086b.p095c.C0765b;
import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p095c.p097b.C0823y;
import com.p065b.p086b.p095c.p099c.C0855h;
import com.p065b.p086b.p095c.p099c.C0862o;
import com.p065b.p086b.p095c.p099c.C0864q;
import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p105b.C0923e;
import com.p065b.p086b.p103f.p105b.C0929k;
import com.p065b.p086b.p103f.p105b.C0930l;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.C0952f;
import com.p065b.p086b.p103f.p106c.C0953g;
import com.p065b.p086b.p103f.p106c.C0954h;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0969w;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p108g.C0996m;
import com.p065b.p086b.p110h.C1019j;

/* compiled from: CfTranslator.java */
/* renamed from: com.b.b.c.a.c */
/* loaded from: classes.dex */
public class C0762c {
    /* renamed from: a */
    public static C0855h m6948a(String str, byte[] bArr, C0761b c0761b, C0765b c0765b) {
        try {
            return m6953b(str, bArr, c0761b, c0765b);
        } catch (RuntimeException e2) {
            throw C1019j.m8537a(e2, "...while processing " + str);
        }
    }

    /* renamed from: b */
    private static C0855h m6953b(String str, byte[] bArr, C0761b c0761b, C0765b c0765b) {
        C0735f c0735f = new C0735f(bArr, str, c0761b.f4715c);
        c0735f.m6839a((C0731b) C0739j.f4663a);
        c0735f.m6840b();
        C0764e.m6959a(c0761b.f4717e, c0761b.f4718f);
        C0855h c0855h = new C0855h(c0735f.m6842d(), c0735f.mo6841c() & (-33), c0735f.m6843e(), c0735f.m6845g(), c0761b.f4713a == 1 ? null : c0735f.mo6849k());
        C0916c m6939a = C0760a.m6939a(c0735f, c0761b);
        if (m6939a.m7826b() != 0) {
            c0855h.m7339a(m6939a);
        }
        m6951a(c0735f, c0855h);
        m6950a(c0735f, c0761b, c0765b, c0855h);
        return c0855h;
    }

    /* renamed from: a */
    private static void m6951a(C0735f c0735f, C0855h c0855h) {
        C0971y m6842d = c0735f.m6842d();
        InterfaceC0744e m6846h = c0735f.m6846h();
        int m6896f_ = m6846h.m6896f_();
        for (int i = 0; i < m6896f_; i++) {
            InterfaceC0743d mo6895a = m6846h.mo6895a(i);
            try {
                C0957k c0957k = new C0957k(m6842d, mo6895a.mo6603a());
                int d2 = mo6895a.mo6606d();
                if (C0919a.m7841f(d2)) {
                    AbstractC0946aa mo6894g = mo6895a.mo6894g();
                    C0862o c0862o = new C0862o(c0957k, d2);
                    if (mo6894g != null) {
                        mo6894g = m6949a(mo6894g, c0957k.mo6695a());
                    }
                    c0855h.m7337a(c0862o, mo6894g);
                } else {
                    c0855h.m7336a(new C0862o(c0957k, d2));
                }
                C0916c m6940a = C0760a.m6940a(mo6895a.mo6607e());
                if (m6940a.m7826b() != 0) {
                    c0855h.m7340a(c0957k, m6940a);
                }
            } catch (RuntimeException e2) {
                throw C1019j.m8537a(e2, "...while processing " + mo6895a.mo6604b().mo6681d() + " " + mo6895a.mo6605c().mo6681d());
            }
        }
    }

    /* renamed from: a */
    private static AbstractC0946aa m6949a(AbstractC0946aa abstractC0946aa, C0975c c0975c) {
        if (!abstractC0946aa.mo6695a().equals(c0975c)) {
            switch (c0975c.mo6697c()) {
                case 1:
                    return C0952f.m8050a(((C0959m) abstractC0946aa).m8061k_());
                case 2:
                    return C0953g.m8053a(((C0959m) abstractC0946aa).m8061k_());
                case 3:
                    return C0954h.m8055a(((C0959m) abstractC0946aa).m8061k_());
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    throw new UnsupportedOperationException("can't coerce " + abstractC0946aa + " to " + c0975c);
                case 8:
                    return C0969w.m8077a(((C0959m) abstractC0946aa).m8061k_());
            }
        }
        return abstractC0946aa;
    }

    /* renamed from: a */
    private static void m6950a(C0735f c0735f, C0761b c0761b, C0765b c0765b, C0855h c0855h) {
        C0806h c0806h;
        int i;
        C0938t c0938t;
        C0971y m6842d = c0735f.m6842d();
        InterfaceC0747h m6847i = c0735f.m6847i();
        int m6898f_ = m6847i.m6898f_();
        for (int i2 = 0; i2 < m6898f_; i2++) {
            InterfaceC0746g mo6897a = m6847i.mo6897a(i2);
            try {
                C0967u c0967u = new C0967u(m6842d, mo6897a.mo6603a());
                int d2 = mo6897a.mo6606d();
                boolean m7841f = C0919a.m7841f(d2);
                boolean m7840e = C0919a.m7840e(d2);
                boolean m7844i = C0919a.m7844i(d2);
                boolean m7843h = C0919a.m7843h(d2);
                boolean z = c0967u.m8048j() || c0967u.m8049k();
                if (m7844i || m7843h) {
                    c0806h = null;
                } else {
                    C0712h c0712h = new C0712h(mo6897a, c0735f, c0761b.f4713a != 1, c0761b.f4714b);
                    C0923e c0923e = C0923e.f5863a;
                    C0938t m6706a = C0723s.m6706a(c0712h, c0923e);
                    C0938t c0938t2 = null;
                    int b2 = c0967u.m8046b(m7841f);
                    String str = m6842d.m8090i().m8125h() + "." + mo6897a.mo6604b().m8084j();
                    if (c0761b.f4716d && C0764e.m6960a(str)) {
                        c0938t = C0996m.m8298a(m6706a, b2, m7841f, c0761b.f4714b, c0923e);
                        if (c0761b.f4719g) {
                            C0763d.m6957a(m6706a, c0938t);
                        }
                        c0938t2 = m6706a;
                    } else {
                        c0938t = m6706a;
                    }
                    C0930l c0930l = null;
                    if (c0761b.f4714b) {
                        c0930l = C0929k.m7900a(c0938t);
                    }
                    C0806h m7163a = C0823y.m7163a(c0938t, c0761b.f4713a, c0930l, b2, c0765b);
                    if (c0761b.f4719g && c0938t2 != null) {
                        m6952a(c0761b, c0765b, c0938t, c0938t2, c0930l, b2, c0712h.m6613k().m6599b());
                    }
                    c0806h = m7163a;
                }
                if (C0919a.m7842g(d2)) {
                    i = 131072 | d2;
                    if (!m7844i) {
                        i &= -33;
                    }
                } else {
                    i = d2;
                }
                if (z) {
                    i |= 65536;
                }
                C0864q c0864q = new C0864q(c0967u, i, c0806h, C0760a.m6942a(mo6897a));
                if (c0967u.m8048j() || c0967u.m8049k() || m7841f || m7840e) {
                    c0855h.m7338a(c0864q);
                } else {
                    c0855h.m7344b(c0864q);
                }
                C0916c m6944b = C0760a.m6944b(mo6897a);
                if (m6944b.m7826b() != 0) {
                    c0855h.m7341a(c0967u, m6944b);
                }
                C0917d m6946c = C0760a.m6946c(mo6897a);
                if (m6946c.m8550f_() != 0) {
                    c0855h.m7342a(c0967u, m6946c);
                }
            } catch (RuntimeException e2) {
                throw C1019j.m8537a(e2, "...while processing " + mo6897a.mo6604b().mo6681d() + " " + mo6897a.mo6605c().mo6681d());
            }
        }
    }

    /* renamed from: a */
    private static void m6952a(C0761b c0761b, C0765b c0765b, C0938t c0938t, C0938t c0938t2, C0930l c0930l, int i, int i2) {
        C0806h m7163a = C0823y.m7163a(c0938t, c0761b.f4713a, c0930l, i, c0765b);
        C0806h m7163a2 = C0823y.m7163a(c0938t2, c0761b.f4713a, c0930l, i, c0765b);
        C0806h.a aVar = new C0806h.a() { // from class: com.b.b.c.a.c.1
            @Override // com.p065b.p086b.p095c.p097b.C0806h.a
            /* renamed from: a */
            public int mo6954a(AbstractC0945a abstractC0945a) {
                return 0;
            }
        };
        m7163a.m7022a(aVar);
        m7163a2.m7022a(aVar);
        C0763d.m6956a(m7163a2, m7163a);
        C0763d.m6955a(i2);
    }
}
