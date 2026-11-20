package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: OneLocalsArray.java */
/* renamed from: com.b.b.a.b.q */
/* loaded from: classes.dex */
public class C0721q extends AbstractC0717m {

    /* renamed from: a */
    private final InterfaceC0976d[] f4555a;

    public C0721q(int i) {
        super(i != 0);
        this.f4555a = new InterfaceC0976d[i];
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0721q mo6667a() {
        C0721q c0721q = new C0721q(this.f4555a.length);
        System.arraycopy(this.f4555a, 0, c0721q.f4555a, 0, this.f4555a.length);
        return c0721q;
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6674a(C1019j c1019j) {
        for (int i = 0; i < this.f4555a.length; i++) {
            InterfaceC0976d interfaceC0976d = this.f4555a[i];
            c1019j.m8540a("locals[" + C1022m.m8557c(i) + "]: " + (interfaceC0976d == null ? "<invalid>" : interfaceC0976d.toString()));
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f4555a.length; i++) {
            InterfaceC0976d interfaceC0976d = this.f4555a[i];
            sb.append("locals[" + C1022m.m8557c(i) + "]: " + (interfaceC0976d == null ? "<invalid>" : interfaceC0976d.toString()) + "\n");
        }
        return sb.toString();
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6673a(C0975c c0975c) {
        int length = this.f4555a.length;
        if (length != 0) {
            m8595l();
            C0975c m8136s = c0975c.m8136s();
            for (int i = 0; i < length; i++) {
                if (this.f4555a[i] == c0975c) {
                    this.f4555a[i] = m8136s;
                }
            }
        }
    }

    /* renamed from: f */
    public int m6694f() {
        return this.f4555a.length;
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6671a(int i, InterfaceC0976d interfaceC0976d) {
        InterfaceC0976d interfaceC0976d2;
        m8595l();
        try {
            InterfaceC0976d mo6696b = interfaceC0976d.mo6696b();
            if (i < 0) {
                throw new IndexOutOfBoundsException("idx < 0");
            }
            if (mo6696b.mo6695a().m8129l()) {
                this.f4555a[i + 1] = null;
            }
            this.f4555a[i] = mo6696b;
            if (i != 0 && (interfaceC0976d2 = this.f4555a[i - 1]) != null && interfaceC0976d2.mo6695a().m8129l()) {
                this.f4555a[i - 1] = null;
            }
        } catch (NullPointerException e2) {
            throw new NullPointerException("type == null");
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public void mo6672a(C0934p c0934p) {
        mo6671a(c0934p.m7931g(), c0934p);
    }

    /* renamed from: b */
    public void m6691b(int i) {
        m8595l();
        this.f4555a[i] = null;
    }

    /* renamed from: c */
    public InterfaceC0976d m6692c(int i) {
        return this.f4555a[i];
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public InterfaceC0976d mo6670a(int i) {
        InterfaceC0976d interfaceC0976d = this.f4555a[i];
        if (interfaceC0976d == null) {
            return m6689a(i, "invalid");
        }
        return interfaceC0976d;
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public AbstractC0717m mo6668a(AbstractC0717m abstractC0717m) {
        return abstractC0717m instanceof C0721q ? m6690a((C0721q) abstractC0717m) : abstractC0717m.mo6668a(this);
    }

    /* renamed from: a */
    public C0721q m6690a(C0721q c0721q) {
        try {
            return C0720p.m6686a(this, c0721q);
        } catch (C0725u e2) {
            e2.m8540a("underlay locals:");
            mo6674a(e2);
            e2.m8540a("overlay locals:");
            c0721q.mo6674a(e2);
            throw e2;
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: a */
    public C0718n mo6669a(AbstractC0717m abstractC0717m, int i) {
        return new C0718n(m6694f()).mo6669a(abstractC0717m, i);
    }

    @Override // com.p065b.p086b.p087a.p089b.AbstractC0717m
    /* renamed from: b */
    protected C0721q mo6675b() {
        return this;
    }

    /* renamed from: a */
    private static InterfaceC0976d m6689a(int i, String str) {
        throw new C0725u("local " + C1022m.m8557c(i) + ": " + str);
    }
}
