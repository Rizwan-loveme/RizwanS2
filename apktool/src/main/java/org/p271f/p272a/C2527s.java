package org.p271f.p272a;

/* compiled from: MethodWriter.java */
/* renamed from: org.f.a.s */
/* loaded from: classes.dex */
class C2527s extends AbstractC2526r {

    /* renamed from: A */
    private C2513e f13215A;

    /* renamed from: B */
    private int f13216B;

    /* renamed from: C */
    private int[] f13217C;

    /* renamed from: D */
    private int[] f13218D;

    /* renamed from: E */
    private int f13219E;

    /* renamed from: F */
    private C2523o f13220F;

    /* renamed from: G */
    private C2523o f13221G;

    /* renamed from: H */
    private int f13222H;

    /* renamed from: I */
    private C2513e f13223I;

    /* renamed from: J */
    private int f13224J;

    /* renamed from: K */
    private C2513e f13225K;

    /* renamed from: L */
    private int f13226L;

    /* renamed from: M */
    private C2513e f13227M;

    /* renamed from: N */
    private int f13228N;

    /* renamed from: O */
    private C2513e f13229O;

    /* renamed from: P */
    private int f13230P;

    /* renamed from: Q */
    private C2481b f13231Q;

    /* renamed from: R */
    private C2481b f13232R;

    /* renamed from: S */
    private C2512d f13233S;

    /* renamed from: T */
    private boolean f13234T;

    /* renamed from: U */
    private int f13235U;

    /* renamed from: V */
    private final int f13236V;

    /* renamed from: W */
    private C2525q f13237W;

    /* renamed from: X */
    private C2525q f13238X;

    /* renamed from: Y */
    private C2525q f13239Y;

    /* renamed from: Z */
    private int f13240Z;

    /* renamed from: aa */
    private int f13241aa;

    /* renamed from: c */
    final C2516h f13242c;

    /* renamed from: d */
    String f13243d;

    /* renamed from: e */
    int f13244e;

    /* renamed from: f */
    int f13245f;

    /* renamed from: g */
    int f13246g;

    /* renamed from: h */
    int[] f13247h;

    /* renamed from: i */
    private int f13248i;

    /* renamed from: j */
    private final int f13249j;

    /* renamed from: k */
    private final int f13250k;

    /* renamed from: l */
    private final String f13251l;

    /* renamed from: m */
    private C2513e f13252m;

    /* renamed from: n */
    private C2481b f13253n;

    /* renamed from: o */
    private C2481b f13254o;

    /* renamed from: p */
    private C2481b f13255p;

    /* renamed from: q */
    private C2481b f13256q;

    /* renamed from: r */
    private C2481b[] f13257r;

    /* renamed from: s */
    private C2481b[] f13258s;

    /* renamed from: t */
    private int f13259t;

    /* renamed from: u */
    private C2512d f13260u;

    /* renamed from: v */
    private C2513e f13261v;

    /* renamed from: w */
    private int f13262w;

    /* renamed from: x */
    private int f13263x;

    /* renamed from: y */
    private int f13264y;

    /* renamed from: z */
    private int f13265z;

