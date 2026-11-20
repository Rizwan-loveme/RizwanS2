package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1568b;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1645k;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p193e.C1661c;
import jadx.core.p183c.p193e.C1662d;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.C1743l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: RegionMakerVisitor.java */
/* renamed from: jadx.core.c.g.b.m */
/* loaded from: classes.dex */
public class C1690m extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10522a = C2568c.m15995a((Class<?>) C1690m.class);

    /* renamed from: b */
    private static final a f10523b = new a(null);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        InterfaceC1644j m12984a;
        if (!c1648n.m12641p()) {
            C1689l c1689l = new C1689l(c1648n);
            c1648n.m12624a(c1689l.m12986a(c1648n.m12648z(), new C1691n(c1648n)));
            if (!c1648n.m12607E() && (m12984a = c1689l.m12984a(c1648n)) != null) {
                c1648n.m12616N().m12715a((InterfaceC1642h) m12984a);
            }
            m12991b(c1648n);
        }
    }

    /* renamed from: b */
    private static void m12991b(C1648n c1648n) {
        C1687j.m12936a(c1648n);
        C1681d.m12888a(c1648n, f10523b);
        C1680c.m12885a(c1648n);
        if (c1648n.m12615M().m12186o()) {
            m12994c(c1648n);
        }
    }

    /* compiled from: RegionMakerVisitor.java */
    /* renamed from: jadx.core.c.g.b.m$a */
    private static final class a extends AbstractC1678a {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // jadx.core.p183c.p197g.p200b.AbstractC1678a, jadx.core.p183c.p197g.p200b.InterfaceC1683f
        /* renamed from: b */
        public void mo12882b(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
            if (interfaceC1644j instanceof C1659c) {
                ((C1659c) interfaceC1644j).m12731k();
            } else {
                if (!(interfaceC1644j instanceof C1661c)) {
                    if (!(interfaceC1644j instanceof C1656b)) {
                        return;
                    }
                    C1690m.m12993b((C1656b) interfaceC1644j);
                    return;
                }
                C1690m.m12992b(c1648n, (C1661c) interfaceC1644j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m12993b(C1656b c1656b) {
        List<InterfaceC1642h> mo12575d = c1656b.mo12575d();
        if (!mo12575d.isEmpty()) {
            InterfaceC1642h interfaceC1642h = mo12575d.get(mo12575d.size() - 1);
            List c2 = interfaceC1642h.mo12150c(C1566b.f10029c);
            if (!c2.isEmpty()) {
                C1568b c1568b = (C1568b) c2.get(0);
                if (c1568b.m12091a().equals(interfaceC1642h)) {
                    c1656b.m12715a((InterfaceC1642h) new C1645k(Collections.singletonList(c1568b.m12093d())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m12992b(C1648n c1648n, C1661c c1661c) {
        for (InterfaceC1642h interfaceC1642h : c1661c.mo12571p_()) {
            if (interfaceC1642h instanceof C1656b) {
                HashSet<InterfaceC1640f> hashSet = new HashSet();
                C1743l.m13288a(interfaceC1642h, hashSet);
                if (hashSet.isEmpty()) {
                    m12995c((C1656b) interfaceC1642h);
                } else {
                    for (InterfaceC1640f interfaceC1640f : hashSet) {
                        if (interfaceC1640f instanceof C1628a) {
                            C1628a c1628a = (C1628a) interfaceC1640f;
                            Iterator<C1628a> it = c1628a.m12443g().iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    C1628a next = it.next();
                                    if (!hashSet.contains(next) && !c1628a.mo12149b(EnumC1562a.SKIP) && !next.mo12149b(EnumC1562a.FALL_THROUGH)) {
                                        m12988a(c1648n, interfaceC1642h, c1628a);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12988a(C1648n c1648n, InterfaceC1642h interfaceC1642h, C1628a c1628a) {
        InterfaceC1642h m13293b = C1743l.m13293b(interfaceC1642h, c1628a);
        if (m13293b instanceof C1656b) {
            m12995c((C1656b) m13293b);
        } else if (interfaceC1642h instanceof C1656b) {
            m12995c((C1656b) interfaceC1642h);
        } else {
            f10522a.mo15939b("Can't insert break, container: {}, block: {}, mth: {}", m13293b, c1628a, c1648n);
        }
    }

    /* renamed from: c */
    private static void m12995c(C1656b c1656b) {
        if (!C1743l.m13290a(c1656b)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new C1646l(EnumC1621l.BREAK, 0));
            c1656b.m12715a((InterfaceC1642h) new C1645k(arrayList));
        }
    }

    /* renamed from: c */
    private static void m12994c(C1648n c1648n) {
        C1656b m12616N = c1648n.m12616N();
        List<InterfaceC1642h> mo12575d = m12616N.mo12575d();
        if (!mo12575d.isEmpty() && (mo12575d.get(0) instanceof C1662d)) {
            C1662d c1662d = (C1662d) mo12575d.get(0);
            C1646l m12740e = c1662d.m12740e();
            if (!m12740e.mo12426d(0).m12315m()) {
                f10522a.mo15937b("In synchronized method {}, top region not synchronized by 'this' {}", c1648n, m12740e);
                return;
            }
            m12616N.mo12575d().set(0, c1662d.m12742g());
            C1740i.m13281c(c1648n, m12740e);
            Iterator<C1646l> it = c1662d.m12741f().iterator();
            while (it.hasNext()) {
                C1740i.m13281c(c1648n, it.next());
            }
            C1680c.m12885a(c1648n);
        }
    }
}
