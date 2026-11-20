package p165d.p167b.p169b;

import java.p209io.IOException;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p173f.C1505e;

/* compiled from: EncryptedPrivateKeyInfo.java */
/* renamed from: d.b.b.c */
/* loaded from: classes.dex */
public class C1425c {

    /* renamed from: a */
    private C1505e f9218a;

    /* renamed from: b */
    private byte[] f9219b;

    /* renamed from: c */
    private byte[] f9220c;

    public C1425c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("encoding must not be null");
        }
        C1450m c1450m = new C1450m(bArr);
        C1450m[] c1450mArr = {c1450m.f9356b.m11371d(), c1450m.f9356b.m11371d()};
        if (c1450m.f9356b.m11362a() != 0) {
            throw new IOException("overrun, bytes = " + c1450m.f9356b.m11362a());
        }
        this.f9218a = C1505e.m11630a(c1450mArr[0]);
        if (c1450mArr[0].f9356b.m11362a() != 0) {
            throw new IOException("encryptionAlgorithm field overrun");
        }
        this.f9220c = c1450mArr[1].m11432m();
        if (c1450mArr[1].f9356b.m11362a() != 0) {
            throw new IOException("encryptedData field overrun");
        }
        this.f9219b = (byte[]) bArr.clone();
    }

    public C1425c(C1505e c1505e, byte[] bArr) {
        this.f9218a = c1505e;
        this.f9220c = (byte[]) bArr.clone();
    }

    /* renamed from: a */
    public C1505e m11246a() {
        return this.f9218a;
    }

    /* renamed from: c */
    public byte[] m11248c() {
        return (byte[]) this.f9220c.clone();
    }

    /* renamed from: b */
    public byte[] m11247b() {
        if (this.f9219b != null) {
            return (byte[]) this.f9219b.clone();
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        this.f9218a.m11637a(c1449l2);
        c1449l2.m11405b(this.f9220c);
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9219b = c1449l.toByteArray();
        return (byte[]) this.f9219b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1425c)) {
            return false;
        }
        try {
            byte[] m11247b = m11247b();
            byte[] m11247b2 = ((C1425c) obj).m11247b();
            if (m11247b.length != m11247b2.length) {
                return false;
            }
            for (int i = 0; i < m11247b.length; i++) {
                if (m11247b[i] != m11247b2[i]) {
                    return false;
                }
            }
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.f9220c.length) {
                i = (this.f9220c[i2] * i2) + i3;
                i2++;
            } else {
                return i3;
            }
        }
    }
}
