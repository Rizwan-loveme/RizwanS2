package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C0997n;
import com.p065b.p086b.p108g.C1002s;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: SsaRenamer.java */
/* renamed from: com.b.b.g.w */
/* loaded from: classes.dex */
public class RunnableC1006w implements Runnable {

    /* renamed from: a */
    private final C1005v f6451a;

    /* renamed from: b */
    private int f6452b;

    /* renamed from: c */
    private final int f6453c;

    /* renamed from: d */
    private int f6454d;

    /* renamed from: e */
    private final C0934p[][] f6455e;

    /* renamed from: f */
    private final ArrayList<C0928j> f6456f;

    /* renamed from: d */
    static /* synthetic */ int m8450d(RunnableC1006w runnableC1006w) {
        int i = runnableC1006w.f6452b;
        runnableC1006w.f6452b = i + 1;
        return i;
    }

    public RunnableC1006w(C1005v c1005v) {
        this.f6453c = c1005v.m8424g();
        this.f6451a = c1005v;
        this.f6452b = this.f6453c;
        this.f6454d = 0;
        this.f6455e = new C0934p[c1005v.m8427j().size()][];
        this.f6456f = new ArrayList<>();
        C0934p[] c0934pArr = new C0934p[this.f6453c];
        for (int i = 0; i < this.f6453c; i++) {
            c0934pArr[i] = C0934p.m7913a(i, C0975c.f6254i);
        }
        this.f6455e[c1005v.m8417c()] = c0934pArr;
    }

