package p000a.p001a;

import java.io.File;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessDataImpl.java */
/* renamed from: a.a.c */
/* loaded from: classes.dex */
class C0002c implements InterfaceC0001b {

    /* renamed from: a */
    private final RandomAccessFile f11a;

    /* renamed from: b */
    private final File f12b;

    /* renamed from: c */
    private final String f13c;

    C0002c(File file, String str) {
        this.f12b = file;
        this.f13c = str;
        this.f11a = new RandomAccessFile(file, str);
    }

    @Override // p000a.p001a.InterfaceC0001b
    /* renamed from: a */
    public void mo17a(long j) {
        this.f11a.seek(j);
    }

    @Override // p000a.p001a.InterfaceC0001b
    /* renamed from: a */
    public int mo15a(byte[] bArr, int i, int i2) {
        return this.f11a.read(bArr, i, i2);
    }

    @Override // p000a.p001a.InterfaceC0001b
    /* renamed from: b */
    public void mo19b(byte[] bArr, int i, int i2) {
        this.f11a.write(bArr, i, i2);
    }

    @Override // p000a.p001a.InterfaceC0001b
    /* renamed from: a */
    public long mo16a() {
        return this.f11a.length();
    }

    @Override // p000a.p001a.InterfaceC0001b
    /* renamed from: b */
    public void mo18b(long j) {
        this.f11a.setLength(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11a.close();
    }
}
