package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2248d;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: BaseByteEncodedValue.java */
/* renamed from: org.d.b.b.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC1998d implements InterfaceC2248d {
    public int hashCode() {
        return mo14861b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof InterfaceC2248d) && mo14861b() == ((InterfaceC2248d) obj).mo14861b();
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2248d, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C1219c.m10173a(mo14861b(), ((InterfaceC2248d) interfaceC2251g).mo14861b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 0;
    }
}
