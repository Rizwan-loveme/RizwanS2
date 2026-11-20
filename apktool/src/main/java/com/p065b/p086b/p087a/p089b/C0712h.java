package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p087a.p088a.C0683b;
import com.p065b.p086b.p087a.p088a.C0689h;
import com.p065b.p086b.p087a.p088a.C0690i;
import com.p065b.p086b.p087a.p088a.C0691j;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p087a.p092e.InterfaceC0742c;
import com.p065b.p086b.p087a.p092e.InterfaceC0746g;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0973a;

/* compiled from: ConcreteMethod.java */
/* renamed from: com.b.b.a.b.h */
/* loaded from: classes.dex */
public final class C0712h implements InterfaceC0746g {

    /* renamed from: a */
    private final InterfaceC0746g f4531a;

    /* renamed from: b */
    private final C0970x f4532b;

    /* renamed from: c */
    private final boolean f4533c;

    /* renamed from: d */
    private final C0683b f4534d;

    /* renamed from: e */
    private final C0715k f4535e;

    /* renamed from: f */
    private final C0716l f4536f;

    public C0712h(InterfaceC0746g interfaceC0746g, InterfaceC0742c interfaceC0742c, boolean z, boolean z2) {
        this(interfaceC0746g, interfaceC0742c.mo6841c(), interfaceC0742c.mo6849k(), z, z2);
    }

    public C0712h(InterfaceC0746g interfaceC0746g, int i, C0970x c0970x, boolean z, boolean z2) {
        C0716l c0716l;
        this.f4531a = interfaceC0746g;
        this.f4533c = (i & 32) != 0;
        this.f4532b = c0970x;
        this.f4534d = (C0683b) interfaceC0746g.mo6607e().mo6891a("Code");
        InterfaceC0741b m6501f = this.f4534d.m6501f();
        C0715k c0715k = C0715k.f4543a;
        if (z) {
            for (C0689h c0689h = (C0689h) m6501f.mo6891a("LineNumberTable"); c0689h != null; c0689h = (C0689h) m6501f.mo6890a(c0689h)) {
                c0715k = C0715k.m6646a(c0715k, c0689h.m6507b());
            }
        }
        this.f4535e = c0715k;
        C0716l c0716l2 = C0716l.f4546a;
        if (z2) {
            for (C0690i c0690i = (C0690i) m6501f.mo6891a("LocalVariableTable"); c0690i != null; c0690i = (C0690i) m6501f.mo6890a(c0690i)) {
                c0716l2 = C0716l.m6653a(c0716l2, c0690i.m6512b());
            }
            C0716l c0716l3 = C0716l.f4546a;
            for (C0691j c0691j = (C0691j) m6501f.mo6891a("LocalVariableTypeTable"); c0691j != null; c0691j = (C0691j) m6501f.mo6890a(c0691j)) {
                c0716l3 = C0716l.m6653a(c0716l3, c0691j.m6512b());
            }
            if (c0716l3.m8550f_() != 0) {
                c0716l = C0716l.m6654b(c0716l2, c0716l3);
                this.f4536f = c0716l;
            }
        }
        c0716l = c0716l2;
        this.f4536f = c0716l;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: a */
    public C0968v mo6603a() {
        return this.f4531a.mo6603a();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: b */
    public C0970x mo6604b() {
        return this.f4531a.mo6604b();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: c */
    public C0970x mo6605c() {
        return this.f4531a.mo6605c();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: d */
    public int mo6606d() {
        return this.f4531a.mo6606d();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: e */
    public InterfaceC0741b mo6607e() {
        return this.f4531a.mo6607e();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: f */
    public C0971y mo6608f() {
        return this.f4531a.mo6608f();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0746g
    /* renamed from: g */
    public C0973a mo6609g() {
        return this.f4531a.mo6609g();
    }

    /* renamed from: h */
    public boolean m6610h() {
        return this.f4533c;
    }

    /* renamed from: i */
    public int m6611i() {
        return this.f4534d.m6497b();
    }

    /* renamed from: j */
    public int m6612j() {
        return this.f4534d.m6498c();
    }

    /* renamed from: k */
    public C0711g m6613k() {
        return this.f4534d.m6499d();
    }

    /* renamed from: l */
    public C0709e m6614l() {
        return this.f4534d.m6500e();
    }

    /* renamed from: m */
    public C0716l m6615m() {
        return this.f4536f;
    }

    /* renamed from: a */
    public C0940v m6602a(int i) {
        return new C0940v(this.f4532b, i, this.f4535e.m6650b(i));
    }
}
