package org.p226d.p233b.p264i.p266b;

import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import com.p129f.p130a.p133c.AbstractC1163ap;
import com.p129f.p130a.p133c.AbstractC1203r;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1153af;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.p226d.p233b.p241c.C2074n;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p233b.p250e.p251a.InterfaceC2169d;
import org.p226d.p233b.p250e.p251a.InterfaceC2172g;
import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p233b.p264i.C2428e;
import org.p226d.p233b.p264i.InterfaceC2427d;
import org.p226d.p233b.p264i.p266b.C2421u;
import org.p226d.p233b.p264i.p267c.C2425b;
import org.p226d.p269d.AbstractC2447a;
import org.p226d.p269d.C2453g;

/* compiled from: ClassPool.java */
/* renamed from: org.d.b.i.b.h */
/* loaded from: classes.dex */
public class C2408h extends C2406f<String, C2415o> implements InterfaceC2427d<CharSequence, CharSequence, C2421u.a<? extends Collection<? extends CharSequence>>, C2415o, InterfaceC2266g, C2416p, Set<? extends InterfaceC2165a>, InterfaceC2246b> {

    /* renamed from: d */
    private static final InterfaceC1121p<InterfaceC2269j> f12768d = new InterfaceC1121p<InterfaceC2269j>() { // from class: org.d.b.i.b.h.2
        @Override // com.p129f.p130a.p131a.InterfaceC1121p
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo9509a(InterfaceC2269j interfaceC2269j) {
            return interfaceC2269j.mo14219a().size() > 0;
        }
    };

    /* renamed from: e */
    private static final InterfaceC1112g<InterfaceC2269j, Set<? extends InterfaceC2165a>> f12769e = new InterfaceC1112g<InterfaceC2269j, Set<? extends InterfaceC2165a>>() { // from class: org.d.b.i.b.h.3
        @Override // com.p129f.p130a.p131a.InterfaceC1112g
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Set<? extends InterfaceC2165a> mo9517a(InterfaceC2269j interfaceC2269j) {
            return interfaceC2269j.mo14219a();
        }
    };

    /* renamed from: c */
    private AbstractC1208w<C2415o> f12770c;

    public C2408h(C2409i c2409i) {
        super(c2409i);
        this.f12770c = null;
    }

