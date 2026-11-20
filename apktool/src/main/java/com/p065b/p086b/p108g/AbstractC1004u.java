package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: SsaInsn.java */
/* renamed from: com.b.b.g.u */
/* loaded from: classes.dex */
public abstract class AbstractC1004u implements InterfaceC1035z, Cloneable {

    /* renamed from: a */
    private final C1002s f6434a;

    /* renamed from: b */
    private C0934p f6435b;

    /* compiled from: SsaInsn.java */
    /* renamed from: com.b.b.g.u$a */
    public interface a {
        /* renamed from: a */
        void mo8176a(C0995l c0995l);

        /* renamed from: a */
        void mo8177a(C0997n c0997n);

        /* renamed from: b */
        void mo8178b(C0995l c0995l);
    }

    /* renamed from: a */
    public abstract void mo8283a(AbstractC0999p abstractC0999p);

    /* renamed from: a */
    public abstract void mo8284a(a aVar);

    /* renamed from: b */
    public abstract C0935q mo8285b();

    /* renamed from: c */
    public abstract AbstractC0926h mo8286c();

    /* renamed from: e */
    public abstract C0937s mo8287e();

    /* renamed from: f */
    public abstract AbstractC0926h mo8288f();

    /* renamed from: k */
    public abstract boolean mo8293k();

    /* renamed from: l */
    public abstract boolean mo8294l();

    /* renamed from: m */
    public abstract boolean mo8295m();

    protected AbstractC1004u(C0934p c0934p, C1002s c1002s) {
        if (c1002s == null) {
            throw new NullPointerException("block == null");
        }
        this.f6434a = c1002s;
        this.f6435b = c0934p;
    }

    /* renamed from: a */
    public static AbstractC1004u m8385a(AbstractC0926h abstractC0926h, C1002s c1002s) {
        return new C0995l(abstractC0926h, c1002s);
    }

    @Override // 
    /* renamed from: n */
    public AbstractC1004u mo8296n() {
        try {
            return (AbstractC1004u) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("unexpected", e2);
        }
    }

    /* renamed from: o */
    public C0934p m8391o() {
        return this.f6435b;
    }

    /* renamed from: b */
    protected void m8387b(C0934p c0934p) {
        if (c0934p == null) {
            throw new NullPointerException("result == null");
        }
        this.f6435b = c0934p;
    }

    /* renamed from: p */
    public C1002s m8392p() {
        return this.f6434a;
    }

    /* renamed from: b */
    public boolean m8389b(int i) {
        return this.f6435b != null && this.f6435b.m7931g() == i;
    }

    /* renamed from: c */
    public void m8390c(int i) {
        if (this.f6435b != null) {
            this.f6435b = this.f6435b.m7927b(i);
        }
    }

    /* renamed from: a */
    public final void m8386a(C0928j c0928j) {
        if (c0928j != this.f6435b.m7933i()) {
            if (c0928j == null || !c0928j.equals(this.f6435b.m7933i())) {
                this.f6435b = C0934p.m7918b(this.f6435b.m7931g(), this.f6435b.mo6695a(), c0928j);
            }
        }
    }

    /* renamed from: b */
    public final void m8388b(AbstractC0999p abstractC0999p) {
        C0934p c0934p = this.f6435b;
        this.f6435b = abstractC0999p.mo8141a(this.f6435b);
        this.f6434a.m8369o().m8408a(this, c0934p);
        mo8283a(abstractC0999p);
    }

    /* renamed from: g */
    public C0934p mo8289g() {
        if (this.f6435b == null || this.f6435b.m7933i() == null) {
            return null;
        }
        return this.f6435b;
    }

    /* renamed from: i */
    public boolean mo8291i() {
        return false;
    }

    /* renamed from: j */
    public boolean mo8292j() {
        return false;
    }
}
