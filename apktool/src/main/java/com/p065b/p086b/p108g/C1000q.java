package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0922d;
import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.C0959m;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* compiled from: SCCP.java */
/* renamed from: com.b.b.g.q */
/* loaded from: classes.dex */
public class C1000q {

    /* renamed from: a */
    private C1005v f6409a;

    /* renamed from: b */
    private int f6410b;

    /* renamed from: c */
    private int[] f6411c;

    /* renamed from: d */
    private AbstractC0945a[] f6412d;

    /* renamed from: g */
    private BitSet f6415g;

    /* renamed from: e */
    private ArrayList<C1002s> f6413e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<C1002s> f6414f = new ArrayList<>();

    /* renamed from: h */
    private ArrayList<AbstractC1004u> f6416h = new ArrayList<>();

    /* renamed from: i */
    private ArrayList<AbstractC1004u> f6417i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<AbstractC1004u> f6418j = new ArrayList<>();

    private C1000q(C1005v c1005v) {
        this.f6409a = c1005v;
        this.f6410b = c1005v.m8424g();
        this.f6411c = new int[this.f6410b];
        this.f6412d = new AbstractC0945a[this.f6410b];
        this.f6415g = new BitSet(c1005v.m8427j().size());
        for (int i = 0; i < this.f6410b; i++) {
            this.f6411c[i] = 0;
            this.f6412d[i] = null;
        }
    }

    /* renamed from: a */
    public static void m8323a(C1005v c1005v) {
        new C1000q(c1005v).m8318a();
    }

    /* renamed from: a */
    private void m8321a(C1002s c1002s) {
        if (!this.f6415g.get(c1002s.m8358e())) {
            this.f6413e.add(c1002s);
            this.f6415g.set(c1002s.m8358e());
        } else {
            this.f6414f.add(c1002s);
        }
    }

    /* renamed from: a */
    private void m8319a(int i, int i2) {
        if (i2 == 2) {
            Iterator<AbstractC1004u> it = this.f6409a.m8420d(i).iterator();
            while (it.hasNext()) {
                this.f6417i.add(it.next());
            }
            return;
        }
        Iterator<AbstractC1004u> it2 = this.f6409a.m8420d(i).iterator();
        while (it2.hasNext()) {
            this.f6416h.add(it2.next());
        }
    }

    /* renamed from: a */
    private boolean m8324a(int i, int i2, AbstractC0945a abstractC0945a) {
        if (i2 != 1) {
            if (this.f6411c[i] == i2) {
                return false;
            }
            this.f6411c[i] = i2;
            return true;
        }
        if (this.f6411c[i] == i2 && this.f6412d[i].equals(abstractC0945a)) {
            return false;
        }
        this.f6411c[i] = i2;
        this.f6412d[i] = abstractC0945a;
        return true;
    }

