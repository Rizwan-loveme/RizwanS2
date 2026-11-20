package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0927i;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C0997n;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import com.p065b.p086b.p110h.InterfaceC1026q;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: SsaBasicBlock.java */
/* renamed from: com.b.b.g.s */
/* loaded from: classes.dex */
public final class C1002s {

    /* renamed from: a */
    public static final Comparator<C1002s> f6419a = new a();

    /* renamed from: c */
    private BitSet f6421c;

    /* renamed from: d */
    private BitSet f6422d;

    /* renamed from: g */
    private int f6425g;

    /* renamed from: h */
    private C1005v f6426h;

    /* renamed from: i */
    private int f6427i;

    /* renamed from: n */
    private InterfaceC1026q f6432n;

    /* renamed from: o */
    private InterfaceC1026q f6433o;

    /* renamed from: f */
    private int f6424f = -1;

    /* renamed from: k */
    private int f6429k = 0;

    /* renamed from: l */
    private int f6430l = 0;

    /* renamed from: m */
    private int f6431m = -1;

    /* renamed from: b */
    private ArrayList<AbstractC1004u> f6420b = new ArrayList<>();

    /* renamed from: e */
    private C1025p f6423e = new C1025p();

    /* renamed from: j */
    private final ArrayList<C1002s> f6428j = new ArrayList<>();

    /* compiled from: SsaBasicBlock.java */
    /* renamed from: com.b.b.g.s$b */
    public interface b {
        /* renamed from: a */
        void mo8207a(C1002s c1002s, C1002s c1002s2);
    }

    public C1002s(int i, int i2, C1005v c1005v) {
        this.f6426h = c1005v;
        this.f6427i = i;
        this.f6425g = i2;
        this.f6421c = new BitSet(c1005v.m8427j().size());
        this.f6422d = new BitSet(c1005v.m8427j().size());
    }

    /* renamed from: a */
    public static C1002s m8333a(C0938t c0938t, int i, C1005v c1005v) {
        C0921c m7977a = c0938t.m7977a();
        C0920b m7854a = m7977a.m7854a(i);
        C1002s c1002s = new C1002s(i, m7854a.mo6568a(), c1005v);
        C0927i m7846b = m7854a.m7846b();
        c1002s.f6420b.ensureCapacity(m7846b.m8550f_());
        int f_ = m7846b.m8550f_();
        for (int i2 = 0; i2 < f_; i2++) {
            c1002s.f6420b.add(new C0995l(m7846b.m7889a(i2), c1002s));
        }
        c1002s.f6421c = C1005v.m8395a(m7977a, c0938t.m7978a(m7854a.mo6568a()));
        c1002s.f6422d = C1005v.m8395a(m7977a, m7854a.m7847c());
        c1002s.f6423e = C1005v.m8398b(m7977a, m7854a.m7847c());
        if (c1002s.f6423e.m8568b() != 0) {
            int m7848d = m7854a.m7848d();
            c1002s.f6424f = m7848d < 0 ? -1 : m7977a.m8586c(m7848d);
        }
        return c1002s;
    }

    /* renamed from: a */
    public void m8346a(C1002s c1002s) {
        this.f6428j.add(c1002s);
    }

    /* renamed from: a */
    public ArrayList<C1002s> m8339a() {
        return this.f6428j;
    }

    /* renamed from: a */
    public void m8340a(int i) {
        this.f6420b.add(0, new C0997n(i, this));
    }

    /* renamed from: a */
    public void m8343a(C0934p c0934p) {
        this.f6420b.add(0, new C0997n(c0934p, this));
    }

    /* renamed from: a */
    public void m8342a(AbstractC0926h abstractC0926h) {
        AbstractC1004u m8385a = AbstractC1004u.m8385a(abstractC0926h, this);
        this.f6420b.add(m8338u(), m8385a);
        this.f6426h.m8407a(m8385a);
    }

    /* renamed from: b */
    public void m8351b(AbstractC0926h abstractC0926h) {
        if (abstractC0926h.m7882f().m7971d() == 1) {
            throw new IllegalArgumentException("last insn must branch");
        }
        AbstractC1004u abstractC1004u = this.f6420b.get(this.f6420b.size() - 1);
        AbstractC1004u m8385a = AbstractC1004u.m8385a(abstractC0926h, this);
        this.f6420b.set(this.f6420b.size() - 1, m8385a);
        this.f6426h.m8416b(abstractC1004u);
        this.f6426h.m8407a(m8385a);
    }