    public RunnableC1006w(C1005v c1005v, int i) {
        this(c1005v);
        this.f6454d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6451a.m8405a(new C1002s.b() { // from class: com.b.b.g.w.1
            @Override // com.p065b.p086b.p108g.C1002s.b
            /* renamed from: a */
            public void mo8207a(C1002s c1002s, C1002s c1002s2) {
                RunnableC1006w.this.new a(c1002s).m8456a();
            }
        });
        this.f6451a.m8422e(this.f6452b);
        this.f6451a.m8430m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C0934p[] m8446b(C0934p[] c0934pArr) {
        C0934p[] c0934pArr2 = new C0934p[c0934pArr.length];
        System.arraycopy(c0934pArr, 0, c0934pArr2, 0, c0934pArr.length);
        return c0934pArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C0928j m8435a(int i) {
        if (i < this.f6456f.size()) {
            return this.f6456f.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8437a(C0934p c0934p) {
        int m7931g = c0934p.m7931g();
        C0928j m7933i = c0934p.m7933i();
        this.f6456f.ensureCapacity(m7931g + 1);
        while (this.f6456f.size() <= m7931g) {
            this.f6456f.add(null);
        }
        this.f6456f.set(m7931g, m7933i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m8443b(int i) {
        return i < this.f6454d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m8448c(int i) {
        return i < this.f6453c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m8445b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* compiled from: SsaRenamer.java */
    /* renamed from: com.b.b.g.w$a */
    private class a implements AbstractC1004u.a {

        /* renamed from: b */
        private final C1002s f6459b;

        /* renamed from: c */
        private final C0934p[] f6460c;

        /* renamed from: d */
        private final HashSet<AbstractC1004u> f6461d = new HashSet<>();

        /* renamed from: e */
        private final HashMap<AbstractC1004u, AbstractC1004u> f6462e = new HashMap<>();

        /* renamed from: f */
        private final C3335a f6463f = new C3335a();

        a(C1002s c1002s) {
            this.f6459b = c1002s;
            this.f6460c = RunnableC1006w.this.f6455e[c1002s.m8358e()];
            RunnableC1006w.this.f6455e[c1002s.m8358e()] = null;
        }

        /* compiled from: SsaRenamer.java */
        /* renamed from: com.b.b.g.w$a$a, reason: collision with other inner class name */
        private class C3335a extends AbstractC0999p {
            public C3335a() {
            }

            @Override // com.p065b.p086b.p108g.AbstractC0999p
            /* renamed from: a */
            public int mo8139a() {
                return RunnableC1006w.this.f6452b;
            }

            @Override // com.p065b.p086b.p108g.AbstractC0999p
            /* renamed from: a */
            public C0934p mo8141a(C0934p c0934p) {
                if (c0934p == null) {
                    return null;
                }
                return c0934p.m7927b(a.this.f6460c[c0934p.m7931g()].m7931g());
            }
        }

        /* renamed from: a */
        public void m8456a() {
            this.f6459b.m8347a(this);
            m8455b();
            ArrayList<AbstractC1004u> m8353c = this.f6459b.m8353c();
            for (int size = m8353c.size() - 1; size >= 0; size--) {
                AbstractC1004u abstractC1004u = m8353c.get(size);
                AbstractC1004u abstractC1004u2 = this.f6462e.get(abstractC1004u);
                if (abstractC1004u2 != null) {
                    m8353c.set(size, abstractC1004u2);
                } else if (abstractC1004u.mo8291i() && !this.f6461d.contains(abstractC1004u)) {
                    m8353c.remove(size);
                }
            }
            boolean z = true;
            Iterator<C1002s> it = this.f6459b.m8339a().iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    C1002s next = it.next();
                    if (next != this.f6459b) {
                        RunnableC1006w.this.f6455e[next.m8358e()] = z2 ? this.f6460c : RunnableC1006w.m8446b(this.f6460c);
                        z = false;
                    } else {
                        z = z2;
                    }
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        private void m8452a(int i, C0934p c0934p) {
            int m7931g = c0934p.m7931g();
            C0928j m7933i = c0934p.m7933i();
            this.f6460c[i] = c0934p;
            for (int length = this.f6460c.length - 1; length >= 0; length--) {
                if (m7931g == this.f6460c[length].m7931g()) {
                    this.f6460c[length] = c0934p;
                }
            }
            if (m7933i != null) {
                RunnableC1006w.this.m8437a(c0934p);
                for (int length2 = this.f6460c.length - 1; length2 >= 0; length2--) {
                    C0934p c0934p2 = this.f6460c[length2];
                    if (m7931g != c0934p2.m7931g() && m7933i.equals(c0934p2.m7933i())) {
                        this.f6460c[length2] = c0934p2.m7923a((C0928j) null);
                    }
                }
            }
        }

        @Override // com.p065b.p086b.p108g.AbstractC1004u.a
        /* renamed from: a */
        public void mo8177a(C0997n c0997n) {
            m8457a((AbstractC1004u) c0997n);
        }

        @Override // com.p065b.p086b.p108g.AbstractC1004u.a
        /* renamed from: a */
        public void mo8176a(C0995l c0995l) {
            C0934p o = c0995l.m8391o();
            int m7931g = o.m7931g();
            int m7931g2 = c0995l.mo8285b().m7949b(0).m7931g();
            c0995l.mo8283a(this.f6463f);
            int m7931g3 = c0995l.mo8285b().m7949b(0).m7931g();
            C0928j m7933i = this.f6460c[m7931g2].m7933i();
            C0928j m7933i2 = o.m7933i();
            if (m7933i2 == null) {
                m7933i2 = m7933i;
            }
            C0928j m8435a = RunnableC1006w.this.m8435a(m7931g3);
            boolean z = m8435a == null || m7933i2 == null || m7933i2.equals(m8435a);
            C0934p m7918b = C0934p.m7918b(m7931g3, o.mo6695a(), m7933i2);
            if (!C0996m.m8301a() || (z && RunnableC1006w.m8445b(m7933i2, m7933i) && RunnableC1006w.this.f6454d == 0)) {
                m8452a(m7931g, m7918b);
                return;
            }
            if (z && m7933i == null && RunnableC1006w.this.f6454d == 0) {
                this.f6462e.put(c0995l, AbstractC1004u.m8385a(new C0932n(C0939u.m8026s(m7918b), C0940v.f6128a, (C0934p) null, C0935q.m7944a(C0934p.m7914a(m7918b.m7931g(), m7918b.mo6695a(), m7933i2))), this.f6459b));
                m8452a(m7931g, m7918b);
            } else {
                m8457a((AbstractC1004u) c0995l);
                this.f6461d.add(c0995l);
            }
        }

        @Override // com.p065b.p086b.p108g.AbstractC1004u.a
        /* renamed from: b */
        public void mo8178b(C0995l c0995l) {
            c0995l.mo8283a(this.f6463f);
            m8457a((AbstractC1004u) c0995l);
        }

        /* renamed from: a */
        void m8457a(AbstractC1004u abstractC1004u) {
            C0934p m8391o = abstractC1004u.m8391o();
            if (m8391o != null) {
                int m7931g = m8391o.m7931g();
                if (!RunnableC1006w.this.m8443b(m7931g)) {
                    abstractC1004u.m8390c(RunnableC1006w.this.f6452b);
                    m8452a(m7931g, abstractC1004u.m8391o());
                    RunnableC1006w.m8450d(RunnableC1006w.this);
                }
            }
        }

        /* renamed from: b */
        private void m8455b() {
            C0997n.b bVar = new C0997n.b() { // from class: com.b.b.g.w.a.1
                @Override // com.p065b.p086b.p108g.C0997n.b
                /* renamed from: a */
                public void mo8208a(C0997n c0997n) {
                    int m8311h = c0997n.m8311h();
                    if (!RunnableC1006w.this.m8443b(m8311h)) {
                        C0934p c0934p = a.this.f6460c[m8311h];
                        if (!RunnableC1006w.this.m8448c(c0934p.m7931g())) {
                            c0997n.m8308a(c0934p, a.this.f6459b);
                        }
                    }
                }
            };
            BitSet m8363i = this.f6459b.m8363i();
            for (int nextSetBit = m8363i.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8363i.nextSetBit(nextSetBit + 1)) {
                RunnableC1006w.this.f6451a.m8427j().get(nextSetBit).m8345a(bVar);
            }
        }
    }
}
