package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2250f;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: BaseDoubleEncodedValue.java */
/* renamed from: org.d.b.b.b.f */
/* loaded from: classes.dex */
public abstract class AbstractC2000f implements InterfaceC2250f {
    public int hashCode() {
        long doubleToRawLongBits = Double.doubleToRawLongBits(mo14863b());
        return (int) (doubleToRawLongBits ^ (doubleToRawLongBits >>> 32));
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2250f) && Double.doubleToRawLongBits(mo14863b()) == Double.doubleToRawLongBits(((InterfaceC2250f) obj).mo14863b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2250f, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : Double.compare(mo14863b(), ((InterfaceC2250f) interfaceC2251g).mo14863b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 17;
    }
}
