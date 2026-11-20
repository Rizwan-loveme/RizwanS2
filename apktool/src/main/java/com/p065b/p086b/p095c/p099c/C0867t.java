package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;
import java.util.TreeMap;

/* compiled from: FieldIdsSection.java */
/* renamed from: com.b.b.c.c.t */
/* loaded from: classes.dex */
public final class C0867t extends AbstractC0829ac {

    /* renamed from: a */
    private final TreeMap<C0957k, C0866s> f5296a;

    public C0867t(C0860m c0860m) {
        super("field_ids", c0860m);
        this.f5296a = new TreeMap<>();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5296a.values();
    }

    /* renamed from: a */
    public AbstractC0871x m7430a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        m7259i();
        C0866s c0866s = this.f5296a.get((C0957k) abstractC0945a);
        if (c0866s == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0866s;
    }

    /* renamed from: a */
    public void m7431a(InterfaceC1007a interfaceC1007a) {
        m7259i();
        int size = this.f5296a.size();
        int g = size == 0 ? 0 : m7257g();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "field_ids_size:  " + C1022m.m8552a(size));
            interfaceC1007a.mo8458a(4, "field_ids_off:   " + C1022m.m8552a(g));
        }
        interfaceC1007a.mo8523d(size);
        interfaceC1007a.mo8523d(g);
    }

    /* renamed from: a */
    public C0866s m7429a(C0957k c0957k) {
        if (c0957k == null) {
            throw new NullPointerException("field == null");
        }
        m7260j();
        C0866s c0866s = this.f5296a.get(c0957k);
        if (c0866s == null) {
            C0866s c0866s2 = new C0866s(c0957k);
            this.f5296a.put(c0957k, c0866s2);
            return c0866s2;
        }
        return c0866s;
    }

    /* renamed from: b */
    public int m7432b(C0957k c0957k) {
        if (c0957k == null) {
            throw new NullPointerException("ref == null");
        }
        m7259i();
        C0866s c0866s = this.f5296a.get(c0957k);
        if (c0866s == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0866s.m7436i();
    }
}
