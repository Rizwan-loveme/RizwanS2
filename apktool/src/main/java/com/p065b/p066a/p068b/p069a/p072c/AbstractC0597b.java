package com.p065b.p066a.p068b.p069a.p072c;

import com.p065b.p066a.C0675d;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.C0610j;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p081g.C0644c;
import com.p065b.p066a.p068b.p081g.C0648g;
import com.p065b.p066a.p068b.p081g.C0656o;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: V2SchemeVerifier.java */
/* renamed from: com.b.a.b.a.c.b */
/* loaded from: classes.dex */
public abstract class AbstractC0597b {
    private AbstractC0597b() {
    }

    /* renamed from: a */
    public static C0598d.e m5939a(InterfaceC0673e interfaceC0673e, InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar, Map<Integer, String> map, Set<Integer> set, int i, int i2) {
        C0598d.e eVar = new C0598d.e(2);
        C0610j m5945a = C0598d.m5945a(interfaceC0671c, cVar, AbstractC0596a.APK_SIGNATURE_SCHEME_V2_BLOCK_ID, eVar);
        m5940a(interfaceC0673e, interfaceC0671c.mo6238b(0L, m5945a.f4192a), m5945a.f4196e, interfaceC0671c.mo6238b(m5945a.f4193b, m5945a.f4195d - m5945a.f4193b), m5945a.f4194c, map, set, i, i2, eVar);
        return eVar;
    }

    /* renamed from: a */
    private static void m5940a(InterfaceC0673e interfaceC0673e, InterfaceC0671c interfaceC0671c, ByteBuffer byteBuffer, InterfaceC0671c interfaceC0671c2, ByteBuffer byteBuffer2, Map<Integer, String> map, Set<Integer> set, int i, int i2, C0598d.e eVar) {
        HashSet hashSet = new HashSet(1);
        m5942a(byteBuffer, hashSet, map, set, i, i2, eVar);
        if (!eVar.mo5855a()) {
            C0598d.m5956a(interfaceC0673e, interfaceC0671c, interfaceC0671c2, byteBuffer2, hashSet, eVar);
            if (!eVar.mo5855a()) {
                eVar.f4014c = true;
            }
        }
    }

