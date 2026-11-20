package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2198k;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction21lh.java */
/* renamed from: org.d.b.c.b.k */
/* loaded from: classes.dex */
public class C2047k extends AbstractC2063c implements InterfaceC2198k {

    /* renamed from: c */
    public static final EnumC2076d f11662c = EnumC2076d.Format21lh;

    /* renamed from: d */
    protected final int f11663d;

    /* renamed from: e */
    protected final long f11664e;

    public C2047k(EnumC2272f enumC2272f, int i, long j) {
        super(enumC2272f);
        this.f11663d = C2388h.m15101b(i);
        this.f11664e = C2388h.m15098a(j);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11663d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11664e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2216d
    /* renamed from: h */
    public short mo14502h() {
        return (short) (this.f11664e >>> 48);
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11662c;
    }
}
