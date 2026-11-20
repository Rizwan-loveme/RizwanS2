package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p110h.C1021l;

/* compiled from: PositionList.java */
/* renamed from: com.b.b.c.b.w */
/* loaded from: classes.dex */
public final class C0821w extends C1021l {

    /* renamed from: a */
    public static final C0821w f5092a = new C0821w(0);

    /* renamed from: a */
    public static C0821w m7155a(C0808j c0808j, int i) {
        switch (i) {
            case 1:
                return f5092a;
            case 2:
            case 3:
                C0940v c0940v = C0940v.f6128a;
                int f_ = c0808j.m8550f_();
                a[] aVarArr = new a[f_];
                int i2 = 0;
                boolean z = false;
                C0940v c0940v2 = c0940v;
                for (int i3 = 0; i3 < f_; i3++) {
                    AbstractC0807i m7049a = c0808j.m7049a(i3);
                    if (m7049a instanceof C0804f) {
                        z = true;
                    } else {
                        C0940v m7042i = m7049a.m7042i();
                        if (!m7042i.equals(c0940v) && !m7042i.m8029a(c0940v2) && (i != 3 || z)) {
                            aVarArr[i2] = new a(m7049a.m7040g(), m7042i);
                            i2++;
                            z = false;
                            c0940v2 = m7042i;
                        }
                    }
                }
                C0821w c0821w = new C0821w(i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    c0821w.m7157a(i4, aVarArr[i4]);
                }
                c0821w.mo6683e_();
                return c0821w;
            default:
                throw new IllegalArgumentException("bogus howMuch");
        }
    }

    public C0821w(int i) {
        super(i);
    }

    /* renamed from: a */
    public a m7156a(int i) {
        return (a) m8548e(i);
    }

    /* renamed from: a */
    public void m7157a(int i, a aVar) {
        m8546a(i, (Object) aVar);
    }

    /* compiled from: PositionList.java */
    /* renamed from: com.b.b.c.b.w$a */
    public static class a {

        /* renamed from: a */
        private final int f5093a;

        /* renamed from: b */
        private final C0940v f5094b;

        public a(int i, C0940v c0940v) {
            if (i < 0) {
                throw new IllegalArgumentException("address < 0");
            }
            if (c0940v == null) {
                throw new NullPointerException("position == null");
            }
            this.f5093a = i;
            this.f5094b = c0940v;
        }

        /* renamed from: a */
        public int m7158a() {
            return this.f5093a;
        }

        /* renamed from: b */
        public C0940v m7159b() {
            return this.f5094b;
        }
    }
}
