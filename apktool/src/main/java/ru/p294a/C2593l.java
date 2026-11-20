package ru.p294a;

/* compiled from: UnparseableExtraFieldData.java */
/* renamed from: ru.a.l */
/* loaded from: classes.dex */
public final class C2593l implements InterfaceC2584c {

    /* renamed from: a */
    private static final C2607z f13445a = new C2607z(44225);

    /* renamed from: b */
    private byte[] f13446b;

    /* renamed from: c */
    private byte[] f13447c;

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public C2607z mo16060a() {
        return f13445a;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: f */
    public C2607z mo16050f() {
        return new C2607z(this.f13446b == null ? 0 : this.f13446b.length);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: d */
    public C2607z mo16048d() {
        return this.f13447c == null ? mo16050f() : new C2607z(this.f13447c.length);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: e */
    public byte[] mo16049e() {
        return AbstractC2582aa.m16057a(this.f13446b);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: c */
    public byte[] mo16047c() {
        return this.f13447c == null ? mo16049e() : AbstractC2582aa.m16057a(this.f13447c);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public void mo16045a(byte[] bArr, int i, int i2) {
        this.f13446b = new byte[i2];
        System.arraycopy(bArr, i, this.f13446b, 0, i2);
    }

    @Override // ru.p294a.InterfaceC2584c
    /* renamed from: b */
    public void mo16070b(byte[] bArr, int i, int i2) {
        this.f13447c = new byte[i2];
        System.arraycopy(bArr, i, this.f13447c, 0, i2);
        if (this.f13446b == null) {
            mo16045a(bArr, i, i2);
        }
    }
}
