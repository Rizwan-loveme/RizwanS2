package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2209v;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction31c.java */
/* renamed from: org.d.b.c.b.v */
/* loaded from: classes.dex */
public class C2058v extends AbstractC2063c implements InterfaceC2209v {

    /* renamed from: c */
    public static final EnumC2076d f11697c = EnumC2076d.Format31c;

    /* renamed from: d */
    protected final int f11698d;

    /* renamed from: e */
    protected final InterfaceC2241f f11699e;

    public C2058v(EnumC2272f enumC2272f, int i, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f11698d = C2388h.m15101b(i);
        this.f11699e = interfaceC2241f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
    /* renamed from: q_ */
    public int mo14495q_() {
        return this.f11698d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11699e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f11716a.f12385eh;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11697c;
    }
}
