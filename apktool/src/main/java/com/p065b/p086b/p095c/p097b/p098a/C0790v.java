package com.p065b.p086b.p095c.p097b.p098a;

import com.p065b.p086b.p095c.p097b.AbstractC0807i;
import com.p065b.p086b.p095c.p097b.AbstractC0813o;
import com.p065b.p086b.p095c.p097b.C0805g;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: Form35c.java */
/* renamed from: com.b.b.c.b.a.v */
/* loaded from: classes.dex */
public final class C0790v extends AbstractC0813o {

    /* renamed from: b */
    public static final AbstractC0813o f4760b = new C0790v();

    private C0790v() {
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public String mo6970a(AbstractC0807i abstractC0807i) {
        return m7068a(m6977e(abstractC0807i.m7043j())) + ", " + m7093f(abstractC0807i);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public String mo6973b(AbstractC0807i abstractC0807i, boolean z) {
        return z ? m7095g(abstractC0807i) : "";
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public int mo6969a() {
        return 3;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public boolean mo6974b(AbstractC0807i abstractC0807i) {
        if (!(abstractC0807i instanceof C0805g)) {
            return false;
        }
        C0805g c0805g = (C0805g) abstractC0807i;
        if (!m7094f(c0805g.m7019d())) {
            return false;
        }
        AbstractC0945a m7018c = c0805g.m7018c();
        return ((m7018c instanceof C0967u) || (m7018c instanceof C0971y)) && m6976d(c0805g.m7043j()) >= 0;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: c */
    public BitSet mo6975c(AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        int f_ = m7043j.m8550f_();
        BitSet bitSet = new BitSet(f_);
        for (int i = 0; i < f_; i++) {
            C0934p m7949b = m7043j.m7949b(i);
            bitSet.set(i, m7086b((m7949b.m7935k() + m7949b.m7931g()) - 1));
        }
        return bitSet;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i) {
        int m7019d = ((C0805g) abstractC0807i).m7019d();
        C0935q m6977e = m6977e(abstractC0807i.m7043j());
        int f_ = m6977e.m8550f_();
        m7080a(interfaceC1007a, m7073a(abstractC0807i, m7084b(f_ > 4 ? m6977e.m7949b(4).m7931g() : 0, f_)), (short) m7019d, m7072a(f_ > 0 ? m6977e.m7949b(0).m7931g() : 0, f_ > 1 ? m6977e.m7949b(1).m7931g() : 0, f_ > 2 ? m6977e.m7949b(2).m7931g() : 0, f_ > 3 ? m6977e.m7949b(3).m7931g() : 0));
    }

    /* renamed from: d */
    private static int m6976d(C0935q c0935q) {
        int f_ = c0935q.m8550f_();
        if (f_ > 5) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < f_; i2++) {
            i += c0935q.m7949b(i2).m7935k();
            if (!m7086b((r3.m7935k() + r3.m7931g()) - 1)) {
                return -1;
            }
        }
        if (i > 5) {
            i = -1;
        }
        return i;
    }

    /* renamed from: e */
    private static C0935q m6977e(C0935q c0935q) {
        int i;
        int m6976d = m6976d(c0935q);
        int f_ = c0935q.m8550f_();
        if (m6976d != f_) {
            C0935q c0935q2 = new C0935q(m6976d);
            int i2 = 0;
            int i3 = 0;
            while (i2 < f_) {
                C0934p m7949b = c0935q.m7949b(i2);
                c0935q2.m7948a(i3, m7949b);
                if (m7949b.m7935k() == 2) {
                    c0935q2.m7948a(i3 + 1, C0934p.m7913a(m7949b.m7931g() + 1, C0975c.f6254i));
                    i = i3 + 2;
                } else {
                    i = i3 + 1;
                }
                i2++;
                i3 = i;
            }
            c0935q2.mo6683e_();
            return c0935q2;
        }
        return c0935q;
    }
}
