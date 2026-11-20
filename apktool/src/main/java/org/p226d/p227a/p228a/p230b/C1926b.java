package org.p226d.p227a.p228a.p230b;

import java.util.List;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p269d.C2457k;

/* compiled from: ArrayEncodedValueAdaptor.java */
/* renamed from: org.d.a.a.b.b */
/* loaded from: classes.dex */
public class C1926b {
    /* renamed from: a */
    public static void m14095a(C2457k c2457k, InterfaceC2246b interfaceC2246b, String str) {
        c2457k.write(123);
        List<? extends InterfaceC2251g> mo14733b = interfaceC2246b.mo14733b();
        if (mo14733b.size() == 0) {
            c2457k.write(125);
            return;
        }
        c2457k.write(10);
        c2457k.m15532a(4);
        boolean z = true;
        for (InterfaceC2251g interfaceC2251g : mo14733b) {
            if (!z) {
                c2457k.write(",\n");
            }
            z = false;
            AbstractC1927c.m14096a(c2457k, interfaceC2251g, str);
        }
        c2457k.m15534b(4);
        c2457k.write("\n}");
    }
}
