package com.p065b.p066a.p068b.p081g;

import java.nio.ByteBuffer;

/* compiled from: ByteBufferUtils.java */
/* renamed from: com.b.a.b.g.c */
/* loaded from: classes.dex */
public final class C0644c {
    private C0644c() {
    }

    /* renamed from: a */
    public static byte[] m6241a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }
}
