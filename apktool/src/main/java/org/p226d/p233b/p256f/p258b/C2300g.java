package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2193f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction12x.java */
/* renamed from: org.d.b.f.b.g */
/* loaded from: classes.dex */
public class C2300g extends AbstractC2295b implements InterfaceC2193f {

    /* renamed from: a */
    public static final EnumC2076d f12481a = EnumC2076d.Format12x;

    /* renamed from: b */
    protected final int f12482b;

    /* renamed from: c */
    protected final int f12483c;

    public C2300g(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12482b = C2388h.m15097a(i);
        this.f12483c = C2388h.m15097a(i2);
    }

    /* renamed from: a */
    public static C2300g m14924a(InterfaceC2193f interfaceC2193f) {
        if (interfaceC2193f instanceof C2300g) {
            return (C2300g) interfaceC2193f;
        }
        return new C2300g(interfaceC2193f.mo14416a(), interfaceC2193f.mo14495q_(), interfaceC2193f.mo14500r_());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12482b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12483c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12481a;
    }
}
