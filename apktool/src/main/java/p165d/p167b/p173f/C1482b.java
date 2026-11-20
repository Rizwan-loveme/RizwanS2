package p165d.p167b.p173f;

import java.util.Comparator;

/* compiled from: RDN.java */
/* renamed from: d.b.f.b */
/* loaded from: classes.dex */
class C1482b implements Comparator<C1455a> {

    /* renamed from: a */
    private static final Comparator<C1455a> f9508a = new C1482b();

    private C1482b() {
    }

    /* renamed from: a */
    static Comparator<C1455a> m11526a() {
        return f9508a;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1455a c1455a, C1455a c1455a2) {
        boolean m11471a = c1455a.m11471a();
        if (m11471a == c1455a2.m11471a()) {
            return c1455a.m11472b().compareTo(c1455a2.m11472b());
        }
        if (m11471a) {
            return -1;
        }
        return 1;
    }
}
