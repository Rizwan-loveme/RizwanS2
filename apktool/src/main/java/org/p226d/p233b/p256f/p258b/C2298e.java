package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2191d;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction11n.java */
/* renamed from: org.d.b.f.b.e */
/* loaded from: classes.dex */
public class C2298e extends AbstractC2295b implements InterfaceC2191d {

    /* renamed from: a */
    public static final EnumC2076d f12476a = EnumC2076d.Format11n;

    /* renamed from: b */
    protected final int f12477b;

    /* renamed from: c */
    protected final int f12478c;

    public C2298e(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f12477b = C2388h.m15097a(i);
        this.f12478c = C2388h.m15103d(i2);
    }

    /* renamed from: a */
    public static C2298e m14922a(InterfaceC2191d interfaceC2191d) {
        if (interfaceC2191d instanceof C2298e) {
            return (C2298e) interfaceC2191d;
        }
        return new C2298e(interfaceC2191d.mo14416a(), interfaceC2191d.mo14495q_(), interfaceC2191d.mo14499f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12477b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f12478c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f12478c;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12476a;
    }
}
