package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0950d;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;

/* compiled from: ClassDefItem.java */
/* renamed from: com.b.b.c.c.h */
/* loaded from: classes.dex */
public final class C0855h extends AbstractC0871x {

    /* renamed from: a */
    private final C0971y f5232a;

    /* renamed from: b */
    private final int f5233b;

    /* renamed from: c */
    private final C0971y f5234c;

    /* renamed from: d */
    private C0845as f5235d;

    /* renamed from: e */
    private final C0970x f5236e;

    /* renamed from: f */
    private final C0854g f5237f;

    /* renamed from: g */
    private C0861n f5238g;

    /* renamed from: h */
    private C0852e f5239h;

    public C0855h(C0971y c0971y, int i, C0971y c0971y2, InterfaceC0977e interfaceC0977e, C0970x c0970x) {
        if (c0971y == null) {
            throw new NullPointerException("thisClass == null");
        }
        if (interfaceC0977e == null) {
            throw new NullPointerException("interfaces == null");
        }
        this.f5232a = c0971y;
        this.f5233b = i;
        this.f5234c = c0971y2;
        this.f5235d = interfaceC0977e.mo6856f_() == 0 ? null : new C0845as(interfaceC0977e);
        this.f5236e = c0970x;
        this.f5237f = new C0854g(c0971y);
        this.f5238g = null;
        this.f5239h = new C0852e();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_CLASS_DEF_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public int mo7211g_() {
        return 32;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0844ar m7407k = c0860m.m7407k();
        C0833ag m7411o = c0860m.m7411o();
        C0833ag m7401e = c0860m.m7401e();
        C0833ag m7402f = c0860m.m7402f();
        C0842ap m7404h = c0860m.m7404h();
        m7407k.m7276a(this.f5232a);
        if (!this.f5237f.m7332c()) {
            c0860m.m7406j().m7225a((AbstractC0834ah) this.f5237f);
            C0950d m7334e = this.f5237f.m7334e();
            if (m7334e != null) {
                this.f5238g = (C0861n) m7411o.m7228b((C0833ag) new C0861n(m7334e));
            }
        }
        if (this.f5234c != null) {
            m7407k.m7276a(this.f5234c);
        }
        if (this.f5235d != null) {
            this.f5235d = (C0845as) m7402f.m7228b((C0833ag) this.f5235d);
        }
        if (this.f5236e != null) {
            m7404h.m7272a(this.f5236e);
        }
        if (!this.f5239h.m7314c()) {
            if (this.f5239h.m7315d()) {
                this.f5239h = (C0852e) m7401e.m7228b((C0833ag) this.f5239h);
            } else {
                m7401e.m7225a((AbstractC0834ah) this.f5239h);
            }
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        C0844ar m7407k = c0860m.m7407k();
        int m7279b = m7407k.m7279b(this.f5232a);
        int m7279b2 = this.f5234c == null ? -1 : m7407k.m7279b(this.f5234c);
        int m7233b = AbstractC0834ah.m7233b(this.f5235d);
        int f2 = this.f5239h.m7314c() ? 0 : this.f5239h.m7237f();
        int m7274b = this.f5236e == null ? -1 : c0860m.m7404h().m7274b(this.f5236e);
        int f3 = this.f5237f.m7332c() ? 0 : this.f5237f.m7237f();
        int m7233b2 = AbstractC0834ah.m7233b(this.f5238g);
        if (mo8460a) {
            interfaceC1007a.mo8458a(0, m7437j() + ' ' + this.f5232a.mo6681d());
            interfaceC1007a.mo8458a(4, "  class_idx:           " + C1022m.m8552a(m7279b));
            interfaceC1007a.mo8458a(4, "  access_flags:        " + C0919a.m7835a(this.f5233b));
            interfaceC1007a.mo8458a(4, "  superclass_idx:      " + C1022m.m8552a(m7279b2) + " // " + (this.f5234c == null ? "<none>" : this.f5234c.mo6681d()));
            interfaceC1007a.mo8458a(4, "  interfaces_off:      " + C1022m.m8552a(m7233b));
            if (m7233b != 0) {
                InterfaceC0977e m7282c = this.f5235d.m7282c();
                int mo6856f_ = m7282c.mo6856f_();
                for (int i = 0; i < mo6856f_; i++) {
                    interfaceC1007a.mo8458a(0, "    " + m7282c.mo6853a(i).mo6681d());
                }
            }
            interfaceC1007a.mo8458a(4, "  source_file_idx:     " + C1022m.m8552a(m7274b) + " // " + (this.f5236e == null ? "<none>" : this.f5236e.mo6681d()));
            interfaceC1007a.mo8458a(4, "  annotations_off:     " + C1022m.m8552a(f2));
            interfaceC1007a.mo8458a(4, "  class_data_off:      " + C1022m.m8552a(f3));
            interfaceC1007a.mo8458a(4, "  static_values_off:   " + C1022m.m8552a(m7233b2));
        }
        interfaceC1007a.mo8523d(m7279b);
        interfaceC1007a.mo8523d(this.f5233b);
        interfaceC1007a.mo8523d(m7279b2);
        interfaceC1007a.mo8523d(m7233b);
        interfaceC1007a.mo8523d(m7274b);
        interfaceC1007a.mo8523d(f2);
        interfaceC1007a.mo8523d(f3);
        interfaceC1007a.mo8523d(m7233b2);
    }

    /* renamed from: c */
    public C0971y m7345c() {
        return this.f5232a;
    }

    /* renamed from: d */
    public C0971y m7346d() {
        return this.f5234c;
    }

    /* renamed from: e */
    public InterfaceC0977e m7347e() {
        return this.f5235d == null ? C0974b.f6209a : this.f5235d.m7282c();
    }

    /* renamed from: f */
    public C0970x m7348f() {
        return this.f5236e;
    }

    /* renamed from: a */
    public void m7337a(C0862o c0862o, AbstractC0945a abstractC0945a) {
        this.f5237f.m7329a(c0862o, abstractC0945a);
    }

    /* renamed from: a */
    public void m7336a(C0862o c0862o) {
        this.f5237f.m7328a(c0862o);
    }

    /* renamed from: a */
    public void m7338a(C0864q c0864q) {
        this.f5237f.m7330a(c0864q);
    }

    /* renamed from: b */
    public void m7344b(C0864q c0864q) {
        this.f5237f.m7331b(c0864q);
    }

    /* renamed from: g */
    public ArrayList<C0864q> m7349g() {
        return this.f5237f.m7333d();
    }

    /* renamed from: a */
    public void m7339a(C0916c c0916c) {
        this.f5239h.m7309a(c0916c);
    }

    /* renamed from: a */
    public void m7340a(C0957k c0957k, C0916c c0916c) {
        this.f5239h.m7310a(c0957k, c0916c);
    }

    /* renamed from: a */
    public void m7341a(C0967u c0967u, C0916c c0916c) {
        this.f5239h.m7311a(c0967u, c0916c);
    }

    /* renamed from: a */
    public void m7342a(C0967u c0967u, C0917d c0917d) {
        this.f5239h.m7312a(c0967u, c0917d);
    }

    /* renamed from: a */
    public C0916c m7335a(C0967u c0967u) {
        return this.f5239h.m7308a(c0967u);
    }

    /* renamed from: b */
    public C0917d m7343b(C0967u c0967u) {
        return this.f5239h.m7313b(c0967u);
    }
}
