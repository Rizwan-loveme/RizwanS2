package com.p065b.p066a;

import java.nio.charset.Charset;

/* compiled from: Utils.java */
/* renamed from: com.b.a.h */
/* loaded from: classes.dex */
public class C0681h {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* renamed from: a */
    public static int m6494a(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("Integer overflow (" + j + ")!");
    }
}
