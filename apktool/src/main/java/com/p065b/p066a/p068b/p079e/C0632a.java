package com.p065b.p066a.p068b.p079e;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p068b.p081g.C0649h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: OidConstants.java */
/* renamed from: com.b.a.b.e.a */
/* loaded from: classes.dex */
public class C0632a {
    public static final String OID_DIGEST_MD5 = "1.2.840.113549.2.5";
    public static final String OID_DIGEST_SHA1 = "1.3.14.3.2.26";
    public static final String OID_DIGEST_SHA224 = "2.16.840.1.101.3.4.2.4";
    public static final String OID_DIGEST_SHA256 = "2.16.840.1.101.3.4.2.1";
    public static final String OID_DIGEST_SHA384 = "2.16.840.1.101.3.4.2.2";
    public static final String OID_DIGEST_SHA512 = "2.16.840.1.101.3.4.2.3";
    public static final String OID_SIG_DSA = "1.2.840.10040.4.1";
    public static final String OID_SIG_EC_PUBLIC_KEY = "1.2.840.10045.2.1";
    public static final String OID_SIG_MD5_WITH_RSA = "1.2.840.113549.1.1.4";
    public static final String OID_SIG_RSA = "1.2.840.113549.1.1.1";
    public static final String OID_SIG_SHA1_WITH_DSA = "1.2.840.10040.4.3";
    public static final String OID_SIG_SHA1_WITH_ECDSA = "1.2.840.10045.4.1";
    public static final String OID_SIG_SHA1_WITH_RSA = "1.2.840.113549.1.1.5";
    public static final String OID_SIG_SHA224_WITH_DSA = "2.16.840.1.101.3.4.3.1";
    public static final String OID_SIG_SHA224_WITH_ECDSA = "1.2.840.10045.4.3.1";
    public static final String OID_SIG_SHA224_WITH_RSA = "1.2.840.113549.1.1.14";
    public static final String OID_SIG_SHA256_WITH_DSA = "2.16.840.1.101.3.4.3.2";
    public static final String OID_SIG_SHA256_WITH_ECDSA = "1.2.840.10045.4.3.2";
    public static final String OID_SIG_SHA256_WITH_RSA = "1.2.840.113549.1.1.11";
    public static final String OID_SIG_SHA384_WITH_DSA = "2.16.840.1.101.3.4.3.3";
    public static final String OID_SIG_SHA384_WITH_ECDSA = "1.2.840.10045.4.3.3";
    public static final String OID_SIG_SHA384_WITH_RSA = "1.2.840.113549.1.1.12";
    public static final String OID_SIG_SHA512_WITH_DSA = "2.16.840.1.101.3.4.3.4";
    public static final String OID_SIG_SHA512_WITH_ECDSA = "1.2.840.10045.4.3.4";
    public static final String OID_SIG_SHA512_WITH_RSA = "1.2.840.113549.1.1.13";
    public static final Map<String, String> OID_TO_JCA_DIGEST_ALG;
    public static final Map<String, String> OID_TO_JCA_SIGNATURE_ALG;
    public static final Map<String, List<C0649h>> SUPPORTED_SIG_ALG_OIDS = new HashMap();

