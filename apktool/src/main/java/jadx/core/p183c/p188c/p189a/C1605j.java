package jadx.core.p183c.p188c.p189a;

import jadx.core.p183c.p184a.AbstractC1584d;
import jadx.core.p183c.p188c.C1625p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SSAVar.java */
/* renamed from: jadx.core.c.c.a.j */
/* loaded from: classes.dex */
public class C1605j extends AbstractC1584d {

    /* renamed from: a */
    private final int f10181a;

    /* renamed from: b */
    private final int f10182b;

    /* renamed from: c */
    private C1608m f10183c;

    /* renamed from: d */
    private int f10184d;

    /* renamed from: e */
    private int f10185e;

    /* renamed from: f */
    private C1604i f10186f;

    /* renamed from: g */
    private final List<C1604i> f10187g = new ArrayList(2);

    /* renamed from: h */
    private C1625p f10188h;

    /* renamed from: i */
    private AbstractC1596a f10189i;

    /* renamed from: j */
    private boolean f10190j;

    public C1605j(int i, int i2, C1604i c1604i) {
        this.f10181a = i;
        this.f10182b = i2;
        this.f10186f = c1604i;
        c1604i.mo12326a(this);
        this.f10184d = -1;
        this.f10185e = -1;
    }

    /* renamed from: d */
    public int m12343d() {
        if (this.f10184d == -1) {
            m12334q();
        }
        return this.f10184d;
    }

    /* renamed from: e */
    public int m12344e() {
        if (this.f10185e == -1) {
            m12334q();
        }
        return this.f10185e;
    }

    /* renamed from: q */
    private void m12334q() {
        int i;
        int i2;
        int m12591s;
        int m12591s2;
        if (this.f10186f.m12314l() == null || (m12591s2 = this.f10186f.m12314l().m12591s()) < 0) {
            i = Integer.MIN_VALUE;
            i2 = Integer.MAX_VALUE;
        } else {
            i2 = Math.min(m12591s2, Integer.MAX_VALUE);
            i = Math.max(m12591s2, Integer.MIN_VALUE);
        }
        int i3 = i;
        for (C1604i c1604i : this.f10187g) {
            if (c1604i.m12314l() != null && (m12591s = c1604i.m12314l().m12591s()) >= 0) {
                i2 = Math.min(m12591s, i2);
                i3 = Math.max(m12591s, i3);
            }
        }
        if (i2 != Integer.MAX_VALUE && i3 != Integer.MIN_VALUE) {
            this.f10184d = i2;
            this.f10185e = i3;
        }
    }

    /* renamed from: f */
    public int m12345f() {
        return this.f10181a;
    }

    /* renamed from: g */
    public int m12346g() {
        return this.f10182b;
    }

    /* renamed from: h */
    public C1604i m12347h() {
        return this.f10186f;
    }

    /* renamed from: a */
    public void m12336a(C1604i c1604i) {
        this.f10186f = c1604i;
    }

    /* renamed from: i */
    public List<C1604i> m12348i() {
        return this.f10187g;
    }

    /* renamed from: j */
    public int m12349j() {
        return this.f10187g.size();
    }

    /* renamed from: b */
    public void m12340b(C1604i c1604i) {
        if (c1604i.m12331p() != null) {
            c1604i.m12331p().m12342c(c1604i);
        }
        c1604i.mo12326a(this);
        this.f10187g.add(c1604i);
    }

    /* renamed from: c */
    public void m12342c(C1604i c1604i) {
        int size = this.f10187g.size();
        for (int i = 0; i < size; i++) {
            if (this.f10187g.get(i) == c1604i) {
                this.f10187g.remove(i);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m12338a(C1625p c1625p) {
        this.f10188h = c1625p;
    }

    /* renamed from: k */
    public C1625p m12350k() {
        return this.f10188h;
    }

    /* renamed from: l */
    public boolean m12351l() {
        return this.f10188h != null;
    }

    /* renamed from: m */
    public int m12352m() {
        return this.f10188h == null ? this.f10187g.size() : this.f10187g.size() + this.f10188h.m12588p().m12331p().m12349j();
    }

    /* renamed from: a */
    public void m12335a(AbstractC1596a abstractC1596a) {
        if (this.f10190j) {
            abstractC1596a = this.f10189i;
        } else {
            this.f10189i = abstractC1596a;
        }
        this.f10186f.f10191d = abstractC1596a;
        int size = this.f10187g.size();
        for (int i = 0; i < size; i++) {
            this.f10187g.get(i).f10191d = abstractC1596a;
        }
    }

    /* renamed from: b */
    public void m12339b(AbstractC1596a abstractC1596a) {
        m12335a(abstractC1596a);
        this.f10190j = true;
    }

    /* renamed from: n */
    public boolean m12353n() {
        return this.f10190j;
    }

    /* renamed from: b */
    public void m12341b(String str) {
        if (str != null) {
            if (this.f10183c == null) {
                this.f10183c = new C1608m();
            }
            this.f10183c.m12361a(str);
        }
    }

    /* renamed from: o */
    public String m12354o() {
        if (this.f10183c == null) {
            return null;
        }
        return this.f10183c.m12360a();
    }

    /* renamed from: p */
    public C1608m m12355p() {
        return this.f10183c;
    }

    /* renamed from: a */
    public void m12337a(C1608m c1608m) {
        this.f10183c = c1608m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1605j)) {
            return false;
        }
        C1605j c1605j = (C1605j) obj;
        return this.f10181a == c1605j.f10181a && this.f10182b == c1605j.f10182b;
    }

    public int hashCode() {
        return (this.f10181a * 31) + this.f10182b;
    }

    public String toString() {
        return "r" + this.f10181a + "_" + this.f10182b;
    }
}
