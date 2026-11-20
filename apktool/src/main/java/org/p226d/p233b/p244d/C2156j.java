package org.p226d.p233b.p244d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p244d.p248d.AbstractC2130a;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;
import org.p226d.p233b.p244d.p248d.C2135f;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p269d.AbstractC2447a;

/* compiled from: DexBackedMethod.java */
/* renamed from: org.d.b.d.j */
/* loaded from: classes.dex */
public class C2156j extends AbstractC1991e implements InterfaceC2267h {

    /* renamed from: a */
    public final C2153g f12029a;

    /* renamed from: b */
    public final C2152f f12030b;

    /* renamed from: c */
    public final int f12031c;

    /* renamed from: d */
    public final int f12032d;

    /* renamed from: e */
    private final int f12033e;

    /* renamed from: f */
    private final int f12034f;

    /* renamed from: g */
    private final int f12035g;

    /* renamed from: h */
    private final int f12036h;

    /* renamed from: i */
    private int f12037i;

    /* renamed from: j */
    private int f12038j;

    /* renamed from: k */
    private int f12039k = -1;

    public C2156j(C2161o c2161o, C2152f c2152f, int i, AbstractC2130a.a aVar, AbstractC2130a.a aVar2) {
        this.f12029a = (C2153g) c2161o.f11828a;
        this.f12030b = c2152f;
        this.f12036h = c2161o.m14635a();
        this.f12032d = c2161o.m14641d() + i;
        this.f12031c = c2161o.m14639c();
        this.f12033e = c2161o.m14639c();
        this.f12035g = aVar.mo14704a(this.f12032d);
        this.f12034f = aVar2.mo14704a(this.f12032d);
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: a */
    public String mo14209a() {
        return this.f12030b.mo14205l();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: f */
    public int mo14214f() {
        return this.f12031c;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: b */
    public String mo14210b() {
        return this.f12029a.m14779r(this.f12029a.m14615a(m14791l() + 4));
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: d */
    public String mo14212d() {
        return this.f12029a.m14781t(this.f12029a.m14615a(m14792m() + 4));
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: e */
    public List<? extends InterfaceC2269j> mo14213e() {
        if (m14793n() <= 0) {
            return AbstractC1208w.m10138g();
        }
        final List<String> mo14211c = mo14211c();
        return new AbstractC2447a<InterfaceC2269j>() { // from class: org.d.b.d.j.1
            @Override // org.p226d.p269d.AbstractC2447a, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<InterfaceC2269j> iterator() {
                return new C2135f(mo14211c, C2156j.this.m14794i(), C2156j.this.m14795j());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return mo14211c.size();
            }
        };
    }

    /* renamed from: i */
    public List<? extends Set<? extends C2120c>> m14794i() {
        return AbstractC2130a.m14696c(this.f12029a, this.f12034f);
    }

    /* renamed from: j */
    public Iterator<String> m14795j() {
        C2157k mo14216h = mo14216h();
        return mo14216h != null ? mo14216h.m14799a(null) : AbstractC1148aa.m9802i().iterator();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    /* renamed from: c */
    public List<String> mo14211c() {
        int m14793n = m14793n();
        if (m14793n <= 0) {
            return AbstractC1208w.m10138g();
        }
        final int a2 = this.f12029a.m14615a(m14793n + 0);
        final int i = m14793n + 4;
        return new AbstractC2133d<String>() { // from class: org.d.b.d.j.2
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String mo14625b(int i2) {
                return C2156j.this.f12029a.m14781t(C2156j.this.f12029a.m14617c(i + (i2 * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a2;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: g */
    public Set<? extends InterfaceC2165a> mo14215g() {
        return AbstractC2130a.m14695b(this.f12029a, this.f12035g);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2267h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C2157k mo14216h() {
        if (this.f12033e > 0) {
            return new C2157k(this.f12029a, this, this.f12033e);
        }
        return null;
    }

    /* renamed from: l */
    private int m14791l() {
        if (this.f12037i == 0) {
            this.f12037i = this.f12029a.m14774m(this.f12032d);
        }
        return this.f12037i;
    }

    /* renamed from: m */
    private int m14792m() {
        if (this.f12038j == 0) {
            this.f12038j = this.f12029a.m14775n(this.f12029a.m14617c(m14791l() + 2));
        }
        return this.f12038j;
    }

    /* renamed from: n */
    private int m14793n() {
        if (this.f12039k == -1) {
            this.f12039k = this.f12029a.m14615a(m14792m() + 8);
        }
        return this.f12039k;
    }

    /* renamed from: a */
    public static void m14790a(C2161o c2161o, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c2161o.m14646f();
            c2161o.m14646f();
            c2161o.m14646f();
        }
    }
}
