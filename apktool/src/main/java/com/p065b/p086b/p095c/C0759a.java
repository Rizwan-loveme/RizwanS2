package com.p065b.p086b.p095c;

/* compiled from: DexFormat.java */
/* renamed from: com.b.b.c.a */
/* loaded from: classes.dex */
public final class C0759a {
    /* renamed from: a */
    public static int m6936a(byte[] bArr) {
        if (bArr.length != 8 || bArr[0] != 100 || bArr[1] != 101 || bArr[2] != 120 || bArr[3] != 10 || bArr[7] != 0) {
            return -1;
        }
        String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
        if (str.equals("036")) {
            return 14;
        }
        return str.equals("035") ? 13 : -1;
    }

    /* renamed from: a */
    public static String m6937a(int i) {
        String str;
        if (i >= 14) {
            str = "036";
        } else {
            str = "035";
        }
        return "dex\n" + str + "\u0000";
    }
}
