package com.p065b.p111c.p113b.p114a.p115a;

import android.security.keystore.KeyProperties;
import android.util.Base64;
import com.p065b.p066a.p068b.p079e.C0632a;
import com.p065b.p111c.C1066c;
import com.p065b.p111c.p112a.AbstractC1038b;
import com.p065b.p111c.p112a.C1037a;
import com.p065b.p111c.p113b.p117b.C1050a;
import com.p065b.p111c.p113b.p118c.C1056d;
import com.p065b.p111c.p113b.p118c.C1057e;
import com.p065b.p111c.p113b.p119d.C1062a;
import com.p065b.p111c.p113b.p119d.C1064c;
import com.p065b.p111c.p120c.InterfaceC1069c;
import com.p065b.p111c.p121d.C1072a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import p165d.p167b.p169b.C1426d;
import p165d.p167b.p169b.C1431i;

/* compiled from: V1SchemeVerifier.java */
/* renamed from: com.b.c.b.a.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC1045c {

    /* renamed from: b */
    private static final Map<String, Integer> f6592b;

    /* renamed from: a */
    private static final String[] f6591a = {KeyProperties.DIGEST_SHA512, KeyProperties.DIGEST_SHA384, KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA1};

    /* renamed from: c */
    private static final Map<String, String> f6593c = new HashMap(8);

    /* renamed from: a */
    public static b m8698a(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar, Map<Integer, String> map, Set<Integer> set, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException("minSdkVersion (" + i + ") > maxSdkVersion (" + i2 + ")");
        }
        b bVar = new b();
        List<C1062a> m8701a = m8701a(interfaceC1069c, cVar);
        Set<String> m8704a = m8704a(m8701a, bVar);
        if (!bVar.m8722c()) {
            e.m8749b(interfaceC1069c, cVar.m8629a(), m8701a, m8704a, map, set, i, i2, bVar);
        }
        return bVar;
    }

    /* renamed from: a */
    private static Set<String> m8704a(List<C1062a> list, b bVar) {
        HashSet hashSet = new HashSet(list.size());
        Iterator<C1062a> it = list.iterator();
        HashSet hashSet2 = null;
        while (it.hasNext()) {
            String m8870h = it.next().m8870h();
            if (!hashSet.add(m8870h)) {
                HashSet hashSet3 = hashSet2 == null ? new HashSet() : hashSet2;
                if (hashSet3.add(m8870h)) {
                    bVar.m8718a(C1066c.c.JAR_SIG_DUPLICATE_ZIP_ENTRY, m8870h);
                    hashSet2 = hashSet3;
                } else {
                    hashSet2 = hashSet3;
                }
            }
        }
        return hashSet;
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.a.c$e */
    private static class e {
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        public static void m8749b(InterfaceC1069c interfaceC1069c, long j, List<C1062a> list, Set<String> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2, b bVar) {
            HashMap hashMap = new HashMap(1);
            ArrayList<C1062a> arrayList = new ArrayList(1);
            C1062a c1062a = null;
            for (C1062a c1062a2 : list) {
                String m8870h = c1062a2.m8870h();
                if (m8870h.startsWith("META-INF/")) {
                    if (c1062a == null && "META-INF/MANIFEST.MF".equals(m8870h)) {
                        c1062a = c1062a2;
                    } else if (m8870h.endsWith(".SF")) {
                        hashMap.put(m8870h, c1062a2);
                    } else if (m8870h.endsWith(".RSA") || m8870h.endsWith(".DSA") || m8870h.endsWith(".EC")) {
                        arrayList.add(c1062a2);
                    }
                }
            }
            if (c1062a != null) {
                try {
                    byte[] m8880b = C1064c.m8880b(interfaceC1069c, c1062a, j);
                    C1050a c1050a = new C1050a(m8880b);
                    C1050a.b m8818b = c1050a.m8818b();
                    List<C1050a.b> m8817a = c1050a.m8817a();
                    HashMap hashMap2 = new HashMap(m8817a.size());
                    int i3 = 0;
                    for (C1050a.b bVar2 : m8817a) {
                        i3++;
                        String m8821a = bVar2.m8821a();
                        if (m8821a != null) {
                            if (hashMap2.put(m8821a, bVar2) == 0) {
                                if (!set.contains(m8821a)) {
                                    bVar.m8718a(C1066c.c.JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST, m8821a);
                                }
                            } else {
                                bVar.m8718a(C1066c.c.JAR_SIG_DUPLICATE_MANIFEST_SECTION, m8821a);
                            }
                        } else {
                            bVar.m8718a(C1066c.c.JAR_SIG_UNNNAMED_MANIFEST_SECTION, Integer.valueOf(i3));
                        }
                    }
                    if (!bVar.m8722c()) {
                        ArrayList<d> arrayList2 = new ArrayList(arrayList.size());
                        for (C1062a c1062a3 : arrayList) {
                            String m8870h2 = c1062a3.m8870h();
                            int lastIndexOf = m8870h2.lastIndexOf(46);
                            if (lastIndexOf == -1) {
                                throw new RuntimeException("Signature block file name does not contain extension: " + m8870h2);
                            }
                            String str = String.valueOf(m8870h2.substring(0, lastIndexOf)) + ".SF";
                            C1062a c1062a4 = (C1062a) hashMap.get(str);
                            if (c1062a4 != null) {
                                String substring = m8870h2.substring("META-INF/".length());
                                arrayList2.add(new d(substring, c1062a3, c1062a4, new c(substring, m8870h2, c1062a4.m8870h(), null), null));
                            } else {
                                bVar.m8721b(C1066c.c.JAR_SIG_MISSING_FILE, m8870h2, str);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            for (d dVar : arrayList2) {
                                dVar.m8740a(interfaceC1069c, j, i, i2);
                                if (dVar.m8742b().m8730c()) {
                                    bVar.f6597b.add(dVar.m8742b());
                                }
                            }
                            if (!bVar.m8722c()) {
                                ArrayList<d> arrayList3 = new ArrayList(arrayList2.size());
                                for (d dVar2 : arrayList2) {
                                    dVar2.m8741a(m8880b, m8818b, hashMap2, map, set2, i, i2);
                                    if (dVar2.m8746f()) {
                                        bVar.f6596a.add(dVar2.m8742b());
                                    } else if (dVar2.m8742b().m8730c()) {
                                        bVar.f6597b.add(dVar2.m8742b());
                                    } else {
                                        arrayList3.add(dVar2);
                                    }
                                }
                                if (!bVar.m8722c()) {
                                    if (!arrayList3.isEmpty()) {
                                        Set<d> m8710b = AbstractC1045c.m8710b(interfaceC1069c, j, list, hashMap2, arrayList3, i, i2, bVar);
                                        if (!bVar.m8722c()) {
                                            HashSet hashSet = new HashSet((bVar.f6597b.size() * 2) + 1);
                                            hashSet.add(c1062a.m8870h());
                                            for (d dVar3 : m8710b) {
                                                hashSet.add(dVar3.m8744d());
                                                hashSet.add(dVar3.m8745e());
                                            }
                                            Iterator<C1062a> it = list.iterator();
                                            while (it.hasNext()) {
                                                String m8870h3 = it.next().m8870h();
                                                if (m8870h3.startsWith("META-INF/") && !m8870h3.endsWith("/") && !hashSet.contains(m8870h3)) {
                                                    bVar.m8721b(C1066c.c.JAR_SIG_UNPROTECTED_ZIP_ENTRY, m8870h3);
                                                }
                                            }
                                            for (d dVar4 : arrayList3) {
                                                if (m8710b.contains(dVar4)) {
                                                    bVar.f6597b.add(dVar4.m8742b());
                                                } else {
                                                    bVar.f6596a.add(dVar4.m8742b());
                                                }
                                            }
                                            bVar.f6598c = true;
                                            return;
                                        }
                                        return;
                                    }
                                    bVar.m8718a(C1066c.c.JAR_SIG_NO_SIGNATURES, "signers.size()");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        bVar.m8718a(C1066c.c.JAR_SIG_NO_SIGNATURES, "Sigblock");
                        return;
                    }
                    return;
                } catch (C1072a e2) {
                    throw new C1037a("Malformed ZIP entry: " + c1062a.m8870h(), e2);
                }
            }
            bVar.m8718a(C1066c.c.JAR_SIG_NO_MANIFEST, new Object[0]);
        }
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.a.c$d */
    private static class d {

        /* renamed from: a */
        private static final Map<String, List<C1056d>> f6607a = new HashMap();

        /* renamed from: b */
        private boolean f6608b;

        /* renamed from: c */
        private final String f6609c;

        /* renamed from: d */
        private final c f6610d;

        /* renamed from: e */
        private byte[] f6611e;

        /* renamed from: f */
        private Set<String> f6612f;

        /* renamed from: g */
        private final C1062a f6613g;

        /* renamed from: h */
        private final C1062a f6614h;

        private d(String str, C1062a c1062a, C1062a c1062a2, c cVar) {
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_RSA, C1056d.m8848a(0));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_MD5_WITH_RSA, C1056d.m8849a(0, 8), C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA1_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA224_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA256_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA384_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA512_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_RSA, C1056d.m8848a(0));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_MD5_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA1_WITH_RSA, C1056d.m8848a(0));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA224_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA256_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA384_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA512_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_RSA, C1056d.m8849a(0, 8), C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_MD5_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA1_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA224_WITH_RSA, C1056d.m8849a(0, 8), C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA256_WITH_RSA, C1056d.m8849a(21, 21));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA384_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA512_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_RSA, C1056d.m8849a(0, 8), C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_MD5_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA1_WITH_RSA, C1056d.m8849a(21, 21));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA224_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA256_WITH_RSA, C1056d.m8849a(0, 8), C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA384_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA512_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_RSA, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_MD5_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA1_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA224_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA256_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA384_WITH_RSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA512_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_RSA, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_MD5_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA1_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA224_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA256_WITH_RSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA384_WITH_RSA, C1056d.m8849a(21, 21));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA512_WITH_RSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA1_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA224_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA256_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_DSA, C1056d.m8848a(0));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA1_WITH_DSA, C1056d.m8848a(9));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA224_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA256_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_DSA, C1056d.m8848a(22));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA1_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA224_WITH_DSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA256_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_DSA, C1056d.m8848a(22));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA1_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA224_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA256_WITH_DSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA1_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA224_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA256_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA1_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA224_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA256_WITH_DSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_EC_PUBLIC_KEY, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_EC_PUBLIC_KEY, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_EC_PUBLIC_KEY, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_EC_PUBLIC_KEY, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_EC_PUBLIC_KEY, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA1_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA224_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA256_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA384_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_MD5, C0632a.OID_SIG_SHA512_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA1_WITH_ECDSA, C1056d.m8848a(18));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA224_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA256_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA384_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA1, C0632a.OID_SIG_SHA512_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA1_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA224_WITH_ECDSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA256_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA384_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA224, C0632a.OID_SIG_SHA512_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA1_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA224_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA256_WITH_ECDSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA384_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA256, C0632a.OID_SIG_SHA512_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA1_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA224_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA256_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA384_WITH_ECDSA, C1056d.m8848a(21));
            m8737a(C0632a.OID_DIGEST_SHA384, C0632a.OID_SIG_SHA512_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA1_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA224_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA256_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA384_WITH_ECDSA, C1056d.m8849a(21, 23));
            m8737a(C0632a.OID_DIGEST_SHA512, C0632a.OID_SIG_SHA512_WITH_ECDSA, C1056d.m8848a(21));
            this.f6609c = str;
            this.f6610d = cVar;
            this.f6613g = c1062a;
            this.f6614h = c1062a2;
        }

        /* synthetic */ d(String str, C1062a c1062a, C1062a c1062a2, c cVar, d dVar) {
            this(str, c1062a, c1062a2, cVar);
        }

        /* renamed from: a */
        public String m8739a() {
            return this.f6609c;
        }

        /* renamed from: e */
        public String m8745e() {
            return this.f6614h.m8870h();
        }

        /* renamed from: d */
        public String m8744d() {
            return this.f6613g.m8870h();
        }

        /* renamed from: g */
        void m8747g() {
            this.f6608b = true;
        }

        /* renamed from: f */
        public boolean m8746f() {
            return this.f6608b;
        }

        /* renamed from: c */
        public Set<String> m8743c() {
            return this.f6612f;
        }

        /* renamed from: b */
        public c m8742b() {
            return this.f6610d;
        }

        /* renamed from: a */
        public void m8740a(InterfaceC1069c interfaceC1069c, long j, int i, int i2) {
            try {
                byte[] m8880b = C1064c.m8880b(interfaceC1069c, this.f6613g, j);
                try {
                    this.f6611e = C1064c.m8880b(interfaceC1069c, this.f6614h, j);
                    try {
                        C1426d c1426d = new C1426d(m8880b);
                        C1431i[] m11261c = c1426d.m11261c();
                        if (m11261c != null && m11261c.length != 0) {
                            C1431i c1431i = null;
                            if (m11261c == null || m11261c.length <= 0) {
                                c1431i = null;
                            } else {
                                for (C1431i c1431i2 : m11261c) {
                                    String c1454q = c1431i2.m11283a().m11643e().toString();
                                    String c1454q2 = c1431i2.m11285b().m11643e().toString();
                                    List<C1056d> m8850a = C1056d.m8849a(i, i2).m8850a(m8733a(c1454q, c1454q2));
                                    if (m8850a.isEmpty()) {
                                        try {
                                            c1431i = c1426d.m11255a(c1431i2, this.f6611e);
                                            if (c1431i != null) {
                                                break;
                                            }
                                            if (i < 24) {
                                                this.f6610d.m8726a(C1066c.c.JAR_SIG_DID_NOT_VERIFY, this.f6613g.m8870h(), this.f6614h.m8870h());
                                                return;
                                            }
                                        } catch (SignatureException e2) {
                                            this.f6610d.m8726a(C1066c.c.JAR_SIG_VERIFY_EXCEPTION, this.f6613g.m8870h(), this.f6614h.m8870h(), e2);
                                            return;
                                        }
                                    } else {
                                        this.f6610d.m8726a(C1066c.c.JAR_SIG_UNSUPPORTED_SIG_ALG, this.f6613g.m8870h(), c1454q, c1454q2, String.valueOf(m8850a));
                                        return;
                                    }
                                }
                            }
                            if (c1431i != null) {
                                try {
                                    ArrayList<X509Certificate> m11286b = c1431i.m11286b(c1426d);
                                    if (m11286b == null || m11286b.isEmpty()) {
                                        throw new RuntimeException("Verified SignerInfo does not have a certificate chain");
                                    }
                                    this.f6610d.f6601a.clear();
                                    this.f6610d.f6601a.addAll(m11286b);
                                    return;
                                } catch (IOException e3) {
                                    throw new RuntimeException("Failed to obtain cert chain from " + this.f6613g.m8870h(), e3);
                                }
                            }
                            this.f6610d.m8726a(C1066c.c.JAR_SIG_NO_SIGNERS, this.f6613g.m8870h());
                            return;
                        }
                        this.f6610d.m8726a(C1066c.c.JAR_SIG_NO_SIGNERS, this.f6613g.m8870h());
                    } catch (IOException e4) {
                        if (e4.getCause() instanceof CertificateException) {
                            this.f6610d.m8726a(C1066c.c.JAR_SIG_MALFORMED_CERTIFICATE, this.f6613g.m8870h(), e4);
                        } else {
                            this.f6610d.m8726a(C1066c.c.JAR_SIG_PARSE_EXCEPTION, this.f6613g.m8870h(), e4);
                        }
                    }
                } catch (C1072a e5) {
                    throw new C1037a("Malformed ZIP entry: " + this.f6614h.m8870h(), e5);
                }
            } catch (C1072a e6) {
                throw new C1037a("Malformed ZIP entry: " + this.f6613g.m8870h(), e6);
            }
        }

        /* renamed from: a */
        private static void m8737a(String str, String str2, C1056d... c1056dArr) {
            f6607a.put(String.valueOf(str) + "with" + str2, Arrays.asList(c1056dArr));
        }

        /* renamed from: a */
        private List<C1056d> m8733a(String str, String str2) {
            List<C1056d> list = f6607a.get(String.valueOf(str) + "with" + str2);
            return list != null ? list : Collections.emptyList();
        }

        /* renamed from: a */
        public void m8741a(byte[] bArr, C1050a.b bVar, Map<String, C1050a.b> map, Map<Integer, String> map2, Set<Integer> set, int i, int i2) {
            C1050a c1050a = new C1050a(this.f6611e);
            C1050a.b m8818b = c1050a.m8818b();
            if (m8818b.m8823a(Attributes.Name.SIGNATURE_VERSION) != null) {
                if (i2 >= 24) {
                    m8735a(m8818b, map2, set);
                    if (this.f6610d.m8730c()) {
                        return;
                    }
                }
                boolean z = false;
                String m8822a = m8818b.m8822a("Created-By");
                if (m8822a != null) {
                    z = m8822a.indexOf("signtool") != -1;
                }
                boolean m8738a = m8738a(m8818b, z, bArr, i, i2);
                if (!z) {
                    m8734a(m8818b, bVar, bArr, i, i2);
                }
                if (!this.f6610d.m8730c()) {
                    List<C1050a.b> m8817a = c1050a.m8817a();
                    HashSet hashSet = new HashSet(m8817a.size());
                    int i3 = 0;
                    for (C1050a.b bVar2 : m8817a) {
                        int i4 = i3 + 1;
                        String m8821a = bVar2.m8821a();
                        if (m8821a != null) {
                            if (hashSet.add(m8821a)) {
                                if (m8738a) {
                                    i3 = i4;
                                } else {
                                    C1050a.b bVar3 = map.get(m8821a);
                                    if (bVar3 != null) {
                                        m8736a(bVar2, z, bVar3, bArr, i, i2);
                                        i3 = i4;
                                    } else {
                                        this.f6610d.m8726a(C1066c.c.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE, m8821a, this.f6614h.m8870h());
                                        m8747g();
                                        i3 = i4;
                                    }
                                }
                            } else {
                                this.f6610d.m8726a(C1066c.c.JAR_SIG_DUPLICATE_SIG_FILE_SECTION, this.f6614h.m8870h(), m8821a);
                                m8747g();
                                return;
                            }
                        } else {
                            this.f6610d.m8726a(C1066c.c.JAR_SIG_UNNNAMED_SIG_FILE_SECTION, this.f6614h.m8870h(), Integer.valueOf(i4));
                            m8747g();
                            return;
                        }
                    }
                    this.f6612f = hashSet;
                    return;
                }
                return;
            }
            this.f6610d.m8726a(C1066c.c.JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE, this.f6614h.m8870h());
            m8747g();
        }

        /* renamed from: a */
        private boolean m8738a(C1050a.b bVar, boolean z, byte[] bArr, int i, int i2) {
            Collection<a> m8709b = AbstractC1045c.m8709b(bVar, z ? "-Digest" : "-Digest-Manifest", i, i2);
            if (!m8709b.isEmpty()) {
                boolean z2 = true;
                for (a aVar : m8709b) {
                    String str = aVar.f6595b;
                    byte[] m8711b = AbstractC1045c.m8711b(str, bArr);
                    byte[] bArr2 = aVar.f6594a;
                    if (!Arrays.equals(bArr2, m8711b)) {
                        this.f6610d.m8729b(C1066c.c.JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY, "META-INF/MANIFEST.MF", str, this.f6614h.m8870h(), Base64.encodeToString(m8711b, 2), Base64.encodeToString(bArr2, 2));
                        z2 = false;
                    }
                }
                return z2;
            }
            this.f6610d.m8729b(C1066c.c.JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE, this.f6614h.m8870h());
            return false;
        }

        /* renamed from: a */
        private void m8734a(C1050a.b bVar, C1050a.b bVar2, byte[] bArr, int i, int i2) {
            Collection<a> m8709b = AbstractC1045c.m8709b(bVar, "-Digest-Manifest-Main-Attributes", i, i2);
            if (!m8709b.isEmpty()) {
                for (a aVar : m8709b) {
                    String str = aVar.f6595b;
                    byte[] m8712b = AbstractC1045c.m8712b(str, bArr, bVar2.m8825c(), bVar2.m8824b());
                    byte[] bArr2 = aVar.f6594a;
                    if (!Arrays.equals(bArr2, m8712b)) {
                        this.f6610d.m8726a(C1066c.c.JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY, str, this.f6614h.m8870h(), Base64.encodeToString(m8712b, 2), Base64.encodeToString(bArr2, 2));
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m8736a(C1050a.b bVar, boolean z, C1050a.b bVar2, byte[] bArr, int i, int i2) {
            int i3;
            String m8821a = bVar.m8821a();
            Collection<a> m8709b = AbstractC1045c.m8709b(bVar, "-Digest", i, i2);
            if (!m8709b.isEmpty()) {
                int m8825c = bVar2.m8825c();
                int m8824b = bVar2.m8824b();
                if (z) {
                    int i4 = m8825c + m8824b;
                    if (bArr[i4 - 1] == 10 && bArr[i4 - 2] == 10) {
                        i3 = m8824b - 1;
                        for (a aVar : m8709b) {
                            String str = aVar.f6595b;
                            byte[] m8712b = AbstractC1045c.m8712b(str, bArr, m8825c, i3);
                            byte[] bArr2 = aVar.f6594a;
                            if (!Arrays.equals(bArr2, m8712b)) {
                                this.f6610d.m8726a(C1066c.c.JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY, m8821a, str, this.f6614h.m8870h(), Base64.encodeToString(m8712b, 2), Base64.encodeToString(bArr2, 2));
                            }
                        }
                        return;
                    }
                }
                i3 = m8824b;
                while (r5.hasNext()) {
                }
                return;
            }
            this.f6610d.m8726a(C1066c.c.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE, m8821a, this.f6614h.m8870h());
        }

        /* renamed from: a */
        private void m8735a(C1050a.b bVar, Map<Integer, String> map, Set<Integer> set) {
            String m8822a = bVar.m8822a("X-Android-APK-Signed");
            if (m8822a == null) {
                if (set.isEmpty()) {
                    return;
                }
                this.f6610d.m8729b(C1066c.c.JAR_SIG_NO_APK_SIG_STRIP_PROTECTION, this.f6614h.m8870h());
                return;
            }
            if (!map.isEmpty()) {
                Set<Integer> keySet = map.keySet();
                HashSet hashSet = new HashSet(1);
                StringTokenizer stringTokenizer = new StringTokenizer(m8822a, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    String trim = stringTokenizer.nextToken().trim();
                    if (!trim.isEmpty()) {
                        try {
                            int parseInt = Integer.parseInt(trim);
                            if (keySet.contains(Integer.valueOf(parseInt))) {
                                hashSet.add(Integer.valueOf(parseInt));
                            } else {
                                this.f6610d.m8729b(C1066c.c.JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID, this.f6614h.m8870h(), Integer.valueOf(parseInt));
                            }
                        } catch (Exception e2) {
                        }
                    }
                }
                Iterator<E> it = hashSet.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!set.contains(Integer.valueOf(intValue))) {
                        this.f6610d.m8726a(C1066c.c.JAR_SIG_MISSING_APK_SIG_REFERENCED, this.f6614h.m8870h(), Integer.valueOf(intValue), map.get(Integer.valueOf(intValue)));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:
    
        if (r1.isEmpty() != false) goto L12;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Collection<a> m8709b(C1050a.b bVar, String str, int i, int i2) {
        String m8708b;
        a aVar = null;
        ArrayList arrayList = new ArrayList(1);
        if (i < 18) {
            String m8822a = bVar.m8822a("Digest-Algorithms");
            if (m8822a == null) {
                m8822a = "SHA SHA1";
            }
            StringTokenizer stringTokenizer = new StringTokenizer(m8822a);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String nextToken = stringTokenizer.nextToken();
                String m8822a2 = bVar.m8822a(String.valueOf(nextToken) + str);
                if (m8822a2 != null && (m8708b = m8708b(nextToken)) != null && m8697a(m8708b) <= i) {
                    arrayList.add(new a(m8708b, Base64.decode(m8822a2, 2), aVar));
                    break;
                }
            }
        }
        if (i2 >= 18) {
            String[] strArr = f6591a;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                String m8822a3 = bVar.m8822a(m8699a(str2, str));
                if (m8822a3 == null) {
                    i3++;
                } else {
                    byte[] decode = Base64.decode(m8822a3, 2);
                    byte[] m8707a = m8707a(arrayList, str2);
                    if (m8707a == null || !Arrays.equals(m8707a, decode)) {
                        arrayList.add(new a(str2, decode, aVar));
                    }
                }
            }
        }
        return arrayList;
    }

    static {
        f6593c.put(KeyProperties.DIGEST_MD5, KeyProperties.DIGEST_MD5);
        f6593c.put("SHA", KeyProperties.DIGEST_SHA1);
        f6593c.put("SHA1", KeyProperties.DIGEST_SHA1);
        f6593c.put(KeyProperties.DIGEST_SHA1, KeyProperties.DIGEST_SHA1);
        f6593c.put(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA256);
        f6593c.put(KeyProperties.DIGEST_SHA384, KeyProperties.DIGEST_SHA384);
        f6593c.put(KeyProperties.DIGEST_SHA512, KeyProperties.DIGEST_SHA512);
        f6592b = new HashMap(5);
        f6592b.put(KeyProperties.DIGEST_MD5, 0);
        f6592b.put(KeyProperties.DIGEST_SHA1, 0);
        f6592b.put(KeyProperties.DIGEST_SHA256, 0);
        f6592b.put(KeyProperties.DIGEST_SHA384, 9);
        f6592b.put(KeyProperties.DIGEST_SHA512, 9);
    }

    /* renamed from: b */
    private static String m8708b(String str) {
        return f6593c.get(str.toUpperCase(Locale.f10688US));
    }

    /* renamed from: a */
    public static int m8697a(String str) {
        Integer num = f6592b.get(str.toUpperCase(Locale.f10688US));
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private static String m8699a(String str, String str2) {
        return KeyProperties.DIGEST_SHA1.equalsIgnoreCase(str) ? "SHA1" + str2 : String.valueOf(str) + str2;
    }

    /* renamed from: a */
    private static byte[] m8707a(Collection<a> collection, String str) {
        for (a aVar : collection) {
            if (aVar.f6595b.equalsIgnoreCase(str)) {
                return aVar.f6594a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static List<C1062a> m8701a(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar) {
        long m8631c = cVar.m8631c();
        if (m8631c > 2147483647L) {
            throw new C1037a("ZIP Central Directory too large: " + m8631c);
        }
        long m8629a = cVar.m8629a();
        ByteBuffer mo8842a = interfaceC1069c.mo8842a(m8629a, (int) m8631c);
        mo8842a.order(ByteOrder.LITTLE_ENDIAN);
        int m8630b = cVar.m8630b();
        ArrayList arrayList = new ArrayList(m8630b);
        for (int i = 0; i < m8630b; i++) {
            int position = mo8842a.position();
            try {
                C1062a m8859a = C1062a.m8859a(mo8842a);
                if (!m8859a.m8870h().endsWith("/")) {
                    arrayList.add(m8859a);
                }
            } catch (C1072a e2) {
                throw new C1037a("Malformed ZIP Central Directory record #" + (i + 1) + " at file offset " + (m8629a + position), e2);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private static boolean m8714d(String str) {
        return (str.startsWith("META-INF/") || str.endsWith("/")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static Set<d> m8710b(InterfaceC1069c interfaceC1069c, long j, Collection<C1062a> collection, Map<String, C1050a.b> map, List<d> list, int i, int i2, b bVar) {
        ArrayList arrayList;
        ArrayList<C1062a> arrayList2 = new ArrayList(collection);
        Collections.sort(arrayList2, C1062a.f6708a);
        HashSet hashSet = new HashSet(map.keySet());
        String str = null;
        ArrayList arrayList3 = null;
        for (C1062a c1062a : arrayList2) {
            String m8870h = c1062a.m8870h();
            hashSet.remove(m8870h);
            if (m8714d(m8870h)) {
                C1050a.b bVar2 = map.get(m8870h);
                if (bVar2 != null) {
                    ArrayList arrayList4 = new ArrayList(list.size());
                    for (d dVar : list) {
                        if (dVar.m8743c().contains(m8870h)) {
                            arrayList4.add(dVar);
                        }
                    }
                    if (!arrayList4.isEmpty()) {
                        if (arrayList3 == null) {
                            arrayList = arrayList4;
                            str = m8870h;
                        } else if (arrayList4.equals(arrayList3)) {
                            arrayList = arrayList3;
                        } else {
                            bVar.m8718a(C1066c.c.JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH, str, m8702a(arrayList3), m8870h, m8702a(arrayList4));
                        }
                        ArrayList arrayList5 = new ArrayList(m8709b(bVar2, "-Digest", i, i2));
                        if (!arrayList5.isEmpty()) {
                            MessageDigest[] messageDigestArr = new MessageDigest[arrayList5.size()];
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= arrayList5.size()) {
                                    try {
                                        break;
                                    } catch (C1072a e2) {
                                        throw new C1037a("Malformed ZIP entry: " + m8870h, e2);
                                    } catch (IOException e3) {
                                        throw new IOException("Failed to read entry: " + m8870h, e3);
                                    }
                                }
                                messageDigestArr[i4] = m8713c(((a) arrayList5.get(i4)).f6595b);
                                i3 = i4 + 1;
                            }
                            C1064c.m8879a(interfaceC1069c, c1062a, j, new C1057e(messageDigestArr));
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 >= arrayList5.size()) {
                                    break;
                                }
                                a aVar = (a) arrayList5.get(i6);
                                byte[] digest = messageDigestArr[i6].digest();
                                if (!Arrays.equals(aVar.f6594a, digest)) {
                                    bVar.m8718a(C1066c.c.JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY, m8870h, aVar.f6595b, "META-INF/MANIFEST.MF", Base64.encodeToString(digest, 2), Base64.encodeToString(aVar.f6594a, 2));
                                }
                                i5 = i6 + 1;
                            }
                            arrayList3 = arrayList;
                        } else {
                            bVar.m8718a(C1066c.c.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST, m8870h);
                            arrayList3 = arrayList;
                        }
                    } else {
                        bVar.m8718a(C1066c.c.JAR_SIG_ZIP_ENTRY_NOT_SIGNED, m8870h);
                    }
                } else {
                    bVar.m8718a(C1066c.c.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST, m8870h);
                }
            }
        }
        if (arrayList3 != null) {
            return new HashSet(arrayList3);
        }
        bVar.m8718a(C1066c.c.JAR_SIG_NO_SIGNED_ZIP_ENTRIES, new Object[0]);
        return Collections.emptySet();
    }

    /* renamed from: a */
    private static List<String> m8702a(List<d> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m8739a());
        }
        return arrayList;
    }

    /* renamed from: c */
    private static MessageDigest m8713c(String str) {
        return MessageDigest.getInstance(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m8712b(String str, byte[] bArr, int i, int i2) {
        MessageDigest m8713c = m8713c(str);
        m8713c.update(bArr, i, i2);
        return m8713c.digest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m8711b(String str, byte[] bArr) {
        return m8713c(str).digest(bArr);
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.a.c$a */
    private static class a {

        /* renamed from: a */
        private final byte[] f6594a;

        /* renamed from: b */
        private final String f6595b;

        private a(String str, byte[] bArr) {
            this.f6595b = str;
            this.f6594a = bArr;
        }

        /* synthetic */ a(String str, byte[] bArr, a aVar) {
            this(str, bArr);
        }
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.a.c$b */
    public static class b {

        /* renamed from: c */
        public boolean f6598c;

        /* renamed from: b */
        public final List<c> f6597b = new ArrayList();

        /* renamed from: a */
        public final List<c> f6596a = new ArrayList();

        /* renamed from: e */
        private final List<C1066c.d> f6600e = new ArrayList();

        /* renamed from: d */
        private final List<C1066c.d> f6599d = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m8722c() {
            if (!this.f6599d.isEmpty()) {
                return true;
            }
            Iterator<c> it = this.f6597b.iterator();
            while (it.hasNext()) {
                if (it.next().m8730c()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8718a(C1066c.c cVar, Object... objArr) {
            this.f6599d.add(new C1066c.d(cVar, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m8721b(C1066c.c cVar, Object... objArr) {
            this.f6600e.add(new C1066c.d(cVar, objArr));
        }

        /* renamed from: a */
        public List<C1066c.d> m8723a() {
            return this.f6599d;
        }

        /* renamed from: b */
        public List<C1066c.d> m8724b() {
            return this.f6600e;
        }
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.a.c$c */
    public static class c {

        /* renamed from: a */
        public final List<X509Certificate> f6601a;

        /* renamed from: b */
        public final String f6602b;

        /* renamed from: c */
        public final String f6603c;

        /* renamed from: d */
        public final String f6604d;

        /* renamed from: e */
        private final List<C1066c.d> f6605e;

        /* renamed from: f */
        private final List<C1066c.d> f6606f;

        private c(String str, String str2, String str3) {
            this.f6601a = new ArrayList();
            this.f6606f = new ArrayList();
            this.f6605e = new ArrayList();
            this.f6602b = str;
            this.f6603c = str2;
            this.f6604d = str3;
        }

        /* synthetic */ c(String str, String str2, String str3, c cVar) {
            this(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m8730c() {
            return !this.f6605e.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8726a(C1066c.c cVar, Object... objArr) {
            this.f6605e.add(new C1066c.d(cVar, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m8729b(C1066c.c cVar, Object... objArr) {
            this.f6606f.add(new C1066c.d(cVar, objArr));
        }

        /* renamed from: a */
        public List<C1066c.d> m8731a() {
            return this.f6605e;
        }

        /* renamed from: b */
        public List<C1066c.d> m8732b() {
            return this.f6606f;
        }
    }
}
