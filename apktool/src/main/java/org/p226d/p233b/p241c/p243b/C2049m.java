package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2064d;
import org.p226d.p233b.p241c.C2068h;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2200m;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction21t.java */
/* renamed from: org.d.b.c.b.m */
/* loaded from: classes.dex */
public class C2049m extends AbstractC2064d implements InterfaceC2200m {

    /* renamed from: d */
    public static final EnumC2076d f11668d = EnumC2076d.Format21t;

    /* renamed from: e */
    protected final int f11669e;

    public C2049m(EnumC2272f enumC2272f, int i, C2068h c2068h) {
        super(enumC2272f, c2068h);
        this.f11669e = C2388h.m15101b(i);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11669e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11668d;
    }
}
