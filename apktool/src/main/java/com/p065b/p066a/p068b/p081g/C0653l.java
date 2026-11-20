package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessFileDataSink.java */
/* renamed from: com.b.a.b.g.l */
/* loaded from: classes.dex */
public class C0653l implements InterfaceC0669a {

    /* renamed from: a */
    private final RandomAccessFile f4253a;

    /* renamed from: b */
    private final FileChannel f4254b;

    /* renamed from: c */
    private long f4255c;

    public C0653l(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, 0L);
    }

    public C0653l(RandomAccessFile randomAccessFile, long j) {
        if (randomAccessFile == null) {
            throw new NullPointerException("file == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("startPosition: " + j);
        }
        this.f4253a = randomAccessFile;
        this.f4254b = randomAccessFile.getChannel();
        this.f4255c = j;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6240a(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offset: " + i);
        }
        if (i > bArr.length) {
            throw new IndexOutOfBoundsException("offset: " + i + ", buf.length: " + bArr.length);
        }
        if (i2 != 0) {
            synchronized (this.f4253a) {
                this.f4253a.seek(this.f4255c);
                this.f4253a.write(bArr, i, i2);
                this.f4255c += i2;
            }
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6239a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining != 0) {
            synchronized (this.f4253a) {
                this.f4253a.seek(this.f4255c);
                while (byteBuffer.hasRemaining()) {
                    this.f4254b.write(byteBuffer);
                }
                this.f4255c += remaining;
            }
        }
    }
}
