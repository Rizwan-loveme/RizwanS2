package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC2008n;
import org.p226d.p233b.p250e.p255d.InterfaceC2259o;
import org.p226d.p233b.p256f.p259c.C2324d;

/* compiled from: ImmutableMethodTypeEncodedValue.java */
/* renamed from: org.d.b.f.e.p */
/* loaded from: classes.dex */
public class C2349p extends AbstractC2008n implements InterfaceC2340g {

    /* renamed from: a */
    protected final C2324d f12603a;

    public C2349p(C2324d c2324d) {
        this.f12603a = c2324d;
    }

    /* renamed from: a */
    public static C2349p m14999a(InterfaceC2259o interfaceC2259o) {
        if (interfaceC2259o instanceof C2349p) {
            return (C2349p) interfaceC2259o;
        }
        return new C2349p(C2324d.m14961b(interfaceC2259o.mo14741b()));
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2259o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C2324d mo14741b() {
        return this.f12603a;
    }
}
