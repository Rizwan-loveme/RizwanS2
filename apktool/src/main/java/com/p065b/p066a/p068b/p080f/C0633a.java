package com.p065b.p066a.p068b.p080f;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p068b.p069a.p071b.EnumC0592a;
import com.p065b.p066a.p068b.p075b.C0620d;
import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import com.p065b.p066a.p068b.p079e.C0632a;
import com.p065b.p066a.p068b.p081g.C0652k;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.SignatureException;

/* compiled from: AlgorithmIdentifier.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.f.a */
/* loaded from: classes.dex */
public class C0633a {

    @InterfaceC0622f(m6179c = 0, m6183g = EnumC0626j.OBJECT_IDENTIFIER)
    public String algorithm;

    @InterfaceC0622f(m6179c = 1, m6180d = true, m6183g = EnumC0626j.ANY)
    public C0623g parameters;

    public C0633a() {
    }

    public C0633a(String str, C0623g c0623g) {
        this.algorithm = str;
        this.parameters = c0623g;
    }

    /* compiled from: AlgorithmIdentifier.java */
    /* renamed from: com.b.a.b.f.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final int[] $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm;

        static {
            int[] iArr = new int[EnumC0592a.values().length];
            $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm = iArr;
            try {
                iArr[EnumC0592a.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[EnumC0592a.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: a */
    public static C0633a m6228a(EnumC0592a enumC0592a) {
        int i = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a.ordinal()];
        if (i == 1) {
            return new C0633a(C0632a.OID_DIGEST_SHA1, C0620d.ASN1_DER_NULL);
        }
        if (i == 2) {
            return new C0633a(C0632a.OID_DIGEST_SHA256, C0620d.ASN1_DER_NULL);
        }
        throw new IllegalArgumentException("Unsupported digest algorithm: " + enumC0592a);
    }

    /* renamed from: a */
    public static C0652k<String, C0633a> m6229a(PublicKey publicKey, EnumC0592a enumC0592a, boolean z) {
        String str;
        C0633a c0633a;
        String algorithm = publicKey.getAlgorithm();
        int i = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a.ordinal()];
        if (i == 1) {
            str = "SHA1";
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unexpected digest algorithm: " + enumC0592a);
            }
            str = "SHA256";
        }
        if (KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm) || C0632a.OID_SIG_RSA.equals(algorithm)) {
            return C0652k.m6250a(str + "withRSA", new C0633a(C0632a.OID_SIG_RSA, C0620d.ASN1_DER_NULL));
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            int i2 = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a.ordinal()];
            if (i2 == 1) {
                c0633a = new C0633a(C0632a.OID_SIG_DSA, C0620d.ASN1_DER_NULL);
            } else if (i2 == 2) {
                c0633a = new C0633a(C0632a.OID_SIG_SHA256_WITH_DSA, C0620d.ASN1_DER_NULL);
            } else {
                throw new IllegalArgumentException("Unexpected digest algorithm: " + enumC0592a);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(z ? "withDetDSA" : "withDSA");
            return C0652k.m6250a(sb.toString(), c0633a);
        }
        if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
            return C0652k.m6250a(str + "withECDSA", new C0633a(C0632a.OID_SIG_EC_PUBLIC_KEY, C0620d.ASN1_DER_NULL));
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    /* renamed from: a */
    public static String m6231a(String str, String str2) {
        String str3;
        String str4 = C0632a.OID_TO_JCA_SIGNATURE_ALG.get(str2);
        if (str4 == null) {
            if (C0632a.OID_SIG_RSA.equals(str2)) {
                str3 = KeyProperties.KEY_ALGORITHM_RSA;
            } else if (C0632a.OID_SIG_DSA.equals(str2)) {
                str3 = "DSA";
            } else {
                if (!C0632a.OID_SIG_EC_PUBLIC_KEY.equals(str2)) {
                    throw new SignatureException("Unsupported JCA Signature algorithm . Digest algorithm: " + str + ", signature algorithm: " + str2);
                }
                str3 = "ECDSA";
            }
            String m6230a = m6230a(str);
            if (m6230a.startsWith("SHA-")) {
                m6230a = "SHA" + m6230a.substring(4);
            }
            return m6230a + "with" + str3;
        }
        return str4;
    }

    /* renamed from: a */
    public static String m6230a(String str) {
        String str2 = C0632a.OID_TO_JCA_DIGEST_ALG.get(str);
        if (str2 != null) {
            return str2;
        }
        throw new SignatureException("Unsupported digest algorithm: " + str);
    }
}
