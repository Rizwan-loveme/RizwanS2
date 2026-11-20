package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1571e;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.C1742k;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClassModifier.java */
/* renamed from: jadx.core.c.g.b */
/* loaded from: classes.dex */
public class C1677b extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public boolean mo12781a(C1636b c1636b) {
        Iterator<C1636b> it = c1636b.m12534n().iterator();
        while (it.hasNext()) {
            mo12781a(it.next());
        }
        if (c1636b.m12539s().m12183l() && c1636b.m12531k().isEmpty() && c1636b.m12530j().isEmpty() && c1636b.m12534n().isEmpty()) {
            c1636b.mo12141a(EnumC1562a.DONT_GENERATE);
        } else {
            m12878c(c1636b);
            for (C1648n c1648n : c1636b.m12530j()) {
                m12869a(c1636b, c1648n);
                m12876b(c1648n);
            }
            m12875b(c1636b);
        }
        return false;
    }

    /* renamed from: b */
    private void m12875b(C1636b c1636b) {
        if (c1636b.m12536p()) {
            c1636b.mo12141a(EnumC1562a.ANONYMOUS_CLASS);
        }
    }

    /* renamed from: c */
    private static void m12878c(C1636b c1636b) {
        if (c1636b.m12544x().m12210l() && !c1636b.m12539s().m12179h()) {
            for (C1639e c1639e : c1636b.m12531k()) {
                if (c1639e.m12566g().m12183l() && c1639e.m12569j().mo12280f()) {
                    C1636b m12557b = c1636b.mo12540t().m12557b(C1590b.m12192a(c1636b.mo12541u(), c1639e.m12569j()));
                    C1590b m12208j = c1636b.m12544x().m12208j();
                    if (m12557b != null && m12208j.equals(m12557b.m12544x())) {
                        Iterator<C1648n> it = c1636b.m12530j().iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            if (m12873a(it.next(), c1639e, m12557b)) {
                                i++;
                            }
                        }
                        if (i != 0) {
                            c1639e.mo12144a(new C1571e(m12208j));
                            c1639e.mo12141a(EnumC1562a.DONT_GENERATE);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m12873a(C1648n c1648n, C1639e c1639e, C1636b c1636b) {
        if (c1648n.m12641p() || !c1648n.m12615M().m12181j()) {
            return false;
        }
        List<C1604i> m12620a = c1648n.m12620a(false);
        if (m12620a.isEmpty() || c1648n.mo12149b(EnumC1562a.SKIP_FIRST_ARG)) {
            return false;
        }
        C1604i c1604i = m12620a.get(0);
        if (!c1604i.m12359s().equals(c1636b.m12544x().m12211m())) {
            return false;
        }
        C1628a c1628a = c1648n.m12647y().get(0);
        List<C1646l> mo12446j = c1628a.mo12446j();
        if (mo12446j.isEmpty()) {
            return false;
        }
        C1646l c1646l = mo12446j.get(0);
        if (c1646l.m12587o() != EnumC1621l.IPUT) {
            return false;
        }
        C1619j c1619j = (C1619j) c1646l;
        C1592d c1592d = (C1592d) c1619j.m12394f();
        if (!c1592d.equals(c1639e.m12565f()) || !c1619j.mo12426d(0).equals(c1604i)) {
            return false;
        }
        c1648n.m12634i();
        C1740i.m13276a(c1648n, c1628a, c1646l);
        if (c1604i.m12331p().m12349j() != 0) {
            C1619j c1619j2 = new C1619j(EnumC1621l.IGET, c1592d, 1);
            c1619j2.m12584c(c1646l.mo12426d(1));
            Iterator<C1604i> it = c1604i.m12331p().m12348i().iterator();
            while (it.hasNext()) {
                it.next().m12310b(c1619j2);
            }
        }
        return true;
    }

    /* renamed from: a */
    private static void m12869a(C1636b c1636b, C1648n c1648n) {
        if (!c1648n.m12641p()) {
            C1589a m12615M = c1648n.m12615M();
            if (m12615M.m12183l()) {
                if (m12877b(c1636b, c1648n)) {
                    c1648n.mo12141a(EnumC1562a.DONT_GENERATE);
                    return;
                }
                if (m12615M.m12181j() && c1648n.m12647y().size() == 2) {
                    List<C1604i> m12620a = c1648n.m12620a(false);
                    if (m12872a(c1636b, m12620a)) {
                        m12870a(c1636b, c1648n, m12620a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m12872a(C1636b c1636b, List<C1604i> list) {
        Iterator<C1604i> it = list.iterator();
        while (it.hasNext()) {
            AbstractC1596a s = it.next().m12359s();
            if (s.mo12280f()) {
                C1636b m12550a = c1636b.mo12540t().m12550a(s);
                if (m12550a == null) {
                    C1590b m12192a = C1590b.m12192a(c1636b.mo12541u(), s);
                    if (m12192a.m12210l() && c1636b.m12509A().startsWith(m12192a.m12208j().m12202d())) {
                        return true;
                    }
                } else if (m12550a.mo12149b(EnumC1562a.DONT_GENERATE)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m12870a(C1636b c1636b, C1648n c1648n, List<C1604i> list) {
        List<C1646l> mo12446j = c1648n.m12647y().get(0).mo12446j();
        if (mo12446j.size() == 1 && mo12446j.get(0).m12587o() == EnumC1621l.CONSTRUCTOR && ((C1610a) mo12446j.get(0)).m12369m() && !list.isEmpty()) {
            C1604i c1604i = list.get(0);
            if (c1604i.m12359s().equals(c1636b.m12532l().m12544x().m12211m())) {
                c1604i.mo12141a(EnumC1562a.SKIP_ARG);
            }
            for (C1604i c1604i2 : list) {
                C1605j m12331p = c1604i2.m12331p();
                if (m12331p != null && m12331p.m12349j() == 0) {
                    c1604i2.mo12141a(EnumC1562a.SKIP_ARG);
                }
            }
            c1648n.mo12141a(EnumC1562a.DONT_GENERATE);
        }
    }

    /* renamed from: b */
    private static boolean m12877b(C1636b c1636b, C1648n c1648n) {
        List<C1646l> m13208b = C1721a.m13208b(c1648n.m12647y());
        if (m13208b.size() == 1) {
            C1646l c1646l = m13208b.get(0);
            if (c1646l.m12587o() == EnumC1621l.RETURN) {
                AbstractC1598c mo12426d = c1646l.mo12426d(0);
                if (mo12426d.mo12312j()) {
                    c1646l = ((C1599d) mo12426d).m12316d();
                }
            }
            if (m12874a(c1648n, c1646l)) {
                return true;
            }
        }
        return !m12879c(c1636b, c1648n);
    }

    /* renamed from: a */
    private static boolean m12874a(C1648n c1648n, C1646l c1646l) {
        C1594f m12417h;
        C1648n m12653a;
        if (c1646l.m12587o() != EnumC1621l.INVOKE || (m12653a = c1648n.mo12541u().m12653a((m12417h = ((C1622m) c1646l).m12417h()))) == null) {
            return false;
        }
        if (m12417h.m12248g() != c1648n.m12617O().m12248g()) {
            return false;
        }
        Iterator<AbstractC1598c> it = c1646l.m12589q().iterator();
        while (it.hasNext()) {
            if (!m12871a(it.next())) {
                return false;
            }
        }
        String m12639n = c1648n.m12639n();
        if (C1742k.m13287a(m12653a.m12639n(), m12639n)) {
            return true;
        }
        if (!m12653a.m12611I()) {
            return false;
        }
        m12653a.m12617O().m12241a(m12639n);
        return true;
    }

    /* renamed from: a */
    private static boolean m12871a(AbstractC1598c abstractC1598c) {
        if (abstractC1598c.mo12298h()) {
            return true;
        }
        if (!abstractC1598c.mo12312j()) {
            return false;
        }
        C1646l m12316d = ((C1599d) abstractC1598c).m12316d();
        if (m12316d.m12587o() == EnumC1621l.CHECK_CAST) {
            return m12871a(m12316d.mo12426d(0));
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m12879c(C1636b c1636b, C1648n c1648n) {
        C1594f m12617O = c1648n.m12617O();
        for (C1648n c1648n2 : c1636b.m12530j()) {
            if (c1648n2 != c1648n) {
                C1594f m12617O2 = c1648n2.m12617O();
                if (m12617O2.m12239a().equals(m12617O.m12239a()) && m12617O2.m12247f().size() == m12617O.m12247f().size()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    private static void m12876b(C1648n c1648n) {
        C1589a m12615M = c1648n.m12615M();
        if (m12615M.m12181j()) {
            if ((m12615M.m12170a() || m12615M.m12179h()) && c1648n.m12620a(false).isEmpty() && !c1648n.mo12145a(C1566b.f10030d)) {
                List<C1628a> m12647y = c1648n.m12647y();
                if (m12647y == null || m12647y.isEmpty() || C1721a.m13203a(m12647y)) {
                    c1648n.mo12141a(EnumC1562a.DONT_GENERATE);
                }
            }
        }
    }
}
