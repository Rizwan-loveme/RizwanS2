package com.p065b.p066a.p068b.p069a;

import android.media.session.PlaybackState;
import android.security.keystore.KeyProperties;
import com.p065b.p066a.C0675d;
import com.p065b.p066a.C0680g;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p068b.p075b.C0612a;
import com.p065b.p066a.p068b.p075b.C0619c;
import com.p065b.p066a.p068b.p075b.C0620d;
import com.p065b.p066a.p068b.p075b.C0621e;
import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p079e.C0632a;
import com.p065b.p066a.p068b.p080f.C0633a;
import com.p065b.p066a.p068b.p080f.C0635c;
import com.p065b.p066a.p068b.p080f.C0636d;
import com.p065b.p066a.p068b.p080f.C0637e;
import com.p065b.p066a.p068b.p080f.C0639g;
import com.p065b.p066a.p068b.p080f.C0640h;
import com.p065b.p066a.p068b.p080f.C0641i;
import com.p065b.p066a.p068b.p081g.C0642a;
import com.p065b.p066a.p068b.p081g.C0645d;
import com.p065b.p066a.p068b.p081g.C0648g;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p068b.p081g.C0655n;
import com.p065b.p066a.p068b.p081g.C0656o;
import com.p065b.p066a.p068b.p082h.C0659c;
import com.p065b.p066a.p068b.p082h.C0660d;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p066a.p084c.AbstractC0670b;
import com.p065b.p066a.p084c.AbstractC0672d;
import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import com.p065b.p066a.p084c.InterfaceC0674f;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.IOException;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
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
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ApkSigningBlockUtils.java */
/* renamed from: com.b.a.b.a.d */
/* loaded from: classes.dex */
public class C0598d {
    public static final int ANDROID_COMMON_PAGE_ALIGNMENT_BYTES = 4096;
    private static final long CONTENT_DIGESTED_CHUNK_MAX_SIZE_BYTES = 1048576;
    public static final int VERITY_PADDING_BLOCK_ID = 1114793335;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V2 = 2;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V3 = 3;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V31 = 31;
    public static final int VERSION_APK_SIGNATURE_SCHEME_V4 = 4;
    public static final int VERSION_JAR_SIGNATURE_SCHEME = 1;
    public static final int VERSION_SOURCE_STAMP = 0;
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, 75, 32, 83, 105, 103, 32, 66, 108, 111, 99, 107, 32, 52, 50};
    private static final EnumC0607g[] V4_CONTENT_DIGEST_ALGORITHMS = {EnumC0607g.CHUNKED_SHA512, EnumC0607g.VERITY_CHUNKED_SHA256, EnumC0607g.CHUNKED_SHA256};

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$g */
    public static class g {

        /* renamed from: a */
        public List<X509Certificate> f4149a;

        /* renamed from: b */
        public C0680g f4150b;

        /* renamed from: c */
        public int f4151c;

        /* renamed from: d */
        public int f4152d;

        /* renamed from: e */
        public PrivateKey f4153e;

        /* renamed from: f */
        public List<EnumC0609i> f4154f;
    }

    /* renamed from: a */
    public static void m5956a(InterfaceC0673e interfaceC0673e, InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, ByteBuffer byteBuffer, Set<EnumC0607g> set, e eVar) {
        if (set.isEmpty()) {
            throw new RuntimeException("No content digests found");
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        int position = byteBuffer.position();
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(byteBuffer);
        allocate.flip();
        byteBuffer.position(position);
        AbstractC0667d.m6321b(allocate, interfaceC0671c.mo6233a());
        try {
            Map<EnumC0607g, byte[]> m5953a = m5953a(interfaceC0673e, set, interfaceC0671c, interfaceC0671c2, new C0642a(allocate));
            if (m5953a.containsKey(EnumC0607g.VERITY_CHUNKED_SHA256)) {
                if (interfaceC0671c.mo6233a() % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
                    throw new RuntimeException("APK Signing Block is not aligned on 4k boundary: " + interfaceC0671c.mo6233a());
                }
                long m6325e = AbstractC0667d.m6325e(byteBuffer) - interfaceC0671c.mo6233a();
                if (m6325e % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
                    throw new RuntimeException("APK Signing Block size is not multiple of page size: " + m6325e);
                }
            }
            if (!set.equals(m5953a.keySet())) {
                throw new RuntimeException("Mismatch between sets of requested and computed content digests . Requested: " + set + ", computed: " + m5953a.keySet());
            }
            for (e.a aVar : eVar.f4128d) {
                for (e.a.b bVar : aVar.f4133f) {
                    EnumC0609i m6078a = EnumC0609i.m6078a(bVar.m6023a());
                    if (m6078a != null) {
                        EnumC0607g m6080a = m6078a.m6080a();
                        if (set.contains(m6080a)) {
                            byte[] m6024b = bVar.m6024b();
                            byte[] bArr = m5953a.get(m6080a);
                            if (!Arrays.equals(m6024b, bArr)) {
                                if (eVar.f4013b == 2) {
                                    aVar.m6020a(C0675d.d.V2_SIG_APK_DIGEST_DID_NOT_VERIFY, m6080a, m5971c(m6024b), m5971c(bArr));
                                } else if (eVar.f4013b == 3) {
                                    aVar.m6020a(C0675d.d.V3_SIG_APK_DIGEST_DID_NOT_VERIFY, m6080a, m5971c(m6024b), m5971c(bArr));
                                }
                            } else {
                                aVar.f4139l.put(m6080a, bArr);
                            }
                        }
                    }
                }
            }
        } catch (DigestException e2) {
            throw new RuntimeException("Failed to compute content digests", e2);
        }
    }

    /* renamed from: a */
    public static void m5958a(ByteBuffer byteBuffer) {
        C0602e.m6033a(byteBuffer);
    }

    /* renamed from: b */
    public static ByteBuffer m5966b(ByteBuffer byteBuffer) {
        return C0602e.m6035b(byteBuffer);
    }

    /* renamed from: c */
    public static byte[] m5973c(ByteBuffer byteBuffer) {
        return C0602e.m6037c(byteBuffer);
    }

    /* renamed from: c */
    public static String m5971c(byte[] bArr) {
        return C0602e.m6029a(bArr);
    }

    /* renamed from: a */
    public static Map<EnumC0607g, byte[]> m5953a(InterfaceC0673e interfaceC0673e, Set<EnumC0607g> set, InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3) {
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (EnumC0607g enumC0607g : set) {
            if (enumC0607g == EnumC0607g.CHUNKED_SHA256 || enumC0607g == EnumC0607g.CHUNKED_SHA512) {
                hashSet.add(enumC0607g);
            }
        }
        m5957a(interfaceC0673e, hashSet, new InterfaceC0671c[]{interfaceC0671c, interfaceC0671c2, interfaceC0671c3}, hashMap);
        if (set.contains(EnumC0607g.VERITY_CHUNKED_SHA256)) {
            m5955a(interfaceC0671c, interfaceC0671c2, interfaceC0671c3, hashMap);
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    static void m5957a(InterfaceC0673e interfaceC0673e, Set<EnumC0607g> set, InterfaceC0671c[] interfaceC0671cArr, Map<EnumC0607g, byte[]> map) {
        Object[] objArr = 0;
        long j2 = 0;
        for (InterfaceC0671c interfaceC0671c : interfaceC0671cArr) {
            j2 += m5965b(interfaceC0671c.mo6233a(), CONTENT_DIGESTED_CHUNK_MAX_SIZE_BYTES);
        }
        if (j2 > 2147483647L) {
            throw new DigestException("Input too long: " + j2 + " chunks");
        }
        int i2 = (int) j2;
        ArrayList<b> arrayList = new ArrayList(set.size());
        Iterator<EnumC0607g> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(new b(it.next(), i2));
        }
        interfaceC0673e.mo6340a(new InterfaceC0674f(new c(interfaceC0671cArr), arrayList) { // from class: com.b.a.b.a.d.1

            /* renamed from: a */
            final List f4059a;

            /* renamed from: b */
            final c f4060b;

            {
                this.f4060b = r1;
                this.f4059a = arrayList;
            }

            @Override // com.p065b.p066a.p084c.InterfaceC0674f
            /* renamed from: a */
            public Runnable mo5975a() {
                return new a(this.f4060b, this.f4059a);
            }
        });
        for (b bVar : arrayList) {
            map.put(bVar.f4102a, bVar.m5999a().digest(bVar.f4103b));
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$b */
    private static class b {

        /* renamed from: a */
        private final EnumC0607g f4102a;

        /* renamed from: b */
        private final byte[] f4103b;

        /* renamed from: c */
        private final int f4104c;

        private b(EnumC0607g enumC0607g, int i) {
            this.f4102a = enumC0607g;
            int m6075a = enumC0607g.m6075a();
            this.f4104c = m6075a;
            byte[] bArr = new byte[(m6075a * i) + 5];
            this.f4103b = bArr;
            bArr[0] = 90;
            C0598d.m5969b(i, bArr, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public MessageDigest m5999a() {
            return MessageDigest.getInstance(this.f4102a.m6077c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m5996a(int i) {
            return (this.f4104c * i) + 5;
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$a */
    private static class a implements Runnable {

        /* renamed from: a */
        private final List<b> f4069a;

        /* renamed from: b */
        private final c f4070b;

        /* renamed from: c */
        private final InterfaceC0669a f4071c;

        /* renamed from: d */
        private final List<MessageDigest> f4072d;

        private a(c cVar, List<b> list) {
            this.f4070b = cVar;
            this.f4069a = list;
            this.f4072d = new ArrayList(list.size());
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.f4072d.add(it.next().m5999a());
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f4071c = AbstractC0670b.m6334a((MessageDigest[]) this.f4072d.toArray(new MessageDigest[0]));
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[5];
            bArr[0] = -91;
            try {
                c.a m6014a = this.f4070b.m6014a();
                while (m6014a != null) {
                    int i = m6014a.f4122c;
                    if (i <= C0598d.CONTENT_DIGESTED_CHUNK_MAX_SIZE_BYTES) {
                        C0598d.m5969b(i, bArr, 1);
                        this.f4071c.mo6240a(bArr, 0, 5);
                        this.f4071c.mo6239a(m6014a.f4121b);
                        for (int i2 = 0; i2 < this.f4069a.size(); i2++) {
                            b bVar = this.f4069a.get(i2);
                            int digest = this.f4072d.get(i2).digest(bVar.f4103b, bVar.m5996a(m6014a.f4120a), bVar.f4104c);
                            if (digest != bVar.f4104c) {
                                throw new RuntimeException("Unexpected output size of " + bVar.f4102a + " digest: " + digest);
                            }
                        }
                        m6014a = this.f4070b.m6014a();
                    } else {
                        throw new RuntimeException("Chunk size greater than expected: " + i);
                    }
                }
            } catch (IOException | DigestException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$c */
    private static class c {

        /* renamed from: a */
        private final int[] f4116a;

        /* renamed from: b */
        private final InterfaceC0671c[] f4117b;

        /* renamed from: c */
        private final AtomicInteger f4118c;

        /* renamed from: d */
        private final int f4119d;

        private c(InterfaceC0671c[] interfaceC0671cArr) {
            this.f4117b = interfaceC0671cArr;
            this.f4116a = new int[interfaceC0671cArr.length];
            int i = 0;
            for (int i2 = 0; i2 < interfaceC0671cArr.length; i2++) {
                long m5965b = C0598d.m5965b(interfaceC0671cArr[i2].mo6233a(), C0598d.CONTENT_DIGESTED_CHUNK_MAX_SIZE_BYTES);
                if (m5965b > 2147483647L) {
                    throw new RuntimeException(String.format("Number of chunks in dataSource[%d] is greater than max int.", Integer.valueOf(i2)));
                }
                this.f4116a[i2] = (int) m5965b;
                i = (int) (m5965b + i);
            }
            this.f4119d = i;
            this.f4118c = new AtomicInteger(0);
        }

        /* renamed from: a */
        public a m6014a() {
            InterfaceC0671c[] interfaceC0671cArr;
            int andIncrement = this.f4118c.getAndIncrement();
            if (andIncrement < 0 || andIncrement >= this.f4119d) {
                return null;
            }
            int i = 0;
            long j = andIncrement;
            while (true) {
                interfaceC0671cArr = this.f4117b;
                if (i >= interfaceC0671cArr.length) {
                    break;
                }
                int i2 = this.f4116a[i];
                if (j < i2) {
                    break;
                }
                j -= i2;
                i++;
            }
            long mo6233a = interfaceC0671cArr[i].mo6233a();
            long j2 = j * C0598d.CONTENT_DIGESTED_CHUNK_MAX_SIZE_BYTES;
            int min = (int) Math.min(mo6233a - j2, C0598d.CONTENT_DIGESTED_CHUNK_MAX_SIZE_BYTES);
            ByteBuffer allocate = ByteBuffer.allocate(min);
            try {
                this.f4117b[i].mo6236a(j2, min, allocate);
                allocate.rewind();
                return new a(andIncrement, allocate, min);
            } catch (IOException e2) {
                throw new IllegalStateException("Failed to read chunk", e2);
            }
        }

        /* compiled from: ApkSigningBlockUtils.java */
        /* renamed from: com.b.a.b.a.d$c$a */
        static class a {

            /* renamed from: a */
            private final int f4120a;

            /* renamed from: b */
            private final ByteBuffer f4121b;

            /* renamed from: c */
            private final int f4122c;

            private a(int i, ByteBuffer byteBuffer, int i2) {
                this.f4120a = i;
                this.f4121b = byteBuffer;
                this.f4122c = i2;
            }
        }
    }

    /* renamed from: a */
    private static void m5955a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3, Map<EnumC0607g, byte[]> map) {
        ByteBuffer m5949a = m5949a(true);
        C0655n c0655n = new C0655n(new byte[8]);
        try {
            m5949a.put(c0655n.m6265a(interfaceC0671c, interfaceC0671c2, interfaceC0671c3));
            m5949a.putLong(interfaceC0671c.mo6233a() + interfaceC0671c2.mo6233a() + interfaceC0671c3.mo6233a());
            map.put(EnumC0607g.VERITY_CHUNKED_SHA256, m5949a.array());
            c0655n.close();
        } catch (Throwable th) {
            try {
                c0655n.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static ByteBuffer m5949a(boolean z) {
        int m6075a = EnumC0607g.VERITY_CHUNKED_SHA256.m6075a();
        if (z) {
            m6075a += 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(m6075a);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$j */
    public static class j {

        /* renamed from: a */
        public final EnumC0607g f4157a;

        /* renamed from: b */
        public final byte[] f4158b;

        /* renamed from: c */
        public final byte[] f4159c;

        j(EnumC0607g enumC0607g, byte[] bArr, byte[] bArr2) {
            this.f4157a = enumC0607g;
            this.f4158b = bArr;
            this.f4159c = bArr2;
        }
    }

    /* renamed from: a */
    public static j m5944a(InterfaceC0671c interfaceC0671c) {
        ByteBuffer m5949a = m5949a(false);
        C0655n c0655n = new C0655n(null);
        try {
            ByteBuffer m6264a = c0655n.m6264a(interfaceC0671c);
            m5949a.put(c0655n.m6266a(m6264a));
            j jVar = new j(EnumC0607g.VERITY_CHUNKED_SHA256, m5949a.array(), m6264a.array());
            c0655n.close();
            return jVar;
        } catch (Throwable th) {
            try {
                c0655n.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m5965b(long j2, long j3) {
        return ((j2 + j3) - 1) / j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m5969b(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 16) & 255);
        bArr[i3 + 3] = (byte) ((i2 >> 24) & 255);
    }

    /* renamed from: a */
    public static byte[] m5959a(PublicKey publicKey) {
        byte[] bArr;
        if ("X.509".equals(publicKey.getFormat())) {
            byte[] encoded = publicKey.getEncoded();
            String algorithm = publicKey.getAlgorithm();
            if (KeyProperties.KEY_ALGORITHM_RSA.equals(algorithm) || C0632a.OID_SIG_RSA.equals(algorithm)) {
                try {
                    C0660d c0660d = (C0660d) C0612a.m6091a(ByteBuffer.wrap(encoded), C0660d.class);
                    ByteBuffer byteBuffer = c0660d.subjectPublicKey;
                    byte b2 = byteBuffer.get();
                    C0659c c0659c = (C0659c) C0612a.m6091a(byteBuffer, C0659c.class);
                    if (c0659c.modulus.compareTo(BigInteger.ZERO) < 0) {
                        byte[] byteArray = c0659c.modulus.toByteArray();
                        byte[] bArr2 = new byte[byteArray.length + 1];
                        bArr2[0] = 0;
                        System.arraycopy(byteArray, 0, bArr2, 1, byteArray.length);
                        c0659c.modulus = new BigInteger(bArr2);
                        byte[] m6164c = C0620d.m6164c(c0659c);
                        byte[] bArr3 = new byte[m6164c.length + 1];
                        bArr3[0] = b2;
                        System.arraycopy(m6164c, 0, bArr3, 1, m6164c.length);
                        c0660d.subjectPublicKey = ByteBuffer.wrap(bArr3);
                        bArr = C0620d.m6164c(c0660d);
                    }
                } catch (C0619c | C0621e e2) {
                    System.out.println("Caught a exception encoding the public key: " + e2);
                    e2.printStackTrace();
                    bArr = null;
                }
            }
            bArr = encoded;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            try {
                bArr = ((X509EncodedKeySpec) KeyFactory.getInstance(publicKey.getAlgorithm()).getKeySpec(publicKey, X509EncodedKeySpec.class)).getEncoded();
            } catch (InvalidKeySpecException e3) {
                throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName(), e3);
            }
        }
        if (bArr != null && bArr.length != 0) {
            return bArr;
        }
        throw new InvalidKeyException("Failed to obtain X.509 encoded form of public key " + publicKey + " of class " + publicKey.getClass().getName());
    }

    /* renamed from: c */
    public static List<byte[]> m5972c(List<X509Certificate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<X509Certificate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getEncoded());
        }
        return arrayList;
    }

    /* renamed from: a */
    public static byte[] m5962a(byte[] bArr) {
        return m5964a(new byte[][]{bArr});
    }

    /* renamed from: a */
    public static byte[] m5960a(List<byte[]> list) {
        return m5964a((byte[][]) list.toArray(new byte[list.size()][]));
    }

    /* renamed from: a */
    public static byte[] m5964a(byte[][] bArr) {
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            i2 += bArr2.length + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        for (byte[] bArr3 : bArr) {
            allocate.putInt(bArr3.length);
            allocate.put(bArr3);
        }
        return allocate.array();
    }

    /* renamed from: b */
    public static byte[] m5970b(List<C0652k<Integer, byte[]>> list) {
        return C0602e.m6034a(list);
    }

    /* renamed from: a */
    public static C0610j m5945a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar, int i2, e eVar) {
        try {
            return C0602e.m6028a(interfaceC0671c, cVar, i2);
        } catch (C0611k e2) {
            throw new f(e2.getMessage());
        }
    }

    /* renamed from: a */
    public static C0652k<InterfaceC0671c, Integer> m5946a(InterfaceC0671c interfaceC0671c, boolean z) {
        int i2;
        if (!z || interfaceC0671c.mo6233a() % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM == 0) {
            i2 = 0;
        } else {
            i2 = (int) (PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM - (interfaceC0671c.mo6233a() % PlaybackState.ACTION_SKIP_TO_QUEUE_ITEM));
            interfaceC0671c = new C0645d(interfaceC0671c, AbstractC0672d.m6337a(ByteBuffer.allocate(i2)));
        }
        return C0652k.m6250a(interfaceC0671c, Integer.valueOf(i2));
    }

    /* renamed from: a */
    public static InterfaceC0671c m5948a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2) {
        long mo6233a = interfaceC0671c.mo6233a();
        ByteBuffer allocate = ByteBuffer.allocate((int) interfaceC0671c2.mo6233a());
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        interfaceC0671c2.mo6236a(0L, (int) interfaceC0671c2.mo6233a(), allocate);
        allocate.flip();
        AbstractC0667d.m6321b(allocate, mo6233a);
        return AbstractC0672d.m6337a(allocate);
    }

    /* renamed from: d */
    public static byte[] m5974d(List<C0652k<byte[], Integer>> list) {
        int i2;
        ByteBuffer byteBuffer;
        Iterator<C0652k<byte[], Integer>> it = list.iterator();
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            i3 = it.next().m6251a().length + 12 + i2;
        }
        int i4 = i2 + 8 + 8 + 16;
        int i5 = i4 % 4096;
        if (i5 != 0) {
            int i6 = 4096 - i5;
            if (i6 < 12) {
                i6 += 4096;
            }
            ByteBuffer order = ByteBuffer.allocate(i6).order(ByteOrder.LITTLE_ENDIAN);
            order.putLong(i6 - 8);
            order.putInt(VERITY_PADDING_BLOCK_ID);
            order.rewind();
            byteBuffer = order;
            i4 = i6 + i4;
        } else {
            byteBuffer = null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long j2 = i4 - 8;
        allocate.putLong(j2);
        for (C0652k<byte[], Integer> c0652k : list) {
            byte[] m6251a = c0652k.m6251a();
            int intValue = c0652k.m6252b().intValue();
            allocate.putLong(m6251a.length + 4);
            allocate.putInt(intValue);
            allocate.put(m6251a);
        }
        if (byteBuffer != null) {
            allocate.put(byteBuffer);
        }
        allocate.putLong(j2);
        allocate.put(APK_SIGNING_BLOCK_MAGIC);
        return allocate.array();
    }

    /* renamed from: b */
    public static List<C0652k<byte[], Integer>> m5967b(InterfaceC0671c interfaceC0671c) {
        long mo6233a = interfaceC0671c.mo6233a();
        if (interfaceC0671c.mo6233a() > 2147483647L || mo6233a < 32) {
            throw new IllegalArgumentException("APK signing block size out of range: " + mo6233a);
        }
        ByteBuffer mo6235a = interfaceC0671c.mo6235a(8L, ((int) interfaceC0671c.mo6233a()) - 32);
        mo6235a.order(ByteOrder.LITTLE_ENDIAN);
        ArrayList arrayList = new ArrayList();
        while (mo6235a.hasRemaining()) {
            long j2 = mo6235a.getLong();
            if (j2 > 2147483647L || j2 < 4) {
                throw new IllegalArgumentException("Block index " + (arrayList.size() + 1) + " size out of range: " + j2);
            }
            int i2 = mo6235a.getInt();
            byte[] bArr = new byte[((int) j2) - 4];
            mo6235a.get(bArr);
            arrayList.add(C0652k.m6250a(bArr, Integer.valueOf(i2)));
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<C0652k<List<X509Certificate>, byte[]>> m5968b(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer m5966b = m5966b(wrap);
        ArrayList arrayList = new ArrayList();
        while (m5966b.hasRemaining()) {
            ByteBuffer m5966b2 = m5966b(m5966b);
            byte[] bArr2 = new byte[m5966b2.remaining()];
            m5966b2.get(bArr2);
            m5966b2.rewind();
            ByteBuffer m5966b3 = m5966b(m5966b2);
            m5966b(m5966b3);
            ByteBuffer m5966b4 = m5966b(m5966b3);
            ArrayList arrayList2 = new ArrayList();
            while (m5966b4.hasRemaining()) {
                int i2 = m5966b4.getInt();
                byte[] bArr3 = new byte[i2];
                if (i2 > m5966b4.remaining()) {
                    throw new IllegalArgumentException("Cert index " + (arrayList2.size() + 1) + " under signer index " + (arrayList.size() + 1) + " size out of range: " + i2);
                }
                m5966b4.get(bArr3);
                arrayList2.add(new C0648g(C0656o.m6269a(bArr3), bArr3));
            }
            arrayList.add(C0652k.m6250a(arrayList2, bArr2));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0652k<List<g>, Map<EnumC0607g, byte[]>> m5947a(InterfaceC0673e interfaceC0673e, InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3, List<g> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("No signer configs provided. At least one is required");
        }
        HashSet hashSet = new HashSet(1);
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            Iterator<EnumC0609i> it2 = it.next().f4154f.iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().m6080a());
            }
        }
        try {
            return C0652k.m6250a(list, m5953a(interfaceC0673e, hashSet, interfaceC0671c, interfaceC0671c2, interfaceC0671c3));
        } catch (IOException e2) {
            throw new IOException("Failed to read APK being signed", e2);
        } catch (DigestException e3) {
            throw new SignatureException("Failed to compute digests of APK", e3);
        }
    }

    /* renamed from: a */
    public static <T extends C0606f> List<T> m5951a(List<T> list, int i2, int i3) {
        return m5952a((List) list, i2, i3, false);
    }

    /* renamed from: a */
    public static <T extends C0606f> List<T> m5952a(List<T> list, int i2, int i3, boolean z) {
        try {
            return C0602e.m6032a(list, i2, i3, z);
        } catch (C0608h e2) {
            throw new d(e2.getMessage());
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$d */
    public static class d extends C0608h {
        public d(String str) {
            super(str);
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$f */
    public static class f extends Exception {
        private static final long serialVersionUID = 1;

        public f(String str) {
            super(str);
        }

        public f(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: a */
    public static List<C0652k<Integer, byte[]>> m5950a(g gVar, byte[] bArr) {
        ArrayList arrayList = new ArrayList(gVar.f4154f.size());
        PublicKey publicKey = gVar.f4149a.get(0).getPublicKey();
        for (EnumC0609i enumC0609i : gVar.f4154f) {
            C0652k<String, ? extends AlgorithmParameterSpec> m6084e = enumC0609i.m6084e();
            String m6251a = m6084e.m6251a();
            AlgorithmParameterSpec m6252b = m6084e.m6252b();
            try {
                Signature signature = Signature.getInstance(m6251a);
                signature.initSign(gVar.f4153e);
                if (m6252b != null) {
                    signature.setParameter(m6252b);
                }
                signature.update(bArr);
                byte[] sign = signature.sign();
                try {
                    Signature signature2 = Signature.getInstance(m6251a);
                    signature2.initVerify(publicKey);
                    if (m6252b != null) {
                        signature2.setParameter(m6252b);
                    }
                    signature2.update(bArr);
                    if (!signature2.verify(sign)) {
                        throw new SignatureException("Failed to verify generated " + m6251a + " signature using public key from certificate");
                    }
                    arrayList.add(C0652k.m6250a(Integer.valueOf(enumC0609i.m6081b()), sign));
                } catch (InvalidAlgorithmParameterException e2) {
                    e = e2;
                    throw new SignatureException("Failed to verify generated " + m6251a + " signature using public key from certificate", e);
                } catch (InvalidKeyException e3) {
                    throw new InvalidKeyException("Failed to verify generated " + m6251a + " signature using public key from certificate", e3);
                } catch (SignatureException e4) {
                    e = e4;
                    throw new SignatureException("Failed to verify generated " + m6251a + " signature using public key from certificate", e);
                }
            } catch (InvalidAlgorithmParameterException e5) {
                e = e5;
                throw new SignatureException("Failed to sign using " + m6251a, e);
            } catch (InvalidKeyException e6) {
                throw new InvalidKeyException("Failed to sign using " + m6251a, e6);
            } catch (SignatureException e7) {
                e = e7;
                throw new SignatureException("Failed to sign using " + m6251a, e);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static byte[] m5963a(byte[] bArr, ByteBuffer byteBuffer, List<X509Certificate> list, C0633a c0633a, C0633a c0633a2) {
        C0641i c0641i = new C0641i();
        c0641i.version = 1;
        X509Certificate x509Certificate = list.get(0);
        c0641i.sid = new C0640h(new C0637e(new C0623g(x509Certificate.getIssuerX500Principal().getEncoded()), x509Certificate.getSerialNumber()));
        c0641i.digestAlgorithm = c0633a;
        c0641i.signatureAlgorithm = c0633a2;
        c0641i.signature = ByteBuffer.wrap(bArr);
        C0639g c0639g = new C0639g();
        c0639g.certificates = new ArrayList(list.size());
        Iterator<X509Certificate> it = list.iterator();
        while (it.hasNext()) {
            c0639g.certificates.add(new C0623g(it.next().getEncoded()));
        }
        c0639g.version = 1;
        c0639g.digestAlgorithms = Collections.singletonList(c0633a);
        c0639g.encapContentInfo = new C0636d("1.2.840.113549.1.7.1");
        c0639g.encapContentInfo.content = byteBuffer;
        c0639g.signerInfos = Collections.singletonList(c0641i);
        C0635c c0635c = new C0635c();
        c0635c.contentType = "1.2.840.113549.1.7.2";
        c0635c.content = new C0623g(C0620d.m6164c(c0639g));
        return C0620d.m6164c(c0635c);
    }

    /* renamed from: a */
    public static byte[] m5961a(Map<EnumC0607g, byte[]> map) {
        for (EnumC0607g enumC0607g : V4_CONTENT_DIGEST_ALGORITHMS) {
            if (map.containsKey(enumC0607g)) {
                return map.get(enumC0607g);
            }
        }
        return null;
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$e */
    public static class e extends C0591b {

        /* renamed from: d */
        public final List<a> f4128d;

        /* renamed from: e */
        public C0680g f4129e;

        /* renamed from: f */
        private final List<C0675d.e> f4130f;

        /* renamed from: g */
        private final List<C0675d.e> f4131g;

        public e(int i) {
            super(i);
            this.f4129e = null;
            this.f4128d = new ArrayList();
            this.f4131g = new ArrayList();
            this.f4130f = new ArrayList();
        }

        @Override // com.p065b.p066a.p068b.p069a.C0591b
        /* renamed from: a */
        public boolean mo5855a() {
            if (!this.f4130f.isEmpty()) {
                return true;
            }
            if (!this.f4128d.isEmpty()) {
                Iterator<a> it = this.f4128d.iterator();
                while (it.hasNext()) {
                    if (it.next().mo5930a()) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // com.p065b.p066a.p068b.p069a.C0591b
        /* renamed from: b */
        public boolean mo5856b() {
            if (!this.f4131g.isEmpty()) {
                return true;
            }
            if (!this.f4128d.isEmpty()) {
                Iterator<a> it = this.f4128d.iterator();
                while (it.hasNext()) {
                    if (it.next().mo5931b()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: a */
        public void m6018a(C0675d.d dVar, Object... objArr) {
            this.f4130f.add(new C0675d.e(dVar, objArr));
        }

        /* renamed from: b */
        public void m6019b(C0675d.d dVar, Object... objArr) {
            this.f4131g.add(new C0675d.e(dVar, objArr));
        }

        @Override // com.p065b.p066a.p068b.p069a.C0591b
        /* renamed from: c */
        public List<C0675d.e> mo5857c() {
            return this.f4130f;
        }

        /* compiled from: ApkSigningBlockUtils.java */
        /* renamed from: com.b.a.b.a.d$e$a */
        public static class a extends C0595c {

            /* renamed from: g */
            public int f4134g;

            /* renamed from: h */
            public int f4135h;

            /* renamed from: j */
            public byte[] f4137j;

            /* renamed from: k */
            public C0680g f4138k;

            /* renamed from: f */
            public List<b> f4133f = new ArrayList();

            /* renamed from: l */
            public Map<EnumC0607g, byte[]> f4139l = new HashMap();

            /* renamed from: i */
            public List<c> f4136i = new ArrayList();

            /* renamed from: m */
            public Map<EnumC0609i, byte[]> f4140m = new HashMap();

            /* renamed from: e */
            public List<C3330a> f4132e = new ArrayList();

            /* renamed from: o */
            private final List<C0675d.e> f4142o = new ArrayList();

            /* renamed from: n */
            private final List<C0675d.e> f4141n = new ArrayList();

            /* renamed from: a */
            public void m6020a(C0675d.d dVar, Object... objArr) {
                this.f4141n.add(new C0675d.e(dVar, objArr));
            }

            /* renamed from: b */
            public void m6021b(C0675d.d dVar, Object... objArr) {
                this.f4142o.add(new C0675d.e(dVar, objArr));
            }

            @Override // com.p065b.p066a.p068b.p069a.C0595c
            /* renamed from: a */
            public boolean mo5930a() {
                return !this.f4141n.isEmpty();
            }

            @Override // com.p065b.p066a.p068b.p069a.C0595c
            /* renamed from: b */
            public boolean mo5931b() {
                return !this.f4142o.isEmpty();
            }

            @Override // com.p065b.p066a.p068b.p069a.C0595c
            /* renamed from: c */
            public List<C0675d.e> mo5932c() {
                return this.f4141n;
            }

            @Override // com.p065b.p066a.p068b.p069a.C0595c
            /* renamed from: d */
            public List<C0675d.e> mo5933d() {
                return this.f4142o;
            }

            /* compiled from: ApkSigningBlockUtils.java */
            /* renamed from: com.b.a.b.a.d$e$a$b */
            public static class b {

                /* renamed from: a */
                private final int f4145a;

                /* renamed from: b */
                private final byte[] f4146b;

                public b(int i, byte[] bArr) {
                    this.f4145a = i;
                    this.f4146b = bArr;
                }

                /* renamed from: a */
                public int m6023a() {
                    return this.f4145a;
                }

                /* renamed from: b */
                public byte[] m6024b() {
                    return this.f4146b;
                }
            }

            /* compiled from: ApkSigningBlockUtils.java */
            /* renamed from: com.b.a.b.a.d$e$a$c */
            public static class c {

                /* renamed from: a */
                private final int f4147a;

                /* renamed from: b */
                private final byte[] f4148b;

                public c(int i, byte[] bArr) {
                    this.f4147a = i;
                    this.f4148b = bArr;
                }

                /* renamed from: a */
                public int m6025a() {
                    return this.f4147a;
                }
            }

            /* compiled from: ApkSigningBlockUtils.java */
            /* renamed from: com.b.a.b.a.d$e$a$a, reason: collision with other inner class name */
            public static class C3330a {

                /* renamed from: a */
                private final int f4143a;

                /* renamed from: b */
                private final byte[] f4144b;

                public C3330a(int i, byte[] bArr) {
                    this.f4143a = i;
                    this.f4144b = (byte[]) bArr.clone();
                }

                /* renamed from: a */
                public int m6022a() {
                    return this.f4143a;
                }
            }
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$i */
    public static class i extends C0606f {
        public i(EnumC0609i enumC0609i, byte[] bArr) {
            super(enumC0609i, bArr);
        }
    }

    /* compiled from: ApkSigningBlockUtils.java */
    /* renamed from: com.b.a.b.a.d$h */
    public static class h {

        /* renamed from: a */
        public final Map<EnumC0607g, byte[]> f4155a;

        /* renamed from: b */
        public final C0652k<byte[], Integer> f4156b;

        public h(C0652k<byte[], Integer> c0652k, Map<EnumC0607g, byte[]> map) {
            this.f4156b = c0652k;
            this.f4155a = map;
        }
    }
}
