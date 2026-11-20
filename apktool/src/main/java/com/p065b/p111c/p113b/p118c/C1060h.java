package com.p065b.p111c.p113b.p118c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessFileDataSink.java */
/* renamed from: com.b.c.b.c.h */
/* loaded from: classes.dex */
public class C1060h implements InterfaceC1067a {

    /* renamed from: a */
    private final RandomAccessFile f6702a;

    /* renamed from: b */
    private final FileChannel f6703b;

    /* renamed from: c */
    private long f6704c;

    public C1060h(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, 0L);
    }

    public C1060h(RandomAccessFile randomAccessFile, long j) {
        if (randomAccessFile == null) {
            throw new NullPointerException("file == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("startPosition: " + j);
        }
        this.f6702a = randomAccessFile;
        this.f6703b = randomAccessFile.getChannel();
        this.f6704c = j;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8847a(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offset: " + i);
        }
        if (i > bArr.length) {
            throw new IndexOutOfBoundsException("offset: " + i + ", buf.length: " + bArr.length);
        }
        if (i2 != 0) {
            synchronized (this.f6702a) {
                this.f6702a.seek(this.f6704c);
                this.f6702a.write(bArr, i, i2);
                this.f6704c += i2;
            }
        }
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8846a(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining != 0) {
            synchronized (this.f6702a) {
                this.f6702a.seek(this.f6704c);
                while (byteBuffer.hasRemaining()) {
                    this.f6703b.write(byteBuffer);
                }
                this.f6704c += remaining;
            }
        }
    }
}
