package com.p065b.p086b.p087a.p092e;

import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;

/* compiled from: StdMember.java */
/* renamed from: com.b.b.a.e.n */
/* loaded from: classes.dex */
public abstract class AbstractC0753n implements InterfaceC0745f {

    /* renamed from: a */
    private final C0971y f4664a;

    /* renamed from: b */
    private final int f4665b;

    /* renamed from: c */
    private final C0968v f4666c;

    /* renamed from: d */
    private final InterfaceC0741b f4667d;

    public AbstractC0753n(C0971y c0971y, int i, C0968v c0968v, InterfaceC0741b interfaceC0741b) {
        if (c0971y == null) {
            throw new NullPointerException("definingClass == null");
        }
        if (c0968v == null) {
            throw new NullPointerException("nat == null");
        }
        if (interfaceC0741b == null) {
            throw new NullPointerException("attributes == null");
        }
        this.f4664a = c0971y;
        this.f4665b = i;
        this.f4666c = c0968v;
        this.f4667d = interfaceC0741b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(this.f4666c.mo6681d());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: f */
    public final C0971y mo6608f() {
        return this.f4664a;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: d */
    public final int mo6606d() {
        return this.f4665b;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: a */
    public final C0968v mo6603a() {
        return this.f4666c;
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: b */
    public final C0970x mo6604b() {
        return this.f4666c.m8072a();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: c */
    public final C0970x mo6605c() {
        return this.f4666c.m8073b();
    }

    @Override // com.p065b.p086b.p087a.p092e.InterfaceC0745f
    /* renamed from: e */
    public final InterfaceC0741b mo6607e() {
        return this.f4667d;
    }
}
