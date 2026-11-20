package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1029t;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: StringDataItem.java */
/* renamed from: com.b.b.c.c.an */
/* loaded from: classes.dex */
public final class C0840an extends AbstractC0834ah {

    /* renamed from: a */
    private final C0970x f5192a;

    public C0840an(C0970x c0970x) {
        super(1, m7269a(c0970x));
        this.f5192a = c0970x;
    }

    /* renamed from: a */
    private static int m7269a(C0970x c0970x) {
        return C1029t.m8588a(c0970x.m8087m()) + c0970x.m8086l() + 1;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_STRING_DATA_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    public void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        C1013d m8085k = this.f5192a.m8085k();
        int m8087m = this.f5192a.m8087m();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(C1029t.m8588a(m8087m), "utf16_size: " + C1022m.m8552a(m8087m));
            interfaceC1007a.mo8458a(m8085k.m8502a() + 1, this.f5192a.m8083i());
        }
        interfaceC1007a.mo8524e(m8087m);
        interfaceC1007a.mo8518a(m8085k);
        interfaceC1007a.mo7631c(0);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return this.f5192a.m8083i();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected int mo7198a(AbstractC0834ah abstractC0834ah) {
        return this.f5192a.compareTo(((C0840an) abstractC0834ah).f5192a);
    }
}