    /* renamed from: a */
    public void m8345a(C0997n.b bVar) {
        int size = this.f6420b.size();
        for (int i = 0; i < size; i++) {
            AbstractC1004u abstractC1004u = this.f6420b.get(i);
            if (abstractC1004u instanceof C0997n) {
                bVar.mo8208a((C0997n) abstractC1004u);
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public void m8349b() {
        this.f6420b.subList(0, m8338u()).clear();
    }

    /* renamed from: u */
    private int m8338u() {
        int size = this.f6420b.size();
        int i = 0;
        while (i < size && (this.f6420b.get(i) instanceof C0997n)) {
            i++;
        }
        return i;
    }

    /* renamed from: c */
    public ArrayList<AbstractC1004u> m8353c() {
        return this.f6420b;
    }

    /* renamed from: d */
    public List<AbstractC1004u> m8356d() {
        return this.f6420b.subList(0, m8338u());
    }

    /* renamed from: e */
    public int m8358e() {
        return this.f6427i;
    }

    /* renamed from: f */
    public int m8360f() {
        return this.f6425g;
    }

    /* renamed from: g */
    public String m8361g() {
        return C1022m.m8557c(this.f6425g);
    }

    /* renamed from: h */
    public BitSet m8362h() {
        return this.f6421c;
    }

    /* renamed from: i */
    public BitSet m8363i() {
        return this.f6422d;
    }

    /* renamed from: j */
    public C1025p m8364j() {
        return this.f6423e;
    }

    /* renamed from: k */
    public int m8365k() {
        return this.f6424f;
    }

    /* renamed from: l */
    public int m8366l() {
        return this.f6426h.m8402a(this.f6424f);
    }

    /* renamed from: m */
    public C1002s m8367m() {
        if (this.f6424f < 0) {
            return null;
        }
        return this.f6426h.m8427j().get(this.f6424f);
    }

    /* renamed from: n */
    public C1025p m8368n() {
        C1025p c1025p = new C1025p(this.f6423e.m8568b());
        int m8568b = this.f6423e.m8568b();
        for (int i = 0; i < m8568b; i++) {
            c1025p.m8571c(this.f6426h.m8402a(this.f6423e.m8569b(i)));
        }
        return c1025p;
    }

    /* renamed from: o */
    public C1005v m8369o() {
        return this.f6426h;
    }

    /* renamed from: p */
    public C1002s m8370p() {
        C1002s m8415b = this.f6426h.m8415b();
        m8415b.f6421c = this.f6421c;
        m8415b.f6422d.set(this.f6427i);
        m8415b.f6423e.m8571c(this.f6427i);
        m8415b.f6424f = this.f6427i;
        this.f6421c = new BitSet(this.f6426h.m8427j().size());
        this.f6421c.set(m8415b.f6427i);
        for (int nextSetBit = m8415b.f6421c.nextSetBit(0); nextSetBit >= 0; nextSetBit = m8415b.f6421c.nextSetBit(nextSetBit + 1)) {
            this.f6426h.m8427j().get(nextSetBit).m8341a(this.f6427i, m8415b.f6427i);
        }
        return m8415b;
    }

    /* renamed from: b */
    public C1002s m8348b(C1002s c1002s) {
        C1002s m8415b = this.f6426h.m8415b();
        if (!this.f6422d.get(c1002s.f6427i)) {
            throw new RuntimeException("Block " + c1002s.m8361g() + " not successor of " + m8361g());
        }
        m8415b.f6421c.set(this.f6427i);
        m8415b.f6422d.set(c1002s.f6427i);
        m8415b.f6423e.m8571c(c1002s.f6427i);
        m8415b.f6424f = c1002s.f6427i;
        for (int m8568b = this.f6423e.m8568b() - 1; m8568b >= 0; m8568b--) {
            if (this.f6423e.m8569b(m8568b) == c1002s.f6427i) {
                this.f6423e.m8570b(m8568b, m8415b.f6427i);
            }
        }
        if (this.f6424f == c1002s.f6427i) {
            this.f6424f = m8415b.f6427i;
        }
        this.f6422d.clear(c1002s.f6427i);
        this.f6422d.set(m8415b.f6427i);
        c1002s.f6421c.set(m8415b.f6427i);
        c1002s.f6421c.set(this.f6427i, this.f6422d.get(c1002s.f6427i));
        return m8415b;
    }

    /* renamed from: a */
    public void m8341a(int i, int i2) {
        if (i != i2) {
            this.f6422d.set(i2);
            if (this.f6424f == i) {
                this.f6424f = i2;
            }
            for (int m8568b = this.f6423e.m8568b() - 1; m8568b >= 0; m8568b--) {
                if (this.f6423e.m8569b(m8568b) == i) {
                    this.f6423e.m8570b(m8568b, i2);
                }
            }
            this.f6422d.clear(i);
            this.f6426h.m8427j().get(i2).f6421c.set(this.f6427i);
            this.f6426h.m8427j().get(i).f6421c.clear(this.f6427i);
        }
    }

    /* renamed from: b */
    public void m8350b(int i) {
        int i2 = 0;
        for (int m8568b = this.f6423e.m8568b() - 1; m8568b >= 0; m8568b--) {
            if (this.f6423e.m8569b(m8568b) == i) {
                i2 = m8568b;
            } else {
                this.f6424f = this.f6423e.m8569b(m8568b);
            }
        }
        this.f6423e.m8574d(i2);
        this.f6422d.clear(i);
        this.f6426h.m8427j().get(i).f6421c.clear(this.f6427i);
    }

    /* renamed from: c */
    public void m8355c(C1002s c1002s) {
        if (this != c1002s && this.f6423e.m8568b() == 0) {
            this.f6422d.set(c1002s.f6427i);
            this.f6423e.m8571c(c1002s.f6427i);
            this.f6424f = c1002s.f6427i;
            c1002s.f6421c.set(this.f6427i);
        }
    }

    /* renamed from: a */
    public void m8344a(C0934p c0934p, C0934p c0934p2) {
        if (c0934p.m7931g() != c0934p2.m7931g()) {
            C0995l c0995l = (C0995l) this.f6420b.get(this.f6420b.size() - 1);
            if (c0995l.m8391o() != null || c0995l.mo8285b().m8550f_() > 0) {
                int nextSetBit = this.f6422d.nextSetBit(0);
                while (nextSetBit >= 0) {
                    this.f6426h.m8427j().get(nextSetBit).m8352b(c0934p, c0934p2);
                    nextSetBit = this.f6422d.nextSetBit(nextSetBit + 1);
                }
                return;
            }
            this.f6420b.add(this.f6420b.size() - 1, new C0995l(new C0932n(C0939u.m7982a(c0934p.mo6695a()), C0940v.f6128a, c0934p, C0935q.m7944a(c0934p2)), this));
            this.f6429k++;
        }
    }

    /* renamed from: b */
    public void m8352b(C0934p c0934p, C0934p c0934p2) {
        if (c0934p.m7931g() != c0934p2.m7931g()) {
            this.f6420b.add(m8338u(), new C0995l(new C0932n(C0939u.m7982a(c0934p.mo6695a()), C0940v.f6128a, c0934p, C0935q.m7944a(c0934p2)), this));
            this.f6430l++;
        }
    }

    /* renamed from: a */
    private static void m8334a(BitSet bitSet, C0934p c0934p) {
        bitSet.set(c0934p.m7931g());
        if (c0934p.m7935k() > 1) {
            bitSet.set(c0934p.m7931g() + 1);
        }
    }

    /* renamed from: b */
    private static boolean m8336b(BitSet bitSet, C0934p c0934p) {
        int m7931g = c0934p.m7931g();
        return bitSet.get(m7931g) || (c0934p.m7935k() == 2 && bitSet.get(m7931g + 1));
    }

    /* renamed from: a */
    private void m8335a(List<AbstractC1004u> list) {
        int i;
        AbstractC1004u abstractC1004u;
        int i2;
        BitSet bitSet = new BitSet(this.f6426h.m8424g());
        BitSet bitSet2 = new BitSet(this.f6426h.m8424g());
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            for (int i4 = i3; i4 < size; i4++) {
                m8334a(bitSet, list.get(i4).mo8285b().m7949b(0));
                m8334a(bitSet2, list.get(i4).m8391o());
            }
            int i5 = i3;
            int i6 = i3;
            while (i5 < size) {
                if (m8336b(bitSet, list.get(i5).m8391o())) {
                    i2 = i6;
                } else {
                    i2 = i6 + 1;
                    Collections.swap(list, i5, i6);
                }
                i5++;
                i6 = i2;
            }
            if (i3 == i6) {
                int i7 = i6;
                while (true) {
                    if (i7 >= size) {
                        abstractC1004u = null;
                        break;
                    }
                    abstractC1004u = list.get(i7);
                    if (!m8336b(bitSet, abstractC1004u.m8391o()) || !m8336b(bitSet2, abstractC1004u.mo8285b().m7949b(0))) {
                        i7++;
                    } else {
                        Collections.swap(list, i6, i7);
                        break;
                    }
                }
                C0934p m8391o = abstractC1004u.m8391o();
                C0934p m7927b = m8391o.m7927b(this.f6426h.m8414b(m8391o.m7935k()));
                C0995l c0995l = new C0995l(new C0932n(C0939u.m7982a(m8391o.mo6695a()), C0940v.f6128a, m7927b, abstractC1004u.mo8285b()), this);
                int i8 = i6 + 1;
                list.add(i6, c0995l);
                list.set(i8, new C0995l(new C0932n(C0939u.m7982a(m8391o.mo6695a()), C0940v.f6128a, m8391o, C0935q.m7944a(m7927b)), this));
                i = list.size();
                i6 = i8;
            } else {
                i = size;
            }
            bitSet.clear();
            bitSet2.clear();
            i3 = i6;
            size = i;
        }
    }

    /* renamed from: c */
    public void m8354c(int i) {
        if (this.f6433o == null) {
            this.f6433o = C1001r.m8332c(this.f6426h.m8424g());
        }
        this.f6433o.mo8477a(i);
    }

    /* renamed from: d */
    public void m8357d(int i) {
        if (this.f6432n == null) {
            this.f6432n = C1001r.m8332c(this.f6426h.m8424g());
        }
        this.f6432n.mo8477a(i);
    }

    /* renamed from: q */
    public InterfaceC1026q m8371q() {
        if (this.f6433o == null) {
            this.f6433o = C1001r.m8332c(this.f6426h.m8424g());
        }
        return this.f6433o;
    }

    /* renamed from: r */
    public boolean m8372r() {
        return this.f6427i == this.f6426h.m8421e();
    }

    /* renamed from: s */
    public boolean m8373s() {
        if (this.f6431m == -1) {
            this.f6426h.m8429l();
        }
        return this.f6431m == 1;
    }

    /* renamed from: e */
    public void m8359e(int i) {
        this.f6431m = i;
    }

    /* renamed from: t */
    public void m8374t() {
        if (this.f6430l > 1) {
            m8335a(this.f6420b.subList(0, this.f6430l));
            if (this.f6420b.get(this.f6430l).mo8292j()) {
                throw new RuntimeException("Unexpected: moves from phis before move-exception");
            }
        }
        if (this.f6429k > 1) {
            m8335a(this.f6420b.subList((this.f6420b.size() - this.f6429k) - 1, this.f6420b.size() - 1));
        }
        this.f6426h.m8426i();
    }

    /* renamed from: a */
    public void m8347a(AbstractC1004u.a aVar) {
        int size = this.f6420b.size();
        for (int i = 0; i < size; i++) {
            this.f6420b.get(i).mo8284a(aVar);
        }
    }

    public String toString() {
        return "{" + this.f6427i + ":" + C1022m.m8557c(this.f6425g) + '}';
    }

    /* compiled from: SsaBasicBlock.java */
    /* renamed from: com.b.b.g.s$a */
    public static final class a implements Comparator<C1002s> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1002s c1002s, C1002s c1002s2) {
            int i = c1002s.f6425g;
            int i2 = c1002s2.f6425g;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            return 0;
        }
    }
}
