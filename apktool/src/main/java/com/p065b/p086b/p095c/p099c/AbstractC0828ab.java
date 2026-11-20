package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0966t;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: MemberIdItem.java */
/* renamed from: com.b.b.c.c.ab */
/* loaded from: classes.dex */
public abstract class AbstractC0828ab extends AbstractC0870w {

    /* renamed from: a */
    private final AbstractC0966t f5156a;

    /* renamed from: b */
    protected abstract int mo7208b(C0860m c0860m);

    /* renamed from: d */
    protected abstract String mo7209d();

    public AbstractC0828ab(AbstractC0966t abstractC0966t) {
        super(abstractC0966t.m8070m());
        this.f5156a = abstractC0966t;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public int mo7211g_() {
        return 8;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0870w, com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        super.mo7201a(c0860m);
        c0860m.m7404h().m7272a(m7210f().m8071n().m8072a());
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public final void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        C0844ar m7407k = c0860m.m7407k();
        C0842ap m7404h = c0860m.m7404h();
        C0968v m8071n = this.f5156a.m8071n();
        int m7279b = m7407k.m7279b(m7433e());
        int m7274b = m7404h.m7274b(m8071n.m8072a());
        int mo7208b = mo7208b(c0860m);
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7437j() + ' ' + this.f5156a.mo6681d());
            interfaceC1007a.mo8458a(2, "  class_idx: " + C1022m.m8557c(m7279b));
            interfaceC1007a.mo8458a(2, String.format("  %-10s %s", mo7209d() + ':', C1022m.m8557c(mo7208b)));
            interfaceC1007a.mo8458a(4, "  name_idx:  " + C1022m.m8552a(m7274b));
        }
        interfaceC1007a.mo8522b(m7279b);
        interfaceC1007a.mo8522b(mo7208b);
        interfaceC1007a.mo8523d(m7274b);
    }

    /* renamed from: f */
    public final AbstractC0966t m7210f() {
        return this.f5156a;
    }
}
