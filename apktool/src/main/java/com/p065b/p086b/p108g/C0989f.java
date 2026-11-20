package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0924f;
import com.p065b.p086b.p103f.p105b.C0925g;
import com.p065b.p086b.p103f.p105b.C0931m;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.C0942x;
import com.p065b.p086b.p103f.p105b.C0943y;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p103f.p106c.C0947ab;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C1002s;
import com.p065b.p086b.p110h.InterfaceC1035z;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: EscapeAnalysis.java */
/* renamed from: com.b.b.g.f */
/* loaded from: classes.dex */
public class C0989f {

    /* renamed from: a */
    private C1005v f6353a;

    /* renamed from: b */
    private int f6354b;

    /* renamed from: c */
    private ArrayList<a> f6355c = new ArrayList<>();

    /* compiled from: EscapeAnalysis.java */
    /* renamed from: com.b.b.g.f$b */
    public enum b {
        TOP,
        NONE,
        METHOD,
        INTER,
        GLOBAL
    }

    /* compiled from: EscapeAnalysis.java */
    /* renamed from: com.b.b.g.f$a */
    static class a {

        /* renamed from: a */
        BitSet f6361a;

        /* renamed from: b */
        b f6362b;

        /* renamed from: c */
        ArrayList<a> f6363c;

        /* renamed from: d */
        ArrayList<a> f6364d;

        /* renamed from: e */
        boolean f6365e;

        a(int i, int i2, b bVar) {
            this.f6361a = new BitSet(i2);
            this.f6361a.set(i);
            this.f6362b = bVar;
            this.f6363c = new ArrayList<>();
            this.f6364d = new ArrayList<>();
            this.f6365e = false;
        }
    }

    private C0989f(C1005v c1005v) {
        this.f6353a = c1005v;
        this.f6354b = c1005v.m8424g();
    }

