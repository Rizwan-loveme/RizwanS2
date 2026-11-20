package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p103f.p104a.C0914a;

/* compiled from: CstAnnotation.java */
/* renamed from: com.b.b.f.c.c */
/* loaded from: classes.dex */
public final class C0949c extends AbstractC0945a {

    /* renamed from: a */
    private final C0914a f6135a;

    public C0949c(C0914a c0914a) {
        if (c0914a == null) {
            throw new NullPointerException("annotation == null");
        }
        c0914a.m8596m();
        this.f6135a = c0914a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0949c) {
            return this.f6135a.equals(((C0949c) obj).f6135a);
        }
        return false;
    }

    public int hashCode() {
        return this.f6135a.hashCode();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: b */
    protected int mo8034b(AbstractC0945a abstractC0945a) {
        return this.f6135a.compareTo(((C0949c) abstractC0945a).f6135a);
    }

    public String toString() {
        return this.f6135a.toString();
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: h */
    public String mo8036h() {
        return "annotation";
    }

    @Override // com.p065b.p086b.p103f.p106c.AbstractC0945a
    /* renamed from: g */
    public boolean mo8035g() {
        return false;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f6135a.toString();
    }

    /* renamed from: a */
    public C0914a m8040a() {
        return this.f6135a;
    }
}
