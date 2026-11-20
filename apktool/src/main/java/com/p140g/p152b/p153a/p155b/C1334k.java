package com.p140g.p152b.p153a.p155b;

import com.p140g.p152b.p153a.C1339c;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: StmtList.java */
/* renamed from: com.g.b.a.b.k */
/* loaded from: classes.dex */
public class C1334k implements Iterable<AbstractC1333j>, Comparator<AbstractC1333j> {

    /* renamed from: a */
    private AbstractC1333j f8673a;

    /* renamed from: b */
    private AbstractC1333j f8674b;

    /* renamed from: c */
    private int f8675c = 1;

    /* renamed from: d */
    private int f8676d = 0;

    @Override // java.util.Comparator
    public int compare(AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        return m10573a(abstractC1333j, abstractC1333j2);
    }

    /* compiled from: StmtList.java */
    /* renamed from: com.g.b.a.b.k$a */
    private static class a implements Iterator<AbstractC1333j> {

        /* renamed from: a */
        private AbstractC1333j f8677a;

        /* renamed from: b */
        private AbstractC1333j f8678b;

        /* renamed from: c */
        private final C1334k f8679c;

        @Override // java.util.Iterator
        public AbstractC1333j next() {
            return m10585a();
        }

        public a(C1334k c1334k, AbstractC1333j abstractC1333j) {
            this.f8679c = c1334k;
            this.f8678b = abstractC1333j;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8678b != null;
        }

        /* renamed from: a */
        public AbstractC1333j m10585a() {
            AbstractC1333j abstractC1333j = this.f8678b;
            this.f8677a = abstractC1333j;
            if (abstractC1333j != null) {
                this.f8678b = abstractC1333j.f8648l;
            } else {
                this.f8678b = (AbstractC1333j) null;
            }
            return abstractC1333j;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f8677a != null) {
                this.f8679c.m10583d(this.f8677a);
                this.f8677a = (AbstractC1333j) null;
            }
        }
    }

    /* renamed from: a */
    public void m10576a(AbstractC1333j abstractC1333j) {
        m10581c(abstractC1333j);
    }

    /* renamed from: a */
    public void m10577a(Collection<AbstractC1333j> collection) {
        Iterator<AbstractC1333j> it = collection.iterator();
        while (it.hasNext()) {
            m10581c(it.next());
        }
    }

    /* renamed from: a */
    public C1334k m10575a(C1339c c1339c) {
        C1334k c1334k = new C1334k();
        Iterator<AbstractC1333j> it = iterator();
        while (it.hasNext()) {
            c1334k.m10576a(it.next().mo10554a(c1339c));
        }
        return c1334k;
    }

    /* renamed from: a */
    public int m10573a(AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        return abstractC1333j.f8646j - abstractC1333j2.f8646j;
    }

    /* renamed from: b */
    public boolean m10580b(AbstractC1333j abstractC1333j) {
        return abstractC1333j.f8647k == this;
    }

    /* renamed from: a */
    public AbstractC1333j m10574a() {
        return this.f8673a;
    }

    /* renamed from: b */
    public int m10578b() {
        return this.f8676d;
    }

    /* renamed from: e */
    private void m10572e(AbstractC1333j abstractC1333j) {
        if (abstractC1333j.f8646j <= 0) {
            abstractC1333j.f8646j = this.f8675c;
            this.f8675c++;
        }
    }

    /* renamed from: b */
    public void m10579b(AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        if (abstractC1333j.f8647k == this) {
            m10572e(abstractC1333j2);
            abstractC1333j2.f8647k = this;
            this.f8676d++;
            abstractC1333j2.f8648l = abstractC1333j.f8648l;
            abstractC1333j2.f8649m = abstractC1333j;
            if (abstractC1333j.f8648l == null) {
                this.f8674b = abstractC1333j2;
            } else {
                abstractC1333j.f8648l.f8649m = abstractC1333j2;
            }
            abstractC1333j.f8648l = abstractC1333j2;
        }
    }

    /* renamed from: c */
    public void m10582c(AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        if (abstractC1333j.f8647k == this) {
            m10572e(abstractC1333j2);
            abstractC1333j2.f8647k = this;
            this.f8676d++;
            abstractC1333j2.f8649m = abstractC1333j.f8649m;
            abstractC1333j2.f8648l = abstractC1333j;
            if (abstractC1333j.f8649m == null) {
                this.f8673a = abstractC1333j2;
            } else {
                abstractC1333j.f8649m.f8648l = abstractC1333j2;
            }
            abstractC1333j.f8649m = abstractC1333j2;
        }
    }

    /* renamed from: c */
    public void m10581c(AbstractC1333j abstractC1333j) {
        m10572e(abstractC1333j);
        abstractC1333j.f8647k = this;
        this.f8676d++;
        if (this.f8673a == null) {
            this.f8674b = abstractC1333j;
            this.f8673a = abstractC1333j;
            AbstractC1333j abstractC1333j2 = (AbstractC1333j) null;
            abstractC1333j.f8648l = abstractC1333j2;
            abstractC1333j.f8649m = abstractC1333j2;
            return;
        }
        abstractC1333j.f8648l = (AbstractC1333j) null;
        abstractC1333j.f8649m = this.f8674b;
        this.f8674b.f8648l = abstractC1333j;
        this.f8674b = abstractC1333j;
    }

    @Override // java.lang.Iterable
    public Iterator<AbstractC1333j> iterator() {
        return new a(this, this.f8673a);
    }

    /* renamed from: d */
    public void m10583d(AbstractC1333j abstractC1333j) {
        if (abstractC1333j.f8647k == this) {
            this.f8676d--;
            abstractC1333j.f8647k = (C1334k) null;
            if (abstractC1333j.f8649m == null) {
                this.f8673a = abstractC1333j.f8648l;
            } else {
                abstractC1333j.f8649m.f8648l = abstractC1333j.f8648l;
            }
            if (abstractC1333j.f8648l == null) {
                this.f8674b = abstractC1333j.f8649m;
            } else {
                abstractC1333j.f8648l.f8649m = abstractC1333j.f8649m;
            }
            abstractC1333j.f8649m = (AbstractC1333j) null;
            abstractC1333j.f8648l = (AbstractC1333j) null;
        }
    }

    /* renamed from: d */
    public void m10584d(AbstractC1333j abstractC1333j, AbstractC1333j abstractC1333j2) {
        if (abstractC1333j.f8647k == this) {
            m10572e(abstractC1333j2);
            abstractC1333j2.f8647k = this;
            abstractC1333j2.f8648l = abstractC1333j.f8648l;
            abstractC1333j2.f8649m = abstractC1333j.f8649m;
            if (abstractC1333j.f8648l != null) {
                abstractC1333j.f8648l.f8649m = abstractC1333j2;
            } else {
                this.f8674b = abstractC1333j2;
            }
            if (abstractC1333j.f8649m != null) {
                abstractC1333j.f8649m.f8648l = abstractC1333j2;
            } else {
                this.f8673a = abstractC1333j2;
            }
            abstractC1333j.f8648l = (AbstractC1333j) null;
            abstractC1333j.f8649m = (AbstractC1333j) null;
            abstractC1333j.f8647k = (C1334k) null;
        }
    }

    public String toString() {
        if (this.f8676d == 0) {
            return "[Empty]";
        }
        StringBuilder sb = new StringBuilder();
        for (AbstractC1333j abstractC1333j : this) {
            if (abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
                sb.append("\n");
            }
            sb.append(abstractC1333j).append("\n");
        }
        return sb.toString();
    }
}
