package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1580n;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import java.util.List;

/* compiled from: MethodInlineVisitor.java */
/* renamed from: jadx.core.c.g.m */
/* loaded from: classes.dex */
public class C1713m extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        C1589a m12615M = c1648n.m12615M();
        if (m12615M.m12183l() && m12615M.m12179h() && c1648n.m12647y().size() == 2) {
            C1628a c1628a = c1648n.m12647y().get(1);
            if (c1628a.mo12149b(EnumC1562a.RETURN) || c1628a.mo12446j().isEmpty()) {
                m13123a(c1648n, c1648n.m12647y().get(0), c1628a);
            }
        }
    }

    /* renamed from: a */
    private static void m13123a(C1648n c1648n, C1628a c1628a, C1628a c1628a2) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        if (mo12446j.isEmpty()) {
            m13124a(c1648n, C1646l.m12576b(c1648n.m12647y().get(1).mo12446j().get(0).mo12426d(0)));
            return;
        }
        if (mo12446j.size() == 1) {
            m13124a(c1648n, mo12446j.get(0));
            return;
        }
        if (mo12446j.size() == 2 && c1628a2.mo12446j().size() == 1 && !c1648n.m12636k().equals(AbstractC1596a.f10133i)) {
            C1646l c1646l = mo12446j.get(0);
            C1646l c1646l2 = mo12446j.get(1);
            AbstractC1598c mo12426d = c1628a2.mo12446j().get(0).mo12426d(0);
            if (c1646l.m12587o() == EnumC1621l.IGET && c1646l2.m12587o() == EnumC1621l.IPUT && mo12426d.mo12298h() && c1646l.m12588p().m12328a((C1604i) mo12426d)) {
                C1604i c1604i = (C1604i) mo12426d;
                c1604i.m12331p().m12342c(c1604i);
                C1695c.m13016b(c1648n);
                List<C1646l> mo12446j2 = c1628a.mo12446j();
                if (mo12446j2.size() == 1) {
                    m13124a(c1648n, mo12446j2.get(0));
                }
            }
        }
    }

    /* renamed from: a */
    private static void m13124a(C1648n c1648n, C1646l c1646l) {
        c1648n.mo12144a(new C1580n(c1646l));
        c1648n.mo12141a(EnumC1562a.DONT_GENERATE);
    }
}
