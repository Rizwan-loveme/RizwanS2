package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2255k;

/* compiled from: BaseIntEncodedValue.java */
/* renamed from: org.d.b.b.b.j */
/* loaded from: classes.dex */
public abstract class AbstractC2004j implements InterfaceC2255k {
    public int hashCode() {
        return mo14865b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2255k) && mo14865b() == ((InterfaceC2255k) obj).mo14865b();
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2255k, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C1219c.m10173a(mo14865b(), ((InterfaceC2255k) interfaceC2251g).mo14865b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 4;
    }
}
