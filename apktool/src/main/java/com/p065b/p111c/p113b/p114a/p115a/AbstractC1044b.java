package com.p065b.p111c.p113b.p114a.p115a;

import android.security.keystore.KeyProperties;
import android.util.Base64;
import com.p065b.p066a.p068b.p079e.C0632a;
import com.p065b.p111c.p112a.C1037a;
import com.p065b.p111c.p113b.p117b.AbstractC1051b;
import com.p065b.p111c.p113b.p117b.AbstractC1052c;
import com.p065b.p111c.p113b.p118c.C1059g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import p165d.p167b.p169b.C1423a;
import p165d.p167b.p169b.C1426d;
import p165d.p167b.p169b.C1431i;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p173f.C1496bn;
import p165d.p167b.p173f.C1505e;

/* compiled from: V1SchemeSigner.java */
/* renamed from: com.b.c.b.a.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1044b {

    /* renamed from: a */
    private static int[] f6577a;

    /* renamed from: b */
    private static final Attributes.Name f6578b = new Attributes.Name("Created-By");

    /* renamed from: e */
    private static final Attributes.Name f6581e = new Attributes.Name("X-Android-APK-Signed");

    /* renamed from: c */
    private static final C1505e f6579c = m8693d(C0632a.OID_DIGEST_SHA1);

    /* renamed from: d */
    private static final C1505e f6580d = m8693d(C0632a.OID_DIGEST_SHA256);

    /* compiled from: V1SchemeSigner.java */
    /* renamed from: com.b.c.b.a.a.b$a */
    public static class a {

        /* renamed from: a */
        public byte[] f6582a;

        /* renamed from: b */
        public SortedMap<String, byte[]> f6583b;

        /* renamed from: c */
        public Attributes f6584c;
    }

    /* compiled from: V1SchemeSigner.java */
    /* renamed from: com.b.c.b.a.a.b$b */
    public static class b {

        /* renamed from: a */
        public List<X509Certificate> f6585a;

        /* renamed from: b */
        public String f6586b;

        /* renamed from: c */
        public PrivateKey f6587c;

        /* renamed from: d */
        public EnumC1043a f6588d;
    }

    /* renamed from: a */
    static /* synthetic */ int[] m8688a() {
        int[] iArr = f6577a;
        if (iArr == null) {
            iArr = new int[EnumC1043a.valuesCustom().length];
            try {
                iArr[EnumC1043a.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1043a.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f6577a = iArr;
        }
        return iArr;
    }

    /* renamed from: a */
    public static EnumC1043a m8678a(PublicKey publicKey, int i) {
        String algorithm = publicKey.getAlgorithm();
        if (KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm)) {
            if (i < 18) {
                return EnumC1043a.SHA1;
            }
            return EnumC1043a.SHA256;
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            if (i < 21) {
                return EnumC1043a.SHA1;
            }
            return EnumC1043a.SHA256;
        }
        if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
            if (i < 18) {
                throw new InvalidKeyException("ECDSA signatures only supported for minSdkVersion 18 and higher");
            }
            return EnumC1043a.SHA256;
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    /* renamed from: a */
    public static String m8682a(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Empty name");
        }
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toUpperCase(Locale.f10688US).toCharArray()) {
            if ((c2 >= 'A' && c2 <= 'Z') || ((c2 >= '0' && c2 <= '9') || c2 == '-' || c2 == '_')) {
                sb.append(c2);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    private static MessageDigest m8694d(EnumC1043a enumC1043a) {
        return MessageDigest.getInstance(enumC1043a.m8671a());
    }

    /* renamed from: a */
    public static String m8681a(EnumC1043a enumC1043a) {
        return enumC1043a.m8671a();
    }

    /* renamed from: b */
    public static boolean m8690b(String str) {
        if (str.endsWith("/")) {
            return false;
        }
        if (str.startsWith("META-INF/") && str.indexOf(47, "META-INF/".length()) == -1) {
            String lowerCase = str.substring("META-INF/".length()).toLowerCase(Locale.f10688US);
            return ("manifest.mf".equals(lowerCase) || lowerCase.endsWith(".sf") || lowerCase.endsWith(".rsa") || lowerCase.endsWith(".dsa") || lowerCase.endsWith(".ec") || lowerCase.startsWith("sig-")) ? false : true;
        }
        return true;
    }

    /* renamed from: a */
    public static List<C1059g<String, byte[]>> m8684a(List<b> list, EnumC1043a enumC1043a, Map<String, byte[]> map, List<Integer> list2, byte[] bArr, String str) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        return m8683a(list, enumC1043a, list2, str, m8679a(enumC1043a, map, bArr));
    }

    /* renamed from: a */
    public static List<C1059g<String, byte[]>> m8683a(List<b> list, EnumC1043a enumC1043a, List<Integer> list2, String str, a aVar) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        ArrayList arrayList = new ArrayList((list.size() * 2) + 1);
        byte[] m8687a = m8687a(list2, enumC1043a, str, aVar);
        for (b bVar : list) {
            String str2 = bVar.f6586b;
            try {
                byte[] m8686a = m8686a(bVar, m8687a);
                arrayList.add(C1059g.m8851a("META-INF/" + str2 + ".SF", m8687a));
                arrayList.add(C1059g.m8851a("META-INF/" + str2 + "." + bVar.f6585a.get(0).getPublicKey().getAlgorithm().toUpperCase(Locale.f10688US), m8686a));
            } catch (InvalidKeyException e2) {
                throw new InvalidKeyException("Failed to sign using signer \"" + str2 + "\"", e2);
            } catch (SignatureException e3) {
                throw new SignatureException("Failed to sign using signer \"" + str2 + "\"", e3);
            } catch (CertificateException e4) {
                throw new CertificateException("Failed to sign using signer \"" + str2 + "\"", e4);
            }
        }
        arrayList.add(C1059g.m8851a("META-INF/MANIFEST.MF", aVar.f6582a));
        return arrayList;
    }

    /* renamed from: a */
    public static Set<String> m8685a(List<b> list) {
        HashSet hashSet = new HashSet((list.size() * 2) + 1);
        for (b bVar : list) {
            String str = bVar.f6586b;
            hashSet.add("META-INF/" + str + ".SF");
            hashSet.add("META-INF/" + str + "." + bVar.f6585a.get(0).getPublicKey().getAlgorithm().toUpperCase(Locale.f10688US));
        }
        hashSet.add("META-INF/MANIFEST.MF");
        return hashSet;
    }

    /* renamed from: a */
    public static a m8679a(EnumC1043a enumC1043a, Map<String, byte[]> map, byte[] bArr) {
        Manifest manifest = null;
        if (bArr != null) {
            try {
                manifest = new Manifest(new ByteArrayInputStream(bArr));
            } catch (IOException e2) {
                throw new C1037a("Malformed source META-INF/MANIFEST.MF", e2);
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Attributes attributes = new Attributes();
        if (manifest != null) {
            attributes.putAll(manifest.getMainAttributes());
        } else {
            attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        }
        try {
            AbstractC1051b.m8833a(byteArrayOutputStream, attributes);
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            TreeMap treeMap = new TreeMap();
            String m8689b = m8689b(enumC1043a);
            for (String str : arrayList) {
                m8692c(str);
                byte[] bArr2 = map.get(str);
                Attributes attributes2 = new Attributes();
                attributes2.putValue(m8689b, Base64.encodeToString(bArr2, 2));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    AbstractC1051b.m8830a(byteArrayOutputStream2, str, attributes2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream.write(byteArray);
                    treeMap.put(str, byteArray);
                } catch (IOException e3) {
                    throw new RuntimeException("Failed to write in-memory MANIFEST.MF", e3);
                }
            }
            a aVar = new a();
            aVar.f6582a = byteArrayOutputStream.toByteArray();
            aVar.f6584c = attributes;
            aVar.f6583b = treeMap;
            return aVar;
        } catch (IOException e4) {
            throw new RuntimeException("Failed to write in-memory MANIFEST.MF", e4);
        }
    }

    /* renamed from: c */
    private static void m8692c(String str) {
        for (char c2 : str.toCharArray()) {
            if (c2 == '\r' || c2 == '\n' || c2 == 0) {
                throw new C1037a(String.format("Unsupported character 0x%1$02x in ZIP entry name \"%2$s\"", Integer.valueOf(c2), str));
            }
        }
    }

    /* renamed from: a */
    private static byte[] m8687a(List<Integer> list, EnumC1043a enumC1043a, String str, a aVar) {
        Attributes mainAttributes = new Manifest().getMainAttributes();
        mainAttributes.put(Attributes.Name.SIGNATURE_VERSION, "1.0");
        mainAttributes.put(f6578b, str);
        if (!list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(intValue));
            }
            mainAttributes.put(f6581e, sb.toString());
        }
        MessageDigest m8694d = m8694d(enumC1043a);
        mainAttributes.putValue(m8691c(enumC1043a), Base64.encodeToString(m8694d.digest(aVar.f6582a), 2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AbstractC1052c.m8836a(byteArrayOutputStream, mainAttributes);
            String m8689b = m8689b(enumC1043a);
            for (Map.Entry<String, byte[]> entry : aVar.f6583b.entrySet()) {
                String key = entry.getKey();
                byte[] digest = m8694d.digest(entry.getValue());
                Attributes attributes = new Attributes();
                attributes.putValue(m8689b, Base64.encodeToString(digest, 2));
                try {
                    AbstractC1052c.m8835a(byteArrayOutputStream, key, attributes);
                } catch (IOException e2) {
                    throw new RuntimeException("Failed to write in-memory .SF file", e2);
                }
            }
            if (byteArrayOutputStream.size() > 0 && byteArrayOutputStream.size() % 1024 == 0) {
                try {
                    AbstractC1052c.m8834a(byteArrayOutputStream);
                } catch (IOException e3) {
                    throw new RuntimeException("Failed to write to ByteArrayOutputStream", e3);
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e4) {
            throw new RuntimeException("Failed to write in-memory .SF file", e4);
        }
    }

    /* renamed from: a */
    private static byte[] m8686a(b bVar, byte[] bArr) {
        List<X509Certificate> list = bVar.f6585a;
        X509Certificate x509Certificate = list.get(0);
        PublicKey publicKey = x509Certificate.getPublicKey();
        EnumC1043a enumC1043a = bVar.f6588d;
        C1059g<String, C1505e> m8680a = m8680a(publicKey, enumC1043a);
        String m8852a = m8680a.m8852a();
        try {
            Signature signature = Signature.getInstance(m8852a);
            signature.initSign(bVar.f6587c);
            signature.update(bArr);
            byte[] sign = signature.sign();
            try {
                Signature signature2 = Signature.getInstance(m8852a);
                signature2.initVerify(publicKey);
                signature2.update(bArr);
                if (!signature2.verify(sign)) {
                    throw new SignatureException("Signature did not verify");
                }
                try {
                    C1496bn c1496bn = new C1496bn(x509Certificate.getIssuerX500Principal().getName());
                    C1505e m8695e = m8695e(enumC1043a);
                    C1426d c1426d = new C1426d(new C1505e[]{m8695e}, new C1423a(C1423a.f9190a, (C1450m) null), (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), new C1431i[]{new C1431i(c1496bn, x509Certificate.getSerialNumber(), m8695e, m8680a.m8853b(), sign)});
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        c1426d.m11258a(byteArrayOutputStream);
                        return byteArrayOutputStream.toByteArray();
                    } catch (IOException e2) {
                        throw new SignatureException("Failed to encode PKCS#7 signed data", e2);
                    }
                } catch (IOException e3) {
                    throw new CertificateParsingException("Failed to parse signer certificate issuer name", e3);
                }
            } catch (InvalidKeyException e4) {
                throw new InvalidKeyException("Failed to verify generated " + m8852a + " signature using public key from certificate", e4);
            } catch (SignatureException e5) {
                throw new SignatureException("Failed to verify generated " + m8852a + " signature using public key from certificate", e5);
            }
        } catch (InvalidKeyException e6) {
            throw new InvalidKeyException("Failed to sign using " + m8852a, e6);
        } catch (SignatureException e7) {
            throw new SignatureException("Failed to sign using " + m8852a, e7);
        }
    }

    /* renamed from: e */
    private static C1505e m8695e(EnumC1043a enumC1043a) {
        switch (m8688a()[enumC1043a.ordinal()]) {
            case 1:
                return f6579c;
            case 2:
                return f6580d;
            default:
                throw new RuntimeException("Unsupported digest algorithm: " + enumC1043a);
        }
    }

    /* renamed from: a */
    private static C1059g<String, C1505e> m8680a(PublicKey publicKey, EnumC1043a enumC1043a) {
        String str;
        C1505e m8693d;
        String algorithm = publicKey.getAlgorithm();
        switch (m8688a()[enumC1043a.ordinal()]) {
            case 1:
                str = "SHA1";
                break;
            case 2:
                str = "SHA256";
                break;
            default:
                throw new IllegalArgumentException("Unexpected digest algorithm: " + enumC1043a);
        }
        if (KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm)) {
            return C1059g.m8851a(String.valueOf(str) + "withRSA", m8693d(C0632a.OID_SIG_RSA));
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            switch (m8688a()[enumC1043a.ordinal()]) {
                case 1:
                    m8693d = m8693d(C0632a.OID_SIG_DSA);
                    break;
                case 2:
                    m8693d = m8693d(C0632a.OID_SIG_SHA256_WITH_DSA);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected digest algorithm: " + enumC1043a);
            }
            return C1059g.m8851a(String.valueOf(str) + "withDSA", m8693d);
        }
        if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
            return C1059g.m8851a(String.valueOf(str) + "withECDSA", m8693d(C0632a.OID_SIG_EC_PUBLIC_KEY));
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    /* renamed from: d */
    private static C1505e m8693d(String str) {
        try {
            return C1505e.m11631a(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Unsupported OID: " + str, e2);
        }
    }

    /* renamed from: b */
    private static String m8689b(EnumC1043a enumC1043a) {
        switch (m8688a()[enumC1043a.ordinal()]) {
            case 1:
                return "SHA1-Digest";
            case 2:
                return "SHA-256-Digest";
            default:
                throw new IllegalArgumentException("Unexpected content digest algorithm: " + enumC1043a);
        }
    }

    /* renamed from: c */
    private static String m8691c(EnumC1043a enumC1043a) {
        switch (m8688a()[enumC1043a.ordinal()]) {
            case 1:
                return "SHA1-Digest-Manifest";
            case 2:
                return "SHA-256-Digest-Manifest";
            default:
                throw new IllegalArgumentException("Unexpected content digest algorithm: " + enumC1043a);
        }
    }
}
