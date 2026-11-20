package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0936r;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1021l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: LocalList.java */
/* renamed from: com.b.b.c.b.q */
/* loaded from: classes.dex */
public final class C0815q extends C1021l {

    /* renamed from: a */
    public static final C0815q f5065a = new C0815q(0);

    /* compiled from: LocalList.java */
    /* renamed from: com.b.b.c.b.q$a */
    public enum a {
        START,
        END_SIMPLY,
        END_REPLACED,
        END_MOVED,
        END_CLOBBERED_BY_PREV,
        END_CLOBBERED_BY_NEXT
    }

    public C0815q(int i) {
        super(i);
    }

    /* renamed from: a */
    public b m7100a(int i) {
        return (b) m8548e(i);
    }

    /* renamed from: a */
    public void m7101a(int i, b bVar) {
        m8546a(i, (Object) bVar);
    }

    /* compiled from: LocalList.java */
    /* renamed from: com.b.b.c.b.q$b */
    public static class b implements Comparable<b> {

        /* renamed from: a */
        private final int f5073a;

        /* renamed from: b */
        private final a f5074b;

        /* renamed from: c */
        private final C0934p f5075c;

        /* renamed from: d */
        private final C0971y f5076d;

        public b(int i, a aVar, C0934p c0934p) {
            if (i < 0) {
                throw new IllegalArgumentException("address < 0");
            }
            if (aVar == null) {
                throw new NullPointerException("disposition == null");
            }
            try {
                if (c0934p.m7933i() == null) {
                    throw new NullPointerException("spec.getLocalItem() == null");
                }
                this.f5073a = i;
                this.f5074b = aVar;
                this.f5075c = c0934p;
                this.f5076d = C0971y.m8089b(c0934p.mo6695a());
            } catch (NullPointerException e2) {
                throw new NullPointerException("spec == null");
            }
        }

        public String toString() {
            return Integer.toHexString(this.f5073a) + " " + this.f5074b + " " + this.f5075c;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && compareTo((b) obj) == 0;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (this.f5073a < bVar.f5073a) {
                return -1;
            }
            if (this.f5073a > bVar.f5073a) {
                return 1;
            }
            boolean m7108c = m7108c();
            if (m7108c != bVar.m7108c()) {
                return !m7108c ? -1 : 1;
            }
            return this.f5075c.compareTo(bVar.f5075c);
        }

        /* renamed from: a */
        public int m7102a() {
            return this.f5073a;
        }

        /* renamed from: b */
        public a m7106b() {
            return this.f5074b;
        }

        /* renamed from: c */
        public boolean m7108c() {
            return this.f5074b == a.START;
        }

        /* renamed from: d */
        public C0970x m7109d() {
            return this.f5075c.m7933i().m7897a();
        }

        /* renamed from: e */
        public C0970x m7110e() {
            return this.f5075c.m7933i().m7898b();
        }

        /* renamed from: f */
        public C0971y m7111f() {
            return this.f5076d;
        }

        /* renamed from: g */
        public int m7112g() {
            return this.f5075c.m7931g();
        }

        /* renamed from: h */
        public C0934p m7113h() {
            return this.f5075c;
        }

        /* renamed from: a */
        public boolean m7105a(C0934p c0934p) {
            return this.f5075c.m7926a(c0934p);
        }

        /* renamed from: b */
        public boolean m7107b(b bVar) {
            return m7105a(bVar.f5075c);
        }

        /* renamed from: a */
        public b m7104a(a aVar) {
            return aVar == this.f5074b ? this : new b(this.f5073a, aVar, this.f5075c);
        }
    }

