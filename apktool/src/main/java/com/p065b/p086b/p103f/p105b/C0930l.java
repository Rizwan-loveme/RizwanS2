package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p110h.C1031v;
import java.util.HashMap;

/* compiled from: LocalVariableInfo.java */
/* renamed from: com.b.b.f.b.l */
/* loaded from: classes.dex */
public final class C0930l extends C1031v {

    /* renamed from: a */
    private final int f5894a;

    /* renamed from: b */
    private final C0936r f5895b;

    /* renamed from: c */
    private final C0936r[] f5896c;

    /* renamed from: d */
    private final HashMap<AbstractC0926h, C0934p> f5897d;

    public C0930l(C0938t c0938t) {
        if (c0938t == null) {
            throw new NullPointerException("method == null");
        }
        C0921c m7977a = c0938t.m7977a();
        int j = m7977a.m8587j();
        this.f5894a = m7977a.m7859e();
        this.f5895b = new C0936r(this.f5894a);
        this.f5896c = new C0936r[j];
        this.f5897d = new HashMap<>(m7977a.m7860f());
        this.f5895b.mo6683e_();
    }

    /* renamed from: a */
    public void m7906a(int i, C0936r c0936r) {
        m8595l();
        if (c0936r == null) {
            throw new NullPointerException("specs == null");
        }
        try {
            this.f5896c[i] = c0936r;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("bogus label");
        }
    }

    /* renamed from: b */
    public boolean m7910b(int i, C0936r c0936r) {
        C0936r m7902c = m7902c(i);
        if (m7902c == null) {
            m7906a(i, c0936r);
            return true;
        }
        C0936r m7967e = m7902c.m7967e();
        if (m7902c.m7965d() != 0) {
            m7967e.m7960a(c0936r, true);
        } else {
            m7967e = c0936r.m7967e();
        }
        if (m7902c.equals(m7967e)) {
            return false;
        }
        m7967e.mo6683e_();
        m7906a(i, m7967e);
        return true;
    }

    /* renamed from: a */
    public C0936r m7904a(int i) {
        C0936r m7902c = m7902c(i);
        return m7902c != null ? m7902c : this.f5895b;
    }

    /* renamed from: a */
    public C0936r m7905a(C0920b c0920b) {
        return m7904a(c0920b.mo6568a());
    }

    /* renamed from: b */
    public C0936r m7909b(int i) {
        C0936r m7902c = m7902c(i);
        return m7902c != null ? m7902c.m7967e() : new C0936r(this.f5894a);
    }

    /* renamed from: a */
    public void m7907a(AbstractC0926h abstractC0926h, C0934p c0934p) {
        m8595l();
        if (abstractC0926h == null) {
            throw new NullPointerException("insn == null");
        }
        if (c0934p == null) {
            throw new NullPointerException("spec == null");
        }
        this.f5897d.put(abstractC0926h, c0934p);
    }

    /* renamed from: a */
    public C0934p m7903a(AbstractC0926h abstractC0926h) {
        return this.f5897d.get(abstractC0926h);
    }

    /* renamed from: b */
    public int m7908b() {
        return this.f5897d.size();
    }

    /* renamed from: c */
    private C0936r m7902c(int i) {
        try {
            return this.f5896c[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("bogus label");
        }
    }
}
