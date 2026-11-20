package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.AbstractC0951e;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1029t;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.io.PrintWriter;

/* compiled from: EncodedMethod.java */
/* renamed from: com.b.b.c.c.q */
/* loaded from: classes.dex */
public final class C0864q extends AbstractC0863p implements Comparable<C0864q> {

    /* renamed from: a */
    private final C0967u f5292a;

    /* renamed from: b */
    private final C0857j f5293b;

    public C0864q(C0967u c0967u, int i, C0806h c0806h, InterfaceC0977e interfaceC0977e) {
        super(i);
        if (c0967u == null) {
            throw new NullPointerException("method == null");
        }
        this.f5292a = c0967u;
        if (c0806h == null) {
            this.f5293b = null;
        } else {
            this.f5293b = new C0857j(c0967u, c0806h, (i & 8) != 0, interfaceC0977e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0864q) && compareTo((C0864q) obj) == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0864q c0864q) {
        return this.f5292a.compareTo(c0864q.f5292a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(C1022m.m8557c(m7419b()));
        stringBuffer.append(' ');
        stringBuffer.append(this.f5292a);
        if (this.f5293b != null) {
            stringBuffer.append(' ');
            stringBuffer.append(this.f5293b);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void m7422a(C0860m c0860m) {
        C0832af m7410n = c0860m.m7410n();
        C0833ag m7401e = c0860m.m7401e();
        m7410n.m7219a((AbstractC0951e) this.f5292a);
        if (this.f5293b != null) {
            m7401e.m7225a((AbstractC0834ah) this.f5293b);
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public final String mo6681d() {
        return this.f5292a.mo6681d();
    }

    /* renamed from: a */
    public final C0970x m7421a() {
        return this.f5292a.m8071n().m8072a();
    }

    /* renamed from: a */
    public void m7423a(PrintWriter printWriter, boolean z) {
        if (this.f5293b == null) {
            printWriter.println(m7424c().mo6681d() + ": abstract or native");
        } else {
            this.f5293b.m7358a(printWriter, "  ", z);
        }
    }

    /* renamed from: c */
    public final C0967u m7424c() {
        return this.f5292a;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0863p
    /* renamed from: a */
    public int mo7415a(C0860m c0860m, InterfaceC1007a interfaceC1007a, int i, int i2) {
        int m7223b = c0860m.m7410n().m7223b(this.f5292a);
        int i3 = m7223b - i;
        int b2 = m7419b();
        int m7233b = AbstractC0834ah.m7233b(this.f5293b);
        if ((m7233b != 0) != ((b2 & 1280) == 0)) {
            throw new UnsupportedOperationException("code vs. access_flags mismatch");
        }
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, String.format("  [%x] %s", Integer.valueOf(i2), this.f5292a.mo6681d()));
            interfaceC1007a.mo8458a(C1029t.m8588a(i3), "    method_idx:   " + C1022m.m8552a(m7223b));
            interfaceC1007a.mo8458a(C1029t.m8588a(b2), "    access_flags: " + C0919a.m7839d(b2));
            interfaceC1007a.mo8458a(C1029t.m8588a(m7233b), "    code_off:     " + C1022m.m8552a(m7233b));
        }
        interfaceC1007a.mo8524e(i3);
        interfaceC1007a.mo8524e(b2);
        interfaceC1007a.mo8524e(m7233b);
        return m7223b;
    }
}
