package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2185ah;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction51l.java */
/* renamed from: org.d.b.f.b.ag */
/* loaded from: classes.dex */
public class C2290ag extends AbstractC2295b implements InterfaceC2185ah {

    /* renamed from: a */
    public static final EnumC2076d f12458a = EnumC2076d.Format51l;

    /* renamed from: b */
    protected final int f12459b;

    /* renamed from: c */
    protected final long f12460c;

    public C2290ag(EnumC2272f enumC2272f, int i, long j) {
        super(enumC2272f);
        this.f12459b = C2388h.m15101b(i);
        this.f12460c = j;
    }

    /* renamed from: a */
    public static C2290ag m14912a(InterfaceC2185ah interfaceC2185ah) {
        if (interfaceC2185ah instanceof C2290ag) {
            return (C2290ag) interfaceC2185ah;
        }
        return new C2290ag(interfaceC2185ah.mo14416a(), interfaceC2185ah.mo14495q_(), interfaceC2185ah.mo14494g());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12459b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12460c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12458a;
    }
}
