package org.p226d.p233b.p256f.p261e;

import org.p226d.p233b.p238b.p240b.AbstractC1997c;
import org.p226d.p233b.p250e.p255d.InterfaceC2247c;

/* compiled from: ImmutableBooleanEncodedValue.java */
/* renamed from: org.d.b.f.e.c */
/* loaded from: classes.dex */
public class C2336c extends AbstractC1997c implements InterfaceC2340g {

    /* renamed from: a */
    public static final C2336c f12589a = new C2336c(true);

    /* renamed from: b */
    public static final C2336c f12590b = new C2336c(false);

    /* renamed from: c */
    protected final boolean f12591c;

    private C2336c(boolean z) {
        this.f12591c = z;
    }

    /* renamed from: a */
    public static C2336c m14980a(boolean z) {
        return z ? f12589a : f12590b;
    }

    /* renamed from: a */
    public static C2336c m14979a(InterfaceC2247c interfaceC2247c) {
        return m14980a(interfaceC2247c.mo14860b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2247c
    /* renamed from: b */
    public boolean mo14860b() {
        return this.f12591c;
    }
}
