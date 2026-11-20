package org.p210a.p211a.p212a.p213a;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.p210a.p211a.p212a.AbstractC1873u;
import org.p210a.p211a.p212a.C1872t;
import org.p210a.p211a.p212a.C1874v;
import org.p210a.p211a.p212a.C1878z;
import org.p210a.p211a.p212a.InterfaceC1822af;
import org.p210a.p211a.p212a.p214b.C1827a;
import org.p210a.p211a.p212a.p214b.C1829c;
import org.p210a.p211a.p212a.p215c.C1833c;
import org.p210a.p211a.p212a.p215c.C1840j;
import org.p210a.p211a.p212a.p215c.C1843m;

/* compiled from: ParserATNSimulator.java */
/* renamed from: org.a.a.a.a.al */
/* loaded from: classes.dex */
public class C1771al extends AbstractC1796f {

    /* renamed from: f */
    public static final boolean f10711f;

    /* renamed from: n */
    static final /* synthetic */ boolean f10712n;

    /* renamed from: g */
    protected final AbstractC1873u f10713g;

    /* renamed from: h */
    public final C1827a[] f10714h;

    /* renamed from: i */
    protected C1833c<AbstractC1776aq, AbstractC1776aq, AbstractC1776aq> f10715i;

    /* renamed from: j */
    protected InterfaceC1822af f10716j;

    /* renamed from: k */
    protected int f10717k;

    /* renamed from: l */
    protected C1874v f10718l;

    /* renamed from: m */
    protected C1827a f10719m;

    /* renamed from: o */
    private EnumC1778as f10720o;

    static {
        f10712n = !C1771al.class.desiredAssertionStatus();
        f10711f = Boolean.parseBoolean(m13502a("TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT"));
    }

