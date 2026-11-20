package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2252h;

/* compiled from: BaseEnumEncodedValue.java */
/* renamed from: org.d.b.b.b.g */
/* loaded from: classes.dex */
public abstract class AbstractC2001g implements InterfaceC2252h {
    public int hashCode() {
        return mo14737b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2252h) {
            return mo14737b().equals(((InterfaceC2252h) obj).mo14737b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2252h, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : mo14737b().compareTo(((InterfaceC2252h) interfaceC2251g).mo14737b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 27;
    }
}
