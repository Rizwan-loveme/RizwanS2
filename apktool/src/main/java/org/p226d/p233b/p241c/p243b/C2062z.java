package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2213z;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction35c.java */
/* renamed from: org.d.b.c.b.z */
/* loaded from: classes.dex */
public class C2062z extends AbstractC2063c implements InterfaceC2213z {

    /* renamed from: c */
    public static final EnumC2076d f11708c = EnumC2076d.Format35c;

    /* renamed from: d */
    protected final int f11709d;

    /* renamed from: e */
    protected final int f11710e;

    /* renamed from: f */
    protected final int f11711f;

    /* renamed from: g */
    protected final int f11712g;

    /* renamed from: h */
    protected final int f11713h;

    /* renamed from: i */
    protected final int f11714i;

    /* renamed from: j */
    protected final InterfaceC2241f f11715j;

    public C2062z(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f11709d = C2388h.m15109j(i);
        this.f11710e = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f11711f = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f11712g = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f11713h = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f11714i = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f11715j = interfaceC2241f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11709d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f11710e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f11711f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f11712g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f11713h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f11714i;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: f */
    public InterfaceC2241f mo14489f() {
        return this.f11715j;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f11716a.f12385eh;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11708c;
    }
}
