package jadx.core.p183c.p197g.p198a;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1602g;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p196f.C1665b;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1668e;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1740i;
import java.util.Iterator;

/* compiled from: BlockExceptionHandler.java */
/* renamed from: jadx.core.c.g.a.a */
/* loaded from: classes.dex */
public class C1670a extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            Iterator<C1628a> it = c1648n.m12647y().iterator();
            while (it.hasNext()) {
                m12782a(it.next());
            }
            Iterator<C1628a> it2 = c1648n.m12647y().iterator();
            while (it2.hasNext()) {
                it2.next().m12444h();
            }
            Iterator<C1628a> it3 = c1648n.m12647y().iterator();
            while (it3.hasNext()) {
                m12783a(c1648n, it3.next());
            }
            Iterator<C1628a> it4 = c1648n.m12647y().iterator();
            while (it4.hasNext()) {
                m12785b(it4.next());
            }
        }
    }

    /* renamed from: a */
    private static void m12782a(C1628a c1628a) {
        C1665b c1665b = (C1665b) c1628a.mo12146b(C1566b.f10033g);
        if (c1665b != null) {
            C1666c m12749c = c1665b.m12749c();
            AbstractC1596a m12211m = m12749c.m12757b() ? AbstractC1596a.f10138n : m12749c.m12750a().m12211m();
            if (!c1628a.mo12446j().isEmpty()) {
                C1646l c1646l = c1628a.mo12446j().get(0);
                if (c1646l.m12587o() == EnumC1621l.MOVE_EXCEPTION) {
                    C1604i m12302a = AbstractC1598c.m12302a(c1646l.m12588p().m12330o(), m12211m);
                    m12302a.m12143a((AbstractC1584d) c1646l);
                    c1646l.m12581b(m12302a);
                    c1646l.mo12141a(EnumC1562a.DONT_INLINE);
                    m12749c.m12751a(m12302a);
                    return;
                }
            }
            m12749c.m12751a(new C1602g("unused", m12211m));
        }
    }

    /* renamed from: a */
    private static void m12783a(C1648n c1648n, C1628a c1628a) {
        C1665b c1665b = (C1665b) c1628a.mo12146b(C1566b.f10033g);
        if (c1665b != null) {
            C1666c m12749c = c1665b.m12749c();
            m12749c.m12756b(c1628a);
            Iterator<C1628a> it = C1721a.m13216e(c1628a, c1628a).iterator();
            while (it.hasNext()) {
                m12749c.m12756b(it.next());
            }
            for (C1628a c1628a2 : m12749c.m12760e()) {
                C1740i c1740i = new C1740i(c1648n, c1628a2);
                for (C1646l c1646l : c1628a2.mo12446j()) {
                    if (c1646l.m12587o() == EnumC1621l.MONITOR_ENTER) {
                        break;
                    } else if (c1646l.m12587o() == EnumC1621l.MONITOR_EXIT) {
                        c1740i.m13284a(c1646l);
                    }
                }
                c1740i.m13282a();
                for (C1646l c1646l2 : c1628a2.mo12446j()) {
                    C1664a c1664a = (C1664a) c1646l2.mo12146b(C1566b.f10034h);
                    if (c1664a != null && (c1646l2.m12587o() == EnumC1621l.THROW || m12784a(c1664a.m12747a()))) {
                        c1665b.m12748a().m12774a(c1648n, c1664a.m12747a());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m12784a(C1668e c1668e) {
        if (c1668e.m12776b() != 1) {
            return false;
        }
        C1666c next = c1668e.m12769a().iterator().next();
        return next.m12757b() || next.m12764i();
    }

    /* renamed from: b */
    private static void m12785b(C1628a c1628a) {
        C1664a c1664a = null;
        Iterator<C1646l> it = c1628a.mo12446j().iterator();
        C1664a c1664a2 = null;
        while (true) {
            if (!it.hasNext()) {
                c1664a = c1664a2;
                break;
            }
            C1664a c1664a3 = (C1664a) it.next().mo12146b(C1566b.f10034h);
            if (c1664a3 != null) {
                if (c1664a2 == null) {
                    c1664a2 = c1664a3;
                } else if (c1664a2 != c1664a3) {
                    break;
                }
            }
        }
        if (c1664a != null) {
            c1628a.mo12144a(c1664a);
        }
    }
}
