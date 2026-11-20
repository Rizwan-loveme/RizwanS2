package com.p065b.p066a.p068b.p069a;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p068b.p081g.C0652k;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* compiled from: SignatureAlgorithm.java */
/* renamed from: com.b.a.b.a.i */
/* loaded from: classes.dex */
public enum EnumC0609i {
    RSA_PSS_WITH_SHA256(257, EnumC0607g.CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_RSA, C0652k.m6250a("SHA256withRSA/PSS", new PSSParameterSpec(KeyProperties.DIGEST_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1)), 24, 23),
    RSA_PSS_WITH_SHA512(258, EnumC0607g.CHUNKED_SHA512, KeyProperties.KEY_ALGORITHM_RSA, C0652k.m6250a("SHA512withRSA/PSS", new PSSParameterSpec(KeyProperties.DIGEST_SHA512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1)), 24, 23),
    RSA_PKCS1_V1_5_WITH_SHA256(259, EnumC0607g.CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_RSA, C0652k.m6250a("SHA256withRSA", null), 24, 1),
    RSA_PKCS1_V1_5_WITH_SHA512(260, EnumC0607g.CHUNKED_SHA512, KeyProperties.KEY_ALGORITHM_RSA, C0652k.m6250a("SHA512withRSA", null), 24, 1),
    ECDSA_WITH_SHA256(513, EnumC0607g.CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_EC, C0652k.m6250a("SHA256withECDSA", null), 24, 11),
    ECDSA_WITH_SHA512(514, EnumC0607g.CHUNKED_SHA512, KeyProperties.KEY_ALGORITHM_EC, C0652k.m6250a("SHA512withECDSA", null), 24, 11),
    DSA_WITH_SHA256(769, EnumC0607g.CHUNKED_SHA256, "DSA", C0652k.m6250a("SHA256withDSA", null), 24, 1),
    DETDSA_WITH_SHA256(769, EnumC0607g.CHUNKED_SHA256, "DSA", C0652k.m6250a("SHA256withDetDSA", null), 24, 1),
    VERITY_RSA_PKCS1_V1_5_WITH_SHA256(1057, EnumC0607g.VERITY_CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_RSA, C0652k.m6250a("SHA256withRSA", null), 28, 1),
    VERITY_ECDSA_WITH_SHA256(1059, EnumC0607g.VERITY_CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_EC, C0652k.m6250a("SHA256withECDSA", null), 28, 11),
    VERITY_DSA_WITH_SHA256(1061, EnumC0607g.VERITY_CHUNKED_SHA256, "DSA", C0652k.m6250a("SHA256withDSA", null), 28, 1);


    /* renamed from: a */
    private final EnumC0607g f4186a;

    /* renamed from: b */
    private final int f4187b;

    /* renamed from: c */
    private final String f4188c;

    /* renamed from: d */
    private final int f4189d;

    /* renamed from: e */
    private final C0652k<String, ? extends AlgorithmParameterSpec> f4190e;

    /* renamed from: f */
    private final int f4191f;

    static {
    }

    EnumC0609i(int i, EnumC0607g enumC0607g, String str, C0652k c0652k, int i2, int i3) {
        this.f4187b = i;
        this.f4186a = enumC0607g;
        this.f4188c = str;
        this.f4190e = c0652k;
        this.f4191f = i2;
        this.f4189d = i3;
    }

    /* renamed from: b */
    public int m6081b() {
        return this.f4187b;
    }

    /* renamed from: a */
    public EnumC0607g m6080a() {
        return this.f4186a;
    }

    /* renamed from: c */
    public String m6082c() {
        return this.f4188c;
    }

    /* renamed from: e */
    public C0652k<String, ? extends AlgorithmParameterSpec> m6084e() {
        return this.f4190e;
    }

    /* renamed from: f */
    public int m6085f() {
        return this.f4191f;
    }

    /* renamed from: d */
    public int m6083d() {
        return this.f4189d;
    }

    /* renamed from: a */
    public static EnumC0609i m6078a(int i) {
        for (EnumC0609i enumC0609i : values()) {
            if (enumC0609i.m6081b() == i) {
                return enumC0609i;
            }
        }
        return null;
    }
}
