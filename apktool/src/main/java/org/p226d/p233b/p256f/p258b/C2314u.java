package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2207t;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction23x.java */
/* renamed from: org.d.b.f.b.u */
/* loaded from: classes.dex */
public class C2314u extends AbstractC2295b implements InterfaceC2207t {

    /* renamed from: a */
    public static final EnumC2076d f12527a = EnumC2076d.Format23x;

    /* renamed from: b */
    protected final int f12528b;

    /* renamed from: c */
    protected final int f12529c;

    /* renamed from: e */
    protected final int f12530e;

    public C2314u(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12528b = C2388h.m15101b(i);
        this.f12529c = C2388h.m15101b(i2);
        this.f12530e = C2388h.m15101b(i3);
    }

    /* renamed from: a */
    public static C2314u m14941a(InterfaceC2207t interfaceC2207t) {
        if (interfaceC2207t instanceof C2314u) {
            return (C2314u) interfaceC2207t;
        }
        return new C2314u(interfaceC2207t.mo14416a(), interfaceC2207t.mo14495q_(), interfaceC2207t.mo14500r_(), interfaceC2207t.mo14504g());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12528b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12529c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2229q
    /* renamed from: g */
    public int mo14504g() {
        return this.f12530e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12527a;
    }
}
