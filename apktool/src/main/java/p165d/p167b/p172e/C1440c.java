package p165d.p167b.p172e;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* compiled from: BitArray.java */
/* renamed from: d.b.e.c */
/* loaded from: classes.dex */
public class C1440c {

    /* renamed from: a */
    private static final byte[][] f9324a = {new byte[]{48, 48, 48, 48}, new byte[]{48, 48, 48, 49}, new byte[]{48, 48, 49, 48}, new byte[]{48, 48, 49, 49}, new byte[]{48, 49, 48, 48}, new byte[]{48, 49, 48, 49}, new byte[]{48, 49, 49, 48}, new byte[]{48, 49, 49, 49}, new byte[]{49, 48, 48, 48}, new byte[]{49, 48, 48, 49}, new byte[]{49, 48, 49, 48}, new byte[]{49, 48, 49, 49}, new byte[]{49, 49, 48, 48}, new byte[]{49, 49, 48, 49}, new byte[]{49, 49, 49, 48}, new byte[]{49, 49, 49, 49}};

    /* renamed from: b */
    private int f9325b;

    /* renamed from: c */
    private byte[] f9326c;

    /* renamed from: c */
    private static int m11318c(int i) {
        return i / 8;
    }

    /* renamed from: b */
    private static int m11317b(int i) {
        return 1 << (7 - (i % 8));
    }

    public C1440c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative length for BitArray");
        }
        this.f9325b = i;
        this.f9326c = new byte[((i + 8) - 1) / 8];
    }

    public C1440c(int i, byte[] bArr) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative length for BitArray");
        }
        if (bArr.length * 8 < i) {
            throw new IllegalArgumentException("Byte array too short to represent bit array of given length");
        }
        this.f9325b = i;
        int i2 = ((i + 8) - 1) / 8;
        byte b2 = (byte) (255 << ((i2 * 8) - i));
        this.f9326c = new byte[i2];
        System.arraycopy(bArr, 0, this.f9326c, 0, i2);
        if (i2 > 0) {
            byte[] bArr2 = this.f9326c;
            int i3 = i2 - 1;
            bArr2[i3] = (byte) (b2 & bArr2[i3]);
        }
    }

    public C1440c(boolean[] zArr) {
        this.f9325b = zArr.length;
        this.f9326c = new byte[(this.f9325b + 7) / 8];
        for (int i = 0; i < this.f9325b; i++) {
            m11320a(i, zArr[i]);
        }
    }

    private C1440c(C1440c c1440c) {
        this.f9325b = c1440c.f9325b;
        this.f9326c = (byte[]) c1440c.f9326c.clone();
    }

    /* renamed from: a */
    public boolean m11321a(int i) {
        if (i < 0 || i >= this.f9325b) {
            throw new ArrayIndexOutOfBoundsException(Integer.toString(i));
        }
        return (this.f9326c[m11318c(i)] & m11317b(i)) != 0;
    }

    /* renamed from: a */
    public void m11320a(int i, boolean z) {
        if (i < 0 || i >= this.f9325b) {
            throw new ArrayIndexOutOfBoundsException(Integer.toString(i));
        }
        int m11318c = m11318c(i);
        int m11317b = m11317b(i);
        if (z) {
            byte[] bArr = this.f9326c;
            bArr[m11318c] = (byte) (m11317b | bArr[m11318c]);
        } else {
            byte[] bArr2 = this.f9326c;
            bArr2[m11318c] = (byte) ((m11317b ^ (-1)) & bArr2[m11318c]);
        }
    }

    /* renamed from: a */
    public int m11319a() {
        return this.f9325b;
    }

    /* renamed from: c */
    public byte[] m11323c() {
        return (byte[]) this.f9326c.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof C1440c)) {
            return false;
        }
        C1440c c1440c = (C1440c) obj;
        if (c1440c.f9325b != this.f9325b) {
            return false;
        }
        for (int i = 0; i < this.f9326c.length; i++) {
            if (this.f9326c[i] != c1440c.f9326c[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean[] m11322b() {
        boolean[] zArr = new boolean[this.f9325b];
        for (int i = 0; i < this.f9325b; i++) {
            zArr[i] = m11321a(i);
        }
        return zArr;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.f9326c.length) {
                i = (i3 * 31) + this.f9326c[i2];
                i2++;
            } else {
                return this.f9325b ^ i3;
            }
        }
    }

    public Object clone() {
        return new C1440c(this);
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < this.f9326c.length - 1; i++) {
            byteArrayOutputStream.write(f9324a[(this.f9326c[i] >> 4) & 15], 0, 4);
            byteArrayOutputStream.write(f9324a[this.f9326c[i] & 15], 0, 4);
            if (i % 8 == 7) {
                byteArrayOutputStream.write(10);
            } else {
                byteArrayOutputStream.write(32);
            }
        }
        for (int length = (this.f9326c.length - 1) * 8; length < this.f9325b; length++) {
            byteArrayOutputStream.write(m11321a(length) ? 49 : 48);
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: d */
    public C1440c m11324d() {
        for (int i = this.f9325b - 1; i >= 0; i--) {
            if (m11321a(i)) {
                return new C1440c(i + 1, Arrays.copyOf(this.f9326c, (i + 8) / 8));
            }
        }
        return new C1440c(1);
    }
}
