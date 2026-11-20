package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1217a;
import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2247c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: BaseBooleanEncodedValue.java */
/* renamed from: org.d.b.b.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC1997c implements InterfaceC2247c {
    public int hashCode() {
        return mo14860b() ? 1 : 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2247c) && mo14860b() == ((InterfaceC2247c) obj).mo14860b();
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2247c, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C1217a.m10170a(mo14860b(), ((InterfaceC2247c) interfaceC2251g).mo14860b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 31;
    }
}
