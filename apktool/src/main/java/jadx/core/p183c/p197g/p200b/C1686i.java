package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1595a;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.EnumC1609b;
import jadx.core.p183c.p188c.EnumC1618i;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.EnumC1623n;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1600e;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.p194a.C1652a;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p183c.p193e.p195b.AbstractC1660d;
import jadx.core.p183c.p193e.p195b.C1657a;
import jadx.core.p183c.p193e.p195b.C1658b;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p183c.p197g.C1695c;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.C1743l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: LoopRegionVisitor.java */
/* renamed from: jadx.core.c.g.b.i */
/* loaded from: classes.dex */
public class C1686i extends C1669a implements InterfaceC1683f {

    /* renamed from: a */
    private static final InterfaceC2558b f10501a = C2568c.m15995a((Class<?>) C1686i.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        C1681d.m12888a(c1648n, this);
    }

    @Override // jadx.core.p183c.p197g.p200b.InterfaceC1683f
    /* renamed from: a */
    public boolean mo12881a(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
        if (interfaceC1644j instanceof C1659c) {
            m12928a(c1648n, (C1659c) interfaceC1644j);
            return true;
        }
        return true;
    }

    /* renamed from: a */
    private static void m12928a(C1648n c1648n, C1659c c1659c) {
        C1653b m12726f;
        if (!c1659c.m12729i() && (m12726f = c1659c.m12726f()) != null && !m12932a(c1648n, c1659c, m12726f) && m12934b(c1648n, c1659c, m12726f)) {
        }
    }

    /* renamed from: a */
    private static boolean m12932a(C1648n c1648n, C1659c c1659c, C1653b c1653b) {
        C1646l m13294b = C1743l.m13294b(c1659c);
        if (m13294b == null) {
            return false;
        }
        C1604i m12588p = m13294b.m12588p();
        if (m12588p == null || m12588p.m12331p() == null || !m12588p.m12331p().m12351l()) {
            return false;
        }
        C1625p m12350k = m12588p.m12331p().m12350k();
        if (m12350k == null || m12350k.m12590r() != 2 || !m12350k.mo12426d(1).equals(m12588p) || m12588p.m12331p().m12349j() != 1) {
            return false;
        }
        C1604i p = m12350k.m12588p();
        if (!c1653b.m12693h().contains(p) || p.m12331p().m12351l()) {
            return false;
        }
        C1604i mo12426d = m12350k.mo12426d(0);
        C1646l m12333r = mo12426d.m12333r();
        if (m12333r == null || mo12426d.m12331p().m12349j() != 1) {
            return false;
        }
        if (!m12933b(c1648n, c1659c, p)) {
            return false;
        }
        LinkedList linkedList = new LinkedList();
        m13294b.mo12372a(linkedList);
        Iterator<C1604i> it = linkedList.iterator();
        while (it.hasNext()) {
            if (m12931a(c1648n, c1659c, it.next())) {
                return false;
            }
        }
        m12333r.mo12141a(EnumC1562a.SKIP);
        m13294b.mo12141a(EnumC1562a.SKIP);
        AbstractC1660d m12927a = m12927a(c1648n, m12333r, m13294b, c1653b);
        if (m12927a != null) {
            c1659c.m12723a(m12927a);
            return true;
        }
        c1659c.m12723a(new C1658b(m12333r, m13294b));
        return true;
    }

