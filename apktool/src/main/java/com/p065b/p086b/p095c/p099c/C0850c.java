package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: AnnotationSetRefItem.java */
/* renamed from: com.b.b.c.c.c */
/* loaded from: classes.dex */
public final class C0850c extends AbstractC0834ah {

    /* renamed from: a */
    private C0849b f5204a;

    public C0850c(C0849b c0849b) {
        super(4, 4);
        if (c0849b == null) {
            throw new NullPointerException("annotations == null");
        }
        this.f5204a = c0849b;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_ANNOTATION_SET_REF_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        this.f5204a = (C0849b) c0860m.m7401e().m7228b((C0833ag) this.f5204a);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return this.f5204a.mo7204b();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int f2 = this.f5204a.m7237f();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "  annotations_off: " + C1022m.m8552a(f2));
        }
        interfaceC1007a.mo8523d(f2);
    }
}
