package ru.maximoff.apktool.view;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.util.Vector;

/* compiled from: GifDecoder.java */
/* renamed from: ru.maximoff.apktool.view.f */
/* loaded from: classes.dex */
public class C3304f {

    /* renamed from: A */
    protected Bitmap f20990A;

    /* renamed from: H */
    protected int f20997H;

    /* renamed from: I */
    protected short[] f20998I;

    /* renamed from: J */
    protected byte[] f20999J;

    /* renamed from: K */
    protected byte[] f21000K;

    /* renamed from: L */
    protected byte[] f21001L;

    /* renamed from: M */
    protected Vector<a> f21002M;

    /* renamed from: N */
    protected int f21003N;

    /* renamed from: a */
    protected InputStream f21004a;

    /* renamed from: b */
    protected int f21005b;

    /* renamed from: c */
    protected int f21006c;

    /* renamed from: d */
    protected int f21007d;

    /* renamed from: e */
    protected boolean f21008e;

    /* renamed from: f */
    protected int f21009f;

    /* renamed from: h */
    protected int[] f21011h;

    /* renamed from: i */
    protected int[] f21012i;

    /* renamed from: j */
    protected int[] f21013j;

    /* renamed from: k */
    protected int f21014k;

    /* renamed from: l */
    protected int f21015l;

    /* renamed from: m */
    protected int f21016m;

    /* renamed from: n */
    protected int f21017n;

    /* renamed from: o */
    protected boolean f21018o;

    /* renamed from: p */
    protected boolean f21019p;

    /* renamed from: q */
    protected int f21020q;

    /* renamed from: r */
    protected int f21021r;

    /* renamed from: s */
    protected int f21022s;

    /* renamed from: t */
    protected int f21023t;

    /* renamed from: u */
    protected int f21024u;

    /* renamed from: v */
    protected int f21025v;

    /* renamed from: w */
    protected int f21026w;

    /* renamed from: x */
    protected int f21027x;

    /* renamed from: y */
    protected int f21028y;

    /* renamed from: z */
    protected Bitmap f21029z;

    /* renamed from: g */
    protected int f21010g = 1;

    /* renamed from: B */
    protected byte[] f20991B = new byte[256];

    /* renamed from: C */
    protected int f20992C = 0;

    /* renamed from: D */
    protected int f20993D = 0;

    /* renamed from: E */
    protected int f20994E = 0;

    /* renamed from: F */
    protected boolean f20995F = false;

    /* renamed from: G */
    protected int f20996G = 0;

    /* compiled from: GifDecoder.java */
    /* renamed from: ru.maximoff.apktool.view.f$a */
    private static class a {

        /* renamed from: a */
        public Bitmap f21030a;

        /* renamed from: b */
        public int f21031b;

        public a(Bitmap bitmap, int i) {
            this.f21030a = bitmap;
            this.f21031b = i;
        }
    }

    /* renamed from: a */
    public int m19865a(int i) {
        this.f20996G = -1;
        if (i >= 0 && i < this.f21003N) {
            this.f20996G = this.f21002M.elementAt(i).f21031b;
        }
        return this.f20996G;
    }

    /* renamed from: a */
    public int m19864a() {
        return this.f21003N;
    }

    /* renamed from: b */
    public int m19867b() {
        return this.f21010g;
    }

    /* renamed from: c */
    protected void m19869c() {
        int i;
        int[] iArr = new int[this.f21006c * this.f21007d];
        if (this.f20994E > 0) {
            if (this.f20994E == 3) {
                int i2 = this.f21003N - 2;
                if (i2 > 0) {
                    this.f20990A = m19868b(i2 - 1);
                } else {
                    this.f20990A = (Bitmap) null;
                }
            }
            if (this.f20990A != null) {
                this.f20990A.getPixels(iArr, 0, this.f21006c, 0, 0, this.f21006c, this.f21007d);
                if (this.f20994E == 2) {
                    int i3 = !this.f20995F ? this.f21016m : 0;
                    for (int i4 = 0; i4 < this.f21028y; i4++) {
                        int i5 = ((this.f21026w + i4) * this.f21006c) + this.f21025v;
                        int i6 = this.f21027x + i5;
                        while (i5 < i6) {
                            iArr[i5] = i3;
                            i5++;
                        }
                    }
                }
            }
        }
        int i7 = 8;
        int i8 = 0;
        int i9 = 1;
        for (int i10 = 0; i10 < this.f21024u; i10++) {
            if (this.f21019p) {
                if (i8 >= this.f21024u) {
                    i9++;
                    switch (i9) {
                        case 2:
                            i = 4;
                            break;
                        case 3:
                            i = 2;
                            i7 = 4;
                            break;
                        case 4:
                            i = 1;
                            i7 = 2;
                            break;
                        default:
                            i = i8;
                            break;
                    }
                } else {
                    i = i8;
                }
                i8 = i + i7;
            } else {
                i = i10;
            }
            int i11 = i + this.f21022s;
            if (i11 < this.f21007d) {
                int i12 = this.f21006c * i11;
                int i13 = i12 + this.f21021r;
                int i14 = this.f21023t + i13;
                if (this.f21006c + i12 < i14) {
                    i14 = this.f21006c + i12;
                }
                int i15 = this.f21023t * i10;
                int i16 = i13;
                while (i16 < i14) {
                    int i17 = i15 + 1;
                    int i18 = this.f21013j[this.f21001L[i15] & 255];
                    if (i18 != 0) {
                        iArr[i16] = i18;
                    }
                    i16++;
                    i15 = i17;
                }
            }
        }
        this.f21029z = Bitmap.createBitmap(iArr, this.f21006c, this.f21007d, Bitmap.Config.ARGB_4444);
    }

