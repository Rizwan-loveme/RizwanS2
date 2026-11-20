package org.p226d.p227a.p228a;

import java.util.Collection;
import org.p226d.p227a.p228a.p230b.AbstractC1925a;
import org.p226d.p233b.C1985b;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p269d.C2457k;

/* compiled from: AnnotationFormatter.java */
/* renamed from: org.d.a.a.a */
/* loaded from: classes.dex */
public class C1914a {
    /* renamed from: a */
    public static void m14087a(C2457k c2457k, Collection<? extends InterfaceC2165a> collection, String str) {
        boolean z = true;
        for (InterfaceC2165a interfaceC2165a : collection) {
            if (!z) {
                c2457k.write(10);
            }
            z = false;
            m14088a(c2457k, interfaceC2165a, str);
        }
    }

    /* renamed from: a */
    public static void m14088a(C2457k c2457k, InterfaceC2165a interfaceC2165a, String str) {
        c2457k.write(".annotation ");
        c2457k.write(C1985b.m14419a(interfaceC2165a.mo14671a()));
        c2457k.write(32);
        c2457k.write(interfaceC2165a.mo14672b());
        c2457k.write(10);
        AbstractC1925a.m14093a(c2457k, interfaceC2165a.mo14673c(), str);
        c2457k.write(".end annotation\n");
    }
}
