package com.p065b.p086b.p103f.p104a;

import com.p065b.p086b.p110h.C1021l;

/* compiled from: AnnotationsList.java */
/* renamed from: com.b.b.f.a.d */
/* loaded from: classes.dex */
public final class C0917d extends C1021l {

    /* renamed from: a */
    public static final C0917d f5853a = new C0917d(0);

    /* renamed from: a */
    public static C0917d m7829a(C0917d c0917d, C0917d c0917d2) {
        int f_ = c0917d.m8550f_();
        if (f_ != c0917d2.m8550f_()) {
            throw new IllegalArgumentException("list1.size() != list2.size()");
        }
        C0917d c0917d3 = new C0917d(f_);
        for (int i = 0; i < f_; i++) {
            c0917d3.m7831a(i, C0916c.m7823a(c0917d.m7830a(i), c0917d2.m7830a(i)));
        }
        c0917d3.mo6683e_();
        return c0917d3;
    }

    public C0917d(int i) {
        super(i);
    }

    /* renamed from: a */
    public C0916c m7830a(int i) {
        return (C0916c) m8548e(i);
    }

    /* renamed from: a */
    public void m7831a(int i, C0916c c0916c) {
        c0916c.m8596m();
        m8546a(i, (Object) c0916c);
    }
}
