package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1022m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: LocalsArraySet.java */
/* renamed from: com.b.b.a.b.n */
/* loaded from: classes.dex */
public class C0718n extends AbstractC0717m {

    /* renamed from: a */
    private final C0721q f4553a;

    /* renamed from: b */
    private final ArrayList<AbstractC0717m> f4554b;

    public C0718n(int i) {
        super(i != 0);
        this.f4553a = new C0721q(i);
        this.f4554b = new ArrayList<>();
    }

    public C0718n(C0721q c0721q, ArrayList<AbstractC0717m> arrayList) {
        super(c0721q.m6694f() > 0);
        this.f4553a = c0721q;
        this.f4554b = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C0718n(C0718n c0718n) {
        super(c0718n.m6682e() > 0);
        this.f4553a = c0718n.f4553a.mo6667a();
        this.f4554b = new ArrayList<>(c0718n.f4554b.size());
        int size = c0718n.f4554b.size();
        for (int i = 0; i < size; i++) {
            AbstractC0717m abstractC0717m = c0718n.f4554b.get(i);
            if (abstractC0717m == null) {
                this.f4554b.add(null);
            } else {
                this.f4554b.add(abstractC0717m.mo6667a());
            }
        }
    }

    @Override // com.p065b.p086b.p110h.C1031v
    /* renamed from: e_ */
    public void mo6683e_() {
        this.f4553a.mo6683e_();
        Iterator<AbstractC0717m> it = this.f4554b.iterator();
        while (it.hasNext()) {
            AbstractC0717m next = it.next();
            if (next != null) {
                next.mo6683e_();
            }
        }
        super.mo6683e_();
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public AbstractC0717m mo6667a() {
        return new C0718n(this);
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6674a(C1019j c1019j) {
        c1019j.m8540a("(locals array set; primary)");
        this.f4553a.mo6674a(c1019j);
        int size = this.f4554b.size();
        for (int i = 0; i < size; i++) {
            AbstractC0717m abstractC0717m = this.f4554b.get(i);
            if (abstractC0717m != null) {
                c1019j.m8540a("(locals array set: primary for caller " + C1022m.m8557c(i) + ')');
                abstractC0717m.mo6675b().mo6674a(c1019j);
            }
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        StringBuilder sb = new StringBuilder();
        sb.append("(locals array set; primary)\n");
        sb.append(mo6675b().mo6681d());
        sb.append('\n');
        int size = this.f4554b.size();
        for (int i = 0; i < size; i++) {
            AbstractC0717m abstractC0717m = this.f4554b.get(i);
            if (abstractC0717m != null) {
                sb.append("(locals array set: primary for caller " + C1022m.m8557c(i) + ")\n");
                sb.append(abstractC0717m.mo6675b().mo6681d());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6673a(C0975c c0975c) {
        if (this.f4553a.m6694f() != 0) {
            m8595l();
            this.f4553a.mo6673a(c0975c);
            Iterator<AbstractC0717m> it = this.f4554b.iterator();
            while (it.hasNext()) {
                AbstractC0717m next = it.next();
                if (next != null) {
                    next.mo6673a(c0975c);
                }
            }
        }
    }

    /* renamed from: e */
    public int m6682e() {
        return this.f4553a.m6694f();
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6671a(int i, InterfaceC0976d interfaceC0976d) {
        m8595l();
        this.f4553a.mo6671a(i, interfaceC0976d);
        Iterator<AbstractC0717m> it = this.f4554b.iterator();
        while (it.hasNext()) {
            AbstractC0717m next = it.next();
            if (next != null) {
                next.mo6671a(i, interfaceC0976d);
            }
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6672a(C0934p c0934p) {
        mo6671a(c0934p.m7931g(), c0934p);
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public InterfaceC0976d mo6670a(int i) {
        return this.f4553a.mo6670a(i);
    }

    /* renamed from: a */
    private C0718n m6676a(C0718n c0718n) {
        AbstractC0717m abstractC0717m;
        C0721q m6690a = this.f4553a.m6690a(c0718n.mo6675b());
        int size = this.f4554b.size();
        int size2 = c0718n.f4554b.size();
        int max = Math.max(size, size2);
        ArrayList arrayList = new ArrayList(max);
        int i = 0;
        boolean z = false;
        while (i < max) {
            AbstractC0717m abstractC0717m2 = i < size ? this.f4554b.get(i) : null;
            AbstractC0717m abstractC0717m3 = i < size2 ? c0718n.f4554b.get(i) : null;
            if (abstractC0717m2 == abstractC0717m3) {
                abstractC0717m = abstractC0717m2;
            } else if (abstractC0717m2 == null) {
                abstractC0717m = abstractC0717m3;
            } else if (abstractC0717m3 == null) {
                abstractC0717m = abstractC0717m2;
            } else {
                try {
                    abstractC0717m = abstractC0717m2.mo6668a(abstractC0717m3);
                } catch (C0725u e2) {
                    e2.m8540a("Merging locals set for caller block " + C1022m.m8557c(i));
                    abstractC0717m = null;
                }
            }
            boolean z2 = z || abstractC0717m2 != abstractC0717m;
            arrayList.add(abstractC0717m);
            i++;
            z = z2;
        }
        return (this.f4553a != m6690a || z) ? new C0718n(m6690a, arrayList) : this;
    }

    /* renamed from: a */
    private C0718n m6677a(C0721q c0721q) {
        C0721q m6690a = this.f4553a.m6690a(c0721q.mo6675b());
        ArrayList arrayList = new ArrayList(this.f4554b.size());
        int size = this.f4554b.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            AbstractC0717m abstractC0717m = this.f4554b.get(i);
            AbstractC0717m abstractC0717m2 = null;
            if (abstractC0717m != null) {
                try {
                    abstractC0717m2 = abstractC0717m.mo6668a(c0721q);
                } catch (C0725u e2) {
                    e2.m8540a("Merging one locals against caller block " + C1022m.m8557c(i));
                }
            }
            boolean z2 = z || abstractC0717m != abstractC0717m2;
            arrayList.add(abstractC0717m2);
            i++;
            z = z2;
        }
        return (this.f4553a != m6690a || z) ? new C0718n(m6690a, arrayList) : this;
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0718n mo6668a(AbstractC0717m abstractC0717m) {
        C0718n m6677a;
        try {
            if (abstractC0717m instanceof C0718n) {
                m6677a = m6676a((C0718n) abstractC0717m);
            } else {
                m6677a = m6677a((C0721q) abstractC0717m);
            }
            m6677a.mo6683e_();
            return m6677a;
        } catch (C0725u e2) {
            e2.m8540a("underlay locals:");
            mo6674a(e2);
            e2.m8540a("overlay locals:");
            abstractC0717m.mo6674a(e2);
            throw e2;
        }
    }

    /* renamed from: c */
    private AbstractC0717m m6678c(int i) {
        if (i >= this.f4554b.size()) {
            return null;
        }
        return this.f4554b.get(i);
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public C0718n mo6669a(AbstractC0717m abstractC0717m, int i) {
        AbstractC0717m mo6668a;
        AbstractC0717m abstractC0717m2;
        C0721q c0721q;
        AbstractC0717m m6678c = m6678c(i);
        C0721q m6690a = this.f4553a.m6690a(abstractC0717m.mo6675b());
        if (m6678c == abstractC0717m) {
            mo6668a = m6678c;
        } else {
            mo6668a = m6678c == null ? abstractC0717m : m6678c.mo6668a(abstractC0717m);
        }
        if (mo6668a != m6678c || m6690a != this.f4553a) {
            int size = this.f4554b.size();
            int max = Math.max(i + 1, size);
            ArrayList arrayList = new ArrayList(max);
            int i2 = 0;
            C0721q c0721q2 = null;
            while (i2 < max) {
                if (i2 == i) {
                    abstractC0717m2 = mo6668a;
                } else {
                    abstractC0717m2 = i2 < size ? this.f4554b.get(i2) : null;
                }
                if (abstractC0717m2 == null) {
                    c0721q = c0721q2;
                } else if (c0721q2 == null) {
                    c0721q = abstractC0717m2.mo6675b();
                } else {
                    c0721q = c0721q2.m6690a(abstractC0717m2.mo6675b());
                }
                arrayList.add(abstractC0717m2);
                i2++;
                c0721q2 = c0721q;
            }
            C0718n c0718n = new C0718n(c0721q2, arrayList);
            c0718n.mo6683e_();
            return c0718n;
        }
        return this;
    }

    /* renamed from: b */
    public AbstractC0717m m6679b(int i) {
        return m6678c(i);
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: b */
    protected C0721q mo6675b() {
        return this.f4553a;
    }
}
