package org.p210a.p211a.p212a.p213a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.p210a.p211a.p212a.AbstractC1877y;
import org.p210a.p211a.p212a.C1878z;
import org.p210a.p211a.p212a.p215c.C1841k;
import org.p210a.p211a.p212a.p215c.C1844n;

/* compiled from: SemanticContext.java */
/* renamed from: org.a.a.a.a.ax */
/* loaded from: classes.dex */
public abstract class AbstractC1783ax {

    /* renamed from: a */
    public static final AbstractC1783ax f10744a = new e();

    /* compiled from: SemanticContext.java */
    /* renamed from: org.a.a.a.a.ax$c */
    public static abstract class c extends AbstractC1783ax {
    }

    /* renamed from: a */
    public abstract boolean mo13582a(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z);

    /* renamed from: b */
    public AbstractC1783ax mo13583b(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
        return this;
    }

    /* compiled from: SemanticContext.java */
    /* renamed from: org.a.a.a.a.ax$e */
    public static class e extends AbstractC1783ax {

        /* renamed from: b */
        public final int f10748b;

        /* renamed from: c */
        public final int f10749c;

        /* renamed from: d */
        public final boolean f10750d;

        protected e() {
            this.f10748b = -1;
            this.f10749c = -1;
            this.f10750d = false;
        }

        public e(int i, int i2, boolean z) {
            this.f10748b = i;
            this.f10749c = i2;
            this.f10750d = z;
        }

        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: a */
        public boolean mo13582a(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            if (!this.f10750d) {
                c1878z = null;
            }
            return abstractC1877y.mo4147a(c1878z, this.f10748b, this.f10749c);
        }

        public int hashCode() {
            return C1841k.m13775b(C1841k.m13772a(C1841k.m13772a(C1841k.m13772a(C1841k.m13770a(), this.f10748b), this.f10749c), this.f10750d ? 1 : 0), 3);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            e eVar = (e) obj;
            return this.f10748b == eVar.f10748b && this.f10749c == eVar.f10749c && this.f10750d == eVar.f10750d;
        }

        public String toString() {
            return "{" + this.f10748b + ":" + this.f10749c + "}?";
        }
    }

    /* compiled from: SemanticContext.java */
    /* renamed from: org.a.a.a.a.ax$d */
    public static class d extends AbstractC1783ax implements Comparable<d> {

        /* renamed from: b */
        public final int f10747b;

        protected d() {
            this.f10747b = 0;
        }

        public d(int i) {
            this.f10747b = i;
        }

        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: a */
        public boolean mo13582a(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            return abstractC1877y.mo13889a(c1878z, this.f10747b);
        }

        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: b */
        public AbstractC1783ax mo13583b(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            if (abstractC1877y.mo13889a(c1878z, this.f10747b)) {
                return AbstractC1783ax.f10744a;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return this.f10747b - dVar.f10747b;
        }

        public int hashCode() {
            return this.f10747b + 31;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this == obj || this.f10747b == ((d) obj).f10747b;
            }
            return false;
        }

        public String toString() {
            return "{" + this.f10747b + ">=prec}?";
        }
    }

    /* compiled from: SemanticContext.java */
    /* renamed from: org.a.a.a.a.ax$a */
    public static class a extends c {

        /* renamed from: b */
        public final AbstractC1783ax[] f10745b;

        public a(AbstractC1783ax abstractC1783ax, AbstractC1783ax abstractC1783ax2) {
            HashSet hashSet = new HashSet();
            if (abstractC1783ax instanceof a) {
                hashSet.addAll(Arrays.asList(((a) abstractC1783ax).f10745b));
            } else {
                hashSet.add(abstractC1783ax);
            }
            if (abstractC1783ax2 instanceof a) {
                hashSet.addAll(Arrays.asList(((a) abstractC1783ax2).f10745b));
            } else {
                hashSet.add(abstractC1783ax2);
            }
            List m13580b = AbstractC1783ax.m13580b(hashSet);
            if (!m13580b.isEmpty()) {
                hashSet.add((d) Collections.min(m13580b));
            }
            this.f10745b = (AbstractC1783ax[]) hashSet.toArray(new AbstractC1783ax[hashSet.size()]);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return Arrays.equals(this.f10745b, ((a) obj).f10745b);
            }
            return false;
        }

