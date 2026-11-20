package p165d.p167b.p172e;

import android.text.format.Time;
import java.math.BigInteger;
import java.p209io.ByteArrayInputStream;
import java.p209io.IOException;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DerInputBuffer.java */
/* renamed from: d.b.e.j */
/* loaded from: classes.dex */
class C1447j extends ByteArrayInputStream implements Cloneable {

    /* renamed from: a */
    boolean f9350a;

    C1447j(byte[] bArr, boolean z) {
        super(bArr);
        this.f9350a = true;
        this.f9350a = z;
    }

    C1447j(byte[] bArr, int i, int i2, boolean z) {
        super(bArr, i, i2);
        this.f9350a = true;
        this.f9350a = z;
    }

    /* renamed from: a */
    C1447j m11347a() {
        try {
            C1447j c1447j = (C1447j) clone();
            c1447j.mark(Integer.MAX_VALUE);
            return c1447j;
        } catch (CloneNotSupportedException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }

    /* renamed from: e */
    byte[] m11358e() {
        int available = available();
        if (available <= 0) {
            return null;
        }
        byte[] bArr = new byte[available];
        System.arraycopy(this.buf, this.pos, bArr, 0, available);
        return bArr;
    }

    /* renamed from: d */
    int m11355d() {
        if (this.pos >= this.count) {
            throw new IOException("out of data");
        }
        return this.buf[this.pos];
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1447j) {
            return m11349a((C1447j) obj);
        }
        return false;
    }

