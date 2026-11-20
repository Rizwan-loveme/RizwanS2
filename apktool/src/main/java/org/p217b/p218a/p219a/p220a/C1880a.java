package org.p217b.p218a.p219a.p220a;

import java.io.InputStream;

/* compiled from: CountingInputStream.java */
/* renamed from: org.b.a.a.a.a */
/* loaded from: classes.dex */
public class C1880a extends AbstractC1881b {

    /* renamed from: a */
    private long f11024a;

    public C1880a(InputStream inputStream) {
        super(inputStream);
    }

    @Override // org.p217b.p218a.p219a.p220a.AbstractC1881b, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        long skip;
        skip = super.skip(j);
        this.f11024a += skip;
        return skip;
    }

    @Override // org.p217b.p218a.p219a.p220a.AbstractC1881b
    /* renamed from: a */
    protected synchronized void mo13938a(int i) {
        if (i != -1) {
            this.f11024a += i;
        }
    }

    /* renamed from: a */
    public int m13937a() {
        long m13939b = m13939b();
        if (m13939b > 2147483647L) {
            throw new ArithmeticException("The byte count " + m13939b + " is too large to be converted to an int");
        }
        return (int) m13939b;
    }

    /* renamed from: b */
    public synchronized long m13939b() {
        return this.f11024a;
    }
}
