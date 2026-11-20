package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;

/* compiled from: CstBoolean.java */
/* renamed from: com.b.b.f.c.f */
/* loaded from: classes.dex */
public final class C0952f extends AbstractC0962p {

    /* renamed from: a */
    public static final C0952f f6139a = new C0952f(false);

    /* renamed from: b */
    public static final C0952f f6140b = new C0952f(true);

    /* renamed from: a */
    public static C0952f m8050a(int i) {
        if (i == 0) {
            return f6139a;
        }
        if (i == 1) {
            return f6140b;
        }
        throw new IllegalArgumentException("bogus value: " + i);
    }

    private C0952f(boolean z) {
        super(z ? 1 : 0);
    }

    public String toString() {
        return m8051j_() ? "boolean{true}" : "boolean{false}";
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6246a;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "boolean";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return m8051j_() ? "true" : "false";
    }

    /* renamed from: j_ */
    public boolean m8051j_() {
        return mo8064j() != 0;
    }
}
