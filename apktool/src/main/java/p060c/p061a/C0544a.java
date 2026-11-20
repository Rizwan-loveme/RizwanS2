package p060c.p061a;

/* compiled from: StringItem.java */
/* renamed from: c.a.a */
/* loaded from: classes.dex */
public class C0544a {

    /* renamed from: a */
    public String f3643a;

    /* renamed from: b */
    public int f3644b;

    /* renamed from: c */
    public int f3645c;

    public C0544a() {
    }

    public C0544a(String str) {
        this.f3643a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C0544a c0544a = (C0544a) obj;
            return this.f3643a == null ? c0544a.f3643a == null : this.f3643a.equals(c0544a.f3643a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f3643a == null ? 0 : this.f3643a.hashCode()) + 31;
    }

    public String toString() {
        return String.format("S%04d %s", new Integer(this.f3645c), this.f3643a);
    }
}
