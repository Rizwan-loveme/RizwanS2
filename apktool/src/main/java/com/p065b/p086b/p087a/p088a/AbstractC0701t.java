package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p087a.p089b.C0716l;
import com.p065b.p086b.p110h.C1032w;

/* compiled from: BaseLocalVariables.java */
/* renamed from: com.b.b.a.a.t */
/* loaded from: classes.dex */
public abstract class AbstractC0701t extends AbstractC0700s {

    /* renamed from: a */
    private final C0716l f4481a;

    public AbstractC0701t(String str, C0716l c0716l) {
        super(str);
        try {
            if (c0716l.m8593d_()) {
                throw new C1032w("localVariables.isMutable()");
            }
            this.f4481a = c0716l;
        } catch (NullPointerException e2) {
            throw new NullPointerException("localVariables == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public final int mo6495a() {
        return (this.f4481a.m8550f_() * 10) + 8;
    }

    /* renamed from: b */
    public final C0716l m6512b() {
        return this.f4481a;
    }
}