    C2527s(C2516h c2516h, int i, String str, String str2, String str3, String[] strArr, boolean z, boolean z2) {
        super(327680);
        this.f13261v = new C2513e();
        if (c2516h.f13130t == null) {
            c2516h.f13130t = this;
        } else {
            c2516h.f13131u.f13214c_ = this;
        }
        c2516h.f13131u = this;
        this.f13242c = c2516h;
        this.f13248i = i;
        if ("<init>".equals(str)) {
            this.f13248i |= 524288;
        }
        this.f13249j = c2516h.m15807a(str);
        this.f13250k = c2516h.m15807a(str2);
        this.f13251l = str2;
        this.f13243d = str3;
        if (strArr != null && strArr.length > 0) {
            this.f13246g = strArr.length;
            this.f13247h = new int[this.f13246g];
            for (int i2 = 0; i2 < this.f13246g; i2++) {
                this.f13247h[i2] = c2516h.m15824c(strArr[i2]);
            }
        }
        this.f13236V = z2 ? 0 : z ? 1 : 2;
        if (z || z2) {
            int m15895f = C2529u.m15895f(this.f13251l) >> 2;
            m15895f = (i & 8) != 0 ? m15895f - 1 : m15895f;
            this.f13263x = m15895f;
            this.f13264y = m15895f;
            this.f13237W = new C2525q();
            this.f13237W.f13202b |= 8;
            mo15747a(this.f13237W);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15744a(String str, int i) {
        if (this.f13223I == null) {
            this.f13223I = new C2513e();
        }
        this.f13222H++;
        this.f13223I.m15770b(str == null ? 0 : this.f13242c.m15807a(str)).m15770b(i);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15676a() {
        this.f13252m = new C2513e();
        return new C2481b(this.f13242c, false, this.f13252m, null, 0);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15679a(String str, boolean z) {
        C2513e c2513e = new C2513e();
        c2513e.m15770b(this.f13242c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13242c, true, c2513e, c2513e, 2);
        if (z) {
            c2481b.f12980c = this.f13253n;
            this.f13253n = c2481b;
        } else {
            c2481b.f12980c = this.f13254o;
            this.f13254o = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15678a(int i, C2530v c2530v, String str, boolean z) {
        C2513e c2513e = new C2513e();
        C2481b.m15705a(i, c2530v, c2513e);
        c2513e.m15770b(this.f13242c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13242c, true, c2513e, c2513e, c2513e.f13089b - 2);
        if (z) {
            c2481b.f12980c = this.f13255p;
            this.f13255p = c2481b;
        } else {
            c2481b.f12980c = this.f13256q;
            this.f13256q = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15677a(int i, String str, boolean z) {
        C2513e c2513e = new C2513e();
        if ("Ljava/lang/Synthetic;".equals(str)) {
            this.f13259t = Math.max(this.f13259t, i + 1);
            return new C2481b(this.f13242c, false, c2513e, null, 0);
        }
        c2513e.m15770b(this.f13242c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13242c, true, c2513e, c2513e, 2);
        if (z) {
            if (this.f13257r == null) {
                this.f13257r = new C2481b[C2529u.m15893d(this.f13251l).length];
            }
            c2481b.f12980c = this.f13257r[i];
            this.f13257r[i] = c2481b;
            return c2481b;
        }
        if (this.f13258s == null) {
            this.f13258s = new C2481b[C2529u.m15893d(this.f13251l).length];
        }
        c2481b.f12980c = this.f13258s[i];
        this.f13258s[i] = c2481b;
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15745a(C2512d c2512d) {
        if (c2512d.m15759a()) {
            c2512d.f13087c = this.f13233S;
            this.f13233S = c2512d;
        } else {
            c2512d.f13087c = this.f13260u;
            this.f13260u = c2512d;
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15751b() {
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15644a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (this.f13236V != 0) {
            if (i == -1) {
                if (this.f13217C == null) {
                    m15882f();
                }
                this.f13264y = i2;
                int m15869a = m15869a(this.f13261v.f13089b, i2, i3);
                int i8 = 0;
                while (i8 < i2) {
                    if (objArr[i8] instanceof String) {
                        i6 = m15869a + 1;
                        this.f13218D[m15869a] = this.f13242c.m15829e((String) objArr[i8]) | 24117248;
                    } else if (objArr[i8] instanceof Integer) {
                        i6 = m15869a + 1;
                        this.f13218D[m15869a] = ((Integer) objArr[i8]).intValue();
                    } else {
                        i6 = m15869a + 1;
                        this.f13218D[m15869a] = this.f13242c.m15808a("", ((C2525q) objArr[i8]).f13204d) | 25165824;
                    }
                    i8++;
                    m15869a = i6;
                }
                while (i7 < i3) {
                    if (objArr2[i7] instanceof String) {
                        i5 = m15869a + 1;
                        this.f13218D[m15869a] = this.f13242c.m15829e((String) objArr2[i7]) | 24117248;
                    } else if (objArr2[i7] instanceof Integer) {
                        i5 = m15869a + 1;
                        this.f13218D[m15869a] = ((Integer) objArr2[i7]).intValue();
                    } else {
                        i5 = m15869a + 1;
                        this.f13218D[m15869a] = this.f13242c.m15808a("", ((C2525q) objArr2[i7]).f13204d) | 25165824;
                    }
                    i7++;
                    m15869a = i5;
                }
                m15883g();
            } else {
                if (this.f13215A == null) {
                    this.f13215A = new C2513e();
                    i4 = this.f13261v.f13089b;
                } else {
                    i4 = (this.f13261v.f13089b - this.f13216B) - 1;
                    if (i4 < 0) {
                        if (i != 3) {
                            throw new IllegalStateException();
                        }
                        return;
                    }
                }
                switch (i) {
                    case 0:
                        this.f13264y = i2;
                        this.f13215A.m15764a(255).m15770b(i4).m15770b(i2);
                        for (int i9 = 0; i9 < i2; i9++) {
                            m15877b(objArr[i9]);
                        }
                        this.f13215A.m15770b(i3);
                        while (i7 < i3) {
                            m15877b(objArr2[i7]);
                            i7++;
                        }
                        break;
                    case 1:
                        this.f13264y += i2;
                        this.f13215A.m15764a(i2 + 251).m15770b(i4);
                        for (int i10 = 0; i10 < i2; i10++) {
                            m15877b(objArr[i10]);
                        }
                        break;
                    case 2:
                        this.f13264y -= i2;
                        this.f13215A.m15764a(251 - i2).m15770b(i4);
                        break;
                    case 3:
                        if (i4 < 64) {
                            this.f13215A.m15764a(i4);
                            break;
                        } else {
                            this.f13215A.m15764a(251).m15770b(i4);
                            break;
                        }
                    case 4:
                        if (i4 < 64) {
                            this.f13215A.m15764a(i4 + 64);
                        } else {
                            this.f13215A.m15764a(247).m15770b(i4);
                        }
                        m15877b(objArr2[0]);
                        break;
                }
                this.f13216B = this.f13261v.f13089b;
                this.f13265z++;
            }
            this.f13262w = Math.max(this.f13262w, i3);
            this.f13263x = Math.max(this.f13263x, this.f13264y);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15740a(int i) {
        this.f13230P = this.f13261v.f13089b;
        this.f13261v.m15764a(i);
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, 0, (C2516h) null, (C2524p) null);
            } else {
                int i2 = this.f13240Z + C2521m.f13173a[i];
                if (i2 > this.f13241aa) {
                    this.f13241aa = i2;
                }
                this.f13240Z = i2;
            }
            if ((i >= 172 && i <= 177) || i == 191) {
                m15880e();
            }
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15741a(int i, int i2) {
        this.f13230P = this.f13261v.f13089b;
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, i2, (C2516h) null, (C2524p) null);
            } else if (i != 188) {
                int i3 = this.f13240Z + 1;
                if (i3 > this.f13241aa) {
                    this.f13241aa = i3;
                }
                this.f13240Z = i3;
            }
        }
        if (i == 17) {
            this.f13261v.m15771b(i, i2);
        } else {
            this.f13261v.m15765a(i, i2);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15648b(int i, int i2) {
        int i3;
        int i4;
        this.f13230P = this.f13261v.f13089b;
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, i2, (C2516h) null, (C2524p) null);
            } else if (i == 169) {
                this.f13239Y.f13202b |= 256;
                this.f13239Y.f13205e = this.f13240Z;
                m15880e();
            } else {
                int i5 = this.f13240Z + C2521m.f13173a[i];
                if (i5 > this.f13241aa) {
                    this.f13241aa = i5;
                }
                this.f13240Z = i5;
            }
        }
        if (this.f13236V != 2) {
            if (i == 22 || i == 24 || i == 55 || i == 57) {
                i4 = i2 + 2;
            } else {
                i4 = i2 + 1;
            }
            if (i4 > this.f13263x) {
                this.f13263x = i4;
            }
        }
        if (i2 < 4 && i != 169) {
            if (i < 54) {
                i3 = ((i - 21) << 2) + 26 + i2;
            } else {
                i3 = ((i - 54) << 2) + 59 + i2;
            }
            this.f13261v.m15764a(i3);
        } else if (i2 >= 256) {
            this.f13261v.m15764a(196).m15771b(i, i2);
        } else {
            this.f13261v.m15765a(i, i2);
        }
        if (i >= 54 && this.f13236V == 0 && this.f13219E > 0) {
            mo15747a(new C2525q());
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15680a(int i, String str) {
        this.f13230P = this.f13261v.f13089b;
        C2524p m15821b = this.f13242c.m15821b(str);
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, this.f13261v.f13089b, this.f13242c, m15821b);
            } else if (i == 187) {
                int i2 = this.f13240Z + 1;
                if (i2 > this.f13241aa) {
                    this.f13241aa = i2;
                }
                this.f13240Z = i2;
            }
        }
        this.f13261v.m15771b(i, m15821b.f13192a);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15681a(int i, String str, String str2, String str3) {
        int i2;
        this.f13230P = this.f13261v.f13089b;
        C2524p m15822b = this.f13242c.m15822b(str, str2, str3);
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, 0, this.f13242c, m15822b);
            } else {
                char charAt = str3.charAt(0);
                switch (i) {
                    case 178:
                        i2 = ((charAt == 'D' || charAt == 'J') ? 2 : 1) + this.f13240Z;
                        break;
                    case 179:
                        i2 = ((charAt == 'D' || charAt == 'J') ? -2 : -1) + this.f13240Z;
                        break;
                    case 180:
                        int i3 = this.f13240Z;
                        if (charAt != 'D' && charAt != 'J') {
                            r0 = 0;
                        }
                        i2 = r0 + i3;
                        break;
                    default:
                        i2 = this.f13240Z + ((charAt == 'D' || charAt == 'J') ? -3 : -2);
                        break;
                }
                if (i2 > this.f13241aa) {
                    this.f13241aa = i2;
                }
                this.f13240Z = i2;
            }
        }
        this.f13261v.m15771b(i, m15822b.f13192a);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15682a(int i, String str, String str2, String str3, boolean z) {
        int i2;
        int i3;
        this.f13230P = this.f13261v.f13089b;
        C2524p m15815a = this.f13242c.m15815a(str, str2, str3, z);
        int i4 = m15815a.f13194c;
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, 0, this.f13242c, m15815a);
            } else {
                if (i4 == 0) {
                    i2 = C2529u.m15895f(str3);
                    m15815a.f13194c = i2;
                } else {
                    i2 = i4;
                }
                if (i == 184) {
                    i3 = (this.f13240Z - (i2 >> 2)) + (i2 & 3) + 1;
                } else {
                    i3 = (this.f13240Z - (i2 >> 2)) + (i2 & 3);
                }
                if (i3 > this.f13241aa) {
                    this.f13241aa = i3;
                }
                this.f13240Z = i3;
                i4 = i2;
            }
        }
        if (i == 185) {
            if (i4 == 0) {
                i4 = C2529u.m15895f(str3);
                m15815a.f13194c = i4;
            }
            this.f13261v.m15771b(185, m15815a.f13192a).m15765a(i4 >> 2, 0);
            return;
        }
        this.f13261v.m15771b(i, m15815a.f13192a);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15683a(String str, String str2, C2522n c2522n, Object... objArr) {
        this.f13230P = this.f13261v.f13089b;
        C2524p m15816a = this.f13242c.m15816a(str, str2, c2522n, objArr);
        int i = m15816a.f13194c;
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(186, 0, this.f13242c, m15816a);
            } else {
                if (i == 0) {
                    i = C2529u.m15895f(str2);
                    m15816a.f13194c = i;
                }
                int i2 = (i & 3) + (this.f13240Z - (i >> 2)) + 1;
                if (i2 > this.f13241aa) {
                    this.f13241aa = i2;
                }
                this.f13240Z = i2;
            }
        }
        this.f13261v.m15771b(186, m15816a.f13192a);
        this.f13261v.m15770b(0);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15743a(int i, C2525q c2525q) {
        C2525q c2525q2 = null;
        this.f13230P = this.f13261v.f13089b;
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(i, 0, (C2516h) null, (C2524p) null);
                c2525q.m15862a().f13202b |= 16;
                m15879c(0, c2525q);
                if (i != 167) {
                    c2525q2 = new C2525q();
                }
            } else if (i == 168) {
                if ((c2525q.f13202b & 512) == 0) {
                    c2525q.f13202b |= 512;
                    this.f13235U++;
                }
                this.f13239Y.f13202b |= 128;
                m15879c(this.f13240Z + 1, c2525q);
                c2525q2 = new C2525q();
            } else {
                this.f13240Z += C2521m.f13173a[i];
                m15879c(this.f13240Z, c2525q);
            }
        }
        if ((c2525q.f13202b & 2) != 0 && c2525q.f13204d - this.f13261v.f13089b < -32768) {
            if (i == 167) {
                this.f13261v.m15764a(200);
            } else if (i == 168) {
                this.f13261v.m15764a(201);
            } else {
                if (c2525q2 != null) {
                    c2525q2.f13202b |= 16;
                }
                this.f13261v.m15764a(i <= 166 ? ((i + 1) ^ 1) - 1 : i ^ 1);
                this.f13261v.m15770b(8);
                this.f13261v.m15764a(200);
            }
            c2525q.m15865a(this, this.f13261v, this.f13261v.f13089b - 1, true);
        } else {
            this.f13261v.m15764a(i);
            c2525q.m15865a(this, this.f13261v, this.f13261v.f13089b - 1, false);
        }
        if (this.f13239Y != null) {
            if (c2525q2 != null) {
                mo15747a(c2525q2);
            }
            if (i == 167) {
                m15880e();
            }
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15747a(C2525q c2525q) {
        this.f13234T |= c2525q.m15868a(this, this.f13261v.f13089b, this.f13261v.f13088a);
        if ((c2525q.f13202b & 1) == 0) {
            if (this.f13236V == 0) {
                if (this.f13239Y != null) {
                    if (c2525q.f13204d == this.f13239Y.f13204d) {
                        this.f13239Y.f13202b |= c2525q.f13202b & 16;
                        c2525q.f13207g = this.f13239Y.f13207g;
                        return;
                    }
                    m15879c(0, c2525q);
                }
                this.f13239Y = c2525q;
                if (c2525q.f13207g == null) {
                    c2525q.f13207g = new C2521m();
                    c2525q.f13207g.f13174b = c2525q;
                }
                if (this.f13238X != null) {
                    if (c2525q.f13204d == this.f13238X.f13204d) {
                        this.f13238X.f13202b |= c2525q.f13202b & 16;
                        c2525q.f13207g = this.f13238X.f13207g;
                        this.f13239Y = this.f13238X;
                        return;
                    }
                    this.f13238X.f13208h = c2525q;
                }
                this.f13238X = c2525q;
                return;
            }
            if (this.f13236V == 1) {
                if (this.f13239Y != null) {
                    this.f13239Y.f13206f = this.f13241aa;
                    m15879c(this.f13240Z, c2525q);
                }
                this.f13239Y = c2525q;
                this.f13240Z = 0;
                this.f13241aa = 0;
                if (this.f13238X != null) {
                    this.f13238X.f13208h = c2525q;
                }
                this.f13238X = c2525q;
            }
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo10229a(Object obj) {
        int i;
        this.f13230P = this.f13261v.f13089b;
        C2524p m15814a = this.f13242c.m15814a(obj);
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(18, 0, this.f13242c, m15814a);
            } else {
                if (m15814a.f13193b == 5 || m15814a.f13193b == 6) {
                    i = this.f13240Z + 2;
                } else {
                    i = this.f13240Z + 1;
                }
                if (i > this.f13241aa) {
                    this.f13241aa = i;
                }
                this.f13240Z = i;
            }
        }
        int i2 = m15814a.f13192a;
        if (m15814a.f13193b == 5 || m15814a.f13193b == 6) {
            this.f13261v.m15771b(20, i2);
        } else if (i2 >= 256) {
            this.f13261v.m15771b(19, i2);
        } else {
            this.f13261v.m15765a(18, i2);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public void mo15649c(int i, int i2) {
        int i3;
        this.f13230P = this.f13261v.f13089b;
        if (this.f13239Y != null && this.f13236V == 0) {
            this.f13239Y.f13207g.m15845a(132, i, (C2516h) null, (C2524p) null);
        }
        if (this.f13236V != 2 && (i3 = i + 1) > this.f13263x) {
            this.f13263x = i3;
        }
        if (i > 255 || i2 > 127 || i2 < -128) {
            this.f13261v.m15764a(196).m15771b(132, i).m15770b(i2);
        } else {
            this.f13261v.m15764a(132).m15765a(i, i2);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15742a(int i, int i2, C2525q c2525q, C2525q... c2525qArr) {
        this.f13230P = this.f13261v.f13089b;
        int i3 = this.f13261v.f13089b;
        this.f13261v.m15764a(170);
        this.f13261v.m15769a((byte[]) null, 0, (4 - (this.f13261v.f13089b % 4)) % 4);
        c2525q.m15865a(this, this.f13261v, i3, true);
        this.f13261v.m15772c(i).m15772c(i2);
        for (C2525q c2525q2 : c2525qArr) {
            c2525q2.m15865a(this, this.f13261v, i3, true);
        }
        m15873a(c2525q, c2525qArr);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15748a(C2525q c2525q, int[] iArr, C2525q[] c2525qArr) {
        this.f13230P = this.f13261v.f13089b;
        int i = this.f13261v.f13089b;
        this.f13261v.m15764a(171);
        this.f13261v.m15769a((byte[]) null, 0, (4 - (this.f13261v.f13089b % 4)) % 4);
        c2525q.m15865a(this, this.f13261v, i, true);
        this.f13261v.m15772c(c2525qArr.length);
        for (int i2 = 0; i2 < c2525qArr.length; i2++) {
            this.f13261v.m15772c(iArr[i2]);
            c2525qArr[i2].m15865a(this, this.f13261v, i, true);
        }
        m15873a(c2525q, c2525qArr);
    }

    /* renamed from: a */
    private void m15873a(C2525q c2525q, C2525q[] c2525qArr) {
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(171, 0, (C2516h) null, (C2524p) null);
                m15879c(0, c2525q);
                c2525q.m15862a().f13202b |= 16;
                for (int i = 0; i < c2525qArr.length; i++) {
                    m15879c(0, c2525qArr[i]);
                    c2525qArr[i].m15862a().f13202b |= 16;
                }
            } else {
                this.f13240Z--;
                m15879c(this.f13240Z, c2525q);
                for (C2525q c2525q2 : c2525qArr) {
                    m15879c(this.f13240Z, c2525q2);
                }
            }
            m15880e();
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15687b(String str, int i) {
        this.f13230P = this.f13261v.f13089b;
        C2524p m15821b = this.f13242c.m15821b(str);
        if (this.f13239Y != null) {
            if (this.f13236V == 0) {
                this.f13239Y.f13207g.m15845a(197, i, this.f13242c, m15821b);
            } else {
                this.f13240Z += 1 - i;
            }
        }
        this.f13261v.m15771b(197, m15821b.f13192a).m15764a(i);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public AbstractC2473a mo15685b(int i, C2530v c2530v, String str, boolean z) {
        C2513e c2513e = new C2513e();
        C2481b.m15705a(((-16776961) & i) | (this.f13230P << 8), c2530v, c2513e);
        c2513e.m15770b(this.f13242c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13242c, true, c2513e, c2513e, c2513e.f13089b - 2);
        if (z) {
            c2481b.f12980c = this.f13231Q;
            this.f13231Q = c2481b;
        } else {
            c2481b.f12980c = this.f13232R;
            this.f13232R = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15684a(C2525q c2525q, C2525q c2525q2, C2525q c2525q3, String str) {
        this.f13219E++;
        C2523o c2523o = new C2523o();
        c2523o.f13186a = c2525q;
        c2523o.f13187b = c2525q2;
        c2523o.f13188c = c2525q3;
        c2523o.f13189d = str;
        c2523o.f13190e = str != null ? this.f13242c.m15824c(str) : 0;
        if (this.f13221G == null) {
            this.f13220F = c2523o;
        } else {
            this.f13221G.f13191f = c2523o;
        }
        this.f13221G = c2523o;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public AbstractC2473a mo15688c(int i, C2530v c2530v, String str, boolean z) {
        C2513e c2513e = new C2513e();
        C2481b.m15705a(i, c2530v, c2513e);
        c2513e.m15770b(this.f13242c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13242c, true, c2513e, c2513e, c2513e.f13089b - 2);
        if (z) {
            c2481b.f12980c = this.f13231Q;
            this.f13231Q = c2481b;
        } else {
            c2481b.f12980c = this.f13232R;
            this.f13232R = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15646a(String str, String str2, String str3, C2525q c2525q, C2525q c2525q2, int i) {
        int i2 = 2;
        if (str3 != null) {
            if (this.f13227M == null) {
                this.f13227M = new C2513e();
            }
            this.f13226L++;
            this.f13227M.m15770b(c2525q.f13204d).m15770b(c2525q2.f13204d - c2525q.f13204d).m15770b(this.f13242c.m15807a(str)).m15770b(this.f13242c.m15807a(str3)).m15770b(i);
        }
        if (this.f13225K == null) {
            this.f13225K = new C2513e();
        }
        this.f13224J++;
        this.f13225K.m15770b(c2525q.f13204d).m15770b(c2525q2.f13204d - c2525q.f13204d).m15770b(this.f13242c.m15807a(str)).m15770b(this.f13242c.m15807a(str2)).m15770b(i);
        if (this.f13236V != 2) {
            char charAt = str2.charAt(0);
            if (charAt != 'J' && charAt != 'D') {
                i2 = 1;
            }
            int i3 = i2 + i;
            if (i3 > this.f13263x) {
                this.f13263x = i3;
            }
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15643a(int i, C2530v c2530v, C2525q[] c2525qArr, C2525q[] c2525qArr2, int[] iArr, String str, boolean z) {
        C2513e c2513e = new C2513e();
        c2513e.m15764a(i >>> 24).m15770b(c2525qArr.length);
        for (int i2 = 0; i2 < c2525qArr.length; i2++) {
            c2513e.m15770b(c2525qArr[i2].f13204d).m15770b(c2525qArr2[i2].f13204d - c2525qArr[i2].f13204d).m15770b(iArr[i2]);
        }
        if (c2530v == null) {
            c2513e.m15764a(0);
        } else {
            c2513e.m15769a(c2530v.f13286a, c2530v.f13287b, (c2530v.f13286a[c2530v.f13287b] * 2) + 1);
        }
        c2513e.m15770b(this.f13242c.m15807a(str)).m15770b(0);
        C2481b c2481b = new C2481b(this.f13242c, true, c2513e, c2513e, c2513e.f13089b - 2);
        if (z) {
            c2481b.f12980c = this.f13231Q;
            this.f13231Q = c2481b;
        } else {
            c2481b.f12980c = this.f13232R;
            this.f13232R = c2481b;
        }
        return c2481b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15752b(int i, C2525q c2525q) {
        if (this.f13229O == null) {
            this.f13229O = new C2513e();
        }
        this.f13228N++;
        this.f13229O.m15770b(c2525q.f13204d);
        this.f13229O.m15770b(i);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: d */
    public void mo15650d(int i, int i2) {
        C2525q c2525q;
        if (this.f13234T) {
            m15885i();
        }
        if (this.f13236V == 0) {
            for (C2523o c2523o = this.f13220F; c2523o != null; c2523o = c2523o.f13191f) {
                C2525q m15862a = c2523o.f13186a.m15862a();
                C2525q m15862a2 = c2523o.f13188c.m15862a();
                C2525q m15862a3 = c2523o.f13187b.m15862a();
                int m15829e = 24117248 | this.f13242c.m15829e(c2523o.f13189d == null ? "java/lang/Throwable" : c2523o.f13189d);
                m15862a2.f13202b |= 16;
                for (C2525q c2525q2 = m15862a; c2525q2 != m15862a3; c2525q2 = c2525q2.f13208h) {
                    C2518j c2518j = new C2518j();
                    c2518j.f13157a = m15829e;
                    c2518j.f13158b = m15862a2;
                    c2518j.f13159c = c2525q2.f13209i;
                    c2525q2.f13209i = c2518j;
                }
            }
            C2521m c2521m = this.f13237W.f13207g;
            c2521m.m15846a(this.f13242c, this.f13248i, C2529u.m15893d(this.f13251l), this.f13263x);
            m15872a(c2521m);
            C2525q c2525q3 = this.f13237W;
            int i3 = 0;
            while (c2525q3 != null) {
                C2525q c2525q4 = c2525q3.f13210j;
                c2525q3.f13210j = null;
                C2521m c2521m2 = c2525q3.f13207g;
                if ((c2525q3.f13202b & 16) != 0) {
                    c2525q3.f13202b |= 32;
                }
                c2525q3.f13202b |= 64;
                int length = c2521m2.f13176d.length + c2525q3.f13206f;
                if (length <= i3) {
                    length = i3;
                }
                C2518j c2518j2 = c2525q3.f13209i;
                while (c2518j2 != null) {
                    C2525q m15862a4 = c2518j2.f13158b.m15862a();
                    if (c2521m2.m15847a(this.f13242c, m15862a4.f13207g, c2518j2.f13157a) && m15862a4.f13210j == null) {
                        m15862a4.f13210j = c2525q4;
                    } else {
                        m15862a4 = c2525q4;
                    }
                    c2518j2 = c2518j2.f13159c;
                    c2525q4 = m15862a4;
                }
                c2525q3 = c2525q4;
                i3 = length;
            }
            int i4 = i3;
            for (C2525q c2525q5 = this.f13237W; c2525q5 != null; c2525q5 = c2525q5.f13208h) {
                C2521m c2521m3 = c2525q5.f13207g;
                if ((c2525q5.f13202b & 32) != 0) {
                    m15872a(c2521m3);
                }
                if ((c2525q5.f13202b & 64) == 0) {
                    C2525q c2525q6 = c2525q5.f13208h;
                    int i5 = c2525q5.f13204d;
                    int i6 = (c2525q6 == null ? this.f13261v.f13089b : c2525q6.f13204d) - 1;
                    if (i6 >= i5) {
                        i4 = Math.max(i4, 1);
                        for (int i7 = i5; i7 < i6; i7++) {
                            this.f13261v.f13088a[i7] = 0;
                        }
                        this.f13261v.f13088a[i6] = -65;
                        this.f13218D[m15869a(i5, 0, 1)] = this.f13242c.m15829e("java/lang/Throwable") | 24117248;
                        m15883g();
                        this.f13220F = C2523o.m15852a(this.f13220F, c2525q5, c2525q6);
                    }
                }
            }
            this.f13219E = 0;
            for (C2523o c2523o2 = this.f13220F; c2523o2 != null; c2523o2 = c2523o2.f13191f) {
                this.f13219E++;
            }
            this.f13262w = i4;
            return;
        }
        if (this.f13236V == 1) {
            for (C2523o c2523o3 = this.f13220F; c2523o3 != null; c2523o3 = c2523o3.f13191f) {
                C2525q c2525q7 = c2523o3.f13188c;
                C2525q c2525q8 = c2523o3.f13187b;
                for (C2525q c2525q9 = c2523o3.f13186a; c2525q9 != c2525q8; c2525q9 = c2525q9.f13208h) {
                    C2518j c2518j3 = new C2518j();
                    c2518j3.f13157a = Integer.MAX_VALUE;
                    c2518j3.f13158b = c2525q7;
                    if ((c2525q9.f13202b & 128) == 0) {
                        c2518j3.f13159c = c2525q9.f13209i;
                        c2525q9.f13209i = c2518j3;
                    } else {
                        c2518j3.f13159c = c2525q9.f13209i.f13159c.f13159c;
                        c2525q9.f13209i.f13159c.f13159c = c2518j3;
                    }
                }
            }
            if (this.f13235U > 0) {
                this.f13237W.m15864a((C2525q) null, 1L, this.f13235U);
                int i8 = 0;
                for (C2525q c2525q10 = this.f13237W; c2525q10 != null; c2525q10 = c2525q10.f13208h) {
                    if ((c2525q10.f13202b & 128) != 0) {
                        C2525q c2525q11 = c2525q10.f13209i.f13159c.f13158b;
                        if ((c2525q11.f13202b & 1024) == 0) {
                            i8++;
                            c2525q11.m15864a((C2525q) null, ((i8 / 32) << 32) | (1 << (i8 % 32)), this.f13235U);
                        }
                    }
                }
                for (C2525q c2525q12 = this.f13237W; c2525q12 != null; c2525q12 = c2525q12.f13208h) {
                    if ((c2525q12.f13202b & 128) != 0) {
                        for (C2525q c2525q13 = this.f13237W; c2525q13 != null; c2525q13 = c2525q13.f13208h) {
                            c2525q13.f13202b &= -2049;
                        }
                        c2525q12.f13209i.f13159c.f13158b.m15864a(c2525q12, 0L, this.f13235U);
                    }
                }
            }
            C2525q c2525q14 = this.f13237W;
            int i9 = 0;
            while (c2525q14 != null) {
                C2525q c2525q15 = c2525q14.f13210j;
                int i10 = c2525q14.f13205e;
                int i11 = c2525q14.f13206f + i10;
                if (i11 <= i9) {
                    i11 = i9;
                }
                C2518j c2518j4 = c2525q14.f13209i;
                C2518j c2518j5 = (c2525q14.f13202b & 128) != 0 ? c2518j4.f13159c : c2518j4;
                while (c2518j5 != null) {
                    C2525q c2525q16 = c2518j5.f13158b;
                    if ((c2525q16.f13202b & 8) == 0) {
                        c2525q16.f13205e = c2518j5.f13157a == Integer.MAX_VALUE ? 1 : c2518j5.f13157a + i10;
                        c2525q16.f13202b |= 8;
                        c2525q16.f13210j = c2525q15;
                        c2525q = c2525q16;
                    } else {
                        c2525q = c2525q15;
                    }
                    c2518j5 = c2518j5.f13159c;
                    c2525q15 = c2525q;
                }
                c2525q14 = c2525q15;
                i9 = i11;
            }
            this.f13262w = Math.max(i, i9);
            return;
        }
        this.f13262w = i;
        this.f13263x = i2;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public void mo15753c() {
    }

    /* renamed from: c */
    private void m15879c(int i, C2525q c2525q) {
        C2518j c2518j = new C2518j();
        c2518j.f13157a = i;
        c2518j.f13158b = c2525q;
        c2518j.f13159c = this.f13239Y.f13209i;
        this.f13239Y.f13209i = c2518j;
    }

    /* renamed from: e */
    private void m15880e() {
        if (this.f13236V == 0) {
            C2525q c2525q = new C2525q();
            c2525q.f13207g = new C2521m();
            c2525q.f13207g.f13174b = c2525q;
            c2525q.m15868a(this, this.f13261v.f13089b, this.f13261v.f13088a);
            this.f13238X.f13208h = c2525q;
            this.f13238X = c2525q;
        } else {
            this.f13239Y.f13206f = this.f13241aa;
        }
        this.f13239Y = null;
    }

    /* renamed from: a */
    private void m15872a(C2521m c2521m) {
        int[] iArr = c2521m.f13175c;
        int[] iArr2 = c2521m.f13176d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < iArr.length) {
            int i4 = iArr[i3];
            if (i4 == 16777216) {
                i2++;
            } else {
                i += i2 + 1;
                i2 = 0;
            }
            if (i4 == 16777220 || i4 == 16777219) {
                i3++;
            }
            i3++;
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < iArr2.length) {
            int i7 = iArr2[i6];
            i5++;
            if (i7 == 16777220 || i7 == 16777219) {
                i6++;
            }
            i6++;
        }
        int m15869a = m15869a(c2521m.f13174b.f13204d, i, i5);
        int i8 = 0;
        for (int i9 = i; i9 > 0; i9--) {
            int i10 = iArr[i8];
            int i11 = m15869a + 1;
            this.f13218D[m15869a] = i10;
            i8 = ((i10 == 16777220 || i10 == 16777219) ? i8 + 1 : i8) + 1;
            m15869a = i11;
        }
        int i12 = m15869a;
        int i13 = 0;
        while (i13 < iArr2.length) {
            int i14 = iArr2[i13];
            int i15 = i12 + 1;
            this.f13218D[i12] = i14;
            if (i14 == 16777220 || i14 == 16777219) {
                i13++;
            }
            i13++;
            i12 = i15;
        }
        m15883g();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x003a. Please report as an issue. */
    /* renamed from: f */
    private void m15882f() {
        int i;
        int m15869a = m15869a(0, this.f13251l.length() + 1, 0);
        if ((this.f13248i & 8) != 0) {
            i = m15869a;
        } else if ((this.f13248i & 524288) == 0) {
            i = m15869a + 1;
            this.f13218D[m15869a] = this.f13242c.m15829e(this.f13242c.f13125o) | 24117248;
        } else {
            i = m15869a + 1;
            this.f13218D[m15869a] = 6;
        }
        int i2 = 1;
        int i3 = i;
        while (true) {
            int i4 = i2 + 1;
            switch (this.f13251l.charAt(i2)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    this.f13218D[i3] = 1;
                    i3++;
                    i2 = i4;
                case 'D':
                    this.f13218D[i3] = 3;
                    i3++;
                    i2 = i4;
                case 'F':
                    this.f13218D[i3] = 2;
                    i3++;
                    i2 = i4;
                case 'J':
                    this.f13218D[i3] = 4;
                    i3++;
                    i2 = i4;
                case 'L':
                    while (this.f13251l.charAt(i4) != ';') {
                        i4++;
                    }
                    this.f13218D[i3] = this.f13242c.m15829e(this.f13251l.substring(i2 + 1, i4)) | 24117248;
                    i4++;
                    i3++;
                    i2 = i4;
                case '[':
                    while (this.f13251l.charAt(i4) == '[') {
                        i4++;
                    }
                    if (this.f13251l.charAt(i4) == 'L') {
                        do {
                            i4++;
                        } while (this.f13251l.charAt(i4) != ';');
                    }
                    i4++;
                    this.f13218D[i3] = this.f13242c.m15829e(this.f13251l.substring(i2, i4)) | 24117248;
                    i3++;
                    i2 = i4;
            }
            this.f13218D[1] = i3 - 3;
            m15883g();
            return;
        }
    }

    /* renamed from: a */
    private int m15869a(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        if (this.f13218D == null || this.f13218D.length < i4) {
            this.f13218D = new int[i4];
        }
        this.f13218D[0] = i;
        this.f13218D[1] = i2;
        this.f13218D[2] = i3;
        return 3;
    }

    /* renamed from: g */
    private void m15883g() {
        if (this.f13217C != null) {
            if (this.f13215A == null) {
                this.f13215A = new C2513e();
            }
            m15884h();
            this.f13265z++;
        }
        this.f13217C = this.f13218D;
        this.f13218D = null;
    }

    /* renamed from: h */
    private void m15884h() {
        int i;
        int i2;
        char c2;
        int i3;
        int i4 = 0;
        int i5 = this.f13218D[1];
        int i6 = this.f13218D[2];
        if ((this.f13242c.f13115e & 65535) < 50) {
            this.f13215A.m15770b(this.f13218D[0]).m15770b(i5);
            m15881e(3, i5 + 3);
            this.f13215A.m15770b(i6);
            m15881e(i5 + 3, i5 + 3 + i6);
        }
        int i7 = this.f13217C[1];
        if (this.f13265z == 0) {
            i = this.f13218D[0];
        } else {
            i = (this.f13218D[0] - this.f13217C[0]) - 1;
        }
        if (i6 == 0) {
            i2 = i5 - i7;
            switch (i2) {
                case -3:
                case -2:
                case -1:
                    c2 = 248;
                    i7 = i5;
                    break;
                case 0:
                    if (i >= 64) {
                        c2 = 251;
                        break;
                    } else {
                        c2 = 0;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    c2 = 252;
                    break;
                default:
                    c2 = 255;
                    break;
            }
            i3 = i7;
        } else if (i5 == i7 && i6 == 1) {
            c2 = i >= 63 ? (char) 247 : '@';
            i2 = 0;
            i3 = i7;
        } else {
            i2 = 0;
            c2 = 255;
            i3 = i7;
        }
        if (c2 != 255) {
            int i8 = 3;
            while (true) {
                if (i4 < i3) {
                    if (this.f13218D[i8] != this.f13217C[i8]) {
                        c2 = 255;
                    } else {
                        i8++;
                        i4++;
                    }
                }
            }
        }
        switch (c2) {
            case 0:
                this.f13215A.m15764a(i);
                break;
            case '@':
                this.f13215A.m15764a(i + 64);
                m15881e(i5 + 3, i5 + 4);
                break;
            case 247:
                this.f13215A.m15764a(247).m15770b(i);
                m15881e(i5 + 3, i5 + 4);
                break;
            case 248:
                this.f13215A.m15764a(i2 + 251).m15770b(i);
                break;
            case 251:
                this.f13215A.m15764a(251).m15770b(i);
                break;
            case 252:
                this.f13215A.m15764a(i2 + 251).m15770b(i);
                m15881e(i3 + 3, i5 + 3);
                break;
            default:
                this.f13215A.m15764a(255).m15770b(i).m15770b(i5);
                m15881e(3, i5 + 3);
                this.f13215A.m15770b(i6);
                m15881e(i5 + 3, i5 + 3 + i6);
                break;
        }
    }

    /* renamed from: e */
    private void m15881e(int i, int i2) {
        while (i < i2) {
            int i3 = this.f13218D[i];
            int i4 = (-268435456) & i3;
            if (i4 == 0) {
                int i5 = i3 & 1048575;
                switch (i3 & 267386880) {
                    case 24117248:
                        this.f13215A.m15764a(7).m15770b(this.f13242c.m15824c(this.f13242c.f13124n[i5].f13196e));
                        break;
                    case 25165824:
                        this.f13215A.m15764a(8).m15770b(this.f13242c.f13124n[i5].f13194c);
                        break;
                    default:
                        this.f13215A.m15764a(i5);
                        break;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                int i6 = i4 >> 28;
                while (true) {
                    int i7 = i6 - 1;
                    if (i6 > 0) {
                        sb.append('[');
                        i6 = i7;
                    } else {
                        if ((i3 & 267386880) == 24117248) {
                            sb.append('L');
                            sb.append(this.f13242c.f13124n[i3 & 1048575].f13196e);
                            sb.append(';');
                        } else {
                            switch (i3 & 15) {
                                case 1:
                                    sb.append('I');
                                    break;
                                case 2:
                                    sb.append('F');
                                    break;
                                case 3:
                                    sb.append('D');
                                    break;
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                default:
                                    sb.append('J');
                                    break;
                                case 9:
                                    sb.append('Z');
                                    break;
                                case 10:
                                    sb.append('B');
                                    break;
                                case 11:
                                    sb.append('C');
                                    break;
                                case 12:
                                    sb.append('S');
                                    break;
                            }
                        }
                        this.f13215A.m15764a(7).m15770b(this.f13242c.m15824c(sb.toString()));
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m15877b(Object obj) {
        if (obj instanceof String) {
            this.f13215A.m15764a(7).m15770b(this.f13242c.m15824c((String) obj));
        } else if (obj instanceof Integer) {
            this.f13215A.m15764a(((Integer) obj).intValue());
        } else {
            this.f13215A.m15764a(8).m15770b(((C2525q) obj).f13204d);
        }
    }

    /* renamed from: d */
    final int m15887d() {
        int i;
        if (this.f13244e != 0) {
            return this.f13245f + 6;
        }
        int i2 = 8;
        if (this.f13261v.f13089b > 0) {
            if (this.f13261v.f13089b > 65536) {
                throw new RuntimeException("Method code too large!");
            }
            this.f13242c.m15807a("Code");
            int i3 = this.f13261v.f13089b + 18 + (this.f13219E * 8) + 8;
            if (this.f13225K != null) {
                this.f13242c.m15807a("LocalVariableTable");
                i3 += this.f13225K.f13089b + 8;
            }
            if (this.f13227M != null) {
                this.f13242c.m15807a("LocalVariableTypeTable");
                i3 += this.f13227M.f13089b + 8;
            }
            if (this.f13229O != null) {
                this.f13242c.m15807a("LineNumberTable");
                i3 += this.f13229O.f13089b + 8;
            }
            if (this.f13215A != null) {
                this.f13242c.m15807a((this.f13242c.f13115e & 65535) >= 50 ? "StackMapTable" : "StackMap");
                i3 += this.f13215A.f13089b + 8;
            }
            if (this.f13231Q != null) {
                this.f13242c.m15807a("RuntimeVisibleTypeAnnotations");
                i3 += this.f13231Q.m15708b() + 8;
            }
            if (this.f13232R != null) {
                this.f13242c.m15807a("RuntimeInvisibleTypeAnnotations");
                i2 = i3 + this.f13232R.m15708b() + 8;
            } else {
                i2 = i3;
            }
            if (this.f13233S != null) {
                i2 += this.f13233S.m15760b(this.f13242c, this.f13261v.f13088a, this.f13261v.f13089b, this.f13262w, this.f13263x);
            }
        }
        if (this.f13246g > 0) {
            this.f13242c.m15807a("Exceptions");
            i2 += (this.f13246g * 2) + 8;
        }
        if ((this.f13248i & 4096) != 0 && ((this.f13242c.f13115e & 65535) < 49 || (this.f13248i & 262144) != 0)) {
            this.f13242c.m15807a("Synthetic");
            i2 += 6;
        }
        if ((this.f13248i & 131072) != 0) {
            this.f13242c.m15807a("Deprecated");
            i2 += 6;
        }
        if (this.f13243d != null) {
            this.f13242c.m15807a("Signature");
            this.f13242c.m15807a(this.f13243d);
            i2 += 8;
        }
        if (this.f13223I != null) {
            this.f13242c.m15807a("MethodParameters");
            i2 += this.f13223I.f13089b + 7;
        }
        if (this.f13252m != null) {
            this.f13242c.m15807a("AnnotationDefault");
            i2 += this.f13252m.f13089b + 6;
        }
        if (this.f13253n != null) {
            this.f13242c.m15807a("RuntimeVisibleAnnotations");
            i2 += this.f13253n.m15708b() + 8;
        }
        if (this.f13254o != null) {
            this.f13242c.m15807a("RuntimeInvisibleAnnotations");
            i2 += this.f13254o.m15708b() + 8;
        }
        if (this.f13255p != null) {
            this.f13242c.m15807a("RuntimeVisibleTypeAnnotations");
            i2 += this.f13255p.m15708b() + 8;
        }
        if (this.f13256q != null) {
            this.f13242c.m15807a("RuntimeInvisibleTypeAnnotations");
            i2 += this.f13256q.m15708b() + 8;
        }
        if (this.f13257r != null) {
            this.f13242c.m15807a("RuntimeVisibleParameterAnnotations");
            i = i2 + ((this.f13257r.length - this.f13259t) * 2) + 7;
            int length = this.f13257r.length;
            while (true) {
                length--;
                if (length < this.f13259t) {
                    break;
                }
                i += this.f13257r[length] == null ? 0 : this.f13257r[length].m15708b();
            }
        } else {
            i = i2;
        }
        if (this.f13258s != null) {
            this.f13242c.m15807a("RuntimeInvisibleParameterAnnotations");
            i += ((this.f13258s.length - this.f13259t) * 2) + 7;
            int length2 = this.f13258s.length;
            while (true) {
                length2--;
                if (length2 < this.f13259t) {
                    break;
                }
                i += this.f13258s[length2] == null ? 0 : this.f13258s[length2].m15708b();
            }
        }
        int i4 = i;
        if (this.f13260u != null) {
            return i4 + this.f13260u.m15760b(this.f13242c, null, 0, -1, -1);
        }
        return i4;
    }

    /* renamed from: a */
    final void m15886a(C2513e c2513e) {
        c2513e.m15770b(((917504 | ((this.f13248i & 262144) / 64)) ^ (-1)) & this.f13248i).m15770b(this.f13249j).m15770b(this.f13250k);
        if (this.f13244e != 0) {
            c2513e.m15769a(this.f13242c.f13114d.f13090a, this.f13244e, this.f13245f);
            return;
        }
        int i = this.f13261v.f13089b > 0 ? 1 : 0;
        if (this.f13246g > 0) {
            i++;
        }
        if ((this.f13248i & 4096) != 0 && ((this.f13242c.f13115e & 65535) < 49 || (this.f13248i & 262144) != 0)) {
            i++;
        }
        if ((this.f13248i & 131072) != 0) {
            i++;
        }
        if (this.f13243d != null) {
            i++;
        }
        if (this.f13223I != null) {
            i++;
        }
        if (this.f13252m != null) {
            i++;
        }
        if (this.f13253n != null) {
            i++;
        }
        if (this.f13254o != null) {
            i++;
        }
        if (this.f13255p != null) {
            i++;
        }
        if (this.f13256q != null) {
            i++;
        }
        if (this.f13257r != null) {
            i++;
        }
        if (this.f13258s != null) {
            i++;
        }
        if (this.f13260u != null) {
            i += this.f13260u.m15762c();
        }
        c2513e.m15770b(i);
        if (this.f13261v.f13089b > 0) {
            int i2 = this.f13261v.f13089b + 12 + (this.f13219E * 8);
            if (this.f13225K != null) {
                i2 += this.f13225K.f13089b + 8;
            }
            if (this.f13227M != null) {
                i2 += this.f13227M.f13089b + 8;
            }
            if (this.f13229O != null) {
                i2 += this.f13229O.f13089b + 8;
            }
            if (this.f13215A != null) {
                i2 += this.f13215A.f13089b + 8;
            }
            if (this.f13231Q != null) {
                i2 += this.f13231Q.m15708b() + 8;
            }
            int m15708b = this.f13232R != null ? i2 + this.f13232R.m15708b() + 8 : i2;
            if (this.f13233S != null) {
                m15708b += this.f13233S.m15760b(this.f13242c, this.f13261v.f13088a, this.f13261v.f13089b, this.f13262w, this.f13263x);
            }
            c2513e.m15770b(this.f13242c.m15807a("Code")).m15772c(m15708b);
            c2513e.m15770b(this.f13262w).m15770b(this.f13263x);
            c2513e.m15772c(this.f13261v.f13089b).m15769a(this.f13261v.f13088a, 0, this.f13261v.f13089b);
            c2513e.m15770b(this.f13219E);
            if (this.f13219E > 0) {
                for (C2523o c2523o = this.f13220F; c2523o != null; c2523o = c2523o.f13191f) {
                    c2513e.m15770b(c2523o.f13186a.f13204d).m15770b(c2523o.f13187b.f13204d).m15770b(c2523o.f13188c.f13204d).m15770b(c2523o.f13190e);
                }
            }
            int i3 = this.f13225K != null ? 1 : 0;
            if (this.f13227M != null) {
                i3++;
            }
            if (this.f13229O != null) {
                i3++;
            }
            if (this.f13215A != null) {
                i3++;
            }
            if (this.f13231Q != null) {
                i3++;
            }
            if (this.f13232R != null) {
                i3++;
            }
            if (this.f13233S != null) {
                i3 += this.f13233S.m15762c();
            }
            c2513e.m15770b(i3);
            if (this.f13225K != null) {
                c2513e.m15770b(this.f13242c.m15807a("LocalVariableTable"));
                c2513e.m15772c(this.f13225K.f13089b + 2).m15770b(this.f13224J);
                c2513e.m15769a(this.f13225K.f13088a, 0, this.f13225K.f13089b);
            }
            if (this.f13227M != null) {
                c2513e.m15770b(this.f13242c.m15807a("LocalVariableTypeTable"));
                c2513e.m15772c(this.f13227M.f13089b + 2).m15770b(this.f13226L);
                c2513e.m15769a(this.f13227M.f13088a, 0, this.f13227M.f13089b);
            }
            if (this.f13229O != null) {
                c2513e.m15770b(this.f13242c.m15807a("LineNumberTable"));
                c2513e.m15772c(this.f13229O.f13089b + 2).m15770b(this.f13228N);
                c2513e.m15769a(this.f13229O.f13088a, 0, this.f13229O.f13089b);
            }
            if (this.f13215A != null) {
                c2513e.m15770b(this.f13242c.m15807a((this.f13242c.f13115e & 65535) >= 50 ? "StackMapTable" : "StackMap"));
                c2513e.m15772c(this.f13215A.f13089b + 2).m15770b(this.f13265z);
                c2513e.m15769a(this.f13215A.f13088a, 0, this.f13215A.f13089b);
            }
            if (this.f13231Q != null) {
                c2513e.m15770b(this.f13242c.m15807a("RuntimeVisibleTypeAnnotations"));
                this.f13231Q.m15707a(c2513e);
            }
            if (this.f13232R != null) {
                c2513e.m15770b(this.f13242c.m15807a("RuntimeInvisibleTypeAnnotations"));
                this.f13232R.m15707a(c2513e);
            }
            if (this.f13233S != null) {
                this.f13233S.m15758a(this.f13242c, this.f13261v.f13088a, this.f13261v.f13089b, this.f13263x, this.f13262w, c2513e);
            }
        }
        if (this.f13246g > 0) {
            c2513e.m15770b(this.f13242c.m15807a("Exceptions")).m15772c((this.f13246g * 2) + 2);
            c2513e.m15770b(this.f13246g);
            for (int i4 = 0; i4 < this.f13246g; i4++) {
                c2513e.m15770b(this.f13247h[i4]);
            }
        }
        if ((this.f13248i & 4096) != 0 && ((this.f13242c.f13115e & 65535) < 49 || (this.f13248i & 262144) != 0)) {
            c2513e.m15770b(this.f13242c.m15807a("Synthetic")).m15772c(0);
        }
        if ((this.f13248i & 131072) != 0) {
            c2513e.m15770b(this.f13242c.m15807a("Deprecated")).m15772c(0);
        }
        if (this.f13243d != null) {
            c2513e.m15770b(this.f13242c.m15807a("Signature")).m15772c(2).m15770b(this.f13242c.m15807a(this.f13243d));
        }
        if (this.f13223I != null) {
            c2513e.m15770b(this.f13242c.m15807a("MethodParameters"));
            c2513e.m15772c(this.f13223I.f13089b + 1).m15764a(this.f13222H);
            c2513e.m15769a(this.f13223I.f13088a, 0, this.f13223I.f13089b);
        }
        if (this.f13252m != null) {
            c2513e.m15770b(this.f13242c.m15807a("AnnotationDefault"));
            c2513e.m15772c(this.f13252m.f13089b);
            c2513e.m15769a(this.f13252m.f13088a, 0, this.f13252m.f13089b);
        }
        if (this.f13253n != null) {
            c2513e.m15770b(this.f13242c.m15807a("RuntimeVisibleAnnotations"));
            this.f13253n.m15707a(c2513e);
        }
        if (this.f13254o != null) {
            c2513e.m15770b(this.f13242c.m15807a("RuntimeInvisibleAnnotations"));
            this.f13254o.m15707a(c2513e);
        }
        if (this.f13255p != null) {
            c2513e.m15770b(this.f13242c.m15807a("RuntimeVisibleTypeAnnotations"));
            this.f13255p.m15707a(c2513e);
        }
        if (this.f13256q != null) {
            c2513e.m15770b(this.f13242c.m15807a("RuntimeInvisibleTypeAnnotations"));
            this.f13256q.m15707a(c2513e);
        }
        if (this.f13257r != null) {
            c2513e.m15770b(this.f13242c.m15807a("RuntimeVisibleParameterAnnotations"));
            C2481b.m15706a(this.f13257r, this.f13259t, c2513e);
        }
        if (this.f13258s != null) {
            c2513e.m15770b(this.f13242c.m15807a("RuntimeInvisibleParameterAnnotations"));
            C2481b.m15706a(this.f13258s, this.f13259t, c2513e);
        }
        if (this.f13260u != null) {
            this.f13260u.m15758a(this.f13242c, (byte[]) null, 0, -1, -1, c2513e);
        }
    }

    /* renamed from: i */
    private void m15885i() {
        int i;
        int m15876b;
        int i2;
        int i3;
        int i4;
        int i5;
        int m15876b2;
        int i6;
        byte[] bArr = this.f13261v.f13088a;
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        boolean[] zArr = new boolean[this.f13261v.f13089b];
        int i7 = 3;
        do {
            if (i7 == 3) {
                i7 = 2;
            }
            int i8 = 0;
            while (i8 < bArr.length) {
                int i9 = bArr[i8] & 255;
                switch (C2516h.f13097c[i9]) {
                    case 0:
                    case 4:
                        i8++;
                        i3 = 0;
                        break;
                    case 1:
                    case 3:
                    case 11:
                        i8 += 2;
                        i3 = 0;
                        break;
                    case 2:
                    case 5:
                    case 6:
                    case 12:
                    case 13:
                        i8 += 3;
                        i3 = 0;
                        break;
                    case 7:
                    case 8:
                        i8 += 5;
                        i3 = 0;
                        break;
                    case 9:
                        if (i9 > 201) {
                            i9 = i9 < 218 ? i9 - 49 : i9 - 20;
                            m15876b2 = m15870a(bArr, i8 + 1) + i8;
                        } else {
                            m15876b2 = m15876b(bArr, i8 + 1) + i8;
                        }
                        int m15871a = m15871a(iArr, iArr2, i8, m15876b2);
                        if ((m15871a < -32768 || m15871a > 32767) && !zArr[i8]) {
                            i6 = (i9 == 167 || i9 == 168) ? 2 : 5;
                            zArr[i8] = true;
                        } else {
                            i6 = 0;
                        }
                        i8 += 3;
                        i3 = i6;
                        break;
                    case 10:
                        i8 += 5;
                        i3 = 0;
                        break;
                    case 14:
                        if (i7 == 1) {
                            i5 = -(m15871a(iArr, iArr2, 0, i8) & 3);
                        } else if (zArr[i8]) {
                            i5 = 0;
                        } else {
                            i5 = i8 & 3;
                            zArr[i8] = true;
                        }
                        int i10 = (i8 + 4) - (i8 & 3);
                        i8 = i10 + (((m15878c(bArr, i10 + 8) - m15878c(bArr, i10 + 4)) + 1) * 4) + 12;
                        i3 = i5;
                        break;
                    case 15:
                        if (i7 == 1) {
                            i4 = -(m15871a(iArr, iArr2, 0, i8) & 3);
                        } else if (zArr[i8]) {
                            i4 = 0;
                        } else {
                            i4 = i8 & 3;
                            zArr[i8] = true;
                        }
                        int i11 = (i8 + 4) - (i8 & 3);
                        i8 = i11 + (m15878c(bArr, i11 + 4) * 8) + 8;
                        i3 = i4;
                        break;
                    case 16:
                    default:
                        i8 += 4;
                        i3 = 0;
                        break;
                    case 17:
                        if ((bArr[i8 + 1] & 255) == 132) {
                            i8 += 6;
                            i3 = 0;
                            break;
                        } else {
                            i8 += 4;
                            i3 = 0;
                            break;
                        }
                }
                if (i3 != 0) {
                    int[] iArr3 = new int[iArr.length + 1];
                    int[] iArr4 = new int[iArr2.length + 1];
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                    System.arraycopy(iArr2, 0, iArr4, 0, iArr2.length);
                    iArr3[iArr.length] = i8;
                    iArr4[iArr2.length] = i3;
                    if (i3 > 0) {
                        i7 = 3;
                        iArr2 = iArr4;
                        iArr = iArr3;
                    } else {
                        iArr2 = iArr4;
                        iArr = iArr3;
                    }
                }
            }
            if (i7 < 3) {
                i7--;
            }
        } while (i7 != 0);
        C2513e c2513e = new C2513e(this.f13261v.f13089b);
        int i12 = 0;
        while (i12 < this.f13261v.f13089b) {
            int i13 = bArr[i12] & 255;
            switch (C2516h.f13097c[i13]) {
                case 0:
                case 4:
                    c2513e.m15764a(i13);
                    i12++;
                    continue;
                case 1:
                case 3:
                case 11:
                    c2513e.m15769a(bArr, i12, 2);
                    i12 += 2;
                    continue;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    c2513e.m15769a(bArr, i12, 3);
                    i12 += 3;
                    continue;
                case 7:
                case 8:
                    c2513e.m15769a(bArr, i12, 5);
                    i12 += 5;
                    continue;
                case 9:
                    if (i13 > 201) {
                        i13 = i13 < 218 ? i13 - 49 : i13 - 20;
                        m15876b = m15870a(bArr, i12 + 1) + i12;
                    } else {
                        m15876b = m15876b(bArr, i12 + 1) + i12;
                    }
                    int m15871a2 = m15871a(iArr, iArr2, i12, m15876b);
                    if (zArr[i12]) {
                        if (i13 == 167) {
                            c2513e.m15764a(200);
                            i2 = m15871a2;
                        } else if (i13 == 168) {
                            c2513e.m15764a(201);
                            i2 = m15871a2;
                        } else {
                            c2513e.m15764a(i13 <= 166 ? ((i13 + 1) ^ 1) - 1 : i13 ^ 1);
                            c2513e.m15770b(8);
                            c2513e.m15764a(200);
                            i2 = m15871a2 - 3;
                        }
                        c2513e.m15772c(i2);
                    } else {
                        c2513e.m15764a(i13);
                        c2513e.m15770b(m15871a2);
                    }
                    i12 += 3;
                    continue;
                case 10:
                    int m15871a3 = m15871a(iArr, iArr2, i12, m15878c(bArr, i12 + 1) + i12);
                    c2513e.m15764a(i13);
                    c2513e.m15772c(m15871a3);
                    i12 += 5;
                    continue;
                case 14:
                    int i14 = (i12 + 4) - (i12 & 3);
                    c2513e.m15764a(170);
                    c2513e.m15769a((byte[]) null, 0, (4 - (c2513e.f13089b % 4)) % 4);
                    int m15878c = m15878c(bArr, i14) + i12;
                    int i15 = i14 + 4;
                    c2513e.m15772c(m15871a(iArr, iArr2, i12, m15878c));
                    int m15878c2 = m15878c(bArr, i15);
                    int i16 = i15 + 4;
                    c2513e.m15772c(m15878c2);
                    i = i16 + 4;
                    c2513e.m15772c(m15878c(bArr, i - 4));
                    for (int m15878c3 = (m15878c(bArr, i16) - m15878c2) + 1; m15878c3 > 0; m15878c3--) {
                        int m15878c4 = m15878c(bArr, i) + i12;
                        i += 4;
                        c2513e.m15772c(m15871a(iArr, iArr2, i12, m15878c4));
                    }
                    break;
                case 15:
                    int i17 = (i12 + 4) - (i12 & 3);
                    c2513e.m15764a(171);
                    c2513e.m15769a((byte[]) null, 0, (4 - (c2513e.f13089b % 4)) % 4);
                    int m15878c5 = m15878c(bArr, i17) + i12;
                    int i18 = i17 + 4;
                    c2513e.m15772c(m15871a(iArr, iArr2, i12, m15878c5));
                    int m15878c6 = m15878c(bArr, i18);
                    i = i18 + 4;
                    c2513e.m15772c(m15878c6);
                    while (m15878c6 > 0) {
                        c2513e.m15772c(m15878c(bArr, i));
                        int i19 = i + 4;
                        int m15878c7 = m15878c(bArr, i19) + i12;
                        i = i19 + 4;
                        c2513e.m15772c(m15871a(iArr, iArr2, i12, m15878c7));
                        m15878c6--;
                    }
                    break;
                case 16:
                default:
                    c2513e.m15769a(bArr, i12, 4);
                    i12 += 4;
                    continue;
                case 17:
                    if ((bArr[i12 + 1] & 255) == 132) {
                        c2513e.m15769a(bArr, i12, 6);
                        i12 += 6;
                        break;
                    } else {
                        c2513e.m15769a(bArr, i12, 4);
                        i12 += 4;
                        continue;
                    }
            }
            i12 = i;
        }
        if (this.f13236V == 0) {
            for (C2525q c2525q = this.f13237W; c2525q != null; c2525q = c2525q.f13208h) {
                int i20 = c2525q.f13204d - 3;
                if (i20 >= 0 && zArr[i20]) {
                    c2525q.f13202b |= 16;
                }
                m15875a(iArr, iArr2, c2525q);
            }
            for (int i21 = 0; i21 < this.f13242c.f13124n.length; i21++) {
                C2524p c2524p = this.f13242c.f13124n[i21];
                if (c2524p != null && c2524p.f13193b == 31) {
                    c2524p.f13194c = m15871a(iArr, iArr2, 0, c2524p.f13194c);
                }
            }
        } else if (this.f13265z > 0) {
            this.f13242c.f13132v = true;
        }
        for (C2523o c2523o = this.f13220F; c2523o != null; c2523o = c2523o.f13191f) {
            m15875a(iArr, iArr2, c2523o.f13186a);
            m15875a(iArr, iArr2, c2523o.f13187b);
            m15875a(iArr, iArr2, c2523o.f13188c);
        }
        int i22 = 0;
        while (i22 < 2) {
            C2513e c2513e2 = i22 == 0 ? this.f13225K : this.f13227M;
            if (c2513e2 != null) {
                byte[] bArr2 = c2513e2.f13088a;
                for (int i23 = 0; i23 < c2513e2.f13089b; i23 += 10) {
                    int m15870a = m15870a(bArr2, i23);
                    int m15871a4 = m15871a(iArr, iArr2, 0, m15870a);
                    m15874a(bArr2, i23, m15871a4);
                    m15874a(bArr2, i23 + 2, m15871a(iArr, iArr2, 0, m15870a + m15870a(bArr2, i23 + 2)) - m15871a4);
                }
            }
            i22++;
        }
        if (this.f13229O != null) {
            byte[] bArr3 = this.f13229O.f13088a;
            for (int i24 = 0; i24 < this.f13229O.f13089b; i24 += 4) {
                m15874a(bArr3, i24, m15871a(iArr, iArr2, 0, m15870a(bArr3, i24)));
            }
        }
        for (C2512d c2512d = this.f13233S; c2512d != null; c2512d = c2512d.f13087c) {
            C2525q[] m15761b = c2512d.m15761b();
            if (m15761b != null) {
                for (int length = m15761b.length - 1; length >= 0; length--) {
                    m15875a(iArr, iArr2, m15761b[length]);
                }
            }
        }
        this.f13261v = c2513e;
    }

    /* renamed from: a */
    static int m15870a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    /* renamed from: b */
    static short m15876b(byte[] bArr, int i) {
        return (short) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
    }

    /* renamed from: c */
    static int m15878c(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    /* renamed from: a */
    static void m15874a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >>> 8);
        bArr[i + 1] = (byte) i2;
    }

    /* renamed from: a */
    static int m15871a(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = i2 - i;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i < iArr[i4] && iArr[i4] <= i2) {
                i3 += iArr2[i4];
            } else if (i2 < iArr[i4] && iArr[i4] <= i) {
                i3 -= iArr2[i4];
            }
        }
        return i3;
    }

    /* renamed from: a */
    static void m15875a(int[] iArr, int[] iArr2, C2525q c2525q) {
        if ((c2525q.f13202b & 4) == 0) {
            c2525q.f13204d = m15871a(iArr, iArr2, 0, c2525q.f13204d);
            c2525q.f13202b |= 4;
        }
    }
}
