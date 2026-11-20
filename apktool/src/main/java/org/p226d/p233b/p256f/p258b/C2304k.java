package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2197j;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction21ih.java */
/* renamed from: org.d.b.f.b.k */
/* loaded from: classes.dex */
public class C2304k extends AbstractC2295b implements InterfaceC2197j {

    /* renamed from: a */
    public static final EnumC2076d f12492a = EnumC2076d.Format21ih;

    /* renamed from: b */
    protected final int f12493b;

    /* renamed from: c */
    protected final int f12494c;

    public C2304k(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12493b = C2388h.m15101b(i);
        this.f12494c = C2388h.m15106g(i2);
    }

    /* renamed from: a */
    public static C2304k m14930a(InterfaceC2197j interfaceC2197j) {
        if (interfaceC2197j instanceof C2304k) {
            return (C2304k) interfaceC2197j;
        }
        return new C2304k(interfaceC2197j.mo14416a(), interfaceC2197j.mo14495q_(), interfaceC2197j.mo14499f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12493b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f12494c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12494c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2216d
    /* renamed from: h */
    public short mo14502h() {
        return (short) (this.f12494c >>> 16);
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12492a;
    }
}
