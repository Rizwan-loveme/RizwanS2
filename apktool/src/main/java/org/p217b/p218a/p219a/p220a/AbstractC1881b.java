package org.p217b.p218a.p219a.p220a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProxyInputStream.java */
/* renamed from: org.b.a.a.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1881b extends FilterInputStream {
    public AbstractC1881b(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        try {
            m13941b(1);
            int read = this.f10665in.read();
            mo13938a(read == -1 ? -1 : 1);
            return read;
        } catch (IOException e2) {
            m13940a(e2);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        int length;
        if (bArr == null) {
            length = 0;
        } else {
            try {
                length = bArr.length;
            } catch (IOException e2) {
                m13940a(e2);
                return -1;
            }
        }
        m13941b(length);
        int read = this.f10665in.read(bArr);
        mo13938a(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            m13941b(i2);
            int read = this.f10665in.read(bArr, i, i2);
            mo13938a(read);
            return read;
        } catch (IOException e2) {
            m13940a(e2);
            return -1;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        try {
            return this.f10665in.skip(j);
        } catch (IOException e2) {
            m13940a(e2);
            return 0L;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        try {
            return super.available();
        } catch (IOException e2) {
            m13940a(e2);
            return 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f10665in.close();
        } catch (IOException e2) {
            m13940a(e2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f10665in.mark(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            this.f10665in.reset();
        } catch (IOException e2) {
            m13940a(e2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return this.f10665in.markSupported();
    }

    /* renamed from: b */
    protected void m13941b(int i) {
    }

    /* renamed from: a */
    protected void mo13938a(int i) {
    }

    /* renamed from: a */
    protected void m13940a(IOException iOException) {
        throw iOException;
    }
}
