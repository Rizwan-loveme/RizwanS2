package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import com.p129f.p130a.p137g.C1220d;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2256l;

/* compiled from: BaseLongEncodedValue.java */
/* renamed from: org.d.b.b.b.k */
/* loaded from: classes.dex */
public abstract class AbstractC2005k implements InterfaceC2256l {
    public int hashCode() {
        long b2 = mo14866b();
        return ((int) (b2 >>> 32)) + (((int) b2) * 31);
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2256l) && mo14866b() == ((InterfaceC2256l) obj).mo14866b();
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2256l, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C1220d.m10175a(mo14866b(), ((InterfaceC2256l) interfaceC2251g).mo14866b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 6;
    }
}
