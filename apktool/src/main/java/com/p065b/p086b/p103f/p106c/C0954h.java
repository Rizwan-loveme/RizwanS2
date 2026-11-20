package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CstChar.java */
/* renamed from: com.b.b.f.c.h */
/* loaded from: classes.dex */
public final class C0954h extends AbstractC0962p {

    /* renamed from: a */
    public static final C0954h f6142a = m8054a((char) 0);

    /* renamed from: a */
    public static C0954h m8054a(char c2) {
        return new C0954h(c2);
    }

    /* renamed from: a */
    public static C0954h m8055a(int i) {
        char c2 = (char) i;
        if (c2 != i) {
            throw new IllegalArgumentException("bogus char value: " + i);
        }
        return m8054a(c2);
    }

    private C0954h(char c2) {
        super(c2);
    }

    public String toString() {
        int j = mo8064j();
        return "char{0x" + C1022m.m8557c(j) + " / " + j + '}';
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6248c;
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "char";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return Integer.toString(mo8064j());
    }
}
