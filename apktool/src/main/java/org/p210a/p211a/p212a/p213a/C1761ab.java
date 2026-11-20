package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerIndexedCustomAction.java */
/* renamed from: org.a.a.a.a.ab */
/* loaded from: classes.dex */
public final class C1761ab implements InterfaceC1813w {

    /* renamed from: a */
    private final int f10702a;

    /* renamed from: b */
    private final InterfaceC1813w f10703b;

    public C1761ab(int i, InterfaceC1813w interfaceC1813w) {
        this.f10702a = i;
        this.f10703b = interfaceC1813w;
    }

    /* renamed from: b */
    public int m13491b() {
        return this.f10702a;
    }

    /* renamed from: c */
    public InterfaceC1813w m13492c() {
        return this.f10703b;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return true;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        this.f10703b.mo13488a(abstractC1870r);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13773a(C1841k.m13772a(C1841k.m13770a(), this.f10702a), this.f10703b), 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1761ab)) {
            return false;
        }
        C1761ab c1761ab = (C1761ab) obj;
        return this.f10702a == c1761ab.f10702a && this.f10703b.equals(c1761ab.f10703b);
    }
}
