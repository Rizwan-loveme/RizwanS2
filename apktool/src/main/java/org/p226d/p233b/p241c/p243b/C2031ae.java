package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2182ae;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction3rms.java */
/* renamed from: org.d.b.c.b.ae */
/* loaded from: classes.dex */
public class C2031ae extends AbstractC2063c implements InterfaceC2182ae {

    /* renamed from: c */
    public static final EnumC2076d f11612c = EnumC2076d.Format3rms;

    /* renamed from: d */
    protected final int f11613d;

    /* renamed from: e */
    protected final int f11614e;

    /* renamed from: f */
    protected final int f11615f;

    public C2031ae(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f11613d = C2388h.m15102c(i);
        this.f11614e = C2388h.m15110k(i2);
        this.f11615f = i3;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f11613d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11614e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2233u
    /* renamed from: f */
    public int mo14488f() {
        return this.f11615f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11612c;
    }
}
