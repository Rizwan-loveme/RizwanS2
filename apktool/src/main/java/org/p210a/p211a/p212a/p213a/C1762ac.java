package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerModeAction.java */
/* renamed from: org.a.a.a.a.ac */
/* loaded from: classes.dex */
public final class C1762ac implements InterfaceC1813w {

    /* renamed from: a */
    private final int f10704a;

    public C1762ac(int i) {
        this.f10704a = i;
    }

    /* renamed from: b */
    public EnumC1815y m13493b() {
        return EnumC1815y.MODE;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return false;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.m13858a(this.f10704a);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13772a(C1841k.m13770a(), m13493b().ordinal()), this.f10704a), 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C1762ac) && this.f10704a == ((C1762ac) obj).f10704a;
    }

    public String toString() {
        return String.format("mode(%d)", Integer.valueOf(this.f10704a));
    }
}
