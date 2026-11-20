package ru.p294a;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: AbstractUnicodeExtraField.java */
/* renamed from: ru.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2581a implements InterfaceC2603v {

    /* renamed from: a */
    private long f13413a;

    /* renamed from: b */
    private byte[] f13414b;

    /* renamed from: c */
    private byte[] f13415c;

    protected AbstractC2581a() {
    }

    protected AbstractC2581a(String str, byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        this.f13413a = crc32.getValue();
        this.f13414b = str.getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: g */
    private void m16044g() {
        if (this.f13414b != null) {
            this.f13415c = new byte[this.f13414b.length + 5];
            this.f13415c[0] = (byte) 1;
            System.arraycopy(C2605x.m16176a(this.f13413a), 0, this.f13415c, 1, 4);
            System.arraycopy(this.f13414b, 0, this.f13415c, 5, this.f13414b.length);
        }
    }

    /* renamed from: t_ */
    public long m16051t_() {
        return this.f13413a;
    }

    /* renamed from: b */
    public byte[] m16046b() {
        byte[] bArr = (byte[]) null;
        if (this.f13414b != null) {
            byte[] bArr2 = new byte[this.f13414b.length];
            System.arraycopy(this.f13414b, 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
        return bArr;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: c */
    public byte[] mo16047c() {
        if (this.f13415c == null) {
            m16044g();
        }
        byte[] bArr = (byte[]) null;
        if (this.f13415c != null) {
            byte[] bArr2 = new byte[this.f13415c.length];
            System.arraycopy(this.f13415c, 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
        return bArr;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: d */
    public C2607z mo16048d() {
        if (this.f13415c == null) {
            m16044g();
        }
        return new C2607z(this.f13415c.length);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: e */
    public byte[] mo16049e() {
        return mo16047c();
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: f */
    public C2607z mo16050f() {
        return mo16048d();
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public void mo16045a(byte[] bArr, int i, int i2) {
        if (i2 < 5) {
            throw new ZipException(new StringBuffer().append("UniCode path extra data must have at least").append(" 5 bytes.").toString());
        }
        byte b2 = bArr[i];
        if (b2 != 1) {
            throw new ZipException(new StringBuffer().append(new StringBuffer().append("Unsupported version [").append((int) b2).toString()).append("] for UniCode path extra data.").toString());
        }
        this.f13413a = C2605x.m16177b(bArr, i + 1);
        this.f13414b = new byte[i2 - 5];
        System.arraycopy(bArr, i + 5, this.f13414b, 0, i2 - 5);
        this.f13415c = (byte[]) null;
    }
}
