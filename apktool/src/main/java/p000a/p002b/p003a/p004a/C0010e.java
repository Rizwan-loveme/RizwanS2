package p000a.p002b.p003a.p004a;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import p000a.p001a.InterfaceC0004e;

/* compiled from: FileDataSource.java */
/* renamed from: a.b.a.a.e */
/* loaded from: classes.dex */
public class C0010e implements InterfaceC0008c {

    /* renamed from: a */
    private InterfaceC0004e f27a;

    /* renamed from: b */
    private long f28b;

    /* renamed from: c */
    private long f29c;

    /* renamed from: d */
    private long f30d;

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public long mo24a() {
        return mo29c() - m40d();
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public void mo26a(InterfaceC0004e interfaceC0004e, long j) {
        mo27a(new OutputStream(this, interfaceC0004e) { // from class: a.b.a.a.e.1

            /* renamed from: a */
            private final C0010e f31a;

            /* renamed from: b */
            private final InterfaceC0004e f32b;

            {
                this.f31a = this;
                this.f32b = interfaceC0004e;
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                this.f32b.mo6a(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                this.f32b.mo9a(bArr, i, i2);
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

    C0010e(InterfaceC0004e interfaceC0004e, long j, long j2) {
        this.f27a = interfaceC0004e;
        this.f28b = j;
        this.f29c = j2;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: c */
    public long mo29c() {
        return this.f29c;
    }

    /* renamed from: d */
    public long m40d() {
        return this.f30d;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: e */
    public void mo31e() {
        this.f30d = 0;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public void mo27a(OutputStream outputStream, long j) {
        int mo10b;
        if (j > mo24a()) {
            throw new EOFException();
        }
        byte[] bArr = new byte[4096];
        this.f27a.mo12b(this.f28b + this.f30d);
        while (j > 0 && (mo10b = this.f27a.mo10b(bArr, 0, (int) Math.min(j, bArr.length))) != -1) {
            outputStream.write(bArr, 0, mo10b);
            j -= mo10b;
            this.f30d += mo10b;
        }
        if (j != 0) {
            throw new IllegalStateException(new StringBuffer().append("Remaining length: ").append(j).toString());
        }
    }
}
