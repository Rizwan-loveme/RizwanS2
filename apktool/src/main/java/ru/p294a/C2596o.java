package ru.p294a;

import java.util.zip.ZipException;

/* compiled from: Zip64ExtendedInformationExtraField.java */
/* renamed from: ru.a.o */
/* loaded from: classes.dex */
public class C2596o implements InterfaceC2584c {

    /* renamed from: a */
    static final C2607z f13457a = new C2607z(1);

    /* renamed from: b */
    private static final byte[] f13458b = new byte[0];

    /* renamed from: c */
    private C2599r f13459c;

    /* renamed from: d */
    private C2599r f13460d;

    /* renamed from: e */
    private C2599r f13461e;

    /* renamed from: f */
    private C2605x f13462f;

    /* renamed from: g */
    private byte[] f13463g;

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public C2607z mo16060a() {
        return f13457a;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: f */
    public C2607z mo16050f() {
        return new C2607z(this.f13459c != null ? 16 : 0);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: d */
    public C2607z mo16048d() {
        return new C2607z((this.f13459c != null ? 8 : 0) + (this.f13460d != null ? 8 : 0) + (this.f13461e == null ? 0 : 8) + (this.f13462f != null ? 4 : 0));
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: e */
    public byte[] mo16049e() {
        if (this.f13459c == null && this.f13460d == null) {
            return f13458b;
        }
        if (this.f13459c == null || this.f13460d == null) {
            throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
        }
        byte[] bArr = new byte[16];
        m16096a(bArr);
        return bArr;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: c */
    public byte[] mo16047c() {
        byte[] bArr = new byte[mo16048d().m16242b()];
        int m16096a = m16096a(bArr);
        if (this.f13461e != null) {
            System.arraycopy(this.f13461e.m16110a(), 0, bArr, m16096a, 8);
            m16096a += 8;
        }
        if (this.f13462f != null) {
            System.arraycopy(this.f13462f.m16179a(), 0, bArr, m16096a, 4);
            int i = m16096a + 4;
        }
        return bArr;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public void mo16045a(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            if (i2 < 16) {
                throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
            }
            this.f13459c = new C2599r(bArr, i);
            int i3 = i + 8;
            this.f13460d = new C2599r(bArr, i3);
            int i4 = i3 + 8;
            int i5 = i2 - 16;
            if (i5 >= 8) {
                this.f13461e = new C2599r(bArr, i4);
                i4 += 8;
                i5 -= 8;
            }
            if (i5 >= 4) {
                this.f13462f = new C2605x(bArr, i4);
                int i6 = i4 + 4;
                int i7 = i5 - 4;
            }
        }
    }

    @Override // ru.p294a.InterfaceC2584c
    /* renamed from: b */
    public void mo16070b(byte[] bArr, int i, int i2) {
        this.f13463g = new byte[i2];
        System.arraycopy(bArr, i, this.f13463g, 0, i2);
        if (i2 >= 28) {
            mo16045a(bArr, i, i2);
            return;
        }
        if (i2 == 24) {
            this.f13459c = new C2599r(bArr, i);
            int i3 = i + 8;
            this.f13460d = new C2599r(bArr, i3);
            this.f13461e = new C2599r(bArr, i3 + 8);
            return;
        }
        if (i2 % 8 == 4) {
            this.f13462f = new C2605x(bArr, (i + i2) - 4);
        }
    }

    /* renamed from: a */
    public void m16098a(boolean z, boolean z2, boolean z3, boolean z4) {
        int i;
        if (this.f13463g != null) {
            int i2 = (z4 ? 4 : 0) + (z ? 8 : 0) + (z2 ? 8 : 0) + (z3 ? 8 : 0);
            if (this.f13463g.length < i2) {
                throw new ZipException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("central directory zip64 extended").append(" information extra field's length").toString()).append(" doesn't match central directory").toString()).append(" data.  Expected length ").toString()).append(i2).toString()).append(" but is ").toString()).append(this.f13463g.length).toString());
            }
            if (z) {
                this.f13459c = new C2599r(this.f13463g, 0);
                i = 8;
            } else {
                i = 0;
            }
            if (z2) {
                this.f13460d = new C2599r(this.f13463g, i);
                i += 8;
            }
            if (z3) {
                this.f13461e = new C2599r(this.f13463g, i);
                i += 8;
            }
            if (z4) {
                this.f13462f = new C2605x(this.f13463g, i);
                int i3 = i + 4;
            }
        }
    }

    /* renamed from: b */
    public C2599r m16099b() {
        return this.f13459c;
    }

    /* renamed from: a */
    public void m16097a(C2599r c2599r) {
        this.f13459c = c2599r;
    }

    /* renamed from: g */
    public C2599r m16102g() {
        return this.f13460d;
    }

    /* renamed from: b */
    public void m16100b(C2599r c2599r) {
        this.f13460d = c2599r;
    }

    /* renamed from: h */
    public C2599r m16103h() {
        return this.f13461e;
    }

    /* renamed from: c */
    public void m16101c(C2599r c2599r) {
        this.f13461e = c2599r;
    }

    /* renamed from: a */
    private int m16096a(byte[] bArr) {
        int i;
        if (this.f13459c != null) {
            System.arraycopy(this.f13459c.m16110a(), 0, bArr, 0, 8);
            i = 8;
        } else {
            i = 0;
        }
        if (this.f13460d != null) {
            System.arraycopy(this.f13460d.m16110a(), 0, bArr, i, 8);
            return i + 8;
        }
        return i;
    }
}
