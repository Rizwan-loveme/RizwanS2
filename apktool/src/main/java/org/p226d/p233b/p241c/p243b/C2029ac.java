package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2180ac;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction3rc.java */
/* renamed from: org.d.b.c.b.ac */
/* loaded from: classes.dex */
public class C2029ac extends AbstractC2063c implements InterfaceC2180ac {

    /* renamed from: c */
    public static final EnumC2076d f11604c = EnumC2076d.Format3rc;

    /* renamed from: d */
    protected final int f11605d;

    /* renamed from: e */
    protected final int f11606e;

    /* renamed from: f */
    protected final InterfaceC2241f f11607f;

    public C2029ac(EnumC2272f enumC2272f, int i, int i2, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f11605d = C2388h.m15102c(i);
        this.f11606e = C2388h.m15110k(i2);
        this.f11607f = interfaceC2241f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f11605d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11606e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11607f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f11716a.f12385eh;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11604c;
    }
}
