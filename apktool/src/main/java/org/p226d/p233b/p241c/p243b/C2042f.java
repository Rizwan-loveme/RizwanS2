package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2193f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction12x.java */
/* renamed from: org.d.b.c.b.f */
/* loaded from: classes.dex */
public class C2042f extends AbstractC2063c implements InterfaceC2193f {

    /* renamed from: c */
    public static final EnumC2076d f11649c = EnumC2076d.Format12x;

    /* renamed from: d */
    protected final int f11650d;

    /* renamed from: e */
    protected final int f11651e;

    public C2042f(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f11650d = C2388h.m15097a(i);
        this.f11651e = C2388h.m15097a(i2);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11650d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11651e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11649c;
    }
}
