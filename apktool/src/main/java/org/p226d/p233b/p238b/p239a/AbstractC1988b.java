package org.p226d.p233b.p238b.p239a;

import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p263h.C2389i;

/* compiled from: BaseFieldReference.java */
/* renamed from: org.d.b.b.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1988b implements InterfaceC2237b {
    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b
    public int hashCode() {
        return (((mo14225d().hashCode() * 31) + mo14226e().hashCode()) * 31) + mo14227f().hashCode();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b
    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC2237b)) {
            return false;
        }
        InterfaceC2237b interfaceC2237b = (InterfaceC2237b) obj;
        return mo14225d().equals(interfaceC2237b.mo14225d()) && mo14226e().equals(interfaceC2237b.mo14226e()) && mo14227f().equals(interfaceC2237b.mo14227f());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(InterfaceC2237b interfaceC2237b) {
        int compareTo = mo14225d().compareTo(interfaceC2237b.mo14225d());
        if (compareTo == 0) {
            int compareTo2 = mo14226e().compareTo(interfaceC2237b.mo14226e());
            return compareTo2 == 0 ? mo14227f().compareTo(interfaceC2237b.mo14227f()) : compareTo2;
        }
        return compareTo;
    }

    public String toString() {
        return C2389i.m15116a((InterfaceC2237b) this);
    }
}
