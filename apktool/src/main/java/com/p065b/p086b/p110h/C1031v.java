package com.p065b.p086b.p110h;

/* compiled from: MutabilityControl.java */
/* renamed from: com.b.b.h.v */
/* loaded from: classes.dex */
public class C1031v {

    /* renamed from: a */
    private boolean f6510a;

    public C1031v() {
        this.f6510a = true;
    }

    public C1031v(boolean z) {
        this.f6510a = z;
    }

    /* renamed from: e_ */
    public void mo6683e_() {
        this.f6510a = false;
    }

    /* renamed from: k */
    public final boolean m8594k() {
        return !this.f6510a;
    }

    /* renamed from: d_ */
    public final boolean m8593d_() {
        return this.f6510a;
    }

    /* renamed from: l */
    public final void m8595l() {
        if (!this.f6510a) {
            throw new C1032w("immutable instance");
        }
    }

    /* renamed from: m */
    public final void m8596m() {
        if (this.f6510a) {
            throw new C1032w("mutable instance");
        }
    }
}
