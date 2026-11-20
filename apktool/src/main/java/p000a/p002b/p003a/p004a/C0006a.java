package p000a.p002b.p003a.p004a;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import p000a.p001a.InterfaceC0004e;

/* compiled from: ByteArrayDataSource.java */
/* renamed from: a.b.a.a.a */
/* loaded from: classes.dex */
public class C0006a implements InterfaceC0008c {

    /* renamed from: a */
    private byte[] f14a;

    /* renamed from: b */
    private int f15b;

    /* renamed from: c */
    private int f16c;

    /* renamed from: d */
    private int f17d;

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public long mo24a() {
        return mo29c() - m30d();
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public void mo26a(InterfaceC0004e interfaceC0004e, long j) {
        mo27a(new OutputStream(this, interfaceC0004e) { // from class: a.b.a.a.a.1

            /* renamed from: a */
            private final C0006a f18a;

            /* renamed from: b */
            private final InterfaceC0004e f19b;

            {
                this.f18a = this;
                this.f19b = interfaceC0004e;
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                this.f19b.mo6a(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                this.f19b.mo9a(bArr, i, i2);
            }
        }, j);
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public InterfaceC0008c mo25a(int i) {
        return C0009d.m36a(this, i);
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: b */
    public C0006a mo28b() {
        long mo24a = mo24a();
        if (mo24a > Integer.MAX_VALUE) {
            throw new IOException("Data too large");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) mo24a);
        mo27a(byteArrayOutputStream, mo24a);
        return (C0006a) C0009d.m37a(byteArrayOutputStream.toByteArray());
    }

    C0006a(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        this.f14a = bArr;
        this.f15b = i;
        this.f16c = i2;
        this.f17d = 0;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: c */
    public long mo29c() {
        return this.f16c;
    }

    /* renamed from: d */
    public long m30d() {
        return this.f17d;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: e */
    public void mo31e() {
        this.f17d = 0;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public void mo27a(OutputStream outputStream, long j) {
        if (j > mo24a()) {
            throw new EOFException();
        }
        outputStream.write(this.f14a, this.f15b + this.f17d, (int) j);
        this.f17d = (int) (this.f17d + j);
    }

    /* renamed from: f */
    public byte[] m32f() {
        return this.f14a;
    }

    /* renamed from: g */
    public int m33g() {
        return this.f15b;
    }
}
