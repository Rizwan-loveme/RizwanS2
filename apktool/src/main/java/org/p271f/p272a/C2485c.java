package org.p271f.p272a;

import org.p271f.p272a.p275c.C2504s;

/* compiled from: AsmBridge.java */
/* renamed from: org.f.a.c */
/* loaded from: classes.dex */
public class C2485c {
    /* renamed from: a */
    public static AbstractC2526r m15714a(AbstractC2526r abstractC2526r) {
        while (abstractC2526r != null && !(abstractC2526r instanceof C2527s)) {
            abstractC2526r = abstractC2526r.f13214c_;
        }
        return abstractC2526r;
    }

    /* renamed from: b */
    public static int m15717b(AbstractC2526r abstractC2526r) {
        return ((C2527s) abstractC2526r).m15887d();
    }

    /* renamed from: a */
    private static void m15716a(C2527s c2527s) {
        C2516h c2516h = c2527s.f13242c;
        C2527s c2527s2 = c2516h.f13130t;
        if (c2527s2 == c2527s) {
            c2516h.f13130t = (C2527s) null;
            if (c2516h.f13131u == c2527s) {
                c2516h.f13131u = (C2527s) null;
                return;
            }
            return;
        }
        while (c2527s2 != null) {
            if (c2527s2.f13214c_ == c2527s) {
                c2527s2.f13214c_ = c2527s.f13214c_;
                if (c2516h.f13131u != c2527s) {
                    return;
                }
                c2516h.f13131u = c2527s2;
                return;
            }
            c2527s2 = (C2527s) c2527s2.f13214c_;
        }
    }

    /* renamed from: a */
    public static void m15715a(AbstractC2526r abstractC2526r, C2504s c2504s) {
        C2527s c2527s = (C2527s) abstractC2526r;
        c2504s.m15746a((AbstractC2515g) c2527s.f13242c);
        m15716a(c2527s);
    }
}
