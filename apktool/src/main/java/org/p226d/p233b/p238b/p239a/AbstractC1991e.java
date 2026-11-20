package org.p226d.p233b.p238b.p239a;

import com.p129f.p130a.p133c.AbstractC1163ap;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p269d.C2450d;
import org.p226d.p269d.C2452f;

/* compiled from: BaseMethodReference.java */
/* renamed from: org.d.b.b.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC1991e implements InterfaceC2240e {
    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    public int hashCode() {
        return (((((mo14209a().hashCode() * 31) + mo14210b().hashCode()) * 31) + mo14212d().hashCode()) * 31) + mo14211c().hashCode();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InterfaceC2240e)) {
            return false;
        }
        InterfaceC2240e interfaceC2240e = (InterfaceC2240e) obj;
        return mo14209a().equals(interfaceC2240e.mo14209a()) && mo14210b().equals(interfaceC2240e.mo14210b()) && mo14212d().equals(interfaceC2240e.mo14212d()) && C2450d.m15489a(mo14211c(), interfaceC2240e.mo14211c());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2240e interfaceC2240e) {
        int compareTo = mo14209a().compareTo(interfaceC2240e.mo14209a());
        if (compareTo == 0) {
            int compareTo2 = mo14210b().compareTo(interfaceC2240e.mo14210b());
            if (compareTo2 == 0) {
                int compareTo3 = mo14212d().compareTo(interfaceC2240e.mo14212d());
                return compareTo3 == 0 ? C2452f.m15515a(AbstractC1163ap.m9958c(), mo14211c(), interfaceC2240e.mo14211c()) : compareTo3;
            }
            return compareTo2;
        }
        return compareTo;
    }

    public String toString() {
        return C2389i.m15120a((InterfaceC2240e) this);
    }
}
