package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: ProtoIdsSection.java */
/* renamed from: com.b.b.c.c.ak */
/* loaded from: classes.dex */
public final class C0837ak extends AbstractC0846at {

    /* renamed from: a */
    private final TreeMap<C0973a, C0836aj> f5180a;

    public C0837ak(C0860m c0860m) {
        super("proto_ids", c0860m, 4);
        this.f5180a = new TreeMap<>();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5180a.values();
    }

    /* renamed from: b */
    public void m7249b(InterfaceC1007a interfaceC1007a) {
        m7259i();
        int size = this.f5180a.size();
        int g = size == 0 ? 0 : m7257g();
        if (size > 65536) {
            throw new UnsupportedOperationException("too many proto ids");
        }
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "proto_ids_size:  " + C1022m.m8552a(size));
            interfaceC1007a.mo8458a(4, "proto_ids_off:   " + C1022m.m8552a(g));
        }
        interfaceC1007a.mo8523d(size);
        interfaceC1007a.mo8523d(g);
    }

    /* renamed from: a */
    public C0836aj m7247a(C0973a c0973a) {
        if (c0973a == null) {
            throw new NullPointerException("prototype == null");
        }
        m7260j();
        C0836aj c0836aj = this.f5180a.get(c0973a);
        if (c0836aj == null) {
            C0836aj c0836aj2 = new C0836aj(c0973a);
            this.f5180a.put(c0973a, c0836aj2);
            return c0836aj2;
        }
        return c0836aj;
    }

    /* renamed from: b */
    public int m7248b(C0973a c0973a) {
        if (c0973a == null) {
            throw new NullPointerException("prototype == null");
        }
        m7259i();
        C0836aj c0836aj = this.f5180a.get(c0973a);
        if (c0836aj == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0836aj.m7436i();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0846at
    /* renamed from: b */
    protected void mo7212b() {
        int i = 0;
        Iterator<? extends AbstractC0872y> it = mo7221a().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                ((C0836aj) it.next()).m7434a(i2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
