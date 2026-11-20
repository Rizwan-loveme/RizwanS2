package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerChannelAction.java */
/* renamed from: org.a.a.a.a.z */
/* loaded from: classes.dex */
public final class C1816z implements InterfaceC1813w {

    /* renamed from: a */
    private final int f10845a;

    public C1816z(int i) {
        this.f10845a = i;
    }

    /* renamed from: b */
    public EnumC1815y m13669b() {
        return EnumC1815y.CHANNEL;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return false;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.m13865d(this.f10845a);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13772a(C1841k.m13770a(), m13669b().ordinal()), this.f10845a), 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C1816z) && this.f10845a == ((C1816z) obj).f10845a;
    }

    public String toString() {
        return String.format("channel(%d)", Integer.valueOf(this.f10845a));
    }
}
