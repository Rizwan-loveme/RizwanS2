package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2206s;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction22x.java */
/* renamed from: org.d.b.c.b.s */
/* loaded from: classes.dex */
public class C2055s extends AbstractC2063c implements InterfaceC2206s {

    /* renamed from: c */
    public static final EnumC2076d f11689c = EnumC2076d.Format22x;

    /* renamed from: d */
    protected final int f11690d;

    /* renamed from: e */
    protected final int f11691e;

    public C2055s(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f11690d = C2388h.m15101b(i);
        this.f11691e = C2388h.m15102c(i2);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11690d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
    /* renamed from: r_ */
    public int mo14500r_() {
        return this.f11691e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11689c;
    }
}
