package com.p124d.p125a;

/* compiled from: NumberParser.java */
/* renamed from: com.d.a.e */
/* loaded from: classes.dex */
class C1085e {

    /* renamed from: b */
    private static final float[] f6983b = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};

    /* renamed from: c */
    private static final float[] f6984c = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};

    /* renamed from: a */
    private int f6985a;

    C1085e() {
    }

    /* renamed from: a */
    int m9062a() {
        return this.f6985a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0167  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    float m9061a(String str, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        boolean z;
        char charAt2;
        boolean z2 = false;
        long j = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z3 = false;
        int i8 = 0;
        this.f6985a = i;
        if (this.f6985a >= i2) {
            return Float.NaN;
        }
        switch (str.charAt(this.f6985a)) {
            case '+':
                this.f6985a++;
                break;
            case '-':
                z2 = true;
                this.f6985a++;
                break;
        }
        int i9 = this.f6985a;
        while (this.f6985a < i2) {
            char charAt3 = str.charAt(this.f6985a);
            if (charAt3 == '0') {
                if (i5 == 0) {
                    i6++;
                } else {
                    i7++;
                }
            } else if (charAt3 >= '1' && charAt3 <= '9') {
                int i10 = i5 + i7;
                while (i7 > 0) {
                    if (j > 922337203685477580L) {
                        return Float.NaN;
                    }
                    j *= 10;
                    i7--;
                }
                if (j > 922337203685477580L) {
                    return Float.NaN;
                }
                j = (j * 10) + (charAt3 - '0');
                i5 = i10 + 1;
                if (j < 0) {
                    return Float.NaN;
                }
            } else {
                if (charAt3 == '.' && !z3) {
                    i8 = this.f6985a - i9;
                    z3 = true;
                }
                if (!z3 && this.f6985a == i8 + 1) {
                    return Float.NaN;
                }
                if (i5 == 0) {
                    i3 = i5;
                } else {
                    if (i6 == 0) {
                        return Float.NaN;
                    }
                    i3 = 1;
                }
                if (z3) {
                    i7 = (i8 - i6) - i3;
                }
                if (this.f6985a < i2 && ((charAt = str.charAt(this.f6985a)) == 'E' || charAt == 'e')) {
                    boolean z4 = false;
                    boolean z5 = false;
                    this.f6985a++;
                    if (this.f6985a != i2) {
                        return Float.NaN;
                    }
                    switch (str.charAt(this.f6985a)) {
                        case '+':
                            this.f6985a++;
                            z = z4;
                            break;
                        case ',':
                        case '.':
                        case '/':
                        default:
                            z5 = true;
                            this.f6985a--;
                            z = false;
                            break;
                        case '-':
                            z4 = true;
                            this.f6985a++;
                            z = z4;
                            break;
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            z = false;
                            break;
                    }
                    if (!z5) {
                        int i11 = this.f6985a;
                        int i12 = 0;
                        while (this.f6985a < i2 && (charAt2 = str.charAt(this.f6985a)) >= '0' && charAt2 <= '9') {
                            if (i12 > 922337203685477580L) {
                                return Float.NaN;
                            }
                            i12 = (i12 * 10) + (charAt2 - '0');
                            this.f6985a++;
                        }
                        if (this.f6985a == i11) {
                            return Float.NaN;
                        }
                        if (z) {
                            i4 = i7 - i12;
                        } else {
                            i4 = i7 + i12;
                        }
                        if (i4 + i3 <= 39 || i4 + i3 < -44) {
                            return Float.NaN;
                        }
                        float f2 = j;
                        if (j != 0) {
                            if (i4 > 0) {
                                f2 *= f6983b[i4];
                            } else if (i4 < 0) {
                                if (i4 < -38) {
                                    f2 = (float) (f2 * 1.0E-20d);
                                    i4 += 20;
                                }
                                f2 *= f6984c[-i4];
                            }
                        }
                        return z2 ? -f2 : f2;
                    }
                }
                i4 = i7;
                if (i4 + i3 <= 39) {
                }
                return Float.NaN;
            }
            this.f6985a++;
        }
        if (!z3) {
        }
        if (i5 == 0) {
        }
        if (z3) {
        }
        if (this.f6985a < i2) {
            boolean z42 = false;
            boolean z52 = false;
            this.f6985a++;
            if (this.f6985a != i2) {
            }
        }
        i4 = i7;
        if (i4 + i3 <= 39) {
        }
        return Float.NaN;
    }
}
