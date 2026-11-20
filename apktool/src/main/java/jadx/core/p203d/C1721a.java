package jadx.core.p203d;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1573g;
import jadx.core.p183c.p184a.p186b.C1581o;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p190b.C1611b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p193e.p194a.C1653b;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: BlockUtils.java */
/* renamed from: jadx.core.d.a */
/* loaded from: classes.dex */
public class C1721a {
    /* renamed from: a */
    public static C1628a m13188a(int i, Iterable<C1628a> iterable) {
        for (C1628a c1628a : iterable) {
            if (c1628a.m12447k() == i) {
                return c1628a;
            }
        }
        throw new C1729f("Can't find block by offset: " + C1739h.m13270a(i) + " in list " + iterable);
    }

    /* renamed from: a */
    public static C1628a m13189a(C1628a c1628a, List<C1628a> list) {
        if (list.size() > 2) {
            list = m13212c(list);
        }
        if (list.size() != 2) {
            throw new C1729f("Incorrect nodes count for selectOther: " + c1628a + " in " + list);
        }
        C1628a c1628a2 = list.get(0);
        return c1628a2 != c1628a ? c1628a2 : list.get(1);
    }

    /* renamed from: b */
    public static C1628a m13205b(C1628a c1628a, List<C1628a> list) {
        int size = list.size();
        if (size == 1) {
            C1628a c1628a2 = list.get(0);
            if (c1628a2 != c1628a) {
                return c1628a2;
            }
            return null;
        }
        if (size != 2) {
            return null;
        }
        C1628a c1628a3 = list.get(0);
        return c1628a3 == c1628a ? list.get(1) : c1628a3;
    }

    /* renamed from: a */
    public static boolean m13198a(C1628a c1628a) {
        if (c1628a.mo12145a(C1566b.f10033g) || c1628a.mo12149b(EnumC1562a.SKIP)) {
            return true;
        }
        if (!c1628a.mo12149b(EnumC1562a.SYNTHETIC)) {
            return false;
        }
        List<C1628a> m12442f = c1628a.m12442f();
        return m12442f.size() == 1 && m12442f.get(0).mo12145a(C1566b.f10033g);
    }

