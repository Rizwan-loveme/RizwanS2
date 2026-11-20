package org.p226d.p233b.p238b.p239a;

import com.p129f.p130a.p133c.AbstractC1163ap;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p269d.C2450d;
import org.p226d.p269d.C2452f;

/* compiled from: BaseMethodProtoReference.java */
/* renamed from: org.d.b.b.a.d */
/* loaded from: classes.dex */
public abstract class AbstractC1990d implements InterfaceC2239d {
    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d
    public int hashCode() {
        return (mo14686b().hashCode() * 31) + mo14685a().hashCode();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d
    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC2239d)) {
            return false;
        }
        InterfaceC2239d interfaceC2239d = (InterfaceC2239d) obj;
        return mo14686b().equals(interfaceC2239d.mo14686b()) && C2450d.m15489a(mo14685a(), interfaceC2239d.mo14685a());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2239d, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2239d interfaceC2239d) {
        int compareTo = mo14686b().compareTo(interfaceC2239d.mo14686b());
        return compareTo != 0 ? compareTo : C2452f.m15515a(AbstractC1163ap.m9958c(), mo14685a(), interfaceC2239d.mo14685a());
    }

    public String toString() {
        return C2389i.m15119a((InterfaceC2239d) this);
    }
}
