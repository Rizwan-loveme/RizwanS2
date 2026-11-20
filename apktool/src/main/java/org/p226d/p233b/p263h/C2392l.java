package org.p226d.p233b.p263h;

import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: TypeUtils.java */
/* renamed from: org.d.b.h.l */
/* loaded from: classes.dex */
public final class C2392l {
    /* renamed from: a */
    public static boolean m15146a(String str) {
        char charAt = str.charAt(0);
        return charAt == 'J' || charAt == 'D';
    }

    /* renamed from: a */
    public static boolean m15148a(InterfaceC2243h interfaceC2243h) {
        return m15146a(interfaceC2243h.mo14205l());
    }

    /* renamed from: b */
    public static boolean m15149b(String str) {
        return str.length() == 1;
    }

    /* renamed from: c */
    public static String m15150c(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf < 0 ? "" : str.substring(1, lastIndexOf);
    }

    /* renamed from: a */
    public static boolean m15147a(String str, InterfaceC2244d interfaceC2244d) {
        if (EnumC1959a.PUBLIC.m14192a(interfaceC2244d.mo14194a())) {
            return true;
        }
        return m15150c(interfaceC2244d.mo14205l()).equals(m15150c(str));
    }
}
