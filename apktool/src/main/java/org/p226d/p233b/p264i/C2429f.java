package org.p226d.p233b.p264i;

import android.widget.ExpandableListView;
import java.p209io.BufferedOutputStream;
import java.p209io.OutputStream;
import org.p226d.p269d.C2453g;

/* compiled from: DexDataWriter.java */
/* renamed from: org.d.b.i.f */
/* loaded from: classes.dex */
public class C2429f extends BufferedOutputStream {

    /* renamed from: a */
    private int f12823a;

    /* renamed from: b */
    private byte[] f12824b;

    /* renamed from: c */
    private byte[] f12825c;

    public C2429f(OutputStream outputStream, int i) {
        this(outputStream, i, 262144);
    }

    public C2429f(OutputStream outputStream, int i, int i2) {
        super(outputStream, i2);
        this.f12824b = new byte[8];
        this.f12825c = new byte[3];
        this.f12823a = i;
    }

    @Override // java.p209io.BufferedOutputStream, java.p209io.FilterOutputStream, java.p209io.OutputStream
    public void write(int i) {
        this.f12823a++;
        super.write(i);
    }

    @Override // java.p209io.FilterOutputStream, java.p209io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.p209io.BufferedOutputStream, java.p209io.FilterOutputStream, java.p209io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f12823a += i2;
        super.write(bArr, i, i2);
    }

    /* renamed from: a */
    public void m15361a(long j) {
        m15356a((int) j);
        m15356a((int) (j >> 32));
    }

    /* renamed from: a */
    public static void m15352a(OutputStream outputStream, int i) {
        outputStream.write(i);
        outputStream.write(i >> 8);
        outputStream.write(i >> 16);
        outputStream.write(i >> 24);
    }

    /* renamed from: a */
    public void m15356a(int i) {
        m15352a(this, i);
    }

    /* renamed from: b */
    public void m15364b(int i) {
        if (i < -32768 || i > 32767) {
            throw new C2453g("Short value out of range: %d", Integer.valueOf(i));
        }
        write(i);
        write(i >> 8);
    }

    /* renamed from: c */
    public void m15367c(int i) {
        if (i < 0 || i > 65535) {
            throw new C2453g("Unsigned short value out of range: %d", Integer.valueOf(i));
        }
        write(i);
        write(i >> 8);
    }

    /* renamed from: d */
    public void m15369d(int i) {
        if (i < 0 || i > 255) {
            throw new C2453g("Unsigned byte value out of range: %d", Integer.valueOf(i));
        }
        write(i);
    }

    /* renamed from: b */
    public static void m15353b(OutputStream outputStream, int i) {
        while ((i & ExpandableListView.PACKED_POSITION_VALUE_NULL) > 127) {
            outputStream.write((i & 127) | 128);
            i >>>= 7;
        }
        outputStream.write(i);
    }

    /* renamed from: e */
    public void m15371e(int i) {
        m15353b(this, i);
    }

    /* renamed from: c */
    public static void m15354c(OutputStream outputStream, int i) {
        if (i >= 0) {
            while (i > 63) {
                outputStream.write((i & 127) | 128);
                i >>>= 7;
            }
            outputStream.write(i & 127);
            return;
        }
        while (i < -64) {
            outputStream.write((i & 127) | 128);
            i >>= 7;
        }
        outputStream.write(i & 127);
    }

    /* renamed from: f */
    public void m15372f(int i) {
        m15354c(this, i);
    }

    /* renamed from: a */
    public void m15359a(int i, int i2) {
        write((i2 << 5) | i);
    }

    /* renamed from: b */
    public void m15365b(int i, int i2) {
        int i3;
        int i4;
        if (i2 >= 0) {
            i3 = 0;
            i4 = i2;
            while (i4 > 127) {
                this.f12824b[i3] = (byte) i4;
                i4 >>= 8;
                i3++;
            }
        } else {
            i3 = 0;
            i4 = i2;
            while (i4 < -128) {
                this.f12824b[i3] = (byte) i4;
                i4 >>= 8;
                i3++;
            }
        }
        int i5 = i3 + 1;
        this.f12824b[i3] = (byte) i4;
        m15359a(i, i5 - 1);
        write(this.f12824b, 0, i5);
    }

    /* renamed from: a */
    public void m15360a(int i, long j) {
        int i2;
        long j2;
        if (j >= 0) {
            i2 = 0;
            j2 = j;
            while (j2 > 127) {
                this.f12824b[i2] = (byte) j2;
                j2 >>= 8;
                i2++;
            }
        } else {
            i2 = 0;
            j2 = j;
            while (j2 < -128) {
                this.f12824b[i2] = (byte) j2;
                j2 >>= 8;
                i2++;
            }
        }
        int i3 = i2 + 1;
        this.f12824b[i2] = (byte) j2;
        m15359a(i, i3 - 1);
        write(this.f12824b, 0, i3);
    }

    /* renamed from: c */
    public void m15368c(int i, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            this.f12824b[i3] = (byte) i2;
            i2 >>>= 8;
            if (i2 == 0) {
                m15359a(i, i4 - 1);
                write(this.f12824b, 0, i4);
                return;
            }
            i3 = i4;
        }
    }

    /* renamed from: a */
    public void m15358a(int i, float f2) {
        m15370d(i, Float.floatToRawIntBits(f2));
    }

    /* renamed from: d */
    protected void m15370d(int i, int i2) {
        int i3 = 3;
        while (true) {
            int i4 = i3 - 1;
            this.f12824b[i3] = (byte) (((-16777216) & i2) >>> 24);
            i2 <<= 8;
            if (i2 == 0) {
                int i5 = i4 + 1;
                int i6 = 4 - i5;
                m15359a(i, i6 - 1);
                write(this.f12824b, i5, i6);
                return;
            }
            i3 = i4;
        }
    }

    /* renamed from: a */
    public void m15357a(int i, double d2) {
        m15366b(i, Double.doubleToRawLongBits(d2));
    }

    /* renamed from: b */
    protected void m15366b(int i, long j) {
        int i2 = 7;
        while (true) {
            int i3 = i2 - 1;
            this.f12824b[i2] = (byte) (((-72057594037927936L) & j) >>> 56);
            j <<= 8;
            if (j == 0) {
                int i4 = i3 + 1;
                int i5 = 8 - i4;
                m15359a(i, i5 - 1);
                write(this.f12824b, i4, i5);
                return;
            }
            i2 = i3;
        }
    }

    /* renamed from: a */
    public void m15362a(String str) {
        int i;
        int length = str.length();
        if (this.f12824b.length <= str.length() * 3) {
            this.f12824b = new byte[str.length() * 3];
        }
        byte[] bArr = this.f12824b;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != 0 && charAt < 128) {
                i = i3 + 1;
                bArr[i3] = (byte) charAt;
            } else if (charAt < 2048) {
                int i4 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 31) | 192);
                i = i4 + 1;
                bArr[i4] = (byte) ((charAt & '?') | 128);
            } else {
                int i5 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> '\f') & 15) | 224);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((charAt >> 6) & 63) | 128);
                i = i6 + 1;
                bArr[i6] = (byte) ((charAt & '?') | 128);
            }
            i2++;
            i3 = i;
        }
        write(bArr, 0, i3);
    }

    /* renamed from: a */
    public void m15355a() {
        int i = (-m15363b()) & 3;
        if (i > 0) {
            write(this.f12825c, 0, i);
        }
    }

    /* renamed from: b */
    public int m15363b() {
        return this.f12823a;
    }
}
