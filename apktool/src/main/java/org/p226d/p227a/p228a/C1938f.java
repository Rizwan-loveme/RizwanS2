package org.p226d.p227a.p228a;

import org.p226d.p269d.C2457k;

/* compiled from: CommentedOutMethodItem.java */
/* renamed from: org.d.a.a.f */
/* loaded from: classes.dex */
public class C1938f extends AbstractC1944l {

    /* renamed from: a */
    private final AbstractC1944l f11323a;

    public C1938f(AbstractC1944l abstractC1944l) {
        super(abstractC1944l.m14161d());
        this.f11323a = abstractC1944l;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return this.f11323a.mo14091a() + 0.001d;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(35);
        this.f11323a.mo14089a(c2457k);
        return true;
    }
}
