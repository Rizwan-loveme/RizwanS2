package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2207t;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction23x.java */
/* renamed from: org.d.b.c.b.t */
/* loaded from: classes.dex */
public class C2056t extends AbstractC2063c implements InterfaceC2207t {

    /* renamed from: c */
    public static final EnumC2076d f11692c = EnumC2076d.Format23x;

    /* renamed from: d */
    protected final int f11693d;

    /* renamed from: e */
    protected final int f11694e;

    /* renamed from: f */
    protected final int f11695f;

    public C2056t(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f11693d = C2388h.m15101b(i);
        this.f11694e = C2388h.m15101b(i2);
        this.f11695f = C2388h.m15101b(i3);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11693d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11694e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2229q
    /* renamed from: g */
    public int mo14504g() {
        return this.f11695f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11692c;
    }
}
