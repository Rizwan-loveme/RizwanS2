package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2259o;

/* compiled from: BaseMethodTypeEncodedValue.java */
/* renamed from: org.d.b.b.b.n */
/* loaded from: classes.dex */
public abstract class AbstractC2008n implements InterfaceC2259o {
    public int hashCode() {
        return mo14741b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2259o) {
            return mo14741b().equals(((InterfaceC2259o) obj).mo14741b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2259o, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14741b().compareTo(((InterfaceC2259o) interfaceC2251g).mo14741b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 21;
    }
}
