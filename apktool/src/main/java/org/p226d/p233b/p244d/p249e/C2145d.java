package org.p226d.p233b.p244d.p249e;

import org.p226d.p233b.p238b.p240b.AbstractC2001g;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p244d.p247c.C2122b;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;

/* compiled from: DexBackedEnumEncodedValue.java */
/* renamed from: org.d.b.d.e.d */
/* loaded from: classes.dex */
public class C2145d extends AbstractC2001g {

    /* renamed from: a */
    public final C2153g f11934a;

    /* renamed from: b */
    private final int f11935b;

    public C2145d(C2161o c2161o, int i) {
        this.f11934a = (C2153g) c2161o.f11828a;
        this.f11935b = c2161o.m14642d(i + 1);
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2252h
    /* renamed from: b */
    public InterfaceC2237b mo14737b() {
        return new C2122b(this.f11934a, this.f11935b);
    }
}
