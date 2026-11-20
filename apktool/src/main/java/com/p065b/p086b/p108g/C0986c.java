package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p108g.AbstractC1004u;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DeadCodeRemover.java */
/* renamed from: com.b.b.g.c */
/* loaded from: classes.dex */
public class C0986c {

    /* renamed from: a */
    private final C1005v f6329a;

    /* renamed from: b */
    private final int f6330b;

    /* renamed from: c */
    private final BitSet f6331c;

    /* renamed from: d */
    private final ArrayList<AbstractC1004u>[] f6332d;

    /* renamed from: a */
    public static void m8217a(C1005v c1005v) {
        new C0986c(c1005v).m8216a();
    }

    private C0986c(C1005v c1005v) {
        this.f6329a = c1005v;
        this.f6330b = c1005v.m8424g();
        this.f6331c = new BitSet(this.f6330b);
        this.f6332d = this.f6329a.m8431n();
    }

    /* renamed from: a */
    private void m8216a() {
        m8220b();
        HashSet hashSet = new HashSet();
        this.f6329a.m8406a(new a(this.f6331c));
        while (true) {
            int nextSetBit = this.f6331c.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.f6331c.clear(nextSetBit);
                if (this.f6332d[nextSetBit].size() == 0 || m8218a(nextSetBit, null)) {
                    AbstractC1004u m8418c = this.f6329a.m8418c(nextSetBit);
                    if (!hashSet.contains(m8418c)) {
                        C0935q mo8285b = m8418c.mo8285b();
                        int f_ = mo8285b.m8550f_();
                        for (int i = 0; i < f_; i++) {
                            C0934p m7949b = mo8285b.m7949b(i);
                            this.f6332d[m7949b.m7931g()].remove(m8418c);
                            if (!m8221b(this.f6329a.m8418c(m7949b.m7931g()))) {
                                this.f6331c.set(m7949b.m7931g());
                            }
                        }
                        hashSet.add(m8418c);
                    }
                }
            } else {
                this.f6329a.m8411a(hashSet);
                return;
            }
        }
    }

    /* renamed from: b */
    private void m8220b() {
        HashSet hashSet = new HashSet();
        this.f6329a.m8429l();
        Iterator<C1002s> it = this.f6329a.m8427j().iterator();
        while (it.hasNext()) {
            C1002s next = it.next();
            if (!next.m8373s()) {
                for (int i = 0; i < next.m8353c().size(); i++) {
                    AbstractC1004u abstractC1004u = next.m8353c().get(i);
                    C0935q mo8285b = abstractC1004u.mo8285b();
                    int f_ = mo8285b.m8550f_();
                    if (f_ != 0) {
                        hashSet.add(abstractC1004u);
                    }
                    for (int i2 = 0; i2 < f_; i2++) {
                        this.f6332d[mo8285b.m7949b(i2).m7931g()].remove(abstractC1004u);
                    }
                    C0934p m8391o = abstractC1004u.m8391o();
                    if (m8391o != null) {
                        Iterator<AbstractC1004u> it2 = this.f6332d[m8391o.m7931g()].iterator();
                        while (it2.hasNext()) {
                            AbstractC1004u next2 = it2.next();
                            if (next2 instanceof C0997n) {
                                ((C0997n) next2).m8307a(m8391o);
                            }
                        }
                    }
                }
            }
        }
        this.f6329a.m8411a(hashSet);
    }

    /* renamed from: a */
    private boolean m8218a(int i, BitSet bitSet) {
        if (bitSet != null && bitSet.get(i)) {
            return true;
        }
        Iterator<AbstractC1004u> it = this.f6332d[i].iterator();
        while (it.hasNext()) {
            if (m8221b(it.next())) {
                return false;
            }
        }
        if (bitSet == null) {
            bitSet = new BitSet(this.f6330b);
        }
        bitSet.set(i);
        Iterator<AbstractC1004u> it2 = this.f6332d[i].iterator();
        while (it2.hasNext()) {
            C0934p m8391o = it2.next().m8391o();
            if (m8391o == null || !m8218a(m8391o.m7931g(), bitSet)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m8221b(AbstractC1004u abstractC1004u) {
        if (abstractC1004u == null) {
            return true;
        }
        return abstractC1004u.mo8295m();
    }

    /* compiled from: DeadCodeRemover.java */
    /* renamed from: com.b.b.g.c$a */
    private static class a implements AbstractC1004u.a {

        /* renamed from: a */
        BitSet f6333a;

        public a(BitSet bitSet) {
            this.f6333a = bitSet;
        }

        @Override // com.p065b.p086b.p108g.AbstractC1004u.a
        /* renamed from: a */
        public void mo8176a(C0995l c0995l) {
            if (!C0986c.m8221b(c0995l)) {
                this.f6333a.set(c0995l.m8391o().m7931g());
            }
        }

        @Override // com.p065b.p086b.p108g.AbstractC1004u.a
        /* renamed from: a */
        public void mo8177a(C0997n c0997n) {
            if (!C0986c.m8221b(c0997n)) {
                this.f6333a.set(c0997n.m8391o().m7931g());
            }
        }

        @Override // com.p065b.p086b.p108g.AbstractC1004u.a
        /* renamed from: b */
        public void mo8178b(C0995l c0995l) {
            C0934p o = c0995l.m8391o();
            if (!C0986c.m8221b(c0995l) && o != null) {
                this.f6333a.set(o.m7931g());
            }
        }
    }
}
