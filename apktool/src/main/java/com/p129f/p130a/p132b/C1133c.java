package com.p129f.p130a.p132b;

import com.p129f.p130a.p131a.AbstractC1110e;
import com.p129f.p130a.p131a.AbstractC1130y;
import com.p129f.p130a.p131a.C1108c;
import com.p129f.p130a.p131a.C1115j;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.C1128w;
import com.p129f.p130a.p131a.InterfaceC1127v;
import com.p129f.p130a.p132b.AbstractC1131a;
import com.p129f.p130a.p132b.ConcurrentMapC1137g;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: CacheBuilder.java */
/* renamed from: com.f.a.b.c */
/* loaded from: classes.dex */
public final class C1133c<K, V> {

    /* renamed from: a */
    static final InterfaceC1127v<? extends AbstractC1131a.b> f7581a = C1128w.m9594a(new AbstractC1131a.b() { // from class: com.f.a.b.c.1
        @Override // com.p129f.p130a.p132b.AbstractC1131a.b
        /* renamed from: a */
        public void mo9603a(int i) {
        }

        @Override // com.p129f.p130a.p132b.AbstractC1131a.b
        /* renamed from: b */
        public void mo9605b(int i) {
        }

        @Override // com.p129f.p130a.p132b.AbstractC1131a.b
        /* renamed from: a */
        public void mo9604a(long j) {
        }

        @Override // com.p129f.p130a.p132b.AbstractC1131a.b
        /* renamed from: b */
        public void mo9606b(long j) {
        }

        @Override // com.p129f.p130a.p132b.AbstractC1131a.b
        /* renamed from: a */
        public void mo9602a() {
        }
    });

    /* renamed from: b */
    static final C1135e f7582b = new C1135e(0, 0, 0, 0, 0, 0);

