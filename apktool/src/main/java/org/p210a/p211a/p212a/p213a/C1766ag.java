package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerSkipAction.java */
/* renamed from: org.a.a.a.a.ag */
/* loaded from: classes.dex */
public final class C1766ag implements InterfaceC1813w {

    /* renamed from: a */
    public static final C1766ag f10708a = new C1766ag();

    private C1766ag() {
    }

    /* renamed from: b */
    public EnumC1815y m13497b() {
        return EnumC1815y.SKIP;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return false;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.m13868l();
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13770a(), m13497b().ordinal()), 1);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public String toString() {
        return "skip";
    }
}
