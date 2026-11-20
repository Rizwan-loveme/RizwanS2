package org.p226d.p233b.p238b.p239a;

import com.p129f.p130a.p137g.C1219c;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;

/* compiled from: BaseMethodHandleReference.java */
/* renamed from: org.d.b.b.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC1989c implements InterfaceC2238c {
    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c
    public int hashCode() {
        return (mo14683a() * 31) + mo14684b().hashCode();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InterfaceC2238c)) {
            return false;
        }
        InterfaceC2238c interfaceC2238c = (InterfaceC2238c) obj;
        return mo14683a() == interfaceC2238c.mo14683a() && mo14684b().equals(interfaceC2238c.mo14684b());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2238c, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2238c interfaceC2238c) {
        int m10173a = C1219c.m10173a(mo14683a(), interfaceC2238c.mo14683a());
        if (m10173a == 0) {
            InterfaceC2241f b2 = mo14684b();
            if (b2 instanceof InterfaceC2237b) {
                if (!(interfaceC2238c.mo14684b() instanceof InterfaceC2237b)) {
                    return -1;
                }
                return ((InterfaceC2237b) b2).compareTo((InterfaceC2237b) interfaceC2238c.mo14684b());
            }
            if (!(interfaceC2238c.mo14684b() instanceof InterfaceC2240e)) {
                return 1;
            }
            return ((InterfaceC2240e) b2).compareTo((InterfaceC2240e) interfaceC2238c.mo14684b());
        }
        return m10173a;
    }
}
