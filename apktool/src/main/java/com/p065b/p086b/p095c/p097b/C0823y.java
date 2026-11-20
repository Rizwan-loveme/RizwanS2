package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p095c.C0765b;
import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0925g;
import com.p065b.p086b.p103f.p105b.C0930l;
import com.p065b.p086b.p103f.p105b.C0931m;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p105b.C0941w;
import com.p065b.p086b.p103f.p105b.C0942x;
import com.p065b.p086b.p103f.p105b.C0943y;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p110h.C1012c;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;

/* compiled from: RopTranslator.java */
/* renamed from: com.b.b.c.b.y */
/* loaded from: classes.dex */
public final class C0823y {

    /* renamed from: a */
    private final C0765b f5096a;

    /* renamed from: b */
    private final C0938t f5097b;

    /* renamed from: c */
    private final int f5098c;

    /* renamed from: d */
    private final C0930l f5099d;

    /* renamed from: e */
    private final C0800b f5100e;

    /* renamed from: f */
    private final C0819u f5101f;

    /* renamed from: g */
    private final b f5102g;

    /* renamed from: h */
    private final int f5103h;

    /* renamed from: i */
    private int[] f5104i = null;

    /* renamed from: j */
    private final int f5105j;

    /* renamed from: k */
    private boolean f5106k;

    /* renamed from: a */
    public static C0806h m7163a(C0938t c0938t, int i, C0930l c0930l, int i2, C0765b c0765b) {
        return new C0823y(c0938t, i, c0930l, i2, c0765b).m7162a();
    }

    private C0823y(C0938t c0938t, int i, C0930l c0930l, int i2, C0765b c0765b) {
        this.f5096a = c0765b;
        this.f5097b = c0938t;
        this.f5098c = i;
        this.f5099d = c0930l;
        this.f5100e = new C0800b(c0938t);
        this.f5105j = i2;
        this.f5106k = m7167a(c0938t, i2);
        C0921c m7977a = c0938t.m7977a();
        int f_ = m7977a.m8550f_();
        int m7860f = (f_ * 3) + m7977a.m7860f();
        m7860f = c0930l != null ? m7860f + c0930l.m7908b() + f_ : m7860f;
        this.f5103h = (this.f5106k ? 0 : this.f5105j) + m7977a.m7859e();
        this.f5101f = new C0819u(c0765b, m7860f, f_ * 3, this.f5103h);
        if (c0930l != null) {
            this.f5102g = new a(this.f5101f, c0930l);
        } else {
            this.f5102g = new b(this.f5101f);
        }
    }

    /* renamed from: a */
    private static boolean m7167a(C0938t c0938t, final int i) {
        final boolean[] zArr = {true};
        final int m7859e = c0938t.m7977a().m7859e();
        c0938t.m7977a().m7857a(new AbstractC0926h.a() { // from class: com.b.b.c.b.y.1
            @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.a, com.p065b.p086b.p103f.p105b.AbstractC0926h.b
            /* renamed from: a */
            public void mo7176a(C0931m c0931m) {
                if (c0931m.m7882f().m7968a() == 3) {
                    zArr[0] = zArr[0] && ((C0959m) c0931m.m7868i_()).m8061k_() + (m7859e - i) == c0931m.m7884h().m7931g();
                }
            }
        });
        return zArr[0];
    }

    /* renamed from: a */
    private C0806h m7162a() {
        m7173c();
        m7170b();
        return new C0806h(this.f5098c, this.f5101f.m7128a(), new C0795aa(this.f5097b, this.f5104i, this.f5100e));
    }

