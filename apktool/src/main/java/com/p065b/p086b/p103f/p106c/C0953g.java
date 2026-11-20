package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstByte.java */
/* renamed from: com.b.b.f.c.g */
/* loaded from: classes.dex */
public final class C0953g extends AbstractC0962p {

    /* renamed from: a */
    public static final C0953g f6141a = m8052a((byte) 0);

    /* renamed from: a */
    public static C0953g m8052a(byte b2) {
        return new C0953g(b2);
    }

    /* renamed from: a */
    public static C0953g m8053a(int i) {
        byte b2 = (byte) i;
        if (b2 != i) {
            throw new IllegalArgumentException("bogus byte value: " + i);
        }
        return m8052a(b2);
    }

    private C0953g(byte b2) {
        super(b2);
    }

    public String toString() {
        int j = mo8064j();
        return "byte{0x" + C1022m.m8559e(j) + " / " + j + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6247b;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "byte";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Integer.toString(mo8064j());
    }
}
