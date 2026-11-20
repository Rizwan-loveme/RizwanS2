package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p092e.C0754o;
import com.p065b.p086b.p087a.p092e.C0755p;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p087a.p092e.InterfaceC0745f;
import com.p065b.p086b.p087a.p092e.InterfaceC0746g;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0971y;

/* compiled from: MethodListParser.java */
/* renamed from: com.b.b.a.d.i */
/* loaded from: classes.dex */
final class C0738i extends AbstractC0737h {

    /* renamed from: a */
    private final C0755p f4662a;

    public C0738i(C0735f c0735f, C0971y c0971y, int i, C0731b c0731b) {
        super(c0735f, c0971y, i, c0731b);
        this.f4662a = new C0755p(m6866f());
    }

    /* renamed from: a */
    public C0755p m6868a() {
        m6865e();
        return this.f4662a;
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: b */
    protected String mo6860b() {
        return "method";
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: a */
    protected String mo6859a(int i) {
        return C0919a.m7839d(i);
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: c */
    protected int mo6861c() {
        return 2;
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: a */
    protected InterfaceC0745f mo6857a(int i, int i2, C0968v c0968v, InterfaceC0741b interfaceC0741b) {
        C0754o c0754o = new C0754o(m6867g(), i2, c0968v, interfaceC0741b);
        this.f4662a.m6906a(i, (InterfaceC0746g) c0754o);
        return c0754o;
    }
}
