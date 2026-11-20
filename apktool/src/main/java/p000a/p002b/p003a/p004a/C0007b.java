package p000a.p002b.p003a.p004a;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import p000a.p001a.InterfaceC0004e;

/* compiled from: ChainedDataSource.java */
/* renamed from: a.b.a.a.b */
/* loaded from: classes.dex */
public class C0007b implements InterfaceC0008c {

    /* renamed from: a */
    private InterfaceC0008c[] f20a;

    /* renamed from: b */
    private InterfaceC0008c f21b;

    /* renamed from: c */
    private int f22c;

    /* renamed from: d */
    private long f23d;

    /* renamed from: e */
    private long f24e;

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public long mo24a() {
        return mo29c() - m34d();
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public void mo26a(InterfaceC0004e interfaceC0004e, long j) {
        mo27a(new OutputStream(this, interfaceC0004e) { // from class: a.b.a.a.b.1

            /* renamed from: a */
            private final C0007b f25a;

            /* renamed from: b */
            private final InterfaceC0004e f26b;

            {
                this.f25a = this;
                this.f26b = interfaceC0004e;
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                this.f26b.mo6a(i);
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                this.f26b.mo9a(bArr, i, i2);
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

    C0007b(InterfaceC0008c... interfaceC0008cArr) {
        if (interfaceC0008cArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f20a = interfaceC0008cArr;
        this.f22c = 0;
        this.f21b = interfaceC0008cArr[this.f22c];
        this.f24e = 0;
        this.f23d = 0;
        for (InterfaceC0008c interfaceC0008c : interfaceC0008cArr) {
            this.f23d += interfaceC0008c.mo29c();
        }
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: c */
    public long mo29c() {
        return this.f23d;
    }

    /* renamed from: d */
    public long m34d() {
        return this.f24e;
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: e */
    public void mo31e() {
        this.f22c = 0;
        this.f21b = this.f20a[this.f22c];
        this.f24e = 0;
        for (InterfaceC0008c interfaceC0008c : this.f20a) {
            interfaceC0008c.mo31e();
        }
    }

    @Override // p000a.p002b.p003a.p004a.InterfaceC0008c
    /* renamed from: a */
    public void mo27a(OutputStream outputStream, long j) {
        if (j > mo24a()) {
            throw new EOFException();
        }
        while (j > 0) {
            long min = Math.min(j, this.f21b.mo24a());
            this.f21b.mo27a(outputStream, min);
            j -= min;
            this.f24e = min + this.f24e;
            if (this.f21b.mo24a() == 0 && this.f22c < this.f20a.length - 1) {
                InterfaceC0008c[] interfaceC0008cArr = this.f20a;
                int i = this.f22c + 1;
                this.f22c = i;
                this.f21b = interfaceC0008cArr[i];
            }
        }
    }
}
