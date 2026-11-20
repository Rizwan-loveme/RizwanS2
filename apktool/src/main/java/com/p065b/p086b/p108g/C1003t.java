package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p108g.C0987d;
import com.p065b.p086b.p110h.InterfaceC1024o;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* compiled from: SsaConverter.java */
/* renamed from: com.b.b.g.t */
/* loaded from: classes.dex */
public class C1003t {
    /* renamed from: a */
    public static C1005v m8376a(C0938t c0938t, int i, boolean z) {
        C1005v m8394a = C1005v.m8394a(c0938t, i, z);
        m8377a(m8394a);
        m8379a(m8394a, C0992i.m8267a(m8394a), 0);
        new RunnableC1006w(m8394a).run();
        m8394a.m8403a();
        return m8394a;
    }

    /* renamed from: a */
    public static void m8378a(C1005v c1005v, int i) {
        m8379a(c1005v, C0992i.m8267a(c1005v), i);
        new RunnableC1006w(c1005v, i).run();
    }

    /* renamed from: a */
    private static void m8377a(C1005v c1005v) {
        m8382b(c1005v);
        m8383c(c1005v);
        m8384d(c1005v);
    }

    /* renamed from: b */
    private static void m8382b(C1005v c1005v) {
        ArrayList<C1002s> m8427j = c1005v.m8427j();
        for (int size = m8427j.size() - 1; size >= 0; size--) {
            C1002s c1002s = m8427j.get(size);
            if (m8380a(c1002s)) {
                c1002s.m8370p();
            }
        }
    }

    /* renamed from: a */
    private static boolean m8380a(C1002s c1002s) {
        return c1002s.m8362h().cardinality() > 1 && c1002s.m8363i().cardinality() > 1;
    }

    /* renamed from: c */
    private static void m8383c(C1005v c1005v) {
        ArrayList<C1002s> m8427j = c1005v.m8427j();
        for (int size = m8427j.size() - 1; size >= 0; size--) {
            C1002s c1002s = m8427j.get(size);
            if (!c1002s.m8372r() && c1002s.m8362h().cardinality() > 1 && c1002s.m8353c().get(0).mo8292j()) {
                BitSet bitSet = (BitSet) c1002s.m8362h().clone();
                for (int nextSetBit = bitSet.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet.nextSetBit(nextSetBit + 1)) {
                    m8427j.get(nextSetBit).m8348b(c1002s).m8353c().add(0, c1002s.m8353c().get(0).mo8296n());
                }
                c1002s.m8353c().remove(0);
            }
        }
    }

    /* renamed from: d */
    private static void m8384d(C1005v c1005v) {
        ArrayList<C1002s> m8427j = c1005v.m8427j();
        for (int size = m8427j.size() - 1; size >= 0; size--) {
            C1002s c1002s = m8427j.get(size);
            BitSet bitSet = (BitSet) c1002s.m8363i().clone();
            for (int nextSetBit = bitSet.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet.nextSetBit(nextSetBit + 1)) {
                C1002s c1002s2 = m8427j.get(nextSetBit);
                if (m8381a(c1002s, c1002s2)) {
                    c1002s.m8348b(c1002s2);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m8381a(C1002s c1002s, C1002s c1002s2) {
        AbstractC1004u abstractC1004u = c1002s.m8353c().get(r0.size() - 1);
        return (abstractC1004u.m8391o() != null || abstractC1004u.mo8285b().m8550f_() > 0) && c1002s2.m8362h().cardinality() > 1;
    }

    /* renamed from: a */
    private static void m8379a(C1005v c1005v, C0993j c0993j, int i) {
        ArrayList<C1002s> m8427j = c1005v.m8427j();
        int size = m8427j.size();
        int m8424g = c1005v.m8424g() - i;
        C0987d.a[] m8225a = new C0987d(c1005v).m8225a();
        BitSet[] bitSetArr = new BitSet[m8424g];
        BitSet[] bitSetArr2 = new BitSet[m8424g];
        for (int i2 = 0; i2 < m8424g; i2++) {
            bitSetArr[i2] = new BitSet(size);
            bitSetArr2[i2] = new BitSet(size);
        }
        int size2 = m8427j.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Iterator<AbstractC1004u> it = m8427j.get(i3).m8353c().iterator();
            while (it.hasNext()) {
                C0934p m8391o = it.next().m8391o();
                if (m8391o != null && m8391o.m7931g() - i >= 0) {
                    bitSetArr[m8391o.m7931g() - i].set(i3);
                }
            }
        }
        for (int i4 = 0; i4 < m8424g; i4++) {
            BitSet bitSet = (BitSet) bitSetArr[i4].clone();
            while (true) {
                int nextSetBit = bitSet.nextSetBit(0);
                if (nextSetBit >= 0) {
                    bitSet.clear(nextSetBit);
                    InterfaceC1024o mo8479b = m8225a[nextSetBit].f6338a.mo8479b();
                    while (mo8479b.mo8481a()) {
                        int mo8482b = mo8479b.mo8482b();
                        if (!bitSetArr2[i4].get(mo8482b)) {
                            bitSetArr2[i4].set(mo8482b);
                            int i5 = i4 + i;
                            C0934p m7956a = c0993j.m8270a(mo8482b).m7956a(i5);
                            if (m7956a == null) {
                                m8427j.get(mo8482b).m8340a(i5);
                            } else {
                                m8427j.get(mo8482b).m8343a(m7956a);
                            }
                            if (!bitSetArr[i4].get(mo8482b)) {
                                bitSet.set(mo8482b);
                            }
                        }
                    }
                }
            }
        }
    }
}
