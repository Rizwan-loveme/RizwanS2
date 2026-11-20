package org.p226d.p227a.p232b;

import org.p226d.p269d.C2457k;

/* compiled from: LongRenderer.java */
/* renamed from: org.d.a.b.g */
/* loaded from: classes.dex */
public class C1957g {
    /* renamed from: a */
    public static void m14180a(C2457k c2457k, long j) {
        if (j < 0) {
            c2457k.write("-0x");
            c2457k.m15533a(-j);
            c2457k.write(76);
        } else {
            c2457k.write("0x");
            c2457k.m15533a(j);
            c2457k.write(76);
        }
    }

    /* renamed from: b */
    public static void m14181b(C2457k c2457k, long j) {
        if (j < 0) {
            c2457k.write("-0x");
            c2457k.m15533a(-j);
            if (j < -2147483648L) {
                c2457k.write(76);
                return;
            }
            return;
        }
        c2457k.write("0x");
        c2457k.m15533a(j);
        if (j > 2147483647L) {
            c2457k.write(76);
        }
    }
}
