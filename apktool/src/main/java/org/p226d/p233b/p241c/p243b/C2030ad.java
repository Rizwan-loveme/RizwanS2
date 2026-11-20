package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2181ad;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction3rmi.java */
/* renamed from: org.d.b.c.b.ad */
/* loaded from: classes.dex */
public class C2030ad extends AbstractC2063c implements InterfaceC2181ad {

    /* renamed from: c */
    public static final EnumC2076d f11608c = EnumC2076d.Format3rmi;

    /* renamed from: d */
    protected final int f11609d;

    /* renamed from: e */
    protected final int f11610e;

    /* renamed from: f */
    protected final int f11611f;

    public C2030ad(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f11609d = C2388h.m15102c(i);
        this.f11610e = C2388h.m15110k(i2);
        this.f11611f = i3;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f11609d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11610e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2217e
    /* renamed from: f */
    public int mo14482f() {
        return this.f11611f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11608c;
    }
}
