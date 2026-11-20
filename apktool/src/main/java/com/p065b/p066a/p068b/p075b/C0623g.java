package com.p065b.p066a.p068b.p075b;

import java.nio.ByteBuffer;

/* compiled from: Asn1OpaqueObject.java */
/* renamed from: com.b.a.b.b.g */
/* loaded from: classes.dex */
public class C0623g {

    /* renamed from: a */
    private final ByteBuffer f4221a;

    public C0623g(ByteBuffer byteBuffer) {
        this.f4221a = byteBuffer.slice();
    }

    public C0623g(byte[] bArr) {
        this.f4221a = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    public ByteBuffer m6184a() {
        return this.f4221a.slice();
    }
}
