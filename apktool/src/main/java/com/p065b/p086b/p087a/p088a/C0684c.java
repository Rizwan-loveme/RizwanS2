package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.C0955i;
import com.p065b.p086b.p103f.p106c.C0958l;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0965s;
import com.p065b.p086b.p103f.p106c.C0970x;

/* compiled from: AttConstantValue.java */
/* renamed from: com.b.b.a.a.c */
/* loaded from: classes.dex */
public final class C0684c extends AbstractC0700s {

    /* renamed from: a */
    private final AbstractC0946aa f4470a;

    public C0684c(AbstractC0946aa abstractC0946aa) {
        super("ConstantValue");
        if (!(abstractC0946aa instanceof C0970x) && !(abstractC0946aa instanceof C0959m) && !(abstractC0946aa instanceof C0965s) && !(abstractC0946aa instanceof C0958l) && !(abstractC0946aa instanceof C0955i)) {
            if (abstractC0946aa == null) {
                throw new NullPointerException("constantValue == null");
            }
            throw new IllegalArgumentException("bad type for constantValue");
        }
        this.f4470a = abstractC0946aa;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return 8;
    }

    /* renamed from: b */
    public AbstractC0946aa m6502b() {
        return this.f4470a;
    }
}
