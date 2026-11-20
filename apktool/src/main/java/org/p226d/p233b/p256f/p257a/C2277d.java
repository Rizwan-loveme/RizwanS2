package org.p226d.p233b.p256f.p257a;

import org.p226d.p233b.p250e.p251a.InterfaceC2169d;

/* compiled from: ImmutableLineNumber.java */
/* renamed from: org.d.b.f.a.d */
/* loaded from: classes.dex */
public class C2277d extends AbstractC2274a implements InterfaceC2169d {

    /* renamed from: b */
    protected final int f12402b;

    public C2277d(int i, int i2) {
        super(i);
        this.f12402b = i2;
    }

    /* renamed from: a */
    public static C2277d m14895a(InterfaceC2169d interfaceC2169d) {
        if (interfaceC2169d instanceof C2277d) {
            return (C2277d) interfaceC2169d;
        }
        return new C2277d(interfaceC2169d.mo14461a(), interfaceC2169d.mo14466b());
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2169d
    /* renamed from: b */
    public int mo14466b() {
        return this.f12402b;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 10;
    }
}
