package ru.p294a;

/* compiled from: UnrecognizedExtraField.java */
/* renamed from: ru.a.m */
/* loaded from: classes.dex */
public class C2594m implements InterfaceC2584c {

    /* renamed from: a */
    private C2607z f13448a;

    /* renamed from: b */
    private byte[] f13449b;

    /* renamed from: c */
    private byte[] f13450c;

    /* renamed from: a */
    public void m16093a(C2607z c2607z) {
        this.f13448a = c2607z;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public C2607z mo16060a() {
        return this.f13448a;
    }

    /* renamed from: a */
    public void m16094a(byte[] bArr) {
        this.f13449b = AbstractC2582aa.m16057a(bArr);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: f */
    public C2607z mo16050f() {
        return new C2607z(this.f13449b.length);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: e */
    public byte[] mo16049e() {
        return AbstractC2582aa.m16057a(this.f13449b);
    }

    /* renamed from: b */
    public void m16095b(byte[] bArr) {
        this.f13450c = AbstractC2582aa.m16057a(bArr);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: d */
    public C2607z mo16048d() {
        return this.f13450c != null ? new C2607z(this.f13450c.length) : mo16050f();
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: c */
    public byte[] mo16047c() {
        return this.f13450c != null ? AbstractC2582aa.m16057a(this.f13450c) : mo16049e();
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public void mo16045a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        m16094a(bArr2);
    }

    @Override // ru.p294a.InterfaceC2584c
    /* renamed from: b */
    public void mo16070b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        m16095b(bArr2);
        if (this.f13449b == null) {
            m16094a(bArr2);
        }
    }
}
