package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2212y;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction32x.java */
/* renamed from: org.d.b.f.b.z */
/* loaded from: classes.dex */
public class C2319z extends AbstractC2295b implements InterfaceC2212y {

    /* renamed from: a */
    public static final EnumC2076d f12542a = EnumC2076d.Format32x;

    /* renamed from: b */
    protected final int f12543b;

    /* renamed from: c */
    protected final int f12544c;

    public C2319z(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12543b = C2388h.m15102c(i);
        this.f12544c = C2388h.m15102c(i2);
    }

    /* renamed from: a */
    public static C2319z m14947a(InterfaceC2212y interfaceC2212y) {
        if (interfaceC2212y instanceof C2319z) {
            return (C2319z) interfaceC2212y;
        }
        return new C2319z(interfaceC2212y.mo14416a(), interfaceC2212y.mo14495q_(), interfaceC2212y.mo14500r_());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12543b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12544c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12542a;
    }
}
