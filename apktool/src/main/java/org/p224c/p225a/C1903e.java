package org.p224c.p225a;

import android.bluetooth.BluetoothClass;
import android.view.InputDevice;

/* compiled from: Decode.java */
/* renamed from: org.c.a.e */
/* loaded from: classes.dex */
final class C1903e {

    /* renamed from: a */
    private static final int[] f11188a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: b */
    private static final int[] f11189b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* renamed from: c */
    private static final int[] f11190c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* renamed from: d */
    private static final int[] f11191d = {131072, InputDevice.SOURCE_MOUSE_RELATIVE, 131075, 196610, 131072, InputDevice.SOURCE_MOUSE_RELATIVE, 131075, 262145, 131072, InputDevice.SOURCE_MOUSE_RELATIVE, 131075, 196610, 131072, InputDevice.SOURCE_MOUSE_RELATIVE, 131075, 262149};

    /* renamed from: a */
    private static int m14042a(C1899a c1899a) {
        if (C1899a.m14029a(c1899a, 1) != 0) {
            int m14029a = C1899a.m14029a(c1899a, 3);
            if (m14029a == 0) {
                return 1;
            }
            return (1 << m14029a) + C1899a.m14029a(c1899a, m14029a);
        }
        return 0;
    }

    /* renamed from: a */
    private static void m14045a(C1899a c1899a, C1909k c1909k) {
        c1909k.f11241h = C1899a.m14029a(c1899a, 1) == 1;
        c1909k.f11240g = 0;
        c1909k.f11242i = false;
        c1909k.f11243j = false;
        if (!c1909k.f11241h || C1899a.m14029a(c1899a, 1) == 0) {
            int m14029a = C1899a.m14029a(c1899a, 2) + 4;
            if (m14029a == 7) {
                c1909k.f11243j = true;
                if (C1899a.m14029a(c1899a, 1) != 0) {
                    throw new C1901c("Corrupted reserved bit");
                }
                int m14029a2 = C1899a.m14029a(c1899a, 2);
                if (m14029a2 != 0) {
                    for (int i = 0; i < m14029a2; i++) {
                        int m14029a3 = C1899a.m14029a(c1899a, 8);
                        if (m14029a3 == 0 && i + 1 == m14029a2 && m14029a2 > 1) {
                            throw new C1901c("Exuberant nibble");
                        }
                        c1909k.f11240g = (m14029a3 << (i * 8)) | c1909k.f11240g;
                    }
                } else {
                    return;
                }
            } else {
                for (int i2 = 0; i2 < m14029a; i2++) {
                    int m14029a4 = C1899a.m14029a(c1899a, 4);
                    if (m14029a4 == 0 && i2 + 1 == m14029a && m14029a > 4) {
                        throw new C1901c("Exuberant nibble");
                    }
                    c1909k.f11240g = (m14029a4 << (i2 * 4)) | c1909k.f11240g;
                }
            }
            c1909k.f11240g++;
            if (!c1909k.f11241h) {
                c1909k.f11242i = C1899a.m14029a(c1899a, 1) == 1;
            }
        }
    }

    /* renamed from: a */
    private static int m14043a(int[] iArr, int i, C1899a c1899a) {
        int i2 = (int) (c1899a.f11173a >>> c1899a.f11174b);
        int i3 = i + (i2 & 255);
        int i4 = iArr[i3] >> 16;
        int i5 = iArr[i3] & 65535;
        if (i4 <= 8) {
            c1899a.f11174b += i4;
            return i5;
        }
        int i6 = i5 + i3 + ((i2 & ((1 << i4) - 1)) >>> 8);
        c1899a.f11174b += (iArr[i6] >> 16) + 8;
        return iArr[i6] & 65535;
    }

    /* renamed from: b */
    private static int m14052b(int[] iArr, int i, C1899a c1899a) {
        C1899a.m14034b(c1899a);
        int m14043a = m14043a(iArr, i, c1899a);
        return C1908j.f11200a[m14043a] + C1899a.m14029a(c1899a, C1908j.f11201b[m14043a]);
    }

