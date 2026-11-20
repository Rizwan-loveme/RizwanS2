package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.p209io.IOException;

/* compiled from: ByteBufferSink.java */
/* renamed from: com.b.a.b.g.b */
/* loaded from: classes.dex */
public class C0643b implements InterfaceC0669a {

    /* renamed from: a */
    private final ByteBuffer f4238a;

    public C0643b(ByteBuffer byteBuffer) {
        this.f4238a = byteBuffer;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6240a(byte[] bArr, int i, int i2) {
        try {
            this.f4238a.put(bArr, i, i2);
        } catch (BufferOverflowException e2) {
            throw new IOException("Insufficient space in output buffer for " + i2 + " bytes", e2);
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6239a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        try {
            this.f4238a.put(byteBuffer);
        } catch (BufferOverflowException e2) {
            throw new IOException("Insufficient space in output buffer for " + remaining + " bytes", e2);
        }
    }
}
