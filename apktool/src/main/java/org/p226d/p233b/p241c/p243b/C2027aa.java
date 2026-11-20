package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2178aa;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction35mi.java */
/* renamed from: org.d.b.c.b.aa */
/* loaded from: classes.dex */
public class C2027aa extends AbstractC2063c implements InterfaceC2178aa {

    /* renamed from: c */
    public static final EnumC2076d f11588c = EnumC2076d.Format35mi;

    /* renamed from: d */
    protected final int f11589d;

    /* renamed from: e */
    protected final int f11590e;

    /* renamed from: f */
    protected final int f11591f;

    /* renamed from: g */
    protected final int f11592g;

    /* renamed from: h */
    protected final int f11593h;

    /* renamed from: i */
    protected final int f11594i;

    /* renamed from: j */
    protected final int f11595j;

    public C2027aa(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(enumC2272f);
        this.f11589d = C2388h.m15109j(i);
        this.f11590e = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f11591f = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f11592g = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f11593h = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f11594i = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f11595j = i7;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11589d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f11590e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f11591f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f11592g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f11593h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f11594i;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2217e
    /* renamed from: f */
    public int mo14482f() {
        return this.f11595j;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11588c;
    }
}
