package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2206s;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction22x.java */
/* renamed from: org.d.b.f.b.t */
/* loaded from: classes.dex */
public class C2313t extends AbstractC2295b implements InterfaceC2206s {

    /* renamed from: a */
    public static final EnumC2076d f12524a = EnumC2076d.Format22x;

    /* renamed from: b */
    protected final int f12525b;

    /* renamed from: c */
    protected final int f12526c;

    public C2313t(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12525b = C2388h.m15101b(i);
        this.f12526c = C2388h.m15102c(i2);
    }

    /* renamed from: a */
    public static C2313t m14940a(InterfaceC2206s interfaceC2206s) {
        if (interfaceC2206s instanceof C2313t) {
            return (C2313t) interfaceC2206s;
        }
        return new C2313t(interfaceC2206s.mo14416a(), interfaceC2206s.mo14495q_(), interfaceC2206s.mo14500r_());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12525b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12526c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12524a;
    }
}
