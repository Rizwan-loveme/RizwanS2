package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import java.nio.ByteBuffer;
import java.io.OutputStream;

/* compiled from: OutputStreamDataSink.java */
/* renamed from: com.b.a.b.g.j */
/* loaded from: classes.dex */
public class C0651j implements InterfaceC0669a {
    private static final int MAX_READ_CHUNK_SIZE = 65536;

    /* renamed from: a */
    private final OutputStream f4250a;

    public C0651j(OutputStream outputStream) {
        if (outputStream == null) {
            throw new NullPointerException("out == null");
        }
        this.f4250a = outputStream;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6240a(byte[] bArr, int i, int i2) {
        this.f4250a.write(bArr, i, i2);
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6239a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            if (byteBuffer.hasArray()) {
                this.f4250a.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.position(byteBuffer.limit());
                return;
            }
            int min = Math.min(byteBuffer.remaining(), 65536);
            byte[] bArr = new byte[min];
            while (byteBuffer.hasRemaining()) {
                int min2 = Math.min(byteBuffer.remaining(), min);
                byteBuffer.get(bArr, 0, min2);
                this.f4250a.write(bArr, 0, min2);
            }
        }
    }
}