    /* renamed from: c */
    private static List<C1628a> m13212c(List<C1628a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C1628a c1628a : list) {
            if (!m13198a(c1628a)) {
                arrayList.add(c1628a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m13196a(C1648n c1648n, BitSet bitSet) {
        int nextSetBit = bitSet.nextSetBit(0);
        while (nextSetBit >= 0) {
            if (m13198a(c1648n.m12647y().get(nextSetBit))) {
                bitSet.clear(nextSetBit);
            }
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
        }
    }

    /* renamed from: b */
    public static List<C1628a> m13206b(C1628a c1628a) {
        List<C1628a> m12441e = c1628a.m12441e();
        ArrayList arrayList = new ArrayList(m12441e.size());
        for (C1628a c1628a2 : m12441e) {
            C1573g c1573g = (C1573g) c1628a2.mo12146b(C1566b.f10048v);
            if (c1573g == null || !c1573g.m12112a(c1628a)) {
                arrayList.add(c1628a2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m13199a(C1628a c1628a, C1628a c1628a2) {
        if (c1628a2 == null || c1628a.m12443g().contains(c1628a2)) {
            return false;
        }
        return c1628a.m12442f().contains(c1628a2);
    }

    /* renamed from: a */
    public static boolean m13201a(C1628a c1628a, C1646l c1646l) {
        Iterator<C1646l> it = c1628a.mo12446j().iterator();
        while (it.hasNext()) {
            if (it.next() == c1646l) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m13202a(InterfaceC1640f interfaceC1640f, EnumC1621l enumC1621l) {
        C1646l m13194a = m13194a(interfaceC1640f);
        return m13194a != null && m13194a.m12587o() == enumC1621l;
    }

    /* renamed from: a */
    public static C1646l m13194a(InterfaceC1640f interfaceC1640f) {
        if (interfaceC1640f == null) {
            return null;
        }
        List<C1646l> mo12446j = interfaceC1640f.mo12446j();
        if (mo12446j.isEmpty()) {
            return null;
        }
        return mo12446j.get(mo12446j.size() - 1);
    }

    /* renamed from: a */
    public static C1628a m13192a(C1648n c1648n, C1646l c1646l) {
        if (c1646l instanceof C1625p) {
            return m13190a(c1648n, (C1625p) c1646l);
        }
        if (c1646l.mo12149b(EnumC1562a.WRAPPED)) {
            return m13211c(c1648n, c1646l);
        }
        for (C1628a c1628a : c1648n.m12647y()) {
            if (m13201a(c1628a, c1646l)) {
                return c1628a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1628a m13190a(C1648n c1648n, C1625p c1625p) {
        for (C1628a c1628a : c1648n.m12647y()) {
            C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                Iterator<C1625p> it = c1581o.m12135a().iterator();
                while (it.hasNext()) {
                    if (it.next() == c1625p) {
                        return c1628a;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    private static C1628a m13211c(C1648n c1648n, C1646l c1646l) {
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            C1628a next = it.next();
            for (C1646l c1646l2 : next.mo12446j()) {
                if (c1646l2 == c1646l || m13186a(c1646l2, c1646l) != null) {
                    return next;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static AbstractC1598c m13204b(C1648n c1648n, C1646l c1646l) {
        if (!c1646l.mo12149b(EnumC1562a.WRAPPED)) {
            return null;
        }
        Iterator<C1628a> it = c1648n.m12647y().iterator();
        while (it.hasNext()) {
            Iterator<C1646l> it2 = it.next().mo12446j().iterator();
            while (it2.hasNext()) {
                AbstractC1598c m13186a = m13186a(it2.next(), c1646l);
                if (m13186a != null) {
                    return m13186a;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static AbstractC1598c m13186a(C1646l c1646l, C1646l c1646l2) {
        for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
            if (abstractC1598c.mo12312j()) {
                C1646l m12316d = ((C1599d) abstractC1598c).m12316d();
                if (m12316d != c1646l2) {
                    AbstractC1598c m13186a = m13186a(m12316d, c1646l2);
                    if (m13186a != null) {
                        return m13186a;
                    }
                } else {
                    return abstractC1598c;
                }
            }
        }
        if (c1646l instanceof C1611b) {
            return m13187a(((C1611b) c1646l).m12373f(), c1646l2);
        }
        return null;
    }

    /* renamed from: a */
    private static AbstractC1598c m13187a(C1653b c1653b, C1646l c1646l) {
        if (c1653b.m12691f()) {
            return m13186a(c1653b.m12692g().m12673d(), c1646l);
        }
        Iterator<C1653b> it = c1653b.m12687b().iterator();
        while (it.hasNext()) {
            AbstractC1598c m13187a = m13187a(it.next(), c1646l);
            if (m13187a != null) {
                return m13187a;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static List<C1628a> m13207b(C1648n c1648n, BitSet bitSet) {
        int cardinality = bitSet.cardinality();
        if (cardinality == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cardinality);
        int nextSetBit = bitSet.nextSetBit(0);
        while (nextSetBit >= 0) {
            arrayList.add(c1648n.m12647y().get(nextSetBit));
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
        }
        return arrayList;
    }

    /* renamed from: c */
    public static C1628a m13210c(C1628a c1628a) {
        List<C1628a> m12443g = c1628a.m12443g();
        if (m12443g.isEmpty()) {
            return null;
        }
        return m12443g.get(0);
    }

    /* renamed from: b */
    public static Set<C1628a> m13209b(C1628a c1628a, C1628a c1628a2) {
        HashSet hashSet = new HashSet();
        hashSet.add(c1628a);
        if (c1628a != c1628a2) {
            m13197a(hashSet, c1628a2, c1628a);
        }
        return hashSet;
    }

    /* renamed from: a */
    private static void m13197a(Set<C1628a> set, C1628a c1628a, C1628a c1628a2) {
        set.add(c1628a);
        for (C1628a c1628a3 : c1628a.m12441e()) {
            if (c1628a3 != c1628a2 && !set.contains(c1628a3)) {
                m13197a(set, c1628a3, c1628a2);
            }
        }
    }

    /* renamed from: a */
    private static boolean m13200a(C1628a c1628a, C1628a c1628a2, BitSet bitSet, boolean z) {
        for (C1628a c1628a3 : z ? c1628a.m12443g() : c1628a.m12442f()) {
            if (c1628a3 == c1628a2) {
                return true;
            }
            int m12440d = c1628a3.m12440d();
            if (!bitSet.get(m12440d)) {
                bitSet.set(m12440d);
                if (!c1628a2.m12436a(c1628a3) && !m13200a(c1628a3, c1628a2, bitSet, z)) {
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m13213c(C1628a c1628a, C1628a c1628a2) {
        if (c1628a == c1628a2 || c1628a2.m12436a(c1628a) || c1628a.m12443g().contains(c1628a2)) {
            return true;
        }
        if (c1628a.m12441e().contains(c1628a2)) {
            return false;
        }
        return m13200a(c1628a, c1628a2, new BitSet(), true);
    }

    /* renamed from: d */
    public static boolean m13215d(C1628a c1628a, C1628a c1628a2) {
        if (c1628a == c1628a2 || c1628a2.m12436a(c1628a) || c1628a.m12442f().contains(c1628a2)) {
            return true;
        }
        if (c1628a.m12441e().contains(c1628a2)) {
            return false;
        }
        return m13200a(c1628a, c1628a2, new BitSet(), false);
    }

    /* renamed from: a */
    public static C1628a m13193a(Collection<C1628a> collection) {
        boolean z;
        if (collection.size() == 1) {
            return collection.iterator().next();
        }
        for (C1628a c1628a : collection) {
            Iterator<C1628a> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                C1628a next = it.next();
                if (c1628a != next && !m13215d(c1628a, next)) {
                    z = false;
                    break;
                }
            }
            if (z) {
                return c1628a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C1628a m13191a(C1648n c1648n, C1628a c1628a, C1628a c1628a2) {
        if (c1628a == null || c1628a2 == null) {
            return null;
        }
        BitSet bitSet = new BitSet();
        bitSet.mo13226or(c1628a.m12449m());
        bitSet.and(c1628a2.m12449m());
        bitSet.clear(c1628a.m12440d());
        bitSet.clear(c1628a2.m12440d());
        if (bitSet.cardinality() == 1) {
            C1628a c1628a3 = c1648n.m12647y().get(bitSet.nextSetBit(0));
            if (m13213c(c1628a, c1628a3) && m13213c(c1628a2, c1628a3)) {
                return c1628a3;
            }
        }
        if (m13213c(c1628a, c1628a2)) {
            return c1628a2;
        }
        if (m13213c(c1628a2, c1628a)) {
            return c1628a;
        }
        return null;
    }

    /* renamed from: e */
    public static List<C1628a> m13216e(C1628a c1628a, C1628a c1628a2) {
        ArrayList arrayList = new ArrayList();
        m13195a(c1628a, c1628a2, arrayList, new HashSet());
        return arrayList;
    }

    /* renamed from: a */
    private static void m13195a(C1628a c1628a, C1628a c1628a2, List<C1628a> list, Set<C1628a> set) {
        if (!set.contains(c1628a2)) {
            set.add(c1628a2);
            for (C1628a c1628a3 : c1628a2.m12443g()) {
                if (c1628a3.m12436a(c1628a)) {
                    list.add(c1628a3);
                    m13195a(c1628a, c1628a3, list, set);
                }
            }
        }
    }

    /* renamed from: d */
    public static List<C1628a> m13214d(C1628a c1628a) {
        LinkedList linkedList = new LinkedList();
        while (c1628a != null && c1628a.m12443g().size() < 2 && c1628a.m12441e().size() == 1) {
            linkedList.add(c1628a);
            c1628a = m13210c(c1628a);
        }
        if (linkedList.isEmpty()) {
            return Collections.emptyList();
        }
        return linkedList;
    }

    /* renamed from: e */
    public static void m13217e(C1628a c1628a) {
        for (C1628a c1628a2 : c1628a.m12441e()) {
            if (c1628a2.mo12149b(EnumC1562a.SYNTHETIC) && !c1628a2.mo12145a(C1566b.f10035i) && c1628a2.mo12446j().isEmpty()) {
                c1628a2.mo12141a(EnumC1562a.SKIP);
                m13217e(c1628a2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return false;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m13219f(C1628a c1628a, C1628a c1628a2) {
        if (c1628a == c1628a2 && c1628a.mo12446j().isEmpty()) {
            return true;
        }
        if (!c1628a.mo12446j().isEmpty() || c1628a.m12443g().size() != 1) {
            return false;
        }
        C1628a m13210c = m13210c(c1628a);
        while (m13210c != null && m13210c != c1628a2 && m13210c.m12443g().size() < 2 && m13210c.m12441e().size() == 1 && m13210c.mo12446j().isEmpty()) {
            m13210c = m13210c(m13210c);
        }
        return true;
    }

    /* renamed from: f */
    public static C1628a m13218f(C1628a c1628a) {
        return (c1628a.m12452p() && c1628a.m12442f().size() == 1) ? c1628a.m12442f().get(0) : c1628a;
    }

    /* renamed from: g */
    public static C1628a m13220g(C1628a c1628a) {
        return (c1628a.m12452p() && c1628a.m12441e().size() == 1) ? c1628a.m12441e().get(0) : c1628a;
    }

    /* renamed from: a */
    public static boolean m13203a(List<C1628a> list) {
        Iterator<C1628a> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().mo12446j().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static List<C1646l> m13208b(List<C1628a> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<C1628a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().mo12446j());
        }
        return arrayList;
    }
}
