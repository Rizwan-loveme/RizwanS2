package org.p226d.p233b.p234a;

import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p234a.p237b.C1967a;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p263h.C2387g;
import org.p226d.p233b.p263h.C2392l;

/* compiled from: AnalyzedMethodUtil.java */
/* renamed from: org.d.b.a.c */
/* loaded from: classes.dex */
public class C1968c {
    /* renamed from: a */
    public static boolean m14258a(InterfaceC1981p interfaceC1981p, InterfaceC2267h interfaceC2267h, boolean z, boolean z2, boolean z3) {
        if (z && C2387g.m15095c(interfaceC2267h) && !C2392l.m15150c(interfaceC2267h.mo14209a()).equals(C2392l.m15150c(interfaceC1981p.mo14265b()))) {
            return false;
        }
        if (z2 && (interfaceC2267h.mo14214f() & EnumC1959a.PROTECTED.m14191a()) != 0 && !C1967a.m14255a(interfaceC1981p, interfaceC2267h.mo14209a())) {
            return false;
        }
        if (z3) {
            if (!C2392l.m15147a(interfaceC1981p.mo14265b(), interfaceC1981p.mo14261a().m14274a(interfaceC2267h.mo14209a()))) {
                return false;
            }
        }
        return true;
    }
}
