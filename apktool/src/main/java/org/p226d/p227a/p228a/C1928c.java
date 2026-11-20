package org.p226d.p227a.p228a;

import org.p226d.p227a.C1950b;
import org.p226d.p227a.p228a.C1943k;
import org.p226d.p269d.C2457k;

/* compiled from: CatchMethodItem.java */
/* renamed from: org.d.a.a.c */
/* loaded from: classes.dex */
public class C1928c extends AbstractC1944l {

    /* renamed from: a */
    private final String f11278a;

    /* renamed from: b */
    private final C1942j f11279b;

    /* renamed from: c */
    private final C1942j f11280c;

    /* renamed from: d */
    private final C1942j f11281d;

    public C1928c(C1950b c1950b, C1943k.b bVar, int i, String str, int i2, int i3, int i4) {
        super(i);
        this.f11278a = str;
        this.f11279b = bVar.m14160a(new C1942j(c1950b, i2, "try_start_"));
        this.f11280c = bVar.m14160a(new C1940h(c1950b, i, i3));
        if (str == null) {
            this.f11281d = bVar.m14160a(new C1942j(c1950b, i4, "catchall_"));
        } else {
            this.f11281d = bVar.m14160a(new C1942j(c1950b, i4, "catch_"));
        }
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return 102.0d;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        if (this.f11278a == null) {
            c2457k.write(".catchall");
        } else {
            c2457k.write(".catch ");
            c2457k.write(this.f11278a);
        }
        c2457k.write(" {");
        this.f11279b.mo14089a(c2457k);
        c2457k.write(" .. ");
        this.f11280c.mo14089a(c2457k);
        c2457k.write("} ");
        this.f11281d.mo14089a(c2457k);
        return true;
    }
}
