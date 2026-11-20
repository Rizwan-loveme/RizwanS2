package com.p065b.p086b.p100d.p101a;

/* compiled from: BaseCodeCursor.java */
/* renamed from: com.b.b.d.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC0876b implements InterfaceC0877c {

    /* renamed from: a */
    private final C0875a f5332a = new C0875a();

    /* renamed from: b */
    private int f5333b = 0;

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0877c
    /* renamed from: a */
    public final int mo7449a() {
        return this.f5333b;
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0877c
    /* renamed from: b */
    public final int mo7452b() {
        int m7447a = this.f5332a.m7447a(this.f5333b);
        return m7447a >= 0 ? m7447a : this.f5333b;
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0877c
    /* renamed from: a */
    public final void mo7451a(int i, int i2) {
        this.f5332a.m7448a(i, i2);
    }

    /* renamed from: a */
    protected final void m7450a(int i) {
        this.f5333b += i;
    }
}
