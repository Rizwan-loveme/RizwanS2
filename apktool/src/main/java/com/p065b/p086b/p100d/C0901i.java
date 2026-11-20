package com.p065b.p086b.p100d;

import com.p065b.p086b.p110h.C1029t;
import com.p065b.p086b.p110h.InterfaceC1016g;

/* compiled from: EncodedValueReader.java */
/* renamed from: com.b.b.d.i */
/* loaded from: classes.dex */
public class C0901i {

    /* renamed from: a */
    protected final InterfaceC1016g f5469a;

    public C0901i(InterfaceC1016g interfaceC1016g) {
        this.f5469a = interfaceC1016g;
    }

    public C0901i(C0900h c0900h) {
        this(c0900h.m7656a());
    }

    /* renamed from: a */
    public final void m7659a() {
        int m8591b = C1029t.m8591b(this.f5469a);
        mo7660a(m8591b);
        for (int i = 0; i < m8591b; i++) {
            m7666c();
        }
    }

    /* renamed from: b */
    public final void m7663b() {
        int m8591b = C1029t.m8591b(this.f5469a);
        int m8591b2 = C1029t.m8591b(this.f5469a);
        mo7661a(m8591b, m8591b2);
        for (int i = 0; i < m8591b2; i++) {
            mo7664b(C1029t.m8591b(this.f5469a));
            m7666c();
        }
    }

    /* renamed from: c */
    public final void m7666c() {
        int mo7634e = this.f5469a.mo7634e() & 255;
        int i = mo7634e & 31;
        int i2 = (mo7634e & 224) >> 5;
        int i3 = i2 + 1;
        switch (i) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 6:
            case 16:
            case 17:
                mo7662a(mo7634e, i, i2, i3);
                break;
            case 23:
                mo7665b(i, m7658a(this.f5469a, i3));
                break;
            case 24:
                mo7668c(i, m7658a(this.f5469a, i3));
                break;
            case 25:
            case 27:
                mo7670d(i, m7658a(this.f5469a, i3));
                break;
            case 26:
                mo7672e(i, m7658a(this.f5469a, i3));
                break;
            case 28:
                mo7667c(mo7634e);
                m7659a();
                break;
            case 29:
                mo7669d(mo7634e);
                m7663b();
                break;
            case 30:
                mo7673f(mo7634e);
                break;
            case 31:
                mo7671e(mo7634e);
                break;
        }
    }

    /* renamed from: a */
    protected void mo7660a(int i) {
    }

    /* renamed from: a */
    protected void mo7661a(int i, int i2) {
    }

    /* renamed from: b */
    protected void mo7664b(int i) {
    }

    /* renamed from: a */
    protected void mo7662a(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            this.f5469a.mo7634e();
        }
    }

    /* renamed from: b */
    protected void mo7665b(int i, int i2) {
    }

    /* renamed from: c */
    protected void mo7668c(int i, int i2) {
    }

    /* renamed from: d */
    protected void mo7670d(int i, int i2) {
    }

    /* renamed from: e */
    protected void mo7672e(int i, int i2) {
    }

    /* renamed from: c */
    protected void mo7667c(int i) {
    }

    /* renamed from: d */
    protected void mo7669d(int i) {
    }

    /* renamed from: e */
    protected void mo7671e(int i) {
    }

    /* renamed from: f */
    protected void mo7673f(int i) {
    }

    /* renamed from: a */
    private int m7658a(InterfaceC1016g interfaceC1016g, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            i4 += (interfaceC1016g.mo7634e() & 255) << i3;
            i2++;
            i3 += 8;
        }
        return i4;
    }
}
