package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: LexerPushModeAction.java */
/* renamed from: org.a.a.a.a.af */
/* loaded from: classes.dex */
public final class C1765af implements InterfaceC1813w {

    /* renamed from: a */
    private final int f10707a;

    public C1765af(int i) {
        this.f10707a = i;
    }

    /* renamed from: b */
    public EnumC1815y m13496b() {
        return EnumC1815y.PUSH_MODE;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public boolean mo13489a() {
        return false;
    }

    @Override // org.p210a.p211a.p212a.p213a.InterfaceC1813w
    /* renamed from: a */
    public void mo13488a(AbstractC1870r abstractC1870r) {
        abstractC1870r.m13862b(this.f10707a);
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13772a(C1841k.m13770a(), m13496b().ordinal()), this.f10707a), 2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C1765af) && this.f10707a == ((C1765af) obj).f10707a;
    }

    public String toString() {
        return String.format("pushMode(%d)", Integer.valueOf(this.f10707a));
    }
}
