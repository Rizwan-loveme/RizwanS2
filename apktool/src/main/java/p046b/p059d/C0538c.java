package p046b.p059d;

/* compiled from: Duo.java */
/* renamed from: b.d.c */
/* loaded from: classes.dex */
public class C0538c<T1, T2> {

    /* renamed from: a */
    public final T1 f3632a;

    /* renamed from: b */
    public final T2 f3633b;

    public C0538c(T1 t1, T2 t2) {
        this.f3632a = t1;
        this.f3633b = t2;
    }

    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            C0538c c0538c = (C0538c) obj;
            if (this.f3632a == c0538c.f3632a || (this.f3632a != null && this.f3632a.equals(c0538c.f3632a))) {
                return this.f3633b == c0538c.f3633b || (this.f3633b != null && this.f3633b.equals(c0538c.f3633b));
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f3632a != null ? this.f3632a.hashCode() : 0) + 213) * 71) + (this.f3633b != null ? this.f3633b.hashCode() : 0);
    }
}
