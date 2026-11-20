package com.p065b.p111c.p113b.p118c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.p209io.IOException;

/* compiled from: ByteBufferSink.java */
/* renamed from: com.b.c.b.c.b */
/* loaded from: classes.dex */
public class C1054b implements InterfaceC1067a {

    /* renamed from: a */
    private final ByteBuffer f6694a;

    public C1054b(ByteBuffer byteBuffer) {
        this.f6694a = byteBuffer;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8847a(byte[] bArr, int i, int i2) {
        try {
            this.f6694a.put(bArr, i, i2);
        } catch (BufferOverflowException e2) {
            throw new IOException("Insufficient space in output buffer for " + i2 + " bytes", e2);
        }
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8846a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        try {
            this.f6694a.put(byteBuffer);
        } catch (BufferOverflowException e2) {
            throw new IOException("Insufficient space in output buffer for " + remaining + " bytes", e2);
        }
    }
}
