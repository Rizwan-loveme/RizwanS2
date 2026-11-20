package org.p226d.p233b.p244d.p245a;

import org.p226d.p233b.C2380h;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.p247c.AbstractC2126f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2194g;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;

/* compiled from: DexBackedInstruction20bc.java */
/* renamed from: org.d.b.d.a.h */
/* loaded from: classes.dex */
public class C2097h extends AbstractC2091b implements InterfaceC2194g {
    public C2097h(C2153g c2153g, EnumC2272f enumC2272f, int i) {
        super(c2153g, enumC2272f, i);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2232t
    /* renamed from: e */
    public int mo14501e() {
        return this.f11824d.m14618d(this.f11826f + 1) & 63;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return AbstractC2126f.m14690a(this.f11824d, mo14490g(), this.f11824d.m14617c(this.f11826f + 2));
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        int d2 = (this.f11824d.m14618d(this.f11826f + 1) >>> 6) + 1;
        C2380h.m15069b(d2);
        return d2;
    }
}
