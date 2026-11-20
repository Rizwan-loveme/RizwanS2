package com.p065b.p086b.p087a.p092e;

import com.p065b.p086b.p110h.C1021l;

/* compiled from: StdAttributeList.java */
/* renamed from: com.b.b.a.e.k */
/* loaded from: classes.dex */
public final class C0750k extends C1021l implements InterfaceC0741b {
    public C0750k(int i) {
        super(i);
    }

    /* renamed from: a */
    public InterfaceC0740a m6903a(int i) {
        return (InterfaceC0740a) m8548e(i);
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0741b
    /* renamed from: b */
    public int mo6892b() {
        int f_ = m8550f_();
        int i = 2;
        for (int i2 = 0; i2 < f_; i2++) {
            i += m6903a(i2).mo6495a();
        }
        return i;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0741b
    /* renamed from: a */
    public InterfaceC0740a mo6891a(String str) {
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            InterfaceC0740a m6903a = m6903a(i);
            if (m6903a.mo6511g().equals(str)) {
                return m6903a;
            }
        }
        return null;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0741b
    /* renamed from: a */
    public InterfaceC0740a mo6890a(InterfaceC0740a interfaceC0740a) {
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            if (m6903a(i) == interfaceC0740a) {
                String mo6511g = interfaceC0740a.mo6511g();
                for (int i2 = i + 1; i2 < f_; i2++) {
                    InterfaceC0740a m6903a = m6903a(i2);
                    if (m6903a.mo6511g().equals(mo6511g)) {
                        return m6903a;
                    }
                }
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m6904a(int i, InterfaceC0740a interfaceC0740a) {
        m8546a(i, (Object) interfaceC0740a);
    }
}
