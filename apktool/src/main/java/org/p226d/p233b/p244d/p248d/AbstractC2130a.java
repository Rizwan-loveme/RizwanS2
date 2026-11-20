package org.p226d.p233b.p244d.p248d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p244d.C2120c;
import org.p226d.p233b.p244d.C2153g;

/* compiled from: AnnotationsDirectory.java */
/* renamed from: org.d.b.d.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC2130a {

    /* renamed from: a */
    public static final AbstractC2130a f11868a = new AbstractC2130a() { // from class: org.d.b.d.d.a.1
        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: a */
        public Set<? extends C2120c> mo14697a() {
            return AbstractC1148aa.m9802i();
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: b */
        public a mo14698b() {
            return a.f11875a;
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: c */
        public a mo14699c() {
            return a.f11875a;
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: d */
        public a mo14700d() {
            return a.f11875a;
        }
    };

    /* compiled from: AnnotationsDirectory.java */
    /* renamed from: org.d.b.d.d.a$a */
    public interface a {

        /* renamed from: a */
        public static final a f11875a = new a() { // from class: org.d.b.d.d.a.a.1
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a.a
            /* renamed from: a */
            public int mo14704a(int i) {
                return 0;
            }
        };

        /* renamed from: a */
        int mo14704a(int i);
    }

    /* renamed from: a */
    public abstract Set<? extends C2120c> mo14697a();

    /* renamed from: b */
    public abstract a mo14698b();

    /* renamed from: c */
    public abstract a mo14699c();

    /* renamed from: d */
    public abstract a mo14700d();

    /* renamed from: a */
    public static AbstractC2130a m14694a(C2153g c2153g, int i) {
        return i == 0 ? f11868a : new b(c2153g, i);
    }

    /* renamed from: b */
    public static Set<? extends C2120c> m14695b(final C2153g c2153g, final int i) {
        if (i == 0) {
            return AbstractC1148aa.m9802i();
        }
        final int a2 = c2153g.m14615a(i);
        return new AbstractC2134e<C2120c>() { // from class: org.d.b.d.d.a.2
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2134e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C2120c mo14702b(int i2) {
                return new C2120c(C2153g.this, C2153g.this.m14615a(i + 4 + (i2 * 4)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a2;
            }
        };
    }

    /* renamed from: c */
    public static List<Set<? extends C2120c>> m14696c(final C2153g c2153g, final int i) {
        if (i <= 0) {
            return AbstractC1208w.m10138g();
        }
        final int a2 = c2153g.m14615a(i);
        return new AbstractC2133d<Set<? extends C2120c>>() { // from class: org.d.b.d.d.a.3
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Set<? extends C2120c> mo14625b(int i2) {
                return AbstractC2130a.m14695b(C2153g.this, C2153g.this.m14615a(i + 4 + (i2 * 4)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a2;
            }
        };
    }

    /* compiled from: AnnotationsDirectory.java */
    /* renamed from: org.d.b.d.d.a$b */
    private static class b extends AbstractC2130a {

        /* renamed from: b */
        public final C2153g f11876b;

        /* renamed from: c */
        private final int f11877c;

        public b(C2153g c2153g, int i) {
            this.f11876b = c2153g;
            this.f11877c = i;
        }

        /* renamed from: e */
        public int m14705e() {
            return this.f11876b.m14615a(this.f11877c + 4);
        }

        /* renamed from: f */
        public int m14706f() {
            return this.f11876b.m14615a(this.f11877c + 8);
        }

        /* renamed from: g */
        public int m14707g() {
            return this.f11876b.m14615a(this.f11877c + 12);
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: a */
        public Set<? extends C2120c> mo14697a() {
            return m14695b(this.f11876b, this.f11876b.m14615a(this.f11877c));
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: b */
        public a mo14698b() {
            int m14705e = m14705e();
            return m14705e == 0 ? a.f11875a : new a(this.f11877c + 16, m14705e);
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: c */
        public a mo14699c() {
            int m14706f = m14706f();
            if (m14706f == 0) {
                return a.f11875a;
            }
            return new a(this.f11877c + 16 + (m14705e() * 8), m14706f);
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a
        /* renamed from: d */
        public a mo14700d() {
            int m14707g = m14707g();
            if (m14707g == 0) {
                return a.f11875a;
            }
            int m14705e = m14705e();
            int i = m14705e * 8;
            return new a((m14706f() * 8) + i + this.f11877c + 16, m14707g);
        }

        /* compiled from: AnnotationsDirectory.java */
        /* renamed from: org.d.b.d.d.a$b$a */
        private class a implements a {

            /* renamed from: c */
            private final int f11879c;

            /* renamed from: d */
            private final int f11880d;

            /* renamed from: e */
            private int f11881e = 0;

            /* renamed from: f */
            private int f11882f;

            public a(int i, int i2) {
                this.f11879c = i;
                this.f11880d = i2;
                this.f11882f = b.this.f11876b.m14615a(i);
            }

            @Override // org.p226d.p233b.p244d.p248d.AbstractC2130a.a
            /* renamed from: a */
            public int mo14704a(int i) {
                while (this.f11882f < i && this.f11881e + 1 < this.f11880d) {
                    this.f11881e++;
                    this.f11882f = b.this.f11876b.m14615a(this.f11879c + (this.f11881e * 8));
                }
                if (this.f11882f == i) {
                    return b.this.f11876b.m14615a(this.f11879c + (this.f11881e * 8) + 4);
                }
                return 0;
            }
        }
    }
}