    /* renamed from: a */
    private int m8233a(C0934p c0934p) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.f6355c.size() || this.f6355c.get(i).f6361a.get(c0934p.m7931g())) {
                break;
            }
            i2 = i + 1;
        }
        return i;
    }

    /* renamed from: a */
    private AbstractC1004u m8234a(AbstractC1004u abstractC1004u) {
        return this.f6353a.m8427j().get(abstractC1004u.m8392p().m8362h().nextSetBit(0)).m8353c().get(r0.size() - 1);
    }

    /* renamed from: b */
    private AbstractC1004u m8247b(AbstractC1004u abstractC1004u) {
        return this.f6353a.m8427j().get(abstractC1004u.m8392p().m8363i().nextSetBit(0)).m8353c().get(0);
    }

    /* renamed from: a */
    private void m8239a(a aVar, a aVar2) {
        if (!aVar2.f6364d.contains(aVar)) {
            aVar2.f6364d.add(aVar);
        }
        if (!aVar.f6363c.contains(aVar2)) {
            aVar.f6363c.add(aVar2);
        }
    }

    /* renamed from: b */
    private void m8249b(a aVar, a aVar2) {
        Iterator<a> it = aVar2.f6364d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            next.f6363c.remove(aVar2);
            next.f6363c.add(aVar);
            aVar.f6364d.add(next);
        }
        Iterator<a> it2 = aVar2.f6363c.iterator();
        while (it2.hasNext()) {
            a next2 = it2.next();
            next2.f6364d.remove(aVar2);
            next2.f6364d.add(aVar);
            aVar.f6363c.add(next2);
        }
    }

    /* renamed from: a */
    public static void m8246a(C1005v c1005v) {
        new C0989f(c1005v).m8251c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8252c(AbstractC1004u abstractC1004u) {
        int m7968a = abstractC1004u.mo8287e().m7968a();
        C0934p m8391o = abstractC1004u.m8391o();
        if (m7968a == 56 && m8391o.m7932h().mo6697c() == 9) {
            m8237a(m8391o, m8253d(abstractC1004u));
            return;
        }
        if (m7968a == 3 && m8391o.m7932h().mo6697c() == 9) {
            a aVar = new a(m8391o.m7931g(), this.f6354b, b.NONE);
            this.f6355c.add(aVar);
            m8237a(m8391o, aVar);
        } else if (m7968a == 55 && m8391o.m7932h().mo6697c() == 9) {
            a aVar2 = new a(m8391o.m7931g(), this.f6354b, b.NONE);
            this.f6355c.add(aVar2);
            m8237a(m8391o, aVar2);
        }
    }

    /* renamed from: d */
    private a m8253d(AbstractC1004u abstractC1004u) {
        a aVar;
        C0934p m8391o = abstractC1004u.m8391o();
        AbstractC1004u m8234a = m8234a(abstractC1004u);
        switch (m8234a.mo8287e().m7968a()) {
            case 5:
            case 40:
                aVar = new a(m8391o.m7931g(), this.f6354b, b.NONE);
                break;
            case 38:
            case 43:
            case 45:
                C0934p m7949b = m8234a.mo8285b().m7949b(0);
                int m8233a = m8233a(m7949b);
                if (m8233a != this.f6355c.size()) {
                    a aVar2 = this.f6355c.get(m8233a);
                    aVar2.f6361a.set(m8391o.m7931g());
                    return aVar2;
                }
                if (m7949b.mo6695a() == C0975c.f6255j) {
                    aVar = new a(m8391o.m7931g(), this.f6354b, b.NONE);
                    break;
                } else {
                    aVar = new a(m8391o.m7931g(), this.f6354b, b.GLOBAL);
                    break;
                }
            case 41:
            case 42:
                if (m8234a.mo8285b().m7949b(0).m7932h().mo6699f()) {
                    aVar = new a(m8391o.m7931g(), this.f6354b, b.NONE);
                    aVar.f6365e = true;
                    break;
                } else {
                    aVar = new a(m8391o.m7931g(), this.f6354b, b.GLOBAL);
                    break;
                }
            case 46:
                aVar = new a(m8391o.m7931g(), this.f6354b, b.GLOBAL);
                break;
            default:
                return null;
        }
        this.f6355c.add(aVar);
        return aVar;
    }

    /* renamed from: a */
    private void m8237a(C0934p c0934p, a aVar) {
        ArrayList<C0934p> arrayList = new ArrayList<>();
        arrayList.add(c0934p);
        while (!arrayList.isEmpty()) {
            C0934p remove = arrayList.remove(arrayList.size() - 1);
            for (AbstractC1004u abstractC1004u : this.f6353a.m8420d(remove.m7931g())) {
                if (abstractC1004u.mo8287e() == null) {
                    m8243a(abstractC1004u, aVar, arrayList);
                } else {
                    m8238a(remove, abstractC1004u, aVar, arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8243a(AbstractC1004u abstractC1004u, a aVar, ArrayList<C0934p> arrayList) {
        int m8233a = m8233a(abstractC1004u.m8391o());
        if (m8233a != this.f6355c.size()) {
            a aVar2 = this.f6355c.get(m8233a);
            if (aVar2 != aVar) {
                aVar.f6365e = false;
                aVar.f6361a.mo13226or(aVar2.f6361a);
                if (aVar.f6362b.compareTo(aVar2.f6362b) < 0) {
                    aVar.f6362b = aVar2.f6362b;
                }
                m8249b(aVar, aVar2);
                this.f6355c.remove(m8233a);
                return;
            }
            return;
        }
        aVar.f6361a.set(abstractC1004u.m8391o().m7931g());
        arrayList.add(abstractC1004u.m8391o());
    }

    /* renamed from: a */
    private void m8238a(C0934p c0934p, AbstractC1004u abstractC1004u, a aVar, ArrayList<C0934p> arrayList) {
        switch (abstractC1004u.mo8287e().m7968a()) {
            case 2:
                aVar.f6361a.set(abstractC1004u.m8391o().m7931g());
                arrayList.add(abstractC1004u.m8391o());
                return;
            case 7:
            case 8:
            case 43:
                if (aVar.f6362b.compareTo(b.METHOD) < 0) {
                    aVar.f6362b = b.METHOD;
                    return;
                }
                return;
            case 33:
            case 35:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                aVar.f6362b = b.INTER;
                return;
            case 38:
                if (!abstractC1004u.mo8285b().m7949b(1).m7932h().mo6699f()) {
                    aVar.f6365e = false;
                    return;
                }
                return;
            case 39:
                if (!abstractC1004u.mo8285b().m7949b(2).m7932h().mo6699f()) {
                    aVar.f6365e = false;
                    break;
                }
                break;
            case 47:
                break;
            case 48:
                aVar.f6362b = b.GLOBAL;
                return;
            default:
                return;
        }
        if (abstractC1004u.mo8285b().m7949b(0).m7932h().mo6697c() == 9) {
            aVar.f6365e = false;
            C0935q mo8285b = abstractC1004u.mo8285b();
            if (mo8285b.m7949b(0).m7931g() == c0934p.m7931g()) {
                int m8233a = m8233a(mo8285b.m7949b(1));
                if (m8233a != this.f6355c.size()) {
                    a aVar2 = this.f6355c.get(m8233a);
                    m8239a(aVar2, aVar);
                    if (aVar.f6362b.compareTo(aVar2.f6362b) < 0) {
                        aVar.f6362b = aVar2.f6362b;
                        return;
                    }
                    return;
                }
                return;
            }
            int m8233a2 = m8233a(mo8285b.m7949b(0));
            if (m8233a2 != this.f6355c.size()) {
                a aVar3 = this.f6355c.get(m8233a2);
                m8239a(aVar, aVar3);
                if (aVar3.f6362b.compareTo(aVar.f6362b) < 0) {
                    aVar3.f6362b = aVar.f6362b;
                }
            }
        }
    }

    /* renamed from: a */
    private void m8236a() {
        Iterator<a> it = this.f6355c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f6365e && next.f6362b == b.NONE) {
                int nextSetBit = next.f6361a.nextSetBit(0);
                AbstractC1004u m8418c = this.f6353a.m8418c(nextSetBit);
                AbstractC1004u m8234a = m8234a(m8418c);
                int mo8064j = ((AbstractC0964r) m8234a.mo8285b().m7949b(0).m7932h()).mo8064j();
                ArrayList<C0934p> arrayList = new ArrayList<>(mo8064j);
                HashSet<AbstractC1004u> hashSet = new HashSet<>();
                m8244a(m8418c, m8234a, mo8064j, arrayList);
                hashSet.add(m8234a);
                hashSet.add(m8418c);
                for (AbstractC1004u abstractC1004u : this.f6353a.m8420d(nextSetBit)) {
                    m8245a(abstractC1004u, m8234a, arrayList, hashSet);
                    hashSet.add(abstractC1004u);
                }
                this.f6353a.m8411a(hashSet);
                this.f6353a.m8430m();
                C1003t.m8378a(this.f6353a, this.f6354b);
                m8248b();
            }
        }
    }

    /* renamed from: a */
    private void m8244a(AbstractC1004u abstractC1004u, AbstractC1004u abstractC1004u2, int i, ArrayList<C0934p> arrayList) {
        C0975c mo6695a = abstractC1004u.m8391o().mo6695a();
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC0945a m8037a = C0947ab.m8037a(mo6695a.m8138u());
            C0934p m7913a = C0934p.m7913a(this.f6353a.m8432o(), (AbstractC0946aa) m8037a);
            arrayList.add(m7913a);
            m8242a(abstractC1004u, C0935q.f5906a, m7913a, 5, m8037a);
        }
    }

    /* renamed from: a */
    private void m8245a(AbstractC1004u abstractC1004u, AbstractC1004u abstractC1004u2, ArrayList<C0934p> arrayList, HashSet<AbstractC1004u> hashSet) {
        int size = arrayList.size();
        switch (abstractC1004u.mo8287e().m7968a()) {
            case 34:
                InterfaceC1035z m7932h = abstractC1004u2.mo8285b().m7949b(0).m7932h();
                AbstractC1004u m8247b = m8247b(abstractC1004u);
                m8242a(m8247b, C0935q.f5906a, m8247b.m8391o(), 5, (AbstractC0945a) m7932h);
                hashSet.add(m8247b);
                break;
            case 38:
                AbstractC1004u m8247b2 = m8247b(abstractC1004u);
                C0935q mo8285b = abstractC1004u.mo8285b();
                int mo8064j = ((AbstractC0964r) mo8285b.m7949b(1).m7932h()).mo8064j();
                if (mo8064j < size) {
                    C0934p c0934p = arrayList.get(mo8064j);
                    m8242a(m8247b2, C0935q.m7944a(c0934p), c0934p.m7927b(m8247b2.m8391o().m7931g()), 2, null);
                } else {
                    m8241a(m8247b2, mo8285b.m7949b(1), hashSet);
                    hashSet.add(m8247b2.m8392p().m8353c().get(2));
                }
                hashSet.add(m8247b2);
                break;
            case 39:
                C0935q mo8285b2 = abstractC1004u.mo8285b();
                int mo8064j2 = ((AbstractC0964r) mo8285b2.m7949b(2).m7932h()).mo8064j();
                if (mo8064j2 < size) {
                    C0934p m7949b = mo8285b2.m7949b(0);
                    C0934p m7927b = m7949b.m7927b(arrayList.get(mo8064j2).m7931g());
                    m8242a(abstractC1004u, C0935q.m7944a(m7949b), m7927b, 2, null);
                    arrayList.set(mo8064j2, m7927b.m7938n());
                    break;
                } else {
                    m8241a(abstractC1004u, mo8285b2.m7949b(2), hashSet);
                    break;
                }
            case 57:
                ArrayList<AbstractC0945a> m7877c = ((C0925g) abstractC1004u.mo8288f()).m7877c();
                for (int i = 0; i < size; i++) {
                    C0934p m7913a = C0934p.m7913a(arrayList.get(i).m7931g(), (InterfaceC0976d) m7877c.get(i));
                    m8242a(abstractC1004u, C0935q.f5906a, m7913a, 5, m7877c.get(i));
                    arrayList.set(i, m7913a);
                }
                break;
        }
    }

    /* renamed from: b */
    private void m8248b() {
        for (int i = 0; i < this.f6353a.m8424g(); i++) {
            AbstractC1004u m8418c = this.f6353a.m8418c(i);
            if (m8418c != null && m8418c.mo8287e() != null && m8418c.mo8287e().m7968a() == 2) {
                ArrayList<AbstractC1004u>[] m8431n = this.f6353a.m8431n();
                final C0934p m7949b = m8418c.mo8285b().m7949b(0);
                final C0934p m8391o = m8418c.m8391o();
                if (m7949b.m7931g() >= this.f6354b || m8391o.m7931g() >= this.f6354b) {
                    AbstractC0999p abstractC0999p = new AbstractC0999p() { // from class: com.b.b.g.f.1
                        @Override // com.p065b.p086b.p108g.AbstractC0999p
                        /* renamed from: a */
                        public int mo8139a() {
                            return C0989f.this.f6353a.m8424g();
                        }

                        @Override // com.p065b.p086b.p108g.AbstractC0999p
                        /* renamed from: a */
                        public C0934p mo8141a(C0934p c0934p) {
                            if (c0934p.m7931g() == m8391o.m7931g()) {
                                return m7949b;
                            }
                            return c0934p;
                        }
                    };
                    Iterator<AbstractC1004u> it = m8431n[m8391o.m7931g()].iterator();
                    while (it.hasNext()) {
                        it.next().mo8283a(abstractC0999p);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m8251c() {
        this.f6353a.m8405a(new C1002s.b() { // from class: com.b.b.g.f.2
            @Override // com.p065b.p086b.p108g.C1002s.b
            /* renamed from: a */
            public void mo8207a(C1002s c1002s, C1002s c1002s2) {
                c1002s.m8347a(new AbstractC1004u.a() { // from class: com.b.b.g.f.2.1
                    @Override // com.p065b.p086b.p108g.AbstractC1004u.a
                    /* renamed from: a */
                    public void mo8176a(C0995l c0995l) {
                    }

                    @Override // com.p065b.p086b.p108g.AbstractC1004u.a
                    /* renamed from: a */
                    public void mo8177a(C0997n c0997n) {
                    }

                    @Override // com.p065b.p086b.p108g.AbstractC1004u.a
                    /* renamed from: b */
                    public void mo8178b(C0995l c0995l) {
                        C0989f.this.m8252c(c0995l);
                    }
                });
            }
        });
        Iterator<a> it = this.f6355c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f6362b != b.NONE) {
                Iterator<a> it2 = next.f6363c.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next.f6362b.compareTo(next2.f6362b) > 0) {
                        next2.f6362b = next.f6362b;
                    }
                }
            }
        }
        m8236a();
    }

    /* renamed from: a */
    private void m8241a(AbstractC1004u abstractC1004u, C0934p c0934p, HashSet<AbstractC1004u> hashSet) {
        C0971y c0971y = new C0971y(C0924f.f5867b);
        m8250b(abstractC1004u, C0935q.f5906a, null, 40, c0971y);
        C1002s m8392p = abstractC1004u.m8392p();
        C1002s m8348b = m8392p.m8348b(m8392p.m8367m());
        AbstractC1004u abstractC1004u2 = m8348b.m8353c().get(0);
        C0934p m7913a = C0934p.m7913a(this.f6353a.m8432o(), c0971y);
        m8242a(abstractC1004u2, C0935q.f5906a, m7913a, 56, null);
        C1002s m8348b2 = m8348b.m8348b(m8348b.m8367m());
        AbstractC1004u abstractC1004u3 = m8348b2.m8353c().get(0);
        m8250b(abstractC1004u3, C0935q.m7945a(m7913a, c0934p), null, 52, new C0967u(c0971y, new C0968v(new C0970x("<init>"), new C0970x("(I)V"))));
        hashSet.add(abstractC1004u3);
        C1002s m8348b3 = m8348b2.m8348b(m8348b2.m8367m());
        AbstractC1004u abstractC1004u4 = m8348b3.m8353c().get(0);
        m8250b(abstractC1004u4, C0935q.m7944a(m7913a), null, 35, null);
        m8348b3.m8341a(m8348b3.m8365k(), this.f6353a.m8423f().m8358e());
        hashSet.add(abstractC1004u4);
    }

    /* renamed from: a */
    private void m8242a(AbstractC1004u abstractC1004u, C0935q c0935q, C0934p c0934p, int i, AbstractC0945a abstractC0945a) {
        C0937s m7980a;
        AbstractC0926h c0931m;
        AbstractC0926h mo8288f = abstractC1004u.mo8288f();
        if (i == 56) {
            m7980a = C0939u.m7998e(c0934p.mo6695a());
        } else {
            m7980a = C0939u.m7980a(i, c0934p, c0935q, abstractC0945a);
        }
        if (abstractC0945a == null) {
            c0931m = new C0932n(m7980a, mo8288f.m7883g(), c0934p, c0935q);
        } else {
            c0931m = new C0931m(m7980a, mo8288f.m7883g(), c0934p, c0935q, abstractC0945a);
        }
        C0995l c0995l = new C0995l(c0931m, abstractC1004u.m8392p());
        ArrayList<AbstractC1004u> m8353c = abstractC1004u.m8392p().m8353c();
        m8353c.add(m8353c.lastIndexOf(abstractC1004u), c0995l);
        this.f6353a.m8407a(c0995l);
    }

    /* renamed from: b */
    private void m8250b(AbstractC1004u abstractC1004u, C0935q c0935q, C0934p c0934p, int i, AbstractC0945a abstractC0945a) {
        AbstractC0926h c0942x;
        AbstractC0926h mo8288f = abstractC1004u.mo8288f();
        C0937s m7980a = C0939u.m7980a(i, c0934p, c0935q, abstractC0945a);
        if (abstractC0945a == null) {
            c0942x = new C0943y(m7980a, mo8288f.m7883g(), c0935q, C0974b.f6209a);
        } else {
            c0942x = new C0942x(m7980a, mo8288f.m7883g(), c0935q, C0974b.f6209a, abstractC0945a);
        }
        C0995l c0995l = new C0995l(c0942x, abstractC1004u.m8392p());
        ArrayList<AbstractC1004u> m8353c = abstractC1004u.m8392p().m8353c();
        m8353c.add(m8353c.lastIndexOf(abstractC1004u), c0995l);
        this.f6353a.m8407a(c0995l);
    }
}
