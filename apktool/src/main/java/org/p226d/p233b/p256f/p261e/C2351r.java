package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC2010p;
import org.p226d.p233b.p250e.p255d.InterfaceC2261q;

/* compiled from: ImmutableShortEncodedValue.java */
/* renamed from: org.d.b.f.e.r */
/* loaded from: classes.dex */
public class C2351r extends AbstractC2010p implements InterfaceC2340g {

    /* renamed from: a */
    protected final short f12605a;

    public C2351r(short s) {
        this.f12605a = s;
    }

    /* renamed from: a */
    public static C2351r m15001a(InterfaceC2261q interfaceC2261q) {
        return interfaceC2261q instanceof C2351r ? (C2351r) interfaceC2261q : new C2351r(interfaceC2261q.mo14867b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2261q
    /* renamed from: b */
    public short mo14867b() {
        return this.f12605a;
    }
}