    public C1771al(AbstractC1873u abstractC1873u, C1759a c1759a, C1827a[] c1827aArr, C1777ar c1777ar) {
        super(c1759a, c1777ar);
        this.f10720o = EnumC1778as.LL;
        this.f10713g = abstractC1873u;
        this.f10714h = c1827aArr;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1796f
    /* renamed from: a */
    public void mo13524a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public int m13505a(InterfaceC1822af interfaceC1822af, int i, C1874v c1874v) {
        C1829c c1829c;
        C1874v c1874v2;
        this.f10716j = interfaceC1822af;
        this.f10717k = interfaceC1822af.mo13717c();
        this.f10718l = c1874v;
        C1827a c1827a = this.f10714h[i];
        this.f10719m = c1827a;
        int e2 = interfaceC1822af.mo13720e();
        int i2 = this.f10717k;
        try {
            if (c1827a.m13706a()) {
                c1829c = c1827a.m13704a(this.f10713g.m13906cz());
            } else {
                c1829c = c1827a.f10855b;
            }
            if (c1829c == null) {
                c1874v2 = c1874v == null ? C1874v.f11015i : c1874v;
                C1793c m13517a = m13517a((AbstractC1797g) c1827a.f10857d, (C1878z) C1874v.f11015i, false);
                if (c1827a.m13706a()) {
                    c1827a.f10855b.f10863b = m13517a;
                    c1829c = m13519a(c1827a, new C1829c(m13514a(m13517a)));
                    c1827a.m13705a(this.f10713g.m13906cz(), c1829c);
                } else {
                    c1829c = m13519a(c1827a, new C1829c(m13517a));
                    c1827a.f10855b = c1829c;
                }
            } else {
                c1874v2 = c1874v;
            }
            return m13507a(c1827a, c1829c, interfaceC1822af, i2, c1874v2);
        } finally {
            this.f10715i = null;
            this.f10719m = null;
            interfaceC1822af.mo13718c(i2);
            interfaceC1822af.mo13716b(e2);
        }
    }

    /* renamed from: a */
    protected int m13507a(C1827a c1827a, C1829c c1829c, InterfaceC1822af interfaceC1822af, int i, C1874v c1874v) {
        int a2 = interfaceC1822af.mo13711a(1);
        while (true) {
            C1829c m13522a = m13522a(c1829c, a2);
            if (m13522a == null) {
                m13522a = m13520a(c1827a, c1829c, a2);
            }
            if (m13522a == f10793c) {
                C1872t m13523a = m13523a(interfaceC1822af, c1874v, c1829c.f10863b, i);
                interfaceC1822af.mo13718c(i);
                int m13504a = m13504a(c1829c.f10863b, c1874v);
                if (m13504a == 0) {
                    throw m13523a;
                }
                return m13504a;
            }
            if (m13522a.f10868g && this.f10720o != EnumC1778as.SLL) {
                BitSet bitSet = m13522a.f10863b.f10769e;
                if (m13522a.f10869h != null) {
                    int c2 = interfaceC1822af.mo13717c();
                    if (c2 != i) {
                        interfaceC1822af.mo13718c(i);
                    }
                    bitSet = m13508a(m13522a.f10869h, c1874v, true);
                    if (bitSet.cardinality() == 1) {
                        return bitSet.nextSetBit(0);
                    }
                    if (c2 != i) {
                        interfaceC1822af.mo13718c(c2);
                    }
                }
                C1793c m13517a = m13517a((AbstractC1797g) c1827a.f10857d, (C1878z) c1874v, true);
                m13528a(c1827a, bitSet, m13522a.f10863b, i, interfaceC1822af.mo13717c());
                return m13506a(c1827a, m13522a, m13517a, interfaceC1822af, i, c1874v);
            }
            if (m13522a.f10865d) {
                if (m13522a.f10869h == null) {
                    return m13522a.f10866e;
                }
                int c3 = interfaceC1822af.mo13717c();
                interfaceC1822af.mo13718c(i);
                BitSet m13508a = m13508a(m13522a.f10869h, c1874v, true);
                switch (m13508a.cardinality()) {
                    case 0:
                        throw m13523a(interfaceC1822af, c1874v, m13522a.f10863b, i);
                    case 1:
                        return m13508a.nextSetBit(0);
                    default:
                        m13529a(c1827a, m13522a, i, c3, false, m13508a, m13522a.f10863b);
                        return m13508a.nextSetBit(0);
                }
            }
            if (a2 != -1) {
                interfaceC1822af.mo13715b();
                a2 = interfaceC1822af.mo13711a(1);
                c1829c = m13522a;
            } else {
                c1829c = m13522a;
            }
        }
    }

    /* renamed from: a */
    protected C1829c m13522a(C1829c c1829c, int i) {
        C1829c[] c1829cArr = c1829c.f10864c;
        if (c1829cArr == null || i + 1 < 0 || i + 1 >= c1829cArr.length) {
            return null;
        }
        return c1829cArr[i + 1];
    }

    /* renamed from: a */
    protected C1829c m13520a(C1827a c1827a, C1829c c1829c, int i) {
        C1793c m13515a = m13515a(c1829c.f10863b, i, false);
        if (m13515a == null) {
            m13521a(c1827a, c1829c, i, f10793c);
            return f10793c;
        }
        C1829c c1829c2 = new C1829c(m13515a);
        int m13503e = m13503e(m13515a);
        if (m13503e != 0) {
            c1829c2.f10865d = true;
            c1829c2.f10863b.f10768d = m13503e;
            c1829c2.f10866e = m13503e;
        } else if (EnumC1778as.m13561a(this.f10720o, m13515a)) {
            c1829c2.f10863b.f10769e = m13538c(m13515a);
            c1829c2.f10868g = true;
            c1829c2.f10865d = true;
            c1829c2.f10866e = c1829c2.f10863b.f10769e.nextSetBit(0);
        }
        if (c1829c2.f10865d && c1829c2.f10863b.f10770f) {
            m13530a(c1829c2, this.f10794d.m13483a(c1827a.f10856c));
            if (c1829c2.f10869h != null) {
                c1829c2.f10866e = 0;
            }
        }
        return m13521a(c1827a, c1829c, i, c1829c2);
    }

    /* renamed from: a */
    protected void m13530a(C1829c c1829c, AbstractC1807q abstractC1807q) {
        int a2 = abstractC1807q.m13630a();
        BitSet m13539d = m13539d(c1829c.f10863b);
        AbstractC1783ax[] m13533a = m13533a(m13539d, c1829c.f10863b, a2);
        if (m13533a != null) {
            c1829c.f10869h = m13534a(m13539d, m13533a);
            c1829c.f10866e = 0;
        } else {
            c1829c.f10866e = m13539d.nextSetBit(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int m13506a(C1827a c1827a, C1829c c1829c, C1793c c1793c, InterfaceC1822af interfaceC1822af, int i, C1874v c1874v) {
        C1793c m13515a;
        int m13504a;
        boolean z = false;
        interfaceC1822af.mo13718c(i);
        int a2 = interfaceC1822af.mo13711a(1);
        while (true) {
            m13515a = m13515a(c1793c, a2, true);
            if (m13515a == null) {
                C1872t m13523a = m13523a(interfaceC1822af, c1874v, c1793c, i);
                interfaceC1822af.mo13718c(i);
                m13504a = m13504a(c1793c, c1874v);
                if (m13504a == 0) {
                    throw m13523a;
                }
            } else {
                Collection<BitSet> m13565c = EnumC1778as.m13565c(m13515a);
                m13515a.f10768d = m13503e(m13515a);
                if (m13515a.f10768d != 0) {
                    m13504a = m13515a.f10768d;
                    break;
                }
                if (this.f10720o != EnumC1778as.LL_EXACT_AMBIG_DETECTION) {
                    m13504a = EnumC1778as.m13560a(m13565c);
                    if (m13504a != 0) {
                        break;
                    }
                    if (a2 == -1) {
                        interfaceC1822af.mo13715b();
                        a2 = interfaceC1822af.mo13711a(1);
                        c1793c = m13515a;
                    } else {
                        c1793c = m13515a;
                    }
                } else {
                    if (EnumC1778as.m13563b(m13565c) && EnumC1778as.m13569e(m13565c)) {
                        z = true;
                        m13504a = EnumC1778as.m13572g(m13565c);
                        break;
                    }
                    if (a2 == -1) {
                    }
                }
            }
        }
        if (m13515a.f10768d != 0) {
            m13527a(c1827a, m13504a, m13515a, i, interfaceC1822af.mo13717c());
        } else {
            m13529a(c1827a, c1829c, i, interfaceC1822af.mo13717c(), z, m13515a.m13596b(), m13515a);
        }
        return m13504a;
    }

    /* renamed from: a */
    protected C1793c m13515a(C1793c c1793c, int i, boolean z) {
        if (this.f10715i == null) {
            this.f10715i = new C1833c<>();
        }
        C1793c c1793c2 = new C1793c(z);
        ArrayList arrayList = null;
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            if (next.f10755a instanceof C1781av) {
                if (!f10712n && !next.f10757c.mo13554a()) {
                    throw new AssertionError();
                }
                if (z || i == -1) {
                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                    arrayList2.add(next);
                    arrayList = arrayList2;
                }
            } else {
                int m13630a = next.f10755a.m13630a();
                for (int i2 = 0; i2 < m13630a; i2++) {
                    AbstractC1797g m13518a = m13518a(next.f10755a.m13631a(i2), i);
                    if (m13518a != null) {
                        c1793c2.m13595a(new C1786b(next, m13518a), this.f10715i);
                    }
                }
            }
        }
        C1793c c1793c3 = null;
        if (arrayList == null && i != -1) {
            if (c1793c2.size() == 1) {
                c1793c3 = c1793c2;
            } else if (m13503e(c1793c2) != 0) {
                c1793c3 = c1793c2;
            }
        }
        if (c1793c3 == null) {
            C1793c c1793c4 = new C1793c(z);
            HashSet hashSet = new HashSet();
            boolean z2 = i == -1;
            Iterator<C1786b> it2 = c1793c2.iterator();
            while (it2.hasNext()) {
                m13526a(it2.next(), c1793c4, (Set<C1786b>) hashSet, false, z, z2);
            }
            c1793c3 = c1793c4;
        }
        if (i == -1) {
            c1793c3 = m13516a(c1793c3, c1793c3 == c1793c2);
        }
        if (arrayList != null && (!z || !EnumC1778as.m13562a(c1793c3))) {
            if (!f10712n && arrayList.isEmpty()) {
                throw new AssertionError();
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                c1793c3.m13595a((C1786b) it3.next(), this.f10715i);
            }
        }
        if (c1793c3.isEmpty()) {
            return null;
        }
        return c1793c3;
    }

    /* renamed from: a */
    protected C1793c m13516a(C1793c c1793c, boolean z) {
        if (!EnumC1778as.m13564b(c1793c)) {
            C1793c c1793c2 = new C1793c(c1793c.f10772h);
            Iterator<C1786b> it = c1793c.iterator();
            while (it.hasNext()) {
                C1786b next = it.next();
                if (next.f10755a instanceof C1781av) {
                    c1793c2.m13595a(next, this.f10715i);
                } else if (z && next.f10755a.m13636c() && this.f10794d.m13485a(next.f10755a).m13766c(-2)) {
                    c1793c2.m13595a(new C1786b(next, this.f10794d.f10693d[next.f10755a.f10799d]), this.f10715i);
                }
            }
            return c1793c2;
        }
        return c1793c;
    }

    /* renamed from: a */
    protected C1793c m13517a(AbstractC1797g abstractC1797g, C1878z c1878z, boolean z) {
        AbstractC1776aq m13545a = AbstractC1776aq.m13545a(this.f10794d, c1878z);
        C1793c c1793c = new C1793c(z);
        for (int i = 0; i < abstractC1797g.m13630a(); i++) {
            m13526a(new C1786b(abstractC1797g.m13631a(i).f10764f, i + 1, m13545a), c1793c, (Set<C1786b>) new HashSet(), true, z, false);
        }
        return c1793c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    protected C1793c m13514a(C1793c c1793c) {
        AbstractC1776aq abstractC1776aq;
        AbstractC1783ax mo13583b;
        HashMap hashMap = new HashMap();
        C1793c c1793c2 = new C1793c(c1793c.f10772h);
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            if (next.f10756b == 1 && (mo13583b = next.f10759e.mo13583b(this.f10713g, this.f10718l)) != null) {
                hashMap.put(Integer.valueOf(next.f10755a.f10798c), next.f10757c);
                if (mo13583b != next.f10759e) {
                    c1793c2.m13595a(new C1786b(next, mo13583b), this.f10715i);
                } else {
                    c1793c2.m13595a(next, this.f10715i);
                }
            }
        }
        Iterator<C1786b> it2 = c1793c.iterator();
        while (it2.hasNext()) {
            C1786b next2 = it2.next();
            if (next2.f10756b != 1 && (next2.m13590b() || (abstractC1776aq = (AbstractC1776aq) hashMap.get(Integer.valueOf(next2.f10755a.f10798c))) == null || !abstractC1776aq.equals(next2.f10757c))) {
                c1793c2.m13595a(next2, this.f10715i);
            }
        }
        return c1793c2;
    }

    /* renamed from: a */
    protected AbstractC1797g m13518a(AbstractC1791be abstractC1791be, int i) {
        if (abstractC1791be.mo13501a(i, 0, this.f10794d.f10696g)) {
            return abstractC1791be.f10764f;
        }
        return null;
    }

    /* renamed from: a */
    protected AbstractC1783ax[] m13533a(BitSet bitSet, C1793c c1793c, int i) {
        AbstractC1783ax[] abstractC1783axArr = new AbstractC1783ax[i + 1];
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            if (bitSet.get(next.f10756b)) {
                abstractC1783axArr[next.f10756b] = AbstractC1783ax.m13581b(abstractC1783axArr[next.f10756b], next.f10759e);
            }
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i; i3++) {
            if (abstractC1783axArr[i3] == null) {
                abstractC1783axArr[i3] = AbstractC1783ax.f10744a;
            } else if (abstractC1783axArr[i3] != AbstractC1783ax.f10744a) {
                i2++;
            }
        }
        if (i2 == 0) {
            return null;
        }
        return abstractC1783axArr;
    }

    /* renamed from: a */
    protected C1829c.a[] m13534a(BitSet bitSet, AbstractC1783ax[] abstractC1783axArr) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 1; i < abstractC1783axArr.length; i++) {
            AbstractC1783ax abstractC1783ax = abstractC1783axArr[i];
            if (!f10712n && abstractC1783ax == null) {
                throw new AssertionError();
            }
            if (bitSet != null && bitSet.get(i)) {
                arrayList.add(new C1829c.a(abstractC1783ax, i));
            }
            if (abstractC1783ax != AbstractC1783ax.f10744a) {
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return (C1829c.a[]) arrayList.toArray(new C1829c.a[arrayList.size()]);
    }

    /* renamed from: a */
    protected int m13504a(C1793c c1793c, C1874v c1874v) {
        int m13535b;
        C1843m<C1793c, C1793c> m13536b = m13536b(c1793c, c1874v);
        C1793c c1793c2 = m13536b.f10912a;
        C1793c c1793c3 = m13536b.f10913b;
        int m13535b2 = m13535b(c1793c2);
        if (m13535b2 == 0) {
            if (c1793c3.size() <= 0 || (m13535b = m13535b(c1793c3)) == 0) {
                return 0;
            }
            return m13535b;
        }
        return m13535b2;
    }

    /* renamed from: b */
    protected int m13535b(C1793c c1793c) {
        C1840j c1840j = new C1840j(new int[0]);
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            if (next.m13586a() > 0 || ((next.f10755a instanceof C1781av) && next.f10757c.m13557c())) {
                c1840j.m13761b(next.f10756b);
            }
        }
        if (c1840j.m13767d() == 0) {
            return 0;
        }
        return c1840j.m13764c();
    }

    /* renamed from: b */
    protected C1843m<C1793c, C1793c> m13536b(C1793c c1793c, C1874v c1874v) {
        C1793c c1793c2 = new C1793c(c1793c.f10772h);
        C1793c c1793c3 = new C1793c(c1793c.f10772h);
        Iterator<C1786b> it = c1793c.iterator();
        while (it.hasNext()) {
            C1786b next = it.next();
            if (next.f10759e != AbstractC1783ax.f10744a) {
                if (m13531a(next.f10759e, c1874v, next.f10756b, c1793c.f10772h)) {
                    c1793c2.add(next);
                } else {
                    c1793c3.add(next);
                }
            } else {
                c1793c2.add(next);
            }
        }
        return new C1843m<>(c1793c2, c1793c3);
    }

    /* renamed from: a */
    protected BitSet m13508a(C1829c.a[] aVarArr, C1874v c1874v, boolean z) {
        BitSet bitSet = new BitSet();
        for (C1829c.a aVar : aVarArr) {
            if (aVar.f10870a == AbstractC1783ax.f10744a) {
                bitSet.set(aVar.f10871b);
                if (!z) {
                    break;
                }
            } else {
                if (m13531a(aVar.f10870a, c1874v, aVar.f10871b, false)) {
                    bitSet.set(aVar.f10871b);
                    if (!z) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return bitSet;
    }

    /* renamed from: a */
    protected boolean m13531a(AbstractC1783ax abstractC1783ax, C1874v c1874v, int i, boolean z) {
        return abstractC1783ax.mo13582a(this.f10713g, c1874v);
    }

    /* renamed from: a */
    protected void m13526a(C1786b c1786b, C1793c c1793c, Set<C1786b> set, boolean z, boolean z2, boolean z3) {
        m13525a(c1786b, c1793c, set, z, z2, 0, z3);
        if (!f10712n && z2 && c1793c.f10771g) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    protected void m13525a(C1786b c1786b, C1793c c1793c, Set<C1786b> set, boolean z, boolean z2, int i, boolean z3) {
        if (c1786b.f10755a instanceof C1781av) {
            if (!c1786b.f10757c.mo13554a()) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < c1786b.f10757c.mo13555b()) {
                        if (c1786b.f10757c.mo13556b(i3) == Integer.MAX_VALUE) {
                            if (z2) {
                                c1793c.m13595a(new C1786b(c1786b, c1786b.f10755a, AbstractC1776aq.f10726d), this.f10715i);
                            } else {
                                m13537b(c1786b, c1793c, set, z, z2, i, z3);
                            }
                        } else {
                            C1786b c1786b2 = new C1786b(this.f10794d.f10690a.get(c1786b.f10757c.mo13556b(i3)), c1786b.f10756b, c1786b.f10757c.mo13553a(i3), c1786b.f10759e);
                            c1786b2.f10758d = c1786b.f10758d;
                            if (!f10712n && i <= Integer.MIN_VALUE) {
                                throw new AssertionError();
                            }
                            m13525a(c1786b2, c1793c, set, z, z2, i - 1, z3);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            } else if (z2) {
                c1793c.m13595a(c1786b, this.f10715i);
                return;
            }
        }
        m13537b(c1786b, c1793c, set, z, z2, i, z3);
    }

    /* renamed from: b */
    protected void m13537b(C1786b c1786b, C1793c c1793c, Set<C1786b> set, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        AbstractC1797g abstractC1797g = c1786b.f10755a;
        if (!abstractC1797g.m13636c()) {
            c1793c.m13595a(c1786b, this.f10715i);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < abstractC1797g.m13630a()) {
                if (i4 != 0 || !m13532a(c1786b)) {
                    AbstractC1791be m13631a = abstractC1797g.m13631a(i4);
                    boolean z4 = !(m13631a instanceof C1800j) && z;
                    C1786b m13512a = m13512a(c1786b, m13631a, z4, i == 0, z2, z3);
                    if (m13512a == null) {
                        continue;
                    } else if (c1786b.f10755a instanceof C1781av) {
                        if (!f10712n && z2) {
                            throw new AssertionError();
                        }
                        if (this.f10719m != null && this.f10719m.m13706a() && ((C1809s) m13631a).m13637d() == this.f10719m.f10857d.f10799d) {
                            m13512a.m13588a(true);
                        }
                        m13512a.f10758d++;
                        if (set.add(m13512a)) {
                            c1793c.f10771g = true;
                            if (!f10712n && i <= Integer.MIN_VALUE) {
                                throw new AssertionError();
                            }
                            i2 = i - 1;
                            m13525a(m13512a, c1793c, set, z4, z2, i2, z3);
                        } else {
                            continue;
                        }
                    } else if (m13631a.mo13540b() || set.add(m13512a)) {
                        i2 = (!(m13631a instanceof C1782aw) || i < 0) ? i : i + 1;
                        m13525a(m13512a, c1793c, set, z4, z2, i2, z3);
                    }
                }
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    protected boolean m13532a(C1786b c1786b) {
        if (f10711f) {
            return false;
        }
        AbstractC1797g abstractC1797g = c1786b.f10755a;
        if (abstractC1797g.mo13499b() != 10 || !((C1788bb) abstractC1797g).f10761k || c1786b.f10757c.mo13554a() || c1786b.f10757c.m13557c()) {
            return false;
        }
        int mo13555b = c1786b.f10757c.mo13555b();
        for (int i = 0; i < mo13555b; i++) {
            if (this.f10794d.f10690a.get(c1786b.f10757c.mo13556b(i)).f10799d != abstractC1797g.f10799d) {
                return false;
            }
        }
        C1805o c1805o = (C1805o) this.f10794d.f10690a.get(((AbstractC1806p) abstractC1797g.m13631a(0).f10764f).f10814h.f10798c);
        for (int i2 = 0; i2 < mo13555b; i2++) {
            AbstractC1797g abstractC1797g2 = this.f10794d.f10690a.get(c1786b.f10757c.mo13556b(i2));
            if (abstractC1797g2.m13630a() != 1 || !abstractC1797g2.m13631a(0).mo13540b()) {
                return false;
            }
            AbstractC1797g abstractC1797g3 = abstractC1797g2.m13631a(0).f10764f;
            if ((abstractC1797g2.mo13499b() != 8 || abstractC1797g3 != abstractC1797g) && abstractC1797g2 != c1805o && abstractC1797g3 != c1805o && (abstractC1797g3.mo13499b() != 8 || abstractC1797g3.m13630a() != 1 || !abstractC1797g3.m13631a(0).mo13540b() || abstractC1797g3.m13631a(0).f10764f != abstractC1797g)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected C1786b m13512a(C1786b c1786b, AbstractC1791be abstractC1791be, boolean z, boolean z2, boolean z3, boolean z4) {
        switch (abstractC1791be.mo13500a()) {
            case 1:
                return new C1786b(c1786b, abstractC1791be.f10764f);
            case 2:
            case 5:
            case 7:
                if (z4 && abstractC1791be.mo13501a(-1, 0, 1)) {
                    return new C1786b(c1786b, abstractC1791be.f10764f);
                }
                return null;
            case 3:
                return m13511a(c1786b, (C1782aw) abstractC1791be);
            case 4:
                return m13510a(c1786b, (C1775ap) abstractC1791be, z, z2, z3);
            case 6:
                return m13513a(c1786b, (C1800j) abstractC1791be);
            case 8:
            case 9:
            default:
                return null;
            case 10:
                return m13509a(c1786b, (C1774ao) abstractC1791be, z, z2, z3);
        }
    }

    /* renamed from: a */
    protected C1786b m13513a(C1786b c1786b, C1800j c1800j) {
        return new C1786b(c1786b, c1800j.f10764f);
    }

    /* renamed from: a */
    public C1786b m13509a(C1786b c1786b, C1774ao c1774ao, boolean z, boolean z2, boolean z3) {
        if (z && z2) {
            if (z3) {
                int c2 = this.f10716j.mo13717c();
                this.f10716j.mo13718c(this.f10717k);
                boolean m13531a = m13531a(c1774ao.m13541d(), this.f10718l, c1786b.f10756b, z3);
                this.f10716j.mo13718c(c2);
                if (!m13531a) {
                    return null;
                }
                return new C1786b(c1786b, c1774ao.f10764f);
            }
            return new C1786b(c1786b, c1774ao.f10764f, AbstractC1783ax.m13579a(c1786b.f10759e, c1774ao.m13541d()));
        }
        return new C1786b(c1786b, c1774ao.f10764f);
    }

    /* renamed from: a */
    protected C1786b m13510a(C1786b c1786b, C1775ap c1775ap, boolean z, boolean z2, boolean z3) {
        if (z && (!c1775ap.f10725c || (c1775ap.f10725c && z2))) {
            if (z3) {
                int c2 = this.f10716j.mo13717c();
                this.f10716j.mo13718c(this.f10717k);
                boolean m13531a = m13531a(c1775ap.m13542d(), this.f10718l, c1786b.f10756b, z3);
                this.f10716j.mo13718c(c2);
                if (!m13531a) {
                    return null;
                }
                return new C1786b(c1786b, c1775ap.f10764f);
            }
            return new C1786b(c1786b, c1775ap.f10764f, AbstractC1783ax.m13579a(c1786b.f10759e, c1775ap.m13542d()));
        }
        return new C1786b(c1786b, c1775ap.f10764f);
    }

    /* renamed from: a */
    protected C1786b m13511a(C1786b c1786b, C1782aw c1782aw) {
        return new C1786b(c1786b, c1782aw.f10764f, C1785az.m13585b(c1786b.f10757c, c1782aw.f10743c.f10798c));
    }

    /* renamed from: c */
    protected BitSet m13538c(C1793c c1793c) {
        return EnumC1778as.m13571f(EnumC1778as.m13565c(c1793c));
    }

    /* renamed from: d */
    protected BitSet m13539d(C1793c c1793c) {
        if (c1793c.f10768d != 0) {
            BitSet bitSet = new BitSet();
            bitSet.set(c1793c.f10768d);
            return bitSet;
        }
        return c1793c.f10769e;
    }

    /* renamed from: a */
    protected C1872t m13523a(InterfaceC1822af interfaceC1822af, C1874v c1874v, C1793c c1793c, int i) {
        return new C1872t(this.f10713g, interfaceC1822af, interfaceC1822af.mo13688f(i), interfaceC1822af.mo13689h(1), c1793c, c1874v);
    }

    /* renamed from: e */
    protected static int m13503e(C1793c c1793c) {
        Iterator<C1786b> it = c1793c.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1786b next = it.next();
            if (i == 0) {
                i = next.f10756b;
            } else if (next.f10756b != i) {
                return 0;
            }
        }
        return i;
    }

    /* renamed from: a */
    protected C1829c m13521a(C1827a c1827a, C1829c c1829c, int i, C1829c c1829c2) {
        if (c1829c2 == null) {
            return null;
        }
        C1829c m13519a = m13519a(c1827a, c1829c2);
        if (c1829c != null && i >= -1 && i <= this.f10794d.f10696g) {
            synchronized (c1829c) {
                if (c1829c.f10864c == null) {
                    c1829c.f10864c = new C1829c[this.f10794d.f10696g + 1 + 1];
                }
                c1829c.f10864c[i + 1] = m13519a;
            }
            return m13519a;
        }
        return m13519a;
    }

    /* renamed from: a */
    protected C1829c m13519a(C1827a c1827a, C1829c c1829c) {
        if (c1829c != f10793c) {
            synchronized (c1827a.f10854a) {
                C1829c c1829c2 = c1827a.f10854a.get(c1829c);
                if (c1829c2 != null) {
                    return c1829c2;
                }
                c1829c.f10862a = c1827a.f10854a.size();
                if (!c1829c.f10863b.m13597c()) {
                    c1829c.f10863b.m13592a(this);
                    c1829c.f10863b.m13593a(true);
                }
                c1827a.f10854a.put(c1829c, c1829c);
                return c1829c;
            }
        }
        return c1829c;
    }

    /* renamed from: a */
    protected void m13528a(C1827a c1827a, BitSet bitSet, C1793c c1793c, int i, int i2) {
        if (this.f10713g != null) {
            this.f10713g.m13929cF().mo13478a(this.f10713g, c1827a, i, i2, bitSet, c1793c);
        }
    }

    /* renamed from: a */
    protected void m13527a(C1827a c1827a, int i, C1793c c1793c, int i2, int i3) {
        if (this.f10713g != null) {
            this.f10713g.m13929cF().mo13477a(this.f10713g, c1827a, i2, i3, i, c1793c);
        }
    }

    /* renamed from: a */
    protected void m13529a(C1827a c1827a, C1829c c1829c, int i, int i2, boolean z, BitSet bitSet, C1793c c1793c) {
        if (this.f10713g != null) {
            this.f10713g.m13929cF().mo13479a(this.f10713g, c1827a, i, i2, z, bitSet, c1793c);
        }
    }

    /* renamed from: a */
    public static String m13502a(String str) {
        try {
            return System.getenv(str);
        } catch (SecurityException e2) {
            return null;
        }
    }
}
