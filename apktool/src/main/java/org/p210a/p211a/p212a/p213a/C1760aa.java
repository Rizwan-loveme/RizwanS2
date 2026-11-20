package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerCustomAction.java */
/* renamed from: org.a.a.a.a.aa */
/* loaded from: classes.dex */
public final class C1760aa implements InterfaceC1813w {

    /* renamed from: a */
    private final int f10700a;

    /* renamed from: b */
    private final int f10701b;

    public C1760aa(int i, int i2) {
        this.f10700a = i;
        this.f10701b = i2;
    }

    /* renamed from: b */
    public EnumC1815y m13490b() {
        return EnumC1815y.CUSTOM;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return true;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.mo4753b(null, this.f10700a, this.f10701b);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13772a(C1841k.m13772a(C1841k.m13770a(), m13490b().ordinal()), this.f10700a), this.f10701b), 3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1760aa)) {
            return false;
        }
        C1760aa c1760aa = (C1760aa) obj;
        return this.f10700a == c1760aa.f10700a && this.f10701b == c1760aa.f10701b;
    }
}
