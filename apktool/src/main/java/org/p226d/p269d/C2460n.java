package org.p226d.p269d;

import java.io.InputStream;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessFileInputStream.java */
/* renamed from: org.d.d.n */
/* loaded from: classes.dex */
public class C2460n extends InputStream {

    /* renamed from: a */
    private int f12939a;

    /* renamed from: b */
    private final RandomAccessFile f12940b;

    public C2460n(RandomAccessFile randomAccessFile, int i) {
        this.f12939a = i;
        this.f12940b = randomAccessFile;
    }

    @Override // java.io.InputStream
    public int read() {
        this.f12940b.seek(this.f12939a);
        this.f12939a++;
        return this.f12940b.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        this.f12940b.seek(this.f12939a);
        int read = this.f12940b.read(bArr);
        this.f12939a += read;
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        this.f12940b.seek(this.f12939a);
        int read = this.f12940b.read(bArr, i, i2);
        this.f12939a += read;
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int min = Math.min((int) j, available());
        this.f12939a += min;
        return min;
    }

    @Override // java.io.InputStream
    public int available() {
        return ((int) this.f12940b.length()) - this.f12939a;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }
}
