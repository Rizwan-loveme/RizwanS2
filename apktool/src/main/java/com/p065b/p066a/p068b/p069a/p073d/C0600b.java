package com.p065b.p066a.p068b.p069a.p073d;

import com.p065b.p066a.C0675d;
import com.p065b.p066a.C0680g;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.C0610j;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p077c.C0628b;
import com.p065b.p066a.p068b.p081g.C0644c;
import com.p065b.p066a.p068b.p081g.C0648g;
import com.p065b.p066a.p068b.p081g.C0656o;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.IOException;
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
import java.util.Set;
import java.util.TreeMap;

/* compiled from: V3SchemeVerifier.java */
/* renamed from: com.b.a.b.a.d.b */
/* loaded from: classes.dex */
public class C0600b {

    /* renamed from: a */
    private final InterfaceC0671c f4091a;

    /* renamed from: b */
    private ByteBuffer f4092b;

    /* renamed from: c */
    private final int f4093c;

    /* renamed from: d */
    private final Set<EnumC0607g> f4094d;

    /* renamed from: e */
    private final InterfaceC0673e f4095e;

    /* renamed from: f */
    private final boolean f4096f;

    /* renamed from: g */
    private final int f4097g;

    /* renamed from: h */
    private final int f4098h;

    /* renamed from: i */
    private final C0628b f4099i;

    /* renamed from: j */
    private final C0598d.e f4100j;

    /* renamed from: k */
    private final AbstractC0581c.c f4101k;

    private C0600b(InterfaceC0673e interfaceC0673e, InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar, Set<EnumC0607g> set, C0598d.e eVar, int i, int i2, int i3, C0628b c0628b, boolean z) {
        this.f4095e = interfaceC0673e;
        this.f4091a = interfaceC0671c;
        this.f4101k = cVar;
        this.f4094d = set;
        this.f4100j = eVar;
        this.f4098h = i;
        this.f4097g = i2;
        this.f4093c = i3;
        this.f4099i = c0628b;
        this.f4096f = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00be, code lost:
    
        if (r4 < (r13.f4099i.m6195c() ? r13.f4099i.m6194b() - 1 : r13.f4097g)) goto L30;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0598d.e m5995b() {
        AbstractC0581c.c cVar;
        int i;
        InterfaceC0671c interfaceC0671c = this.f4091a;
        if (interfaceC0671c == null || (cVar = this.f4101k) == null) {
            throw new IllegalStateException("A non-null apk and zip sections must be specified to verify an APK's v3 signatures");
        }
        C0610j m5945a = C0598d.m5945a(interfaceC0671c, cVar, this.f4093c, this.f4100j);
        this.f4092b = m5945a.f4196e;
        InterfaceC0671c mo6238b = this.f4091a.mo6238b(0L, m5945a.f4192a);
        InterfaceC0671c mo6238b2 = this.f4091a.mo6238b(m5945a.f4193b, m5945a.f4195d - m5945a.f4193b);
        ByteBuffer byteBuffer = m5945a.f4194c;
        m5994a();
        if (this.f4100j.mo5855a()) {
            return this.f4100j;
        }
        C0598d.m5956a(this.f4095e, mo6238b, mo6238b2, byteBuffer, this.f4094d, this.f4100j);
        TreeMap treeMap = new TreeMap();
        for (C0598d.e.a aVar : this.f4100j.f4128d) {
            treeMap.put(Integer.valueOf(aVar.f4135h), aVar);
        }
        ArrayList arrayList = new ArrayList(this.f4100j.f4128d.size());
        Iterator it = treeMap.values().iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0598d.e.a aVar2 = (C0598d.e.a) it.next();
            int i5 = aVar2.f4135h;
            int i6 = aVar2.f4134g;
            if (i4 != 0) {
                if (i5 != i3 + 1) {
                    this.f4100j.m6018a(C0675d.d.V3_INCONSISTENT_SDK_VERSIONS, new Object[0]);
                    break;
                }
                i5 = i4;
            }
            if (aVar2.f4138k != null) {
                int m6492b = aVar2.f4138k.m6492b();
                if (m6492b < i2) {
                    this.f4100j.m6018a(C0675d.d.V3_INCONSISTENT_LINEAGES, new Object[0]);
                    i3 = i6;
                    i4 = i5;
                    break;
                }
                arrayList.add(aVar2.f4138k);
                i = m6492b;
            } else {
                i = i2;
            }
            i2 = i;
            i3 = i6;
            i4 = i5;
        }
        if (i4 <= this.f4098h) {
        }
        this.f4100j.m6018a(C0675d.d.V3_MISSING_SDK_VERSIONS, Integer.valueOf(i4), Integer.valueOf(i3));
        try {
            this.f4100j.f4129e = C0680g.m6487a(arrayList);
        } catch (IllegalArgumentException e2) {
            this.f4100j.m6018a(C0675d.d.V3_INCONSISTENT_LINEAGES, new Object[0]);
        }
        if (!this.f4100j.mo5855a()) {
            this.f4100j.f4014c = true;
        }
        return this.f4100j;
    }

