package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.C0750k;
import com.p065b.p086b.p087a.p092e.InterfaceC0740a;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: AttributeListParser.java */
/* renamed from: com.b.b.a.d.c */
/* loaded from: classes.dex */
final class C0732c {

    /* renamed from: a */
    private final C0735f f4625a;

    /* renamed from: b */
    private final int f4626b;

    /* renamed from: c */
    private final int f4627c;

    /* renamed from: d */
    private final C0731b f4628d;

    /* renamed from: e */
    private final C0750k f4629e;

    /* renamed from: f */
    private int f4630f;

    /* renamed from: g */
    private InterfaceC0749j f4631g;

    public C0732c(C0735f c0735f, int i, int i2, C0731b c0731b) {
        if (c0735f == null) {
            throw new NullPointerException("cf == null");
        }
        if (c0731b == null) {
            throw new NullPointerException("attributeFactory == null");
        }
        int m8512f = c0735f.m6838a().m8512f(i2);
        this.f4625a = c0735f;
        this.f4626b = i;
        this.f4627c = i2;
        this.f4628d = c0731b;
        this.f4629e = new C0750k(m8512f);
        this.f4630f = -1;
    }

    /* renamed from: a */
    public void m6813a(InterfaceC0749j interfaceC0749j) {
        this.f4631g = interfaceC0749j;
    }

    /* renamed from: a */
    public int m6812a() {
        m6810c();
        return this.f4630f;
    }

    /* renamed from: b */
    public C0750k m6814b() {
        m6810c();
        return this.f4629e;
    }

    /* renamed from: c */
    private void m6810c() {
        if (this.f4630f < 0) {
            m6811d();
        }
    }

    /* renamed from: d */
    private void m6811d() {
        int f_ = this.f4629e.m8550f_();
        int i = this.f4627c + 2;
        C1013d m6838a = this.f4625a.m6838a();
        if (this.f4631g != null) {
            this.f4631g.m6900a(m6838a, this.f4627c, 2, "attributes_count: " + C1022m.m8557c(f_));
        }
        for (int i2 = 0; i2 < f_; i2++) {
            try {
                if (this.f4631g != null) {
                    this.f4631g.m6900a(m6838a, i, 0, "\nattributes[" + i2 + "]:\n");
                    this.f4631g.m6899a(1);
                }
                InterfaceC0740a m6808a = this.f4628d.m6808a(this.f4625a, this.f4626b, i, this.f4631g);
                i += m6808a.mo6495a();
                this.f4629e.m6904a(i2, m6808a);
                if (this.f4631g != null) {
                    this.f4631g.m6899a(-1);
                    this.f4631g.m6900a(m6838a, i, 0, "end attributes[" + i2 + "]\n");
                }
            } catch (C0748i e2) {
                e2.m8540a("...while parsing attributes[" + i2 + "]");
                throw e2;
            } catch (RuntimeException e3) {
                C0748i c0748i = new C0748i(e3);
                c0748i.m8540a("...while parsing attributes[" + i2 + "]");
                throw c0748i;
            }
        }
        this.f4630f = i;
    }
}
