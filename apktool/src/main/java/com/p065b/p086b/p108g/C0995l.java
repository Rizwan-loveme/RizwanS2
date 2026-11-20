package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p108g.AbstractC1004u;

/* compiled from: NormalSsaInsn.java */
/* renamed from: com.b.b.g.l */
/* loaded from: classes.dex */
public final class C0995l extends AbstractC1004u implements Cloneable {

    /* renamed from: a */
    private AbstractC0926h f6392a;

    C0995l(AbstractC0926h abstractC0926h, C1002s c1002s) {
        super(abstractC0926h.m7884h(), c1002s);
        this.f6392a = abstractC0926h;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: a */
    public final void mo8283a(AbstractC0999p abstractC0999p) {
        C0935q m7886j = this.f6392a.m7886j();
        C0935q m8316a = abstractC0999p.m8316a(m7886j);
        if (m8316a != m7886j) {
            this.f6392a = this.f6392a.mo7873a(m8391o(), m8316a);
            m8392p().m8369o().m8410a(this, m7886j);
        }
    }

    /* renamed from: a */
    public final void m8281a(int i, C0934p c0934p) {
        C0935q m7886j = this.f6392a.m7886j();
        int f_ = m7886j.m8550f_();
        C0935q c0935q = new C0935q(f_);
        int i2 = 0;
        while (i2 < f_) {
            c0935q.m7948a(i2, i2 == i ? c0934p : m7886j.m7949b(i2));
            i2++;
        }
        c0935q.mo6683e_();
        C0934p m7949b = m7886j.m7949b(i);
        if (m7949b.m7931g() != c0934p.m7931g()) {
            m8392p().m8369o().m8409a(this, m7949b, c0934p);
        }
        this.f6392a = this.f6392a.mo7873a(m8391o(), c0935q);
    }

    /* renamed from: a */
    public final void m8282a(C0935q c0935q) {
        if (this.f6392a.m7886j().m8550f_() != c0935q.m8550f_()) {
            throw new RuntimeException("Sources counts don't match");
        }
        this.f6392a = this.f6392a.mo7873a(m8391o(), c0935q);
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C0995l mo8296n() {
        return (C0995l) super.mo8296n();
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: b */
    public C0935q mo8285b() {
        return this.f6392a.m7886j();
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return mo8286c().mo6681d();
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: c */
    public AbstractC0926h mo8286c() {
        return this.f6392a.mo7873a(m8391o(), this.f6392a.m7886j());
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: e */
    public C0937s mo8287e() {
        return this.f6392a.m7882f();
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: f */
    public AbstractC0926h mo8288f() {
        return this.f6392a;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: g */
    public C0934p mo8289g() {
        C0934p o;
        if (this.f6392a.m7882f().m7968a() == 54) {
            o = this.f6392a.m7886j().m7949b(0);
        } else {
            o = m8391o();
        }
        if (o == null || o.m7933i() == null) {
            return null;
        }
        return o;
    }

    /* renamed from: h */
    public void m8290h() {
        C0935q m7886j = this.f6392a.m7886j();
        this.f6392a = this.f6392a.mo7888l();
        m8392p().m8369o().m8410a(this, m7886j);
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: i */
    public boolean mo8291i() {
        return this.f6392a.m7882f().m7968a() == 2;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: j */
    public boolean mo8292j() {
        return this.f6392a.m7882f().m7968a() == 4;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: k */
    public boolean mo8293k() {
        return this.f6392a.m7887k();
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: a */
    public void mo8284a(AbstractC1004u.a aVar) {
        if (mo8291i()) {
            aVar.mo8176a(this);
        } else {
            aVar.mo8178b(this);
        }
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: l */
    public boolean mo8294l() {
        return mo8291i();
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: m */
    public boolean mo8295m() {
        C0937s mo8287e = mo8287e();
        if (mo8287e.m7971d() != 1) {
            return true;
        }
        boolean z = C0996m.m8301a() && mo8289g() != null;
        switch (mo8287e.m7968a()) {
            case 2:
            case 5:
            case 55:
                return z;
            default:
                return true;
        }
    }
}
