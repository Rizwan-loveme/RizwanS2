package jadx.core.p183c.p197g.p201c;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.p186b.C1581o;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.p205b.C1729f;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: EliminatePhiNodes.java */
/* renamed from: jadx.core.c.g.c.a */
/* loaded from: classes.dex */
public class C1696a extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10536a = C2568c.m15995a((Class<?>) C1696a.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            m13031c(c1648n);
            m13030b(c1648n);
        }
    }

    /* renamed from: b */
    private static void m13030b(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                Iterator<C1625p> it = c1581o.m12135a().iterator();
                while (it.hasNext()) {
                    m13028a(c1648n, c1628a, it.next());
                }
            }
        }
    }

    /* renamed from: a */
    private static void m13028a(C1648n c1648n, C1628a c1628a, C1625p c1625p) {
        Iterator<C1646l> it = c1628a.mo12446j().iterator();
        while (it.hasNext()) {
            if (it.next() == c1625p) {
                it.remove();
                return;
            }
        }
        f10536a.mo15937b("Phi node not removed: {}, mth: {}", c1625p, c1648n);
    }

    /* renamed from: c */
    private void m13031c(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            List<C1646l> mo12446j = c1628a.mo12446j();
            if (!mo12446j.isEmpty()) {
                C1646l c1646l = mo12446j.get(0);
                if (c1646l.m12587o() == EnumC1621l.MERGE) {
                    m13029a(c1648n, c1628a, c1646l);
                }
            }
        }
    }

    /* renamed from: a */
    private void m13029a(C1648n c1648n, C1628a c1628a, C1646l c1646l) {
        C1628a c1628a2;
        if (c1646l.m12590r() != 2) {
            throw new C1729f("Unexpected count of arguments in merge insn: " + c1646l);
        }
        C1604i c1604i = (C1604i) c1646l.mo12426d(1);
        C1604i c1604i2 = (C1604i) c1646l.mo12426d(0);
        int m12330o = c1604i2.m12330o();
        if (c1604i.m12330o() == m12330o) {
            throw new C1729f("Unexpected register number in merge insn: " + c1646l);
        }
        C1605j m12331p = c1604i.m12331p();
        C1604i m12347h = m12331p.m12347h();
        C1646l l = m12347h.m12314l();
        C1628a m13192a = C1721a.m13192a(c1648n, l);
        if (m13192a == null) {
            throw new C1729f("Unknown assign block for " + l);
        }
        Iterator<C1628a> it = c1628a.m12441e().iterator();
        while (true) {
            if (it.hasNext()) {
                c1628a2 = it.next();
                if (C1721a.m13213c(m13192a, c1628a2)) {
                    break;
                }
            } else {
                c1628a2 = null;
                break;
            }
        }
        if (c1628a2 == null) {
            throw new C1729f("Assign predecessor not found for " + m13192a + " from " + c1628a);
        }
        C1604i m12324a = c1604i.m12324a(m12330o, (C1605j) null);
        C1605j m12618a = c1648n.m12618a(m12330o, c1648n.m12628c(m12330o), m12324a);
        m12618a.m12341b(m12331p.m12354o());
        m12618a.m12335a(m12347h.m12359s());
        if (l != null) {
            l.m12581b(m12324a);
        }
        for (C1604i c1604i3 : m12331p.m12348i()) {
            C1604i m12324a2 = c1604i3.m12324a(m12330o, m12618a);
            C1646l l2 = c1604i3.m12314l();
            if (l2 != null) {
                m12618a.m12340b(m12324a2);
                l2.mo12424a(c1604i3, m12324a2);
            }
        }
        c1628a.mo12446j().remove(0);
        C1625p m13044a = C1698c.m13044a(c1648n, c1628a, m12330o);
        m13044a.m12581b(c1646l.m12588p());
        m13044a.m12422a(m12324a.m12332q(), c1628a2);
        m13044a.m12422a(c1604i2.m12332q(), C1721a.m13205b(c1628a2, c1628a.m12441e()));
    }
}
