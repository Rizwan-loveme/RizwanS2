package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2200m;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction21t.java */
/* renamed from: org.d.b.f.b.n */
/* loaded from: classes.dex */
public class C2307n extends AbstractC2295b implements InterfaceC2200m {

    /* renamed from: a */
    public static final EnumC2076d f12501a = EnumC2076d.Format21t;

    /* renamed from: b */
    protected final int f12502b;

    /* renamed from: c */
    protected final int f12503c;

    public C2307n(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12502b = C2388h.m15101b(i);
        this.f12503c = C2388h.m15108i(i2);
    }

    /* renamed from: a */
    public static C2307n m14933a(InterfaceC2200m interfaceC2200m) {
        if (interfaceC2200m instanceof C2307n) {
            return (C2307n) interfaceC2200m;
        }
        return new C2307n(interfaceC2200m.mo14416a(), interfaceC2200m.mo14495q_(), interfaceC2200m.mo14507e());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12502b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        return this.f12503c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12501a;
    }
}
