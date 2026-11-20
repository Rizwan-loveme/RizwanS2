package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: HeaderItem.java */
/* renamed from: com.b.b.c.c.u */
/* loaded from: classes.dex */
public final class C0868u extends AbstractC0871x {
    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_HEADER_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public int mo7211g_() {
        return 112;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int g = c0860m.m7403g().m7257g();
        AbstractC0838al m7412p = c0860m.m7412p();
        AbstractC0838al m7413q = c0860m.m7413q();
        int m7257g = m7412p.m7257g();
        int m7257g2 = (m7413q.m7257g() + m7413q.mo7231h_()) - m7257g;
        String m6962a = c0860m.m7397b().m6962a();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(8, "magic: " + new C0970x(m6962a).m8083i());
            interfaceC1007a.mo8458a(4, "checksum");
            interfaceC1007a.mo8458a(20, "signature");
            interfaceC1007a.mo8458a(4, "file_size:       " + C1022m.m8552a(c0860m.m7399c()));
            interfaceC1007a.mo8458a(4, "header_size:     " + C1022m.m8552a(112));
            interfaceC1007a.mo8458a(4, "endian_tag:      " + C1022m.m8552a(305419896));
            interfaceC1007a.mo8458a(4, "link_size:       0");
            interfaceC1007a.mo8458a(4, "link_off:        0");
            interfaceC1007a.mo8458a(4, "map_off:         " + C1022m.m8552a(g));
        }
        for (int i = 0; i < 8; i++) {
            interfaceC1007a.mo7631c(m6962a.charAt(i));
        }
        interfaceC1007a.mo8529g(24);
        interfaceC1007a.mo8523d(c0860m.m7399c());
        interfaceC1007a.mo8523d(112);
        interfaceC1007a.mo8523d(305419896);
        interfaceC1007a.mo8529g(8);
        interfaceC1007a.mo8523d(g);
        c0860m.m7404h().m7275b(interfaceC1007a);
        c0860m.m7407k().m7281b(interfaceC1007a);
        c0860m.m7408l().m7249b(interfaceC1007a);
        c0860m.m7409m().m7431a(interfaceC1007a);
        c0860m.m7410n().m7222a(interfaceC1007a);
        c0860m.m7405i().m7353a(interfaceC1007a);
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "data_size:       " + C1022m.m8552a(m7257g2));
            interfaceC1007a.mo8458a(4, "data_off:        " + C1022m.m8552a(m7257g));
        }
        interfaceC1007a.mo8523d(m7257g2);
        interfaceC1007a.mo8523d(m7257g);
    }
}
