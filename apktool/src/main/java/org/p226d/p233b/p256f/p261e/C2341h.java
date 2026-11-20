package org.p226d.p233b.p256f.p261e;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p133c.AbstractC1208w;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2247c;
import org.p226d.p233b.p250e.p255d.InterfaceC2248d;
import org.p226d.p233b.p250e.p255d.InterfaceC2249e;
import org.p226d.p233b.p250e.p255d.InterfaceC2250f;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2252h;
import org.p226d.p233b.p250e.p255d.InterfaceC2253i;
import org.p226d.p233b.p250e.p255d.InterfaceC2254j;
import org.p226d.p233b.p250e.p255d.InterfaceC2255k;
import org.p226d.p233b.p250e.p255d.InterfaceC2256l;
import org.p226d.p233b.p250e.p255d.InterfaceC2257m;
import org.p226d.p233b.p250e.p255d.InterfaceC2258n;
import org.p226d.p233b.p250e.p255d.InterfaceC2259o;
import org.p226d.p233b.p250e.p255d.InterfaceC2261q;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;
import org.p226d.p233b.p250e.p255d.InterfaceC2263s;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2453g;

/* compiled from: ImmutableEncodedValueFactory.java */
/* renamed from: org.d.b.f.e.h */
/* loaded from: classes.dex */
public class C2341h {

    /* renamed from: a */
    private static final AbstractC2455i<InterfaceC2340g, InterfaceC2251g> f12595a = new AbstractC2455i<InterfaceC2340g, InterfaceC2251g>() { // from class: org.d.b.f.e.h.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2251g interfaceC2251g) {
            return interfaceC2251g instanceof InterfaceC2340g;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC2340g mo14889a(InterfaceC2251g interfaceC2251g) {
            return C2341h.m14986a(interfaceC2251g);
        }
    };

    /* renamed from: a */
    public static InterfaceC2340g m14986a(InterfaceC2251g interfaceC2251g) {
        switch (interfaceC2251g.mo14430a()) {
            case 0:
                return C2337d.m14981a((InterfaceC2248d) interfaceC2251g);
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            default:
                C1120o.m9550a(false);
                return null;
            case 2:
                return C2351r.m15001a((InterfaceC2261q) interfaceC2251g);
            case 3:
                return C2338e.m14982a((InterfaceC2249e) interfaceC2251g);
            case 4:
                return C2345l.m14993a((InterfaceC2255k) interfaceC2251g);
            case 6:
                return C2346m.m14994a((InterfaceC2256l) interfaceC2251g);
            case 16:
                return C2344k.m14992a((InterfaceC2254j) interfaceC2251g);
            case 17:
                return C2339f.m14983a((InterfaceC2250f) interfaceC2251g);
            case 21:
                return C2349p.m14999a((InterfaceC2259o) interfaceC2251g);
            case 22:
                return C2348o.m14997a((InterfaceC2258n) interfaceC2251g);
            case 23:
                return C2352s.m15002a((InterfaceC2262r) interfaceC2251g);
            case 24:
                return C2353t.m15003a((InterfaceC2263s) interfaceC2251g);
            case 25:
                return C2343j.m14990a((InterfaceC2253i) interfaceC2251g);
            case 26:
                return C2347n.m14995a((InterfaceC2257m) interfaceC2251g);
            case 27:
                return C2342i.m14988a((InterfaceC2252h) interfaceC2251g);
            case 28:
                return C2335b.m14977a((InterfaceC2246b) interfaceC2251g);
            case 29:
                return C2334a.m14975a((InterfaceC2245a) interfaceC2251g);
            case 30:
                return C2350q.f12604a;
            case 31:
                return C2336c.m14979a((InterfaceC2247c) interfaceC2251g);
        }
    }

    /* renamed from: a */
    public static InterfaceC2251g m14985a(String str) {
        switch (str.charAt(0)) {
            case 'B':
                return new C2337d((byte) 0);
            case 'C':
                return new C2338e((char) 0);
            case 'D':
                return new C2339f(0.0d);
            case 'F':
                return new C2344k(0.0f);
            case 'I':
                return new C2345l(0);
            case 'J':
                return new C2346m(0L);
            case 'L':
            case '[':
                return C2350q.f12604a;
            case 'S':
                return new C2351r((short) 0);
            case 'Z':
                return C2336c.f12590b;
            default:
                throw new C2453g("Unrecognized type: %s", str);
        }
    }

    /* renamed from: b */
    public static InterfaceC2340g m14987b(InterfaceC2251g interfaceC2251g) {
        if (interfaceC2251g == null) {
            return null;
        }
        return m14986a(interfaceC2251g);
    }

    /* renamed from: a */
    public static AbstractC1208w<InterfaceC2340g> m14984a(Iterable<? extends InterfaceC2251g> iterable) {
        return f12595a.m15525a(iterable);
    }
}
