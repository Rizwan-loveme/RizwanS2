package com.p065b.p111c.p113b.p118c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import java.nio.ByteBuffer;
import java.p209io.OutputStream;

/* compiled from: OutputStreamDataSink.java */
/* renamed from: com.b.c.b.c.f */
/* loaded from: classes.dex */
public class C1058f implements InterfaceC1067a {

    /* renamed from: a */
    private final OutputStream f6699a;

    public C1058f(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("out == null");
        }
        this.f6699a = outputStream;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8847a(byte[] bArr, int i, int i2) {
        this.f6699a.write(bArr, i, i2);
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8846a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (byteBuffer.hasArray()) {
                this.f6699a.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            byte[] bArr = new byte[Math.min(byteBuffer.remaining(), 65536)];
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(byteBuffer.remaining(), bArr.length);
                byteBuffer.get(bArr, 0, min);
                this.f6699a.write(bArr, 0, min);
            }
        }
    }
}
