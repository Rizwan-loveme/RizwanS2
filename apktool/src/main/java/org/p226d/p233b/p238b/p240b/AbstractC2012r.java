package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2263s;

/* compiled from: BaseTypeEncodedValue.java */
/* renamed from: org.d.b.b.b.r */
/* loaded from: classes.dex */
public abstract class AbstractC2012r implements InterfaceC2263s {
    public int hashCode() {
        return mo14743b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2263s) {
            return mo14743b().equals(((InterfaceC2263s) obj).mo14743b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2263s, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14743b().compareTo(((InterfaceC2263s) interfaceC2251g).mo14743b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 24;
    }
}
