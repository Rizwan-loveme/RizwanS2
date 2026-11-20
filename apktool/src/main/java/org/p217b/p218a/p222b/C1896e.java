package org.p217b.p218a.p222b;

import java.util.ArrayList;

/* compiled from: StringUtils.java */
/* renamed from: org.b.a.b.e */
/* loaded from: classes.dex */
public class C1896e {
    /* renamed from: a */
    public static String[] m14014a(String str, String str2) {
        return m14015a(str, str2, -1, false);
    }

    /* renamed from: a */
    private static String[] m14015a(String str, String str2, int i, boolean z) {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int i4;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return C1888a.f11054c;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            z2 = false;
            z3 = false;
            i2 = 0;
            i3 = 0;
            int i5 = 1;
            while (i3 < length) {
                if (Character.isWhitespace(str.charAt(i3))) {
                    if (z3 || z) {
                        int i6 = i5 + 1;
                        if (i5 == i) {
                            z2 = false;
                            i3 = length;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i2, i3));
                        z3 = false;
                        i5 = i6;
                    }
                    int i7 = i3 + 1;
                    i2 = i7;
                    i3 = i7;
                } else {
                    i3++;
                    z2 = false;
                    z3 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                z2 = false;
                z3 = false;
                int i8 = 0;
                i3 = 0;
                int i9 = 1;
                while (i3 < length) {
                    if (str.charAt(i3) == charAt) {
                        if (z3 || z) {
                            int i10 = i9 + 1;
                            if (i9 == i) {
                                z2 = false;
                                i3 = length;
                            } else {
                                z2 = true;
                            }
                            arrayList.add(str.substring(i8, i3));
                            z3 = false;
                            i9 = i10;
                        }
                        int i11 = i3 + 1;
                        i8 = i11;
                        i3 = i11;
                    } else {
                        i3++;
                        z2 = false;
                        z3 = true;
                    }
                }
                i4 = i8;
                if (!z3 || (z && z2)) {
                    arrayList.add(str.substring(i4, i3));
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            z2 = false;
            z3 = false;
            i2 = 0;
            i3 = 0;
            int i12 = 1;
            while (i3 < length) {
                if (str2.indexOf(str.charAt(i3)) >= 0) {
                    if (z3 || z) {
                        int i13 = i12 + 1;
                        if (i12 == i) {
                            z2 = false;
                            i3 = length;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i2, i3));
                        z3 = false;
                        i12 = i13;
                    }
                    int i14 = i3 + 1;
                    i2 = i14;
                    i3 = i14;
                } else {
                    i3++;
                    z2 = false;
                    z3 = true;
                }
            }
        }
        i4 = i2;
        if (!z3) {
        }
        arrayList.add(str.substring(i4, i3));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
