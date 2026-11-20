package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.p192a.C1632d;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1740i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: ExtractFieldInit.java */
/* renamed from: jadx.core.c.g.j */
/* loaded from: classes.dex */
public class C1710j extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public boolean mo12781a(C1636b c1636b) {
        if (!c1636b.m12535o()) {
            Iterator<C1636b> it = c1636b.m12534n().iterator();
            while (it.hasNext()) {
                mo12781a(it.next());
            }
            m13116b(c1636b);
            m13117c(c1636b);
            m13118d(c1636b);
        }
        return false;
    }

    /* renamed from: b */
    private static void m13116b(C1636b c1636b) {
        C1648n m12537q = c1636b.m12537q();
        if (m12537q != null && m12537q.m12615M().m12179h() && !m12537q.m12641p()) {
            Iterator<C1628a> it = m12537q.m12647y().iterator();
            while (it.hasNext()) {
                for (C1646l c1646l : it.next().mo12446j()) {
                    if (c1646l.m12587o() == EnumC1621l.SPUT) {
                        m13112a(c1636b, (C1619j) c1646l);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m13112a(C1636b c1636b, C1619j c1619j) {
        C1639e m12514a;
        C1592d c1592d = (C1592d) c1619j.m12394f();
        if (c1592d.m12228c().m12202d().equals(c1636b.m12544x().m12202d()) && (m12514a = c1636b.m12514a(c1592d)) != null && m12514a.m12566g().m12180i()) {
            m12514a.m12152d(C1566b.f10037k);
        }
    }

    /* renamed from: c */
    private static void m13117c(C1636b c1636b) {
        C1648n m12537q = c1636b.m12537q();
        if (m12537q != null) {
            for (C1639e c1639e : c1636b.m12531k()) {
                if (!c1639e.mo12149b(EnumC1562a.DONT_GENERATE) && c1639e.m12566g().m12179h()) {
                    List<C1646l> m13111a = m13111a(m12537q, c1639e, EnumC1621l.SPUT);
                    if (m13111a.size() == 1) {
                        C1646l c1646l = m13111a.get(0);
                        if (m13114a(c1646l)) {
                            C1740i.m13281c(m12537q, c1646l);
                            m13113a(m12537q, c1639e, c1646l);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ExtractFieldInit.java */
    /* renamed from: jadx.core.c.g.j$a */
    private static class a {

        /* renamed from: a */
        private final C1648n f10554a;

        /* renamed from: b */
        private final List<C1646l> f10555b;

        private a(C1648n c1648n) {
            this.f10555b = new ArrayList();
            this.f10554a = c1648n;
        }

        /* synthetic */ a(C1648n c1648n, a aVar) {
            this(c1648n);
        }

        /* renamed from: a */
        public C1648n m13120a() {
            return this.f10554a;
        }

        /* renamed from: b */
        public List<C1646l> m13121b() {
            return this.f10555b;
        }
    }

    /* renamed from: d */
    private static void m13118d(C1636b c1636b) {
        a aVar = null;
        List<C1648n> m13119e = m13119e(c1636b);
        if (!m13119e.isEmpty()) {
            ArrayList<a> arrayList = new ArrayList(m13119e.size());
            for (C1648n c1648n : m13119e) {
                if (!c1648n.m12641p() && !c1648n.m12647y().isEmpty()) {
                    a aVar2 = new a(c1648n, aVar);
                    arrayList.add(aVar2);
                    for (C1646l c1646l : c1648n.m12647y().get(0).mo12446j()) {
                        if (c1646l.m12587o() == EnumC1621l.IPUT && m13114a(c1646l)) {
                            aVar2.m13121b().add(c1646l);
                        } else if (!aVar2.m13121b().isEmpty()) {
                            break;
                        }
                    }
                } else {
                    return;
                }
            }
            a aVar3 = null;
            for (a aVar4 : arrayList) {
                if (aVar3 == null) {
                    aVar3 = aVar4;
                } else if (!m13115a(aVar3.m13121b(), aVar4.m13121b())) {
                    return;
                }
            }
            if (aVar3 != null) {
                HashSet hashSet = new HashSet();
                Iterator<C1646l> it = aVar3.m13121b().iterator();
                while (it.hasNext()) {
                    C1592d c1592d = (C1592d) ((C1619j) it.next()).m12394f();
                    if (c1636b.mo12540t().m12551a(c1592d) == null || !hashSet.add(c1592d)) {
                        return;
                    }
                }
                for (a aVar5 : arrayList) {
                    Iterator<C1646l> it2 = aVar5.m13121b().iterator();
                    while (it2.hasNext()) {
                        C1740i.m13281c(aVar5.m13120a(), it2.next());
                    }
                }
                for (C1646l c1646l2 : aVar3.m13121b()) {
                    m13113a(aVar3.m13120a(), c1636b.mo12540t().m12551a((C1592d) ((C1619j) c1646l2).m12394f()), c1646l2);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m13115a(List<C1646l> list, List<C1646l> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!list.get(i).mo12254a(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m13114a(C1646l c1646l) {
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        if (!mo12426d.mo12312j()) {
            return mo12426d.mo12311i() || mo12426d.m12315m();
        }
        if (!((C1599d) mo12426d).m12316d().m12594v() && c1646l.mo12145a(C1566b.f10034h)) {
            return false;
        }
        HashSet hashSet = new HashSet();
        c1646l.mo12372a(hashSet);
        if (!hashSet.isEmpty()) {
            Iterator<E> it = hashSet.iterator();
            while (it.hasNext()) {
                if (!((C1604i) it.next()).m12315m()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: e */
    private static List<C1648n> m13119e(C1636b c1636b) {
        ArrayList arrayList = new ArrayList();
        for (C1648n c1648n : c1636b.m12530j()) {
            C1589a m12615M = c1648n.m12615M();
            if (!m12615M.m12179h() && m12615M.m12181j()) {
                arrayList.add(c1648n);
                if (C1721a.m13203a(c1648n.m12647y())) {
                    return Collections.emptyList();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<C1646l> m13111a(C1648n c1648n, C1639e c1639e, EnumC1621l enumC1621l) {
        if (c1648n.m12641p()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            for (C1646l c1646l : it.next().mo12446j()) {
                if (c1646l.m12587o() == enumC1621l && ((C1592d) ((C1619j) c1646l).m12394f()).equals(c1639e.m12565f())) {
                    arrayList.add(c1646l);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m13113a(C1648n c1648n, C1639e c1639e, C1646l c1646l) {
        c1639e.mo12144a(C1632d.m12468a(c1648n, C1646l.m12576b(c1646l.mo12426d(0))));
    }
}
