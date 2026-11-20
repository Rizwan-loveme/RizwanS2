package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1031v;

/* compiled from: StdConstantPool.java */
/* renamed from: com.b.b.f.c.z */
/* loaded from: classes.dex */
public final class C0972z extends C1031v implements InterfaceC0948b {

    /* renamed from: a */
    private final AbstractC0945a[] f6193a;

    public C0972z(int i) {
        super(i > 1);
        if (i < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        this.f6193a = new AbstractC0945a[i];
    }

    /* renamed from: c */
    public AbstractC0945a m8094c(int i) {
        try {
            return this.f6193a[i];
        } catch (IndexOutOfBoundsException e2) {
            return m8092d(i);
        }
    }

    @Override // com.p065b.p086b.p103f.p106c.InterfaceC0948b
    /* renamed from: b */
    public AbstractC0945a mo8039b(int i) {
        if (i == 0) {
            return null;
        }
        return mo8038a(i);
    }

    @Override // com.p065b.p086b.p103f.p106c.InterfaceC0948b
    /* renamed from: a */
    public AbstractC0945a mo8038a(int i) {
        try {
            AbstractC0945a abstractC0945a = this.f6193a[i];
            if (abstractC0945a == null) {
                m8092d(i);
                return abstractC0945a;
            }
            return abstractC0945a;
        } catch (IndexOutOfBoundsException e2) {
            return m8092d(i);
        }
    }

    /* renamed from: a */
    public void m8093a(int i, AbstractC0945a abstractC0945a) {
        AbstractC0945a abstractC0945a2;
        m8595l();
        boolean z = abstractC0945a != null && abstractC0945a.mo8035g();
        if (i < 1) {
            throw new IllegalArgumentException("n < 1");
        }
        if (z) {
            if (i == this.f6193a.length - 1) {
                throw new IllegalArgumentException("(n == size - 1) && cst.isCategory2()");
            }
            this.f6193a[i + 1] = null;
        }
        if (abstractC0945a != null && this.f6193a[i] == null && (abstractC0945a2 = this.f6193a[i - 1]) != null && abstractC0945a2.mo8035g()) {
            this.f6193a[i - 1] = null;
        }
        this.f6193a[i] = abstractC0945a;
    }

    /* renamed from: d */
    private static AbstractC0945a m8092d(int i) {
        throw new C1019j("invalid constant pool index " + C1022m.m8557c(i));
    }
}
