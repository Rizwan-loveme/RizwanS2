package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1578l;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p183c.p193e.p194a.C1654c;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1742k;
import jadx.core.p203d.p205b.C1729f;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: IfMakerHelper.java */
/* renamed from: jadx.core.c.g.b.g */
/* loaded from: classes.dex */
public class C1684g {

    /* renamed from: a */
    private static final InterfaceC2558b f10497a = C2568c.m15995a((Class<?>) C1684g.class);

    private C1684g() {
    }

    /* renamed from: a */
    static C1654c m12893a(C1628a c1628a) {
        C1617h c1617h = (C1617h) c1628a.mo12446j().get(0);
        C1654c c1654c = new C1654c(C1653b.m12676a(c1617h), c1617h.m12389j(), c1617h.m12390k());
        c1654c.m12699b(c1628a);
        c1654c.m12698b().add(c1628a);
        return c1654c;
    }

    /* renamed from: a */
    static C1654c m12895a(C1654c c1654c) {
        C1654c m12906b = m12906b(c1654c);
        return m12906b != null ? m12906b : c1654c;
    }

    /* renamed from: a */
    static C1654c m12894a(C1648n c1648n, C1628a c1628a, C1654c c1654c) {
        C1628a m12701d = c1654c.m12701d();
        C1628a m12702e = c1654c.m12702e();
        if (C1742k.m13287a(m12701d, m12702e)) {
            C1654c c1654c2 = new C1654c(c1654c, (C1628a) null, (C1628a) null);
            c1654c2.m12696a(m12701d);
            return c1654c2;
        }
        if (m12701d.mo12149b(EnumC1562a.RETURN) && m12702e.mo12149b(EnumC1562a.RETURN)) {
            c1654c.m12696a((C1628a) null);
            return c1654c;
        }
        boolean m12900a = m12900a(c1654c, m12701d);
        boolean m12900a2 = m12900a(c1654c, m12702e);
        if (m12900a && m12900a2) {
            f10497a.mo15932a("Stop processing blocks after 'if': {}, method: {}", c1654c.m12704g(), c1648n);
            return null;
        }
        if (m12900a2) {
            C1654c c1654c3 = new C1654c(c1654c, m12701d, (C1628a) null);
            c1654c3.m12696a(m12702e);
            c1654c = c1654c3;
        } else if (m12900a) {
            c1654c = new C1654c(C1654c.m12694a(c1654c), m12702e, (C1628a) null);
            c1654c.m12696a(m12701d);
        } else {
            List<C1628a> m12443g = m12701d.m12443g();
            List<C1628a> m12443g2 = m12702e.m12443g();
            if (m12443g.size() == 1 && m12903a(m12443g, m12443g2)) {
                c1654c.m12696a(m12443g.get(0));
            } else if (c1654c.m12698b().size() == 1 && c1628a.m12451o().size() == 2) {
                c1654c.m12696a(C1721a.m13191a(c1648n, m12701d, m12702e));
            }
        }
        if (c1654c.m12703f() == null) {
            Iterator<C1628a> it = c1628a.m12451o().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1628a next = it.next();
                if (next != m12701d && next != m12702e && !c1654c.m12698b().contains(next) && C1721a.m13213c(m12701d, next)) {
                    c1654c.m12696a(next);
                    break;
                }
            }
        }
        if (C1721a.m13199a(c1628a, c1654c.m12703f())) {
            c1654c.m12696a((C1628a) null);
            return c1654c;
        }
        return c1654c;
    }

    /* renamed from: a */
    private static boolean m12900a(C1654c c1654c, C1628a c1628a) {
        if (c1628a.mo12149b(EnumC1562a.LOOP_START) && c1628a.m12441e().size() == 1) {
            C1628a c1628a2 = c1628a.m12441e().get(0);
            if (c1628a2.mo12149b(EnumC1562a.LOOP_END)) {
                List<C1578l> c2 = c1628a.mo12150c(C1566b.f10028b);
                List c3 = c1628a2.mo12150c(C1566b.f10028b);
                for (C1578l c1578l : c2) {
                    Iterator it = c3.iterator();
                    while (it.hasNext()) {
                        if (c1578l == ((C1578l) it.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return !m12899a(c1628a, c1654c);
    }

    /* renamed from: a */
    private static boolean m12899a(C1628a c1628a, C1654c c1654c) {
        List<C1628a> m12441e = c1628a.m12441e();
        Set<C1628a> m12698b = c1654c.m12698b();
        Iterator<C1628a> it = m12441e.iterator();
        while (it.hasNext()) {
            C1628a m13220g = C1721a.m13220g(it.next());
            if (!m12698b.contains(m13220g) && !m13220g.mo12149b(EnumC1562a.LOOP_END)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m12903a(Collection<C1628a> collection, Collection<C1628a> collection2) {
        return collection.size() == collection2.size() && collection.containsAll(collection2);
    }

    /* renamed from: b */
    static C1654c m12906b(C1654c c1654c) {
        boolean z;
        C1628a m12701d = c1654c.m12701d();
        C1628a m12702e = c1654c.m12702e();
        if (m12701d == m12702e) {
            return null;
        }
        C1654c m12907b = m12907b(c1654c, m12701d);
        if (m12907b != null) {
            z = true;
        } else {
            m12907b = m12907b(c1654c, m12702e);
            if (m12907b == null) {
                return null;
            }
            z = false;
        }
        if (m12901a(c1654c, m12907b)) {
            m12907b = C1654c.m12694a(m12907b);
        }
        if (!C1689l.m12974a(m12701d, m12907b.m12701d()) && !C1689l.m12974a(m12702e, m12907b.m12702e())) {
            if (m12898a(m12701d, m12702e) || m12898a(m12702e, m12701d)) {
                return null;
            }
            if (!z) {
                m12702e = m12701d;
            }
            if (!C1721a.m13213c(m12907b.m12704g(), C1721a.m13218f(m12702e))) {
                return m12912d(c1654c);
            }
            m12907b = m12906b(m12907b);
            if (m12907b != null) {
                if (m12901a(c1654c, m12907b)) {
                    m12907b = C1654c.m12694a(m12907b);
                }
                if (!m12902a(c1654c, m12907b, z)) {
                    return c1654c;
                }
            } else {
                return c1654c;
            }
        }
        return m12895a(m12908b(c1654c, m12907b, z));
    }

    /* renamed from: d */
    private static C1654c m12912d(C1654c c1654c) {
        C1654c m12907b = m12907b(c1654c, c1654c.m12701d());
        C1654c m12907b2 = m12907b(c1654c, c1654c.m12702e());
        if (m12907b == null || m12907b2 == null || !m12907b.m12704g().m12449m().equals(m12907b2.m12704g().m12449m())) {
            return null;
        }
        C1654c m12895a = m12895a(m12907b);
        C1654c m12895a2 = m12895a(m12907b2);
        if (m12895a.m12701d() == m12895a2.m12701d() && m12895a.m12702e() == m12895a2.m12702e()) {
            return m12896a(c1654c, m12895a, m12895a2);
        }
        if (m12895a.m12701d() == m12895a2.m12702e() && m12895a.m12702e() == m12895a2.m12701d()) {
            return m12896a(c1654c, m12895a, C1654c.m12694a(m12895a2));
        }
        return null;
    }

    /* renamed from: a */
    private static C1654c m12896a(C1654c c1654c, C1654c c1654c2, C1654c c1654c3) {
        C1654c c1654c4 = new C1654c(C1653b.m12679a(c1654c.m12695a(), c1654c2.m12695a(), c1654c3.m12695a()), c1654c2.m12701d(), c1654c2.m12702e());
        c1654c4.m12699b(c1654c.m12704g());
        c1654c4.m12697a(c1654c, c1654c2, c1654c3);
        m12909c(c1654c4);
        return c1654c4;
    }

    /* renamed from: a */
    private static boolean m12901a(C1654c c1654c, C1654c c1654c2) {
        return C1689l.m12974a(c1654c.m12702e(), c1654c2.m12701d()) || C1689l.m12974a(c1654c.m12701d(), c1654c2.m12702e());
    }

    /* renamed from: a */
    private static boolean m12902a(C1654c c1654c, C1654c c1654c2, boolean z) {
        return z ? C1689l.m12974a(c1654c.m12702e(), c1654c2.m12702e()) : C1689l.m12974a(c1654c.m12701d(), c1654c2.m12701d());
    }

    /* renamed from: a */
    private static boolean m12898a(C1628a c1628a, C1628a c1628a2) {
        return c1628a.m12443g().size() == 1 && c1628a.m12443g().contains(c1628a2);
    }

    /* renamed from: b */
    private static C1654c m12908b(C1654c c1654c, C1654c c1654c2, boolean z) {
        C1628a m12905b;
        C1628a m12702e;
        C1653b m12678a = C1653b.m12678a(z ? C1653b.a.AND : C1653b.a.OR, c1654c.m12695a(), c1654c2.m12695a());
        if (z) {
            m12905b = c1654c2.m12701d();
            m12702e = m12905b(c1654c.m12702e(), c1654c2.m12702e());
        } else {
            m12905b = m12905b(c1654c.m12701d(), c1654c2.m12701d());
            m12702e = c1654c2.m12702e();
        }
        C1654c c1654c3 = new C1654c(m12678a, m12905b, m12702e);
        c1654c3.m12699b(c1654c.m12704g());
        c1654c3.m12697a(c1654c, c1654c2);
        m12897a(z ? c1654c.m12702e() : c1654c.m12701d(), c1654c3.m12700c());
        return c1654c3;
    }

    /* renamed from: b */
    private static C1628a m12905b(C1628a c1628a, C1628a c1628a2) {
        if (!m12910c(c1628a, c1628a2)) {
            C1628a m13218f = C1721a.m13218f(c1628a);
            if (!m12910c(m13218f, c1628a2)) {
                c1628a2 = C1721a.m13218f(c1628a2);
                if (!m12910c(m13218f, c1628a2) && !m12910c(c1628a, c1628a2)) {
                    throw new C1729f("Unexpected merge pattern");
                }
            }
        }
        return c1628a2;
    }

    /* renamed from: c */
    private static boolean m12910c(C1628a c1628a, C1628a c1628a2) {
        return c1628a == c1628a2 || C1689l.m12982b(c1628a, c1628a2);
    }

    /* renamed from: c */
    static void m12909c(C1654c c1654c) {
        if (c1654c.m12698b().size() > 1) {
            for (C1628a c1628a : c1654c.m12698b()) {
                if (c1628a != c1654c.m12704g()) {
                    c1628a.mo12141a(EnumC1562a.SKIP);
                }
            }
        }
        if (!c1654c.m12700c().isEmpty()) {
            Iterator<C1628a> it = c1654c.m12700c().iterator();
            while (it.hasNext()) {
                it.next().mo12141a(EnumC1562a.SKIP);
            }
            c1654c.m12700c().clear();
        }
    }

    /* renamed from: b */
    private static C1654c m12907b(C1654c c1654c, C1628a c1628a) {
        C1628a m12904b;
        if (m12911c(c1654c, c1628a) && (m12904b = m12904b(c1628a)) != null) {
            return m12893a(m12904b);
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m12911c(C1654c c1654c, C1628a c1628a) {
        return c1628a.m12441e().size() == 1 || c1654c.m12698b().containsAll(c1628a.m12441e());
    }

    /* renamed from: b */
    private static C1628a m12904b(C1628a c1628a) {
        boolean z;
        if (c1628a == null || c1628a.mo12145a(C1566b.f10028b) || c1628a.mo12149b(EnumC1562a.SKIP)) {
            return null;
        }
        List<C1646l> mo12446j = c1628a.mo12446j();
        if (mo12446j.size() != 1 || mo12446j.get(0).m12587o() != EnumC1621l.IF) {
            List<C1628a> m12442f = c1628a.m12442f();
            if (m12442f.size() != 1) {
                return null;
            }
            C1628a c1628a2 = m12442f.get(0);
            if (c1628a2.m12441e().size() != 1) {
                return null;
            }
            if (!mo12446j.isEmpty()) {
                Iterator<C1646l> it = mo12446j.iterator();
                while (it.hasNext()) {
                    C1604i m12588p = it.next().m12588p();
                    if (m12588p != null) {
                        List<C1604i> m12348i = m12588p.m12331p().m12348i();
                        if (m12348i.size() == 1) {
                            C1646l m12314l = m12348i.get(0).m12314l();
                            if (!C1721a.m13201a(c1628a, m12314l) && !C1721a.m13201a(c1628a2, m12314l)) {
                                z = false;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return m12904b(c1628a2);
            }
            return null;
        }
        return c1628a;
    }

    /* renamed from: a */
    private static void m12897a(C1628a c1628a, Set<C1628a> set) {
        while (c1628a != null && c1628a.m12443g().size() < 2 && c1628a.m12441e().size() == 1) {
            set.add(c1628a);
            c1628a = C1721a.m13210c(c1628a);
        }
    }
}
