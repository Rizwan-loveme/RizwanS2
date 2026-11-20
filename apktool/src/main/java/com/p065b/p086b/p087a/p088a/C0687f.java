package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1032w;

/* compiled from: AttExceptions.java */
/* renamed from: com.b.b.a.a.f */
/* loaded from: classes.dex */
public final class C0687f extends AbstractC0700s {

    /* renamed from: a */
    private final InterfaceC0977e f4473a;

    public C0687f(InterfaceC0977e interfaceC0977e) {
        super("Exceptions");
        try {
            if (interfaceC0977e.mo6855d_()) {
                throw new C1032w("exceptions.isMutable()");
            }
            this.f4473a = interfaceC0977e;
        } catch (NullPointerException e2) {
            throw new NullPointerException("exceptions == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return (this.f4473a.mo6856f_() * 2) + 8;
    }

    /* renamed from: b */
    public InterfaceC0977e m6505b() {
        return this.f4473a;
    }
}
