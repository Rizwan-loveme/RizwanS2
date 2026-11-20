package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstDouble.java */
/* renamed from: com.b.b.f.c.i */
/* loaded from: classes.dex */
public final class C0955i extends AbstractC0963q {

    /* renamed from: a */
    public static final C0955i f6143a = new C0955i(Double.doubleToLongBits(0.0d));

    /* renamed from: b */
    public static final C0955i f6144b = new C0955i(Double.doubleToLongBits(1.0d));

    /* renamed from: a */
    public static C0955i m8056a(long j) {
        return new C0955i(j);
    }

    private C0955i(long j) {
        super(j);
    }

    public String toString() {
        long k = mo8065k();
        return "double{0x" + C1022m.m8553a(k) + " / " + Double.longBitsToDouble(k) + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6249d;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "double";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Double.toString(Double.longBitsToDouble(mo8065k()));
    }
}
