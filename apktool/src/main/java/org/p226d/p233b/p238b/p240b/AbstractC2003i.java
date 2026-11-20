package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2254j;

/* compiled from: BaseFloatEncodedValue.java */
/* renamed from: org.d.b.b.b.i */
/* loaded from: classes.dex */
public abstract class AbstractC2003i implements InterfaceC2254j {
    public int hashCode() {
        return Float.floatToRawIntBits(mo14864b());
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof InterfaceC2254j) && Float.floatToRawIntBits(mo14864b()) == Float.floatToRawIntBits(((InterfaceC2254j) obj).mo14864b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2254j, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : Float.compare(mo14864b(), ((InterfaceC2254j) interfaceC2251g).mo14864b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 16;
    }
}
