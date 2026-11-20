package com.p065b.p111c.p113b.p114a.p116b;

import android.security.keystore.KeyProperties;

/* compiled from: ContentDigestAlgorithm.java */
/* renamed from: com.b.c.b.a.b.a */
/* loaded from: classes.dex */
public enum EnumC1046a {
    CHUNKED_SHA256(KeyProperties.DIGEST_SHA256, 32),
    CHUNKED_SHA512(KeyProperties.DIGEST_SHA512, 64);


    /* renamed from: d */
    private final int f6623d;

    /* renamed from: e */
    private final String f6624e;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1046a[] valuesCustom() {
        EnumC1046a[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1046a[] enumC1046aArr = new EnumC1046a[length];
        System.arraycopy(valuesCustom, 0, enumC1046aArr, 0, length);
        return enumC1046aArr;
    }

    EnumC1046a(String str, int i) {
        this.f6624e = str;
        this.f6623d = i;
    }

    /* renamed from: b */
    String m8754b() {
        return this.f6624e;
    }

    /* renamed from: a */
    int m8753a() {
        return this.f6623d;
    }
}
