package org.p210a.p211a.p212a;

import org.p210a.p211a.p212a.p215c.C1839i;
import org.p210a.p211a.p212a.p215c.C1843m;

/* compiled from: CommonTokenFactory.java */
/* renamed from: org.a.a.a.k */
/* loaded from: classes.dex */
public class C1863k implements InterfaceC1820ad<C1862j> {

    /* renamed from: a */
    public static final InterfaceC1820ad<C1862j> f10959a = new C1863k();

    /* renamed from: b */
    protected final boolean f10960b;

    public C1863k(boolean z) {
        this.f10960b = z;
    }

    public C1863k() {
        this(false);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1820ad
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1862j mo13681b(C1843m<InterfaceC1821ae, InterfaceC1858f> c1843m, int i, String str, int i2, int i3, int i4, int i5, int i6) {
        C1862j c1862j = new C1862j(c1843m, i, i2, i3, i4);
        c1862j.m13834a(i5);
        c1862j.m13836b(i6);
        if (str != null) {
            c1862j.m13835a(str);
        } else if (this.f10960b && c1843m.f10913b != null) {
            c1862j.m13835a(c1843m.f10913b.mo13712a(C1839i.m13746a(i3, i4)));
        }
        return c1862j;
    }
}
