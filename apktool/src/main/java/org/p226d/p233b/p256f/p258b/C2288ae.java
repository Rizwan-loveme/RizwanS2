package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2181ad;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction3rmi.java */
/* renamed from: org.d.b.f.b.ae */
/* loaded from: classes.dex */
public class C2288ae extends AbstractC2295b implements InterfaceC2181ad {

    /* renamed from: a */
    public static final EnumC2076d f12450a = EnumC2076d.Format3rmi;

    /* renamed from: b */
    protected final int f12451b;

    /* renamed from: c */
    protected final int f12452c;

    /* renamed from: e */
    protected final int f12453e;

    public C2288ae(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f12451b = C2388h.m15102c(i);
        this.f12452c = C2388h.m15110k(i2);
        this.f12453e = C2388h.m15113n(i3);
    }

    /* renamed from: a */
    public static C2288ae m14910a(InterfaceC2181ad interfaceC2181ad) {
        if (interfaceC2181ad instanceof C2288ae) {
            return (C2288ae) interfaceC2181ad;
        }
        return new C2288ae(interfaceC2181ad.mo14416a(), interfaceC2181ad.mo14491h(), interfaceC2181ad.mo14481e(), interfaceC2181ad.mo14482f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f12451b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f12452c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2217e
    /* renamed from: f */
    public int mo14482f() {
        return this.f12453e;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12450a;
    }
}
