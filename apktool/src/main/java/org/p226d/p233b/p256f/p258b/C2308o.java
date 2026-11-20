package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2201n;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction22b.java */
/* renamed from: org.d.b.f.b.o */
/* loaded from: classes.dex */
public class C2308o extends AbstractC2295b implements InterfaceC2201n {

    /* renamed from: a */
    public static final EnumC2076d f12504a = EnumC2076d.Format22b;

    /* renamed from: b */
    protected final int f12505b;

    /* renamed from: c */
    protected final int f12506c;

    /* renamed from: e */
    protected final int f12507e;

    public C2308o(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12505b = C2388h.m15101b(i);
        this.f12506c = C2388h.m15101b(i2);
        this.f12507e = C2388h.m15104e(i3);
    }

    /* renamed from: a */
    public static C2308o m14934a(InterfaceC2201n interfaceC2201n) {
        if (interfaceC2201n instanceof C2308o) {
            return (C2308o) interfaceC2201n;
        }
        return new C2308o(interfaceC2201n.mo14416a(), interfaceC2201n.mo14495q_(), interfaceC2201n.mo14500r_(), interfaceC2201n.mo14499f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12505b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f12506c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f12507e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12507e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12504a;
    }
}
