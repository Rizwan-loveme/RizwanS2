package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p107d.C0975c;
import java.util.HashSet;

/* compiled from: DalvCode.java */
/* renamed from: com.b.b.c.b.h */
/* loaded from: classes.dex */
public final class C0806h {

    /* renamed from: a */
    private final int f4786a;

    /* renamed from: b */
    private C0820v f4787b;

    /* renamed from: c */
    private InterfaceC0801c f4788c;

    /* renamed from: d */
    private C0803e f4789d;

    /* renamed from: e */
    private C0821w f4790e;

    /* renamed from: f */
    private C0815q f4791f;

    /* renamed from: g */
    private C0808j f4792g;

    /* compiled from: DalvCode.java */
    /* renamed from: com.b.b.c.b.h$a */
    public interface a {
        /* renamed from: a */
        int mo6954a(AbstractC0945a abstractC0945a);
    }

    public C0806h(int i, C0820v c0820v, InterfaceC0801c interfaceC0801c) {
        if (c0820v == null) {
            throw new NullPointerException("unprocessedInsns == null");
        }
        if (interfaceC0801c == null) {
            throw new NullPointerException("unprocessedCatches == null");
        }
        this.f4786a = i;
        this.f4787b = c0820v;
        this.f4788c = interfaceC0801c;
        this.f4789d = null;
        this.f4790e = null;
        this.f4791f = null;
        this.f4792g = null;
    }

    /* renamed from: j */
    private void m7021j() {
        if (this.f4792g == null) {
            this.f4792g = this.f4787b.m7154d();
            this.f4790e = C0821w.m7155a(this.f4792g, this.f4786a);
            this.f4791f = C0815q.m7099a(this.f4792g);
            this.f4789d = this.f4788c.mo6982a();
            this.f4787b = null;
            this.f4788c = null;
        }
    }

    /* renamed from: a */
    public void m7022a(a aVar) {
        this.f4787b.m7149a(aVar);
    }

    /* renamed from: a */
    public boolean m7023a() {
        return this.f4786a != 1 && this.f4787b.m7151a();
    }

    /* renamed from: b */
    public boolean m7024b() {
        return this.f4787b.m7152b();
    }

    /* renamed from: c */
    public boolean m7025c() {
        return this.f4788c.mo6983b();
    }

    /* renamed from: d */
    public HashSet<C0975c> m7026d() {
        return this.f4788c.mo6984c();
    }

    /* renamed from: e */
    public HashSet<AbstractC0945a> m7027e() {
        return this.f4787b.m7153c();
    }

    /* renamed from: f */
    public C0808j m7028f() {
        m7021j();
        return this.f4792g;
    }

    /* renamed from: g */
    public C0803e m7029g() {
        m7021j();
        return this.f4789d;
    }

    /* renamed from: h */
    public C0821w m7030h() {
        m7021j();
        return this.f4790e;
    }

    /* renamed from: i */
    public C0815q m7031i() {
        m7021j();
        return this.f4791f;
    }
}
