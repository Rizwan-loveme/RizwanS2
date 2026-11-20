package jadx.core.p183c.p197g;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;
import jadx.core.p183c.p188c.p189a.C1599d;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p188c.p189a.C1605j;
import jadx.core.p183c.p188c.p190b.C1610a;
import jadx.core.p183c.p188c.p190b.C1611b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1730c;
import jadx.core.p203d.C1738g;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* compiled from: CodeShrinker.java */
/* renamed from: jadx.core.c.g.c */
/* loaded from: classes.dex */
public class C1695c extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        m13016b(c1648n);
    }

    /* renamed from: b */
    public static void m13016b(C1648n c1648n) {
        if (!c1648n.m12641p() && !c1648n.mo12149b(EnumC1562a.DONT_SHRINK)) {
            for (C1628a c1628a : c1648n.m12647y()) {
                m13013a(c1648n, c1628a);
                m13012a(c1628a);
            }
        }
    }

    /* compiled from: CodeShrinker.java */
    /* renamed from: jadx.core.c.g.c$a */
    private static final class a {

        /* renamed from: a */
        private final C1646l f10530a;

        /* renamed from: b */
        private final List<a> f10531b;

        /* renamed from: c */
        private final List<C1604i> f10532c;

        /* renamed from: d */
        private final int f10533d;

        /* renamed from: e */
        private int f10534e;

        /* renamed from: f */
        private a f10535f;

        public a(C1646l c1646l, List<a> list, int i) {
            this.f10530a = c1646l;
            this.f10531b = list;
            this.f10533d = i;
            this.f10534e = i;
            this.f10532c = m13017a(c1646l);
        }

        /* renamed from: a */
        public static List<C1604i> m13017a(C1646l c1646l) {
            LinkedList linkedList = new LinkedList();
            m13019a(c1646l, linkedList);
            return linkedList;
        }

        /* renamed from: a */
        private static void m13019a(C1646l c1646l, List<C1604i> list) {
            if (c1646l.m12587o() == EnumC1621l.CONSTRUCTOR) {
                list.add(((C1610a) c1646l).m12364h());
            } else if (c1646l.m12587o() == EnumC1621l.TERNARY) {
                list.addAll(((C1611b) c1646l).m12373f().m12693h());
            }
            for (AbstractC1598c abstractC1598c : c1646l.m12589q()) {
                if (abstractC1598c.mo12298h()) {
                    list.add((C1604i) abstractC1598c);
                }
            }
            for (AbstractC1598c abstractC1598c2 : c1646l.m12589q()) {
                if (abstractC1598c2.mo12312j()) {
                    m13019a(((C1599d) abstractC1598c2).m12316d(), list);
                }
            }
        }

        /* renamed from: a */
        public C1646l m13024a() {
            return this.f10530a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public List<C1604i> m13023c() {
            return this.f10532c;
        }

        /* renamed from: a */
        public b m13025a(int i, C1604i c1604i) {
            if (i >= this.f10534e || !m13020a(i, this.f10534e)) {
                return null;
            }
            this.f10534e = i;
            return m13027b(i, c1604i);
        }

        /* renamed from: a */
        private boolean m13020a(int i, int i2) {
            BitSet bitSet;
            a aVar = this.f10531b.get(i);
            List<C1604i> m13023c = aVar.m13023c();
            int i3 = i + 1;
            if (i3 == i2) {
                return true;
            }
            if (i3 > i2) {
                throw new C1729f("Invalid inline insn positions: " + i3 + " - " + i2);
            }
            if (m13023c.isEmpty()) {
                if (aVar.f10530a.m12592t()) {
                    return true;
                }
                bitSet = C1730c.f10580a;
            } else {
                bitSet = new BitSet();
                Iterator<C1604i> it = m13023c.iterator();
                while (it.hasNext()) {
                    bitSet.set(it.next().m12330o());
                }
            }
            while (i3 < i2) {
                a aVar2 = this.f10531b.get(i3);
                if (aVar2.m13026b() != this) {
                    C1646l c1646l = aVar2.f10530a;
                    if (!c1646l.m12593u() || m13022b(c1646l, bitSet)) {
                        return false;
                    }
                }
                i3++;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static boolean m13022b(C1646l c1646l, BitSet bitSet) {
            C1604i m12588p;
            if (bitSet.isEmpty() || (m12588p = c1646l.m12588p()) == null || m12588p.mo12297g()) {
                return false;
            }
            return bitSet.get(m12588p.m12330o());
        }

        /* renamed from: b */
        public b m13027b(int i, C1604i c1604i) {
            a aVar = this.f10531b.get(i);
            aVar.f10535f = this;
            return new b(aVar.f10530a, c1604i);
        }

        /* renamed from: b */
        public a m13026b() {
            a m13026b;
            if (this.f10535f != null && (m13026b = this.f10535f.m13026b()) != null) {
                this.f10535f = m13026b;
            }
            return this.f10535f;
        }

        public String toString() {
            return "ArgsInfo: |" + this.f10534e + " ->" + (this.f10535f == null ? "-" : Integer.valueOf(this.f10535f.f10533d)) + " " + this.f10532c + " : " + this.f10530a;
        }
    }

    /* compiled from: CodeShrinker.java */
    /* renamed from: jadx.core.c.g.c$b */
    private static final class b {

        /* renamed from: a */
        private final C1646l f10537a;

        /* renamed from: b */
        private final C1604i f10538b;

        public b(C1646l c1646l, C1604i c1604i) {
            this.f10537a = c1646l;
            this.f10538b = c1604i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public C1646l m13033a() {
            return this.f10537a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public C1604i m13034b() {
            return this.f10538b;
        }

        public String toString() {
            return "WrapInfo: " + this.f10538b + " -> " + this.f10537a;
        }
    }

    /* renamed from: a */
    private static void m13013a(C1648n c1648n, C1628a c1628a) {
        C1646l l;
        if (!c1628a.mo12446j().isEmpty()) {
            C1738g c1738g = new C1738g(c1628a.mo12446j());
            int m13265a = c1738g.m13265a();
            ArrayList<a> arrayList = new ArrayList(m13265a);
            for (int i = 0; i < m13265a; i++) {
                arrayList.add(new a(c1738g.m13267a(i), arrayList, i));
            }
            ArrayList<b> arrayList2 = new ArrayList();
            for (a aVar : arrayList) {
                List m13023c = aVar.m13023c();
                if (!m13023c.isEmpty()) {
                    ListIterator listIterator = m13023c.listIterator(m13023c.size());
                    while (listIterator.hasPrevious()) {
                        C1604i c1604i = (C1604i) listIterator.previous();
                        C1605j m12331p = c1604i.m12331p();
                        if (m12331p != null && m12331p.m12352m() == 1 && !m12331p.mo12149b(EnumC1562a.DONT_INLINE) && (l = m12331p.m12347h().m12314l()) != null && !l.mo12149b(EnumC1562a.DONT_INLINE)) {
                            int m13266a = c1738g.m13266a(l);
                            if (m13266a != -1) {
                                b m13025a = aVar.m13025a(m13266a, c1604i);
                                if (m13025a != null) {
                                    arrayList2.add(m13025a);
                                }
                            } else {
                                C1628a m13192a = C1721a.m13192a(c1648n, l);
                                if (m13192a != null && l != c1604i.m12314l() && m13015a(l, m13192a, c1628a, aVar.m13024a())) {
                                    m13014a(c1604i, l, m13192a);
                                }
                            }
                        }
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                for (b bVar : arrayList2) {
                    m13014a(bVar.m13034b(), bVar.m13033a(), c1628a);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m13014a(C1604i c1604i, C1646l c1646l, C1628a c1628a) {
        C1646l l = c1604i.m12314l();
        if (l != null && l.m12587o() == EnumC1621l.RETURN) {
            l.m12118a(c1646l.m12122d());
        }
        boolean z = c1604i.m12310b(c1646l) != null;
        if (z) {
            C1738g.m13262a(c1628a, c1646l);
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m13015a(C1646l c1646l, C1628a c1628a, C1628a c1628a2, C1646l c1646l2) {
        if (!C1721a.m13213c(c1628a, c1628a2)) {
            return false;
        }
        List<C1604i> m13017a = a.m13017a(c1646l);
        BitSet bitSet = new BitSet();
        Iterator<C1604i> it = m13017a.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().m12330o());
        }
        boolean z = false;
        for (C1646l c1646l3 : c1628a.mo12446j()) {
            if (z && (!c1646l3.m12593u() || a.m13022b(c1646l3, bitSet))) {
                return false;
            }
            if (c1646l3 == c1646l) {
                z = true;
            }
        }
        Set<C1628a> m13209b = C1721a.m13209b(c1628a, c1628a2);
        m13209b.remove(c1628a);
        m13209b.remove(c1628a2);
        Iterator<C1628a> it2 = m13209b.iterator();
        while (it2.hasNext()) {
            for (C1646l c1646l4 : it2.next().mo12446j()) {
                if (!c1646l4.m12593u() || a.m13022b(c1646l4, bitSet)) {
                    return false;
                }
            }
        }
        for (C1646l c1646l5 : c1628a2.mo12446j()) {
            if (c1646l5 == c1646l2) {
                return true;
            }
            if (!c1646l5.m12593u() || a.m13022b(c1646l5, bitSet)) {
                return false;
            }
        }
        throw new C1729f("Can't process instruction move : " + c1628a);
    }

    /* renamed from: a */
    private static void m13012a(C1628a c1628a) {
        List<C1646l> mo12446j = c1628a.mo12446j();
        int size = mo12446j.size();
        for (int i = 0; i < size; i++) {
            C1646l c1646l = mo12446j.get(i);
            if (c1646l.m12587o() == EnumC1621l.MOVE) {
                AbstractC1598c mo12426d = c1646l.mo12426d(0);
                if (mo12426d.mo12312j()) {
                    C1646l m12316d = ((C1599d) mo12426d).m12316d();
                    m12316d.m12581b(c1646l.m12588p());
                    m12316d.m12143a((AbstractC1584d) c1646l);
                    m12316d.m12586e(c1646l.m12591s());
                    m12316d.mo12151c(EnumC1562a.WRAPPED);
                    c1628a.mo12446j().set(i, m12316d);
                }
            }
        }
    }
}
