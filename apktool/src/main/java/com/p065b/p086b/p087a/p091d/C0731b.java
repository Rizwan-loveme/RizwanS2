package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p088a.C0704w;
import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.InterfaceC0740a;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: AttributeFactory.java */
/* renamed from: com.b.b.a.d.b */
/* loaded from: classes.dex */
public class C0731b {
    /* renamed from: a */
    public final InterfaceC0740a m6808a(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (c0735f == null) {
            throw new NullPointerException("cf == null");
        }
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("bad context");
        }
        C0970x c0970x = null;
        try {
            C1013d m6838a = c0735f.m6838a();
            InterfaceC0948b m6844f = c0735f.m6844f();
            int m8512f = m6838a.m8512f(i2);
            int m8508c = m6838a.m8508c(i2 + 2);
            c0970x = (C0970x) m6844f.mo8038a(m8512f);
            if (interfaceC0749j != null) {
                interfaceC0749j.m6900a(m6838a, i2, 2, "name: " + c0970x.mo6681d());
                interfaceC0749j.m6900a(m6838a, i2 + 2, 4, "length: " + C1022m.m8552a(m8508c));
            }
            return mo6809a(c0735f, i, c0970x.m8084j(), i2 + 6, m8508c, interfaceC0749j);
        } catch (C0748i e2) {
            e2.m8540a("...while parsing " + (c0970x != null ? c0970x.mo6681d() + " " : "") + "attribute at offset " + C1022m.m8552a(i2));
            throw e2;
        }
    }

    /* renamed from: a */
    protected InterfaceC0740a mo6809a(C0735f c0735f, int i, String str, int i2, int i3, InterfaceC0749j interfaceC0749j) {
        C1013d m6838a = c0735f.m6838a();
        C0704w c0704w = new C0704w(str, m6838a, i2, i3, c0735f.m6844f());
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i2, i3, "attribute data");
        }
        return c0704w;
    }
}
