package org.p226d.p233b.p238b;

import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p137g.C1219c;
import java.util.Comparator;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: BaseExceptionHandler.java */
/* renamed from: org.d.b.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC2013c implements InterfaceC2265f {

    /* renamed from: a */
    public static final Comparator<InterfaceC2265f> f11569a = new Comparator<InterfaceC2265f>() { // from class: org.d.b.b.c.2
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InterfaceC2265f interfaceC2265f, InterfaceC2265f interfaceC2265f2) {
            String mo14476b = interfaceC2265f.mo14476b();
            if (mo14476b == null) {
                if (interfaceC2265f2.mo14476b() != null) {
                    return 1;
                }
                return 0;
            }
            if (interfaceC2265f2.mo14476b() == null) {
                return -1;
            }
            return mo14476b.compareTo(interfaceC2265f2.mo14476b());
        }
    };

    @Override // org.p226d.p233b.p250e.InterfaceC2265f
    /* renamed from: a */
    public InterfaceC2243h mo14450a() {
        final String b2 = mo14476b();
        if (b2 == null) {
            return null;
        }
        return new AbstractC1993g() { // from class: org.d.b.b.c.1
            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
            /* renamed from: l */
            public String mo14205l() {
                return b2;
            }
        };
    }

    public int hashCode() {
        String b2 = mo14476b();
        return ((b2 == null ? 0 : b2.hashCode()) * 31) + mo14477c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC2265f)) {
            return false;
        }
        InterfaceC2265f interfaceC2265f = (InterfaceC2265f) obj;
        return C1116k.m9538a(mo14476b(), interfaceC2265f.mo14476b()) && mo14477c() == interfaceC2265f.mo14477c();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2265f, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2265f interfaceC2265f) {
        String b2 = mo14476b();
        if (b2 == null) {
            if (interfaceC2265f.mo14476b() != null) {
                return 1;
            }
        } else {
            if (interfaceC2265f.mo14476b() == null) {
                return -1;
            }
            int compareTo = b2.compareTo(interfaceC2265f.mo14476b());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return C1219c.m10173a(mo14477c(), interfaceC2265f.mo14477c());
    }
}
