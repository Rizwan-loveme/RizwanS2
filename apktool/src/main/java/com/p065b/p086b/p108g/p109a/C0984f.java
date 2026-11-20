package com.p065b.p086b.p108g.p109a;

import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0927i;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p108g.AbstractC0999p;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p108g.C0978a;
import com.p065b.p086b.p108g.C0997n;
import com.p065b.p086b.p108g.C1002s;
import com.p065b.p086b.p108g.C1005v;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

/* compiled from: SsaToRop.java */
/* renamed from: com.b.b.g.a.f */
/* loaded from: classes.dex */
public class C0984f {

    /* renamed from: a */
    private final C1005v f6315a;

    /* renamed from: b */
    private final boolean f6316b;

    /* renamed from: c */
    private final C0981c f6317c;

    /* renamed from: a */
    public static C0938t m8200a(C1005v c1005v, boolean z) {
        return new C0984f(c1005v, z).m8199a();
    }

    private C0984f(C1005v c1005v, boolean z) {
        this.f6316b = z;
        this.f6315a = c1005v;
        this.f6317c = C0982d.m8189a(c1005v);
    }

    /* renamed from: a */
    private C0938t m8199a() {
        C0979a c0979a = new C0979a(this.f6315a, this.f6317c, this.f6316b);
        AbstractC0999p mo8174b = c0979a.mo8174b();
        this.f6315a.m8433p();
        this.f6315a.m8404a(mo8174b);
        m8204c();
        if (c0979a.mo8173a()) {
            m8205d();
        }
        m8203b();
        return new C0980b(new C0938t(m8206e(), this.f6315a.m8402a(this.f6315a.m8417c()))).m8185a();
    }

    /* renamed from: b */
    private void m8203b() {
        final ArrayList<C1002s> m8427j = this.f6315a.m8427j();
        this.f6315a.m8412a(false, new C1002s.b() { // from class: com.b.b.g.a.f.1
            @Override // com.p065b.p086b.p108g.C1002s.b
            /* renamed from: a */
            public void mo8207a(C1002s c1002s, C1002s c1002s2) {
                ArrayList<AbstractC1004u> m8353c = c1002s.m8353c();
                if (m8353c.size() == 1 && m8353c.get(0).mo8287e() == C0939u.f6120s) {
                    BitSet bitSet = (BitSet) c1002s.m8362h().clone();
                    for (int nextSetBit = bitSet.nextSetBit(0); nextSetBit >= 0; nextSetBit = bitSet.nextSetBit(nextSetBit + 1)) {
                        ((C1002s) m8427j.get(nextSetBit)).m8341a(c1002s.m8358e(), c1002s.m8365k());
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private void m8204c() {
        ArrayList<C1002s> m8427j = this.f6315a.m8427j();
        Iterator<C1002s> it = m8427j.iterator();
        while (it.hasNext()) {
            C1002s next = it.next();
            next.m8345a(new a(m8427j));
            next.m8349b();
        }
        Iterator<C1002s> it2 = m8427j.iterator();
        while (it2.hasNext()) {
            it2.next().m8374t();
        }
    }

    /* compiled from: SsaToRop.java */
    /* renamed from: com.b.b.g.a.f$a */
    private static class a implements C0997n.b {

        /* renamed from: a */
        private final ArrayList<C1002s> f6320a;

        public a(ArrayList<C1002s> arrayList) {
            this.f6320a = arrayList;
        }

        @Override // com.p065b.p086b.p108g.C0997n.b
        /* renamed from: a */
        public void mo8208a(C0997n c0997n) {
            C0935q mo8285b = c0997n.mo8285b();
            C0934p o = c0997n.m8391o();
            int f_ = mo8285b.m8550f_();
            for (int i = 0; i < f_; i++) {
                this.f6320a.get(c0997n.m8303a(i)).m8344a(o, mo8285b.m7949b(i));
            }
        }
    }

    /* renamed from: d */
    private void m8205d() {
        int m8425h = this.f6315a.m8425h();
        C0978a c0978a = new C0978a(this.f6315a.m8424g());
        int m8424g = this.f6315a.m8424g();
        for (int i = 0; i < m8424g; i++) {
            if (i < m8425h) {
                c0978a.mo8142a(i, (m8424g - m8425h) + i, 1);
            } else {
                c0978a.mo8142a(i, i - m8425h, 1);
            }
        }
        this.f6315a.m8404a(c0978a);
    }

    /* renamed from: e */
    private C0921c m8206e() {
        int i = 0;
        ArrayList<C1002s> m8427j = this.f6315a.m8427j();
        C1002s m8423f = this.f6315a.m8423f();
        this.f6315a.m8429l();
        C0921c c0921c = new C0921c(this.f6315a.m8428k() - ((m8423f == null || !m8423f.m8373s()) ? 0 : 1));
        Iterator<C1002s> it = m8427j.iterator();
        while (it.hasNext()) {
            C1002s next = it.next();
            if (next.m8373s() && next != m8423f) {
                c0921c.m7856a(i, m8202b(next));
                i++;
            }
        }
        if (m8423f != null && m8423f.m8353c().size() != 0) {
            throw new RuntimeException("Exit block must have no insns when leaving SSA form");
        }
        return c0921c;
    }

    /* renamed from: a */
    private void m8201a(C1002s c1002s) {
        C0937s mo8287e = c1002s.m8353c().get(r0.size() - 1).mo8287e();
        if (mo8287e.m7971d() != 2 && mo8287e != C0939u.f6004bD) {
            throw new RuntimeException("Exit predecessor must end in valid exit statement.");
        }
    }

    /* renamed from: b */
    private C0920b m8202b(C1002s c1002s) {
        C1025p c1025p;
        int i = -1;
        C1025p m8368n = c1002s.m8368n();
        int m8366l = c1002s.m8366l();
        C1002s m8423f = this.f6315a.m8423f();
        if (!m8368n.m8581h(m8423f == null ? -1 : m8423f.m8360f())) {
            i = m8366l;
            c1025p = m8368n;
        } else {
            if (m8368n.m8568b() > 1) {
                throw new RuntimeException("Exit predecessor must have no other successors" + C1022m.m8557c(c1002s.m8360f()));
            }
            c1025p = C1025p.f6502a;
            m8201a(c1002s);
        }
        c1025p.mo6683e_();
        return new C0920b(c1002s.m8360f(), m8198a(c1002s.m8353c()), c1025p, i);
    }

    /* renamed from: a */
    private C0927i m8198a(ArrayList<AbstractC1004u> arrayList) {
        int size = arrayList.size();
        C0927i c0927i = new C0927i(size);
        for (int i = 0; i < size; i++) {
            c0927i.m7890a(i, arrayList.get(i).mo8286c());
        }
        c0927i.mo6683e_();
        return c0927i;
    }
}
