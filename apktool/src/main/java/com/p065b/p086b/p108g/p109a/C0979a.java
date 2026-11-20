package com.p065b.p086b.p108g.p109a;

import com.p065b.p086b.p103f.p105b.AbstractC0922d;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p108g.AbstractC0999p;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C0990g;
import com.p065b.p086b.p108g.C0995l;
import com.p065b.p086b.p108g.C0996m;
import com.p065b.p086b.p108g.C0997n;
import com.p065b.p086b.p108g.C1005v;
import com.p065b.p086b.p110h.InterfaceC1024o;
import com.p065b.p086b.p110h.InterfaceC1026q;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: FirstFitLocalCombiningAllocator.java */
/* renamed from: com.b.b.g.a.a */
/* loaded from: classes.dex */
public class C0979a extends AbstractC0983e {

    /* renamed from: c */
    private final Map<C0928j, ArrayList<C0934p>> f6281c;

    /* renamed from: d */
    private final ArrayList<C0995l> f6282d;

    /* renamed from: e */
    private final ArrayList<C0995l> f6283e;

    /* renamed from: f */
    private final ArrayList<C0997n> f6284f;

    /* renamed from: g */
    private final BitSet f6285g;

    /* renamed from: h */
    private final C0990g f6286h;

    /* renamed from: i */
    private final int f6287i;

    /* renamed from: j */
    private final BitSet f6288j;

    /* renamed from: k */
    private final BitSet f6289k;

    /* renamed from: l */
    private final boolean f6290l;

    public C0979a(C1005v c1005v, C0981c c0981c, boolean z) {
        super(c1005v, c0981c);
        this.f6285g = new BitSet(c1005v.m8424g());
        this.f6286h = new C0990g(c0981c, c1005v.m8424g());
        this.f6290l = z;
        this.f6287i = c1005v.m8425h();
        this.f6288j = new BitSet(this.f6287i * 2);
        this.f6288j.set(0, this.f6287i);
        this.f6289k = new BitSet(this.f6287i * 2);
        this.f6281c = new TreeMap();
        this.f6282d = new ArrayList<>();
        this.f6283e = new ArrayList<>();
        this.f6284f = new ArrayList<>();
    }

    @Override // com.p065b.p086b.p108g.p109a.AbstractC0983e
    /* renamed from: a */
    public boolean mo8173a() {
        return true;
    }

    @Override // com.p065b.p086b.p108g.p109a.AbstractC0983e
    /* renamed from: b */
    public AbstractC0999p mo8174b() {
        m8171j();
        m8161c();
        m8165e();
        m8167f();
        m8164d();
        m8168g();
        m8169h();
        m8170i();
        return this.f6286h;
    }

