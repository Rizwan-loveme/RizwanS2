package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2209v;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p256f.p259c.C2327g;
import org.p226d.p233b.p256f.p259c.InterfaceC2326f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction31c.java */
/* renamed from: org.d.b.f.b.w */
/* loaded from: classes.dex */
public class C2316w extends AbstractC2295b implements InterfaceC2209v {

    /* renamed from: a */
    public static final EnumC2076d f12533a = EnumC2076d.Format31c;

    /* renamed from: b */
    protected final int f12534b;

    /* renamed from: c */
    protected final InterfaceC2326f f12535c;

    public C2316w(EnumC2272f enumC2272f, int i, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f12534b = C2388h.m15101b(i);
        this.f12535c = C2327g.m14964a(enumC2272f.f12385eh, interfaceC2241f);
    }

    /* renamed from: a */
    public static C2316w m14943a(InterfaceC2209v interfaceC2209v) {
        if (interfaceC2209v instanceof C2316w) {
            return (C2316w) interfaceC2209v;
        }
        return new C2316w(interfaceC2209v.mo14416a(), interfaceC2209v.mo14495q_(), interfaceC2209v.mo14489f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f12534b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC2326f mo14489f() {
        return this.f12535c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f12471d.f12385eh;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12533a;
    }
}
