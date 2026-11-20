package org.p217b.p218a.p219a.p221b;

import java.p209io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ByteArrayOutputStream.java */
/* renamed from: org.b.a.a.b.a */
/* loaded from: classes.dex */
public class C1883a extends OutputStream {

    /* renamed from: a */
    private static final byte[] f11035a = new byte[0];

    /* renamed from: b */
    private final List<byte[]> f11036b;

    /* renamed from: c */
    private int f11037c;

    /* renamed from: d */
    private int f11038d;

    /* renamed from: e */
    private byte[] f11039e;

    /* renamed from: f */
    private int f11040f;

    public C1883a() {
        this(1024);
    }

    public C1883a(int i) {
        this.f11036b = new ArrayList();
        if (i < 0) {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
        synchronized (this) {
            m13948a(i);
        }
    }

    /* renamed from: a */
    private void m13948a(int i) {
        if (this.f11037c < this.f11036b.size() - 1) {
            this.f11038d += this.f11039e.length;
            this.f11037c++;
            this.f11039e = this.f11036b.get(this.f11037c);
            return;
        }
        if (this.f11039e == null) {
            this.f11038d = 0;
        } else {
            i = Math.max(this.f11039e.length << 1, i - this.f11038d);
            this.f11038d += this.f11039e.length;
        }
        this.f11037c++;
        this.f11039e = new byte[i];
        this.f11036b.add(this.f11039e);
    }

    @Override // java.p209io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            synchronized (this) {
                int i3 = this.f11040f + i2;
                int i4 = this.f11040f - this.f11038d;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.f11039e.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.f11039e, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        m13948a(i3);
                        i4 = 0;
                    }
                }
                this.f11040f = i3;
            }
        }
    }

    @Override // java.p209io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.f11040f - this.f11038d;
        if (i2 == this.f11039e.length) {
            m13948a(this.f11040f + 1);
            i2 = 0;
        }
        this.f11039e[i2] = (byte) i;
        this.f11040f++;
    }

    @Override // java.p209io.OutputStream, java.p209io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: a */
    public synchronized byte[] m13949a() {
        byte[] bArr;
        int i = 0;
        synchronized (this) {
            int i2 = this.f11040f;
            if (i2 == 0) {
                bArr = f11035a;
            } else {
                byte[] bArr2 = new byte[i2];
                Iterator<byte[]> it = this.f11036b.iterator();
                do {
                    int i3 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    byte[] next = it.next();
                    int min = Math.min(next.length, i2);
                    System.arraycopy(next, 0, bArr2, i3, min);
                    i = i3 + min;
                    i2 -= min;
                } while (i2 != 0);
                bArr = bArr2;
            }
        }
        return bArr;
    }

    public String toString() {
        return new String(m13949a());
    }
}
