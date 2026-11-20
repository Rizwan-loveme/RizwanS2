package org.p271f.p272a;

/* compiled from: Handler.java */
/* renamed from: org.f.a.o */
/* loaded from: classes.dex */
class C2523o {

    /* renamed from: a */
    C2525q f13186a;

    /* renamed from: b */
    C2525q f13187b;

    /* renamed from: c */
    C2525q f13188c;

    /* renamed from: d */
    String f13189d;

    /* renamed from: e */
    int f13190e;

    /* renamed from: f */
    C2523o f13191f;

    C2523o() {
    }

    /* renamed from: a */
    static C2523o m15852a(C2523o c2523o, C2525q c2525q, C2525q c2525q2) {
        if (c2523o == null) {
            return null;
        }
        c2523o.f13191f = m15852a(c2523o.f13191f, c2525q, c2525q2);
        int i = c2523o.f13186a.f13204d;
        int i2 = c2523o.f13187b.f13204d;
        int i3 = c2525q.f13204d;
        int i4 = c2525q2 == null ? Integer.MAX_VALUE : c2525q2.f13204d;
        if (i3 < i2 && i4 > i) {
            if (i3 <= i) {
                if (i4 >= i2) {
                    return c2523o.f13191f;
                }
                c2523o.f13186a = c2525q2;
                return c2523o;
            }
            if (i4 >= i2) {
                c2523o.f13187b = c2525q;
                return c2523o;
            }
            C2523o c2523o2 = new C2523o();
            c2523o2.f13186a = c2525q2;
            c2523o2.f13187b = c2523o.f13187b;
            c2523o2.f13188c = c2523o.f13188c;
            c2523o2.f13189d = c2523o.f13189d;
            c2523o2.f13190e = c2523o.f13190e;
            c2523o2.f13191f = c2523o.f13191f;
            c2523o.f13187b = c2525q;
            c2523o.f13191f = c2523o2;
            return c2523o;
        }
        return c2523o;
    }
}
