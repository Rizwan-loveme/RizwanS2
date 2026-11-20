package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p183c.p193e.p194a.C1655d;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1743l;
import java.util.List;

/* compiled from: IfRegionVisitor.java */
/* renamed from: jadx.core.c.g.b.h */
/* loaded from: classes.dex */
public class C1685h extends C1669a {

    /* renamed from: a */
    private static final c f10498a = new c(null);

    /* renamed from: b */
    private static final a f10499b = new a(0 == true ? 1 : 0);

    /* renamed from: c */
    private static final b f10500c = new b(0 == true ? 1 : 0);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        C1681d.m12887a(c1648n, f10498a);
        C1681d.m12888a(c1648n, f10499b);
        C1681d.m12887a(c1648n, f10500c);
    }

    /* compiled from: IfRegionVisitor.java */
    /* renamed from: jadx.core.c.g.b.h$c */
    private static class c implements InterfaceC1682e {
        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }

        @Override // jadx.core.p183c.p197g.p200b.InterfaceC1682e
        /* renamed from: a */
        public boolean mo12892a(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
            return (interfaceC1644j instanceof C1655d) && C1693p.m13011a(c1648n, (C1655d) interfaceC1644j);
        }
    }

    /* compiled from: IfRegionVisitor.java */
    /* renamed from: jadx.core.c.g.b.h$a */
    private static class a extends AbstractC1678a {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // jadx.core.p183c.p197g.p200b.AbstractC1678a, jadx.core.p183c.p197g.p200b.InterfaceC1683f
        /* renamed from: a */
        public boolean mo12881a(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
            if (interfaceC1644j instanceof C1655d) {
                C1655d c1655d = (C1655d) interfaceC1644j;
                C1685h.m12922d(c1655d);
                C1685h.m12919c(c1648n, c1655d);
                C1685h.m12924e(c1655d);
                C1685h.m12925f(c1655d);
                return true;
            }
            return true;
        }
    }

    /* compiled from: IfRegionVisitor.java */
    /* renamed from: jadx.core.c.g.b.h$b */
    private static class b implements InterfaceC1682e {
        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        @Override // jadx.core.p183c.p197g.p200b.InterfaceC1682e
        /* renamed from: a */
        public boolean mo12892a(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
            if (interfaceC1644j instanceof C1655d) {
                return C1685h.m12923d(c1648n, (C1655d) interfaceC1644j);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m12922d(C1655d c1655d) {
        if (c1655d.m12712i() && c1655d.m12708e().m12685a() == C1653b.a.NOT) {
            m12926g(c1655d);
        }
        InterfaceC1642h m12710g = c1655d.m12710g();
        if (m12710g != null && !C1743l.m13300g(m12710g)) {
            boolean m13300g = C1743l.m13300g(c1655d.m12709f());
            if (m13300g || m12921c(c1655d.m12709f())) {
                m12926g(c1655d);
            }
            if (!m13300g && m12915a(c1655d.m12709f()) && !m12915a(m12710g)) {
                m12926g(c1655d);
            }
        }
    }

    /* renamed from: a */
    private static boolean m12915a(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof C1655d) {
            return true;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
            if (mo12575d.size() == 1 && (mo12575d.get(0) instanceof C1655d)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m12919c(C1648n c1648n, C1655d c1655d) {
        if (!c1648n.m12636k().equals(AbstractC1596a.f10133i) && m12921c(c1655d.m12710g())) {
            m12926g(c1655d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m12924e(C1655d c1655d) {
        if (c1655d.m12710g() != null && C1743l.m13298e(c1655d.m12710g())) {
            m12926g(c1655d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static void m12925f(C1655d c1655d) {
        if (!m12921c(c1655d.m12709f())) {
            InterfaceC1642h m12710g = c1655d.m12710g();
            if (m12710g instanceof C1656b) {
                List<InterfaceC1642h> mo12575d = ((C1656b) m12710g).mo12575d();
                if (mo12575d.size() == 1 && (mo12575d.get(0) instanceof C1655d)) {
                    mo12575d.get(0).mo12141a(EnumC1562a.ELSE_IF_CHAIN);
                    m12710g.mo12141a(EnumC1562a.ELSE_IF_CHAIN);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m12923d(C1648n c1648n, C1655d c1655d) {
        if (c1655d.m12710g() == null || c1655d.mo12149b(EnumC1562a.ELSE_IF_CHAIN) || c1655d.m12710g().mo12149b(EnumC1562a.ELSE_IF_CHAIN) || !m12917b(c1655d.m12709f())) {
            return false;
        }
        if (c1648n.m12636k() == AbstractC1596a.f10133i && C1743l.m13299f(c1655d.m12709f()) == 2 && C1743l.m13299f(c1655d.m12710g()) == 2) {
            return false;
        }
        InterfaceC1644j c2 = c1655d.mo12574c();
        C1656b c1656b = new C1656b(c2);
        if (!c2.mo12573a(c1655d, c1656b)) {
            return false;
        }
        c1656b.m12715a((InterfaceC1642h) c1655d);
        c1656b.m12715a(c1655d.m12710g());
        c1655d.m12707b((InterfaceC1642h) null);
        return true;
    }

    /* renamed from: b */
    private static boolean m12917b(InterfaceC1642h interfaceC1642h) {
        return C1743l.m13297d(interfaceC1642h) || C1743l.m13298e(interfaceC1642h);
    }

    /* renamed from: g */
    private static void m12926g(C1655d c1655d) {
        if (c1655d.m12710g() != null) {
            c1655d.m12713j();
        }
    }

    /* renamed from: c */
    private static boolean m12921c(InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h == null) {
            return false;
        }
        if (interfaceC1642h.mo12149b(EnumC1562a.RETURN)) {
            return true;
        }
        if (!(interfaceC1642h instanceof InterfaceC1644j)) {
            return false;
        }
        List<InterfaceC1642h> mo12575d = ((InterfaceC1644j) interfaceC1642h).mo12575d();
        return mo12575d.size() == 1 && mo12575d.get(0).mo12149b(EnumC1562a.RETURN);
    }
}
