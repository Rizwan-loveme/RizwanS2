package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: ReturnAddress.java */
/* renamed from: com.b.b.a.b.r */
/* loaded from: classes.dex */
public final class C0722r implements InterfaceC0976d {

    /* renamed from: a */
    private final int f4556a;

    public C0722r(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("subroutineAddress < 0");
        }
        this.f4556a = i;
    }

    public String toString() {
        return "<addr:" + C1022m.m8557c(this.f4556a) + ">";
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return toString();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return C0975c.f6256k;
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: b */
    public InterfaceC0976d mo6696b() {
        return this;
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: c */
    public int mo6697c() {
        return C0975c.f6256k.mo6697c();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: e */
    public int mo6698e() {
        return C0975c.f6256k.mo6698e();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: f */
    public boolean mo6699f() {
        return false;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0722r) && this.f4556a == ((C0722r) obj).f4556a;
    }

    public int hashCode() {
        return this.f4556a;
    }

    /* renamed from: g */
    public int m6700g() {
        return this.f4556a;
    }
}
