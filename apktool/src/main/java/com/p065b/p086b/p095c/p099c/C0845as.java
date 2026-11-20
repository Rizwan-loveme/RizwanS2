package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: TypeListItem.java */
/* renamed from: com.b.b.c.c.as */
/* loaded from: classes.dex */
public final class C0845as extends AbstractC0834ah {

    /* renamed from: a */
    private final InterfaceC0977e f5197a;

    public C0845as(InterfaceC0977e interfaceC0977e) {
        super(4, (interfaceC0977e.mo6856f_() * 2) + 4);
        this.f5197a = interfaceC0977e;
    }

    public int hashCode() {
        return C0974b.m8111b(this.f5197a);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_TYPE_LIST;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0844ar m7407k = c0860m.m7407k();
        int mo6856f_ = this.f5197a.mo6856f_();
        for (int i = 0; i < mo6856f_; i++) {
            m7407k.m7277a(this.f5197a.mo6853a(i));
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        throw new RuntimeException("unsupported");
    }

    /* renamed from: c */
    public InterfaceC0977e m7282c() {
        return this.f5197a;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        C0844ar m7407k = c0860m.m7407k();
        int mo6856f_ = this.f5197a.mo6856f_();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7239h() + " type_list");
            interfaceC1007a.mo8458a(4, "  size: " + C1022m.m8552a(mo6856f_));
            for (int i = 0; i < mo6856f_; i++) {
                C0975c mo6853a = this.f5197a.mo6853a(i);
                interfaceC1007a.mo8458a(2, "  " + C1022m.m8557c(m7407k.m7280b(mo6853a)) + " // " + mo6853a.mo6681d());
            }
        }
        interfaceC1007a.mo8523d(mo6856f_);
        for (int i2 = 0; i2 < mo6856f_; i2++) {
            interfaceC1007a.mo8522b(m7407k.m7280b(this.f5197a.mo6853a(i2)));
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected int mo7198a(AbstractC0834ah abstractC0834ah) {
        return C0974b.m8112b(this.f5197a, ((C0845as) abstractC0834ah).f5197a);
    }
}
