package com.p065b.p066a.p068b.p069a.p072c;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: V2SchemeSigner.java */
/* renamed from: com.b.a.b.a.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0596a {
    public static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;

    private AbstractC0596a() {
    }

    /* renamed from: a */
    public static List<EnumC0609i> m5936a(PublicKey publicKey, int i, boolean z, boolean z2) {
        EnumC0609i enumC0609i;
        String algorithm = publicKey.getAlgorithm();
        if (KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm)) {
            if (((RSAKey) publicKey).getModulus().bitLength() <= 3072) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(EnumC0609i.RSA_PKCS1_V1_5_WITH_SHA256);
                if (z) {
                    arrayList.add(EnumC0609i.VERITY_RSA_PKCS1_V1_5_WITH_SHA256);
                    return arrayList;
                }
                return arrayList;
            }
            return Collections.singletonList(EnumC0609i.RSA_PKCS1_V1_5_WITH_SHA512);
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            ArrayList arrayList2 = new ArrayList();
            if (z2) {
                enumC0609i = EnumC0609i.DETDSA_WITH_SHA256;
            } else {
                enumC0609i = EnumC0609i.DSA_WITH_SHA256;
            }
            arrayList2.add(enumC0609i);
            if (z) {
                arrayList2.add(EnumC0609i.VERITY_DSA_WITH_SHA256);
            }
            return arrayList2;
        }
        if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
            if (((ECKey) publicKey).getParams().getOrder().bitLength() <= 256) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(EnumC0609i.ECDSA_WITH_SHA256);
                if (z) {
                    arrayList3.add(EnumC0609i.VERITY_ECDSA_WITH_SHA256);
                    return arrayList3;
                }
                return arrayList3;
            }
            return Collections.singletonList(EnumC0609i.ECDSA_WITH_SHA512);
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    /* renamed from: a */
    public static C0598d.h m5934a(InterfaceC0673e interfaceC0673e, InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3, List<C0598d.g> list, boolean z, List<byte[]> list2) {
        C0652k<List<C0598d.g>, Map<EnumC0607g, byte[]>> m5947a = C0598d.m5947a(interfaceC0673e, interfaceC0671c, interfaceC0671c2, interfaceC0671c3, list);
        return new C0598d.h(m5935a(m5947a.m6251a(), m5947a.m6252b(), z, list2), m5947a.m6252b());
    }

    /* renamed from: a */
    private static C0652k<byte[], Integer> m5935a(List<C0598d.g> list, Map<EnumC0607g, byte[]> map, boolean z, List<byte[]> list2) {
        ArrayList arrayList = new ArrayList(list.size());
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        Iterator<C0598d.g> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            try {
                arrayList.add(m5937a(it.next(), map, z));
            } catch (InvalidKeyException e2) {
                throw new InvalidKeyException("Signer #" + i + " failed", e2);
            } catch (SignatureException e3) {
                throw new SignatureException("Signer #" + i + " failed", e3);
            }
        }
        return C0652k.m6250a(C0598d.m5964a(new byte[][]{C0598d.m5960a(arrayList)}), Integer.valueOf(APK_SIGNATURE_SCHEME_V2_BLOCK_ID));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static byte[] m5937a(C0598d.g gVar, Map<EnumC0607g, byte[]> map, boolean z) {
        Object[] objArr = 0;
        if (gVar.f4149a.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        byte[] m5959a = C0598d.m5959a(gVar.f4149a.get(0).getPublicKey());
        a.C3328a c3328a = new a.C3328a();
        try {
            c3328a.f4054b = C0598d.m5972c(gVar.f4149a);
            ArrayList arrayList = new ArrayList(gVar.f4154f.size());
            for (EnumC0609i enumC0609i : gVar.f4154f) {
                EnumC0607g m6080a = enumC0609i.m6080a();
                byte[] bArr = map.get(m6080a);
                if (bArr == null) {
                    throw new RuntimeException(m6080a + " content digest for " + enumC0609i + " not computed");
                }
                arrayList.add(C0652k.m6250a(Integer.valueOf(enumC0609i.m6081b()), bArr));
            }
            c3328a.f4055c = arrayList;
            c3328a.f4053a = m5938a(z);
            a.b bVar = new a.b();
            bVar.f4058c = C0598d.m5964a(new byte[][]{C0598d.m5970b(c3328a.f4055c), C0598d.m5960a(c3328a.f4054b), c3328a.f4053a, new byte[0]});
            bVar.f4056a = m5959a;
            bVar.f4057b = new ArrayList();
            bVar.f4057b = C0598d.m5950a(gVar, bVar.f4058c);
            return C0598d.m5964a(new byte[][]{bVar.f4058c, C0598d.m5970b(bVar.f4057b), bVar.f4056a});
        } catch (CertificateEncodingException e2) {
            throw new SignatureException("Failed to encode certificates", e2);
        }
    }

    /* renamed from: a */
    private static byte[] m5938a(boolean z) {
        if (!z) {
            return new byte[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(8);
        allocate.putInt(-1091571699);
        allocate.putInt(3);
        return allocate.array();
    }

    /* compiled from: V2SchemeSigner.java */
    /* renamed from: com.b.a.b.a.c.a$a */
    private static final class a {

        /* compiled from: V2SchemeSigner.java */
        /* renamed from: com.b.a.b.a.c.a$a$b */
        private static final class b {

            /* renamed from: a */
            public byte[] f4056a;

            /* renamed from: b */
            public List<C0652k<Integer, byte[]>> f4057b;

            /* renamed from: c */
            public byte[] f4058c;

            private b() {
            }
        }

        private a() {
        }

        /* compiled from: V2SchemeSigner.java */
        /* renamed from: com.b.a.b.a.c.a$a$a, reason: collision with other inner class name */
        private static final class C3328a {

            /* renamed from: a */
            public byte[] f4053a;

            /* renamed from: b */
            public List<byte[]> f4054b;

            /* renamed from: c */
            public List<C0652k<Integer, byte[]>> f4055c;

            private C3328a() {
            }
        }
    }
}
