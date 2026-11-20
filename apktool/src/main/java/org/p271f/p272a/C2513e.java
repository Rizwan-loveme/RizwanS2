package org.p271f.p272a;

/* compiled from: ByteVector.java */
/* renamed from: org.f.a.e */
/* loaded from: classes.dex */
public class C2513e {

    /* renamed from: a */
    byte[] f13088a;

    /* renamed from: b */
    int f13089b;

    public C2513e() {
        this.f13088a = new byte[64];
    }

    public C2513e(int i) {
        this.f13088a = new byte[i];
    }

    /* renamed from: a */
    public C2513e m15764a(int i) {
        int i2 = this.f13089b;
        if (i2 + 1 > this.f13088a.length) {
            m15763d(1);
        }
        this.f13088a[i2] = (byte) i;
        this.f13089b = i2 + 1;
        return this;
    }

    /* renamed from: a */
    C2513e m15765a(int i, int i2) {
        int i3 = this.f13089b;
        if (i3 + 2 > this.f13088a.length) {
            m15763d(2);
        }
        byte[] bArr = this.f13088a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.f13089b = i4 + 1;
        return this;
    }

    /* renamed from: b */
    public C2513e m15770b(int i) {
        int i2 = this.f13089b;
        if (i2 + 2 > this.f13088a.length) {
            m15763d(2);
        }
        byte[] bArr = this.f13088a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.f13089b = i3 + 1;
        return this;
    }

    /* renamed from: b */
    C2513e m15771b(int i, int i2) {
        int i3 = this.f13089b;
        if (i3 + 3 > this.f13088a.length) {
            m15763d(3);
        }
        byte[] bArr = this.f13088a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.f13089b = i5 + 1;
        return this;
    }

    /* renamed from: c */
    public C2513e m15772c(int i) {
        int i2 = this.f13089b;
        if (i2 + 4 > this.f13088a.length) {
            m15763d(4);
        }
        byte[] bArr = this.f13088a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.f13089b = i5 + 1;
        return this;
    }

    /* renamed from: a */
    public C2513e m15766a(long j) {
        int i = this.f13089b;
        if (i + 8 > this.f13088a.length) {
            m15763d(8);
        }
        byte[] bArr = this.f13088a;
        int i2 = (int) (j >>> 32);
        int i3 = i + 1;
        bArr[i] = (byte) (i2 >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i2 >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = (int) j;
        int i8 = i6 + 1;
        bArr[i6] = (byte) (i7 >>> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i7 >>> 16);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i7 >>> 8);
        bArr[i10] = (byte) i7;
        this.f13089b = i10 + 1;
        return this;
    }

    /* renamed from: a */
    public C2513e m15767a(String str) {
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException();
        }
        int i = this.f13089b;
        if (i + 2 + length > this.f13088a.length) {
            m15763d(length + 2);
        }
        byte[] bArr = this.f13088a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i2 + 1;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt >= 1 && charAt <= 127) {
                bArr[i3] = (byte) charAt;
                i4++;
                i3++;
            } else {
                this.f13089b = i3;
                return m15768a(str, i4, 65535);
            }
        }
        this.f13089b = i3;
        return this;
    }

    /* renamed from: a */
    C2513e m15768a(String str, int i, int i2) {
        int i3;
        int length = str.length();
        int i4 = i;
        for (int i5 = i; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt >= 1 && charAt <= 127) {
                i4++;
            } else if (charAt > 2047) {
                i4 += 3;
            } else {
                i4 += 2;
            }
        }
        if (i4 > i2) {
            throw new IllegalArgumentException();
        }
        int i6 = (this.f13089b - i) - 2;
        if (i6 >= 0) {
            this.f13088a[i6] = (byte) (i4 >>> 8);
            this.f13088a[i6 + 1] = (byte) i4;
        }
        if ((this.f13089b + i4) - i > this.f13088a.length) {
            m15763d(i4 - i);
        }
        int i7 = this.f13089b;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 >= 1 && charAt2 <= 127) {
                i3 = i7 + 1;
                this.f13088a[i7] = (byte) charAt2;
            } else if (charAt2 > 2047) {
                int i8 = i7 + 1;
                this.f13088a[i7] = (byte) (((charAt2 >> '\f') & 15) | 224);
                int i9 = i8 + 1;
                this.f13088a[i8] = (byte) (((charAt2 >> 6) & 63) | 128);
                i3 = i9 + 1;
                this.f13088a[i9] = (byte) ((charAt2 & '?') | 128);
            } else {
                int i10 = i7 + 1;
                this.f13088a[i7] = (byte) (((charAt2 >> 6) & 31) | 192);
                i3 = i10 + 1;
                this.f13088a[i10] = (byte) ((charAt2 & '?') | 128);
            }
            i++;
            i7 = i3;
        }
        this.f13089b = i7;
        return this;
    }

    /* renamed from: a */
    public C2513e m15769a(byte[] bArr, int i, int i2) {
        if (this.f13089b + i2 > this.f13088a.length) {
            m15763d(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.f13088a, this.f13089b, i2);
        }
        this.f13089b += i2;
        return this;
    }

    /* renamed from: d */
    private void m15763d(int i) {
        int length = this.f13088a.length * 2;
        int i2 = this.f13089b + i;
        if (length <= i2) {
            length = i2;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.f13088a, 0, bArr, 0, this.f13089b);
        this.f13088a = bArr;
    }
}
