package org.p226d.p269d;

import java.p209io.OutputStream;
import java.p209io.RandomAccessFile;

/* compiled from: RandomAccessFileOutputStream.java */
/* renamed from: org.d.d.o */
/* loaded from: classes.dex */
public class C2461o extends OutputStream {

    /* renamed from: a */
    private int f12941a;

    /* renamed from: b */
    private final RandomAccessFile f12942b;

    public C2461o(RandomAccessFile randomAccessFile, int i) {
        this.f12941a = i;
        this.f12942b = randomAccessFile;
    }

    @Override // java.p209io.OutputStream
    public void write(int i) {
        this.f12942b.seek(this.f12941a);
        this.f12941a++;
        this.f12942b.write(i);
    }

    @Override // java.p209io.OutputStream
    public void write(byte[] bArr) {
        this.f12942b.seek(this.f12941a);
        this.f12941a += bArr.length;
        this.f12942b.write(bArr);
    }

    @Override // java.p209io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f12942b.seek(this.f12941a);
        this.f12941a += i2;
        this.f12942b.write(bArr, i, i2);
    }
}
