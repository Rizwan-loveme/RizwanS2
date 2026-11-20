package org.p210a.p211a.p212a.p213a;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import org.p210a.p211a.p212a.C1878z;
import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: LL1Analyzer.java */
/* renamed from: org.a.a.a.a.t */
/* loaded from: classes.dex */
public class C1810t {

    /* renamed from: a */
    public final C1759a f10818a;

    public C1810t(C1759a c1759a) {
        this.f10818a = c1759a;
    }

    /* renamed from: a */
    public C1840j m13639a(AbstractC1797g abstractC1797g, C1878z c1878z) {
        return m13638a(abstractC1797g, null, c1878z);
    }

    /* renamed from: a */
    public C1840j m13638a(AbstractC1797g abstractC1797g, AbstractC1797g abstractC1797g2, C1878z c1878z) {
        C1840j c1840j = new C1840j(new int[0]);
        m13640a(abstractC1797g, abstractC1797g2, c1878z != null ? AbstractC1776aq.m13545a(abstractC1797g.f10797b, c1878z) : null, c1840j, new HashSet(), new BitSet(), true, true);
        return c1840j;
    }

    /* renamed from: a */
    protected void m13640a(AbstractC1797g abstractC1797g, AbstractC1797g abstractC1797g2, AbstractC1776aq abstractC1776aq, C1840j c1840j, Set<C1786b> set, BitSet bitSet, boolean z, boolean z2) {
        if (set.add(new C1786b(abstractC1797g, 0, abstractC1776aq))) {
            if (abstractC1797g == abstractC1797g2) {
                if (abstractC1776aq == null) {
                    c1840j.m13761b(-2);
                    return;
                } else if (abstractC1776aq.mo13554a() && z2) {
                    c1840j.m13761b(-1);
                    return;
                }
            }
            if (abstractC1797g instanceof C1781av) {
                if (abstractC1776aq == null) {
                    c1840j.m13761b(-2);
                    return;
                }
                if (abstractC1776aq.mo13554a() && z2) {
                    c1840j.m13761b(-1);
                    return;
                }
                if (abstractC1776aq != AbstractC1776aq.f10726d) {
                    boolean z3 = bitSet.get(abstractC1797g.f10799d);
                    try {
                        bitSet.clear(abstractC1797g.f10799d);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= abstractC1776aq.mo13555b()) {
                                break;
                            }
                            m13640a(this.f10818a.f10690a.get(abstractC1776aq.mo13556b(i2)), abstractC1797g2, abstractC1776aq.mo13553a(i2), c1840j, set, bitSet, z, z2);
                            i = i2 + 1;
                        }
                        if (z3) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (z3) {
                            bitSet.set(abstractC1797g.f10799d);
                        }
                    }
                }
            }
            int m13630a = abstractC1797g.m13630a();
            for (int i3 = 0; i3 < m13630a; i3++) {
                AbstractC1791be m13631a = abstractC1797g.m13631a(i3);
                if (m13631a.getClass() == C1782aw.class) {
                    if (bitSet.get(((C1782aw) m13631a).f10764f.f10799d)) {
                        continue;
                    } else {
                        C1785az m13585b = C1785az.m13585b(abstractC1776aq, ((C1782aw) m13631a).f10743c.f10798c);
                        try {
                            bitSet.set(((C1782aw) m13631a).f10764f.f10799d);
                            m13640a(m13631a.f10764f, abstractC1797g2, m13585b, c1840j, set, bitSet, z, z2);
                        } finally {
                            bitSet.clear(((C1782aw) m13631a).f10764f.f10799d);
                        }
                    }
                } else if (m13631a instanceof AbstractC1799i) {
                    if (z) {
                        m13640a(m13631a.f10764f, abstractC1797g2, abstractC1776aq, c1840j, set, bitSet, z, z2);
                    } else {
                        c1840j.m13761b(0);
                    }
                } else if (m13631a.mo13540b()) {
                    m13640a(m13631a.f10764f, abstractC1797g2, abstractC1776aq, c1840j, set, bitSet, z, z2);
                } else if (m13631a.getClass() == C1792bf.class) {
                    c1840j.m13758a(C1840j.m13753a(1, this.f10818a.f10696g));
                } else {
                    C1840j mo13577c = m13631a.mo13577c();
                    if (mo13577c != null) {
                        if (m13631a instanceof C1769aj) {
                            mo13577c = mo13577c.m13760b(C1840j.m13753a(1, this.f10818a.f10696g));
                        }
                        c1840j.m13758a(mo13577c);
                    }
                }
            }
        }
    }
}
