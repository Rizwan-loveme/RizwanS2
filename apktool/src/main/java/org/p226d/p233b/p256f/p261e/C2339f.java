package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC2000f;
import org.p226d.p233b.p250e.p255d.InterfaceC2250f;

/* compiled from: ImmutableDoubleEncodedValue.java */
/* renamed from: org.d.b.f.e.f */
/* loaded from: classes.dex */
public class C2339f extends AbstractC2000f implements InterfaceC2340g {

    /* renamed from: a */
    protected final double f12594a;

    public C2339f(double d2) {
        this.f12594a = d2;
    }

    /* renamed from: a */
    public static C2339f m14983a(InterfaceC2250f interfaceC2250f) {
        return interfaceC2250f instanceof C2339f ? (C2339f) interfaceC2250f : new C2339f(interfaceC2250f.mo14863b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2250f
    /* renamed from: b */
    public double mo14863b() {
        return this.f12594a;
    }
}
