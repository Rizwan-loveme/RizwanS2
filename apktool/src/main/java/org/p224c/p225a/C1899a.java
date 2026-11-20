package org.p224c.p225a;

import android.bluetooth.BluetoothClass;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: BitReader.java */
/* renamed from: org.c.a.a */
/* loaded from: classes.dex */
final class C1899a {

    /* renamed from: a */
    long f11173a;

    /* renamed from: b */
    int f11174b;

    /* renamed from: f */
    private InputStream f11178f;

    /* renamed from: g */
    private boolean f11179g;

    /* renamed from: h */
    private int f11180h;

    /* renamed from: c */
    private final byte[] f11175c = new byte[4160];

    /* renamed from: d */
    private final int[] f11176d = new int[BluetoothClass.Device.AUDIO_VIDEO_MICROPHONE];

    /* renamed from: e */
    private final C1907i f11177e = new C1907i();

    /* renamed from: i */
    private int f11181i = 0;

    C1899a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r5.f11179g = true;
        r5.f11181i = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        r0 = r0 + 3;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void m14030a(C1899a c1899a) {
        if (c1899a.f11180h > 1015) {
            if (c1899a.f11179g) {
                if (m14038f(c1899a) < -2) {
                    throw new C1901c("No more input");
                }
                return;
            }
            int i = c1899a.f11180h << 2;
            int i2 = 4096 - i;
            System.arraycopy(c1899a.f11175c, i, c1899a.f11175c, 0, i2);
            c1899a.f11180h = 0;
            while (true) {
                if (i2 >= 4096) {
                    break;
                }
                try {
                    int read = c1899a.f11178f.read(c1899a.f11175c, i2, 4096 - i2);
                    if (read <= 0) {
                        break;
                    } else {
                        i2 += read;
                    }
                } catch (IOException e2) {
                    throw new C1901c("Failed to read input", e2);
                }
            }
            C1907i.m14071a(c1899a.f11177e, i2 >> 2);
        }
    }

    /* renamed from: a */
    static void m14032a(C1899a c1899a, boolean z) {
        if (c1899a.f11179g) {
            int i = ((c1899a.f11180h << 2) + ((c1899a.f11174b + 7) >> 3)) - 8;
            if (i > c1899a.f11181i) {
                throw new C1901c("Read after end");
            }
            if (z && i != c1899a.f11181i) {
                throw new C1901c("Unused bytes after end");
            }
        }
    }

    /* renamed from: b */
    static void m14034b(C1899a c1899a) {
        if (c1899a.f11174b >= 32) {
            int[] iArr = c1899a.f11176d;
            c1899a.f11180h = c1899a.f11180h + 1;
            c1899a.f11173a = (iArr[r1] << 32) | (c1899a.f11173a >>> 32);
            c1899a.f11174b -= 32;
        }
    }

    /* renamed from: a */
    static int m14029a(C1899a c1899a, int i) {
        m14034b(c1899a);
        int i2 = ((int) (c1899a.f11173a >>> c1899a.f11174b)) & ((1 << i) - 1);
        c1899a.f11174b += i;
        return i2;
    }

    /* renamed from: a */
    static void m14031a(C1899a c1899a, InputStream inputStream) {
        if (c1899a.f11178f != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        C1907i.m14072a(c1899a.f11177e, c1899a.f11175c, c1899a.f11176d);
        c1899a.f11178f = inputStream;
        c1899a.f11173a = 0L;
        c1899a.f11174b = 64;
        c1899a.f11180h = 1024;
        c1899a.f11179g = false;
        m14039g(c1899a);
    }

    /* renamed from: g */
    private static void m14039g(C1899a c1899a) {
        m14030a(c1899a);
        m14032a(c1899a, false);
        m14034b(c1899a);
        m14034b(c1899a);
    }

    /* renamed from: c */
    static void m14035c(C1899a c1899a) {
        if (c1899a.f11174b == 64) {
            m14039g(c1899a);
        }
    }

    /* renamed from: d */
    static void m14036d(C1899a c1899a) {
        InputStream inputStream = c1899a.f11178f;
        c1899a.f11178f = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /* renamed from: e */
    static void m14037e(C1899a c1899a) {
        int i = (64 - c1899a.f11174b) & 7;
        if (i != 0 && m14029a(c1899a, i) != 0) {
            throw new C1901c("Corrupted padding bits");
        }
    }

    /* renamed from: f */
    static int m14038f(C1899a c1899a) {
        int i = 1024;
        if (c1899a.f11179g) {
            i = (c1899a.f11181i + 3) >> 2;
        }
        return i - c1899a.f11180h;
    }

    /* renamed from: a */
    static void m14033a(C1899a c1899a, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if ((c1899a.f11174b & 7) != 0) {
            throw new C1901c("Unaligned copyBytes");
        }
        while (c1899a.f11174b != 64 && i2 != 0) {
            bArr[i] = (byte) (c1899a.f11173a >>> c1899a.f11174b);
            c1899a.f11174b += 8;
            i2--;
            i++;
        }
        if (i2 != 0) {
            int min = Math.min(m14038f(c1899a), i2 >> 2);
            if (min > 0) {
                System.arraycopy(c1899a.f11175c, c1899a.f11180h << 2, bArr, i, min << 2);
                i4 = i + (min << 2);
                i3 = i2 - (min << 2);
                c1899a.f11180h = min + c1899a.f11180h;
            } else {
                i3 = i2;
                i4 = i;
            }
            if (i3 != 0) {
                if (m14038f(c1899a) > 0) {
                    m14034b(c1899a);
                    while (i3 != 0) {
                        bArr[i4] = (byte) (c1899a.f11173a >>> c1899a.f11174b);
                        c1899a.f11174b += 8;
                        i3--;
                        i4++;
                    }
                    m14032a(c1899a, false);
                    return;
                }
                while (i3 > 0) {
                    try {
                        int read = c1899a.f11178f.read(bArr, i4, i3);
                        if (read == -1) {
                            throw new C1901c("Unexpected end of input");
                        }
                        i4 += read;
                        i3 -= read;
                    } catch (IOException e2) {
                        throw new C1901c("Failed to read input", e2);
                    }
                }
            }
        }
    }
}
