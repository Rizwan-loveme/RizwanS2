package p165d.p167b.p172e;

import java.io.IOException;
import java.util.ArrayList;

/* compiled from: DerIndefLenConverter.java */
/* renamed from: d.b.e.i */
/* loaded from: classes.dex */
class C1446i {

    /* renamed from: a */
    private byte[] f9341a;

    /* renamed from: b */
    private int f9342b;

    /* renamed from: c */
    private int f9343c;

    /* renamed from: d */
    private int f9344d;

    /* renamed from: f */
    private byte[] f9346f;

    /* renamed from: g */
    private int f9347g;

    /* renamed from: i */
    private int f9349i = 0;

    /* renamed from: e */
    private ArrayList<Object> f9345e = new ArrayList<>();

    /* renamed from: h */
    private int f9348h = 0;

    /* renamed from: d */
    private boolean m11341d(int i) {
        return (i & 31) == 0 && (i & 32) == 0 && (i & 192) == 0;
    }

    /* renamed from: b */
    static boolean m11337b(int i) {
        return (i & 128) == 128;
    }

    C1446i() {
    }

    /* renamed from: a */
    static boolean m11335a(int i) {
        return m11337b(i) && (i & 127) == 0;
    }

    /* renamed from: b */
    private void m11336b() {
        Object obj;
        if (this.f9342b != this.f9343c) {
            if (m11341d(this.f9341a[this.f9342b]) && this.f9341a[this.f9342b + 1] == 0) {
                int i = 0;
                Object obj2 = null;
                int size = this.f9345e.size() - 1;
                while (true) {
                    if (size < 0) {
                        obj = obj2;
                        break;
                    }
                    obj2 = this.f9345e.get(size);
                    if (obj2 instanceof Integer) {
                        obj = obj2;
                        break;
                    } else {
                        i += ((byte[]) obj2).length - 3;
                        size--;
                    }
                }
                if (size < 0) {
                    throw new IOException("EOC does not have matching indefinite-length tag");
                }
                this.f9345e.set(size, m11339c((this.f9342b - ((Integer) obj).intValue()) + i));
                this.f9349i--;
                this.f9348h = (r0.length - 3) + this.f9348h;
            }
            this.f9342b++;
        }
    }

    /* renamed from: d */
    private void m11340d() {
        if (this.f9342b != this.f9343c) {
            byte[] bArr = this.f9341a;
            int i = this.f9342b;
            this.f9342b = i + 1;
            byte b2 = bArr[i];
            if (m11341d(b2) && this.f9341a[this.f9342b] == 0) {
                this.f9342b++;
                m11340d();
            } else {
                byte[] bArr2 = this.f9346f;
                int i2 = this.f9347g;
                this.f9347g = i2 + 1;
                bArr2[i2] = b2;
            }
        }
    }

