package com.p065b.p111c.p113b.p114a.p116b;

import com.p065b.p111c.C1066c;
import com.p065b.p111c.p112a.AbstractC1038b;
import com.p065b.p111c.p112a.C1037a;
import com.p065b.p111c.p113b.p118c.C1053a;
import com.p065b.p111c.p113b.p118c.C1055c;
import com.p065b.p111c.p113b.p118c.C1059g;
import com.p065b.p111c.p113b.p119d.AbstractC1065d;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.ByteArrayInputStream;
import java.security.DigestException;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: V2SchemeVerifier.java */
/* renamed from: com.b.c.b.a.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC1049d {

    /* renamed from: a */
    private static int[] f6646a;

    /* renamed from: b */
    private static final char[] f6647b = "01234567890abcdef".toCharArray();

    /* renamed from: a */
    static /* synthetic */ int[] m8788a() {
        int[] iArr = f6646a;
        if (iArr == null) {
            iArr = new int[EnumC1046a.valuesCustom().length];
            try {
                iArr[EnumC1046a.CHUNKED_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[EnumC1046a.CHUNKED_SHA512.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            f6646a = iArr;
        }
        return iArr;
    }

    /* renamed from: b */
    public static b m8789b(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar) {
        b bVar = new b();
        g m8776a = m8776a(interfaceC1069c, cVar, bVar);
        m8784a(interfaceC1069c.mo8845b(0L, m8776a.f6669a), m8776a.f6673e, interfaceC1069c.mo8845b(m8776a.f6670b, m8776a.f6672d - m8776a.f6670b), m8776a.f6671c, bVar);
        return bVar;
    }

    /* renamed from: a */
    private static void m8784a(InterfaceC1069c interfaceC1069c, ByteBuffer byteBuffer, InterfaceC1069c interfaceC1069c2, ByteBuffer byteBuffer2, b bVar) {
        HashSet hashSet = new HashSet(1);
        m8787a(byteBuffer, hashSet, bVar);
        if (!bVar.m8793a()) {
            m8783a(interfaceC1069c, interfaceC1069c2, byteBuffer2, hashSet, bVar);
            if (!bVar.m8793a()) {
                bVar.f6650b = true;
            }
        }
    }

    /* renamed from: a */
    private static void m8787a(ByteBuffer byteBuffer, Set<EnumC1046a> set, b bVar) {
        try {
            ByteBuffer m8790b = m8790b(byteBuffer);
            if (!m8790b.hasRemaining()) {
                bVar.m8792a(C1066c.c.V2_SIG_NO_SIGNERS, new Object[0]);
                return;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                int i2 = 0;
                while (m8790b.hasRemaining()) {
                    c cVar = new c();
                    cVar.f6656d = i2;
                    bVar.f6649a.add(cVar);
                    try {
                        m8786a(m8790b(m8790b), certificateFactory, cVar, set);
                        i2++;
                    } catch (C1037a | BufferUnderflowException e2) {
                        cVar.m8797a(C1066c.c.V2_SIG_MALFORMED_SIGNER, new Object[0]);
                        return;
                    }
                }
            } catch (CertificateException e3) {
                throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
            }
        } catch (C1037a e4) {
            bVar.m8792a(C1066c.c.V2_SIG_MALFORMED_SIGNERS, new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m8786a(ByteBuffer byteBuffer, CertificateFactory certificateFactory, c cVar, Set<EnumC1046a> set) {
        ByteBuffer m8790b = m8790b(byteBuffer);
        byte[] bArr = new byte[m8790b.remaining()];
        m8790b.get(bArr);
        m8790b.flip();
        cVar.f6658f = bArr;
        ByteBuffer m8790b2 = m8790b(byteBuffer);
        byte[] m8791c = m8791c(byteBuffer);
        ArrayList arrayList = new ArrayList(1);
        int i2 = 0;
        while (m8790b2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer m8790b3 = m8790b(m8790b2);
                int i3 = m8790b3.getInt();
                byte[] m8791c2 = m8791c(m8790b3);
                cVar.f6657e.add(new f(i3, m8791c2));
                EnumC1047b m8755a = EnumC1047b.m8755a(i3);
                if (m8755a == null) {
                    cVar.m8800b(C1066c.c.V2_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i3));
                } else {
                    arrayList.add(new i(m8755a, m8791c2, null));
                }
            } catch (C1037a | BufferUnderflowException e2) {
                cVar.m8797a(C1066c.c.V2_SIG_MALFORMED_SIGNATURE, Integer.valueOf(i2));
                return;
            }
        }
        if (cVar.f6657e.isEmpty()) {
            cVar.m8797a(C1066c.c.V2_SIG_NO_SIGNATURES, new Object[0]);
            return;
        }
        List<i> m8782a = m8782a(arrayList);
        if (m8782a.isEmpty()) {
            cVar.m8797a(C1066c.c.V2_SIG_NO_SUPPORTED_SIGNATURES, new Object[0]);
            return;
        }
        for (i iVar : m8782a) {
            EnumC1047b enumC1047b = iVar.f6674a;
            String m8852a = enumC1047b.m8759d().m8852a();
            AlgorithmParameterSpec m8853b = enumC1047b.m8759d().m8853b();
            try {
                PublicKey generatePublic = KeyFactory.getInstance(enumC1047b.m8758c()).generatePublic(new X509EncodedKeySpec(m8791c));
                try {
                    Signature signature = Signature.getInstance(m8852a);
                    signature.initVerify(generatePublic);
                    if (m8853b != null) {
                        signature.setParameter(m8853b);
                    }
                    m8790b.position(0);
                    signature.update(m8790b);
                    byte[] bArr2 = iVar.f6675b;
                    if (!signature.verify(bArr2)) {
                        cVar.m8797a(C1066c.c.V2_SIG_DID_NOT_VERIFY, enumC1047b);
                        return;
                    } else {
                        cVar.f6660h.put(enumC1047b, bArr2);
                        set.add(enumC1047b.m8756a());
                    }
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | SignatureException e3) {
                    cVar.m8797a(C1066c.c.V2_SIG_VERIFY_EXCEPTION, enumC1047b, e3);
                    return;
                }
            } catch (Exception e4) {
                cVar.m8797a(C1066c.c.V2_SIG_MALFORMED_PUBLIC_KEY, e4);
                return;
            }
        }
        m8790b.position(0);
        ByteBuffer m8790b4 = m8790b(m8790b);
        ByteBuffer m8790b5 = m8790b(m8790b);
        ByteBuffer m8790b6 = m8790b(m8790b);
        int i4 = -1;
        while (m8790b5.hasRemaining()) {
            int i5 = i4 + 1;
            byte[] m8791c3 = m8791c(m8790b5);
            try {
                cVar.f6654b.add(new a((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(m8791c3)), m8791c3));
                i4 = i5;
            } catch (CertificateException e5) {
                cVar.m8797a(C1066c.c.V2_SIG_MALFORMED_CERTIFICATE, Integer.valueOf(i5), Integer.valueOf(i5 + 1), e5);
                return;
            }
        }
        if (cVar.f6654b.isEmpty()) {
            cVar.m8797a(C1066c.c.V2_SIG_NO_CERTIFICATES, new Object[0]);
            return;
        }
        byte[] encoded = cVar.f6654b.get(0).getPublicKey().getEncoded();
        if (!Arrays.equals(m8791c, encoded)) {
            cVar.m8797a(C1066c.c.V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, m8778a(encoded), m8778a(m8791c));
            return;
        }
        int i6 = 0;
        while (m8790b4.hasRemaining()) {
            i6++;
            try {
                ByteBuffer m8790b7 = m8790b(m8790b4);
                cVar.f6655c.add(new e(m8790b7.getInt(), m8791c(m8790b7)));
            } catch (C1037a | BufferUnderflowException e6) {
                cVar.m8797a(C1066c.c.V2_SIG_MALFORMED_DIGEST, Integer.valueOf(i6));
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(cVar.f6657e.size());
        Iterator<f> it = cVar.f6657e.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(it.next().m8804a()));
        }
        ArrayList arrayList3 = new ArrayList(cVar.f6655c.size());
        Iterator<e> it2 = cVar.f6655c.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Integer.valueOf(it2.next().m8802a()));
        }
        if (!arrayList2.equals(arrayList3)) {
            cVar.m8797a(C1066c.c.V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS, arrayList2, arrayList3);
            return;
        }
        int i7 = 0;
        while (m8790b6.hasRemaining()) {
            i7++;
            try {
                ByteBuffer m8790b8 = m8790b(m8790b6);
                int i8 = m8790b8.getInt();
                cVar.f6653a.add(new d(i8, m8791c(m8790b8)));
                cVar.m8800b(C1066c.c.V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i8));
            } catch (C1037a | BufferUnderflowException e7) {
                cVar.m8797a(C1066c.c.V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE, Integer.valueOf(i7));
                return;
            }
        }
    }

    /* renamed from: a */
    private static List<i> m8782a(List<i> list) {
        i iVar = null;
        byte[] bArr = null;
        EnumC1047b enumC1047b = null;
        for (i iVar2 : list) {
            EnumC1047b enumC1047b2 = iVar2.f6674a;
            if (enumC1047b == null || m8775a(enumC1047b2, enumC1047b) > 0) {
                bArr = iVar2.f6675b;
                enumC1047b = enumC1047b2;
            }
        }
        if (enumC1047b == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(new i(enumC1047b, bArr, iVar));
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$i */
    private static class i {

        /* renamed from: a */
        private final EnumC1047b f6674a;

        /* renamed from: b */
        private final byte[] f6675b;

        private i(EnumC1047b enumC1047b, byte[] bArr) {
            this.f6674a = enumC1047b;
            this.f6675b = bArr;
        }

        /* synthetic */ i(EnumC1047b enumC1047b, byte[] bArr, i iVar) {
            this(enumC1047b, bArr);
        }
    }

    /* renamed from: a */
    private static int m8775a(EnumC1047b enumC1047b, EnumC1047b enumC1047b2) {
        return m8774a(enumC1047b.m8756a(), enumC1047b2.m8756a());
    }

    /* renamed from: a */
    private static int m8774a(EnumC1046a enumC1046a, EnumC1046a enumC1046a2) {
        switch (m8788a()[enumC1046a.ordinal()]) {
            case 1:
                switch (m8788a()[enumC1046a2.ordinal()]) {
                    case 1:
                        return 0;
                    case 2:
                        return -1;
                    default:
                        throw new IllegalArgumentException("Unknown alg2: " + enumC1046a2);
                }
            case 2:
                switch (m8788a()[enumC1046a2.ordinal()]) {
                    case 1:
                        return 1;
                    case 2:
                        return 0;
                    default:
                        throw new IllegalArgumentException("Unknown alg2: " + enumC1046a2);
                }
            default:
                throw new IllegalArgumentException("Unknown alg1: " + enumC1046a);
        }
    }

    /* renamed from: a */
    private static void m8783a(InterfaceC1069c interfaceC1069c, InterfaceC1069c interfaceC1069c2, ByteBuffer byteBuffer, Set<EnumC1046a> set, b bVar) {
        if (set.isEmpty()) {
            throw new RuntimeException("No content digests found");
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(byteBuffer);
        allocate.flip();
        AbstractC1065d.m8902b(allocate, interfaceC1069c.mo8840a());
        try {
            Map<EnumC1046a, byte[]> m8762a = AbstractC1048c.m8762a(set, new InterfaceC1069c[]{interfaceC1069c, interfaceC1069c2, new C1053a(allocate)});
            if (!set.equals(m8762a.keySet())) {
                throw new RuntimeException("Mismatch between sets of requested and computed content digests . Requested: " + set + ", computed: " + m8762a.keySet());
            }
            for (c cVar : bVar.f6649a) {
                for (e eVar : cVar.f6655c) {
                    EnumC1047b m8755a = EnumC1047b.m8755a(eVar.m8802a());
                    if (m8755a != null) {
                        EnumC1046a m8756a = m8755a.m8756a();
                        byte[] m8803b = eVar.m8803b();
                        byte[] bArr = m8762a.get(m8756a);
                        if (!Arrays.equals(m8803b, bArr)) {
                            cVar.m8797a(C1066c.c.V2_SIG_APK_DIGEST_DID_NOT_VERIFY, m8756a, m8778a(m8803b), m8778a(bArr));
                        } else {
                            cVar.f6659g.put(m8756a, bArr);
                        }
                    }
                }
            }
        } catch (DigestException e2) {
            throw new RuntimeException("Failed to compute content digests", e2);
        }
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$g */
    private static class g {

        /* renamed from: a */
        private final long f6669a;

        /* renamed from: b */
        private final long f6670b;

        /* renamed from: c */
        private final ByteBuffer f6671c;

        /* renamed from: d */
        private final long f6672d;

        /* renamed from: e */
        private final ByteBuffer f6673e;

        private g(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2) {
            this.f6673e = byteBuffer;
            this.f6669a = j;
            this.f6670b = j2;
            this.f6672d = j3;
            this.f6671c = byteBuffer2;
        }

        /* synthetic */ g(ByteBuffer byteBuffer, long j, long j2, long j3, ByteBuffer byteBuffer2, g gVar) {
            this(byteBuffer, j, j2, j3, byteBuffer2);
        }
    }

    /* renamed from: a */
    private static g m8776a(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar, b bVar) {
        ByteBuffer m8632d = cVar.m8632d();
        C1059g<InterfaceC1069c, Long> m8777a = m8777a(interfaceC1069c, cVar);
        InterfaceC1069c m8852a = m8777a.m8852a();
        long longValue = m8777a.m8853b().longValue();
        ByteBuffer mo8842a = m8852a.mo8842a(0L, (int) m8852a.mo8840a());
        mo8842a.order(ByteOrder.LITTLE_ENDIAN);
        return new g(m8781a(mo8842a, bVar), longValue, cVar.m8629a(), cVar.m8633e(), m8632d, null);
    }

    /* renamed from: a */
    public static C1059g<InterfaceC1069c, Long> m8777a(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar) {
        long m8629a = cVar.m8629a();
        long m8631c = cVar.m8631c() + m8629a;
        long m8633e = cVar.m8633e();
        if (m8631c != m8633e) {
            throw new h("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + m8631c + ", EoCD start: " + m8633e);
        }
        if (m8629a < 32) {
            throw new h("APK too small for APK Signing Block. ZIP Central Directory offset: " + m8629a);
        }
        ByteBuffer mo8842a = interfaceC1069c.mo8842a(m8629a - 24, 24);
        mo8842a.order(ByteOrder.LITTLE_ENDIAN);
        if (mo8842a.getLong(8) != 2334950737559900225L || mo8842a.getLong(16) != 3617552046287187010L) {
            throw new h("No APK Signing Block before ZIP Central Directory");
        }
        long j = mo8842a.getLong(0);
        if (j < mo8842a.capacity() || j > 2147483639) {
            throw new h("APK Signing Block size out of range: " + j);
        }
        int i2 = (int) (8 + j);
        long j2 = m8629a - i2;
        if (j2 < 0) {
            throw new h("APK Signing Block offset out of range: " + j2);
        }
        ByteBuffer mo8842a2 = interfaceC1069c.mo8842a(j2, 8);
        mo8842a2.order(ByteOrder.LITTLE_ENDIAN);
        long j3 = mo8842a2.getLong(0);
        if (j3 != j) {
            throw new h("APK Signing Block sizes in header and footer do not match: " + j3 + " vs " + j);
        }
        return C1059g.m8851a(interfaceC1069c.mo8845b(j2, i2), Long.valueOf(j2));
    }

    /* renamed from: a */
    private static ByteBuffer m8781a(ByteBuffer byteBuffer, b bVar) {
        m8785a(byteBuffer);
        ByteBuffer m8780a = m8780a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (m8780a.hasRemaining()) {
            i2++;
            if (m8780a.remaining() < 8) {
                throw new h("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = m8780a.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new h("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int position = m8780a.position();
            if (i3 > m8780a.remaining()) {
                throw new h("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + m8780a.remaining());
            }
            int i4 = m8780a.getInt();
            if (i4 == 1896449818) {
                return m8779a(m8780a, i3 - 4);
            }
            bVar.m8795b(C1066c.c.APK_SIG_BLOCK_UNKNOWN_ENTRY_ID, Integer.valueOf(i4));
            m8780a.position(i3 + position);
        }
        throw new h("No APK Signature Scheme v2 block in APK Signing Block");
    }

    /* renamed from: a */
    private static void m8785a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$h */
    public static class h extends Exception {
        public h(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static ByteBuffer m8780a(ByteBuffer byteBuffer, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("start: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("end < start: " + i3 + " < " + i2);
        }
        int capacity = byteBuffer.capacity();
        if (i3 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i3 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i3);
            byteBuffer.position(i2);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    /* renamed from: a */
    private static ByteBuffer m8779a(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size: " + i2);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i3 = position + i2;
        if (i3 < position || i3 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    /* renamed from: b */
    private static ByteBuffer m8790b(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
            throw new C1037a("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i2 > byteBuffer.remaining()) {
            throw new C1037a("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
        }
        return m8779a(byteBuffer, i2);
    }

    /* renamed from: c */
    private static byte[] m8791c(ByteBuffer byteBuffer) {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new C1037a("Negative length");
        }
        if (i2 > byteBuffer.remaining()) {
            throw new C1037a("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$a */
    private static class a extends C1055c {

        /* renamed from: a */
        private byte[] f6648a;

        public a(X509Certificate x509Certificate, byte[] bArr) {
            super(x509Certificate);
            this.f6648a = bArr != null ? (byte[]) bArr.clone() : null;
        }

        @Override // com.p065b.p111c.p113b.p118c.C1055c, java.security.cert.Certificate
        public byte[] getEncoded() {
            if (this.f6648a != null) {
                return (byte[]) this.f6648a.clone();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static String m8778a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(f6647b[(bArr[i2] & 255) >>> 4]).append(f6647b[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$b */
    public static class b {

        /* renamed from: b */
        public boolean f6650b;

        /* renamed from: a */
        public final List<c> f6649a = new ArrayList();

        /* renamed from: d */
        private final List<C1066c.d> f6652d = new ArrayList();

        /* renamed from: c */
        private final List<C1066c.d> f6651c = new ArrayList();

        /* renamed from: a */
        public boolean m8793a() {
            if (!this.f6651c.isEmpty()) {
                return true;
            }
            if (!this.f6649a.isEmpty()) {
                Iterator<c> it = this.f6649a.iterator();
                while (it.hasNext()) {
                    if (it.next().m8798a()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: a */
        public void m8792a(C1066c.c cVar, Object... objArr) {
            this.f6651c.add(new C1066c.d(cVar, objArr));
        }

        /* renamed from: b */
        public void m8795b(C1066c.c cVar, Object... objArr) {
            this.f6652d.add(new C1066c.d(cVar, objArr));
        }

        /* renamed from: b */
        public List<C1066c.d> m8794b() {
            return this.f6651c;
        }

        /* renamed from: c */
        public List<C1066c.d> m8796c() {
            return this.f6652d;
        }
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$c */
    public static class c {

        /* renamed from: d */
        public int f6656d;

        /* renamed from: f */
        public byte[] f6658f;

        /* renamed from: b */
        public List<X509Certificate> f6654b = new ArrayList();

        /* renamed from: c */
        public List<e> f6655c = new ArrayList();

        /* renamed from: g */
        public Map<EnumC1046a, byte[]> f6659g = new HashMap();

        /* renamed from: e */
        public List<f> f6657e = new ArrayList();

        /* renamed from: h */
        public Map<EnumC1047b, byte[]> f6660h = new HashMap();

        /* renamed from: a */
        public List<d> f6653a = new ArrayList();

        /* renamed from: j */
        private final List<C1066c.d> f6662j = new ArrayList();

        /* renamed from: i */
        private final List<C1066c.d> f6661i = new ArrayList();

        /* renamed from: a */
        public void m8797a(C1066c.c cVar, Object... objArr) {
            this.f6661i.add(new C1066c.d(cVar, objArr));
        }

        /* renamed from: b */
        public void m8800b(C1066c.c cVar, Object... objArr) {
            this.f6662j.add(new C1066c.d(cVar, objArr));
        }

        /* renamed from: a */
        public boolean m8798a() {
            return !this.f6661i.isEmpty();
        }

        /* renamed from: b */
        public List<C1066c.d> m8799b() {
            return this.f6661i;
        }

        /* renamed from: c */
        public List<C1066c.d> m8801c() {
            return this.f6662j;
        }
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$e */
    public static class e {

        /* renamed from: a */
        private final int f6665a;

        /* renamed from: b */
        private final byte[] f6666b;

        public e(int i, byte[] bArr) {
            this.f6665a = i;
            this.f6666b = bArr;
        }

        /* renamed from: a */
        public int m8802a() {
            return this.f6665a;
        }

        /* renamed from: b */
        public byte[] m8803b() {
            return this.f6666b;
        }
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$f */
    public static class f {

        /* renamed from: a */
        private final int f6667a;

        /* renamed from: b */
        private final byte[] f6668b;

        public f(int i, byte[] bArr) {
            this.f6667a = i;
            this.f6668b = bArr;
        }

        /* renamed from: a */
        public int m8804a() {
            return this.f6667a;
        }
    }

    /* compiled from: V2SchemeVerifier.java */
    /* renamed from: com.b.c.b.a.b.d$d */
    public static class d {

        /* renamed from: a */
        private final int f6663a;

        /* renamed from: b */
        private final byte[] f6664b;

        public d(int i, byte[] bArr) {
            this.f6663a = i;
            this.f6664b = (byte[]) bArr.clone();
        }
    }
}
