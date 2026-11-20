package com.p065b.p111c;

import com.p065b.p111c.p112a.AbstractC1038b;
import com.p065b.p111c.p112a.C1037a;
import com.p065b.p111c.p113b.p114a.C1042a;
import com.p065b.p111c.p113b.p114a.p115a.AbstractC1045c;
import com.p065b.p111c.p113b.p114a.p116b.AbstractC1049d;
import com.p065b.p111c.p120c.AbstractC1070d;
import com.p065b.p111c.p120c.InterfaceC1069c;
import com.p065b.p111c.p121d.C1072a;
import java.nio.ByteBuffer;
import java.io.File;
import java.io.RandomAccessFile;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ApkVerifier.java */
/* renamed from: com.b.c.c */
/* loaded from: classes.dex */
public class C1066c {

    /* renamed from: a */
    private static final Map<Integer, String> f6741a = Collections.singletonMap(2, "APK Signature Scheme v2");

    /* renamed from: b */
    private final InterfaceC1069c f6742b;

    /* renamed from: c */
    private final File f6743c;

    /* renamed from: d */
    private final int f6744d;

    /* renamed from: e */
    private final Integer f6745e;

    private C1066c(File file, InterfaceC1069c interfaceC1069c, Integer num, int i) {
        this.f6743c = file;
        this.f6742b = interfaceC1069c;
        this.f6745e = num;
        this.f6744d = i;
    }

    /* synthetic */ C1066c(File file, InterfaceC1069c interfaceC1069c, Integer num, int i, C1066c c1066c) {
        this(file, interfaceC1069c, num, i);
    }

