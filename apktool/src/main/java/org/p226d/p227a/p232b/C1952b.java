package org.p226d.p227a.p232b;

import org.p226d.p269d.C2457k;

/* compiled from: ByteRenderer.java */
/* renamed from: org.d.a.b.b */
/* loaded from: classes.dex */
public class C1952b {
    /* renamed from: a */
    public static void m14175a(C2457k c2457k, byte b2) {
        if (b2 < 0) {
            c2457k.write("-0x");
            c2457k.m15533a(-b2);
            c2457k.write(116);
        } else {
            c2457k.write("0x");
            c2457k.m15533a(b2);
            c2457k.write(116);
        }
    }
}