    /* renamed from: a */
    boolean m11349a(C1447j c1447j) {
        if (this == c1447j) {
            return true;
        }
        int available = available();
        if (c1447j.available() != available) {
            return false;
        }
        for (int i = 0; i < available; i++) {
            if (this.buf[this.pos + i] != c1447j.buf[c1447j.pos + i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int available = available();
        int i = this.pos;
        int i2 = 0;
        int i3 = 0;
        while (i2 < available) {
            int i4 = (this.buf[i + i2] * i2) + i3;
            i2++;
            i3 = i4;
        }
        return i3;
    }

    /* renamed from: e */
    void m11357e(int i) {
        if (i > available()) {
            throw new IOException("insufficient data");
        }
        this.count = this.pos + i;
    }

    /* renamed from: a */
    BigInteger m11348a(int i, boolean z) {
        if (i > available()) {
            throw new IOException("short read of integer");
        }
        if (i == 0) {
            throw new IOException("Invalid encoding: zero length Int value");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.buf, this.pos, bArr, 0, i);
        skip(i);
        if (this.f9350a || i < 2 || bArr[0] != 0 || bArr[1] < 0) {
            return z ? new BigInteger(1, bArr) : new BigInteger(bArr);
        }
        throw new IOException("Invalid encoding: redundant leading 0s");
    }

    /* renamed from: c */
    public int m11353c(int i) {
        BigInteger m11348a = m11348a(i, false);
        if (m11348a.compareTo(BigInteger.valueOf(-2147483648L)) < 0) {
            throw new IOException("Integer below minimum valid value");
        }
        if (m11348a.compareTo(BigInteger.valueOf(2147483647L)) > 0) {
            throw new IOException("Integer exceeds maximum valid value");
        }
        return m11348a.intValue();
    }

    /* renamed from: a */
    public byte[] m11350a(int i) {
        if (i > available()) {
            throw new IOException("short read of bit string");
        }
        if (i == 0) {
            throw new IOException("Invalid encoding: zero length bit string");
        }
        byte b2 = this.buf[this.pos];
        if (b2 < 0 || b2 > 7) {
            throw new IOException("Invalid number of padding bits");
        }
        byte[] bArr = new byte[i - 1];
        System.arraycopy(this.buf, this.pos + 1, bArr, 0, i - 1);
        if (b2 != 0) {
            int i2 = i - 2;
            bArr[i2] = (byte) ((255 << b2) & bArr[i2]);
        }
        skip(i);
        return bArr;
    }

    /* renamed from: b */
    byte[] m11352b() {
        return m11350a(available());
    }

    /* renamed from: c */
    C1440c m11354c() {
        if (this.pos >= this.count) {
            return null;
        }
        int available = available();
        int i = this.buf[this.pos] & 255;
        if (i > 7) {
            throw new IOException("Invalid value for unused bits: " + i);
        }
        byte[] bArr = new byte[available - 1];
        int length = bArr.length == 0 ? 0 : (bArr.length * 8) - i;
        System.arraycopy(this.buf, this.pos + 1, bArr, 0, available - 1);
        C1440c c1440c = new C1440c(length, bArr);
        this.pos = this.count;
        return c1440c;
    }

    /* renamed from: d */
    public Date m11356d(int i) {
        if (i > available()) {
            throw new IOException("short read of DER UTC Time");
        }
        if (i < 11 || i > 17) {
            throw new IOException("DER UTC Time length error");
        }
        return m11346b(i, false);
    }

    /* renamed from: b */
    public Date m11351b(int i) {
        if (i > available()) {
            throw new IOException("short read of DER Generalized Time");
        }
        if (i < 13 || i > 23) {
            throw new IOException("DER Generalized Time length error");
        }
        return m11346b(i, true);
    }

    /* renamed from: b */
    private Date m11346b(int i, boolean z) {
        int i2;
        String str;
        int i3;
        int i4;
        if (z) {
            byte[] bArr = this.buf;
            int i5 = this.pos;
            this.pos = i5 + 1;
            int digit = Character.digit((char) bArr[i5], 10);
            byte[] bArr2 = this.buf;
            int i6 = this.pos;
            this.pos = i6 + 1;
            int digit2 = Character.digit((char) bArr2[i6], 10);
            byte[] bArr3 = this.buf;
            int i7 = this.pos;
            this.pos = i7 + 1;
            int digit3 = Character.digit((char) bArr3[i7], 10);
            byte[] bArr4 = this.buf;
            int i8 = this.pos;
            this.pos = i8 + 1;
            i2 = (digit * 1000) + (digit2 * 100) + (digit3 * 10) + Character.digit((char) bArr4[i8], 10);
            i -= 2;
            str = "Generalized";
        } else {
            byte[] bArr5 = this.buf;
            int i9 = this.pos;
            this.pos = i9 + 1;
            int digit4 = Character.digit((char) bArr5[i9], 10);
            byte[] bArr6 = this.buf;
            int i10 = this.pos;
            this.pos = i10 + 1;
            int digit5 = (digit4 * 10) + Character.digit((char) bArr6[i10], 10);
            if (digit5 < 50) {
                i2 = digit5 + 2000;
                str = Time.TIMEZONE_UTC;
            } else {
                i2 = digit5 + 1900;
                str = Time.TIMEZONE_UTC;
            }
        }
        byte[] bArr7 = this.buf;
        int i11 = this.pos;
        this.pos = i11 + 1;
        int digit6 = Character.digit((char) bArr7[i11], 10);
        byte[] bArr8 = this.buf;
        int i12 = this.pos;
        this.pos = i12 + 1;
        int digit7 = Character.digit((char) bArr8[i12], 10) + (digit6 * 10);
        byte[] bArr9 = this.buf;
        int i13 = this.pos;
        this.pos = i13 + 1;
        int digit8 = Character.digit((char) bArr9[i13], 10);
        byte[] bArr10 = this.buf;
        int i14 = this.pos;
        this.pos = i14 + 1;
        int digit9 = Character.digit((char) bArr10[i14], 10) + (digit8 * 10);
        byte[] bArr11 = this.buf;
        int i15 = this.pos;
        this.pos = i15 + 1;
        int digit10 = Character.digit((char) bArr11[i15], 10);
        byte[] bArr12 = this.buf;
        int i16 = this.pos;
        this.pos = i16 + 1;
        int digit11 = Character.digit((char) bArr12[i16], 10) + (digit10 * 10);
        byte[] bArr13 = this.buf;
        int i17 = this.pos;
        this.pos = i17 + 1;
        int digit12 = Character.digit((char) bArr13[i17], 10);
        byte[] bArr14 = this.buf;
        int i18 = this.pos;
        this.pos = i18 + 1;
        int digit13 = Character.digit((char) bArr14[i18], 10) + (digit12 * 10);
        int i19 = i - 10;
        int i20 = 0;
        if (i19 > 2 && i19 < 12) {
            byte[] bArr15 = this.buf;
            int i21 = this.pos;
            this.pos = i21 + 1;
            int digit14 = Character.digit((char) bArr15[i21], 10);
            byte[] bArr16 = this.buf;
            int i22 = this.pos;
            this.pos = i22 + 1;
            int digit15 = (digit14 * 10) + Character.digit((char) bArr16[i22], 10);
            i4 = i19 - 2;
            if (this.buf[this.pos] == 46 || this.buf[this.pos] == 44) {
                this.pos++;
                int i23 = 0;
                int i24 = this.pos;
                while (this.buf[i24] != 90 && this.buf[i24] != 43 && this.buf[i24] != 45) {
                    i24++;
                    i23++;
                }
                switch (i23) {
                    case 1:
                        byte[] bArr17 = this.buf;
                        int i25 = this.pos;
                        this.pos = i25 + 1;
                        i20 = (Character.digit((char) bArr17[i25], 10) * 100) + 0;
                        break;
                    case 2:
                        byte[] bArr18 = this.buf;
                        int i26 = this.pos;
                        this.pos = i26 + 1;
                        int digit16 = Character.digit((char) bArr18[i26], 10);
                        byte[] bArr19 = this.buf;
                        int i27 = this.pos;
                        this.pos = i27 + 1;
                        i20 = (digit16 * 100) + 0 + (Character.digit((char) bArr19[i27], 10) * 10);
                        break;
                    case 3:
                        byte[] bArr20 = this.buf;
                        int i28 = this.pos;
                        this.pos = i28 + 1;
                        int digit17 = Character.digit((char) bArr20[i28], 10);
                        byte[] bArr21 = this.buf;
                        int i29 = this.pos;
                        this.pos = i29 + 1;
                        int digit18 = Character.digit((char) bArr21[i29], 10);
                        byte[] bArr22 = this.buf;
                        int i30 = this.pos;
                        this.pos = i30 + 1;
                        i20 = (digit17 * 100) + 0 + (digit18 * 10) + Character.digit((char) bArr22[i30], 10);
                        break;
                    default:
                        throw new IOException("Parse " + str + " time, unsupported precision for seconds value");
                }
                i4 = (i4 - 1) - i23;
                i3 = digit15;
            } else {
                i3 = digit15;
            }
        } else {
            i3 = 0;
            i4 = i19;
        }
        if (digit7 == 0 || digit9 == 0 || digit7 > 12 || digit9 > 31 || digit11 >= 24 || digit13 >= 60 || i3 >= 60) {
            throw new IOException("Parse " + str + " time, invalid format");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i2, digit7, digit9, digit11, digit13, i3);
        calendar.setTimeInMillis(i20);
        long timeInMillis = calendar.getTimeInMillis();
        if (i4 != 1 && i4 != 5) {
            throw new IOException("Parse " + str + " time, invalid offset");
        }
        byte[] bArr23 = this.buf;
        int i31 = this.pos;
        this.pos = i31 + 1;
        switch (bArr23[i31]) {
            case 43:
                byte[] bArr24 = this.buf;
                int i32 = this.pos;
                this.pos = i32 + 1;
                int digit19 = Character.digit((char) bArr24[i32], 10);
                byte[] bArr25 = this.buf;
                int i33 = this.pos;
                this.pos = i33 + 1;
                int digit20 = (digit19 * 10) + Character.digit((char) bArr25[i33], 10);
                byte[] bArr26 = this.buf;
                int i34 = this.pos;
                this.pos = i34 + 1;
                int digit21 = Character.digit((char) bArr26[i34], 10);
                byte[] bArr27 = this.buf;
                int i35 = this.pos;
                this.pos = i35 + 1;
                int digit22 = (digit21 * 10) + Character.digit((char) bArr27[i35], 10);
                if (digit20 >= 24 || digit22 >= 60) {
                    throw new IOException("Parse " + str + " time, +hhmm");
                }
                timeInMillis -= (((digit20 * 60) + digit22) * 60) * 1000;
                break;
                break;
            case 45:
                byte[] bArr28 = this.buf;
                int i36 = this.pos;
                this.pos = i36 + 1;
                int digit23 = Character.digit((char) bArr28[i36], 10);
                byte[] bArr29 = this.buf;
                int i37 = this.pos;
                this.pos = i37 + 1;
                int digit24 = (digit23 * 10) + Character.digit((char) bArr29[i37], 10);
                byte[] bArr30 = this.buf;
                int i38 = this.pos;
                this.pos = i38 + 1;
                int digit25 = Character.digit((char) bArr30[i38], 10);
                byte[] bArr31 = this.buf;
                int i39 = this.pos;
                this.pos = i39 + 1;
                int digit26 = (digit25 * 10) + Character.digit((char) bArr31[i39], 10);
                if (digit24 >= 24 || digit26 >= 60) {
                    throw new IOException("Parse " + str + " time, -hhmm");
                }
                timeInMillis += ((digit24 * 60) + digit26) * 60 * 1000;
                break;
                break;
            case 90:
                break;
            default:
                throw new IOException("Parse " + str + " time, garbage offset");
        }
        return new Date(timeInMillis);
    }
}
