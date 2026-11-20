package org.p210a.p211a.p212a;

import org.p210a.p211a.p212a.p213a.AbstractC1797g;
import org.p210a.p211a.p212a.p213a.C1759a;
import org.p210a.p211a.p212a.p213a.C1782aw;
import org.p210a.p211a.p212a.p215c.C1840j;
import org.p210a.p211a.p212a.p215c.C1843m;

/* compiled from: DefaultErrorStrategy.java */
/* renamed from: org.a.a.a.n */
/* loaded from: classes.dex */
public class C1866n implements InterfaceC1826b {

    /* renamed from: a */
    protected boolean f10963a = false;

    /* renamed from: b */
    protected int f10964b = -1;

    /* renamed from: c */
    protected C1840j f10965c;

    /* renamed from: d */
    protected C1874v f10966d;

    /* renamed from: e */
    protected int f10967e;

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: a */
    public void mo13696a(AbstractC1873u abstractC1873u) {
        m13848g(abstractC1873u);
    }

    /* renamed from: f */
    protected void m13847f(AbstractC1873u abstractC1873u) {
        this.f10963a = true;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: d */
    public boolean mo13701d(AbstractC1873u abstractC1873u) {
        return this.f10963a;
    }

    /* renamed from: g */
    protected void m13848g(AbstractC1873u abstractC1873u) {
        this.f10963a = false;
        this.f10965c = null;
        this.f10964b = -1;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: e */
    public void mo13702e(AbstractC1873u abstractC1873u) {
        m13848g(abstractC1873u);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: b */
    public void mo13699b(AbstractC1873u abstractC1873u, C1876x c1876x) {
        if (!mo13701d(abstractC1873u)) {
            m13847f(abstractC1873u);
            if (c1876x instanceof C1872t) {
                m13844a(abstractC1873u, (C1872t) c1876x);
                return;
            }
            if (c1876x instanceof C1868p) {
                m13843a(abstractC1873u, (C1868p) c1876x);
            } else if (c1876x instanceof C1867o) {
                m13842a(abstractC1873u, (C1867o) c1876x);
            } else {
                System.err.println("unknown recognition error type: " + c1876x.getClass().getName());
                abstractC1873u.m13880a(c1876x.m13924d(), c1876x.getMessage(), c1876x);
            }
        }
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: a */
    public void mo13697a(AbstractC1873u abstractC1873u, C1876x c1876x) {
        if (this.f10964b == abstractC1873u.m13900ct().mo13717c() && this.f10965c != null && this.f10965c.m13766c(abstractC1873u.m13930cG())) {
            abstractC1873u.m13903cw();
        }
        this.f10964b = abstractC1873u.m13900ct().mo13717c();
        if (this.f10965c == null) {
            this.f10965c = new C1840j(new int[0]);
        }
        this.f10965c.m13761b(abstractC1873u.m13930cG());
        m13841a(abstractC1873u, m13855n(abstractC1873u));
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: c */
    public void mo13700c(AbstractC1873u abstractC1873u) {
        AbstractC1797g abstractC1797g = abstractC1873u.m13926cC().f10794d.f10690a.get(abstractC1873u.m13930cG());
        if (!mo13701d(abstractC1873u)) {
            int a2 = abstractC1873u.m13900ct().mo13711a(1);
            C1840j m13485a = abstractC1873u.mo4049d().m13485a(abstractC1797g);
            if (m13485a.m13766c(a2)) {
                this.f10966d = null;
                this.f10967e = -1;
                return;
            }
            if (m13485a.m13766c(-2)) {
                if (this.f10966d == null) {
                    this.f10966d = abstractC1873u.m13893cA();
                    this.f10967e = abstractC1873u.m13930cG();
                    return;
                }
                return;
            }
            switch (abstractC1797g.mo13499b()) {
                case 3:
                case 4:
                case 5:
                case 10:
                    if (m13852k(abstractC1873u) == null) {
                        throw new C1868p(abstractC1873u);
                    }
                    return;
                case 6:
                case 7:
                case 8:
                default:
                    return;
                case 9:
                case 11:
                    m13849h(abstractC1873u);
                    m13841a(abstractC1873u, abstractC1873u.m13894cB().m13768d(m13855n(abstractC1873u)));
                    return;
            }
        }
    }

    /* renamed from: a */
    protected void m13844a(AbstractC1873u abstractC1873u, C1872t c1872t) {
        String str;
        InterfaceC1822af m13900ct = abstractC1873u.m13900ct();
        if (m13900ct != null) {
            str = c1872t.m13877a().mo13672a() == -1 ? "<EOF>" : m13900ct.mo13686a(c1872t.m13877a(), c1872t.m13924d());
        } else {
            str = "<unknown input>";
        }
        abstractC1873u.m13880a(c1872t.m13924d(), "no viable alternative at input " + m13839a(str), c1872t);
    }

    /* renamed from: a */
    protected void m13843a(AbstractC1873u abstractC1873u, C1868p c1868p) {
        abstractC1873u.m13880a(c1868p.m13924d(), "mismatched input " + m13840a(c1868p.m13924d()) + " expecting " + c1868p.m13923c().m13755a(abstractC1873u.mo4047b()), c1868p);
    }

    /* renamed from: a */
    protected void m13842a(AbstractC1873u abstractC1873u, C1867o c1867o) {
        abstractC1873u.m13880a(c1867o.m13924d(), "rule " + abstractC1873u.mo4048c()[abstractC1873u.f10993k.mo4288a()] + " " + c1867o.getMessage(), c1867o);
    }

    /* renamed from: h */
    protected void m13849h(AbstractC1873u abstractC1873u) {
        if (!mo13701d(abstractC1873u)) {
            m13847f(abstractC1873u);
            InterfaceC1819ac m13902cv = abstractC1873u.m13902cv();
            abstractC1873u.m13880a(m13902cv, "extraneous input " + m13840a(m13902cv) + " expecting " + m13854m(abstractC1873u).m13755a(abstractC1873u.mo4047b()), (C1876x) null);
        }
    }

    /* renamed from: i */
    protected void m13850i(AbstractC1873u abstractC1873u) {
        if (!mo13701d(abstractC1873u)) {
            m13847f(abstractC1873u);
            InterfaceC1819ac m13902cv = abstractC1873u.m13902cv();
            abstractC1873u.m13880a(m13902cv, "missing " + m13854m(abstractC1873u).m13755a(abstractC1873u.mo4047b()) + " at " + m13840a(m13902cv), (C1876x) null);
        }
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1826b
    /* renamed from: b */
    public InterfaceC1819ac mo13698b(AbstractC1873u abstractC1873u) {
        InterfaceC1819ac m13852k = m13852k(abstractC1873u);
        if (m13852k != null) {
            abstractC1873u.m13903cw();
            return m13852k;
        }
        if (m13851j(abstractC1873u)) {
            return m13853l(abstractC1873u);
        }
        if (this.f10966d == null) {
            throw new C1868p(abstractC1873u);
        }
        throw new C1868p(abstractC1873u, this.f10967e, this.f10966d);
    }

    /* renamed from: j */
    protected boolean m13851j(AbstractC1873u abstractC1873u) {
        if (!abstractC1873u.m13926cC().f10794d.m13486a(abstractC1873u.m13926cC().f10794d.f10690a.get(abstractC1873u.m13930cG()).m13631a(0).f10764f, abstractC1873u.f10993k).m13766c(abstractC1873u.m13900ct().mo13711a(1))) {
            return false;
        }
        m13850i(abstractC1873u);
        return true;
    }

    /* renamed from: k */
    protected InterfaceC1819ac m13852k(AbstractC1873u abstractC1873u) {
        if (!m13854m(abstractC1873u).m13766c(abstractC1873u.m13900ct().mo13711a(2))) {
            return null;
        }
        m13849h(abstractC1873u);
        abstractC1873u.m13903cw();
        InterfaceC1819ac m13902cv = abstractC1873u.m13902cv();
        mo13702e(abstractC1873u);
        return m13902cv;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [org.a.a.a.ac] */
    /* renamed from: l */
    protected InterfaceC1819ac m13853l(AbstractC1873u abstractC1873u) {
        InterfaceC1819ac m13902cv = abstractC1873u.m13902cv();
        C1840j m13854m = m13854m(abstractC1873u);
        int m13764c = !m13854m.mo13733a() ? m13854m.m13764c() : 0;
        String str = m13764c == -1 ? "<missing EOF>" : "<missing " + abstractC1873u.mo4047b().mo13693c(m13764c) + ">";
        InterfaceC1819ac mo13689h = abstractC1873u.m13900ct().mo13689h(-1);
        InterfaceC1819ac interfaceC1819ac = (m13902cv.mo13672a() != -1 || mo13689h == null) ? m13902cv : mo13689h;
        return abstractC1873u.m13899cs().mo13681b(new C1843m<>(interfaceC1819ac.mo13680i(), interfaceC1819ac.mo13680i().mo13683p()), m13764c, str, 0, -1, -1, interfaceC1819ac.mo13674c(), interfaceC1819ac.mo13675d());
    }

    /* renamed from: m */
    protected C1840j m13854m(AbstractC1873u abstractC1873u) {
        return abstractC1873u.m13894cB();
    }

    /* renamed from: a */
    protected String m13840a(InterfaceC1819ac interfaceC1819ac) {
        if (interfaceC1819ac == null) {
            return "<no token>";
        }
        String m13845b = m13845b(interfaceC1819ac);
        if (m13845b == null) {
            if (m13846c(interfaceC1819ac) == -1) {
                m13845b = "<EOF>";
            } else {
                m13845b = "<" + m13846c(interfaceC1819ac) + ">";
            }
        }
        return m13839a(m13845b);
    }

    /* renamed from: b */
    protected String m13845b(InterfaceC1819ac interfaceC1819ac) {
        return interfaceC1819ac.mo13673b();
    }

    /* renamed from: c */
    protected int m13846c(InterfaceC1819ac interfaceC1819ac) {
        return interfaceC1819ac.mo13672a();
    }

    /* renamed from: a */
    protected String m13839a(String str) {
        return "'" + str.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + "'";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [org.a.a.a.z] */
    /* renamed from: n */
    protected C1840j m13855n(AbstractC1873u abstractC1873u) {
        C1759a c1759a = abstractC1873u.m13926cC().f10794d;
        C1874v c1874v = abstractC1873u.f10993k;
        C1840j c1840j = new C1840j(new int[0]);
        for (C1874v c1874v2 = c1874v; c1874v2 != null && c1874v2.f11017k >= 0; c1874v2 = c1874v2.f11016j) {
            c1840j.m13758a(c1759a.m13485a(((C1782aw) c1759a.f10690a.get(c1874v2.f11017k).m13631a(0)).f10743c));
        }
        c1840j.m13769d(-2);
        return c1840j;
    }

    /* renamed from: a */
    protected void m13841a(AbstractC1873u abstractC1873u, C1840j c1840j) {
        int a2 = abstractC1873u.m13900ct().mo13711a(1);
        while (a2 != -1 && !c1840j.m13766c(a2)) {
            abstractC1873u.m13903cw();
            a2 = abstractC1873u.m13900ct().mo13711a(1);
        }
    }
}
