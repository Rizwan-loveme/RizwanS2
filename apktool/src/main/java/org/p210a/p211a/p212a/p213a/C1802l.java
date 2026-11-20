package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: AtomTransition.java */
/* renamed from: org.a.a.a.a.l */
/* loaded from: classes.dex */
public final class C1802l extends AbstractC1791be {

    /* renamed from: a */
    public final int f10812a;

    public C1802l(AbstractC1797g abstractC1797g, int i) {
        super(abstractC1797g);
        this.f10812a = i;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: a */
    public int mo13500a() {
        return 5;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: c */
    public C1840j mo13577c() {
        return C1840j.m13752a(this.f10812a);
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: a */
    public boolean mo13501a(int i, int i2, int i3) {
        return this.f10812a == i;
    }

    public String toString() {
        return String.valueOf(this.f10812a);
    }
}
