package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2257m;

/* compiled from: BaseMethodEncodedValue.java */
/* renamed from: org.d.b.b.b.l */
/* loaded from: classes.dex */
public abstract class AbstractC2006l implements InterfaceC2257m {
    public int hashCode() {
        return mo14739b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2257m) {
            return mo14739b().equals(((InterfaceC2257m) obj).mo14739b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2257m, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14739b().compareTo(((InterfaceC2257m) interfaceC2251g).mo14739b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 26;
    }
}
