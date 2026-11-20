package com.p065b.p066a.p068b.p069a;

import android.security.keystore.KeyProperties;

/* compiled from: ContentDigestAlgorithm.java */
/* renamed from: com.b.a.b.a.g */
/* loaded from: classes.dex */
public enum EnumC0607g {
    CHUNKED_SHA256(1, KeyProperties.DIGEST_SHA256, 32),
    CHUNKED_SHA512(2, KeyProperties.DIGEST_SHA512, 64),
    VERITY_CHUNKED_SHA256(3, KeyProperties.DIGEST_SHA256, 32),
    SHA256(4, KeyProperties.DIGEST_SHA256, 32);


    /* renamed from: a */
    private final int f4183a;

    /* renamed from: b */
    private final int f4184b;

    /* renamed from: c */
    private final String f4185c;

    EnumC0607g(int i, String str, int i2) {
        this.f4184b = i;
        this.f4185c = str;
        this.f4183a = i2;
    }

    /* renamed from: b */
    public int m6076b() {
        return this.f4184b;
    }

    /* renamed from: c */
    String m6077c() {
        return this.f4185c;
    }

    /* renamed from: a */
    int m6075a() {
        return this.f4183a;
    }
}
