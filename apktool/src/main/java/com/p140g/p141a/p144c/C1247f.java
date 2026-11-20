package com.p140g.p141a.p144c;

import com.p140g.p141a.C1236a;
import com.p140g.p141a.p145d.C1278g;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2485c;
import org.p271f.p272a.p275c.C2504s;

/* compiled from: ExDex2Asm.java */
/* renamed from: com.g.a.c.f */
/* loaded from: classes.dex */
public class C1247f extends C1243b {

    /* renamed from: q */
    protected final InterfaceC1245d f8085q;

    public C1247f(InterfaceC1245d interfaceC1245d) {
        this.f8085q = interfaceC1245d;
    }

    @Override // com.p140g.p141a.p144c.C1243b
    /* renamed from: a */
    public void mo10307a(C1278g c1278g, AbstractC2526r abstractC2526r) {
        AbstractC2526r m15714a = C2485c.m15714a(abstractC2526r);
        C2504s c2504s = new C2504s(327680, c1278g.f8168a, c1278g.f8171d.m10398c(), c1278g.f8171d.m10397b(), (String) null, (String[]) null);
        try {
            super.mo10307a(c1278g, c2504s);
        } catch (Exception e2) {
            if (this.f8085q == null) {
                throw new C1236a(e2, "fail convert code for %s", c1278g.f8171d);
            }
            c2504s.f13058q.m15732c();
            c2504s.f13059r.clear();
            this.f8085q.m10328a(c1278g.f8171d, c1278g, c2504s, e2);
        }
        c2504s.m15749a(abstractC2526r);
        if (m15714a != null) {
            try {
                C2485c.m15717b(m15714a);
            } catch (Exception e3) {
                c2504s.f13058q.m15732c();
                c2504s.f13059r.clear();
                this.f8085q.m10328a(c1278g.f8171d, c1278g, c2504s, e3);
                C2485c.m15715a(m15714a, c2504s);
            }
        }
    }
}
