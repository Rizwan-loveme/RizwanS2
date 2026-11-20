package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2201n;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction22b.java */
/* renamed from: org.d.b.c.b.n */
/* loaded from: classes.dex */
public class C2050n extends AbstractC2063c implements InterfaceC2201n {

    /* renamed from: c */
    public static final EnumC2076d f11670c = EnumC2076d.Format22b;

    /* renamed from: d */
    protected final int f11671d;

    /* renamed from: e */
    protected final int f11672e;

    /* renamed from: f */
    protected final int f11673f;

    public C2050n(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f11671d = C2388h.m15101b(i);
        this.f11672e = C2388h.m15101b(i2);
        this.f11673f = C2388h.m15104e(i3);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11671d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11672e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f11673f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11673f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11670c;
    }
}
