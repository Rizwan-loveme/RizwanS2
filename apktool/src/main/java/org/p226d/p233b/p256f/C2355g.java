package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1151ad;
import com.p129f.p130a.p133c.AbstractC1163ap;
import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2456j;

/* compiled from: ImmutableMethod.java */
/* renamed from: org.d.b.f.g */
/* loaded from: classes.dex */
public class C2355g extends AbstractC1991e implements InterfaceC2267h {

    /* renamed from: h */
    private static final AbstractC2455i<C2355g, InterfaceC2267h> f12615h = new AbstractC2455i<C2355g, InterfaceC2267h>() { // from class: org.d.b.f.g.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2267h interfaceC2267h) {
            return interfaceC2267h instanceof C2355g;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2355g mo14889a(InterfaceC2267h interfaceC2267h) {
            return C2355g.m15008a(interfaceC2267h);
        }
    };

    /* renamed from: a */
    protected final String f12616a;

    /* renamed from: b */
    protected final String f12617b;

    /* renamed from: c */
    protected final AbstractC1208w<? extends C2357i> f12618c;

    /* renamed from: d */
    protected final String f12619d;

    /* renamed from: e */
    protected final int f12620e;

    /* renamed from: f */
    protected final AbstractC1148aa<? extends C2273a> f12621f;

    /* renamed from: g */
    protected final C2356h f12622g;

    public C2355g(String str, String str2, Iterable<? extends InterfaceC2269j> iterable, String str3, int i, Set<? extends InterfaceC2165a> set, InterfaceC2268i interfaceC2268i) {
        this.f12616a = str;
        this.f12617b = str2;
        this.f12618c = C2357i.m15017a(iterable);
        this.f12619d = str3;
        this.f12620e = i;
        this.f12621f = C2273a.m14886a(set);
        this.f12622g = C2356h.m15013a(interfaceC2268i);
    }

    public C2355g(String str, String str2, AbstractC1208w<? extends C2357i> abstractC1208w, String str3, int i, AbstractC1148aa<? extends C2273a> abstractC1148aa, C2356h c2356h) {
        this.f12616a = str;
        this.f12617b = str2;
        this.f12618c = C2456j.m15529a(abstractC1208w);
        this.f12619d = str3;
        this.f12620e = i;
        this.f12621f = C2456j.m15527a(abstractC1148aa);
        this.f12622g = c2356h;
    }

    /* renamed from: a */
    public static C2355g m15008a(InterfaceC2267h interfaceC2267h) {
        if (interfaceC2267h instanceof C2355g) {
            return (C2355g) interfaceC2267h;
        }
        return new C2355g(interfaceC2267h.mo14209a(), interfaceC2267h.mo14210b(), interfaceC2267h.mo14213e(), interfaceC2267h.mo14212d(), interfaceC2267h.mo14214f(), interfaceC2267h.mo14215g(), interfaceC2267h.mo14216h());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: a */
    public String mo14209a() {
        return this.f12616a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: b */
    public String mo14210b() {
        return this.f12617b;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends CharSequence> mo14211c() {
        return this.f12618c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends C2357i> mo14213e() {
        return this.f12618c;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: d */
    public String mo14212d() {
        return this.f12619d;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: f */
    public int mo14214f() {
        return this.f12620e;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2273a> mo14215g() {
        return this.f12621f;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public C2356h mo14216h() {
        return this.f12622g;
    }

    /* renamed from: a */
    public static AbstractC1151ad<C2355g> m15007a(Iterable<? extends InterfaceC2267h> iterable) {
        return f12615h.m15524a(AbstractC1163ap.m9957b(), iterable);
    }
}
