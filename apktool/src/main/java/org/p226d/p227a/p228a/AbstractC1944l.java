package org.p226d.p227a.p228a;

import org.p226d.p269d.C2457k;

/* compiled from: MethodItem.java */
/* renamed from: org.d.a.a.l */
/* loaded from: classes.dex */
public abstract class AbstractC1944l implements Comparable<AbstractC1944l> {

    /* renamed from: f */
    protected final int f11343f;

    /* renamed from: a */
    public abstract double mo14091a();

    /* renamed from: a */
    public abstract boolean mo14089a(C2457k c2457k);

    protected AbstractC1944l(int i) {
        this.f11343f = i;
    }

    /* renamed from: d */
    public int m14161d() {
        return this.f11343f;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC1944l abstractC1944l) {
        int compareTo = Integer.valueOf(this.f11343f).compareTo(Integer.valueOf(abstractC1944l.f11343f));
        if (compareTo == 0) {
            return Double.valueOf(mo14091a()).compareTo(Double.valueOf(abstractC1944l.mo14091a()));
        }
        return compareTo;
    }
}