        public int hashCode() {
            return C1841k.m13774a(this.f10745b, a.class.hashCode());
        }

        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: a */
        public boolean mo13582a(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            for (AbstractC1783ax abstractC1783ax : this.f10745b) {
                if (!abstractC1783ax.mo13582a(abstractC1877y, c1878z)) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: b */
        public AbstractC1783ax mo13583b(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            ArrayList arrayList = new ArrayList();
            AbstractC1783ax[] abstractC1783axArr = this.f10745b;
            int length = abstractC1783axArr.length;
            boolean z = false;
            for (int i = 0; i < length; i++) {
                AbstractC1783ax abstractC1783ax = abstractC1783axArr[i];
                AbstractC1783ax mo13583b = abstractC1783ax.mo13583b(abstractC1877y, c1878z);
                z |= mo13583b != abstractC1783ax;
                if (mo13583b == null) {
                    return null;
                }
                if (mo13583b != f10744a) {
                    arrayList.add(mo13583b);
                }
            }
            if (z) {
                if (arrayList.isEmpty()) {
                    return f10744a;
                }
                AbstractC1783ax abstractC1783ax2 = (AbstractC1783ax) arrayList.get(0);
                for (int i2 = 1; i2 < arrayList.size(); i2++) {
                    abstractC1783ax2 = AbstractC1783ax.m13579a(abstractC1783ax2, (AbstractC1783ax) arrayList.get(i2));
                }
                return abstractC1783ax2;
            }
            return this;
        }

        public String toString() {
            return C1844n.m13777a(Arrays.asList(this.f10745b).iterator(), "&&");
        }
    }

    /* compiled from: SemanticContext.java */
    /* renamed from: org.a.a.a.a.ax$b */
    public static class b extends c {

        /* renamed from: b */
        public final AbstractC1783ax[] f10746b;

        public b(AbstractC1783ax abstractC1783ax, AbstractC1783ax abstractC1783ax2) {
            HashSet hashSet = new HashSet();
            if (abstractC1783ax instanceof b) {
                hashSet.addAll(Arrays.asList(((b) abstractC1783ax).f10746b));
            } else {
                hashSet.add(abstractC1783ax);
            }
            if (abstractC1783ax2 instanceof b) {
                hashSet.addAll(Arrays.asList(((b) abstractC1783ax2).f10746b));
            } else {
                hashSet.add(abstractC1783ax2);
            }
            List m13580b = AbstractC1783ax.m13580b(hashSet);
            if (!m13580b.isEmpty()) {
                hashSet.add((d) Collections.max(m13580b));
            }
            this.f10746b = (AbstractC1783ax[]) hashSet.toArray(new AbstractC1783ax[hashSet.size()]);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return Arrays.equals(this.f10746b, ((b) obj).f10746b);
            }
            return false;
        }

        public int hashCode() {
            return C1841k.m13774a(this.f10746b, b.class.hashCode());
        }

        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: a */
        public boolean mo13582a(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            for (AbstractC1783ax abstractC1783ax : this.f10746b) {
                if (abstractC1783ax.mo13582a(abstractC1877y, c1878z)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.p210a.p211a.p212a.p213a.AbstractC1783ax
        /* renamed from: b */
        public AbstractC1783ax mo13583b(AbstractC1877y<?, ?> abstractC1877y, C1878z c1878z) {
            int i = 1;
            ArrayList arrayList = new ArrayList();
            AbstractC1783ax[] abstractC1783axArr = this.f10746b;
            int length = abstractC1783axArr.length;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                AbstractC1783ax abstractC1783ax = abstractC1783axArr[i2];
                AbstractC1783ax mo13583b = abstractC1783ax.mo13583b(abstractC1877y, c1878z);
                z |= mo13583b != abstractC1783ax;
                if (mo13583b == f10744a) {
                    return f10744a;
                }
                if (mo13583b != null) {
                    arrayList.add(mo13583b);
                }
            }
            if (z) {
                if (arrayList.isEmpty()) {
                    return null;
                }
                AbstractC1783ax abstractC1783ax2 = (AbstractC1783ax) arrayList.get(0);
                while (true) {
                    AbstractC1783ax abstractC1783ax3 = abstractC1783ax2;
                    if (i >= arrayList.size()) {
                        return abstractC1783ax3;
                    }
                    abstractC1783ax2 = AbstractC1783ax.m13581b(abstractC1783ax3, (AbstractC1783ax) arrayList.get(i));
                    i++;
                }
            } else {
                return this;
            }
        }

        public String toString() {
            return C1844n.m13777a(Arrays.asList(this.f10746b).iterator(), "||");
        }
    }

    /* renamed from: a */
    public static AbstractC1783ax m13579a(AbstractC1783ax abstractC1783ax, AbstractC1783ax abstractC1783ax2) {
        if (abstractC1783ax == null || abstractC1783ax == f10744a) {
            return abstractC1783ax2;
        }
        if (abstractC1783ax2 != null && abstractC1783ax2 != f10744a) {
            a aVar = new a(abstractC1783ax, abstractC1783ax2);
            return aVar.f10745b.length == 1 ? aVar.f10745b[0] : aVar;
        }
        return abstractC1783ax;
    }

    /* renamed from: b */
    public static AbstractC1783ax m13581b(AbstractC1783ax abstractC1783ax, AbstractC1783ax abstractC1783ax2) {
        if (abstractC1783ax != null) {
            if (abstractC1783ax2 == null) {
                return abstractC1783ax;
            }
            if (abstractC1783ax == f10744a || abstractC1783ax2 == f10744a) {
                return f10744a;
            }
            b bVar = new b(abstractC1783ax, abstractC1783ax2);
            return bVar.f10746b.length == 1 ? bVar.f10746b[0] : bVar;
        }
        return abstractC1783ax2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static List<d> m13580b(Collection<? extends AbstractC1783ax> collection) {
        ArrayList arrayList = null;
        Iterator<? extends AbstractC1783ax> it = collection.iterator();
        while (it.hasNext()) {
            AbstractC1783ax next = it.next();
            if (next instanceof d) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((d) next);
                it.remove();
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        return arrayList;
    }
}
