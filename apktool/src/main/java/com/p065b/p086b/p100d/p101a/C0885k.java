package com.p065b.p086b.p100d.p101a;

import com.p065b.p086b.p100d.EnumC0903k;

/* compiled from: OneRegisterDecodedInstruction.java */
/* renamed from: com.b.b.d.a.k */
/* loaded from: classes.dex */
public final class C0885k extends AbstractC0880f {

    /* renamed from: a */
    private final int f5393a;

    public C0885k(EnumC0884j enumC0884j, int i, int i2, EnumC0903k enumC0903k, int i3, long j, int i4) {
        super(enumC0884j, i, i2, enumC0903k, i3, j);
        this.f5393a = i4;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: m */
    public int mo7485m() {
        return 1;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: n */
    public int mo7486n() {
        return this.f5393a;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: d */
    public AbstractC0880f mo7476d(int i) {
        return new C0885k(m7469a(), m7471b(), i, m7478f(), m7479g(), m7480h(), this.f5393a);
    }
}
