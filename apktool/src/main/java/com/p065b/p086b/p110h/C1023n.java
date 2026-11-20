package com.p065b.p086b.p110h;

import java.io.FilterWriter;
import java.io.Writer;

/* compiled from: IndentingWriter.java */
/* renamed from: com.b.b.h.n */
/* loaded from: classes.dex */
public final class C1023n extends FilterWriter {

    /* renamed from: a */
    private final String f6496a;

    /* renamed from: b */
    private final int f6497b;

    /* renamed from: c */
    private final int f6498c;

    /* renamed from: d */
    private int f6499d;

    /* renamed from: e */
    private boolean f6500e;

    /* renamed from: f */
    private int f6501f;

    public C1023n(Writer writer, int i, String str) {
        super(writer);
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("width < 0");
        }
        if (str == null) {
            throw new NullPointerException("prefix == null");
        }
        this.f6497b = i != 0 ? i : Integer.MAX_VALUE;
        this.f6498c = i >> 1;
        this.f6496a = str.length() == 0 ? null : str;
        m8564a();
    }

    public C1023n(Writer writer, int i) {
        this(writer, i, "");
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i) {
        synchronized (this.lock) {
            if (this.f6500e) {
                if (i == 32) {
                    this.f6501f++;
                    if (this.f6501f >= this.f6498c) {
                        this.f6501f = this.f6498c;
                        this.f6500e = false;
                    }
                } else {
                    this.f6500e = false;
                }
            }
            if (this.f6499d == this.f6497b && i != 10) {
                this.out.write(10);
                this.f6499d = 0;
            }
            if (this.f6499d == 0) {
                if (this.f6496a != null) {
                    this.out.write(this.f6496a);
                }
                if (!this.f6500e) {
                    for (int i2 = 0; i2 < this.f6501f; i2++) {
                        this.out.write(32);
                    }
                    this.f6499d = this.f6501f;
                }
            }
            this.out.write(i);
            if (i == 10) {
                m8564a();
            } else {
                this.f6499d++;
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                write(cArr[i]);
                i++;
                i2--;
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        synchronized (this.lock) {
            while (i2 > 0) {
                write(str.charAt(i));
                i++;
                i2--;
            }
        }
    }

    /* renamed from: a */
    private void m8564a() {
        this.f6499d = 0;
        this.f6500e = this.f6498c != 0;
        this.f6501f = 0;
    }
}
