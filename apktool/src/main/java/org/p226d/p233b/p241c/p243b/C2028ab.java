package org.p226d.p233b.p241c.p243b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p241c.AbstractC2063c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2179ab;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: BuilderInstruction35ms.java */
/* renamed from: org.d.b.c.b.ab */
/* loaded from: classes.dex */
public class C2028ab extends AbstractC2063c implements InterfaceC2179ab {

    /* renamed from: c */
    public static final EnumC2076d f11596c = EnumC2076d.Format35ms;

    /* renamed from: d */
    protected final int f11597d;

    /* renamed from: e */
    protected final int f11598e;

    /* renamed from: f */
    protected final int f11599f;

    /* renamed from: g */
    protected final int f11600g;

    /* renamed from: h */
    protected final int f11601h;

    /* renamed from: i */
    protected final int f11602i;

    /* renamed from: j */
    protected final int f11603j;

    public C2028ab(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(enumC2272f);
        this.f11597d = C2388h.m15109j(i);
        this.f11598e = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f11599f = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f11600g = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f11601h = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f11602i = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f11603j = i7;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f11597d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f11598e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f11599f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f11600g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f11601h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f11602i;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2233u
    /* renamed from: f */
    public int mo14488f() {
        return this.f11603j;
    }

    @Override // org.p226d.p233b.p241c.AbstractC2063c
    /* renamed from: c */
    public EnumC2076d mo14478c() {
        return f11596c;
    }
}
