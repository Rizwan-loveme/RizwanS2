package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import com.p129f.p130a.p137g.C1221e;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2261q;

/* compiled from: BaseShortEncodedValue.java */
/* renamed from: org.d.b.b.b.p */
/* loaded from: classes.dex */
public abstract class AbstractC2010p implements InterfaceC2261q {
    public int hashCode() {
        return mo14867b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2261q) && mo14867b() == ((InterfaceC2261q) obj).mo14867b();
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2261q, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C1221e.m10177a(mo14867b(), ((InterfaceC2261q) interfaceC2251g).mo14867b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 2;
    }
}