    /* renamed from: a */
    private static int m14041a(int i, int[] iArr, int i2) {
        return i < 16 ? iArr[(f11189b[i] + i2) & 3] + f11190c[i] : (i - 16) + 1;
    }

    /* renamed from: a */
    private static void m14050a(int[] iArr, int i) {
        int i2 = iArr[i];
        while (i > 0) {
            iArr[i] = iArr[i - 1];
            i--;
        }
        iArr[0] = i2;
    }

    /* renamed from: a */
    private static void m14049a(byte[] bArr, int i) {
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = bArr[i3] & 255;
            bArr[i3] = (byte) iArr[i4];
            if (i4 != 0) {
                m14050a(iArr, i4);
            }
        }
    }

    /* renamed from: a */
    private static void m14051a(int[] iArr, int i, int[] iArr2, C1899a c1899a) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 8;
        int i8 = 0;
        int i9 = 0;
        int i10 = 32768;
        int[] iArr3 = new int[32];
        C1905g.m14068a(iArr3, 0, 5, iArr, 18);
        while (i6 < i && i10 > 0) {
            C1899a.m14030a(c1899a);
            C1899a.m14034b(c1899a);
            int i11 = ((int) (c1899a.f11173a >>> c1899a.f11174b)) & 31;
            c1899a.f11174b += iArr3[i11] >> 16;
            int i12 = iArr3[i11] & 65535;
            if (i12 < 16) {
                i8 = 0;
                i3 = i6 + 1;
                iArr2[i6] = i12;
                if (i12 != 0) {
                    i4 = i10 - (32768 >> i12);
                    i5 = i9;
                }
                i4 = i10;
                i5 = i9;
                i12 = i7;
            } else {
                int i13 = i12 - 14;
                int i14 = i12 == 16 ? i7 : 0;
                if (i9 != i14) {
                    i2 = 0;
                    i9 = i14;
                } else {
                    i2 = i8;
                }
                i8 = C1899a.m14029a(c1899a, i13) + 3 + (i2 > 0 ? (i2 - 2) << i13 : i2);
                int i15 = i8 - i2;
                if (i6 + i15 > i) {
                    throw new C1901c("symbol + repeatDelta > numSymbols");
                }
                int i16 = 0;
                i3 = i6;
                while (i16 < i15) {
                    iArr2[i3] = i9;
                    i16++;
                    i3++;
                }
                if (i9 != 0) {
                    i4 = i10 - (i15 << (15 - i9));
                    i5 = i9;
                    i12 = i7;
                }
                i4 = i10;
                i5 = i9;
                i12 = i7;
            }
            i10 = i4;
            i9 = i5;
            i7 = i12;
            i6 = i3;
        }
        if (i10 != 0) {
            throw new C1901c("Unused space");
        }
        C1911m.m14079a(iArr2, i6, i - i6);
    }

    /* renamed from: a */
    static void m14044a(int i, int[] iArr, int i2, C1899a c1899a) {
        boolean z;
        boolean z2 = true;
        C1899a.m14030a(c1899a);
        int[] iArr2 = new int[i];
        int m14029a = C1899a.m14029a(c1899a, 2);
        if (m14029a == 1) {
            int[] iArr3 = new int[4];
            int m14029a2 = C1899a.m14029a(c1899a, 2) + 1;
            int i3 = 0;
            int i4 = i - 1;
            while (i4 != 0) {
                i4 >>= 1;
                i3++;
            }
            for (int i5 = 0; i5 < m14029a2; i5++) {
                iArr3[i5] = C1899a.m14029a(c1899a, i3) % i;
                iArr2[iArr3[i5]] = 2;
            }
            iArr2[iArr3[0]] = 1;
            switch (m14029a2) {
                case 1:
                    break;
                case 2:
                    z = iArr3[0] != iArr3[1];
                    iArr2[iArr3[1]] = 1;
                    z2 = z;
                    break;
                case 3:
                    if (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[1] == iArr3[2]) {
                        z2 = false;
                        break;
                    }
                    break;
                default:
                    boolean z3 = (iArr3[0] == iArr3[1] || iArr3[0] == iArr3[2] || iArr3[0] == iArr3[3] || iArr3[1] == iArr3[2] || iArr3[1] == iArr3[3] || iArr3[2] == iArr3[3]) ? false : true;
                    if (C1899a.m14029a(c1899a, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                        z2 = z3;
                        break;
                    } else {
                        iArr2[iArr3[0]] = 2;
                        z2 = z3;
                        break;
                    }
                    break;
            }
        } else {
            int[] iArr4 = new int[18];
            int i6 = 32;
            int i7 = 0;
            while (m14029a < 18 && i6 > 0) {
                int i8 = f11188a[m14029a];
                C1899a.m14034b(c1899a);
                int i9 = ((int) (c1899a.f11173a >>> c1899a.f11174b)) & 15;
                c1899a.f11174b += f11191d[i9] >> 16;
                int i10 = f11191d[i9] & 65535;
                iArr4[i8] = i10;
                if (i10 != 0) {
                    i6 -= 32 >> i10;
                    i7++;
                }
                m14029a++;
            }
            z = i7 == 1 || i6 == 0;
            m14051a(iArr4, i, iArr2, c1899a);
            z2 = z;
        }
        if (!z2) {
            throw new C1901c("Can't readHuffmanCode");
        }
        C1905g.m14068a(iArr, i2, 8, iArr2, i);
    }

    /* renamed from: a */
    private static int m14040a(int i, byte[] bArr, C1899a c1899a) {
        C1899a.m14030a(c1899a);
        int m14042a = m14042a(c1899a) + 1;
        if (m14042a == 1) {
            C1911m.m14078a(bArr, 0, i);
            return m14042a;
        }
        int m14029a = C1899a.m14029a(c1899a, 1) == 1 ? C1899a.m14029a(c1899a, 4) + 1 : 0;
        int[] iArr = new int[BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR];
        m14044a(m14042a + m14029a, iArr, 0, c1899a);
        int i2 = 0;
        while (i2 < i) {
            C1899a.m14030a(c1899a);
            C1899a.m14034b(c1899a);
            int m14043a = m14043a(iArr, 0, c1899a);
            if (m14043a == 0) {
                bArr[i2] = 0;
                i2++;
            } else if (m14043a <= m14029a) {
                for (int m14029a2 = C1899a.m14029a(c1899a, m14043a) + (1 << m14043a); m14029a2 != 0; m14029a2--) {
                    if (i2 >= i) {
                        throw new C1901c("Corrupted context map");
                    }
                    bArr[i2] = 0;
                    i2++;
                }
            } else {
                bArr[i2] = (byte) (m14043a - m14029a);
                i2++;
            }
        }
        if (C1899a.m14029a(c1899a, 1) == 1) {
            m14049a(bArr, i);
        }
        return m14042a;
    }

    /* renamed from: a */
    private static void m14047a(C1909k c1909k, int i) {
        int i2;
        C1899a c1899a = c1909k.f11236c;
        int[] iArr = c1909k.f11249p;
        int i3 = i * 2;
        C1899a.m14034b(c1899a);
        int m14043a = m14043a(c1909k.f11238e, i * BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, c1899a);
        c1909k.f11247n[i] = m14052b(c1909k.f11239f, i * BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, c1899a);
        if (m14043a == 1) {
            i2 = iArr[i3 + 1] + 1;
        } else if (m14043a == 0) {
            i2 = iArr[i3];
        } else {
            i2 = m14043a - 2;
        }
        if (i2 >= c1909k.f11248o[i]) {
            i2 -= c1909k.f11248o[i];
        }
        iArr[i3] = iArr[i3 + 1];
        iArr[i3 + 1] = i2;
    }

    /* renamed from: b */
    private static void m14053b(C1909k c1909k) {
        m14047a(c1909k, 0);
        int i = c1909k.f11249p[1];
        c1909k.f11209B = i << 6;
        c1909k.f11255v = c1909k.f11208A[c1909k.f11209B] & 255;
        c1909k.f11256w = c1909k.f11244k.f11196b[c1909k.f11255v];
        byte b2 = c1909k.f11259z[i];
        c1909k.f11211D = C1902d.f11187b[b2];
        c1909k.f11212E = C1902d.f11187b[b2 + 1];
    }

    /* renamed from: c */
    private static void m14054c(C1909k c1909k) {
        m14047a(c1909k, 1);
        c1909k.f11213F = c1909k.f11245l.f11196b[c1909k.f11249p[3]];
    }

    /* renamed from: d */
    private static void m14055d(C1909k c1909k) {
        m14047a(c1909k, 2);
        c1909k.f11210C = c1909k.f11249p[5] << 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r8.f11223P >= 16384) goto L13;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m14056e(C1909k c1909k) {
        int i;
        int i2 = 16384;
        int i3 = c1909k.f11223P;
        if (i3 > c1909k.f11225R) {
            while ((i3 >> 1) > ((int) c1909k.f11225R) + c1909k.f11226S.length) {
                i3 >>= 1;
            }
            if (!c1909k.f11241h) {
                if (i3 < 16384) {
                }
            }
        }
        i2 = i3;
        if (i2 > c1909k.f11224Q) {
            byte[] bArr = new byte[i2 + 37];
            if (c1909k.f11237d != null) {
                System.arraycopy(c1909k.f11237d, 0, bArr, 0, c1909k.f11224Q);
            } else if (c1909k.f11226S.length != 0) {
                int length = c1909k.f11226S.length;
                if (length > c1909k.f11222O) {
                    i = length - c1909k.f11222O;
                    length = c1909k.f11222O;
                } else {
                    i = 0;
                }
                System.arraycopy(c1909k.f11226S, i, bArr, 0, length);
                c1909k.f11251r = length;
                c1909k.f11227T = length;
            }
            c1909k.f11237d = bArr;
            c1909k.f11224Q = i2;
        }
    }

    /* renamed from: f */
    private static void m14057f(C1909k c1909k) {
        C1899a c1899a = c1909k.f11236c;
        if (c1909k.f11241h) {
            c1909k.f11235b = 10;
            c1909k.f11232Y = c1909k.f11251r;
            c1909k.f11231X = 0;
            c1909k.f11234a = 12;
            return;
        }
        c1909k.f11244k.f11195a = null;
        c1909k.f11244k.f11196b = null;
        c1909k.f11245l.f11195a = null;
        c1909k.f11245l.f11196b = null;
        c1909k.f11246m.f11195a = null;
        c1909k.f11246m.f11196b = null;
        C1899a.m14030a(c1899a);
        m14045a(c1899a, c1909k);
        if (c1909k.f11240g != 0 || c1909k.f11243j) {
            if (c1909k.f11242i || c1909k.f11243j) {
                C1899a.m14037e(c1899a);
                c1909k.f11234a = c1909k.f11243j ? 4 : 5;
            } else {
                c1909k.f11234a = 2;
            }
            if (!c1909k.f11243j) {
                c1909k.f11225R += c1909k.f11240g;
                if (c1909k.f11224Q < c1909k.f11223P) {
                    m14056e(c1909k);
                }
            }
        }
    }

    /* renamed from: g */
    private static void m14058g(C1909k c1909k) {
        C1899a c1899a = c1909k.f11236c;
        for (int i = 0; i < 3; i++) {
            c1909k.f11248o[i] = m14042a(c1899a) + 1;
            c1909k.f11247n[i] = 268435456;
            if (c1909k.f11248o[i] > 1) {
                m14044a(c1909k.f11248o[i] + 2, c1909k.f11238e, i * BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, c1899a);
                m14044a(26, c1909k.f11239f, i * BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, c1899a);
                c1909k.f11247n[i] = m14052b(c1909k.f11239f, i * BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, c1899a);
            }
        }
        C1899a.m14030a(c1899a);
        c1909k.f11218K = C1899a.m14029a(c1899a, 2);
        c1909k.f11216I = (C1899a.m14029a(c1899a, 4) << c1909k.f11218K) + 16;
        c1909k.f11217J = (1 << c1909k.f11218K) - 1;
        int i2 = (48 << c1909k.f11218K) + c1909k.f11216I;
        c1909k.f11259z = new byte[c1909k.f11248o[0]];
        int i3 = 0;
        while (i3 < c1909k.f11248o[0]) {
            int min = Math.min(i3 + 96, c1909k.f11248o[0]);
            while (i3 < min) {
                c1909k.f11259z[i3] = (byte) (C1899a.m14029a(c1899a, 2) << 1);
                i3++;
            }
            C1899a.m14030a(c1899a);
        }
        c1909k.f11208A = new byte[c1909k.f11248o[0] << 6];
        int m14040a = m14040a(c1909k.f11248o[0] << 6, c1909k.f11208A, c1899a);
        c1909k.f11254u = true;
        int i4 = 0;
        while (true) {
            if (i4 >= (c1909k.f11248o[0] << 6)) {
                break;
            }
            if (c1909k.f11208A[i4] == (i4 >> 6)) {
                i4++;
            } else {
                c1909k.f11254u = false;
                break;
            }
        }
        c1909k.f11215H = new byte[c1909k.f11248o[2] << 2];
        int m14040a2 = m14040a(c1909k.f11248o[2] << 2, c1909k.f11215H, c1899a);
        C1906h.m14069a(c1909k.f11244k, 256, m14040a);
        C1906h.m14069a(c1909k.f11245l, 704, c1909k.f11248o[1]);
        C1906h.m14069a(c1909k.f11246m, i2, m14040a2);
        C1906h.m14070a(c1909k.f11244k, c1899a);
        C1906h.m14070a(c1909k.f11245l, c1899a);
        C1906h.m14070a(c1909k.f11246m, c1899a);
        c1909k.f11209B = 0;
        c1909k.f11210C = 0;
        c1909k.f11211D = C1902d.f11187b[c1909k.f11259z[0]];
        c1909k.f11212E = C1902d.f11187b[c1909k.f11259z[0] + 1];
        c1909k.f11255v = 0;
        c1909k.f11256w = c1909k.f11244k.f11196b[0];
        c1909k.f11213F = c1909k.f11245l.f11196b[0];
        int[] iArr = c1909k.f11249p;
        int[] iArr2 = c1909k.f11249p;
        c1909k.f11249p[4] = 1;
        iArr2[2] = 1;
        iArr[0] = 1;
        int[] iArr3 = c1909k.f11249p;
        int[] iArr4 = c1909k.f11249p;
        c1909k.f11249p[5] = 0;
        iArr4[3] = 0;
        iArr3[1] = 0;
    }

    /* renamed from: h */
    private static void m14059h(C1909k c1909k) {
        C1899a c1899a = c1909k.f11236c;
        byte[] bArr = c1909k.f11237d;
        if (c1909k.f11240g <= 0) {
            C1899a.m14035c(c1899a);
            c1909k.f11234a = 1;
            return;
        }
        int min = Math.min(c1909k.f11224Q - c1909k.f11251r, c1909k.f11240g);
        C1899a.m14033a(c1899a, bArr, c1909k.f11251r, min);
        c1909k.f11240g -= min;
        c1909k.f11251r += min;
        if (c1909k.f11251r == c1909k.f11224Q) {
            c1909k.f11235b = 5;
            c1909k.f11232Y = c1909k.f11224Q;
            c1909k.f11231X = 0;
            c1909k.f11234a = 12;
            return;
        }
        C1899a.m14035c(c1899a);
        c1909k.f11234a = 1;
    }

    /* renamed from: i */
    private static boolean m14060i(C1909k c1909k) {
        if (c1909k.f11227T != 0) {
            c1909k.f11231X += c1909k.f11227T;
            c1909k.f11227T = 0;
        }
        int min = Math.min(c1909k.f11229V - c1909k.f11230W, c1909k.f11232Y - c1909k.f11231X);
        if (min != 0) {
            System.arraycopy(c1909k.f11237d, c1909k.f11231X, c1909k.f11233Z, c1909k.f11228U + c1909k.f11230W, min);
            c1909k.f11230W += min;
            c1909k.f11231X = min + c1909k.f11231X;
        }
        return c1909k.f11230W < c1909k.f11229V;
    }

    /* renamed from: a */
    static void m14048a(C1909k c1909k, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        c1909k.f11226S = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5 A[LOOP:1: B:32:0x00d5->B:114:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b5 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void m14046a(C1909k c1909k) {
        int i;
        int i2;
        if (c1909k.f11234a == 0) {
            throw new IllegalStateException("Can't decompress until initialized");
        }
        if (c1909k.f11234a == 11) {
            throw new IllegalStateException("Can't decompress after close");
        }
        C1899a c1899a = c1909k.f11236c;
        int i3 = c1909k.f11224Q - 1;
        byte[] bArr = c1909k.f11237d;
        int i4 = i3;
        while (c1909k.f11234a != 10) {
            switch (c1909k.f11234a) {
                case 1:
                    if (c1909k.f11240g < 0) {
                        throw new C1901c("Invalid metablock length");
                    }
                    m14057f(c1909k);
                    int i5 = c1909k.f11224Q - 1;
                    bArr = c1909k.f11237d;
                    i4 = i5;
                case 2:
                    m14058g(c1909k);
                    c1909k.f11234a = 3;
                    if (c1909k.f11240g > 0) {
                        c1909k.f11234a = 1;
                    } else {
                        C1899a.m14030a(c1899a);
                        if (c1909k.f11247n[1] == 0) {
                            m14054c(c1909k);
                        }
                        c1909k.f11247n[1] = r1[1] - 1;
                        C1899a.m14034b(c1899a);
                        int m14043a = m14043a(c1909k.f11245l.f11195a, c1909k.f11213F, c1899a);
                        int i6 = m14043a >>> 6;
                        c1909k.f11214G = 0;
                        if (i6 >= 2) {
                            i6 -= 2;
                            c1909k.f11214G = -1;
                        }
                        int i7 = C1908j.f11206g[i6] + ((m14043a >>> 3) & 7);
                        int i8 = C1908j.f11207h[i6] + (m14043a & 7);
                        c1909k.f11258y = C1908j.f11202c[i7] + C1899a.m14029a(c1899a, C1908j.f11203d[i7]);
                        c1909k.f11220M = C1899a.m14029a(c1899a, C1908j.f11205f[i8]) + C1908j.f11204e[i8];
                        c1909k.f11257x = 0;
                        c1909k.f11234a = 6;
                        if (c1909k.f11254u) {
                            int i9 = bArr[(c1909k.f11251r - 1) & i4] & 255;
                            int i10 = bArr[(c1909k.f11251r - 2) & i4] & 255;
                            while (true) {
                                if (c1909k.f11257x < c1909k.f11258y) {
                                    C1899a.m14030a(c1899a);
                                    if (c1909k.f11247n[0] == 0) {
                                        m14053b(c1909k);
                                    }
                                    int i11 = c1909k.f11208A[(C1902d.f11186a[i10 + c1909k.f11212E] | C1902d.f11186a[c1909k.f11211D + i9]) + c1909k.f11209B] & 255;
                                    c1909k.f11247n[0] = r3[0] - 1;
                                    C1899a.m14034b(c1899a);
                                    int m14043a2 = m14043a(c1909k.f11244k.f11195a, c1909k.f11244k.f11196b[i11], c1899a);
                                    bArr[c1909k.f11251r] = (byte) m14043a2;
                                    c1909k.f11257x++;
                                    int i12 = c1909k.f11251r;
                                    c1909k.f11251r = i12 + 1;
                                    if (i12 == i4) {
                                        c1909k.f11235b = 6;
                                        c1909k.f11232Y = c1909k.f11224Q;
                                        c1909k.f11231X = 0;
                                        c1909k.f11234a = 12;
                                    } else {
                                        i10 = i9;
                                        i9 = m14043a2;
                                    }
                                }
                            }
                        } else {
                            while (true) {
                                if (c1909k.f11257x < c1909k.f11258y) {
                                    C1899a.m14030a(c1899a);
                                    if (c1909k.f11247n[0] == 0) {
                                        m14053b(c1909k);
                                    }
                                    c1909k.f11247n[0] = r1[0] - 1;
                                    C1899a.m14034b(c1899a);
                                    bArr[c1909k.f11251r] = (byte) m14043a(c1909k.f11244k.f11195a, c1909k.f11256w, c1899a);
                                    c1909k.f11257x++;
                                    int i13 = c1909k.f11251r;
                                    c1909k.f11251r = i13 + 1;
                                    if (i13 == i4) {
                                        c1909k.f11235b = 6;
                                        c1909k.f11232Y = c1909k.f11224Q;
                                        c1909k.f11231X = 0;
                                        c1909k.f11234a = 12;
                                    }
                                }
                            }
                        }
                        if (c1909k.f11234a != 6) {
                            c1909k.f11240g -= c1909k.f11258y;
                            if (c1909k.f11240g <= 0) {
                                c1909k.f11234a = 3;
                            } else {
                                if (c1909k.f11214G < 0) {
                                    C1899a.m14030a(c1899a);
                                    if (c1909k.f11247n[2] == 0) {
                                        m14055d(c1909k);
                                    }
                                    c1909k.f11247n[2] = r1[2] - 1;
                                    C1899a.m14034b(c1899a);
                                    c1909k.f11214G = m14043a(c1909k.f11246m.f11195a, c1909k.f11246m.f11196b[c1909k.f11215H[(c1909k.f11220M > 4 ? 3 : c1909k.f11220M - 2) + c1909k.f11210C] & 255], c1899a);
                                    if (c1909k.f11214G >= c1909k.f11216I) {
                                        c1909k.f11214G -= c1909k.f11216I;
                                        int i14 = c1909k.f11214G & c1909k.f11217J;
                                        c1909k.f11214G >>>= c1909k.f11218K;
                                        c1909k.f11214G = i14 + c1909k.f11216I + ((C1899a.m14029a(c1899a, (c1909k.f11214G >>> 1) + 1) + ((((c1909k.f11214G & 1) + 2) << r2) - 4)) << c1909k.f11218K);
                                    }
                                }
                                c1909k.f11219L = m14041a(c1909k.f11214G, c1909k.f11250q, c1909k.f11253t);
                                if (c1909k.f11219L < 0) {
                                    throw new C1901c("Negative distance");
                                }
                                if (c1909k.f11252s != c1909k.f11222O && c1909k.f11251r < c1909k.f11222O) {
                                    c1909k.f11252s = c1909k.f11251r;
                                } else {
                                    c1909k.f11252s = c1909k.f11222O;
                                }
                                c1909k.f11221N = c1909k.f11251r;
                                if (c1909k.f11219L > c1909k.f11252s) {
                                    c1909k.f11234a = 9;
                                } else {
                                    if (c1909k.f11214G > 0) {
                                        c1909k.f11250q[c1909k.f11253t & 3] = c1909k.f11219L;
                                        c1909k.f11253t++;
                                    }
                                    if (c1909k.f11220M > c1909k.f11240g) {
                                        throw new C1901c("Invalid backward reference");
                                    }
                                    c1909k.f11257x = 0;
                                    c1909k.f11234a = 7;
                                    i = (c1909k.f11251r - c1909k.f11219L) & i4;
                                    int i15 = c1909k.f11251r;
                                    i2 = c1909k.f11220M - c1909k.f11257x;
                                    if (i + i2 < i4 || i15 + i2 >= i4) {
                                        while (true) {
                                            if (c1909k.f11257x >= c1909k.f11220M) {
                                                bArr[c1909k.f11251r] = bArr[(c1909k.f11251r - c1909k.f11219L) & i4];
                                                c1909k.f11240g--;
                                                c1909k.f11257x++;
                                                int i16 = c1909k.f11251r;
                                                c1909k.f11251r = i16 + 1;
                                                if (i16 == i4) {
                                                    c1909k.f11235b = 7;
                                                    c1909k.f11232Y = c1909k.f11224Q;
                                                    c1909k.f11231X = 0;
                                                    c1909k.f11234a = 12;
                                                }
                                            }
                                        }
                                    } else {
                                        int i17 = 0;
                                        int i18 = i;
                                        while (i17 < i2) {
                                            bArr[i15] = bArr[i18];
                                            i17++;
                                            i15++;
                                            i18++;
                                        }
                                        c1909k.f11257x += i2;
                                        c1909k.f11240g -= i2;
                                        c1909k.f11251r += i2;
                                    }
                                    if (c1909k.f11234a != 7) {
                                        c1909k.f11234a = 3;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                    break;
                case 3:
                    if (c1909k.f11240g > 0) {
                    }
                    break;
                case 4:
                    while (c1909k.f11240g > 0) {
                        C1899a.m14030a(c1899a);
                        C1899a.m14029a(c1899a, 8);
                        c1909k.f11240g--;
                    }
                    c1909k.f11234a = 1;
                case 5:
                    m14059h(c1909k);
                case 6:
                    if (c1909k.f11254u) {
                    }
                    if (c1909k.f11234a != 6) {
                    }
                    break;
                case 7:
                    i = (c1909k.f11251r - c1909k.f11219L) & i4;
                    int i152 = c1909k.f11251r;
                    i2 = c1909k.f11220M - c1909k.f11257x;
                    if (i + i2 < i4) {
                        break;
                    }
                    while (true) {
                        if (c1909k.f11257x >= c1909k.f11220M) {
                        }
                    }
                    if (c1909k.f11234a != 7) {
                    }
                    break;
                case 8:
                    System.arraycopy(bArr, c1909k.f11224Q, bArr, 0, c1909k.f11221N - c1909k.f11224Q);
                    c1909k.f11234a = 3;
                case 9:
                    if (c1909k.f11220M >= 4 && c1909k.f11220M <= 24) {
                        int i19 = C1904f.f11192a[c1909k.f11220M];
                        int i20 = (c1909k.f11219L - c1909k.f11252s) - 1;
                        int i21 = i20 >>> C1904f.f11193b[c1909k.f11220M];
                        int i22 = i19 + (c1909k.f11220M * (((1 << r3) - 1) & i20));
                        if (i21 < C1910l.f11260a.length) {
                            int m14076a = C1910l.m14076a(bArr, c1909k.f11221N, C1904f.m14061a(), i22, c1909k.f11220M, C1910l.f11260a[i21]);
                            c1909k.f11221N += m14076a;
                            c1909k.f11251r += m14076a;
                            c1909k.f11240g -= m14076a;
                            if (c1909k.f11221N >= c1909k.f11224Q) {
                                c1909k.f11235b = 8;
                                c1909k.f11232Y = c1909k.f11224Q;
                                c1909k.f11231X = 0;
                                c1909k.f11234a = 12;
                            } else {
                                c1909k.f11234a = 3;
                            }
                        } else {
                            throw new C1901c("Invalid backward reference");
                        }
                    } else {
                        throw new C1901c("Invalid backward reference");
                    }
                    break;
                case 10:
                case 11:
                default:
                    throw new C1901c("Unexpected state " + c1909k.f11234a);
                case 12:
                    if (m14060i(c1909k)) {
                        if (c1909k.f11251r >= c1909k.f11222O) {
                            c1909k.f11252s = c1909k.f11222O;
                        }
                        c1909k.f11251r &= i4;
                        c1909k.f11234a = c1909k.f11235b;
                    } else {
                        return;
                    }
            }
        }
        if (c1909k.f11234a == 10) {
            if (c1909k.f11240g < 0) {
                throw new C1901c("Invalid metablock length");
            }
            C1899a.m14037e(c1899a);
            C1899a.m14032a(c1909k.f11236c, true);
        }
    }
}
