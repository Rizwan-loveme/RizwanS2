package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: StringIdsSection.java */
/* renamed from: com.b.b.c.c.ap */
/* loaded from: classes.dex */
public final class C0842ap extends AbstractC0846at {

    /* renamed from: a */
    private final TreeMap<C0970x, C0841ao> f5195a;

    public C0842ap(C0860m c0860m) {
        super("string_ids", c0860m, 4);
        this.f5195a = new TreeMap<>();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5195a.values();
    }

    /* renamed from: a */
    public AbstractC0871x m7273a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        m7259i();
        C0841ao c0841ao = this.f5195a.get((C0970x) abstractC0945a);
        if (c0841ao == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0841ao;
    }

    /* renamed from: b */
    public void m7275b(InterfaceC1007a interfaceC1007a) {
        m7259i();
        int size = this.f5195a.size();
        int g = size == 0 ? 0 : m7257g();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "string_ids_size: " + C1022m.m8552a(size));
            interfaceC1007a.mo8458a(4, "string_ids_off:  " + C1022m.m8552a(g));
        }
        interfaceC1007a.mo8523d(size);
        interfaceC1007a.mo8523d(g);
    }

    /* renamed from: a */
    public C0841ao m7272a(C0970x c0970x) {
        return m7271a(new C0841ao(c0970x));
    }

    /* renamed from: a */
    public C0841ao m7271a(C0841ao c0841ao) {
        if (c0841ao == null) {
            throw new NullPointerException("string == null");
        }
        m7260j();
        C0970x m7270c = c0841ao.m7270c();
        C0841ao c0841ao2 = this.f5195a.get(m7270c);
        if (c0841ao2 == null) {
            this.f5195a.put(m7270c, c0841ao);
            return c0841ao;
        }
        return c0841ao2;
    }

    /* renamed from: b */
    public int m7274b(C0970x c0970x) {
        if (c0970x == null) {
            throw new NullPointerException("string == null");
        }
        m7259i();
        C0841ao c0841ao = this.f5195a.get(c0970x);
        if (c0841ao == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0841ao.m7436i();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0846at
    /* renamed from: b */
    protected void mo7212b() {
        int i = 0;
        Iterator<C0841ao> it = this.f5195a.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                it.next().m7434a(i2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
