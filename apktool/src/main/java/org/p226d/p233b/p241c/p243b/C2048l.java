package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2199l;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction21s.java */
/* renamed from: org.d.b.c.b.l */
/* loaded from: classes.dex */
public class C2048l extends AbstractC2063c implements InterfaceC2199l {

    /* renamed from: c */
    public static final EnumC2076d f11665c = EnumC2076d.Format21s;

    /* renamed from: d */
    protected final int f11666d;

    /* renamed from: e */
    protected final int f11667e;

    public C2048l(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f11666d = C2388h.m15101b(i);
        this.f11667e = C2388h.m15105f(i2);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11666d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f11667e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11667e;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11665c;
    }
}
