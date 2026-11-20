package org.p226d.p227a.p228a;

import org.p226d.p269d.C2457k;

/* compiled from: CommentMethodItem.java */
/* renamed from: org.d.a.a.e */
/* loaded from: classes.dex */
public class C1937e extends AbstractC1944l {

    /* renamed from: a */
    private final String f11321a;

    /* renamed from: b */
    private final double f11322b;

    public C1937e(String str, int i, double d2) {
        super(i);
        this.f11321a = str;
        this.f11322b = d2;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return this.f11322b;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(35);
        c2457k.write(this.f11321a);
        return true;
    }
}
