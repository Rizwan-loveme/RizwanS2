package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2204q;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction22s.java */
/* renamed from: org.d.b.c.b.q */
/* loaded from: classes.dex */
public class C2053q extends AbstractC2063c implements InterfaceC2204q {

    /* renamed from: c */
    public static final EnumC2076d f11682c = EnumC2076d.Format22s;

    /* renamed from: d */
    protected final int f11683d;

    /* renamed from: e */
    protected final int f11684e;

    /* renamed from: f */
    protected final int f11685f;

    public C2053q(EnumC2272f enumC2272f, int i, int i2, int i3) {
        super(enumC2272f);
        this.f11683d = C2388h.m15097a(i);
        this.f11684e = C2388h.m15097a(i2);
        this.f11685f = C2388h.m15105f(i3);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11683d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11684e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f11685f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11685f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11682c;
    }
}
