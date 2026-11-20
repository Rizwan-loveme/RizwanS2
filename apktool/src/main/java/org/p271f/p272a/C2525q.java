package org.p271f.p272a;

/* compiled from: Label.java */
/* renamed from: org.f.a.q */
/* loaded from: classes.dex */
public class C2525q {

    /* renamed from: a */
    public Object f13201a;

    /* renamed from: b */
    int f13202b;

    /* renamed from: c */
    int f13203c;

    /* renamed from: d */
    int f13204d;

    /* renamed from: e */
    int f13205e;

    /* renamed from: f */
    int f13206f;

    /* renamed from: g */
    C2521m f13207g;

    /* renamed from: h */
    C2525q f13208h;

    /* renamed from: i */
    C2518j f13209i;

    /* renamed from: j */
    C2525q f13210j;

    /* renamed from: k */
    private int f13211k;

    /* renamed from: l */
    private int[] f13212l;

    /* renamed from: a */
    void m15865a(C2527s c2527s, C2513e c2513e, int i, boolean z) {
        if ((this.f13202b & 2) == 0) {
            if (z) {
                m15861a((-1) - i, c2513e.f13089b);
                c2513e.m15772c(-1);
                return;
            } else {
                m15861a(i, c2513e.f13089b);
                c2513e.m15770b(-1);
                return;
            }
        }
        if (z) {
            c2513e.m15772c(this.f13204d - i);
        } else {
            c2513e.m15770b(this.f13204d - i);
        }
    }

    /* renamed from: a */
    private void m15861a(int i, int i2) {
        if (this.f13212l == null) {
            this.f13212l = new int[6];
        }
        if (this.f13211k >= this.f13212l.length) {
            int[] iArr = new int[this.f13212l.length + 6];
            System.arraycopy(this.f13212l, 0, iArr, 0, this.f13212l.length);
            this.f13212l = iArr;
        }
        int[] iArr2 = this.f13212l;
        int i3 = this.f13211k;
        this.f13211k = i3 + 1;
        iArr2[i3] = i;
        int[] iArr3 = this.f13212l;
        int i4 = this.f13211k;
        this.f13211k = i4 + 1;
        iArr3[i4] = i2;
    }

    /* renamed from: a */
    boolean m15868a(C2527s c2527s, int i, byte[] bArr) {
        boolean z = false;
        this.f13202b |= 2;
        this.f13204d = i;
        int i2 = 0;
        while (true) {
            boolean z2 = z;
            if (i2 < this.f13211k) {
                int i3 = i2 + 1;
                int i4 = this.f13212l[i2];
                i2 = i3 + 1;
                int i5 = this.f13212l[i3];
                if (i4 >= 0) {
                    int i6 = i - i4;
                    if (i6 < -32768 || i6 > 32767) {
                        int i7 = bArr[i5 - 1] & 255;
                        if (i7 <= 168) {
                            bArr[i5 - 1] = (byte) (i7 + 49);
                        } else {
                            bArr[i5 - 1] = (byte) (i7 + 20);
                        }
                        z2 = true;
                    }
                    bArr[i5] = (byte) (i6 >>> 8);
                    bArr[i5 + 1] = (byte) i6;
                } else {
                    int i8 = i4 + i + 1;
                    int i9 = i5 + 1;
                    bArr[i5] = (byte) (i8 >>> 24);
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) (i8 >>> 16);
                    bArr[i10] = (byte) (i8 >>> 8);
                    bArr[i10 + 1] = (byte) i8;
                }
                z = z2;
            } else {
                return z2;
            }
        }
    }

    /* renamed from: a */
    C2525q m15862a() {
        return this.f13207g == null ? this : this.f13207g.f13174b;
    }

    /* renamed from: a */
    boolean m15866a(long j) {
        return ((this.f13202b & 1024) == 0 || (this.f13212l[(int) (j >>> 32)] & ((int) j)) == 0) ? false : true;
    }

    /* renamed from: a */
    boolean m15867a(C2525q c2525q) {
        if ((this.f13202b & 1024) == 0 || (c2525q.f13202b & 1024) == 0) {
            return false;
        }
        for (int i = 0; i < this.f13212l.length; i++) {
            if ((this.f13212l[i] & c2525q.f13212l[i]) != 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m15863a(long j, int i) {
        if ((this.f13202b & 1024) == 0) {
            this.f13202b |= 1024;
            this.f13212l = new int[(i / 32) + 1];
        }
        int[] iArr = this.f13212l;
        int i2 = (int) (j >>> 32);
        iArr[i2] = iArr[i2] | ((int) j);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m15864a(C2525q c2525q, long j, int i) {
        C2525q c2525q2 = this;
        while (c2525q2 != null) {
            C2525q c2525q3 = c2525q2;
            c2525q2 = c2525q3.f13210j;
            c2525q3.f13210j = null;
            if (c2525q != null) {
                if ((c2525q3.f13202b & 2048) != 0) {
                    continue;
                }
                c2525q3.f13202b |= 2048;
                if ((c2525q3.f13202b & 256) != 0 && !c2525q3.m15867a(c2525q)) {
                    C2518j c2518j2 = new C2518j();
                    c2518j2.f13157a = c2525q3.f13205e;
                    c2518j2.f13158b = c2525q.f13209i.f13158b;
                    c2518j2.f13159c = c2525q3.f13209i;
                    c2525q3.f13209i = c2518j2;
                }
            } else {
                if (c2525q3.m15866a(j)) {
                    continue;
                }
                c2525q3.m15863a(j, i);
            }
            C2518j c2518j = c2525q3.f13209i;
            while (c2518j != null) {
                if (((c2525q3.f13202b & 128) == 0 || c2518j != c2525q3.f13209i.f13159c) && c2518j.f13158b.f13210j == null) {
                    c2518j.f13158b.f13210j = c2525q2;
                    c2525q2 = c2518j.f13158b;
                }
                c2518j = c2518j.f13159c;
            }
        }
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
