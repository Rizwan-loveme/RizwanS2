package jadx.core.p183c.p197g.p198a;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1578l;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1638d;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1730c;
import jadx.core.p203d.p205b.C1728e;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: BlockProcessor.java */
/* renamed from: jadx.core.c.g.a.d */
/* loaded from: classes.dex */
public class C1675d extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10491a = C2568c.m15995a((Class<?>) C1675d.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            m12836c(c1648n);
        }
    }

    /* renamed from: b */
    public static void m12833b(C1648n c1648n) {
        m12848n(c1648n);
        m12849o(c1648n);
        m12836c(c1648n);
    }

    /* renamed from: c */
    private static void m12836c(C1648n c1648n) {
        m12838d(c1648n);
        if (m12845k(c1648n)) {
            m12849o(c1648n);
            m12838d(c1648n);
        }
        m12840f(c1648n);
        int i = 0;
        while (m12844j(c1648n)) {
            m12849o(c1648n);
            m12838d(c1648n);
            m12840f(c1648n);
            int i2 = i + 1;
            if (i > 100) {
                throw new AssertionError("Can't fix method cfg: " + c1648n);
            }
            i = i2;
        }
        m12839e(c1648n);
        m12842h(c1648n);
        m12843i(c1648n);
    }

    /* renamed from: a */
    private static boolean m12828a(C1628a c1628a) {
        return c1628a.mo12446j().isEmpty() && !c1628a.m12452p() && c1628a.m12153o_() && c1628a.m12442f().size() <= 1 && !c1628a.m12441e().isEmpty();
    }

    /* renamed from: b */
    private static boolean m12834b(C1628a c1628a) {
        if (!m12828a(c1628a)) {
            return false;
        }
        if (c1628a.m12442f().size() == 1) {
            C1628a c1628a2 = c1628a.m12442f().get(0);
            for (C1628a c1628a3 : c1628a.m12441e()) {
                c1628a3.m12442f().remove(c1628a);
                C1676e.m12856a(c1628a3, c1628a2);
                C1676e.m12864b(c1628a3, c1628a, c1628a2);
                c1628a3.m12444h();
            }
            C1676e.m12863b(c1628a, c1628a2);
        } else {
            for (C1628a c1628a4 : c1628a.m12441e()) {
                c1628a4.m12442f().remove(c1628a);
                c1628a4.m12444h();
            }
        }
        c1628a.mo12141a(EnumC1562a.REMOVE);
        c1628a.m12442f().clear();
        c1628a.m12441e().clear();
        return true;
    }

    /* renamed from: c */
    private static boolean m12837c(C1628a c1628a) {
        int m12823a;
        if (!c1628a.mo12149b(EnumC1562a.LOOP_START) && !c1628a.mo12149b(EnumC1562a.LOOP_END)) {
            return false;
        }
        List<C1628a> m12441e = c1628a.m12441e();
        if (m12441e.size() <= 1) {
            return false;
        }
        C1646l m13194a = C1721a.m13194a((InterfaceC1640f) c1628a);
        if ((m13194a != null && m13194a.m12587o() == EnumC1621l.IF) || (m12823a = m12823a(m12441e)) <= 0) {
            return false;
        }
        m12826a(c1628a, m12825a(m12441e.get(0), m12823a));
        Iterator<C1628a> it = m12441e.iterator();
        while (it.hasNext()) {
            m12825a(it.next(), m12823a).clear();
        }
        f10491a.mo15932a("Move duplicate insns, count: {} to block {}", Integer.valueOf(m12823a), c1628a);
        return true;
    }

    /* renamed from: a */
    private static List<C1646l> m12825a(C1628a c1628a, int i) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        int size = mo12446j.size();
        return mo12446j.subList(size - i, size);
    }

    /* renamed from: a */
    private static void m12826a(C1628a c1628a, List<C1646l> list) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        ArrayList arrayList = new ArrayList(list.size() + mo12446j.size());
        arrayList.addAll(list);
        arrayList.addAll(mo12446j);
        mo12446j.clear();
        mo12446j.addAll(arrayList);
    }

    /* renamed from: a */
    private static int m12823a(List<C1628a> list) {
        int i;
        int i2 = 0;
        loop0: while (true) {
            i = i2;
            Iterator<C1628a> it = list.iterator();
            C1646l c1646l = null;
            while (it.hasNext()) {
                C1646l m12832b = m12832b(it.next(), i);
                if (m12832b == null) {
                    break loop0;
                }
                if (c1646l == null) {
                    c1646l = m12832b;
                } else if (!m12830a(c1646l, m12832b)) {
                    break loop0;
                }
            }
            i2 = i + 1;
        }
        return i;
    }

    /* renamed from: a */
    private static boolean m12830a(C1646l c1646l, C1646l c1646l2) {
        return c1646l.m12582b(c1646l2) && c1646l.m12593u();
    }

    /* renamed from: b */
    private static C1646l m12832b(C1628a c1628a, int i) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        if (mo12446j.size() <= i) {
            return null;
        }
        return mo12446j.get((r1 - i) - 1);
    }

    /* renamed from: d */
    private static void m12838d(C1648n c1648n) {
        boolean z;
        C1628a c1628a;
        List<C1628a> m12647y = c1648n.m12647y();
        int size = m12647y.size();
        for (int i = 0; i < size; i++) {
            C1628a c1628a2 = m12647y.get(i);
            c1628a2.m12434a(i);
            c1628a2.m12435a(new BitSet(size));
            c1628a2.m12448l().set(0, size);
        }
        C1628a m12648z = c1648n.m12648z();
        m12648z.m12448l().clear();
        m12648z.m12448l().set(m12648z.m12440d());
        BitSet bitSet = new BitSet(size);
        do {
            z = false;
            for (C1628a c1628a3 : m12647y) {
                if (c1628a3 != m12648z) {
                    BitSet m12448l = c1628a3.m12448l();
                    if (!z) {
                        bitSet.clear();
                        bitSet.mo13226or(m12448l);
                    }
                    Iterator<C1628a> it = c1628a3.m12441e().iterator();
                    while (it.hasNext()) {
                        m12448l.and(it.next().m12448l());
                    }
                    m12448l.set(c1628a3.m12440d());
                    if (!z && !m12448l.equals(bitSet)) {
                        z = true;
                    }
                }
            }
        } while (z);
        m12841g(c1648n);
        for (C1628a c1628a4 : m12647y) {
            c1628a4.m12448l().clear(c1628a4.m12440d());
        }
        for (C1628a c1628a5 : m12647y) {
            if (c1628a5 != m12648z) {
                List<C1628a> m12441e = c1628a5.m12441e();
                if (m12441e.size() == 1) {
                    c1628a = m12441e.get(0);
                } else {
                    BitSet bitSet2 = new BitSet(c1628a5.m12448l().length());
                    bitSet2.mo13226or(c1628a5.m12448l());
                    for (int nextSetBit = bitSet2.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet2.nextSetBit(nextSetBit + 1)) {
                        bitSet2.andNot(m12647y.get(nextSetBit).m12448l());
                    }
                    if (bitSet2.cardinality() != 1) {
                        throw new C1729f("Can't find immediate dominator for block " + c1628a5 + " in " + bitSet2 + " preds:" + m12441e);
                    }
                    c1628a = m12647y.get(bitSet2.nextSetBit(0));
                }
                C1628a c1628a6 = c1628a;
                c1628a5.m12437b(c1628a6);
                c1628a6.m12439c(c1628a5);
            }
        }
    }

    /* renamed from: e */
    private static void m12839e(C1648n c1648n) {
        Iterator<C1628a> it = c1648n.m12603A().iterator();
        while (it.hasNext()) {
            it.next().m12438b(C1730c.f10580a);
        }
        Iterator<C1628a> it2 = c1648n.m12647y().iterator();
        while (it2.hasNext()) {
            try {
                m12827a(c1648n, it2.next());
            } catch (Exception e2) {
                throw new C1729f("Failed compute block dominance frontier", e2);
            } catch (StackOverflowError e3) {
                throw new C1728e("Failed compute block dominance frontier");
            }
        }
    }

    /* renamed from: a */
    private static void m12827a(C1648n c1648n, C1628a c1628a) {
        if (c1628a.m12449m() == null) {
            Iterator<C1628a> it = c1628a.m12451o().iterator();
            while (it.hasNext()) {
                m12827a(c1648n, it.next());
            }
            List<C1628a> m12647y = c1648n.m12647y();
            BitSet bitSet = null;
            for (C1628a c1628a2 : c1628a.m12442f()) {
                if (c1628a2.m12450n() != c1628a) {
                    if (bitSet == null) {
                        bitSet = new BitSet(m12647y.size());
                    }
                    bitSet.set(c1628a2.m12440d());
                }
            }
            Iterator<C1628a> it2 = c1628a.m12451o().iterator();
            while (it2.hasNext()) {
                BitSet m12449m = it2.next().m12449m();
                for (int nextSetBit = m12449m.nextSetBit(0); nextSetBit >= 0; nextSetBit = m12449m.nextSetBit(nextSetBit + 1)) {
                    if (m12647y.get(nextSetBit).m12450n() != c1628a) {
                        if (bitSet == null) {
                            bitSet = new BitSet(m12647y.size());
                        }
                        bitSet.set(nextSetBit);
                    }
                }
            }
            if (bitSet == null || bitSet.cardinality() == 0) {
                bitSet = C1730c.f10580a;
            }
            c1628a.m12438b(bitSet);
        }
    }

    /* renamed from: f */
    private static void m12840f(C1648n c1648n) {
        c1648n.m12603A().clear();
        for (C1628a c1628a : c1648n.m12647y()) {
            if (C1721a.m13202a(c1628a, EnumC1621l.RETURN)) {
                c1628a.mo12141a(EnumC1562a.RETURN);
                c1648n.m12603A().add(c1628a);
            }
        }
    }

    /* renamed from: g */
    private static void m12841g(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            for (C1628a c1628a2 : c1628a.m12442f()) {
                if (c1628a.m12448l().get(c1628a2.m12440d())) {
                    c1628a2.mo12141a(EnumC1562a.LOOP_START);
                    c1628a.mo12141a(EnumC1562a.LOOP_END);
                    C1578l c1578l = new C1578l(c1628a2, c1628a);
                    c1628a2.mo12142a(C1566b.f10028b, c1578l);
                    c1628a.mo12142a(C1566b.f10028b, c1578l);
                }
            }
        }
    }

    /* renamed from: h */
    private static void m12842h(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            if (c1628a.mo12149b(EnumC1562a.LOOP_START)) {
                Iterator it = c1628a.mo12150c(C1566b.f10028b).iterator();
                while (it.hasNext()) {
                    c1648n.m12621a((C1578l) it.next());
                }
            }
        }
    }

    /* renamed from: i */
    private static void m12843i(C1648n c1648n) {
        if (c1648n.m12604B() != 0) {
            for (C1578l c1578l : c1648n.m12605C()) {
                for (C1578l c1578l2 : c1648n.m12605C()) {
                    if (c1578l != c1578l2 && c1578l.m12128c().containsAll(c1578l2.m12128c())) {
                        C1578l m12132g = c1578l2.m12132g();
                        if (m12132g != null) {
                            if (m12132g.m12128c().containsAll(c1578l.m12128c())) {
                                c1578l.m12126a(m12132g);
                                c1578l2.m12126a(c1578l);
                            } else {
                                m12132g.m12126a(c1578l);
                            }
                        } else {
                            c1578l2.m12126a(c1578l);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: j */
    private static boolean m12844j(C1648n c1648n) {
        List<C1628a> m12647y = c1648n.m12647y();
        for (C1628a c1628a : m12647y) {
            if (c1628a.m12441e().isEmpty() && c1628a != c1648n.m12648z()) {
                throw new C1729f("Unreachable block: " + c1628a);
            }
        }
        Iterator<C1628a> it = m12647y.iterator();
        while (it.hasNext()) {
            if (m12835b(c1648n, it.next())) {
                return true;
            }
        }
        return m12846l(c1648n);
    }

    /* renamed from: k */
    private static boolean m12845k(C1648n c1648n) {
        List<C1628a> m12647y = c1648n.m12647y();
        Iterator<C1628a> it = m12647y.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (m12837c(it.next())) {
                z = true;
            }
        }
        Iterator<C1628a> it2 = m12647y.iterator();
        while (it2.hasNext()) {
            if (m12834b(it2.next())) {
                z = true;
            }
        }
        if (C1676e.m12865b(c1648n)) {
            return true;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m12835b(C1648n c1648n, C1628a c1628a) {
        boolean z;
        boolean z2 = false;
        List c2 = c1628a.mo12150c(C1566b.f10028b);
        if (c2.size() > 1) {
            Iterator it = c2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((C1578l) it.next()).m12124a() != c1628a) {
                    z = false;
                    break;
                }
            }
            if (z) {
                C1628a m12851a = C1676e.m12851a(c1648n, c1628a.m12447k());
                m12851a.mo12141a(EnumC1562a.SYNTHETIC);
                C1676e.m12856a(m12851a, c1628a);
                Iterator it2 = c2.iterator();
                while (it2.hasNext()) {
                    C1676e.m12857a(((C1578l) it2.next()).m12127b(), c1628a, m12851a);
                }
                return true;
            }
        }
        if (c2.size() == 1) {
            C1578l c1578l = (C1578l) c2.get(0);
            List<C1638d> m12130e = c1578l.m12130e();
            if (!m12130e.isEmpty()) {
                boolean z3 = false;
                for (C1638d c1638d : m12130e) {
                    C1628a m12563b = c1638d.m12563b();
                    C1628a m12562a = c1638d.m12562a();
                    if (!m12563b.mo12149b(EnumC1562a.SYNTHETIC) && !m12562a.mo12149b(EnumC1562a.SYNTHETIC)) {
                        C1676e.m12853a(c1648n, m12562a, m12563b);
                        z3 = true;
                    }
                }
                if (z3) {
                    return true;
                }
            }
            C1628a m12127b = c1578l.m12127b();
            if (m12127b.m12441e().size() > 1) {
                for (C1628a c1628a2 : new ArrayList(m12127b.m12441e())) {
                    if (!c1628a2.mo12149b(EnumC1562a.SYNTHETIC)) {
                        C1676e.m12853a(c1648n, c1628a2, m12127b);
                        z2 = true;
                    }
                }
                return z2;
            }
        }
        return false;
    }

    /* renamed from: l */
    private static boolean m12846l(C1648n c1648n) {
        C1646l m12824a;
        if (c1648n.m12603A().size() != 1) {
            return false;
        }
        C1628a c1628a = c1648n.m12603A().get(0);
        if (c1628a.mo12446j().size() != 1 || c1628a.mo12149b(EnumC1562a.SYNTHETIC) || c1628a.mo12145a(C1566b.f10035i) || c1628a.m12441e().size() < 2) {
            return false;
        }
        List<C1628a> m13206b = C1721a.m13206b(c1628a);
        if (m13206b.size() < 2) {
            return false;
        }
        C1646l c1646l = c1628a.mo12446j().get(0);
        if (c1646l.m12590r() != 0 && !m12831a(m13206b, c1646l)) {
            return false;
        }
        boolean z = true;
        for (C1628a c1628a2 : m13206b) {
            C1628a m12851a = C1676e.m12851a(c1648n, -1);
            m12851a.mo12141a(EnumC1562a.SYNTHETIC);
            if (z) {
                m12851a.mo12141a(EnumC1562a.ORIG_RETURN);
                m12824a = c1646l;
                z = false;
            } else {
                m12824a = m12824a(c1646l);
            }
            m12851a.mo12446j().add(m12824a);
            C1676e.m12857a(c1628a2, c1628a, m12851a);
        }
        m12847m(c1648n);
        return true;
    }

    /* renamed from: a */
    private static boolean m12831a(List<C1628a> list, C1646l c1646l) {
        int m12330o = ((C1604i) c1646l.mo12426d(0)).m12330o();
        Iterator<C1628a> it = list.iterator();
        while (it.hasNext()) {
            Iterator<C1646l> it2 = it.next().mo12446j().iterator();
            while (it2.hasNext()) {
                C1604i m12588p = it2.next().m12588p();
                if (m12588p != null && m12588p.m12330o() == m12330o) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: m */
    private static void m12847m(C1648n c1648n) {
        Iterator<C1628a> it = c1648n.m12603A().iterator();
        while (it.hasNext()) {
            C1628a next = it.next();
            if (next.m12441e().isEmpty()) {
                c1648n.m12647y().remove(next);
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private static C1646l m12824a(C1646l c1646l) {
        C1646l c1646l2 = new C1646l(c1646l.m12587o(), c1646l.m12590r());
        if (c1646l.m12590r() == 1) {
            C1604i c1604i = (C1604i) c1646l.mo12426d(0);
            c1646l2.m12584c((AbstractC1598c) AbstractC1598c.m12302a(c1604i.m12330o(), c1604i.m12359s()));
        }
        c1646l2.m12143a((AbstractC1584d) c1646l);
        c1646l2.m12586e(c1646l.m12591s());
        c1646l2.m12118a(c1646l.m12122d());
        return c1646l2;
    }

    /* renamed from: n */
    private static void m12848n(C1648n c1648n) {
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            if (m12829a(it.next(), c1648n)) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private static boolean m12829a(C1628a c1628a, C1648n c1648n) {
        if (c1628a.mo12149b(EnumC1562a.REMOVE)) {
            if (!c1628a.m12441e().isEmpty() || !c1628a.m12442f().isEmpty()) {
                f10491a.mo15937b("Block {} not deleted, method: {}", c1628a, c1648n);
            } else {
                C1664a c1664a = (C1664a) c1628a.mo12146b(C1566b.f10034h);
                if (c1664a != null) {
                    c1664a.m12747a().m12771a(c1648n, c1628a);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: o */
    private static void m12849o(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            c1628a.m12152d(C1566b.f10028b);
            c1628a.mo12151c(EnumC1562a.LOOP_START);
            c1628a.mo12151c(EnumC1562a.LOOP_END);
            c1628a.m12435a((BitSet) null);
            c1628a.m12437b((C1628a) null);
            c1628a.m12438b((BitSet) null);
            c1628a.m12451o().clear();
        }
    }
}
