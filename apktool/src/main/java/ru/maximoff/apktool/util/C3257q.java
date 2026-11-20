package ru.maximoff.apktool.util;

import android.util.Base64;

/* compiled from: EncryptUtils.java */
/* renamed from: ru.maximoff.apktool.util.q */
/* loaded from: classes.dex */
public class C3257q {
    /* renamed from: a */
    public static String m19518a(String str, String str2) {
        return m19517a(m19521c(str, str2));
    }

    /* renamed from: b */
    public static String m19520b(String str, String str2) {
        return m19521c(m19519b(str), str2);
    }

    /* renamed from: a */
    public static String m19517a(String str) {
        try {
            return new String(Base64.encode(str.getBytes(), 2));
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: b */
    public static String m19519b(String str) {
        try {
            return new String(Base64.decode(str.getBytes(), 2));
        } catch (Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: c */
    public static String m19521c(String str, String str2) {
        try {
            if (str == null || str2 == null) {
                return (String) null;
            }
            char[] charArray = str2.toCharArray();
            char[] charArray2 = str.toCharArray();
            int length = charArray2.length;
            int length2 = charArray.length;
            char[] cArr = new char[length];
            for (int i = 0; i < length; i++) {
                cArr[i] = (char) (charArray2[i] ^ charArray[i % length2]);
            }
            return new String(cArr);
        } catch (Exception e2) {
            return (String) null;
        }
    }
}
