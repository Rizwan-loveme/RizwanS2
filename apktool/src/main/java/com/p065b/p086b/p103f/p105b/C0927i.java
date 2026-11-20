package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p110h.C1021l;

/* compiled from: InsnList.java */
/* renamed from: com.b.b.f.b.i */
/* loaded from: classes.dex */
public final class C0927i extends C1021l {
    public C0927i(int i) {
        super(i);
    }

    /* renamed from: a */
    public AbstractC0926h m7889a(int i) {
        return (AbstractC0926h) m8548e(i);
    }

    /* renamed from: a */
    public void m7890a(int i, AbstractC0926h abstractC0926h) {
        m8546a(i, (Object) abstractC0926h);
    }

    /* renamed from: e */
    public AbstractC0926h m7893e() {
        return m7889a(m8550f_() - 1);
    }

    /* renamed from: a */
    public void m7891a(AbstractC0926h.b bVar) {
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            m7889a(i).mo7875a(bVar);
        }
    }

    /* renamed from: a */
    public boolean m7892a(C0927i c0927i) {
        int f_;
        if (c0927i == null || (f_ = m8550f_()) != c0927i.m8550f_()) {
            return false;
        }
        for (int i = 0; i < f_; i++) {
            if (!m7889a(i).mo7867a(c0927i.m7889a(i))) {
                return false;
            }
        }
        return true;
    }
}
