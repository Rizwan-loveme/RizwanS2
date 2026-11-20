package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2184ag;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction4rcc.java */
/* renamed from: org.d.b.c.b.ag */
/* loaded from: classes.dex */
public class C2033ag extends AbstractC2063c implements InterfaceC2184ag {

    /* renamed from: c */
    public static final EnumC2076d f11625c = EnumC2076d.Format4rcc;

    /* renamed from: d */
    protected final int f11626d;

    /* renamed from: e */
    protected final int f11627e;

    /* renamed from: f */
    protected final InterfaceC2241f f11628f;

    /* renamed from: g */
    protected final InterfaceC2241f f11629g;

    public C2033ag(EnumC2272f enumC2272f, int i, int i2, InterfaceC2241f interfaceC2241f, InterfaceC2241f interfaceC2241f2) {
        super(enumC2272f);
        this.f11626d = C2388h.m15102c(i);
        this.f11627e = C2388h.m15110k(i2);
        this.f11628f = interfaceC2241f;
        this.f11629g = interfaceC2241f2;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
    /* renamed from: h */
    public int mo14491h() {
        return this.f11626d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11627e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11628f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f11716a.f12385eh;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2176a
    /* renamed from: m */
    public InterfaceC2241f mo14492m() {
        return this.f11629g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2176a
    /* renamed from: n */
    public int mo14493n() {
        return this.f11716a.f12388ek;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11625c;
    }
}
