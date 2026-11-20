package jadx.core.p183c.p191d;

/* compiled from: Edge.java */
/* renamed from: jadx.core.c.d.d */
/* loaded from: classes.dex */
public class C1638d {

    /* renamed from: a */
    private final C1628a f10360a;

    /* renamed from: b */
    private final C1628a f10361b;

    public C1638d(C1628a c1628a, C1628a c1628a2) {
        this.f10360a = c1628a;
        this.f10361b = c1628a2;
    }

    /* renamed from: a */
    public C1628a m12562a() {
        return this.f10360a;
    }

    /* renamed from: b */
    public C1628a m12563b() {
        return this.f10361b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1638d c1638d = (C1638d) obj;
        return this.f10360a.equals(c1638d.f10360a) && this.f10361b.equals(c1638d.f10361b);
    }

    public int hashCode() {
        return this.f10360a.hashCode() + (this.f10361b.hashCode() * 31);
    }

    public String toString() {
        return "Edge: " + this.f10360a + " -> " + this.f10361b;
    }
}