    /* renamed from: a */
    public static C0815q m7099a(C0808j c0808j) {
        int f_ = c0808j.m8550f_();
        c cVar = new c(f_);
        for (int i = 0; i < f_; i++) {
            AbstractC0807i m7049a = c0808j.m7049a(i);
            if (m7049a instanceof C0816r) {
                cVar.m7122a(m7049a.m7040g(), ((C0816r) m7049a).m7124c());
            } else if (m7049a instanceof C0817s) {
                cVar.m7120a(m7049a.m7040g(), ((C0817s) m7049a).m7126c());
            } else if (m7049a instanceof C0814p) {
                cVar.m7123b(m7049a.m7040g(), ((C0814p) m7049a).m7098c());
            }
        }
        return cVar.m7119a();
    }

    /* compiled from: LocalList.java */
    /* renamed from: com.b.b.c.b.q$c */
    public static class c {

        /* renamed from: a */
        private final ArrayList<b> f5077a;

        /* renamed from: b */
        private int f5078b = 0;

        /* renamed from: c */
        private C0936r f5079c = null;

        /* renamed from: d */
        private int[] f5080d = null;

        /* renamed from: e */
        private int f5081e = 0;

        public c(int i) {
            this.f5077a = new ArrayList<>(i);
        }

        /* renamed from: a */
        private void m7115a(int i, int i2) {
            boolean z = this.f5080d == null;
            if (i != this.f5081e || z) {
                if (i < this.f5081e) {
                    throw new RuntimeException("shouldn't happen");
                }
                if (z || i2 >= this.f5080d.length) {
                    int i3 = i2 + 1;
                    C0936r c0936r = new C0936r(i3);
                    int[] iArr = new int[i3];
                    Arrays.fill(iArr, -1);
                    if (!z) {
                        c0936r.m7959a(this.f5079c);
                        System.arraycopy(this.f5080d, 0, iArr, 0, this.f5080d.length);
                    }
                    this.f5079c = c0936r;
                    this.f5080d = iArr;
                }
            }
        }

        /* renamed from: a */
        public void m7122a(int i, C0936r c0936r) {
            int m7961b = c0936r.m7961b();
            m7115a(i, m7961b - 1);
            for (int i2 = 0; i2 < m7961b; i2++) {
                C0934p m7956a = this.f5079c.m7956a(i2);
                C0934p m7114a = m7114a(c0936r.m7956a(i2));
                if (m7956a == null) {
                    if (m7114a != null) {
                        m7120a(i, m7114a);
                    }
                } else if (m7114a == null) {
                    m7123b(i, m7956a);
                } else if (!m7114a.m7926a(m7956a)) {
                    m7123b(i, m7956a);
                    m7120a(i, m7114a);
                }
            }
        }

        /* renamed from: a */
        public void m7120a(int i, C0934p c0934p) {
            C0934p m7956a;
            C0934p m7956a2;
            int m7931g = c0934p.m7931g();
            C0934p m7114a = m7114a(c0934p);
            m7115a(i, m7931g);
            C0934p m7956a3 = this.f5079c.m7956a(m7931g);
            if (!m7114a.m7926a(m7956a3)) {
                C0934p m7962b = this.f5079c.m7962b(m7114a);
                if (m7962b != null) {
                    m7117b(i, a.END_MOVED, m7962b);
                }
                int i2 = this.f5080d[m7931g];
                if (m7956a3 != null) {
                    m7116a(i, a.END_REPLACED, m7956a3);
                } else if (i2 >= 0) {
                    b bVar = this.f5077a.get(i2);
                    if (bVar.m7102a() == i) {
                        if (bVar.m7105a(m7114a)) {
                            this.f5077a.set(i2, null);
                            this.f5078b++;
                            this.f5079c.m7966d(m7114a);
                            this.f5080d[m7931g] = -1;
                            return;
                        }
                        this.f5077a.set(i2, bVar.m7104a(a.END_REPLACED));
                    }
                }
                if (m7931g > 0 && (m7956a2 = this.f5079c.m7956a(m7931g - 1)) != null && m7956a2.m7936l()) {
                    m7117b(i, a.END_CLOBBERED_BY_NEXT, m7956a2);
                }
                if (m7114a.m7936l() && (m7956a = this.f5079c.m7956a(m7931g + 1)) != null) {
                    m7117b(i, a.END_CLOBBERED_BY_PREV, m7956a);
                }
                m7116a(i, a.START, m7114a);
            }
        }

