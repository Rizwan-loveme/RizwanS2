package org.p226d.p233b.p244d.p245a;

import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedInstruction.java */
/* renamed from: org.d.b.d.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC2091b implements InterfaceC2218f {

    /* renamed from: d */
    public final C2153g f11824d;

    /* renamed from: e */
    public final EnumC2272f f11825e;

    /* renamed from: f */
    public final int f11826f;

    public AbstractC2091b(C2153g c2153g, EnumC2272f enumC2272f, int i) {
        this.f11824d = c2153g;
        this.f11825e = enumC2272f;
        this.f11826f = i;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: a */
    public EnumC2272f mo14416a() {
        return this.f11825e;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return this.f11825e.f12386ei.f11799L / 2;
    }

    /* renamed from: a */
    public static InterfaceC2218f m14633a(C2161o c2161o) {
        int h = c2161o.m14649h();
        AbstractC2091b m14632a = m14632a((C2153g) c2161o.f11828a, ((C2153g) c2161o.f11828a).mo14767a().m15029d(h == 0 ? c2161o.m14647g() : h), c2161o.m14635a());
        c2161o.m14638b(m14632a.mo14417b() * 2);
        return m14632a;
    }

    /* renamed from: a */
    private static AbstractC2091b m14632a(C2153g c2153g, EnumC2272f enumC2272f, int i) {
        if (enumC2272f == null) {
            return new C2090al(c2153g, i);
        }
        switch (enumC2272f.f12386ei) {
            case Format10t:
                return new C2092c(c2153g, enumC2272f, i);
            case Format10x:
                return new C2093d(c2153g, enumC2272f, i);
            case Format11n:
                return new C2094e(c2153g, enumC2272f, i);
            case Format11x:
                return new C2095f(c2153g, enumC2272f, i);
            case Format12x:
                return new C2096g(c2153g, enumC2272f, i);
            case Format20bc:
                return new C2097h(c2153g, enumC2272f, i);
            case Format20t:
                return new C2098i(c2153g, enumC2272f, i);
            case Format21c:
                return new C2099j(c2153g, enumC2272f, i);
            case Format21ih:
                return new C2100k(c2153g, enumC2272f, i);
            case Format21lh:
                return new C2101l(c2153g, enumC2272f, i);
            case Format21s:
                return new C2102m(c2153g, enumC2272f, i);
            case Format21t:
                return new C2103n(c2153g, enumC2272f, i);
            case Format22b:
                return new C2104o(c2153g, enumC2272f, i);
            case Format22c:
                return new C2105p(c2153g, enumC2272f, i);
            case Format22cs:
                return new C2106q(c2153g, enumC2272f, i);
            case Format22s:
                return new C2107r(c2153g, enumC2272f, i);
            case Format22t:
                return new C2108s(c2153g, enumC2272f, i);
            case Format22x:
                return new C2109t(c2153g, enumC2272f, i);
            case Format23x:
                return new C2110u(c2153g, enumC2272f, i);
            case Format30t:
                return new C2111v(c2153g, enumC2272f, i);
            case Format31c:
                return new C2112w(c2153g, enumC2272f, i);
            case Format31i:
                return new C2113x(c2153g, enumC2272f, i);
            case Format31t:
                return new C2114y(c2153g, enumC2272f, i);
            case Format32x:
                return new C2115z(c2153g, enumC2272f, i);
            case Format35c:
                return new C2079aa(c2153g, enumC2272f, i);
            case Format35ms:
                return new C2081ac(c2153g, enumC2272f, i);
            case Format35mi:
                return new C2080ab(c2153g, enumC2272f, i);
            case Format3rc:
                return new C2082ad(c2153g, enumC2272f, i);
            case Format3rmi:
                return new C2083ae(c2153g, enumC2272f, i);
            case Format3rms:
                return new C2084af(c2153g, enumC2272f, i);
            case Format45cc:
                return new C2085ag(c2153g, enumC2272f, i);
            case Format4rcc:
                return new C2086ah(c2153g, enumC2272f, i);
            case Format51l:
                return new C2087ai(c2153g, enumC2272f, i);
            case PackedSwitchPayload:
                return new C2088aj(c2153g, i);
            case SparseSwitchPayload:
                return new C2089ak(c2153g, i);
            case ArrayPayload:
                return new C2078a(c2153g, i);
            default:
                throw new C2453g("Unexpected opcode format: %s", enumC2272f.f12386ei.toString());
        }
    }
}
