package org.p226d.p233b.p244d.p247c;

import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedReference.java */
/* renamed from: org.d.b.d.c.f */
/* loaded from: classes.dex */
public abstract class AbstractC2126f {
    /* renamed from: a */
    public static InterfaceC2241f m14690a(C2153g c2153g, int i, int i2) {
        switch (i) {
            case 0:
                return new C2127g(c2153g, i2);
            case 1:
                return new C2128h(c2153g, i2);
            case 2:
                return new C2122b(c2153g, i2);
            case 3:
                return new C2125e(c2153g, i2);
            case 4:
                return new C2124d(c2153g, i2);
            case 5:
                return new C2121a(c2153g, i2);
            case 6:
                return new C2123c(c2153g, i2);
            default:
                throw new C2453g("Invalid reference type: %d", Integer.valueOf(i));
        }
    }
}
