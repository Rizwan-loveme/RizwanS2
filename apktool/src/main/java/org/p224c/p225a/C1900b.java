package org.p224c.p225a;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: BrotliInputStream.java */
/* renamed from: org.c.a.b */
/* loaded from: classes.dex */
public class C1900b extends InputStream {

    /* renamed from: a */
    private byte[] f11182a;

    /* renamed from: b */
    private int f11183b;

    /* renamed from: c */
    private int f11184c;

    /* renamed from: d */
    private final C1909k f11185d;

    public C1900b(InputStream inputStream) {
        this(inputStream, 16384, null);
    }

    public C1900b(InputStream inputStream, int i, byte[] bArr) {
        this.f11185d = new C1909k();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.f11182a = new byte[i];
        this.f11183b = 0;
        this.f11184c = 0;
        try {
            C1909k.m14075a(this.f11185d, inputStream);
            if (bArr != null) {
                C1903e.m14048a(this.f11185d, bArr);
            }
        } catch (C1901c e2) {
            throw new IOException("Brotli decoder initialization failed", e2);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C1909k.m14074a(this.f11185d);
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f11184c >= this.f11183b) {
            this.f11183b = read(this.f11182a, 0, this.f11182a.length);
            this.f11184c = 0;
            if (this.f11183b == -1) {
                return -1;
            }
        }
        byte[] bArr = this.f11182a;
        int i = this.f11184c;
        this.f11184c = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Bad length: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException("Buffer overflow: " + (i + i2) + " > " + bArr.length);
        }
        if (i2 == 0) {
            return 0;
        }
        int max = Math.max(this.f11183b - this.f11184c, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.f11182a, this.f11184c, bArr, i, max);
            this.f11184c += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.f11185d.f11233Z = bArr;
            this.f11185d.f11228U = i;
            this.f11185d.f11229V = i2;
            this.f11185d.f11230W = 0;
            C1903e.m14046a(this.f11185d);
            if (this.f11185d.f11230W == 0) {
                return -1;
            }
            return max + this.f11185d.f11230W;
        } catch (C1901c e2) {
            throw new IOException("Brotli stream decoding failed", e2);
        }
    }
}
