package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2210w;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction31i.java */
/* renamed from: org.d.b.f.b.x */
/* loaded from: classes.dex */
public class C2317x extends AbstractC2295b implements InterfaceC2210w {

    /* renamed from: a */
    public static final EnumC2076d f12536a = EnumC2076d.Format31i;

    /* renamed from: b */
    protected final int f12537b;

    /* renamed from: c */
    protected final int f12538c;

    public C2317x(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12537b = C2388h.m15101b(i);
        this.f12538c = i2;
    }

    /* renamed from: a */
    public static C2317x m14945a(InterfaceC2210w interfaceC2210w) {
        if (interfaceC2210w instanceof C2317x) {
            return (C2317x) interfaceC2210w;
        }
        return new C2317x(interfaceC2210w.mo14416a(), interfaceC2210w.mo14495q_(), interfaceC2210w.mo14499f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12537b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f12538c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12538c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12536a;
    }
}
