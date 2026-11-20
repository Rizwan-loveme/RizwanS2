package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: ProtoIdItem.java */
/* renamed from: com.b.b.c.c.aj */
/* loaded from: classes.dex */
public final class C0836aj extends AbstractC0871x {

    /* renamed from: a */
    private final C0973a f5177a;

    /* renamed from: b */
    private final C0970x f5178b;

    /* renamed from: c */
    private C0845as f5179c;

    public C0836aj(C0973a c0973a) {
        if (c0973a == null) {
            throw new NullPointerException("prototype == null");
        }
        this.f5177a = c0973a;
        this.f5178b = m7246a(c0973a);
        C0974b m8104c = c0973a.m8104c();
        this.f5179c = m8104c.m8550f_() == 0 ? null : new C0845as(m8104c);
    }

    /* renamed from: a */
    private static C0970x m7246a(C0973a c0973a) {
        C0974b m8104c = c0973a.m8104c();
        int f_ = m8104c.m8550f_();
        StringBuilder sb = new StringBuilder(f_ + 1);
        sb.append(m7245a(c0973a.m8103b()));
        for (int i = 0; i < f_; i++) {
            sb.append(m7245a(m8104c.mo6853a(i)));
        }
        return new C0970x(sb.toString());
    }

    /* renamed from: a */
    private static char m7245a(C0975c c0975c) {
        char charAt = c0975c.m8125h().charAt(0);
        if (charAt == '[') {
            return 'L';
        }
        return charAt;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_PROTO_ID_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public int mo7211g_() {
        return 12;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0842ap m7404h = c0860m.m7404h();
        C0844ar m7407k = c0860m.m7407k();
        C0833ag m7402f = c0860m.m7402f();
        m7407k.m7277a(this.f5177a.m8103b());
        m7404h.m7272a(this.f5178b);
        if (this.f5179c != null) {
            this.f5179c = (C0845as) m7402f.m7228b((C0833ag) this.f5179c);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int m7274b = c0860m.m7404h().m7274b(this.f5178b);
        int m7280b = c0860m.m7407k().m7280b(this.f5177a.m8103b());
        int m7233b = AbstractC0834ah.m7233b(this.f5179c);
        if (interfaceC1007a.mo8460a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5177a.m8103b().mo6681d());
            sb.append(" proto(");
            C0974b m8104c = this.f5177a.m8104c();
            int f_ = m8104c.m8550f_();
            for (int i = 0; i < f_; i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(m8104c.mo6853a(i).mo6681d());
            }
            sb.append(")");
            interfaceC1007a.mo8458a(0, m7437j() + ' ' + sb.toString());
            interfaceC1007a.mo8458a(4, "  shorty_idx:      " + C1022m.m8552a(m7274b) + " // " + this.f5178b.m8083i());
            interfaceC1007a.mo8458a(4, "  return_type_idx: " + C1022m.m8552a(m7280b) + " // " + this.f5177a.m8103b().mo6681d());
            interfaceC1007a.mo8458a(4, "  parameters_off:  " + C1022m.m8552a(m7233b));
        }
        interfaceC1007a.mo8523d(m7274b);
        interfaceC1007a.mo8523d(m7280b);
        interfaceC1007a.mo8523d(m7233b);
    }
}
