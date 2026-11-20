package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1025p;

/* compiled from: Frame.java */
/* renamed from: com.b.b.a.b.j */
/* loaded from: classes.dex */
public final class C0714j {

    /* renamed from: a */
    private final AbstractC0717m f4540a;

    /* renamed from: b */
    private final C0713i f4541b;

    /* renamed from: c */
    private final C1025p f4542c;

    private C0714j(AbstractC0717m abstractC0717m, C0713i c0713i) {
        this(abstractC0717m, c0713i, C1025p.f6502a);
    }

    private C0714j(AbstractC0717m abstractC0717m, C0713i c0713i, C1025p c1025p) {
        if (abstractC0717m == null) {
            throw new NullPointerException("locals == null");
        }
        if (c0713i == null) {
            throw new NullPointerException("stack == null");
        }
        c1025p.m8596m();
        this.f4540a = abstractC0717m;
        this.f4541b = c0713i;
        this.f4542c = c1025p;
    }

    public C0714j(int i, int i2) {
        this(new C0721q(i), new C0713i(i2));
    }

    /* renamed from: a */
    public C0714j m6633a() {
        return new C0714j(this.f4540a.mo6667a(), this.f4541b.m6618a(), this.f4542c);
    }

    /* renamed from: b */
    public void m6642b() {
        this.f4540a.mo6683e_();
        this.f4541b.mo6683e_();
    }

    /* renamed from: a */
    public void m6639a(C0975c c0975c) {
        this.f4540a.mo6673a(c0975c);
        this.f4541b.m6622a(c0975c);
    }

    /* renamed from: c */
    public AbstractC0717m m6643c() {
        return this.f4540a;
    }

    /* renamed from: d */
    public C0713i m6644d() {
        return this.f4541b;
    }

    /* renamed from: e */
    public C1025p m6645e() {
        return this.f4542c;
    }

    /* renamed from: a */
    public void m6638a(C0974b c0974b) {
        int f_ = c0974b.m8550f_();
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            C0975c m8115b = c0974b.m8115b(i);
            this.f4540a.mo6671a(i2, m8115b);
            i++;
            i2 = m8115b.m8127j() + i2;
        }
    }

    /* renamed from: a */
    public C0714j m6634a(int i, int i2) {
        AbstractC0717m m6679b = this.f4540a instanceof C0718n ? ((C0718n) this.f4540a).m6679b(i2) : null;
        try {
            C1025p m8578f = this.f4542c.m8578f();
            if (m8578f.m8575e() != i) {
                throw new RuntimeException("returning from invalid subroutine");
            }
            m8578f.mo6683e_();
            if (m6679b == null) {
                return null;
            }
            return new C0714j(m6679b, this.f4541b, m8578f);
        } catch (IndexOutOfBoundsException e2) {
            throw new RuntimeException("returning from invalid subroutine");
        } catch (NullPointerException e3) {
            throw new NullPointerException("can't return from non-subroutine");
        }
    }

    /* renamed from: a */
    public C0714j m6635a(C0714j c0714j) {
        AbstractC0717m mo6668a = m6643c().mo6668a(c0714j.m6643c());
        C0713i m6619a = m6644d().m6619a(c0714j.m6644d());
        C1025p m6632a = m6632a(c0714j.f4542c);
        AbstractC0717m m6631a = m6631a(mo6668a, m6632a);
        return (m6631a == m6643c() && m6619a == m6644d() && this.f4542c == m6632a) ? this : new C0714j(m6631a, m6619a, m6632a);
    }

    /* renamed from: a */
    private C1025p m6632a(C1025p c1025p) {
        if (this.f4542c.equals(c1025p)) {
            return this.f4542c;
        }
        C1025p c1025p2 = new C1025p();
        int m8568b = this.f4542c.m8568b();
        int m8568b2 = c1025p.m8568b();
        for (int i = 0; i < m8568b && i < m8568b2 && this.f4542c.m8569b(i) == c1025p.m8569b(i); i++) {
            c1025p2.m8571c(i);
        }
        c1025p2.mo6683e_();
        return c1025p2;
    }

    /* renamed from: a */
    private static AbstractC0717m m6631a(AbstractC0717m abstractC0717m, C1025p c1025p) {
        if (abstractC0717m instanceof C0718n) {
            C0718n c0718n = (C0718n) abstractC0717m;
            if (c1025p.m8568b() == 0) {
                return c0718n.mo6675b();
            }
            return c0718n;
        }
        return abstractC0717m;
    }

    /* renamed from: a */
    public C0714j m6636a(C0714j c0714j, int i, int i2) {
        C1025p c1025p;
        C1025p c1025p2;
        C0718n mo6669a = m6643c().mo6669a(c0714j.m6643c(), i2);
        C0713i m6619a = m6644d().m6619a(c0714j.m6644d());
        C1025p m8578f = c0714j.f4542c.m8578f();
        m8578f.m8571c(i);
        m8578f.mo6683e_();
        if (mo6669a != m6643c() || m6619a != m6644d() || !this.f4542c.equals(m8578f)) {
            if (this.f4542c.equals(m8578f)) {
                c1025p2 = this.f4542c;
            } else {
                if (this.f4542c.m8568b() > m8578f.m8568b()) {
                    c1025p2 = this.f4542c;
                    c1025p = m8578f;
                } else {
                    c1025p = this.f4542c;
                    c1025p2 = m8578f;
                }
                int m8568b = c1025p2.m8568b();
                int m8568b2 = c1025p.m8568b();
                for (int i3 = m8568b2 - 1; i3 >= 0; i3--) {
                    if (c1025p.m8569b(i3) != c1025p2.m8569b((m8568b - m8568b2) + i3)) {
                        throw new RuntimeException("Incompatible merged subroutines");
                    }
                }
            }
            return new C0714j(mo6669a, m6619a, c1025p2);
        }
        return this;
    }

    /* renamed from: b */
    public C0714j m6641b(int i, int i2) {
        this.f4542c.m8578f().m8571c(i);
        return new C0714j(this.f4540a.mo6675b(), this.f4541b, C1025p.m8565a(i)).m6636a(this, i, i2);
    }

    /* renamed from: a */
    public C0714j m6637a(C0971y c0971y) {
        C0713i m6618a = m6644d().m6618a();
        m6618a.m6628c();
        m6618a.m6623a(c0971y);
        return new C0714j(m6643c(), m6618a, this.f4542c);
    }

    /* renamed from: a */
    public void m6640a(C1019j c1019j) {
        this.f4540a.mo6674a(c1019j);
        this.f4541b.m6624a(c1019j);
    }
}
