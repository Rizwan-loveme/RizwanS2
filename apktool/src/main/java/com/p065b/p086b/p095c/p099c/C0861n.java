package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0950d;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: EncodedArrayItem.java */
/* renamed from: com.b.b.c.c.n */
/* loaded from: classes.dex */
public final class C0861n extends AbstractC0834ah {

    /* renamed from: a */
    private final C0950d f5288a;

    /* renamed from: b */
    private byte[] f5289b;

    public C0861n(C0950d c0950d) {
        super(1, -1);
        if (c0950d == null) {
            throw new NullPointerException("array == null");
        }
        this.f5288a = c0950d;
        this.f5289b = null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_ENCODED_ARRAY_ITEM;
    }

    public int hashCode() {
        return this.f5288a.hashCode();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected int mo7198a(AbstractC0834ah abstractC0834ah) {
        return this.f5288a.compareTo(((C0861n) abstractC0834ah).f5288a);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return this.f5288a.mo6681d();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0848av.m7289a(c0860m, this.f5288a);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        C1014e c1014e = new C1014e();
        new C0848av(abstractC0838al.m7255e(), c1014e).m7296a(this.f5288a, false);
        this.f5289b = c1014e.m8527f();
        m7234a(this.f5289b.length);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7239h() + " encoded array");
            new C0848av(c0860m, interfaceC1007a).m7296a(this.f5288a, true);
        } else {
            interfaceC1007a.mo8520a(this.f5289b);
        }
    }
}
