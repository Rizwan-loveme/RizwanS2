package com.p065b.p111c.p113b.p114a.p116b;

import android.security.keystore.KeyProperties;
import com.p065b.p111c.p113b.p118c.C1059g;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* compiled from: SignatureAlgorithm.java */
/* renamed from: com.b.c.b.a.b.b */
/* loaded from: classes.dex */
public enum EnumC1047b {
    RSA_PSS_WITH_SHA256(257, EnumC1046a.CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_RSA, C1059g.m8851a("SHA256withRSA/PSS", new PSSParameterSpec(KeyProperties.DIGEST_SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1))),
    RSA_PSS_WITH_SHA512(258, EnumC1046a.CHUNKED_SHA512, KeyProperties.KEY_ALGORITHM_RSA, C1059g.m8851a("SHA512withRSA/PSS", new PSSParameterSpec(KeyProperties.DIGEST_SHA512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1))),
    RSA_PKCS1_V1_5_WITH_SHA256(259, EnumC1046a.CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_RSA, C1059g.m8851a("SHA256withRSA", null)),
    RSA_PKCS1_V1_5_WITH_SHA512(260, EnumC1046a.CHUNKED_SHA512, KeyProperties.KEY_ALGORITHM_RSA, C1059g.m8851a("SHA512withRSA", null)),
    ECDSA_WITH_SHA256(513, EnumC1046a.CHUNKED_SHA256, KeyProperties.KEY_ALGORITHM_EC, C1059g.m8851a("SHA256withECDSA", null)),
    ECDSA_WITH_SHA512(514, EnumC1046a.CHUNKED_SHA512, KeyProperties.KEY_ALGORITHM_EC, C1059g.m8851a("SHA512withECDSA", null)),
    DSA_WITH_SHA256(769, EnumC1046a.CHUNKED_SHA256, "DSA", C1059g.m8851a("SHA256withDSA", null));


    /* renamed from: i */
    private final EnumC1046a f6633i;

    /* renamed from: j */
    private final int f6634j;

    /* renamed from: k */
    private final String f6635k;

    /* renamed from: l */
    private final C1059g<String, ? extends AlgorithmParameterSpec> f6636l;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1047b[] valuesCustom() {
        EnumC1047b[] valuesCustom = values();
        int length = valuesCustom.length;
        EnumC1047b[] enumC1047bArr = new EnumC1047b[length];
        System.arraycopy(valuesCustom, 0, enumC1047bArr, 0, length);
        return enumC1047bArr;
    }

    EnumC1047b(int i, EnumC1046a enumC1046a, String str, C1059g c1059g) {
        this.f6634j = i;
        this.f6633i = enumC1046a;
        this.f6635k = str;
        this.f6636l = c1059g;
    }

    /* renamed from: b */
    int m8757b() {
        return this.f6634j;
    }

    /* renamed from: a */
    EnumC1046a m8756a() {
        return this.f6633i;
    }

    /* renamed from: c */
    String m8758c() {
        return this.f6635k;
    }

    /* renamed from: d */
    C1059g<String, ? extends AlgorithmParameterSpec> m8759d() {
        return this.f6636l;
    }

    /* renamed from: a */
    static EnumC1047b m8755a(int i) {
        for (EnumC1047b enumC1047b : valuesCustom()) {
            if (enumC1047b.m8757b() == i) {
                return enumC1047b;
            }
        }
        return null;
    }
}
