package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import java.util.Iterator;
import java.util.Set;

/* compiled from: DependencyCollector.java */
/* renamed from: jadx.core.c.g.f */
/* loaded from: classes.dex */
public class C1706f extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public boolean mo12781a(C1636b c1636b) {
        C1637c mo12540t = c1636b.mo12540t();
        Set<C1636b> m12513E = c1636b.m12513E();
        m13082a(c1636b, mo12540t, m12513E);
        Iterator<C1636b> it = c1636b.m12534n().iterator();
        while (it.hasNext()) {
            m13082a(it.next(), mo12540t, m12513E);
        }
        m12513E.remove(c1636b);
        return false;
    }

    /* renamed from: a */
    private static void m13082a(C1636b c1636b, C1637c c1637c, Set<C1636b> set) {
        m13084a(c1637c, set, c1636b.m12527g());
        Iterator<AbstractC1596a> it = c1636b.m12528h().iterator();
        while (it.hasNext()) {
            m13084a(c1637c, set, it.next());
        }
        Iterator<C1639e> it2 = c1636b.m12531k().iterator();
        while (it2.hasNext()) {
            m13084a(c1637c, set, it2.next().m12569j());
        }
        for (C1648n c1648n : c1636b.m12530j()) {
            if (!c1648n.m12641p() && !c1648n.mo12145a(C1566b.f10030d)) {
                m13087a(c1637c, set, c1648n);
            }
        }
    }

    /* renamed from: a */
    private static void m13087a(C1637c c1637c, Set<C1636b> set, C1648n c1648n) {
        m13085a(c1637c, set, c1648n.m12640o());
        m13084a(c1637c, set, c1648n.m12636k());
        Iterator<AbstractC1596a> it = c1648n.m12617O().m12247f().iterator();
        while (it.hasNext()) {
            m13084a(c1637c, set, it.next());
        }
        Iterator<C1628a> it2 = c1648n.m12647y().iterator();
        while (it2.hasNext()) {
            Iterator<C1646l> it3 = it2.next().mo12446j().iterator();
            while (it3.hasNext()) {
                m13086a(c1637c, set, it3.next());
            }
        }
    }

    /* renamed from: a */
    private static void m13086a(C1637c c1637c, Set<C1636b> set, C1646l c1646l) {
        C1604i m12588p = c1646l.m12588p();
        if (m12588p != null) {
            m13084a(c1637c, set, m12588p.m12359s());
        }
        for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
            if (abstractC1598c.mo12312j()) {
                m13086a(c1637c, set, ((C1599d) abstractC1598c).m12316d());
            } else {
                m13084a(c1637c, set, abstractC1598c.m12359s());
            }
        }
        m13088b(c1637c, set, c1646l);
    }

    /* renamed from: b */
    private static void m13088b(C1637c c1637c, Set<C1636b> set, C1646l c1646l) {
        if (c1646l instanceof C1619j) {
            Object m12394f = ((C1619j) c1646l).m12394f();
            if (m12394f instanceof C1592d) {
                m13083a(c1637c, set, ((C1592d) m12394f).m12228c());
                return;
            } else {
                if (m12394f instanceof AbstractC1596a) {
                    m13084a(c1637c, set, (AbstractC1596a) m12394f);
                    return;
                }
                return;
            }
        }
        if (c1646l instanceof C1622m) {
            m13083a(c1637c, set, ((C1622m) c1646l).m12417h().m12245d());
        }
    }

    /* renamed from: a */
    private static void m13084a(C1637c c1637c, Set<C1636b> set, AbstractC1596a abstractC1596a) {
        if (abstractC1596a != null) {
            if (abstractC1596a.mo12280f()) {
                m13083a(c1637c, set, C1590b.m12193a(c1637c.mo12541u(), abstractC1596a.mo12279e()));
                AbstractC1596a[] mo12283i = abstractC1596a.mo12283i();
                if (abstractC1596a.mo12281g() && mo12283i != null) {
                    for (AbstractC1596a abstractC1596a2 : mo12283i) {
                        m13084a(c1637c, set, abstractC1596a2);
                    }
                    return;
                }
                return;
            }
            if (abstractC1596a.mo12286l()) {
                m13084a(c1637c, set, abstractC1596a.mo12289o());
            }
        }
    }

    /* renamed from: a */
    private static void m13083a(C1637c c1637c, Set<C1636b> set, C1590b c1590b) {
        if (c1590b != null) {
            m13085a(c1637c, set, c1637c.m12557b(c1590b));
        }
    }

    /* renamed from: a */
    private static void m13085a(C1637c c1637c, Set<C1636b> set, C1636b c1636b) {
        if (c1636b != null) {
            set.add(c1636b.m12533m());
        }
    }
}
