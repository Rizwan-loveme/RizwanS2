package org.p226d.p233b.p244d;

import org.p226d.p233b.p244d.C2077a;
import org.p226d.p269d.C2453g;
import org.p226d.p269d.C2465s;

/* compiled from: BaseDexReader.java */
/* renamed from: org.d.b.d.b */
/* loaded from: classes.dex */
public class C2116b<T extends C2077a> {

    /* renamed from: a */
    public final T f11828a;

    /* renamed from: b */
    private int f11829b;

    public C2116b(T t, int i) {
        this.f11828a = t;
        this.f11829b = i;
    }

    /* renamed from: a */
    public int m14635a() {
        return this.f11829b;
    }

    /* renamed from: a */
    public void m14636a(int i) {
        this.f11829b = i;
    }

    /* renamed from: b */
    public int m14637b() {
        int i;
        int i2 = this.f11828a.f11802b + this.f11829b;
        byte[] bArr = this.f11828a.f11801a;
        int i3 = i2 + 1;
        int i4 = bArr[i2] & 255;
        if (i4 <= 127) {
            i = (i4 << 25) >> 25;
        } else {
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            int i7 = (i4 & 127) | ((i6 & 127) << 7);
            if (i6 <= 127) {
                i = (i7 << 18) >> 18;
                i3 = i5;
            } else {
                i3 = i5 + 1;
                int i8 = bArr[i5] & 255;
                int i9 = i7 | ((i8 & 127) << 14);
                if (i8 <= 127) {
                    i = (i9 << 11) >> 11;
                } else {
                    int i10 = i3 + 1;
                    int i11 = bArr[i3] & 255;
                    int i12 = i9 | ((i11 & 127) << 21);
                    if (i11 <= 127) {
                        i = (i12 << 4) >> 4;
                        i3 = i10;
                    } else {
                        i3 = i10 + 1;
                        int i13 = bArr[i10] & 255;
                        if (i13 > 127) {
                            throw new C2453g("Invalid sleb128 integer encountered at offset 0x%x", Integer.valueOf(this.f11829b));
                        }
                        i = i12 | (i13 << 28);
                    }
                }
            }
        }
        this.f11829b = i3 - this.f11828a.f11802b;
        return i;
    }

    /* renamed from: c */
    public int m14639c() {
        return m14634a(false);
    }

