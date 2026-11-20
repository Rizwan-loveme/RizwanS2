package org.p226d.p227a.p228a.p231c;

import org.p226d.p227a.p228a.C1943k;
import org.p226d.p233b.p234a.C1984s;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2186ai;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2187aj;

/* compiled from: InstructionMethodItemFactory.java */
/* renamed from: org.d.a.a.c.c */
/* loaded from: classes.dex */
public class C1931c {
    /* renamed from: a */
    public static C1930b m14118a(C1943k c1943k, int i, InterfaceC2218f interfaceC2218f) {
        if (interfaceC2218f instanceof InterfaceC2222j) {
            return new C1932d(c1943k.f11328a.f11317a, c1943k, i, (InterfaceC2222j) interfaceC2218f);
        }
        if (interfaceC2218f instanceof C1984s) {
            return new C1935g(c1943k, i, (C1984s) interfaceC2218f);
        }
        switch (interfaceC2218f.mo14416a().f12386ei) {
            case ArrayPayload:
                return new C1929a(c1943k, i, (InterfaceC2177a) interfaceC2218f);
            case PackedSwitchPayload:
                return new C1933e(c1943k, i, (InterfaceC2186ai) interfaceC2218f);
            case SparseSwitchPayload:
                return new C1934f(c1943k, i, (InterfaceC2187aj) interfaceC2218f);
            default:
                return new C1930b(c1943k, i, interfaceC2218f);
        }
    }
}
