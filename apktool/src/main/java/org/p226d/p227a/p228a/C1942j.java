package org.p226d.p227a.p228a;

import org.p226d.p227a.C1950b;
import org.p226d.p269d.C2457k;

/* compiled from: LabelMethodItem.java */
/* renamed from: org.d.a.a.j */
/* loaded from: classes.dex */
public class C1942j extends AbstractC1944l {

    /* renamed from: a */
    private final C1950b f11325a;

    /* renamed from: b */
    private final String f11326b;

    /* renamed from: c */
    private int f11327c;

    public C1942j(C1950b c1950b, int i, String str) {
        super(i);
        this.f11325a = c1950b;
        this.f11326b = str;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return 0.0d;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AbstractC1944l abstractC1944l) {
        int compareTo = super.compareTo(abstractC1944l);
        if (compareTo == 0 && (abstractC1944l instanceof C1942j)) {
            return this.f11326b.compareTo(((C1942j) abstractC1944l).f11326b);
        }
        return compareTo;
    }

    public int hashCode() {
        return m14161d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1942j) && compareTo((AbstractC1944l) obj) == 0;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(58);
        c2457k.write(this.f11326b);
        if (this.f11325a.f11358d) {
            c2457k.m15533a(this.f11327c);
            return true;
        }
        c2457k.m15533a(mo14137b());
        return true;
    }

    /* renamed from: c */
    public String m14142c() {
        return this.f11326b;
    }

    /* renamed from: b */
    public int mo14137b() {
        return m14161d();
    }

    /* renamed from: a */
    public void m14141a(int i) {
        this.f11327c = i;
    }
}
