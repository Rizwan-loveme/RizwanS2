package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2178aa;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction35mi.java */
/* renamed from: org.d.b.f.b.ab */
/* loaded from: classes.dex */
public class C2285ab extends AbstractC2295b implements InterfaceC2178aa {

    /* renamed from: a */
    public static final EnumC2076d f12430a = EnumC2076d.Format35mi;

    /* renamed from: b */
    protected final int f12431b;

    /* renamed from: c */
    protected final int f12432c;

    /* renamed from: e */
    protected final int f12433e;

    /* renamed from: f */
    protected final int f12434f;

    /* renamed from: g */
    protected final int f12435g;

    /* renamed from: h */
    protected final int f12436h;

    /* renamed from: i */
    protected final int f12437i;

    public C2285ab(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(enumC2272f);
        this.f12431b = C2388h.m15109j(i);
        this.f12432c = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f12433e = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f12434f = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f12435g = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f12436h = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f12437i = C2388h.m15113n(i7);
    }

    /* renamed from: a */
    public static C2285ab m14906a(InterfaceC2178aa interfaceC2178aa) {
        if (interfaceC2178aa instanceof C2285ab) {
            return (C2285ab) interfaceC2178aa;
        }
        return new C2285ab(interfaceC2178aa.mo14416a(), interfaceC2178aa.mo14481e(), interfaceC2178aa.mo14483h(), interfaceC2178aa.mo14484i(), interfaceC2178aa.mo14485j(), interfaceC2178aa.mo14486k(), interfaceC2178aa.mo14487l(), interfaceC2178aa.mo14482f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f12431b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f12432c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f12433e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f12434f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f12435g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f12436h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2217e
    /* renamed from: f */
    public int mo14482f() {
        return this.f12437i;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12430a;
    }
}
