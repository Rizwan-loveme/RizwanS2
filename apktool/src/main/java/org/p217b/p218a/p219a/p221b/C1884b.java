package org.p217b.p218a.p219a.p221b;

import java.p209io.Serializable;
import java.p209io.Writer;

/* compiled from: StringBuilderWriter.java */
/* renamed from: org.b.a.a.b.b */
/* loaded from: classes.dex */
public class C1884b extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f11041a;

    public C1884b() {
        this.f11041a = new StringBuilder();
    }

    public C1884b(int i) {
        this.f11041a = new StringBuilder(i);
    }

    @Override // java.p209io.Writer, java.lang.Appendable
    public Writer append(char c2) {
        this.f11041a.append(c2);
        return this;
    }

    @Override // java.p209io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.f11041a.append(charSequence);
        return this;
    }

    @Override // java.p209io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        this.f11041a.append(charSequence, i, i2);
        return this;
    }

    @Override // java.p209io.Writer, java.p209io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.p209io.Writer, java.p209io.Flushable
    public void flush() {
    }

    @Override // java.p209io.Writer
    public void write(String str) {
        if (str != null) {
            this.f11041a.append(str);
        }
    }

    @Override // java.p209io.Writer
    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.f11041a.append(cArr, i, i2);
        }
    }

    public String toString() {
        return this.f11041a.toString();
    }
}
