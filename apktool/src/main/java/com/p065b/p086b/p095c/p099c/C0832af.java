package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0951e;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;
import java.util.TreeMap;

/* compiled from: MethodIdsSection.java */
/* renamed from: com.b.b.c.c.af */
/* loaded from: classes.dex */
public final class C0832af extends AbstractC0829ac {

    /* renamed from: a */
    private final TreeMap<AbstractC0951e, C0831ae> f5159a;

    public C0832af(C0860m c0860m) {
        super("method_ids", c0860m);
        this.f5159a = new TreeMap<>();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5159a.values();
    }

    /* renamed from: a */
    public AbstractC0871x m7220a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        m7259i();
        C0831ae c0831ae = this.f5159a.get((AbstractC0951e) abstractC0945a);
        if (c0831ae == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0831ae;
    }

    /* renamed from: a */
    public void m7222a(InterfaceC1007a interfaceC1007a) {
        m7259i();
        int size = this.f5159a.size();
        int g = size == 0 ? 0 : m7257g();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "method_ids_size: " + C1022m.m8552a(size));
            interfaceC1007a.mo8458a(4, "method_ids_off:  " + C1022m.m8552a(g));
        }
        interfaceC1007a.mo8523d(size);
        interfaceC1007a.mo8523d(g);
    }

    /* renamed from: a */
    public C0831ae m7219a(AbstractC0951e abstractC0951e) {
        if (abstractC0951e == null) {
            throw new NullPointerException("method == null");
        }
        m7260j();
        C0831ae c0831ae = this.f5159a.get(abstractC0951e);
        if (c0831ae == null) {
            C0831ae c0831ae2 = new C0831ae(abstractC0951e);
            this.f5159a.put(abstractC0951e, c0831ae2);
            return c0831ae2;
        }
        return c0831ae;
    }

    /* renamed from: b */
    public int m7223b(AbstractC0951e abstractC0951e) {
        if (abstractC0951e == null) {
            throw new NullPointerException("ref == null");
        }
        m7259i();
        C0831ae c0831ae = this.f5159a.get(abstractC0951e);
        if (c0831ae == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0831ae.m7436i();
    }
}
