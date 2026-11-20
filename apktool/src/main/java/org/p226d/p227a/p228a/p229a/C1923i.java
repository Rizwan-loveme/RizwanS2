package org.p226d.p227a.p228a.p229a;

import org.p226d.p227a.p228a.C1948p;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p269d.C2457k;

/* compiled from: StartLocalMethodItem.java */
/* renamed from: org.d.a.a.a.i */
/* loaded from: classes.dex */
public class C1923i extends AbstractC1916b {

    /* renamed from: a */
    private final InterfaceC2174i f11276a;

    /* renamed from: b */
    private final C1948p f11277b;

    public C1923i(int i, int i2, C1948p c1948p, InterfaceC2174i interfaceC2174i) {
        super(i, i2);
        this.f11276a = interfaceC2174i;
        this.f11277b = c1948p;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(".local ");
        this.f11277b.m14172a(c2457k, this.f11276a.mo14470e());
        String b2 = this.f11276a.mo14220b();
        String l = this.f11276a.mo14465l();
        String c2 = this.f11276a.mo14452c();
        if (b2 != null || l != null || c2 != null) {
            c2457k.write(", ");
            C1920f.m14092a(c2457k, b2, l, c2);
            return true;
        }
        return true;
    }
}
