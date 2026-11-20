package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p103f.p106c.C0947ab;
import com.p065b.p086b.p103f.p106c.C0950d;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ClassDataItem.java */
/* renamed from: com.b.b.c.c.g */
/* loaded from: classes.dex */
public final class C0854g extends AbstractC0834ah {

    /* renamed from: a */
    private final C0971y f5224a;

    /* renamed from: b */
    private final ArrayList<C0862o> f5225b;

    /* renamed from: c */
    private final HashMap<C0862o, AbstractC0945a> f5226c;

    /* renamed from: d */
    private final ArrayList<C0862o> f5227d;

    /* renamed from: e */
    private final ArrayList<C0864q> f5228e;

    /* renamed from: f */
    private final ArrayList<C0864q> f5229f;

    /* renamed from: g */
    private C0950d f5230g;

    /* renamed from: h */
    private byte[] f5231h;

    public C0854g(C0971y c0971y) {
        super(1, -1);
        if (c0971y == null) {
            throw new NullPointerException("thisClass == null");
        }
        this.f5224a = c0971y;
        this.f5225b = new ArrayList<>(20);
        this.f5226c = new HashMap<>(40);
        this.f5227d = new ArrayList<>(20);
        this.f5228e = new ArrayList<>(20);
        this.f5229f = new ArrayList<>(20);
        this.f5230g = null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_CLASS_DATA_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return toString();
    }

    /* renamed from: c */
    public boolean m7332c() {
        return this.f5225b.isEmpty() && this.f5227d.isEmpty() && this.f5228e.isEmpty() && this.f5229f.isEmpty();
    }

    /* renamed from: a */
    public void m7329a(C0862o c0862o, AbstractC0945a abstractC0945a) {
        if (c0862o == null) {
            throw new NullPointerException("field == null");
        }
        if (this.f5230g != null) {
            throw new UnsupportedOperationException("static fields already sorted");
        }
        this.f5225b.add(c0862o);
        this.f5226c.put(c0862o, abstractC0945a);
    }

    /* renamed from: a */
    public void m7328a(C0862o c0862o) {
        if (c0862o == null) {
            throw new NullPointerException("field == null");
        }
        this.f5227d.add(c0862o);
    }

    /* renamed from: a */
    public void m7330a(C0864q c0864q) {
        if (c0864q == null) {
            throw new NullPointerException("method == null");
        }
        this.f5228e.add(c0864q);
    }

    /* renamed from: b */
    public void m7331b(C0864q c0864q) {
        if (c0864q == null) {
            throw new NullPointerException("method == null");
        }
        this.f5229f.add(c0864q);
    }

    /* renamed from: d */
    public ArrayList<C0864q> m7333d() {
        ArrayList<C0864q> arrayList = new ArrayList<>(this.f5228e.size() + this.f5229f.size());
        arrayList.addAll(this.f5228e);
        arrayList.addAll(this.f5229f);
        return arrayList;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        if (!this.f5225b.isEmpty()) {
            m7334e();
            Iterator<C0862o> it = this.f5225b.iterator();
            while (it.hasNext()) {
                it.next().m7418a(c0860m);
            }
        }
        if (!this.f5227d.isEmpty()) {
            Collections.sort(this.f5227d);
            Iterator<C0862o> it2 = this.f5227d.iterator();
            while (it2.hasNext()) {
                it2.next().m7418a(c0860m);
            }
        }
        if (!this.f5228e.isEmpty()) {
            Collections.sort(this.f5228e);
            Iterator<C0864q> it3 = this.f5228e.iterator();
            while (it3.hasNext()) {
                it3.next().m7422a(c0860m);
            }
        }
        if (!this.f5229f.isEmpty()) {
            Collections.sort(this.f5229f);
            Iterator<C0864q> it4 = this.f5229f.iterator();
            while (it4.hasNext()) {
                it4.next().m7422a(c0860m);
            }
        }
    }

    /* renamed from: e */
    public C0950d m7334e() {
        if (this.f5230g == null && this.f5225b.size() != 0) {
            this.f5230g = m7327i();
        }
        return this.f5230g;
    }

    /* renamed from: i */
    private C0950d m7327i() {
        Collections.sort(this.f5225b);
        int size = this.f5225b.size();
        while (size > 0) {
            AbstractC0945a abstractC0945a = this.f5226c.get(this.f5225b.get(size - 1));
            if (!(abstractC0945a instanceof AbstractC0964r)) {
                if (abstractC0945a != null) {
                    break;
                }
                size--;
            } else {
                if (((AbstractC0964r) abstractC0945a).mo8065k() != 0) {
                    break;
                }
                size--;
            }
        }
        if (size == 0) {
            return null;
        }
        C0950d.a aVar = new C0950d.a(size);
        for (int i = 0; i < size; i++) {
            C0862o c0862o = this.f5225b.get(i);
            AbstractC0945a abstractC0945a2 = this.f5226c.get(c0862o);
            if (abstractC0945a2 == null) {
                abstractC0945a2 = C0947ab.m8037a(c0862o.m7417a().mo6695a());
            }
            aVar.m8044a(i, abstractC0945a2);
        }
        aVar.mo6683e_();
        return new C0950d(aVar);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        C1014e c1014e = new C1014e();
        m7326b(abstractC0838al.m7255e(), c1014e);
        this.f5231h = c1014e.m8527f();
        m7234a(this.f5231h.length);
    }

    /* renamed from: b */
    private void m7326b(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        if (mo8460a) {
            interfaceC1007a.mo8458a(0, m7239h() + " class data for " + this.f5224a.mo6681d());
        }
        m7324a(c0860m, interfaceC1007a, "static_fields", this.f5225b.size());
        m7324a(c0860m, interfaceC1007a, "instance_fields", this.f5227d.size());
        m7324a(c0860m, interfaceC1007a, "direct_methods", this.f5228e.size());
        m7324a(c0860m, interfaceC1007a, "virtual_methods", this.f5229f.size());
        m7325a(c0860m, interfaceC1007a, "static_fields", this.f5225b);
        m7325a(c0860m, interfaceC1007a, "instance_fields", this.f5227d);
        m7325a(c0860m, interfaceC1007a, "direct_methods", this.f5228e);
        m7325a(c0860m, interfaceC1007a, "virtual_methods", this.f5229f);
        if (mo8460a) {
            interfaceC1007a.mo8462c();
        }
    }

    /* renamed from: a */
    private static void m7324a(C0860m c0860m, InterfaceC1007a interfaceC1007a, String str, int i) {
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8459a(String.format("  %-21s %08x", str + "_size:", Integer.valueOf(i)));
        }
        interfaceC1007a.mo8524e(i);
    }

    /* renamed from: a */
    private static void m7325a(C0860m c0860m, InterfaceC1007a interfaceC1007a, String str, ArrayList<? extends AbstractC0863p> arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (interfaceC1007a.mo8460a()) {
                interfaceC1007a.mo8458a(0, "  " + str + ":");
            }
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i = arrayList.get(i2).mo7415a(c0860m, interfaceC1007a, i, i2);
            }
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    public void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        if (interfaceC1007a.mo8460a()) {
            m7326b(c0860m, interfaceC1007a);
        } else {
            interfaceC1007a.mo8520a(this.f5231h);
        }
    }
}
