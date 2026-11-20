package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2253i;

/* compiled from: BaseFieldEncodedValue.java */
/* renamed from: org.d.b.b.b.h */
/* loaded from: classes.dex */
public abstract class AbstractC2002h implements InterfaceC2253i {
    public int hashCode() {
        return mo14738b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2253i) {
            return mo14738b().equals(((InterfaceC2253i) obj).mo14738b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2253i, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14738b().compareTo(((InterfaceC2253i) interfaceC2251g).mo14738b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 25;
    }
}
