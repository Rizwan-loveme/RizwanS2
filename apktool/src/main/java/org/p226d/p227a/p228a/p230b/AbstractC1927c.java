package org.p226d.p227a.p228a.p230b;

import org.p226d.p227a.p228a.C1947o;
import org.p226d.p227a.p232b.C1951a;
import org.p226d.p227a.p232b.C1952b;
import org.p226d.p227a.p232b.C1953c;
import org.p226d.p227a.p232b.C1954d;
import org.p226d.p227a.p232b.C1955e;
import org.p226d.p227a.p232b.C1956f;
import org.p226d.p227a.p232b.C1957g;
import org.p226d.p227a.p232b.C1958h;
import org.p226d.p233b.p250e.p255d.InterfaceC2245a;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2247c;
import org.p226d.p233b.p250e.p255d.InterfaceC2248d;
import org.p226d.p233b.p250e.p255d.InterfaceC2249e;
import org.p226d.p233b.p250e.p255d.InterfaceC2250f;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p250e.p255d.InterfaceC2252h;
import org.p226d.p233b.p250e.p255d.InterfaceC2253i;
import org.p226d.p233b.p250e.p255d.InterfaceC2254j;
import org.p226d.p233b.p250e.p255d.InterfaceC2255k;
import org.p226d.p233b.p250e.p255d.InterfaceC2256l;
import org.p226d.p233b.p250e.p255d.InterfaceC2257m;
import org.p226d.p233b.p250e.p255d.InterfaceC2258n;
import org.p226d.p233b.p250e.p255d.InterfaceC2259o;
import org.p226d.p233b.p250e.p255d.InterfaceC2261q;
import org.p226d.p233b.p250e.p255d.InterfaceC2262r;
import org.p226d.p233b.p250e.p255d.InterfaceC2263s;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p269d.C2457k;

/* compiled from: EncodedValueAdaptor.java */
/* renamed from: org.d.a.a.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC1927c {
    /* renamed from: a */
    public static void m14096a(C2457k c2457k, InterfaceC2251g interfaceC2251g, String str) {
        switch (interfaceC2251g.mo14430a()) {
            case 0:
                C1952b.m14175a(c2457k, ((InterfaceC2248d) interfaceC2251g).mo14861b());
                return;
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            default:
                throw new IllegalArgumentException("Unknown encoded value type: " + interfaceC2251g.mo14430a());
            case 2:
                C1958h.m14182a(c2457k, ((InterfaceC2261q) interfaceC2251g).mo14867b());
                return;
            case 3:
                C1953c.m14176a(c2457k, ((InterfaceC2249e) interfaceC2251g).mo14862b());
                return;
            case 4:
                C1956f.m14179a(c2457k, ((InterfaceC2255k) interfaceC2251g).mo14865b());
                return;
            case 6:
                C1957g.m14180a(c2457k, ((InterfaceC2256l) interfaceC2251g).mo14866b());
                return;
            case 16:
                C1955e.m14178a(c2457k, ((InterfaceC2254j) interfaceC2251g).mo14864b());
                return;
            case 17:
                C1954d.m14177a(c2457k, ((InterfaceC2250f) interfaceC2251g).mo14863b());
                return;
            case 21:
                C1947o.m14169a(c2457k, 4, ((InterfaceC2259o) interfaceC2251g).mo14741b());
                return;
            case 22:
                C1947o.m14169a(c2457k, 6, ((InterfaceC2258n) interfaceC2251g).mo14740b());
                return;
            case 23:
                C1947o.m14170a(c2457k, ((InterfaceC2262r) interfaceC2251g).mo14742b());
                return;
            case 24:
                c2457k.write(((InterfaceC2263s) interfaceC2251g).mo14743b());
                return;
            case 25:
                InterfaceC2253i interfaceC2253i = (InterfaceC2253i) interfaceC2251g;
                C2389i.m15126a(c2457k, interfaceC2253i.mo14738b(), interfaceC2253i.mo14738b().mo14225d().equals(str));
                return;
            case 26:
                InterfaceC2257m interfaceC2257m = (InterfaceC2257m) interfaceC2251g;
                C2389i.m15130a(c2457k, interfaceC2257m.mo14739b(), interfaceC2257m.mo14739b().mo14209a().equals(str));
                return;
            case 27:
                InterfaceC2252h interfaceC2252h = (InterfaceC2252h) interfaceC2251g;
                boolean z = interfaceC2252h.mo14737b().mo14225d().equals(str);
                c2457k.write(".enum ");
                C2389i.m15126a(c2457k, interfaceC2252h.mo14737b(), z);
                return;
            case 28:
                C1926b.m14095a(c2457k, (InterfaceC2246b) interfaceC2251g, str);
                return;
            case 29:
                AbstractC1925a.m14094a(c2457k, (InterfaceC2245a) interfaceC2251g, str);
                return;
            case 30:
                c2457k.write("null");
                return;
            case 31:
                C1951a.m14174a(c2457k, ((InterfaceC2247c) interfaceC2251g).mo14860b());
                return;
        }
    }
}
