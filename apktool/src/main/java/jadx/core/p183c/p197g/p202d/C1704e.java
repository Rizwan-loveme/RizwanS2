package jadx.core.p183c.p197g.p202d;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.p186b.C1581o;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p189a.C1608m;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p197g.C1669a;
import java.util.Iterator;
import java.util.List;

/* compiled from: TypeInference.java */
/* renamed from: jadx.core.c.g.d.e */
/* loaded from: classes.dex */
public class C1704e extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            m13078b(c1648n);
            C1637c mo12540t = c1648n.mo12540t();
            for (C1605j c1605j : c1648n.m12614L()) {
                AbstractC1596a m13075a = m13075a(mo12540t, c1605j);
                if (m13075a == null) {
                    m13075a = AbstractC1596a.f10139o;
                }
                c1605j.m12335a(m13075a);
                c1605j.m12341b(m13076a(c1605j));
            }
            Iterator<C1605j> it = c1648n.m12614L().iterator();
            while (it.hasNext()) {
                C1625p m12350k = it.next().m12350k();
                if (m12350k != null) {
                    m13077a(m12350k);
                }
            }
        }
    }

    /* renamed from: a */
    private static AbstractC1596a m13075a(C1637c c1637c, C1605j c1605j) {
        C1604i m12347h = c1605j.m12347h();
        List<C1604i> m12348i = c1605j.m12348i();
        if (m12348i.isEmpty() || c1605j.m12353n()) {
            return m12347h.m12359s();
        }
        AbstractC1596a s = m12347h.m12359s();
        Iterator<C1604i> it = m12348i.iterator();
        AbstractC1596a abstractC1596a = s;
        while (it.hasNext()) {
            AbstractC1596a s2 = it.next().m12359s();
            if (!abstractC1596a.mo12276b() || !s2.mo12276b()) {
                AbstractC1596a m12262a = AbstractC1596a.m12262a(c1637c, abstractC1596a, s2);
                if (m12262a != null) {
                    abstractC1596a = m12262a;
                }
            }
        }
        return abstractC1596a;
    }

    /* renamed from: a */
    private static void m13077a(C1625p c1625p) {
        AbstractC1596a abstractC1596a;
        AbstractC1596a s = c1625p.m12588p().m12359s();
        if (!s.mo12276b()) {
            for (AbstractC1598c abstractC1598c : c1625p.m12589q()) {
                if (abstractC1598c.m12359s().mo12276b()) {
                    abstractC1596a = abstractC1598c.m12359s();
                    break;
                }
            }
        }
        abstractC1596a = s;
        c1625p.m12588p().mo12293a(abstractC1596a);
        for (int i = 0; i < c1625p.m12590r(); i++) {
            C1604i mo12426d = c1625p.mo12426d(i);
            mo12426d.mo12293a(abstractC1596a);
            C1605j m12331p = mo12426d.m12331p();
            if (m12331p != null) {
                m12331p.m12341b(c1625p.m12588p().mo12320m_());
            }
        }
    }

    /* renamed from: b */
    private static void m13078b(C1648n c1648n) {
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            C1581o c1581o = (C1581o) it.next().mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                for (C1625p c1625p : c1581o.m12135a()) {
                    C1604i p = c1625p.m12588p();
                    int r = c1625p.m12590r();
                    for (int i = 0; i < r; i++) {
                        c1625p.mo12426d(i).m12329b(p);
                    }
                    C1608m m12355p = p.m12331p().m12355p();
                    if (m12355p == null) {
                        m12355p = new C1608m();
                        p.m12331p().m12337a(m12355p);
                    }
                    for (int i2 = 0; i2 < r; i2++) {
                        c1625p.mo12426d(i2).m12331p().m12337a(m12355p);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static String m13076a(C1605j c1605j) {
        String mo12320m_ = c1605j.m12347h().mo12320m_();
        if (mo12320m_ == null) {
            Iterator<C1604i> it = c1605j.m12348i().iterator();
            while (it.hasNext()) {
                String mo12320m_2 = it.next().mo12320m_();
                if (mo12320m_2 != null) {
                    return mo12320m_2;
                }
            }
            return null;
        }
        return mo12320m_;
    }
}
