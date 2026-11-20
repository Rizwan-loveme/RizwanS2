package ru.p294a;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* compiled from: AsiExtraField.java */
/* renamed from: ru.a.b */
/* loaded from: classes.dex */
public class C2583b implements Cloneable, InterfaceC2603v {

    /* renamed from: a */
    private static final C2607z f13417a = new C2607z(30062);

    /* renamed from: b */
    private int f13418b = 0;

    /* renamed from: c */
    private int f13419c = 0;

    /* renamed from: d */
    private int f13420d = 0;

    /* renamed from: e */
    private String f13421e = "";

    /* renamed from: f */
    private boolean f13422f = false;

    /* renamed from: g */
    private CRC32 f13423g = new CRC32();

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public C2607z mo16060a() {
        return f13417a;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: f */
    public C2607z mo16050f() {
        return new C2607z(m16066h().getBytes().length + 14);
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: d */
    public C2607z mo16048d() {
        return mo16050f();
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: e */
    public byte[] mo16049e() {
        byte[] bArr = new byte[mo16050f().m16242b() - 4];
        System.arraycopy(C2607z.m16240a(m16068j()), 0, bArr, 0, 2);
        byte[] bytes = m16066h().getBytes();
        System.arraycopy(C2605x.m16176a(bytes.length), 0, bArr, 2, 4);
        System.arraycopy(C2607z.m16240a(m16063b()), 0, bArr, 6, 2);
        System.arraycopy(C2607z.m16240a(m16065g()), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.f13423g.reset();
        this.f13423g.update(bArr);
        long value = this.f13423g.getValue();
        byte[] bArr2 = new byte[bArr.length + 4];
        System.arraycopy(C2605x.m16176a(value), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        return bArr2;
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: c */
    public byte[] mo16047c() {
        return mo16049e();
    }

    /* renamed from: b */
    public int m16063b() {
        return this.f13419c;
    }

    /* renamed from: g */
    public int m16065g() {
        return this.f13420d;
    }

    /* renamed from: h */
    public String m16066h() {
        return this.f13421e;
    }

    /* renamed from: i */
    public boolean m16067i() {
        return !m16066h().isEmpty();
    }

    /* renamed from: a */
    public void m16061a(int i) {
        this.f13418b = m16064b(i);
    }

    /* renamed from: j */
    public int m16068j() {
        return this.f13418b;
    }

    /* renamed from: a */
    public void m16062a(boolean z) {
        this.f13422f = z;
        this.f13418b = m16064b(this.f13418b);
    }

    /* renamed from: k */
    public boolean m16069k() {
        return this.f13422f && !m16067i();
    }

    @Override // ru.p294a.InterfaceC2603v
    /* renamed from: a */
    public void mo16045a(byte[] bArr, int i, int i2) {
        long m16177b = C2605x.m16177b(bArr, i);
        byte[] bArr2 = new byte[i2 - 4];
        System.arraycopy(bArr, i + 4, bArr2, 0, i2 - 4);
        this.f13423g.reset();
        this.f13423g.update(bArr2);
        long value = this.f13423g.getValue();
        if (m16177b != value) {
            throw new ZipException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("bad CRC checksum ").append(Long.toHexString(m16177b)).toString()).append(" instead of ").toString()).append(Long.toHexString(value)).toString());
        }
        int m16238a = C2607z.m16238a(bArr2, 0);
        int m16177b2 = (int) C2605x.m16177b(bArr2, 2);
        if (m16177b2 < 0 || m16177b2 > bArr2.length - 10) {
            throw new ZipException(new StringBuffer().append(new StringBuffer().append("Bad symbolic link name length ").append(m16177b2).toString()).append(" in ASI extra field").toString());
        }
        this.f13419c = C2607z.m16238a(bArr2, 6);
        this.f13420d = C2607z.m16238a(bArr2, 8);
        if (m16177b2 == 0) {
            this.f13421e = "";
        } else {
            byte[] bArr3 = new byte[m16177b2];
            System.arraycopy(bArr2, 10, bArr3, 0, m16177b2);
            this.f13421e = new String(bArr3);
        }
        m16062a((m16238a & 16384) != 0);
        m16061a(m16238a);
    }

    /* renamed from: b */
    protected int m16064b(int i) {
        int i2 = 32768;
        if (m16067i()) {
            i2 = 40960;
        } else if (m16069k()) {
            i2 = 16384;
        }
        return i2 | (i & 4095);
    }

    public Object clone() {
        try {
            C2583b c2583b = (C2583b) super.clone();
            c2583b.f13423g = new CRC32();
            return c2583b;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
