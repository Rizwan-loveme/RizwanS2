package com.p065b.p086b.p110h;

/* compiled from: ByteArrayByteInput.java */
/* renamed from: com.b.b.h.f */
/* loaded from: classes.dex */
public final class C1015f implements InterfaceC1016g {

    /* renamed from: a */
    private final byte[] f6492a;

    /* renamed from: b */
    private int f6493b;

    public C1015f(byte... bArr) {
        this.f6492a = bArr;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1016g
    /* renamed from: e */
    public byte mo7634e() {
        byte[] bArr = this.f6492a;
        int i = this.f6493b;
        this.f6493b = i + 1;
        return bArr[i];
    }
}
