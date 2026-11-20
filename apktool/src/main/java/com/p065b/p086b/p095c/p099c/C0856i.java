package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: ClassDefsSection.java */
/* renamed from: com.b.b.c.c.i */
/* loaded from: classes.dex */
public final class C0856i extends AbstractC0846at {

    /* renamed from: a */
    private final TreeMap<C0975c, C0855h> f5240a;

    /* renamed from: b */
    private ArrayList<C0855h> f5241b;

    public C0856i(C0860m c0860m) {
        super("class_defs", c0860m, 4);
        this.f5240a = new TreeMap<>();
        this.f5241b = null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0838al
    /* renamed from: a */
    public Collection<? extends AbstractC0872y> mo7221a() {
        return this.f5241b != null ? this.f5241b : this.f5240a.values();
    }

    /* renamed from: a */
    public AbstractC0871x m7351a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        m7259i();
        C0855h c0855h = this.f5240a.get(((C0971y) abstractC0945a).m8090i());
        if (c0855h == null) {
            throw new IllegalArgumentException("not found");
        }
        return c0855h;
    }

    /* renamed from: a */
    public void m7353a(InterfaceC1007a interfaceC1007a) {
        m7259i();
        int size = this.f5240a.size();
        int g = size == 0 ? 0 : m7257g();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(4, "class_defs_size: " + C1022m.m8552a(size));
            interfaceC1007a.mo8458a(4, "class_defs_off:  " + C1022m.m8552a(g));
        }
        interfaceC1007a.mo8523d(size);
        interfaceC1007a.mo8523d(g);
    }

    /* renamed from: a */
    public void m7352a(C0855h c0855h) {
        try {
            C0975c m8090i = c0855h.m7345c().m8090i();
            m7260j();
            if (this.f5240a.get(m8090i) != null) {
                throw new IllegalArgumentException("already added: " + m8090i);
            }
            this.f5240a.put(m8090i, c0855h);
        } catch (NullPointerException e2) {
            throw new NullPointerException("clazz == null");
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0846at
    /* renamed from: b */
    protected void mo7212b() {
        int size = this.f5240a.size();
        int i = 0;
        this.f5241b = new ArrayList<>(size);
        Iterator<C0975c> it = this.f5240a.keySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = m7350a(it.next(), i2, size - i2);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private int m7350a(C0975c c0975c, int i, int i2) {
        C0855h c0855h = this.f5240a.get(c0975c);
        if (c0855h != null && !c0855h.m7435h()) {
            if (i2 < 0) {
                throw new RuntimeException("class circularity with " + c0975c);
            }
            int i3 = i2 - 1;
            C0971y m7346d = c0855h.m7346d();
            if (m7346d != null) {
                i = m7350a(m7346d.m8090i(), i, i3);
            }
            InterfaceC0977e m7347e = c0855h.m7347e();
            int mo6856f_ = m7347e.mo6856f_();
            for (int i4 = 0; i4 < mo6856f_; i4++) {
                i = m7350a(m7347e.mo6853a(i4), i, i3);
            }
            c0855h.m7434a(i);
            this.f5241b.add(c0855h);
            return i + 1;
        }
        return i;
    }
}
