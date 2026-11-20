package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p269d.C2452f;

/* compiled from: BaseAnnotationEncodedValue.java */
/* renamed from: org.d.b.b.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1995a implements InterfaceC2245a {
    public int hashCode() {
        return (mo14672b().hashCode() * 31) + mo14673c().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC2245a)) {
            return false;
        }
        InterfaceC2245a interfaceC2245a = (InterfaceC2245a) obj;
        return mo14672b().equals(interfaceC2245a.mo14672b()) && mo14673c().equals(interfaceC2245a.mo14673c());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2245a, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        if (m10173a == 0) {
            InterfaceC2245a interfaceC2245a = (InterfaceC2245a) interfaceC2251g;
            int compareTo = mo14672b().compareTo(interfaceC2245a.mo14672b());
            return compareTo == 0 ? C2452f.m15518b(mo14673c(), interfaceC2245a.mo14673c()) : compareTo;
        }
        return m10173a;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 29;
    }
}
