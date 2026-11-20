package com.p065b.p086b.p087a.p088a;

import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p110h.C1013d;

/* compiled from: RawAttribute.java */
/* renamed from: com.b.b.a.a.w */
/* loaded from: classes.dex */
public final class C0704w extends AbstractC0700s {

    /* renamed from: a */
    private final C1013d f4488a;

    /* renamed from: b */
    private final InterfaceC0948b f4489b;

    public C0704w(String str, C1013d c1013d, InterfaceC0948b interfaceC0948b) {
        super(str);
        if (c1013d == null) {
            throw new NullPointerException("data == null");
        }
        this.f4488a = c1013d;
        this.f4489b = interfaceC0948b;
    }

    public C0704w(String str, C1013d c1013d, int i, int i2, InterfaceC0948b interfaceC0948b) {
        this(str, c1013d.m8504a(i, i + i2), interfaceC0948b);
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0740a
    /* renamed from: a */
    public int mo6495a() {
        return this.f4488a.m8502a() + 6;
    }
}
