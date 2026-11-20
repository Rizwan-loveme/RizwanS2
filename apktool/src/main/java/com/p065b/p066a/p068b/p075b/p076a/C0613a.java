package com.p065b.p066a.p068b.p075b.p076a;

import java.nio.ByteBuffer;

/* compiled from: BerDataValue.java */
/* renamed from: com.b.a.b.b.a.a */
/* loaded from: classes.dex */
public class C0613a {

    /* renamed from: a */
    private final boolean f4197a;

    /* renamed from: b */
    private final ByteBuffer f4198b;

    /* renamed from: c */
    private final ByteBuffer f4199c;

    /* renamed from: d */
    private final int f4200d;

    /* renamed from: e */
    private final int f4201e;

    C0613a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, boolean z, int i2) {
        this.f4198b = byteBuffer;
        this.f4199c = byteBuffer2;
        this.f4200d = i;
        this.f4197a = z;
        this.f4201e = i2;
    }

    /* renamed from: d */
    public int m6115d() {
        return this.f4200d;
    }

    /* renamed from: e */
    public int m6116e() {
        return this.f4201e;
    }

    /* renamed from: b */
    public ByteBuffer m6113b() {
        return this.f4198b.slice();
    }

    /* renamed from: c */
    public ByteBuffer m6114c() {
        return this.f4199c.slice();
    }

    /* renamed from: a */
    public InterfaceC0615c m6112a() {
        return new C0617e(m6114c());
    }
}
