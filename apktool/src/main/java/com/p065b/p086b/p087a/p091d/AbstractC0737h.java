package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.C0750k;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p087a.p092e.InterfaceC0745f;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: MemberListParser.java */
/* renamed from: com.b.b.a.d.h */
/* loaded from: classes.dex */
abstract class AbstractC0737h {

    /* renamed from: a */
    private final C0735f f4656a;

    /* renamed from: b */
    private final C0971y f4657b;

    /* renamed from: c */
    private final int f4658c;

    /* renamed from: d */
    private final C0731b f4659d;

    /* renamed from: e */
    private int f4660e;

    /* renamed from: f */
    private InterfaceC0749j f4661f;

    /* renamed from: a */
    protected abstract InterfaceC0745f mo6857a(int i, int i2, C0968v c0968v, InterfaceC0741b interfaceC0741b);

    /* renamed from: a */
    protected abstract String mo6859a(int i);

    /* renamed from: b */
    protected abstract String mo6860b();

    /* renamed from: c */
    protected abstract int mo6861c();

    public AbstractC0737h(C0735f c0735f, C0971y c0971y, int i, C0731b c0731b) {
        if (c0735f == null) {
            throw new NullPointerException("cf == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (c0731b == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        this.f4656a = c0735f;
        this.f4657b = c0971y;
        this.f4658c = i;
        this.f4659d = c0731b;
        this.f4660e = -1;
    }

    /* renamed from: d */
    public int m6864d() {
        m6865e();
        return this.f4660e;
    }

    /* renamed from: a */
    public final void m6863a(InterfaceC0749j interfaceC0749j) {
        this.f4661f = interfaceC0749j;
    }

    /* renamed from: e */
    protected final void m6865e() {
        if (this.f4660e < 0) {
            m6862a();
        }
    }

    /* renamed from: f */
    protected final int m6866f() {
        return this.f4656a.m6838a().m8512f(this.f4658c);
    }

    /* renamed from: g */
    protected final C0971y m6867g() {
        return this.f4657b;
    }

    /* renamed from: a */
    private void m6862a() {
        int mo6861c = mo6861c();
        int m6866f = m6866f();
        int i = this.f4658c + 2;
        C1013d m6838a = this.f4656a.m6838a();
        InterfaceC0948b m6844f = this.f4656a.m6844f();
        if (this.f4661f != null) {
            this.f4661f.m6900a(m6838a, this.f4658c, 2, mo6860b() + "s_count: " + C1022m.m8557c(m6866f));
        }
        for (int i2 = 0; i2 < m6866f; i2++) {
            try {
                int m8512f = m6838a.m8512f(i);
                int m8512f2 = m6838a.m8512f(i + 2);
                int m8512f3 = m6838a.m8512f(i + 4);
                C0970x c0970x = (C0970x) m6844f.mo8038a(m8512f2);
                C0970x c0970x2 = (C0970x) m6844f.mo8038a(m8512f3);
                if (this.f4661f != null) {
                    this.f4661f.m6901a(m6838a, i, c0970x.m8084j(), c0970x2.m8084j());
                    this.f4661f.m6900a(m6838a, i, 0, "\n" + mo6860b() + "s[" + i2 + "]:\n");
                    this.f4661f.m6899a(1);
                    this.f4661f.m6900a(m6838a, i, 2, "access_flags: " + mo6859a(m8512f));
                    this.f4661f.m6900a(m6838a, i + 2, 2, "name: " + c0970x.mo6681d());
                    this.f4661f.m6900a(m6838a, i + 4, 2, "descriptor: " + c0970x2.mo6681d());
                }
                C0732c c0732c = new C0732c(this.f4656a, mo6861c, i + 6, this.f4659d);
                c0732c.m6813a(this.f4661f);
                i = c0732c.m6812a();
                C0750k m6814b = c0732c.m6814b();
                m6814b.mo6683e_();
                InterfaceC0745f mo6857a = mo6857a(i2, m8512f, new C0968v(c0970x, c0970x2), m6814b);
                if (this.f4661f != null) {
                    this.f4661f.m6899a(-1);
                    this.f4661f.m6900a(m6838a, i, 0, "end " + mo6860b() + "s[" + i2 + "]\n");
                    this.f4661f.m6902a(m6838a, i, c0970x.m8084j(), c0970x2.m8084j(), mo6857a);
                }
            } catch (C0748i e2) {
                e2.m8540a("...while parsing " + mo6860b() + "s[" + i2 + "]");
                throw e2;
            } catch (RuntimeException e3) {
                C0748i c0748i = new C0748i(e3);
                c0748i.m8540a("...while parsing " + mo6860b() + "s[" + i2 + "]");
                throw c0748i;
            }
        }
        this.f4660e = i;
    }
}