    /* renamed from: b */
    private void m7170b() {
        C0921c m7977a = this.f5097b.m7977a();
        int[] iArr = this.f5104i;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 1;
            m7166a(m7977a.m7858b(iArr[i]), i2 == iArr.length ? -1 : iArr[i2]);
        }
    }

    /* renamed from: a */
    private void m7166a(C0920b c0920b, int i) {
        C0804f m6998a = this.f5100e.m6998a(c0920b);
        this.f5101f.m7130a(m6998a);
        if (this.f5099d != null) {
            this.f5101f.m7130a(new C0816r(m6998a.m7042i(), this.f5099d.m7905a(c0920b)));
        }
        this.f5102g.m7184a(c0920b, this.f5100e.m6999b(c0920b));
        c0920b.m7846b().m7891a(this.f5102g);
        this.f5101f.m7130a(this.f5100e.m7000c(c0920b));
        int m7848d = c0920b.m7848d();
        AbstractC0926h m7851g = c0920b.m7851g();
        if (m7848d >= 0 && m7848d != i) {
            if (m7851g.m7882f().m7971d() == 4 && c0920b.m7849e() == i) {
                this.f5101f.m7129a(1, this.f5100e.m6997a(m7848d));
            } else {
                this.f5101f.m7130a(new C0797ac(C0810l.f4818P, m7851g.m7883g(), C0935q.f5906a, this.f5100e.m6997a(m7848d)));
            }
        }
    }

    /* renamed from: c */
    private void m7173c() {
        int i;
        int m8569b;
        C0921c m7977a = this.f5097b.m7977a();
        int f_ = m7977a.m8550f_();
        int j = m7977a.m8587j();
        int[] m8489a = C1012c.m8489a(j);
        int[] m8489a2 = C1012c.m8489a(j);
        for (int i2 = 0; i2 < f_; i2++) {
            C1012c.m8490b(m8489a, m7977a.m7854a(i2).mo6568a());
        }
        int[] iArr = new int[f_];
        int m7979b = this.f5097b.m7979b();
        int i3 = 0;
        while (m7979b != -1) {
            while (true) {
                C1025p m7978a = this.f5097b.m7978a(m7979b);
                int m8568b = m7978a.m8568b();
                for (int i4 = 0; i4 < m8568b; i4++) {
                    m8569b = m7978a.m8569b(i4);
                    if (C1012c.m8487a(m8489a2, m8569b)) {
                        break;
                    }
                    if (C1012c.m8487a(m8489a, m8569b) && m7977a.m7858b(m8569b).m7848d() == m7979b) {
                        break;
                    }
                }
                C1012c.m8490b(m8489a2, m8569b);
                m7979b = m8569b;
            }
            int i5 = i3;
            while (true) {
                if (m7979b != -1) {
                    C1012c.m8493c(m8489a, m7979b);
                    C1012c.m8493c(m8489a2, m7979b);
                    iArr[i5] = m7979b;
                    int i6 = i5 + 1;
                    C0920b m7858b = m7977a.m7858b(m7979b);
                    C0920b m7855a = m7977a.m7855a(m7858b);
                    if (m7855a == null) {
                        i5 = i6;
                        break;
                    }
                    m7979b = m7855a.mo6568a();
                    int m7848d = m7858b.m7848d();
                    if (!C1012c.m8487a(m8489a, m7979b)) {
                        if (m7848d == m7979b || m7848d < 0 || !C1012c.m8487a(m8489a, m7848d)) {
                            C1025p m7847c = m7858b.m7847c();
                            int m8568b2 = m7847c.m8568b();
                            while (true) {
                                if (i >= m8568b2) {
                                    m7979b = -1;
                                    break;
                                } else {
                                    m7979b = m7847c.m8569b(i);
                                    i = C1012c.m8487a(m8489a, m7979b) ? 0 : i + 1;
                                }
                            }
                        } else {
                            m7979b = m7848d;
                        }
                    }
                    i5 = i6;
                }
            }
            m7979b = C1012c.m8494d(m8489a, 0);
            i3 = i5;
        }
        if (i3 != f_) {
            throw new RuntimeException("shouldn't happen");
        }
        this.f5104i = iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C0935q m7168b(AbstractC0926h abstractC0926h) {
        return m7169b(abstractC0926h, abstractC0926h.m7884h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C0935q m7169b(AbstractC0926h abstractC0926h, C0934p c0934p) {
        C0935q m7886j = abstractC0926h.m7886j();
        if (abstractC0926h.m7882f().m7973f() && m7886j.m8550f_() == 2 && c0934p.m7931g() == m7886j.m7949b(1).m7931g()) {
            m7886j = C0935q.m7945a(m7886j.m7949b(1), m7886j.m7949b(0));
        }
        return c0934p == null ? m7886j : m7886j.m7950b(c0934p);
    }

    /* compiled from: RopTranslator.java */
    /* renamed from: com.b.b.c.b.y$b */
    private class b implements AbstractC0926h.b {

        /* renamed from: a */
        private final C0819u f5112a;

        /* renamed from: c */
        private C0920b f5114c;

        /* renamed from: d */
        private C0804f f5115d;

        public b(C0819u c0819u) {
            this.f5112a = c0819u;
        }

        /* renamed from: a */
        public void m7184a(C0920b c0920b, C0804f c0804f) {
            this.f5114c = c0920b;
            this.f5115d = c0804f;
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7178a(C0932n c0932n) {
            AbstractC0807i c0797ac;
            C0937s f2 = c0932n.m7882f();
            if (f2.m7968a() != 54 && f2.m7968a() != 56) {
                C0940v g = c0932n.m7883g();
                C0809k m7160a = C0822x.m7160a(c0932n);
                switch (f2.m7971d()) {
                    case 1:
                    case 2:
                    case 6:
                        c0797ac = new C0824z(m7160a, g, C0823y.m7168b(c0932n));
                        break;
                    case 3:
                        return;
                    case 4:
                        c0797ac = new C0797ac(m7160a, g, C0823y.m7168b(c0932n), C0823y.this.f5100e.m6997a(this.f5114c.m7847c().m8569b(1)));
                        break;
                    case 5:
                    default:
                        throw new RuntimeException("shouldn't happen");
                }
                m7183a(c0797ac);
            }
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7176a(C0931m c0931m) {
            C0940v g = c0931m.m7883g();
            C0809k m7160a = C0822x.m7160a(c0931m);
            C0937s f2 = c0931m.m7882f();
            int m7968a = f2.m7968a();
            if (f2.m7971d() != 1) {
                throw new RuntimeException("shouldn't happen");
            }
            if (m7968a == 3) {
                if (!C0823y.this.f5106k) {
                    C0934p h = c0931m.m7884h();
                    m7183a(new C0824z(m7160a, g, C0935q.m7945a(h, C0934p.m7913a(((C0959m) c0931m.m7868i_()).m8061k_() + (C0823y.this.f5103h - C0823y.this.f5105j), h.mo6695a()))));
                    return;
                }
                return;
            }
            m7183a(new C0805g(m7160a, g, C0823y.m7168b(c0931m), c0931m.m7868i_()));
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7179a(C0941w c0941w) {
            C0940v g = c0941w.m7883g();
            C1025p m8031c = c0941w.m8031c();
            C1025p m7847c = this.f5114c.m7847c();
            int m8568b = m8031c.m8568b();
            int m8568b2 = m7847c.m8568b();
            int m7848d = this.f5114c.m7848d();
            if (m8568b != m8568b2 - 1 || m7848d != m7847c.m8569b(m8568b)) {
                throw new RuntimeException("shouldn't happen");
            }
            C0804f[] c0804fArr = new C0804f[m8568b];
            for (int i = 0; i < m8568b; i++) {
                c0804fArr[i] = C0823y.this.f5100e.m6997a(m7847c.m8569b(i));
            }
            C0804f c0804f = new C0804f(g);
            C0796ab c0796ab = new C0796ab(g, this.f5115d, m8031c, c0804fArr);
            AbstractC0807i c0797ac = new C0797ac(c0796ab.m6988c() ? C0810l.f4821S : C0810l.f4822T, g, C0823y.m7168b(c0941w), c0804f);
            m7183a(this.f5115d);
            m7183a(c0797ac);
            m7186b(new C0818t(g));
            m7186b(c0804f);
            m7186b(c0796ab);
        }

        /* renamed from: a */
        private C0934p m7182a() {
            int m7848d = this.f5114c.m7848d();
            if (m7848d < 0) {
                return null;
            }
            AbstractC0926h m7889a = C0823y.this.f5097b.m7977a().m7858b(m7848d).m7846b().m7889a(0);
            if (m7889a.m7882f().m7968a() == 56) {
                return m7889a.m7884h();
            }
            return null;
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7180a(C0942x c0942x) {
            AbstractC0807i c0805g;
            C0940v g = c0942x.m7883g();
            C0809k m7160a = C0822x.m7160a(c0942x);
            C0937s f2 = c0942x.m7882f();
            AbstractC0945a i_ = c0942x.m7868i_();
            if (f2.m7971d() != 6) {
                throw new RuntimeException("shouldn't happen");
            }
            m7183a(this.f5115d);
            if (f2.m7972e()) {
                m7183a(new C0805g(m7160a, g, c0942x.m7886j(), i_));
                return;
            }
            C0934p m7182a = m7182a();
            C0935q m7169b = C0823y.m7169b(c0942x, m7182a);
            if ((m7160a.m7059d() || f2.m7968a() == 43) != (m7182a != null)) {
                throw new RuntimeException("Insn with result/move-result-pseudo mismatch " + c0942x);
            }
            if (f2.m7968a() == 41 && m7160a.m7056a() != 35) {
                c0805g = new C0824z(m7160a, g, m7169b);
            } else {
                c0805g = new C0805g(m7160a, g, m7169b, i_);
            }
            m7183a(c0805g);
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7181a(C0943y c0943y) {
            C0940v g = c0943y.m7883g();
            C0809k m7160a = C0822x.m7160a(c0943y);
            if (c0943y.m7882f().m7971d() != 6) {
                throw new RuntimeException("shouldn't happen");
            }
            C0934p m7182a = m7182a();
            if (m7160a.m7059d() != (m7182a != null)) {
                throw new RuntimeException("Insn with result/move-result-pseudo mismatch" + c0943y);
            }
            m7183a(this.f5115d);
            m7183a(new C0824z(m7160a, g, C0823y.m7169b(c0943y, m7182a)));
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7185a(C0925g c0925g) {
            C0940v g = c0925g.m7883g();
            AbstractC0945a m7878e = c0925g.m7878e();
            ArrayList<AbstractC0945a> m7877c = c0925g.m7877c();
            if (c0925g.m7882f().m7971d() != 1) {
                throw new RuntimeException("shouldn't happen");
            }
            C0804f c0804f = new C0804f(g);
            AbstractC0807i c0766a = new C0766a(g, this.f5115d, m7877c, m7878e);
            AbstractC0807i c0797ac = new C0797ac(C0810l.f4816N, g, C0823y.m7168b(c0925g), c0804f);
            m7183a(this.f5115d);
            m7183a(c0797ac);
            m7186b(new C0818t(g));
            m7186b(c0804f);
            m7186b(c0766a);
        }

        /* renamed from: a */
        protected void m7183a(AbstractC0807i abstractC0807i) {
            this.f5112a.m7130a(abstractC0807i);
        }

        /* renamed from: b */
        protected void m7186b(AbstractC0807i abstractC0807i) {
            this.f5112a.m7131b(abstractC0807i);
        }
    }

    /* compiled from: RopTranslator.java */
    /* renamed from: com.b.b.c.b.y$a */
    private class a extends b {

        /* renamed from: c */
        private C0930l f5111c;

        public a(C0819u c0819u, C0930l c0930l) {
            super(c0819u);
            this.f5111c = c0930l;
        }

        @Override // com.p065b.p086b.p095c.p097b.C0823y.b, com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7178a(C0932n c0932n) {
            super.mo7178a(c0932n);
            m7177a((AbstractC0926h) c0932n);
        }

        @Override // com.p065b.p086b.p095c.p097b.C0823y.b, com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7176a(C0931m c0931m) {
            super.mo7176a(c0931m);
            m7177a((AbstractC0926h) c0931m);
        }

        @Override // com.p065b.p086b.p095c.p097b.C0823y.b, com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7179a(C0941w c0941w) {
            super.mo7179a(c0941w);
            m7177a((AbstractC0926h) c0941w);
        }

        @Override // com.p065b.p086b.p095c.p097b.C0823y.b, com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7180a(C0942x c0942x) {
            super.mo7180a(c0942x);
            m7177a((AbstractC0926h) c0942x);
        }

        @Override // com.p065b.p086b.p095c.p097b.C0823y.b, com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7181a(C0943y c0943y) {
            super.mo7181a(c0943y);
            m7177a((AbstractC0926h) c0943y);
        }

        /* renamed from: a */
        public void m7177a(AbstractC0926h abstractC0926h) {
            C0934p m7903a = this.f5111c.m7903a(abstractC0926h);
            if (m7903a != null) {
                m7183a(new C0817s(abstractC0926h.m7883g(), m7903a));
            }
        }
    }
}