    /* renamed from: a */
    private int m14634a(boolean z) {
        int i = this.f11828a.f11802b + this.f11829b;
        byte[] bArr = this.f11828a.f11801a;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        if (i3 > 127) {
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            i3 = (i3 & 127) | ((i5 & 127) << 7);
            if (i5 > 127) {
                i2 = i4 + 1;
                int i6 = bArr[i4] & 255;
                i3 |= (i6 & 127) << 14;
                if (i6 > 127) {
                    i4 = i2 + 1;
                    int i7 = bArr[i2] & 255;
                    i3 |= (i7 & 127) << 21;
                    if (i7 > 127) {
                        i2 = i4 + 1;
                        byte b2 = bArr[i4];
                        if (b2 < 0) {
                            throw new C2453g("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.f11829b));
                        }
                        if ((b2 & 15) > 7 && !z) {
                            throw new C2453g("Encountered valid uleb128 that is out of range at offset 0x%x", Integer.valueOf(this.f11829b));
                        }
                        i3 |= b2 << 28;
                    }
                }
            }
            i2 = i4;
        }
        this.f11829b = i2 - this.f11828a.f11802b;
        return i3;
    }

    /* renamed from: d */
    public int m14641d() {
        return m14634a(true);
    }

    /* renamed from: e */
    public int m14643e() {
        int i = this.f11828a.f11802b + this.f11829b;
        byte[] bArr = this.f11828a.f11801a;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        if (i3 > 127) {
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            i3 = (i3 & 127) | ((i5 & 127) << 7);
            if (i5 > 127) {
                i2 = i4 + 1;
                int i6 = bArr[i4] & 255;
                i3 |= (i6 & 127) << 14;
                if (i6 > 127) {
                    i4 = i2 + 1;
                    int i7 = bArr[i2] & 255;
                    i3 |= (i7 & 127) << 21;
                    if (i7 > 127) {
                        i2 = i4 + 1;
                        byte b2 = bArr[i4];
                        if (b2 < 0) {
                            throw new C2453g("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.f11829b));
                        }
                        i3 |= b2 << 28;
                    }
                }
            }
            i2 = i4;
        }
        this.f11829b = i2 - this.f11828a.f11802b;
        return i3;
    }

    /* renamed from: f */
    public void m14646f() {
        int i = this.f11829b + this.f11828a.f11802b;
        byte[] bArr = this.f11828a.f11801a;
        int i2 = i + 1;
        if (bArr[i] < 0) {
            int i3 = i2 + 1;
            if (bArr[i2] < 0) {
                i2 = i3 + 1;
                if (bArr[i3] < 0) {
                    i3 = i2 + 1;
                    if (bArr[i2] < 0) {
                        i2 = i3 + 1;
                        if (bArr[i3] < 0) {
                            throw new C2453g("Invalid uleb128 integer encountered at offset 0x%x", Integer.valueOf(this.f11829b));
                        }
                    }
                }
            }
            i2 = i3;
        }
        this.f11829b = i2 - this.f11828a.f11802b;
    }

    /* renamed from: g */
    public int m14647g() {
        return this.f11828a.m14617c(this.f11829b);
    }

    /* renamed from: h */
    public int m14649h() {
        return this.f11828a.m14618d(this.f11829b);
    }

    /* renamed from: i */
    public int m14651i() {
        int i = this.f11829b;
        int m14618d = this.f11828a.m14618d(this.f11829b);
        this.f11829b = i + 1;
        return m14618d;
    }

    /* renamed from: j */
    public int m14652j() {
        int i = this.f11829b;
        int m14621g = this.f11828a.m14621g(this.f11829b);
        this.f11829b = i + 4;
        return m14621g;
    }

    /* renamed from: k */
    public int m14653k() {
        int i = this.f11829b;
        int m14623i = this.f11828a.m14623i(this.f11829b);
        this.f11829b = i + 1;
        return m14623i;
    }

    /* renamed from: l */
    public void m14654l() {
        this.f11829b++;
    }

    /* renamed from: b */
    public void m14638b(int i) {
        this.f11829b += i;
    }

    /* renamed from: c */
    public int m14640c(int i) {
        int i2;
        int i3 = this.f11829b + this.f11828a.f11802b;
        byte[] bArr = this.f11828a.f11801a;
        switch (i) {
            case 1:
                i2 = bArr[i3];
                break;
            case 2:
                i2 = (bArr[i3 + 1] << 8) | (bArr[i3] & 255);
                break;
            case 3:
                i2 = (bArr[i3 + 2] << 16) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8);
                break;
            case 4:
                i2 = (bArr[i3 + 3] << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
                break;
            default:
                throw new C2453g("Invalid size %d for sized int at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.f11829b));
        }
        this.f11829b = (i3 + i) - this.f11828a.f11802b;
        return i2;
    }

    /* renamed from: d */
    public int m14642d(int i) {
        int i2 = 0;
        int i3 = this.f11828a.f11802b + this.f11829b;
        byte[] bArr = this.f11828a.f11801a;
        switch (i) {
            case 4:
                byte b2 = bArr[i3 + 3];
                if (b2 < 0) {
                    throw new C2453g("Encountered valid sized uint that is out of range at offset 0x%x", Integer.valueOf(this.f11829b));
                }
                i2 = b2 << 24;
            case 3:
                i2 |= (bArr[i3 + 2] & 255) << 16;
            case 2:
                i2 |= (bArr[i3 + 1] & 255) << 8;
            case 1:
                int i4 = i2 | (bArr[i3] & 255);
                this.f11829b = (i3 + i) - this.f11828a.f11802b;
                return i4;
            default:
                throw new C2453g("Invalid size %d for sized uint at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.f11829b));
        }
    }

    /* renamed from: e */
    public int m14644e(int i) {
        int i2;
        int i3 = this.f11829b + this.f11828a.f11802b;
        byte[] bArr = this.f11828a.f11801a;
        switch (i) {
            case 1:
                i2 = bArr[i3] << 24;
                break;
            case 2:
                i2 = (bArr[i3 + 1] << 24) | ((bArr[i3] & 255) << 16);
                break;
            case 3:
                i2 = (bArr[i3 + 2] << 24) | ((bArr[i3] & 255) << 8) | ((bArr[i3 + 1] & 255) << 16);
                break;
            case 4:
                i2 = (bArr[i3 + 3] << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
                break;
            default:
                throw new C2453g("Invalid size %d for sized, right extended int at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.f11829b));
        }
        this.f11829b = (i3 + i) - this.f11828a.f11802b;
        return i2;
    }

    /* renamed from: f */
    public long m14645f(int i) {
        long j;
        int i2 = this.f11828a.f11802b + this.f11829b;
        byte[] bArr = this.f11828a.f11801a;
        switch (i) {
            case 1:
                j = bArr[i2] << 56;
                break;
            case 2:
                j = (bArr[i2 + 1] << 56) | ((bArr[i2] & 255) << 48);
                break;
            case 3:
                j = (bArr[i2 + 2] << 56) | ((bArr[i2] & 255) << 40) | ((bArr[i2 + 1] & 255) << 48);
                break;
            case 4:
                j = (bArr[i2 + 3] << 56) | ((bArr[i2] & 255) << 32) | ((bArr[i2 + 1] & 255) << 40) | ((bArr[i2 + 2] & 255) << 48);
                break;
            case 5:
                j = (bArr[i2 + 4] << 56) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 32) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 3] & 255) << 48);
                break;
            case 6:
                j = (bArr[i2 + 5] << 56) | ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 24) | ((bArr[i2 + 2] & 255) << 32) | ((bArr[i2 + 3] & 255) << 40) | ((bArr[i2 + 4] & 255) << 48);
                break;
            case 7:
                j = (bArr[i2 + 6] << 56) | ((bArr[i2] & 255) << 8) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 24) | ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2 + 4] & 255) << 40) | ((bArr[i2 + 5] & 255) << 48);
                break;
            case 8:
                j = (bArr[i2 + 7] << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
                break;
            default:
                throw new C2453g("Invalid size %d for sized, right extended long at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.f11829b));
        }
        this.f11829b = (i2 + i) - this.f11828a.f11802b;
        return j;
    }

    /* renamed from: g */
    public long m14648g(int i) {
        long j;
        int i2 = this.f11828a.f11802b + this.f11829b;
        byte[] bArr = this.f11828a.f11801a;
        switch (i) {
            case 1:
                j = bArr[i2];
                break;
            case 2:
                j = (bArr[i2 + 1] << 8) | (bArr[i2] & 255);
                break;
            case 3:
                j = (bArr[i2 + 2] << 16) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
                break;
            case 4:
                j = (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
                break;
            case 5:
                j = (bArr[i2 + 4] << 32) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24);
                break;
            case 6:
                j = (bArr[i2 + 5] << 40) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32);
                break;
            case 7:
                j = (bArr[i2 + 6] << 48) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40);
                break;
            case 8:
                j = (bArr[i2 + 7] << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
                break;
            default:
                throw new C2453g("Invalid size %d for sized long at offset 0x%x", Integer.valueOf(i), Integer.valueOf(this.f11829b));
        }
        this.f11829b = (i2 + i) - this.f11828a.f11802b;
        return j;
    }

    /* renamed from: h */
    public String m14650h(int i) {
        int[] iArr = new int[1];
        String m15563a = C2465s.m15563a(this.f11828a.f11801a, this.f11828a.f11802b + this.f11829b, i, iArr);
        this.f11829b = iArr[0] + this.f11829b;
        return m15563a;
    }
}
