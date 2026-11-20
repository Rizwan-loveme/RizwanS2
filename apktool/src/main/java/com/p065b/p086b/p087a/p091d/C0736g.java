package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p092e.C0751l;
import com.p065b.p086b.p087a.p092e.C0752m;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p087a.p092e.InterfaceC0743d;
import com.p065b.p086b.p087a.p092e.InterfaceC0745f;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0971y;

/* compiled from: FieldListParser.java */
/* renamed from: com.b.b.a.d.g */
/* loaded from: classes.dex */
final class C0736g extends AbstractC0737h {

    /* renamed from: a */
    private final C0752m f4655a;

    public C0736g(C0735f c0735f, C0971y c0971y, int i, C0731b c0731b) {
        super(c0735f, c0971y, i, c0731b);
        this.f4655a = new C0752m(m6866f());
    }

    /* renamed from: a */
    public C0752m m6858a() {
        m6865e();
        return this.f4655a;
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: b */
    protected String mo6860b() {
        return "field";
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: a */
    protected String mo6859a(int i) {
        return C0919a.m7838c(i);
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: c */
    protected int mo6861c() {
        return 1;
    }

    @Override // com.p065b.p086b.p087a.p091d.AbstractC0737h
    /* renamed from: a */
    protected InterfaceC0745f mo6857a(int i, int i2, C0968v c0968v, InterfaceC0741b interfaceC0741b) {
        C0751l c0751l = new C0751l(m6867g(), i2, c0968v, interfaceC0741b);
        this.f4655a.m6905a(i, (InterfaceC0743d) c0751l);
        return c0751l;
    }
}
