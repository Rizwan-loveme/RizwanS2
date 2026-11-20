package com.p065b.p066a;

import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0591b;
import com.p065b.p066a.p068b.p069a.C0595c;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.C0611k;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p069a.p070a.AbstractC0590d;
import com.p065b.p066a.p068b.p069a.p071b.AbstractC0594c;
import com.p065b.p066a.p068b.p069a.p072c.AbstractC0597b;
import com.p065b.p066a.p068b.p069a.p073d.C0599a;
import com.p065b.p066a.p068b.p069a.p073d.C0600b;
import com.p065b.p066a.p068b.p069a.p074e.AbstractC0604b;
import com.p065b.p066a.p068b.p083i.C0664a;
import com.p065b.p066a.p068b.p083i.C0666c;
import com.p065b.p066a.p084c.AbstractC0672d;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import com.p065b.p066a.p085d.C0676a;
import java.nio.ByteBuffer;
import java.p209io.File;
import java.p209io.RandomAccessFile;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ApkVerifier.java */
/* renamed from: com.b.a.d */
/* loaded from: classes.dex */
public class C0675d {
    private static final Map<Integer, String> SUPPORTED_APK_SIG_SCHEME_NAMES = m6351b();

    /* renamed from: a */
    private final InterfaceC0671c f4302a;

    /* renamed from: b */
    private final File f4303b;

    /* renamed from: c */
    private final int f4304c;

    /* renamed from: d */
    private final Integer f4305d;

    /* renamed from: e */
    private final File f4306e;

    /* renamed from: a */
    private static int m6341a(int i) {
        return i >= 30 ? 2 : 1;
    }

    /* renamed from: b */
    private static Map<Integer, String> m6351b() {
        HashMap hashMap = new HashMap(2);
        hashMap.put(2, "APK Signature Scheme v2");
        hashMap.put(3, "APK Signature Scheme v3");
        return hashMap;
    }

    private C0675d(File file, InterfaceC0671c interfaceC0671c, File file2, Integer num, int i) {
        this.f4303b = file;
        this.f4302a = interfaceC0671c;
        this.f4306e = file2;
        this.f4305d = num;
        this.f4304c = i;
    }

