package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p095c.C0765b;
import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0936r;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0966t;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1018i;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: OutputFinisher.java */
/* renamed from: com.b.b.c.b.v */
/* loaded from: classes.dex */
public final class C0820v {

    /* renamed from: a */
    private final C0765b f5086a;

    /* renamed from: b */
    private final int f5087b;

    /* renamed from: c */
    private ArrayList<AbstractC0807i> f5088c;

    /* renamed from: f */
    private int f5091f = -1;

    /* renamed from: d */
    private boolean f5089d = false;

    /* renamed from: e */
    private boolean f5090e = false;

    public C0820v(C0765b c0765b, int i, int i2) {
        this.f5086a = c0765b;
        this.f5087b = i2;
        this.f5088c = new ArrayList<>(i);
    }

    /* renamed from: a */
    public boolean m7151a() {
        return this.f5089d;
    }

    /* renamed from: b */
    public boolean m7152b() {
        return this.f5090e;
    }

    /* renamed from: b */
    private static boolean m7139b(AbstractC0807i abstractC0807i) {
        if (abstractC0807i instanceof C0816r) {
            C0936r m7124c = ((C0816r) abstractC0807i).m7124c();
            int m7965d = m7124c.m7965d();
            for (int i = 0; i < m7965d; i++) {
                if (m7137a(m7124c.m7956a(i))) {
                    return true;
                }
            }
        } else if ((abstractC0807i instanceof C0817s) && m7137a(((C0817s) abstractC0807i).m7126c())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m7137a(C0934p c0934p) {
        return (c0934p == null || c0934p.m7933i().m7897a() == null) ? false : true;
    }

    /* renamed from: c */
    public HashSet<AbstractC0945a> m7153c() {
        HashSet<AbstractC0945a> hashSet = new HashSet<>(20);
        Iterator<AbstractC0807i> it = this.f5088c.iterator();
        while (it.hasNext()) {
            m7134a(hashSet, it.next());
        }
        return hashSet;
    }

    /* renamed from: a */
    private static void m7134a(HashSet<AbstractC0945a> hashSet, AbstractC0807i abstractC0807i) {
        if (abstractC0807i instanceof C0805g) {
            hashSet.add(((C0805g) abstractC0807i).m7018c());
            return;
        }
        if (abstractC0807i instanceof C0816r) {
            C0936r m7124c = ((C0816r) abstractC0807i).m7124c();
            int m7965d = m7124c.m7965d();
            for (int i = 0; i < m7965d; i++) {
                m7135a(hashSet, m7124c.m7956a(i));
            }
            return;
        }
        if (abstractC0807i instanceof C0817s) {
            m7135a(hashSet, ((C0817s) abstractC0807i).m7126c());
        }
    }

    /* renamed from: a */
    private static void m7135a(HashSet<AbstractC0945a> hashSet, C0934p c0934p) {
        if (c0934p != null) {
            C0928j m7933i = c0934p.m7933i();
            C0970x m7897a = m7933i.m7897a();
            C0970x m7898b = m7933i.m7898b();
            C0975c mo6695a = c0934p.mo6695a();
            if (mo6695a != C0975c.f6255j) {
                hashSet.add(C0971y.m8089b(mo6695a));
            }
            if (m7897a != null) {
                hashSet.add(m7897a);
            }
            if (m7898b != null) {
                hashSet.add(m7898b);
            }
        }
    }

    /* renamed from: a */
    public void m7150a(AbstractC0807i abstractC0807i) {
        this.f5088c.add(abstractC0807i);
        m7140c(abstractC0807i);
    }

    /* renamed from: c */
    private void m7140c(AbstractC0807i abstractC0807i) {
        if (!this.f5089d && abstractC0807i.m7042i().m8028a() >= 0) {
            this.f5089d = true;
        }
        if (!this.f5090e && m7139b(abstractC0807i)) {
            this.f5090e = true;
        }
    }

    /* renamed from: a */
    public void m7148a(int i, C0804f c0804f) {
        int size = (this.f5088c.size() - i) - 1;
        try {
            this.f5088c.set(size, ((C0797ac) this.f5088c.get(size)).m6989a(c0804f));
        } catch (ClassCastException e2) {
            throw new IllegalArgumentException("non-reversible instruction");
        } catch (IndexOutOfBoundsException e3) {
            throw new IllegalArgumentException("too few instructions");
        }
    }

    /* renamed from: a */
    public void m7149a(C0806h.a aVar) {
        Iterator<AbstractC0807i> it = this.f5088c.iterator();
        while (it.hasNext()) {
            AbstractC0807i next = it.next();
            if (next instanceof C0805g) {
                m7133a((C0805g) next, aVar);
            }
        }
    }

    /* renamed from: a */
    private static void m7133a(C0805g c0805g, C0806h.a aVar) {
        int mo6954a;
        AbstractC0945a m7018c = c0805g.m7018c();
        int mo6954a2 = aVar.mo6954a(m7018c);
        if (mo6954a2 >= 0) {
            c0805g.m7016a(mo6954a2);
        }
        if ((m7018c instanceof AbstractC0966t) && (mo6954a = aVar.mo6954a(((AbstractC0966t) m7018c).m8070m())) >= 0) {
            c0805g.m7017b(mo6954a);
        }
    }

    /* renamed from: d */
    public C0808j m7154d() {
        if (this.f5091f >= 0) {
            throw new UnsupportedOperationException("already processed");
        }
        C0809k[] m7144e = m7144e();
        m7136a(m7144e);
        m7141c(m7144e);
        m7145f();
        return C0808j.m7048a(this.f5088c, this.f5091f + this.f5087b);
    }

    /* renamed from: e */
    private C0809k[] m7144e() {
        int size = this.f5088c.size();
        C0809k[] c0809kArr = new C0809k[size];
        for (int i = 0; i < size; i++) {
            c0809kArr[i] = this.f5088c.get(i).m7041h();
        }
        return c0809kArr;
    }

    /* renamed from: a */
    private void m7136a(C0809k[] c0809kArr) {
        int i = this.f5091f < 0 ? 0 : this.f5091f;
        while (true) {
            int m7138b = m7138b(c0809kArr);
            if (i < m7138b) {
                int i2 = m7138b - i;
                int size = this.f5088c.size();
                for (int i3 = 0; i3 < size; i3++) {
                    AbstractC0807i abstractC0807i = this.f5088c.get(i3);
                    if (!(abstractC0807i instanceof C0804f)) {
                        this.f5088c.set(i3, abstractC0807i.mo6995d(i2));
                    }
                }
                i = m7138b;
            } else {
                this.f5091f = i;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
    
        if (r0 > r1) goto L8;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m7138b(C0809k[] c0809kArr) {
        int i;
        int size = this.f5088c.size();
        int i2 = this.f5091f;
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC0807i abstractC0807i = this.f5088c.get(i3);
            C0809k c0809k = c0809kArr[i3];
            C0809k m7132a = m7132a(abstractC0807i, c0809k);
            if (m7132a == null) {
                i = abstractC0807i.m7033a(m7142d(abstractC0807i).m7058c().mo6975c(abstractC0807i));
            } else if (c0809k == m7132a) {
            }
            i = i2;
            c0809kArr[i3] = m7132a;
            i2 = i;
        }
        return i2;
    }

    /* renamed from: a */
    private C0809k m7132a(AbstractC0807i abstractC0807i, C0809k c0809k) {
        while (c0809k != null && !c0809k.m7058c().mo6974b(abstractC0807i)) {
            c0809k = C0810l.m7064a(c0809k, this.f5086a);
        }
        return c0809k;
    }

    /* renamed from: d */
    private C0809k m7142d(AbstractC0807i abstractC0807i) {
        C0809k m7132a = m7132a(abstractC0807i.m7045l(), abstractC0807i.m7041h());
        if (m7132a == null) {
            throw new C1018i("No expanded opcode for " + abstractC0807i);
        }
        return m7132a;
    }

    /* renamed from: c */
    private void m7141c(C0809k[] c0809kArr) {
        if (this.f5091f == 0) {
            int size = this.f5088c.size();
            for (int i = 0; i < size; i++) {
                AbstractC0807i abstractC0807i = this.f5088c.get(i);
                C0809k m7041h = abstractC0807i.m7041h();
                C0809k c0809k = c0809kArr[i];
                if (m7041h != c0809k) {
                    this.f5088c.set(i, abstractC0807i.mo6990a(c0809k));
                }
            }
            return;
        }
        this.f5088c = m7143d(c0809kArr);
    }

    /* renamed from: d */
    private ArrayList<AbstractC0807i> m7143d(C0809k[] c0809kArr) {
        AbstractC0807i m7035b;
        AbstractC0807i m7036c;
        int size = this.f5088c.size();
        ArrayList<AbstractC0807i> arrayList = new ArrayList<>(size * 2);
        for (int i = 0; i < size; i++) {
            AbstractC0807i abstractC0807i = this.f5088c.get(i);
            C0809k m7041h = abstractC0807i.m7041h();
            C0809k c0809k = c0809kArr[i];
            if (c0809k != null) {
                m7036c = null;
                m7035b = null;
            } else {
                c0809k = m7142d(abstractC0807i);
                BitSet mo6975c = c0809k.m7058c().mo6975c(abstractC0807i);
                m7035b = abstractC0807i.m7035b(mo6975c);
                m7036c = abstractC0807i.m7036c(mo6975c);
                abstractC0807i = abstractC0807i.m7038d(mo6975c);
            }
            if (m7035b != null) {
                arrayList.add(m7035b);
            }
            if (c0809k != m7041h) {
                abstractC0807i = abstractC0807i.mo6990a(c0809k);
            }
            arrayList.add(abstractC0807i);
            if (m7036c != null) {
                arrayList.add(m7036c);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    private void m7145f() {
        do {
            m7146g();
        } while (m7147h());
    }

    /* renamed from: g */
    private void m7146g() {
        int size = this.f5088c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0807i abstractC0807i = this.f5088c.get(i2);
            abstractC0807i.m7037c(i);
            i += abstractC0807i.mo6964a();
        }
    }

    /* renamed from: h */
    private boolean m7147h() {
        int i;
        int i2;
        int size = this.f5088c.size();
        int i3 = 0;
        boolean z = false;
        while (i3 < size) {
            AbstractC0807i abstractC0807i = this.f5088c.get(i3);
            if (abstractC0807i instanceof C0797ac) {
                C0809k m7041h = abstractC0807i.m7041h();
                C0797ac c0797ac = (C0797ac) abstractC0807i;
                if (m7041h.m7058c().mo6972a(c0797ac)) {
                    i = size;
                } else {
                    if (m7041h.m7057b() == 40) {
                        C0809k m7132a = m7132a(abstractC0807i, m7041h);
                        if (m7132a == null) {
                            throw new UnsupportedOperationException("method too long");
                        }
                        this.f5088c.set(i3, abstractC0807i.mo6990a(m7132a));
                        i2 = i3;
                        i = size;
                    } else {
                        try {
                            C0804f c0804f = (C0804f) this.f5088c.get(i3 + 1);
                            this.f5088c.set(i3, new C0797ac(C0810l.f4818P, c0797ac.m7042i(), C0935q.f5906a, c0797ac.m6991c()));
                            this.f5088c.add(i3, c0797ac.m6989a(c0804f));
                            i = size + 1;
                            i2 = i3 + 1;
                        } catch (ClassCastException e2) {
                            throw new IllegalStateException("unpaired TargetInsn");
                        } catch (IndexOutOfBoundsException e3) {
                            throw new IllegalStateException("unpaired TargetInsn (dangling)");
                        }
                    }
                    i3 = i2;
                    z = true;
                }
            } else {
                i = size;
            }
            i3++;
            size = i;
        }
        return z;
    }
}
