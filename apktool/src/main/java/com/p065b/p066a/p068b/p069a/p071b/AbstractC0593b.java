package com.p065b.p066a.p068b.p069a.p071b;

import android.security.keystore.KeyProperties;
import android.util.Base64;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p075b.C0621e;
import com.p065b.p066a.p068b.p078d.AbstractC0630b;
import com.p065b.p066a.p068b.p078d.AbstractC0631c;
import com.p065b.p066a.p068b.p079e.C0632a;
import com.p065b.p066a.p068b.p080f.C0633a;
import com.p065b.p066a.p068b.p081g.C0652k;
import java.nio.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
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

/* compiled from: V1SchemeSigner.java */
/* renamed from: com.b.a.b.a.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC0593b {
    private static final String ATTRIBUTE_VALUE_MANIFEST_VERSION = "1.0";
    private static final String ATTRIBUTE_VALUE_SIGNATURE_VERSION = "1.0";
    public static final String MANIFEST_ENTRY_NAME = "META-INF/MANIFEST.MF";
    private static final Attributes.Name ATTRIBUTE_NAME_CREATED_BY = new Attributes.Name("Created-By");
    private static final Attributes.Name SF_ATTRIBUTE_NAME_ANDROID_APK_SIGNED_NAME = new Attributes.Name("X-Android-APK-Signed");

    /* compiled from: V1SchemeSigner.java */
    /* renamed from: com.b.a.b.a.b.b$a */
    public static class a {

        /* renamed from: a */
        public byte[] f4018a;

        /* renamed from: b */
        public SortedMap<String, byte[]> f4019b;

        /* renamed from: c */
        public Attributes f4020c;
    }

    /* compiled from: V1SchemeSigner.java */
    /* renamed from: com.b.a.b.a.b.b$b */
    public static class b {

        /* renamed from: a */
        public List<X509Certificate> f4021a;

        /* renamed from: b */
        public boolean f4022b;

        /* renamed from: c */
        public String f4023c;

        /* renamed from: d */
        public PrivateKey f4024d;

        /* renamed from: e */
        public EnumC0592a f4025e;
    }

    private AbstractC0593b() {
    }

    /* renamed from: a */
    public static EnumC0592a m5861a(PublicKey publicKey, int i) {
        String algorithm = publicKey.getAlgorithm();
        if (!KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm) && !C0632a.OID_SIG_RSA.equals(algorithm)) {
            if ("DSA".equalsIgnoreCase(algorithm)) {
                if (i < 21) {
                    return EnumC0592a.SHA1;
                }
                return EnumC0592a.SHA256;
            }
            if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
                if (i < 18) {
                    throw new InvalidKeyException("ECDSA signatures only supported for minSdkVersion 18 and higher");
                }
                return EnumC0592a.SHA256;
            }
            throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
        }
        if (i < 18) {
            return EnumC0592a.SHA1;
        }
        return EnumC0592a.SHA256;
    }

    /* renamed from: a */
    public static String m5864a(String str) {
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
    private static MessageDigest m5874d(EnumC0592a enumC0592a) {
        return MessageDigest.getInstance(enumC0592a.m5859a());
    }

    /* renamed from: a */
    public static String m5863a(EnumC0592a enumC0592a) {
        return enumC0592a.m5859a();
    }

    /* renamed from: b */
    public static boolean m5871b(String str) {
        if (str.endsWith("/")) {
            return false;
        }
        if (str.startsWith("META-INF/") && str.indexOf(47, 9) == -1) {
            String lowerCase = str.substring(9).toLowerCase(Locale.f10688US);
            return ("manifest.mf".equals(lowerCase) || lowerCase.endsWith(".sf") || lowerCase.endsWith(".rsa") || lowerCase.endsWith(".dsa") || lowerCase.endsWith(".ec") || lowerCase.startsWith("sig-")) ? false : true;
        }
        return true;
    }

    /* renamed from: a */
    public static List<C0652k<String, byte[]>> m5866a(List<b> list, EnumC0592a enumC0592a, Map<String, byte[]> map, List<Integer> list2, byte[] bArr, String str) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        return m5865a(list, enumC0592a, list2, str, m5862a(enumC0592a, map, bArr));
    }

    /* renamed from: a */
    public static List<C0652k<String, byte[]>> m5865a(List<b> list, EnumC0592a enumC0592a, List<Integer> list2, String str, a aVar) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        ArrayList arrayList = new ArrayList((list.size() * 2) + 1);
        byte[] m5869a = m5869a(list2, enumC0592a, str, aVar);
        for (b bVar : list) {
            String str2 = bVar.f4023c;
            try {
                byte[] m5868a = m5868a(bVar, m5869a);
                arrayList.add(C0652k.m6250a("META-INF/" + str2 + ".SF", m5869a));
                arrayList.add(C0652k.m6250a("META-INF/" + str2 + "." + bVar.f4021a.get(0).getPublicKey().getAlgorithm().toUpperCase(Locale.f10688US), m5868a));
            } catch (InvalidKeyException e2) {
                throw new InvalidKeyException("Failed to sign using signer \"" + str2 + "\"", e2);
            } catch (SignatureException e3) {
                throw new SignatureException("Failed to sign using signer \"" + str2 + "\"", e3);
            } catch (CertificateException e4) {
                throw new CertificateException("Failed to sign using signer \"" + str2 + "\"", e4);
            }
        }
        arrayList.add(C0652k.m6250a("META-INF/MANIFEST.MF", aVar.f4018a));
        return arrayList;
    }

    /* renamed from: a */
    public static Set<String> m5867a(List<b> list) {
        HashSet hashSet = new HashSet((list.size() * 2) + 1);
        for (b bVar : list) {
            String str = bVar.f4023c;
            hashSet.add("META-INF/" + str + ".SF");
            hashSet.add("META-INF/" + str + "." + bVar.f4021a.get(0).getPublicKey().getAlgorithm().toUpperCase(Locale.f10688US));
        }
        hashSet.add("META-INF/MANIFEST.MF");
        return hashSet;
    }

    /* renamed from: a */
    public static a m5862a(EnumC0592a enumC0592a, Map<String, byte[]> map, byte[] bArr) {
        Manifest manifest;
        if (bArr != null) {
            try {
                manifest = new Manifest(new ByteArrayInputStream(bArr));
            } catch (IOException e2) {
                throw new C0579a("Malformed source META-INF/MANIFEST.MF", e2);
            }
        } else {
            manifest = null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Attributes attributes = new Attributes();
        if (manifest != null) {
            attributes.putAll(manifest.getMainAttributes());
        } else {
            attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        }
        try {
            AbstractC0630b.m6221a(byteArrayOutputStream, attributes);
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            TreeMap treeMap = new TreeMap();
            String m5870b = m5870b(enumC0592a);
            for (String str : arrayList) {
                m5873c(str);
                byte[] bArr2 = map.get(str);
                Attributes attributes2 = new Attributes();
                attributes2.putValue(m5870b, Base64.encodeToString(bArr2, 2));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    AbstractC0630b.m6218a(byteArrayOutputStream2, str, attributes2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream.write(byteArray);
                    treeMap.put(str, byteArray);
                } catch (IOException e3) {
                    throw new RuntimeException("Failed to write in-memory MANIFEST.MF", e3);
                }
            }
            a aVar = new a();
            aVar.f4018a = byteArrayOutputStream.toByteArray();
            aVar.f4020c = attributes;
            aVar.f4019b = treeMap;
            return aVar;
        } catch (IOException e4) {
            throw new RuntimeException("Failed to write in-memory MANIFEST.MF", e4);
        }
    }

    /* renamed from: c */
    private static void m5873c(String str) {
        for (char c2 : str.toCharArray()) {
            if (c2 == '\r' || c2 == '\n' || c2 == 0) {
                throw new C0579a(String.format("Unsupported character 0x%1$02x in ZIP entry name \"%2$s\"", Integer.valueOf(c2), str));
            }
        }
    }

    /* renamed from: a */
    private static byte[] m5869a(List<Integer> list, EnumC0592a enumC0592a, String str, a aVar) {
        Attributes mainAttributes = new Manifest().getMainAttributes();
        mainAttributes.put(Attributes.Name.SIGNATURE_VERSION, "1.0");
        mainAttributes.put(ATTRIBUTE_NAME_CREATED_BY, str);
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
            mainAttributes.put(SF_ATTRIBUTE_NAME_ANDROID_APK_SIGNED_NAME, sb.toString());
        }
        MessageDigest m5874d = m5874d(enumC0592a);
        mainAttributes.putValue(m5872c(enumC0592a), Base64.encodeToString(m5874d.digest(aVar.f4018a), 2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AbstractC0631c.m6224a(byteArrayOutputStream, mainAttributes);
            String m5870b = m5870b(enumC0592a);
            for (Map.Entry<String, byte[]> entry : aVar.f4019b.entrySet()) {
                String key = entry.getKey();
                byte[] digest = m5874d.digest(entry.getValue());
                Attributes attributes = new Attributes();
                attributes.putValue(m5870b, Base64.encodeToString(digest, 2));
                try {
                    AbstractC0631c.m6223a(byteArrayOutputStream, key, attributes);
                } catch (IOException e2) {
                    throw new RuntimeException("Failed to write in-memory .SF file", e2);
                }
            }
            if (byteArrayOutputStream.size() > 0 && byteArrayOutputStream.size() % 1024 == 0) {
                try {
                    AbstractC0631c.m6222a(byteArrayOutputStream);
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
    private static byte[] m5868a(b bVar, byte[] bArr) {
        List<X509Certificate> list = bVar.f4021a;
        PublicKey publicKey = list.get(0).getPublicKey();
        EnumC0592a enumC0592a = bVar.f4025e;
        C0652k<String, C0633a> m6229a = C0633a.m6229a(publicKey, enumC0592a, bVar.f4022b);
        String m6251a = m6229a.m6251a();
        try {
            Signature signature = Signature.getInstance(m6251a);
            signature.initSign(bVar.f4024d);
            signature.update(bArr);
            byte[] sign = signature.sign();
            try {
                Signature signature2 = Signature.getInstance(m6251a);
                signature2.initVerify(publicKey);
                signature2.update(bArr);
                if (!signature2.verify(sign)) {
                    throw new SignatureException("Signature did not verify");
                }
                try {
                    return C0598d.m5963a(sign, (ByteBuffer) null, list, C0633a.m6228a(enumC0592a), m6229a.m6252b());
                } catch (C0621e | CertificateEncodingException e2) {
                    throw new SignatureException("Failed to encode signature block");
                }
            } catch (InvalidKeyException e3) {
                throw new InvalidKeyException("Failed to verify generated " + m6251a + " signature using public key from certificate", e3);
            } catch (SignatureException e4) {
                throw new SignatureException("Failed to verify generated " + m6251a + " signature using public key from certificate", e4);
            }
        } catch (InvalidKeyException e5) {
            throw new InvalidKeyException("Failed to sign using " + m6251a, e5);
        } catch (SignatureException e6) {
            throw new SignatureException("Failed to sign using " + m6251a, e6);
        }
    }

    /* compiled from: V1SchemeSigner.java */
    /* renamed from: com.b.a.b.a.b.b$1, reason: invalid class name */
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

    /* renamed from: b */
    private static String m5870b(EnumC0592a enumC0592a) {
        int i = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a.ordinal()];
        if (i == 1) {
            return "SHA1-Digest";
        }
        if (i == 2) {
            return "SHA-256-Digest";
        }
        throw new IllegalArgumentException("Unexpected content digest algorithm: " + enumC0592a);
    }

    /* renamed from: c */
    private static String m5872c(EnumC0592a enumC0592a) {
        int i = AnonymousClass1.$SwitchMap$com$android$apksig$internal$apk$v1$DigestAlgorithm[enumC0592a.ordinal()];
        if (i == 1) {
            return "SHA1-Digest-Manifest";
        }
        if (i == 2) {
            return "SHA-256-Digest-Manifest";
        }
        throw new IllegalArgumentException("Unexpected content digest algorithm: " + enumC0592a);
    }
}
