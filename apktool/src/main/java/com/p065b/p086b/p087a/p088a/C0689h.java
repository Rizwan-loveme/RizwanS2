package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p087a.p089b.C0715k;
import com.p065b.p086b.p110h.C1032w;

/* compiled from: AttLineNumberTable.java */
/* renamed from: com.b.b.a.a.h */
/* loaded from: classes.dex */
public final class C0689h extends AbstractC0700s {

    /* renamed from: a */
    private final C0715k f4475a;

    public C0689h(C0715k c0715k) {
        super("LineNumberTable");
        try {
            if (c0715k.m8593d_()) {
                throw new C1032w("lineNumbers.isMutable()");
            }
            this.f4475a = c0715k;
        } catch (NullPointerException e2) {
            throw new NullPointerException("lineNumbers == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return (this.f4475a.m8550f_() * 4) + 8;
    }

    /* renamed from: b */
    public C0715k m6507b() {
        return this.f4475a;
    }
}
