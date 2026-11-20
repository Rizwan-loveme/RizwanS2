package org.p226d.p233b.p238b;

import java.util.Comparator;
import org.p226d.p233b.p250e.InterfaceC2175b;

/* compiled from: BaseAnnotationElement.java */
/* renamed from: org.d.b.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC1994b implements InterfaceC2175b {

    /* renamed from: a */
    public static final Comparator<InterfaceC2175b> f11568a = new Comparator<InterfaceC2175b>() { // from class: org.d.b.b.b.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InterfaceC2175b interfaceC2175b, InterfaceC2175b interfaceC2175b2) {
            return interfaceC2175b.mo14692a().compareTo(interfaceC2175b2.mo14692a());
        }
    };

    public int hashCode() {
        return (mo14692a().hashCode() * 31) + mo14693b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InterfaceC2175b)) {
            return false;
        }
        InterfaceC2175b interfaceC2175b = (InterfaceC2175b) obj;
        return mo14692a().equals(interfaceC2175b.mo14692a()) && mo14693b().equals(interfaceC2175b.mo14693b());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2175b, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2175b interfaceC2175b) {
        int compareTo = mo14692a().compareTo(interfaceC2175b.mo14692a());
        return compareTo != 0 ? compareTo : mo14693b().compareTo(interfaceC2175b.mo14693b());
    }
}