    static {
        m6226a(OID_DIGEST_MD5, OID_SIG_RSA, C0649h.m6245a(0));
        m6226a(OID_DIGEST_MD5, OID_SIG_MD5_WITH_RSA, C0649h.m6246a(0, 8), C0649h.m6245a(21));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA1_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA224_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA256_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA384_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA512_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_RSA, C0649h.m6245a(0));
        m6226a(OID_DIGEST_SHA1, OID_SIG_MD5_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA1_WITH_RSA, C0649h.m6245a(0));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA224_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA256_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA384_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA512_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_RSA, C0649h.m6246a(0, 8), C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA224, OID_SIG_MD5_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA1_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA224_WITH_RSA, C0649h.m6246a(0, 8), C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA256_WITH_RSA, C0649h.m6246a(21, 21));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA384_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA512_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_RSA, C0649h.m6246a(0, 8), C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA256, OID_SIG_MD5_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA1_WITH_RSA, C0649h.m6246a(21, 21));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA224_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA256_WITH_RSA, C0649h.m6246a(0, 8), C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA384_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA512_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_RSA, C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA384, OID_SIG_MD5_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA1_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA224_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA256_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA384_WITH_RSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA512_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_RSA, C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA512, OID_SIG_MD5_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA1_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA224_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA256_WITH_RSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA384_WITH_RSA, C0649h.m6246a(21, 21));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA512_WITH_RSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA1_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA224_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA256_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_DSA, C0649h.m6245a(0));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA1_WITH_DSA, C0649h.m6245a(9));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA224_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA256_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_DSA, C0649h.m6245a(22));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA1_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA224_WITH_DSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA256_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_DSA, C0649h.m6245a(22));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA1_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA224_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA256_WITH_DSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA1_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA224_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA256_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA1_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA224_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA256_WITH_DSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_EC_PUBLIC_KEY, C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA224, OID_SIG_EC_PUBLIC_KEY, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA256, OID_SIG_EC_PUBLIC_KEY, C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA384, OID_SIG_EC_PUBLIC_KEY, C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA512, OID_SIG_EC_PUBLIC_KEY, C0649h.m6245a(18));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA1_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA224_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA256_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA384_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_MD5, OID_SIG_SHA512_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA1_WITH_ECDSA, C0649h.m6245a(18));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA224_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA256_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA384_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA1, OID_SIG_SHA512_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA1_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA224_WITH_ECDSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA256_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA384_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA224, OID_SIG_SHA512_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA1_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA224_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA256_WITH_ECDSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA384_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA256, OID_SIG_SHA512_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA1_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA224_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA256_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA384_WITH_ECDSA, C0649h.m6245a(21));
        m6226a(OID_DIGEST_SHA384, OID_SIG_SHA512_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA1_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA224_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA256_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA384_WITH_ECDSA, C0649h.m6246a(21, 23));
        m6226a(OID_DIGEST_SHA512, OID_SIG_SHA512_WITH_ECDSA, C0649h.m6245a(21));
        HashMap hashMap = new HashMap();
        OID_TO_JCA_DIGEST_ALG = hashMap;
        hashMap.put(OID_DIGEST_MD5, KeyProperties.DIGEST_MD5);
        hashMap.put(OID_DIGEST_SHA1, KeyProperties.DIGEST_SHA1);
        hashMap.put(OID_DIGEST_SHA224, KeyProperties.DIGEST_SHA224);
        hashMap.put(OID_DIGEST_SHA256, KeyProperties.DIGEST_SHA256);
        hashMap.put(OID_DIGEST_SHA384, KeyProperties.DIGEST_SHA384);
        hashMap.put(OID_DIGEST_SHA512, KeyProperties.DIGEST_SHA512);
        HashMap hashMap2 = new HashMap();
        OID_TO_JCA_SIGNATURE_ALG = hashMap2;
        hashMap2.put(OID_SIG_MD5_WITH_RSA, "MD5withRSA");
        hashMap2.put(OID_SIG_SHA1_WITH_RSA, "SHA1withRSA");
        hashMap2.put(OID_SIG_SHA224_WITH_RSA, "SHA224withRSA");
        hashMap2.put(OID_SIG_SHA256_WITH_RSA, "SHA256withRSA");
        hashMap2.put(OID_SIG_SHA384_WITH_RSA, "SHA384withRSA");
        hashMap2.put(OID_SIG_SHA512_WITH_RSA, "SHA512withRSA");
        hashMap2.put(OID_SIG_SHA1_WITH_DSA, "SHA1withDSA");
        hashMap2.put(OID_SIG_SHA224_WITH_DSA, "SHA224withDSA");
        hashMap2.put(OID_SIG_SHA256_WITH_DSA, "SHA256withDSA");
        hashMap2.put(OID_SIG_SHA1_WITH_ECDSA, "SHA1withECDSA");
        hashMap2.put(OID_SIG_SHA224_WITH_ECDSA, "SHA224withECDSA");
        hashMap2.put(OID_SIG_SHA256_WITH_ECDSA, "SHA256withECDSA");
        hashMap2.put(OID_SIG_SHA384_WITH_ECDSA, "SHA384withECDSA");
        hashMap2.put(OID_SIG_SHA512_WITH_ECDSA, "SHA512withECDSA");
    }

    /* renamed from: a */
    public static void m6226a(String str, String str2, C0649h... c0649hArr) {
        SUPPORTED_SIG_ALG_OIDS.put(str + "with" + str2, Arrays.asList(c0649hArr));
    }

    /* renamed from: a */
    public static List<C0649h> m6225a(String str, String str2) {
        List<C0649h> list = SUPPORTED_SIG_ALG_OIDS.get(str + "with" + str2);
        return list != null ? list : Collections.emptyList();
    }

    /* compiled from: OidConstants.java */
    /* renamed from: com.b.a.b.e.a$a */
    public static class a {
        private static final Map<String, String> OID_TO_USER_FRIENDLY_NAME;

        private a() {
        }

        static {
            HashMap hashMap = new HashMap();
            OID_TO_USER_FRIENDLY_NAME = hashMap;
            hashMap.put(C0632a.OID_DIGEST_MD5, KeyProperties.DIGEST_MD5);
            hashMap.put(C0632a.OID_DIGEST_SHA1, KeyProperties.DIGEST_SHA1);
            hashMap.put(C0632a.OID_DIGEST_SHA224, KeyProperties.DIGEST_SHA224);
            hashMap.put(C0632a.OID_DIGEST_SHA256, KeyProperties.DIGEST_SHA256);
            hashMap.put(C0632a.OID_DIGEST_SHA384, KeyProperties.DIGEST_SHA384);
            hashMap.put(C0632a.OID_DIGEST_SHA512, KeyProperties.DIGEST_SHA512);
            hashMap.put(C0632a.OID_SIG_RSA, KeyProperties.KEY_ALGORITHM_RSA);
            hashMap.put(C0632a.OID_SIG_MD5_WITH_RSA, "MD5 with RSA");
            hashMap.put(C0632a.OID_SIG_SHA1_WITH_RSA, "SHA-1 with RSA");
            hashMap.put(C0632a.OID_SIG_SHA224_WITH_RSA, "SHA-224 with RSA");
            hashMap.put(C0632a.OID_SIG_SHA256_WITH_RSA, "SHA-256 with RSA");
            hashMap.put(C0632a.OID_SIG_SHA384_WITH_RSA, "SHA-384 with RSA");
            hashMap.put(C0632a.OID_SIG_SHA512_WITH_RSA, "SHA-512 with RSA");
            hashMap.put(C0632a.OID_SIG_DSA, "DSA");
            hashMap.put(C0632a.OID_SIG_SHA1_WITH_DSA, "SHA-1 with DSA");
            hashMap.put(C0632a.OID_SIG_SHA224_WITH_DSA, "SHA-224 with DSA");
            hashMap.put(C0632a.OID_SIG_SHA256_WITH_DSA, "SHA-256 with DSA");
            hashMap.put(C0632a.OID_SIG_SHA384_WITH_DSA, "SHA-384 with DSA");
            hashMap.put(C0632a.OID_SIG_SHA512_WITH_DSA, "SHA-512 with DSA");
            hashMap.put(C0632a.OID_SIG_EC_PUBLIC_KEY, "ECDSA");
            hashMap.put(C0632a.OID_SIG_SHA1_WITH_ECDSA, "SHA-1 with ECDSA");
            hashMap.put(C0632a.OID_SIG_SHA224_WITH_ECDSA, "SHA-224 with ECDSA");
            hashMap.put(C0632a.OID_SIG_SHA256_WITH_ECDSA, "SHA-256 with ECDSA");
            hashMap.put(C0632a.OID_SIG_SHA384_WITH_ECDSA, "SHA-384 with ECDSA");
            hashMap.put(C0632a.OID_SIG_SHA512_WITH_ECDSA, "SHA-512 with ECDSA");
        }

        /* renamed from: a */
        public static String m6227a(String str) {
            return OID_TO_USER_FRIENDLY_NAME.get(str);
        }
    }

    private C0632a() {
    }
}
