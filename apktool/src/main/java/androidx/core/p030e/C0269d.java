package androidx.core.p030e;

/* compiled from: Pools.java */
/* renamed from: androidx.core.e.d */
/* loaded from: classes.dex */
public final class C0269d {

    /* compiled from: Pools.java */
    /* renamed from: androidx.core.e.d$a */
    public interface a<T> {
        /* renamed from: a */
        T mo1954a();

        /* renamed from: a */
        boolean mo1955a(T t);
    }

    /* compiled from: Pools.java */
    /* renamed from: androidx.core.e.d$b */
    public static class b<T> implements a<T> {

        /* renamed from: a */
        private final Object[] f2064a;

        /* renamed from: b */
        private int f2065b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2064a = new Object[i];
        }

        @Override // androidx.core.p030e.C0269d.a
        /* renamed from: a */
        public T mo1954a() {
            if (this.f2065b <= 0) {
                return null;
            }
            int i = this.f2065b - 1;
            T t = (T) this.f2064a[i];
            this.f2064a[i] = null;
            this.f2065b--;
            return t;
        }

        @Override // androidx.core.p030e.C0269d.a
        /* renamed from: a */
        public boolean mo1955a(T t) {
            if (m1956b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.f2065b >= this.f2064a.length) {
                return false;
            }
            this.f2064a[this.f2065b] = t;
            this.f2065b++;
            return true;
        }

        /* renamed from: b */
        private boolean m1956b(T t) {
            for (int i = 0; i < this.f2065b; i++) {
                if (this.f2064a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools.java */
    /* renamed from: androidx.core.e.d$c */
    public static class c<T> extends b<T> {

        /* renamed from: a */
        private final Object f2066a;

        public c(int i) {
            super(i);
            this.f2066a = new Object();
        }

        @Override // androidx.core.p030e.C0269d.b, androidx.core.p030e.C0269d.a
        /* renamed from: a */
        public T mo1954a() {
            T t;
            synchronized (this.f2066a) {
                t = (T) super.mo1954a();
            }
            return t;
        }

        @Override // androidx.core.p030e.C0269d.b, androidx.core.p030e.C0269d.a
        /* renamed from: a */
        public boolean mo1955a(T t) {
            boolean mo1955a;
            synchronized (this.f2066a) {
                mo1955a = super.mo1955a(t);
            }
            return mo1955a;
        }
    }
}
