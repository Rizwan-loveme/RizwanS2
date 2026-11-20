package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstFloat.java */
/* renamed from: com.b.b.f.c.l */
/* loaded from: classes.dex */
public final class C0958l extends AbstractC0962p {

    /* renamed from: a */
    public static final C0958l f6146a = m8059a(Float.floatToIntBits(0.0f));

    /* renamed from: b */
    public static final C0958l f6147b = m8059a(Float.floatToIntBits(1.0f));

    /* renamed from: c */
    public static final C0958l f6148c = m8059a(Float.floatToIntBits(2.0f));

    /* renamed from: a */
    public static C0958l m8059a(int i) {
        return new C0958l(i);
    }

    private C0958l(int i) {
        super(i);
    }

    public String toString() {
        int j = mo8064j();
        return "float{0x" + C1022m.m8552a(j) + " / " + Float.intBitsToFloat(j) + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6250e;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "float";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Float.toString(Float.intBitsToFloat(mo8064j()));
    }
}