    /* renamed from: a */
    public static void m5942a(ByteBuffer byteBuffer, Set<EnumC0607g> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2, C0598d.e eVar) {
        try {
            ByteBuffer m5966b = C0598d.m5966b(byteBuffer);
            if (!m5966b.hasRemaining()) {
                eVar.m6018a(C0675d.d.V2_SIG_NO_SIGNERS, new Object[0]);
                return;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (m5966b.hasRemaining()) {
                        C0598d.e.a aVar = new C0598d.e.a();
                        aVar.f4049c = i4;
                        eVar.f4128d.add(aVar);
                        try {
                            m5941a(C0598d.m5966b(m5966b), certificateFactory, aVar, set, map, set2, i, i2);
                            i3 = i4 + 1;
                        } catch (C0579a | BufferUnderflowException e2) {
                            aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_SIGNER, new Object[0]);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } catch (CertificateException e3) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
            }
        } catch (C0579a e4) {
            eVar.m6018a(C0675d.d.V2_SIG_MALFORMED_SIGNERS, new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m5941a(ByteBuffer byteBuffer, CertificateFactory certificateFactory, C0598d.e.a aVar, Set<EnumC0607g> set, Map<Integer, String> map, Set<Integer> set2, int i, int i2) {
        byte[] encoded;
        ByteBuffer m5966b = C0598d.m5966b(byteBuffer);
        byte[] bArr = new byte[m5966b.remaining()];
        m5966b.get(bArr);
        m5966b.flip();
        aVar.f4137j = bArr;
        ByteBuffer m5966b2 = C0598d.m5966b(byteBuffer);
        byte[] m5973c = C0598d.m5973c(byteBuffer);
        ArrayList arrayList = new ArrayList(1);
        int i3 = 0;
        while (m5966b2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer m5966b3 = C0598d.m5966b(m5966b2);
                int i4 = m5966b3.getInt();
                byte[] m5973c2 = C0598d.m5973c(m5966b3);
                aVar.f4136i.add(new C0598d.e.a.c(i4, m5973c2));
                EnumC0609i m6078a = EnumC0609i.m6078a(i4);
                if (m6078a == null) {
                    aVar.m6021b(C0675d.d.V2_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i4));
                } else {
                    arrayList.add(new C0598d.i(m6078a, m5973c2));
                }
            } catch (C0579a | BufferUnderflowException e2) {
                aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_SIGNATURE, Integer.valueOf(i3));
                return;
            }
        }
        if (aVar.f4136i.isEmpty()) {
            aVar.m6020a(C0675d.d.V2_SIG_NO_SIGNATURES, new Object[0]);
            return;
        }
        try {
            for (C0598d.i iVar : C0598d.m5951a(arrayList, i, i2)) {
                EnumC0609i enumC0609i = iVar.f4181a;
                String m6251a = enumC0609i.m6084e().m6251a();
                AlgorithmParameterSpec m6252b = enumC0609i.m6084e().m6252b();
                try {
                    PublicKey generatePublic = KeyFactory.getInstance(enumC0609i.m6082c()).generatePublic(new X509EncodedKeySpec(m5973c));
                    try {
                        Signature signature = Signature.getInstance(m6251a);
                        signature.initVerify(generatePublic);
                        if (m6252b != null) {
                            signature.setParameter(m6252b);
                        }
                        m5966b.position(0);
                        signature.update(m5966b);
                        byte[] bArr2 = iVar.f4182b;
                        if (!signature.verify(bArr2)) {
                            aVar.m6020a(C0675d.d.V2_SIG_DID_NOT_VERIFY, enumC0609i);
                            return;
                        } else {
                            aVar.f4140m.put(enumC0609i, bArr2);
                            set.add(enumC0609i.m6080a());
                        }
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | SignatureException e3) {
                        aVar.m6020a(C0675d.d.V2_SIG_VERIFY_EXCEPTION, enumC0609i, e3);
                        return;
                    }
                } catch (Exception e4) {
                    aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_PUBLIC_KEY, e4);
                    return;
                }
            }
            m5966b.position(0);
            ByteBuffer m5966b4 = C0598d.m5966b(m5966b);
            ByteBuffer m5966b5 = C0598d.m5966b(m5966b);
            ByteBuffer m5966b6 = C0598d.m5966b(m5966b);
            int i5 = -1;
            while (m5966b5.hasRemaining()) {
                i5++;
                byte[] m5973c3 = C0598d.m5973c(m5966b5);
                try {
                    aVar.f4048b.add(new C0648g(C0656o.m6270a(m5973c3, certificateFactory), m5973c3));
                } catch (CertificateException e5) {
                    aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_CERTIFICATE, Integer.valueOf(i5), Integer.valueOf(i5 + 1), e5);
                    return;
                }
            }
            if (aVar.f4048b.isEmpty()) {
                aVar.m6020a(C0675d.d.V2_SIG_NO_CERTIFICATES, new Object[0]);
                return;
            }
            X509Certificate x509Certificate = aVar.f4048b.get(0);
            try {
                encoded = C0598d.m5959a(x509Certificate.getPublicKey());
            } catch (InvalidKeyException e6) {
                System.out.println("Caught an exception encoding the public key: " + e6);
                e6.printStackTrace();
                encoded = x509Certificate.getPublicKey().getEncoded();
            }
            if (!Arrays.equals(m5973c, encoded)) {
                aVar.m6020a(C0675d.d.V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, C0598d.m5971c(encoded), C0598d.m5971c(m5973c));
                return;
            }
            int i6 = 0;
            while (m5966b4.hasRemaining()) {
                i6++;
                try {
                    ByteBuffer m5966b7 = C0598d.m5966b(m5966b4);
                    aVar.f4133f.add(new C0598d.e.a.b(m5966b7.getInt(), C0598d.m5973c(m5966b7)));
                } catch (C0579a | BufferUnderflowException e7) {
                    aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_DIGEST, Integer.valueOf(i6));
                    return;
                }
            }
            ArrayList arrayList2 = new ArrayList(aVar.f4136i.size());
            Iterator<C0598d.e.a.c> it = aVar.f4136i.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(it.next().m6025a()));
            }
            ArrayList arrayList3 = new ArrayList(aVar.f4133f.size());
            Iterator<C0598d.e.a.b> it2 = aVar.f4133f.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(it2.next().m6023a()));
            }
            if (!arrayList2.equals(arrayList3)) {
                aVar.m6020a(C0675d.d.V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, arrayList2, arrayList3);
                return;
            }
            Set<Integer> keySet = map.keySet();
            HashSet hashSet = new HashSet(1);
            int i7 = 0;
            while (m5966b6.hasRemaining()) {
                i7++;
                try {
                    ByteBuffer m5966b8 = C0598d.m5966b(m5966b6);
                    int i8 = m5966b8.getInt();
                    byte[] m6241a = C0644c.m6241a(m5966b8);
                    aVar.f4132e.add(new C0598d.e.a.C3330a(i8, m6241a));
                    if (i8 == -1091571699) {
                        int i9 = ByteBuffer.wrap(m6241a).order(ByteOrder.LITTLE_ENDIAN).getInt();
                        if (keySet.contains(Integer.valueOf(i9))) {
                            hashSet.add(Integer.valueOf(i9));
                        } else {
                            aVar.m6021b(C0675d.d.V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID, Integer.valueOf(aVar.f4049c), Integer.valueOf(i9));
                        }
                    } else {
                        aVar.m6021b(C0675d.d.V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i8));
                    }
                } catch (C0579a e8) {
                    aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i7));
                    return;
                } catch (BufferUnderflowException e9) {
                    aVar.m6020a(C0675d.d.V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i7));
                    return;
                }
            }
            Iterator<E> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                int intValue = ((Integer) it3.next()).intValue();
                if (!set2.contains(Integer.valueOf(intValue))) {
                    aVar.m6020a(C0675d.d.V2_SIG_MISSING_APK_SIG_REFERENCED, Integer.valueOf(aVar.f4049c), (String) map.get(Integer.valueOf(intValue)));
                }
            }
        } catch (C0598d.d e10) {
            aVar.m6020a(C0675d.d.V2_SIG_NO_SUPPORTED_SIGNATURES, e10);
        }
    }
}
