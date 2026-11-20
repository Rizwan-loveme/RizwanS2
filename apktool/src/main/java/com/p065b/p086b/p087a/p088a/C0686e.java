package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0971y;

/* compiled from: AttEnclosingMethod.java */
/* renamed from: com.b.b.a.a.e */
/* loaded from: classes.dex */
public final class C0686e extends AbstractC0700s {

    /* renamed from: a */
    private final C0971y f4471a;

    /* renamed from: b */
    private final C0968v f4472b;

    public C0686e(C0971y c0971y, C0968v c0968v) {
        super("EnclosingMethod");
        if (c0971y == null) {
            throw new NullPointerException("type == null");
        }
        this.f4471a = c0971y;
        this.f4472b = c0968v;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return 10;
    }

    /* renamed from: b */
    public C0971y m6503b() {
        return this.f4471a;
    }

    /* renamed from: c */
    public C0968v m6504c() {
        return this.f4472b;
    }
}
