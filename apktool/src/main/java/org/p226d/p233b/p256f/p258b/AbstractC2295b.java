package org.p226d.p233b.p256f.p258b;

import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2178aa;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2179ab;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2180ac;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2181ad;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2182ae;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2185ah;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2186ai;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2188ak;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2189b;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2190c;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2191d;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2192e;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2193f;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2194g;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2195h;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2196i;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2197j;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2198k;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2199l;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2200m;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2201n;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2202o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2203p;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2204q;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2205r;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2206s;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2207t;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2208u;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2209v;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2210w;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2211x;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2212y;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2213z;
import org.p226d.p233b.p263h.C2388h;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: ImmutableInstruction.java */
/* renamed from: org.d.b.f.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC2295b implements InterfaceC2218f {

    /* renamed from: a */
    private static final AbstractC2455i<AbstractC2295b, InterfaceC2218f> f12470a = new AbstractC2455i<AbstractC2295b, InterfaceC2218f>() { // from class: org.d.b.f.b.b.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2218f interfaceC2218f) {
            return interfaceC2218f instanceof AbstractC2295b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public AbstractC2295b mo14889a(InterfaceC2218f interfaceC2218f) {
            return AbstractC2295b.m14919a(interfaceC2218f);
        }
    };

    /* renamed from: d */
    protected final EnumC2272f f12471d;

    /* renamed from: c */
    public abstract EnumC2076d mo14903c();

    protected AbstractC2295b(EnumC2272f enumC2272f) {
        C2388h.m15100a(enumC2272f, mo14903c());
        this.f12471d = enumC2272f;
    }

    /* renamed from: a */
    public static AbstractC2295b m14919a(InterfaceC2218f interfaceC2218f) {
        if (interfaceC2218f instanceof AbstractC2295b) {
            return (AbstractC2295b) interfaceC2218f;
        }
        switch (interfaceC2218f.mo14416a().f12386ei) {
            case Format10t:
                return C2296c.m14920a((InterfaceC2189b) interfaceC2218f);
            case Format10x:
                if (interfaceC2218f instanceof InterfaceC2188ak) {
                    return C2294ak.m14917a((InterfaceC2188ak) interfaceC2218f);
                }
                return C2297d.m14921a((InterfaceC2190c) interfaceC2218f);
            case Format11n:
                return C2298e.m14922a((InterfaceC2191d) interfaceC2218f);
            case Format11x:
                return C2299f.m14923a((InterfaceC2192e) interfaceC2218f);
            case Format12x:
                return C2300g.m14924a((InterfaceC2193f) interfaceC2218f);
            case Format20bc:
                return C2301h.m14925a((InterfaceC2194g) interfaceC2218f);
            case Format20t:
                return C2302i.m14927a((InterfaceC2195h) interfaceC2218f);
            case Format21c:
                return C2303j.m14928a((InterfaceC2196i) interfaceC2218f);
            case Format21ih:
                return C2304k.m14930a((InterfaceC2197j) interfaceC2218f);
            case Format21lh:
                return C2305l.m14931a((InterfaceC2198k) interfaceC2218f);
            case Format21s:
                return C2306m.m14932a((InterfaceC2199l) interfaceC2218f);
            case Format21t:
                return C2307n.m14933a((InterfaceC2200m) interfaceC2218f);
            case Format22b:
                return C2308o.m14934a((InterfaceC2201n) interfaceC2218f);
            case Format22c:
                return C2309p.m14935a((InterfaceC2202o) interfaceC2218f);
            case Format22cs:
                return C2310q.m14937a((InterfaceC2203p) interfaceC2218f);
            case Format22s:
                return C2311r.m14938a((InterfaceC2204q) interfaceC2218f);
            case Format22t:
                return C2312s.m14939a((InterfaceC2205r) interfaceC2218f);
            case Format22x:
                return C2313t.m14940a((InterfaceC2206s) interfaceC2218f);
            case Format23x:
                return C2314u.m14941a((InterfaceC2207t) interfaceC2218f);
            case Format30t:
                return C2315v.m14942a((InterfaceC2208u) interfaceC2218f);
            case Format31c:
                return C2316w.m14943a((InterfaceC2209v) interfaceC2218f);
            case Format31i:
                return C2317x.m14945a((InterfaceC2210w) interfaceC2218f);
            case Format31t:
                return C2318y.m14946a((InterfaceC2211x) interfaceC2218f);
            case Format32x:
                return C2319z.m14947a((InterfaceC2212y) interfaceC2218f);
            case Format35c:
                return C2284aa.m14904a((InterfaceC2213z) interfaceC2218f);
            case Format35mi:
                return C2285ab.m14906a((InterfaceC2178aa) interfaceC2218f);
            case Format35ms:
                return C2286ac.m14907a((InterfaceC2179ab) interfaceC2218f);
            case Format3rc:
                return C2287ad.m14908a((InterfaceC2180ac) interfaceC2218f);
            case Format3rmi:
                return C2288ae.m14910a((InterfaceC2181ad) interfaceC2218f);
            case Format3rms:
                return C2289af.m14911a((InterfaceC2182ae) interfaceC2218f);
            case Format51l:
                return C2290ag.m14912a((InterfaceC2185ah) interfaceC2218f);
            case PackedSwitchPayload:
                return C2291ah.m14913a((InterfaceC2186ai) interfaceC2218f);
            case SparseSwitchPayload:
                return C2292ai.m14914a((InterfaceC2187aj) interfaceC2218f);
            case ArrayPayload:
                return C2283a.m14902a((InterfaceC2177a) interfaceC2218f);
            default:
                throw new RuntimeException("Unexpected instruction type");
        }
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: a */
    public EnumC2272f mo14416a() {
        return this.f12471d;
    }

    @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return mo14903c().f11799L / 2;
    }

    /* renamed from: a */
    public static AbstractC1208w<AbstractC2295b> m14918a(Iterable<? extends InterfaceC2218f> iterable) {
        return f12470a.m15525a(iterable);
    }
}