    /* renamed from: b */
    public Bitmap m19868b(int i) {
        if (this.f21003N <= 0) {
            return (Bitmap) null;
        }
        return this.f21002M.elementAt(i % this.f21003N).f21030a;
    }

    /* renamed from: a */
    public int m19866a(InputStream inputStream) {
        m19873f();
        if (inputStream != null) {
            this.f21004a = inputStream;
            m19878k();
            if (!m19872e()) {
                m19876i();
                if (this.f21003N < 0) {
                    this.f21005b = 1;
                }
            }
        } else {
            this.f21005b = 2;
        }
        try {
            inputStream.close();
        } catch (Exception e2) {
        }
        return this.f21005b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [short] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: d */
    protected void m19871d() {
        int i;
        int i2;
        int i3;
        int i4;
        short s;
        int i5;
        int i6;
        int i7 = this.f21023t * this.f21024u;
        if (this.f21001L == null || this.f21001L.length < i7) {
            this.f21001L = new byte[i7];
        }
        if (this.f20998I == null) {
            this.f20998I = new short[4096];
        }
        if (this.f20999J == null) {
            this.f20999J = new byte[4096];
        }
        if (this.f21000K == null) {
            this.f21000K = new byte[4097];
        }
        int m19874g = m19874g();
        int i8 = 1 << m19874g;
        int i9 = i8 + 1;
        int i10 = i8 + 2;
        int i11 = m19874g + 1;
        int i12 = (1 << i11) - 1;
        for (int i13 = 0; i13 < i8; i13++) {
            this.f20998I[i13] = (short) 0;
            this.f20999J[i13] = (byte) i13;
        }
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (i19 < i7) {
            if (i16 != 0) {
                i = i16;
                i2 = i18;
                i3 = i22;
            } else if (i21 < i11) {
                if (i20 == 0) {
                    i20 = m19875h();
                    if (i20 <= 0) {
                        break;
                    } else {
                        i15 = 0;
                    }
                }
                int i23 = i18 + ((this.f20991B[i15] & 255) << i21);
                i21 += 8;
                i15++;
                i20--;
                i18 = i23;
            } else {
                i3 = i18 & i12;
                i2 = i18 >> i11;
                i21 -= i11;
                if (i3 > i10 || i3 == i9) {
                    break;
                }
                if (i3 == i8) {
                    i11 = m19874g + 1;
                    i12 = (1 << i11) - 1;
                    i10 = i8 + 2;
                    i18 = i2;
                    i22 = -1;
                } else if (i22 == -1) {
                    this.f21000K[i16] = this.f20999J[i3];
                    i16++;
                    i17 = i3;
                    i18 = i2;
                    i22 = i3;
                } else {
                    if (i3 == i10) {
                        i4 = i16 + 1;
                        this.f21000K[i16] = (byte) i17;
                        s = i22;
                    } else {
                        i4 = i16;
                        s = i3;
                    }
                    while (s > i8) {
                        this.f21000K[i4] = this.f20999J[s];
                        s = this.f20998I[s];
                        i4++;
                    }
                    i17 = this.f20999J[s] & 255;
                    if (i10 >= 4096) {
                        break;
                    }
                    i = i4 + 1;
                    this.f21000K[i4] = (byte) i17;
                    this.f20998I[i10] = (short) i22;
                    this.f20999J[i10] = (byte) i17;
                    int i24 = i10 + 1;
                    if ((i24 & i12) != 0 || i24 >= 4096) {
                        i5 = i11;
                        i6 = i12;
                    } else {
                        i5 = i11 + 1;
                        i6 = i12 + i24;
                    }
                    i11 = i5;
                    i12 = i6;
                    i10 = i24;
                }
            }
            i16 = i - 1;
            this.f21001L[i14] = this.f21000K[i16];
            i19++;
            i14++;
            i18 = i2;
            i22 = i3;
        }
        for (int i25 = i14; i25 < i7; i25++) {
            this.f21001L[i25] = (byte) 0;
        }
    }

    /* renamed from: e */
    protected boolean m19872e() {
        return this.f21005b != 0;
    }

    /* renamed from: f */
    protected void m19873f() {
        this.f21005b = 0;
        this.f21003N = 0;
        this.f21002M = new Vector<>();
        this.f21011h = (int[]) null;
        this.f21012i = (int[]) null;
    }

    /* renamed from: g */
    protected int m19874g() {
        try {
            return this.f21004a.read();
        } catch (Exception e2) {
            this.f21005b = 1;
            return 0;
        }
    }

    /* renamed from: h */
    protected int m19875h() {
        this.f20992C = m19874g();
        int i = 0;
        if (this.f20992C > 0) {
            while (i < this.f20992C) {
                try {
                    int read = this.f21004a.read(this.f20991B, i, this.f20992C - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (i < this.f20992C) {
                this.f21005b = 1;
            }
        }
        return i;
    }

    /* renamed from: c */
    protected int[] m19870c(int i) {
        int i2;
        int i3 = i * 3;
        int[] iArr = (int[]) null;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.f21004a.read(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.f21005b = 1;
        } else {
            iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                i4 = i7 + 1;
                iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            }
        }
        return iArr;
    }

    /* renamed from: i */
    protected void m19876i() {
        boolean z = false;
        while (!z && !m19872e()) {
            switch (m19874g()) {
                case 33:
                    switch (m19874g()) {
                        case 1:
                            m19884q();
                            break;
                        case 249:
                            m19877j();
                            break;
                        case 254:
                            m19884q();
                            break;
                        case 255:
                            m19875h();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = new StringBuffer().append(str).append((char) this.f20991B[i]).toString();
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                m19881n();
                                break;
                            } else {
                                m19884q();
                                break;
                            }
                        default:
                            m19884q();
                            break;
                    }
                case 44:
                    m19879l();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.f21005b = 1;
                    break;
            }
        }
    }

    /* renamed from: j */
    protected void m19877j() {
        m19874g();
        int m19874g = m19874g();
        this.f20993D = (m19874g & 28) >> 2;
        if (this.f20993D == 0) {
            this.f20993D = 1;
        }
        this.f20995F = (m19874g & 1) != 0;
        this.f20996G = m19882o() * 10;
        this.f20997H = m19874g();
        m19874g();
    }

    /* renamed from: k */
    protected void m19878k() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = new StringBuffer().append(str).append((char) m19874g()).toString();
        }
        if (!str.startsWith("GIF")) {
            this.f21005b = 1;
            return;
        }
        m19880m();
        if (this.f21008e && !m19872e()) {
            this.f21011h = m19870c(this.f21009f);
            this.f21015l = this.f21011h[this.f21014k];
        }
    }

