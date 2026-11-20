package org.p210a.p211a.p212a.p213a;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p210a.p211a.p212a.p215c.AbstractC1831a;
import org.p210a.p211a.p212a.p215c.C1832b;
import org.p210a.p211a.p212a.p215c.C1833c;

/* compiled from: ATNConfigSet.java */
/* renamed from: org.a.a.a.a.c */
/* loaded from: classes.dex */
public class C1793c implements Set<C1786b> {

    /* renamed from: a */
    protected boolean f10765a;

    /* renamed from: b */
    public a f10766b;

    /* renamed from: c */
    public final ArrayList<C1786b> f10767c;

    /* renamed from: d */
    public int f10768d;

    /* renamed from: e */
    protected BitSet f10769e;

    /* renamed from: f */
    public boolean f10770f;

    /* renamed from: g */
    public boolean f10771g;

    /* renamed from: h */
    public final boolean f10772h;

    /* renamed from: i */
    private int f10773i;

    /* compiled from: ATNConfigSet.java */
    /* renamed from: org.a.a.a.a.c$c */
    public static class c extends a {
        public c() {
            super(b.f10774a);
        }
    }

    /* compiled from: ATNConfigSet.java */
    /* renamed from: org.a.a.a.a.c$b */
    public static final class b extends AbstractC1831a<C1786b> {

        /* renamed from: a */
        public static final b f10774a = new b();

        private b() {
        }

        @Override // org.p210a.p211a.p212a.p215c.InterfaceC1834d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int mo13573a(C1786b c1786b) {
            return ((((c1786b.f10755a.f10798c + 217) * 31) + c1786b.f10756b) * 31) + c1786b.f10759e.hashCode();
        }

        @Override // org.p210a.p211a.p212a.p215c.InterfaceC1834d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo13575a(C1786b c1786b, C1786b c1786b2) {
            if (c1786b == c1786b2) {
                return true;
            }
            if (c1786b == null || c1786b2 == null) {
                return false;
            }
            return c1786b.f10755a.f10798c == c1786b2.f10755a.f10798c && c1786b.f10756b == c1786b2.f10756b && c1786b.f10759e.equals(c1786b2.f10759e);
        }
    }

    public C1793c(boolean z) {
        this.f10765a = false;
        this.f10767c = new ArrayList<>(7);
        this.f10773i = -1;
        this.f10766b = new c();
        this.f10772h = z;
    }

    public C1793c() {
        this(true);
    }

    @Override // java.util.Set
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(C1786b c1786b) {
        return m13595a(c1786b, null);
    }

    /* renamed from: a */
    public boolean m13595a(C1786b c1786b, C1833c<AbstractC1776aq, AbstractC1776aq, AbstractC1776aq> c1833c) {
        if (this.f10765a) {
            throw new IllegalStateException("This set is readonly");
        }
        if (c1786b.f10759e != AbstractC1783ax.f10744a) {
            this.f10770f = true;
        }
        if (c1786b.m13586a() > 0) {
            this.f10771g = true;
        }
        C1786b c2 = this.f10766b.m13722c((a) c1786b);
        if (c2 == c1786b) {
            this.f10773i = -1;
            this.f10767c.add(c1786b);
        } else {
            AbstractC1776aq m13546a = AbstractC1776aq.m13546a(c2.f10757c, c1786b.f10757c, !this.f10772h, c1833c);
            c2.f10758d = Math.max(c2.f10758d, c1786b.f10758d);
            if (c1786b.m13590b()) {
                c2.m13588a(true);
            }
            c2.f10757c = m13546a;
        }
        return true;
    }

    /* renamed from: a */
    public List<C1786b> m13591a() {
        return this.f10767c;
    }

    /* renamed from: b */
    public BitSet m13596b() {
        BitSet bitSet = new BitSet();
        Iterator<C1786b> it = this.f10767c.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().f10756b);
        }
        return bitSet;
    }

    /* renamed from: a */
    public void m13592a(AbstractC1796f abstractC1796f) {
        if (this.f10765a) {
            throw new IllegalStateException("This set is readonly");
        }
        if (!this.f10766b.isEmpty()) {
            Iterator<C1786b> it = this.f10767c.iterator();
            while (it.hasNext()) {
                C1786b next = it.next();
                next.f10757c = abstractC1796f.m13629a(next.f10757c);
            }
        }
    }

    @Override // java.util.Set
    public boolean addAll(Collection<? extends C1786b> collection) {
        Iterator<? extends C1786b> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return false;
    }

    @Override // java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1793c)) {
            return false;
        }
        C1793c c1793c = (C1793c) obj;
        return this.f10767c != null && this.f10767c.equals(c1793c.f10767c) && this.f10772h == c1793c.f10772h && this.f10768d == c1793c.f10768d && this.f10769e == c1793c.f10769e && this.f10770f == c1793c.f10770f && this.f10771g == c1793c.f10771g;
    }

    @Override // java.util.Set
    public int hashCode() {
        if (!m13597c()) {
            return this.f10767c.hashCode();
        }
        if (this.f10773i == -1) {
            this.f10773i = this.f10767c.hashCode();
        }
        return this.f10773i;
    }

    @Override // java.util.Set
    public int size() {
        return this.f10767c.size();
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        return this.f10767c.isEmpty();
    }

    @Override // java.util.Set
    public boolean contains(Object obj) {
        if (this.f10766b == null) {
            throw new UnsupportedOperationException("This method is not implemented for readonly sets.");
        }
        return this.f10766b.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<C1786b> iterator() {
        return this.f10767c.iterator();
    }

    @Override // java.util.Set
    public void clear() {
        if (this.f10765a) {
            throw new IllegalStateException("This set is readonly");
        }
        this.f10767c.clear();
        this.f10773i = -1;
        this.f10766b.clear();
    }

    /* renamed from: c */
    public boolean m13597c() {
        return this.f10765a;
    }

    /* renamed from: a */
    public void m13593a(boolean z) {
        this.f10765a = z;
        this.f10766b = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m13591a().toString());
        if (this.f10770f) {
            sb.append(",hasSemanticContext=").append(this.f10770f);
        }
        if (this.f10768d != 0) {
            sb.append(",uniqueAlt=").append(this.f10768d);
        }
        if (this.f10769e != null) {
            sb.append(",conflictingAlts=").append(this.f10769e);
        }
        if (this.f10771g) {
            sb.append(",dipsIntoOuterContext");
        }
        return sb.toString();
    }

    @Override // java.util.Set
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C1786b[] toArray() {
        return this.f10766b.toArray();
    }

    @Override // java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f10766b.toArray(tArr);
    }

    @Override // java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    /* compiled from: ATNConfigSet.java */
    /* renamed from: org.a.a.a.a.c$a */
    public static abstract class a extends C1832b<C1786b> {
        public a(AbstractC1831a<? super C1786b> abstractC1831a) {
            this(abstractC1831a, 16, 2);
        }

        public a(AbstractC1831a<? super C1786b> abstractC1831a, int i, int i2) {
            super(abstractC1831a, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p210a.p211a.p212a.p215c.C1832b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C1786b mo13601b(Object obj) {
            if (obj instanceof C1786b) {
                return (C1786b) obj;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p210a.p211a.p212a.p215c.C1832b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C1786b[][] mo13604d(int i) {
            return new C1786b[i][];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p210a.p211a.p212a.p215c.C1832b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final C1786b[] mo13603c(int i) {
            return new C1786b[i];
        }
    }
}
