package com.p065b.p086b.p095c.p097b.p098a;

import com.p065b.p086b.p095c.p097b.AbstractC0807i;
import com.p065b.p086b.p095c.p097b.AbstractC0813o;
import com.p065b.p086b.p095c.p097b.C0805g;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: Form41c.java */
/* renamed from: com.b.b.c.b.a.x */
/* loaded from: classes.dex */
public final class C0792x extends AbstractC0813o {

    /* renamed from: b */
    public static final AbstractC0813o f4762b = new C0792x();

    private C0792x() {
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public String mo6970a(AbstractC0807i abstractC0807i) {
        return abstractC0807i.m7043j().m7949b(0).m7937m() + ", " + m7093f(abstractC0807i);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public String mo6973b(AbstractC0807i abstractC0807i, boolean z) {
        return z ? m7095g(abstractC0807i) : "";
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public int mo6969a() {
        return 4;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public boolean mo6974b(AbstractC0807i abstractC0807i) {
        C0934p m7949b;
        if (!f5063a || !(abstractC0807i instanceof C0805g)) {
            return false;
        }
        C0935q m7043j = abstractC0807i.m7043j();
        switch (m7043j.m8550f_()) {
            case 1:
                m7949b = m7043j.m7949b(0);
                break;
            case 2:
                m7949b = m7043j.m7949b(0);
                if (m7949b.m7931g() != m7043j.m7949b(1).m7931g()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        if (!m7094f(m7949b.m7931g())) {
            return false;
        }
        AbstractC0945a m7018c = ((C0805g) abstractC0807i).m7018c();
        return (m7018c instanceof C0971y) || (m7018c instanceof C0957k);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: c */
    public BitSet mo6975c(AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        int f_ = m7043j.m8550f_();
        BitSet bitSet = new BitSet(f_);
        boolean d2 = m7090d(m7043j.m7949b(0).m7931g());
        if (f_ == 1) {
            bitSet.set(0, d2);
        } else if (m7043j.m7949b(0).m7931g() == m7043j.m7949b(1).m7931g()) {
            bitSet.set(0, d2);
            bitSet.set(1, d2);
        }
        return bitSet;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        m7076a(interfaceC1007a, m7096h(abstractC0807i), ((C0805g) abstractC0807i).m7019d(), (short) m7043j.m7949b(0).m7931g());
    }
}
