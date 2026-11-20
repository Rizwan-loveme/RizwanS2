package jadx.p180a;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1648n;
import java.util.List;

/* compiled from: JavaMethod.java */
/* renamed from: jadx.a.g */
/* loaded from: classes.dex */
public final class C1539g implements InterfaceC1540h {

    /* renamed from: a */
    private final C1648n f9879a;

    /* renamed from: b */
    private final C1537e f9880b;

    C1539g(C1537e c1537e, C1648n c1648n) {
        this.f9880b = c1537e;
        this.f9879a = c1648n;
    }

    @Override // jadx.p180a.InterfaceC1540h
    /* renamed from: c */
    public String mo11806c() {
        return this.f9879a.m12639n();
    }

    /* renamed from: a */
    public List<AbstractC1596a> m11812a() {
        return this.f9879a.m12617O().m12247f();
    }

    /* renamed from: b */
    public AbstractC1596a m11813b() {
        return this.f9879a.m12636k();
    }

    /* renamed from: d */
    public int m11814d() {
        return this.f9879a.m12123e();
    }

    public int hashCode() {
        return this.f9879a.hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof C1539g) && this.f9879a.equals(((C1539g) obj).f9879a));
    }

    public String toString() {
        return this.f9879a.toString();
    }
}
