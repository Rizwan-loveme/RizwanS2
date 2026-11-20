package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2179ab;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction35ms.java */
/* renamed from: org.d.b.f.b.ac */
/* loaded from: classes.dex */
public class C2286ac extends AbstractC2295b implements InterfaceC2179ab {

    /* renamed from: a */
    public static final EnumC2076d f12438a = EnumC2076d.Format35ms;

    /* renamed from: b */
    protected final int f12439b;

    /* renamed from: c */
    protected final int f12440c;

    /* renamed from: e */
    protected final int f12441e;

    /* renamed from: f */
    protected final int f12442f;

    /* renamed from: g */
    protected final int f12443g;

    /* renamed from: h */
    protected final int f12444h;

    /* renamed from: i */
    protected final int f12445i;

    public C2286ac(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(enumC2272f);
        this.f12439b = C2388h.m15109j(i);
        this.f12440c = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f12441e = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f12442f = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f12443g = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f12444h = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f12445i = C2388h.m15112m(i7);
    }

    /* renamed from: a */
    public static C2286ac m14907a(InterfaceC2179ab interfaceC2179ab) {
        if (interfaceC2179ab instanceof C2286ac) {
            return (C2286ac) interfaceC2179ab;
        }
        return new C2286ac(interfaceC2179ab.mo14416a(), interfaceC2179ab.mo14481e(), interfaceC2179ab.mo14483h(), interfaceC2179ab.mo14484i(), interfaceC2179ab.mo14485j(), interfaceC2179ab.mo14486k(), interfaceC2179ab.mo14487l(), interfaceC2179ab.mo14488f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f12439b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f12440c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f12441e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f12442f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f12443g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f12444h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2233u
    /* renamed from: f */
    public int mo14488f() {
        return this.f12445i;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12438a;
    }
}
