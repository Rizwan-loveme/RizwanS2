package com.p065b.p086b.p100d.p101a;

import com.p065b.p086b.p100d.EnumC0903k;

/* compiled from: ThreeRegisterDecodedInstruction.java */
/* renamed from: com.b.b.d.a.q */
/* loaded from: classes.dex */
public final class C0891q extends AbstractC0880f {

    /* renamed from: a */
    private final int f5402a;

    /* renamed from: b */
    private final int f5403b;

    /* renamed from: c */
    private final int f5404c;

    public C0891q(EnumC0884j enumC0884j, int i, int i2, EnumC0903k enumC0903k, int i3, long j, int i4, int i5, int i6) {
        super(enumC0884j, i, i2, enumC0903k, i3, j);
        this.f5402a = i4;
        this.f5403b = i5;
        this.f5404c = i6;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: m */
    public int mo7485m() {
        return 3;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: n */
    public int mo7486n() {
        return this.f5402a;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: o */
    public int mo7487o() {
        return this.f5403b;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: p */
    public int mo7488p() {
        return this.f5404c;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: d */
    public AbstractC0880f mo7476d(int i) {
        return new C0891q(m7469a(), m7471b(), i, m7478f(), m7479g(), m7480h(), this.f5402a, this.f5403b, this.f5404c);
    }
}
