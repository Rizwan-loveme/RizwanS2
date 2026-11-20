package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import java.lang.Comparable;
import java.p209io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Range.java */
/* renamed from: com.f.a.c.as */
/* loaded from: classes.dex */
public final class C1166as<C extends Comparable> extends AbstractC1167at implements InterfaceC1121p<C>, Serializable {

    /* renamed from: c */
    private static final C1166as<Comparable> f7827c = new C1166as<>(AbstractC1202q.m10098a(), AbstractC1202q.m10099b());

    /* renamed from: a */
    final AbstractC1202q<C> f7828a;

    /* renamed from: b */
    final AbstractC1202q<C> f7829b;

    /* compiled from: Range.java */
    /* renamed from: com.f.a.c.as$a */
    static class a implements InterfaceC1112g<C1166as, AbstractC1202q> {

        /* renamed from: a */
        static final a f7830a = new a();

        a() {
        }

        @Override // com.p129f.p130a.p131a.InterfaceC1112g
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public AbstractC1202q mo9517a(C1166as c1166as) {
            return c1166as.f7828a;
        }
    }

    /* renamed from: a */
    static <C extends Comparable<?>> InterfaceC1112g<C1166as<C>, AbstractC1202q<C>> m9966a() {
        return a.f7830a;
    }

    /* renamed from: b */
    static <C extends Comparable<?>> AbstractC1163ap<C1166as<C>> m9970b() {
        return (AbstractC1163ap<C1166as<C>>) b.f7831a;
    }

    /* renamed from: a */
    static <C extends Comparable<?>> C1166as<C> m9967a(AbstractC1202q<C> abstractC1202q, AbstractC1202q<C> abstractC1202q2) {
        return new C1166as<>(abstractC1202q, abstractC1202q2);
    }

    /* renamed from: a */
    public static <C extends Comparable<?>> C1166as<C> m9969a(C c2, C c3) {
        return m9967a(AbstractC1202q.m10100b(c2), AbstractC1202q.m10101c(c3));
    }

    /* renamed from: b */
    public static <C extends Comparable<?>> C1166as<C> m9972b(C c2, C c3) {
        return m9967a(AbstractC1202q.m10101c(c2), AbstractC1202q.m10101c(c3));
    }

    /* renamed from: a */
    public static <C extends Comparable<?>> C1166as<C> m9968a(C c2) {
        return m9967a(AbstractC1202q.m10098a(), AbstractC1202q.m10101c(c2));
    }

    /* renamed from: b */
    public static <C extends Comparable<?>> C1166as<C> m9971b(C c2) {
        return m9967a(AbstractC1202q.m10100b(c2), AbstractC1202q.m10099b());
    }

    /* renamed from: c */
    public static <C extends Comparable<?>> C1166as<C> m9975c() {
        return (C1166as<C>) f7827c;
    }

    private C1166as(AbstractC1202q<C> abstractC1202q, AbstractC1202q<C> abstractC1202q2) {
        this.f7828a = (AbstractC1202q) C1120o.m9547a(abstractC1202q);
        this.f7829b = (AbstractC1202q) C1120o.m9547a(abstractC1202q2);
        if (abstractC1202q.compareTo((AbstractC1202q) abstractC1202q2) > 0 || abstractC1202q == AbstractC1202q.m10099b() || abstractC1202q2 == AbstractC1202q.m10098a()) {
            throw new IllegalArgumentException("Invalid range: " + m9973b((AbstractC1202q<?>) abstractC1202q, (AbstractC1202q<?>) abstractC1202q2));
        }
    }

    /* renamed from: d */
    public boolean m9979d() {
        return this.f7828a.equals(this.f7829b);
    }

    /* renamed from: c */
    public boolean m9978c(C c2) {
        C1120o.m9547a(c2);
        return this.f7828a.mo10104a((AbstractC1202q<C>) c2) && !this.f7829b.mo10104a((AbstractC1202q<C>) c2);
    }

    @Override // com.p129f.p130a.p131a.InterfaceC1121p
    @Deprecated
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9509a(C c2) {
        return m9978c(c2);
    }

    /* renamed from: a */
    public boolean m9976a(C1166as<C> c1166as) {
        return this.f7828a.compareTo((AbstractC1202q) c1166as.f7829b) <= 0 && c1166as.f7828a.compareTo((AbstractC1202q) this.f7829b) <= 0;
    }

    /* renamed from: b */
    public C1166as<C> m9977b(C1166as<C> c1166as) {
        int compareTo = this.f7828a.compareTo((AbstractC1202q) c1166as.f7828a);
        int compareTo2 = this.f7829b.compareTo((AbstractC1202q) c1166as.f7829b);
        if (compareTo < 0 || compareTo2 > 0) {
            if (compareTo > 0 || compareTo2 < 0) {
                return m9967a((AbstractC1202q) (compareTo >= 0 ? this.f7828a : c1166as.f7828a), (AbstractC1202q) (compareTo2 <= 0 ? this.f7829b : c1166as.f7829b));
            }
            return c1166as;
        }
        return this;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof C1166as)) {
            return false;
        }
        C1166as c1166as = (C1166as) obj;
        return this.f7828a.equals(c1166as.f7828a) && this.f7829b.equals(c1166as.f7829b);
    }

    public int hashCode() {
        return (this.f7828a.hashCode() * 31) + this.f7829b.hashCode();
    }

    public String toString() {
        return m9973b((AbstractC1202q<?>) this.f7828a, (AbstractC1202q<?>) this.f7829b);
    }

    /* renamed from: b */
    private static String m9973b(AbstractC1202q<?> abstractC1202q, AbstractC1202q<?> abstractC1202q2) {
        StringBuilder sb = new StringBuilder(16);
        abstractC1202q.mo10103a(sb);
        sb.append("..");
        abstractC1202q2.mo10105b(sb);
        return sb.toString();
    }

    /* renamed from: c */
    static int m9974c(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* compiled from: Range.java */
    /* renamed from: com.f.a.c.as$b */
    private static class b extends AbstractC1163ap<C1166as<?>> implements Serializable {

        /* renamed from: a */
        static final AbstractC1163ap<C1166as<?>> f7831a = new b();

        private b() {
        }

        @Override // com.p129f.p130a.p133c.AbstractC1163ap, java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1166as<?> c1166as, C1166as<?> c1166as2) {
            return AbstractC1201p.m10091a().mo10095a(c1166as.f7828a, c1166as2.f7828a).mo10095a(c1166as.f7829b, c1166as2.f7829b).mo10096b();
        }
    }
}