    /* renamed from: a */
    private int m11334a() {
        if (this.f9342b == this.f9343c) {
            return 0;
        }
        byte[] bArr = this.f9341a;
        int i = this.f9342b;
        this.f9342b = i + 1;
        int i2 = bArr[i] & 255;
        if (m11335a(i2)) {
            this.f9345e.add(new Integer(this.f9342b));
            this.f9349i++;
            return 0;
        }
        if (m11337b(i2)) {
            int i3 = i2 & 127;
            if (i3 > 4) {
                throw new IOException("Too much data");
            }
            if (this.f9343c - this.f9342b < i3 + 1) {
                throw new IOException("Too little data");
            }
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                byte[] bArr2 = this.f9341a;
                int i6 = this.f9342b;
                this.f9342b = i6 + 1;
                i4 = (i4 << 8) + (bArr2[i6] & 255);
            }
            if (i4 < 0) {
                throw new IOException("Invalid length bytes");
            }
            return i4;
        }
        return i2 & 127;
    }

    /* renamed from: c */
    private void m11338c() {
        int i;
        if (this.f9342b != this.f9343c) {
            byte[] bArr = this.f9341a;
            int i2 = this.f9342b;
            this.f9342b = i2 + 1;
            int i3 = bArr[i2] & 255;
            if (m11335a(i3)) {
                ArrayList<Object> arrayList = this.f9345e;
                int i4 = this.f9344d;
                this.f9344d = i4 + 1;
                byte[] bArr2 = (byte[]) arrayList.get(i4);
                System.arraycopy(bArr2, 0, this.f9346f, this.f9347g, bArr2.length);
                this.f9347g = bArr2.length + this.f9347g;
                return;
            }
            if (m11337b(i3)) {
                i = 0;
                for (int i5 = 0; i5 < (i3 & 127); i5++) {
                    byte[] bArr3 = this.f9341a;
                    int i6 = this.f9342b;
                    this.f9342b = i6 + 1;
                    i = (i << 8) + (bArr3[i6] & 255);
                }
                if (i < 0) {
                    throw new IOException("Invalid length bytes");
                }
            } else {
                i = i3 & 127;
            }
            m11343f(i);
            m11344g(i);
        }
    }

    /* renamed from: f */
    private void m11343f(int i) {
        if (i < 128) {
            byte[] bArr = this.f9346f;
            int i2 = this.f9347g;
            this.f9347g = i2 + 1;
            bArr[i2] = (byte) i;
            return;
        }
        if (i < 256) {
            byte[] bArr2 = this.f9346f;
            int i3 = this.f9347g;
            this.f9347g = i3 + 1;
            bArr2[i3] = -127;
            byte[] bArr3 = this.f9346f;
            int i4 = this.f9347g;
            this.f9347g = i4 + 1;
            bArr3[i4] = (byte) i;
            return;
        }
        if (i < 65536) {
            byte[] bArr4 = this.f9346f;
            int i5 = this.f9347g;
            this.f9347g = i5 + 1;
            bArr4[i5] = -126;
            byte[] bArr5 = this.f9346f;
            int i6 = this.f9347g;
            this.f9347g = i6 + 1;
            bArr5[i6] = (byte) (i >> 8);
            byte[] bArr6 = this.f9346f;
            int i7 = this.f9347g;
            this.f9347g = i7 + 1;
            bArr6[i7] = (byte) i;
            return;
        }
        if (i < 16777216) {
            byte[] bArr7 = this.f9346f;
            int i8 = this.f9347g;
            this.f9347g = i8 + 1;
            bArr7[i8] = -125;
            byte[] bArr8 = this.f9346f;
            int i9 = this.f9347g;
            this.f9347g = i9 + 1;
            bArr8[i9] = (byte) (i >> 16);
            byte[] bArr9 = this.f9346f;
            int i10 = this.f9347g;
            this.f9347g = i10 + 1;
            bArr9[i10] = (byte) (i >> 8);
            byte[] bArr10 = this.f9346f;
            int i11 = this.f9347g;
            this.f9347g = i11 + 1;
            bArr10[i11] = (byte) i;
            return;
        }
        byte[] bArr11 = this.f9346f;
        int i12 = this.f9347g;
        this.f9347g = i12 + 1;
        bArr11[i12] = -124;
        byte[] bArr12 = this.f9346f;
        int i13 = this.f9347g;
        this.f9347g = i13 + 1;
        bArr12[i13] = (byte) (i >> 24);
        byte[] bArr13 = this.f9346f;
        int i14 = this.f9347g;
        this.f9347g = i14 + 1;
        bArr13[i14] = (byte) (i >> 16);
        byte[] bArr14 = this.f9346f;
        int i15 = this.f9347g;
        this.f9347g = i15 + 1;
        bArr14[i15] = (byte) (i >> 8);
        byte[] bArr15 = this.f9346f;
        int i16 = this.f9347g;
        this.f9347g = i16 + 1;
        bArr15[i16] = (byte) i;
    }

    /* renamed from: c */
    private byte[] m11339c(int i) {
        if (i < 128) {
            return new byte[]{(byte) i};
        }
        if (i < 256) {
            return new byte[]{-127, (byte) i};
        }
        if (i < 65536) {
            return new byte[]{-126, (byte) (i >> 8), (byte) i};
        }
        if (i < 16777216) {
            return new byte[]{-125, (byte) (i >> 16), (byte) (i >> 8), (byte) i};
        }
        return new byte[]{-124, (byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    /* renamed from: e */
    private void m11342e(int i) {
        this.f9342b += i;
    }

    /* renamed from: g */
    private void m11344g(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = this.f9346f;
            int i3 = this.f9347g;
            this.f9347g = i3 + 1;
            byte[] bArr2 = this.f9341a;
            int i4 = this.f9342b;
            this.f9342b = i4 + 1;
            bArr[i3] = bArr2[i4];
        }
    }

    /* renamed from: a */
    byte[] m11345a(byte[] bArr) {
        this.f9341a = bArr;
        this.f9342b = 0;
        this.f9344d = 0;
        this.f9343c = this.f9341a.length;
        while (this.f9342b < this.f9343c) {
            m11336b();
            m11342e(m11334a());
        }
        if (this.f9349i != 0) {
            throw new IOException("not all indef len BER resolved");
        }
        this.f9346f = new byte[this.f9343c + this.f9348h];
        this.f9342b = 0;
        this.f9347g = 0;
        this.f9344d = 0;
        while (this.f9342b < this.f9343c) {
            m11340d();
            m11338c();
        }
        return this.f9346f;
    }
}
