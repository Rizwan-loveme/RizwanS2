package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstShort.java */
/* renamed from: com.b.b.f.c.w */
/* loaded from: classes.dex */
public final class C0969w extends AbstractC0962p {

    /* renamed from: a */
    public static final C0969w f6168a = m8078a((short) 0);

    /* renamed from: a */
    public static C0969w m8078a(short s) {
        return new C0969w(s);
    }

    /* renamed from: a */
    public static C0969w m8077a(int i) {
        short s = (short) i;
        if (s != i) {
            throw new IllegalArgumentException("bogus short value: " + i);
        }
        return m8078a(s);
    }

    private C0969w(short s) {
        super(s);
    }

    public String toString() {
        int j = mo8064j();
        return "short{0x" + C1022m.m8557c(j) + " / " + j + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6253h;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "short";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Integer.toString(mo8064j());
    }
}
