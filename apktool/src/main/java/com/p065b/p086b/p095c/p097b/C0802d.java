package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1021l;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: CatchHandlerList.java */
/* renamed from: com.b.b.c.b.d */
/* loaded from: classes.dex */
public final class C0802d extends C1021l implements Comparable<C0802d> {

    /* renamed from: a */
    public static final C0802d f4776a = new C0802d(0);

    public C0802d(int i) {
        super(i);
    }

    /* renamed from: a */
    public a m7002a(int i) {
        return (a) m8548e(i);
    }

    @Override // com.p065b.p086b.p110h.C1021l, com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return m7003a("", "");
    }

    /* renamed from: a */
    public String m7003a(String str, String str2) {
        StringBuilder sb = new StringBuilder(100);
        int f_ = m8550f_();
        sb.append(str);
        sb.append(str2);
        sb.append("catch ");
        for (int i = 0; i < f_; i++) {
            a m7002a = m7002a(i);
            if (i != 0) {
                sb.append(",\n");
                sb.append(str);
                sb.append("  ");
            }
            if (i == f_ - 1 && m7005e()) {
                sb.append("<any>");
            } else {
                sb.append(m7002a.m7007a().mo6681d());
            }
            sb.append(" -> ");
            sb.append(C1022m.m8558d(m7002a.m7008b()));
        }
        return sb.toString();
    }

    /* renamed from: e */
    public boolean m7005e() {
        int f_ = m8550f_();
        if (f_ == 0) {
            return false;
        }
        return m7002a(f_ - 1).m7007a().equals(C0971y.f6172a);
    }

    /* renamed from: a */
    public void m7004a(int i, C0971y c0971y, int i2) {
        m8546a(i, new a(c0971y, i2));
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0802d c0802d) {
        if (this == c0802d) {
            return 0;
        }
        int f_ = m8550f_();
        int f_2 = c0802d.m8550f_();
        int min = Math.min(f_, f_2);
        for (int i = 0; i < min; i++) {
            int compareTo = m7002a(i).compareTo(c0802d.m7002a(i));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (f_ < f_2) {
            return -1;
        }
        return f_ > f_2 ? 1 : 0;
    }

    /* compiled from: CatchHandlerList.java */
    /* renamed from: com.b.b.c.b.d$a */
    public static class a implements Comparable<a> {

        /* renamed from: a */
        private final C0971y f4777a;

        /* renamed from: b */
        private final int f4778b;

        public a(C0971y c0971y, int i) {
            if (i < 0) {
                throw new IllegalArgumentException("handler < 0");
            }
            if (c0971y == null) {
                throw new NullPointerException("exceptionType == null");
            }
            this.f4778b = i;
            this.f4777a = c0971y;
        }

        public int hashCode() {
            return (this.f4778b * 31) + this.f4777a.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && compareTo((a) obj) == 0;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            if (this.f4778b < aVar.f4778b) {
                return -1;
            }
            if (this.f4778b > aVar.f4778b) {
                return 1;
            }
            return this.f4777a.compareTo(aVar.f4777a);
        }

        /* renamed from: a */
        public C0971y m7007a() {
            return this.f4777a;
        }

        /* renamed from: b */
        public int m7008b() {
            return this.f4778b;
        }
    }
}
