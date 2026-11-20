package org.p226d.p233b.p241c;

import java.util.HashMap;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: MethodImplementationBuilder.java */
/* renamed from: org.d.b.c.l */
/* loaded from: classes.dex */
public class C2072l {

    /* renamed from: a */
    private final HashMap<String, C2068h> f11736a = new HashMap<>();

    /* renamed from: b */
    private final C2074n f11737b;

    /* renamed from: c */
    private C2073m f11738c;

    public C2072l(int i) {
        this.f11737b = new C2074n(i);
        this.f11738c = this.f11737b.f11745b.get(0);
    }

    /* renamed from: a */
    public InterfaceC2268i m14531a() {
        return this.f11737b;
    }

    /* renamed from: a */
    public C2068h m14530a(String str) {
        C2068h c2068h = this.f11736a.get(str);
        if (c2068h != null) {
            if (c2068h.m14518d()) {
                throw new IllegalArgumentException("There is already a label with that name.");
            }
            this.f11738c.m14550c().add(c2068h);
            return c2068h;
        }
        C2068h m14552d = this.f11738c.m14552d();
        this.f11736a.put(str, m14552d);
        return m14552d;
    }

    /* renamed from: b */
    public C2068h m14538b(String str) {
        C2068h c2068h = this.f11736a.get(str);
        if (c2068h == null) {
            C2068h c2068h2 = new C2068h();
            this.f11736a.put(str, c2068h2);
            return c2068h2;
        }
        return c2068h;
    }

    /* renamed from: a */
    public void m14537a(InterfaceC2243h interfaceC2243h, C2068h c2068h, C2068h c2068h2, C2068h c2068h3) {
        this.f11737b.m14607a(interfaceC2243h, c2068h, c2068h2, c2068h3);
    }

    /* renamed from: a */
    public void m14535a(C2068h c2068h, C2068h c2068h2, C2068h c2068h3) {
        this.f11737b.m14606a(c2068h, c2068h2, c2068h3);
    }

    /* renamed from: a */
    public void m14532a(int i) {
        this.f11738c.m14544a(i);
    }

    /* renamed from: a */
    public void m14533a(int i, InterfaceC2242g interfaceC2242g, InterfaceC2243h interfaceC2243h, InterfaceC2242g interfaceC2242g2) {
        this.f11738c.m14545a(i, interfaceC2242g, interfaceC2243h, interfaceC2242g2);
    }

    /* renamed from: b */
    public void m14540b(int i) {
        this.f11738c.m14549b(i);
    }

    /* renamed from: c */
    public void m14542c(int i) {
        this.f11738c.m14551c(i);
    }

    /* renamed from: b */
    public void m14539b() {
        this.f11738c.m14554f();
    }

    /* renamed from: c */
    public void m14541c() {
        this.f11738c.m14555g();
    }

    /* renamed from: a */
    public void m14536a(InterfaceC2242g interfaceC2242g) {
        this.f11738c.m14547a(interfaceC2242g);
    }

    /* renamed from: a */
    public void m14534a(AbstractC2063c abstractC2063c) {
        this.f11737b.m14605a(abstractC2063c);
        this.f11738c = this.f11737b.f11745b.get(this.f11737b.f11745b.size() - 1);
    }
}
