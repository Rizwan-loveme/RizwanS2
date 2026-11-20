package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: RangeTransition.java */
/* renamed from: org.a.a.a.a.at */
/* loaded from: classes.dex */
public final class C1779at extends AbstractC1791be {

    /* renamed from: a */
    public final int f10737a;

    /* renamed from: b */
    public final int f10738b;

    public C1779at(AbstractC1797g abstractC1797g, int i, int i2) {
        super(abstractC1797g);
        this.f10737a = i;
        this.f10738b = i2;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: a */
    public int mo13500a() {
        return 2;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: c */
    public C1840j mo13577c() {
        return C1840j.m13753a(this.f10737a, this.f10738b);
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: a */
    public boolean mo13501a(int i, int i2, int i3) {
        return i >= this.f10737a && i <= this.f10738b;
    }

    public String toString() {
        return new StringBuilder("'").appendCodePoint(this.f10737a).append("'..'").appendCodePoint(this.f10738b).append("'").toString();
    }
}
