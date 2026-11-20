package org.p226d.p233b.p238b.p239a;

import org.p226d.p233b.p250e.p254c.InterfaceC2236a;

/* compiled from: BaseCallSiteReference.java */
/* renamed from: org.d.b.b.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC1987a implements InterfaceC2236a {
    public int hashCode() {
        return (((((((mo14678a().hashCode() * 31) + mo14679b().hashCode()) * 31) + mo14680c().hashCode()) * 31) + mo14681d().hashCode()) * 31) + mo14682e().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof InterfaceC2236a)) {
            return false;
        }
        InterfaceC2236a interfaceC2236a = (InterfaceC2236a) obj;
        return mo14679b().equals(interfaceC2236a.mo14679b()) && mo14680c().equals(interfaceC2236a.mo14680c()) && mo14681d().equals(interfaceC2236a.mo14681d()) && mo14682e().equals(interfaceC2236a.mo14682e());
    }
}
