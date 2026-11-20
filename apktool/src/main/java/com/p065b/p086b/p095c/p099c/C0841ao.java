package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: StringIdItem.java */
/* renamed from: com.b.b.c.c.ao */
/* loaded from: classes.dex */
public final class C0841ao extends AbstractC0871x implements Comparable {

    /* renamed from: a */
    private final C0970x f5193a;

    /* renamed from: b */
    private C0840an f5194b;

    public C0841ao(C0970x c0970x) {
        if (c0970x == null) {
            throw new NullPointerException("value == null");
        }
        this.f5193a = c0970x;
        this.f5194b = null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0841ao)) {
            return false;
        }
        return this.f5193a.equals(((C0841ao) obj).f5193a);
    }

    public int hashCode() {
        return this.f5193a.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return this.f5193a.compareTo(((C0841ao) obj).f5193a);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_STRING_ID_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public int mo7211g_() {
        return 4;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        if (this.f5194b == null) {
            C0833ag m7400d = c0860m.m7400d();
            this.f5194b = new C0840an(this.f5193a);
            m7400d.m7225a((AbstractC0834ah) this.f5194b);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int f2 = this.f5194b.m7237f();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, m7437j() + ' ' + this.f5193a.m8082a(100));
            interfaceC1007a.mo8458a(4, "  string_data_off: " + C1022m.m8552a(f2));
        }
        interfaceC1007a.mo8523d(f2);
    }

    /* renamed from: c */
    public C0970x m7270c() {
        return this.f5193a;
    }
}
