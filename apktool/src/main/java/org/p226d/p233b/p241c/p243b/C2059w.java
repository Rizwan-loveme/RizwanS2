package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2210w;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction31i.java */
/* renamed from: org.d.b.c.b.w */
/* loaded from: classes.dex */
public class C2059w extends AbstractC2063c implements InterfaceC2210w {

    /* renamed from: c */
    public static final EnumC2076d f11700c = EnumC2076d.Format31i;

    /* renamed from: d */
    protected final int f11701d;

    /* renamed from: e */
    protected final int f11702e;

    public C2059w(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f11701d = C2388h.m15101b(i);
        this.f11702e = i2;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11701d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f11702e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11702e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11700c;
    }
}
