package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C1002s;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/* compiled from: SsaMethod.java */
/* renamed from: com.b.b.g.v */
/* loaded from: classes.dex */
public final class C1005v {

    /* renamed from: a */
    private ArrayList<C1002s> f6436a;

    /* renamed from: b */
    private int f6437b;

    /* renamed from: c */
    private int f6438c;

    /* renamed from: d */
    private int f6439d;

    /* renamed from: e */
    private int f6440e;

    /* renamed from: f */
    private int f6441f;

    /* renamed from: g */
    private int f6442g;

    /* renamed from: h */
    private final int f6443h;

    /* renamed from: i */
    private final boolean f6444i;

    /* renamed from: j */
    private AbstractC1004u[] f6445j;

    /* renamed from: k */
    private ArrayList<AbstractC1004u>[] f6446k;

    /* renamed from: l */
    private List<AbstractC1004u>[] f6447l;

    /* renamed from: m */
    private boolean f6448m = false;

    /* renamed from: a */
    public static C1005v m8394a(C0938t c0938t, int i, boolean z) {
        C1005v c1005v = new C1005v(c0938t, i, z);
        c1005v.m8396a(c0938t);
        return c1005v;
    }

    private C1005v(C0938t c0938t, int i, boolean z) {
        this.f6443h = i;
        this.f6444i = z;
        this.f6442g = c0938t.m7977a().m8587j();
        this.f6439d = c0938t.m7977a().m7859e();
        this.f6440e = this.f6439d;
    }

    /* renamed from: a */
    static BitSet m8395a(C0921c c0921c, C1025p c1025p) {
        BitSet bitSet = new BitSet(c0921c.m8550f_());
        int m8568b = c1025p.m8568b();
        for (int i = 0; i < m8568b; i++) {
            bitSet.set(c0921c.m8586c(c1025p.m8569b(i)));
        }
        return bitSet;
    }

    /* renamed from: b */
    public static C1025p m8398b(C0921c c0921c, C1025p c1025p) {
        C1025p c1025p2 = new C1025p(c1025p.m8568b());
        int m8568b = c1025p.m8568b();
        for (int i = 0; i < m8568b; i++) {
            c1025p2.m8571c(c0921c.m8586c(c1025p.m8569b(i)));
        }
        return c1025p2;
    }

    /* renamed from: a */
    private void m8396a(C0938t c0938t) {
        int f_ = c0938t.m7977a().m8550f_();
        this.f6436a = new ArrayList<>(f_ + 2);
        for (int i = 0; i < f_; i++) {
            this.f6436a.add(C1002s.m8333a(c0938t, i, this));
        }
        this.f6437b = this.f6436a.get(c0938t.m7977a().m8586c(c0938t.m7979b())).m8370p().m8358e();
        this.f6438c = -1;
    }

    /* renamed from: a */
    void m8403a() {
        if (this.f6438c >= 0) {
            throw new RuntimeException("must be called at most once");
        }
        this.f6438c = this.f6436a.size();
        int i = this.f6438c;
        int i2 = this.f6442g;
        this.f6442g = i2 + 1;
        C1002s c1002s = new C1002s(i, i2, this);
        this.f6436a.add(c1002s);
        Iterator<C1002s> it = this.f6436a.iterator();
        while (it.hasNext()) {
            it.next().m8355c(c1002s);
        }
        if (c1002s.m8362h().cardinality() == 0) {
            this.f6436a.remove(this.f6438c);
            this.f6438c = -1;
            this.f6442g--;
        }
    }

    /* renamed from: a */
    private static AbstractC1004u m8393a(C1002s c1002s) {
        return new C0995l(new C0932n(C0939u.f6120s, C0940v.f6128a, (C0934p) null, C0935q.f5906a), c1002s);
    }

    /* renamed from: b */
    public C1002s m8415b() {
        int size = this.f6436a.size();
        int i = this.f6442g;
        this.f6442g = i + 1;
        C1002s c1002s = new C1002s(size, i, this);
        c1002s.m8353c().add(m8393a(c1002s));
        this.f6436a.add(c1002s);
        return c1002s;
    }

