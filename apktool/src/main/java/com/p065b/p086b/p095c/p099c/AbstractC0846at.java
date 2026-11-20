package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: UniformItemSection.java */
/* renamed from: com.b.b.c.c.at */
/* loaded from: classes.dex */
public abstract class AbstractC0846at extends AbstractC0838al {
    /* renamed from: b */
    protected abstract void mo7212b();

    public AbstractC0846at(String str, C0860m c0860m, int i) {
        super(str, c0860m, i);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: h_ */
    public final int mo7231h_() {
        Collection<? extends AbstractC0872y> a2 = mo7221a();
        int size = a2.size();
        if (size == 0) {
            return 0;
        }
        return a2.iterator().next().mo7211g_() * size;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: c */
    protected final void mo7229c() {
        C0860m e2 = m7255e();
        mo7212b();
        Iterator<? extends AbstractC0872y> it = mo7221a().iterator();
        while (it.hasNext()) {
            it.next().mo7201a(e2);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a_ */
    protected final void mo7227a_(InterfaceC1007a interfaceC1007a) {
        C0860m e2 = m7255e();
        int f2 = m7256f();
        Iterator<? extends AbstractC0872y> it = mo7221a().iterator();
        while (it.hasNext()) {
            it.next().mo7207a(e2, interfaceC1007a);
            interfaceC1007a.mo8531h(f2);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public final int mo7224a(AbstractC0872y abstractC0872y) {
        AbstractC0871x abstractC0871x = (AbstractC0871x) abstractC0872y;
        return m7252c(abstractC0871x.m7436i() * abstractC0871x.mo7211g_());
    }
}
