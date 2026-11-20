package org.p210a.p211a.p212a;

/* compiled from: CommonTokenStream.java */
/* renamed from: org.a.a.a.l */
/* loaded from: classes.dex */
public class C1864l extends C1857e {

    /* renamed from: f */
    protected int f10961f;

    public C1864l(InterfaceC1821ae interfaceC1821ae) {
        super(interfaceC1821ae);
        this.f10961f = 0;
    }

    @Override // org.p210a.p211a.p212a.C1857e
    /* renamed from: i */
    protected int mo13805i(int i) {
        return m13794a(i, this.f10961f);
    }

    @Override // org.p210a.p211a.p212a.C1857e
    /* renamed from: g */
    protected InterfaceC1819ac mo13802g(int i) {
        if (i == 0 || this.f10919c - i < 0) {
            return null;
        }
        int i2 = this.f10919c;
        for (int i3 = 1; i3 <= i && i2 > 0; i3++) {
            i2 = m13798b(i2 - 1, this.f10961f);
        }
        if (i2 >= 0) {
            return this.f10918b.get(i2);
        }
        return null;
    }

    @Override // org.p210a.p211a.p212a.C1857e, org.p210a.p211a.p212a.InterfaceC1822af
    /* renamed from: h */
    public InterfaceC1819ac mo13689h(int i) {
        m13801f();
        if (i == 0) {
            return null;
        }
        if (i < 0) {
            return mo13802g(-i);
        }
        int i2 = this.f10919c;
        for (int i3 = 1; i3 < i; i3++) {
            if (m13799d(i2 + 1)) {
                i2 = m13794a(i2 + 1, this.f10961f);
            }
        }
        return this.f10918b.get(i2);
    }
}
