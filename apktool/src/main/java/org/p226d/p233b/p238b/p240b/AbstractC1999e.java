package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1218b;
import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2249e;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: BaseCharEncodedValue.java */
/* renamed from: org.d.b.b.b.e */
/* loaded from: classes.dex */
public abstract class AbstractC1999e implements InterfaceC2249e {
    public int hashCode() {
        return mo14862b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2249e) && mo14862b() == ((InterfaceC2249e) obj).mo14862b();
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2249e, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C1218b.m10171a(mo14862b(), ((InterfaceC2249e) interfaceC2251g).mo14862b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 3;
    }
}
