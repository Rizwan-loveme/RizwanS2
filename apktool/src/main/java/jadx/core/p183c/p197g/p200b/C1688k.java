package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1567a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1608m;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.p195b.AbstractC1660d;
import jadx.core.p183c.p193e.p195b.C1658b;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1741j;
import jadx.core.p203d.C1743l;
import jadx.core.p203d.InterfaceC1736e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ProcessVariables.java */
/* renamed from: jadx.core.c.g.b.k */
/* loaded from: classes.dex */
public class C1688k extends C1669a {

    /* compiled from: ProcessVariables.java */
    /* renamed from: jadx.core.c.g.b.k$c */
    private static class c {

        /* renamed from: a */
        private final int f10511a;

        /* renamed from: b */
        private final AbstractC1596a f10512b;

        public c(C1604i c1604i) {
            this.f10511a = c1604i.m12330o();
            this.f10512b = c1604i.m12359s();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f10511a == cVar.f10511a && this.f10512b.equals(cVar.f10512b);
        }

        public int hashCode() {
            return (this.f10511a * 31) + this.f10512b.hashCode();
        }

        public String toString() {
            return "r" + this.f10511a + ":" + this.f10512b;
        }
    }

    /* compiled from: ProcessVariables.java */
    /* renamed from: jadx.core.c.g.b.k$b */
    private static class b {

        /* renamed from: a */
        private C1604i f10506a;

        /* renamed from: b */
        private C1608m f10507b;

        /* renamed from: c */
        private InterfaceC1644j f10508c;

        /* renamed from: d */
        private final Set<InterfaceC1644j> f10509d;

        /* renamed from: e */
        private final Set<InterfaceC1644j> f10510e;

        private b() {
            this.f10509d = new LinkedHashSet(2);
            this.f10510e = new LinkedHashSet(2);
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        /* renamed from: a */
        public void m12952a(C1604i c1604i) {
            this.f10506a = c1604i;
        }

        /* renamed from: a */
        public C1604i m12951a() {
            return this.f10506a;
        }

        /* renamed from: b */
        public C1608m m12955b() {
            return this.f10507b;
        }

        /* renamed from: a */
        public void m12953a(C1608m c1608m) {
            this.f10507b = c1608m;
        }

        /* renamed from: a */
        public void m12954a(InterfaceC1644j interfaceC1644j) {
            this.f10508c = interfaceC1644j;
        }

        /* renamed from: c */
        public InterfaceC1644j m12956c() {
            return this.f10508c;
        }

        /* renamed from: d */
        public Set<InterfaceC1644j> m12957d() {
            return this.f10510e;
        }

        /* renamed from: e */
        public Set<InterfaceC1644j> m12958e() {
            return this.f10509d;
        }

        public String toString() {
            return this.f10506a + ", a:" + this.f10510e + ", u:" + this.f10509d;
        }
    }

    /* compiled from: ProcessVariables.java */
    /* renamed from: jadx.core.c.g.b.k$a */
    private static class a extends AbstractC1694q {

        /* renamed from: b */
        private final List<C1604i> f10504b = new ArrayList();

        /* renamed from: c */
        private final Map<c, b> f10505c;

        public a(Map<c, b> map) {
            this.f10505c = map;
        }

        @Override // jadx.core.p183c.p197g.p200b.AbstractC1694q
        /* renamed from: a */
        public void mo12950a(C1648n c1648n, InterfaceC1640f interfaceC1640f, InterfaceC1644j interfaceC1644j) {
            m12948a(interfaceC1644j);
            int size = interfaceC1640f.mo12446j().size();
            for (int i = 0; i < size; i++) {
                C1646l c1646l = interfaceC1640f.mo12446j().get(i);
                if (!c1646l.mo12149b(EnumC1562a.SKIP)) {
                    this.f10504b.clear();
                    m12949a(c1646l, interfaceC1644j);
                }
            }
        }

        /* renamed from: a */
        private void m12948a(InterfaceC1644j interfaceC1644j) {
            if (interfaceC1644j instanceof C1659c) {
                AbstractC1660d m12733m = ((C1659c) interfaceC1644j).m12733m();
                if (m12733m instanceof C1658b) {
                    C1658b c1658b = (C1658b) m12733m;
                    m12949a(c1658b.m12718a(), interfaceC1644j);
                    m12949a(c1658b.m12719b(), interfaceC1644j);
                }
            }
        }