        /* renamed from: b */
        public void m7123b(int i, C0934p c0934p) {
            m7121a(i, c0934p, a.END_SIMPLY);
        }

        /* renamed from: a */
        public void m7121a(int i, C0934p c0934p, a aVar) {
            int m7931g = c0934p.m7931g();
            C0934p m7114a = m7114a(c0934p);
            m7115a(i, m7931g);
            if (this.f5080d[m7931g] < 0 && !m7118c(i, m7114a)) {
                m7116a(i, aVar, m7114a);
            }
        }

        /* renamed from: c */
        private boolean m7118c(int i, C0934p c0934p) {
            boolean z = false;
            int size = this.f5077a.size() - 1;
            while (size >= 0) {
                b bVar = this.f5077a.get(size);
                if (bVar != null) {
                    if (bVar.m7102a() != i) {
                        return false;
                    }
                    if (bVar.m7105a(c0934p)) {
                        break;
                    }
                }
                size--;
            }
            this.f5079c.m7964c(c0934p);
            this.f5077a.set(size, null);
            this.f5078b++;
            int m7931g = c0934p.m7931g();
            int i2 = size - 1;
            b bVar2 = null;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                bVar2 = this.f5077a.get(i2);
                if (bVar2 != null && bVar2.m7113h().m7931g() == m7931g) {
                    z = true;
                    break;
                }
                i2--;
            }
            if (z) {
                this.f5080d[m7931g] = i2;
                if (bVar2.m7102a() == i) {
                    this.f5077a.set(i2, bVar2.m7104a(a.END_SIMPLY));
                }
            }
            return true;
        }

        /* renamed from: a */
        private static C0934p m7114a(C0934p c0934p) {
            if (c0934p != null && c0934p.mo6695a() == C0975c.f6255j) {
                return c0934p.m7925a(C0975c.f6260o);
            }
            return c0934p;
        }

        /* renamed from: a */
        private void m7116a(int i, a aVar, C0934p c0934p) {
            int m7931g = c0934p.m7931g();
            this.f5077a.add(new b(i, aVar, c0934p));
            if (aVar == a.START) {
                this.f5079c.m7966d(c0934p);
                this.f5080d[m7931g] = -1;
            } else {
                this.f5079c.m7964c(c0934p);
                this.f5080d[m7931g] = this.f5077a.size() - 1;
            }
        }

        /* renamed from: b */
        private void m7117b(int i, a aVar, C0934p c0934p) {
            if (aVar == a.START) {
                throw new RuntimeException("shouldn't happen");
            }
            int i2 = this.f5080d[c0934p.m7931g()];
            if (i2 >= 0) {
                b bVar = this.f5077a.get(i2);
                if (bVar.m7102a() == i && bVar.m7113h().equals(c0934p)) {
                    this.f5077a.set(i2, bVar.m7104a(aVar));
                    this.f5079c.m7964c(c0934p);
                    return;
                }
            }
            m7121a(i, c0934p, aVar);
        }

        /* renamed from: a */
        public C0815q m7119a() {
            int i;
            m7115a(Integer.MAX_VALUE, 0);
            int size = this.f5077a.size();
            int i2 = size - this.f5078b;
            if (i2 == 0) {
                return C0815q.f5065a;
            }
            b[] bVarArr = new b[i2];
            if (size == i2) {
                this.f5077a.toArray(bVarArr);
            } else {
                Iterator<b> it = this.f5077a.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        bVarArr[i3] = next;
                        i = i3 + 1;
                    } else {
                        i = i3;
                    }
                    i3 = i;
                }
            }
            Arrays.sort(bVarArr);
            C0815q c0815q = new C0815q(i2);
            for (int i4 = 0; i4 < i2; i4++) {
                c0815q.m7101a(i4, bVarArr[i4]);
            }
            c0815q.mo6683e_();
            return c0815q;
        }
    }
}
