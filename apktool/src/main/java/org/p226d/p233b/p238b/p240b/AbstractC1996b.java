package org.p226d.p233b.p238b.p240b;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p269d.C2452f;

/* compiled from: BaseArrayEncodedValue.java */
/* renamed from: org.d.b.b.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC1996b implements InterfaceC2246b {
    public int hashCode() {
        return mo14733b().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InterfaceC2246b) {
            return mo14733b().equals(((InterfaceC2246b) obj).mo14733b());
        }
        return false;
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2246b, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2251g interfaceC2251g) {
        int m10173a = C1219c.m10173a(mo14430a(), interfaceC2251g.mo14430a());
        return m10173a != 0 ? m10173a : C2452f.m15514a(mo14733b(), ((InterfaceC2246b) interfaceC2251g).mo14733b());
    }

    @Override // org.p226d.p233b.p250e.p255d.InterfaceC2251g
    /* renamed from: a */
    public int mo14430a() {
        return 28;
    }
}
