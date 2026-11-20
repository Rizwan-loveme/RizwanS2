package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p137g.C1217a;
import java.lang.Comparable;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Cut.java */
/* renamed from: com.f.a.c.q */
/* loaded from: classes.dex */
abstract class AbstractC1202q<C extends Comparable> implements Serializable, Comparable<AbstractC1202q<C>> {

    /* renamed from: a */
    @NullableDecl
    final C f7945a;

    /* renamed from: a */
    abstract void mo10103a(StringBuilder sb);

    /* renamed from: a */
    abstract boolean mo10104a(C c2);

    /* renamed from: b */
    abstract void mo10105b(StringBuilder sb);

    public abstract int hashCode();

    AbstractC1202q(@NullableDecl C c2) {
        this.f7945a = c2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AbstractC1202q<C> abstractC1202q) {
        if (abstractC1202q == m10098a()) {
            return 1;
        }
        if (abstractC1202q == m10099b()) {
            return -1;
        }
        int m9974c = C1166as.m9974c(this.f7945a, abstractC1202q.f7945a);
        return m9974c == 0 ? C1217a.m10170a(this instanceof b, abstractC1202q instanceof b) : m9974c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractC1202q)) {
            return false;
        }
        try {
            return compareTo((AbstractC1202q) obj) == 0;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    /* renamed from: a */
    static <C extends Comparable> AbstractC1202q<C> m10098a() {
        return c.f7947b;
    }

    /* compiled from: Cut.java */
    /* renamed from: com.f.a.c.q$c */
    private static final class c extends AbstractC1202q<Comparable<?>> {

        /* renamed from: b */
        private static final c f7947b = new c();

        private c() {
            super(null);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        boolean mo10104a(Comparable<?> comparable) {
            return true;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        void mo10103a(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: b */
        void mo10105b(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q, java.lang.Comparable
        /* renamed from: a */
        public int compareTo(AbstractC1202q<Comparable<?>> abstractC1202q) {
            return abstractC1202q == this ? 0 : -1;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "-∞";
        }
    }

    /* renamed from: b */
    static <C extends Comparable> AbstractC1202q<C> m10099b() {
        return a.f7946b;
    }

    /* compiled from: Cut.java */
    /* renamed from: com.f.a.c.q$a */
    private static final class a extends AbstractC1202q<Comparable<?>> {

        /* renamed from: b */
        private static final a f7946b = new a();

        private a() {
            super(null);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        boolean mo10104a(Comparable<?> comparable) {
            return false;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        void mo10103a(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: b */
        void mo10105b(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q, java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(AbstractC1202q<Comparable<?>> abstractC1202q) {
            return abstractC1202q == this ? 0 : 1;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "+∞";
        }
    }

    /* renamed from: b */
    static <C extends Comparable> AbstractC1202q<C> m10100b(C c2) {
        return new d(c2);
    }

    /* compiled from: Cut.java */
    /* renamed from: com.f.a.c.q$d */
    private static final class d<C extends Comparable> extends AbstractC1202q<C> {
        @Override // com.p129f.p130a.p133c.AbstractC1202q, java.lang.Comparable
        public /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((AbstractC1202q) obj);
        }

        d(C c2) {
            super((Comparable) C1120o.m9547a(c2));
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        boolean mo10104a(C c2) {
            return C1166as.m9974c(this.f7945a, c2) <= 0;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        void mo10103a(StringBuilder sb) {
            sb.append('[').append(this.f7945a);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: b */
        void mo10105b(StringBuilder sb) {
            sb.append(this.f7945a).append(')');
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        public int hashCode() {
            return this.f7945a.hashCode();
        }

        public String toString() {
            return "\\" + this.f7945a + "/";
        }
    }

    /* renamed from: c */
    static <C extends Comparable> AbstractC1202q<C> m10101c(C c2) {
        return new b(c2);
    }

    /* compiled from: Cut.java */
    /* renamed from: com.f.a.c.q$b */
    private static final class b<C extends Comparable> extends AbstractC1202q<C> {
        @Override // com.p129f.p130a.p133c.AbstractC1202q, java.lang.Comparable
        public /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((AbstractC1202q) obj);
        }

        b(C c2) {
            super((Comparable) C1120o.m9547a(c2));
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        boolean mo10104a(C c2) {
            return C1166as.m9974c(this.f7945a, c2) < 0;
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: a */
        void mo10103a(StringBuilder sb) {
            sb.append('(').append(this.f7945a);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        /* renamed from: b */
        void mo10105b(StringBuilder sb) {
            sb.append(this.f7945a).append(']');
        }

        @Override // com.p129f.p130a.p133c.AbstractC1202q
        public int hashCode() {
            return this.f7945a.hashCode() ^ (-1);
        }

        public String toString() {
            return "/" + this.f7945a + "\\";
        }
    }
}
