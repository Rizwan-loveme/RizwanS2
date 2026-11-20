package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p107d.C0975c;

/* compiled from: CstNat.java */
/* renamed from: com.b.b.f.c.v */
/* loaded from: classes.dex */
public final class C0968v extends AbstractC0945a {

    /* renamed from: a */
    public static final C0968v f6165a = new C0968v(new C0970x("TYPE"), new C0970x("Ljava/lang/Class;"));

    /* renamed from: b */
    private final C0970x f6166b;

    /* renamed from: c */
    private final C0970x f6167c;

    public C0968v(C0970x c0970x, C0970x c0970x2) {
        if (c0970x == null) {
            throw new NullPointerException("name == null");
        }
        if (c0970x2 == null) {
            throw new NullPointerException("descriptor == null");
        }
        this.f6166b = c0970x;
        this.f6167c = c0970x2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0968v)) {
            return false;
        }
        C0968v c0968v = (C0968v) obj;
        return this.f6166b.equals(c0968v.f6166b) && this.f6167c.equals(c0968v.f6167c);
    }

    public int hashCode() {
        return (this.f6166b.hashCode() * 31) ^ this.f6167c.hashCode();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        C0968v c0968v = (C0968v) abstractC0945a;
        int a2 = this.f6166b.compareTo(c0968v.f6166b);
        return a2 != 0 ? a2 : this.f6167c.compareTo(c0968v.f6167c);
    }

    public String toString() {
        return "nat{" + mo6681d() + '}';
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "nat";
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public boolean mo8035g() {
        return false;
    }

    /* renamed from: a */
    public C0970x m8072a() {
        return this.f6166b;
    }

    /* renamed from: b */
    public C0970x m8073b() {
        return this.f6167c;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f6166b.mo6681d() + ':' + this.f6167c.mo6681d();
    }

    /* renamed from: c */
    public C0975c m8074c() {
        return C0975c.m8118a(this.f6167c.m8084j());
    }

    /* renamed from: e */
    public final boolean m8075e() {
        return this.f6166b.m8084j().equals("<init>");
    }

    /* renamed from: f */
    public final boolean m8076f() {
        return this.f6166b.m8084j().equals("<clinit>");
    }
}
