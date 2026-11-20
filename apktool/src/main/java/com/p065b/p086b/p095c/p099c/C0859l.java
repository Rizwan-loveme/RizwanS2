package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p095c.p097b.C0808j;
import com.p065b.p086b.p095c.p097b.C0815q;
import com.p065b.p086b.p095c.p097b.C0821w;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.io.PrintWriter;

/* compiled from: DebugInfoItem.java */
/* renamed from: com.b.b.c.c.l */
/* loaded from: classes.dex */
public class C0859l extends AbstractC0834ah {

    /* renamed from: a */
    private final C0806h f5267a;

    /* renamed from: b */
    private byte[] f5268b;

    /* renamed from: c */
    private final boolean f5269c;

    /* renamed from: d */
    private final C0967u f5270d;

    public C0859l(C0806h c0806h, boolean z, C0967u c0967u) {
        super(1, -1);
        if (c0806h == null) {
            throw new NullPointerException("code == null");
        }
        this.f5267a = c0806h;
        this.f5269c = z;
        this.f5270d = c0967u;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_DEBUG_INFO_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        try {
            this.f5268b = m7384a(abstractC0838al.m7255e(), null, null, null, false);
            m7234a(this.f5268b.length);
        } catch (RuntimeException e2) {
            throw C1019j.m8537a(e2, "...while placing debug info for " + this.f5270d.mo6681d());
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        throw new RuntimeException("unsupported");
    }

    /* renamed from: a */
    public void m7386a(C0860m c0860m, InterfaceC1007a interfaceC1007a, String str) {
        m7384a(c0860m, str, null, interfaceC1007a, false);
    }

    /* renamed from: a */
    public void m7387a(PrintWriter printWriter, String str) {
        m7384a(null, str, printWriter, null, false);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8459a(m7239h() + " debug info");
            m7384a(c0860m, null, null, interfaceC1007a, true);
        }
        interfaceC1007a.mo8520a(this.f5268b);
    }

    /* renamed from: a */
    private byte[] m7384a(C0860m c0860m, String str, PrintWriter printWriter, InterfaceC1007a interfaceC1007a, boolean z) {
        return m7385b(c0860m, str, printWriter, interfaceC1007a, z);
    }

    /* renamed from: b */
    private byte[] m7385b(C0860m c0860m, String str, PrintWriter printWriter, InterfaceC1007a interfaceC1007a, boolean z) {
        C0821w m7030h = this.f5267a.m7030h();
        C0815q m7031i = this.f5267a.m7031i();
        C0808j m7028f = this.f5267a.m7028f();
        C0858k c0858k = new C0858k(m7030h, m7031i, c0860m, m7028f.m7053e(), m7028f.m7054f(), this.f5269c, this.f5270d);
        if (printWriter == null && interfaceC1007a == null) {
            return c0858k.m7380a();
        }
        return c0858k.m7381a(str, printWriter, interfaceC1007a, z);
    }
}
