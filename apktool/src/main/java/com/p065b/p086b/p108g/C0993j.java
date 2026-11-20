package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0936r;
import com.p065b.p086b.p110h.C1031v;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: LocalVariableInfo.java */
/* renamed from: com.b.b.g.j */
/* loaded from: classes.dex */
public class C0993j extends C1031v {

    /* renamed from: a */
    private final int f6381a;

    /* renamed from: b */
    private final C0936r f6382b;

    /* renamed from: c */
    private final C0936r[] f6383c;

    /* renamed from: d */
    private final HashMap<AbstractC1004u, C0934p> f6384d;

    public C0993j(C1005v c1005v) {
        if (c1005v == null) {
            throw new NullPointerException("method == null");
        }
        ArrayList<C1002s> m8427j = c1005v.m8427j();
        this.f6381a = c1005v.m8424g();
        this.f6382b = new C0936r(this.f6381a);
        this.f6383c = new C0936r[m8427j.size()];
        this.f6384d = new HashMap<>();
        this.f6382b.mo6683e_();
    }

    /* renamed from: a */
    public void m8271a(int i, C0936r c0936r) {
        m8595l();
        if (c0936r == null) {
            throw new NullPointerException("specs == null");
        }
        try {
            this.f6383c[i] = c0936r;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("bogus index");
        }
    }

    /* renamed from: b */
    public boolean m8274b(int i, C0936r c0936r) {
        C0936r m8269c = m8269c(i);
        if (m8269c == null) {
            m8271a(i, c0936r);
            return true;
        }
        C0936r m7967e = m8269c.m7967e();
        m7967e.m7960a(c0936r, true);
        if (m8269c.equals(m7967e)) {
            return false;
        }
        m7967e.mo6683e_();
        m8271a(i, m7967e);
        return true;
    }

    /* renamed from: a */
    public C0936r m8270a(int i) {
        C0936r m8269c = m8269c(i);
        return m8269c != null ? m8269c : this.f6382b;
    }

    /* renamed from: b */
    public C0936r m8273b(int i) {
        C0936r m8269c = m8269c(i);
        return m8269c != null ? m8269c.m7967e() : new C0936r(this.f6381a);
    }

    /* renamed from: a */
    public void m8272a(AbstractC1004u abstractC1004u, C0934p c0934p) {
        m8595l();
        if (abstractC1004u == null) {
            throw new NullPointerException("insn == null");
        }
        if (c0934p == null) {
            throw new NullPointerException("spec == null");
        }
        this.f6384d.put(abstractC1004u, c0934p);
    }

    /* renamed from: c */
    private C0936r m8269c(int i) {
        try {
            return this.f6383c[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("bogus index");
        }
    }
}