    /* renamed from: c */
    static final InterfaceC1127v<AbstractC1131a.b> f7583c = new InterfaceC1127v<AbstractC1131a.b>() { // from class: com.f.a.b.c.2
        @Override // com.p129f.p130a.p131a.InterfaceC1127v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbstractC1131a.b mo9592a() {
            return new AbstractC1131a.a();
        }
    };

    /* renamed from: d */
    static final AbstractC1130y f7584d = new AbstractC1130y() { // from class: com.f.a.b.c.3
        @Override // com.p129f.p130a.p131a.AbstractC1130y
        /* renamed from: a */
        public long mo9601a() {
            return 0L;
        }
    };

    /* renamed from: u */
    private static final Logger f7585u = Logger.getLogger(C1133c.class.getName());

    /* renamed from: j */
    @MonotonicNonNullDecl
    InterfaceC1146p<? super K, ? super V> f7591j;

    /* renamed from: k */
    @MonotonicNonNullDecl
    ConcurrentMapC1137g.p f7592k;

    /* renamed from: l */
    @MonotonicNonNullDecl
    ConcurrentMapC1137g.p f7593l;

    /* renamed from: p */
    @MonotonicNonNullDecl
    AbstractC1110e<Object> f7597p;

    /* renamed from: q */
    @MonotonicNonNullDecl
    AbstractC1110e<Object> f7598q;

    /* renamed from: r */
    @MonotonicNonNullDecl
    InterfaceC1143m<? super K, ? super V> f7599r;

    /* renamed from: s */
    @MonotonicNonNullDecl
    AbstractC1130y f7600s;

    /* renamed from: e */
    boolean f7586e = true;

    /* renamed from: f */
    int f7587f = -1;

    /* renamed from: g */
    int f7588g = -1;

    /* renamed from: h */
    long f7589h = -1;

    /* renamed from: i */
    long f7590i = -1;

    /* renamed from: m */
    long f7594m = -1;

    /* renamed from: n */
    long f7595n = -1;

    /* renamed from: o */
    long f7596o = -1;

    /* renamed from: t */
    InterfaceC1127v<? extends AbstractC1131a.b> f7601t = f7581a;

    /* compiled from: CacheBuilder.java */
    /* renamed from: com.f.a.b.c$a */
    enum a implements InterfaceC1143m<Object, Object> {
        INSTANCE;

        @Override // com.p129f.p130a.p132b.InterfaceC1143m
        /* renamed from: a */
        public void mo9626a(C1144n<Object, Object> c1144n) {
        }
    }

    /* compiled from: CacheBuilder.java */
    /* renamed from: com.f.a.b.c$b */
    enum b implements InterfaceC1146p<Object, Object> {
        INSTANCE;

        @Override // com.p129f.p130a.p132b.InterfaceC1146p
        /* renamed from: a */
        public int mo9627a(Object obj, Object obj2) {
            return 1;
        }
    }

    private C1133c() {
    }

    /* renamed from: a */
    public static C1133c<Object, Object> m9608a() {
        return new C1133c<>();
    }

    /* renamed from: b */
    AbstractC1110e<Object> m9612b() {
        return (AbstractC1110e) C1115j.m9529a(this.f7597p, m9618h().mo9775a());
    }

    /* renamed from: c */
    AbstractC1110e<Object> m9613c() {
        return (AbstractC1110e) C1115j.m9529a(this.f7598q, m9619i().mo9775a());
    }

    /* renamed from: d */
    int m9614d() {
        if (this.f7587f == -1) {
            return 16;
        }
        return this.f7587f;
    }

    /* renamed from: e */
    int m9615e() {
        if (this.f7588g == -1) {
            return 4;
        }
        return this.f7588g;
    }

    /* renamed from: f */
    long m9616f() {
        if (this.f7594m == 0 || this.f7595n == 0) {
            return 0L;
        }
        return this.f7591j == null ? this.f7589h : this.f7590i;
    }

    /* renamed from: g */
    <K1 extends K, V1 extends V> InterfaceC1146p<K1, V1> m9617g() {
        return (InterfaceC1146p) C1115j.m9529a(this.f7591j, b.INSTANCE);
    }

    /* renamed from: h */
    ConcurrentMapC1137g.p m9618h() {
        return (ConcurrentMapC1137g.p) C1115j.m9529a(this.f7592k, ConcurrentMapC1137g.p.STRONG);
    }

    /* renamed from: i */
    ConcurrentMapC1137g.p m9619i() {
        return (ConcurrentMapC1137g.p) C1115j.m9529a(this.f7593l, ConcurrentMapC1137g.p.STRONG);
    }

    /* renamed from: j */
    long m9620j() {
        if (this.f7594m == -1) {
            return 0L;
        }
        return this.f7594m;
    }

    /* renamed from: k */
    long m9621k() {
        if (this.f7595n == -1) {
            return 0L;
        }
        return this.f7595n;
    }

    /* renamed from: l */
    long m9622l() {
        if (this.f7596o == -1) {
            return 0L;
        }
        return this.f7596o;
    }

    /* renamed from: a */
    AbstractC1130y m9610a(boolean z) {
        if (this.f7600s != null) {
            return this.f7600s;
        }
        return z ? AbstractC1130y.m9600b() : f7584d;
    }

    /* renamed from: m */
    <K1 extends K, V1 extends V> InterfaceC1143m<K1, V1> m9623m() {
        return (InterfaceC1143m) C1115j.m9529a(this.f7599r, a.INSTANCE);
    }

    /* renamed from: n */
    InterfaceC1127v<? extends AbstractC1131a.b> m9624n() {
        return this.f7601t;
    }

    /* renamed from: a */
    public <K1 extends K, V1 extends V> InterfaceC1136f<K1, V1> m9611a(AbstractC1134d<? super K1, V1> abstractC1134d) {
        m9609o();
        return new ConcurrentMapC1137g.k(this, abstractC1134d);
    }

    /* renamed from: o */
    private void m9609o() {
        if (this.f7591j == null) {
            C1120o.m9559b(this.f7590i == -1, "maximumWeight requires weigher");
        } else if (this.f7586e) {
            C1120o.m9559b(this.f7590i != -1, "weigher requires maximumWeight");
        } else if (this.f7590i == -1) {
            f7585u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public String toString() {
        C1115j.a m9528a = C1115j.m9528a(this);
        if (this.f7587f != -1) {
            m9528a.m9534a("initialCapacity", this.f7587f);
        }
        if (this.f7588g != -1) {
            m9528a.m9534a("concurrencyLevel", this.f7588g);
        }
        if (this.f7589h != -1) {
            m9528a.m9535a("maximumSize", this.f7589h);
        }
        if (this.f7590i != -1) {
            m9528a.m9535a("maximumWeight", this.f7590i);
        }
        if (this.f7594m != -1) {
            m9528a.m9536a("expireAfterWrite", this.f7594m + "ns");
        }
        if (this.f7595n != -1) {
            m9528a.m9536a("expireAfterAccess", this.f7595n + "ns");
        }
        if (this.f7592k != null) {
            m9528a.m9536a("keyStrength", C1108c.m9502a(this.f7592k.toString()));
        }
        if (this.f7593l != null) {
            m9528a.m9536a("valueStrength", C1108c.m9502a(this.f7593l.toString()));
        }
        if (this.f7597p != null) {
            m9528a.m9533a("keyEquivalence");
        }
        if (this.f7598q != null) {
            m9528a.m9533a("valueEquivalence");
        }
        if (this.f7599r != null) {
            m9528a.m9533a("removalListener");
        }
        return m9528a.toString();
    }
}
