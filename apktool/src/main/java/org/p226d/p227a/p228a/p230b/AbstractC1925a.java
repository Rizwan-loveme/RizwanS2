package org.p226d.p227a.p228a.p230b;

import java.util.Collection;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p269d.C2457k;

/* compiled from: AnnotationEncodedValueAdaptor.java */
/* renamed from: org.d.a.a.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1925a {
    /* renamed from: a */
    public static void m14094a(C2457k c2457k, InterfaceC2245a interfaceC2245a, String str) {
        c2457k.write(".subannotation ");
        c2457k.write(interfaceC2245a.mo14672b());
        c2457k.write(10);
        m14093a(c2457k, interfaceC2245a.mo14673c(), str);
        c2457k.write(".end subannotation");
    }

    /* renamed from: a */
    public static void m14093a(C2457k c2457k, Collection<? extends InterfaceC2175b> collection, String str) {
        c2457k.m15532a(4);
        for (InterfaceC2175b interfaceC2175b : collection) {
            c2457k.write(interfaceC2175b.mo14692a());
            c2457k.write(" = ");
            AbstractC1927c.m14096a(c2457k, interfaceC2175b.mo14693b(), str);
            c2457k.write(10);
        }
        c2457k.m15534b(4);
    }
}
