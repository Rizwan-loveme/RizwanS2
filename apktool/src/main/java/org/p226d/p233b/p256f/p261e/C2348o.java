package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC2007m;
import org.p226d.p233b.p250e.p255d.InterfaceC2258n;
import org.p226d.p233b.p256f.p259c.C2323c;

/* compiled from: ImmutableMethodHandleEncodedValue.java */
/* renamed from: org.d.b.f.e.o */
/* loaded from: classes.dex */
public class C2348o extends AbstractC2007m implements InterfaceC2340g {

    /* renamed from: a */
    protected final C2323c f12602a;

    public C2348o(C2323c c2323c) {
        this.f12602a = c2323c;
    }

    /* renamed from: a */
    public static C2348o m14997a(InterfaceC2258n interfaceC2258n) {
        if (interfaceC2258n instanceof C2348o) {
            return (C2348o) interfaceC2258n;
        }
        return new C2348o(C2323c.m14960b(interfaceC2258n.mo14740b()));
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2258n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C2323c mo14740b() {
        return this.f12602a;
    }
}
