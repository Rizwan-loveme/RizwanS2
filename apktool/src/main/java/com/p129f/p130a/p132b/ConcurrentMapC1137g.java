package com.p129f.p130a.p132b;

import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import com.p129f.p130a.p131a.AbstractC1110e;
import com.p129f.p130a.p131a.AbstractC1130y;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.C1125t;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p132b.AbstractC1131a;
import com.p129f.p130a.p132b.AbstractC1134d;
import com.p129f.p130a.p132b.C1133c;
import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1192g;
import com.p129f.p130a.p133c.C1154ag;
import com.p129f.p130a.p137g.C1219c;
import com.p129f.p130a.p138h.p139a.C1225d;
import com.p129f.p130a.p138h.p139a.C1227f;
import com.p129f.p130a.p138h.p139a.C1232k;
import com.p129f.p130a.p138h.p139a.C1233l;
import com.p129f.p130a.p138h.p139a.C1234m;
import com.p129f.p130a.p138h.p139a.C1235n;
import com.p129f.p130a.p138h.p139a.InterfaceFutureC1231j;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.p209io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: LocalCache.java */
/* renamed from: com.f.a.b.g */
/* loaded from: classes.dex */
class ConcurrentMapC1137g<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* renamed from: a */
    static final Logger f7612a = Logger.getLogger(ConcurrentMapC1137g.class.getName());

    /* renamed from: u */
    static final w<Object, Object> f7613u = new w<Object, Object>() { // from class: com.f.a.b.g.1
        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        public Object get() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return 0;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: b */
        public InterfaceC1141k<Object, Object> mo9670b() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public w<Object, Object> mo9668a(ReferenceQueue<Object> referenceQueue, @NullableDecl Object obj, InterfaceC1141k<Object, Object> interfaceC1141k) {
            return this;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: c */
        public boolean mo9671c() {
            return false;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: d */
        public boolean mo9672d() {
            return false;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: e */
        public Object mo9673e() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public void mo9669a(Object obj) {
        }
    };

    /* renamed from: v */
    static final Queue<?> f7614v = new AbstractQueue<Object>() { // from class: com.f.a.b.g.2
        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return AbstractC1148aa.m9802i().iterator();
        }
    };

    /* renamed from: b */
    final int f7615b;

    /* renamed from: c */
    final int f7616c;

    /* renamed from: d */
    final n<K, V>[] f7617d;

    /* renamed from: e */
    final int f7618e;

    /* renamed from: f */
    final AbstractC1110e<Object> f7619f;

    /* renamed from: g */
    final AbstractC1110e<Object> f7620g;

    /* renamed from: h */
    final p f7621h;

    /* renamed from: i */
    final p f7622i;

    /* renamed from: j */
    final long f7623j;

    /* renamed from: k */
    final InterfaceC1146p<K, V> f7624k;

    /* renamed from: l */
    final long f7625l;

    /* renamed from: m */
    final long f7626m;

    /* renamed from: n */
    final long f7627n;

    /* renamed from: o */
    final Queue<C1144n<K, V>> f7628o;

    /* renamed from: p */
    final InterfaceC1143m<K, V> f7629p;

    /* renamed from: q */
    final AbstractC1130y f7630q;

    /* renamed from: r */
    final d f7631r;

    /* renamed from: s */
    final AbstractC1131a.b f7632s;

    /* renamed from: t */
    @NullableDecl
    final AbstractC1134d<? super K, V> f7633t;

    /* renamed from: w */
    @MonotonicNonNullDecl
    Set<K> f7634w;

    /* renamed from: x */
    @MonotonicNonNullDecl
    Collection<V> f7635x;

    /* renamed from: y */
    @MonotonicNonNullDecl
    Set<Map.Entry<K, V>> f7636y;

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$p */
    enum p {
        STRONG { // from class: com.f.a.b.g.p.1
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.p
            /* renamed from: a */
            <K, V> w<K, V> mo9776a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, V v, int i) {
                return i == 1 ? new t(v) : new ae(v, i);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.p
            /* renamed from: a */
            AbstractC1110e<Object> mo9775a() {
                return AbstractC1110e.m9511a();
            }
        },
        SOFT { // from class: com.f.a.b.g.p.2
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.p
            /* renamed from: a */
            <K, V> w<K, V> mo9776a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, V v, int i) {
                return i == 1 ? new o(nVar.f7699i, v, interfaceC1141k) : new ad(nVar.f7699i, v, interfaceC1141k, i);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.p
            /* renamed from: a */
            AbstractC1110e<Object> mo9775a() {
                return AbstractC1110e.m9512b();
            }
        },
        WEAK { // from class: com.f.a.b.g.p.3
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.p
            /* renamed from: a */
            <K, V> w<K, V> mo9776a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, V v, int i) {
                return i == 1 ? new ab(nVar.f7699i, v, interfaceC1141k) : new af(nVar.f7699i, v, interfaceC1141k, i);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.p
            /* renamed from: a */
            AbstractC1110e<Object> mo9775a() {
                return AbstractC1110e.m9512b();
            }
        };

        /* renamed from: a */
        abstract AbstractC1110e<Object> mo9775a();

        /* renamed from: a */
        abstract <K, V> w<K, V> mo9776a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, V v, int i);
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$w */
    interface w<K, V> {
        /* renamed from: a */
        int mo9667a();

        /* renamed from: a */
        w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, @NullableDecl V v, InterfaceC1141k<K, V> interfaceC1141k);

        /* renamed from: a */
        void mo9669a(@NullableDecl V v);

        @NullableDecl
        /* renamed from: b */
        InterfaceC1141k<K, V> mo9670b();

        /* renamed from: c */
        boolean mo9671c();

        /* renamed from: d */
        boolean mo9672d();

        /* renamed from: e */
        V mo9673e();

        @NullableDecl
        V get();
    }

    ConcurrentMapC1137g(C1133c<? super K, ? super V> c1133c, @NullableDecl AbstractC1134d<? super K, V> abstractC1134d) {
        int i2 = 0;
        this.f7618e = Math.min(c1133c.m9615e(), 65536);
        this.f7621h = c1133c.m9618h();
        this.f7622i = c1133c.m9619i();
        this.f7619f = c1133c.m9612b();
        this.f7620g = c1133c.m9613c();
        this.f7623j = c1133c.m9616f();
        this.f7624k = (InterfaceC1146p<K, V>) c1133c.m9617g();
        this.f7625l = c1133c.m9621k();
        this.f7626m = c1133c.m9620j();
        this.f7627n = c1133c.m9622l();
        this.f7629p = (InterfaceC1143m<K, V>) c1133c.m9623m();
        this.f7628o = this.f7629p == C1133c.a.INSTANCE ? m9640q() : new ConcurrentLinkedQueue<>();
        this.f7630q = c1133c.m9610a(m9660j());
        this.f7631r = d.m9700a(this.f7621h, m9662l(), m9661k());
        this.f7632s = c1133c.m9624n().mo9592a();
        this.f7633t = abstractC1134d;
        int min = Math.min(c1133c.m9614d(), 1073741824);
        if (m9647a() && !m9650b()) {
            min = (int) Math.min(min, this.f7623j);
        }
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.f7618e && (!m9647a() || i3 * 20 <= this.f7623j)) {
            i4++;
            i3 <<= 1;
        }
        this.f7616c = 32 - i4;
        this.f7615b = i3 - 1;
        this.f7617d = m9653c(i3);
        int i5 = min / i3;
        int i6 = 1;
        while (i6 < (i5 * i3 < min ? i5 + 1 : i5)) {
            i6 <<= 1;
        }
        if (m9647a()) {
            long j2 = (this.f7623j / i3) + 1;
            long j3 = this.f7623j % i3;
            while (true) {
                long j4 = j2;
                if (i2 < this.f7617d.length) {
                    j2 = ((long) i2) == j3 ? j4 - 1 : j4;
                    this.f7617d[i2] = m9642a(i6, j2, c1133c.m9624n().mo9592a());
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            while (i2 < this.f7617d.length) {
                this.f7617d[i2] = m9642a(i6, -1L, c1133c.m9624n().mo9592a());
                i2++;
            }
        }
    }

    /* renamed from: a */
    boolean m9647a() {
        return this.f7623j >= 0;
    }

    /* renamed from: b */
    boolean m9650b() {
        return this.f7624k != C1133c.b.INSTANCE;
    }

    /* renamed from: c */
    boolean m9652c() {
        return this.f7626m > 0;
    }

    /* renamed from: d */
    boolean m9654d() {
        return this.f7625l > 0;
    }

    /* renamed from: e */
    boolean m9655e() {
        return this.f7627n > 0;
    }

    /* renamed from: f */
    boolean m9656f() {
        return m9654d() || m9647a();
    }

    /* renamed from: g */
    boolean m9657g() {
        return m9652c();
    }

    /* renamed from: h */
    boolean m9658h() {
        return m9652c() || m9655e();
    }

    /* renamed from: i */
    boolean m9659i() {
        return m9654d();
    }

    /* renamed from: j */
    boolean m9660j() {
        return m9658h() || m9659i();
    }

    /* renamed from: k */
    boolean m9661k() {
        return m9657g() || m9658h();
    }

    /* renamed from: l */
    boolean m9662l() {
        return m9656f() || m9659i();
    }

    /* renamed from: m */
    boolean m9663m() {
        return this.f7621h != p.STRONG;
    }

    /* renamed from: n */
    boolean m9664n() {
        return this.f7622i != p.STRONG;
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$d */
    enum d {
        STRONG { // from class: com.f.a.b.g.d.1
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new s(k, i, interfaceC1141k);
            }
        },
        STRONG_ACCESS { // from class: com.f.a.b.g.d.2
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new q(k, i, interfaceC1141k);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
                InterfaceC1141k<K, V> mo9701a = super.mo9701a(nVar, interfaceC1141k, interfaceC1141k2);
                m9703a(interfaceC1141k, mo9701a);
                return mo9701a;
            }
        },
        STRONG_WRITE { // from class: com.f.a.b.g.d.3
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new u(k, i, interfaceC1141k);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
                InterfaceC1141k<K, V> mo9701a = super.mo9701a(nVar, interfaceC1141k, interfaceC1141k2);
                m9704b(interfaceC1141k, mo9701a);
                return mo9701a;
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.f.a.b.g.d.4
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new r(k, i, interfaceC1141k);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
                InterfaceC1141k<K, V> mo9701a = super.mo9701a(nVar, interfaceC1141k, interfaceC1141k2);
                m9703a(interfaceC1141k, mo9701a);
                m9704b(interfaceC1141k, mo9701a);
                return mo9701a;
            }
        },
        WEAK { // from class: com.f.a.b.g.d.5
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new aa(nVar.f7698h, k, i, interfaceC1141k);
            }
        },
        WEAK_ACCESS { // from class: com.f.a.b.g.d.6
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new y(nVar.f7698h, k, i, interfaceC1141k);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
                InterfaceC1141k<K, V> mo9701a = super.mo9701a(nVar, interfaceC1141k, interfaceC1141k2);
                m9703a(interfaceC1141k, mo9701a);
                return mo9701a;
            }
        },
        WEAK_WRITE { // from class: com.f.a.b.g.d.7
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new ac(nVar.f7698h, k, i, interfaceC1141k);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
                InterfaceC1141k<K, V> mo9701a = super.mo9701a(nVar, interfaceC1141k, interfaceC1141k2);
                m9704b(interfaceC1141k, mo9701a);
                return mo9701a;
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.f.a.b.g.d.8
            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
                return new z(nVar.f7698h, k, i, interfaceC1141k);
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.d
            /* renamed from: a */
            <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
                InterfaceC1141k<K, V> mo9701a = super.mo9701a(nVar, interfaceC1141k, interfaceC1141k2);
                m9703a(interfaceC1141k, mo9701a);
                m9704b(interfaceC1141k, mo9701a);
                return mo9701a;
            }
        };


        /* renamed from: i */
        static final d[] f7670i = {STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};

        /* renamed from: a */
        abstract <K, V> InterfaceC1141k<K, V> mo9702a(n<K, V> nVar, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k);

        /* renamed from: a */
        static d m9700a(p pVar, boolean z, boolean z2) {
            return f7670i[(z2 ? (char) 2 : (char) 0) | (z ? (char) 1 : (char) 0) | (pVar == p.WEAK ? (char) 4 : (char) 0)];
        }

        /* renamed from: a */
        <K, V> InterfaceC1141k<K, V> mo9701a(n<K, V> nVar, InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
            return mo9702a(nVar, interfaceC1141k.mo9683d(), interfaceC1141k.mo9681c(), interfaceC1141k2);
        }

        /* renamed from: a */
        <K, V> void m9703a(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
            interfaceC1141k2.mo9675a(interfaceC1141k.mo9685e());
            ConcurrentMapC1137g.m9633a(interfaceC1141k.mo9687g(), interfaceC1141k2);
            ConcurrentMapC1137g.m9633a(interfaceC1141k2, interfaceC1141k.mo9686f());
            ConcurrentMapC1137g.m9635b((InterfaceC1141k) interfaceC1141k);
        }

        /* renamed from: b */
        <K, V> void m9704b(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
            interfaceC1141k2.mo9679b(interfaceC1141k.mo9688h());
            ConcurrentMapC1137g.m9636b(interfaceC1141k.mo9690j(), interfaceC1141k2);
            ConcurrentMapC1137g.m9636b(interfaceC1141k2, interfaceC1141k.mo9689i());
            ConcurrentMapC1137g.m9637c(interfaceC1141k);
        }
    }

    /* renamed from: o */
    static <K, V> w<K, V> m9638o() {
        return (w<K, V>) f7613u;
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$m */
    private enum m implements InterfaceC1141k<Object, Object> {
        INSTANCE;

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public w<Object, Object> mo9674a() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9676a(w<Object, Object> wVar) {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public InterfaceC1141k<Object, Object> mo9678b() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public int mo9681c() {
            return 0;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public Object mo9683d() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            return 0L;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<Object, Object> mo9686f() {
            return this;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<Object, Object> interfaceC1141k) {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<Object, Object> mo9687g() {
            return this;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<Object, Object> interfaceC1141k) {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            return 0L;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<Object, Object> mo9689i() {
            return this;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<Object, Object> interfaceC1141k) {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<Object, Object> mo9690j() {
            return this;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<Object, Object> interfaceC1141k) {
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$b */
    static abstract class b<K, V> implements InterfaceC1141k<K, V> {
        b() {
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public w<K, V> mo9674a() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9676a(w<K, V> wVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9678b() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public int mo9681c() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public K mo9683d() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<K, V> mo9686f() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<K, V> mo9687g() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<K, V> mo9689i() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<K, V> mo9690j() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: p */
    static <K, V> InterfaceC1141k<K, V> m9639p() {
        return m.INSTANCE;
    }

    /* renamed from: q */
    static <E> Queue<E> m9640q() {
        return (Queue<E>) f7614v;
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$s */
    static class s<K, V> extends b<K, V> {

        /* renamed from: g */
        final K f7724g;

        /* renamed from: h */
        final int f7725h;

        /* renamed from: i */
        @NullableDecl
        final InterfaceC1141k<K, V> f7726i;

        /* renamed from: j */
        volatile w<K, V> f7727j = ConcurrentMapC1137g.m9638o();

        s(K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7724g = k;
            this.f7725h = i;
            this.f7726i = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public K mo9683d() {
            return this.f7724g;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public w<K, V> mo9674a() {
            return this.f7727j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9676a(w<K, V> wVar) {
            this.f7727j = wVar;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public int mo9681c() {
            return this.f7725h;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9678b() {
            return this.f7726i;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$q */
    static final class q<K, V> extends s<K, V> {

        /* renamed from: a */
        volatile long f7715a;

        /* renamed from: b */
        InterfaceC1141k<K, V> f7716b;

        /* renamed from: c */
        InterfaceC1141k<K, V> f7717c;

        q(K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(k, i, interfaceC1141k);
            this.f7715a = Long.MAX_VALUE;
            this.f7716b = ConcurrentMapC1137g.m9639p();
            this.f7717c = ConcurrentMapC1137g.m9639p();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            return this.f7715a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
            this.f7715a = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<K, V> mo9686f() {
            return this.f7716b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7716b = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<K, V> mo9687g() {
            return this.f7717c;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7717c = interfaceC1141k;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$u */
    static final class u<K, V> extends s<K, V> {

        /* renamed from: a */
        volatile long f7729a;

        /* renamed from: b */
        InterfaceC1141k<K, V> f7730b;

        /* renamed from: c */
        InterfaceC1141k<K, V> f7731c;

        u(K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(k, i, interfaceC1141k);
            this.f7729a = Long.MAX_VALUE;
            this.f7730b = ConcurrentMapC1137g.m9639p();
            this.f7731c = ConcurrentMapC1137g.m9639p();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            return this.f7729a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
            this.f7729a = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<K, V> mo9689i() {
            return this.f7730b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7730b = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<K, V> mo9690j() {
            return this.f7731c;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7731c = interfaceC1141k;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$r */
    static final class r<K, V> extends s<K, V> {

        /* renamed from: a */
        volatile long f7718a;

        /* renamed from: b */
        InterfaceC1141k<K, V> f7719b;

        /* renamed from: c */
        InterfaceC1141k<K, V> f7720c;

        /* renamed from: d */
        volatile long f7721d;

        /* renamed from: e */
        InterfaceC1141k<K, V> f7722e;

        /* renamed from: f */
        InterfaceC1141k<K, V> f7723f;

        r(K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(k, i, interfaceC1141k);
            this.f7718a = Long.MAX_VALUE;
            this.f7719b = ConcurrentMapC1137g.m9639p();
            this.f7720c = ConcurrentMapC1137g.m9639p();
            this.f7721d = Long.MAX_VALUE;
            this.f7722e = ConcurrentMapC1137g.m9639p();
            this.f7723f = ConcurrentMapC1137g.m9639p();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            return this.f7718a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
            this.f7718a = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<K, V> mo9686f() {
            return this.f7719b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7719b = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<K, V> mo9687g() {
            return this.f7720c;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7720c = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            return this.f7721d;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
            this.f7721d = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<K, V> mo9689i() {
            return this.f7722e;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7722e = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<K, V> mo9690j() {
            return this.f7723f;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7723f = interfaceC1141k;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$aa */
    static class aa<K, V> extends WeakReference<K> implements InterfaceC1141k<K, V> {

        /* renamed from: g */
        final int f7639g;

        /* renamed from: h */
        @NullableDecl
        final InterfaceC1141k<K, V> f7640h;

        /* renamed from: i */
        volatile w<K, V> f7641i;

        aa(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(k, referenceQueue);
            this.f7641i = ConcurrentMapC1137g.m9638o();
            this.f7639g = i;
            this.f7640h = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public K mo9683d() {
            return get();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<K, V> mo9686f() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<K, V> mo9687g() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<K, V> mo9689i() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<K, V> mo9690j() {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
            throw new UnsupportedOperationException();
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public w<K, V> mo9674a() {
            return this.f7641i;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9676a(w<K, V> wVar) {
            this.f7641i = wVar;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public int mo9681c() {
            return this.f7639g;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9678b() {
            return this.f7640h;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$y */
    static final class y<K, V> extends aa<K, V> {

        /* renamed from: a */
        volatile long f7735a;

        /* renamed from: b */
        InterfaceC1141k<K, V> f7736b;

        /* renamed from: c */
        InterfaceC1141k<K, V> f7737c;

        y(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(referenceQueue, k, i, interfaceC1141k);
            this.f7735a = Long.MAX_VALUE;
            this.f7736b = ConcurrentMapC1137g.m9639p();
            this.f7737c = ConcurrentMapC1137g.m9639p();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            return this.f7735a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
            this.f7735a = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<K, V> mo9686f() {
            return this.f7736b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7736b = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<K, V> mo9687g() {
            return this.f7737c;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7737c = interfaceC1141k;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$ac */
    static final class ac<K, V> extends aa<K, V> {

        /* renamed from: a */
        volatile long f7643a;

        /* renamed from: b */
        InterfaceC1141k<K, V> f7644b;

        /* renamed from: c */
        InterfaceC1141k<K, V> f7645c;

        ac(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(referenceQueue, k, i, interfaceC1141k);
            this.f7643a = Long.MAX_VALUE;
            this.f7644b = ConcurrentMapC1137g.m9639p();
            this.f7645c = ConcurrentMapC1137g.m9639p();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            return this.f7643a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
            this.f7643a = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<K, V> mo9689i() {
            return this.f7644b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7644b = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<K, V> mo9690j() {
            return this.f7645c;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7645c = interfaceC1141k;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$z */
    static final class z<K, V> extends aa<K, V> {

        /* renamed from: a */
        volatile long f7738a;

        /* renamed from: b */
        InterfaceC1141k<K, V> f7739b;

        /* renamed from: c */
        InterfaceC1141k<K, V> f7740c;

        /* renamed from: d */
        volatile long f7741d;

        /* renamed from: e */
        InterfaceC1141k<K, V> f7742e;

        /* renamed from: f */
        InterfaceC1141k<K, V> f7743f;

        z(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            super(referenceQueue, k, i, interfaceC1141k);
            this.f7738a = Long.MAX_VALUE;
            this.f7739b = ConcurrentMapC1137g.m9639p();
            this.f7740c = ConcurrentMapC1137g.m9639p();
            this.f7741d = Long.MAX_VALUE;
            this.f7742e = ConcurrentMapC1137g.m9639p();
            this.f7743f = ConcurrentMapC1137g.m9639p();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: e */
        public long mo9685e() {
            return this.f7738a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9675a(long j) {
            this.f7738a = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: f */
        public InterfaceC1141k<K, V> mo9686f() {
            return this.f7739b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: a */
        public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7739b = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: g */
        public InterfaceC1141k<K, V> mo9687g() {
            return this.f7740c;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7740c = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: h */
        public long mo9688h() {
            return this.f7741d;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: b */
        public void mo9679b(long j) {
            this.f7741d = j;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: i */
        public InterfaceC1141k<K, V> mo9689i() {
            return this.f7742e;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: c */
        public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7742e = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: j */
        public InterfaceC1141k<K, V> mo9690j() {
            return this.f7743f;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.aa, com.p129f.p130a.p132b.InterfaceC1141k
        /* renamed from: d */
        public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
            this.f7743f = interfaceC1141k;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$ab */
    static class ab<K, V> extends WeakReference<V> implements w<K, V> {

        /* renamed from: a */
        final InterfaceC1141k<K, V> f7642a;

        ab(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            super(v, referenceQueue);
            this.f7642a = interfaceC1141k;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return 1;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9670b() {
            return this.f7642a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public void mo9669a(V v) {
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            return new ab(referenceQueue, v, interfaceC1141k);
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: c */
        public boolean mo9671c() {
            return false;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: d */
        public boolean mo9672d() {
            return true;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: e */
        public V mo9673e() {
            return get();
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$o */
    static class o<K, V> extends SoftReference<V> implements w<K, V> {

        /* renamed from: a */
        final InterfaceC1141k<K, V> f7710a;

        o(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            super(v, referenceQueue);
            this.f7710a = interfaceC1141k;
        }

        /* renamed from: a */
        public int mo9667a() {
            return 1;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9670b() {
            return this.f7710a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public void mo9669a(V v) {
        }

        /* renamed from: a */
        public w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            return new o(referenceQueue, v, interfaceC1141k);
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: c */
        public boolean mo9671c() {
            return false;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: d */
        public boolean mo9672d() {
            return true;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: e */
        public V mo9673e() {
            return get();
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$t */
    static class t<K, V> implements w<K, V> {

        /* renamed from: a */
        final V f7728a;

        t(V v) {
            this.f7728a = v;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        public V get() {
            return this.f7728a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return 1;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9670b() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            return this;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: c */
        public boolean mo9671c() {
            return false;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: d */
        public boolean mo9672d() {
            return true;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: e */
        public V mo9673e() {
            return get();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public void mo9669a(V v) {
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$af */
    static final class af<K, V> extends ab<K, V> {

        /* renamed from: b */
        final int f7648b;

        af(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k, int i) {
            super(referenceQueue, v, interfaceC1141k);
            this.f7648b = i;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.ab, com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return this.f7648b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.ab, com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            return new af(referenceQueue, v, interfaceC1141k, this.f7648b);
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$ad */
    static final class ad<K, V> extends o<K, V> {

        /* renamed from: b */
        final int f7646b;

        ad(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k, int i) {
            super(referenceQueue, v, interfaceC1141k);
            this.f7646b = i;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.o, com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return this.f7646b;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.o, com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, V v, InterfaceC1141k<K, V> interfaceC1141k) {
            return new ad(referenceQueue, v, interfaceC1141k, this.f7646b);
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$ae */
    static final class ae<K, V> extends t<K, V> {

        /* renamed from: b */
        final int f7647b;

        ae(V v, int i) {
            super(v);
            this.f7647b = i;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.t, com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return this.f7647b;
        }
    }

    /* renamed from: a */
    static int m9631a(int i2) {
        int i3 = ((i2 << 15) ^ (-12931)) + i2;
        int i4 = i3 ^ (i3 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = i6 + (i6 << 2) + (i6 << 14);
        return i7 ^ (i7 >>> 16);
    }

    /* renamed from: a */
    int m9641a(@NullableDecl Object obj) {
        return m9631a(this.f7619f.m9513a(obj));
    }

    /* renamed from: a */
    void m9645a(w<K, V> wVar) {
        InterfaceC1141k<K, V> mo9670b = wVar.mo9670b();
        int mo9681c = mo9670b.mo9681c();
        m9648b(mo9681c).m9745a((n<K, V>) mo9670b.mo9683d(), mo9681c, (w<n<K, V>, V>) wVar);
    }

    /* renamed from: a */
    void m9646a(InterfaceC1141k<K, V> interfaceC1141k) {
        int mo9681c = interfaceC1141k.mo9681c();
        m9648b(mo9681c).m9741a((InterfaceC1141k) interfaceC1141k, mo9681c);
    }

    /* renamed from: b */
    n<K, V> m9648b(int i2) {
        return this.f7617d[(i2 >>> this.f7616c) & this.f7615b];
    }

    /* renamed from: a */
    n<K, V> m9642a(int i2, long j2, AbstractC1131a.b bVar) {
        return new n<>(this, i2, j2, bVar);
    }

    @NullableDecl
    /* renamed from: a */
    V m9643a(InterfaceC1141k<K, V> interfaceC1141k, long j2) {
        V v2;
        if (interfaceC1141k.mo9683d() == null || (v2 = interfaceC1141k.mo9674a().get()) == null || m9651b(interfaceC1141k, j2)) {
            return null;
        }
        return v2;
    }

    /* renamed from: b */
    boolean m9651b(InterfaceC1141k<K, V> interfaceC1141k, long j2) {
        C1120o.m9547a(interfaceC1141k);
        if (!m9654d() || j2 - interfaceC1141k.mo9685e() < this.f7625l) {
            return m9652c() && j2 - interfaceC1141k.mo9688h() >= this.f7626m;
        }
        return true;
    }

    /* renamed from: a */
    static <K, V> void m9633a(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
        interfaceC1141k.mo9677a(interfaceC1141k2);
        interfaceC1141k2.mo9680b(interfaceC1141k);
    }

    /* renamed from: b */
    static <K, V> void m9635b(InterfaceC1141k<K, V> interfaceC1141k) {
        InterfaceC1141k<K, V> m9639p = m9639p();
        interfaceC1141k.mo9677a(m9639p);
        interfaceC1141k.mo9680b(m9639p);
    }

    /* renamed from: b */
    static <K, V> void m9636b(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
        interfaceC1141k.mo9682c(interfaceC1141k2);
        interfaceC1141k2.mo9684d(interfaceC1141k);
    }

    /* renamed from: c */
    static <K, V> void m9637c(InterfaceC1141k<K, V> interfaceC1141k) {
        InterfaceC1141k<K, V> m9639p = m9639p();
        interfaceC1141k.mo9682c(m9639p);
        interfaceC1141k.mo9684d(m9639p);
    }

    /* renamed from: r */
    void m9665r() {
        while (true) {
            C1144n<K, V> poll = this.f7628o.poll();
            if (poll != null) {
                try {
                    this.f7629p.mo9626a(poll);
                } catch (Throwable th) {
                    f7612a.log(Level.WARNING, "Exception thrown by removal listener", th);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    final n<K, V>[] m9653c(int i2) {
        return new n[i2];
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$n */
    static class n<K, V> extends ReentrantLock {

        /* renamed from: a */
        @Weak
        final ConcurrentMapC1137g<K, V> f7691a;

        /* renamed from: b */
        volatile int f7692b;

        /* renamed from: c */
        @GuardedBy("this")
        long f7693c;

        /* renamed from: d */
        int f7694d;

        /* renamed from: e */
        int f7695e;

        /* renamed from: f */
        @MonotonicNonNullDecl
        volatile AtomicReferenceArray<InterfaceC1141k<K, V>> f7696f;

        /* renamed from: g */
        final long f7697g;

        /* renamed from: h */
        @NullableDecl
        final ReferenceQueue<K> f7698h;

        /* renamed from: i */
        @NullableDecl
        final ReferenceQueue<V> f7699i;

        /* renamed from: j */
        final Queue<InterfaceC1141k<K, V>> f7700j;

        /* renamed from: k */
        final AtomicInteger f7701k = new AtomicInteger();

        /* renamed from: l */
        @GuardedBy("this")
        final Queue<InterfaceC1141k<K, V>> f7702l;

        /* renamed from: m */
        @GuardedBy("this")
        final Queue<InterfaceC1141k<K, V>> f7703m;

        /* renamed from: n */
        final AbstractC1131a.b f7704n;

        n(ConcurrentMapC1137g<K, V> concurrentMapC1137g, int i, long j, AbstractC1131a.b bVar) {
            this.f7691a = concurrentMapC1137g;
            this.f7697g = j;
            this.f7704n = (AbstractC1131a.b) C1120o.m9547a(bVar);
            m9740a(m9732a(i));
            this.f7698h = concurrentMapC1137g.m9663m() ? new ReferenceQueue<>() : null;
            this.f7699i = concurrentMapC1137g.m9664n() ? new ReferenceQueue<>() : null;
            this.f7700j = concurrentMapC1137g.m9656f() ? new ConcurrentLinkedQueue<>() : ConcurrentMapC1137g.m9640q();
            this.f7702l = concurrentMapC1137g.m9657g() ? new ag<>() : ConcurrentMapC1137g.m9640q();
            this.f7703m = concurrentMapC1137g.m9656f() ? new c<>() : ConcurrentMapC1137g.m9640q();
        }

        /* renamed from: a */
        AtomicReferenceArray<InterfaceC1141k<K, V>> m9732a(int i) {
            return new AtomicReferenceArray<>(i);
        }

        /* renamed from: a */
        void m9740a(AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray) {
            this.f7695e = (atomicReferenceArray.length() * 3) / 4;
            if (!this.f7691a.m9650b() && this.f7695e == this.f7697g) {
                this.f7695e++;
            }
            this.f7696f = atomicReferenceArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @GuardedBy("this")
        /* renamed from: a */
        InterfaceC1141k<K, V> m9722a(K k, int i, @NullableDecl InterfaceC1141k<K, V> interfaceC1141k) {
            return this.f7691a.f7631r.mo9702a(this, C1120o.m9547a(k), i, interfaceC1141k);
        }

        @GuardedBy("this")
        /* renamed from: a */
        InterfaceC1141k<K, V> m9719a(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
            if (interfaceC1141k.mo9683d() == null) {
                return null;
            }
            w<K, V> mo9674a = interfaceC1141k.mo9674a();
            V v = mo9674a.get();
            if (v == null && mo9674a.mo9672d()) {
                return null;
            }
            InterfaceC1141k<K, V> mo9701a = this.f7691a.f7631r.mo9701a(this, interfaceC1141k, interfaceC1141k2);
            mo9701a.mo9676a(mo9674a.mo9668a(this.f7699i, v, mo9701a));
            return mo9701a;
        }

        @GuardedBy("this")
        /* renamed from: a */
        void m9738a(InterfaceC1141k<K, V> interfaceC1141k, K k, V v, long j) {
            w<K, V> mo9674a = interfaceC1141k.mo9674a();
            int mo9627a = this.f7691a.f7624k.mo9627a(k, v);
            C1120o.m9559b(mo9627a >= 0, "Weights must be non-negative");
            interfaceC1141k.mo9676a(this.f7691a.f7622i.mo9776a(this, interfaceC1141k, v, mo9627a));
            m9736a((InterfaceC1141k) interfaceC1141k, mo9627a, j);
            mo9674a.mo9669a(v);
        }

        /* renamed from: a */
        V m9726a(K k, int i, AbstractC1134d<? super K, V> abstractC1134d) {
            V m9751b;
            InterfaceC1141k<K, V> m9749b;
            C1120o.m9547a(k);
            C1120o.m9547a(abstractC1134d);
            try {
                try {
                    if (this.f7692b != 0 && (m9749b = m9749b(k, i)) != null) {
                        long mo9601a = this.f7691a.f7630q.mo9601a();
                        V m9757c = m9757c(m9749b, mo9601a);
                        if (m9757c != null) {
                            m9737a(m9749b, mo9601a);
                            this.f7704n.mo9603a(1);
                            m9751b = m9723a(m9749b, k, i, m9757c, mo9601a, abstractC1134d);
                        } else {
                            w<K, V> mo9674a = m9749b.mo9674a();
                            if (mo9674a.mo9671c()) {
                                m9751b = m9724a((InterfaceC1141k<InterfaceC1141k<K, V>, V>) m9749b, (InterfaceC1141k<K, V>) k, (w<InterfaceC1141k<K, V>, V>) mo9674a);
                            }
                        }
                        return m9751b;
                    }
                    m9751b = m9751b((n<K, V>) k, i, (AbstractC1134d<? super n<K, V>, V>) abstractC1134d);
                    return m9751b;
                } catch (ExecutionException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof Error) {
                        throw new C1225d((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new C1234m(cause);
                    }
                    throw e2;
                }
            } finally {
                m9771l();
            }
        }

        @NullableDecl
        /* renamed from: a */
        V m9725a(Object obj, int i) {
            V v = null;
            try {
                if (this.f7692b != 0) {
                    long mo9601a = this.f7691a.f7630q.mo9601a();
                    InterfaceC1141k<K, V> m9721a = m9721a(obj, i, mo9601a);
                    if (m9721a != null) {
                        V v2 = m9721a.mo9674a().get();
                        if (v2 != null) {
                            m9737a(m9721a, mo9601a);
                            v = m9723a(m9721a, m9721a.mo9683d(), i, v2, mo9601a, this.f7691a.f7633t);
                        } else {
                            m9733a();
                        }
                    }
                    return v;
                }
                return v;
            } finally {
                m9771l();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
        
            if (r6 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
        
            r4 = new com.p129f.p130a.p132b.ConcurrentMapC1137g.j<>();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
        
            if (r12 != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
        
            r5 = m9722a((com.p129f.p130a.p132b.ConcurrentMapC1137g.n<K, V>) r19, r20, (com.p129f.p130a.p132b.InterfaceC1141k<com.p129f.p130a.p132b.ConcurrentMapC1137g.n<K, V>, V>) r0);
            r5.mo9676a(r4);
            r0.set(r17, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
        
            if (r6 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        
            return m9724a((com.p129f.p130a.p132b.InterfaceC1141k<com.p129f.p130a.p132b.InterfaceC1141k<K, V>, V>) r5, (com.p129f.p130a.p132b.InterfaceC1141k<K, V>) r19, (com.p129f.p130a.p132b.ConcurrentMapC1137g.w<com.p129f.p130a.p132b.InterfaceC1141k<K, V>, V>) r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
        
            r7 = m9728a((com.p129f.p130a.p132b.ConcurrentMapC1137g.n<K, V>) r19, r20, (com.p129f.p130a.p132b.ConcurrentMapC1137g.j<com.p129f.p130a.p132b.ConcurrentMapC1137g.n<K, V>, V>) r4, (com.p129f.p130a.p132b.AbstractC1134d<? super com.p129f.p130a.p132b.ConcurrentMapC1137g.n<K, V>, V>) r21);
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
        
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
        
            return r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0104, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0105, code lost:
        
            r18.f7704n.mo9605b(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x010d, code lost:
        
            throw r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00fb, code lost:
        
            r12.mo9676a(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00fe, code lost:
        
            r5 = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0117, code lost:
        
            r4 = null;
            r5 = r12;
         */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        V m9751b(K k, int i, AbstractC1134d<? super K, V> abstractC1134d) {
            boolean z;
            w<K, V> wVar = null;
            lock();
            try {
                long mo9601a = this.f7691a.f7630q.mo9601a();
                m9759c(mo9601a);
                int i2 = this.f7692b - 1;
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k;
                while (true) {
                    if (interfaceC1141k2 == null) {
                        z = true;
                        break;
                    }
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() != i || mo9683d == null || !this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        interfaceC1141k2 = interfaceC1141k2.mo9678b();
                    } else {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        if (mo9674a.mo9671c()) {
                            z = false;
                            wVar = mo9674a;
                        } else {
                            V v = mo9674a.get();
                            if (v == null) {
                                m9739a(mo9683d, i, v, mo9674a.mo9667a(), EnumC1142l.COLLECTED);
                            } else if (this.f7691a.m9651b(interfaceC1141k2, mo9601a)) {
                                m9739a(mo9683d, i, v, mo9674a.mo9667a(), EnumC1142l.EXPIRED);
                            } else {
                                m9755b(interfaceC1141k2, mo9601a);
                                this.f7704n.mo9603a(1);
                                return v;
                            }
                            this.f7702l.remove(interfaceC1141k2);
                            this.f7703m.remove(interfaceC1141k2);
                            this.f7692b = i2;
                            z = true;
                            wVar = mo9674a;
                        }
                    }
                }
            } finally {
                unlock();
                m9772m();
            }
        }

        /* renamed from: a */
        V m9724a(InterfaceC1141k<K, V> interfaceC1141k, K k, w<K, V> wVar) {
            if (!wVar.mo9671c()) {
                throw new AssertionError();
            }
            C1120o.m9560b(!Thread.holdsLock(interfaceC1141k), "Recursive load of: %s", k);
            try {
                V mo9673e = wVar.mo9673e();
                if (mo9673e == null) {
                    throw new AbstractC1134d.a("CacheLoader returned null for key " + k + ".");
                }
                m9737a(interfaceC1141k, this.f7691a.f7630q.mo9601a());
                return mo9673e;
            } finally {
                this.f7704n.mo9605b(1);
            }
        }

        /* renamed from: a */
        V m9728a(K k, int i, j<K, V> jVar, AbstractC1134d<? super K, V> abstractC1134d) {
            return m9729a((n<K, V>) k, i, (j<n<K, V>, V>) jVar, (InterfaceFutureC1231j) jVar.m9712a(k, abstractC1134d));
        }

        /* renamed from: b */
        InterfaceFutureC1231j<V> m9750b(final K k, final int i, final j<K, V> jVar, AbstractC1134d<? super K, V> abstractC1134d) {
            final InterfaceFutureC1231j<V> m9712a = jVar.m9712a(k, abstractC1134d);
            m9712a.mo10200a(new Runnable() { // from class: com.f.a.b.g.n.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.this.m9729a((n) k, i, (j<n, V>) jVar, m9712a);
                    } catch (Throwable th) {
                        ConcurrentMapC1137g.f7612a.log(Level.WARNING, "Exception thrown during refresh", th);
                        jVar.m9713a(th);
                    }
                }
            }, C1232k.m10225a());
            return m9712a;
        }

        /* renamed from: a */
        V m9729a(K k, int i, j<K, V> jVar, InterfaceFutureC1231j<V> interfaceFutureC1231j) {
            try {
                V v = (V) C1235n.m10228a(interfaceFutureC1231j);
                if (v == null) {
                    throw new AbstractC1134d.a("CacheLoader returned null for key " + k + ".");
                }
                this.f7704n.mo9604a(jVar.m9715f());
                m9744a((n<K, V>) k, i, (j<n<K, V>, j<K, V>>) jVar, (j<K, V>) v);
                if (v == null) {
                    this.f7704n.mo9606b(jVar.m9715f());
                    m9743a((n<K, V>) k, i, (j<n<K, V>, V>) jVar);
                }
                return v;
            } catch (Throwable th) {
                if (0 == 0) {
                    this.f7704n.mo9606b(jVar.m9715f());
                    m9743a((n<K, V>) k, i, (j<n<K, V>, V>) jVar);
                }
                throw th;
            }
        }

        /* renamed from: a */
        V m9723a(InterfaceC1141k<K, V> interfaceC1141k, K k, int i, V v, long j, AbstractC1134d<? super K, V> abstractC1134d) {
            V m9727a;
            return (!this.f7691a.m9655e() || j - interfaceC1141k.mo9688h() <= this.f7691a.f7627n || interfaceC1141k.mo9674a().mo9671c() || (m9727a = m9727a((n<K, V>) k, i, (AbstractC1134d<? super n<K, V>, V>) abstractC1134d, true)) == null) ? v : m9727a;
        }

        @NullableDecl
        /* renamed from: a */
        V m9727a(K k, int i, AbstractC1134d<? super K, V> abstractC1134d, boolean z) {
            j<K, V> m9718a = m9718a((n<K, V>) k, i, z);
            if (m9718a == null) {
                return null;
            }
            InterfaceFutureC1231j<V> m9750b = m9750b(k, i, m9718a, abstractC1134d);
            if (!m9750b.isDone()) {
                return null;
            }
            try {
                return (V) C1235n.m10228a(m9750b);
            } catch (Throwable th) {
                return null;
            }
        }

        @NullableDecl
        /* renamed from: a */
        j<K, V> m9718a(K k, int i, boolean z) {
            lock();
            try {
                long mo9601a = this.f7691a.f7630q.mo9601a();
                m9759c(mo9601a);
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = (InterfaceC1141k) atomicReferenceArray.get(length);
                for (InterfaceC1141k interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    Object mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        if (mo9674a.mo9671c() || (z && mo9601a - interfaceC1141k2.mo9688h() < this.f7691a.f7627n)) {
                            return null;
                        }
                        this.f7694d++;
                        j<K, V> jVar = new j<>(mo9674a);
                        interfaceC1141k2.mo9676a(jVar);
                        return jVar;
                    }
                }
                this.f7694d++;
                j<K, V> jVar2 = new j<>();
                InterfaceC1141k<K, V> m9722a = m9722a((n<K, V>) k, i, (InterfaceC1141k<n<K, V>, V>) interfaceC1141k);
                m9722a.mo9676a(jVar2);
                atomicReferenceArray.set(length, m9722a);
                return jVar2;
            } finally {
                unlock();
                m9772m();
            }
        }

        /* renamed from: a */
        void m9733a() {
            if (tryLock()) {
                try {
                    m9752b();
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy("this")
        /* renamed from: b */
        void m9752b() {
            if (this.f7691a.m9663m()) {
                m9758c();
            }
            if (this.f7691a.m9664n()) {
                m9762d();
            }
        }

        @GuardedBy("this")
        /* renamed from: c */
        void m9758c() {
            int i = 0;
            do {
                int i2 = i;
                Reference<? extends K> poll = this.f7698h.poll();
                if (poll != null) {
                    this.f7691a.m9646a((InterfaceC1141k) poll);
                    i = i2 + 1;
                } else {
                    return;
                }
            } while (i != 16);
        }

        @GuardedBy("this")
        /* renamed from: d */
        void m9762d() {
            int i = 0;
            do {
                int i2 = i;
                Reference<? extends V> poll = this.f7699i.poll();
                if (poll != null) {
                    this.f7691a.m9645a((w) poll);
                    i = i2 + 1;
                } else {
                    return;
                }
            } while (i != 16);
        }

        /* renamed from: e */
        void m9764e() {
            if (this.f7691a.m9663m()) {
                m9765f();
            }
            if (this.f7691a.m9664n()) {
                m9766g();
            }
        }

        /* renamed from: f */
        void m9765f() {
            while (this.f7698h.poll() != null) {
            }
        }

        /* renamed from: g */
        void m9766g() {
            while (this.f7699i.poll() != null) {
            }
        }

        /* renamed from: a */
        void m9737a(InterfaceC1141k<K, V> interfaceC1141k, long j) {
            if (this.f7691a.m9659i()) {
                interfaceC1141k.mo9675a(j);
            }
            this.f7700j.add(interfaceC1141k);
        }

        @GuardedBy("this")
        /* renamed from: b */
        void m9755b(InterfaceC1141k<K, V> interfaceC1141k, long j) {
            if (this.f7691a.m9659i()) {
                interfaceC1141k.mo9675a(j);
            }
            this.f7703m.add(interfaceC1141k);
        }

        @GuardedBy("this")
        /* renamed from: a */
        void m9736a(InterfaceC1141k<K, V> interfaceC1141k, int i, long j) {
            m9767h();
            this.f7693c += i;
            if (this.f7691a.m9659i()) {
                interfaceC1141k.mo9675a(j);
            }
            if (this.f7691a.m9658h()) {
                interfaceC1141k.mo9679b(j);
            }
            this.f7703m.add(interfaceC1141k);
            this.f7702l.add(interfaceC1141k);
        }

        @GuardedBy("this")
        /* renamed from: h */
        void m9767h() {
            while (true) {
                InterfaceC1141k<K, V> poll = this.f7700j.poll();
                if (poll != null) {
                    if (this.f7703m.contains(poll)) {
                        this.f7703m.add(poll);
                    }
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        void m9734a(long j) {
            if (tryLock()) {
                try {
                    m9753b(j);
                } finally {
                    unlock();
                }
            }
        }

        @GuardedBy("this")
        /* renamed from: b */
        void m9753b(long j) {
            InterfaceC1141k<K, V> peek;
            InterfaceC1141k<K, V> peek2;
            m9767h();
            do {
                peek = this.f7702l.peek();
                if (peek == null || !this.f7691a.m9651b(peek, j)) {
                    do {
                        peek2 = this.f7703m.peek();
                        if (peek2 == null || !this.f7691a.m9651b(peek2, j)) {
                            return;
                        }
                    } while (m9742a((InterfaceC1141k) peek2, peek2.mo9681c(), EnumC1142l.EXPIRED));
                    throw new AssertionError();
                }
            } while (m9742a((InterfaceC1141k) peek, peek.mo9681c(), EnumC1142l.EXPIRED));
            throw new AssertionError();
        }

        @GuardedBy("this")
        /* renamed from: a */
        void m9739a(@NullableDecl K k, int i, @NullableDecl V v, int i2, EnumC1142l enumC1142l) {
            this.f7693c -= i2;
            if (enumC1142l.mo9784a()) {
                this.f7704n.mo9602a();
            }
            if (this.f7691a.f7628o != ConcurrentMapC1137g.f7614v) {
                this.f7691a.f7628o.offer(C1144n.m9785a(k, v, enumC1142l));
            }
        }

        @GuardedBy("this")
        /* renamed from: a */
        void m9735a(InterfaceC1141k<K, V> interfaceC1141k) {
            if (this.f7691a.m9647a()) {
                m9767h();
                if (interfaceC1141k.mo9674a().mo9667a() > this.f7697g && !m9742a((InterfaceC1141k) interfaceC1141k, interfaceC1141k.mo9681c(), EnumC1142l.SIZE)) {
                    throw new AssertionError();
                }
                while (this.f7693c > this.f7697g) {
                    InterfaceC1141k<K, V> m9768i = m9768i();
                    if (!m9742a((InterfaceC1141k) m9768i, m9768i.mo9681c(), EnumC1142l.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        @GuardedBy("this")
        /* renamed from: i */
        InterfaceC1141k<K, V> m9768i() {
            for (InterfaceC1141k<K, V> interfaceC1141k : this.f7703m) {
                if (interfaceC1141k.mo9674a().mo9667a() > 0) {
                    return interfaceC1141k;
                }
            }
            throw new AssertionError();
        }

        /* renamed from: b */
        InterfaceC1141k<K, V> m9747b(int i) {
            return this.f7696f.get((r0.length() - 1) & i);
        }

        @NullableDecl
        /* renamed from: b */
        InterfaceC1141k<K, V> m9749b(Object obj, int i) {
            for (InterfaceC1141k<K, V> m9747b = m9747b(i); m9747b != null; m9747b = m9747b.mo9678b()) {
                if (m9747b.mo9681c() == i) {
                    K mo9683d = m9747b.mo9683d();
                    if (mo9683d == null) {
                        m9733a();
                    } else if (this.f7691a.f7619f.m9514a(obj, mo9683d)) {
                        return m9747b;
                    }
                }
            }
            return null;
        }

        @NullableDecl
        /* renamed from: a */
        InterfaceC1141k<K, V> m9721a(Object obj, int i, long j) {
            InterfaceC1141k<K, V> m9749b = m9749b(obj, i);
            if (m9749b == null) {
                return null;
            }
            if (!this.f7691a.m9651b(m9749b, j)) {
                return m9749b;
            }
            m9734a(j);
            return null;
        }

        /* renamed from: c */
        V m9757c(InterfaceC1141k<K, V> interfaceC1141k, long j) {
            if (interfaceC1141k.mo9683d() == null) {
                m9733a();
                return null;
            }
            V v = interfaceC1141k.mo9674a().get();
            if (v == null) {
                m9733a();
                return null;
            }
            if (!this.f7691a.m9651b(interfaceC1141k, j)) {
                return v;
            }
            m9734a(j);
            return null;
        }

        /* renamed from: c */
        boolean m9760c(Object obj, int i) {
            try {
                if (this.f7692b != 0) {
                    InterfaceC1141k<K, V> m9721a = m9721a(obj, i, this.f7691a.f7630q.mo9601a());
                    if (m9721a != null) {
                        r0 = m9721a.mo9674a().get() != null;
                    }
                }
                return r0;
            } finally {
                m9771l();
            }
        }

        @NullableDecl
        /* renamed from: a */
        V m9731a(K k, int i, V v, boolean z) {
            int i2;
            lock();
            try {
                long mo9601a = this.f7691a.f7630q.mo9601a();
                m9759c(mo9601a);
                if (this.f7692b + 1 > this.f7695e) {
                    m9769j();
                    int i3 = this.f7692b + 1;
                }
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        V v2 = mo9674a.get();
                        if (v2 != null) {
                            if (z) {
                                m9755b(interfaceC1141k2, mo9601a);
                                return v2;
                            }
                            this.f7694d++;
                            m9739a(k, i, v2, mo9674a.mo9667a(), EnumC1142l.REPLACED);
                            m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) interfaceC1141k2, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                            m9735a(interfaceC1141k2);
                            return v2;
                        }
                        this.f7694d++;
                        if (mo9674a.mo9672d()) {
                            m9739a(k, i, v2, mo9674a.mo9667a(), EnumC1142l.COLLECTED);
                            m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) interfaceC1141k2, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                            i2 = this.f7692b;
                        } else {
                            m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) interfaceC1141k2, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                            i2 = this.f7692b + 1;
                        }
                        this.f7692b = i2;
                        m9735a(interfaceC1141k2);
                        return null;
                    }
                }
                this.f7694d++;
                InterfaceC1141k<K, V> m9722a = m9722a((n<K, V>) k, i, (InterfaceC1141k<n<K, V>, V>) interfaceC1141k);
                m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) m9722a, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                atomicReferenceArray.set(length, m9722a);
                this.f7692b++;
                m9735a(m9722a);
                return null;
            } finally {
                unlock();
                m9772m();
            }
        }

        @GuardedBy("this")
        /* renamed from: j */
        void m9769j() {
            int i;
            int i2;
            AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i3 = this.f7692b;
                AtomicReferenceArray<InterfaceC1141k<K, V>> m9732a = m9732a(length << 1);
                this.f7695e = (m9732a.length() * 3) / 4;
                int length2 = m9732a.length() - 1;
                int i4 = 0;
                while (i4 < length) {
                    InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(i4);
                    if (interfaceC1141k != null) {
                        InterfaceC1141k<K, V> mo9678b = interfaceC1141k.mo9678b();
                        int mo9681c = interfaceC1141k.mo9681c() & length2;
                        if (mo9678b == null) {
                            m9732a.set(mo9681c, interfaceC1141k);
                            i = i3;
                        } else {
                            InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k;
                            while (mo9678b != null) {
                                int mo9681c2 = mo9678b.mo9681c() & length2;
                                if (mo9681c2 != mo9681c) {
                                    interfaceC1141k2 = mo9678b;
                                } else {
                                    mo9681c2 = mo9681c;
                                }
                                mo9678b = mo9678b.mo9678b();
                                mo9681c = mo9681c2;
                            }
                            m9732a.set(mo9681c, interfaceC1141k2);
                            InterfaceC1141k<K, V> interfaceC1141k3 = interfaceC1141k;
                            i = i3;
                            while (interfaceC1141k3 != interfaceC1141k2) {
                                int mo9681c3 = interfaceC1141k3.mo9681c() & length2;
                                InterfaceC1141k<K, V> m9719a = m9719a(interfaceC1141k3, m9732a.get(mo9681c3));
                                if (m9719a != null) {
                                    m9732a.set(mo9681c3, m9719a);
                                    i2 = i;
                                } else {
                                    m9754b(interfaceC1141k3);
                                    i2 = i - 1;
                                }
                                interfaceC1141k3 = interfaceC1141k3.mo9678b();
                                i = i2;
                            }
                        }
                    } else {
                        i = i3;
                    }
                    i4++;
                    i3 = i;
                }
                this.f7696f = m9732a;
                this.f7692b = i3;
            }
        }

        /* renamed from: a */
        boolean m9746a(K k, int i, V v, V v2) {
            lock();
            try {
                long mo9601a = this.f7691a.f7630q.mo9601a();
                m9759c(mo9601a);
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        V v3 = mo9674a.get();
                        if (v3 == null) {
                            if (mo9674a.mo9672d()) {
                                int i2 = this.f7692b - 1;
                                this.f7694d++;
                                InterfaceC1141k<K, V> m9720a = m9720a(interfaceC1141k, interfaceC1141k2, mo9683d, i, v3, mo9674a, EnumC1142l.COLLECTED);
                                int i3 = this.f7692b - 1;
                                atomicReferenceArray.set(length, m9720a);
                                this.f7692b = i3;
                            }
                            return false;
                        }
                        if (!this.f7691a.f7620g.m9514a(v, v3)) {
                            m9755b(interfaceC1141k2, mo9601a);
                            return false;
                        }
                        this.f7694d++;
                        m9739a(k, i, v3, mo9674a.mo9667a(), EnumC1142l.REPLACED);
                        m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) interfaceC1141k2, (InterfaceC1141k<K, V>) k, (K) v2, mo9601a);
                        m9735a(interfaceC1141k2);
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                m9772m();
            }
        }

        @NullableDecl
        /* renamed from: a */
        V m9730a(K k, int i, V v) {
            lock();
            try {
                long mo9601a = this.f7691a.f7630q.mo9601a();
                m9759c(mo9601a);
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        V v2 = mo9674a.get();
                        if (v2 != null) {
                            this.f7694d++;
                            m9739a(k, i, v2, mo9674a.mo9667a(), EnumC1142l.REPLACED);
                            m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) interfaceC1141k2, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                            m9735a(interfaceC1141k2);
                            return v2;
                        }
                        if (mo9674a.mo9672d()) {
                            int i2 = this.f7692b - 1;
                            this.f7694d++;
                            InterfaceC1141k<K, V> m9720a = m9720a(interfaceC1141k, interfaceC1141k2, mo9683d, i, v2, mo9674a, EnumC1142l.COLLECTED);
                            int i3 = this.f7692b - 1;
                            atomicReferenceArray.set(length, m9720a);
                            this.f7692b = i3;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
                m9772m();
            }
        }

        @NullableDecl
        /* renamed from: d */
        V m9761d(Object obj, int i) {
            EnumC1142l enumC1142l;
            lock();
            try {
                m9759c(this.f7691a.f7630q.mo9601a());
                int i2 = this.f7692b - 1;
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(obj, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        V v = mo9674a.get();
                        if (v != null) {
                            enumC1142l = EnumC1142l.EXPLICIT;
                        } else {
                            if (!mo9674a.mo9672d()) {
                                return null;
                            }
                            enumC1142l = EnumC1142l.COLLECTED;
                        }
                        this.f7694d++;
                        InterfaceC1141k<K, V> m9720a = m9720a(interfaceC1141k, interfaceC1141k2, mo9683d, i, v, mo9674a, enumC1142l);
                        int i3 = this.f7692b - 1;
                        atomicReferenceArray.set(length, m9720a);
                        this.f7692b = i3;
                        return v;
                    }
                }
                return null;
            } finally {
                unlock();
                m9772m();
            }
        }

        /* renamed from: b */
        boolean m9756b(Object obj, int i, Object obj2) {
            EnumC1142l enumC1142l;
            lock();
            try {
                m9759c(this.f7691a.f7630q.mo9601a());
                int i2 = this.f7692b - 1;
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(obj, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        V v = mo9674a.get();
                        if (this.f7691a.f7620g.m9514a(obj2, v)) {
                            enumC1142l = EnumC1142l.EXPLICIT;
                        } else {
                            if (v != null || !mo9674a.mo9672d()) {
                                return false;
                            }
                            enumC1142l = EnumC1142l.COLLECTED;
                        }
                        this.f7694d++;
                        InterfaceC1141k<K, V> m9720a = m9720a(interfaceC1141k, interfaceC1141k2, mo9683d, i, v, mo9674a, enumC1142l);
                        int i3 = this.f7692b - 1;
                        atomicReferenceArray.set(length, m9720a);
                        this.f7692b = i3;
                        boolean z = enumC1142l == EnumC1142l.EXPLICIT;
                        unlock();
                        m9772m();
                        return z;
                    }
                }
                return false;
            } finally {
                unlock();
                m9772m();
            }
        }

        /* renamed from: a */
        boolean m9744a(K k, int i, j<K, V> jVar, V v) {
            lock();
            try {
                long mo9601a = this.f7691a.f7630q.mo9601a();
                m9759c(mo9601a);
                int i2 = this.f7692b + 1;
                if (i2 > this.f7695e) {
                    m9769j();
                    i2 = this.f7692b + 1;
                }
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        w<K, V> mo9674a = interfaceC1141k2.mo9674a();
                        V v2 = mo9674a.get();
                        if (jVar != mo9674a && (v2 != null || mo9674a == ConcurrentMapC1137g.f7613u)) {
                            m9739a(k, i, v, 0, EnumC1142l.REPLACED);
                            return false;
                        }
                        this.f7694d++;
                        if (jVar.mo9672d()) {
                            m9739a(k, i, v2, jVar.mo9667a(), v2 == null ? EnumC1142l.COLLECTED : EnumC1142l.REPLACED);
                            i2--;
                        }
                        m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) interfaceC1141k2, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                        this.f7692b = i2;
                        m9735a(interfaceC1141k2);
                        return true;
                    }
                }
                this.f7694d++;
                InterfaceC1141k<K, V> m9722a = m9722a((n<K, V>) k, i, (InterfaceC1141k<n<K, V>, V>) interfaceC1141k);
                m9738a((InterfaceC1141k<InterfaceC1141k<K, V>, K>) m9722a, (InterfaceC1141k<K, V>) k, (K) v, mo9601a);
                atomicReferenceArray.set(length, m9722a);
                this.f7692b = i2;
                m9735a(m9722a);
                return true;
            } finally {
                unlock();
                m9772m();
            }
        }

        /* renamed from: k */
        void m9770k() {
            if (this.f7692b != 0) {
                lock();
                try {
                    m9759c(this.f7691a.f7630q.mo9601a());
                    AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(i); interfaceC1141k != null; interfaceC1141k = interfaceC1141k.mo9678b()) {
                            if (interfaceC1141k.mo9674a().mo9672d()) {
                                K mo9683d = interfaceC1141k.mo9683d();
                                V v = interfaceC1141k.mo9674a().get();
                                m9739a(mo9683d, interfaceC1141k.mo9681c(), v, interfaceC1141k.mo9674a().mo9667a(), (mo9683d == null || v == null) ? EnumC1142l.COLLECTED : EnumC1142l.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    m9764e();
                    this.f7702l.clear();
                    this.f7703m.clear();
                    this.f7701k.set(0);
                    this.f7694d++;
                    this.f7692b = 0;
                } finally {
                    unlock();
                    m9772m();
                }
            }
        }

        @NullableDecl
        @GuardedBy("this")
        /* renamed from: a */
        InterfaceC1141k<K, V> m9720a(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2, @NullableDecl K k, int i, V v, w<K, V> wVar, EnumC1142l enumC1142l) {
            m9739a(k, i, v, wVar.mo9667a(), enumC1142l);
            this.f7702l.remove(interfaceC1141k2);
            this.f7703m.remove(interfaceC1141k2);
            if (!wVar.mo9671c()) {
                return m9748b(interfaceC1141k, interfaceC1141k2);
            }
            wVar.mo9669a(null);
            return interfaceC1141k;
        }

        @NullableDecl
        @GuardedBy("this")
        /* renamed from: b */
        InterfaceC1141k<K, V> m9748b(InterfaceC1141k<K, V> interfaceC1141k, InterfaceC1141k<K, V> interfaceC1141k2) {
            int i = this.f7692b;
            InterfaceC1141k<K, V> mo9678b = interfaceC1141k2.mo9678b();
            while (interfaceC1141k != interfaceC1141k2) {
                InterfaceC1141k<K, V> m9719a = m9719a(interfaceC1141k, mo9678b);
                if (m9719a == null) {
                    m9754b(interfaceC1141k);
                    i--;
                    m9719a = mo9678b;
                }
                interfaceC1141k = interfaceC1141k.mo9678b();
                mo9678b = m9719a;
            }
            this.f7692b = i;
            return mo9678b;
        }

        @GuardedBy("this")
        /* renamed from: b */
        void m9754b(InterfaceC1141k<K, V> interfaceC1141k) {
            m9739a(interfaceC1141k.mo9683d(), interfaceC1141k.mo9681c(), interfaceC1141k.mo9674a().get(), interfaceC1141k.mo9674a().mo9667a(), EnumC1142l.COLLECTED);
            this.f7702l.remove(interfaceC1141k);
            this.f7703m.remove(interfaceC1141k);
        }

        /* renamed from: a */
        boolean m9741a(InterfaceC1141k<K, V> interfaceC1141k, int i) {
            lock();
            try {
                int i2 = this.f7692b - 1;
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k2 = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k3 = interfaceC1141k2; interfaceC1141k3 != null; interfaceC1141k3 = interfaceC1141k3.mo9678b()) {
                    if (interfaceC1141k3 == interfaceC1141k) {
                        this.f7694d++;
                        InterfaceC1141k<K, V> m9720a = m9720a(interfaceC1141k2, interfaceC1141k3, interfaceC1141k3.mo9683d(), i, interfaceC1141k3.mo9674a().get(), interfaceC1141k3.mo9674a(), EnumC1142l.COLLECTED);
                        int i3 = this.f7692b - 1;
                        atomicReferenceArray.set(length, m9720a);
                        this.f7692b = i3;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                m9772m();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        
            if (r2.mo9674a() != r13) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            r10.f7694d++;
            r0 = m9720a(r1, r2, r3, r12, r13.get(), r13, com.p129f.p130a.p132b.EnumC1142l.COLLECTED);
            r1 = r10.f7692b - 1;
            r8.set(r9, r0);
            r10.f7692b = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
        
            r0 = true;
            unlock();
            r1 = isHeldByCurrentThread();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        
            unlock();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        
            if (isHeldByCurrentThread() != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        
            m9772m();
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        boolean m9745a(K k, int i, w<K, V> wVar) {
            boolean z = false;
            lock();
            try {
                int i2 = this.f7692b - 1;
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k;
                while (true) {
                    if (interfaceC1141k2 != null) {
                        K mo9683d = interfaceC1141k2.mo9683d();
                        if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                            break;
                        }
                        interfaceC1141k2 = interfaceC1141k2.mo9678b();
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            m9772m();
                        }
                    }
                }
                return z;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    m9772m();
                }
            }
        }

        /* renamed from: a */
        boolean m9743a(K k, int i, j<K, V> jVar) {
            lock();
            try {
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
                int length = i & (atomicReferenceArray.length() - 1);
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(length);
                for (InterfaceC1141k<K, V> interfaceC1141k2 = interfaceC1141k; interfaceC1141k2 != null; interfaceC1141k2 = interfaceC1141k2.mo9678b()) {
                    K mo9683d = interfaceC1141k2.mo9683d();
                    if (interfaceC1141k2.mo9681c() == i && mo9683d != null && this.f7691a.f7619f.m9514a(k, mo9683d)) {
                        if (interfaceC1141k2.mo9674a() != jVar) {
                            return false;
                        }
                        if (jVar.mo9672d()) {
                            interfaceC1141k2.mo9676a(jVar.m9716g());
                        } else {
                            atomicReferenceArray.set(length, m9748b(interfaceC1141k, interfaceC1141k2));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                m9772m();
            }
        }

        @GuardedBy("this")
        /* renamed from: a */
        boolean m9742a(InterfaceC1141k<K, V> interfaceC1141k, int i, EnumC1142l enumC1142l) {
            int i2 = this.f7692b - 1;
            AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7696f;
            int length = i & (atomicReferenceArray.length() - 1);
            InterfaceC1141k<K, V> interfaceC1141k2 = atomicReferenceArray.get(length);
            for (InterfaceC1141k<K, V> interfaceC1141k3 = interfaceC1141k2; interfaceC1141k3 != null; interfaceC1141k3 = interfaceC1141k3.mo9678b()) {
                if (interfaceC1141k3 == interfaceC1141k) {
                    this.f7694d++;
                    InterfaceC1141k<K, V> m9720a = m9720a(interfaceC1141k2, interfaceC1141k3, interfaceC1141k3.mo9683d(), i, interfaceC1141k3.mo9674a().get(), interfaceC1141k3.mo9674a(), enumC1142l);
                    int i3 = this.f7692b - 1;
                    atomicReferenceArray.set(length, m9720a);
                    this.f7692b = i3;
                    return true;
                }
            }
            return false;
        }

        /* renamed from: l */
        void m9771l() {
            if ((this.f7701k.incrementAndGet() & 63) == 0) {
                m9773n();
            }
        }

        @GuardedBy("this")
        /* renamed from: c */
        void m9759c(long j) {
            m9763d(j);
        }

        /* renamed from: m */
        void m9772m() {
            m9774o();
        }

        /* renamed from: n */
        void m9773n() {
            m9763d(this.f7691a.f7630q.mo9601a());
            m9774o();
        }

        /* renamed from: d */
        void m9763d(long j) {
            if (tryLock()) {
                try {
                    m9752b();
                    m9753b(j);
                    this.f7701k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        /* renamed from: o */
        void m9774o() {
            if (!isHeldByCurrentThread()) {
                this.f7691a.m9665r();
            }
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$j */
    static class j<K, V> implements w<K, V> {

        /* renamed from: a */
        volatile w<K, V> f7684a;

        /* renamed from: b */
        final C1233l<V> f7685b;

        /* renamed from: c */
        final C1125t f7686c;

        public j() {
            this(ConcurrentMapC1137g.m9638o());
        }

        public j(w<K, V> wVar) {
            this.f7685b = C1233l.m10227h();
            this.f7686c = C1125t.m9582a();
            this.f7684a = wVar;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: c */
        public boolean mo9671c() {
            return true;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: d */
        public boolean mo9672d() {
            return this.f7684a.mo9672d();
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public int mo9667a() {
            return this.f7684a.mo9667a();
        }

        /* renamed from: b */
        public boolean m9714b(@NullableDecl V v) {
            return this.f7685b.mo10203a((C1233l<V>) v);
        }

        /* renamed from: a */
        public boolean m9713a(Throwable th) {
            return this.f7685b.mo10204a(th);
        }

        /* renamed from: b */
        private InterfaceFutureC1231j<V> m9711b(Throwable th) {
            return C1227f.m10223a(th);
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public void mo9669a(@NullableDecl V v) {
            if (v != null) {
                m9714b((j<K, V>) v);
            } else {
                this.f7684a = ConcurrentMapC1137g.m9638o();
            }
        }

        /* renamed from: a */
        public InterfaceFutureC1231j<V> m9712a(K k, AbstractC1134d<? super K, V> abstractC1134d) {
            InterfaceFutureC1231j<V> m9711b;
            try {
                this.f7686c.m9587b();
                V v = this.f7684a.get();
                if (v == null) {
                    V mo9629a = abstractC1134d.mo9629a(k);
                    m9711b = m9714b((j<K, V>) mo9629a) ? this.f7685b : C1227f.m10222a(mo9629a);
                } else {
                    InterfaceFutureC1231j<V> m9628a = abstractC1134d.m9628a(k, v);
                    if (m9628a == null) {
                        m9711b = C1227f.m10222a((Object) null);
                    } else {
                        m9711b = C1227f.m10221a(m9628a, new InterfaceC1112g<V, V>() { // from class: com.f.a.b.g.j.1
                            @Override // com.p129f.p130a.p131a.InterfaceC1112g
                            /* renamed from: a */
                            public V mo9517a(V v2) {
                                j.this.m9714b((j) v2);
                                return v2;
                            }
                        }, C1232k.m10225a());
                    }
                }
            } catch (Throwable th) {
                m9711b = m9713a(th) ? this.f7685b : m9711b(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }
            return m9711b;
        }

        /* renamed from: f */
        public long m9715f() {
            return this.f7686c.m9586a(TimeUnit.NANOSECONDS);
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: e */
        public V mo9673e() {
            return (V) C1235n.m10228a(this.f7685b);
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        public V get() {
            return this.f7684a.get();
        }

        /* renamed from: g */
        public w<K, V> m9716g() {
            return this.f7684a;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: b */
        public InterfaceC1141k<K, V> mo9670b() {
            return null;
        }

        @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.w
        /* renamed from: a */
        public w<K, V> mo9668a(ReferenceQueue<V> referenceQueue, @NullableDecl V v, InterfaceC1141k<K, V> interfaceC1141k) {
            return this;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$ag */
    static final class ag<K, V> extends AbstractQueue<InterfaceC1141k<K, V>> {

        /* renamed from: a */
        final InterfaceC1141k<K, V> f7649a = new b<K, V>() { // from class: com.f.a.b.g.ag.1

            /* renamed from: a */
            InterfaceC1141k<K, V> f7650a = this;

            /* renamed from: b */
            InterfaceC1141k<K, V> f7651b = this;

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: h */
            public long mo9688h() {
                return Long.MAX_VALUE;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: b */
            public void mo9679b(long j) {
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: i */
            public InterfaceC1141k<K, V> mo9689i() {
                return this.f7650a;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: c */
            public void mo9682c(InterfaceC1141k<K, V> interfaceC1141k) {
                this.f7650a = interfaceC1141k;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: j */
            public InterfaceC1141k<K, V> mo9690j() {
                return this.f7651b;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: d */
            public void mo9684d(InterfaceC1141k<K, V> interfaceC1141k) {
                this.f7651b = interfaceC1141k;
            }
        };

        ag() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(InterfaceC1141k<K, V> interfaceC1141k) {
            ConcurrentMapC1137g.m9636b(interfaceC1141k.mo9690j(), interfaceC1141k.mo9689i());
            ConcurrentMapC1137g.m9636b(this.f7649a.mo9690j(), interfaceC1141k);
            ConcurrentMapC1137g.m9636b(interfaceC1141k, this.f7649a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC1141k<K, V> peek() {
            InterfaceC1141k<K, V> mo9689i = this.f7649a.mo9689i();
            if (mo9689i == this.f7649a) {
                return null;
            }
            return mo9689i;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC1141k<K, V> poll() {
            InterfaceC1141k<K, V> mo9689i = this.f7649a.mo9689i();
            if (mo9689i == this.f7649a) {
                return null;
            }
            remove(mo9689i);
            return mo9689i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterfaceC1141k interfaceC1141k = (InterfaceC1141k) obj;
            InterfaceC1141k<K, V> mo9690j = interfaceC1141k.mo9690j();
            InterfaceC1141k<K, V> mo9689i = interfaceC1141k.mo9689i();
            ConcurrentMapC1137g.m9636b(mo9690j, mo9689i);
            ConcurrentMapC1137g.m9637c(interfaceC1141k);
            return mo9689i != m.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ((InterfaceC1141k) obj).mo9689i() != m.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f7649a.mo9689i() == this.f7649a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (InterfaceC1141k<K, V> mo9689i = this.f7649a.mo9689i(); mo9689i != this.f7649a; mo9689i = mo9689i.mo9689i()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            InterfaceC1141k<K, V> mo9689i = this.f7649a.mo9689i();
            while (mo9689i != this.f7649a) {
                InterfaceC1141k<K, V> mo9689i2 = mo9689i.mo9689i();
                ConcurrentMapC1137g.m9637c(mo9689i);
                mo9689i = mo9689i2;
            }
            this.f7649a.mo9682c(this.f7649a);
            this.f7649a.mo9684d(this.f7649a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<InterfaceC1141k<K, V>> iterator() {
            return new AbstractC1192g<InterfaceC1141k<K, V>>(peek()) { // from class: com.f.a.b.g.ag.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.p129f.p130a.p133c.AbstractC1192g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public InterfaceC1141k<K, V> mo9695a(InterfaceC1141k<K, V> interfaceC1141k) {
                    InterfaceC1141k<K, V> mo9689i = interfaceC1141k.mo9689i();
                    if (mo9689i == ag.this.f7649a) {
                        return null;
                    }
                    return mo9689i;
                }
            };
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$c */
    static final class c<K, V> extends AbstractQueue<InterfaceC1141k<K, V>> {

        /* renamed from: a */
        final InterfaceC1141k<K, V> f7657a = new b<K, V>() { // from class: com.f.a.b.g.c.1

            /* renamed from: a */
            InterfaceC1141k<K, V> f7658a = this;

            /* renamed from: b */
            InterfaceC1141k<K, V> f7659b = this;

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: e */
            public long mo9685e() {
                return Long.MAX_VALUE;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: a */
            public void mo9675a(long j) {
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: f */
            public InterfaceC1141k<K, V> mo9686f() {
                return this.f7658a;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: a */
            public void mo9677a(InterfaceC1141k<K, V> interfaceC1141k) {
                this.f7658a = interfaceC1141k;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: g */
            public InterfaceC1141k<K, V> mo9687g() {
                return this.f7659b;
            }

            @Override // com.p129f.p130a.p132b.ConcurrentMapC1137g.b, com.p129f.p130a.p132b.InterfaceC1141k
            /* renamed from: b */
            public void mo9680b(InterfaceC1141k<K, V> interfaceC1141k) {
                this.f7659b = interfaceC1141k;
            }
        };

        c() {
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(InterfaceC1141k<K, V> interfaceC1141k) {
            ConcurrentMapC1137g.m9633a(interfaceC1141k.mo9687g(), interfaceC1141k.mo9686f());
            ConcurrentMapC1137g.m9633a(this.f7657a.mo9687g(), interfaceC1141k);
            ConcurrentMapC1137g.m9633a(interfaceC1141k, this.f7657a);
            return true;
        }

        @Override // java.util.Queue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC1141k<K, V> peek() {
            InterfaceC1141k<K, V> mo9686f = this.f7657a.mo9686f();
            if (mo9686f == this.f7657a) {
                return null;
            }
            return mo9686f;
        }

        @Override // java.util.Queue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InterfaceC1141k<K, V> poll() {
            InterfaceC1141k<K, V> mo9686f = this.f7657a.mo9686f();
            if (mo9686f == this.f7657a) {
                return null;
            }
            remove(mo9686f);
            return mo9686f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterfaceC1141k interfaceC1141k = (InterfaceC1141k) obj;
            InterfaceC1141k<K, V> mo9687g = interfaceC1141k.mo9687g();
            InterfaceC1141k<K, V> mo9686f = interfaceC1141k.mo9686f();
            ConcurrentMapC1137g.m9633a(mo9687g, mo9686f);
            ConcurrentMapC1137g.m9635b(interfaceC1141k);
            return mo9686f != m.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ((InterfaceC1141k) obj).mo9686f() != m.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f7657a.mo9686f() == this.f7657a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            for (InterfaceC1141k<K, V> mo9686f = this.f7657a.mo9686f(); mo9686f != this.f7657a; mo9686f = mo9686f.mo9686f()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            InterfaceC1141k<K, V> mo9686f = this.f7657a.mo9686f();
            while (mo9686f != this.f7657a) {
                InterfaceC1141k<K, V> mo9686f2 = mo9686f.mo9686f();
                ConcurrentMapC1137g.m9635b((InterfaceC1141k) mo9686f);
                mo9686f = mo9686f2;
            }
            this.f7657a.mo9677a(this.f7657a);
            this.f7657a.mo9680b(this.f7657a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<InterfaceC1141k<K, V>> iterator() {
            return new AbstractC1192g<InterfaceC1141k<K, V>>(peek()) { // from class: com.f.a.b.g.c.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.p129f.p130a.p133c.AbstractC1192g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public InterfaceC1141k<K, V> mo9695a(InterfaceC1141k<K, V> interfaceC1141k) {
                    InterfaceC1141k<K, V> mo9686f = interfaceC1141k.mo9686f();
                    if (mo9686f == c.this.f7657a) {
                        return null;
                    }
                    return mo9686f;
                }
            };
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        n<K, V>[] nVarArr = this.f7617d;
        long j2 = 0;
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            if (nVarArr[i2].f7692b != 0) {
                return false;
            }
            j2 += nVarArr[i2].f7694d;
        }
        if (j2 != 0) {
            for (int i3 = 0; i3 < nVarArr.length; i3++) {
                if (nVarArr[i3].f7692b != 0) {
                    return false;
                }
                j2 -= nVarArr[i3].f7694d;
            }
            if (j2 != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    long m9666s() {
        long j2 = 0;
        for (int i2 = 0; i2 < this.f7617d.length; i2++) {
            j2 += Math.max(0, r4[i2].f7692b);
        }
        return j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return C1219c.m10174a(m9666s());
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int m9641a = m9641a(obj);
        return m9648b(m9641a).m9725a(obj, m9641a);
    }

    /* renamed from: a */
    V m9644a(K k2, AbstractC1134d<? super K, V> abstractC1134d) {
        int m9641a = m9641a(C1120o.m9547a(k2));
        return m9648b(m9641a).m9726a((n<K, V>) k2, m9641a, (AbstractC1134d<? super n<K, V>, V>) abstractC1134d);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @NullableDecl
    public V getOrDefault(@NullableDecl Object obj, @NullableDecl V v2) {
        V v3 = get(obj);
        return v3 != null ? v3 : v2;
    }

    /* renamed from: b */
    V m9649b(K k2) {
        return m9644a((ConcurrentMapC1137g<K, V>) k2, (AbstractC1134d<? super ConcurrentMapC1137g<K, V>, V>) this.f7633t);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        int m9641a = m9641a(obj);
        return m9648b(m9641a).m9760c(obj, m9641a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        r8 = r8 + r16.f7694d;
        r6 = r6 + 1;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean containsValue(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        long mo9601a = this.f7630q.mo9601a();
        n<K, V>[] nVarArr = this.f7617d;
        long j2 = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            long j3 = j2;
            if (i3 >= 3) {
                break;
            }
            j2 = 0;
            int length = nVarArr.length;
            int i4 = 0;
            while (i4 < length) {
                n<K, V> nVar = nVarArr[i4];
                int i5 = nVar.f7692b;
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = nVar.f7696f;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < atomicReferenceArray.length()) {
                        for (InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(i7); interfaceC1141k != null; interfaceC1141k = interfaceC1141k.mo9678b()) {
                            V m9757c = nVar.m9757c(interfaceC1141k, mo9601a);
                            if (m9757c != null && this.f7620g.m9514a(obj, m9757c)) {
                                return true;
                            }
                        }
                        i6 = i7 + 1;
                    }
                }
            }
            if (j2 == j3) {
                break;
            }
            i2 = i3 + 1;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v2) {
        C1120o.m9547a(k2);
        C1120o.m9547a(v2);
        int m9641a = m9641a(k2);
        return m9648b(m9641a).m9731a((n<K, V>) k2, m9641a, (int) v2, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k2, V v2) {
        C1120o.m9547a(k2);
        C1120o.m9547a(v2);
        int m9641a = m9641a(k2);
        return m9648b(m9641a).m9731a((n<K, V>) k2, m9641a, (int) v2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int m9641a = m9641a(obj);
        return m9648b(m9641a).m9761d(obj, m9641a);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int m9641a = m9641a(obj);
        return m9648b(m9641a).m9756b(obj, m9641a, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        C1120o.m9547a(k2);
        C1120o.m9547a(v3);
        if (v2 == null) {
            return false;
        }
        int m9641a = m9641a(k2);
        return m9648b(m9641a).m9746a((n<K, V>) k2, m9641a, v2, v3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k2, V v2) {
        C1120o.m9547a(k2);
        C1120o.m9547a(v2);
        int m9641a = m9641a(k2);
        return m9648b(m9641a).m9730a((n<K, V>) k2, m9641a, (int) v2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (n<K, V> nVar : this.f7617d) {
            nVar.m9770k();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f7634w;
        if (set != null) {
            return set;
        }
        i iVar = new i(this);
        this.f7634w = iVar;
        return iVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f7635x;
        if (collection != null) {
            return collection;
        }
        x xVar = new x(this);
        this.f7635x = xVar;
        return xVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f7636y;
        if (set != null) {
            return set;
        }
        f fVar = new f(this);
        this.f7636y = fVar;
        return fVar;
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$g */
    abstract class g<T> implements Iterator<T> {

        /* renamed from: b */
        int f7674b;

        /* renamed from: c */
        int f7675c = -1;

        /* renamed from: d */
        @MonotonicNonNullDecl
        n<K, V> f7676d;

        /* renamed from: e */
        @MonotonicNonNullDecl
        AtomicReferenceArray<InterfaceC1141k<K, V>> f7677e;

        /* renamed from: f */
        @NullableDecl
        InterfaceC1141k<K, V> f7678f;

        /* renamed from: g */
        @NullableDecl
        ConcurrentMapC1137g<K, V>.ah f7679g;

        /* renamed from: h */
        @NullableDecl
        ConcurrentMapC1137g<K, V>.ah f7680h;

        g() {
            this.f7674b = ConcurrentMapC1137g.this.f7617d.length - 1;
            m9707b();
        }

        /* renamed from: b */
        final void m9707b() {
            this.f7679g = null;
            if (!m9708c() && !m9709d()) {
                while (this.f7674b >= 0) {
                    n<K, V>[] nVarArr = ConcurrentMapC1137g.this.f7617d;
                    int i = this.f7674b;
                    this.f7674b = i - 1;
                    this.f7676d = nVarArr[i];
                    if (this.f7676d.f7692b != 0) {
                        this.f7677e = this.f7676d.f7696f;
                        this.f7675c = this.f7677e.length() - 1;
                        if (m9709d()) {
                            return;
                        }
                    }
                }
            }
        }

        /* renamed from: c */
        boolean m9708c() {
            if (this.f7678f != null) {
                this.f7678f = this.f7678f.mo9678b();
                while (this.f7678f != null) {
                    if (!m9706a(this.f7678f)) {
                        this.f7678f = this.f7678f.mo9678b();
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: d */
        boolean m9709d() {
            while (this.f7675c >= 0) {
                AtomicReferenceArray<InterfaceC1141k<K, V>> atomicReferenceArray = this.f7677e;
                int i = this.f7675c;
                this.f7675c = i - 1;
                InterfaceC1141k<K, V> interfaceC1141k = atomicReferenceArray.get(i);
                this.f7678f = interfaceC1141k;
                if (interfaceC1141k != null && (m9706a(this.f7678f) || m9708c())) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        boolean m9706a(InterfaceC1141k<K, V> interfaceC1141k) {
            n<K, V> nVar;
            try {
                long mo9601a = ConcurrentMapC1137g.this.f7630q.mo9601a();
                K mo9683d = interfaceC1141k.mo9683d();
                Object m9643a = ConcurrentMapC1137g.this.m9643a(interfaceC1141k, mo9601a);
                if (m9643a != null) {
                    this.f7679g = new ah(mo9683d, m9643a);
                    return true;
                }
                return false;
            } finally {
                this.f7676d.m9771l();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7679g != null;
        }

        /* renamed from: e */
        ConcurrentMapC1137g<K, V>.ah m9710e() {
            if (this.f7679g == null) {
                throw new NoSuchElementException();
            }
            this.f7680h = this.f7679g;
            m9707b();
            return this.f7680h;
        }

        @Override // java.util.Iterator
        public void remove() {
            C1120o.m9558b(this.f7680h != null);
            ConcurrentMapC1137g.this.remove(this.f7680h.getKey());
            this.f7680h = null;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$h */
    final class h extends ConcurrentMapC1137g<K, V>.g<K> {
        h() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return m9710e().getKey();
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$v */
    final class v extends ConcurrentMapC1137g<K, V>.g<V> {
        v() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return m9710e().getValue();
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$ah */
    final class ah implements Map.Entry<K, V> {

        /* renamed from: a */
        final K f7654a;

        /* renamed from: b */
        V f7655b;

        ah(K k, V v) {
            this.f7654a = k;
            this.f7655b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f7654a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f7655b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f7654a.equals(entry.getKey()) && this.f7655b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f7654a.hashCode() ^ this.f7655b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) ConcurrentMapC1137g.this.put(this.f7654a, v);
            this.f7655b = v;
            return v2;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$e */
    final class e extends ConcurrentMapC1137g<K, V>.g<Map.Entry<K, V>> {
        e() {
            super();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return m9710e();
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$a */
    abstract class a<T> extends AbstractSet<T> {

        /* renamed from: a */
        @Weak
        final ConcurrentMap<?, ?> f7637a;

        a(ConcurrentMap<?, ?> concurrentMap) {
            this.f7637a = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7637a.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f7637a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7637a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ConcurrentMapC1137g.m9634b((Collection) this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) ConcurrentMapC1137g.m9634b((Collection) this).toArray(eArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <E> ArrayList<E> m9634b(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        C1154ag.m9890a(arrayList, collection.iterator());
        return arrayList;
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$i */
    final class i extends ConcurrentMapC1137g<K, V>.a<K> {
        i(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f7637a.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f7637a.remove(obj) != null;
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$x */
    final class x extends AbstractCollection<V> {

        /* renamed from: b */
        private final ConcurrentMap<?, ?> f7734b;

        x(ConcurrentMap<?, ?> concurrentMap) {
            this.f7734b = concurrentMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f7734b.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f7734b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f7734b.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new v();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f7734b.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return ConcurrentMapC1137g.m9634b((Collection) this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <E> E[] toArray(E[] eArr) {
            return (E[]) ConcurrentMapC1137g.m9634b((Collection) this).toArray(eArr);
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$f */
    final class f extends ConcurrentMapC1137g<K, V>.a<Map.Entry<K, V>> {
        f(ConcurrentMap<?, ?> concurrentMap) {
            super(concurrentMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = ConcurrentMapC1137g.this.get(key)) != null && ConcurrentMapC1137g.this.f7620g.m9514a(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && ConcurrentMapC1137g.this.remove(key, entry.getValue());
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$l */
    static class l<K, V> implements InterfaceC1132b<K, V>, Serializable {

        /* renamed from: a */
        final ConcurrentMapC1137g<K, V> f7688a;

        private l(ConcurrentMapC1137g<K, V> concurrentMapC1137g) {
            this.f7688a = concurrentMapC1137g;
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1132b
        /* renamed from: a */
        public void mo9607a(K k, V v) {
            this.f7688a.put(k, v);
        }
    }

    /* compiled from: LocalCache.java */
    /* renamed from: com.f.a.b.g$k */
    static class k<K, V> extends l<K, V> implements InterfaceC1136f<K, V> {
        k(C1133c<? super K, ? super V> c1133c, AbstractC1134d<? super K, V> abstractC1134d) {
            super();
        }

        /* renamed from: c */
        public V m9717c(K k) {
            return this.f7688a.m9649b((ConcurrentMapC1137g<K, V>) k);
        }

        @Override // com.p129f.p130a.p132b.InterfaceC1136f
        /* renamed from: b */
        public V mo9630b(K k) {
            try {
                return m9717c(k);
            } catch (ExecutionException e2) {
                throw new C1234m(e2.getCause());
            }
        }

        @Override // com.p129f.p130a.p131a.InterfaceC1112g
        /* renamed from: a */
        public final V mo9517a(K k) {
            return mo9630b(k);
        }
    }
}
