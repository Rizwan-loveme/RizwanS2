package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2064d;
import org.p226d.p233b.p241c.C2068h;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2205r;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction22t.java */
/* renamed from: org.d.b.c.b.r */
/* loaded from: classes.dex */
public class C2054r extends AbstractC2064d implements InterfaceC2205r {

    /* renamed from: d */
    public static final EnumC2076d f11686d = EnumC2076d.Format22t;

    /* renamed from: e */
    protected final int f11687e;

    /* renamed from: f */
    protected final int f11688f;

    public C2054r(EnumC2272f enumC2272f, int i, int i2, C2068h c2068h) {
        super(enumC2272f, c2068h);
        this.f11687e = C2388h.m15097a(i);
        this.f11688f = C2388h.m15097a(i2);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11687e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11688f;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11686d;
    }
}
