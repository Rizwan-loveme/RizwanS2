package org.p271f.p272a;

import android.widget.ExpandableListView;

/* compiled from: ClassReader.java */
/* renamed from: org.f.a.f */
/* loaded from: classes.dex */
public class C2514f {

    /* renamed from: a */
    public final byte[] f13090a;

    /* renamed from: b */
    public final int f13091b;

    /* renamed from: c */
    private final int[] f13092c;

    /* renamed from: d */
    private final String[] f13093d;

    /* renamed from: e */
    private final int f13094e;

    public C2514f(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public C2514f(byte[] bArr, int i, int i2) {
        int i3;
        this.f13090a = bArr;
        if (m15795c(i + 6) > 52) {
            throw new IllegalArgumentException();
        }
        this.f13092c = new int[m15792b(i + 8)];
        int length = this.f13092c.length;
        this.f13093d = new String[length];
        int i4 = 0;
        int i5 = 1;
        int i6 = i + 10;
        while (i5 < length) {
            this.f13092c[i5] = i6 + 1;
            switch (bArr[i6]) {
                case 1:
                    int m15792b = m15792b(i6 + 1) + 3;
                    if (m15792b <= i4) {
                        i3 = m15792b;
                        break;
                    } else {
                        i3 = m15792b;
                        i4 = m15792b;
                        break;
                    }
                case 2:
                case 7:
                case 8:
                case 13:
                case 14:
                case 16:
                case 17:
                default:
                    i3 = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 18:
                    i3 = 5;
                    break;
                case 5:
                case 6:
                    i3 = 9;
                    i5++;
                    break;
                case 15:
                    i3 = 4;
                    break;
            }
            i5++;
            i6 = i3 + i6;
        }
        this.f13094e = i4;
        this.f13091b = i6;
    }

    /* renamed from: a */
    public void m15790a(AbstractC2515g abstractC2515g, int i) {
        m15791a(abstractC2515g, new C2512d[0], i);
    }

    /* renamed from: a */
    public void m15791a(AbstractC2515g abstractC2515g, C2512d[] c2512dArr, int i) {
        C2512d m15781a;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        int i7 = this.f13091b;
        char[] cArr = new char[this.f13094e];
        C2517i c2517i = new C2517i();
        c2517i.f13137a = c2512dArr;
        c2517i.f13138b = i;
        c2517i.f13139c = cArr;
        int m15792b = m15792b(i7);
        String m15793b = m15793b(i7 + 2, cArr);
        String m15793b2 = m15793b(i7 + 4, cArr);
        String[] strArr = new String[m15792b(i7 + 6)];
        int i8 = i7 + 8;
        for (int i9 = 0; i9 < strArr.length; i9++) {
            strArr[i9] = m15793b(i8, cArr);
            i8 += 2;
        }
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        C2512d c2512d = null;
        int m15773a = m15773a();
        int m15792b2 = m15792b(m15773a);
        int i15 = m15773a;
        while (m15792b2 > 0) {
            String m15788a = m15788a(i15 + 2, cArr);
            if ("SourceFile".equals(m15788a)) {
                str3 = m15788a(i15 + 8, cArr);
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("InnerClasses".equals(m15788a)) {
                i2 = i15 + 8;
                m15781a = c2512d;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("EnclosingMethod".equals(m15788a)) {
                str5 = m15793b(i15 + 8, cArr);
                int m15792b3 = m15792b(i15 + 10);
                if (m15792b3 != 0) {
                    str6 = m15788a(this.f13092c[m15792b3], cArr);
                    str = m15788a(this.f13092c[m15792b3] + 2, cArr);
                } else {
                    str = str7;
                }
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
            } else if ("Signature".equals(m15788a)) {
                str2 = m15788a(i15 + 8, cArr);
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("RuntimeVisibleAnnotations".equals(m15788a)) {
                i6 = i15 + 8;
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                str = str7;
            } else if ("RuntimeVisibleTypeAnnotations".equals(m15788a)) {
                i4 = i15 + 8;
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("Deprecated".equals(m15788a)) {
                m15792b |= 131072;
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("Synthetic".equals(m15788a)) {
                m15792b |= 266240;
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("SourceDebugExtension".equals(m15788a)) {
                int m15796d = m15796d(i15 + 4);
                str4 = m15780a(i15 + 8, m15796d, new char[m15796d]);
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("RuntimeInvisibleAnnotations".equals(m15788a)) {
                i5 = i15 + 8;
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i6 = i10;
                str = str7;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(m15788a)) {
                i3 = i15 + 8;
                m15781a = c2512d;
                i2 = i14;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else if ("BootstrapMethods".equals(m15788a)) {
                int[] iArr = new int[m15792b(i15 + 8)];
                int i16 = i15 + 10;
                for (int i17 = 0; i17 < iArr.length; i17++) {
                    iArr[i17] = i16;
                    i16 += (m15792b(i16 + 2) + 2) << 1;
                }
                c2517i.f13140d = iArr;
                m15781a = c2512d;
                i2 = i14;
                i3 = i13;
                i4 = i12;
                i5 = i11;
                i6 = i10;
                str = str7;
            } else {
                m15781a = m15781a(c2512dArr, m15788a, i15 + 8, m15796d(i15 + 4), cArr, -1, null);
                if (m15781a != null) {
                    m15781a.f13087c = c2512d;
                    i2 = i14;
                    i3 = i13;
                    i4 = i12;
                    i5 = i11;
                    i6 = i10;
                    str = str7;
                } else {
                    m15781a = c2512d;
                    i2 = i14;
                    i3 = i13;
                    i4 = i12;
                    i5 = i11;
                    i6 = i10;
                    str = str7;
                }
            }
            i15 += m15796d(i15 + 4) + 6;
            m15792b2--;
            c2512d = m15781a;
            i14 = i2;
            i13 = i3;
            i12 = i4;
            i11 = i5;
            i10 = i6;
            str7 = str;
        }
        abstractC2515g.mo15669a(m15796d(this.f13092c[1] - 7), m15792b, m15793b, str2, m15793b2, strArr);
        if ((i & 2) == 0 && (str3 != null || str4 != null)) {
            abstractC2515g.mo15798a(str3, str4);
        }
        if (str5 != null) {
            abstractC2515g.mo15670a(str5, str6, str7);
        }
        if (i10 != 0) {
            int i18 = i10 + 2;
            for (int m15792b4 = m15792b(i10); m15792b4 > 0; m15792b4--) {
                i18 = m15776a(i18 + 2, cArr, true, abstractC2515g.mo15663a(m15788a(i18, cArr), true));
            }
        }
        if (i11 != 0) {
            int i19 = i11 + 2;
            for (int m15792b5 = m15792b(i11); m15792b5 > 0; m15792b5--) {
                i19 = m15776a(i19 + 2, cArr, true, abstractC2515g.mo15663a(m15788a(i19, cArr), false));
            }
        }
        if (i12 != 0) {
            int i20 = i12 + 2;
            for (int m15792b6 = m15792b(i12); m15792b6 > 0; m15792b6--) {
                int m15778a = m15778a(c2517i, i20);
                i20 = m15776a(m15778a + 2, cArr, true, abstractC2515g.mo15662a(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a, cArr), true));
            }
        }
        if (i13 != 0) {
            int i21 = i13 + 2;
            for (int m15792b7 = m15792b(i13); m15792b7 > 0; m15792b7--) {
                int m15778a2 = m15778a(c2517i, i21);
                i21 = m15776a(m15778a2 + 2, cArr, true, abstractC2515g.mo15662a(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a2, cArr), false));
            }
        }
        while (c2512d != null) {
            C2512d c2512d2 = c2512d.f13087c;
            c2512d.f13087c = null;
            abstractC2515g.mo15799a(c2512d);
            c2512d = c2512d2;
        }
        if (i14 != 0) {
            int i22 = i14 + 2;
            for (int m15792b8 = m15792b(i14); m15792b8 > 0; m15792b8--) {
                abstractC2515g.mo15671a(m15793b(i22, cArr), m15793b(i22 + 2, cArr), m15788a(i22 + 4, cArr), m15792b(i22 + 6));
                i22 += 8;
            }
        }
        int length = (strArr.length * 2) + this.f13091b + 10;
        for (int m15792b9 = m15792b(length - 2); m15792b9 > 0; m15792b9--) {
            length = m15777a(abstractC2515g, c2517i, length);
        }
        int i23 = length + 2;
        for (int m15792b10 = m15792b(i23 - 2); m15792b10 > 0; m15792b10--) {
            i23 = m15785b(abstractC2515g, c2517i, i23);
        }
        abstractC2515g.mo10327a();
    }

    /* renamed from: a */
    private int m15777a(AbstractC2515g abstractC2515g, C2517i c2517i, int i) {
        C2512d m15781a;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char[] cArr = c2517i.f13139c;
        int m15792b = m15792b(i);
        String m15788a = m15788a(i + 2, cArr);
        String m15788a2 = m15788a(i + 4, cArr);
        int i7 = i + 6;
        String str = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        Object obj = null;
        C2512d c2512d = null;
        int m15792b2 = m15792b(i7);
        int i12 = i7;
        while (m15792b2 > 0) {
            String m15788a3 = m15788a(i12 + 2, cArr);
            if ("ConstantValue".equals(m15788a3)) {
                int m15792b3 = m15792b(i12 + 8);
                obj = m15792b3 == 0 ? null : m15794c(m15792b3, cArr);
                m15781a = c2512d;
                i2 = i11;
                i3 = i10;
                i4 = i9;
                i5 = i8;
                i6 = m15792b;
            } else if ("Signature".equals(m15788a3)) {
                str = m15788a(i12 + 8, cArr);
                m15781a = c2512d;
                i2 = i11;
                i3 = i10;
                i4 = i9;
                i5 = i8;
                i6 = m15792b;
            } else if ("Deprecated".equals(m15788a3)) {
                i6 = m15792b | 131072;
                m15781a = c2512d;
                i2 = i11;
                i3 = i10;
                i4 = i9;
                i5 = i8;
            } else if ("Synthetic".equals(m15788a3)) {
                i6 = m15792b | 266240;
                m15781a = c2512d;
                i2 = i11;
                i3 = i10;
                i4 = i9;
                i5 = i8;
            } else if ("RuntimeVisibleAnnotations".equals(m15788a3)) {
                i5 = i12 + 8;
                m15781a = c2512d;
                i2 = i11;
                i3 = i10;
                i4 = i9;
                i6 = m15792b;
            } else if ("RuntimeVisibleTypeAnnotations".equals(m15788a3)) {
                i3 = i12 + 8;
                m15781a = c2512d;
                i2 = i11;
                i4 = i9;
                i5 = i8;
                i6 = m15792b;
            } else if ("RuntimeInvisibleAnnotations".equals(m15788a3)) {
                i4 = i12 + 8;
                m15781a = c2512d;
                i2 = i11;
                i3 = i10;
                i5 = i8;
                i6 = m15792b;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(m15788a3)) {
                i2 = i12 + 8;
                m15781a = c2512d;
                i3 = i10;
                i4 = i9;
                i5 = i8;
                i6 = m15792b;
            } else {
                m15781a = m15781a(c2517i.f13137a, m15788a3, i12 + 8, m15796d(i12 + 4), cArr, -1, null);
                if (m15781a != null) {
                    m15781a.f13087c = c2512d;
                    i2 = i11;
                    i3 = i10;
                    i4 = i9;
                    i5 = i8;
                    i6 = m15792b;
                } else {
                    m15781a = c2512d;
                    i2 = i11;
                    i3 = i10;
                    i4 = i9;
                    i5 = i8;
                    i6 = m15792b;
                }
            }
            i12 += m15796d(i12 + 4) + 6;
            m15792b2--;
            c2512d = m15781a;
            i11 = i2;
            i10 = i3;
            i9 = i4;
            i8 = i5;
            m15792b = i6;
        }
        int i13 = i12 + 2;
        AbstractC2519k mo15665a = abstractC2515g.mo15665a(m15792b, m15788a, m15788a2, str, obj);
        if (mo15665a != null) {
            if (i8 != 0) {
                int i14 = i8 + 2;
                for (int m15792b4 = m15792b(i8); m15792b4 > 0; m15792b4--) {
                    i14 = m15776a(i14 + 2, cArr, true, mo15665a.mo15673a(m15788a(i14, cArr), true));
                }
            }
            if (i9 != 0) {
                int i15 = i9 + 2;
                for (int m15792b5 = m15792b(i9); m15792b5 > 0; m15792b5--) {
                    i15 = m15776a(i15 + 2, cArr, true, mo15665a.mo15673a(m15788a(i15, cArr), false));
                }
            }
            if (i10 != 0) {
                int i16 = i10 + 2;
                for (int m15792b6 = m15792b(i10); m15792b6 > 0; m15792b6--) {
                    int m15778a = m15778a(c2517i, i16);
                    i16 = m15776a(m15778a + 2, cArr, true, mo15665a.mo15672a(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a, cArr), true));
                }
            }
            if (i11 != 0) {
                int i17 = i11 + 2;
                for (int m15792b7 = m15792b(i11); m15792b7 > 0; m15792b7--) {
                    int m15778a2 = m15778a(c2517i, i17);
                    i17 = m15776a(m15778a2 + 2, cArr, true, mo15665a.mo15672a(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a2, cArr), false));
                }
            }
            while (c2512d != null) {
                C2512d c2512d2 = c2512d.f13087c;
                c2512d.f13087c = null;
                mo15665a.mo15831a(c2512d);
                c2512d = c2512d2;
            }
            mo15665a.mo15830a();
        }
        return i13;
    }

    /* renamed from: b */
    private int m15785b(AbstractC2515g abstractC2515g, C2517i c2517i, int i) {
        C2512d m15781a;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        char[] cArr = c2517i.f13139c;
        c2517i.f13141e = m15792b(i);
        c2517i.f13142f = m15788a(i + 2, cArr);
        c2517i.f13143g = m15788a(i + 4, cArr);
        int i10 = i + 6;
        int i11 = 0;
        int i12 = 0;
        String[] strArr = null;
        String str = null;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        C2512d c2512d = null;
        int m15792b = m15792b(i10);
        int i21 = i10;
        while (m15792b > 0) {
            String m15788a = m15788a(i21 + 2, cArr);
            if ("Code".equals(m15788a)) {
                if ((c2517i.f13138b & 1) == 0) {
                    i11 = i21 + 8;
                    m15781a = c2512d;
                    i2 = i20;
                    i3 = i19;
                    i4 = i18;
                    i5 = i17;
                    i6 = i16;
                    i7 = i15;
                    i8 = i14;
                    i9 = i13;
                }
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("Exceptions".equals(m15788a)) {
                strArr = new String[m15792b(i21 + 8)];
                i12 = i21 + 10;
                for (int i22 = 0; i22 < strArr.length; i22++) {
                    strArr[i22] = m15793b(i12, cArr);
                    i12 += 2;
                }
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("Signature".equals(m15788a)) {
                str = m15788a(i21 + 8, cArr);
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("Deprecated".equals(m15788a)) {
                c2517i.f13141e |= 131072;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("RuntimeVisibleAnnotations".equals(m15788a)) {
                i8 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i9 = i13;
            } else if ("RuntimeVisibleTypeAnnotations".equals(m15788a)) {
                i6 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("AnnotationDefault".equals(m15788a)) {
                i4 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("Synthetic".equals(m15788a)) {
                c2517i.f13141e |= 266240;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("RuntimeInvisibleAnnotations".equals(m15788a)) {
                i7 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i8 = i14;
                i9 = i13;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(m15788a)) {
                i5 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("RuntimeVisibleParameterAnnotations".equals(m15788a)) {
                i3 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("RuntimeInvisibleParameterAnnotations".equals(m15788a)) {
                i2 = i21 + 8;
                m15781a = c2512d;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            } else if ("MethodParameters".equals(m15788a)) {
                i9 = i21 + 8;
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
            } else {
                m15781a = m15781a(c2517i.f13137a, m15788a, i21 + 8, m15796d(i21 + 4), cArr, -1, null);
                if (m15781a != null) {
                    m15781a.f13087c = c2512d;
                    i2 = i20;
                    i3 = i19;
                    i4 = i18;
                    i5 = i17;
                    i6 = i16;
                    i7 = i15;
                    i8 = i14;
                    i9 = i13;
                }
                m15781a = c2512d;
                i2 = i20;
                i3 = i19;
                i4 = i18;
                i5 = i17;
                i6 = i16;
                i7 = i15;
                i8 = i14;
                i9 = i13;
            }
            i21 += m15796d(i21 + 4) + 6;
            m15792b--;
            c2512d = m15781a;
            i20 = i2;
            i19 = i3;
            i18 = i4;
            i17 = i5;
            i16 = i6;
            i15 = i7;
            i14 = i8;
            i13 = i9;
        }
        int i23 = i21 + 2;
        AbstractC2526r mo15667a = abstractC2515g.mo15667a(c2517i.f13141e, c2517i.f13142f, c2517i.f13143g, str, strArr);
        if (mo15667a == null) {
            return i23;
        }
        if (mo15667a instanceof C2527s) {
            C2527s c2527s = (C2527s) mo15667a;
            if (c2527s.f13242c.f13114d == this && str == c2527s.f13243d) {
                boolean z = false;
                if (strArr == null) {
                    z = c2527s.f13246g == 0;
                } else if (strArr.length == c2527s.f13246g) {
                    z = true;
                    int length = strArr.length - 1;
                    while (true) {
                        if (length < 0) {
                            break;
                        }
                        i12 -= 2;
                        if (c2527s.f13247h[length] != m15792b(i12)) {
                            z = false;
                            break;
                        }
                        length--;
                    }
                }
                if (z) {
                    c2527s.f13244e = i10;
                    c2527s.f13245f = i23 - i10;
                    return i23;
                }
            }
        }
        if (i13 != 0) {
            int i24 = this.f13090a[i13] & 255;
            int i25 = i13 + 1;
            while (i24 > 0) {
                mo15667a.mo15744a(m15788a(i25, cArr), m15792b(i25 + 2));
                i24--;
                i25 += 4;
            }
        }
        if (i18 != 0) {
            AbstractC2473a mo15676a = mo15667a.mo15676a();
            m15775a(i18, cArr, (String) null, mo15676a);
            if (mo15676a != null) {
                mo15676a.mo15637a();
            }
        }
        if (i14 != 0) {
            int i26 = i14 + 2;
            for (int m15792b2 = m15792b(i14); m15792b2 > 0; m15792b2--) {
                i26 = m15776a(i26 + 2, cArr, true, mo15667a.mo15679a(m15788a(i26, cArr), true));
            }
        }
        if (i15 != 0) {
            int i27 = i15 + 2;
            for (int m15792b3 = m15792b(i15); m15792b3 > 0; m15792b3--) {
                i27 = m15776a(i27 + 2, cArr, true, mo15667a.mo15679a(m15788a(i27, cArr), false));
            }
        }
        if (i16 != 0) {
            int i28 = i16 + 2;
            for (int m15792b4 = m15792b(i16); m15792b4 > 0; m15792b4--) {
                int m15778a = m15778a(c2517i, i28);
                i28 = m15776a(m15778a + 2, cArr, true, mo15667a.mo15678a(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a, cArr), true));
            }
        }
        if (i17 != 0) {
            int i29 = i17 + 2;
            for (int m15792b5 = m15792b(i17); m15792b5 > 0; m15792b5--) {
                int m15778a2 = m15778a(c2517i, i29);
                i29 = m15776a(m15778a2 + 2, cArr, true, mo15667a.mo15678a(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a2, cArr), false));
            }
        }
        if (i19 != 0) {
            m15786b(mo15667a, c2517i, i19, true);
        }
        if (i20 != 0) {
            m15786b(mo15667a, c2517i, i20, false);
        }
        while (c2512d != null) {
            C2512d c2512d2 = c2512d.f13087c;
            c2512d.f13087c = null;
            mo15667a.mo15745a(c2512d);
            c2512d = c2512d2;
        }
        if (i11 != 0) {
            mo15667a.mo15751b();
            m15783a(mo15667a, c2517i, i11);
        }
        mo15667a.mo15753c();
        return i23;
    }

    /* renamed from: a */
    private void m15783a(AbstractC2526r abstractC2526r, C2517i c2517i, int i) {
        C2517i c2517i2;
        int i2;
        int i3;
        int i4;
        int m15792b;
        C2512d c2512d;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        C2512d m15756a;
        int i9;
        byte[] bArr = this.f13090a;
        char[] cArr = c2517i.f13139c;
        int m15792b2 = m15792b(i);
        int m15792b3 = m15792b(i + 2);
        int m15796d = m15796d(i + 4);
        int i10 = i + 8;
        int i11 = i10 + m15796d;
        C2525q[] c2525qArr = new C2525q[m15796d + 2];
        c2517i.f13144h = c2525qArr;
        m15789a(m15796d + 1, c2525qArr);
        int i12 = i10;
        while (i12 < i11) {
            int i13 = i12 - i10;
            switch (C2516h.f13097c[bArr[i12] & 255]) {
                case 0:
                case 4:
                    i9 = i12 + 1;
                    break;
                case 1:
                case 3:
                case 11:
                    i9 = i12 + 2;
                    break;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    i9 = i12 + 3;
                    break;
                case 7:
                case 8:
                    i9 = i12 + 5;
                    break;
                case 9:
                    m15789a(m15795c(i12 + 1) + i13, c2525qArr);
                    i9 = i12 + 3;
                    break;
                case 10:
                    m15789a(m15796d(i12 + 1) + i13, c2525qArr);
                    i9 = i12 + 5;
                    break;
                case 14:
                    int i14 = (i12 + 4) - (i13 & 3);
                    m15789a(m15796d(i14) + i13, c2525qArr);
                    for (int m15796d2 = (m15796d(i14 + 8) - m15796d(i14 + 4)) + 1; m15796d2 > 0; m15796d2--) {
                        m15789a(m15796d(i14 + 12) + i13, c2525qArr);
                        i14 += 4;
                    }
                    i9 = i14 + 12;
                    break;
                case 15:
                    int i15 = (i12 + 4) - (i13 & 3);
                    m15789a(m15796d(i15) + i13, c2525qArr);
                    for (int m15796d3 = m15796d(i15 + 4); m15796d3 > 0; m15796d3--) {
                        m15789a(m15796d(i15 + 12) + i13, c2525qArr);
                        i15 += 8;
                    }
                    i9 = i15 + 8;
                    break;
                case 16:
                default:
                    i9 = i12 + 4;
                    break;
                case 17:
                    if ((bArr[i12 + 1] & 255) == 132) {
                        i9 = i12 + 6;
                        break;
                    } else {
                        i9 = i12 + 4;
                        break;
                    }
            }
            i12 = i9;
        }
        for (int m15792b4 = m15792b(i12); m15792b4 > 0; m15792b4--) {
            abstractC2526r.mo15684a(m15789a(m15792b(i12 + 2), c2525qArr), m15789a(m15792b(i12 + 4), c2525qArr), m15789a(m15792b(i12 + 6), c2525qArr), m15788a(this.f13092c[m15792b(i12 + 8)], cArr));
            i12 += 8;
        }
        int i16 = i12 + 2;
        int[] iArr = null;
        int[] iArr2 = null;
        int i17 = -1;
        int i18 = -1;
        int i19 = 0;
        int i20 = 0;
        boolean z2 = true;
        boolean z3 = (c2517i.f13138b & 8) != 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        C2512d c2512d2 = null;
        int m15792b5 = m15792b(i16);
        while (m15792b5 > 0) {
            String m15788a = m15788a(i16 + 2, cArr);
            if ("LocalVariableTable".equals(m15788a)) {
                if ((c2517i.f13138b & 2) == 0) {
                    int i24 = i16 + 8;
                    int i25 = i16;
                    for (int m15792b6 = m15792b(i16 + 8); m15792b6 > 0; m15792b6--) {
                        int m15792b7 = m15792b(i25 + 10);
                        if (c2525qArr[m15792b7] == null) {
                            m15789a(m15792b7, c2525qArr).f13202b |= 1;
                        }
                        int m15792b8 = m15792b7 + m15792b(i25 + 12);
                        if (c2525qArr[m15792b8] == null) {
                            m15789a(m15792b8, c2525qArr).f13202b |= 1;
                        }
                        i25 += 10;
                    }
                    c2512d = c2512d2;
                    i5 = i23;
                    i6 = i22;
                    i7 = i21;
                    z = z2;
                    i8 = i20;
                    i19 = i24;
                }
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
            } else if ("LocalVariableTypeTable".equals(m15788a)) {
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i16 + 8;
            } else if ("LineNumberTable".equals(m15788a)) {
                if ((c2517i.f13138b & 2) == 0) {
                    int i26 = i16;
                    for (int m15792b9 = m15792b(i16 + 8); m15792b9 > 0; m15792b9--) {
                        int m15792b10 = m15792b(i26 + 10);
                        if (c2525qArr[m15792b10] == null) {
                            m15789a(m15792b10, c2525qArr).f13202b |= 1;
                        }
                        c2525qArr[m15792b10].f13203c = m15792b(i26 + 12);
                        i26 += 4;
                    }
                    c2512d = c2512d2;
                    i5 = i23;
                    i6 = i22;
                    i7 = i21;
                    z = z2;
                    i8 = i20;
                }
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
            } else if ("RuntimeVisibleTypeAnnotations".equals(m15788a)) {
                iArr = m15784a(abstractC2526r, c2517i, i16 + 8, true);
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
                i17 = (iArr.length == 0 || m15787a(iArr[0]) < 67) ? -1 : m15792b(iArr[0] + 1);
            } else if ("RuntimeInvisibleTypeAnnotations".equals(m15788a)) {
                iArr2 = m15784a(abstractC2526r, c2517i, i16 + 8, false);
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
                i18 = (iArr2.length == 0 || m15787a(iArr2[0]) < 67) ? -1 : m15792b(iArr2[0] + 1);
            } else if ("StackMapTable".equals(m15788a)) {
                if ((c2517i.f13138b & 4) == 0) {
                    i7 = i16 + 10;
                    i6 = m15796d(i16 + 4);
                    i5 = m15792b(i16 + 8);
                    c2512d = c2512d2;
                    z = z2;
                    i8 = i20;
                }
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
            } else if ("StackMap".equals(m15788a)) {
                if ((c2517i.f13138b & 4) == 0) {
                    i7 = i16 + 10;
                    i6 = m15796d(i16 + 4);
                    i5 = m15792b(i16 + 8);
                    c2512d = c2512d2;
                    z = false;
                    i8 = i20;
                }
                c2512d = c2512d2;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
            } else {
                C2512d c2512d3 = c2512d2;
                for (int i27 = 0; i27 < c2517i.f13137a.length; i27++) {
                    if (c2517i.f13137a[i27].f13085a.equals(m15788a) && (m15756a = c2517i.f13137a[i27].m15756a(this, i16 + 8, m15796d(i16 + 4), cArr, i10 - 8, c2525qArr)) != null) {
                        m15756a.f13087c = c2512d3;
                        c2512d3 = m15756a;
                    }
                }
                c2512d = c2512d3;
                i5 = i23;
                i6 = i22;
                i7 = i21;
                z = z2;
                i8 = i20;
            }
            i16 += m15796d(i16 + 4) + 6;
            m15792b5--;
            c2512d2 = c2512d;
            i23 = i5;
            i22 = i6;
            i21 = i7;
            z2 = z;
            i20 = i8;
        }
        int i28 = i16 + 2;
        if (i21 == 0) {
            c2517i2 = null;
        } else {
            c2517i.f13147k = -1;
            c2517i.f13151o = 0;
            c2517i.f13152p = 0;
            c2517i.f13153q = 0;
            c2517i.f13155s = 0;
            c2517i.f13154r = new Object[m15792b3];
            c2517i.f13156t = new Object[m15792b2];
            if (z3) {
                m15782a(c2517i);
            }
            for (int i29 = i21; i29 < (i21 + i22) - 2; i29++) {
                if (bArr[i29] == 8 && (m15792b = m15792b(i29 + 1)) >= 0 && m15792b < m15796d && (bArr[i10 + m15792b] & 255) == 187) {
                    m15789a(m15792b, c2525qArr);
                }
            }
            c2517i2 = c2517i;
        }
        C2517i c2517i3 = c2517i2;
        int i30 = i23;
        int i31 = i18;
        int i32 = 0;
        int i33 = 0;
        for (int i34 = i10; i34 < i11; i34 = i4) {
            int i35 = i34 - i10;
            C2525q c2525q = c2525qArr[i35];
            if (c2525q != null) {
                abstractC2526r.mo15747a(c2525q);
                if ((c2517i.f13138b & 2) == 0 && c2525q.f13203c > 0) {
                    abstractC2526r.mo15752b(c2525q.f13203c, c2525q);
                }
            }
            C2517i c2517i4 = c2517i3;
            int i36 = i30;
            int i37 = i21;
            while (c2517i4 != null && (c2517i4.f13147k == i35 || c2517i4.f13147k == -1)) {
                if (c2517i4.f13147k != -1) {
                    if (!z2 || z3) {
                        abstractC2526r.mo15644a(-1, c2517i4.f13152p, c2517i4.f13154r, c2517i4.f13155s, c2517i4.f13156t);
                    } else {
                        abstractC2526r.mo15644a(c2517i4.f13151o, c2517i4.f13153q, c2517i4.f13154r, c2517i4.f13155s, c2517i4.f13156t);
                    }
                }
                if (i36 > 0) {
                    i36--;
                    i37 = m15774a(i37, z2, z3, c2517i4);
                } else {
                    c2517i4 = null;
                }
            }
            int i38 = bArr[i34] & 255;
            switch (C2516h.f13097c[i38]) {
                case 0:
                    abstractC2526r.mo15740a(i38);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 1;
                    break;
                case 1:
                    abstractC2526r.mo15741a(i38, bArr[i34 + 1]);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 2;
                    break;
                case 2:
                    abstractC2526r.mo15741a(i38, m15795c(i34 + 1));
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 3;
                    break;
                case 3:
                    abstractC2526r.mo15648b(i38, bArr[i34 + 1] & 255);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 2;
                    break;
                case 4:
                    if (i38 > 54) {
                        int i39 = i38 - 59;
                        abstractC2526r.mo15648b((i39 >> 2) + 54, i39 & 3);
                    } else {
                        int i40 = i38 - 26;
                        abstractC2526r.mo15648b((i40 >> 2) + 21, i40 & 3);
                    }
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 1;
                    break;
                case 5:
                    abstractC2526r.mo15680a(i38, m15793b(i34 + 1, cArr));
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 3;
                    break;
                case 6:
                case 7:
                    int i41 = this.f13092c[m15792b(i34 + 1)];
                    boolean z4 = bArr[i41 + (-1)] == 11;
                    String m15793b = m15793b(i41, cArr);
                    int i42 = this.f13092c[m15792b(i41 + 2)];
                    String m15788a2 = m15788a(i42, cArr);
                    String m15788a3 = m15788a(i42 + 2, cArr);
                    if (i38 < 182) {
                        abstractC2526r.mo15681a(i38, m15793b, m15788a2, m15788a3);
                    } else {
                        abstractC2526r.mo15682a(i38, m15793b, m15788a2, m15788a3, z4);
                    }
                    if (i38 == 185) {
                        i2 = i17;
                        i3 = i33;
                        i4 = i34 + 5;
                        break;
                    } else {
                        i2 = i17;
                        i3 = i33;
                        i4 = i34 + 3;
                        break;
                    }
                case 8:
                    int i43 = this.f13092c[m15792b(i34 + 1)];
                    int i44 = c2517i.f13140d[m15792b(i43)];
                    C2522n c2522n = (C2522n) m15794c(m15792b(i44), cArr);
                    int m15792b11 = m15792b(i44 + 2);
                    Object[] objArr = new Object[m15792b11];
                    int i45 = i44 + 4;
                    for (int i46 = 0; i46 < m15792b11; i46++) {
                        objArr[i46] = m15794c(m15792b(i45), cArr);
                        i45 += 2;
                    }
                    int i47 = this.f13092c[m15792b(i43 + 2)];
                    abstractC2526r.mo15683a(m15788a(i47, cArr), m15788a(i47 + 2, cArr), c2522n, objArr);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 5;
                    break;
                case 9:
                    abstractC2526r.mo15743a(i38, c2525qArr[m15795c(i34 + 1) + i35]);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 3;
                    break;
                case 10:
                    abstractC2526r.mo15743a(i38 - 33, c2525qArr[m15796d(i34 + 1) + i35]);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 5;
                    break;
                case 11:
                    abstractC2526r.mo10229a(m15794c(bArr[i34 + 1] & 255, cArr));
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 2;
                    break;
                case 12:
                    abstractC2526r.mo10229a(m15794c(m15792b(i34 + 1), cArr));
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 3;
                    break;
                case 13:
                    abstractC2526r.mo15649c(bArr[i34 + 1] & 255, bArr[i34 + 2]);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 3;
                    break;
                case 14:
                    int i48 = (i34 + 4) - (i35 & 3);
                    int m15796d4 = i35 + m15796d(i48);
                    int m15796d5 = m15796d(i48 + 4);
                    int m15796d6 = m15796d(i48 + 8);
                    C2525q[] c2525qArr2 = new C2525q[(m15796d6 - m15796d5) + 1];
                    int i49 = i48 + 12;
                    for (int i50 = 0; i50 < c2525qArr2.length; i50++) {
                        c2525qArr2[i50] = c2525qArr[m15796d(i49) + i35];
                        i49 += 4;
                    }
                    abstractC2526r.mo15742a(m15796d5, m15796d6, c2525qArr[m15796d4], c2525qArr2);
                    i2 = i17;
                    i3 = i33;
                    i4 = i49;
                    break;
                case 15:
                    int i51 = (i34 + 4) - (i35 & 3);
                    int m15796d7 = i35 + m15796d(i51);
                    int m15796d8 = m15796d(i51 + 4);
                    int[] iArr3 = new int[m15796d8];
                    C2525q[] c2525qArr3 = new C2525q[m15796d8];
                    int i52 = i51 + 8;
                    for (int i53 = 0; i53 < m15796d8; i53++) {
                        iArr3[i53] = m15796d(i52);
                        c2525qArr3[i53] = c2525qArr[m15796d(i52 + 4) + i35];
                        i52 += 8;
                    }
                    abstractC2526r.mo15748a(c2525qArr[m15796d7], iArr3, c2525qArr3);
                    i2 = i17;
                    i3 = i33;
                    i4 = i52;
                    break;
                case 16:
                default:
                    abstractC2526r.mo15687b(m15793b(i34 + 1, cArr), bArr[i34 + 3] & 255);
                    i2 = i17;
                    i3 = i33;
                    i4 = i34 + 4;
                    break;
                case 17:
                    int i54 = bArr[i34 + 1] & 255;
                    if (i54 == 132) {
                        abstractC2526r.mo15649c(m15792b(i34 + 2), m15795c(i34 + 4));
                        i2 = i17;
                        i3 = i33;
                        i4 = i34 + 6;
                        break;
                    } else {
                        abstractC2526r.mo15648b(i54, m15792b(i34 + 2));
                        i2 = i17;
                        i3 = i33;
                        i4 = i34 + 4;
                        break;
                    }
            }
            while (iArr != null && i3 < iArr.length && i2 <= i35) {
                if (i2 == i35) {
                    int m15778a = m15778a(c2517i, iArr[i3]);
                    m15776a(m15778a + 2, cArr, true, abstractC2526r.mo15685b(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a, cArr), true));
                }
                int i55 = i3 + 1;
                i2 = (i55 >= iArr.length || m15787a(iArr[i55]) < 67) ? -1 : m15792b(iArr[i55] + 1);
                i3 = i55;
            }
            int i56 = i31;
            int i57 = i32;
            while (iArr2 != null && i57 < iArr2.length && i56 <= i35) {
                if (i56 == i35) {
                    int m15778a2 = m15778a(c2517i, iArr2[i57]);
                    m15776a(m15778a2 + 2, cArr, true, abstractC2526r.mo15685b(c2517i.f13145i, c2517i.f13146j, m15788a(m15778a2, cArr), false));
                }
                i57++;
                i56 = (i57 >= iArr2.length || m15787a(iArr2[i57]) < 67) ? -1 : m15792b(iArr2[i57] + 1);
            }
            c2517i3 = c2517i4;
            i30 = i36;
            i21 = i37;
            i31 = i56;
            i17 = i2;
            i32 = i57;
            i33 = i3;
        }
        if (c2525qArr[m15796d] != null) {
            abstractC2526r.mo15747a(c2525qArr[m15796d]);
        }
        if ((c2517i.f13138b & 2) == 0 && i19 != 0) {
            int[] iArr4 = null;
            if (i20 != 0) {
                int i58 = i20 + 2;
                iArr4 = new int[m15792b(i20) * 3];
                int length = iArr4.length;
                while (length > 0) {
                    int i59 = length - 1;
                    iArr4[i59] = i58 + 6;
                    int i60 = i59 - 1;
                    iArr4[i60] = m15792b(i58 + 8);
                    length = i60 - 1;
                    iArr4[length] = m15792b(i58);
                    i58 += 10;
                }
            }
            int i61 = i19 + 2;
            for (int m15792b12 = m15792b(i19); m15792b12 > 0; m15792b12--) {
                int m15792b13 = m15792b(i61);
                int m15792b14 = m15792b(i61 + 2);
                int m15792b15 = m15792b(i61 + 8);
                String str = null;
                if (iArr4 != null) {
                    int i62 = 0;
                    while (true) {
                        if (i62 >= iArr4.length) {
                            break;
                        }
                        if (iArr4[i62] != m15792b13 || iArr4[i62 + 1] != m15792b15) {
                            i62 += 3;
                        } else {
                            str = m15788a(iArr4[i62 + 2], cArr);
                        }
                    }
                }
                abstractC2526r.mo15646a(m15788a(i61 + 4, cArr), m15788a(i61 + 6, cArr), str, c2525qArr[m15792b13], c2525qArr[m15792b13 + m15792b14], m15792b15);
                i61 += 10;
            }
        }
        if (iArr != null) {
            for (int i63 = 0; i63 < iArr.length; i63++) {
                if ((m15787a(iArr[i63]) >> 1) == 32) {
                    int m15778a3 = m15778a(c2517i, iArr[i63]);
                    m15776a(m15778a3 + 2, cArr, true, abstractC2526r.mo15643a(c2517i.f13145i, c2517i.f13146j, c2517i.f13148l, c2517i.f13149m, c2517i.f13150n, m15788a(m15778a3, cArr), true));
                }
            }
        }
        if (iArr2 != null) {
            for (int i64 = 0; i64 < iArr2.length; i64++) {
                if ((m15787a(iArr2[i64]) >> 1) == 32) {
                    int m15778a4 = m15778a(c2517i, iArr2[i64]);
                    m15776a(m15778a4 + 2, cArr, true, abstractC2526r.mo15643a(c2517i.f13145i, c2517i.f13146j, c2517i.f13148l, c2517i.f13149m, c2517i.f13150n, m15788a(m15778a4, cArr), false));
                }
            }
        }
        while (c2512d2 != null) {
            C2512d c2512d4 = c2512d2.f13087c;
            c2512d2.f13087c = null;
            abstractC2526r.mo15745a(c2512d2);
            c2512d2 = c2512d4;
        }
        abstractC2526r.mo15650d(m15792b2, m15792b3);
    }

    /* renamed from: a */
    private int[] m15784a(AbstractC2526r abstractC2526r, C2517i c2517i, int i, boolean z) {
        int i2;
        char[] cArr = c2517i.f13139c;
        int[] iArr = new int[m15792b(i)];
        int i3 = i + 2;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = i3;
            int m15796d = m15796d(i3);
            switch (m15796d >>> 24) {
                case 0:
                case 1:
                case 22:
                    i2 = i3 + 2;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = i3 + 1;
                    break;
                case 64:
                case 65:
                    int i5 = i3;
                    for (int m15792b = m15792b(i3 + 1); m15792b > 0; m15792b--) {
                        int m15792b2 = m15792b(i5 + 3);
                        int m15792b3 = m15792b(i5 + 5);
                        m15789a(m15792b2, c2517i.f13144h);
                        m15789a(m15792b2 + m15792b3, c2517i.f13144h);
                        i5 += 6;
                    }
                    i2 = i5 + 3;
                    break;
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    i2 = i3 + 4;
                    break;
                default:
                    i2 = i3 + 3;
                    break;
            }
            int m15787a = m15787a(i2);
            if ((m15796d >>> 24) == 66) {
                C2530v c2530v = m15787a == 0 ? null : new C2530v(this.f13090a, i2);
                int i6 = i2 + (m15787a * 2) + 1;
                i3 = m15776a(i6 + 2, cArr, true, abstractC2526r.mo15688c(m15796d, c2530v, m15788a(i6, cArr), z));
            } else {
                i3 = m15776a(i2 + 3 + (m15787a * 2), cArr, true, (AbstractC2473a) null);
            }
        }
        return iArr;
    }

    /* renamed from: a */
    private int m15778a(C2517i c2517i, int i) {
        int i2;
        int i3;
        int m15796d = m15796d(i);
        switch (m15796d >>> 24) {
            case 0:
            case 1:
            case 22:
                i2 = (-65536) & m15796d;
                i3 = i + 2;
                break;
            case 19:
            case 20:
            case 21:
                i2 = (-16777216) & m15796d;
                i3 = i + 1;
                break;
            case 64:
            case 65:
                i2 = (-16777216) & m15796d;
                int m15792b = m15792b(i + 1);
                c2517i.f13148l = new C2525q[m15792b];
                c2517i.f13149m = new C2525q[m15792b];
                c2517i.f13150n = new int[m15792b];
                i3 = i + 3;
                for (int i4 = 0; i4 < m15792b; i4++) {
                    int m15792b2 = m15792b(i3);
                    int m15792b3 = m15792b(i3 + 2);
                    c2517i.f13148l[i4] = m15789a(m15792b2, c2517i.f13144h);
                    c2517i.f13149m[i4] = m15789a(m15792b2 + m15792b3, c2517i.f13144h);
                    c2517i.f13150n[i4] = m15792b(i3 + 4);
                    i3 += 6;
                }
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                i2 = (-16776961) & m15796d;
                i3 = i + 4;
                break;
            default:
                i2 = ((m15796d >>> 24) < 67 ? -256 : -16777216) & m15796d;
                i3 = i + 3;
                break;
        }
        int m15787a = m15787a(i3);
        c2517i.f13145i = i2;
        c2517i.f13146j = m15787a == 0 ? null : new C2530v(this.f13090a, i3);
        return i3 + 1 + (m15787a * 2);
    }

    /* renamed from: b */
    private void m15786b(AbstractC2526r abstractC2526r, C2517i c2517i, int i, boolean z) {
        int i2 = i + 1;
        int i3 = this.f13090a[i] & 255;
        int length = C2529u.m15893d(c2517i.f13143g).length - i3;
        int i4 = 0;
        while (i4 < length) {
            AbstractC2473a mo15677a = abstractC2526r.mo15677a(i4, "Ljava/lang/Synthetic;", false);
            if (mo15677a != null) {
                mo15677a.mo15637a();
            }
            i4++;
        }
        char[] cArr = c2517i.f13139c;
        while (true) {
            int i5 = i4;
            if (i5 < i3 + length) {
                i2 += 2;
                for (int m15792b = m15792b(i2); m15792b > 0; m15792b--) {
                    i2 = m15776a(i2 + 2, cArr, true, abstractC2526r.mo15677a(i5, m15788a(i2, cArr), z));
                }
                i4 = i5 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private int m15776a(int i, char[] cArr, boolean z, AbstractC2473a abstractC2473a) {
        int m15792b = m15792b(i);
        int i2 = i + 2;
        if (z) {
            while (m15792b > 0) {
                i2 = m15775a(i2 + 2, cArr, m15788a(i2, cArr), abstractC2473a);
                m15792b--;
            }
        } else {
            while (m15792b > 0) {
                i2 = m15775a(i2, cArr, (String) null, abstractC2473a);
                m15792b--;
            }
        }
        if (abstractC2473a != null) {
            abstractC2473a.mo15637a();
        }
        return i2;
    }

    /* renamed from: a */
    private int m15775a(int i, char[] cArr, String str, AbstractC2473a abstractC2473a) {
        int i2 = 0;
        if (abstractC2473a == null) {
            switch (this.f13090a[i] & 255) {
                case 64:
                    return m15776a(i + 3, cArr, true, (AbstractC2473a) null);
                case 91:
                    return m15776a(i + 1, cArr, false, (AbstractC2473a) null);
                case 101:
                    return i + 5;
                default:
                    return i + 3;
            }
        }
        int i3 = i + 1;
        switch (this.f13090a[i] & 255) {
            case 64:
                return m15776a(i3 + 2, cArr, true, abstractC2473a.mo15636a(str, m15788a(i3, cArr)));
            case 66:
                abstractC2473a.mo15638a(str, new Byte((byte) m15796d(this.f13092c[m15792b(i3)])));
                return i3 + 2;
            case 67:
                abstractC2473a.mo15638a(str, new Character((char) m15796d(this.f13092c[m15792b(i3)])));
                return i3 + 2;
            case 68:
            case 70:
            case 73:
            case 74:
                abstractC2473a.mo15638a(str, m15794c(m15792b(i3), cArr));
                return i3 + 2;
            case 83:
                abstractC2473a.mo15638a(str, new Short((short) m15796d(this.f13092c[m15792b(i3)])));
                return i3 + 2;
            case 90:
                abstractC2473a.mo15638a(str, m15796d(this.f13092c[m15792b(i3)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                return i3 + 2;
            case 91:
                int m15792b = m15792b(i3);
                int i4 = i3 + 2;
                if (m15792b == 0) {
                    return m15776a(i4 - 2, cArr, false, abstractC2473a.mo15635a(str));
                }
                int i5 = i4 + 1;
                switch (this.f13090a[i4] & 255) {
                    case 66:
                        byte[] bArr = new byte[m15792b];
                        while (i2 < m15792b) {
                            bArr[i2] = (byte) m15796d(this.f13092c[m15792b(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, bArr);
                        return i5 - 1;
                    case 67:
                        char[] cArr2 = new char[m15792b];
                        while (i2 < m15792b) {
                            cArr2[i2] = (char) m15796d(this.f13092c[m15792b(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, cArr2);
                        return i5 - 1;
                    case 68:
                        double[] dArr = new double[m15792b];
                        while (i2 < m15792b) {
                            dArr[i2] = Double.longBitsToDouble(m15797e(this.f13092c[m15792b(i5)]));
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, dArr);
                        return i5 - 1;
                    case 70:
                        float[] fArr = new float[m15792b];
                        while (i2 < m15792b) {
                            fArr[i2] = Float.intBitsToFloat(m15796d(this.f13092c[m15792b(i5)]));
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, fArr);
                        return i5 - 1;
                    case 73:
                        int[] iArr = new int[m15792b];
                        while (i2 < m15792b) {
                            iArr[i2] = m15796d(this.f13092c[m15792b(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, iArr);
                        return i5 - 1;
                    case 74:
                        long[] jArr = new long[m15792b];
                        while (i2 < m15792b) {
                            jArr[i2] = m15797e(this.f13092c[m15792b(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, jArr);
                        return i5 - 1;
                    case 83:
                        short[] sArr = new short[m15792b];
                        while (i2 < m15792b) {
                            sArr[i2] = (short) m15796d(this.f13092c[m15792b(i5)]);
                            i5 += 3;
                            i2++;
                        }
                        abstractC2473a.mo15638a(str, sArr);
                        return i5 - 1;
                    case 90:
                        boolean[] zArr = new boolean[m15792b];
                        int i6 = i5;
                        for (int i7 = 0; i7 < m15792b; i7++) {
                            zArr[i7] = m15796d(this.f13092c[m15792b(i6)]) != 0;
                            i6 += 3;
                        }
                        abstractC2473a.mo15638a(str, zArr);
                        return i6 - 1;
                    default:
                        return m15776a(i5 - 3, cArr, false, abstractC2473a.mo15635a(str));
                }
            case 99:
                abstractC2473a.mo15638a(str, C2529u.m15888a(m15788a(i3, cArr)));
                return i3 + 2;
            case 101:
                abstractC2473a.mo15639a(str, m15788a(i3, cArr), m15788a(i3 + 2, cArr));
                return i3 + 4;
            case 115:
                abstractC2473a.mo15638a(str, m15788a(i3, cArr));
                return i3 + 2;
            default:
                return i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        r9.f13152p = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m15782a(C2517i c2517i) {
        int i = 1;
        String str = c2517i.f13143g;
        Object[] objArr = c2517i.f13154r;
        int i2 = 0;
        if ((c2517i.f13141e & 8) == 0) {
            if ("<init>".equals(c2517i.f13142f)) {
                objArr[0] = InterfaceC2528t.f13272g;
                i2 = 1;
            } else {
                objArr[0] = m15793b(this.f13091b + 2, c2517i.f13139c);
                i2 = 1;
            }
        }
        while (true) {
            int i3 = i + 1;
            switch (str.charAt(i)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    objArr[i2] = InterfaceC2528t.f13267b;
                    i = i3;
                    i2++;
                    break;
                case 'D':
                    objArr[i2] = InterfaceC2528t.f13269d;
                    i = i3;
                    i2++;
                    break;
                case 'F':
                    objArr[i2] = InterfaceC2528t.f13268c;
                    i = i3;
                    i2++;
                    break;
                case 'J':
                    objArr[i2] = InterfaceC2528t.f13270e;
                    i = i3;
                    i2++;
                    break;
                case 'L':
                    while (str.charAt(i3) != ';') {
                        i3++;
                    }
                    int i4 = i + 1;
                    i = i3 + 1;
                    objArr[i2] = str.substring(i4, i3);
                    i2++;
                    break;
                case '[':
                    while (str.charAt(i3) == '[') {
                        i3++;
                    }
                    if (str.charAt(i3) == 'L') {
                        do {
                            i3++;
                        } while (str.charAt(i3) != ';');
                    }
                    int i5 = i3 + 1;
                    objArr[i2] = str.substring(i, i5);
                    i = i5;
                    i2++;
                    break;
            }
        }
    }

    /* renamed from: a */
    private int m15774a(int i, boolean z, boolean z2, C2517i c2517i) {
        int i2;
        int i3;
        char[] cArr = c2517i.f13139c;
        C2525q[] c2525qArr = c2517i.f13144h;
        if (z) {
            i3 = i + 1;
            i2 = this.f13090a[i] & 255;
        } else {
            c2517i.f13147k = -1;
            i2 = 255;
            i3 = i;
        }
        c2517i.f13153q = 0;
        if (i2 < 64) {
            c2517i.f13151o = 3;
            c2517i.f13155s = 0;
        } else if (i2 < 128) {
            i2 -= 64;
            i3 = m15779a(c2517i.f13156t, 0, i3, cArr, c2525qArr);
            c2517i.f13151o = 4;
            c2517i.f13155s = 1;
        } else {
            int m15792b = m15792b(i3);
            i3 += 2;
            if (i2 == 247) {
                i3 = m15779a(c2517i.f13156t, 0, i3, cArr, c2525qArr);
                c2517i.f13151o = 4;
                c2517i.f13155s = 1;
                i2 = m15792b;
            } else if (i2 >= 248 && i2 < 251) {
                c2517i.f13151o = 2;
                c2517i.f13153q = 251 - i2;
                c2517i.f13152p -= c2517i.f13153q;
                c2517i.f13155s = 0;
                i2 = m15792b;
            } else if (i2 == 251) {
                c2517i.f13151o = 3;
                c2517i.f13155s = 0;
                i2 = m15792b;
            } else if (i2 < 255) {
                int i4 = i2 - 251;
                int i5 = z2 ? c2517i.f13152p : 0;
                while (i4 > 0) {
                    i3 = m15779a(c2517i.f13154r, i5, i3, cArr, c2525qArr);
                    i4--;
                    i5++;
                }
                c2517i.f13151o = 1;
                c2517i.f13153q = i2 - 251;
                c2517i.f13152p += c2517i.f13153q;
                c2517i.f13155s = 0;
                i2 = m15792b;
            } else {
                c2517i.f13151o = 0;
                int m15792b2 = m15792b(i3);
                int i6 = i3 + 2;
                c2517i.f13153q = m15792b2;
                c2517i.f13152p = m15792b2;
                int i7 = 0;
                for (int i8 = m15792b2; i8 > 0; i8--) {
                    i6 = m15779a(c2517i.f13154r, i7, i6, cArr, c2525qArr);
                    i7++;
                }
                int m15792b3 = m15792b(i6);
                i3 = i6 + 2;
                c2517i.f13155s = m15792b3;
                int i9 = 0;
                for (int i10 = m15792b3; i10 > 0; i10--) {
                    i3 = m15779a(c2517i.f13156t, i9, i3, cArr, c2525qArr);
                    i9++;
                }
                i2 = m15792b;
            }
        }
        c2517i.f13147k += i2 + 1;
        m15789a(c2517i.f13147k, c2525qArr);
        return i3;
    }

    /* renamed from: a */
    private int m15779a(Object[] objArr, int i, int i2, char[] cArr, C2525q[] c2525qArr) {
        int i3 = i2 + 1;
        switch (this.f13090a[i2] & 255) {
            case 0:
                objArr[i] = InterfaceC2528t.f13266a;
                return i3;
            case 1:
                objArr[i] = InterfaceC2528t.f13267b;
                return i3;
            case 2:
                objArr[i] = InterfaceC2528t.f13268c;
                return i3;
            case 3:
                objArr[i] = InterfaceC2528t.f13269d;
                return i3;
            case 4:
                objArr[i] = InterfaceC2528t.f13270e;
                return i3;
            case 5:
                objArr[i] = InterfaceC2528t.f13271f;
                return i3;
            case 6:
                objArr[i] = InterfaceC2528t.f13272g;
                return i3;
            case 7:
                objArr[i] = m15793b(i3, cArr);
                return i3 + 2;
            default:
                objArr[i] = m15789a(m15792b(i3), c2525qArr);
                return i3 + 2;
        }
    }

    /* renamed from: a */
    protected C2525q m15789a(int i, C2525q[] c2525qArr) {
        if (c2525qArr[i] == null) {
            c2525qArr[i] = new C2525q();
        }
        return c2525qArr[i];
    }

    /* renamed from: a */
    private int m15773a() {
        int m15792b = (m15792b(this.f13091b + 6) * 2) + this.f13091b + 8;
        for (int m15792b2 = m15792b(m15792b); m15792b2 > 0; m15792b2--) {
            for (int m15792b3 = m15792b(m15792b + 8); m15792b3 > 0; m15792b3--) {
                m15792b += m15796d(m15792b + 12) + 6;
            }
            m15792b += 8;
        }
        int i = m15792b + 2;
        for (int m15792b4 = m15792b(i); m15792b4 > 0; m15792b4--) {
            for (int m15792b5 = m15792b(i + 8); m15792b5 > 0; m15792b5--) {
                i += m15796d(i + 12) + 6;
            }
            i += 8;
        }
        return i + 2;
    }

    /* renamed from: a */
    private C2512d m15781a(C2512d[] c2512dArr, String str, int i, int i2, char[] cArr, int i3, C2525q[] c2525qArr) {
        for (int i4 = 0; i4 < c2512dArr.length; i4++) {
            if (c2512dArr[i4].f13085a.equals(str)) {
                return c2512dArr[i4].m15756a(this, i, i2, cArr, i3, c2525qArr);
            }
        }
        return new C2512d(str).m15756a(this, i, i2, (char[]) null, -1, (C2525q[]) null);
    }

    /* renamed from: a */
    public int m15787a(int i) {
        return this.f13090a[i] & 255;
    }

    /* renamed from: b */
    public int m15792b(int i) {
        byte[] bArr = this.f13090a;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* renamed from: c */
    public short m15795c(int i) {
        byte[] bArr = this.f13090a;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    /* renamed from: d */
    public int m15796d(int i) {
        byte[] bArr = this.f13090a;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: e */
    public long m15797e(int i) {
        return (m15796d(i) << 32) | (m15796d(i + 4) & ExpandableListView.PACKED_POSITION_VALUE_NULL);
    }

    /* renamed from: a */
    public String m15788a(int i, char[] cArr) {
        int m15792b = m15792b(i);
        if (i == 0 || m15792b == 0) {
            return null;
        }
        String str = this.f13093d[m15792b];
        if (str == null) {
            int i2 = this.f13092c[m15792b];
            String[] strArr = this.f13093d;
            String m15780a = m15780a(i2 + 2, m15792b(i2), cArr);
            strArr[m15792b] = m15780a;
            return m15780a;
        }
        return str;
    }

    /* renamed from: a */
    private String m15780a(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i + i2;
        byte[] bArr = this.f13090a;
        char c2 = 0;
        char c3 = 0;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            switch (c3) {
                case 0:
                    int i7 = b2 & 255;
                    if (i7 < 128) {
                        i3 = i5 + 1;
                        cArr[i5] = (char) i7;
                        break;
                    } else if (i7 < 224 && i7 > 191) {
                        c2 = (char) (i7 & 31);
                        c3 = 1;
                        i3 = i5;
                        break;
                    } else {
                        c2 = (char) (i7 & 15);
                        c3 = 2;
                        i3 = i5;
                        break;
                    }
                case 1:
                    i3 = i5 + 1;
                    cArr[i5] = (char) ((c2 << 6) | (b2 & 63));
                    c3 = 0;
                    break;
                case 2:
                    c2 = (char) ((c2 << 6) | (b2 & 63));
                    c3 = 1;
                    i3 = i5;
                    break;
                default:
                    i3 = i5;
                    break;
            }
            i5 = i3;
            i = i6;
        }
        return new String(cArr, 0, i5);
    }

    /* renamed from: b */
    public String m15793b(int i, char[] cArr) {
        return m15788a(this.f13092c[m15792b(i)], cArr);
    }

    /* renamed from: c */
    public Object m15794c(int i, char[] cArr) {
        int i2 = this.f13092c[i];
        switch (this.f13090a[i2 - 1]) {
            case 3:
                return new Integer(m15796d(i2));
            case 4:
                return new Float(Float.intBitsToFloat(m15796d(i2)));
            case 5:
                return new Long(m15797e(i2));
            case 6:
                return new Double(Double.longBitsToDouble(m15797e(i2)));
            case 7:
                return C2529u.m15891b(m15788a(i2, cArr));
            case 8:
                return m15788a(i2, cArr);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                int m15787a = m15787a(i2);
                int[] iArr = this.f13092c;
                int i3 = iArr[m15792b(i2 + 1)];
                String m15793b = m15793b(i3, cArr);
                int i4 = iArr[m15792b(i3 + 2)];
                return new C2522n(m15787a, m15793b, m15788a(i4, cArr), m15788a(i4 + 2, cArr));
            case 16:
                return C2529u.m15892c(m15788a(i2, cArr));
        }
    }
}