    /* renamed from: a */
    public static void m5993a(ByteBuffer byteBuffer, Set<EnumC0607g> set, C0598d.e eVar) {
        try {
            new a(byteBuffer).m6004a(eVar).m6006a(set).m6007a(false).m6008a().m5994a();
        } catch (C0598d.f | IOException e2) {
            throw new IllegalStateException("An exception was encountered when attempting to parse the signers from the provided APK Signature Scheme v3 block", e2);
        }
    }

    /* renamed from: a */
    public C0598d.e m5994a() {
        try {
            if (this.f4092b == null) {
                this.f4092b = C0598d.m5945a(this.f4091a, this.f4101k, this.f4093c, this.f4100j).f4196e;
            }
            ByteBuffer m5966b = C0598d.m5966b(this.f4092b);
            if (!m5966b.hasRemaining()) {
                this.f4100j.m6018a(C0675d.d.V3_SIG_NO_SIGNERS, new Object[0]);
                return this.f4100j;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                int i = 0;
                while (m5966b.hasRemaining()) {
                    C0598d.e.a aVar = new C0598d.e.a();
                    aVar.f4049c = i;
                    this.f4100j.f4128d.add(aVar);
                    try {
                        m5992a(C0598d.m5966b(m5966b), certificateFactory, aVar);
                        i++;
                    } catch (C0579a | BufferUnderflowException e2) {
                        aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_SIGNER, new Object[0]);
                        return this.f4100j;
                    }
                }
                return this.f4100j;
            } catch (CertificateException e3) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
            }
        } catch (C0579a e4) {
            this.f4100j.m6018a(C0675d.d.V3_SIG_MALFORMED_SIGNERS, new Object[0]);
            return this.f4100j;
        }
    }

    /* renamed from: a */
    private void m5992a(ByteBuffer byteBuffer, CertificateFactory certificateFactory, C0598d.e.a aVar) {
        byte[] encoded;
        ByteBuffer m5966b = C0598d.m5966b(byteBuffer);
        byte[] bArr = new byte[m5966b.remaining()];
        m5966b.get(bArr);
        m5966b.flip();
        aVar.f4137j = bArr;
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        aVar.f4135h = i;
        aVar.f4134g = i2;
        if (i < 0 || i > i2) {
            aVar.m6020a(C0675d.d.V3_SIG_INVALID_SDK_VERSIONS, Integer.valueOf(i), Integer.valueOf(i2));
        }
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
                    aVar.m6021b(C0675d.d.V3_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i4));
                } else {
                    arrayList.add(new C0598d.i(m6078a, m5973c2));
                }
            } catch (C0579a | BufferUnderflowException e2) {
                aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_SIGNATURE, Integer.valueOf(i3));
                return;
            }
        }
        if (aVar.f4136i.isEmpty()) {
            aVar.m6020a(C0675d.d.V3_SIG_NO_SIGNATURES, new Object[0]);
            return;
        }
        try {
            for (C0598d.i iVar : C0598d.m5951a(arrayList, aVar.f4135h, aVar.f4134g)) {
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
                            aVar.m6020a(C0675d.d.V3_SIG_DID_NOT_VERIFY, enumC0609i);
                            return;
                        } else {
                            aVar.f4140m.put(enumC0609i, bArr2);
                            this.f4094d.add(enumC0609i.m6080a());
                        }
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException | SignatureException e3) {
                        aVar.m6020a(C0675d.d.V3_SIG_VERIFY_EXCEPTION, enumC0609i, e3);
                        return;
                    }
                } catch (Exception e4) {
                    aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_PUBLIC_KEY, e4);
                    return;
                }
            }
            m5966b.position(0);
            ByteBuffer m5966b4 = C0598d.m5966b(m5966b);
            ByteBuffer m5966b5 = C0598d.m5966b(m5966b);
            int i5 = m5966b.getInt();
            if (i5 != i) {
                aVar.m6020a(C0675d.d.V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD, Integer.valueOf(i), Integer.valueOf(i5));
            }
            int i6 = m5966b.getInt();
            if (i6 != i2) {
                aVar.m6020a(C0675d.d.V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD, Integer.valueOf(i2), Integer.valueOf(i6));
            }
            ByteBuffer m5966b6 = C0598d.m5966b(m5966b);
            int i7 = -1;
            while (m5966b5.hasRemaining()) {
                i7++;
                byte[] m5973c3 = C0598d.m5973c(m5966b5);
                try {
                    aVar.f4048b.add(new C0648g(C0656o.m6270a(m5973c3, certificateFactory), m5973c3));
                } catch (CertificateException e5) {
                    aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_CERTIFICATE, Integer.valueOf(i7), Integer.valueOf(i7 + 1), e5);
                    return;
                }
            }
            if (aVar.f4048b.isEmpty()) {
                aVar.m6020a(C0675d.d.V3_SIG_NO_CERTIFICATES, new Object[0]);
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
                aVar.m6020a(C0675d.d.V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, C0598d.m5971c(encoded), C0598d.m5971c(m5973c));
                return;
            }
            int i8 = 0;
            while (m5966b4.hasRemaining()) {
                i8++;
                try {
                    ByteBuffer m5966b7 = C0598d.m5966b(m5966b4);
                    aVar.f4133f.add(new C0598d.e.a.b(m5966b7.getInt(), C0598d.m5973c(m5966b7)));
                } catch (C0579a | BufferUnderflowException e7) {
                    aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_DIGEST, Integer.valueOf(i8));
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
                aVar.m6020a(C0675d.d.V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, arrayList2, arrayList3);
                return;
            }
            int i9 = 0;
            boolean z = false;
            while (m5966b6.hasRemaining()) {
                i9++;
                try {
                    ByteBuffer m5966b8 = C0598d.m5966b(m5966b6);
                    int i10 = m5966b8.getInt();
                    byte[] m6241a = C0644c.m6241a(m5966b8);
                    aVar.f4132e.add(new C0598d.e.a.C3330a(i10, m6241a));
                    if (i10 == 1000370060) {
                        try {
                            aVar.f4138k = C0680g.m6488a(m6241a);
                            if (aVar.f4138k.m6492b() != aVar.f4138k.m6490a(aVar.f4048b.get(0)).m6492b()) {
                                aVar.m6020a(C0675d.d.V3_SIG_POR_CERT_MISMATCH, new Object[0]);
                            }
                        } catch (IllegalArgumentException e8) {
                            aVar.m6020a(C0675d.d.V3_SIG_POR_CERT_MISMATCH, new Object[0]);
                        } catch (SecurityException e9) {
                            aVar.m6020a(C0675d.d.V3_SIG_POR_DID_NOT_VERIFY, new Object[0]);
                        } catch (Exception e10) {
                            aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_LINEAGE, new Object[0]);
                        }
                    } else if (i10 == 1436519170) {
                        if (this.f4097g >= 33 && this.f4096f) {
                            int i11 = ByteBuffer.wrap(m6241a).order(ByteOrder.LITTLE_ENDIAN).getInt();
                            if (this.f4099i.m6195c()) {
                                int m6194b = this.f4099i.m6194b();
                                if (i11 != m6194b) {
                                    aVar.m6020a(C0675d.d.V31_ROTATION_MIN_SDK_MISMATCH, Integer.valueOf(i11), Integer.valueOf(m6194b));
                                }
                            } else {
                                aVar.m6020a(C0675d.d.V31_BLOCK_MISSING, Integer.valueOf(i11));
                            }
                        }
                        z = true;
                    } else if (i10 == -1029262406) {
                        if (this.f4093c != 462663009) {
                            aVar.m6021b(C0675d.d.V31_ROTATION_TARGETS_DEV_RELEASE_ATTR_ON_V3_SIGNER, new Object[0]);
                        }
                    } else {
                        aVar.m6021b(C0675d.d.V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i10));
                    }
                } catch (C0579a e11) {
                    aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i9));
                    return;
                } catch (BufferUnderflowException e12) {
                    aVar.m6020a(C0675d.d.V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i9));
                    return;
                }
            }
            if (!this.f4096f || !this.f4099i.m6195c() || z) {
                return;
            }
            aVar.m6021b(C0675d.d.V31_ROTATION_MIN_SDK_ATTR_MISSING, Integer.valueOf(this.f4099i.m6194b()));
        } catch (C0598d.d e13) {
            aVar.m6020a(C0675d.d.V3_SIG_NO_SUPPORTED_SIGNATURES, new Object[0]);
        }
    }

    /* compiled from: V3SchemeVerifier.java */
    /* renamed from: com.b.a.b.a.d.b$a */
    public static class a {

        /* renamed from: a */
        private InterfaceC0671c f4105a;

        /* renamed from: b */
        private ByteBuffer f4106b;

        /* renamed from: d */
        private Set<EnumC0607g> f4108d;

        /* renamed from: g */
        private int f4111g;

        /* renamed from: h */
        private int f4112h;

        /* renamed from: j */
        private C0598d.e f4114j;

        /* renamed from: k */
        private AbstractC0581c.c f4115k;

        /* renamed from: e */
        private InterfaceC0673e f4109e = InterfaceC0673e.SINGLE_THREADED;

        /* renamed from: c */
        private int f4107c = C0599a.APK_SIGNATURE_SCHEME_V3_BLOCK_ID;

        /* renamed from: f */
        private boolean f4110f = true;

        /* renamed from: i */
        private C0628b f4113i = C0628b.m6192a();

        public a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar, int i, int i2) {
            this.f4105a = interfaceC0671c;
            this.f4115k = cVar;
            this.f4112h = i;
            this.f4111g = i2;
        }

        public a(ByteBuffer byteBuffer) {
            this.f4106b = byteBuffer;
        }

        /* renamed from: a */
        public a m6005a(InterfaceC0673e interfaceC0673e) {
            this.f4109e = interfaceC0673e;
            return this;
        }

        /* renamed from: a */
        public a m6003a(int i) {
            this.f4107c = i;
            return this;
        }

        /* renamed from: b */
        public a m6009b(int i) {
            this.f4113i = C0628b.m6193a(i);
            return this;
        }

        /* renamed from: a */
        public a m6004a(C0598d.e eVar) {
            this.f4114j = eVar;
            return this;
        }

        /* renamed from: a */
        public a m6006a(Set<EnumC0607g> set) {
            this.f4108d = set;
            return this;
        }

        /* renamed from: a */
        public a m6007a(boolean z) {
            this.f4110f = z;
            return this;
        }

        /* renamed from: a */
        public C0600b m6008a() {
            int i;
            int i2 = this.f4107c;
            if (i2 == -262969152) {
                i = 3;
                this.f4112h = Math.max(this.f4112h, 28);
            } else if (i2 == 462663009) {
                i = 31;
                this.f4112h = this.f4111g;
            } else {
                throw new IllegalArgumentException(String.format("Unsupported APK Signature Scheme V3 block ID: 0x%08x", Integer.valueOf(this.f4107c)));
            }
            if (this.f4114j == null) {
                this.f4114j = new C0598d.e(i);
            }
            if (this.f4108d == null) {
                this.f4108d = new HashSet(1);
            }
            C0600b c0600b = new C0600b(this.f4109e, this.f4105a, this.f4115k, this.f4108d, this.f4114j, this.f4112h, this.f4111g, this.f4107c, this.f4113i, this.f4110f);
            ByteBuffer byteBuffer = this.f4106b;
            if (byteBuffer != null) {
                c0600b.f4092b = byteBuffer;
            }
            return c0600b;
        }
    }
}
