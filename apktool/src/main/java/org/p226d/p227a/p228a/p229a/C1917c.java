package org.p226d.p227a.p228a.p229a;

import org.p226d.p227a.p228a.C1948p;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p269d.C2457k;

/* compiled from: EndLocalMethodItem.java */
/* renamed from: org.d.a.a.a.c */
/* loaded from: classes.dex */
public class C1917c extends AbstractC1916b {

    /* renamed from: a */
    private final InterfaceC2167b f11270a;

    /* renamed from: b */
    private final C1948p f11271b;

    public C1917c(int i, int i2, C1948p c1948p, InterfaceC2167b interfaceC2167b) {
        super(i, i2);
        this.f11270a = interfaceC2167b;
        this.f11271b = c1948p;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(".end local ");
        this.f11271b.m14172a(c2457k, this.f11270a.mo14463e());
        String b2 = this.f11270a.mo14220b();
        String l = this.f11270a.mo14465l();
        String c2 = this.f11270a.mo14452c();
        if (b2 != null || l != null || c2 != null) {
            c2457k.write("    # ");
            C1920f.m14092a(c2457k, b2, l, c2);
            return true;
        }
        return true;
    }
}
