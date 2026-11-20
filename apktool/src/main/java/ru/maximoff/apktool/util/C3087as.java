package ru.maximoff.apktool.util;

/* compiled from: GifEncoder.java */
/* renamed from: ru.maximoff.apktool.util.as */
/* loaded from: classes.dex */
class C3087as {

    /* renamed from: a */
    protected int f18034a;

    /* renamed from: b */
    protected byte[] f18035b;

    /* renamed from: c */
    protected int f18036c;

    /* renamed from: d */
    protected int f18037d;

    /* renamed from: f */
    protected int[] f18039f = new int[256];

    /* renamed from: g */
    protected int[] f18040g = new int[256];

    /* renamed from: h */
    protected int[] f18041h = new int[256];

    /* renamed from: i */
    protected int[] f18042i = new int[32];

    /* renamed from: e */
    protected int[][] f18038e = new int[256][];

    public C3087as(byte[] bArr, int i, int i2) {
        this.f18035b = bArr;
        this.f18036c = i;
        this.f18037d = i2;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f18038e[i3] = new int[4];
            int[] iArr = this.f18038e[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.f18041h[i3] = 256;
            this.f18040g[i3] = 0;
        }
    }

    /* renamed from: a */
    public byte[] m18675a() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[this.f18038e[i][3]] = i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = iArr[i3];
            int i5 = i2 + 1;
            bArr[i2] = (byte) this.f18038e[i4][0];
            int i6 = i5 + 1;
            bArr[i5] = (byte) this.f18038e[i4][1];
            i2 = i6 + 1;
            bArr[i6] = (byte) this.f18038e[i4][2];
        }
        return bArr;
    }

    /* renamed from: b */
    public void m18677b() {
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < 256) {
            int[] iArr = this.f18038e[i4];
            int i5 = iArr[1];
            int i6 = i4;
            for (int i7 = i4 + 1; i7 < 256; i7++) {
                int[] iArr2 = this.f18038e[i7];
                if (iArr2[1] < i5) {
                    i5 = iArr2[1];
                    i6 = i7;
                }
            }
            int[] iArr3 = this.f18038e[i6];
            if (i4 != i6) {
                int i8 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i8;
                int i9 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i9;
                int i10 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i10;
                int i11 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i11;
            }
            if (i5 != i3) {
                this.f18039f[i3] = (i2 + i4) >> 1;
                for (int i12 = i3 + 1; i12 < i5; i12++) {
                    this.f18039f[i12] = i4;
                }
                i = i4;
            } else {
                i = i2;
                i5 = i3;
            }
            i4++;
            i2 = i;
            i3 = i5;
        }
        this.f18039f[i3] = (i2 + 255) >> 1;
        for (int i13 = i3 + 1; i13 < 256; i13++) {
            this.f18039f[i13] = 255;
        }
    }

    /* renamed from: c */
    public void m18679c() {
        int i;
        if (this.f18036c < 1509) {
            this.f18037d = 1;
        }
        this.f18034a = ((this.f18037d - 1) / 3) + 30;
        byte[] bArr = this.f18035b;
        int i2 = this.f18036c;
        int i3 = this.f18036c / (this.f18037d * 3);
        int i4 = i3 / 100;
        for (int i5 = 0; i5 < 32; i5++) {
            this.f18042i[i5] = (((1024 - (i5 * i5)) * 256) / 1024) * 1024;
        }
        if (this.f18036c < 1509) {
            i = 3;
        } else if (this.f18036c % 499 != 0) {
            i = 1497;
        } else if (this.f18036c % 491 != 0) {
            i = 1473;
        } else if (this.f18036c % 487 != 0) {
            i = 1461;
        } else {
            i = 1509;
        }
        int i6 = 0;
        int i7 = 1024;
        int i8 = 32;
        int i9 = 2048;
        int i10 = 0;
        while (i10 < i3) {
            int i11 = (bArr[i6 + 0] & 255) << 4;
            int i12 = (bArr[i6 + 1] & 255) << 4;
            int i13 = (bArr[i6 + 2] & 255) << 4;
            int m18676b = m18676b(i11, i12, i13);
            m18678b(i7, m18676b, i11, i12, i13);
            if (i8 != 0) {
                m18674a(i8, m18676b, i11, i12, i13);
            }
            int i14 = i6 + i;
            int i15 = i14 >= i2 ? i14 - this.f18036c : i14;
            int i16 = i10 + 1;
            int i17 = i4 == 0 ? 1 : i4;
            if (i16 % i17 == 0) {
                int i18 = i7 - (i7 / this.f18034a);
                int i19 = i9 - (i9 / 30);
                int i20 = i19 >> 6;
                int i21 = i20 <= 1 ? 0 : i20;
                for (int i22 = 0; i22 < i21; i22++) {
                    this.f18042i[i22] = ((((i21 * i21) - (i22 * i22)) * 256) / (i21 * i21)) * i18;
                }
                i6 = i15;
                i4 = i17;
                i7 = i18;
                i8 = i21;
                i9 = i19;
                i10 = i16;
            } else {
                i6 = i15;
                i4 = i17;
                i10 = i16;
            }
        }
    }

    /* renamed from: a */
    public int m18673a(int i, int i2, int i3) {
        int i4;
        int i5 = 1000;
        int i6 = this.f18039f[i2];
        int i7 = -1;
        int i8 = i6 - 1;
        while (true) {
            int i9 = i6;
            if (i9 < 256 || i8 >= 0) {
                if (i9 < 256) {
                    int[] iArr = this.f18038e[i9];
                    int i10 = iArr[1] - i2;
                    if (i10 >= i5) {
                        i4 = i7;
                        i6 = 256;
                    } else {
                        i6 = i9 + 1;
                        if (i10 < 0) {
                            i10 = -i10;
                        }
                        int i11 = iArr[0] - i;
                        if (i11 < 0) {
                            i11 = -i11;
                        }
                        int i12 = i11 + i10;
                        if (i12 < i5) {
                            int i13 = iArr[2] - i3;
                            if (i13 < 0) {
                                i13 = -i13;
                            }
                            int i14 = i12 + i13;
                            if (i14 < i5) {
                                i4 = iArr[3];
                                i5 = i14;
                            }
                        }
                        i4 = i7;
                    }
                } else {
                    i4 = i7;
                    i6 = i9;
                }
                if (i8 >= 0) {
                    int[] iArr2 = this.f18038e[i8];
                    int i15 = i2 - iArr2[1];
                    if (i15 >= i5) {
                        i7 = i4;
                        i8 = -1;
                    } else {
                        i8--;
                        if (i15 < 0) {
                            i15 = -i15;
                        }
                        int i16 = iArr2[0] - i;
                        if (i16 < 0) {
                            i16 = -i16;
                        }
                        int i17 = i16 + i15;
                        if (i17 < i5) {
                            int i18 = iArr2[2] - i3;
                            if (i18 < 0) {
                                i18 = -i18;
                            }
                            int i19 = i18 + i17;
                            if (i19 < i5) {
                                i7 = iArr2[3];
                                i5 = i19;
                            }
                        }
                    }
                }
                i7 = i4;
            } else {
                return i7;
            }
        }
    }

    /* renamed from: d */
    public byte[] m18680d() {
        m18679c();
        m18681e();
        m18677b();
        return m18675a();
    }

    /* renamed from: e */
    public void m18681e() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.f18038e[i];
            iArr[0] = iArr[0] >> 4;
            int[] iArr2 = this.f18038e[i];
            iArr2[1] = iArr2[1] >> 4;
            int[] iArr3 = this.f18038e[i];
            iArr3[2] = iArr3[2] >> 4;
            this.f18038e[i][3] = i;
        }
    }

    /* renamed from: a */
    protected void m18674a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i2 - i;
        int i8 = i7 < -1 ? -1 : i7;
        int i9 = i2 + i;
        if (i9 > 256) {
            i9 = 256;
        }
        int i10 = i2 + 1;
        int i11 = 1;
        int i12 = i2 - 1;
        while (true) {
            if (i10 >= i9 && i12 <= i8) {
                return;
            }
            int i13 = i11 + 1;
            int i14 = this.f18042i[i11];
            if (i10 < i9) {
                i6 = i10 + 1;
                int[] iArr = this.f18038e[i10];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i3) * i14) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i4) * i14) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i5) * i14) / 262144);
                } catch (Exception e2) {
                }
            } else {
                i6 = i10;
            }
            if (i12 > i8) {
                int i15 = i12 - 1;
                int[] iArr2 = this.f18038e[i12];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i14) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i14) / 262144);
                    iArr2[2] = iArr2[2] - ((i14 * (iArr2[2] - i5)) / 262144);
                    i11 = i13;
                    i12 = i15;
                    i10 = i6;
                } catch (Exception e3) {
                    i11 = i13;
                    i12 = i15;
                    i10 = i6;
                }
            } else {
                i11 = i13;
                i10 = i6;
            }
        }
    }

    /* renamed from: b */
    protected void m18678b(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f18038e[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    /* renamed from: b */
    protected int m18676b(int i, int i2, int i3) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = -1;
        int i9 = 0;
        while (i9 < 256) {
            int[] iArr = this.f18038e[i9];
            int i10 = iArr[0] - i;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = iArr[1] - i2;
            if (i11 < 0) {
                i11 = -i11;
            }
            int i12 = i11 + i10;
            int i13 = iArr[2] - i3;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i12 + i13;
            if (i14 < i6) {
                i4 = i14;
                i8 = i9;
            } else {
                i4 = i6;
            }
            int i15 = i14 - (this.f18040g[i9] >> 12);
            if (i15 < i5) {
                i7 = i9;
            } else {
                i15 = i5;
            }
            int i16 = this.f18041h[i9] >> 10;
            int[] iArr2 = this.f18041h;
            iArr2[i9] = iArr2[i9] - i16;
            int[] iArr3 = this.f18040g;
            iArr3[i9] = (i16 << 10) + iArr3[i9];
            i9++;
            i5 = i15;
            i6 = i4;
        }
        int[] iArr4 = this.f18041h;
        iArr4[i8] = iArr4[i8] + 64;
        int[] iArr5 = this.f18040g;
        iArr5[i8] = iArr5[i8] - 65536;
        return i7;
    }
}
