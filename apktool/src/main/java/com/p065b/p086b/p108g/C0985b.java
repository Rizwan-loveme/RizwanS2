package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0931m;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p105b.C0942x;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ConstCollector.java */
/* renamed from: com.b.b.g.b */
/* loaded from: classes.dex */
public class C0985b {

    /* renamed from: a */
    private static boolean f6321a = false;

    /* renamed from: b */
    private static boolean f6322b = false;

    /* renamed from: c */
    private final C1005v f6323c;

    /* renamed from: a */
    public static void m8212a(C1005v c1005v) {
        new C0985b(c1005v).m8210a();
    }

    private C0985b(C1005v c1005v) {
        this.f6323c = c1005v;
    }

    /* renamed from: a */
    private void m8210a() {
        int m8424g = this.f6323c.m8424g();
        ArrayList<AbstractC0946aa> m8214b = m8214b();
        int min = Math.min(m8214b.size(), 5);
        C1002s m8419d = this.f6323c.m8419d();
        HashMap<AbstractC0946aa, C0934p> hashMap = new HashMap<>(min);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < min) {
                AbstractC0946aa abstractC0946aa = m8214b.get(i2);
                C0934p m7913a = C0934p.m7913a(this.f6323c.m8432o(), abstractC0946aa);
                C0937s m8000f = C0939u.m8000f(abstractC0946aa);
                if (m8000f.m7971d() == 1) {
                    m8419d.m8342a(new C0931m(C0939u.m8000f(abstractC0946aa), C0940v.f6128a, m7913a, C0935q.f5906a, abstractC0946aa));
                } else {
                    C1002s m8419d2 = this.f6323c.m8419d();
                    C1002s m8367m = m8419d2.m8367m();
                    C1002s m8348b = m8419d2.m8348b(m8367m);
                    m8348b.m8351b(new C0942x(m8000f, C0940v.f6128a, C0935q.f5906a, C0974b.f6209a, abstractC0946aa));
                    m8348b.m8348b(m8367m).m8342a(new C0932n(C0939u.m7998e(m7913a.m7932h()), C0940v.f6128a, m7913a, C0935q.f5906a));
                }
                hashMap.put(abstractC0946aa, m7913a);
                i = i2 + 1;
            } else {
                m8213a(hashMap, m8424g);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private ArrayList<AbstractC0946aa> m8214b() {
        int m8424g = this.f6323c.m8424g();
        final HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < m8424g; i++) {
            AbstractC1004u m8418c = this.f6323c.m8418c(i);
            if (m8418c != null && m8418c.mo8287e() != null) {
                C0934p m8391o = m8418c.m8391o();
                InterfaceC0976d m7932h = m8391o.m7932h();
                if (m7932h.mo6699f()) {
                    AbstractC0946aa abstractC0946aa = (AbstractC0946aa) m7932h;
                    if (m8418c.mo8287e().m7968a() == 56) {
                        m8418c = this.f6323c.m8427j().get(m8418c.m8392p().m8362h().nextSetBit(0)).m8353c().get(r1.size() - 1);
                    }
                    if (!m8418c.mo8293k() || ((abstractC0946aa instanceof C0970x) && f6321a && m8418c.m8392p().m8363i().cardinality() <= 1)) {
                        if (this.f6323c.m8413a(m8391o)) {
                            if (f6322b && !hashSet.contains(abstractC0946aa)) {
                                hashSet.add(abstractC0946aa);
                            }
                        }
                        Integer num = (Integer) hashMap.get(abstractC0946aa);
                        if (num == null) {
                            hashMap.put(abstractC0946aa, 1);
                        } else {
                            hashMap.put(abstractC0946aa, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
            }
        }
        ArrayList<AbstractC0946aa> arrayList = new ArrayList<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > 1) {
                arrayList.add(entry.getKey());
            }
        }
        Collections.sort(arrayList, new Comparator<AbstractC0945a>() { // from class: com.b.b.g.b.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(AbstractC0945a abstractC0945a, AbstractC0945a abstractC0945a2) {
                int intValue = ((Integer) hashMap.get(abstractC0945a2)).intValue() - ((Integer) hashMap.get(abstractC0945a)).intValue();
                if (intValue == 0) {
                    return abstractC0945a.compareTo(abstractC0945a2);
                }
                return intValue;
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return obj == this;
            }
        });
        return arrayList;
    }

    /* renamed from: a */
    private void m8211a(C0934p c0934p, C0934p c0934p2) {
        for (AbstractC1004u abstractC1004u : this.f6323c.m8420d(c0934p.m7931g())) {
            C0934p mo8289g = abstractC1004u.mo8289g();
            if (mo8289g != null && abstractC1004u.m8391o() != null) {
                C0928j m7933i = mo8289g.m7933i();
                abstractC1004u.m8386a((C0928j) null);
                c0934p2 = c0934p2.m7923a(m7933i);
                AbstractC1004u m8385a = AbstractC1004u.m8385a(new C0932n(C0939u.m8026s(c0934p2), C0940v.f6128a, (C0934p) null, C0935q.m7944a(c0934p2)), abstractC1004u.m8392p());
                ArrayList<AbstractC1004u> m8353c = abstractC1004u.m8392p().m8353c();
                m8353c.add(m8353c.indexOf(abstractC1004u) + 1, m8385a);
            }
        }
    }

    /* renamed from: a */
    private void m8213a(HashMap<AbstractC0946aa, C0934p> hashMap, int i) {
        AbstractC0946aa abstractC0946aa;
        final C0934p c0934p;
        HashSet hashSet = new HashSet();
        ArrayList<AbstractC1004u>[] m8431n = this.f6323c.m8431n();
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC1004u m8418c = this.f6323c.m8418c(i2);
            if (m8418c != null) {
                final C0934p m8391o = m8418c.m8391o();
                InterfaceC0976d m7932h = m8418c.m8391o().m7932h();
                if (m7932h.mo6699f() && (c0934p = hashMap.get((abstractC0946aa = (AbstractC0946aa) m7932h))) != null) {
                    if (this.f6323c.m8413a(m8391o)) {
                        if (f6322b && !hashSet.contains(abstractC0946aa)) {
                            hashSet.add(abstractC0946aa);
                            m8211a(m8391o, hashMap.get(abstractC0946aa));
                        }
                    }
                    AbstractC0999p abstractC0999p = new AbstractC0999p() { // from class: com.b.b.g.b.2
                        @Override // com.p065b.p086b.p108g.AbstractC0999p
                        /* renamed from: a */
                        public int mo8139a() {
                            return C0985b.this.f6323c.m8424g();
                        }

                        @Override // com.p065b.p086b.p108g.AbstractC0999p
                        /* renamed from: a */
                        public C0934p mo8141a(C0934p c0934p2) {
                            if (c0934p2.m7931g() == m8391o.m7931g()) {
                                return c0934p.m7923a(c0934p2.m7933i());
                            }
                            return c0934p2;
                        }
                    };
                    Iterator<AbstractC1004u> it = m8431n[m8391o.m7931g()].iterator();
                    while (it.hasNext()) {
                        AbstractC1004u next = it.next();
                        if (!next.mo8293k() || next.m8392p().m8363i().cardinality() <= 1) {
                            next.mo8283a(abstractC0999p);
                        }
                    }
                }
            }
        }
    }
}
