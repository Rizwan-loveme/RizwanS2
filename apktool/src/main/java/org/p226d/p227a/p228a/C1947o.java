package org.p226d.p227a.p228a;

import org.p226d.p227a.p228a.p230b.AbstractC1927c;
import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2238c;
import org.p226d.p233b.p250e.p254c.InterfaceC2239d;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p269d.C2457k;
import org.p226d.p269d.C2464r;

/* compiled from: ReferenceFormatter.java */
/* renamed from: org.d.a.a.o */
/* loaded from: classes.dex */
public class C1947o {
    /* renamed from: a */
    public static void m14170a(C2457k c2457k, String str) {
        c2457k.write(34);
        C2464r.m15561a(c2457k, str);
        c2457k.write(34);
    }

    /* renamed from: a */
    public static void m14171a(C2457k c2457k, InterfaceC2236a interfaceC2236a) {
        c2457k.write(interfaceC2236a.mo14678a());
        c2457k.write(40);
        c2457k.write(34);
        C2464r.m15561a(c2457k, interfaceC2236a.mo14680c());
        c2457k.write("\", ");
        m14169a(c2457k, 4, interfaceC2236a.mo14681d());
        for (InterfaceC2251g interfaceC2251g : interfaceC2236a.mo14682e()) {
            c2457k.write(", ");
            AbstractC1927c.m14096a(c2457k, interfaceC2251g, null);
        }
        c2457k.write(")@");
        if (interfaceC2236a.mo14679b().mo14683a() != 4) {
            throw new IllegalArgumentException("The linker method handle for a call site must be of type invoke-static");
        }
        m14169a(c2457k, 3, interfaceC2236a.mo14679b().mo14684b());
    }

    /* renamed from: a */
    public static void m14169a(C2457k c2457k, int i, InterfaceC2241f interfaceC2241f) {
        switch (i) {
            case 0:
                m14170a(c2457k, ((InterfaceC2242g) interfaceC2241f).mo14691a());
                return;
            case 1:
                c2457k.write(((InterfaceC2243h) interfaceC2241f).mo14205l());
                return;
            case 2:
                C2389i.m15125a(c2457k, (InterfaceC2237b) interfaceC2241f);
                return;
            case 3:
                C2389i.m15129a(c2457k, (InterfaceC2240e) interfaceC2241f);
                return;
            case 4:
                C2389i.m15128a(c2457k, (InterfaceC2239d) interfaceC2241f);
                return;
            case 5:
                m14171a(c2457k, (InterfaceC2236a) interfaceC2241f);
                return;
            case 6:
                C2389i.m15127a(c2457k, (InterfaceC2238c) interfaceC2241f);
                return;
            default:
                throw new IllegalStateException("Unknown reference type");
        }
    }
}
