package ru.maximoff.apktool.util;

import android.graphics.Bitmap;
import java.lang.reflect.Array;
import java.p209io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: QrCode.java */
/* renamed from: ru.maximoff.apktool.util.aw */
/* loaded from: classes.dex */
public final class C3091aw {
    /* renamed from: a */
    public static Bitmap m18735a(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("text == null");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        try {
            return new b(str.getBytes("UTF-8")).m18757a(i);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* compiled from: QrCode.java */
    /* renamed from: ru.maximoff.apktool.util.aw$b */
    private static final class b {

        /* renamed from: a */
        private static final int[] f18127a = {19, 34, 55, 80};

        /* renamed from: b */
        private static final int[] f18128b = {26, 44, 70, 100};

        /* renamed from: c */
        private final byte[] f18129c;

        /* renamed from: d */
        private int f18130d;

        /* renamed from: e */
        private int f18131e;

        /* renamed from: f */
        private boolean[][] f18132f;

        /* renamed from: g */
        private boolean[][] f18133g;

        b(byte[] bArr) {
            this.f18129c = bArr;
            m18740a();
            m18745b();
        }

        /* renamed from: a */
        private void m18740a() {
            for (int i = 1; i <= 4; i++) {
                if ((this.f18129c.length * 8) + 12 <= f18127a[i - 1] * 8) {
                    this.f18130d = i;
                    return;
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("Text is too long for QR Version 4. ").append("Maximum UTF-8 length is 78 bytes.").toString());
        }

        /* renamed from: b */
        private void m18745b() {
            this.f18131e = (this.f18130d * 4) + 17;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            boolean[][] zArr = (boolean[][]) null;
            while (i2 < 8) {
                this.f18132f = (boolean[][]) Array.newInstance(Boolean.TYPE, this.f18131e, this.f18131e);
                this.f18133g = (boolean[][]) Array.newInstance(Boolean.TYPE, this.f18131e, this.f18131e);
                m18750c();
                m18747b(m18755e(), i2);
                m18751c(i2);
                int m18756f = m18756f();
                if (m18756f < i) {
                    zArr = m18744a(this.f18132f);
                } else {
                    m18756f = i;
                }
                i2++;
                i = m18756f;
            }
            this.f18132f = zArr;
        }

        /* renamed from: c */
        private void m18750c() {
            m18741a(0, 0);
            m18741a(this.f18131e - 7, 0);
            m18741a(0, this.f18131e - 7);
            for (int i = 8; i < this.f18131e - 8; i++) {
                if (!this.f18133g[6][i]) {
                    this.f18133g[6][i] = true;
                    this.f18132f[6][i] = (i & 1) == 0;
                }
                if (!this.f18133g[i][6]) {
                    this.f18133g[i][6] = true;
                    this.f18132f[i][6] = (i & 1) == 0;
                }
            }
            if (this.f18130d >= 2) {
                int[] m18753d = m18753d();
                for (int i2 : m18753d) {
                    for (int i3 : m18753d) {
                        if ((i2 != 6 || i3 != 6) && ((i2 != 6 || i3 != this.f18131e - 7) && (i2 != this.f18131e - 7 || i3 != 6))) {
                            m18746b(i2, i3);
                        }
                    }
                }
            }
            this.f18133g[this.f18131e - 8][8] = true;
            this.f18132f[this.f18131e - 8][8] = true;
            for (int i4 = 0; i4 < 15; i4++) {
                if (i4 < 6) {
                    this.f18133g[i4][8] = true;
                } else if (i4 < 8) {
                    this.f18133g[i4 + 1][8] = true;
                } else {
                    this.f18133g[(this.f18131e - 15) + i4][8] = true;
                }
                if (i4 < 8) {
                    this.f18133g[8][(this.f18131e - i4) - 1] = true;
                } else if (i4 < 9) {
                    this.f18133g[8][15 - i4] = true;
                } else {
                    this.f18133g[8][(15 - i4) - 1] = true;
                }
            }
        }

        /* renamed from: a */
        private void m18741a(int i, int i2) {
            for (int i3 = -1; i3 <= 7; i3++) {
                for (int i4 = -1; i4 <= 7; i4++) {
                    int i5 = i + i4;
                    int i6 = i2 + i3;
                    if (i5 >= 0 && i6 >= 0 && i5 < this.f18131e && i6 < this.f18131e) {
                        this.f18133g[i6][i5] = true;
                        this.f18132f[i6][i5] = false;
                    }
                }
            }
            int i7 = 0;
            while (i7 < 7) {
                int i8 = 0;
                while (i8 < 7) {
                    this.f18132f[i2 + i7][i + i8] = i8 == 0 || i8 == 6 || i7 == 0 || i7 == 6 || (i8 >= 2 && i8 <= 4 && i7 >= 2 && i7 <= 4);
                    i8++;
                }
                i7++;
            }
        }

        /* renamed from: b */
        private void m18746b(int i, int i2) {
            for (int i3 = -2; i3 <= 2; i3++) {
                for (int i4 = -2; i4 <= 2; i4++) {
                    this.f18132f[i2 + i3][i + i4] = Math.max(Math.abs(i4), Math.abs(i3)) != 1;
                    this.f18133g[i2 + i3][i + i4] = true;
                }
            }
        }

        /* renamed from: d */
        private int[] m18753d() {
            switch (this.f18130d) {
                case 2:
                    return new int[]{6, 18};
                case 3:
                    return new int[]{6, 22};
                case 4:
                    return new int[]{6, 26};
                default:
                    return new int[0];
            }
        }

        /* renamed from: e */
        private byte[] m18755e() {
            int i = f18127a[this.f18130d - 1];
            byte[] bArr = new byte[i];
            a aVar = new a();
            aVar.m18738a(4, 4);
            aVar.m18738a(this.f18129c.length, 8);
            for (int i2 = 0; i2 < this.f18129c.length; i2++) {
                aVar.m18738a(this.f18129c[i2] & 255, 8);
            }
            int i3 = i * 8;
            aVar.m18738a(0, Math.min(4, i3 - aVar.m18737a()));
            while ((aVar.m18737a() & 7) != 0) {
                aVar.m18738a(0, 1);
            }
            boolean z = false;
            while (aVar.m18737a() < i3) {
                aVar.m18738a(z ? 17 : 236, 8);
                z = !z;
            }
            System.arraycopy(aVar.m18739b(), 0, bArr, 0, bArr.length);
            byte[] m18743a = m18743a(bArr, f18128b[this.f18130d - 1] - i);
            byte[] bArr2 = new byte[bArr.length + m18743a.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(m18743a, 0, bArr2, bArr.length, m18743a.length);
            return bArr2;
        }

        /* renamed from: a */
        private byte[] m18743a(byte[] bArr, int i) {
            int[] m18748b = m18748b(i);
            int[] iArr = new int[i];
            for (byte b2 : bArr) {
                int i2 = iArr[0] ^ (b2 & 255);
                System.arraycopy(iArr, 1, iArr, 0, i - 1);
                iArr[i - 1] = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    iArr[i3] = iArr[i3] ^ m18749c(m18748b[i3 + 1], i2);
                }
            }
            byte[] bArr2 = new byte[i];
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[i4] = (byte) iArr[i4];
            }
            return bArr2;
        }

        /* renamed from: b */
        private int[] m18748b(int i) {
            int[] iArr = {1};
            int i2 = 0;
            int i3 = 1;
            while (i2 < i) {
                int[] iArr2 = new int[iArr.length + 1];
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    iArr2[i4] = iArr2[i4] ^ iArr[i4];
                    int i5 = i4 + 1;
                    iArr2[i5] = iArr2[i5] ^ m18749c(iArr[i4], i3);
                }
                i3 = m18749c(i3, 2);
                i2++;
                iArr = iArr2;
            }
            return iArr;
        }

        /* renamed from: c */
        private int m18749c(int i, int i2) {
            int i3 = 0;
            while (i2 != 0) {
                if ((i2 & 1) != 0) {
                    i3 ^= i;
                }
                int i4 = i << 1;
                if ((i4 & 256) != 0) {
                    i4 ^= 285;
                }
                i2 >>>= 1;
                i = i4;
            }
            return i3;
        }

        /* renamed from: b */
        private void m18747b(byte[] bArr, int i) {
            boolean z;
            int i2 = this.f18131e - 1;
            int i3 = -1;
            int i4 = 0;
            while (i2 > 0) {
                if (i2 == 6) {
                    i2--;
                }
                for (int i5 = 0; i5 < this.f18131e; i5++) {
                    int i6 = i3 == 1 ? i5 : (this.f18131e - 1) - i5;
                    for (int i7 = 0; i7 < 2; i7++) {
                        int i8 = i2 - i7;
                        if (!this.f18133g[i6][i8]) {
                            if (i4 < bArr.length * 8) {
                                z = ((bArr[i4 >>> 3] >>> (7 - (i4 & 7))) & 1) != 0;
                                i4++;
                            } else {
                                z = false;
                            }
                            if (m18742a(i, i8, i6)) {
                                z = !z;
                            }
                            this.f18132f[i6][i8] = z;
                        }
                    }
                }
                i2 -= 2;
                i3 = -i3;
            }
        }

        /* renamed from: a */
        private boolean m18742a(int i, int i2, int i3) {
            switch (i) {
                case 0:
                    if (((i2 + i3) & 1) == 0) {
                        break;
                    }
                    break;
                case 1:
                    if ((i3 & 1) == 0) {
                        break;
                    }
                    break;
                case 2:
                    if (i2 % 3 == 0) {
                        break;
                    }
                    break;
                case 3:
                    if ((i2 + i3) % 3 == 0) {
                        break;
                    }
                    break;
                case 4:
                    if (((i3 / 2) + (i2 / 3)) % 2 == 0) {
                        break;
                    }
                    break;
                case 5:
                    if (((i2 * i3) % 2) + ((i2 * i3) % 3) == 0) {
                        break;
                    }
                    break;
                case 6:
                    if ((((i2 * i3) % 2) + ((i2 * i3) % 3)) % 2 == 0) {
                        break;
                    }
                    break;
                case 7:
                    if ((((i2 * i3) % 3) + ((i2 + i3) % 2)) % 2 == 0) {
                        break;
                    }
                    break;
            }
            return false;
        }

        /* renamed from: c */
        private void m18751c(int i) {
            int m18752d = m18752d(i | 8);
            for (int i2 = 0; i2 < 15; i2++) {
                boolean z = ((m18752d >>> i2) & 1) != 0;
                if (i2 < 6) {
                    this.f18132f[i2][8] = z;
                } else if (i2 < 8) {
                    this.f18132f[i2 + 1][8] = z;
                } else {
                    this.f18132f[(this.f18131e - 15) + i2][8] = z;
                }
            }
            for (int i3 = 0; i3 < 15; i3++) {
                boolean z2 = ((m18752d >>> i3) & 1) != 0;
                if (i3 < 8) {
                    this.f18132f[8][(this.f18131e - i3) - 1] = z2;
                } else if (i3 < 9) {
                    this.f18132f[8][15 - i3] = z2;
                } else {
                    this.f18132f[8][(15 - i3) - 1] = z2;
                }
            }
            this.f18132f[this.f18131e - 8][8] = true;
        }

        /* renamed from: d */
        private int m18752d(int i) {
            int i2 = i << 10;
            while (m18754e(i2) >= m18754e(1335)) {
                i2 ^= 1335 << (m18754e(i2) - m18754e(1335));
            }
            return (i2 | (i << 10)) ^ 21522;
        }

        /* renamed from: e */
        private int m18754e(int i) {
            int i2 = 0;
            while (i != 0) {
                i2++;
                i >>>= 1;
            }
            return i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int m18756f() {
            int i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f18131e; i3++) {
                int i4 = 1;
                boolean z = this.f18132f[i3][0];
                for (int i5 = 1; i5 < this.f18131e; i5++) {
                    boolean z2 = this.f18132f[i3][i5];
                    if (z2 == z) {
                        i4++;
                        if (i4 == 5) {
                            i2 += 3;
                        } else if (i4 > 5) {
                            i2++;
                        }
                    } else {
                        i4 = 1;
                        z = z2;
                    }
                }
            }
            for (int i6 = 0; i6 < this.f18131e; i6++) {
                int i7 = 1;
                boolean z3 = this.f18132f[0][i6];
                for (int i8 = 1; i8 < this.f18131e; i8++) {
                    boolean z4 = this.f18132f[i8][i6];
                    if (z4 == z3) {
                        i7++;
                        if (i7 == 5) {
                            i2 += 3;
                        } else if (i7 > 5) {
                            i2++;
                        }
                    } else {
                        i7 = 1;
                        z3 = z4;
                    }
                }
            }
            for (int i9 = 0; i9 < this.f18131e - 1; i9++) {
                for (0; i < this.f18131e - 1; i + 1) {
                    boolean z5 = this.f18132f[i9][i];
                    if (this.f18132f[i9][i + 1]) {
                        i = z5 ? 0 : i + 1;
                        if (this.f18132f[i9 + 1][i]) {
                        }
                    } else {
                        if (z5) {
                        }
                        if (this.f18132f[i9 + 1][i]) {
                            if (z5) {
                            }
                            if (this.f18132f[i9 + 1][i + 1]) {
                                if (z5) {
                                }
                                i2 += 3;
                            } else {
                                if (!z5) {
                                }
                                i2 += 3;
                            }
                        } else {
                            if (!z5) {
                            }
                            if (this.f18132f[i9 + 1][i + 1]) {
                            }
                        }
                    }
                }
            }
            for (int i10 = 0; i10 < this.f18131e; i10++) {
                for (int i11 = 0; i11 < this.f18131e - 6; i11++) {
                    if (this.f18132f[i10][i11] && !this.f18132f[i10][i11 + 1] && this.f18132f[i10][i11 + 2] && this.f18132f[i10][i11 + 3] && this.f18132f[i10][i11 + 4] && !this.f18132f[i10][i11 + 5] && this.f18132f[i10][i11 + 6]) {
                        i2 += 40;
                    }
                }
            }
            for (int i12 = 0; i12 < this.f18131e; i12++) {
                for (int i13 = 0; i13 < this.f18131e - 6; i13++) {
                    if (this.f18132f[i13][i12] && !this.f18132f[i13 + 1][i12] && this.f18132f[i13 + 2][i12] && this.f18132f[i13 + 3][i12] && this.f18132f[i13 + 4][i12] && !this.f18132f[i13 + 5][i12] && this.f18132f[i13 + 6][i12]) {
                        i2 += 40;
                    }
                }
            }
            int i14 = 0;
            for (int i15 = 0; i15 < this.f18131e; i15++) {
                for (int i16 = 0; i16 < this.f18131e; i16++) {
                    if (this.f18132f[i15][i16]) {
                        i14++;
                    }
                }
            }
            return ((Math.abs(((i14 * 100) / (this.f18131e * this.f18131e)) - 50) / 5) * 10) + i2;
        }

        /* renamed from: a */
        private boolean[][] m18744a(boolean[][] zArr) {
            boolean[][] zArr2 = new boolean[zArr.length][];
            for (int i = 0; i < zArr.length; i++) {
                zArr2[i] = Arrays.copyOf(zArr[i], zArr[i].length);
            }
            return zArr2;
        }

        /* renamed from: a */
        Bitmap m18757a(int i) {
            int i2 = this.f18131e + 8;
            Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            int[] iArr = new int[i * i];
            Arrays.fill(iArr, -1);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = ((i3 * i2) / i) - 4;
                if (i4 >= 0 && i4 < this.f18131e) {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = ((i5 * i2) / i) - 4;
                        if (i6 >= 0 && i6 < this.f18131e && this.f18132f[i4][i6]) {
                            iArr[(i3 * i) + i5] = -16777216;
                        }
                    }
                }
            }
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
            return createBitmap;
        }
    }

    /* compiled from: QrCode.java */
    /* renamed from: ru.maximoff.apktool.util.aw$a */
    private static final class a {

        /* renamed from: a */
        private byte[] f18125a = new byte[32];

        /* renamed from: b */
        private int f18126b;

        /* renamed from: a */
        void m18738a(int i, int i2) {
            if (i2 < 0 || i2 > 31 || (i >>> i2) != 0) {
                throw new IllegalArgumentException();
            }
            m18736a(this.f18126b + i2);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                int i4 = (i >>> i3) & 1;
                int i5 = this.f18126b >>> 3;
                int i6 = 7 - (this.f18126b & 7);
                if (i4 != 0) {
                    byte[] bArr = this.f18125a;
                    bArr[i5] = (byte) (((byte) (1 << i6)) | bArr[i5]);
                }
                this.f18126b++;
            }
        }

        /* renamed from: a */
        int m18737a() {
            return this.f18126b;
        }

        /* renamed from: b */
        byte[] m18739b() {
            return Arrays.copyOf(this.f18125a, (this.f18126b + 7) / 8);
        }

        /* renamed from: a */
        private void m18736a(int i) {
            int i2 = (i + 7) / 8;
            if (i2 > this.f18125a.length) {
                this.f18125a = Arrays.copyOf(this.f18125a, Math.max(i2, this.f18125a.length * 2));
            }
        }
    }
}
