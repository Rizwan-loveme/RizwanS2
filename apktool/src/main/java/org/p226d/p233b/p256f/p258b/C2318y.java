package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2211x;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction31t.java */
/* renamed from: org.d.b.f.b.y */
/* loaded from: classes.dex */
public class C2318y extends AbstractC2295b implements InterfaceC2211x {

    /* renamed from: a */
    public static final EnumC2076d f12539a = EnumC2076d.Format31t;

    /* renamed from: b */
    protected final int f12540b;

    /* renamed from: c */
    protected final int f12541c;

    public C2318y(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12540b = C2388h.m15101b(i);
        this.f12541c = i2;
    }

    /* renamed from: a */
    public static C2318y m14946a(InterfaceC2211x interfaceC2211x) {
        if (interfaceC2211x instanceof C2318y) {
            return (C2318y) interfaceC2211x;
        }
        return new C2318y(interfaceC2211x.mo14416a(), interfaceC2211x.mo14495q_(), interfaceC2211x.mo14507e());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12540b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2222j
    /* renamed from: e */
    public int mo14507e() {
        return this.f12541c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12539a;
    }
}
