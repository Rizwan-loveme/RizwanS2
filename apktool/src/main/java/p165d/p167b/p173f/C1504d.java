package p165d.p167b.p173f;

import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: AccessDescription.java */
/* renamed from: d.b.f.d */
/* loaded from: classes.dex */
public final class C1504d {

    /* renamed from: e */
    private C1465aj f9636e;

    /* renamed from: f */
    private C1454q f9637f;

    /* renamed from: g */
    private int f9638g = -1;

    /* renamed from: c */
    public static final C1454q f9634c = C1454q.m11454a(new int[]{1, 3, 6, 1, 5, 5, 7, 48, 1});

    /* renamed from: a */
    public static final C1454q f9632a = C1454q.m11454a(new int[]{1, 3, 6, 1, 5, 5, 7, 48, 2});

    /* renamed from: d */
    public static final C1454q f9635d = C1454q.m11454a(new int[]{1, 3, 6, 1, 5, 5, 7, 48, 3});

    /* renamed from: b */
    public static final C1454q f9633b = C1454q.m11454a(new int[]{1, 3, 6, 1, 5, 5, 7, 48, 5});

    public C1504d(C1450m c1450m) {
        C1448k m11425f = c1450m.m11425f();
        this.f9637f = m11425f.m11376h();
        this.f9636e = new C1465aj(m11425f.m11371d());
    }

    /* renamed from: b */
    public C1454q m11628b() {
        return this.f9637f;
    }

    /* renamed from: a */
    public C1465aj m11626a() {
        return this.f9636e;
    }

    /* renamed from: a */
    public void m11627a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        c1449l2.m11394a(this.f9637f);
        this.f9636e.m11493a(c1449l2);
        c1449l.m11388a((byte) 48, c1449l2);
    }

    public int hashCode() {
        if (this.f9638g == -1) {
            this.f9638g = this.f9637f.hashCode() + this.f9636e.hashCode();
        }
        return this.f9638g;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1504d)) {
            return false;
        }
        C1504d c1504d = (C1504d) obj;
        if (this != c1504d) {
            return this.f9637f.equals(c1504d.m11628b()) && this.f9636e.equals(c1504d.m11626a());
        }
        return true;
    }

    public String toString() {
        String c1454q;
        if (this.f9637f.equals(f9632a)) {
            c1454q = "caIssuers";
        } else if (this.f9637f.equals(f9633b)) {
            c1454q = "caRepository";
        } else if (this.f9637f.equals(f9635d)) {
            c1454q = "timeStamping";
        } else if (this.f9637f.equals(f9634c)) {
            c1454q = "ocsp";
        } else {
            c1454q = this.f9637f.toString();
        }
        return "\n   accessMethod: " + c1454q + "\n   accessLocation: " + this.f9636e.toString();
    }
}
