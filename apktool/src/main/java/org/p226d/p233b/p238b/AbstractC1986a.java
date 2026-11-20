package org.p226d.p233b.p238b;

import com.p129f.p130a.p137g.C1219c;
import java.util.Comparator;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p269d.C2452f;

/* compiled from: BaseAnnotation.java */
/* renamed from: org.d.b.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1986a implements InterfaceC2165a {

    /* renamed from: a */
    public static final Comparator<? super InterfaceC2165a> f11567a = new Comparator<InterfaceC2165a>() { // from class: org.d.b.b.a.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InterfaceC2165a interfaceC2165a, InterfaceC2165a interfaceC2165a2) {
            return interfaceC2165a.mo14672b().compareTo(interfaceC2165a2.mo14672b());
        }
    };

    public int hashCode() {
        return (((mo14671a() * 31) + mo14672b().hashCode()) * 31) + mo14673c().hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC2165a)) {
            return false;
        }
        InterfaceC2165a interfaceC2165a = (InterfaceC2165a) obj;
        return mo14671a() == interfaceC2165a.mo14671a() && mo14672b().equals(interfaceC2165a.mo14672b()) && mo14673c().equals(interfaceC2165a.mo14673c());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2165a, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2165a interfaceC2165a) {
        int m10173a = C1219c.m10173a(mo14671a(), interfaceC2165a.mo14671a());
        if (m10173a == 0) {
            int compareTo = mo14672b().compareTo(interfaceC2165a.mo14672b());
            return compareTo == 0 ? C2452f.m15518b(mo14673c(), interfaceC2165a.mo14673c()) : compareTo;
        }
        return m10173a;
    }
}
