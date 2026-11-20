package org.p226d.p227a.p228a;

import org.p226d.p227a.C1950b;
import org.p226d.p269d.C2457k;

/* compiled from: RegisterFormatter.java */
/* renamed from: org.d.a.a.p */
/* loaded from: classes.dex */
public class C1948p {

    /* renamed from: d */
    static final /* synthetic */ boolean f11350d;

    /* renamed from: a */
    public final C1950b f11351a;

    /* renamed from: b */
    public final int f11352b;

    /* renamed from: c */
    public final int f11353c;

    static {
        f11350d = !C1948p.class.desiredAssertionStatus();
    }

    public C1948p(C1950b c1950b, int i, int i2) {
        this.f11351a = c1950b;
        this.f11352b = i;
        this.f11353c = i2;
    }

    /* renamed from: a */
    public void m14173a(C2457k c2457k, int i, int i2) {
        if (this.f11351a.f11356b) {
            if (!f11350d && i > i2) {
                throw new AssertionError();
            }
            if (i >= this.f11352b - this.f11353c) {
                c2457k.write("{p");
                c2457k.m15536c(i - (this.f11352b - this.f11353c));
                c2457k.write(" .. p");
                c2457k.m15536c(i2 - (this.f11352b - this.f11353c));
                c2457k.write(125);
                return;
            }
        }
        c2457k.write("{v");
        c2457k.m15536c(i);
        c2457k.write(" .. v");
        c2457k.m15536c(i2);
        c2457k.write(125);
    }

    /* renamed from: a */
    public void m14172a(C2457k c2457k, int i) {
        if (this.f11351a.f11356b && i >= this.f11352b - this.f11353c) {
            c2457k.write(112);
            c2457k.m15536c(i - (this.f11352b - this.f11353c));
        } else {
            c2457k.write(118);
            c2457k.m15536c(i);
        }
    }
}