    /* renamed from: a */
    private static AbstractC1660d m12927a(C1648n c1648n, C1646l c1646l, C1646l c1646l2, C1653b c1653b) {
        C1646l m12333r;
        C1604i m12588p;
        if ((c1646l2 instanceof C1595a) && ((C1595a) c1646l2).m12255f() == EnumC1609b.ADD) {
            AbstractC1598c mo12426d = c1646l2.mo12426d(1);
            if (!mo12426d.mo12311i() || ((C1600e) mo12426d).m12317d() != 1) {
                return null;
            }
            if (c1646l.m12587o() != EnumC1621l.CONST || !c1646l.mo12426d(0).mo12311i() || ((C1600e) c1646l.mo12426d(0)).m12317d() != 0) {
                return null;
            }
            AbstractC1598c mo12426d2 = c1646l2.mo12426d(0);
            if (!mo12426d2.mo12298h()) {
                return null;
            }
            List<C1604i> m12348i = ((C1604i) mo12426d2).m12331p().m12348i();
            if (m12348i.size() != 3 || m12348i.get(2) != mo12426d2) {
                return null;
            }
            C1604i c1604i = m12348i.get(0);
            C1646l l = m12348i.get(1).m12314l();
            if (l == null || l.m12587o() != EnumC1621l.AGET) {
                return null;
            }
            if (!c1653b.m12691f()) {
                return null;
            }
            C1652a m12692g = c1653b.m12692g();
            if (m12692g.m12670a() != EnumC1618i.LT || m12692g.m12671b() != c1604i) {
                return null;
            }
            AbstractC1598c m12672c = m12692g.m12672c();
            if (m12672c.mo12312j()) {
                m12333r = ((C1599d) m12672c).m12316d();
            } else {
                if (!m12672c.mo12298h()) {
                    return null;
                }
                m12333r = ((C1604i) m12672c).m12333r();
            }
            if (m12333r == null || m12333r.m12587o() != EnumC1621l.ARRAY_LENGTH) {
                return null;
            }
            if (m12333r.mo12426d(0).equals(l.mo12426d(0)) && (m12588p = l.m12588p()) != null) {
                m12333r.mo12141a(EnumC1562a.SKIP);
                l.mo12141a(EnumC1562a.SKIP);
                C1740i.m13278a(c1648n, m12333r);
                C1695c.m13016b(c1648n);
                if (l.mo12149b(EnumC1562a.WRAPPED)) {
                    AbstractC1598c m13204b = C1721a.m13204b(c1648n, l);
                    if (m13204b != null && m13204b.m12314l() != null) {
                        m13204b.m12314l().mo12424a(m13204b, m12588p);
                    } else {
                        f10501a.mo15932a(" checkArrayForEach: Wrapped insn not found: {}, mth: {}", l, c1648n);
                    }
                }
                return new C1657a(m12588p, m12333r.mo12426d(0));
            }
            return null;
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m12934b(C1648n c1648n, C1659c c1659c, C1653b c1653b) {
        C1604i c1604i;
        List<C1604i> m12693h = c1653b.m12693h();
        if (m12693h.size() != 1) {
            return false;
        }
        C1604i c1604i2 = m12693h.get(0);
        C1605j m12331p = c1604i2.m12331p();
        if (m12331p == null || m12331p.m12351l()) {
            return false;
        }
        List<C1604i> m12348i = m12331p.m12348i();
        C1646l m12333r = c1604i2.m12333r();
        if (m12348i.size() != 2 || m12333r == null || !m12929a(m12333r, (String) null, "iterator()Ljava/util/Iterator;", 0)) {
            return false;
        }
        AbstractC1598c mo12426d = m12333r.mo12426d(0);
        C1646l l = m12348i.get(0).m12314l();
        C1646l l2 = m12348i.get(1).m12314l();
        if (l == null || l2 == null || !m12929a(l, "java.util.Iterator", "hasNext()Z", 0) || !m12929a(l2, "java.util.Iterator", "next()Ljava/lang/Object;", 0)) {
            return false;
        }
        LinkedList linkedList = new LinkedList();
        C1604i m12588p = l2.m12588p();
        if (m12588p == null) {
            return false;
        }
        if (l2.mo12149b(EnumC1562a.WRAPPED)) {
            AbstractC1598c m13204b = C1721a.m13204b(c1648n, l2);
            if (m13204b != null && m13204b.m12314l() != null) {
                C1646l m12314l = m13204b.m12314l();
                if (m12314l.m12587o() != EnumC1621l.CHECK_CAST) {
                    if (!m12930a(c1648n, mo12426d, m12588p)) {
                        return false;
                    }
                    m12314l.mo12424a(m13204b, m12588p);
                    c1604i = m12588p;
                } else {
                    C1604i m12588p2 = m12314l.m12588p();
                    if (m12588p2 == null || !m12930a(c1648n, mo12426d, m12588p2)) {
                        return false;
                    }
                    AbstractC1598c m13204b2 = C1721a.m13204b(c1648n, m12314l);
                    if (m13204b2 != null && m13204b2.m12314l() != null) {
                        m13204b2.m12314l().mo12424a(m13204b2, m12588p2);
                        c1604i = m12588p2;
                    } else {
                        linkedList.add(m12314l);
                        c1604i = m12588p2;
                    }
                }
            } else {
                f10501a.mo15937b(" checkIterableForEach: Wrapped insn not found: {}, mth: {}", l2, c1648n);
                return false;
            }
        } else {
            linkedList.add(l2);
            c1604i = m12588p;
        }
        m12333r.mo12141a(EnumC1562a.SKIP);
        Iterator<E> it = linkedList.iterator();
        while (it.hasNext()) {
            ((C1646l) it.next()).mo12141a(EnumC1562a.SKIP);
        }
        c1659c.m12723a(new C1657a(c1604i, mo12426d));
        return true;
    }

    /* renamed from: a */
    private static boolean m12930a(C1648n c1648n, AbstractC1598c abstractC1598c, C1604i c1604i) {
        AbstractC1596a s = abstractC1598c.m12359s();
        AbstractC1596a s2 = c1604i.m12359s();
        if (s.mo12281g()) {
            AbstractC1596a[] mo12283i = s.mo12283i();
            if (mo12283i == null || mo12283i.length != 1) {
                return false;
            }
            AbstractC1596a abstractC1596a = mo12283i[0];
            if (abstractC1596a.equals(s2)) {
                return true;
            }
            if (abstractC1596a.mo12282h()) {
                c1604i.mo12293a(abstractC1596a);
                return true;
            }
            if (AbstractC1596a.m12271c(c1648n.mo12540t(), abstractC1596a, s2)) {
                return true;
            }
            AbstractC1596a mo12284j = abstractC1596a.mo12284j();
            if (mo12284j != null && abstractC1596a.mo12285k() == 1 && AbstractC1596a.m12271c(c1648n.mo12540t(), mo12284j, s2)) {
                return true;
            }
            f10501a.mo15939b("Generic type differs: '{}' and '{}' in {}", abstractC1596a, s2, c1648n);
            return false;
        }
        if (!abstractC1598c.mo12298h()) {
            return true;
        }
        abstractC1598c.mo12293a(AbstractC1596a.m12264a(s.mo12279e(), new AbstractC1596a[]{s2}));
        return true;
    }

    /* renamed from: a */
    private static boolean m12929a(C1646l c1646l, String str, String str2, int i) {
        if (c1646l.m12587o() != EnumC1621l.INVOKE) {
            return false;
        }
        C1622m c1622m = (C1622m) c1646l;
        C1594f m12417h = c1622m.m12417h();
        if (m12417h.m12248g() == i && m12417h.m12244c().equals(str2) && c1622m.m12416f() == EnumC1623n.INTERFACE) {
            return str == null || m12417h.m12245d().m12202d().equals(str);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m12931a(C1648n c1648n, C1659c c1659c, C1604i c1604i) {
        C1646l m12333r = c1604i.m12333r();
        if (m12333r == null) {
            return true;
        }
        if (!m12935c(c1648n, c1659c, m12333r.m12588p())) {
            return false;
        }
        if (m12333r instanceof C1625p) {
            Iterator<AbstractC1598c> it = ((C1625p) m12333r).m12589q().iterator();
            while (it.hasNext()) {
                if (!m12931a(c1648n, c1659c, (C1604i) it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m12933b(C1648n c1648n, C1659c c1659c, C1604i c1604i) {
        Iterator<C1604i> it = c1604i.m12331p().m12348i().iterator();
        while (it.hasNext()) {
            if (!m12935c(c1648n, c1659c, it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m12935c(C1648n c1648n, C1659c c1659c, C1604i c1604i) {
        C1646l l = c1604i.m12314l();
        if (l == null) {
            return false;
        }
        C1628a m13192a = C1721a.m13192a(c1648n, l);
        if (m13192a == null) {
            f10501a.mo15932a(" LoopRegionVisitor: instruction not found: {}, mth: {}", l, c1648n);
            return false;
        }
        return C1743l.m13291a(c1659c, m13192a);
    }

    @Override // jadx.core.p183c.p197g.p200b.InterfaceC1683f
    /* renamed from: b */
    public void mo12882b(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
    }

    @Override // jadx.core.p183c.p197g.p200b.InterfaceC1683f
    /* renamed from: a */
    public void mo12880a(C1648n c1648n, InterfaceC1640f interfaceC1640f) {
    }
}
