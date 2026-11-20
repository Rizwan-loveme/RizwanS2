package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p095c.p097b.C0808j;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.io.PrintWriter;
import java.util.Iterator;

/* compiled from: CodeItem.java */
/* renamed from: com.b.b.c.c.j */
/* loaded from: classes.dex */
public final class C0857j extends AbstractC0834ah {

    /* renamed from: a */
    private final C0967u f5242a;

    /* renamed from: b */
    private final C0806h f5243b;

    /* renamed from: c */
    private C0853f f5244c;

    /* renamed from: d */
    private final boolean f5245d;

    /* renamed from: e */
    private final InterfaceC0977e f5246e;

    /* renamed from: f */
    private C0859l f5247f;

    public C0857j(C0967u c0967u, C0806h c0806h, boolean z, InterfaceC0977e interfaceC0977e) {
        super(4, -1);
        if (c0967u == null) {
            throw new NullPointerException("ref == null");
        }
        if (c0806h == null) {
            throw new NullPointerException("code == null");
        }
        if (interfaceC0977e == null) {
            throw new NullPointerException("throwsList == null");
        }
        this.f5242a = c0967u;
        this.f5243b = c0806h;
        this.f5245d = z;
        this.f5246e = interfaceC0977e;
        this.f5244c = null;
        this.f5247f = null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_CODE_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0833ag m7411o = c0860m.m7411o();
        C0844ar m7407k = c0860m.m7407k();
        if (this.f5243b.m7023a() || this.f5243b.m7024b()) {
            this.f5247f = new C0859l(this.f5243b, this.f5245d, this.f5242a);
            m7411o.m7225a((AbstractC0834ah) this.f5247f);
        }
        if (this.f5243b.m7025c()) {
            Iterator<C0975c> it = this.f5243b.m7026d().iterator();
            while (it.hasNext()) {
                m7407k.m7277a(it.next());
            }
            this.f5244c = new C0853f(this.f5243b);
        }
        Iterator<AbstractC0945a> it2 = this.f5243b.m7027e().iterator();
        while (it2.hasNext()) {
            c0860m.m7394a(it2.next());
        }
    }

    public String toString() {
        return "CodeItem{" + mo7204b() + "}";
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return this.f5242a.mo6681d();
    }

    /* renamed from: a */
    public void m7358a(PrintWriter printWriter, String str, boolean z) {
        printWriter.println(this.f5242a.mo6681d() + ":");
        C0808j m7028f = this.f5243b.m7028f();
        printWriter.println("regs: " + C1022m.m8557c(m7357e()) + "; ins: " + C1022m.m8557c(m7355c()) + "; outs: " + C1022m.m8557c(m7356d()));
        m7028f.m7052a(printWriter, str, z);
        String str2 = str + "  ";
        if (this.f5244c != null) {
            printWriter.print(str);
            printWriter.println("catches");
            this.f5244c.m7322a(printWriter, str2);
        }
        if (this.f5247f != null) {
            printWriter.print(str);
            printWriter.println("debug info");
            this.f5247f.m7387a(printWriter, str2);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        int i2;
        final C0860m m7255e = abstractC0838al.m7255e();
        this.f5243b.m7022a(new C0806h.a() { // from class: com.b.b.c.c.j.1
            @Override // com.p065b.p086b.p095c.p097b.C0806h.a
            /* renamed from: a */
            public int mo6954a(AbstractC0945a abstractC0945a) {
                AbstractC0871x m7398b = m7255e.m7398b(abstractC0945a);
                if (m7398b == null) {
                    return -1;
                }
                return m7398b.m7436i();
            }
        });
        if (this.f5244c != null) {
            this.f5244c.m7320a(m7255e);
            i2 = this.f5244c.m7323b();
        } else {
            i2 = 0;
        }
        int m7053e = this.f5243b.m7028f().m7053e();
        if ((m7053e & 1) != 0) {
            m7053e++;
        }
        m7234a(i2 + (m7053e * 2) + 16);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        int m7357e = m7357e();
        int m7356d = m7356d();
        int m7355c = m7355c();
        int m7053e = this.f5243b.m7028f().m7053e();
        boolean z = (m7053e & 1) != 0;
        int m7319a = this.f5244c == null ? 0 : this.f5244c.m7319a();
        int f2 = this.f5247f == null ? 0 : this.f5247f.m7237f();
        if (mo8460a) {
            interfaceC1007a.mo8458a(0, m7239h() + ' ' + this.f5242a.mo6681d());
            interfaceC1007a.mo8458a(2, "  registers_size: " + C1022m.m8557c(m7357e));
            interfaceC1007a.mo8458a(2, "  ins_size:       " + C1022m.m8557c(m7355c));
            interfaceC1007a.mo8458a(2, "  outs_size:      " + C1022m.m8557c(m7356d));
            interfaceC1007a.mo8458a(2, "  tries_size:     " + C1022m.m8557c(m7319a));
            interfaceC1007a.mo8458a(4, "  debug_off:      " + C1022m.m8552a(f2));
            interfaceC1007a.mo8458a(4, "  insns_size:     " + C1022m.m8552a(m7053e));
            if (this.f5246e.mo6856f_() != 0) {
                interfaceC1007a.mo8458a(0, "  throws " + C0974b.m8109a(this.f5246e));
            }
        }
        interfaceC1007a.mo8522b(m7357e);
        interfaceC1007a.mo8522b(m7355c);
        interfaceC1007a.mo8522b(m7356d);
        interfaceC1007a.mo8522b(m7319a);
        interfaceC1007a.mo8523d(f2);
        interfaceC1007a.mo8523d(m7053e);
        m7354b(c0860m, interfaceC1007a);
        if (this.f5244c != null) {
            if (z) {
                if (mo8460a) {
                    interfaceC1007a.mo8458a(2, "  padding: 0");
                }
                interfaceC1007a.mo8522b(0);
            }
            this.f5244c.m7321a(c0860m, interfaceC1007a);
        }
        if (mo8460a && this.f5247f != null) {
            interfaceC1007a.mo8458a(0, "  debug info");
            this.f5247f.m7386a(c0860m, interfaceC1007a, "    ");
        }
    }

    /* renamed from: b */
    private void m7354b(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        try {
            this.f5243b.m7028f().m7051a(interfaceC1007a);
        } catch (RuntimeException e2) {
            throw C1019j.m8537a(e2, "...while writing instructions for " + this.f5242a.mo6681d());
        }
    }

    /* renamed from: c */
    private int m7355c() {
        return this.f5242a.m8046b(this.f5245d);
    }

    /* renamed from: d */
    private int m7356d() {
        return this.f5243b.m7028f().m7055g();
    }

    /* renamed from: e */
    private int m7357e() {
        return this.f5243b.m7028f().m7054f();
    }
}
