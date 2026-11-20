package jadx.core.p181a;

import jadx.core.p181a.C1550f;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1567a;
import jadx.core.p183c.p184a.p186b.C1572f;
import jadx.core.p183c.p184a.p186b.C1579m;
import jadx.core.p183c.p188c.C1626q;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1602g;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p191d.p192a.C1632d;
import jadx.core.p183c.p193e.C1656b;
import jadx.core.p183c.p193e.C1661c;
import jadx.core.p183c.p193e.C1662d;
import jadx.core.p183c.p193e.C1663e;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p183c.p193e.p194a.C1655d;
import jadx.core.p183c.p193e.p195b.AbstractC1660d;
import jadx.core.p183c.p193e.p195b.C1657a;
import jadx.core.p183c.p193e.p195b.C1658b;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1743l;
import jadx.core.p203d.p205b.C1724a;
import jadx.core.p203d.p205b.C1729f;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: RegionGen.java */
/* renamed from: jadx.core.a.i */
/* loaded from: classes.dex */
public class C1553i extends C1550f {

    /* renamed from: e */
    private static final InterfaceC2558b f9949e = C2568c.m15995a((Class<?>) C1553i.class);

    public C1553i(C1551g c1551g) {
        super(c1551g, false);
    }

    /* renamed from: a */
    public void m11995a(C1548d c1548d, InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h instanceof InterfaceC1640f) {
            m11989a((InterfaceC1640f) interfaceC1642h, c1548d);
            return;
        }
        if (interfaceC1642h instanceof InterfaceC1644j) {
            if (interfaceC1642h instanceof C1656b) {
                m11987a(c1548d, (C1656b) interfaceC1642h);
                return;
            }
            m11993c(c1548d, interfaceC1642h);
            if (interfaceC1642h instanceof C1655d) {
                m11990a((C1655d) interfaceC1642h, c1548d, true);
                return;
            }
            if (interfaceC1642h instanceof C1661c) {
                m11986a((C1661c) interfaceC1642h, c1548d);
                return;
            }
            if (interfaceC1642h instanceof C1659c) {
                m11985a((C1659c) interfaceC1642h, c1548d);
                return;
            } else if (interfaceC1642h instanceof C1663e) {
                m11992a((C1663e) interfaceC1642h, c1548d);
                return;
            } else {
                if (interfaceC1642h instanceof C1662d) {
                    m11991a((C1662d) interfaceC1642h, c1548d);
                    return;
                }
                return;
            }
        }
        throw new C1724a("Not processed container: " + interfaceC1642h);
    }

    /* renamed from: c */
    private void m11993c(C1548d c1548d, InterfaceC1642h interfaceC1642h) {
        C1567a c1567a = (C1567a) interfaceC1642h.mo12146b(C1566b.f10046t);
        if (c1567a != null) {
            for (C1604i c1604i : c1567a.m12088a()) {
                c1548d.m11882a();
                m11952a(c1548d, c1604i);
                c1548d.m11893b(';');
            }
        }
    }

    /* renamed from: a */
    private void m11987a(C1548d c1548d, C1656b c1656b) {
        m11993c(c1548d, c1656b);
        Iterator<InterfaceC1642h> it = c1656b.mo12575d().iterator();
        while (it.hasNext()) {
            m11995a(c1548d, it.next());
        }
    }

    /* renamed from: b */
    public void m11996b(C1548d c1548d, InterfaceC1642h interfaceC1642h) {
        c1548d.m11899d();
        m11995a(c1548d, interfaceC1642h);
        c1548d.m11901e();
    }

    /* renamed from: a */
    private void m11989a(InterfaceC1640f interfaceC1640f, C1548d c1548d) {
        for (C1646l c1646l : interfaceC1640f.mo12446j()) {
            if (!c1646l.mo12149b(EnumC1562a.SKIP)) {
                m11955a(c1646l, c1548d);
            }
        }
        C1572f c1572f = (C1572f) interfaceC1640f.mo12146b(C1566b.f10036j);
        if (c1572f != null) {
            m11955a(c1572f.m12110a(), c1548d);
        }
    }

    /* renamed from: a */
    private void m11990a(C1655d c1655d, C1548d c1548d, boolean z) {
        if (z) {
            c1548d.m11884a(c1655d.m12714k());
        } else {
            c1548d.m11902e(c1655d.m12714k());
        }
        c1548d.m11897c("if (");
        new C1549e(this).m11921a(c1548d, c1655d.m12708e());
        c1548d.m11897c(") {");
        m11996b(c1548d, c1655d.m12709f());
        c1548d.m11883a('}');
        InterfaceC1642h m12710g = c1655d.m12710g();
        if (m12710g != null && C1743l.m13301h(m12710g)) {
            c1548d.m11897c(" else ");
            if (!m11994d(c1548d, m12710g)) {
                c1548d.m11893b('{');
                m11996b(c1548d, m12710g);
                c1548d.m11883a('}');
            }
        }
    }

    /* renamed from: d */
    private boolean m11994d(C1548d c1548d, InterfaceC1642h interfaceC1642h) {
        if (interfaceC1642h.mo12149b(EnumC1562a.ELSE_IF_CHAIN) && (interfaceC1642h instanceof C1656b)) {
            List<InterfaceC1642h> mo12575d = ((C1656b) interfaceC1642h).mo12575d();
            if (mo12575d.size() == 1) {
                InterfaceC1642h interfaceC1642h2 = mo12575d.get(0);
                if (interfaceC1642h2 instanceof C1655d) {
                    m11993c(c1548d, interfaceC1642h2);
                    m11990a((C1655d) interfaceC1642h2, c1548d, false);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private C1548d m11985a(C1659c c1659c, C1548d c1548d) {
        C1628a m12727g = c1659c.m12727g();
        if (m12727g != null) {
            List<C1646l> mo12446j = m12727g.mo12446j();
            if (mo12446j.size() > 1) {
                C1735d.m13258a(this.f9932b, "Found not inlined instructions from loop header");
                int size = mo12446j.size() - 1;
                for (int i = 0; i < size; i++) {
                    m11955a(mo12446j.get(i), c1548d);
                }
            }
        }
        C1579m c1579m = (C1579m) c1659c.m12725e().m12124a().mo12146b(C1566b.f10047u);
        if (c1579m != null) {
            c1548d.m11886a(this.f9931a.m11965b().m11981a(c1579m)).m11893b(':');
        }
        C1653b m12726f = c1659c.m12726f();
        if (m12726f == null) {
            c1548d.m11886a("while (true) {");
            m11996b(c1548d, c1659c.m12728h());
            c1548d.m11883a('}');
        } else {
            C1549e c1549e = new C1549e(this);
            AbstractC1660d m12733m = c1659c.m12733m();
            if (m12733m != null) {
                if (m12733m instanceof C1658b) {
                    C1658b c1658b = (C1658b) m12733m;
                    c1548d.m11886a("for (");
                    m11956a(c1658b.m12718a(), c1548d, C1550f.a.INLINE);
                    c1548d.m11897c("; ");
                    c1549e.m11921a(c1548d, m12726f);
                    c1548d.m11897c("; ");
                    m11956a(c1658b.m12719b(), c1548d, C1550f.a.INLINE);
                    c1548d.m11897c(") {");
                    m11996b(c1548d, c1659c.m12728h());
                    c1548d.m11883a('}');
                } else if (m12733m instanceof C1657a) {
                    C1657a c1657a = (C1657a) m12733m;
                    c1548d.m11886a("for (");
                    m11952a(c1548d, c1657a.m12716a());
                    c1548d.m11897c(" : ");
                    m11951a(c1548d, c1657a.m12717b(), false);
                    c1548d.m11897c(") {");
                    m11996b(c1548d, c1659c.m12728h());
                    c1548d.m11883a('}');
                } else {
                    throw new C1729f("Unknown loop type: " + m12733m.getClass());
                }
            } else if (c1659c.m12729i()) {
                c1548d.m11886a("do {");
                m11996b(c1548d, c1659c.m12728h());
                c1548d.m11884a(c1659c.m12732l());
                c1548d.m11897c("} while (");
                c1549e.m11921a(c1548d, m12726f);
                c1548d.m11897c(");");
            } else {
                c1548d.m11884a(c1659c.m12732l());
                c1548d.m11897c("while (");
                c1549e.m11921a(c1548d, m12726f);
                c1548d.m11897c(") {");
                m11996b(c1548d, c1659c.m12728h());
                c1548d.m11883a('}');
            }
        }
        return c1548d;
    }

    /* renamed from: a */
    private void m11991a(C1662d c1662d, C1548d c1548d) {
        c1548d.m11886a("synchronized (");
        m11958b(c1548d, c1662d.m12740e().mo12426d(0));
        c1548d.m11897c(") {");
        m11996b(c1548d, c1662d.m12742g());
        c1548d.m11883a('}');
    }

    /* renamed from: a */
    private C1548d m11986a(C1661c c1661c, C1548d c1548d) {
        AbstractC1598c d2 = ((C1626q) c1661c.m12736e().mo12446j().get(0)).mo12426d(0);
        c1548d.m11886a("switch (");
        m11951a(c1548d, d2, false);
        c1548d.m11897c(") {");
        c1548d.m11899d();
        int size = c1661c.m12738g().size();
        for (int i = 0; i < size; i++) {
            List<Object> list = c1661c.m12738g().get(i);
            InterfaceC1642h interfaceC1642h = c1661c.m12739h().get(i);
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                c1548d.m11886a("case ");
                if (next instanceof C1639e) {
                    C1639e c1639e = (C1639e) next;
                    if (c1639e.m12570k().m12535o()) {
                        c1548d.m11897c(c1639e.m12568i());
                    } else {
                        m11948a(c1548d, c1639e.m12565f());
                        C1632d c1632d = (C1632d) c1639e.mo12146b(C1566b.f10037k);
                        if (c1632d != null && c1632d.m12470a() != null) {
                            c1548d.m11897c(" /*").m11897c(c1632d.m12470a().toString()).m11897c("*/");
                        }
                    }
                } else if (next instanceof Integer) {
                    c1548d.m11897c(C1554j.m12003a(((Integer) next).intValue(), d2.m12359s(), this.f9932b));
                } else {
                    throw new C1729f("Unexpected key in switch: " + (next != null ? next.getClass() : null));
                }
                c1548d.m11893b(':');
            }
            m11996b(c1548d, interfaceC1642h);
        }
        if (c1661c.m12737f() != null) {
            c1548d.m11886a("default:");
            m11996b(c1548d, c1661c.m12737f());
        }
        c1548d.m11901e();
        c1548d.m11883a('}');
        return c1548d;
    }

    /* renamed from: a */
    private void m11992a(C1663e c1663e, C1548d c1548d) {
        c1548d.m11886a("try {");
        m11996b(c1548d, c1663e.m12744e());
        Iterator<Map.Entry<C1666c, InterfaceC1642h>> it = c1663e.m12745f().entrySet().iterator();
        C1666c c1666c = null;
        while (it.hasNext()) {
            C1666c key = it.next().getKey();
            if (key.m12757b()) {
                if (c1666c != null) {
                    f9949e.mo15942c("Several 'all' handlers in try/catch block in {}", this.f9932b);
                }
                c1666c = key;
            } else {
                m11988a(c1548d, key);
            }
        }
        if (c1666c != null) {
            m11988a(c1548d, c1666c);
        }
        InterfaceC1642h m12746g = c1663e.m12746g();
        if (m12746g != null) {
            c1548d.m11886a("} finally {");
            m11996b(c1548d, m12746g);
        }
        c1548d.m11883a('}');
    }

    /* renamed from: a */
    private void m11988a(C1548d c1548d, C1666c c1666c) {
        InterfaceC1642h m12761f = c1666c.m12761f();
        if (m12761f != null) {
            c1548d.m11886a("} catch (");
            AbstractC1598c m12762g = c1666c.m12762g();
            if (m12762g instanceof C1604i) {
                m11952a(c1548d, (C1604i) m12762g);
            } else if (m12762g instanceof C1602g) {
                if (c1666c.m12757b()) {
                    c1548d.m11897c("Throwable");
                } else {
                    m11947a(c1548d, c1666c.m12750a());
                }
                c1548d.m11893b(' ');
                c1548d.m11897c(this.f9931a.m11965b().m11982a((C1602g) m12762g));
            }
            c1548d.m11897c(") {");
            m11996b(c1548d, m12761f);
        }
    }
}
