package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2064d;
import org.p226d.p233b.p241c.C2068h;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2211x;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction31t.java */
/* renamed from: org.d.b.c.b.x */
/* loaded from: classes.dex */
public class C2060x extends AbstractC2064d implements InterfaceC2211x {

    /* renamed from: d */
    public static final EnumC2076d f11703d = EnumC2076d.Format31t;

    /* renamed from: e */
    protected final int f11704e;

    public C2060x(EnumC2272f enumC2272f, int i, C2068h c2068h) {
        super(enumC2272f, c2068h);
        this.f11704e = C2388h.m15101b(i);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11704e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11703d;
    }
}
