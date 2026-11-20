package org.p226d.p233b.p264i.p266b;

import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p133c.AbstractC1151ad;
import com.p129f.p130a.p133c.AbstractC1163ap;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1153af;
import com.p129f.p130a.p133c.C1154ag;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p264i.p266b.C2421u;

/* compiled from: PoolClassDef.java */
/* renamed from: org.d.b.i.b.o */
/* loaded from: classes.dex */
class C2415o extends AbstractC1993g implements InterfaceC2244d {

    /* renamed from: a */
    final InterfaceC2244d f12783a;

    /* renamed from: b */
    final C2421u.a<List<String>> f12784b;

    /* renamed from: c */
    final AbstractC1151ad<InterfaceC2266g> f12785c;

    /* renamed from: d */
    final AbstractC1151ad<InterfaceC2266g> f12786d;

    /* renamed from: e */
    final AbstractC1151ad<C2416p> f12787e;

    /* renamed from: f */
    final AbstractC1151ad<C2416p> f12788f;

    /* renamed from: g */
    int f12789g = -1;

    /* renamed from: h */
    int f12790h = 0;

    C2415o(InterfaceC2244d interfaceC2244d) {
        this.f12783a = interfaceC2244d;
        this.f12784b = new C2421u.a<>(AbstractC1208w.m10132a((Collection) interfaceC2244d.mo14196c()));
        this.f12785c = AbstractC1151ad.m9840a((Iterable) interfaceC2244d.mo14199f());
        this.f12786d = AbstractC1151ad.m9840a((Iterable) interfaceC2244d.mo14200g());
        this.f12787e = AbstractC1151ad.m9840a(C1153af.m9868a((Iterable) interfaceC2244d.mo14202i(), (InterfaceC1112g) C2416p.f12793c));
        this.f12788f = AbstractC1151ad.m9840a(C1153af.m9868a((Iterable) interfaceC2244d.mo14203j(), (InterfaceC1112g) C2416p.f12793c));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: l */
    public String mo14205l() {
        return this.f12783a.mo14205l();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: a */
    public int mo14194a() {
        return this.f12783a.mo14194a();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: b */
    public String mo14195b() {
        return this.f12783a.mo14195b();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: c */
    public List<String> mo14196c() {
        return this.f12784b.f12798a;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: d */
    public String mo14197d() {
        return this.f12783a.mo14197d();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: e */
    public Set<? extends InterfaceC2165a> mo14198e() {
        return this.f12783a.mo14198e();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public SortedSet<InterfaceC2266g> mo14199f() {
        return this.f12785c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public SortedSet<InterfaceC2266g> mo14200g() {
        return this.f12786d;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Collection<InterfaceC2266g> mo14207n() {
        return new AbstractCollection<InterfaceC2266g>() { // from class: org.d.b.i.b.o.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<InterfaceC2266g> iterator() {
                return C1154ag.m9882a(AbstractC1208w.m10131a(C2415o.this.f12785c.iterator(), C2415o.this.f12786d.iterator()), AbstractC1163ap.m9957b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2415o.this.f12785c.size() + C2415o.this.f12786d.size();
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public SortedSet<C2416p> mo14202i() {
        return this.f12787e;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public SortedSet<C2416p> mo14203j() {
        return this.f12788f;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Collection<C2416p> mo14206m() {
        return new AbstractCollection<C2416p>() { // from class: org.d.b.i.b.o.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<C2416p> iterator() {
                return C1154ag.m9882a(AbstractC1208w.m10131a(C2415o.this.f12787e.iterator(), C2415o.this.f12788f.iterator()), AbstractC1163ap.m9957b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2415o.this.f12787e.size() + C2415o.this.f12788f.size();
            }
        };
    }
}
