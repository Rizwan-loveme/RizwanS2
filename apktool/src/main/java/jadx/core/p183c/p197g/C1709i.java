package jadx.core.p183c.p197g;

import jadx.core.p181a.C1554j;
import jadx.core.p182b.C1559d;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p184a.p186b.C1569c;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1619j;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.C1739h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: EnumVisitor.java */
/* renamed from: jadx.core.c.g.i */
/* loaded from: classes.dex */
public class C1709i extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public boolean mo12781a(C1636b c1636b) {
        C1648n c1648n;
        C1590b m12365i;
        C1636b m12557b;
        if (!c1636b.m12535o()) {
            return true;
        }
        Iterator<C1648n> it = c1636b.m12530j().iterator();
        while (true) {
            if (!it.hasNext()) {
                c1648n = null;
                break;
            }
            C1648n next = it.next();
            if (next.m12617O().m12250i()) {
                c1648n = next;
                break;
            }
        }
        if (c1648n == null) {
            C1735d.m13254a(c1636b, "Enum class init method not found");
            return true;
        }
        AbstractC1596a m12211m = c1636b.m12544x().m12211m();
        String str = "valueOf(Ljava/lang/String;)" + C1554j.m12005a(m12211m);
        String str2 = "values()" + C1554j.m12005a(AbstractC1596a.m12258a(m12211m));
        ArrayList arrayList = new ArrayList();
        for (C1639e c1639e : c1636b.m12531k()) {
            if (c1639e.m12566g().m12182k()) {
                arrayList.add(c1639e);
                c1639e.mo12141a(EnumC1562a.DONT_GENERATE);
            } else if (c1639e.m12566g().m12183l()) {
                c1639e.mo12141a(EnumC1562a.DONT_GENERATE);
            }
        }
        for (C1648n c1648n2 : c1636b.m12530j()) {
            C1594f m12617O = c1648n2.m12617O();
            if (!m12617O.m12250i()) {
                String m12244c = m12617O.m12244c();
                boolean m12183l = c1648n2.m12615M().m12183l();
                if (m12617O.m12249h() && !m12183l) {
                    if (m12244c.equals("<init>(Ljava/lang/String;I)V")) {
                        c1648n2.mo12141a(EnumC1562a.DONT_GENERATE);
                    }
                } else if (m12183l || m12244c.equals(str2) || m12244c.equals(str)) {
                    c1648n2.mo12141a(EnumC1562a.DONT_GENERATE);
                }
            }
        }
        C1569c c1569c = new C1569c(arrayList.size());
        c1636b.mo12144a((InterfaceC1587g) c1569c);
        c1569c.m12095a(c1648n);
        C1590b m12544x = c1636b.m12544x();
        C1628a c1628a = c1648n.m12647y().get(0);
        ArrayList<C1646l> arrayList2 = new ArrayList();
        List<C1646l> mo12446j = c1628a.mo12446j();
        int size = mo12446j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            C1646l c1646l = mo12446j.get(i);
            if (c1646l.m12587o() == EnumC1621l.SPUT) {
                C1592d c1592d = (C1592d) ((C1619j) c1646l).m12394f();
                if (c1592d.m12228c().equals(m12544x)) {
                    C1639e m12514a = c1636b.m12514a(c1592d);
                    if (m12514a != null && m13109a(m12544x, m12514a)) {
                        if (i == size - 1) {
                            c1648n.mo12141a(EnumC1562a.DONT_GENERATE);
                        } else {
                            mo12446j.subList(0, i + 1).clear();
                        }
                    } else {
                        arrayList2.add(c1646l);
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        for (C1646l c1646l2 : arrayList2) {
            C1610a m13106a = m13106a(c1646l2);
            if (m13106a != null && m13106a.m12590r() >= 2 && (m12557b = c1636b.mo12540t().m12557b((m12365i = m13106a.m12365i()))) != null && (m12365i.equals(m12544x) || m12557b.m12539s().m12182k())) {
                C1592d c1592d2 = (C1592d) ((C1619j) c1646l2).m12394f();
                String m13107a = m13107a(c1636b.mo12540t(), m13106a.mo12426d(0));
                if (m13107a != null && !c1592d2.m12229d().equals(m13107a) && C1559d.m12064b(m13107a)) {
                    c1592d2.m12226a(m13107a);
                }
                C1569c.a aVar = new C1569c.a(c1592d2, m13106a, 2);
                c1569c.m12094a().add(aVar);
                if (!m13106a.m12365i().equals(m12544x)) {
                    Iterator<C1636b> it2 = c1636b.m12534n().iterator();
                    while (it2.hasNext()) {
                        m13108a(m13106a, aVar, it2.next());
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m13108a(C1610a c1610a, C1569c.a aVar, C1636b c1636b) {
        if (c1636b.m12544x().equals(c1610a.m12365i())) {
            for (C1648n c1648n : c1636b.m12530j()) {
                if (c1648n.m12615M().m12181j()) {
                    c1648n.mo12141a(EnumC1562a.DONT_GENERATE);
                }
            }
            aVar.m12098a(c1636b);
            c1636b.mo12141a(EnumC1562a.DONT_GENERATE);
        }
    }

    /* renamed from: a */
    private boolean m13109a(C1590b c1590b, C1639e c1639e) {
        if (!c1639e.m12566g().m12183l()) {
            return false;
        }
        AbstractC1596a m12569j = c1639e.m12569j();
        return m12569j.mo12286l() && m12569j.mo12289o().equals(c1590b.m12211m());
    }

    /* renamed from: a */
    private C1610a m13106a(C1646l c1646l) {
        if (c1646l.m12590r() != 1) {
            return null;
        }
        AbstractC1598c mo12426d = c1646l.mo12426d(0);
        if (mo12426d.mo12312j()) {
            return m13110b(((C1599d) mo12426d).m12316d());
        }
        if (mo12426d.mo12298h()) {
            return m13110b(((C1604i) mo12426d).m12333r());
        }
        return null;
    }

    /* renamed from: b */
    private C1610a m13110b(C1646l c1646l) {
        if (c1646l == null || c1646l.m12587o() != EnumC1621l.CONSTRUCTOR) {
            return null;
        }
        return (C1610a) c1646l;
    }

    /* renamed from: a */
    private String m13107a(C1637c c1637c, AbstractC1598c abstractC1598c) {
        if (abstractC1598c.mo12312j()) {
            Object m13269a = C1739h.m13269a(c1637c, ((C1599d) abstractC1598c).m12316d());
            if (m13269a instanceof String) {
                return (String) m13269a;
            }
        }
        return null;
    }
}
