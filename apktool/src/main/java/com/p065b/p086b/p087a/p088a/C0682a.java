package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;

/* compiled from: AttAnnotationDefault.java */
/* renamed from: com.b.b.a.a.a */
/* loaded from: classes.dex */
public final class C0682a extends AbstractC0700s {

    /* renamed from: a */
    private final AbstractC0945a f4463a;

    /* renamed from: b */
    private final int f4464b;

    public C0682a(AbstractC0945a abstractC0945a, int i) {
        super("AnnotationDefault");
        if (abstractC0945a == null) {
            throw new NullPointerException("value == null");
        }
        this.f4463a = abstractC0945a;
        this.f4464b = i;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return this.f4464b + 6;
    }

    /* renamed from: b */
    public AbstractC0945a m6496b() {
        return this.f4463a;
    }
}
