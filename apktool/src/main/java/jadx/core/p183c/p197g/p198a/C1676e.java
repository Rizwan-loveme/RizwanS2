package jadx.core.p183c.p197g.p198a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1576j;
import jadx.core.p183c.p188c.AbstractC1627r;
import jadx.core.p183c.p188c.C1617h;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p196f.C1665b;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1667d;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.p205b.C1729f;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BlockSplitter.java */
/* renamed from: jadx.core.c.g.a.e */
/* loaded from: classes.dex */
public class C1676e extends C1669a {

    /* renamed from: a */
    private static final Set<EnumC1621l> f10492a = m12855a(EnumC1621l.RETURN, EnumC1621l.IF, EnumC1621l.SWITCH, EnumC1621l.MONITOR_ENTER, EnumC1621l.MONITOR_EXIT, EnumC1621l.THROW);

    /* renamed from: a */
    private static Set<EnumC1621l> m12855a(EnumC1621l enumC1621l, EnumC1621l... enumC1621lArr) {
        return EnumSet.m13457of(enumC1621l, enumC1621lArr);
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            c1648n.m12632g();
            c1648n.m12645w();
            m12867d(c1648n);
            m12868e(c1648n);
            m12865b(c1648n);
            m12866c(c1648n);
        }
    }

    /* renamed from: c */
    private static void m12866c(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            C1646l m13194a = C1721a.m13194a((InterfaceC1640f) c1628a);
            if (m13194a instanceof AbstractC1627r) {
                ((AbstractC1627r) m13194a).mo12385a(c1628a);
            }
        }
    }

    /* renamed from: d */
    private static void m12867d(C1648n c1648n) {
        boolean z;
        C1646l c1646l = null;
        HashMap hashMap = new HashMap();
        C1628a m12851a = m12851a(c1648n, 0);
        c1648n.m12623a(m12851a);
        for (C1646l c1646l2 : c1648n.m12643r()) {
            if (c1646l2 != null) {
                if (c1646l != null) {
                    EnumC1621l m12587o = c1646l.m12587o();
                    if (m12587o == EnumC1621l.GOTO || m12587o == EnumC1621l.THROW || f10492a.contains(m12587o)) {
                        if (m12587o == EnumC1621l.RETURN || m12587o == EnumC1621l.THROW) {
                            c1648n.m12626b(m12851a);
                        }
                        C1628a m12851a2 = m12851a(c1648n, c1646l2.m12591s());
                        if (m12587o == EnumC1621l.MONITOR_ENTER || m12587o == EnumC1621l.MONITOR_EXIT) {
                            m12856a(m12851a, m12851a2);
                        }
                        z = true;
                        m12851a = m12851a2;
                    } else {
                        z = m12861a(c1646l, c1646l2) || f10492a.contains(c1646l2.m12587o()) || m12862a(hashMap, m12851a, c1646l2) || c1646l2.mo12145a(C1566b.f10033g) || c1646l.mo12149b(EnumC1562a.TRY_LEAVE) || c1646l.m12587o() == EnumC1621l.MOVE_EXCEPTION;
                        if (z) {
                            m12851a = m12852a(c1648n, m12851a, c1646l2.m12591s());
                        }
                    }
                } else {
                    z = false;
                }
                if (c1646l2.mo12149b(EnumC1562a.TRY_ENTER)) {
                    m12851a = m12854a(c1648n, hashMap, m12851a, c1646l2, z);
                } else if (c1646l2.mo12145a(C1566b.f10033g)) {
                    m12859a(c1648n, m12851a, c1646l2);
                    hashMap.put(Integer.valueOf(c1646l2.m12591s()), m12851a);
                    m12851a.mo12446j().add(c1646l2);
                } else {
                    hashMap.put(Integer.valueOf(c1646l2.m12591s()), m12851a);
                    m12851a.mo12446j().add(c1646l2);
                }
                c1646l = c1646l2;
            }
        }
        m12860a(c1648n, hashMap);
    }

    /* renamed from: a */
    private static void m12859a(C1648n c1648n, C1628a c1628a, C1646l c1646l) {
        C1665b c1665b = (C1665b) c1646l.mo12146b(C1566b.f10033g);
        c1646l.m12152d(C1566b.f10033g);
        if (c1646l.m12587o() != EnumC1621l.MOVE_EXCEPTION) {
            C1628a m12851a = m12851a(c1648n, -1);
            m12851a.mo12141a(EnumC1562a.SYNTHETIC);
            m12856a(m12851a, c1628a);
            c1628a = m12851a;
        }
        c1628a.mo12144a(c1665b);
        c1665b.m12749c().m12752a(c1628a);
    }

    /* renamed from: a */
    private static C1628a m12854a(C1648n c1648n, Map<Integer, C1628a> map, C1628a c1628a, C1646l c1646l, boolean z) {
        if (c1646l.m12591s() != 0 && !z) {
            c1628a = m12852a(c1648n, c1628a, c1646l.m12591s());
        }
        map.put(Integer.valueOf(c1646l.m12591s()), c1628a);
        C1667d c1667d = new C1667d(c1628a);
        c1628a.mo12141a(EnumC1562a.SYNTHETIC);
        c1628a.mo12144a(c1667d);
        C1628a m12851a = m12851a(c1648n, -1);
        m12851a.mo12446j().add(c1646l);
        m12851a.mo12144a(c1667d);
        m12856a(c1628a, m12851a);
        return m12851a;
    }

    /* renamed from: a */
    private static C1628a m12852a(C1648n c1648n, C1628a c1628a, int i) {
        C1628a m12851a = m12851a(c1648n, i);
        m12856a(c1628a, m12851a);
        return m12851a;
    }

    /* renamed from: a */
    static C1628a m12851a(C1648n c1648n, int i) {
        C1628a c1628a = new C1628a(c1648n.m12647y().size(), i);
        c1648n.m12647y().add(c1628a);
        return c1628a;
    }

    /* renamed from: a */
    static void m12856a(C1628a c1628a, C1628a c1628a2) {
        if (!c1628a.m12442f().contains(c1628a2)) {
            c1628a.m12442f().add(c1628a2);
        }
        if (!c1628a2.m12441e().contains(c1628a)) {
            c1628a2.m12441e().add(c1628a);
        }
    }

    /* renamed from: b */
    static void m12863b(C1628a c1628a, C1628a c1628a2) {
        c1628a.m12442f().remove(c1628a2);
        c1628a2.m12441e().remove(c1628a);
    }

    /* renamed from: a */
    static void m12857a(C1628a c1628a, C1628a c1628a2, C1628a c1628a3) {
        m12863b(c1628a, c1628a2);
        m12856a(c1628a, c1628a3);
        m12864b(c1628a, c1628a2, c1628a3);
    }

    /* renamed from: a */
    static C1628a m12853a(C1648n c1648n, C1628a c1628a, C1628a c1628a2) {
        C1628a m12851a = m12851a(c1648n, c1628a2.m12447k());
        m12851a.mo12141a(EnumC1562a.SYNTHETIC);
        m12863b(c1628a, c1628a2);
        m12856a(c1628a, m12851a);
        m12856a(m12851a, c1628a2);
        m12864b(c1628a, c1628a2, m12851a);
        c1628a.m12444h();
        m12851a.m12444h();
        return m12851a;
    }

    /* renamed from: b */
    static void m12864b(C1628a c1628a, C1628a c1628a2, C1628a c1628a3) {
        C1646l m13194a = C1721a.m13194a((InterfaceC1640f) c1628a);
        if (m13194a instanceof AbstractC1627r) {
            ((AbstractC1627r) m13194a).mo12386a(c1628a2, c1628a3);
        }
    }

    /* renamed from: a */
    private static void m12860a(C1648n c1648n, Map<Integer, C1628a> map) {
        for (C1628a c1628a : c1648n.m12647y()) {
            for (C1646l c1646l : c1628a.mo12446j()) {
                for (C1576j c1576j : c1646l.mo12150c(C1566b.f10027a)) {
                    m12856a(m12850a(c1576j.m12116a(), map), m12850a(c1576j.m12117b(), map));
                }
                m12858a(c1628a, c1646l);
            }
        }
    }

    /* renamed from: a */
    private static void m12858a(C1628a c1628a, C1646l c1646l) {
        C1664a c1664a = (C1664a) c1646l.mo12146b(C1566b.f10034h);
        C1667d c1667d = (C1667d) c1628a.mo12146b(C1566b.f10035i);
        if (c1664a != null && c1667d != null) {
            C1628a m12765a = c1667d.m12765a();
            boolean b2 = c1646l.mo12149b(EnumC1562a.TRY_LEAVE);
            Iterator<C1666c> it = c1664a.m12747a().m12769a().iterator();
            while (it.hasNext()) {
                C1628a m12759d = it.next().m12759d();
                if (m12765a != m12759d) {
                    if (!m12759d.mo12145a(C1566b.f10035i)) {
                        m12759d.mo12144a(c1667d);
                    }
                    m12856a(m12765a, m12759d);
                }
                if (b2) {
                    m12856a(c1628a, m12759d);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m12861a(C1646l c1646l, C1646l c1646l2) {
        Iterator it = c1646l.mo12150c(C1566b.f10027a).iterator();
        while (it.hasNext()) {
            if (((C1576j) it.next()).m12116a() == c1646l.m12591s()) {
                return true;
            }
        }
        Iterator it2 = c1646l2.mo12150c(C1566b.f10027a).iterator();
        while (it2.hasNext()) {
            if (((C1576j) it2.next()).m12117b() == c1646l2.m12591s()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m12862a(Map<Integer, C1628a> map, C1628a c1628a, C1646l c1646l) {
        return c1646l.m12587o() == EnumC1621l.IF && map.get(Integer.valueOf(((C1617h) c1646l).mo12383f())) == c1628a;
    }

    /* renamed from: a */
    private static C1628a m12850a(int i, Map<Integer, C1628a> map) {
        C1628a c1628a = map.get(Integer.valueOf(i));
        if (c1628a == null) {
            throw new C1729f("Missing block: " + i);
        }
        return c1628a;
    }

    /* renamed from: e */
    private static void m12868e(C1648n c1648n) {
        EnumC1621l m12587o;
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            Iterator<C1646l> it2 = it.next().mo12446j().iterator();
            while (it2.hasNext()) {
                C1646l next = it2.next();
                if (next.m12153o_() && ((m12587o = next.m12587o()) == EnumC1621l.GOTO || m12587o == EnumC1621l.NOP)) {
                    it2.remove();
                }
            }
        }
    }

    /* renamed from: b */
    static boolean m12865b(C1648n c1648n) {
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        boolean z = false;
        while (it.hasNext()) {
            C1628a next = it.next();
            if (next.mo12446j().isEmpty() && next.m12441e().isEmpty() && next.m12442f().isEmpty()) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
