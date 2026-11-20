package org.p226d.p233b.p241c;

import java.util.Set;
import org.p226d.p233b.p241c.p242a.C2018a;
import org.p226d.p233b.p241c.p242a.C2019b;
import org.p226d.p233b.p241c.p242a.C2020c;
import org.p226d.p233b.p241c.p242a.C2021d;
import org.p226d.p233b.p241c.p242a.C2022e;
import org.p226d.p233b.p241c.p242a.C2023f;
import org.p226d.p233b.p241c.p242a.C2024g;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: MethodLocation.java */
/* renamed from: org.d.b.c.m */
/* loaded from: classes.dex */
public class C2073m {

    /* renamed from: a */
    AbstractC2063c f11739a;

    /* renamed from: b */
    int f11740b;

    /* renamed from: c */
    int f11741c;

    /* renamed from: e */
    private final AbstractC2070j<AbstractC2017a> f11743e = new C2069i();

    /* renamed from: d */
    private final AbstractC2070j<C2068h> f11742d = new C2071k();

    C2073m(AbstractC2063c abstractC2063c, int i, int i2) {
        this.f11739a = abstractC2063c;
        this.f11740b = i;
        this.f11741c = i2;
    }

    /* renamed from: a */
    public InterfaceC2218f m14543a() {
        return this.f11739a;
    }

    /* renamed from: b */
    public int m14548b() {
        return this.f11740b;
    }

    /* renamed from: a */
    void m14546a(C2073m c2073m) {
        this.f11742d.m14527a(c2073m, c2073m.f11742d);
        this.f11743e.m14527a(c2073m, c2073m.f11743e);
    }

    /* renamed from: c */
    public Set<C2068h> m14550c() {
        return this.f11742d.m14526a(this);
    }

    /* renamed from: d */
    public C2068h m14552d() {
        C2068h c2068h = new C2068h();
        m14550c().add(c2068h);
        return c2068h;
    }

    /* renamed from: e */
    public Set<AbstractC2017a> m14553e() {
        return this.f11743e.m14526a(this);
    }

    /* renamed from: a */
    public void m14544a(int i) {
        m14553e().add(new C2020c(i));
    }

    /* renamed from: a */
    public void m14545a(int i, InterfaceC2242g interfaceC2242g, InterfaceC2243h interfaceC2243h, InterfaceC2242g interfaceC2242g2) {
        m14553e().add(new C2024g(i, interfaceC2242g, interfaceC2243h, interfaceC2242g2));
    }

    /* renamed from: b */
    public void m14549b(int i) {
        m14553e().add(new C2018a(i));
    }

    /* renamed from: c */
    public void m14551c(int i) {
        m14553e().add(new C2022e(i));
    }

    /* renamed from: f */
    public void m14554f() {
        m14553e().add(new C2021d());
    }

    /* renamed from: g */
    public void m14555g() {
        m14553e().add(new C2019b());
    }

    /* renamed from: a */
    public void m14547a(InterfaceC2242g interfaceC2242g) {
        m14553e().add(new C2023f(interfaceC2242g));
    }
}
