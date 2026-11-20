package org.p226d.p269d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1151ad;
import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: ImmutableConverter.java */
/* renamed from: org.d.d.i */
/* loaded from: classes.dex */
public abstract class AbstractC2455i<ImmutableItem, Item> {
    /* renamed from: a */
    protected abstract ImmutableItem mo14889a(Item item);

    /* renamed from: b */
    protected abstract boolean mo14890b(Item item);

    /* renamed from: a */
    public AbstractC1208w<ImmutableItem> m15525a(Iterable<? extends Item> iterable) {
        boolean z = true;
        if (iterable == null) {
            return AbstractC1208w.m10138g();
        }
        if (iterable instanceof AbstractC1208w) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (!mo14890b((AbstractC2455i<ImmutableItem, Item>) it.next())) {
                    break;
                }
            }
        }
        if (!z) {
            return (AbstractC1208w) iterable;
        }
        final Iterator<? extends Item> it2 = iterable.iterator();
        return AbstractC1208w.m10134a((Iterator) new Iterator<ImmutableItem>() { // from class: org.d.d.i.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) AbstractC2455i.this.mo14889a((AbstractC2455i) it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        });
    }

    /* renamed from: b */
    public AbstractC1148aa<ImmutableItem> m15526b(Iterable<? extends Item> iterable) {
        boolean z = true;
        if (iterable == null) {
            return AbstractC1148aa.m9802i();
        }
        if (iterable instanceof AbstractC1148aa) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (!mo14890b((AbstractC2455i<ImmutableItem, Item>) it.next())) {
                    break;
                }
            }
        }
        if (!z) {
            return (AbstractC1148aa) iterable;
        }
        final Iterator<? extends Item> it2 = iterable.iterator();
        return AbstractC1148aa.m9798a((Iterator) new Iterator<ImmutableItem>() { // from class: org.d.d.i.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) AbstractC2455i.this.mo14889a((AbstractC2455i) it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        });
    }

    /* renamed from: a */
    public AbstractC1151ad<ImmutableItem> m15524a(Comparator<? super ImmutableItem> comparator, Iterable<? extends Item> iterable) {
        boolean z;
        if (iterable == null) {
            return AbstractC1151ad.m9847g();
        }
        if ((iterable instanceof AbstractC1151ad) && ((AbstractC1151ad) iterable).comparator().equals(comparator)) {
            Iterator<? extends Item> it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (!mo14890b((AbstractC2455i<ImmutableItem, Item>) it.next())) {
                    z = true;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (!z) {
            return (AbstractC1151ad) iterable;
        }
        final Iterator<? extends Item> it2 = iterable.iterator();
        return AbstractC1151ad.m9845a((Comparator) comparator, (Iterator) new Iterator<ImmutableItem>() { // from class: org.d.d.i.3
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it2.hasNext();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Iterator
            public ImmutableItem next() {
                return (ImmutableItem) AbstractC2455i.this.mo14889a((AbstractC2455i) it2.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                it2.remove();
            }
        });
    }
}
