package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p110h.C1032w;

/* compiled from: BaseParameterAnnotations.java */
/* renamed from: com.b.b.a.a.u */
/* loaded from: classes.dex */
public abstract class AbstractC0702u extends AbstractC0700s {

    /* renamed from: a */
    private final C0917d f4482a;

    /* renamed from: b */
    private final int f4483b;

    public AbstractC0702u(String str, C0917d c0917d, int i) {
        super(str);
        try {
            if (c0917d.m8593d_()) {
                throw new C1032w("parameterAnnotations.isMutable()");
            }
            this.f4482a = c0917d;
            this.f4483b = i;
        } catch (NullPointerException e2) {
            throw new NullPointerException("parameterAnnotations == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public final int mo6495a() {
        return this.f4483b + 6;
    }

    /* renamed from: b */
    public final C0917d m6513b() {
        return this.f4482a;
    }
}
