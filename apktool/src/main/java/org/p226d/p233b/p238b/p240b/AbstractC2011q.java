package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;

/* compiled from: BaseStringEncodedValue.java */
/* renamed from: org.d.b.b.b.q */
/* loaded from: classes.dex */
public abstract class AbstractC2011q implements InterfaceC2262r {
    public int hashCode() {
        return mo14742b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2262r) {
            return mo14742b().equals(((InterfaceC2262r) obj).mo14742b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2262r, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14742b().compareTo(((InterfaceC2262r) interfaceC2251g).mo14742b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 23;
    }
}
