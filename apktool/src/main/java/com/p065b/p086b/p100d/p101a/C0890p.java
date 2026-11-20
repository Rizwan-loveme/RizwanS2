package com.p065b.p086b.p100d.p101a;

/* compiled from: SparseSwitchPayloadDecodedInstruction.java */
/* renamed from: com.b.b.d.a.p */
/* loaded from: classes.dex */
public final class C0890p extends AbstractC0880f {

    /* renamed from: a */
    private final int[] f5400a;

    /* renamed from: b */
    private final int[] f5401b;

    public C0890p(EnumC0884j enumC0884j, int i, int[] iArr, int[] iArr2) {
        super(enumC0884j, i, 0, null, 0, 0L);
        if (iArr.length != iArr2.length) {
            throw new IllegalArgumentException("keys/targets length mismatch");
        }
        this.f5400a = iArr;
        this.f5401b = iArr2;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: m */
    public int mo7485m() {
        return 0;
    }

    /* renamed from: w */
    public int[] m7542w() {
        return this.f5400a;
    }

    /* renamed from: x */
    public int[] m7543x() {
        return this.f5401b;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: d */
    public AbstractC0880f mo7476d(int i) {
        throw new UnsupportedOperationException("no index in instruction");
    }
}
