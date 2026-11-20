package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerMoreAction.java */
/* renamed from: org.a.a.a.a.ad */
/* loaded from: classes.dex */
public final class C1763ad implements InterfaceC1813w {

    /* renamed from: a */
    public static final C1763ad f10705a = new C1763ad();

    private C1763ad() {
    }

    /* renamed from: b */
    public EnumC1815y m13494b() {
        return EnumC1815y.MORE;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return false;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.m13869m();
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13770a(), m13494b().ordinal()), 1);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public String toString() {
        return "more";
    }
}
