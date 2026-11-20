package org.p226d.p227a.p228a.p229a;

import org.p226d.p227a.p228a.C1948p;
import org.p226d.p233b.p250e.p251a.InterfaceC2172g;
import org.p226d.p269d.C2457k;

/* compiled from: RestartLocalMethodItem.java */
/* renamed from: org.d.a.a.a.g */
/* loaded from: classes.dex */
public class C1921g extends AbstractC1916b {

    /* renamed from: a */
    private final InterfaceC2172g f11273a;

    /* renamed from: b */
    private final C1948p f11274b;

    public C1921g(int i, int i2, C1948p c1948p, InterfaceC2172g interfaceC2172g) {
        super(i, i2);
        this.f11273a = interfaceC2172g;
        this.f11274b = c1948p;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        c2457k.write(".restart local ");
        this.f11274b.m14172a(c2457k, this.f11273a.mo14467e());
        String b2 = this.f11273a.mo14220b();
        String l = this.f11273a.mo14465l();
        String c2 = this.f11273a.mo14452c();
        if (b2 != null || l != null || c2 != null) {
            c2457k.write("    # ");
            C1920f.m14092a(c2457k, b2, l, c2);
            return true;
        }
        return true;
    }
}
