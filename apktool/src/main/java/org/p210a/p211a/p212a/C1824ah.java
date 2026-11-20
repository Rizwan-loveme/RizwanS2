package org.p210a.p211a.p212a;

import java.util.Arrays;

/* compiled from: VocabularyImpl.java */
/* renamed from: org.a.a.a.ah */
/* loaded from: classes.dex */
public class C1824ah implements InterfaceC1823ag {

    /* renamed from: c */
    private final String[] f10850c;

    /* renamed from: d */
    private final String[] f10851d;

    /* renamed from: e */
    private final String[] f10852e;

    /* renamed from: f */
    private final int f10853f;

    /* renamed from: b */
    private static final String[] f10849b = new String[0];

    /* renamed from: a */
    public static final C1824ah f10848a = new C1824ah(f10849b, f10849b, f10849b);

    public C1824ah(String[] strArr, String[] strArr2) {
        this(strArr, strArr2, null);
    }

    public C1824ah(String[] strArr, String[] strArr2, String[] strArr3) {
        this.f10850c = strArr == null ? f10849b : strArr;
        this.f10851d = strArr2 == null ? f10849b : strArr2;
        this.f10852e = strArr3 == null ? f10849b : strArr3;
        this.f10853f = Math.max(this.f10852e.length, Math.max(this.f10850c.length, this.f10851d.length)) - 1;
    }

    /* renamed from: a */
    public static InterfaceC1823ag m13694a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return f10848a;
        }
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length);
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (!str.isEmpty()) {
                    char charAt = str.charAt(0);
                    if (charAt == '\'') {
                        strArr3[i] = null;
                    } else if (Character.isUpperCase(charAt)) {
                        strArr2[i] = null;
                    }
                }
                strArr2[i] = null;
                strArr3[i] = null;
            }
        }
        return new C1824ah(strArr2, strArr3, strArr);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1823ag
    /* renamed from: a */
    public int mo13690a() {
        return this.f10853f;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1823ag
    /* renamed from: a */
    public String mo13691a(int i) {
        if (i < 0 || i >= this.f10850c.length) {
            return null;
        }
        return this.f10850c[i];
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1823ag
    /* renamed from: b */
    public String mo13692b(int i) {
        if (i >= 0 && i < this.f10851d.length) {
            return this.f10851d[i];
        }
        if (i == -1) {
            return "EOF";
        }
        return null;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1823ag
    /* renamed from: c */
    public String mo13693c(int i) {
        String str;
        if (i < 0 || i >= this.f10852e.length || (str = this.f10852e[i]) == null) {
            String mo13691a = mo13691a(i);
            if (mo13691a == null) {
                String mo13692b = mo13692b(i);
                return mo13692b == null ? Integer.toString(i) : mo13692b;
            }
            return mo13691a;
        }
        return str;
    }
}