    /* renamed from: c */
    private void m8161c() {
        int i;
        int i2;
        for (ArrayList<C0934p> arrayList : this.f6281c.values()) {
            int size = arrayList.size();
            int i3 = -1;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    i = 0;
                    i2 = i3;
                    break;
                }
                C0934p c0934p = arrayList.get(i4);
                i2 = m8153b(c0934p.m7931g());
                if (i2 < 0) {
                    i4++;
                    i3 = i2;
                } else {
                    int m7935k = c0934p.m7935k();
                    m8156b(c0934p, i2);
                    i = m7935k;
                    break;
                }
            }
            if (i2 >= 0) {
                m8152a(arrayList, i2, i, true);
            }
        }
    }

    /* renamed from: b */
    private int m8153b(int i) {
        C0937s mo8287e;
        AbstractC1004u m8418c = this.f6313a.m8418c(i);
        if (m8418c == null || (mo8287e = m8418c.mo8287e()) == null || mo8287e.m7968a() != 3) {
            return -1;
        }
        return ((C0959m) ((AbstractC0922d) m8418c.mo8288f()).m7868i_()).m8061k_();
    }

    /* renamed from: d */
    private void m8164d() {
        boolean z;
        for (ArrayList<C0934p> arrayList : this.f6281c.values()) {
            int i = this.f6287i;
            while (true) {
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 1;
                while (i2 < size) {
                    C0934p c0934p = arrayList.get(i2);
                    int m7935k = c0934p.m7935k();
                    i2++;
                    i3 = (this.f6285g.get(c0934p.m7931g()) || m7935k <= i3) ? i3 : m7935k;
                }
                int m8162d = m8162d(i, i3);
                boolean m8152a = m8151a(arrayList, m8162d) ? m8152a(arrayList, m8162d, i3, true) : z;
                i = m8162d + 1;
                z = m8152a ? false : m8152a;
            }
        }
    }

    /* renamed from: a */
    private boolean m8152a(ArrayList<C0934p> arrayList, int i, int i2, boolean z) {
        Iterator<C0934p> it = arrayList.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            C0934p next = it.next();
            if (!this.f6285g.get(next.m7931g())) {
                boolean m8150a = m8150a(next, i, i2);
                z2 = !m8150a || z2;
                if (m8150a && z) {
                    m8146a(i, next.m7935k());
                }
            }
        }
        return !z2;
    }

    /* renamed from: a */
    private boolean m8150a(C0934p c0934p, int i, int i2) {
        if (c0934p.m7935k() > i2 || this.f6285g.get(c0934p.m7931g()) || !m8149a(c0934p, i)) {
            return false;
        }
        m8156b(c0934p, i);
        return true;
    }

    /* renamed from: a */
    private void m8146a(int i, int i2) {
        this.f6288j.set(i, i + i2, true);
    }

    /* renamed from: b */
    private boolean m8157b(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            if (this.f6288j.get(i3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private int m8158c(int i, int i2) {
        int nextClearBit = this.f6288j.nextClearBit(i);
        while (true) {
            int i3 = 1;
            while (i3 < i2 && !this.f6288j.get(nextClearBit + i3)) {
                i3++;
            }
            if (i3 == i2) {
                return nextClearBit;
            }
            nextClearBit = this.f6288j.nextClearBit(nextClearBit + i3);
        }
    }

    /* renamed from: d */
    private int m8162d(int i, int i2) {
        int nextClearBit = this.f6289k.nextClearBit(i);
        while (true) {
            int i3 = 1;
            while (i3 < i2 && !this.f6289k.get(nextClearBit + i3)) {
                i3++;
            }
            if (i3 == i2) {
                return nextClearBit;
            }
            nextClearBit = this.f6289k.nextClearBit(nextClearBit + i3);
        }
    }

    /* renamed from: e */
    private void m8165e() {
        int m8424g = this.f6313a.m8424g();
        for (int i = 0; i < m8424g; i++) {
            if (!this.f6285g.get(i)) {
                int m8153b = m8153b(i);
                C0934p a2 = m8196a(i);
                if (m8153b >= 0) {
                    m8156b(a2, m8153b);
                }
            }
        }
    }

    /* renamed from: f */
    private void m8167f() {
        Iterator<C0995l> it = this.f6283e.iterator();
        while (it.hasNext()) {
            m8147a(it.next());
        }
    }

    /* renamed from: g */
    private void m8168g() {
        Iterator<C0995l> it = this.f6282d.iterator();
        while (it.hasNext()) {
            C0995l next = it.next();
            C0934p o = next.m8391o();
            int m7931g = o.m7931g();
            BitSet m8362h = next.m8392p().m8362h();
            if (m8362h.cardinality() == 1) {
                AbstractC1004u abstractC1004u = this.f6313a.m8427j().get(m8362h.nextSetBit(0)).m8353c().get(r0.size() - 1);
                if (abstractC1004u.mo8287e().m7968a() == 43) {
                    C0934p m7949b = abstractC1004u.mo8285b().m7949b(0);
                    int m7931g2 = m7949b.m7931g();
                    int m7935k = m7949b.m7935k();
                    boolean z = this.f6285g.get(m7931g);
                    boolean z2 = this.f6285g.get(m7931g2);
                    boolean m8150a = (!z2) & z ? m8150a(m7949b, this.f6286h.m8140a(m7931g), m7935k) : z2;
                    if ((!z) & m8150a) {
                        z = m8150a(o, this.f6286h.m8140a(m7931g2), m7935k);
                    }
                    if (!z || !m8150a) {
                        int m8158c = m8158c(this.f6287i, m7935k);
                        ArrayList<C0934p> arrayList = new ArrayList<>(2);
                        arrayList.add(o);
                        arrayList.add(m7949b);
                        while (!m8152a(arrayList, m8158c, m7935k, false)) {
                            m8158c = m8158c(m8158c + 1, m7935k);
                        }
                    }
                    boolean z3 = abstractC1004u.mo8288f().mo7876b().mo6856f_() != 0;
                    int a2 = this.f6286h.m8140a(m7931g);
                    if (a2 != this.f6286h.m8140a(m7931g2) && !z3) {
                        ((C0995l) abstractC1004u).m8281a(0, m8197a(abstractC1004u, m7949b));
                        m8156b(abstractC1004u.mo8285b().m7949b(0), a2);
                    }
                }
            }
        }
    }

    /* renamed from: h */
    private void m8169h() {
        Iterator<C0997n> it = this.f6284f.iterator();
        while (it.hasNext()) {
            m8148a(it.next());
        }
    }

    /* renamed from: i */
    private void m8170i() {
        C0934p a2;
        int m8424g = this.f6313a.m8424g();
        for (int i = 0; i < m8424g; i++) {
            if (!this.f6285g.get(i) && (a2 = m8196a(i)) != null) {
                int m7935k = a2.m7935k();
                int m8158c = m8158c(this.f6287i, m7935k);
                while (!m8149a(a2, m8158c)) {
                    m8158c = m8158c(m8158c + 1, m7935k);
                }
                m8156b(a2, m8158c);
            }
        }
    }

    /* renamed from: a */
    private boolean m8151a(ArrayList<C0934p> arrayList, int i) {
        Iterator<C0934p> it = arrayList.iterator();
        while (it.hasNext()) {
            C0934p next = it.next();
            if (!this.f6285g.get(next.m7931g()) && !m8149a(next, i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m8149a(C0934p c0934p, int i) {
        return (m8166e(i, c0934p.m7935k()) || this.f6286h.m8255a(c0934p, i)) ? false : true;
    }

    /* renamed from: e */
    private boolean m8166e(int i, int i2) {
        return i < this.f6287i && i + i2 > this.f6287i;
    }

    /* renamed from: j */
    private void m8171j() {
        this.f6313a.m8406a(new AbstractC1004u.a() { // from class: com.b.b.g.a.a.1
            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8176a(C0995l c0995l) {
                m8175a((AbstractC1004u) c0995l);
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8177a(C0997n c0997n) {
                m8175a((AbstractC1004u) c0997n);
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: b */
            public void mo8178b(C0995l c0995l) {
                m8175a((AbstractC1004u) c0995l);
            }

            /* renamed from: a */
            private void m8175a(AbstractC1004u abstractC1004u) {
                C0934p mo8289g = abstractC1004u.mo8289g();
                if (mo8289g != null) {
                    C0928j m7933i = mo8289g.m7933i();
                    ArrayList arrayList = (ArrayList) C0979a.this.f6281c.get(m7933i);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        C0979a.this.f6281c.put(m7933i, arrayList);
                    }
                    arrayList.add(mo8289g);
                }
                if (abstractC1004u instanceof C0995l) {
                    if (abstractC1004u.mo8287e().m7968a() == 56) {
                        C0979a.this.f6282d.add((C0995l) abstractC1004u);
                        return;
                    } else {
                        if (C0996m.m8302b().mo7872a(abstractC1004u.mo8288f().m7882f(), abstractC1004u.mo8285b())) {
                            C0979a.this.f6283e.add((C0995l) abstractC1004u);
                            return;
                        }
                        return;
                    }
                }
                if (abstractC1004u instanceof C0997n) {
                    C0979a.this.f6284f.add((C0997n) abstractC1004u);
                }
            }
        });
    }

    /* renamed from: b */
    private void m8156b(C0934p c0934p, int i) {
        int m7931g = c0934p.m7931g();
        if (this.f6285g.get(m7931g) || !m8149a(c0934p, i)) {
            throw new RuntimeException("attempt to add invalid register mapping");
        }
        int m7935k = c0934p.m7935k();
        this.f6286h.mo8142a(c0934p.m7931g(), i, m7935k);
        this.f6285g.set(m7931g);
        this.f6289k.set(i, m7935k + i);
    }

    /* renamed from: a */
    private void m8147a(C0995l c0995l) {
        int m8154b = m8154b(c0995l);
        C0935q mo8285b = c0995l.mo8285b();
        int f_ = mo8285b.m8550f_();
        int i = 0;
        int i2 = m8154b;
        while (i < f_) {
            C0934p m7949b = mo8285b.m7949b(i);
            int m7931g = m7949b.m7931g();
            int m7935k = m7949b.m7935k();
            int i3 = i2 + m7935k;
            if (!this.f6285g.get(m7931g)) {
                C0928j m8159c = m8159c(m7931g);
                m8156b(m7949b, i2);
                if (m8159c != null) {
                    m8146a(i2, m7935k);
                    ArrayList<C0934p> arrayList = this.f6281c.get(m8159c);
                    int size = arrayList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        C0934p c0934p = arrayList.get(i4);
                        if (-1 == mo8285b.m7951c(c0934p.m7931g())) {
                            m8150a(c0934p, i2, m7935k);
                        }
                    }
                }
            }
            i++;
            i2 = i3;
        }
    }

    /* renamed from: b */
    private int m8154b(C0995l c0995l) {
        int a2;
        BitSet bitSet;
        int m8143a;
        C0935q mo8285b = c0995l.mo8285b();
        int f_ = mo8285b.m8550f_();
        int[] iArr = new int[f_];
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            iArr[i] = mo8285b.m7949b(i).m7935k();
            int i3 = iArr[i] + i2;
            i++;
            i2 = i3;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = -1;
        BitSet bitSet2 = null;
        int i6 = 0;
        for (int i7 = 0; i7 < f_; i7++) {
            int m7931g = mo8285b.m7949b(i7).m7931g();
            if (i7 != 0) {
                i6 -= iArr[i7 - 1];
            }
            if (this.f6285g.get(m7931g) && (a2 = this.f6286h.m8140a(m7931g) + i6) >= 0 && !m8166e(a2, i2) && (m8143a = m8143a(a2, c0995l, iArr, (bitSet = new BitSet(f_)))) >= 0) {
                int cardinality = m8143a - bitSet.cardinality();
                if (cardinality > i4) {
                    bitSet2 = bitSet;
                    i5 = a2;
                    i4 = cardinality;
                }
                if (m8143a == i2) {
                    break;
                }
            }
        }
        if (i5 == -1) {
            bitSet2 = new BitSet(f_);
            i5 = m8144a(c0995l, i2, iArr, bitSet2);
        }
        for (int nextSetBit = bitSet2.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet2.nextSetBit(nextSetBit + 1)) {
            c0995l.m8281a(nextSetBit, m8197a(c0995l, mo8285b.m7949b(nextSetBit)));
        }
        return i5;
    }

    /* renamed from: a */
    private int m8144a(C0995l c0995l, int i, int[] iArr, BitSet bitSet) {
        int i2 = this.f6287i;
        while (true) {
            int m8158c = m8158c(i2, i);
            if (m8143a(m8158c, c0995l, iArr, bitSet) < 0) {
                i2 = m8158c + 1;
                bitSet.clear();
            } else {
                return m8158c;
            }
        }
    }

    /* renamed from: a */
    private int m8143a(int i, C0995l c0995l, int[] iArr, BitSet bitSet) {
        C0935q mo8285b = c0995l.mo8285b();
        int f_ = mo8285b.m8550f_();
        int i2 = 0;
        C0935q m8172a = m8172a(c0995l.m8392p().m8371q());
        BitSet bitSet2 = new BitSet(this.f6313a.m8424g());
        int i3 = i;
        for (int i4 = 0; i4 < f_; i4++) {
            C0934p m7949b = mo8285b.m7949b(i4);
            int m7931g = m7949b.m7931g();
            int i5 = iArr[i4];
            if (i4 != 0) {
                i3 += iArr[i4 - 1];
            }
            if (this.f6285g.get(m7931g) && this.f6286h.m8140a(m7931g) == i3) {
                i2 += i5;
            } else {
                if (m8157b(i3, i5)) {
                    return -1;
                }
                if (!this.f6285g.get(m7931g) && m8149a(m7949b, i3) && !bitSet2.get(m7931g)) {
                    i2 += i5;
                } else if (!this.f6286h.m8256a(m8172a, i3, i5) && !this.f6286h.m8256a(mo8285b, i3, i5)) {
                    bitSet.set(i4);
                } else {
                    return -1;
                }
            }
            bitSet2.set(m7931g);
        }
        return i2;
    }

    /* renamed from: a */
    C0935q m8172a(InterfaceC1026q interfaceC1026q) {
        C0935q c0935q = new C0935q(interfaceC1026q.mo8476a());
        InterfaceC1024o mo8479b = interfaceC1026q.mo8479b();
        int i = 0;
        while (mo8479b.mo8481a()) {
            c0935q.m7948a(i, m8196a(mo8479b.mo8482b()));
            i++;
        }
        return c0935q;
    }

    /* renamed from: c */
    private C0928j m8159c(int i) {
        for (Map.Entry<C0928j, ArrayList<C0934p>> entry : this.f6281c.entrySet()) {
            Iterator<C0934p> it = entry.getValue().iterator();
            while (it.hasNext()) {
                if (it.next().m7931g() == i) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m8148a(C0997n c0997n) {
        C0934p o = c0997n.m8391o();
        int m7931g = o.m7931g();
        int m7935k = o.m7935k();
        C0935q mo8285b = c0997n.mo8285b();
        int f_ = mo8285b.m8550f_();
        ArrayList<C0934p> arrayList = new ArrayList<>();
        a aVar = new a(f_ + 1);
        if (this.f6285g.get(m7931g)) {
            aVar.m8180a(this.f6286h.m8140a(m7931g));
        } else {
            arrayList.add(o);
        }
        for (int i = 0; i < f_; i++) {
            C0934p m8391o = this.f6313a.m8418c(mo8285b.m7949b(i).m7931g()).m8391o();
            int m7931g2 = m8391o.m7931g();
            if (this.f6285g.get(m7931g2)) {
                aVar.m8180a(this.f6286h.m8140a(m7931g2));
            } else {
                arrayList.add(m8391o);
            }
        }
        for (int i2 = 0; i2 < aVar.m8181b(); i2++) {
            m8152a(arrayList, aVar.m8179a(), m7935k, false);
        }
        int m8158c = m8158c(this.f6287i, m7935k);
        while (!m8152a(arrayList, m8158c, m7935k, false)) {
            m8158c = m8158c(m8158c + 1, m7935k);
        }
    }

    /* compiled from: FirstFitLocalCombiningAllocator.java */
    /* renamed from: com.b.b.g.a.a$a */
    private static class a {

        /* renamed from: a */
        private final int[] f6292a;

        /* renamed from: b */
        private final int[] f6293b;

        /* renamed from: c */
        private int f6294c = 0;

        public a(int i) {
            this.f6292a = new int[i];
            this.f6293b = new int[i];
        }

        /* renamed from: a */
        public void m8180a(int i) {
            for (int i2 = 0; i2 < this.f6294c; i2++) {
                if (this.f6292a[i2] == i) {
                    int[] iArr = this.f6293b;
                    iArr[i2] = iArr[i2] + 1;
                    return;
                }
            }
            this.f6292a[this.f6294c] = i;
            this.f6293b[this.f6294c] = 1;
            this.f6294c++;
        }

        /* renamed from: a */
        public int m8179a() {
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            int i4 = -1;
            while (true) {
                int i5 = i;
                if (i2 < this.f6294c) {
                    if (i3 < this.f6293b[i2]) {
                        i4 = this.f6292a[i2];
                        i3 = this.f6293b[i2];
                        i = i2;
                    } else {
                        i = i5;
                    }
                    i2++;
                } else {
                    this.f6293b[i5] = 0;
                    return i4;
                }
            }
        }

        /* renamed from: b */
        public int m8181b() {
            return this.f6294c;
        }
    }
}
