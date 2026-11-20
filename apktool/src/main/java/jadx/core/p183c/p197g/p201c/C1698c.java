package jadx.core.p183c.p197g.p201c;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p184a.p186b.C1581o;
import jadx.core.p183c.p188c.C1625p;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.C1738g;
import jadx.core.p203d.C1740i;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: SSATransform.java */
/* renamed from: jadx.core.c.g.c.c */
/* loaded from: classes.dex */
public class C1698c extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            m13055b(c1648n);
        }
    }

    /* renamed from: b */
    private static void m13055b(C1648n c1648n) {
        int i = 0;
        C1697b c1697b = new C1697b(c1648n);
        c1697b.m13040a();
        int m12612J = c1648n.m12612J();
        for (int i2 = 0; i2 < m12612J; i2++) {
            m13047a(c1648n, i2, c1697b);
        }
        m13058c(c1648n);
        m13059d(c1648n);
        m13060e(c1648n);
        m13045a(c1648n.m12635j());
        while (true) {
            boolean m13061f = m13061f(c1648n);
            int i3 = i + 1;
            if (i > 50) {
                throw new C1729f("Phi nodes fix limit reached!");
            }
            if (!m13061f) {
                return;
            } else {
                i = i3;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static void m13047a(C1648n c1648n, int i, C1697b c1697b) {
        List<C1628a> m12647y = c1648n.m12647y();
        int size = m12647y.size();
        BitSet bitSet = new BitSet(size);
        BitSet bitSet2 = new BitSet(size);
        LinkedList linkedList = new LinkedList();
        BitSet m13039a = c1697b.m13039a(i);
        for (int nextSetBit = m13039a.nextSetBit(0); nextSetBit >= 0; nextSetBit = m13039a.nextSetBit(nextSetBit + 1)) {
            bitSet2.set(nextSetBit);
            linkedList.add(m12647y.get(nextSetBit));
        }
        while (!linkedList.isEmpty()) {
            BitSet m12449m = ((C1628a) linkedList.pop()).m12449m();
            for (int nextSetBit2 = m12449m.nextSetBit(0); nextSetBit2 >= 0; nextSetBit2 = m12449m.nextSetBit(nextSetBit2 + 1)) {
                if (!bitSet.get(nextSetBit2) && c1697b.m13041a(nextSetBit2, i)) {
                    C1628a c1628a = m12647y.get(nextSetBit2);
                    m13044a(c1648n, c1628a, i);
                    bitSet.set(nextSetBit2);
                    if (!bitSet2.get(nextSetBit2)) {
                        bitSet2.set(nextSetBit2);
                        linkedList.add(c1628a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static C1625p m13044a(C1648n c1648n, C1628a c1628a, int i) {
        C1581o c1581o;
        int i2;
        C1581o c1581o2 = (C1581o) c1628a.mo12146b(C1566b.f10044r);
        if (c1581o2 == null) {
            C1581o c1581o3 = new C1581o();
            c1628a.mo12144a(c1581o3);
            c1581o = c1581o3;
        } else {
            c1581o = c1581o2;
        }
        int size = c1628a.m12441e().size();
        if (c1648n.m12648z() == c1628a) {
            Iterator<C1604i> it = c1648n.m12620a(true).iterator();
            while (it.hasNext()) {
                if (it.next().m12330o() == i) {
                    i2 = size + 1;
                    break;
                }
            }
        }
        i2 = size;
        C1625p c1625p = new C1625p(i, i2);
        c1581o.m12135a().add(c1625p);
        c1625p.m12586e(c1628a.m12447k());
        c1628a.mo12446j().add(0, c1625p);
        return c1625p;
    }

    /* renamed from: c */
    private static void m13058c(C1648n c1648n) {
        if (!c1648n.m12614L().isEmpty()) {
            throw new C1729f("SSA rename variables already executed");
        }
        int m12612J = c1648n.m12612J();
        C1605j[] c1605jArr = new C1605j[m12612J];
        int[] iArr = new int[m12612J];
        for (C1604i c1604i : c1648n.m12620a(true)) {
            int m12330o = c1604i.m12330o();
            c1605jArr[m12330o] = m13043a(c1648n, iArr, c1604i, m12330o);
        }
        C1628a m12648z = c1648n.m12648z();
        m13049a(c1605jArr, m12648z);
        m13048a(c1648n, c1605jArr, iArr, m12648z);
    }

    /* renamed from: a */
    private static C1605j m13043a(C1648n c1648n, int[] iArr, C1604i c1604i, int i) {
        int i2 = iArr[i];
        iArr[i] = i2 + 1;
        return c1648n.m12618a(i, i2, c1604i);
    }

    /* renamed from: a */
    private static void m13049a(C1605j[] c1605jArr, C1628a c1628a) {
        C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
        if (c1581o != null) {
            Iterator<C1625p> it = c1581o.m12135a().iterator();
            while (it.hasNext()) {
                m13050a(c1605jArr, c1628a, it.next());
            }
        }
    }

    /* renamed from: a */
    private static void m13048a(C1648n c1648n, C1605j[] c1605jArr, int[] iArr, C1628a c1628a) {
        C1605j[] c1605jArr2 = (C1605j[]) Arrays.copyOf(c1605jArr, c1605jArr.length);
        for (C1646l c1646l : c1628a.mo12446j()) {
            if (c1646l.m12587o() != EnumC1621l.PHI) {
                for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
                    if (abstractC1598c.mo12298h()) {
                        C1604i c1604i = (C1604i) abstractC1598c;
                        int m12330o = c1604i.m12330o();
                        C1605j c1605j = c1605jArr[m12330o];
                        if (c1605j == null) {
                            throw new C1729f("Not initialized variable reg: " + m12330o + ", insn: " + c1646l + ", block:" + c1628a + ", method: " + c1648n);
                        }
                        c1605j.m12340b(c1604i);
                    }
                }
            }
            C1604i m12588p = c1646l.m12588p();
            if (m12588p != null) {
                int m12330o2 = m12588p.m12330o();
                c1605jArr[m12330o2] = m13043a(c1648n, iArr, m12588p, m12330o2);
            }
        }
        Iterator<C1628a> it = c1628a.m12442f().iterator();
        while (it.hasNext()) {
            C1581o c1581o = (C1581o) it.next().mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                Iterator<C1625p> it2 = c1581o.m12135a().iterator();
                while (it2.hasNext()) {
                    m13050a(c1605jArr, c1628a, it2.next());
                }
            }
        }
        Iterator<C1628a> it3 = c1628a.m12451o().iterator();
        while (it3.hasNext()) {
            m13048a(c1648n, c1605jArr, iArr, it3.next());
        }
        System.arraycopy(c1605jArr2, 0, c1605jArr, 0, c1605jArr.length);
    }

    /* renamed from: a */
    private static void m13050a(C1605j[] c1605jArr, C1628a c1628a, C1625p c1625p) {
        C1605j c1605j = c1605jArr[c1625p.m12588p().m12330o()];
        if (c1605j != null) {
            c1605j.m12340b(c1625p.m12419a(c1628a));
            c1605j.m12338a(c1625p);
        }
    }

    /* renamed from: d */
    private static void m13059d(C1648n c1648n) {
        for (C1628a c1628a : c1648n.m12647y()) {
            C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
            if (c1581o != null && c1628a.mo12145a(C1566b.f10033g)) {
                Iterator<C1625p> it = c1581o.m12135a().iterator();
                while (it.hasNext()) {
                    m13046a(it.next());
                }
            }
        }
    }

    /* renamed from: a */
    private static void m13046a(C1625p c1625p) {
        int r = c1625p.m12590r();
        int i = 0;
        while (i < r) {
            C1604i mo12426d = c1625p.mo12426d(i);
            C1646l m12333r = mo12426d.m12333r();
            if (m12333r != null && m12333r.m12588p() != null && m12333r.mo12149b(EnumC1562a.TRY_LEAVE) && c1625p.mo12423a((AbstractC1598c) mo12426d)) {
                r--;
            } else {
                i++;
            }
        }
    }

    /* renamed from: e */
    private static boolean m13060e(C1648n c1648n) {
        boolean z = false;
        for (C1628a c1628a : c1648n.m12647y()) {
            C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                for (C1625p c1625p : c1581o.m12135a()) {
                    for (int i = 0; i < c1625p.m12590r(); i++) {
                        C1604i mo12426d = c1625p.mo12426d(i);
                        C1646l m12333r = mo12426d.m12333r();
                        if (m12333r != null && m12333r.mo12149b(EnumC1562a.REMOVE)) {
                            c1625p.mo12423a((AbstractC1598c) mo12426d);
                            C1740i.m13276a(c1648n, c1628a, m12333r);
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: f */
    private static boolean m13061f(C1648n c1648n) {
        C1646l l;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (C1605j c1605j : c1648n.m12614L()) {
            if (c1605j.m12349j() == 0 && (l = c1605j.m12347h().m12314l()) != null && l.m12587o() == EnumC1621l.PHI) {
                arrayList.add((C1625p) l);
                z = true;
            }
        }
        boolean z2 = z;
        for (C1628a c1628a : c1648n.m12647y()) {
            C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                Iterator<C1625p> it = c1581o.m12135a().iterator();
                while (it.hasNext()) {
                    if (m13051a(c1648n, c1628a, it.next())) {
                        it.remove();
                        z2 = true;
                    }
                }
            }
        }
        m13053a(c1648n, arrayList);
        return z2;
    }

    /* renamed from: a */
    private static boolean m13051a(C1648n c1648n, C1628a c1628a, C1625p c1625p) {
        boolean z = true;
        if (c1625p.m12590r() == 0) {
            for (C1604i c1604i : c1625p.m12588p().m12331p().m12348i()) {
                C1646l l = c1604i.m12314l();
                if (l != null && l.m12587o() == EnumC1621l.PHI) {
                    c1625p.mo12423a((AbstractC1598c) c1604i);
                }
            }
            C1740i.m13276a(c1648n, c1628a, c1625p);
            return true;
        }
        if (c1625p.m12590r() != 1 && !m13056b(c1625p)) {
            z = false;
        }
        if (z) {
            return m13052a(c1648n, c1628a, c1625p, c1625p.mo12426d(0));
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m13056b(C1625p c1625p) {
        C1605j c1605j = null;
        for (int i = 0; i < c1625p.m12590r(); i++) {
            C1604i mo12426d = c1625p.mo12426d(i);
            if (c1605j == null) {
                c1605j = mo12426d.m12331p();
            } else if (c1605j != mo12426d.m12331p()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m13053a(C1648n c1648n, List<C1625p> list) {
        C1605j m12331p;
        for (C1628a c1628a : c1648n.m12647y()) {
            C1581o c1581o = (C1581o) c1628a.mo12146b(C1566b.f10044r);
            if (c1581o != null) {
                List<C1625p> m12135a = c1581o.m12135a();
                for (C1625p c1625p : list) {
                    if (m12135a.remove(c1625p)) {
                        for (AbstractC1598c abstractC1598c : c1625p.m12589q()) {
                            if (abstractC1598c != null && (m12331p = ((C1604i) abstractC1598c).m12331p()) != null) {
                                m12331p.m12338a((C1625p) null);
                            }
                        }
                        C1740i.m13276a(c1648n, c1628a, c1625p);
                    }
                }
                if (m12135a.isEmpty()) {
                    c1628a.m12152d(C1566b.f10044r);
                }
            }
        }
        list.clear();
        return true;
    }

    /* renamed from: a */
    private static boolean m13052a(C1648n c1648n, C1628a c1628a, C1625p c1625p, C1604i c1604i) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        int m13264b = C1738g.m13264b(mo12446j, c1625p);
        if (m13264b == -1) {
            return false;
        }
        C1605j m12331p = c1625p.m12588p().m12331p();
        C1605j m12331p2 = c1604i.m12331p();
        if (m12331p2 != null) {
            m12331p2.m12342c(c1604i);
            m12331p2.m12338a((C1625p) null);
        }
        if (m13057b(c1648n, c1628a, c1625p)) {
            mo12446j.remove(m13264b);
            return true;
        }
        m12331p.m12338a((C1625p) null);
        C1646l c1646l = new C1646l(EnumC1621l.MOVE, 1);
        c1646l.mo12141a(EnumC1562a.SYNTHETIC);
        c1646l.m12581b(c1625p.m12588p());
        c1646l.m12584c((AbstractC1598c) c1604i);
        c1604i.m12331p().m12340b(c1604i);
        mo12446j.set(m13264b, c1646l);
        return true;
    }

    /* renamed from: b */
    private static boolean m13057b(C1648n c1648n, C1628a c1628a, C1625p c1625p) {
        C1646l m12333r;
        C1605j m12331p = c1625p.m12588p().m12331p();
        if (m12331p == null) {
            return false;
        }
        C1604i mo12426d = c1625p.mo12426d(0);
        if (mo12426d.m12331p() == null) {
            return false;
        }
        Iterator it = new ArrayList(m12331p.m12348i()).iterator();
        while (it.hasNext()) {
            C1604i c1604i = (C1604i) it.next();
            C1646l l = c1604i.m12314l();
            if (l == null || l == c1625p) {
                return false;
            }
            c1604i.m12331p().m12342c(c1604i);
            C1604i m12332q = mo12426d.m12332q();
            if (!l.mo12424a(c1604i, m12332q)) {
                return false;
            }
            m12332q.m12331p().m12340b(m12332q);
            m12332q.mo12319a_(c1604i.mo12320m_());
            m12332q.mo12293a(c1604i.m12359s());
        }
        if (c1628a.mo12145a(C1566b.f10033g) && (m12333r = mo12426d.m12333r()) != null) {
            m12333r.mo12141a(EnumC1562a.DONT_INLINE);
        }
        C1740i.m13278a(c1648n, c1625p);
        return true;
    }

    /* renamed from: a */
    private static void m13045a(C1604i c1604i) {
        if (c1604i != null) {
            m13054b(c1604i);
            Iterator<C1604i> it = c1604i.m12331p().m12348i().iterator();
            while (it.hasNext()) {
                m13054b(it.next());
            }
        }
    }

    /* renamed from: b */
    private static void m13054b(C1604i c1604i) {
        if (c1604i != null) {
            c1604i.mo12141a(EnumC1562a.THIS);
            c1604i.mo12319a_("this");
            C1646l l = c1604i.m12314l();
            if (l != null && l.m12587o() == EnumC1621l.MOVE && l.mo12426d(0) == c1604i) {
                C1604i m12588p = l.m12588p();
                if (m12588p.m12330o() != c1604i.m12330o() && !m12588p.m12331p().m12351l()) {
                    m13045a(m12588p);
                    l.mo12141a(EnumC1562a.SKIP);
                }
            }
        }
    }
}
