package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;

/* compiled from: ThrowingInsn.java */
/* renamed from: com.b.b.f.b.y */
/* loaded from: classes.dex */
public final class C0943y extends AbstractC0926h {

    /* renamed from: a */
    private final InterfaceC0977e f6134a;

    /* renamed from: a */
    public static String m8032a(InterfaceC0977e interfaceC0977e) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("catch");
        int mo6856f_ = interfaceC0977e.mo6856f_();
        for (int i = 0; i < mo6856f_; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(interfaceC0977e.mo6853a(i).mo6681d());
        }
        return stringBuffer.toString();
    }

    public C0943y(C0937s c0937s, C0940v c0940v, C0935q c0935q, InterfaceC0977e interfaceC0977e) {
        super(c0937s, c0940v, null, c0935q);
        if (c0937s.m7971d() != 6) {
            throw new IllegalArgumentException("bogus branchingness");
        }
        if (interfaceC0977e == null) {
            throw new NullPointerException("catches == null");
        }
        this.f6134a = interfaceC0977e;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public String mo7866a() {
        return m8032a(this.f6134a);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: b */
    public InterfaceC0977e mo7876b() {
        return this.f6134a;
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public void mo7875a(AbstractC0926h.b bVar) {
        bVar.mo7181a(this);
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7874a(C0975c c0975c) {
        return new C0943y(m7882f(), m7883g(), m7886j(), this.f6134a.mo6854a(c0975c));
    }

    @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h
    /* renamed from: a */
    public AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q) {
        return new C0943y(m7882f(), m7883g(), c0935q, this.f6134a);
    }
}
