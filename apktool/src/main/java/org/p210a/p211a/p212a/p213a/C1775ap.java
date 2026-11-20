package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.p213a.AbstractC1783ax;

/* compiled from: PredicateTransition.java */
/* renamed from: org.a.a.a.a.ap */
/* loaded from: classes.dex */
public final class C1775ap extends AbstractC1799i {

    /* renamed from: a */
    public final int f10723a;

    /* renamed from: b */
    public final int f10724b;

    /* renamed from: c */
    public final boolean f10725c;

    public C1775ap(AbstractC1797g abstractC1797g, int i, int i2, boolean z) {
        super(abstractC1797g);
        this.f10723a = i;
        this.f10724b = i2;
        this.f10725c = z;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: a */
    public int mo13500a() {
        return 4;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: b */
    public boolean mo13540b() {
        return true;
    }

    @Override // org.p210a.p211a.p212a.p213a.AbstractC1791be
    /* renamed from: a */
    public boolean mo13501a(int i, int i2, int i3) {
        return false;
    }

    /* renamed from: d */
    public AbstractC1783ax.e m13542d() {
        return new AbstractC1783ax.e(this.f10723a, this.f10724b, this.f10725c);
    }

    public String toString() {
        return "pred_" + this.f10723a + ":" + this.f10724b;
    }
}
