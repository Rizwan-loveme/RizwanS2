package org.p226d.p227a.p228a.p229a;

import org.p226d.p227a.p228a.C1947o;
import org.p226d.p269d.C2457k;

/* compiled from: LocalFormatter.java */
/* renamed from: org.d.a.a.a.f */
/* loaded from: classes.dex */
public class C1920f {
    /* renamed from: a */
    public static void m14092a(C2457k c2457k, String str, String str2, String str3) {
        if (str != null) {
            C1947o.m14170a(c2457k, str);
        } else {
            c2457k.write("null");
        }
        c2457k.write(58);
        if (str2 != null) {
            c2457k.write(str2);
        } else {
            c2457k.write("V");
        }
        if (str3 != null) {
            c2457k.write(", ");
            C1947o.m14170a(c2457k, str3);
        }
    }
}
