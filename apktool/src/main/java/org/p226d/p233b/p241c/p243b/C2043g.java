package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.C2380h;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2194g;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction20bc.java */
/* renamed from: org.d.b.c.b.g */
/* loaded from: classes.dex */
public class C2043g extends AbstractC2063c implements InterfaceC2194g {

    /* renamed from: c */
    public static final EnumC2076d f11652c = EnumC2076d.Format20bc;

    /* renamed from: d */
    protected final int f11653d;

    /* renamed from: e */
    protected final InterfaceC2241f f11654e;

    public C2043g(EnumC2272f enumC2272f, int i, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f11653d = C2388h.m15114o(i);
        this.f11654e = interfaceC2241f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2232t
    /* renamed from: e */
    public int mo14501e() {
        return this.f11653d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11654e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return C2380h.m15067a(this.f11654e);
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11652c;
    }
}
