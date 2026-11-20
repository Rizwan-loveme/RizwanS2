package com.p065b.p086b.p110h;

import java.util.NoSuchElementException;

/* compiled from: ListIntSet.java */
/* renamed from: com.b.b.h.u */
/* loaded from: classes.dex */
public class C1030u implements InterfaceC1026q {

    /* renamed from: a */
    final C1025p f6507a = new C1025p();

    public C1030u() {
        this.f6507a.m8580g();
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: a */
    public void mo8477a(int i) {
        int m8579g = this.f6507a.m8579g(i);
        if (m8579g < 0) {
            this.f6507a.m8572c(-(m8579g + 1), i);
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: b */
    public boolean mo8480b(int i) {
        return this.f6507a.m8577f(i) >= 0;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: a */
    public void mo8478a(InterfaceC1026q interfaceC1026q) {
        int i;
        if (interfaceC1026q instanceof C1030u) {
            C1030u c1030u = (C1030u) interfaceC1026q;
            int m8568b = this.f6507a.m8568b();
            int m8568b2 = c1030u.f6507a.m8568b();
            int i2 = 0;
            int i3 = 0;
            while (i2 < m8568b2 && i3 < m8568b) {
                i = i2;
                while (i < m8568b2 && c1030u.f6507a.m8569b(i) < this.f6507a.m8569b(i3)) {
                    mo8477a(c1030u.f6507a.m8569b(i));
                    i++;
                }
                if (i == m8568b2) {
                    break;
                }
                while (i3 < m8568b && c1030u.f6507a.m8569b(i) >= this.f6507a.m8569b(i3)) {
                    i3++;
                }
                i2 = i;
            }
            i = i2;
            while (i < m8568b2) {
                mo8477a(c1030u.f6507a.m8569b(i));
                i++;
            }
            this.f6507a.m8580g();
            return;
        }
        if (interfaceC1026q instanceof C1011b) {
            C1011b c1011b = (C1011b) interfaceC1026q;
            for (int i4 = 0; i4 >= 0; i4 = C1012c.m8494d(c1011b.f6472a, i4 + 1)) {
                this.f6507a.m8571c(i4);
            }
            this.f6507a.m8580g();
            return;
        }
        InterfaceC1024o mo8479b = interfaceC1026q.mo8479b();
        while (mo8479b.mo8481a()) {
            mo8477a(mo8479b.mo8482b());
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: a */
    public int mo8476a() {
        return this.f6507a.m8568b();
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: b */
    public InterfaceC1024o mo8479b() {
        return new InterfaceC1024o() { // from class: com.b.b.h.u.1

            /* renamed from: b */
            private int f6509b = 0;

            @Override // com.p065b.p086b.p110h.InterfaceC1024o
            /* renamed from: a */
            public boolean mo8481a() {
                return this.f6509b < C1030u.this.f6507a.m8568b();
            }

            @Override // com.p065b.p086b.p110h.InterfaceC1024o
            /* renamed from: b */
            public int mo8482b() {
                if (!mo8481a()) {
                    throw new NoSuchElementException();
                }
                C1025p c1025p = C1030u.this.f6507a;
                int i = this.f6509b;
                this.f6509b = i + 1;
                return c1025p.m8569b(i);
            }
        };
    }

    public String toString() {
        return this.f6507a.toString();
    }
}