    /* renamed from: a */
    public void m15196a(InterfaceC2244d interfaceC2244d) {
        C2415o c2415o = new C2415o(interfaceC2244d);
        if (((C2415o) this.f12766b.put(c2415o.mo14205l(), c2415o)) != null) {
            throw new C2453g("Class %s has already been interned", c2415o.mo14205l());
        }
        ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) c2415o.mo14205l());
        ((C2422v) this.f12765a.f12827A).b2((CharSequence) c2415o.mo14195b());
        ((C2421u) this.f12765a.f12834H).m15317a((Collection<? extends CharSequence>) c2415o.mo14196c());
        ((C2419s) this.f12765a.f12865z).m15312b(c2415o.mo14197d());
        HashSet hashSet = new HashSet();
        for (InterfaceC2266g interfaceC2266g : c2415o.mo14207n()) {
            String m15131b = C2389i.m15131b(interfaceC2266g);
            if (!hashSet.add(m15131b)) {
                throw new C2453g("Multiple definitions for field %s->%s", c2415o.mo14205l(), m15131b);
            }
            ((C2411k) this.f12765a.f12829C).m15283d((InterfaceC2237b) interfaceC2266g);
            InterfaceC2251g mo14223b = interfaceC2266g.mo14223b();
            if (mo14223b != null) {
                this.f12765a.m15248a(mo14223b);
            }
            ((C2402b) this.f12765a.f12836J).a2(interfaceC2266g.mo14224c());
            InterfaceC2246b mo15211f = mo15211f(c2415o);
            if (mo15211f != null) {
                ((C2410j) this.f12765a.f12837K).a2(mo15211f);
            }
        }
        HashSet hashSet2 = new HashSet();
        for (C2416p c2416p : c2415o.mo14206m()) {
            String m15121a = C2389i.m15121a((InterfaceC2240e) c2416p, true);
            if (!hashSet2.add(m15121a)) {
                throw new C2453g("Multiple definitions for method %s->%s", c2415o.mo14205l(), m15121a);
            }
            ((C2414n) this.f12765a.f12830D).m15296d((InterfaceC2240e) c2416p);
            m15185a((InterfaceC2267h) c2416p);
            m15186b((InterfaceC2267h) c2416p);
            ((C2402b) this.f12765a.f12836J).a2(c2416p.mo14215g());
            Iterator<? extends InterfaceC2269j> it = c2416p.mo14213e().iterator();
            while (it.hasNext()) {
                ((C2402b) this.f12765a.f12836J).a2(it.next().mo14219a());
            }
        }
        ((C2402b) this.f12765a.f12836J).a2(c2415o.mo14198e());
    }

    /* renamed from: a */
    private void m15185a(InterfaceC2267h interfaceC2267h) {
        InterfaceC2268i mo14216h = interfaceC2267h.mo14216h();
        if (mo14216h != null) {
            boolean z = false;
            for (InterfaceC2218f interfaceC2218f : mo14216h.mo14608b()) {
                if (interfaceC2218f instanceof InterfaceC2225m) {
                    InterfaceC2241f mo14489f = ((InterfaceC2225m) interfaceC2218f).mo14489f();
                    switch (interfaceC2218f.mo14416a().f12385eh) {
                        case 0:
                            ((C2419s) this.f12765a.f12865z).m15310a((CharSequence) mo14489f);
                            break;
                        case 1:
                            ((C2422v) this.f12765a.f12827A).m15321a((CharSequence) mo14489f);
                            break;
                        case 2:
                            ((C2411k) this.f12765a.f12829C).m15283d((InterfaceC2237b) mo14489f);
                            break;
                        case 3:
                            ((C2414n) this.f12765a.f12830D).m15296d((InterfaceC2240e) mo14489f);
                            break;
                        case 4:
                        default:
                            throw new C2453g("Unrecognized reference type: %d", Integer.valueOf(interfaceC2218f.mo14416a().f12385eh));
                        case 5:
                            ((C2407g) this.f12765a.f12832F).m15183b((InterfaceC2236a) mo14489f);
                            break;
                    }
                }
                z = true;
            }
            List<? extends InterfaceC2271l<? extends InterfaceC2265f>> mo14612e = mo14216h.mo14612e();
            if (!z && mo14612e.size() > 0) {
                throw new C2453g("Method %s has no instructions, but has try blocks.", C2389i.m15120a((InterfaceC2240e) interfaceC2267h));
            }
            Iterator<? extends InterfaceC2271l<? extends InterfaceC2265f>> it = mo14216h.mo14612e().iterator();
            while (it.hasNext()) {
                Iterator<? extends Object> it2 = it.next().mo14516c().iterator();
                while (it2.hasNext()) {
                    ((C2422v) this.f12765a.f12827A).b2((CharSequence) ((InterfaceC2265f) it2.next()).mo14476b());
                }
            }
        }
    }

    /* renamed from: b */
    private void m15186b(InterfaceC2267h interfaceC2267h) {
        Iterator<? extends InterfaceC2269j> it = interfaceC2267h.mo14213e().iterator();
        while (it.hasNext()) {
            String mo14220b = it.next().mo14220b();
            if (mo14220b != null) {
                ((C2419s) this.f12765a.f12865z).m15310a((CharSequence) mo14220b);
            }
        }
        InterfaceC2268i mo14216h = interfaceC2267h.mo14216h();
        if (mo14216h != null) {
            for (InterfaceC2166a interfaceC2166a : mo14216h.mo14601a()) {
                switch (interfaceC2166a.mo14464f()) {
                    case 3:
                        InterfaceC2174i interfaceC2174i = (InterfaceC2174i) interfaceC2166a;
                        ((C2419s) this.f12765a.f12865z).m15312b(interfaceC2174i.mo14220b());
                        ((C2422v) this.f12765a.f12827A).b2((CharSequence) interfaceC2174i.mo14465l());
                        ((C2419s) this.f12765a.f12865z).m15312b(interfaceC2174i.mo14452c());
                        break;
                    case 9:
                        ((C2419s) this.f12765a.f12865z).m15312b(((InterfaceC2173h) interfaceC2166a).mo14468b());
                        break;
                }
            }
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a */
    public Collection<? extends C2415o> mo15193a() {
        if (this.f12770c == null) {
            this.f12770c = AbstractC1163ap.m9957b().m9961b(this.f12766b.values());
        }
        return this.f12770c;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a */
    public Map.Entry<? extends C2415o, Integer> mo15194a(CharSequence charSequence) {
        final C2415o c2415o;
        if (charSequence != null && (c2415o = (C2415o) this.f12766b.get(charSequence.toString())) != null) {
            return new Map.Entry<C2415o, Integer>() { // from class: org.d.b.i.b.h.1
                @Override // java.util.Map.Entry
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public C2415o getKey() {
                    return c2415o;
                }

                @Override // java.util.Map.Entry
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Integer getValue() {
                    return Integer.valueOf(c2415o.f12789g);
                }

                @Override // java.util.Map.Entry
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer setValue(Integer num) {
                    C2415o c2415o2 = c2415o;
                    int intValue = num.intValue();
                    c2415o2.f12789g = intValue;
                    return Integer.valueOf(intValue);
                }
            };
        }
        return null;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CharSequence mo15191a(C2415o c2415o) {
        return c2415o.mo14205l();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo15199b(C2415o c2415o) {
        return c2415o.mo14194a();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CharSequence mo15203c(C2415o c2415o) {
        return c2415o.mo14195b();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public C2421u.a<List<String>> mo15207d(C2415o c2415o) {
        return c2415o.f12784b;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: e, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public CharSequence mo15208e(C2415o c2415o) {
        return c2415o.mo14197d();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: f, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2246b mo15211f(C2415o c2415o) {
        return C2425b.m15326a(c2415o.mo14199f());
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: g, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<? extends InterfaceC2266g> mo15213g(C2415o c2415o) {
        return c2415o.mo14199f();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: h, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<? extends InterfaceC2266g> mo15214h(C2415o c2415o) {
        return c2415o.mo14200g();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: i, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<? extends InterfaceC2266g> mo15216i(C2415o c2415o) {
        return c2415o.mo14207n();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: j, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<C2416p> mo15219j(C2415o c2415o) {
        return c2415o.mo14202i();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: k, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<C2416p> mo15221k(C2415o c2415o) {
        return c2415o.mo14203j();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: l, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<? extends C2416p> mo15222l(C2415o c2415o) {
        return c2415o.mo14206m();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo15223m(InterfaceC2266g interfaceC2266g) {
        return interfaceC2266g.mo14222a();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int mo15225n(C2416p c2416p) {
        return c2416p.mo14214f();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Set<? extends InterfaceC2165a> mo15227o(C2415o c2415o) {
        Set<? extends InterfaceC2165a> mo14198e = c2415o.mo14198e();
        if (mo14198e.size() == 0) {
            return null;
        }
        return mo14198e;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<? extends InterfaceC2165a> mo15228p(InterfaceC2266g interfaceC2266g) {
        Set<? extends InterfaceC2165a> mo14224c = interfaceC2266g.mo14224c();
        if (mo14224c.size() == 0) {
            return null;
        }
        return mo14224c;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set<? extends InterfaceC2165a> mo15229q(C2416p c2416p) {
        Set<? extends InterfaceC2165a> mo14215g = c2416p.mo14215g();
        if (mo14215g.size() == 0) {
            return null;
        }
        return mo14215g;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<? extends Set<? extends InterfaceC2165a>> mo15230r(C2416p c2416p) {
        final List<? extends InterfaceC2269j> mo14213e = c2416p.mo14213e();
        if (C1153af.m9874b(mo14213e, f12768d)) {
            return new AbstractC2447a<Set<? extends InterfaceC2165a>>() { // from class: org.d.b.i.b.h.4
                @Override // org.p226d.p269d.AbstractC2447a, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator<Set<? extends InterfaceC2165a>> iterator() {
                    return AbstractC1203r.m10108a(mo14213e).m10114a(C2408h.f12769e).iterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return mo14213e.size();
                }
            };
        }
        return null;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Iterable<? extends InterfaceC2166a> mo15231s(C2416p c2416p) {
        InterfaceC2268i mo14216h = c2416p.mo14216h();
        if (mo14216h != null) {
            return mo14216h.mo14601a();
        }
        return null;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Iterable<CharSequence> mo15232t(C2416p c2416p) {
        return C1153af.m9868a((Iterable) c2416p.mo14213e(), (InterfaceC1112g) new InterfaceC1112g<InterfaceC2269j, CharSequence>() { // from class: org.d.b.i.b.h.5
            @Override // com.p129f.p130a.p131a.InterfaceC1112g
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public CharSequence mo9517a(InterfaceC2269j interfaceC2269j) {
                return interfaceC2269j.mo14220b();
            }
        });
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int mo15233u(C2416p c2416p) {
        InterfaceC2268i mo14216h = c2416p.mo14216h();
        if (mo14216h != null) {
            return mo14216h.mo14611d();
        }
        return 0;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Iterable<? extends InterfaceC2218f> mo15234v(C2416p c2416p) {
        InterfaceC2268i mo14216h = c2416p.mo14216h();
        if (mo14216h != null) {
            return mo14216h.mo14608b();
        }
        return null;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public List<? extends InterfaceC2271l<? extends InterfaceC2265f>> mo15235w(C2416p c2416p) {
        InterfaceC2268i mo14216h = c2416p.mo14216h();
        return mo14216h != null ? mo14216h.mo14612e() : AbstractC1208w.m10138g();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a */
    public CharSequence mo15192a(InterfaceC2265f interfaceC2265f) {
        return interfaceC2265f.mo14476b();
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C2074n mo15236x(C2416p c2416p) {
        return new C2074n(c2416p.mo14216h());
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo15195a(C2415o c2415o, int i) {
        c2415o.f12790h = i;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public int mo15237y(C2415o c2415o) {
        return c2415o.f12790h;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo15202b(C2416p c2416p, int i) {
        c2416p.f12794a = i;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int mo15238z(C2416p c2416p) {
        return c2416p.f12794a;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo15205c(C2416p c2416p, int i) {
        c2416p.f12795b = i;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public int mo15188A(C2416p c2416p) {
        return c2416p.f12795b;
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2427d
    /* renamed from: a */
    public void mo15198a(C2428e<CharSequence, CharSequence> c2428e, InterfaceC2166a interfaceC2166a) {
        switch (interfaceC2166a.mo14464f()) {
            case 3:
                InterfaceC2174i interfaceC2174i = (InterfaceC2174i) interfaceC2166a;
                c2428e.m15346a(interfaceC2174i.mo14461a(), interfaceC2174i.mo14470e(), interfaceC2174i.mo14220b(), interfaceC2174i.mo14465l(), interfaceC2174i.mo14452c());
                return;
            case 5:
                InterfaceC2167b interfaceC2167b = (InterfaceC2167b) interfaceC2166a;
                c2428e.m15345a(interfaceC2167b.mo14461a(), interfaceC2167b.mo14463e());
                return;
            case 6:
                InterfaceC2172g interfaceC2172g = (InterfaceC2172g) interfaceC2166a;
                c2428e.m15349b(interfaceC2172g.mo14461a(), interfaceC2172g.mo14467e());
                return;
            case 7:
                c2428e.m15348b(interfaceC2166a.mo14461a());
                return;
            case 8:
                c2428e.m15350c(interfaceC2166a.mo14461a());
                return;
            case 9:
                InterfaceC2173h interfaceC2173h = (InterfaceC2173h) interfaceC2166a;
                c2428e.m15347a(interfaceC2173h.mo14461a(), (int) interfaceC2173h.mo14468b());
                break;
            case 10:
                InterfaceC2169d interfaceC2169d = (InterfaceC2169d) interfaceC2166a;
                c2428e.m15351c(interfaceC2169d.mo14461a(), interfaceC2169d.mo14466b());
                return;
        }
        throw new C2453g("Unexpected debug item type: %d", Integer.valueOf(interfaceC2166a.mo14464f()));
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2434k
    /* renamed from: o, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int mo15172B(C2415o c2415o) {
        return c2415o.f12789g;
    }

    /* compiled from: ClassPool.java */
    /* renamed from: org.d.b.i.b.h$a */
    class a implements Map.Entry<C2415o, Integer> {

        /* renamed from: b */
        private final C2415o f12780b;

        public a(C2415o c2415o) {
            this.f12780b = c2415o;
        }

        @Override // java.util.Map.Entry
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C2415o getKey() {
            return this.f12780b;
        }

        @Override // java.util.Map.Entry
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer getValue() {
            return Integer.valueOf(this.f12780b.f12789g);
        }

        @Override // java.util.Map.Entry
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer setValue(Integer num) {
            int i = this.f12780b.f12789g;
            this.f12780b.f12789g = num.intValue();
            return Integer.valueOf(i);
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2434k
    /* renamed from: b */
    public Collection<? extends Map.Entry<C2415o, Integer>> mo15173b() {
        return new AbstractCollection<Map.Entry<C2415o, Integer>>() { // from class: org.d.b.i.b.h.6
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<C2415o, Integer>> iterator() {
                return new Iterator<Map.Entry<C2415o, Integer>>() { // from class: org.d.b.i.b.h.6.1

                    /* renamed from: a */
                    Iterator<C2415o> f12777a;

                    {
                        this.f12777a = C2408h.this.f12766b.values().iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f12777a.hasNext();
                    }

                    @Override // java.util.Iterator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Map.Entry<C2415o, Integer> next() {
                        return C2408h.this.new a(this.f12777a.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2408h.this.f12766b.size();
            }
        };
    }
}
