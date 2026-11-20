package org.p226d.p233b.p244d.p249e;

import org.p226d.p233b.p238b.p240b.AbstractC2002h;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p244d.p247c.C2122b;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;

/* compiled from: DexBackedFieldEncodedValue.java */
/* renamed from: org.d.b.d.e.e */
/* loaded from: classes.dex */
public class C2146e extends AbstractC2002h {

    /* renamed from: a */
    public final C2153g f11936a;

    /* renamed from: b */
    private final int f11937b;

    public C2146e(C2161o c2161o, int i) {
        this.f11936a = (C2153g) c2161o.f11828a;
        this.f11937b = c2161o.m14642d(i + 1);
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2253i
    /* renamed from: b */
    public InterfaceC2237b mo14738b() {
        return new C2122b(this.f11936a, this.f11937b);
    }
}
