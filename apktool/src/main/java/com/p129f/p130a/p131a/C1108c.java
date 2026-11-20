package com.p129f.p130a.p131a;

/* compiled from: Ascii.java */
/* renamed from: com.f.a.a.c */
/* loaded from: classes.dex */
public final class C1108c {
    /* renamed from: a */
    public static String m9502a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (!m9503a(str.charAt(i))) {
                i++;
            } else {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (m9503a(c2)) {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m9503a(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }
}
