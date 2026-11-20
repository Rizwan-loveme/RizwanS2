package com.p065b.p066a.p068b.p069a.p071b;

import android.security.keystore.KeyProperties;
import android.util.Base64;
import com.p065b.p066a.C0675d;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p075b.C0612a;
import com.p065b.p066a.p068b.p075b.C0619c;
import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import com.p065b.p066a.p068b.p078d.C0629a;
import com.p065b.p066a.p068b.p079e.C0632a;
import com.p065b.p066a.p068b.p080f.C0633a;
import com.p065b.p066a.p068b.p080f.C0634b;
import com.p065b.p066a.p068b.p080f.C0635c;
import com.p065b.p066a.p068b.p080f.C0638f;
import com.p065b.p066a.p068b.p080f.C0639g;
import com.p065b.p066a.p068b.p080f.C0641i;
import com.p065b.p066a.p068b.p081g.C0644c;
import com.p065b.p066a.p068b.p081g.C0649h;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p068b.p082h.C0657a;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p066a.p068b.p083i.C0664a;
import com.p065b.p066a.p068b.p083i.C0666c;
import com.p065b.p066a.p084c.AbstractC0670b;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0676a;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
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

/* compiled from: V1SchemeVerifier.java */
/* renamed from: com.b.a.b.a.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC0594c {
    private static final String[] JB_MR2_AND_NEWER_DIGEST_ALGS = {KeyProperties.DIGEST_SHA512, KeyProperties.DIGEST_SHA384, KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA1};
    private static final Map<String, Integer> MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST;
    private static final Map<String, String> UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL;

    /* compiled from: V1SchemeVerifier.java */
    @InterfaceC0618b(m6143a = EnumC0626j.CHOICE)
    /* renamed from: com.b.a.b.a.b.c$b */
    public static class b {

        @InterfaceC0622f(m6183g = EnumC0626j.OBJECT_IDENTIFIER)
        public String value;
    }

    /* compiled from: V1SchemeVerifier.java */
    @InterfaceC0618b(m6143a = EnumC0626j.CHOICE)
    /* renamed from: com.b.a.b.a.b.c$c */
    public static class c {

        @InterfaceC0622f(m6183g = EnumC0626j.OCTET_STRING)
        public byte[] value;
    }

    private AbstractC0594c() {
    }

    /* renamed from: a */
    public static d m5876a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar, Map<Integer, String> map, Set<Integer> set, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException("minSdkVersion (" + i + ") > maxSdkVersion (" + i2 + ")");
        }
        d dVar = new d();
        List<C0664a> m5880a = m5880a(interfaceC0671c, cVar);
        Set<String> m5883a = m5883a(m5880a, dVar);
        if (!dVar.m5898c()) {
            g.m5928b(interfaceC0671c, cVar.m6355a(), m5880a, m5883a, map, set, i, i2, dVar);
        }
        return dVar;
    }

    /* renamed from: a */
    private static Set<String> m5883a(List<C0664a> list, d dVar) {
        HashSet hashSet = new HashSet(list.size());
        Iterator<C0664a> it = list.iterator();
        HashSet hashSet2 = null;
        while (it.hasNext()) {
            String m6287h = it.next().m6287h();
            if (!hashSet.add(m6287h)) {
                HashSet hashSet3 = hashSet2 == null ? new HashSet() : hashSet2;
                if (hashSet3.add(m6287h)) {
                    dVar.m5894a(C0675d.d.JAR_SIG_DUPLICATE_ZIP_ENTRY, m6287h);
                    hashSet2 = hashSet3;
                } else {
                    hashSet2 = hashSet3;
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public static C0652k<C0629a.b, Map<String, C0629a.b>> m5877a(byte[] bArr, Set<String> set, d dVar) {
        C0629a c0629a = new C0629a(bArr);
        C0629a.b m6206b = c0629a.m6206b();
        List<C0629a.b> m6205a = c0629a.m6205a();
        HashMap hashMap = new HashMap(m6205a.size());
        int i = 0;
        for (C0629a.b bVar : m6205a) {
            i++;
            String m6209a = bVar.m6209a();
            if (m6209a != null) {
                if (hashMap.put(m6209a, bVar) == 0) {
                    if (!set.contains(m6209a)) {
                        dVar.m5894a(C0675d.d.JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST, m6209a);
                    }
                } else {
                    dVar.m5894a(C0675d.d.JAR_SIG_DUPLICATE_MANIFEST_SECTION, m6209a);
                }
            } else {
                dVar.m5894a(C0675d.d.JAR_SIG_UNNNAMED_MANIFEST_SECTION, Integer.valueOf(i));
            }
        }
        return C0652k.m6250a(m6206b, hashMap);
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.a.b.a.b.c$g */
    private static class g {
        private g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        public static void m5928b(InterfaceC0671c interfaceC0671c, long j, List<C0664a> list, Set<String> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2, d dVar) {
            HashMap hashMap = new HashMap(1);
            ArrayList<C0664a> arrayList = new ArrayList(1);
            C0664a c0664a = null;
            for (C0664a c0664a2 : list) {
                String m6287h = c0664a2.m6287h();
                if (m6287h.startsWith("META-INF/")) {
                    if (c0664a == null && "META-INF/MANIFEST.MF".equals(m6287h)) {
                        c0664a = c0664a2;
                    } else if (m6287h.endsWith(".SF")) {
                        hashMap.put(m6287h, c0664a2);
                    } else if (m6287h.endsWith(".RSA") || m6287h.endsWith(".DSA") || m6287h.endsWith(".EC")) {
                        arrayList.add(c0664a2);
                    }
                }
            }
            if (c0664a != null) {
                try {
                    byte[] m6298b = C0666c.m6298b(interfaceC0671c, c0664a, j);
                    C0652k<C0629a.b, Map<String, C0629a.b>> m5877a = AbstractC0594c.m5877a(m6298b, set, dVar);
                    if (!dVar.m5898c()) {
                        C0629a.b m6251a = m5877a.m6251a();
                        Map<String, C0629a.b> m6252b = m5877a.m6252b();
                        ArrayList<f> arrayList2 = new ArrayList(arrayList.size());
                        for (C0664a c0664a3 : arrayList) {
                            String m6287h2 = c0664a3.m6287h();
                            int lastIndexOf = m6287h2.lastIndexOf(46);
                            if (lastIndexOf == -1) {
                                throw new RuntimeException("Signature block file name does not contain extension: " + m6287h2);
                            }
                            String str = m6287h2.substring(0, lastIndexOf) + ".SF";
                            C0664a c0664a4 = (C0664a) hashMap.get(str);
                            if (c0664a4 != null) {
                                String substring = m6287h2.substring(9);
                                arrayList2.add(new f(substring, c0664a3, c0664a4, new d.a(substring, m6287h2, c0664a4.m6287h())));
                            } else {
                                dVar.m5897b(C0675d.d.JAR_SIG_MISSING_FILE, m6287h2, str);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            for (f fVar : arrayList2) {
                                fVar.m5919a(interfaceC0671c, j, i, i2);
                                if (fVar.m5921b().m5906c()) {
                                    dVar.f4029b.add(fVar.m5921b());
                                }
                            }
                            if (!dVar.m5898c()) {
                                ArrayList<f> arrayList3 = new ArrayList(arrayList2.size());
                                for (f fVar2 : arrayList2) {
                                    fVar2.m5920a(m6298b, m6251a, m6252b, map, set2, i, i2);
                                    if (fVar2.m5925f()) {
                                        dVar.f4028a.add(fVar2.m5921b());
                                    } else if (fVar2.m5921b().m5906c()) {
                                        dVar.f4029b.add(fVar2.m5921b());
                                    } else {
                                        arrayList3.add(fVar2);
                                    }
                                }
                                if (!dVar.m5898c()) {
                                    if (!arrayList3.isEmpty()) {
                                        Set<f> m5888b = AbstractC0594c.m5888b(interfaceC0671c, j, list, m6252b, arrayList3, i, i2, dVar);
                                        if (!dVar.m5898c()) {
                                            HashSet hashSet = new HashSet((dVar.f4029b.size() * 2) + 1);
                                            hashSet.add(c0664a.m6287h());
                                            for (f fVar3 : m5888b) {
                                                hashSet.add(fVar3.m5923d());
                                                hashSet.add(fVar3.m5924e());
                                            }
                                            Iterator<C0664a> it = list.iterator();
                                            while (it.hasNext()) {
                                                String m6287h3 = it.next().m6287h();
                                                if (m6287h3.startsWith("META-INF/") && !m6287h3.endsWith("/") && !hashSet.contains(m6287h3)) {
                                                    dVar.m5897b(C0675d.d.JAR_SIG_UNPROTECTED_ZIP_ENTRY, m6287h3);
                                                }
                                            }
                                            for (f fVar4 : arrayList3) {
                                                if (m5888b.contains(fVar4)) {
                                                    dVar.f4029b.add(fVar4.m5921b());
                                                } else {
                                                    dVar.f4028a.add(fVar4.m5921b());
                                                }
                                            }
                                            dVar.f4030c = true;
                                            return;
                                        }
                                        return;
                                    }
                                    dVar.m5894a(C0675d.d.JAR_SIG_NO_SIGNATURES, new Object[0]);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        dVar.m5894a(C0675d.d.JAR_SIG_NO_SIGNATURES, new Object[0]);
                        return;
                    }
                    return;
                } catch (C0676a e2) {
                    throw new C0579a("Malformed ZIP entry: " + c0664a.m6287h(), e2);
                }
            }
            dVar.m5894a(C0675d.d.JAR_SIG_NO_MANIFEST, new Object[0]);
        }
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.a.b.a.b.c$f */
    static class f {

        /* renamed from: a */
        private boolean f4040a;

        /* renamed from: b */
        private final String f4041b;

        /* renamed from: c */
        private final d.a f4042c;

        /* renamed from: d */
        private byte[] f4043d;

        /* renamed from: e */
        private Set<String> f4044e;

        /* renamed from: f */
        private final C0664a f4045f;

        /* renamed from: g */
        private final C0664a f4046g;

        private f(String str, C0664a c0664a, C0664a c0664a2, d.a aVar) {
            this.f4041b = str;
            this.f4042c = aVar;
            this.f4045f = c0664a;
            this.f4046g = c0664a2;
        }

        /* renamed from: a */
        public String m5918a() {
            return this.f4041b;
        }

        /* renamed from: e */
        public String m5924e() {
            return this.f4046g.m6287h();
        }

        /* renamed from: d */
        public String m5923d() {
            return this.f4045f.m6287h();
        }

        /* renamed from: g */
        void m5926g() {
            this.f4040a = true;
        }

        /* renamed from: f */
        public boolean m5925f() {
            return this.f4040a;
        }

        /* renamed from: c */
        public Set<String> m5922c() {
            return this.f4044e;
        }

        /* renamed from: b */
        public d.a m5921b() {
            return this.f4042c;
        }

        /* renamed from: a */
        public void m5919a(InterfaceC0671c interfaceC0671c, long j, int i, int i2) {
            List<C0641i> list;
            List<X509Certificate> m6273a;
            C0641i c0641i;
            try {
                byte[] m6298b = C0666c.m6298b(interfaceC0671c, this.f4045f, j);
                try {
                    this.f4043d = C0666c.m6298b(interfaceC0671c, this.f4046g, j);
                    try {
                        C0635c c0635c = (C0635c) C0612a.m6091a(ByteBuffer.wrap(m6298b), C0635c.class);
                        if (!"1.2.840.113549.1.7.2".equals(c0635c.contentType)) {
                            throw new C0619c("Unsupported ContentInfo.contentType: " + c0635c.contentType);
                        }
                        C0639g c0639g = (C0639g) C0612a.m6091a(c0635c.content.m6184a(), C0639g.class);
                        if (!c0639g.signerInfos.isEmpty()) {
                            if (i < 24) {
                                list = Collections.singletonList(c0639g.signerInfos.get(0));
                            } else {
                                list = c0639g.signerInfos;
                            }
                            C0641i c0641i2 = null;
                            X509Certificate x509Certificate = null;
                            List<X509Certificate> list2 = null;
                            for (C0641i c0641i3 : list) {
                                if (list2 == null) {
                                    try {
                                        m6273a = C0657a.m6273a(c0639g.certificates);
                                    } catch (CertificateException e2) {
                                        this.f4042c.m5902a(C0675d.d.JAR_SIG_PARSE_EXCEPTION, this.f4045f.m6287h(), e2);
                                        return;
                                    }
                                } else {
                                    m6273a = list2;
                                }
                                try {
                                    X509Certificate m5912a = m5912a(c0639g, m6273a, c0641i3, this.f4043d, i, i2);
                                    if (this.f4042c.m5906c()) {
                                        return;
                                    }
                                    if (m5912a == null || c0641i2 != null) {
                                        m5912a = x509Certificate;
                                        c0641i = c0641i2;
                                    } else {
                                        c0641i = c0641i3;
                                    }
                                    c0641i2 = c0641i;
                                    x509Certificate = m5912a;
                                    list2 = m6273a;
                                } catch (C0638f e3) {
                                    this.f4042c.m5902a(C0675d.d.JAR_SIG_PARSE_EXCEPTION, this.f4045f.m6287h(), e3);
                                    return;
                                } catch (InvalidKeyException e4) {
                                    e = e4;
                                    this.f4042c.m5902a(C0675d.d.JAR_SIG_VERIFY_EXCEPTION, this.f4045f.m6287h(), this.f4046g.m6287h(), e);
                                    return;
                                } catch (SignatureException e5) {
                                    e = e5;
                                    this.f4042c.m5902a(C0675d.d.JAR_SIG_VERIFY_EXCEPTION, this.f4045f.m6287h(), this.f4046g.m6287h(), e);
                                    return;
                                }
                            }
                            if (c0641i2 != null) {
                                List<X509Certificate> m5913a = m5913a(list2, x509Certificate);
                                this.f4042c.f4033a.clear();
                                this.f4042c.f4033a.addAll(m5913a);
                                return;
                            }
                            this.f4042c.m5902a(C0675d.d.JAR_SIG_DID_NOT_VERIFY, this.f4045f.m6287h(), this.f4046g.m6287h());
                            return;
                        }
                        this.f4042c.m5902a(C0675d.d.JAR_SIG_NO_SIGNERS, this.f4045f.m6287h());
                    } catch (C0619c e6) {
                        e6.printStackTrace();
                        this.f4042c.m5902a(C0675d.d.JAR_SIG_PARSE_EXCEPTION, this.f4045f.m6287h(), e6);
                    }
                } catch (C0676a e7) {
                    throw new C0579a("Malformed ZIP entry: " + this.f4046g.m6287h(), e7);
                }
            } catch (C0676a e8) {
                throw new C0579a("Malformed ZIP entry: " + this.f4045f.m6287h(), e8);
            }
        }

        /* renamed from: a */
        private X509Certificate m5912a(C0639g c0639g, Collection<X509Certificate> collection, C0641i c0641i, byte[] bArr, int i, int i2) {
            String str = c0641i.digestAlgorithm.algorithm;
            String str2 = c0641i.signatureAlgorithm.algorithm;
            List<C0649h> m6248a = C0649h.m6246a(i, i2).m6248a(C0632a.m6225a(str, str2));
            boolean z = false;
            if (!m6248a.isEmpty()) {
                String m6227a = C0632a.a.m6227a(str);
                String str3 = m6227a == null ? str : m6227a;
                String m6227a2 = C0632a.a.m6227a(str2);
                String str4 = m6227a2 == null ? str2 : m6227a2;
                StringBuilder sb = new StringBuilder();
                for (C0649h c0649h : m6248a) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    if (c0649h.m6249b() == c0649h.m6247a()) {
                        sb.append(String.valueOf(c0649h.m6249b()));
                    } else if (c0649h.m6247a() == Integer.MAX_VALUE) {
                        sb.append(c0649h.m6249b() + "+");
                    } else {
                        sb.append(c0649h.m6249b() + "-" + c0649h.m6247a());
                    }
                }
                this.f4042c.m5902a(C0675d.d.JAR_SIG_UNSUPPORTED_SIG_ALG, this.f4045f.m6287h(), str, str2, sb.toString(), str3, str4);
                return null;
            }
            X509Certificate m6272a = C0657a.m6272a(collection, c0641i.sid);
            if (m6272a == null) {
                throw new SignatureException("Signing certificate referenced in SignerInfo not found in SignedData");
            }
            if (m6272a.hasUnsupportedCriticalExtension()) {
                throw new SignatureException("Signing certificate has unsupported critical extensions");
            }
            boolean[] keyUsage = m6272a.getKeyUsage();
            if (keyUsage != null) {
                boolean z2 = keyUsage.length >= 1 && keyUsage[0];
                if (keyUsage.length >= 2 && keyUsage[1]) {
                    z = true;
                }
                if (!z2 && !z) {
                    throw new SignatureException("Signing certificate not authorized for use in digital signatures: keyUsage extension missing digitalSignature and nonRepudiation");
                }
            }
            String m6231a = C0633a.m6231a(str, str2);
            Signature signature = Signature.getInstance(m6231a);
            PublicKey publicKey = m6272a.getPublicKey();
            try {
                signature.initVerify(publicKey);
            } catch (InvalidKeyException e2) {
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(publicKey.getAlgorithm()).generatePublic(new X509EncodedKeySpec(C0598d.m5959a(publicKey)));
                    signature = Signature.getInstance(m6231a);
                    signature.initVerify(generatePublic);
                } catch (InvalidKeySpecException e3) {
                    throw e2;
                }
            }
            if (c0641i.signedAttrs != null) {
                if (i < 19) {
                    throw new SignatureException("APKs with Signed Attributes broken on platforms with API Level < 19");
                }
                try {
                    e eVar = new e(C0612a.m6098b(c0641i.signedAttrs.m6184a(), C0634b.class));
                    if (i2 >= 24) {
                        String m5910a = eVar.m5910a("1.2.840.113549.1.9.3");
                        if (m5910a == null) {
                            throw new SignatureException("No Content Type in signed attributes");
                        }
                        if (!m5910a.equals(c0639g.encapContentInfo.contentType)) {
                            return null;
                        }
                    }
                    byte[] m5911b = eVar.m5911b("1.2.840.113549.1.9.4");
                    if (m5911b == null) {
                        throw new SignatureException("No content digest in signed attributes");
                    }
                    if (!Arrays.equals(m5911b, MessageDigest.getInstance(C0633a.m6230a(str)).digest(bArr))) {
                        return null;
                    }
                    ByteBuffer m6184a = c0641i.signedAttrs.m6184a();
                    signature.update((byte) 49);
                    m6184a.position(1);
                    signature.update(m6184a);
                } catch (C0619c e4) {
                    throw new SignatureException("Failed to parse signed attributes", e4);
                }
            } else {
                signature.update(bArr);
            }
            if (signature.verify(C0644c.m6241a(c0641i.signature.slice()))) {
                return m6272a;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public static List<X509Certificate> m5913a(List<X509Certificate> list, X509Certificate x509Certificate) {
            boolean z;
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(x509Certificate);
            arrayList.remove(x509Certificate);
            while (!x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN())) {
                Principal issuerDN = x509Certificate.getIssuerDN();
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        z = false;
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) arrayList.get(i);
                    if (issuerDN.equals(x509Certificate2.getSubjectDN())) {
                        arrayList.remove(i);
                        arrayList2.add(x509Certificate2);
                        z = true;
                        x509Certificate = x509Certificate2;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    break;
                }
            }
            return arrayList2;
        }

        /* renamed from: a */
        public void m5920a(byte[] bArr, C0629a.b bVar, Map<String, C0629a.b> map, Map<Integer, String> map2, Set<Integer> set, int i, int i2) {
            boolean z;
            C0629a c0629a = new C0629a(this.f4043d);
            C0629a.b m6206b = c0629a.m6206b();
            if (m6206b.m6211a(Attributes.Name.SIGNATURE_VERSION) != null) {
                if (i2 >= 24) {
                    m5915a(m6206b, map2, set);
                    if (this.f4042c.m5906c()) {
                        return;
                    }
                }
                String m6210a = m6206b.m6210a("Created-By");
                if (m6210a != null) {
                    z = m6210a.indexOf("signtool") != -1;
                } else {
                    z = false;
                }
                boolean m5917a = m5917a(m6206b, z, bArr, i, i2);
                if (!z) {
                    m5914a(m6206b, bVar, bArr, i, i2);
                }
                if (!this.f4042c.m5906c()) {
                    List<C0629a.b> m6205a = c0629a.m6205a();
                    HashSet hashSet = new HashSet(m6205a.size());
                    int i3 = 0;
                    for (C0629a.b bVar2 : m6205a) {
                        int i4 = i3 + 1;
                        String m6209a = bVar2.m6209a();
                        if (m6209a != null) {
                            if (!hashSet.add(m6209a)) {
                                this.f4042c.m5902a(C0675d.d.JAR_SIG_DUPLICATE_SIG_FILE_SECTION, this.f4046g.m6287h(), m6209a);
                                m5926g();
                                return;
                            }
                            if (!m5917a) {
                                C0629a.b bVar3 = map.get(m6209a);
                                if (bVar3 != null) {
                                    m5916a(bVar2, z, bVar3, bArr, i, i2);
                                } else {
                                    this.f4042c.m5902a(C0675d.d.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE, m6209a, this.f4046g.m6287h());
                                    m5926g();
                                }
                            }
                            i3 = i4;
                        } else {
                            this.f4042c.m5902a(C0675d.d.JAR_SIG_UNNNAMED_SIG_FILE_SECTION, this.f4046g.m6287h(), Integer.valueOf(i4));
                            m5926g();
                            return;
                        }
                    }
                    this.f4044e = hashSet;
                    return;
                }
                return;
            }
            this.f4042c.m5902a(C0675d.d.JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE, this.f4046g.m6287h());
            m5926g();
        }

        /* renamed from: a */
        private boolean m5917a(C0629a.b bVar, boolean z, byte[] bArr, int i, int i2) {
            Collection<a> m5879a = AbstractC0594c.m5879a(bVar, z ? "-Digest" : "-Digest-Manifest", i, i2);
            if (!(!m5879a.isEmpty())) {
                this.f4042c.m5905b(C0675d.d.JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE, this.f4046g.m6287h());
                return false;
            }
            boolean z2 = true;
            for (a aVar : m5879a) {
                String str = aVar.f4027b;
                byte[] m5889b = AbstractC0594c.m5889b(str, bArr);
                byte[] bArr2 = aVar.f4026a;
                if (!Arrays.equals(bArr2, m5889b)) {
                    this.f4042c.m5905b(C0675d.d.JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY, "META-INF/MANIFEST.MF", str, this.f4046g.m6287h(), Base64.encodeToString(m5889b, 2), Base64.encodeToString(bArr2, 2));
                    z2 = false;
                }
            }
            return z2;
        }

        /* renamed from: a */
        private void m5914a(C0629a.b bVar, C0629a.b bVar2, byte[] bArr, int i, int i2) {
            Collection<a> m5879a = AbstractC0594c.m5879a(bVar, "-Digest-Manifest-Main-Attributes", i, i2);
            if (!m5879a.isEmpty()) {
                for (a aVar : m5879a) {
                    String str = aVar.f4027b;
                    byte[] m5890b = AbstractC0594c.m5890b(str, bArr, bVar2.m6213c(), bVar2.m6212b());
                    byte[] bArr2 = aVar.f4026a;
                    if (!Arrays.equals(bArr2, m5890b)) {
                        this.f4042c.m5902a(C0675d.d.JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY, str, this.f4046g.m6287h(), Base64.encodeToString(m5890b, 2), Base64.encodeToString(bArr2, 2));
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m5916a(C0629a.b bVar, boolean z, C0629a.b bVar2, byte[] bArr, int i, int i2) {
            int i3;
            String m6209a = bVar.m6209a();
            Collection<a> m5879a = AbstractC0594c.m5879a(bVar, "-Digest", i, i2);
            if (!m5879a.isEmpty()) {
                int m6213c = bVar2.m6213c();
                int m6212b = bVar2.m6212b();
                if (z) {
                    int i4 = m6213c + m6212b;
                    if (bArr[i4 - 1] == 10 && bArr[i4 - 2] == 10) {
                        i3 = m6212b - 1;
                        for (a aVar : m5879a) {
                            String str = aVar.f4027b;
                            byte[] m5890b = AbstractC0594c.m5890b(str, bArr, m6213c, i3);
                            byte[] bArr2 = aVar.f4026a;
                            if (!Arrays.equals(bArr2, m5890b)) {
                                this.f4042c.m5902a(C0675d.d.JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY, m6209a, str, this.f4046g.m6287h(), Base64.encodeToString(m5890b, 2), Base64.encodeToString(bArr2, 2));
                            }
                        }
                        return;
                    }
                }
                i3 = m6212b;
                while (r5.hasNext()) {
                }
                return;
            }
            this.f4042c.m5902a(C0675d.d.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE, m6209a, this.f4046g.m6287h());
        }

        /* renamed from: a */
        private void m5915a(C0629a.b bVar, Map<Integer, String> map, Set<Integer> set) {
            String m6210a = bVar.m6210a("X-Android-APK-Signed");
            if (m6210a == null) {
                if (set.isEmpty()) {
                    return;
                }
                this.f4042c.m5905b(C0675d.d.JAR_SIG_NO_APK_SIG_STRIP_PROTECTION, this.f4046g.m6287h());
                return;
            }
            if (!map.isEmpty()) {
                Set<Integer> keySet = map.keySet();
                HashSet hashSet = new HashSet(1);
                StringTokenizer stringTokenizer = new StringTokenizer(m6210a, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    String trim = stringTokenizer.nextToken().trim();
                    if (!trim.isEmpty()) {
                        try {
                            int parseInt = Integer.parseInt(trim);
                            if (keySet.contains(Integer.valueOf(parseInt))) {
                                hashSet.add(Integer.valueOf(parseInt));
                            } else {
                                this.f4042c.m5905b(C0675d.d.JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID, this.f4046g.m6287h(), Integer.valueOf(parseInt));
                            }
                        } catch (Exception e2) {
                        }
                    }
                }
                Iterator<E> it = hashSet.iterator();
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!set.contains(Integer.valueOf(intValue))) {
                        this.f4042c.m5902a(C0675d.d.JAR_SIG_MISSING_APK_SIG_REFERENCED, this.f4046g.m6287h(), Integer.valueOf(intValue), map.get(Integer.valueOf(intValue)));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static Collection<a> m5879a(C0629a.b bVar, String str, int i, int i2) {
        String m5887b;
        ArrayList arrayList = new ArrayList(1);
        if (i < 18) {
            String m6210a = bVar.m6210a("Digest-Algorithms");
            if (m6210a == null) {
                m6210a = "SHA SHA1";
            }
            StringTokenizer stringTokenizer = new StringTokenizer(m6210a);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String nextToken = stringTokenizer.nextToken();
                String m6210a2 = bVar.m6210a(nextToken + str);
                if (m6210a2 != null && (m5887b = m5887b(nextToken)) != null && m5875a(m5887b) <= i) {
                    arrayList.add(new a(m5887b, Base64.decode(m6210a2, 2)));
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                return arrayList;
            }
        }
        if (i2 >= 18) {
            String[] strArr = JB_MR2_AND_NEWER_DIGEST_ALGS;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                String m6210a3 = bVar.m6210a(m5878a(str2, str));
                if (m6210a3 == null) {
                    i3++;
                } else {
                    byte[] decode = Base64.decode(m6210a3, 2);
                    byte[] m5886a = m5886a(arrayList, str2);
                    if (m5886a == null || !Arrays.equals(m5886a, decode)) {
                        arrayList.add(new a(str2, decode));
                    }
                }
            }
        }
        return arrayList;
    }

    static {
        HashMap hashMap = new HashMap(8);
        UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL = hashMap;
        hashMap.put(KeyProperties.DIGEST_MD5, KeyProperties.DIGEST_MD5);
        hashMap.put("SHA", KeyProperties.DIGEST_SHA1);
        hashMap.put("SHA1", KeyProperties.DIGEST_SHA1);
        hashMap.put(KeyProperties.DIGEST_SHA1, KeyProperties.DIGEST_SHA1);
        hashMap.put(KeyProperties.DIGEST_SHA256, KeyProperties.DIGEST_SHA256);
        hashMap.put(KeyProperties.DIGEST_SHA384, KeyProperties.DIGEST_SHA384);
        hashMap.put(KeyProperties.DIGEST_SHA512, KeyProperties.DIGEST_SHA512);
        HashMap hashMap2 = new HashMap(5);
        MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST = hashMap2;
        hashMap2.put(KeyProperties.DIGEST_MD5, 0);
        hashMap2.put(KeyProperties.DIGEST_SHA1, 0);
        hashMap2.put(KeyProperties.DIGEST_SHA256, 0);
        hashMap2.put(KeyProperties.DIGEST_SHA384, 9);
        hashMap2.put(KeyProperties.DIGEST_SHA512, 9);
    }

    /* renamed from: b */
    private static String m5887b(String str) {
        return UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL.get(str.toUpperCase(Locale.f10688US));
    }

    /* renamed from: a */
    public static int m5875a(String str) {
        Integer num = MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST.get(str.toUpperCase(Locale.f10688US));
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private static String m5878a(String str, String str2) {
        if (KeyProperties.DIGEST_SHA1.equalsIgnoreCase(str)) {
            return "SHA1" + str2;
        }
        return str + str2;
    }

    /* renamed from: a */
    private static byte[] m5886a(Collection<a> collection, String str) {
        for (a aVar : collection) {
            if (aVar.f4027b.equalsIgnoreCase(str)) {
                return aVar.f4026a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static List<C0664a> m5880a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        return AbstractC0667d.m6314a(interfaceC0671c, cVar);
    }

    /* renamed from: d */
    private static boolean m5892d(String str) {
        if (str.startsWith("META-INF/")) {
            return false;
        }
        return !str.endsWith("/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static Set<f> m5888b(InterfaceC0671c interfaceC0671c, long j, Collection<C0664a> collection, Map<String, C0629a.b> map, List<f> list, int i, int i2, d dVar) {
        String str;
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList, C0664a.BY_LOCAL_FILE_HEADER_OFFSET_COMPARATOR);
        Iterator it = arrayList.iterator();
        ArrayList arrayList2 = null;
        String str2 = null;
        while (it.hasNext()) {
            C0664a c0664a = (C0664a) it.next();
            String m6287h = c0664a.m6287h();
            if (m5892d(m6287h)) {
                C0629a.b bVar = map.get(m6287h);
                if (bVar == null) {
                    dVar.m5894a(C0675d.d.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST, m6287h);
                } else {
                    ArrayList arrayList3 = new ArrayList(list.size());
                    for (f fVar : list) {
                        if (fVar.m5922c().contains(m6287h)) {
                            arrayList3.add(fVar);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        dVar.m5894a(C0675d.d.JAR_SIG_ZIP_ENTRY_NOT_SIGNED, m6287h);
                    } else {
                        if (arrayList2 == null) {
                            arrayList2 = arrayList3;
                            str = m6287h;
                        } else if (arrayList3.equals(arrayList2)) {
                            str = str2;
                        } else {
                            dVar.m5894a(C0675d.d.JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH, str2, m5881a(arrayList2), m6287h, m5881a(arrayList3));
                        }
                        ArrayList arrayList4 = new ArrayList(m5879a(bVar, "-Digest", i, i2));
                        if (arrayList4.isEmpty()) {
                            dVar.m5894a(C0675d.d.JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST, m6287h);
                        } else {
                            MessageDigest[] messageDigestArr = new MessageDigest[arrayList4.size()];
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 < arrayList4.size()) {
                                    messageDigestArr[i4] = m5891c(((a) arrayList4.get(i4)).f4027b);
                                    i3 = i4 + 1;
                                } else {
                                    try {
                                        break;
                                    } catch (C0676a e2) {
                                        e = e2;
                                    } catch (IOException e3) {
                                        e = e3;
                                    }
                                }
                            }
                            try {
                                C0666c.m6297a(interfaceC0671c, c0664a, j, AbstractC0670b.m6334a(messageDigestArr));
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= arrayList4.size()) {
                                        break;
                                    }
                                    a aVar = (a) arrayList4.get(i6);
                                    byte[] digest = messageDigestArr[i6].digest();
                                    if (!Arrays.equals(aVar.f4026a, digest)) {
                                        dVar.m5894a(C0675d.d.JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY, m6287h, aVar.f4027b, "META-INF/MANIFEST.MF", Base64.encodeToString(digest, 2), Base64.encodeToString(aVar.f4026a, 2));
                                    }
                                    i5 = i6 + 1;
                                }
                            } catch (C0676a e4) {
                                e = e4;
                                throw new C0579a("Malformed ZIP entry: " + m6287h, e);
                            } catch (IOException e5) {
                                e = e5;
                                throw new IOException("Failed to read entry: " + m6287h, e);
                            }
                        }
                        str2 = str;
                        it = it;
                    }
                }
            }
        }
        if (arrayList2 != null) {
            return new HashSet(arrayList2);
        }
        dVar.m5894a(C0675d.d.JAR_SIG_NO_SIGNED_ZIP_ENTRIES, new Object[0]);
        return Collections.emptySet();
    }

    /* renamed from: a */
    private static List<String> m5881a(List<f> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<f> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m5918a());
        }
        return arrayList;
    }

    /* renamed from: c */
    private static MessageDigest m5891c(String str) {
        return MessageDigest.getInstance(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m5890b(String str, byte[] bArr, int i, int i2) {
        MessageDigest m5891c = m5891c(str);
        m5891c.update(bArr, i, i2);
        return m5891c.digest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static byte[] m5889b(String str, byte[] bArr) {
        return m5891c(str).digest(bArr);
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.a.b.a.b.c$a */
    public static class a {

        /* renamed from: a */
        public final byte[] f4026a;

        /* renamed from: b */
        public final String f4027b;

        private a(String str, byte[] bArr) {
            this.f4027b = str;
            this.f4026a = bArr;
        }
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.a.b.a.b.c$d */
    public static class d {

        /* renamed from: c */
        public boolean f4030c;

        /* renamed from: b */
        public final List<a> f4029b = new ArrayList();

        /* renamed from: a */
        public final List<a> f4028a = new ArrayList();

        /* renamed from: e */
        private final List<C0675d.e> f4032e = new ArrayList();

        /* renamed from: d */
        private final List<C0675d.e> f4031d = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m5898c() {
            if (!this.f4031d.isEmpty()) {
                return true;
            }
            Iterator<a> it = this.f4029b.iterator();
            while (it.hasNext()) {
                if (it.next().m5906c()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m5894a(C0675d.d dVar, Object... objArr) {
            this.f4031d.add(new C0675d.e(dVar, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m5897b(C0675d.d dVar, Object... objArr) {
            this.f4032e.add(new C0675d.e(dVar, objArr));
        }

        /* renamed from: a */
        public List<C0675d.e> m5899a() {
            return this.f4031d;
        }

        /* renamed from: b */
        public List<C0675d.e> m5900b() {
            return this.f4032e;
        }

        /* compiled from: V1SchemeVerifier.java */
        /* renamed from: com.b.a.b.a.b.c$d$a */
        public static class a {

            /* renamed from: a */
            public final List<X509Certificate> f4033a;

            /* renamed from: b */
            public final String f4034b;

            /* renamed from: c */
            public final String f4035c;

            /* renamed from: d */
            public final String f4036d;

            /* renamed from: e */
            private final List<C0675d.e> f4037e;

            /* renamed from: f */
            private final List<C0675d.e> f4038f;

            private a(String str, String str2, String str3) {
                this.f4033a = new ArrayList();
                this.f4038f = new ArrayList();
                this.f4037e = new ArrayList();
                this.f4034b = str;
                this.f4035c = str2;
                this.f4036d = str3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: c */
            public boolean m5906c() {
                return !this.f4037e.isEmpty();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m5902a(C0675d.d dVar, Object... objArr) {
                this.f4037e.add(new C0675d.e(dVar, objArr));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: b */
            public void m5905b(C0675d.d dVar, Object... objArr) {
                this.f4038f.add(new C0675d.e(dVar, objArr));
            }

            /* renamed from: a */
            public List<C0675d.e> m5907a() {
                return this.f4037e;
            }

            /* renamed from: b */
            public List<C0675d.e> m5908b() {
                return this.f4038f;
            }
        }
    }

    /* compiled from: V1SchemeVerifier.java */
    /* renamed from: com.b.a.b.a.b.c$e */
    private static class e {

        /* renamed from: a */
        private Map<String, List<C0623g>> f4039a;

        public e(Collection<C0634b> collection) {
            HashMap hashMap = new HashMap(collection.size());
            for (C0634b c0634b : collection) {
                if (hashMap.put(c0634b.attrType, c0634b.attrValues) != 0) {
                    throw new C0638f("Duplicate signed attribute: " + c0634b.attrType);
                }
            }
            this.f4039a = hashMap;
        }

        /* renamed from: c */
        private C0623g m5909c(String str) {
            List<C0623g> list = this.f4039a.get(str);
            if (list != null && !list.isEmpty()) {
                if (list.size() > 1) {
                    throw new C0638f("Attribute " + str + " has multiple values");
                }
                return list.get(0);
            }
            return null;
        }

        /* renamed from: a */
        public String m5910a(String str) {
            C0623g m5909c = m5909c(str);
            if (m5909c == null) {
                return null;
            }
            try {
                return ((b) C0612a.m6091a(m5909c.m6184a(), b.class)).value;
            } catch (C0619c e2) {
                throw new C0638f("Failed to decode OBJECT IDENTIFIER", e2);
            }
        }

        /* renamed from: b */
        public byte[] m5911b(String str) {
            C0623g m5909c = m5909c(str);
            if (m5909c == null) {
                return null;
            }
            try {
                return ((c) C0612a.m6091a(m5909c.m6184a(), c.class)).value;
            } catch (C0619c e2) {
                throw new C0638f("Failed to decode OBJECT IDENTIFIER", e2);
            }
        }
    }
}