        /* renamed from: a */
        void m12949a(C1646l c1646l, InterfaceC1644j interfaceC1644j) {
            if (c1646l != null) {
                C1604i m12588p = c1646l.m12588p();
                if (m12588p != null && m12588p.mo12298h()) {
                    b m12947b = C1688k.m12947b(m12588p, this.f10505c);
                    if (m12947b.m12951a() == null) {
                        m12947b.m12952a(m12588p);
                        m12947b.m12954a(interfaceC1644j);
                    }
                    m12947b.m12957d().add(interfaceC1644j);
                }
                this.f10504b.clear();
                c1646l.mo12372a(this.f10504b);
                Iterator<C1604i> it = this.f10504b.iterator();
                while (it.hasNext()) {
                    C1688k.m12947b(it.next(), this.f10505c).m12958e().add(interfaceC1644j);
                }
            }
        }
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        InterfaceC1644j interfaceC1644j;
        if (!c1648n.m12641p()) {
            List<C1604i> m12620a = c1648n.m12620a(true);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<C1604i> it = m12620a.iterator();
            while (it.hasNext()) {
                m12947b(it.next(), linkedHashMap);
            }
            C1681d.m12888a(c1648n, new a(linkedHashMap));
            Iterator<C1604i> it2 = m12620a.iterator();
            while (it2.hasNext()) {
                linkedHashMap.remove(new c(it2.next()));
            }
            Iterator it3 = linkedHashMap.entrySet().iterator();
            while (it3.hasNext()) {
                b bVar = (b) ((Map.Entry) it3.next()).getValue();
                if (bVar.m12957d().isEmpty()) {
                    it3.remove();
                } else {
                    C1646l l = bVar.m12951a().m12314l();
                    if (l == null || l.m12587o() == EnumC1621l.MOVE_EXCEPTION) {
                        it3.remove();
                    }
                }
            }
            if (!linkedHashMap.isEmpty()) {
                Iterator it4 = linkedHashMap.entrySet().iterator();
                while (it4.hasNext()) {
                    b bVar2 = (b) ((Map.Entry) it4.next()).getValue();
                    Iterator<InterfaceC1644j> it5 = bVar2.m12957d().iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        InterfaceC1644j next = it5.next();
                        if (bVar2.m12956c() == next && m12946a(bVar2, next) && m12945a(bVar2)) {
                            it4.remove();
                            break;
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    Iterator it6 = linkedHashMap.entrySet().iterator();
                    while (it6.hasNext()) {
                        b bVar3 = (b) ((Map.Entry) it6.next()).getValue();
                        Set<InterfaceC1644j> m12958e = bVar3.m12958e();
                        Iterator<InterfaceC1644j> it7 = m12958e.iterator();
                        while (it7.hasNext()) {
                            InterfaceC1644j mo12574c = it7.next().mo12574c();
                            if (mo12574c != null && m12958e.contains(mo12574c)) {
                                it7.remove();
                            }
                        }
                        if (!m12958e.isEmpty()) {
                            interfaceC1644j = m12958e.iterator().next();
                        } else if (bVar3.m12957d().isEmpty()) {
                            interfaceC1644j = null;
                        } else {
                            interfaceC1644j = bVar3.m12957d().iterator().next();
                        }
                        if (interfaceC1644j != null) {
                            boolean z = false;
                            InterfaceC1644j interfaceC1644j2 = interfaceC1644j;
                            InterfaceC1644j interfaceC1644j3 = interfaceC1644j;
                            while (true) {
                                if (interfaceC1644j2 == null) {
                                    break;
                                }
                                if (m12946a(bVar3, interfaceC1644j3)) {
                                    m12943a(interfaceC1644j3, bVar3.m12951a());
                                    z = true;
                                    break;
                                } else {
                                    interfaceC1644j3 = interfaceC1644j2;
                                    interfaceC1644j2 = interfaceC1644j2.mo12574c();
                                }
                            }
                            if (!z) {
                                m12943a(c1648n.m12616N(), bVar3.m12951a());
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static b m12947b(C1604i c1604i, Map<c, b> map) {
        b bVar = (b) C1741j.m13285a(map, new c(c1604i), new InterfaceC1736e<c, b>() { // from class: jadx.core.c.g.b.k.1
            @Override // jadx.core.p203d.InterfaceC1736e
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public b mo12561a(c cVar) {
                return new b(null);
            }
        });
        if (bVar.m12955b() == null) {
            C1608m m12355p = c1604i.m12331p().m12355p();
            if (m12355p == null) {
                m12355p = new C1608m();
                c1604i.m12331p().m12337a(m12355p);
            }
            bVar.m12953a(m12355p);
        } else {
            c1604i.m12331p().m12337a(bVar.m12955b());
        }
        return bVar;
    }

    /* renamed from: a */
    private static boolean m12945a(b bVar) {
        C1604i m12951a = bVar.m12951a();
        C1646l l = m12951a.m12314l();
        if (l == null || !m12951a.equals(l.m12588p())) {
            return false;
        }
        l.mo12141a(EnumC1562a.DECLARE_VAR);
        return true;
    }

    /* renamed from: a */
    private static void m12943a(InterfaceC1642h interfaceC1642h, C1604i c1604i) {
        C1567a c1567a = (C1567a) interfaceC1642h.mo12146b(C1566b.f10046t);
        if (c1567a == null) {
            c1567a = new C1567a();
            interfaceC1642h.mo12144a(c1567a);
        }
        c1567a.m12089a(c1604i);
    }

    /* renamed from: a */
    private static boolean m12946a(b bVar, InterfaceC1644j interfaceC1644j) {
        if (interfaceC1644j instanceof C1659c) {
            Iterator<InterfaceC1644j> it = bVar.m12957d().iterator();
            while (it.hasNext()) {
                if (!C1743l.m13292a(interfaceC1644j, it.next())) {
                    return false;
                }
            }
        }
        if (interfaceC1644j.mo12149b(EnumC1562a.ELSE_IF_CHAIN)) {
            return false;
        }
        return m12944a(interfaceC1644j, bVar.m12957d()) && m12944a(interfaceC1644j, bVar.m12958e());
    }

    /* renamed from: a */
    private static boolean m12944a(InterfaceC1644j interfaceC1644j, Set<InterfaceC1644j> set) {
        Iterator<InterfaceC1644j> it = set.iterator();
        while (it.hasNext()) {
            if (!C1743l.m13292a(interfaceC1644j, it.next())) {
                return false;
            }
        }
        return true;
    }
}