    /* renamed from: a */
    public e m8917a() {
        RandomAccessFile randomAccessFile;
        InterfaceC1069c m8926a;
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (this.f6742b != null) {
                m8926a = this.f6742b;
            } else if (this.f6743c != null) {
                randomAccessFile = new RandomAccessFile(this.f6743c, "r");
                try {
                    m8926a = AbstractC1070d.m8926a(randomAccessFile, 0L, randomAccessFile.length());
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
            e m8915a = m8915a(m8926a);
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return m8915a;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r7.m8937a() != false) goto L22;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private e m8915a(InterfaceC1069c interfaceC1069c) {
        Set emptySet;
        int m8624a;
        ByteBuffer byteBuffer = null;
        if (this.f6745e != null) {
            if (this.f6745e.intValue() < 0) {
                throw new IllegalArgumentException("minSdkVersion must not be negative: " + this.f6745e);
            }
            if (this.f6745e != null && this.f6745e.intValue() > this.f6744d) {
                throw new IllegalArgumentException("minSdkVersion (" + this.f6745e + ") > maxSdkVersion (" + this.f6744d + ")");
            }
        }
        int i = this.f6744d;
        try {
            AbstractC1038b.c m8625a = AbstractC1038b.m8625a(interfaceC1069c);
            e eVar = new e();
            if (i >= 24) {
                emptySet = new HashSet(1);
                try {
                    AbstractC1049d.b m8789b = AbstractC1049d.m8789b(interfaceC1069c, m8625a);
                    emptySet.add(2);
                    eVar.m8929a(m8789b);
                } catch (AbstractC1049d.h e2) {
                }
            } else {
                emptySet = Collections.emptySet();
            }
            if (this.f6745e != null) {
                m8624a = this.f6745e.intValue();
            } else {
                byteBuffer = m8916a(interfaceC1069c, m8625a);
                m8624a = AbstractC1038b.m8624a(byteBuffer.slice());
                if (m8624a > this.f6744d) {
                    throw new IllegalArgumentException("minSdkVersion from APK (" + m8624a + ") > maxSdkVersion (" + this.f6744d + ")");
                }
            }
            if (i >= 26) {
                if (byteBuffer == null) {
                    byteBuffer = m8916a(interfaceC1069c, m8625a);
                }
                int m8914a = byteBuffer == null ? 1 : m8914a(byteBuffer.slice());
                if (m8914a > 1 && emptySet.isEmpty()) {
                    eVar.m8936a(c.NO_SIG_FOR_TARGET_SANDBOX_VERSION, Integer.valueOf(m8914a));
                }
            }
            if (m8624a < 24 || emptySet.isEmpty()) {
                eVar.m8928a(AbstractC1045c.m8698a(interfaceC1069c, m8625a, f6741a, emptySet, m8624a, i));
            }
            if (!eVar.m8937a()) {
                if (eVar.m8941e() && eVar.m8942f()) {
                    ArrayList arrayList = new ArrayList(eVar.m8939c());
                    ArrayList arrayList2 = new ArrayList(eVar.m8940d());
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        f fVar = (f) it.next();
                        try {
                            arrayList3.add(new b(fVar.m8946b().getEncoded(), null));
                        } catch (CertificateEncodingException e3) {
                            throw new RuntimeException("Failed to encode JAR signer " + fVar.m8947c() + " certs", e3);
                        }
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        g gVar = (g) it2.next();
                        try {
                            arrayList4.add(new b(gVar.m8951b().getEncoded(), null));
                        } catch (CertificateEncodingException e4) {
                            throw new RuntimeException("Failed to encode APK Signature Scheme v2 signer (index: " + gVar.m8952c() + ") certs", e4);
                        }
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList3.size()) {
                            break;
                        }
                        if (arrayList4.contains((b) arrayList3.get(i2))) {
                            i2++;
                        } else {
                            ((f) arrayList.get(i2)).m8943a(c.V2_SIG_MISSING, new Object[0]);
                            break;
                        }
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= arrayList4.size()) {
                            break;
                        }
                        if (arrayList3.contains((b) arrayList4.get(i3))) {
                            i3++;
                        } else {
                            ((g) arrayList2.get(i3)).m8948a(c.JAR_SIG_MISSING, new Object[0]);
                            break;
                        }
                    }
                }
                if (!eVar.m8937a()) {
                    eVar.m8935g();
                    if (eVar.m8942f()) {
                        Iterator<g> it3 = eVar.m8940d().iterator();
                        while (it3.hasNext()) {
                            eVar.m8934a(it3.next().m8951b());
                        }
                    } else if (eVar.m8941e()) {
                        Iterator<f> it4 = eVar.m8939c().iterator();
                        while (it4.hasNext()) {
                            eVar.m8934a(it4.next().m8946b());
                        }
                    } else {
                        throw new RuntimeException("APK considered verified, but has not verified using either v1 or v2 schemes");
                    }
                }
            }
            return eVar;
        } catch (C1072a e5) {
            throw new C1037a("Malformed APK: not a ZIP archive", e5);
        }
    }

    /* renamed from: a */
    private static ByteBuffer m8916a(InterfaceC1069c interfaceC1069c, AbstractC1038b.c cVar) {
        try {
            return C1036a.m8605a(AbstractC1045c.m8701a(interfaceC1069c, cVar), interfaceC1069c.mo8845b(0L, cVar.m8629a()));
        } catch (C1072a e2) {
            throw new C1037a("Failed to read AndroidManifest.xml", e2);
        }
    }

    /* renamed from: a */
    private static int m8914a(ByteBuffer byteBuffer) {
        try {
            C1042a c1042a = new C1042a(byteBuffer);
            for (int m8661c = c1042a.m8661c(); m8661c != 2; m8661c = c1042a.m8666f()) {
                if (m8661c == 3 && c1042a.m8659b() == 1 && "manifest".equals(c1042a.m8664d()) && c1042a.m8665e().isEmpty()) {
                    for (int i = 0; i < c1042a.m8657a(); i++) {
                        if (c1042a.m8660b(i) == 16844108) {
                            switch (c1042a.m8663d(i)) {
                                case 2:
                                    return c1042a.m8658a(i);
                                default:
                                    throw new C1037a("Failed to determine APK's target sandbox version: unsupported value type of AndroidManifest.xml android:targetSandboxVersion. Only integer values supported.");
                            }
                        }
                    }
                    return 1;
                }
            }
            throw new C1037a("Failed to determine APK's target sandbox version : no manifest element in AndroidManifest.xml");
        } catch (C1042a.e e2) {
            throw new C1037a("Failed to determine APK's target sandbox version: malformed AndroidManifest.xml", e2);
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$e */
    public static class e {

        /* renamed from: f */
        private boolean f6812f;

        /* renamed from: g */
        private boolean f6813g;

        /* renamed from: h */
        private boolean f6814h;

        /* renamed from: a */
        private final List<d> f6807a = new ArrayList();

        /* renamed from: i */
        private final List<d> f6815i = new ArrayList();

        /* renamed from: b */
        private final List<X509Certificate> f6808b = new ArrayList();

        /* renamed from: d */
        private final List<f> f6810d = new ArrayList();

        /* renamed from: c */
        private final List<f> f6809c = new ArrayList();

        /* renamed from: e */
        private final List<g> f6811e = new ArrayList();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public void m8935g() {
            this.f6812f = true;
        }

        /* renamed from: e */
        public boolean m8941e() {
            return this.f6813g;
        }

        /* renamed from: f */
        public boolean m8942f() {
            return this.f6814h;
        }

        /* renamed from: b */
        public List<X509Certificate> m8938b() {
            return this.f6808b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8934a(X509Certificate x509Certificate) {
            this.f6808b.add(x509Certificate);
        }

        /* renamed from: c */
        public List<f> m8939c() {
            return this.f6810d;
        }

        /* renamed from: d */
        public List<g> m8940d() {
            return this.f6811e;
        }

        /* renamed from: a */
        void m8936a(c cVar, Object... objArr) {
            this.f6807a.add(new d(cVar, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8928a(AbstractC1045c.b bVar) {
            f fVar = null;
            this.f6813g = bVar.f6598c;
            this.f6807a.addAll(bVar.m8723a());
            this.f6815i.addAll(bVar.m8724b());
            Iterator<AbstractC1045c.c> it = bVar.f6597b.iterator();
            while (it.hasNext()) {
                this.f6810d.add(new f(it.next(), fVar));
            }
            Iterator<AbstractC1045c.c> it2 = bVar.f6596a.iterator();
            while (it2.hasNext()) {
                this.f6809c.add(new f(it2.next(), fVar));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8929a(AbstractC1049d.b bVar) {
            this.f6814h = bVar.f6650b;
            this.f6807a.addAll(bVar.m8794b());
            this.f6815i.addAll(bVar.m8796c());
            Iterator<AbstractC1049d.c> it = bVar.f6649a.iterator();
            while (it.hasNext()) {
                this.f6811e.add(new g(it.next(), null));
            }
        }

        /* renamed from: a */
        public boolean m8937a() {
            if (!this.f6807a.isEmpty()) {
                return true;
            }
            if (!this.f6810d.isEmpty()) {
                Iterator<f> it = this.f6810d.iterator();
                while (it.hasNext()) {
                    if (it.next().m8945a()) {
                        return true;
                    }
                }
            }
            if (!this.f6811e.isEmpty()) {
                Iterator<g> it2 = this.f6811e.iterator();
                while (it2.hasNext()) {
                    if (it2.next().m8950a()) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$f */
    public static class f {

        /* renamed from: a */
        private final List<X509Certificate> f6816a;

        /* renamed from: b */
        private final List<d> f6817b;

        /* renamed from: c */
        private final String f6818c;

        /* renamed from: d */
        private final String f6819d;

        /* renamed from: e */
        private final String f6820e;

        /* renamed from: f */
        private final List<d> f6821f;

        private f(AbstractC1045c.c cVar) {
            this.f6818c = cVar.f6602b;
            this.f6816a = cVar.f6601a;
            this.f6819d = cVar.f6603c;
            this.f6820e = cVar.f6604d;
            this.f6817b = cVar.m8731a();
            this.f6821f = cVar.m8732b();
        }

        /* synthetic */ f(AbstractC1045c.c cVar, f fVar) {
            this(cVar);
        }

        /* renamed from: c */
        public String m8947c() {
            return this.f6818c;
        }

        /* renamed from: b */
        public X509Certificate m8946b() {
            if (this.f6816a.isEmpty()) {
                return null;
            }
            return this.f6816a.get(0);
        }

        /* renamed from: a */
        public boolean m8945a() {
            return !this.f6817b.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8943a(c cVar, Object... objArr) {
            this.f6817b.add(new d(cVar, objArr));
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$g */
    public static class g {

        /* renamed from: a */
        private final List<X509Certificate> f6822a;

        /* renamed from: b */
        private final List<d> f6823b;

        /* renamed from: c */
        private final int f6824c;

        /* renamed from: d */
        private final List<d> f6825d;

        private g(AbstractC1049d.c cVar) {
            this.f6824c = cVar.f6656d;
            this.f6822a = cVar.f6654b;
            this.f6823b = cVar.m8799b();
            this.f6825d = cVar.m8801c();
        }

        /* synthetic */ g(AbstractC1049d.c cVar, g gVar) {
            this(cVar);
        }

        /* renamed from: c */
        public int m8952c() {
            return this.f6824c;
        }

        /* renamed from: b */
        public X509Certificate m8951b() {
            if (this.f6822a.isEmpty()) {
                return null;
            }
            return this.f6822a.get(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m8948a(c cVar, Object... objArr) {
            this.f6823b.add(new d(cVar, objArr));
        }

        /* renamed from: a */
        public boolean m8950a() {
            return !this.f6823b.isEmpty();
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$c */
    public enum c {
        JAR_SIG_NO_SIGNATURES("No JAR signatures:%s"),
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
        JAR_SIG_UNSUPPORTED_SIG_ALG("JAR signature %1$s uses digest algorithm %2$s and signature algorithm %3$s which is not supported on API Levels %4$s"),
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
        V2_SIG_MISSING("No APK Signature Scheme v2 signature from this signer"),
        V2_SIG_MALFORMED_SIGNERS("Malformed list of signers"),
        V2_SIG_MALFORMED_SIGNER("Malformed signer block"),
        V2_SIG_MALFORMED_PUBLIC_KEY("Malformed public key: %1$s"),
        V2_SIG_MALFORMED_CERTIFICATE("Malformed certificate #%2$d: %3$s"),
        V2_SIG_MALFORMED_SIGNATURE("Malformed APK Signature Scheme v2 signature record #%1$d"),
        V2_SIG_MALFORMED_DIGEST("Malformed APK Signature Scheme v2 digest record #%1$d"),
        V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE("Malformed additional attribute #%1$d"),
        V2_SIG_NO_SIGNERS("No signers in APK Signature Scheme v2 signature"),
        V2_SIG_UNKNOWN_SIG_ALGORITHM("Unknown signature algorithm: %1$#x"),
        V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE("Unknown additional attribute: ID %1$#x"),
        V2_SIG_VERIFY_EXCEPTION("Failed to verify %1$s signature: %2$s"),
        V2_SIG_DID_NOT_VERIFY("%1$s signature over signed-data did not verify"),
        V2_SIG_NO_SIGNATURES("No signatures"),
        V2_SIG_NO_SUPPORTED_SIGNATURES("No supported signatures"),
        V2_SIG_NO_CERTIFICATES("No certificates"),
        V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD("Public key mismatch between certificate and signature record: <%1$s> vs <%2$s>"),
        V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS("Signature algorithms mismatch between signatures and digests records: %1$s vs %2$s"),
        V2_SIG_APK_DIGEST_DID_NOT_VERIFY("APK integrity check failed. %1$s digest mismatch. Expected: <%2$s>, actual: <%3$s>"),
        APK_SIG_BLOCK_UNKNOWN_ENTRY_ID("APK Signing Block contains unknown entry: ID %1$#x");


        /* renamed from: aa */
        private final String f6804aa;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static c[] valuesCustom() {
            c[] valuesCustom = values();
            int length = valuesCustom.length;
            c[] cVarArr = new c[length];
            System.arraycopy(valuesCustom, 0, cVarArr, 0, length);
            return cVarArr;
        }

        c(String str) {
            this.f6804aa = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public String m8923a() {
            return this.f6804aa;
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$d */
    public static class d {

        /* renamed from: a */
        private final c f6805a;

        /* renamed from: b */
        private final Object[] f6806b;

        public d(c cVar, Object[] objArr) {
            this.f6805a = cVar;
            this.f6806b = objArr;
        }

        public String toString() {
            return String.format(this.f6805a.m8923a(), this.f6806b);
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$b */
    private static class b {

        /* renamed from: a */
        private final byte[] f6750a;

        /* renamed from: b */
        private final int f6751b;

        private b(byte[] bArr) {
            this.f6750a = bArr;
            this.f6751b = Arrays.hashCode(this.f6750a);
        }

        /* synthetic */ b(byte[] bArr, b bVar) {
            this(bArr);
        }

        public int hashCode() {
            return this.f6751b;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                if (hashCode() != bVar.hashCode() || !Arrays.equals(this.f6750a, bVar.f6750a)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: ApkVerifier.java */
    /* renamed from: com.b.c.c$a */
    public static class a {

        /* renamed from: a */
        private final InterfaceC1069c f6746a;

        /* renamed from: b */
        private final File f6747b;

        /* renamed from: c */
        private int f6748c = Integer.MAX_VALUE;

        /* renamed from: d */
        private Integer f6749d;

        public a(File file) {
            if (file == null) {
                throw new NullPointerException("apk == null");
            }
            this.f6747b = file;
            this.f6746a = null;
        }

        /* renamed from: b */
        public a m8920b(int i) {
            this.f6749d = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public a m8918a(int i) {
            this.f6748c = i;
            return this;
        }

        /* renamed from: a */
        public C1066c m8919a() {
            return new C1066c(this.f6747b, this.f6746a, this.f6749d, this.f6748c, null);
        }
    }
}
