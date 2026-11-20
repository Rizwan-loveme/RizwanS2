package com.p065b.p111c.p113b.p114a.p116b;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p068b.p069a.p072c.AbstractC0596a;
import com.p065b.p111c.p113b.p118c.C1057e;
import com.p065b.p111c.p113b.p118c.C1059g;
import com.p065b.p111c.p113b.p119d.AbstractC1065d;
import com.p065b.p111c.p120c.AbstractC1070d;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.IOException;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: V2SchemeSigner.java */
/* renamed from: com.b.c.b.a.b.c */
/* loaded from: classes.dex */
public abstract class AbstractC1048c {

    /* renamed from: a */
    private static final byte[] f6637a = {65, 80, 75, 32, 83, 105, 103, 32, 66, 108, 111, 99, 107, 32, 52, 50};

    /* compiled from: V2SchemeSigner.java */
    /* renamed from: com.b.c.b.a.b.c$a */
    public static class a {

        /* renamed from: a */
        public List<X509Certificate> f6638a;

        /* renamed from: b */
        public PrivateKey f6639b;

        /* renamed from: c */
        public List<EnumC1047b> f6640c;
    }

    /* renamed from: a */
    public static List<EnumC1047b> m8761a(PublicKey publicKey, int i) {
        String algorithm = publicKey.getAlgorithm();
        if (KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm)) {
            if (((RSAKey) publicKey).getModulus().bitLength() <= 3072) {
                return Collections.singletonList(EnumC1047b.RSA_PKCS1_V1_5_WITH_SHA256);
            }
            return Collections.singletonList(EnumC1047b.RSA_PKCS1_V1_5_WITH_SHA512);
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            return Collections.singletonList(EnumC1047b.DSA_WITH_SHA256);
        }
        if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
            if (((ECKey) publicKey).getParams().getOrder().bitLength() <= 256) {
                return Collections.singletonList(EnumC1047b.ECDSA_WITH_SHA256);
            }
            return Collections.singletonList(EnumC1047b.ECDSA_WITH_SHA512);
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    /* renamed from: a */
    public static byte[] m8765a(InterfaceC1069c interfaceC1069c, InterfaceC1069c interfaceC1069c2, InterfaceC1069c interfaceC1069c3, List<a> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No signer configs provided. At least one is required");
        }
        HashSet hashSet = new HashSet(1);
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            Iterator<EnumC1047b> it2 = it.next().f6640c.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().m8756a());
            }
        }
        long mo8840a = interfaceC1069c.mo8840a();
        ByteBuffer allocate = ByteBuffer.allocate((int) interfaceC1069c3.mo8840a());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        interfaceC1069c3.mo8843a(0L, (int) interfaceC1069c3.mo8840a(), allocate);
        allocate.flip();
        AbstractC1065d.m8902b(allocate, mo8840a);
        try {
            return m8772b(list, m8762a(hashSet, new InterfaceC1069c[]{interfaceC1069c, interfaceC1069c2, AbstractC1070d.m8927a(allocate)}));
        } catch (IOException e2) {
            throw new IOException("Failed to read APK being signed", e2);
        } catch (DigestException e3) {
            throw new SignatureException("Failed to compute digests of APK", e3);
        }
    }

    /* renamed from: a */
    static Map<EnumC1046a, byte[]> m8762a(Set<EnumC1046a> set, InterfaceC1069c[] interfaceC1069cArr) {
        int i;
        long j = 0;
        for (InterfaceC1069c interfaceC1069c : interfaceC1069cArr) {
            j += m8760a(interfaceC1069c.mo8840a(), 1048576);
        }
        if (j > 2147483647L) {
            throw new DigestException("Input too long: " + j + " chunks");
        }
        int i2 = (int) j;
        EnumC1046a[] enumC1046aArr = (EnumC1046a[]) set.toArray(new EnumC1046a[set.size()]);
        MessageDigest[] messageDigestArr = new MessageDigest[enumC1046aArr.length];
        byte[][] bArr = new byte[enumC1046aArr.length][];
        int[] iArr = new int[enumC1046aArr.length];
        for (int i3 = 0; i3 < enumC1046aArr.length; i3++) {
            EnumC1046a enumC1046a = enumC1046aArr[i3];
            int m8753a = enumC1046a.m8753a();
            iArr[i3] = m8753a;
            byte[] bArr2 = new byte[(m8753a * i2) + 5];
            bArr2[0] = 90;
            m8763a(i2, bArr2, 1);
            bArr[i3] = bArr2;
            messageDigestArr[i3] = MessageDigest.getInstance(enumC1046a.m8754b());
        }
        C1057e c1057e = new C1057e(messageDigestArr);
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int i4 = 0;
        int length = interfaceC1069cArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < length) {
                InterfaceC1069c interfaceC1069c2 = interfaceC1069cArr[i6];
                long j2 = 0;
                long mo8840a = interfaceC1069c2.mo8840a();
                while (true) {
                    i = i4;
                    if (mo8840a <= 0) {
                        break;
                    }
                    int min = (int) Math.min(mo8840a, 1048576L);
                    m8763a(min, bArr3, 1);
                    for (MessageDigest messageDigest : messageDigestArr) {
                        messageDigest.update(bArr3);
                    }
                    try {
                        interfaceC1069c2.mo8844a(j2, min, c1057e);
                        for (int i7 = 0; i7 < enumC1046aArr.length; i7++) {
                            MessageDigest messageDigest2 = messageDigestArr[i7];
                            byte[] bArr4 = bArr[i7];
                            int i8 = iArr[i7];
                            int digest = messageDigest2.digest(bArr4, (i * i8) + 5, i8);
                            if (digest != i8) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest2.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        j2 += min;
                        mo8840a -= min;
                        i4 = i + 1;
                    } catch (IOException e2) {
                        throw new IOException("Failed to read chunk #" + i, e2);
                    }
                }
            } else {
                HashMap hashMap = new HashMap(enumC1046aArr.length);
                for (int i9 = 0; i9 < enumC1046aArr.length; i9++) {
                    hashMap.put(enumC1046aArr[i9], messageDigestArr[i9].digest(bArr[i9]));
                }
                return hashMap;
            }
            i5 = i6 + 1;
            i4 = i;
        }
    }

    /* renamed from: a */
    private static final long m8760a(long j, int i) {
        return ((i + j) - 1) / i;
    }

    /* renamed from: a */
    private static void m8763a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    /* renamed from: b */
    private static byte[] m8772b(List<a> list, Map<EnumC1046a, byte[]> map) {
        return m8769a(m8768a(list, map));
    }

    /* renamed from: a */
    private static byte[] m8769a(byte[] bArr) {
        int length = bArr.length + 20 + 8 + 16;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long j = length - 8;
        allocate.putLong(j);
        allocate.putLong(bArr.length + 4);
        allocate.putInt(AbstractC0596a.APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
        allocate.put(bArr);
        allocate.putLong(j);
        allocate.put(f6637a);
        return allocate.array();
    }

    /* renamed from: a */
    private static byte[] m8768a(List<a> list, Map<EnumC1046a, byte[]> map) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<a> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            try {
                arrayList.add(m8764a(it.next(), map));
            } catch (InvalidKeyException e2) {
                throw new InvalidKeyException("Signer #" + i + " failed", e2);
            } catch (SignatureException e3) {
                throw new SignatureException("Signer #" + i + " failed", e3);
            }
        }
        return m8770a(new byte[][]{m8767a(arrayList)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static byte[] m8764a(a aVar, Map<EnumC1046a, byte[]> map) {
        b bVar = null;
        Object[] objArr = 0;
        if (aVar.f6638a.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        PublicKey publicKey = aVar.f6638a.get(0).getPublicKey();
        byte[] m8766a = m8766a(publicKey);
        b bVar2 = new b(bVar);
        try {
            bVar2.f6641a = m8773c(aVar.f6638a);
            ArrayList arrayList = new ArrayList(aVar.f6640c.size());
            for (EnumC1047b enumC1047b : aVar.f6640c) {
                EnumC1046a m8756a = enumC1047b.m8756a();
                byte[] bArr = map.get(m8756a);
                if (bArr == null) {
                    throw new RuntimeException(m8756a + " content digest for " + enumC1047b + " not computed");
                }
                arrayList.add(C1059g.m8851a(Integer.valueOf(enumC1047b.m8757b()), bArr));
            }
            bVar2.f6642b = arrayList;
            c cVar = new c(objArr == true ? 1 : 0);
            cVar.f6645c = m8770a(new byte[][]{m8771b(bVar2.f6642b), m8767a(bVar2.f6641a), new byte[0]});
            cVar.f6643a = m8766a;
            cVar.f6644b = new ArrayList(aVar.f6640c.size());
            for (EnumC1047b enumC1047b2 : aVar.f6640c) {
                C1059g<String, ? extends AlgorithmParameterSpec> m8759d = enumC1047b2.m8759d();
                String m8852a = m8759d.m8852a();
                AlgorithmParameterSpec m8853b = m8759d.m8853b();
                try {
                    Signature signature = Signature.getInstance(m8852a);
                    signature.initSign(aVar.f6639b);
                    if (m8853b != null) {
                        signature.setParameter(m8853b);
                    }
                    signature.update(cVar.f6645c);
                    byte[] sign = signature.sign();
                    try {
                        Signature signature2 = Signature.getInstance(m8852a);
                        signature2.initVerify(publicKey);
                        if (m8853b != null) {
                            signature2.setParameter(m8853b);
                        }
                        signature2.update(cVar.f6645c);
                        if (!signature2.verify(sign)) {
                            throw new SignatureException("Signature did not verify");
                        }
                        cVar.f6644b.add(C1059g.m8851a(Integer.valueOf(enumC1047b2.m8757b()), sign));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new SignatureException("Failed to verify generated " + m8852a + " signature using public key from certificate", e);
                    } catch (InvalidKeyException e3) {
                        throw new InvalidKeyException("Failed to verify generated " + m8852a + " signature using public key from certificate", e3);
                    } catch (SignatureException e4) {
                        e = e4;
                        throw new SignatureException("Failed to verify generated " + m8852a + " signature using public key from certificate", e);
                    }
                } catch (InvalidAlgorithmParameterException e5) {
                    e = e5;
                    throw new SignatureException("Failed to sign using " + m8852a, e);
                } catch (InvalidKeyException e6) {
                    throw new InvalidKeyException("Failed to sign using " + m8852a, e6);
                } catch (SignatureException e7) {
                    e = e7;
                    throw new SignatureException("Failed to sign using " + m8852a, e);
                }
            }
            return m8770a(new byte[][]{cVar.f6645c, m8771b(cVar.f6644b), cVar.f6643a});
        } catch (CertificateEncodingException e8) {
            throw new SignatureException("Failed to encode certificates", e8);
        }
    }

    /* compiled from: V2SchemeSigner.java */
    /* renamed from: com.b.c.b.a.b.c$c */
    private static final class c {

        /* renamed from: a */
        public byte[] f6643a;

        /* renamed from: b */
        public List<C1059g<Integer, byte[]>> f6644b;

        /* renamed from: c */
        public byte[] f6645c;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    /* compiled from: V2SchemeSigner.java */
    /* renamed from: com.b.c.b.a.b.c$b */
    private static final class b {

        /* renamed from: a */
        public List<byte[]> f6641a;

        /* renamed from: b */
        public List<C1059g<Integer, byte[]>> f6642b;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }

    /* renamed from: a */
    private static byte[] m8766a(PublicKey publicKey) {
        byte[] bArr = null;
        if ("X.509".equals(publicKey.getFormat())) {
            bArr = publicKey.getEncoded();
        }
        if (bArr == null) {
            try {
                bArr = ((X509EncodedKeySpec) KeyFactory.getInstance(publicKey.getAlgorithm()).getKeySpec(publicKey, X509EncodedKeySpec.class)).getEncoded();
            } catch (InvalidKeySpecException e2) {
                throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName(), e2);
            }
        }
        if (bArr == null || bArr.length == 0) {
            throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName());
        }
        return bArr;
    }

    /* renamed from: c */
    private static List<byte[]> m8773c(List<X509Certificate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<X509Certificate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getEncoded());
        }
        return arrayList;
    }

    /* renamed from: a */
    private static byte[] m8767a(List<byte[]> list) {
        return m8770a((byte[][]) list.toArray(new byte[list.size()][]));
    }

    /* renamed from: a */
    private static byte[] m8770a(byte[][] bArr) {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            i += bArr2.length + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (byte[] bArr3 : bArr) {
            allocate.putInt(bArr3.length);
            allocate.put(bArr3);
        }
        return allocate.array();
    }

    /* renamed from: b */
    private static byte[] m8771b(List<C1059g<Integer, byte[]>> list) {
        int i;
        Iterator<C1059g<Integer, byte[]>> it = list.iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            i2 = it.next().m8853b().length + 12 + i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (C1059g<Integer, byte[]> c1059g : list) {
            byte[] m8853b = c1059g.m8853b();
            allocate.putInt(m8853b.length + 8);
            allocate.putInt(c1059g.m8852a().intValue());
            allocate.putInt(m8853b.length);
            allocate.put(m8853b);
        }
        return allocate.array();
    }
}
