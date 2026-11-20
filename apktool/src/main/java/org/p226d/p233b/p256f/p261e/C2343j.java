package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC2002h;
import org.p226d.p233b.p250e.p255d.InterfaceC2253i;
import org.p226d.p233b.p256f.p259c.C2322b;

/* compiled from: ImmutableFieldEncodedValue.java */
/* renamed from: org.d.b.f.e.j */
/* loaded from: classes.dex */
public class C2343j extends AbstractC2002h implements InterfaceC2340g {

    /* renamed from: a */
    protected final C2322b f12597a;

    public C2343j(C2322b c2322b) {
        this.f12597a = c2322b;
    }

    /* renamed from: a */
    public static C2343j m14990a(InterfaceC2253i interfaceC2253i) {
        return interfaceC2253i instanceof C2343j ? (C2343j) interfaceC2253i : new C2343j(C2322b.m14959b(interfaceC2253i.mo14738b()));
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2253i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C2322b mo14738b() {
        return this.f12597a;
    }
}
