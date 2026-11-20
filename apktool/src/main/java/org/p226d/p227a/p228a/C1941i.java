package org.p226d.p227a.p228a;

import java.util.Set;
import org.p226d.p227a.C1950b;
import org.p226d.p227a.p228a.p230b.AbstractC1927c;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p263h.C2383c;
import org.p226d.p269d.C2457k;

/* compiled from: FieldDefinition.java */
/* renamed from: org.d.a.a.i */
/* loaded from: classes.dex */
public class C1941i {
    /* renamed from: a */
    public static void m14138a(C1950b c1950b, C2457k c2457k, InterfaceC2266g interfaceC2266g, boolean z) {
        InterfaceC2251g mo14223b = interfaceC2266g.mo14223b();
        int mo14222a = interfaceC2266g.mo14222a();
        if (z && EnumC1959a.STATIC.m14192a(mo14222a) && EnumC1959a.FINAL.m14192a(mo14222a) && mo14223b != null) {
            if (C2383c.m15080a(mo14223b)) {
                mo14223b = null;
            } else {
                c2457k.write("# The value of this static final field might be set in the static constructor\n");
            }
        }
        c2457k.write(".field ");
        m14139a(c2457k, interfaceC2266g.mo14222a());
        c2457k.write(interfaceC2266g.mo14226e());
        c2457k.write(58);
        c2457k.write(interfaceC2266g.mo14227f());
        if (mo14223b != null) {
            c2457k.write(" = ");
            AbstractC1927c.m14096a(c2457k, mo14223b, c1950b.f11364j ? interfaceC2266g.mo14225d() : null);
        }
        c2457k.write(10);
        Set<? extends InterfaceC2165a> mo14224c = interfaceC2266g.mo14224c();
        if (mo14224c.size() > 0) {
            c2457k.m15532a(4);
            C1914a.m14087a(c2457k, mo14224c, c1950b.f11364j ? interfaceC2266g.mo14225d() : null);
            c2457k.m15534b(4);
            c2457k.write(".end field\n");
        }
    }

    /* renamed from: a */
    private static void m14139a(C2457k c2457k, int i) {
        for (EnumC1959a enumC1959a : EnumC1959a.m14189f(i)) {
            c2457k.write(enumC1959a.toString());
            c2457k.write(32);
        }
    }
}
