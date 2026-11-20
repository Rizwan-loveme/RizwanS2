package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2192e;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction11x.java */
/* renamed from: org.d.b.c.b.e */
/* loaded from: classes.dex */
public class C2041e extends AbstractC2063c implements InterfaceC2192e {

    /* renamed from: c */
    public static final EnumC2076d f11647c = EnumC2076d.Format11x;

    /* renamed from: d */
    protected final int f11648d;

    public C2041e(EnumC2272f enumC2272f, int i) {
        super(enumC2272f);
        this.f11648d = C2388h.m15101b(i);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11648d;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11647c;
    }
}
