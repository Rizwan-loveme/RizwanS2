package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2258n;

/* compiled from: BaseMethodHandleEncodedValue.java */
/* renamed from: org.d.b.b.b.m */
/* loaded from: classes.dex */
public abstract class AbstractC2007m implements InterfaceC2258n {
    public int hashCode() {
        return mo14740b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2258n) {
            return mo14740b().equals(((InterfaceC2258n) obj).mo14740b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2258n, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14740b().compareTo(((InterfaceC2258n) interfaceC2251g).mo14740b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 22;
    }
}
