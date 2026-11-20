package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: TypeIdItem.java */
/* renamed from: com.b.b.c.c.aq */
/* loaded from: classes.dex */
public final class C0843aq extends AbstractC0870w {
    public C0843aq(C0971y c0971y) {
        super(c0971y);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_TYPE_ID_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public int mo7211g_() {
        return 4;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0870w, com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        c0860m.m7404h().m7272a(m7433e().m8091j());
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        C0970x m8091j = m7433e().m8091j();
        int m7274b = c0860m.m7404h().m7274b(m8091j);
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7437j() + ' ' + m8091j.mo6681d());
            interfaceC1007a.mo8458a(4, "  descriptor_idx: " + C1022m.m8552a(m7274b));
        }
        interfaceC1007a.mo8523d(m7274b);
    }
}
