package org.p226d.p233b.p264i.p266b;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Collection;
import java.util.Iterator;
import org.p226d.p233b.p264i.InterfaceC2443t;

/* compiled from: TypeListPool.java */
/* renamed from: org.d.b.i.b.u */
/* loaded from: classes.dex */
public class C2421u extends AbstractC2404d<a<? extends Collection<? extends CharSequence>>> implements InterfaceC2443t<CharSequence, a<? extends Collection<? extends CharSequence>>> {
    public C2421u(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a */
    public void m15317a(Collection<? extends CharSequence> collection) {
        if (collection.size() > 0) {
            if (((Integer) this.f12766b.put(new a(collection), 0)) == null) {
                Iterator<? extends CharSequence> it = collection.iterator();
                while (it.hasNext()) {
                    ((C2422v) this.f12765a.f12827A).m15321a(it.next());
                }
            }
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2443t
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Collection<? extends CharSequence> mo15316a(a<? extends Collection<? extends CharSequence>> aVar) {
        return aVar == null ? AbstractC1208w.m10138g() : aVar.f12798a;
    }

    @Override // org.p226d.p233b.p264i.p266b.AbstractC2404d, org.p226d.p233b.p264i.InterfaceC2439p
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int mo15175b(a<? extends Collection<? extends CharSequence>> aVar) {
        if (aVar == null || aVar.f12798a.size() == 0) {
            return 0;
        }
        return super.mo15175b((C2421u) aVar);
    }

    /* compiled from: TypeListPool.java */
    /* renamed from: org.d.b.i.b.u$a */
    public static class a<TypeCollection extends Collection<? extends CharSequence>> implements Comparable<a<? extends Collection<? extends CharSequence>>> {

        /* renamed from: a */
        TypeCollection f12798a;

        public a(TypeCollection typecollection) {
            this.f12798a = typecollection;
        }

        public int hashCode() {
            int i = 1;
            Iterator it = this.f12798a.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = ((CharSequence) it.next()).toString().hashCode() + (i2 * 31);
                } else {
                    return i2;
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f12798a.size() != aVar.f12798a.size()) {
                return false;
            }
            Iterator it = aVar.f12798a.iterator();
            Iterator it2 = this.f12798a.iterator();
            while (it2.hasNext()) {
                if (!((CharSequence) it2.next()).toString().equals(((CharSequence) it.next()).toString())) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.f12798a.iterator();
            while (it.hasNext()) {
                sb.append(((CharSequence) it.next()).toString());
            }
            return sb.toString();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a<? extends Collection<? extends CharSequence>> aVar) {
            Iterator it = aVar.f12798a.iterator();
            for (CharSequence charSequence : this.f12798a) {
                if (!it.hasNext()) {
                    return 1;
                }
                int compareTo = charSequence.toString().compareTo(((CharSequence) it.next()).toString());
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            if (it.hasNext()) {
                return -1;
            }
            return 0;
        }
    }
}
