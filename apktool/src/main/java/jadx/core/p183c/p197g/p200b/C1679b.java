package jadx.core.p183c.p197g.p200b;

import jadx.core.p181a.C1548d;
import jadx.core.p181a.C1550f;
import jadx.core.p181a.C1551g;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.p205b.C1724a;
import java.util.HashSet;
import java.util.Iterator;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: CheckRegions.java */
/* renamed from: jadx.core.c.g.b.b */
/* loaded from: classes.dex */
public class C1679b extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10493a = C2568c.m15995a((Class<?>) C1679b.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p() && c1648n.m12616N() != null && !c1648n.m12647y().isEmpty() && !c1648n.mo12145a(C1566b.f10030d)) {
            final HashSet hashSet = new HashSet();
            C1681d.m12888a(c1648n, new AbstractC1678a() { // from class: jadx.core.c.g.b.b.1
                @Override // jadx.core.p183c.p197g.p200b.AbstractC1678a, jadx.core.p183c.p197g.p200b.InterfaceC1683f
                /* renamed from: a */
                public void mo12880a(C1648n c1648n2, InterfaceC1640f interfaceC1640f) {
                    if (interfaceC1640f instanceof C1628a) {
                        C1628a c1628a = (C1628a) interfaceC1640f;
                        if (!hashSet.add(c1628a) && C1679b.f10493a.mo15940b() && !c1628a.mo12149b(EnumC1562a.RETURN) && !c1628a.mo12149b(EnumC1562a.SKIP) && !c1628a.mo12149b(EnumC1562a.SYNTHETIC) && !c1628a.mo12446j().isEmpty()) {
                            C1679b.f10493a.mo15932a("Duplicated block: {} - {}", c1648n2, c1628a);
                        }
                    }
                }
            });
            if (c1648n.m12647y().size() != hashSet.size()) {
                for (C1628a c1628a : c1648n.m12647y()) {
                    if (!hashSet.contains(c1628a) && !c1628a.mo12446j().isEmpty() && !c1628a.mo12149b(EnumC1562a.SKIP)) {
                        c1648n.m12627b("Missing block: " + c1628a + ", code:" + C1548d.f9911a + m12883a(c1648n, c1628a));
                    }
                }
            }
            C1681d.m12888a(c1648n, new AbstractC1678a() { // from class: jadx.core.c.g.b.b.2
                @Override // jadx.core.p183c.p197g.p200b.AbstractC1678a, jadx.core.p183c.p197g.p200b.InterfaceC1683f
                /* renamed from: a */
                public boolean mo12881a(C1648n c1648n2, InterfaceC1644j interfaceC1644j) {
                    C1628a m12727g;
                    if ((interfaceC1644j instanceof C1659c) && (m12727g = ((C1659c) interfaceC1644j).m12727g()) != null && m12727g.mo12446j().size() != 1) {
                        c1648n2.m12627b("Incorrect condition in loop: " + m12727g);
                    }
                    return true;
                }
            });
        }
    }

    /* renamed from: a */
    private static String m12883a(C1648n c1648n, C1628a c1628a) {
        C1548d c1548d = new C1548d();
        c1548d.m11900d(3);
        C1550f c1550f = new C1550f(C1551g.m11959a(c1648n), true);
        Iterator<C1646l> it = c1628a.mo12446j().iterator();
        while (it.hasNext()) {
            try {
                c1550f.m11955a(it.next(), c1548d);
            } catch (C1724a e2) {
            }
        }
        c1548d.m11892b().m11896c();
        c1548d.m11905h();
        return c1548d.toString();
    }
}
