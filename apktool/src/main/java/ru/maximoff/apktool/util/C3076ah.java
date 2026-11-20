package ru.maximoff.apktool.util;

import dalvik.bytecode.Opcodes;
import java.io.OutputStream;

/* compiled from: GifEncoder.java */
/* renamed from: ru.maximoff.apktool.util.ah */
/* loaded from: classes.dex */
class C3076ah {

    /* renamed from: a */
    int f17630a;

    /* renamed from: c */
    int f17632c;

    /* renamed from: j */
    int f17639j;

    /* renamed from: k */
    int f17640k;

    /* renamed from: l */
    int f17641l;

    /* renamed from: p */
    int f17645p;

    /* renamed from: r */
    private int f17647r;

    /* renamed from: s */
    private int f17648s;

    /* renamed from: t */
    private byte[] f17649t;

    /* renamed from: u */
    private int f17650u;

    /* renamed from: v */
    private int f17651v;

    /* renamed from: w */
    private int f17652w;

    /* renamed from: b */
    int f17631b = 12;

    /* renamed from: d */
    int f17633d = 4096;

    /* renamed from: e */
    int[] f17634e = new int[5003];

    /* renamed from: f */
    int[] f17635f = new int[5003];

    /* renamed from: g */
    int f17636g = 5003;

    /* renamed from: h */
    int f17637h = 0;

    /* renamed from: i */
    boolean f17638i = false;

    /* renamed from: m */
    int f17642m = 0;

    /* renamed from: n */
    int f17643n = 0;

    /* renamed from: o */
    int[] f17644o = {0, 1, 3, 7, 15, 31, 63, 127, 255, Opcodes.OP_CHECK_CAST_JUMBO, 1023, 2047, 4095, Opcodes.OP_SPUT_BYTE_JUMBO, 16383, 32767, 65535};

    /* renamed from: q */
    byte[] f17646q = new byte[256];

    C3076ah(int i, int i2, byte[] bArr, int i3) {
        this.f17647r = i;
        this.f17648s = i2;
        this.f17649t = bArr;
        this.f17650u = Math.max(2, i3);
    }

    /* renamed from: a */
    void m18480a(byte b2, OutputStream outputStream) {
        byte[] bArr = this.f17646q;
        int i = this.f17645p;
        this.f17645p = i + 1;
        bArr[i] = b2;
        if (this.f17645p >= 254) {
            m18487c(outputStream);
        }
    }

    /* renamed from: a */
    void m18483a(OutputStream outputStream) {
        m18481a(this.f17636g);
        this.f17637h = this.f17640k + 2;
        this.f17638i = true;
        m18485b(this.f17640k, outputStream);
    }

    /* renamed from: a */
    void m18481a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f17634e[i2] = -1;
        }
    }

    /* renamed from: a */
    void m18482a(int i, OutputStream outputStream) {
        int i2 = 0;
        this.f17639j = i;
        this.f17638i = false;
        this.f17630a = this.f17639j;
        this.f17632c = m18484b(this.f17630a);
        this.f17640k = 1 << (i - 1);
        this.f17641l = this.f17640k + 1;
        this.f17637h = this.f17640k + 2;
        this.f17645p = 0;
        int m18479a = m18479a();
        for (int i3 = this.f17636g; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.f17636g;
        m18481a(i5);
        m18485b(this.f17640k, outputStream);
        while (true) {
            int m18479a2 = m18479a();
            if (m18479a2 != -1) {
                int i6 = (m18479a2 << this.f17631b) + m18479a;
                int i7 = (m18479a2 << i4) ^ m18479a;
                if (this.f17634e[i7] == i6) {
                    m18479a = this.f17635f[i7];
                } else {
                    if (this.f17634e[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.f17634e[i7] == i6) {
                                m18479a = this.f17635f[i7];
                                break;
                            }
                        } while (this.f17634e[i7] >= 0);
                    }
                    m18485b(m18479a, outputStream);
                    if (this.f17637h < this.f17633d) {
                        int[] iArr = this.f17635f;
                        int i9 = this.f17637h;
                        this.f17637h = i9 + 1;
                        iArr[i7] = i9;
                        this.f17634e[i7] = i6;
                        m18479a = m18479a2;
                    } else {
                        m18483a(outputStream);
                        m18479a = m18479a2;
                    }
                }
            } else {
                m18485b(m18479a, outputStream);
                m18485b(this.f17641l, outputStream);
                return;
            }
        }
    }

    /* renamed from: b */
    void m18486b(OutputStream outputStream) {
        outputStream.write(this.f17650u);
        this.f17651v = this.f17647r * this.f17648s;
        this.f17652w = 0;
        m18482a(this.f17650u + 1, outputStream);
        outputStream.write(0);
    }

    /* renamed from: c */
    void m18487c(OutputStream outputStream) {
        if (this.f17645p > 0) {
            outputStream.write(this.f17645p);
            outputStream.write(this.f17646q, 0, this.f17645p);
            this.f17645p = 0;
        }
    }

    /* renamed from: b */
    final int m18484b(int i) {
        return (1 << i) - 1;
    }

    /* renamed from: a */
    private int m18479a() {
        if (this.f17651v == 0) {
            return -1;
        }
        this.f17651v--;
        byte[] bArr = this.f17649t;
        int i = this.f17652w;
        this.f17652w = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: b */
    void m18485b(int i, OutputStream outputStream) {
        this.f17642m &= this.f17644o[this.f17643n];
        if (this.f17643n > 0) {
            this.f17642m |= i << this.f17643n;
        } else {
            this.f17642m = i;
        }
        this.f17643n += this.f17630a;
        while (this.f17643n >= 8) {
            m18480a((byte) (this.f17642m & 255), outputStream);
            this.f17642m >>= 8;
            this.f17643n -= 8;
        }
        if (this.f17637h > this.f17632c || this.f17638i) {
            if (this.f17638i) {
                int i2 = this.f17639j;
                this.f17630a = i2;
                this.f17632c = m18484b(i2);
                this.f17638i = false;
            } else {
                this.f17630a++;
                if (this.f17630a == this.f17631b) {
                    this.f17632c = this.f17633d;
                } else {
                    this.f17632c = m18484b(this.f17630a);
                }
            }
        }
        if (i == this.f17641l) {
            while (this.f17643n > 0) {
                m18480a((byte) (this.f17642m & 255), outputStream);
                this.f17642m >>= 8;
                this.f17643n -= 8;
            }
            m18487c(outputStream);
        }
    }
}
