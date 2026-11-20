package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.C2380h;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2194g;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p256f.p259c.C2327g;
import org.p226d.p233b.p256f.p259c.InterfaceC2326f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction20bc.java */
/* renamed from: org.d.b.f.b.h */
/* loaded from: classes.dex */
public class C2301h extends AbstractC2295b implements InterfaceC2194g {

    /* renamed from: a */
    public static final EnumC2076d f12484a = EnumC2076d.Format20bc;

    /* renamed from: b */
    protected final int f12485b;

    /* renamed from: c */
    protected final InterfaceC2326f f12486c;

    public C2301h(EnumC2272f enumC2272f, int i, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f12485b = C2388h.m15114o(i);
        this.f12486c = C2327g.m14964a(enumC2272f.f12385eh, interfaceC2241f);
    }

    /* renamed from: a */
    public static C2301h m14925a(InterfaceC2194g interfaceC2194g) {
        if (interfaceC2194g instanceof C2301h) {
            return (C2301h) interfaceC2194g;
        }
        return new C2301h(interfaceC2194g.mo14416a(), interfaceC2194g.mo14501e(), interfaceC2194g.mo14489f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2232t
    /* renamed from: e */
    public int mo14501e() {
        return this.f12485b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC2326f mo14489f() {
        return this.f12486c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return C2380h.m15067a(this.f12486c);
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12484a;
    }
}