    /* renamed from: c */
    public int m8417c() {
        return this.f6437b;
    }

    /* renamed from: d */
    public C1002s m8419d() {
        return this.f6436a.get(this.f6437b);
    }

    /* renamed from: e */
    public int m8421e() {
        return this.f6438c;
    }

    /* renamed from: f */
    public C1002s m8423f() {
        if (this.f6438c < 0) {
            return null;
        }
        return this.f6436a.get(this.f6438c);
    }

    /* renamed from: a */
    public int m8402a(int i) {
        if (i < 0) {
            return -1;
        }
        return this.f6436a.get(i).m8360f();
    }

    /* renamed from: g */
    public int m8424g() {
        return this.f6439d;
    }

    /* renamed from: h */
    public int m8425h() {
        return this.f6443h;
    }

    /* renamed from: b */
    public int m8414b(int i) {
        int i2 = this.f6440e + this.f6441f;
        this.f6441f += i;
        this.f6439d = Math.max(this.f6439d, i2 + i);
        return i2;
    }

    /* renamed from: i */
    public void m8426i() {
        this.f6441f = 0;
    }

    /* renamed from: j */
    public ArrayList<C1002s> m8427j() {
        return this.f6436a;
    }

    /* renamed from: k */
    public int m8428k() {
        int i = 0;
        Iterator<C1002s> it = this.f6436a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().m8373s() ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* renamed from: l */
    public void m8429l() {
        Iterator<C1002s> it = this.f6436a.iterator();
        while (it.hasNext()) {
            it.next().m8359e(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(m8419d());
        while (!arrayList.isEmpty()) {
            C1002s c1002s = (C1002s) arrayList.remove(0);
            if (!c1002s.m8373s()) {
                c1002s.m8359e(1);
                BitSet m8363i = c1002s.m8363i();
                for (int nextSetBit = m8363i.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8363i.nextSetBit(nextSetBit + 1)) {
                    arrayList.add(this.f6436a.get(nextSetBit));
                }
            }
        }
    }

    /* renamed from: a */
    public void m8404a(AbstractC0999p abstractC0999p) {
        Iterator<C1002s> it = m8427j().iterator();
        while (it.hasNext()) {
            Iterator<AbstractC1004u> it2 = it.next().m8353c().iterator();
            while (it2.hasNext()) {
                it2.next().m8388b(abstractC0999p);
            }
        }
        this.f6439d = abstractC0999p.mo8139a();
        this.f6440e = this.f6439d;
    }

    /* renamed from: c */
    public AbstractC1004u m8418c(int i) {
        if (this.f6448m) {
            throw new RuntimeException("No def list in back mode");
        }
        if (this.f6445j != null) {
            return this.f6445j[i];
        }
        this.f6445j = new AbstractC1004u[m8424g()];
        m8406a(new AbstractC1004u.a() { // from class: com.b.b.g.v.1
            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8176a(C0995l c0995l) {
                C1005v.this.f6445j[c0995l.m8391o().m7931g()] = c0995l;
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8177a(C0997n c0997n) {
                C1005v.this.f6445j[c0997n.m8391o().m7931g()] = c0997n;
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: b */
            public void mo8178b(C0995l c0995l) {
                if (c0995l.m8391o() != null) {
                    C1005v.this.f6445j[c0995l.m8391o().m7931g()] = c0995l;
                }
            }
        });
        return this.f6445j[i];
    }

    /* renamed from: q */
    private void m8401q() {
        if (this.f6448m) {
            throw new RuntimeException("No use list in back mode");
        }
        this.f6446k = new ArrayList[this.f6439d];
        for (int i = 0; i < this.f6439d; i++) {
            this.f6446k[i] = new ArrayList<>();
        }
        m8406a(new AbstractC1004u.a() { // from class: com.b.b.g.v.2
            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8176a(C0995l c0995l) {
                m8434a((AbstractC1004u) c0995l);
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8177a(C0997n c0997n) {
                m8434a((AbstractC1004u) c0997n);
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: b */
            public void mo8178b(C0995l c0995l) {
                m8434a((AbstractC1004u) c0995l);
            }

            /* renamed from: a */
            private void m8434a(AbstractC1004u abstractC1004u) {
                C0935q mo8285b = abstractC1004u.mo8285b();
                int f_ = mo8285b.m8550f_();
                for (int i2 = 0; i2 < f_; i2++) {
                    C1005v.this.f6446k[mo8285b.m7949b(i2).m7931g()].add(abstractC1004u);
                }
            }
        });
        this.f6447l = new List[this.f6439d];
        for (int i2 = 0; i2 < this.f6439d; i2++) {
            this.f6447l[i2] = Collections.unmodifiableList(this.f6446k[i2]);
        }
    }

    /* renamed from: a */
    void m8409a(AbstractC1004u abstractC1004u, C0934p c0934p, C0934p c0934p2) {
        if (this.f6446k != null) {
            if (c0934p != null) {
                this.f6446k[c0934p.m7931g()].remove(abstractC1004u);
            }
            int m7931g = c0934p2.m7931g();
            if (this.f6446k.length <= m7931g) {
                this.f6446k = null;
            } else {
                this.f6446k[m7931g].add(abstractC1004u);
            }
        }
    }

    /* renamed from: a */
    void m8410a(AbstractC1004u abstractC1004u, C0935q c0935q) {
        if (this.f6446k != null) {
            if (c0935q != null) {
                m8399b(abstractC1004u, c0935q);
            }
            C0935q mo8285b = abstractC1004u.mo8285b();
            int f_ = mo8285b.m8550f_();
            for (int i = 0; i < f_; i++) {
                this.f6446k[mo8285b.m7949b(i).m7931g()].add(abstractC1004u);
            }
        }
    }

    /* renamed from: b */
    private void m8399b(AbstractC1004u abstractC1004u, C0935q c0935q) {
        if (c0935q != null) {
            int f_ = c0935q.m8550f_();
            for (int i = 0; i < f_; i++) {
                if (!this.f6446k[c0935q.m7949b(i).m7931g()].remove(abstractC1004u)) {
                    throw new RuntimeException("use not found");
                }
            }
        }
    }

    /* renamed from: a */
    void m8407a(AbstractC1004u abstractC1004u) {
        m8410a(abstractC1004u, (C0935q) null);
        m8408a(abstractC1004u, (C0934p) null);
    }

    /* renamed from: b */
    void m8416b(AbstractC1004u abstractC1004u) {
        if (this.f6446k != null) {
            m8399b(abstractC1004u, abstractC1004u.mo8285b());
        }
        C0934p m8391o = abstractC1004u.m8391o();
        if (this.f6445j != null && m8391o != null) {
            this.f6445j[m8391o.m7931g()] = null;
        }
    }

    /* renamed from: m */
    public void m8430m() {
        this.f6445j = null;
        this.f6446k = null;
        this.f6447l = null;
    }

    /* renamed from: a */
    void m8408a(AbstractC1004u abstractC1004u, C0934p c0934p) {
        if (this.f6445j != null) {
            if (c0934p != null) {
                this.f6445j[c0934p.m7931g()] = null;
            }
            C0934p m8391o = abstractC1004u.m8391o();
            if (m8391o != null) {
                if (this.f6445j[m8391o.m7931g()] != null) {
                    throw new RuntimeException("Duplicate add of insn");
                }
                this.f6445j[m8391o.m7931g()] = abstractC1004u;
            }
        }
    }

    /* renamed from: d */
    public List<AbstractC1004u> m8420d(int i) {
        if (this.f6447l == null) {
            m8401q();
        }
        return this.f6447l[i];
    }

    /* renamed from: n */
    public ArrayList<AbstractC1004u>[] m8431n() {
        if (this.f6446k == null) {
            m8401q();
        }
        ArrayList<AbstractC1004u>[] arrayListArr = new ArrayList[this.f6439d];
        for (int i = 0; i < this.f6439d; i++) {
            arrayListArr[i] = new ArrayList<>(this.f6446k[i]);
        }
        return arrayListArr;
    }

    /* renamed from: a */
    public boolean m8413a(C0934p c0934p) {
        AbstractC1004u m8418c = m8418c(c0934p.m7931g());
        if (m8418c == null) {
            return false;
        }
        if (m8418c.mo8289g() != null) {
            return true;
        }
        Iterator<AbstractC1004u> it = m8420d(c0934p.m7931g()).iterator();
        while (it.hasNext()) {
            AbstractC0926h mo8288f = it.next().mo8288f();
            if (mo8288f != null && mo8288f.m7882f().m7968a() == 54) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    void m8422e(int i) {
        this.f6439d = i;
        this.f6440e = this.f6439d;
        m8430m();
    }

    /* renamed from: o */
    public int m8432o() {
        int i = this.f6439d;
        this.f6439d = i + 1;
        this.f6440e = this.f6439d;
        m8430m();
        return i;
    }

    /* renamed from: a */
    public void m8406a(AbstractC1004u.a aVar) {
        Iterator<C1002s> it = this.f6436a.iterator();
        while (it.hasNext()) {
            it.next().m8347a(aVar);
        }
    }

    /* renamed from: a */
    public void m8412a(boolean z, C1002s.b bVar) {
        BitSet bitSet = new BitSet(this.f6436a.size());
        Stack stack = new Stack();
        C1002s m8423f = z ? m8423f() : m8419d();
        if (m8423f != null) {
            stack.add(null);
            stack.add(m8423f);
            while (stack.size() > 0) {
                C1002s c1002s = (C1002s) stack.pop();
                C1002s c1002s2 = (C1002s) stack.pop();
                if (!bitSet.get(c1002s.m8358e())) {
                    BitSet m8362h = z ? c1002s.m8362h() : c1002s.m8363i();
                    for (int nextSetBit = m8362h.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8362h.nextSetBit(nextSetBit + 1)) {
                        stack.add(c1002s);
                        stack.add(this.f6436a.get(nextSetBit));
                    }
                    bitSet.set(c1002s.m8358e());
                    bVar.mo8207a(c1002s, c1002s2);
                }
            }
        }
    }

    /* renamed from: a */
    public void m8405a(C1002s.b bVar) {
        BitSet bitSet = new BitSet(m8427j().size());
        Stack stack = new Stack();
        stack.add(m8419d());
        while (stack.size() > 0) {
            C1002s c1002s = (C1002s) stack.pop();
            ArrayList<C1002s> m8339a = c1002s.m8339a();
            if (!bitSet.get(c1002s.m8358e())) {
                for (int size = m8339a.size() - 1; size >= 0; size--) {
                    stack.add(m8339a.get(size));
                }
                bitSet.set(c1002s.m8358e());
                bVar.mo8207a(c1002s, null);
            }
        }
    }

    /* renamed from: a */
    public void m8411a(Set<AbstractC1004u> set) {
        Iterator<C1002s> it = m8427j().iterator();
        while (it.hasNext()) {
            C1002s next = it.next();
            ArrayList<AbstractC1004u> m8353c = next.m8353c();
            for (int size = m8353c.size() - 1; size >= 0; size--) {
                AbstractC1004u abstractC1004u = m8353c.get(size);
                if (set.contains(abstractC1004u)) {
                    m8416b(abstractC1004u);
                    m8353c.remove(size);
                }
            }
            int size2 = m8353c.size();
            AbstractC1004u abstractC1004u2 = size2 == 0 ? null : m8353c.get(size2 - 1);
            if (next != m8423f() && (size2 == 0 || abstractC1004u2.mo8288f() == null || abstractC1004u2.mo8288f().m7882f().m7971d() == 1)) {
                m8353c.add(AbstractC1004u.m8385a(new C0932n(C0939u.f6120s, C0940v.f6128a, (C0934p) null, C0935q.f5906a), next));
                BitSet m8363i = next.m8363i();
                for (int nextSetBit = m8363i.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8363i.nextSetBit(nextSetBit + 1)) {
                    if (nextSetBit != next.m8365k()) {
                        next.m8350b(nextSetBit);
                    }
                }
            }
        }
    }

    /* renamed from: p */
    public void m8433p() {
        this.f6448m = true;
        this.f6446k = null;
        this.f6445j = null;
    }
}
