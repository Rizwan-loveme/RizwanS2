package com.p065b.p086b.p100d.p101a;

import java.io.EOFException;

/* compiled from: ShortArrayCodeInput.java */
/* renamed from: com.b.b.d.a.n */
/* loaded from: classes.dex */
public final class C0888n extends AbstractC0876b implements InterfaceC0878d {

    /* renamed from: a */
    private final short[] f5398a;

    public C0888n(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.f5398a = sArr;
    }

    /* renamed from: f */
    public boolean m7539f() {
        return mo7449a() < this.f5398a.length;
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0878d
    /* renamed from: c */
    public int mo7453c() {
        try {
            short s = this.f5398a[mo7449a()];
            m7450a(1);
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new EOFException();
        }
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0878d
    /* renamed from: d */
    public int mo7454d() {
        return mo7453c() | (mo7453c() << 16);
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0878d
    /* renamed from: e */
    public long mo7455e() {
        return mo7453c() | (mo7453c() << 16) | (mo7453c() << 32) | (mo7453c() << 48);
    }
}
