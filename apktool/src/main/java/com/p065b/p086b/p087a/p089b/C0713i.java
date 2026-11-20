package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1031v;

/* compiled from: ExecutionStack.java */
/* renamed from: com.b.b.a.b.i */
/* loaded from: classes.dex */
public final class C0713i extends C1031v {

    /* renamed from: a */
    private final InterfaceC0976d[] f4537a;

    /* renamed from: b */
    private final boolean[] f4538b;

    /* renamed from: c */
    private int f4539c;

    public C0713i(int i) {
        super(i != 0);
        this.f4537a = new InterfaceC0976d[i];
        this.f4538b = new boolean[i];
        this.f4539c = 0;
    }

    /* renamed from: a */
    public C0713i m6618a() {
        C0713i c0713i = new C0713i(this.f4537a.length);
        System.arraycopy(this.f4537a, 0, c0713i.f4537a, 0, this.f4537a.length);
        System.arraycopy(this.f4538b, 0, c0713i.f4538b, 0, this.f4538b.length);
        c0713i.f4539c = this.f4539c;
        return c0713i;
    }

    /* renamed from: a */
    public void m6624a(C1019j c1019j) {
        int i = this.f4539c - 1;
        int i2 = 0;
        while (i2 <= i) {
            c1019j.m8540a("stack[" + (i2 == i ? "top0" : C1022m.m8557c(i - i2)) + "]: " + m6617b(this.f4537a[i2]));
            i2++;
        }
    }

    /* renamed from: a */
    public void m6622a(C0975c c0975c) {
        if (this.f4539c != 0) {
            m8595l();
            C0975c m8136s = c0975c.m8136s();
            for (int i = 0; i < this.f4539c; i++) {
                if (this.f4537a[i] == c0975c) {
                    this.f4537a[i] = m8136s;
                }
            }
        }
    }

    /* renamed from: b */
    public int m6625b() {
        return this.f4539c;
    }

    /* renamed from: c */
    public void m6628c() {
        m8595l();
        for (int i = 0; i < this.f4539c; i++) {
            this.f4537a[i] = null;
            this.f4538b[i] = false;
        }
        this.f4539c = 0;
    }

    /* renamed from: a */
    public void m6623a(InterfaceC0976d interfaceC0976d) {
        m8595l();
        try {
            InterfaceC0976d mo6696b = interfaceC0976d.mo6696b();
            int m8127j = mo6696b.mo6695a().m8127j();
            if (this.f4539c + m8127j > this.f4537a.length) {
                m6616a("overflow");
                return;
            }
            if (m8127j == 2) {
                this.f4537a[this.f4539c] = null;
                this.f4539c++;
            }
            this.f4537a[this.f4539c] = mo6696b;
            this.f4539c++;
        } catch (NullPointerException e2) {
            throw new NullPointerException("type == null");
        }
    }

    /* renamed from: d */
    public void m6629d() {
        m8595l();
        this.f4538b[this.f4539c] = true;
    }

    /* renamed from: a */
    public InterfaceC0976d m6620a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        return i >= this.f4539c ? m6616a("underflow") : this.f4537a[(this.f4539c - i) - 1];
    }

    /* renamed from: b */
    public boolean m6626b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        if (i >= this.f4539c) {
            throw new C0725u("stack: underflow");
        }
        return this.f4538b[(this.f4539c - i) - 1];
    }

    /* renamed from: c */
    public C0975c m6627c(int i) {
        return m6620a(i).mo6695a();
    }

    /* renamed from: e */
    public InterfaceC0976d m6630e() {
        m8595l();
        InterfaceC0976d m6620a = m6620a(0);
        this.f4537a[this.f4539c - 1] = null;
        this.f4538b[this.f4539c - 1] = false;
        this.f4539c -= m6620a.mo6695a().m8127j();
        return m6620a;
    }

    /* renamed from: a */
    public void m6621a(int i, InterfaceC0976d interfaceC0976d) {
        m8595l();
        try {
            InterfaceC0976d mo6696b = interfaceC0976d.mo6696b();
            int i2 = (this.f4539c - i) - 1;
            InterfaceC0976d interfaceC0976d2 = this.f4537a[i2];
            if (interfaceC0976d2 == null || interfaceC0976d2.mo6695a().m8127j() != mo6696b.mo6695a().m8127j()) {
                m6616a("incompatible substitution: " + m6617b(interfaceC0976d2) + " -> " + m6617b(mo6696b));
            }
            this.f4537a[i2] = mo6696b;
        } catch (NullPointerException e2) {
            throw new NullPointerException("type == null");
        }
    }

    /* renamed from: a */
    public C0713i m6619a(C0713i c0713i) {
        try {
            return C0720p.m6685a(this, c0713i);
        } catch (C0725u e2) {
            e2.m8540a("underlay stack:");
            m6624a(e2);
            e2.m8540a("overlay stack:");
            c0713i.m6624a(e2);
            throw e2;
        }
    }

    /* renamed from: b */
    private static String m6617b(InterfaceC0976d interfaceC0976d) {
        return interfaceC0976d == null ? "<invalid>" : interfaceC0976d.toString();
    }

    /* renamed from: a */
    private static InterfaceC0976d m6616a(String str) {
        throw new C0725u("stack: " + str);
    }
}