    /* renamed from: a */
    public f m6353a() {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            InterfaceC0671c interfaceC0671c = this.f4302a;
            if (interfaceC0671c == null) {
                if (this.f4303b != null) {
                    randomAccessFile = new RandomAccessFile(this.f4303b, "r");
                    try {
                        interfaceC0671c = AbstractC0672d.m6336a(randomAccessFile, 0L, randomAccessFile.length());
                        randomAccessFile2 = randomAccessFile;
                    } catch (Throwable th) {
                        th = th;
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("APK not provided");
                }
            }
            f m6342a = m6342a(interfaceC0671c);
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return m6342a;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private f m6342a(InterfaceC0671c interfaceC0671c) {
        ByteBuffer byteBuffer;
        List<C0664a> m5880a;
        int m5776d;
        int m6341a;
        X509Certificate x509Certificate;
        C0664a c0664a;
        int i;
        C0598d.e m5995b;
        File file;
        int i2 = this.f4304c;
        try {
            AbstractC0581c.c m5771a = AbstractC0581c.m5771a(interfaceC0671c);
            int m6350b = m6350b(interfaceC0671c, m5771a);
            f fVar = new f();
            HashMap hashMap = new HashMap();
            Map<Integer, String> m6352b = m6352b(i2);
            HashSet hashSet = new HashSet(2);
            if (i2 >= 24) {
                InterfaceC0673e interfaceC0673e = InterfaceC0673e.SINGLE_THREADED;
                if (i2 >= 33) {
                    try {
                        C0598d.e m5995b2 = new C0600b.a(interfaceC0671c, m5771a, Math.max(m6350b, 33), i2).m6005a(interfaceC0673e).m6003a(462663009).m6008a().m5995b();
                        hashSet.add(31);
                        int i3 = m5995b2.f4128d.isEmpty() ? 0 : Integer.MAX_VALUE;
                        try {
                            i = i3;
                            for (C0598d.e.a aVar : m5995b2.f4128d) {
                                try {
                                    i = i > aVar.f4135h ? aVar.f4135h : i;
                                } catch (C0598d.f e2) {
                                }
                            }
                            fVar.m6370a(m5995b2);
                            hashMap.put(31, m6344a(m5995b2));
                        } catch (C0598d.f e3) {
                            i = i3;
                        }
                    } catch (C0598d.f e4) {
                        i = 0;
                    }
                    if (fVar.m6379a()) {
                        return fVar;
                    }
                } else {
                    i = 0;
                }
                if (m6350b < 33 || hashSet.isEmpty()) {
                    try {
                        C0600b.a m6003a = new C0600b.a(interfaceC0671c, m5771a, Math.max(m6350b, 28), i2).m6005a(interfaceC0673e).m6003a(C0599a.APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
                        if (i > 0) {
                            try {
                                m6003a.m6009b(i);
                            } catch (C0598d.f e5) {
                                if (hashSet.contains(31)) {
                                }
                                if (fVar.m6379a()) {
                                }
                                if (m6350b >= 28) {
                                }
                                try {
                                    try {
                                        C0598d.e m5939a = AbstractC0597b.m5939a(interfaceC0673e, interfaceC0671c, m5771a, m6352b, hashSet, Math.max(m6350b, 24), i2);
                                        hashSet.add(2);
                                        fVar.m6370a(m5939a);
                                        hashMap.put(2, m6344a(m5939a));
                                    } catch (C0598d.f e6) {
                                    }
                                } catch (C0598d.f e7) {
                                }
                                if (fVar.m6379a()) {
                                }
                                file = this.f4306e;
                                if (file != null) {
                                }
                                if (i2 >= 26) {
                                }
                                m5880a = AbstractC0594c.m5880a(interfaceC0671c, m5771a);
                                if (m6350b >= 24) {
                                }
                                fVar.m6368a(AbstractC0594c.m5876a(interfaceC0671c, m5771a, m6352b, hashSet, m6350b, i2));
                                hashMap.put(1, m6345a(m5880a, interfaceC0671c, m5771a));
                                if (fVar.m6379a()) {
                                }
                            }
                        }
                        m5995b = m6003a.m6008a().m5995b();
                    } catch (C0598d.f e8) {
                    }
                    try {
                        hashSet.add(3);
                        fVar.m6370a(m5995b);
                        hashMap.put(3, m6344a(m5995b));
                    } catch (C0598d.f e9) {
                        if (hashSet.contains(31)) {
                            fVar.m6378a(d.V31_BLOCK_FOUND_WITHOUT_V3_BLOCK, new Object[0]);
                        }
                        if (fVar.m6379a()) {
                        }
                        if (m6350b >= 28) {
                        }
                        C0598d.e m5939a2 = AbstractC0597b.m5939a(interfaceC0673e, interfaceC0671c, m5771a, m6352b, hashSet, Math.max(m6350b, 24), i2);
                        hashSet.add(2);
                        fVar.m6370a(m5939a2);
                        hashMap.put(2, m6344a(m5939a2));
                        if (fVar.m6379a()) {
                        }
                        file = this.f4306e;
                        if (file != null) {
                        }
                        if (i2 >= 26) {
                        }
                        m5880a = AbstractC0594c.m5880a(interfaceC0671c, m5771a);
                        if (m6350b >= 24) {
                        }
                        fVar.m6368a(AbstractC0594c.m5876a(interfaceC0671c, m5771a, m6352b, hashSet, m6350b, i2));
                        hashMap.put(1, m6345a(m5880a, interfaceC0671c, m5771a));
                        if (fVar.m6379a()) {
                        }
                    }
                    if (fVar.m6379a()) {
                        return fVar;
                    }
                }
                if (m6350b >= 28 || hashSet.isEmpty()) {
                    C0598d.e m5939a22 = AbstractC0597b.m5939a(interfaceC0673e, interfaceC0671c, m5771a, m6352b, hashSet, Math.max(m6350b, 24), i2);
                    hashSet.add(2);
                    fVar.m6370a(m5939a22);
                    hashMap.put(2, m6344a(m5939a22));
                    if (fVar.m6379a()) {
                        return fVar;
                    }
                }
                file = this.f4306e;
                if (file != null) {
                    C0598d.e m6052a = AbstractC0604b.m6052a(interfaceC0671c, file);
                    hashSet.add(4);
                    fVar.m6370a(m6052a);
                    if (fVar.m6379a()) {
                        return fVar;
                    }
                }
            }
            if (i2 >= 26) {
                ByteBuffer m6343a = m6343a(interfaceC0671c, m5771a);
                int m5775c = AbstractC0581c.m5775c(m6343a.slice());
                if (m5775c > 1 && hashSet.isEmpty()) {
                    fVar.m6378a(d.NO_SIG_FOR_TARGET_SANDBOX_VERSION, Integer.valueOf(m5775c));
                }
                byteBuffer = m6343a;
            } else {
                byteBuffer = null;
            }
            m5880a = AbstractC0594c.m5880a(interfaceC0671c, m5771a);
            if (m6350b >= 24 || hashSet.isEmpty()) {
                fVar.m6368a(AbstractC0594c.m5876a(interfaceC0671c, m5771a, m6352b, hashSet, m6350b, i2));
                hashMap.put(1, m6345a(m5880a, interfaceC0671c, m5771a));
            }
            if (fVar.m6379a()) {
                return fVar;
            }
            try {
                Iterator<C0664a> it = m5880a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        c0664a = it.next();
                        if (AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME.equals(c0664a.m6287h())) {
                            break;
                        }
                    } else {
                        c0664a = null;
                        break;
                    }
                }
                if (c0664a != null) {
                    fVar.m6369a(AbstractC0590d.m5847a(interfaceC0671c, m5771a, C0666c.m6298b(interfaceC0671c, c0664a, m5771a.m6355a()), hashMap, Math.max(m6350b, 30), i2));
                }
            } catch (C0611k e10) {
                fVar.m6381b(d.SOURCE_STAMP_SIG_MISSING, new Object[0]);
            } catch (C0676a e11) {
                throw new C0579a("Failed to read APK", e11);
            }
            if (fVar.m6379a()) {
                return fVar;
            }
            if (fVar.m6388i() && fVar.m6389j()) {
                ArrayList arrayList = new ArrayList(fVar.m6383d());
                ArrayList arrayList2 = new ArrayList(fVar.m6384e());
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f.b bVar = (f.b) it2.next();
                    try {
                        arrayList3.add(new c(bVar.m6400b().getEncoded()));
                    } catch (CertificateEncodingException e12) {
                        throw new IllegalStateException("Failed to encode JAR signer " + bVar.m6402d() + " certs", e12);
                    }
                }
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    f.c cVar = (f.c) it3.next();
                    try {
                        arrayList4.add(new c(cVar.m6408b().getEncoded()));
                    } catch (CertificateEncodingException e13) {
                        throw new IllegalStateException("Failed to encode APK Signature Scheme v2 signer (index: " + cVar.m6411e() + ") certs", e13);
                    }
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= arrayList3.size()) {
                        break;
                    }
                    if (arrayList4.contains((c) arrayList3.get(i5))) {
                        i4 = i5 + 1;
                    } else {
                        ((f.b) arrayList.get(i5)).m6397a(d.V2_SIG_MISSING, new Object[0]);
                        break;
                    }
                }
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= arrayList4.size()) {
                        break;
                    }
                    if (arrayList3.contains((c) arrayList4.get(i7))) {
                        i6 = i7 + 1;
                    } else {
                        ((f.c) arrayList2.get(i7)).m6405a(d.JAR_SIG_MISSING, new Object[0]);
                        break;
                    }
                }
            }
            if (fVar.m6391l() && (fVar.m6388i() || fVar.m6389j())) {
                C0680g m6382c = fVar.m6382c();
                if (fVar.m6388i()) {
                    List<f.b> m6383d = fVar.m6383d();
                    if (m6383d.size() != 1) {
                        fVar.m6378a(d.V3_SIG_MULTIPLE_PAST_SIGNERS, new Object[0]);
                    }
                    x509Certificate = (X509Certificate) m6383d.get(0).f4353a.get(0);
                } else {
                    List<f.c> m6384e = fVar.m6384e();
                    if (m6384e.size() != 1) {
                        fVar.m6378a(d.V3_SIG_MULTIPLE_PAST_SIGNERS, new Object[0]);
                    }
                    x509Certificate = (X509Certificate) m6384e.get(0).f4359a.get(0);
                }
                if (m6382c == null) {
                    List<f.d> m6386g = fVar.m6386g();
                    if (m6386g.size() != 1) {
                        fVar.m6378a(d.V3_SIG_MULTIPLE_SIGNERS, new Object[0]);
                    }
                    try {
                        if (!Arrays.equals(x509Certificate.getEncoded(), ((X509Certificate) m6386g.get(0).f4364a.get(0)).getEncoded())) {
                            fVar.m6378a(d.V3_SIG_PAST_SIGNERS_MISMATCH, new Object[0]);
                        }
                    } catch (CertificateEncodingException e14) {
                        throw new RuntimeException("Failed to encode APK Signature Scheme v3 signer cert", e14);
                    }
                } else {
                    try {
                        if (m6382c.m6490a(x509Certificate).m6492b() != 1) {
                            fVar.m6378a(d.V3_SIG_PAST_SIGNERS_MISMATCH, new Object[0]);
                        }
                    } catch (IllegalArgumentException e15) {
                        fVar.m6378a(d.V3_SIG_PAST_SIGNERS_MISMATCH, new Object[0]);
                    }
                }
            }
            if (fVar.m6392m()) {
                List<f.e> m6387h = fVar.m6387h();
                List<C0598d.e.a.b> m6420a = m6387h.get(0).m6420a();
                if (m6420a.size() != 1) {
                    fVar.m6378a(d.V4_SIG_V2_V3_DIGESTS_MISMATCH, new Object[0]);
                }
                byte[] m6024b = m6420a.get(0).m6024b();
                if (fVar.m6391l()) {
                    if (m6387h.size() != (fVar.m6390k() ? 2 : 1)) {
                        fVar.m6378a(d.V4_SIG_MULTIPLE_SIGNERS, new Object[0]);
                    }
                    m6347a(fVar.m6386g(), m6387h.get(0).f4372a, m6024b, fVar);
                    if (fVar.m6390k()) {
                        m6347a(fVar.m6385f(), m6387h.get(1).f4372a, m6024b, fVar);
                    }
                } else if (fVar.m6389j()) {
                    if (m6387h.size() != 1) {
                        fVar.m6378a(d.V4_SIG_MULTIPLE_SIGNERS, new Object[0]);
                    }
                    List<f.c> m6384e2 = fVar.m6384e();
                    if (m6384e2.size() != 1) {
                        fVar.m6378a(d.V4_SIG_MULTIPLE_SIGNERS, new Object[0]);
                    }
                    m6346a((List<X509Certificate>) m6387h.get(0).f4372a, (List<X509Certificate>) m6384e2.get(0).f4359a, fVar);
                    if (!Arrays.equals(m6024b, m6349a(m6384e2.get(0).m6409c()))) {
                        fVar.m6378a(d.V4_SIG_V2_V3_DIGESTS_MISMATCH, new Object[0]);
                    }
                } else {
                    throw new RuntimeException("V4 signature must be also verified with V2/V3");
                }
            }
            if (byteBuffer == null) {
                try {
                    byteBuffer = m6343a(interfaceC0671c, m5771a);
                } catch (C0579a e16) {
                }
            }
            if (byteBuffer != null && (m6341a = m6341a((m5776d = AbstractC0581c.m5776d(byteBuffer.slice())))) > 1 && i2 >= m5776d && (m6341a == 2 ? !fVar.m6389j() : m6341a == 3) && !fVar.m6391l() && !fVar.m6390k()) {
                fVar.m6378a(d.MIN_SIG_SCHEME_FOR_TARGET_SDK_NOT_MET, Integer.valueOf(m5776d), Integer.valueOf(m6341a));
            }
            if (fVar.m6379a()) {
                return fVar;
            }
            fVar.m6377n();
            if (!fVar.m6390k()) {
                if (!fVar.m6391l()) {
                    if (fVar.m6389j()) {
                        Iterator<f.c> it4 = fVar.m6384e().iterator();
                        while (it4.hasNext()) {
                            fVar.m6376a(it4.next().m6408b());
                        }
                    } else if (fVar.m6388i()) {
                        Iterator<f.b> it5 = fVar.m6383d().iterator();
                        while (it5.hasNext()) {
                            fVar.m6376a(it5.next().m6400b());
                        }
                    } else {
                        throw new RuntimeException("APK verified, but has not verified using any of v1, v2 or v3 schemes");
                    }
                } else {
                    fVar.m6376a(fVar.m6386g().get(r0.size() - 1).m6415b());
                }
            } else {
                fVar.m6376a(fVar.m6385f().get(r0.size() - 1).m6415b());
            }
            return fVar;
        } catch (C0676a e17) {
            throw new C0579a("Malformed APK: not a ZIP archive", e17);
        }
    }

    /* renamed from: b */
    private int m6350b(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        Integer num = this.f4305d;
        if (num != null) {
            if (num.intValue() < 0) {
                throw new IllegalArgumentException("minSdkVersion must not be negative: " + this.f4305d);
            }
            Integer num2 = this.f4305d;
            if (num2 != null && num2.intValue() > this.f4304c) {
                throw new IllegalArgumentException("minSdkVersion (" + this.f4305d + ") > maxSdkVersion (" + this.f4304c + ")");
            }
            return this.f4305d.intValue();
        }
        int m5774b = AbstractC0581c.m5774b(m6343a(interfaceC0671c, cVar).slice());
        if (m5774b <= this.f4304c) {
            return m5774b;
        }
        throw new IllegalArgumentException("minSdkVersion from APK (" + m5774b + ") > maxSdkVersion (" + this.f4304c + ")");
    }

    /* renamed from: b */
    private static Map<Integer, String> m6352b(int i) {
        if (i >= 28) {
            return SUPPORTED_APK_SIG_SCHEME_NAMES;
        }
        if (i >= 24) {
            HashMap hashMap = new HashMap(1);
            hashMap.put(2, SUPPORTED_APK_SIG_SCHEME_NAMES.get(2));
            return hashMap;
        }
        return Collections.emptyMap();
    }

    /* renamed from: a */
    private static void m6347a(List<f.d> list, List<X509Certificate> list2, byte[] bArr, f fVar) {
        if (list.size() != 1) {
            fVar.m6378a(d.V4_SIG_MULTIPLE_SIGNERS, new Object[0]);
        }
        m6346a(list2, (List<X509Certificate>) list.get(0).f4364a, fVar);
        if (Arrays.equals(bArr, m6349a(list.get(0).m6416c()))) {
            return;
        }
        fVar.m6378a(d.V4_SIG_V2_V3_DIGESTS_MISMATCH, new Object[0]);
    }

    /* renamed from: a */
    private static void m6346a(List<X509Certificate> list, List<X509Certificate> list2, f fVar) {
        try {
            if (Arrays.equals(list2.get(0).getEncoded(), list.get(0).getEncoded())) {
                return;
            }
            fVar.m6378a(d.V4_SIG_V2_V3_SIGNERS_MISMATCH, new Object[0]);
        } catch (CertificateEncodingException e2) {
            throw new RuntimeException("Failed to encode APK signer cert", e2);
        }
    }

    /* renamed from: a */
    private static byte[] m6349a(List<C0598d.e.a.b> list) {
        HashMap hashMap = new HashMap();
        m6348a(list, hashMap);
        return C0598d.m5961a(hashMap);
    }

    /* renamed from: a */
    private static Map<EnumC0607g, byte[]> m6344a(C0598d.e eVar) {
        HashMap hashMap = new HashMap();
        Iterator<C0598d.e.a> it = eVar.f4128d.iterator();
        while (it.hasNext()) {
            m6348a(it.next().f4133f, hashMap);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<EnumC0607g, byte[]> m6345a(List<C0664a> list, InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        C0664a c0664a;
        EnumMap enumMap = new EnumMap(EnumC0607g.class);
        Iterator<C0664a> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                c0664a = it.next();
                if ("META-INF/MANIFEST.MF".equals(c0664a.m6287h())) {
                    break;
                }
            } else {
                c0664a = null;
                break;
            }
        }
        if (c0664a == null) {
            return enumMap;
        }
        try {
            enumMap.put((EnumMap) EnumC0607g.SHA256, (EnumC0607g) AbstractC0581c.m5773a(C0666c.m6298b(interfaceC0671c, c0664a, cVar.m6355a())));
            return enumMap;
        } catch (C0676a e2) {
            throw new C0579a("Failed to read APK", e2);
        }
    }

    /* renamed from: a */
    private static void m6348a(List<C0598d.e.a.b> list, Map<EnumC0607g, byte[]> map) {
        for (C0598d.e.a.b bVar : list) {
            EnumC0609i m6078a = EnumC0609i.m6078a(bVar.m6023a());
            if (m6078a != null) {
                map.put(m6078a.m6080a(), bVar.m6024b());
            }
        }
    }

    /* renamed from: a */
    private static ByteBuffer m6343a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        try {
            return C0578a.m5749a(AbstractC0594c.m5880a(interfaceC0671c, cVar), interfaceC0671c.mo6238b(0L, cVar.m6355a()));
        } catch (C0676a e2) {
            throw new C0579a("Failed to read AndroidManifest.xml", e2);
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.a.d$f */
    public static class f {

        /* renamed from: c */
        private C0680g f4330c;

        /* renamed from: d */
        private a f4331d;

        /* renamed from: e */
        private boolean f4332e;

        /* renamed from: l */
        private boolean f4339l;

        /* renamed from: m */
        private boolean f4340m;

        /* renamed from: n */
        private boolean f4341n;

        /* renamed from: o */
        private boolean f4342o;

        /* renamed from: p */
        private boolean f4343p;

        /* renamed from: q */
        private boolean f4344q;

        /* renamed from: s */
        private boolean f4346s;

        /* renamed from: a */
        private final List<e> f4328a = new ArrayList();

        /* renamed from: r */
        private final List<e> f4345r = new ArrayList();

        /* renamed from: b */
        private final List<X509Certificate> f4329b = new ArrayList();

        /* renamed from: g */
        private final List<b> f4334g = new ArrayList();

        /* renamed from: f */
        private final List<b> f4333f = new ArrayList();

        /* renamed from: h */
        private final List<c> f4335h = new ArrayList();

        /* renamed from: j */
        private final List<d> f4337j = new ArrayList();

        /* renamed from: i */
        private final List<d> f4336i = new ArrayList();

        /* renamed from: k */
        private final List<e> f4338k = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public void m6377n() {
            this.f4339l = true;
        }

        /* renamed from: i */
        public boolean m6388i() {
            return this.f4340m;
        }

        /* renamed from: j */
        public boolean m6389j() {
            return this.f4341n;
        }

        /* renamed from: l */
        public boolean m6391l() {
            return this.f4343p;
        }

        /* renamed from: k */
        public boolean m6390k() {
            return this.f4342o;
        }

        /* renamed from: m */
        public boolean m6392m() {
            return this.f4344q;
        }

        /* renamed from: b */
        public List<X509Certificate> m6380b() {
            return this.f4329b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m6376a(X509Certificate x509Certificate) {
            this.f4329b.add(x509Certificate);
        }

        /* renamed from: d */
        public List<b> m6383d() {
            return this.f4334g;
        }

        /* renamed from: e */
        public List<c> m6384e() {
            return this.f4335h;
        }

        /* renamed from: g */
        public List<d> m6386g() {
            return this.f4337j;
        }

        /* renamed from: f */
        public List<d> m6385f() {
            return this.f4336i;
        }

        /* renamed from: h */
        public List<e> m6387h() {
            return this.f4338k;
        }

        /* renamed from: c */
        public C0680g m6382c() {
            return this.f4330c;
        }

        /* renamed from: a */
        void m6378a(d dVar, Object... objArr) {
            this.f4328a.add(new e(dVar, objArr));
        }

        /* renamed from: b */
        void m6381b(d dVar, Object... objArr) {
            this.f4345r.add(new e(dVar, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m6368a(AbstractC0594c.d dVar) {
            this.f4340m = dVar.f4030c;
            this.f4328a.addAll(dVar.m5899a());
            this.f4345r.addAll(dVar.m5900b());
            Iterator<AbstractC0594c.d.a> it = dVar.f4029b.iterator();
            while (it.hasNext()) {
                this.f4334g.add(new b(it.next()));
            }
            Iterator<AbstractC0594c.d.a> it2 = dVar.f4028a.iterator();
            while (it2.hasNext()) {
                this.f4333f.add(new b(it2.next()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m6369a(C0591b c0591b) {
            if (c0591b.f4013b == 0) {
                this.f4332e = c0591b.f4014c;
                if (c0591b.f4012a.isEmpty()) {
                    return;
                }
                this.f4331d = new a(c0591b.f4012a.get(0));
                return;
            }
            throw new IllegalArgumentException("Unknown ApkSigResult Signing Block Scheme Id " + c0591b.f4013b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public void m6370a(C0598d.e eVar) {
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            int i = eVar.f4013b;
            if (i == 0) {
                this.f4332e = eVar.f4014c;
                if (!eVar.f4128d.isEmpty()) {
                    this.f4331d = new a(eVar.f4128d.get(0));
                    return;
                }
                return;
            }
            if (i == 31) {
                this.f4342o = eVar.f4014c;
                Iterator<C0598d.e.a> it = eVar.f4128d.iterator();
                while (it.hasNext()) {
                    this.f4336i.add(new d(it.next()));
                }
                this.f4330c = eVar.f4129e;
                return;
            }
            if (i == 2) {
                this.f4341n = eVar.f4014c;
                Iterator<C0598d.e.a> it2 = eVar.f4128d.iterator();
                while (it2.hasNext()) {
                    this.f4335h.add(new c(it2.next()));
                }
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    this.f4344q = eVar.f4014c;
                    Iterator<C0598d.e.a> it3 = eVar.f4128d.iterator();
                    while (it3.hasNext()) {
                        this.f4338k.add(new e(it3.next()));
                    }
                    return;
                }
                throw new IllegalArgumentException("Unknown Signing Block Scheme Id");
            }
            this.f4343p = eVar.f4014c;
            Iterator<C0598d.e.a> it4 = eVar.f4128d.iterator();
            while (it4.hasNext()) {
                this.f4337j.add(new d(it4.next()));
            }
            if (this.f4330c == null) {
                this.f4330c = eVar.f4129e;
            }
        }

        /* renamed from: a */
        public boolean m6379a() {
            if (!this.f4328a.isEmpty()) {
                return true;
            }
            if (this.f4346s && !this.f4345r.isEmpty()) {
                return true;
            }
            if (!this.f4334g.isEmpty()) {
                for (b bVar : this.f4334g) {
                    if (bVar.m6399a()) {
                        return true;
                    }
                    if (this.f4346s && !bVar.m6403e().isEmpty()) {
                        return true;
                    }
                }
            }
            if (!this.f4335h.isEmpty()) {
                for (c cVar : this.f4335h) {
                    if (cVar.m6407a()) {
                        return true;
                    }
                    if (this.f4346s && !cVar.m6412f().isEmpty()) {
                        return true;
                    }
                }
            }
            if (!this.f4337j.isEmpty()) {
                for (d dVar : this.f4337j) {
                    if (dVar.m6414a()) {
                        return true;
                    }
                    if (this.f4346s && !dVar.m6418e().isEmpty()) {
                        return true;
                    }
                }
            }
            a aVar = this.f4331d;
            if (aVar != null) {
                if (aVar.m6393a()) {
                    return true;
                }
                if (this.f4346s && !this.f4331d.m6394b().isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        /* compiled from: ApkVerifier.java */
        /* renamed from: com.b.a.d$f$b */
        public static class b {

            /* renamed from: a */
            private final List<X509Certificate> f4353a;

            /* renamed from: b */
            private final List<e> f4354b;

            /* renamed from: c */
            private final String f4355c;

            /* renamed from: d */
            private final String f4356d;

            /* renamed from: e */
            private final String f4357e;

            /* renamed from: f */
            private final List<e> f4358f;

            private b(AbstractC0594c.d.a aVar) {
                this.f4355c = aVar.f4034b;
                this.f4353a = aVar.f4033a;
                this.f4356d = aVar.f4035c;
                this.f4357e = aVar.f4036d;
                this.f4354b = aVar.m5907a();
                this.f4358f = aVar.m5908b();
            }

            /* renamed from: d */
            public String m6402d() {
                return this.f4355c;
            }

            /* renamed from: b */
            public X509Certificate m6400b() {
                if (this.f4353a.isEmpty()) {
                    return null;
                }
                return this.f4353a.get(0);
            }

            /* renamed from: a */
            public boolean m6399a() {
                return !this.f4354b.isEmpty();
            }

            /* renamed from: c */
            public List<e> m6401c() {
                return this.f4354b;
            }

            /* renamed from: e */
            public List<e> m6403e() {
                return this.f4358f;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m6397a(d dVar, Object... objArr) {
                this.f4354b.add(new e(dVar, objArr));
            }
        }

        /* compiled from: ApkVerifier.java */
        /* renamed from: com.b.a.d$f$c */
        public static class c {

            /* renamed from: a */
            private final List<X509Certificate> f4359a;

            /* renamed from: b */
            private final List<C0598d.e.a.b> f4360b;

            /* renamed from: c */
            private final List<e> f4361c;

            /* renamed from: d */
            private final int f4362d;

            /* renamed from: e */
            private final List<e> f4363e;

            private c(C0598d.e.a aVar) {
                this.f4362d = aVar.f4049c;
                this.f4359a = aVar.f4048b;
                this.f4361c = aVar.mo5932c();
                this.f4363e = aVar.mo5933d();
                this.f4360b = aVar.f4133f;
            }

            /* renamed from: e */
            public int m6411e() {
                return this.f4362d;
            }

            /* renamed from: b */
            public X509Certificate m6408b() {
                if (this.f4359a.isEmpty()) {
                    return null;
                }
                return this.f4359a.get(0);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public void m6405a(d dVar, Object... objArr) {
                this.f4361c.add(new e(dVar, objArr));
            }

            /* renamed from: a */
            public boolean m6407a() {
                return !this.f4361c.isEmpty();
            }

            /* renamed from: d */
            public List<e> m6410d() {
                return this.f4361c;
            }

            /* renamed from: f */
            public List<e> m6412f() {
                return this.f4363e;
            }

            /* renamed from: c */
            public List<C0598d.e.a.b> m6409c() {
                return this.f4360b;
            }
        }

        /* compiled from: ApkVerifier.java */
        /* renamed from: com.b.a.d$f$d */
        public static class d {

            /* renamed from: a */
            private final List<X509Certificate> f4364a;

            /* renamed from: b */
            private final List<C0598d.e.a.b> f4365b;

            /* renamed from: c */
            private final List<e> f4366c;

            /* renamed from: d */
            private final int f4367d;

            /* renamed from: e */
            private final int f4368e;

            /* renamed from: f */
            private final int f4369f;

            /* renamed from: g */
            private final boolean f4370g;

            /* renamed from: h */
            private final List<e> f4371h;

            private d(C0598d.e.a aVar) {
                boolean z;
                this.f4367d = aVar.f4049c;
                this.f4364a = aVar.f4048b;
                this.f4366c = aVar.mo5932c();
                this.f4371h = aVar.mo5933d();
                this.f4365b = aVar.f4133f;
                this.f4369f = aVar.f4135h;
                this.f4368e = aVar.f4134g;
                Iterator<C0598d.e.a.C3330a> it = aVar.f4132e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().m6022a() == -1029262406) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                this.f4370g = z;
            }

            /* renamed from: b */
            public X509Certificate m6415b() {
                if (this.f4364a.isEmpty()) {
                    return null;
                }
                return this.f4364a.get(0);
            }

            /* renamed from: a */
            public boolean m6414a() {
                return !this.f4366c.isEmpty();
            }

            /* renamed from: d */
            public List<e> m6417d() {
                return this.f4366c;
            }

            /* renamed from: e */
            public List<e> m6418e() {
                return this.f4371h;
            }

            /* renamed from: c */
            public List<C0598d.e.a.b> m6416c() {
                return this.f4365b;
            }
        }

        /* compiled from: ApkVerifier.java */
        /* renamed from: com.b.a.d$f$e */
        public static class e {

            /* renamed from: a */
            private final List<X509Certificate> f4372a;

            /* renamed from: b */
            private final List<C0598d.e.a.b> f4373b;

            /* renamed from: c */
            private final List<e> f4374c;

            /* renamed from: d */
            private final int f4375d;

            /* renamed from: e */
            private final List<e> f4376e;

            private e(C0598d.e.a aVar) {
                this.f4375d = aVar.f4049c;
                this.f4372a = aVar.f4048b;
                this.f4374c = aVar.mo5932c();
                this.f4376e = aVar.mo5933d();
                this.f4373b = aVar.f4133f;
            }

            /* renamed from: b */
            public List<e> m6421b() {
                return this.f4374c;
            }

            /* renamed from: a */
            public List<C0598d.e.a.b> m6420a() {
                return this.f4373b;
            }
        }

        /* compiled from: ApkVerifier.java */
        /* renamed from: com.b.a.d$f$a */
        public static class a {

            /* renamed from: a */
            private final List<X509Certificate> f4347a;

            /* renamed from: b */
            private final List<X509Certificate> f4348b;

            /* renamed from: c */
            private final List<e> f4349c;

            /* renamed from: d */
            private final EnumC3331a f4350d;

            /* renamed from: e */
            private final long f4351e;

            /* renamed from: f */
            private final List<e> f4352f;

            /* compiled from: ApkVerifier.java */
            /* renamed from: com.b.a.d$f$a$a, reason: collision with other inner class name */
            public enum EnumC3331a {
                STAMP_VERIFIED,
                STAMP_VERIFICATION_FAILED,
                CERT_DIGEST_MISMATCH,
                STAMP_MISSING,
                STAMP_NOT_VERIFIED,
                VERIFICATION_ERROR
            }

            private a(C0595c c0595c) {
                this.f4348b = c0595c.f4048b;
                this.f4347a = c0595c.f4047a;
                List<e> m6354a = a.m6354a(c0595c.mo5932c());
                this.f4349c = m6354a;
                List<e> m6354a2 = a.m6354a(c0595c.mo5933d());
                this.f4352f = m6354a2;
                if (m6354a.isEmpty() && m6354a2.isEmpty()) {
                    this.f4350d = EnumC3331a.STAMP_VERIFIED;
                } else {
                    this.f4350d = EnumC3331a.STAMP_VERIFICATION_FAILED;
                }
                this.f4351e = c0595c.f4050d;
            }

            a(EnumC3331a enumC3331a) {
                this.f4348b = Collections.emptyList();
                this.f4347a = Collections.emptyList();
                this.f4349c = Collections.emptyList();
                this.f4352f = Collections.emptyList();
                this.f4350d = enumC3331a;
                this.f4351e = 0L;
            }

            /* renamed from: a */
            public boolean m6393a() {
                return !this.f4349c.isEmpty();
            }

            /* renamed from: b */
            public List<e> m6394b() {
                return this.f4352f;
            }
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.a.d$d */
    public enum d {
        JAR_SIG_NO_SIGNATURES("No JAR signatures"),
        JAR_SIG_NO_SIGNED_ZIP_ENTRIES("No JAR entries covered by JAR signatures"),
        JAR_SIG_DUPLICATE_ZIP_ENTRY("Duplicate entry: %1$s"),
        JAR_SIG_DUPLICATE_MANIFEST_SECTION("Duplicate section in META-INF/MANIFEST.MF: %1$s"),
        JAR_SIG_UNNNAMED_MANIFEST_SECTION("Malformed META-INF/MANIFEST.MF: invidual section #%1$d does not have a name"),
        JAR_SIG_UNNNAMED_SIG_FILE_SECTION("Malformed %1$s: invidual section #%2$d does not have a name"),
        JAR_SIG_NO_MANIFEST("Missing META-INF/MANIFEST.MF"),
        JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST("%1$s entry referenced by META-INF/MANIFEST.MF not found in the APK"),
        JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST("No digest for %1$s in META-INF/MANIFEST.MF"),
        JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE("No digest for %1$s in %2$s"),
        JAR_SIG_ZIP_ENTRY_NOT_SIGNED("%1$s entry not signed"),
        JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH("Entries %1$s and %3$s are signed with different sets of signers : <%2$s> vs <%4$s>"),
        JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY("%2$s digest of %1$s does not match the digest specified in %3$s. Expected: <%5$s>, actual: <%4$s>"),
        JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY("%1$s digest of META-INF/MANIFEST.MF main section does not match the digest specified in %2$s. Expected: <%4$s>, actual: <%3$s>"),
        JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY("%2$s digest of META-INF/MANIFEST.MF section for %1$s does not match the digest specified in %3$s. Expected: <%5$s>, actual: <%4$s>"),
        JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE("%1$s does not specify digest of META-INF/MANIFEST.MF. This slows down verification."),
        JAR_SIG_NO_APK_SIG_STRIP_PROTECTION("APK is signed using APK Signature Scheme v2 but these signatures may be stripped without being detected because %1$s does not contain anti-stripping protections."),
        JAR_SIG_MISSING_FILE("Partial JAR signature. Found: %1$s, missing: %2$s"),
        JAR_SIG_VERIFY_EXCEPTION("Failed to verify JAR signature %1$s against %2$s: %3$s"),
        JAR_SIG_UNSUPPORTED_SIG_ALG("JAR signature %1$s uses digest algorithm %5$s and signature algorithm %6$s which is not supported on API Level(s) %4$s for which this APK is being verified"),
        JAR_SIG_PARSE_EXCEPTION("Failed to parse JAR signature %1$s: %2$s"),
        JAR_SIG_MALFORMED_CERTIFICATE("Malformed certificate in JAR signature %1$s: %2$s"),
        JAR_SIG_DID_NOT_VERIFY("JAR signature %1$s did not verify against %2$s"),
        JAR_SIG_NO_SIGNERS("JAR signature %1$s contains no signers"),
        JAR_SIG_DUPLICATE_SIG_FILE_SECTION("Duplicate section in %1$s: %2$s"),
        JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE("Malformed %1$s: missing Signature-Version attribute"),
        JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID("JAR signature %1$s references unknown APK signature scheme ID: %2$d"),
        JAR_SIG_MISSING_APK_SIG_REFERENCED("JAR signature %1$s indicates the APK is signed using %3$s but no such signature was found. Signature stripped?"),
        JAR_SIG_UNPROTECTED_ZIP_ENTRY("%1$s not protected by signature. Unauthorized modifications to this JAR entry will not be detected. Delete or move the entry outside of META-INF/."),
        JAR_SIG_MISSING("No JAR signature from this signer"),
        NO_SIG_FOR_TARGET_SANDBOX_VERSION("Missing APK Signature Scheme v2 signature required for target sandbox version %1$d"),
        MIN_SIG_SCHEME_FOR_TARGET_SDK_NOT_MET("Target SDK version %1$d requires a minimum of signature scheme v%2$d; the APK is not signed with this or a later signature scheme"),
        V2_SIG_MISSING("No APK Signature Scheme v2 signature from this signer"),
        V2_SIG_MALFORMED_SIGNERS("Malformed list of signers"),
        V2_SIG_MALFORMED_SIGNER("Malformed signer block"),
        V2_SIG_MALFORMED_PUBLIC_KEY("Malformed public key: %1$s"),
        V2_SIG_MALFORMED_CERTIFICATE("Malformed certificate #%2$d: %3$s"),
        V2_SIG_MALFORMED_SIGNATURE("Malformed APK Signature Scheme v2 signature record #%1$d"),
        V2_SIG_MALFORMED_DIGEST("Malformed APK Signature Scheme v2 digest record #%1$d"),
        V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE("Malformed additional attribute #%1$d"),
        V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID("APK Signature Scheme v2 signer: %1$s references unknown APK signature scheme ID: %2$d"),
        V2_SIG_MISSING_APK_SIG_REFERENCED("APK Signature Scheme v2 signature %1$s indicates the APK is signed using %2$s but no such signature was found. Signature stripped?"),
        V2_SIG_NO_SIGNERS("No signers in APK Signature Scheme v2 signature"),
        V2_SIG_UNKNOWN_SIG_ALGORITHM("Unknown signature algorithm: %1$#x"),
        V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE("Unknown additional attribute: ID %1$#x"),
        V2_SIG_VERIFY_EXCEPTION("Failed to verify %1$s signature: %2$s"),
        V2_SIG_DID_NOT_VERIFY("%1$s signature over signed-data did not verify"),
        V2_SIG_NO_SIGNATURES("No signatures"),
        V2_SIG_NO_SUPPORTED_SIGNATURES("No supported signatures: %1$s"),
        V2_SIG_NO_CERTIFICATES("No certificates"),
        V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD("Public key mismatch between certificate and signature record: <%1$s> vs <%2$s>"),
        V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS("Signature algorithms mismatch between signatures and digests records: %1$s vs %2$s"),
        V2_SIG_APK_DIGEST_DID_NOT_VERIFY("APK integrity check failed. %1$s digest mismatch. Expected: <%2$s>, actual: <%3$s>"),
        V3_SIG_MALFORMED_SIGNERS("Malformed list of signers"),
        V3_SIG_MALFORMED_SIGNER("Malformed signer block"),
        V3_SIG_MALFORMED_PUBLIC_KEY("Malformed public key: %1$s"),
        V3_SIG_MALFORMED_CERTIFICATE("Malformed certificate #%2$d: %3$s"),
        V3_SIG_MALFORMED_SIGNATURE("Malformed APK Signature Scheme v3 signature record #%1$d"),
        V3_SIG_MALFORMED_DIGEST("Malformed APK Signature Scheme v3 digest record #%1$d"),
        V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE("Malformed additional attribute #%1$d"),
        V3_SIG_NO_SIGNERS("No signers in APK Signature Scheme v3 signature"),
        V3_SIG_MULTIPLE_SIGNERS("Multiple APK Signature Scheme v3 signatures found for a single  platform version."),
        V3_SIG_MULTIPLE_PAST_SIGNERS("Multiple signatures found for pre-v3 signing with an APK  Signature Scheme v3 signer.  Only one allowed."),
        V3_SIG_PAST_SIGNERS_MISMATCH("v3 signer differs from v1/v2 signer without proper signing certificate lineage."),
        V3_SIG_UNKNOWN_SIG_ALGORITHM("Unknown signature algorithm: %1$#x"),
        V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE("Unknown additional attribute: ID %1$#x"),
        V3_SIG_VERIFY_EXCEPTION("Failed to verify %1$s signature: %2$s"),
        V3_SIG_INVALID_SDK_VERSIONS("Invalid SDK Version parameter(s) encountered in APK Signature scheme v3 signature: minSdkVersion %1$s maxSdkVersion: %2$s"),
        V3_SIG_DID_NOT_VERIFY("%1$s signature over signed-data did not verify"),
        V3_SIG_NO_SIGNATURES("No signatures"),
        V3_SIG_NO_SUPPORTED_SIGNATURES("No supported signatures"),
        V3_SIG_NO_CERTIFICATES("No certificates"),
        V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD("minSdkVersion mismatch between signed data and signature record: <%1$s> vs <%2$s>"),
        V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD("maxSdkVersion mismatch between signed data and signature record: <%1$s> vs <%2$s>"),
        V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD("Public key mismatch between certificate and signature record: <%1$s> vs <%2$s>"),
        V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS("Signature algorithms mismatch between signatures and digests records: %1$s vs %2$s"),
        V3_SIG_APK_DIGEST_DID_NOT_VERIFY("APK integrity check failed. %1$s digest mismatch. Expected: <%2$s>, actual: <%3$s>"),
        V3_SIG_POR_DID_NOT_VERIFY("SigningCertificateLineage attribute containd a proof-of-rotation record with signature(s) that did not verify."),
        V3_SIG_MALFORMED_LINEAGE("Failed to parse the SigningCertificateLineage structure in the APK Signature Scheme v3 signature's additional attributes section."),
        V3_SIG_POR_CERT_MISMATCH("APK signing certificate differs from the associated certificate found in the signer's SigningCertificateLineage."),
        V3_INCONSISTENT_SDK_VERSIONS("APK Signature Scheme v3 signers supported min/max SDK versions are not continuous."),
        V3_MISSING_SDK_VERSIONS("APK Signature Scheme v3 signers supported min/max SDK versions do not cover the entire desired range.  Found min:  %1$s max %2$s"),
        V3_INCONSISTENT_LINEAGES("SigningCertificateLineages targeting different platform versions using APK Signature Scheme v3 are not all a part of the same overall lineage."),
        V31_BLOCK_MISSING("The v3 signer indicates key rotation should be supported starting from SDK version %1$s, but a v3.1 block was not found"),
        V31_ROTATION_MIN_SDK_MISMATCH("The v3 signer indicates key rotation should be supported starting from SDK version %1$s, but the v3.1 block targets %2$s for rotation"),
        V31_ROTATION_MIN_SDK_ATTR_MISSING("APK supports key rotation starting from SDK version %1$s, but the v3 signer does not contain the attribute to detect if this signature is stripped"),
        V31_BLOCK_FOUND_WITHOUT_V3_BLOCK("The APK contains a v3.1 signing block without a v3.0 base block"),
        V31_ROTATION_TARGETS_DEV_RELEASE_ATTR_ON_V3_SIGNER("The rotation-targets-dev-release attribute is only supported on v3.1 signers; this attribute will be ignored by the platform in a v3.0 signer"),
        APK_SIG_BLOCK_UNKNOWN_ENTRY_ID("APK Signing Block contains unknown entry: ID %1$#x"),
        V4_SIG_MALFORMED_SIGNERS("V4 signature has malformed signer block"),
        V4_SIG_UNKNOWN_SIG_ALGORITHM("V4 signature has unknown signing algorithm: %1$#x"),
        V4_SIG_NO_SIGNATURES("V4 signature has no signature found"),
        V4_SIG_NO_SUPPORTED_SIGNATURES("V4 signature has no supported signature"),
        V4_SIG_DID_NOT_VERIFY("%1$s signature over signed-data did not verify"),
        V4_SIG_VERIFY_EXCEPTION("Failed to verify %1$s signature: %2$s"),
        V4_SIG_MALFORMED_PUBLIC_KEY("Malformed public key: %1$s"),
        V4_SIG_MALFORMED_CERTIFICATE("V4 signature has malformed certificate"),
        V4_SIG_NO_CERTIFICATE("V4 signature has no certificate"),
        V4_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD("V4 signature has mismatched certificate and signature: <%1$s> vs <%2$s>"),
        V4_SIG_APK_ROOT_DID_NOT_VERIFY("V4 signature's hash tree root (content digest) did not verity"),
        V4_SIG_APK_TREE_DID_NOT_VERIFY("V4 signature's hash tree did not verity"),
        V4_SIG_MULTIPLE_SIGNERS("V4 signature only supports one signer"),
        V4_SIG_V2_V3_SIGNERS_MISMATCH("V4 signature and V2/V3 signature have mismatched certificates"),
        V4_SIG_V2_V3_DIGESTS_MISMATCH("V4 signature and V2/V3 signature have mismatched digests"),
        V4_SIG_VERSION_NOT_CURRENT("V4 signature format version %1$d is different from the tool's current version %2$d"),
        SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING("Neither the source stamp certificate digest file nor the signature block are present in the APK"),
        SOURCE_STAMP_SIG_MISSING("No SourceStamp signature"),
        SOURCE_STAMP_MALFORMED_CERTIFICATE("Malformed certificate: %1$s"),
        SOURCE_STAMP_MALFORMED_SIGNATURE("Malformed SourceStamp signature"),
        SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM("Unknown signature algorithm: %1$#x"),
        SOURCE_STAMP_VERIFY_EXCEPTION("Failed to verify %1$s signature: %2$s"),
        SOURCE_STAMP_DID_NOT_VERIFY("%1$s signature over signed-data did not verify"),
        SOURCE_STAMP_NO_SIGNATURE("No signature"),
        SOURCE_STAMP_NO_SUPPORTED_SIGNATURE("Signature(s) {%1$s} not supported: %2$s"),
        SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK("Certificate mismatch between SourceStamp block in APK signing block and SourceStamp file in APK: <%1$s> vs <%2$s>"),
        SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST("A source stamp signature block was found without a corresponding certificate digest in the APK"),
        SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH("The source stamp certificate digest in the APK, %1$s, does not match the expected digest, %2$s"),
        SOURCE_STAMP_MALFORMED_ATTRIBUTE("Malformed stamp attribute #%1$d"),
        SOURCE_STAMP_UNKNOWN_ATTRIBUTE("Unknown stamp attribute: ID %1$#x"),
        SOURCE_STAMP_MALFORMED_LINEAGE("Failed to parse the SigningCertificateLineage structure in the source stamp attributes section."),
        SOURCE_STAMP_POR_CERT_MISMATCH("APK signing certificate differs from the associated certificate found in the signer's SigningCertificateLineage."),
        SOURCE_STAMP_POR_DID_NOT_VERIFY("Source stamp SigningCertificateLineage attribute contains a proof-of-rotation record with signature(s) that did not verify."),
        SOURCE_STAMP_INVALID_TIMESTAMP("The source stamp timestamp attribute has an invalid value: %1$d"),
        MALFORMED_APK("Malformed APK; the following exception was caught when attempting to parse the APK: %1$s"),
        UNEXPECTED_EXCEPTION("An unexpected exception was caught when verifying the signature: %1$s");


        /* renamed from: a */
        private final String f4325a;

        d(String str) {
            this.f4325a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public String m6366b() {
            return this.f4325a;
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.a.d$e */
    public static class e extends C0668c {

        /* renamed from: a */
        private final d f4326a;

        /* renamed from: b */
        private final Object[] f4327b;

        public e(d dVar, Object[] objArr) {
            super(dVar.f4325a, objArr);
            this.f4326a = dVar;
            this.f4327b = objArr;
        }

        @Override // com.p065b.p066a.C0668c
        /* renamed from: b */
        public Object[] mo6331b() {
            return (Object[]) this.f4327b.clone();
        }

        @Override // com.p065b.p066a.C0668c
        public String toString() {
            return String.format(this.f4326a.m6366b(), this.f4327b);
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.a.d$c */
    private static class c {

        /* renamed from: a */
        private final byte[] f4317a;

        /* renamed from: b */
        private final int f4318b;

        private c(byte[] bArr) {
            this.f4317a = bArr;
            this.f4318b = Arrays.hashCode(bArr);
        }

        public int hashCode() {
            return this.f4318b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return hashCode() == cVar.hashCode() && Arrays.equals(this.f4317a, cVar.f4317a);
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.a.d$b */
    public static class b {

        /* renamed from: a */
        private final InterfaceC0671c f4312a;

        /* renamed from: b */
        private final File f4313b;

        /* renamed from: c */
        private int f4314c = Integer.MAX_VALUE;

        /* renamed from: d */
        private Integer f4315d;

        /* renamed from: e */
        private File f4316e;

        public b(File file) {
            if (file == null) {
                throw new NullPointerException("apk == null");
            }
            this.f4313b = file;
            this.f4312a = null;
        }

        public b(InterfaceC0671c interfaceC0671c) {
            if (interfaceC0671c == null) {
                throw new NullPointerException("apk == null");
            }
            this.f4312a = interfaceC0671c;
            this.f4313b = null;
        }

        /* renamed from: b */
        public b m6363b(int i) {
            this.f4315d = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public b m6360a(int i) {
            this.f4314c = i;
            return this;
        }

        /* renamed from: a */
        public b m6361a(File file) {
            this.f4316e = file;
            return this;
        }

        /* renamed from: a */
        public C0675d m6362a() {
            return new C0675d(this.f4313b, this.f4312a, this.f4316e, this.f4315d, this.f4314c);
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.a.d$a */
    public static class a {
        static final Map<Integer, d> sVerificationIssueIdToIssue;

        private a() {
        }

        static {
            HashMap hashMap = new HashMap();
            sVerificationIssueIdToIssue = hashMap;
            hashMap.put(1, d.V2_SIG_MALFORMED_SIGNERS);
            hashMap.put(2, d.V2_SIG_NO_SIGNERS);
            hashMap.put(3, d.V2_SIG_MALFORMED_SIGNER);
            hashMap.put(4, d.V2_SIG_MALFORMED_SIGNATURE);
            hashMap.put(5, d.V2_SIG_NO_SIGNATURES);
            hashMap.put(6, d.V2_SIG_MALFORMED_CERTIFICATE);
            hashMap.put(7, d.V2_SIG_NO_CERTIFICATES);
            hashMap.put(8, d.V2_SIG_MALFORMED_DIGEST);
            hashMap.put(9, d.V3_SIG_MALFORMED_SIGNERS);
            hashMap.put(10, d.V3_SIG_NO_SIGNERS);
            hashMap.put(11, d.V3_SIG_MALFORMED_SIGNER);
            hashMap.put(12, d.V3_SIG_MALFORMED_SIGNATURE);
            hashMap.put(13, d.V3_SIG_NO_SIGNATURES);
            hashMap.put(14, d.V3_SIG_MALFORMED_CERTIFICATE);
            hashMap.put(15, d.V3_SIG_NO_CERTIFICATES);
            hashMap.put(16, d.V3_SIG_MALFORMED_DIGEST);
            hashMap.put(17, d.SOURCE_STAMP_NO_SIGNATURE);
            hashMap.put(18, d.SOURCE_STAMP_MALFORMED_CERTIFICATE);
            hashMap.put(19, d.SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM);
            hashMap.put(20, d.SOURCE_STAMP_MALFORMED_SIGNATURE);
            hashMap.put(21, d.SOURCE_STAMP_DID_NOT_VERIFY);
            hashMap.put(22, d.SOURCE_STAMP_VERIFY_EXCEPTION);
            hashMap.put(23, d.SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH);
            hashMap.put(24, d.SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST);
            hashMap.put(25, d.SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING);
            hashMap.put(26, d.SOURCE_STAMP_NO_SUPPORTED_SIGNATURE);
            hashMap.put(27, d.SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK);
            hashMap.put(28, d.MALFORMED_APK);
            hashMap.put(29, d.UNEXPECTED_EXCEPTION);
            hashMap.put(30, d.SOURCE_STAMP_SIG_MISSING);
            hashMap.put(31, d.SOURCE_STAMP_MALFORMED_ATTRIBUTE);
            hashMap.put(32, d.SOURCE_STAMP_UNKNOWN_ATTRIBUTE);
            hashMap.put(33, d.SOURCE_STAMP_MALFORMED_LINEAGE);
            hashMap.put(34, d.SOURCE_STAMP_POR_CERT_MISMATCH);
            hashMap.put(35, d.SOURCE_STAMP_POR_DID_NOT_VERIFY);
            hashMap.put(36, d.JAR_SIG_NO_SIGNATURES);
            hashMap.put(37, d.JAR_SIG_PARSE_EXCEPTION);
            hashMap.put(38, d.SOURCE_STAMP_INVALID_TIMESTAMP);
        }

        /* renamed from: a */
        public static List<e> m6354a(List<? extends C0668c> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (C0668c c0668c : list) {
                if (c0668c instanceof e) {
                    arrayList.add((e) c0668c);
                } else {
                    arrayList.add(new e(sVerificationIssueIdToIssue.get(Integer.valueOf(c0668c.m6330a())), c0668c.mo6331b()));
                }
            }
            return arrayList;
        }
    }
}
