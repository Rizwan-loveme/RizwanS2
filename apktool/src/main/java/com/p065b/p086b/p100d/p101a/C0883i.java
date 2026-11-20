package com.p065b.p086b.p100d.p101a;

import com.p065b.p086b.p100d.EnumC0903k;

/* compiled from: FourRegisterDecodedInstruction.java */
/* renamed from: com.b.b.d.a.i */
/* loaded from: classes.dex */
public final class C0883i extends AbstractC0880f {

    /* renamed from: a */
    private final int f5348a;

    /* renamed from: b */
    private final int f5349b;

    /* renamed from: c */
    private final int f5350c;

    /* renamed from: d */
    private final int f5351d;

    public C0883i(EnumC0884j enumC0884j, int i, int i2, EnumC0903k enumC0903k, int i3, long j, int i4, int i5, int i6, int i7) {
        super(enumC0884j, i, i2, enumC0903k, i3, j);
        this.f5348a = i4;
        this.f5349b = i5;
        this.f5350c = i6;
        this.f5351d = i7;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: m */
    public int mo7485m() {
        return 4;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: n */
    public int mo7486n() {
        return this.f5348a;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: o */
    public int mo7487o() {
        return this.f5349b;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: p */
    public int mo7488p() {
        return this.f5350c;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: q */
    public int mo7489q() {
        return this.f5351d;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: d */
    public AbstractC0880f mo7476d(int i) {
        return new C0883i(m7469a(), m7471b(), i, m7478f(), m7479g(), m7480h(), this.f5348a, this.f5349b, this.f5350c, this.f5351d);
    }
}
