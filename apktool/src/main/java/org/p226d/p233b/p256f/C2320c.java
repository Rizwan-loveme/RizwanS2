package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1151ad;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1154ag;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2456j;

/* compiled from: ImmutableClassDef.java */
/* renamed from: org.d.b.f.c */
/* loaded from: classes.dex */
public class C2320c extends AbstractC1993g implements InterfaceC2244d {

    /* renamed from: k */
    private static final AbstractC2455i<C2320c, InterfaceC2244d> f12545k = new AbstractC2455i<C2320c, InterfaceC2244d>() { // from class: org.d.b.f.c.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2244d interfaceC2244d) {
            return interfaceC2244d instanceof C2320c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2320c mo14889a(InterfaceC2244d interfaceC2244d) {
            return C2320c.m14949a(interfaceC2244d);
        }
    };

    /* renamed from: a */
    protected final String f12546a;

    /* renamed from: b */
    protected final int f12547b;

    /* renamed from: c */
    protected final String f12548c;

    /* renamed from: d */
    protected final AbstractC1208w<String> f12549d;

    /* renamed from: e */
    protected final String f12550e;

    /* renamed from: f */
    protected final AbstractC1148aa<? extends C2273a> f12551f;

    /* renamed from: g */
    protected final AbstractC1151ad<? extends C2354f> f12552g;

    /* renamed from: h */
    protected final AbstractC1151ad<? extends C2354f> f12553h;

    /* renamed from: i */
    protected final AbstractC1151ad<? extends C2355g> f12554i;

    /* renamed from: j */
    protected final AbstractC1151ad<? extends C2355g> f12555j;

    public C2320c(String str, int i, String str2, Collection<String> collection, String str3, Collection<? extends InterfaceC2165a> collection2, Iterable<? extends InterfaceC2266g> iterable, Iterable<? extends InterfaceC2266g> iterable2, Iterable<? extends InterfaceC2267h> iterable3, Iterable<? extends InterfaceC2267h> iterable4) {
        this.f12546a = str;
        this.f12547b = i;
        this.f12548c = str2;
        this.f12549d = collection == null ? AbstractC1208w.m10138g() : AbstractC1208w.m10132a((Collection) collection);
        this.f12550e = str3;
        this.f12551f = C2273a.m14886a(collection2);
        this.f12552g = C2354f.m15004a(iterable);
        this.f12553h = C2354f.m15004a(iterable2);
        this.f12554i = C2355g.m15007a(iterable3);
        this.f12555j = C2355g.m15007a(iterable4);
    }

    public C2320c(String str, int i, String str2, AbstractC1208w<String> abstractC1208w, String str3, AbstractC1148aa<? extends C2273a> abstractC1148aa, AbstractC1151ad<? extends C2354f> abstractC1151ad, AbstractC1151ad<? extends C2354f> abstractC1151ad2, AbstractC1151ad<? extends C2355g> abstractC1151ad3, AbstractC1151ad<? extends C2355g> abstractC1151ad4) {
        this.f12546a = str;
        this.f12547b = i;
        this.f12548c = str2;
        this.f12549d = C2456j.m15529a(abstractC1208w);
        this.f12550e = str3;
        this.f12551f = C2456j.m15527a(abstractC1148aa);
        this.f12552g = C2456j.m15528a((AbstractC1151ad) abstractC1151ad);
        this.f12553h = C2456j.m15528a((AbstractC1151ad) abstractC1151ad2);
        this.f12554i = C2456j.m15528a((AbstractC1151ad) abstractC1151ad3);
        this.f12555j = C2456j.m15528a((AbstractC1151ad) abstractC1151ad4);
    }

    /* renamed from: a */
    public static C2320c m14949a(InterfaceC2244d interfaceC2244d) {
        if (interfaceC2244d instanceof C2320c) {
            return (C2320c) interfaceC2244d;
        }
        return new C2320c(interfaceC2244d.mo14205l(), interfaceC2244d.mo14194a(), interfaceC2244d.mo14195b(), interfaceC2244d.mo14196c(), interfaceC2244d.mo14197d(), interfaceC2244d.mo14198e(), interfaceC2244d.mo14199f(), interfaceC2244d.mo14200g(), interfaceC2244d.mo14202i(), interfaceC2244d.mo14203j());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: l */
    public String mo14205l() {
        return this.f12546a;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: a */
    public int mo14194a() {
        return this.f12547b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: b */
    public String mo14195b() {
        return this.f12548c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<String> mo14196c() {
        return this.f12549d;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: d */
    public String mo14197d() {
        return this.f12550e;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2273a> mo14198e() {
        return this.f12551f;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2354f> mo14199f() {
        return this.f12552g;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2354f> mo14200g() {
        return this.f12553h;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2355g> mo14202i() {
        return this.f12554i;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2355g> mo14203j() {
        return this.f12555j;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Collection<? extends C2354f> mo14207n() {
        return new AbstractCollection<C2354f>() { // from class: org.d.b.f.c.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<C2354f> iterator() {
                return C1154ag.m9895b(C2320c.this.f12552g.iterator(), C2320c.this.f12553h.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2320c.this.f12552g.size() + C2320c.this.f12553h.size();
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Collection<? extends C2355g> mo14206m() {
        return new AbstractCollection<C2355g>() { // from class: org.d.b.f.c.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<C2355g> iterator() {
                return C1154ag.m9895b(C2320c.this.f12554i.iterator(), C2320c.this.f12555j.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return C2320c.this.f12554i.size() + C2320c.this.f12555j.size();
            }
        };
    }

    /* renamed from: a */
    public static AbstractC1148aa<C2320c> m14948a(Iterable<? extends InterfaceC2244d> iterable) {
        return f12545k.m15526b(iterable);
    }
}
