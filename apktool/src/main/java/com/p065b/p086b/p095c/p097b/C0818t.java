package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: OddSpacer.java */
/* renamed from: com.b.b.c.b.t */
/* loaded from: classes.dex */
public final class C0818t extends AbstractC0798ad {
    public C0818t(C0940v c0940v) {
        super(c0940v, C0935q.f5906a);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public int mo6964a() {
        return m7040g() & 1;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public void mo6967a(InterfaceC1007a interfaceC1007a) {
        if (mo6964a() != 0) {
            interfaceC1007a.mo8522b(AbstractC0813o.m7071a(0, 0));
        }
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    public AbstractC0807i mo6965a(C0935q c0935q) {
        return new C0818t(m7042i());
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: b */
    protected String mo6968b() {
        return null;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0807i
    /* renamed from: a */
    protected String mo6966a(boolean z) {
        if (mo6964a() == 0) {
            return null;
        }
        return "nop // spacer";
    }
}
