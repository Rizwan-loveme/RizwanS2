package org.p226d.p227a.p228a.p231c;

import android.icu.text.DateFormat;
import java.util.List;
import org.p226d.p227a.p228a.C1943k;
import org.p226d.p227a.p232b.C1957g;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;
import org.p226d.p269d.C2457k;

/* compiled from: ArrayDataMethodItem.java */
/* renamed from: org.d.a.a.c.a */
/* loaded from: classes.dex */
public class C1929a extends C1930b<InterfaceC2177a> {
    public C1929a(C1943k c1943k, int i, InterfaceC2177a interfaceC2177a) {
        super(c1943k, i, interfaceC2177a);
    }

    @Override // org.p226d.p227a.p228a.p231c.C1930b, org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        String str;
        int mo14479e = ((InterfaceC2177a) this.f11284b).mo14479e();
        c2457k.write(".array-data ");
        c2457k.m15536c(((InterfaceC2177a) this.f11284b).mo14479e());
        c2457k.write(10);
        c2457k.m15532a(4);
        List<Number> mo14480f = ((InterfaceC2177a) this.f11284b).mo14480f();
        switch (mo14479e) {
            case 1:
                str = "t";
                break;
            case 2:
                str = DateFormat.SECOND;
                break;
            default:
                str = "";
                break;
        }
        for (Number number : mo14480f) {
            C1957g.m14181b(c2457k, number.longValue());
            c2457k.write(str);
            if (mo14479e == 8) {
                m14100a(c2457k, number.longValue());
            } else if (mo14479e == 4) {
                int intValue = number.intValue();
                if (!m14104c(c2457k, intValue)) {
                    m14102b(c2457k, intValue);
                }
            }
            c2457k.write("\n");
        }
        c2457k.m15534b(4);
        c2457k.write(".end array-data");
        return true;
    }
}
