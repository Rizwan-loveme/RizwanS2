package jadx.p180a;

/* compiled from: CodePosition.java */
/* renamed from: jadx.a.a */
/* loaded from: classes.dex */
public final class C1533a {

    /* renamed from: a */
    private final InterfaceC1540h f9834a = null;

    /* renamed from: b */
    private final int f9835b;

    /* renamed from: c */
    private final int f9836c;

    public C1533a(int i, int i2) {
        this.f9835b = i;
        this.f9836c = i2;
    }

    /* renamed from: a */
    public int m11754a() {
        return this.f9835b;
    }

    /* renamed from: b */
    public int m11755b() {
        return this.f9836c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1533a c1533a = (C1533a) obj;
        return this.f9835b == c1533a.f9835b && this.f9836c == c1533a.f9836c;
    }

    public int hashCode() {
        return this.f9835b + (this.f9836c * 31);
    }

    public String toString() {
        return String.valueOf(this.f9835b) + ":" + this.f9836c + (this.f9834a != null ? " " + this.f9834a : "");
    }
}