    /* renamed from: a */
    private void m8320a(C0997n c0997n) {
        int m7931g = c0997n.m8391o().m7931g();
        if (this.f6411c[m7931g] != 2) {
            C0935q mo8285b = c0997n.mo8285b();
            AbstractC0945a abstractC0945a = null;
            int f_ = mo8285b.m8550f_();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= f_) {
                    break;
                }
                int m8303a = c0997n.m8303a(i);
                int m7931g2 = mo8285b.m7949b(i).m7931g();
                int i3 = this.f6411c[m7931g2];
                if (this.f6415g.get(m8303a)) {
                    if (i3 != 1) {
                        i2 = i3;
                        break;
                    } else if (abstractC0945a == null) {
                        abstractC0945a = this.f6412d[m7931g2];
                        i2 = 1;
                    } else if (!this.f6412d[m7931g2].equals(abstractC0945a)) {
                        i2 = 2;
                        break;
                    }
                }
                i++;
            }
            if (m8324a(m7931g, i2, abstractC0945a)) {
                m8319a(m7931g, i2);
            }
        }
    }

    /* renamed from: b */
    private void m8326b(C1002s c1002s) {
        Iterator<AbstractC1004u> it = c1002s.m8353c().iterator();
        while (it.hasNext()) {
            AbstractC1004u next = it.next();
            if (next instanceof C0997n) {
                m8320a((C0997n) next);
            } else {
                m8327b(next);
            }
        }
    }

    /* renamed from: c */
    private void m8329c(C1002s c1002s) {
        Iterator<AbstractC1004u> it = c1002s.m8353c().iterator();
        while (it.hasNext()) {
            AbstractC1004u next = it.next();
            if (next instanceof C0997n) {
                m8320a((C0997n) next);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012b A[LOOP:0: B:35:0x012b->B:37:0x0135, LOOP_START, PHI: r4
      0x012b: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:29:0x0066, B:37:0x0135] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARN: Type inference failed for: r0v66, types: [com.b.b.f.c.a[]] */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r1v31, types: [com.b.b.f.c.a[]] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m8322a(AbstractC1004u abstractC1004u) {
        boolean z;
        boolean z2;
        int m8569b;
        C0959m c0959m;
        C0937s mo8287e = abstractC1004u.mo8287e();
        C0935q mo8285b = abstractC1004u.mo8285b();
        if (mo8287e.m7971d() == 4) {
            C0934p m7949b = mo8285b.m7949b(0);
            int m7931g = m7949b.m7931g();
            C0959m c0959m2 = (this.f6409a.m8413a(m7949b) || this.f6411c[m7931g] != 1) ? null : this.f6412d[m7931g];
            if (mo8285b.m8550f_() == 2) {
                C0934p m7949b2 = mo8285b.m7949b(1);
                int m7931g2 = m7949b2.m7931g();
                if (!this.f6409a.m8413a(m7949b2) && this.f6411c[m7931g2] == 1) {
                    c0959m = this.f6412d[m7931g2];
                    if (c0959m2 == null && mo8285b.m8550f_() == 1) {
                        switch (c0959m2.mo6697c()) {
                            case 6:
                                int m8061k_ = c0959m2.m8061k_();
                                switch (mo8287e.m7968a()) {
                                    case 7:
                                        z = m8061k_ == 0;
                                        z2 = true;
                                        break;
                                    case 8:
                                        z = m8061k_ != 0;
                                        z2 = true;
                                        break;
                                    case 9:
                                        z = m8061k_ < 0;
                                        z2 = true;
                                        break;
                                    case 10:
                                        z = m8061k_ >= 0;
                                        z2 = true;
                                        break;
                                    case 11:
                                        z = m8061k_ <= 0;
                                        z2 = true;
                                        break;
                                    case 12:
                                        z = m8061k_ > 0;
                                        z2 = true;
                                        break;
                                    default:
                                        throw new RuntimeException("Unexpected op");
                                }
                        }
                    } else if (c0959m2 != null && c0959m != null) {
                        switch (c0959m2.mo6697c()) {
                            case 6:
                                int m8061k_2 = c0959m2.m8061k_();
                                int m8061k_3 = c0959m.m8061k_();
                                switch (mo8287e.m7968a()) {
                                    case 7:
                                        z = m8061k_2 == m8061k_3;
                                        z2 = true;
                                        break;
                                    case 8:
                                        z = m8061k_2 != m8061k_3;
                                        z2 = true;
                                        break;
                                    case 9:
                                        z = m8061k_2 < m8061k_3;
                                        z2 = true;
                                        break;
                                    case 10:
                                        z = m8061k_2 >= m8061k_3;
                                        z2 = true;
                                        break;
                                    case 11:
                                        z = m8061k_2 <= m8061k_3;
                                        z2 = true;
                                        break;
                                    case 12:
                                        z = m8061k_2 > m8061k_3;
                                        z2 = true;
                                        break;
                                    default:
                                        throw new RuntimeException("Unexpected op");
                                }
                        }
                    }
                    C1002s m8392p = abstractC1004u.m8392p();
                    if (z2) {
                        if (z) {
                            m8569b = m8392p.m8364j().m8569b(1);
                        } else {
                            m8569b = m8392p.m8364j().m8569b(0);
                        }
                        m8321a(this.f6409a.m8427j().get(m8569b));
                        this.f6418j.add(abstractC1004u);
                        return;
                    }
                    for (int i = 0; i < m8392p.m8364j().m8568b(); i++) {
                        m8321a(this.f6409a.m8427j().get(m8392p.m8364j().m8569b(i)));
                    }
                    return;
                }
            }
            c0959m = null;
            if (c0959m2 == null) {
            }
            if (c0959m2 != null) {
                switch (c0959m2.mo6697c()) {
                }
                C1002s m8392p2 = abstractC1004u.m8392p();
                if (z2) {
                }
            }
        }
        z = false;
        z2 = false;
        C1002s m8392p22 = abstractC1004u.m8392p();
        if (z2) {
        }
    }

    /* renamed from: a */
    private AbstractC0945a m8317a(AbstractC1004u abstractC1004u, int i) {
        AbstractC0945a abstractC0945a;
        int i2;
        boolean z;
        AbstractC0926h mo8288f = abstractC1004u.mo8288f();
        int m7968a = abstractC1004u.mo8287e().m7968a();
        C0935q mo8285b = abstractC1004u.mo8285b();
        int m7931g = mo8285b.m7949b(0).m7931g();
        AbstractC0945a abstractC0945a2 = this.f6411c[m7931g] != 1 ? null : this.f6412d[m7931g];
        if (mo8285b.m8550f_() == 1) {
            abstractC0945a = ((AbstractC0922d) mo8288f).m7868i_();
        } else {
            int m7931g2 = mo8285b.m7949b(1).m7931g();
            abstractC0945a = this.f6411c[m7931g2] != 1 ? null : this.f6412d[m7931g2];
        }
        if (abstractC0945a2 == null || abstractC0945a == null) {
            return null;
        }
        switch (i) {
            case 6:
                int m8061k_ = ((C0959m) abstractC0945a2).m8061k_();
                int m8061k_2 = ((C0959m) abstractC0945a).m8061k_();
                switch (m7968a) {
                    case 14:
                        i2 = m8061k_ + m8061k_2;
                        z = false;
                        break;
                    case 15:
                        if (mo8285b.m8550f_() == 1) {
                            i2 = m8061k_2 - m8061k_;
                            z = false;
                            break;
                        } else {
                            i2 = m8061k_ - m8061k_2;
                            z = false;
                            break;
                        }
                    case 16:
                        i2 = m8061k_ * m8061k_2;
                        z = false;
                        break;
                    case 17:
                        if (m8061k_2 != 0) {
                            i2 = m8061k_ / m8061k_2;
                            z = false;
                            break;
                        } else {
                            z = true;
                            i2 = 0;
                            break;
                        }
                    case 18:
                        if (m8061k_2 != 0) {
                            i2 = m8061k_ % m8061k_2;
                            z = false;
                            break;
                        } else {
                            z = true;
                            i2 = 0;
                            break;
                        }
                    case 19:
                    default:
                        throw new RuntimeException("Unexpected op");
                    case 20:
                        i2 = m8061k_ & m8061k_2;
                        z = false;
                        break;
                    case 21:
                        i2 = m8061k_ | m8061k_2;
                        z = false;
                        break;
                    case 22:
                        i2 = m8061k_ ^ m8061k_2;
                        z = false;
                        break;
                    case 23:
                        i2 = m8061k_ << m8061k_2;
                        z = false;
                        break;
                    case 24:
                        i2 = m8061k_ >> m8061k_2;
                        z = false;
                        break;
                    case 25:
                        i2 = m8061k_ >>> m8061k_2;
                        z = false;
                        break;
                }
                if (z) {
                    return null;
                }
                return C0959m.m8060a(i2);
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: b */
    private void m8327b(AbstractC1004u abstractC1004u) {
        int i;
        AbstractC0945a abstractC0945a;
        AbstractC0926h mo8288f = abstractC1004u.mo8288f();
        if (mo8288f.m7882f().m7971d() != 1 || mo8288f.m7882f().m7972e()) {
            m8322a(abstractC1004u);
        }
        int m7968a = abstractC1004u.mo8287e().m7968a();
        C0934p m8391o = abstractC1004u.m8391o();
        if (m8391o == null) {
            if (m7968a == 17 || m7968a == 18) {
                m8391o = abstractC1004u.m8392p().m8367m().m8353c().get(0).m8391o();
            } else {
                return;
            }
        }
        int m7931g = m8391o.m7931g();
        switch (m7968a) {
            case 2:
                if (abstractC1004u.mo8285b().m8550f_() == 1) {
                    int m7931g2 = abstractC1004u.mo8285b().m7949b(0).m7931g();
                    i = this.f6411c[m7931g2];
                    abstractC0945a = this.f6412d[m7931g2];
                    break;
                }
                abstractC0945a = null;
                i = 2;
                break;
            case 5:
                abstractC0945a = ((AbstractC0922d) mo8288f).m7868i_();
                i = 1;
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                abstractC0945a = m8317a(abstractC1004u, m8391o.mo6697c());
                if (abstractC0945a == null) {
                    i = 2;
                    break;
                } else {
                    i = 1;
                    break;
                }
            case 56:
                if (this.f6411c[m7931g] == 1) {
                    i = this.f6411c[m7931g];
                    abstractC0945a = this.f6412d[m7931g];
                    break;
                }
                abstractC0945a = null;
                i = 2;
                break;
            default:
                abstractC0945a = null;
                i = 2;
                break;
        }
        if (m8324a(m7931g, i, abstractC0945a)) {
            m8319a(m7931g, i);
        }
    }

    /* renamed from: a */
    private void m8318a() {
        m8321a(this.f6409a.m8419d());
        while (true) {
            if (!this.f6413e.isEmpty() || !this.f6414f.isEmpty() || !this.f6416h.isEmpty() || !this.f6417i.isEmpty()) {
                while (!this.f6413e.isEmpty()) {
                    m8326b(this.f6413e.remove(this.f6413e.size() - 1));
                }
                while (!this.f6414f.isEmpty()) {
                    m8329c(this.f6414f.remove(this.f6414f.size() - 1));
                }
                while (!this.f6417i.isEmpty()) {
                    AbstractC1004u remove = this.f6417i.remove(this.f6417i.size() - 1);
                    if (this.f6415g.get(remove.m8392p().m8358e())) {
                        if (remove instanceof C0997n) {
                            m8320a((C0997n) remove);
                        } else {
                            m8327b(remove);
                        }
                    }
                }
                while (!this.f6416h.isEmpty()) {
                    AbstractC1004u remove2 = this.f6416h.remove(this.f6416h.size() - 1);
                    if (this.f6415g.get(remove2.m8392p().m8358e())) {
                        if (remove2 instanceof C0997n) {
                            m8320a((C0997n) remove2);
                        } else {
                            m8327b(remove2);
                        }
                    }
                }
            } else {
                m8325b();
                m8328c();
                return;
            }
        }
    }

    /* renamed from: b */
    private void m8325b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f6410b) {
                if (this.f6411c[i2] == 1 && (this.f6412d[i2] instanceof AbstractC0946aa)) {
                    AbstractC1004u m8418c = this.f6409a.m8418c(i2);
                    if (!m8418c.m8391o().m7932h().mo6699f()) {
                        m8418c.m8387b(m8418c.m8391o().m7925a((AbstractC0946aa) this.f6412d[i2]));
                        for (AbstractC1004u abstractC1004u : this.f6409a.m8420d(i2)) {
                            if (!abstractC1004u.mo8294l()) {
                                C0995l c0995l = (C0995l) abstractC1004u;
                                C0935q mo8285b = abstractC1004u.mo8285b();
                                int m7951c = mo8285b.m7951c(i2);
                                c0995l.m8281a(m7951c, mo8285b.m7949b(m7951c).m7925a((AbstractC0946aa) this.f6412d[i2]));
                            }
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private void m8328c() {
        Iterator<AbstractC1004u> it = this.f6418j.iterator();
        while (it.hasNext()) {
            AbstractC1004u next = it.next();
            C1002s m8392p = next.m8392p();
            int m8568b = m8392p.m8364j().m8568b();
            int i = 0;
            int i2 = -1;
            while (i < m8568b) {
                int m8569b = m8392p.m8364j().m8569b(i);
                if (this.f6415g.get(m8569b)) {
                    m8569b = i2;
                }
                i++;
                i2 = m8569b;
            }
            if (m8568b == 2 && i2 != -1) {
                m8392p.m8351b(new C0932n(C0939u.f6120s, next.mo8288f().m7883g(), (C0934p) null, C0935q.f5906a));
                m8392p.m8350b(i2);
            }
        }
    }
}