    /* renamed from: l */
    protected void m19879l() {
        int i = 0;
        this.f21021r = m19882o();
        this.f21022s = m19882o();
        this.f21023t = m19882o();
        this.f21024u = m19882o();
        int m19874g = m19874g();
        this.f21018o = (m19874g & 128) != 0;
        this.f21020q = (int) Math.pow(2, (m19874g & 7) + 1);
        this.f21019p = (m19874g & 64) != 0;
        if (this.f21018o) {
            this.f21012i = m19870c(this.f21020q);
            this.f21013j = this.f21012i;
        } else {
            this.f21013j = this.f21011h;
            if (this.f21014k == this.f20997H) {
                this.f21015l = 0;
            }
        }
        if (this.f20995F) {
            int i2 = this.f21013j[this.f20997H];
            this.f21013j[this.f20997H] = 0;
            i = i2;
        }
        if (this.f21013j == null) {
            this.f21005b = 1;
        }
        if (!m19872e()) {
            m19871d();
            m19884q();
            if (!m19872e()) {
                this.f21003N++;
                this.f21029z = Bitmap.createBitmap(this.f21006c, this.f21007d, Bitmap.Config.ARGB_4444);
                m19869c();
                this.f21002M.addElement(new a(this.f21029z, this.f20996G));
                if (this.f20995F) {
                    this.f21013j[this.f20997H] = i;
                }
                m19883p();
            }
        }
    }

    /* renamed from: m */
    protected void m19880m() {
        this.f21006c = m19882o();
        this.f21007d = m19882o();
        int m19874g = m19874g();
        this.f21008e = (m19874g & 128) != 0;
        this.f21009f = 2 << (m19874g & 7);
        this.f21014k = m19874g();
        this.f21017n = m19874g();
    }

    /* renamed from: n */
    protected void m19881n() {
        do {
            m19875h();
            if (this.f20991B[0] == 1) {
                this.f21010g = (this.f20991B[1] & 255) | ((this.f20991B[2] & 255) << 8);
            }
            if (this.f20992C <= 0) {
                return;
            }
        } while (!m19872e());
    }

    /* renamed from: o */
    protected int m19882o() {
        return m19874g() | (m19874g() << 8);
    }

    /* renamed from: p */
    protected void m19883p() {
        this.f20994E = this.f20993D;
        this.f21025v = this.f21021r;
        this.f21026w = this.f21022s;
        this.f21027x = this.f21023t;
        this.f21028y = this.f21024u;
        this.f20990A = this.f21029z;
        this.f21016m = this.f21015l;
        this.f20993D = 0;
        this.f20995F = false;
        this.f20996G = 0;
        this.f21012i = (int[]) null;
    }

    /* renamed from: q */
    protected void m19884q() {
        do {
            m19875h();
            if (this.f20992C <= 0) {
                return;
            }
        } while (!m19872e());
    }
}
