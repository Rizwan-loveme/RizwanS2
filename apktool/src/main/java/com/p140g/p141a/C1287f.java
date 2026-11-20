package com.p140g.p141a;

/* compiled from: MethodHandle.java */
/* renamed from: com.g.a.f */
/* loaded from: classes.dex */
public class C1287f {

    /* renamed from: a */
    private int f8488a;

    /* renamed from: b */
    private C1249d f8489b;

    /* renamed from: c */
    private C1280e f8490c;

    public C1287f(int i, C1249d c1249d) {
        this.f8488a = i;
        this.f8489b = c1249d;
    }

    public C1287f(int i, C1280e c1280e) {
        this.f8488a = i;
        this.f8490c = c1280e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1287f c1287f = (C1287f) obj;
        if (this.f8488a != c1287f.f8488a) {
            return false;
        }
        if (this.f8489b != null) {
            if (!this.f8489b.equals(c1287f.f8489b)) {
                return false;
            }
        } else if (c1287f.f8489b != null) {
            return false;
        }
        return this.f8490c != null ? this.f8490c.equals(c1287f.f8490c) : c1287f.f8490c == null;
    }

    public int hashCode() {
        return (((this.f8489b != null ? this.f8489b.hashCode() : 0) + (this.f8488a * 31)) * 31) + (this.f8490c != null ? this.f8490c.hashCode() : 0);
    }

    /* renamed from: a */
    public int m10457a() {
        return this.f8488a;
    }

    /* renamed from: b */
    public C1249d m10458b() {
        return this.f8489b;
    }

    /* renamed from: c */
    public C1280e m10459c() {
        return this.f8490c;
    }
}
