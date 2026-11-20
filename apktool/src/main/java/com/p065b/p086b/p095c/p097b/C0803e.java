package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p110h.C1021l;

/* compiled from: CatchTable.java */
/* renamed from: com.b.b.c.b.e */
/* loaded from: classes.dex */
public final class C0803e extends C1021l implements Comparable<C0803e> {

    /* renamed from: a */
    public static final C0803e f4779a = new C0803e(0);

    public C0803e(int i) {
        super(i);
    }

    /* renamed from: a */
    public a m7010a(int i) {
        return (a) m8548e(i);
    }

    /* renamed from: a */
    public void m7011a(int i, a aVar) {
        m8546a(i, (Object) aVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0803e c0803e) {
        if (this == c0803e) {
            return 0;
        }
        int f_ = m8550f_();
        int f_2 = c0803e.m8550f_();
        int min = Math.min(f_, f_2);
        for (int i = 0; i < min; i++) {
            int compareTo = m7010a(i).compareTo(c0803e.m7010a(i));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (f_ < f_2) {
            return -1;
        }
        return f_ > f_2 ? 1 : 0;
    }

    /* compiled from: CatchTable.java */
    /* renamed from: com.b.b.c.b.e$a */
    public static class a implements Comparable<a> {

        /* renamed from: a */
        private final int f4780a;

        /* renamed from: b */
        private final int f4781b;

        /* renamed from: c */
        private final C0802d f4782c;

        public a(int i, int i2, C0802d c0802d) {
            if (i < 0) {
                throw new IllegalArgumentException("start < 0");
            }
            if (i2 <= i) {
                throw new IllegalArgumentException("end <= start");
            }
            if (c0802d.m8593d_()) {
                throw new IllegalArgumentException("handlers.isMutable()");
            }
            this.f4780a = i;
            this.f4781b = i2;
            this.f4782c = c0802d;
        }

        public int hashCode() {
            return (((this.f4780a * 31) + this.f4781b) * 31) + this.f4782c.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && compareTo((a) obj) == 0;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (this.f4780a < aVar.f4780a) {
                return -1;
            }
            if (this.f4780a > aVar.f4780a) {
                return 1;
            }
            if (this.f4781b < aVar.f4781b) {
                return -1;
            }
            if (this.f4781b > aVar.f4781b) {
                return 1;
            }
            return this.f4782c.compareTo(aVar.f4782c);
        }

        /* renamed from: a */
        public int m7012a() {
            return this.f4780a;
        }

        /* renamed from: b */
        public int m7014b() {
            return this.f4781b;
        }

        /* renamed from: c */
        public C0802d m7015c() {
            return this.f4782c;
        }
    }
}
