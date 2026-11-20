package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p110h.C1032w;

/* compiled from: AttInnerClasses.java */
/* renamed from: com.b.b.a.a.g */
/* loaded from: classes.dex */
public final class C0688g extends AbstractC0700s {

    /* renamed from: a */
    private final C0703v f4474a;

    public C0688g(C0703v c0703v) {
        super("InnerClasses");
        try {
            if (c0703v.m8593d_()) {
                throw new C1032w("innerClasses.isMutable()");
            }
            this.f4474a = c0703v;
        } catch (NullPointerException e2) {
            throw new NullPointerException("innerClasses == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return (this.f4474a.m8550f_() * 8) + 8;
    }

    /* renamed from: b */
    public C0703v m6506b() {
        return this.f4474a;
    }
}
