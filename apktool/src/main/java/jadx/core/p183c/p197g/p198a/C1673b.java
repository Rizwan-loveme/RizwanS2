package jadx.core.p183c.p197g.p198a;

import jadx.core.C1544a;
import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1573g;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p196f.C1664a;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1667d;
import jadx.core.p183c.p196f.C1668e;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p183c.p197g.C1707g;
import jadx.core.p183c.p197g.InterfaceC1712l;
import jadx.core.p183c.p197g.p198a.p199a.C1671a;
import jadx.core.p183c.p197g.p198a.p199a.C1672b;
import jadx.core.p183c.p197g.p201c.C1697b;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1735d;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: BlockFinallyExtract.java */
/* renamed from: jadx.core.c.g.a.b */
/* loaded from: classes.dex */
public class C1673b extends C1669a {

    /* renamed from: a */
    private static final InterfaceC2558b f10489a = C2568c.m15995a((Class<?>) C1673b.class);

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p() && !c1648n.m12607E()) {
            try {
                Iterator<C1666c> it = c1648n.m12606D().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (m12812a(c1648n, it.next())) {
                        z = true;
                    }
                }
                if (z) {
                    m12819b(c1648n);
                    C1675d.m12833b(c1648n);
                }
            } catch (Exception e2) {
                f10489a.mo15937b("Undo finally extract visitor, mth: {}", c1648n, e2);
                try {
                    c1648n.m12633h();
                    c1648n.m12631f();
                    for (InterfaceC1712l interfaceC1712l : C1544a.m11831a(c1648n.mo12541u().m12668j())) {
                        if (!(interfaceC1712l instanceof C1673b)) {
                            C1707g.m13090a(interfaceC1712l, c1648n);
                        } else {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    f10489a.mo15943c("Undo finally extract failed, mth: {}", c1648n, e2);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m12812a(C1648n c1648n, C1666c c1666c) {
        boolean z = false;
        boolean z2 = true;
        for (C1628a c1628a : c1666c.m12760e()) {
            if (z2) {
                z2 = c1666c.m12760e().containsAll(c1628a.m12443g());
            }
            List<C1646l> mo12446j = c1628a.mo12446j();
            int size = mo12446j.size();
            if (c1666c.m12757b() && size != 0 && mo12446j.get(size - 1).m12587o() == EnumC1621l.THROW) {
                mo12446j.remove(size - 1);
                z = true;
            }
        }
        if (z && z2 && m12821b(c1648n, c1666c)) {
            return true;
        }
        if (m12801a(c1666c) == 0 && z && z2) {
            c1666c.m12763h().m12773a(c1648n, c1666c);
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m12821b(C1648n c1648n, C1666c c1666c) {
        C1697b c1697b;
        C1697b c1697b2;
        C1672b m12805a;
        C1697b c1697b3 = null;
        boolean z = false;
        int size = c1666c.m12760e().size();
        BitSet bitSet = new BitSet(size);
        ArrayList arrayList = new ArrayList(size);
        for (C1628a c1628a : c1666c.m12760e()) {
            List<C1646l> mo12446j = c1628a.mo12446j();
            if (!mo12446j.isEmpty()) {
                if (mo12446j.get(0).m12587o() != EnumC1621l.MOVE_EXCEPTION) {
                    arrayList.add(c1628a);
                }
                bitSet.set(c1628a.m12440d());
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        LinkedList<C1672b> linkedList = new LinkedList();
        HashSet<C1628a> hashSet = new HashSet();
        C1668e m12763h = c1666c.m12763h();
        if (m12763h.m12776b() > 1) {
            for (C1666c c1666c2 : m12763h.m12769a()) {
                if (c1666c2 != c1666c) {
                    Iterator<C1628a> it = c1666c2.m12760e().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1672b m12805a2 = m12805a(c1648n, it.next(), arrayList, bitSet);
                        if (m12805a2 != null) {
                            linkedList.add(m12805a2);
                            break;
                        }
                    }
                }
            }
            if (linkedList.size() != m12763h.m12776b() - 1) {
                return false;
            }
        }
        Iterator<C1666c> it2 = m12763h.m12769a().iterator();
        while (it2.hasNext()) {
            C1667d c1667d = (C1667d) it2.next().m12759d().mo12146b(C1566b.f10035i);
            if (c1667d != null) {
                C1628a m12765a = c1667d.m12765a();
                if (!m12765a.m12443g().isEmpty()) {
                    hashSet.add(m12765a);
                }
            }
        }
        boolean z2 = false;
        for (C1628a c1628a2 : hashSet) {
            Iterator<C1628a> it3 = C1721a.m13216e(c1628a2, c1628a2.m12443g().get(0)).iterator();
            while (true) {
                if (it3.hasNext()) {
                    C1628a next = it3.next();
                    if (!bitSet.get(next.m12440d()) && (m12805a = m12805a(c1648n, next, arrayList, bitSet)) != null) {
                        linkedList.add(m12805a);
                        z2 = true;
                        break;
                    }
                }
            }
        }
        if (!z2) {
            return false;
        }
        boolean m12815a = m12815a(linkedList);
        if (m12815a) {
            C1697b c1697b4 = new C1697b(c1648n);
            c1697b4.m13040a();
            c1697b = c1697b4;
        } else {
            c1697b = null;
        }
        int i = 0;
        for (C1672b c1672b : linkedList) {
            if (m12813a(c1648n, c1672b)) {
                i++;
                c1672b.m12792a(true);
            }
        }
        if (i == 0) {
            return false;
        }
        if (i != linkedList.size()) {
            throw new C1729f("Some finally instructions failed to remove: ");
        }
        C1628a m12759d = c1666c.m12759d();
        C1646l m13194a = C1721a.m13194a((InterfaceC1640f) m12759d);
        if (m13194a == null || m13194a.m12587o() != EnumC1621l.MOVE_EXCEPTION) {
            c1697b2 = null;
        } else {
            List<C1646l> mo12446j2 = m12759d.mo12446j();
            if (!m12759d.m12443g().isEmpty()) {
                c1697b3 = new C1697b(c1648n);
                c1697b3.m13040a();
                C1604i m12588p = m13194a.m12588p();
                if (c1697b3.m13042a(m12759d.m12443g().get(0), m12588p.m12330o())) {
                    C1646l c1646l = new C1646l(EnumC1621l.NOP, 0);
                    c1646l.m12581b(m12588p);
                    c1646l.mo12141a(EnumC1562a.REMOVE);
                    mo12446j2.set(mo12446j2.size() - 1, c1646l);
                    z = true;
                }
            }
            if (!z) {
                mo12446j2.remove(mo12446j2.size() - 1);
                m12759d.mo12141a(EnumC1562a.SKIP);
            }
            c1697b2 = c1697b3;
        }
        if (m12815a) {
            if (c1697b2 == null) {
                c1697b2 = new C1697b(c1648n);
                c1697b2.m13040a();
            }
            m12808a(c1648n, linkedList, c1697b, c1697b2);
        }
        c1666c.m12755a(true);
        return true;
    }

    /* renamed from: a */
    private static void m12808a(C1648n c1648n, List<C1672b> list, C1697b c1697b, C1697b c1697b2) {
        BitSet bitSet = new BitSet(c1648n.m12612J());
        for (C1672b c1672b : list) {
            bitSet.clear();
            C1671a m12796c = c1672b.m12796c();
            C1628a m12786a = m12796c.m12786a();
            C1628a m12787b = m12796c.m12787b();
            if (!c1672b.m12800g().isEmpty() && m12787b != null) {
                for (Map.Entry<C1604i, C1604i> entry : c1672b.m12800g().entrySet()) {
                    C1604i key = entry.getKey();
                    C1604i value = entry.getValue();
                    int m12330o = key.m12330o();
                    int m12330o2 = value.m12330o();
                    if (!bitSet.get(m12330o)) {
                        boolean m13042a = c1697b.m13042a(m12786a, m12330o);
                        boolean m13042a2 = c1697b2.m13042a(m12787b, m12330o);
                        if (c1697b2.m13042a(m12787b, m12330o2) && m13042a) {
                            C1646l c1646l = new C1646l(EnumC1621l.MERGE, 2);
                            c1646l.m12581b(value.m12332q());
                            c1646l.m12584c((AbstractC1598c) value.m12332q());
                            c1646l.m12584c((AbstractC1598c) key.m12332q());
                            m12807a(c1648n, m12787b, c1646l);
                        } else if (m13042a) {
                            C1646l c1646l2 = new C1646l(EnumC1621l.MOVE, 1);
                            c1646l2.m12581b(value.m12332q());
                            c1646l2.m12584c((AbstractC1598c) key.m12332q());
                            m12807a(c1648n, m12787b, c1646l2);
                        } else if (m13042a2) {
                            C1646l c1646l3 = new C1646l(EnumC1621l.NOP, 0);
                            c1646l3.m12581b(key.m12332q());
                            c1646l3.mo12141a(EnumC1562a.REMOVE);
                            m12807a(c1648n, m12787b, c1646l3);
                        }
                        bitSet.set(m12330o);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12807a(C1648n c1648n, C1628a c1628a, C1646l c1646l) {
        c1646l.mo12141a(EnumC1562a.SYNTHETIC);
        if (c1628a.mo12446j().isEmpty()) {
            c1628a.mo12446j().add(c1646l);
        } else {
            m12802a(c1648n, c1628a, 0).m12441e().get(0).mo12446j().add(c1646l);
        }
    }

    /* renamed from: a */
    private static boolean m12815a(List<C1672b> list) {
        Iterator<C1672b> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().m12800g().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static C1672b m12805a(C1648n c1648n, C1628a c1628a, List<C1628a> list, BitSet bitSet) {
        C1672b m12804a;
        if (!list.isEmpty() && (m12804a = m12804a(c1628a, list.get(0), bitSet)) != null) {
            Set<C1671a> m12794b = m12804a.m12794b();
            if (m12794b.size() != 1 && !m12814a(c1648n, m12794b)) {
                f10489a.mo15931a("Unexpected finally block outs count: {}", m12794b);
                return null;
            }
            return m12804a;
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m12814a(C1648n c1648n, Set<C1671a> set) {
        HashSet hashSet = new HashSet();
        boolean z = true;
        for (C1671a c1671a : set) {
            if (!c1671a.m12786a().m12453q()) {
                z = false;
            }
            hashSet.add(c1671a.m12787b());
        }
        if (!z || hashSet.size() != 1) {
            return false;
        }
        Iterator<C1671a> it = set.iterator();
        while (it.hasNext()) {
            C1628a m12786a = it.next().m12786a();
            if (!m12786a.mo12149b(EnumC1562a.ORIG_RETURN)) {
                m12806a(c1648n, m12786a);
                it.remove();
            }
        }
        return true;
    }

    /* renamed from: a */
    private static C1672b m12804a(C1628a c1628a, C1628a c1628a2, BitSet bitSet) {
        C1672b m12803a = m12803a(c1628a, c1628a2);
        if (m12803a != null && m12810a(c1628a, c1628a2, m12803a, bitSet)) {
            return m12803a;
        }
        return null;
    }

    /* renamed from: a */
    private static C1672b m12803a(C1628a c1628a, C1628a c1628a2) {
        int i;
        boolean z = true;
        List<C1646l> mo12446j = c1628a.mo12446j();
        List<C1646l> mo12446j2 = c1628a2.mo12446j();
        if (mo12446j.size() < mo12446j2.size()) {
            return null;
        }
        int size = mo12446j.size() - mo12446j2.size();
        if (m12816a(mo12446j, mo12446j2, size, (C1672b) null)) {
            i = 0;
        } else if (m12816a(mo12446j, mo12446j2, 0, (C1672b) null)) {
            i = mo12446j2.size();
            size = 0;
        } else {
            int i2 = 1;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    i = 0;
                    break;
                }
                if (!m12816a(mo12446j, mo12446j2, i2, (C1672b) null)) {
                    i2++;
                } else {
                    i = mo12446j2.size() + i2;
                    size = i2;
                    break;
                }
            }
            if (!z) {
                return null;
            }
        }
        C1671a c1671a = new C1671a(c1628a, c1628a2);
        C1672b c1672b = new C1672b(c1671a);
        c1672b.m12789a(size);
        c1672b.m12795b(i);
        if (i != 0) {
            c1672b.m12791a(c1671a);
        }
        if (m12816a(mo12446j, mo12446j2, size, c1672b)) {
            return c1672b;
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m12816a(List<C1646l> list, List<C1646l> list2, int i, C1672b c1672b) {
        for (int size = list2.size() - 1; size >= 0; size--) {
            if (!m12811a(list.get(i + size), list2.get(size), c1672b)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m12810a(C1628a c1628a, C1628a c1628a2, C1672b c1672b, BitSet bitSet) {
        if (!c1672b.m12788a().isEmpty() && !m12809a(c1628a, c1628a2, c1672b)) {
            return false;
        }
        C1671a c1671a = new C1671a(c1628a, c1628a2);
        c1672b.m12788a().add(c1671a);
        List<C1628a> m12443g = c1628a2.m12443g();
        List<C1628a> m12443g2 = c1628a.m12443g();
        if (m12443g.size() != m12443g2.size()) {
            c1672b.m12794b().add(c1671a);
            return true;
        }
        for (int i = 0; i < m12443g.size(); i++) {
            C1628a c1628a3 = m12443g.get(i);
            C1628a c1628a4 = m12443g2.get(i);
            if (bitSet.get(c1628a3.m12440d())) {
                if (c1672b.m12799f() != 0 || !m12810a(c1628a4, c1628a3, c1672b, bitSet)) {
                    return false;
                }
            } else {
                c1672b.m12794b().add(new C1671a(c1628a4, c1628a3));
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m12809a(C1628a c1628a, C1628a c1628a2, C1672b c1672b) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        List<C1646l> mo12446j2 = c1628a2.mo12446j();
        if (mo12446j.size() < mo12446j2.size()) {
            return false;
        }
        int size = mo12446j2.size();
        for (int i = 0; i < size; i++) {
            if (!m12811a(mo12446j.get(i), mo12446j2.get(i), c1672b)) {
                return false;
            }
        }
        if (mo12446j.size() > mo12446j2.size()) {
            c1672b.m12795b(mo12446j2.size());
            c1672b.m12791a(new C1671a(c1628a, c1628a2));
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m12811a(C1646l c1646l, C1646l c1646l2, C1672b c1672b) {
        if (!c1646l.mo12254a(c1646l2)) {
            return false;
        }
        for (int i = 0; i < c1646l.m12590r(); i++) {
            AbstractC1598c mo12426d = c1646l.mo12426d(i);
            AbstractC1598c mo12426d2 = c1646l2.mo12426d(i);
            if (mo12426d.mo12298h() != mo12426d2.mo12298h()) {
                return false;
            }
            if (c1672b != null && mo12426d2.mo12298h()) {
                C1604i c1604i = (C1604i) mo12426d;
                C1604i c1604i2 = (C1604i) mo12426d2;
                if (c1604i.m12330o() == c1604i2.m12330o()) {
                    continue;
                } else {
                    C1604i c1604i3 = c1672b.m12800g().get(mo12426d);
                    if (c1604i3 == null) {
                        c1672b.m12800g().put(c1604i, c1604i2);
                    } else if (!c1604i3.m12328a(c1604i2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m12813a(C1648n c1648n, C1672b c1672b) {
        C1628a c1628a;
        C1671a c1671a;
        C1628a m12786a = c1672b.m12796c().m12786a();
        C1628a m12787b = c1672b.m12796c().m12787b();
        if (m12786a.mo12149b(EnumC1562a.REMOVE)) {
            return true;
        }
        if (m12786a.m12441e().size() != 1) {
            f10489a.mo15939b("Finally extract failed: remBlock pred: {}, {}, method: {}", m12786a, m12786a.m12441e(), c1648n);
            return false;
        }
        if (c1672b.m12794b().isEmpty()) {
            C1735d.m13258a(c1648n, "Failed to extract finally block: empty outs");
            return false;
        }
        c1672b.m12790a(m12786a.m12441e().get(0));
        int m12798e = c1672b.m12798e();
        int m12799f = c1672b.m12799f();
        if (c1672b.m12796c().equals(c1672b.m12797d())) {
            c1672b.m12795b(m12799f - m12798e);
        }
        if (m12798e > 0) {
            C1628a m12802a = m12802a(c1648n, m12786a, m12798e);
            c1672b.m12788a().remove(c1672b.m12796c());
            c1672b.m12788a().add(new C1671a(m12802a, m12787b));
            c1628a = m12802a;
        } else {
            c1628a = m12786a;
        }
        if (m12799f > 0) {
            C1628a m12802a2 = m12802a(c1648n, c1672b.m12797d().m12786a(), m12799f);
            for (C1628a c1628a2 : m12802a2.m12442f()) {
                Iterator<C1671a> it = c1672b.m12794b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        c1671a = null;
                        break;
                    }
                    C1671a next = it.next();
                    if (next.m12786a().equals(c1628a2)) {
                        it.remove();
                        c1671a = new C1671a(m12802a2, next.m12787b());
                        break;
                    }
                }
                if (c1671a != null) {
                    c1672b.m12794b().add(c1671a);
                }
            }
        }
        Set<C1671a> m12794b = c1672b.m12794b();
        if (m12794b.isEmpty()) {
            throw new C1729f("Failed to extract finally block: all outs is deleted");
        }
        C1671a next2 = m12794b.iterator().next();
        C1628a m12786a2 = next2.m12786a();
        C1628a m12787b2 = next2.m12787b();
        List<C1628a> m13206b = C1721a.m13206b(m12787b2);
        if (m13206b.size() > 1) {
            C1628a m12853a = C1676e.m12853a(c1648n, m12787b2.m12441e().get(0), m12787b2);
            Iterator it2 = new ArrayList(m12787b2.m12441e()).iterator();
            while (it2.hasNext()) {
                C1628a c1628a3 = (C1628a) it2.next();
                if (c1628a3 != m12853a) {
                    C1676e.m12857a(c1628a3, m12787b2, m12853a);
                }
            }
            m12786a2.m12441e().clear();
            m12818b(m12853a, m12786a2);
            C1676e.m12856a(m12853a, m12786a2);
        } else if (m13206b.size() == 1) {
            C1628a c1628a4 = m13206b.get(0);
            C1628a m12793b = c1672b.m12793b(c1628a4);
            if (m12793b == null) {
                throw new C1729f("Block not found by " + c1628a4 + ", in " + c1672b);
            }
            C1676e.m12863b(c1628a4, m12786a2);
            m12818b(m12793b, m12786a2);
            C1676e.m12856a(m12793b, m12786a2);
        } else {
            throw new C1729f("Finally extract failed, unexpected preds: " + m13206b + " for " + m12787b2 + ", method: " + c1648n);
        }
        Iterator it3 = new ArrayList(c1628a.m12441e()).iterator();
        while (it3.hasNext()) {
            C1628a m12853a2 = C1676e.m12853a(c1648n, (C1628a) it3.next(), c1628a);
            C1676e.m12863b(m12853a2, c1628a);
            C1676e.m12856a(m12853a2, m12787b);
            m12818b(m12853a2, m12787b);
            C1676e.m12856a(m12853a2, m12786a2);
            C1676e.m12864b(m12853a2, c1628a, m12786a2);
        }
        m12806a(c1648n, c1628a);
        for (C1671a c1671a2 : c1672b.m12788a()) {
            m12806a(c1648n, c1671a2.m12786a());
            c1671a2.m12787b().m12444h();
        }
        return true;
    }

    /* renamed from: a */
    private static C1628a m12802a(C1648n c1648n, C1628a c1628a, int i) {
        C1628a m12851a = C1676e.m12851a(c1648n, -1);
        m12851a.m12442f().addAll(c1628a.m12442f());
        Iterator it = new ArrayList(c1628a.m12442f()).iterator();
        while (it.hasNext()) {
            C1628a c1628a2 = (C1628a) it.next();
            C1676e.m12863b(c1628a, c1628a2);
            C1676e.m12856a(m12851a, c1628a2);
        }
        c1628a.m12442f().clear();
        C1676e.m12856a(c1628a, m12851a);
        c1628a.m12444h();
        m12851a.m12444h();
        List<C1646l> mo12446j = c1628a.mo12446j();
        int size = mo12446j.size();
        while (i < size) {
            C1646l c1646l = mo12446j.get(i);
            c1646l.mo12141a(EnumC1562a.SKIP);
            m12851a.mo12446j().add(c1646l);
            i++;
        }
        Iterator<C1646l> it2 = mo12446j.iterator();
        while (it2.hasNext()) {
            if (it2.next().mo12149b(EnumC1562a.SKIP)) {
                it2.remove();
            }
        }
        Iterator<C1646l> it3 = m12851a.mo12446j().iterator();
        while (it3.hasNext()) {
            it3.next().mo12151c(EnumC1562a.SKIP);
        }
        return m12851a;
    }

    /* renamed from: a */
    private static void m12806a(C1648n c1648n, C1628a c1628a) {
        for (C1628a c1628a2 : c1628a.m12441e()) {
            c1628a2.m12442f().remove(c1628a);
            c1628a2.m12444h();
        }
        Iterator<C1628a> it = c1628a.m12442f().iterator();
        while (it.hasNext()) {
            it.next().m12441e().remove(c1628a);
        }
        c1628a.m12441e().clear();
        c1628a.m12442f().clear();
        c1628a.mo12141a(EnumC1562a.REMOVE);
        c1628a.mo12151c(EnumC1562a.SKIP);
        C1664a c1664a = (C1664a) c1628a.mo12146b(C1566b.f10034h);
        if (c1664a != null) {
            c1664a.m12747a().m12771a(c1648n, c1628a);
            for (C1628a c1628a3 : c1648n.m12647y()) {
                if (c1628a3.mo12149b(EnumC1562a.SKIP)) {
                    m12806a(c1648n, c1628a3);
                }
            }
        }
    }

    /* renamed from: b */
    private static void m12818b(C1628a c1628a, C1628a c1628a2) {
        C1573g c1573g = (C1573g) c1628a.mo12146b(C1566b.f10048v);
        if (c1573g == null) {
            c1573g = new C1573g();
            c1628a.mo12144a(c1573g);
        }
        c1573g.m12111a().add(c1628a2);
    }

    /* renamed from: a */
    private static int m12801a(C1666c c1666c) {
        Iterator<C1628a> it = c1666c.m12760e().iterator();
        int i = 0;
        while (it.hasNext()) {
            List<C1646l> mo12446j = it.next().mo12446j();
            if (!mo12446j.isEmpty() && mo12446j.get(0).m12587o() == EnumC1621l.MOVE_EXCEPTION) {
                i--;
            }
            i = mo12446j.size() + i;
        }
        return i;
    }

    /* renamed from: b */
    private static void m12819b(C1648n c1648n) {
        C1573g c1573g;
        C1628a c1628a;
        C1628a m12817b = m12817b(c1648n.m12603A());
        if (m12817b != null && (c1573g = (C1573g) m12817b.mo12146b(C1566b.f10048v)) != null) {
            LinkedList<C1628a> linkedList = new LinkedList();
            for (C1628a c1628a2 : m12817b.m12442f()) {
                if (c1628a2.mo12149b(EnumC1562a.RETURN)) {
                    linkedList.add(c1628a2);
                }
            }
            if (linkedList.size() >= 2) {
                Iterator<E> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        c1628a = null;
                        break;
                    }
                    C1628a c1628a3 = (C1628a) it.next();
                    if (c1628a3.mo12149b(EnumC1562a.ORIG_RETURN)) {
                        c1628a = c1628a3;
                        break;
                    }
                }
                if (c1628a != null) {
                    for (C1628a c1628a4 : linkedList) {
                        if (c1628a4 != c1628a) {
                            Iterator<C1628a> it2 = c1628a4.m12441e().iterator();
                            while (it2.hasNext()) {
                                C1676e.m12856a(it2.next(), c1628a);
                            }
                            m12806a(c1648n, c1628a4);
                            c1573g.m12111a().remove(c1628a4);
                        }
                    }
                    m12820b(c1648n, c1628a);
                }
            }
        }
    }

    /* renamed from: b */
    private static void m12820b(C1648n c1648n, C1628a c1628a) {
        C1628a c1628a2 = null;
        ArrayList<C1628a> arrayList = new ArrayList(c1628a.m12441e());
        Iterator<E> it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((C1628a) it.next()).m12452p()) {
                it.remove();
            }
        }
        if (arrayList.size() >= 2) {
            C1628a c1628a3 = null;
            for (C1628a c1628a4 : arrayList) {
                List<C1628a> m12442f = c1628a4.m12442f();
                if (m12442f.size() == 2) {
                    C1628a m13205b = C1721a.m13205b(c1628a, m12442f);
                    if (c1628a3 != null) {
                        if (m13205b != c1628a3) {
                            return;
                        } else {
                            m13205b = c1628a3;
                        }
                    }
                    if (!c1628a4.mo12145a(C1566b.f10048v)) {
                        return;
                    } else {
                        c1628a3 = m13205b;
                    }
                } else {
                    return;
                }
            }
            if (c1628a3 != null) {
                for (C1628a c1628a5 : arrayList) {
                    if (c1628a2 == null) {
                        c1628a2 = c1628a5;
                    } else {
                        Iterator<C1628a> it2 = c1628a5.m12441e().iterator();
                        while (it2.hasNext()) {
                            C1676e.m12856a(it2.next(), c1628a2);
                        }
                        m12806a(c1648n, c1628a5);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static C1628a m12817b(List<C1628a> list) {
        for (C1628a c1628a : list) {
            for (C1628a c1628a2 : c1628a.m12441e()) {
                C1573g c1573g = (C1573g) c1628a2.mo12146b(C1566b.f10048v);
                if (c1573g != null && c1573g.m12112a(c1628a)) {
                    return c1628a2;
                }
            }
        }
        return null;
    }
}
