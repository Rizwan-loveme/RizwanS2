package org.p226d.p233b.p241c;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p241c.AbstractC2067g;

/* compiled from: LocatedItems.java */
/* renamed from: org.d.b.c.j */
/* loaded from: classes.dex */
public abstract class AbstractC2070j<T extends AbstractC2067g> {

    /* renamed from: a */
    private List<T> f11730a = null;

    /* renamed from: a */
    protected abstract String mo14521a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public List<T> m14525b() {
        return this.f11730a == null ? AbstractC1208w.m10138g() : this.f11730a;
    }

    /* renamed from: a */
    public Set<T> m14526a(final C2073m c2073m) {
        return new AbstractSet<T>() { // from class: org.d.b.c.j.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<T> iterator() {
                final Iterator it = AbstractC2070j.this.m14525b().iterator();
                return (Iterator<T>) new Iterator<T>() { // from class: org.d.b.c.j.1.1

                    /* renamed from: c */
                    private T f11735c = null;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public T next() {
                        this.f11735c = (T) it.next();
                        return this.f11735c;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        if (this.f11735c != null) {
                            this.f11735c.m14517a(null);
                        }
                        it.remove();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractC2070j.this.m14525b().size();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean add(T t) {
                if (t.m14518d()) {
                    throw new IllegalArgumentException(AbstractC2070j.this.mo14521a());
                }
                t.m14517a(c2073m);
                AbstractC2070j.this.m14523a((AbstractC2070j) t);
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14523a(T t) {
        if (this.f11730a == null) {
            this.f11730a = new ArrayList(1);
        }
        this.f11730a.add(t);
    }

    /* renamed from: a */
    public void m14527a(C2073m c2073m, AbstractC2070j<T> abstractC2070j) {
        if (abstractC2070j != this && this.f11730a != null) {
            Iterator<T> it = this.f11730a.iterator();
            while (it.hasNext()) {
                it.next().m14517a(c2073m);
            }
            List<T> list = this.f11730a;
            list.addAll(abstractC2070j.m14525b());
            abstractC2070j.f11730a = list;
            this.f11730a = null;
        }
    }
}
