package org.p226d.p233b.p256f.p258b;

import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2213z;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p256f.p259c.C2327g;
import org.p226d.p233b.p256f.p259c.InterfaceC2326f;
import org.p226d.p233b.p263h.C2388h;

/* compiled from: ImmutableInstruction35c.java */
/* renamed from: org.d.b.f.b.aa */
/* loaded from: classes.dex */
public class C2284aa extends AbstractC2295b implements InterfaceC2213z {

    /* renamed from: a */
    public static final EnumC2076d f12422a = EnumC2076d.Format35c;

    /* renamed from: b */
    protected final int f12423b;

    /* renamed from: c */
    protected final int f12424c;

    /* renamed from: e */
    protected final int f12425e;

    /* renamed from: f */
    protected final int f12426f;

    /* renamed from: g */
    protected final int f12427g;

    /* renamed from: h */
    protected final int f12428h;

    /* renamed from: i */
    protected final InterfaceC2326f f12429i;

    public C2284aa(EnumC2272f enumC2272f, int i, int i2, int i3, int i4, int i5, int i6, InterfaceC2241f interfaceC2241f) {
        super(enumC2272f);
        this.f12423b = C2388h.m15109j(i);
        this.f12424c = i > 0 ? C2388h.m15097a(i2) : 0;
        this.f12425e = i > 1 ? C2388h.m15097a(i3) : 0;
        this.f12426f = i > 2 ? C2388h.m15097a(i4) : 0;
        this.f12427g = i > 3 ? C2388h.m15097a(i5) : 0;
        this.f12428h = i > 4 ? C2388h.m15097a(i6) : 0;
        this.f12429i = C2327g.m14964a(enumC2272f.f12385eh, interfaceC2241f);
    }

    /* renamed from: a */
    public static C2284aa m14904a(InterfaceC2213z interfaceC2213z) {
        if (interfaceC2213z instanceof C2284aa) {
            return (C2284aa) interfaceC2213z;
        }
        return new C2284aa(interfaceC2213z.mo14416a(), interfaceC2213z.mo14481e(), interfaceC2213z.mo14483h(), interfaceC2213z.mo14484i(), interfaceC2213z.mo14485j(), interfaceC2213z.mo14486k(), interfaceC2213z.mo14487l(), interfaceC2213z.mo14489f());
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
    /* renamed from: e */
    public int mo14481e() {
        return this.f12423b;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: h */
    public int mo14483h() {
        return this.f12424c;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: i */
    public int mo14484i() {
        return this.f12425e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: j */
    public int mo14485j() {
        return this.f12426f;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: k */
    public int mo14486k() {
        return this.f12427g;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
    /* renamed from: l */
    public int mo14487l() {
        return this.f12428h;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public InterfaceC2326f mo14489f() {
        return this.f12429i;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
    /* renamed from: g */
    public int mo14490g() {
        return this.f12471d.f12385eh;
    }

    @Override // org.p226d.p233b.p256f.p258b.AbstractC2295b
    /* renamed from: c */
    public EnumC2076d mo14903c() {
        return f12422a;
    }
}
