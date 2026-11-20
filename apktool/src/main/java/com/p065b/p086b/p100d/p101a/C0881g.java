package com.p065b.p086b.p100d.p101a;

/* compiled from: FillArrayDataPayloadDecodedInstruction.java */
/* renamed from: com.b.b.d.a.g */
/* loaded from: classes.dex */
public final class C0881g extends AbstractC0880f {

    /* renamed from: a */
    private final Object f5340a;

    /* renamed from: b */
    private final int f5341b;

    /* renamed from: c */
    private final int f5342c;

    private C0881g(EnumC0884j enumC0884j, int i, Object obj, int i2, int i3) {
        super(enumC0884j, i, 0, null, 0, 0L);
        this.f5340a = obj;
        this.f5341b = i2;
        this.f5342c = i3;
    }

    public C0881g(EnumC0884j enumC0884j, int i, byte[] bArr) {
        this(enumC0884j, i, bArr, bArr.length, 1);
    }

    public C0881g(EnumC0884j enumC0884j, int i, short[] sArr) {
        this(enumC0884j, i, sArr, sArr.length, 2);
    }

    public C0881g(EnumC0884j enumC0884j, int i, int[] iArr) {
        this(enumC0884j, i, iArr, iArr.length, 4);
    }

    public C0881g(EnumC0884j enumC0884j, int i, long[] jArr) {
        this(enumC0884j, i, jArr, jArr.length, 8);
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: m */
    public int mo7485m() {
        return 0;
    }

    /* renamed from: w */
    public short m7495w() {
        return (short) this.f5342c;
    }

    /* renamed from: x */
    public int m7496x() {
        return this.f5341b;
    }

    /* renamed from: y */
    public Object m7497y() {
        return this.f5340a;
    }

    @Override // com.p065b.p086b.p100d.p101a.AbstractC0880f
    /* renamed from: d */
    public AbstractC0880f mo7476d(int i) {
        throw new UnsupportedOperationException("no index in instruction");
    }
}
