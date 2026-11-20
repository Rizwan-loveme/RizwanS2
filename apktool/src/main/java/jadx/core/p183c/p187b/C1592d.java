package jadx.core.p183c.p187b;

import jadx.core.p181a.C1554j;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1637c;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;

/* compiled from: FieldInfo.java */
/* renamed from: jadx.core.c.b.d */
/* loaded from: classes.dex */
public final class C1592d {

    /* renamed from: a */
    private final C1590b f10110a;

    /* renamed from: b */
    private final String f10111b;

    /* renamed from: c */
    private final AbstractC1596a f10112c;

    /* renamed from: d */
    private String f10113d;

    private C1592d(C1590b c1590b, String str, AbstractC1596a abstractC1596a) {
        this.f10110a = c1590b;
        this.f10111b = str;
        this.f10112c = abstractC1596a;
        this.f10113d = str;
    }

    /* renamed from: a */
    public static C1592d m12223a(C1637c c1637c, C1590b c1590b, String str, AbstractC1596a abstractC1596a) {
        return c1637c.mo12541u().m12667i().m12235a(new C1592d(c1590b, str, abstractC1596a));
    }

    /* renamed from: a */
    public static C1592d m12224a(C1637c c1637c, InterfaceC2237b interfaceC2237b) {
        return m12223a(c1637c, C1590b.m12193a(c1637c.mo12541u(), interfaceC2237b.mo14225d()), interfaceC2237b.mo14226e(), c1637c.m12547a(interfaceC2237b.mo14227f()));
    }

    /* renamed from: a */
    public String m12225a() {
        return this.f10111b;
    }

    /* renamed from: b */
    public AbstractC1596a m12227b() {
        return this.f10112c;
    }

    /* renamed from: c */
    public C1590b m12228c() {
        return this.f10110a;
    }

    /* renamed from: d */
    public String m12229d() {
        return this.f10113d;
    }

    /* renamed from: a */
    public void m12226a(String str) {
        this.f10113d = str;
    }

    /* renamed from: e */
    public String m12230e() {
        return String.valueOf(this.f10110a.m12202d()) + "." + this.f10111b + ":" + C1554j.m12005a(this.f10112c);
    }

    /* renamed from: f */
    public boolean m12231f() {
        return !this.f10111b.equals(this.f10113d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1592d c1592d = (C1592d) obj;
        return this.f10111b.equals(c1592d.f10111b) && this.f10112c.equals(c1592d.f10112c) && this.f10110a.equals(c1592d.f10110a);
    }

    public int hashCode() {
        return (((this.f10111b.hashCode() * 31) + this.f10112c.hashCode()) * 31) + this.f10110a.hashCode();
    }

    public String toString() {
        return this.f10110a + "." + this.f10111b + " " + this.f10112c;
    }
}
