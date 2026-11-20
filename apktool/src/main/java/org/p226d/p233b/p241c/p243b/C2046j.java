package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2197j;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction21ih.java */
/* renamed from: org.d.b.c.b.j */
/* loaded from: classes.dex */
public class C2046j extends AbstractC2063c implements InterfaceC2197j {

    /* renamed from: c */
    public static final EnumC2076d f11659c = EnumC2076d.Format21ih;

    /* renamed from: d */
    protected final int f11660d;

    /* renamed from: e */
    protected final int f11661e;

    public C2046j(EnumC2272f enumC2272f, int i, int i2) {
        super(enumC2272f);
        this.f11660d = C2388h.m15101b(i);
        this.f11661e = C2388h.m15106g(i2);
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11660d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2221i
    /* renamed from: f */
    public int mo14499f() {
        return this.f11661e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2234v
    /* renamed from: g */
    public long mo14494g() {
        return this.f11661e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2216d
    /* renamed from: h */
    public short mo14502h() {
        return (short) (this.f11661e >>> 16);
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11659c;
    }
}
