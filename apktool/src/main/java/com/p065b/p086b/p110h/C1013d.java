package com.p065b.p086b.p110h;

import android.widget.ExpandableListView;
import java.io.DataInputStream;
import java.io.InputStream;

/* compiled from: ByteArray.java */
/* renamed from: com.b.b.h.d */
/* loaded from: classes.dex */
public final class C1013d {

    /* renamed from: a */
    private final byte[] f6475a;

    /* renamed from: b */
    private final int f6476b;

    /* renamed from: c */
    private final int f6477c;

    public C1013d(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start");
        }
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("end > bytes.length");
        }
        this.f6475a = bArr;
        this.f6476b = i;
        this.f6477c = i2 - i;
    }

    public C1013d(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public int m8502a() {
        return this.f6477c;
    }

    /* renamed from: a */
    public C1013d m8504a(int i, int i2) {
        m8497b(i, i2);
        return new C1013d(this.f6475a, this.f6476b + i, this.f6476b + i2);
    }

    /* renamed from: a */
    public int m8503a(int i) {
        m8497b(i, i + 1);
        return m8500g(i);
    }

    /* renamed from: b */
    public int m8506b(int i) {
        m8497b(i, i + 2);
        return (m8500g(i) << 8) | m8501h(i + 1);
    }

    /* renamed from: c */
    public int m8508c(int i) {
        m8497b(i, i + 4);
        return (m8500g(i) << 24) | (m8501h(i + 1) << 16) | (m8501h(i + 2) << 8) | m8501h(i + 3);
    }

    /* renamed from: d */
    public long m8510d(int i) {
        m8497b(i, i + 8);
        return (((((m8500g(i) << 24) | (m8501h(i + 1) << 16)) | (m8501h(i + 2) << 8)) | m8501h(i + 3)) << 32) | (((m8500g(i + 4) << 24) | (m8501h(i + 5) << 16) | (m8501h(i + 6) << 8) | m8501h(i + 7)) & ExpandableListView.PACKED_POSITION_VALUE_NULL);
    }

    /* renamed from: e */
    public int m8511e(int i) {
        m8497b(i, i + 1);
        return m8501h(i);
    }

    /* renamed from: f */
    public int m8512f(int i) {
        m8497b(i, i + 2);
        return (m8501h(i) << 8) | m8501h(i + 1);
    }

    /* renamed from: a */
    public void m8505a(byte[] bArr, int i) {
        if (bArr.length - i < this.f6477c) {
            throw new IndexOutOfBoundsException("(out.length - offset) < size()");
        }
        System.arraycopy(this.f6475a, this.f6476b, bArr, i, this.f6477c);
    }

    /* renamed from: b */
    private void m8497b(int i, int i2) {
        if (i < 0 || i2 < i || i2 > this.f6477c) {
            throw new IllegalArgumentException("bad range: " + i + ".." + i2 + "; actual size " + this.f6477c);
        }
    }

    /* renamed from: g */
    private int m8500g(int i) {
        return this.f6475a[this.f6476b + i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public int m8501h(int i) {
        return this.f6475a[this.f6476b + i] & 255;
    }

    /* renamed from: b */
    public a m8507b() {
        return new a(m8509c());
    }

    /* renamed from: c */
    public b m8509c() {
        return new b();
    }

    /* compiled from: ByteArray.java */
    /* renamed from: com.b.b.h.d$b */
    public class b extends InputStream {

        /* renamed from: b */
        private int f6480b = 0;

        /* renamed from: c */
        private int f6481c = 0;

        public b() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f6480b < C1013d.this.f6477c) {
                int m8501h = C1013d.this.m8501h(this.f6480b);
                this.f6480b++;
                return m8501h;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (i + i2 > bArr.length) {
                i2 = bArr.length - i;
            }
            int i3 = C1013d.this.f6477c - this.f6480b;
            if (i2 > i3) {
                i2 = i3;
            }
            System.arraycopy(C1013d.this.f6475a, this.f6480b + C1013d.this.f6476b, bArr, i, i2);
            this.f6480b += i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int available() {
            return C1013d.this.f6477c - this.f6480b;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.f6481c = this.f6480b;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f6480b = this.f6481c;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }
    }

    /* compiled from: ByteArray.java */
    /* renamed from: com.b.b.h.d$a */
    public static class a extends DataInputStream {

        /* renamed from: a */
        private final b f6478a;

        public a(b bVar) {
            super(bVar);
            this.f6478a = bVar;
        }
    }
}
