package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p110h.C1032w;

/* compiled from: BaseAnnotations.java */
/* renamed from: com.b.b.a.a.r */
/* loaded from: classes.dex */
public abstract class AbstractC0699r extends AbstractC0700s {

    /* renamed from: a */
    private final C0916c f4478a;

    /* renamed from: b */
    private final int f4479b;

    public AbstractC0699r(String str, C0916c c0916c, int i) {
        super(str);
        try {
            if (c0916c.m8593d_()) {
                throw new C1032w("annotations.isMutable()");
            }
            this.f4478a = c0916c;
            this.f4479b = i;
        } catch (NullPointerException e2) {
            throw new NullPointerException("annotations == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public final int mo6495a() {
        return this.f4479b + 6;
    }

    /* renamed from: b */
    public final C0916c m6510b() {
        return this.f4478a;
    }
}
