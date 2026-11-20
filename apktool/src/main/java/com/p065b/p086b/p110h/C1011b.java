package com.p065b.p086b.p110h;

import java.util.NoSuchElementException;

/* compiled from: BitIntSet.java */
/* renamed from: com.b.b.h.b */
/* loaded from: classes.dex */
public class C1011b implements InterfaceC1026q {

    /* renamed from: a */
    int[] f6472a;

    public C1011b(int i) {
        this.f6472a = C1012c.m8489a(i);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: a */
    public void mo8477a(int i) {
        m8475c(i);
        C1012c.m8485a(this.f6472a, i, true);
    }

    /* renamed from: c */
    private void m8475c(int i) {
        if (i >= C1012c.m8484a(this.f6472a)) {
            int[] m8489a = C1012c.m8489a(Math.max(i + 1, C1012c.m8484a(this.f6472a) * 2));
            System.arraycopy(this.f6472a, 0, m8489a, 0, this.f6472a.length);
            this.f6472a = m8489a;
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: b */
    public boolean mo8480b(int i) {
        return i < C1012c.m8484a(this.f6472a) && C1012c.m8487a(this.f6472a, i);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: a */
    public void mo8478a(InterfaceC1026q interfaceC1026q) {
        if (interfaceC1026q instanceof C1011b) {
            C1011b c1011b = (C1011b) interfaceC1026q;
            m8475c(C1012c.m8484a(c1011b.f6472a) + 1);
            C1012c.m8486a(this.f6472a, c1011b.f6472a);
        } else {
            if (interfaceC1026q instanceof C1030u) {
                C1030u c1030u = (C1030u) interfaceC1026q;
                int m8568b = c1030u.f6507a.m8568b();
                if (m8568b > 0) {
                    m8475c(c1030u.f6507a.m8569b(m8568b - 1));
                }
                for (int i = 0; i < c1030u.f6507a.m8568b(); i++) {
                    C1012c.m8485a(this.f6472a, c1030u.f6507a.m8569b(i), true);
                }
                return;
            }
            InterfaceC1024o mo8479b = interfaceC1026q.mo8479b();
            while (mo8479b.mo8481a()) {
                mo8477a(mo8479b.mo8482b());
            }
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: a */
    public int mo8476a() {
        return C1012c.m8492c(this.f6472a);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1026q
    /* renamed from: b */
    public InterfaceC1024o mo8479b() {
        return new InterfaceC1024o() { // from class: com.b.b.h.b.1

            /* renamed from: b */
            private int f6474b;

            {
                this.f6474b = C1012c.m8494d(C1011b.this.f6472a, 0);
            }

            @Override // com.p065b.p086b.p110h.InterfaceC1024o
            /* renamed from: a */
            public boolean mo8481a() {
                return this.f6474b >= 0;
            }

            @Override // com.p065b.p086b.p110h.InterfaceC1024o
            /* renamed from: b */
            public int mo8482b() {
                if (!mo8481a()) {
                    throw new NoSuchElementException();
                }
                int i = this.f6474b;
                this.f6474b = C1012c.m8494d(C1011b.this.f6472a, this.f6474b + 1);
                return i;
            }
        };
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z = true;
        int m8494d = C1012c.m8494d(this.f6472a, 0);
        while (m8494d >= 0) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(m8494d);
            m8494d = C1012c.m8494d(this.f6472a, m8494d + 1);
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }
}
