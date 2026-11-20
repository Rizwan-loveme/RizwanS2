package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerTypeAction.java */
/* renamed from: org.a.a.a.a.ah */
/* loaded from: classes.dex */
public class C1767ah implements InterfaceC1813w {

    /* renamed from: a */
    private final int f10709a;

    public C1767ah(int i) {
        this.f10709a = i;
    }

    /* renamed from: b */
    public EnumC1815y m13498b() {
        return EnumC1815y.TYPE;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return false;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.m13864c(this.f10709a);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13772a(C1841k.m13770a(), m13498b().ordinal()), this.f10709a), 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C1767ah) && this.f10709a == ((C1767ah) obj).f10709a;
    }

    public String toString() {
        return String.format("type(%d)", Integer.valueOf(this.f10709a));
    }
}
