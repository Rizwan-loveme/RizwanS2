package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2183af;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction45cc.java */
/* renamed from: org.d.b.c.b.af */
/* loaded from: classes.dex */
public class C2032af extends AbstractC2063c implements InterfaceC2183af {

    /* renamed from: c */
    public static final EnumC2076d f11616c = EnumC2076d.Format45cc;

    /* renamed from: d */
    protected final int f11617d;

    /* renamed from: e */
    protected final int f11618e;

    /* renamed from: f */
    protected final int f11619f;

    /* renamed from: g */
    protected final int f11620g;

    /* renamed from: h */
    protected final int f11621h;

    /* renamed from: i */
    protected final int f11622i;

    /* renamed from: j */
    protected final InterfaceC2241f f11623j;

    /* renamed from: k */
    protected final InterfaceC2241f f11624k;

    public C2032af(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, InterfaceC2241f interfaceC2241f, InterfaceC2241f interfaceC2241f2) {
        super(enumC2272f);
        this.f11617d = C2388h.m15109j(i);
        this.f11618e = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f11619f = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f11620g = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f11621h = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f11622i = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f11623j = interfaceC2241f;
        this.f11624k = interfaceC2241f2;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11617d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f11618e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f11619f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f11620g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f11621h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f11622i;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11623j;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f11716a.f12385eh;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2176a
    /* renamed from: m */
    public InterfaceC2241f mo14492m() {
        return this.f11624k;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2176a
    /* renamed from: n */
    public int mo14493n() {
        return this.f11716a.f12388ek;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11616c;
    }
}
