package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: TypeIdsSection.java */
/* renamed from: com.b.b.c.c.ar */
/* loaded from: classes.dex */
public final class C0844ar extends AbstractC0846at {

    /* renamed from: a */
    private final TreeMap<C0975c, C0843aq> f5196a;

    public C0844ar(C0860m c0860m) {
        super("type_ids", c0860m, 4);
        this.f5196a = new TreeMap<>();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5196a.values();
    }

    /* renamed from: a */
    public AbstractC0871x m7278a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        m7259i();
        C0843aq c0843aq = this.f5196a.get(((C0971y) abstractC0945a).m8090i());
        if (c0843aq == null) {
            throw new IllegalArgumentException("not found: " + abstractC0945a);
        }
        return c0843aq;
    }

    /* renamed from: b */
    public void m7281b(InterfaceC1007a interfaceC1007a) {
        m7259i();
        int size = this.f5196a.size();
        int g = size == 0 ? 0 : m7257g();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many type ids");
        }
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "type_ids_size:   " + C1022m.m8552a(size));
            interfaceC1007a.mo8458a(4, "type_ids_off:    " + C1022m.m8552a(g));
        }
        interfaceC1007a.mo8523d(size);
        interfaceC1007a.mo8523d(g);
    }

    /* renamed from: a */
    public C0843aq m7277a(C0975c c0975c) {
        if (c0975c == null) {
            throw new NullPointerException("type == null");
        }
        m7260j();
        C0843aq c0843aq = this.f5196a.get(c0975c);
        if (c0843aq == null) {
            C0843aq c0843aq2 = new C0843aq(new C0971y(c0975c));
            this.f5196a.put(c0975c, c0843aq2);
            return c0843aq2;
        }
        return c0843aq;
    }

    /* renamed from: a */
    public C0843aq m7276a(C0971y c0971y) {
        if (c0971y == null) {
            throw new NullPointerException("type == null");
        }
        m7260j();
        C0975c m8090i = c0971y.m8090i();
        C0843aq c0843aq = this.f5196a.get(m8090i);
        if (c0843aq == null) {
            C0843aq c0843aq2 = new C0843aq(c0971y);
            this.f5196a.put(m8090i, c0843aq2);
            return c0843aq2;
        }
        return c0843aq;
    }

    /* renamed from: b */
    public int m7280b(C0975c c0975c) {
        if (c0975c == null) {
            throw new NullPointerException("type == null");
        }
        m7259i();
        C0843aq c0843aq = this.f5196a.get(c0975c);
        if (c0843aq == null) {
            throw new IllegalArgumentException("not found: " + c0975c);
        }
        return c0843aq.m7436i();
    }

    /* renamed from: b */
    public int m7279b(C0971y c0971y) {
        if (c0971y == null) {
            throw new NullPointerException("type == null");
        }
        return m7280b(c0971y.m8090i());
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0846at
    /* renamed from: b */
    protected void mo7212b() {
        int i = 0;
        Iterator<? extends AbstractC0872y> it = mo7221a().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                ((C0843aq) it.next()).m7434a(i2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
