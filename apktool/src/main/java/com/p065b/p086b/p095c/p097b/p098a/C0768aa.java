package com.p065b.p086b.p095c.p097b.p098a;

import com.p065b.p086b.p095c.p097b.AbstractC0807i;
import com.p065b.p086b.p095c.p097b.AbstractC0813o;
import com.p065b.p086b.p095c.p097b.C0805g;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: Form5rc.java */
/* renamed from: com.b.b.c.b.a.aa */
/* loaded from: classes.dex */
public final class C0768aa extends AbstractC0813o {

    /* renamed from: b */
    public static final AbstractC0813o f4738b = new C0768aa();

    private C0768aa() {
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public String mo6970a(AbstractC0807i abstractC0807i) {
        return m7085b(abstractC0807i.m7043j()) + ", " + m7093f(abstractC0807i);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public String mo6973b(AbstractC0807i abstractC0807i, boolean z) {
        return z ? m7095g(abstractC0807i) : "";
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public int mo6969a() {
        return 5;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public boolean mo6974b(AbstractC0807i abstractC0807i) {
        if (!f5063a || !(abstractC0807i instanceof C0805g)) {
            return false;
        }
        C0805g c0805g = (C0805g) abstractC0807i;
        AbstractC0945a m7018c = c0805g.m7018c();
        if (!(m7018c instanceof C0967u) && !(m7018c instanceof C0971y)) {
            return false;
        }
        C0935q j = c0805g.m7043j();
        j.m8550f_();
        return j.m8550f_() == 0 || (m7088c(j) && m7094f(j.m7949b(0).m7931g()) && m7094f(j.m7953e()));
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        m7077a(interfaceC1007a, m7096h(abstractC0807i), ((C0805g) abstractC0807i).m7019d(), (short) m7043j.m7953e(), (short) (m7043j.m8550f_() == 0 ? 0 : m7043j.m7949b(0).m7931g()));
    }
}
