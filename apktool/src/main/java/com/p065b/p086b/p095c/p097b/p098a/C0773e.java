package com.p065b.p086b.p095c.p097b.p098a;

import com.p065b.p086b.p095c.p097b.AbstractC0807i;
import com.p065b.p086b.p095c.p097b.AbstractC0813o;
import com.p065b.p086b.p095c.p097b.C0824z;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: Form12x.java */
/* renamed from: com.b.b.c.b.a.e */
/* loaded from: classes.dex */
public final class C0773e extends AbstractC0813o {

    /* renamed from: b */
    public static final AbstractC0813o f4743b = new C0773e();

    private C0773e() {
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public String mo6970a(AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        int f_ = m7043j.m8550f_();
        return m7043j.m7949b(f_ - 2).m7937m() + ", " + m7043j.m7949b(f_ - 1).m7937m();
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public String mo6973b(AbstractC0807i abstractC0807i, boolean z) {
        return "";
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public int mo6969a() {
        return 1;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public boolean mo6974b(AbstractC0807i abstractC0807i) {
        C0934p m7949b;
        C0934p m7949b2;
        if (!(abstractC0807i instanceof C0824z)) {
            return false;
        }
        C0935q m7043j = abstractC0807i.m7043j();
        switch (m7043j.m8550f_()) {
            case 2:
                m7949b = m7043j.m7949b(0);
                m7949b2 = m7043j.m7949b(1);
                break;
            case 3:
                m7949b = m7043j.m7949b(1);
                m7949b2 = m7043j.m7949b(2);
                if (m7949b.m7931g() != m7043j.m7949b(0).m7931g()) {
                    return false;
                }
                break;
            default:
                return false;
        }
        return m7086b(m7949b.m7931g()) && m7086b(m7949b2.m7931g());
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: c */
    public BitSet mo6975c(AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        BitSet bitSet = new BitSet(2);
        bitSet.set(0, m7086b(m7043j.m7949b(0).m7931g()));
        bitSet.set(1, m7086b(m7043j.m7949b(1).m7931g()));
        return bitSet;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        int f_ = m7043j.m8550f_();
        m7074a(interfaceC1007a, m7073a(abstractC0807i, m7084b(m7043j.m7949b(f_ - 2).m7931g(), m7043j.m7949b(f_ - 1).m7931g())));
    }
}
