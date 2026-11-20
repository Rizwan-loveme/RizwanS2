package jadx.p180a;

import jadx.core.p181a.C1548d;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1647m;
import jadx.core.p183c.p191d.C1648n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: JavaClass.java */
/* renamed from: jadx.a.e */
/* loaded from: classes.dex */
public final class C1537e implements InterfaceC1540h {

    /* renamed from: a */
    private final C1536d f9871a;

    /* renamed from: b */
    private final C1636b f9872b;

    /* renamed from: c */
    private final C1537e f9873c;

    /* renamed from: d */
    private List<C1537e> f9874d;

    /* renamed from: e */
    private List<C1538f> f9875e;

    /* renamed from: f */
    private List<C1539g> f9876f;

    C1537e(C1636b c1636b, C1536d c1536d) {
        this.f9874d = Collections.emptyList();
        this.f9875e = Collections.emptyList();
        this.f9876f = Collections.emptyList();
        this.f9871a = c1536d;
        this.f9872b = c1636b;
        this.f9873c = null;
    }

    C1537e(C1636b c1636b, C1537e c1537e) {
        this.f9874d = Collections.emptyList();
        this.f9875e = Collections.emptyList();
        this.f9876f = Collections.emptyList();
        this.f9871a = null;
        this.f9872b = c1636b;
        this.f9873c = c1537e;
    }

    /* renamed from: a */
    public String m11804a() {
        C1548d m12511C = this.f9872b.m12511C();
        if (m12511C == null) {
            m11805b();
            m12511C = this.f9872b.m12511C();
            if (m12511C == null) {
                return "";
            }
        }
        return m12511C.m11907j();
    }

    /* renamed from: b */
    public synchronized void m11805b() {
        if (this.f9871a != null && this.f9872b.m12511C() == null) {
            this.f9871a.m11794a(this.f9872b);
            m11802g();
        }
    }

    /* renamed from: g */
    private void m11802g() {
        C1536d m11803h = m11803h();
        int size = this.f9872b.m12534n().size();
        if (size != 0) {
            ArrayList arrayList = new ArrayList(size);
            for (C1636b c1636b : this.f9872b.m12534n()) {
                if (!c1636b.mo12149b(EnumC1562a.DONT_GENERATE)) {
                    C1537e c1537e = new C1537e(c1636b, this);
                    c1537e.m11802g();
                    arrayList.add(c1537e);
                    m11803h.m11799g().put(c1636b, c1537e);
                }
            }
            this.f9874d = Collections.unmodifiableList(arrayList);
        }
        int size2 = this.f9872b.m12531k().size();
        if (size2 != 0) {
            ArrayList arrayList2 = new ArrayList(size2);
            for (C1639e c1639e : this.f9872b.m12531k()) {
                if (!c1639e.mo12149b(EnumC1562a.DONT_GENERATE)) {
                    C1538f c1538f = new C1538f(c1639e, this);
                    arrayList2.add(c1538f);
                    m11803h.m11801i().put(c1639e, c1538f);
                }
            }
            this.f9875e = Collections.unmodifiableList(arrayList2);
        }
        int size3 = this.f9872b.m12530j().size();
        if (size3 != 0) {
            ArrayList arrayList3 = new ArrayList(size3);
            for (C1648n c1648n : this.f9872b.m12530j()) {
                if (!c1648n.mo12149b(EnumC1562a.DONT_GENERATE)) {
                    C1539g c1539g = new C1539g(this, c1648n);
                    arrayList3.add(c1539g);
                    m11803h.m11800h().put(c1648n, c1539g);
                }
            }
            Collections.sort(arrayList3, C1647m.f10373a);
            this.f9876f = Collections.unmodifiableList(arrayList3);
        }
    }

    /* renamed from: h */
    private C1536d m11803h() {
        return this.f9873c != null ? this.f9873c.m11803h() : this.f9871a;
    }

    @Override // jadx.p180a.InterfaceC1540h
    /* renamed from: c */
    public String mo11806c() {
        return this.f9872b.m12546z();
    }

    /* renamed from: d */
    public String m11807d() {
        return this.f9872b.m12509A();
    }

    /* renamed from: e */
    public List<C1538f> m11808e() {
        m11805b();
        return this.f9875e;
    }

    /* renamed from: f */
    public List<C1539g> m11809f() {
        m11805b();
        return this.f9876f;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof C1537e) && this.f9872b.equals(((C1537e) obj).f9872b));
    }

    public int hashCode() {
        return this.f9872b.hashCode();
    }

    public String toString() {
        return m11807d();
    }
}
