package com.p065b.p086b.p110h;

/* compiled from: LabeledList.java */
/* renamed from: com.b.b.h.s */
/* loaded from: classes.dex */
public class C1028s extends C1021l {

    /* renamed from: a */
    private final C1025p f6506a;

    public C1028s(int i) {
        super(i);
        this.f6506a = new C1025p(i);
    }

    public C1028s(C1028s c1028s) {
        super(c1028s.m8550f_());
        this.f6506a = c1028s.f6506a.m8578f();
        int f_ = c1028s.m8550f_();
        for (int i = 0; i < f_; i++) {
            Object e2 = c1028s.m8548e(i);
            if (e2 != null) {
                m8546a(i, e2);
            }
        }
    }

    /* renamed from: j */
    public final int m8587j() {
        int m8568b = this.f6506a.m8568b() - 1;
        while (m8568b >= 0 && this.f6506a.m8569b(m8568b) < 0) {
            m8568b--;
        }
        int i = m8568b + 1;
        this.f6506a.m8576e(i);
        return i;
    }

    /* renamed from: a */
    private void m8582a(int i) {
        this.f6506a.m8570b(i, -1);
    }

    /* renamed from: a */
    private void m8583a(int i, int i2) {
        int m8568b = this.f6506a.m8568b();
        for (int i3 = 0; i3 <= i - m8568b; i3++) {
            this.f6506a.m8571c(-1);
        }
        this.f6506a.m8570b(i, i2);
    }

    /* renamed from: c */
    public final int m8586c(int i) {
        if (i >= this.f6506a.m8568b()) {
            return -1;
        }
        return this.f6506a.m8569b(i);
    }

    @Override // com.p065b.p086b.p110h.C1021l
    /* renamed from: i */
    public void mo8551i() {
        super.mo8551i();
        m8584e();
    }

    /* renamed from: e */
    private void m8584e() {
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            InterfaceC1027r interfaceC1027r = (InterfaceC1027r) m8548e(i);
            if (interfaceC1027r != null) {
                this.f6506a.m8570b(interfaceC1027r.mo6568a(), i);
            }
        }
    }

    /* renamed from: a */
    protected void m8585a(int i, InterfaceC1027r interfaceC1027r) {
        InterfaceC1027r interfaceC1027r2 = (InterfaceC1027r) m8549f(i);
        m8546a(i, (Object) interfaceC1027r);
        if (interfaceC1027r2 != null) {
            m8582a(interfaceC1027r2.mo6568a());
        }
        if (interfaceC1027r != null) {
            m8583a(interfaceC1027r.mo6568a(), i);
        }
    }
}
