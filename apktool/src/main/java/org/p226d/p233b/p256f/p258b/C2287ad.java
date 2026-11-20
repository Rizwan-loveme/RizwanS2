package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2180ac;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p256f.p259c.C2327g;
import org.p226d.p233b.p256f.p259c.InterfaceC2326f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction3rc.java */
/* renamed from: org.d.b.f.b.ad */
/* loaded from: classes.dex */
public class C2287ad extends AbstractC2295b implements InterfaceC2180ac {

    /* renamed from: a */
    public static final EnumC2076d f12446a = EnumC2076d.Format3rc;

    /* renamed from: b */
    protected final int f12447b;

    /* renamed from: c */
    protected final int f12448c;

    /* renamed from: e */
    protected final InterfaceC2326f f12449e;

    public C2287ad(EnumC2272f enumC2272f, int i, int i2, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f12447b = C2388h.m15102c(i);
        this.f12448c = C2388h.m15110k(i2);
        this.f12449e = C2327g.m14964a(enumC2272f.f12385eh, interfaceC2241f);
    }

    /* renamed from: a */
    public static C2287ad m14908a(InterfaceC2180ac interfaceC2180ac) {
        if (interfaceC2180ac instanceof C2287ad) {
            return (C2287ad) interfaceC2180ac;
        }
        return new C2287ad(interfaceC2180ac.mo14416a(), interfaceC2180ac.mo14491h(), interfaceC2180ac.mo14481e(), interfaceC2180ac.mo14489f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f12447b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f12448c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC2326f mo14489f() {
        return this.f12449e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f12471d.f12385eh;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12446a;
    }
}
