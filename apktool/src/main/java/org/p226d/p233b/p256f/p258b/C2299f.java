package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2192e;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction11x.java */
/* renamed from: org.d.b.f.b.f */
/* loaded from: classes.dex */
public class C2299f extends AbstractC2295b implements InterfaceC2192e {

    /* renamed from: a */
    public static final EnumC2076d f12479a = EnumC2076d.Format11x;

    /* renamed from: b */
    protected final int f12480b;

    public C2299f(EnumC2272f enumC2272f, int i) {
        super(enumC2272f);
        this.f12480b = C2388h.m15101b(i);
    }

    /* renamed from: a */
    public static C2299f m14923a(InterfaceC2192e interfaceC2192e) {
        if (interfaceC2192e instanceof C2299f) {
            return (C2299f) interfaceC2192e;
        }
        return new C2299f(interfaceC2192e.mo14416a(), interfaceC2192e.mo14495q_());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12480b;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12479a;
    }
}
