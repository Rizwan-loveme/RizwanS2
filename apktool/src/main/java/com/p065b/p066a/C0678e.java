package com.p065b.p066a;

import com.p065b.p066a.InterfaceC0585b;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p069a.p070a.AbstractC0589c;
import com.p065b.p066a.p068b.p069a.p071b.AbstractC0593b;
import com.p065b.p066a.p068b.p069a.p071b.EnumC0592a;
import com.p065b.p066a.p068b.p069a.p072c.AbstractC0596a;
import com.p065b.p066a.p068b.p069a.p073d.C0599a;
import com.p065b.p066a.p068b.p069a.p074e.AbstractC0603a;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p068b.p081g.C0654m;
import com.p065b.p066a.p084c.AbstractC0670b;
import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import java.nio.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: DefaultApkSignerEngine.java */
/* renamed from: com.b.a.e */
/* loaded from: classes.dex */
public class C0678e implements InterfaceC0585b {
    private static final Set<Integer> DISCARDED_SIGNATURE_BLOCK_IDS;

    /* renamed from: A */
    private List<AbstractC0593b.b> f4377A;

    /* renamed from: B */
    private final boolean f4378B;

    /* renamed from: C */
    private boolean f4379C;

    /* renamed from: D */
    private final boolean f4380D;

    /* renamed from: E */
    private boolean f4381E;

    /* renamed from: F */
    private final boolean f4382F;

    /* renamed from: G */
    private final boolean f4383G;

    /* renamed from: a */
    private e f4384a;

    /* renamed from: b */
    private f f4385b;

    /* renamed from: c */
    private boolean f4386c;

    /* renamed from: d */
    private final String f4387d;

    /* renamed from: e */
    private Boolean f4388e;

    /* renamed from: f */
    private final boolean f4389f;

    /* renamed from: g */
    private final Map<String, byte[]> f4390g;

    /* renamed from: h */
    private InterfaceC0673e f4391h;

    /* renamed from: i */
    private d f4392i;

    /* renamed from: j */
    private final int f4393j;

    /* renamed from: k */
    private final boolean f4394k;

    /* renamed from: l */
    private d f4395l;

    /* renamed from: m */
    private final Map<String, c> f4396m;

    /* renamed from: n */
    private final Map<String, byte[]> f4397n;

    /* renamed from: o */
    private final Map<String, d> f4398o;

    /* renamed from: p */
    private List<C0652k<byte[], Integer>> f4399p;

    /* renamed from: q */
    private List<byte[]> f4400q;

    /* renamed from: r */
    private final int f4401r;

    /* renamed from: s */
    private final boolean f4402s;

    /* renamed from: t */
    private Set<String> f4403t;

    /* renamed from: u */
    private final List<g> f4404u;

    /* renamed from: v */
    private final C0680g f4405v;

    /* renamed from: w */
    private final g f4406w;

    /* renamed from: x */
    private final C0680g f4407x;

    /* renamed from: y */
    private EnumC0592a f4408y;

    /* renamed from: z */
    private boolean f4409z;

    static {
        HashSet hashSet = new HashSet(3);
        DISCARDED_SIGNATURE_BLOCK_IDS = hashSet;
        hashSet.add(Integer.valueOf(C0598d.VERITY_PADDING_BLOCK_ID));
        hashSet.add(722016414);
        hashSet.add(Integer.valueOf(AbstractC0589c.V2_SOURCE_STAMP_BLOCK_ID));
    }

    private C0678e(List<g> list, g gVar, C0680g c0680g, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, C0680g c0680g2) {
        this.f4400q = Collections.emptyList();
        this.f4399p = Collections.emptyList();
        this.f4377A = Collections.emptyList();
        this.f4403t = Collections.emptySet();
        this.f4396m = new HashMap();
        this.f4397n = new HashMap();
        this.f4390g = new HashMap();
        this.f4398o = new HashMap();
        this.f4391h = InterfaceC0673e.MULTI_THREADED;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        this.f4378B = z2;
        this.f4380D = z3;
        this.f4382F = z4;
        this.f4383G = z5;
        this.f4409z = z2;
        this.f4379C = z3;
        this.f4381E = z4;
        this.f4389f = z6;
        this.f4394k = z7;
        this.f4387d = str;
        this.f4404u = list;
        this.f4406w = gVar;
        this.f4407x = c0680g;
        this.f4393j = i;
        this.f4401r = i2;
        this.f4402s = z;
        this.f4405v = c0680g2;
        if (z2) {
            if (z4) {
                g gVar2 = list.get(0);
                if (c0680g2 != null && c0680g2.m6490a((X509Certificate) gVar2.f4448a.get(0)).m6492b() != 1) {
                    throw new IllegalArgumentException("v1 signing enabled but the oldest signer in the SigningCertificateLineage is missing.  Please provide the oldest signer to enable v1 signing");
                }
                m6427a(Collections.singletonList(gVar2), i);
                return;
            }
            m6427a(list, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m6427a(List<g> list, int i) {
        this.f4377A = new ArrayList(list.size());
        HashMap hashMap = new HashMap(list.size());
        int i2 = 0;
        EnumC0592a enumC0592a = null;
        while (i2 < list.size()) {
            g gVar = list.get(i2);
            List<X509Certificate> m6477a = gVar.m6477a();
            PublicKey publicKey = m6477a.get(0).getPublicKey();
            String m5864a = AbstractC0593b.m5864a(gVar.m6479c());
            Integer num = (Integer) hashMap.put(m5864a, Integer.valueOf(i2));
            if (num != null) {
                throw new IllegalArgumentException("Signers #" + (num.intValue() + 1) + " and #" + (i2 + 1) + " have the same name: " + m5864a + ". v1 signer names must be unique");
            }
            EnumC0592a m5861a = AbstractC0593b.m5861a(publicKey, i);
            AbstractC0593b.b bVar = new AbstractC0593b.b();
            bVar.f4023c = m5864a;
            bVar.f4024d = gVar.m6480d();
            bVar.f4021a = m6477a;
            bVar.f4025e = m5861a;
            bVar.f4022b = gVar.m6478b();
            if (enumC0592a != null && EnumC0592a.BY_STRENGTH_COMPARATOR.compare(m5861a, enumC0592a) <= 0) {
                m5861a = enumC0592a;
            }
            this.f4377A.add(bVar);
            i2++;
            enumC0592a = m5861a;
        }
        this.f4408y = enumC0592a;
        this.f4403t = AbstractC0593b.m5867a(this.f4377A);
    }

    /* renamed from: a */
    private List<C0598d.g> m6425a(boolean z) {
        if (this.f4382F) {
            ArrayList arrayList = new ArrayList();
            g gVar = this.f4404u.get(0);
            C0680g c0680g = this.f4405v;
            if (c0680g != null && c0680g.m6490a((X509Certificate) gVar.f4448a.get(0)).m6492b() != 1) {
                throw new IllegalArgumentException("v2 signing enabled but the oldest signer in the SigningCertificateLineage is missing.  Please provide the oldest signer to enable v2 signing.");
            }
            arrayList.add(m6423a(this.f4404u.get(0), z, 2));
            return arrayList;
        }
        return m6426a(z, 2);
    }

    /* renamed from: p */
    private boolean m6445p() {
        int i;
        return this.f4405v != null && (i = this.f4401r) >= 33 && this.f4393j < i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        if (r0 > r8.f4393j) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ef, code lost:
    
        throw new java.security.InvalidKeyException("Provided key algorithms not supported on all desired Android SDK versions");
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<C0598d.g> m6432d(List<C0598d.g> list) {
        int i;
        if (m6445p() && this.f4405v.m6490a((X509Certificate) this.f4404u.get(0).f4448a.get(0)).m6492b() != 1) {
            throw new IllegalArgumentException("v3.1 signing enabled but the oldest signer in the SigningCertificateLineage for the v3.0 signing block is missing.  Please provide the oldest signer to enable v3.1 signing.");
        }
        ArrayList arrayList = new ArrayList();
        int i2 = Integer.MAX_VALUE;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = i2;
                break;
            }
            C0598d.g gVar = list.get(size);
            if (gVar.f4154f == null) {
                throw new InvalidKeyException("Unsupported key algorithm " + gVar.f4149a.get(0).getPublicKey().getAlgorithm() + " is not supported for APK Signature Scheme v3 signing");
            }
            if (size == list.size() - 1) {
                gVar.f4151c = Integer.MAX_VALUE;
            } else if (this.f4402s && i2 == this.f4401r) {
                gVar.f4151c = i2;
            } else {
                gVar.f4151c = i2 - 1;
            }
            gVar.f4152d = m6422a(gVar.f4154f);
            if (this.f4405v != null && (!this.f4402s ? gVar.f4151c >= this.f4401r : gVar.f4151c > this.f4401r)) {
                gVar.f4150b = this.f4405v.m6490a(gVar.f4149a.get(0));
                int i3 = gVar.f4152d;
                int i4 = this.f4401r;
                if (i3 < i4) {
                    gVar.f4152d = i4;
                }
            }
            arrayList.add(gVar);
            i = gVar.f4152d;
            boolean z = this.f4402s;
            if ((z && i < this.f4393j) || ((!z && i <= this.f4393j) || i <= 28)) {
                break;
            }
            size--;
            i2 = i;
        }
        return arrayList;
    }

    /* renamed from: b */
    private List<C0598d.g> m6428b(boolean z) {
        return m6432d(m6426a(z, 3));
    }

    /* renamed from: c */
    private List<C0598d.g> m6431c(List<C0598d.g> list) {
        if (!m6445p()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C0598d.g> it = list.iterator();
        while (it.hasNext()) {
            C0598d.g next = it.next();
            if (next.f4152d >= this.f4401r) {
                arrayList.add(next);
                it.remove();
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    private AbstractC0603a.a m6439j() {
        List<C0598d.g> m6426a = m6426a(true, 4);
        if (m6426a.size() != 1) {
            m6426a = m6432d(m6426a);
        }
        return new AbstractC0603a.a(m6426a, m6431c(m6426a));
    }

    /* renamed from: i */
    private C0598d.g m6438i() {
        C0598d.g m6423a = m6423a(this.f4406w, false, 0);
        C0680g c0680g = this.f4407x;
        if (c0680g != null) {
            m6423a.f4150b = c0680g.m6490a(m6423a.f4149a.get(0));
        }
        return m6423a;
    }

    /* renamed from: a */
    private int m6422a(List<EnumC0609i> list) {
        Iterator<EnumC0609i> it = list.iterator();
        int i = Integer.MAX_VALUE;
        while (it.hasNext()) {
            int m6085f = it.next().m6085f();
            if (m6085f < i) {
                if (m6085f <= this.f4393j || m6085f <= 28) {
                    return m6085f;
                }
                i = m6085f;
            }
        }
        return i;
    }

    /* renamed from: a */
    private List<C0598d.g> m6426a(boolean z, int i) {
        ArrayList arrayList = new ArrayList(this.f4404u.size());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f4404u.size()) {
                return arrayList;
            }
            arrayList.add(m6423a(this.f4404u.get(i3), z, i));
            i2 = i3 + 1;
        }
    }

    /* renamed from: a */
    private C0598d.g m6423a(g gVar, boolean z, int i) {
        boolean z2 = false;
        List<X509Certificate> m6477a = gVar.m6477a();
        PublicKey publicKey = m6477a.get(0).getPublicKey();
        C0598d.g gVar2 = new C0598d.g();
        gVar2.f4153e = gVar.m6480d();
        gVar2.f4149a = m6477a;
        if (i == 0) {
            gVar2.f4154f = Collections.singletonList(EnumC0609i.RSA_PKCS1_V1_5_WITH_SHA256);
        } else if (i == 2) {
            gVar2.f4154f = AbstractC0596a.m5936a(publicKey, this.f4393j, z && this.f4383G, gVar.m6478b());
        } else if (i == 3) {
            try {
                int i2 = this.f4393j;
                if (z && this.f4383G) {
                    z2 = true;
                }
                gVar2.f4154f = C0599a.m5977a(publicKey, i2, z2, gVar.m6478b());
            } catch (InvalidKeyException e2) {
                gVar2.f4154f = null;
            }
        } else if (i == 4) {
            try {
                gVar2.f4154f = AbstractC0603a.m6043a(publicKey, this.f4393j, z, gVar.m6478b());
            } catch (InvalidKeyException e3) {
                gVar2.f4154f = null;
            }
        } else {
            throw new IllegalArgumentException("Unknown APK Signature Scheme ID requested");
        }
        return gVar2;
    }

    /* renamed from: d */
    private boolean m6433d(String str) {
        return this.f4389f || !AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(str);
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: a */
    public void mo5792a(InterfaceC0671c interfaceC0671c) {
        boolean z = false;
        m6434e();
        if (interfaceC0671c == null || interfaceC0671c.mo6233a() == 0 || !this.f4394k) {
            return;
        }
        this.f4399p = new ArrayList();
        try {
            for (C0652k<byte[], Integer> c0652k : C0598d.m5967b(interfaceC0671c)) {
                if (c0652k.m6252b().intValue() == 1896449818) {
                    if (this.f4380D) {
                        List<C0652k<List<X509Certificate>, byte[]>> m5968b = C0598d.m5968b(c0652k.m6251a());
                        this.f4400q = new ArrayList(m5968b.size());
                        for (C0652k<List<X509Certificate>, byte[]> c0652k2 : m5968b) {
                            if (!m6429b(c0652k2.m6251a())) {
                                this.f4400q.add(c0652k2.m6252b());
                                z = true;
                            }
                        }
                    } else {
                        this.f4399p.add(c0652k);
                        z = true;
                    }
                } else if (c0652k.m6252b().intValue() == -262969152) {
                    if (!this.f4382F) {
                        throw new IllegalStateException("Preserving an existing V3 signature is not supported");
                    }
                    List<C0652k<List<X509Certificate>, byte[]>> m5968b2 = C0598d.m5968b(c0652k.m6251a());
                    if (m5968b2.size() > 1) {
                        throw new IllegalArgumentException("The provided APK signing block contains " + m5968b2.size() + " V3 signers; the V3 signature scheme only supports one signer");
                    }
                    if (m5968b2.size() == 1 && !m6429b(m5968b2.get(0).m6251a())) {
                        throw new IllegalStateException("The V3 signature scheme only supports one signer; a request was made to preserve the existing V3 signature, but the engine is configured to sign with a different signer");
                    }
                } else if (!DISCARDED_SIGNATURE_BLOCK_IDS.contains(c0652k.m6252b())) {
                    this.f4399p.add(c0652k);
                }
            }
            if (this.f4382F && z) {
                throw new IllegalStateException("Signature scheme V3+ only supports a single signer and cannot be appended to the existing signature scheme blocks");
            }
        } catch (C0579a e2) {
            e = e2;
            throw new IllegalArgumentException("Unable to parse the provided signing block", e);
        } catch (IOException e3) {
            e = e3;
            throw new IllegalArgumentException("Unable to parse the provided signing block", e);
        } catch (CertificateException e4) {
            e = e4;
            throw new IllegalArgumentException("Unable to parse the provided signing block", e);
        }
    }

    /* renamed from: b */
    private boolean m6429b(List<X509Certificate> list) {
        Iterator<g> it = this.f4404u.iterator();
        while (it.hasNext()) {
            if (list.containsAll(it.next().m6477a())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: a */
    public InterfaceC0585b.a mo5790a(String str) {
        m6434e();
        InterfaceC0585b.a.EnumC3327a m6430c = m6430c(str);
        int i = AnonymousClass1.f4410x62cebf84[m6430c.ordinal()];
        if (i == 1) {
            return new InterfaceC0585b.a(InterfaceC0585b.a.EnumC3327a.SKIP);
        }
        if (i == 2) {
            return new InterfaceC0585b.a(InterfaceC0585b.a.EnumC3327a.OUTPUT);
        }
        if (i == 3) {
            if (!"META-INF/MANIFEST.MF".equals(str)) {
                return new InterfaceC0585b.a(InterfaceC0585b.a.EnumC3327a.OUTPUT_BY_ENGINE);
            }
            this.f4392i = new d(str, null);
            return new InterfaceC0585b.a(InterfaceC0585b.a.EnumC3327a.OUTPUT_BY_ENGINE, this.f4392i);
        }
        throw new RuntimeException("Unsupported output policy: " + m6430c);
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$android$apksig$ApkSignerEngine$InputJarEntryInstructions$OutputPolicy */
        static final int[] f4410x62cebf84;

        static {
            int[] iArr = new int[InterfaceC0585b.a.EnumC3327a.values().length];
            f4410x62cebf84 = iArr;
            try {
                iArr[InterfaceC0585b.a.EnumC3327a.SKIP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4410x62cebf84[InterfaceC0585b.a.EnumC3327a.OUTPUT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4410x62cebf84[InterfaceC0585b.a.EnumC3327a.OUTPUT_BY_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: b */
    public InterfaceC0585b.b mo5795b(String str) {
        d dVar;
        AnonymousClass1 anonymousClass1 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        m6434e();
        m6442m();
        if (!m6433d(str)) {
            m6440k();
        }
        if (!this.f4378B) {
            if (m6433d(str)) {
                return null;
            }
            d dVar2 = new d(str, anonymousClass1);
            this.f4395l = dVar2;
            return dVar2;
        }
        if (AbstractC0593b.m5871b(str)) {
            m6441l();
            c cVar = new c(str, AbstractC0593b.m5863a(this.f4408y));
            this.f4396m.put(str, cVar);
            this.f4397n.remove(str);
            if (this.f4389f || !AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(str)) {
                return cVar;
            }
            d dVar3 = new d(str, objArr4 == true ? 1 : 0);
            this.f4395l = dVar3;
            return new b(str, new InterfaceC0585b.b[]{dVar3, cVar});
        }
        if (!this.f4403t.contains(str)) {
            return null;
        }
        m6441l();
        if ("META-INF/MANIFEST.MF".equals(str)) {
            dVar = new d(str, objArr2 == true ? 1 : 0);
            this.f4392i = dVar;
        } else if (this.f4390g.containsKey(str)) {
            dVar = new d(str, objArr == true ? 1 : 0);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            this.f4398o.put(str, dVar);
            return dVar;
        }
        return dVar;
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: d */
    public InterfaceC0585b.d mo5798d() {
        List<C0652k<String, byte[]>> m5866a;
        m6434e();
        if (!this.f4409z) {
            return null;
        }
        d dVar = this.f4392i;
        if (dVar != null && !dVar.m6470f()) {
            throw new IllegalStateException("Still waiting to inspect input APK's " + this.f4392i.m6471c());
        }
        for (c cVar : this.f4396m.values()) {
            String m6465c = cVar.m6465c();
            if (!cVar.m6464g()) {
                throw new IllegalStateException("Still waiting to inspect output APK's " + m6465c);
            }
            this.f4397n.put(m6465c, cVar.m6462e());
        }
        if (mo5796b()) {
            MessageDigest messageDigest = MessageDigest.getInstance(AbstractC0593b.m5863a(this.f4408y));
            messageDigest.update(mo5794a());
            this.f4397n.put(AbstractC0581c.SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME, messageDigest.digest());
        }
        this.f4396m.clear();
        for (d dVar2 : this.f4398o.values()) {
            if (!dVar2.m6470f()) {
                throw new IllegalStateException("Still waiting to inspect output APK's " + dVar2.m6471c());
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.f4380D) {
            arrayList.add(2);
        }
        if (this.f4382F) {
            arrayList.add(3);
        }
        d dVar3 = this.f4392i;
        byte[] m6469e = dVar3 != null ? dVar3.m6469e() : null;
        byte[] bArr = mo5796b() ? AbstractC0593b.m5862a(this.f4408y, this.f4397n, m6469e).f4018a : m6469e;
        m6435f();
        f fVar = this.f4385b;
        if (fVar == null || !fVar.m6475c()) {
            try {
                m5866a = AbstractC0593b.m5866a(this.f4377A, this.f4408y, this.f4397n, arrayList, bArr, this.f4387d);
            } catch (CertificateException e2) {
                throw new SignatureException("Failed to generate v1 signature", e2);
            }
        } else {
            AbstractC0593b.a m5862a = AbstractC0593b.m5862a(this.f4408y, this.f4397n, bArr);
            if (!Arrays.equals(m5862a.f4018a, this.f4390g.get("META-INF/MANIFEST.MF"))) {
                try {
                    m5866a = AbstractC0593b.m5865a(this.f4377A, this.f4408y, arrayList, this.f4387d, m5862a);
                } catch (CertificateException e3) {
                    throw new SignatureException("Failed to generate v1 signature", e3);
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<String, byte[]> entry : this.f4390g.entrySet()) {
                    String key = entry.getKey();
                    byte[] value = entry.getValue();
                    d dVar4 = this.f4398o.get(key);
                    if (dVar4 == null) {
                        arrayList2.add(C0652k.m6250a(key, value));
                    } else if (!Arrays.equals(value, dVar4.m6469e())) {
                        arrayList2.add(C0652k.m6250a(key, value));
                    }
                }
                if (arrayList2.isEmpty()) {
                    return null;
                }
                m5866a = arrayList2;
            }
        }
        if (m5866a.isEmpty()) {
            this.f4409z = false;
            return null;
        }
        ArrayList arrayList3 = new ArrayList(m5866a.size());
        for (C0652k<String, byte[]> c0652k : m5866a) {
            String m6251a = c0652k.m6251a();
            byte[] m6252b = c0652k.m6252b();
            arrayList3.add(new InterfaceC0585b.d.a(m6251a, m6252b));
            this.f4390g.put(m6251a, m6252b);
        }
        f fVar2 = new f(arrayList3);
        this.f4385b = fVar2;
        return fVar2;
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: a */
    public InterfaceC0585b.c mo5791a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3) {
        return m6424a(interfaceC0671c, interfaceC0671c2, interfaceC0671c3, true);
    }

    /* renamed from: a */
    private e m6424a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3, boolean z) {
        C0598d.h hVar;
        C0598d.h hVar2;
        List<C0652k<byte[], Integer>> list;
        m6434e();
        m6437h();
        if (!this.f4380D && !this.f4382F && !mo5796b()) {
            return null;
        }
        m6435f();
        C0652k<InterfaceC0671c, Integer> m5946a = C0598d.m5946a(interfaceC0671c, z);
        InterfaceC0671c m6251a = m5946a.m6251a();
        int intValue = m5946a.m6252b().intValue();
        InterfaceC0671c m5948a = C0598d.m5948a(m6251a, interfaceC0671c3);
        ArrayList arrayList = new ArrayList();
        if (this.f4394k && (list = this.f4399p) != null && !list.isEmpty()) {
            arrayList.addAll(this.f4399p);
        }
        if (this.f4380D) {
            m6442m();
            hVar = AbstractC0596a.m5934a(this.f4391h, m6251a, interfaceC0671c2, m5948a, m6425a(z), this.f4382F, this.f4394k ? this.f4400q : null);
            arrayList.add(hVar.f4156b);
        } else {
            hVar = null;
        }
        if (this.f4382F) {
            m6443n();
            List<C0598d.g> m6428b = m6428b(z);
            List<C0598d.g> m6431c = m6431c(m6428b);
            if (m6431c != null && m6431c.size() > 0) {
                arrayList.add(new C0599a.a(m6251a, interfaceC0671c2, m5948a, m6431c).m5987a(this.f4391h).m5986a(462663009).m5988a(this.f4402s).m5989a().m5985a().f4156b);
            }
            C0599a.a m5986a = new C0599a.a(m6251a, interfaceC0671c2, m5948a, m6428b).m5987a(this.f4391h).m5986a(C0599a.APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
            if (m6445p()) {
                m5986a.m5990b(this.f4401r);
            }
            hVar2 = m5986a.m5989a().m5985a();
            arrayList.add(hVar2.f4156b);
        } else {
            hVar2 = null;
        }
        if (mo5796b()) {
            C0598d.g m6438i = m6438i();
            HashMap hashMap = new HashMap();
            if (this.f4382F) {
                hashMap.put(3, hVar2.f4155a);
            }
            if (this.f4380D) {
                hashMap.put(2, hVar.f4155a);
            }
            if (this.f4378B) {
                HashMap hashMap2 = new HashMap();
                try {
                    d dVar = this.f4392i;
                    hashMap2.put(EnumC0607g.SHA256, AbstractC0581c.m5773a(AbstractC0593b.m5862a(this.f4408y, this.f4397n, dVar != null ? dVar.m6469e() : null).f4018a));
                    hashMap.put(1, hashMap2);
                } catch (C0579a e2) {
                    throw new RuntimeException("Failed to generate manifest file", e2);
                }
            }
            arrayList.add(AbstractC0589c.m5840a(m6438i, hashMap));
        }
        e eVar = new e(C0598d.m5974d(arrayList), intValue);
        this.f4384a = eVar;
        return eVar;
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: c */
    public void mo5797c() {
        m6434e();
        m6437h();
        m6436g();
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: a */
    public void mo5793a(InterfaceC0671c interfaceC0671c, File file, boolean z) {
        if (file == null) {
            if (!z) {
                throw new SignatureException("Missing V4 output file.");
            }
            return;
        }
        try {
            AbstractC0603a.m6044a(interfaceC0671c, m6439j(), file);
        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException e2) {
            if (z) {
            } else {
                throw new SignatureException("V4 signing failed", e2);
            }
        }
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: b */
    public boolean mo5796b() {
        return this.f4406w != null && (this.f4380D || this.f4382F || this.f4378B);
    }

    @Override // com.p065b.p066a.InterfaceC0585b
    /* renamed from: a */
    public byte[] mo5794a() {
        if (this.f4406w.m6477a().isEmpty()) {
            throw new SignatureException("No certificates configured for stamp");
        }
        try {
            return AbstractC0581c.m5773a(this.f4406w.m6477a().get(0).getEncoded());
        } catch (CertificateEncodingException e2) {
            throw new SignatureException("Failed to encode source stamp certificate", e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4386c = true;
        this.f4385b = null;
        this.f4392i = null;
        this.f4395l = null;
        this.f4388e = null;
        this.f4396m.clear();
        this.f4397n.clear();
        this.f4390g.clear();
        this.f4398o.clear();
        this.f4384a = null;
    }

    /* renamed from: l */
    private void m6441l() {
        if (this.f4378B) {
            this.f4409z = true;
        }
        m6442m();
    }

    /* renamed from: m */
    private void m6442m() {
        if (this.f4380D) {
            this.f4379C = true;
            this.f4384a = null;
        }
    }

    /* renamed from: n */
    private void m6443n() {
        if (this.f4382F) {
            this.f4381E = true;
            this.f4384a = null;
        }
    }

    /* renamed from: e */
    private void m6434e() {
        if (this.f4386c) {
            throw new IllegalStateException("Engine closed");
        }
    }

    /* renamed from: h */
    private void m6437h() {
        if (this.f4409z) {
            f fVar = this.f4385b;
            if (fVar == null) {
                throw new IllegalStateException("v1 signature (JAR signature) not yet generated. Skipped outputJarEntries()?");
            }
            if (!fVar.m6475c()) {
                throw new IllegalStateException("v1 signature (JAR signature) addition requested by outputJarEntries() hasn't been fulfilled");
            }
            for (Map.Entry<String, byte[]> entry : this.f4390g.entrySet()) {
                String key = entry.getKey();
                byte[] value = entry.getValue();
                d dVar = this.f4398o.get(key);
                if (dVar == null) {
                    throw new IllegalStateException("APK entry " + key + " not yet output despite this having been requested");
                }
                if (!dVar.m6470f()) {
                    throw new IllegalStateException("Still waiting to inspect output APK's " + key);
                }
                if (!Arrays.equals(value, dVar.m6469e())) {
                    throw new IllegalStateException("Output APK entry " + key + " data differs from what was requested");
                }
            }
            this.f4409z = false;
        }
    }

    /* renamed from: g */
    private void m6436g() {
        if (this.f4379C || this.f4381E) {
            e eVar = this.f4384a;
            if (eVar == null) {
                throw new IllegalStateException("Signed APK Signing BLock not yet generated. Skipped outputZipSections()?");
            }
            if (!eVar.m6473d()) {
                throw new IllegalStateException("APK Signing Block addition of signature(s) requested by outputZipSections() hasn't been fulfilled yet");
            }
            this.f4384a = null;
            this.f4379C = false;
            this.f4381E = false;
        }
    }

    /* renamed from: f */
    private void m6435f() {
        if (this.f4389f) {
            return;
        }
        try {
            if (!m6444o()) {
            } else {
                throw new SignatureException("APK is debuggable (see android:debuggable attribute) and this engine is configured to refuse to sign debuggable APKs");
            }
        } catch (C0579a e2) {
            throw new SignatureException("Failed to determine whether the APK is debuggable", e2);
        }
    }

    /* renamed from: o */
    private boolean m6444o() {
        Boolean bool = this.f4388e;
        if (bool != null) {
            return bool.booleanValue();
        }
        d dVar = this.f4395l;
        if (dVar == null) {
            throw new IllegalStateException("Cannot determine debuggable status of output APK because AndroidManifest.xml entry contents have not yet been requested");
        }
        if (!dVar.m6470f()) {
            throw new IllegalStateException("Still waiting to inspect output APK's " + this.f4395l.m6471c());
        }
        Boolean valueOf = Boolean.valueOf(AbstractC0581c.m5772a(ByteBuffer.wrap(this.f4395l.m6469e())));
        this.f4388e = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: k */
    private void m6440k() {
        this.f4388e = null;
    }

    /* renamed from: c */
    private InterfaceC0585b.a.EnumC3327a m6430c(String str) {
        if (this.f4403t.contains(str)) {
            return InterfaceC0585b.a.EnumC3327a.OUTPUT_BY_ENGINE;
        }
        if (this.f4394k || AbstractC0593b.m5871b(str)) {
            return InterfaceC0585b.a.EnumC3327a.OUTPUT;
        }
        return InterfaceC0585b.a.EnumC3327a.SKIP;
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$f */
    private static class f implements InterfaceC0585b.d {

        /* renamed from: a */
        private final List<InterfaceC0585b.d.a> f4446a;

        /* renamed from: b */
        private volatile boolean f4447b;

        private f(List<InterfaceC0585b.d.a> list) {
            this.f4446a = Collections.unmodifiableList(new ArrayList(list));
        }

        @Override // com.p065b.p066a.InterfaceC0585b.d
        /* renamed from: b */
        public List<InterfaceC0585b.d.a> mo6197b() {
            return this.f4446a;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.d
        /* renamed from: a */
        public void mo6196a() {
            this.f4447b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m6475c() {
            return this.f4447b;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$e */
    private static class e implements InterfaceC0585b.c {

        /* renamed from: a */
        private final byte[] f4443a;

        /* renamed from: b */
        private volatile boolean f4444b;

        /* renamed from: c */
        private final int f4445c;

        private e(byte[] bArr, int i) {
            this.f4443a = (byte[]) bArr.clone();
            this.f4445c = i;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.c
        /* renamed from: b */
        public byte[] mo6189b() {
            return (byte[]) this.f4443a.clone();
        }

        @Override // com.p065b.p066a.InterfaceC0585b.c
        /* renamed from: a */
        public void mo6188a() {
            this.f4444b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public boolean m6473d() {
            return this.f4444b;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.c
        /* renamed from: c */
        public int mo6190c() {
            return this.f4445c;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$d */
    private static class d implements InterfaceC0585b.b {

        /* renamed from: a */
        private InterfaceC0669a f4438a;

        /* renamed from: b */
        private ByteArrayOutputStream f4439b;

        /* renamed from: c */
        private boolean f4440c;

        /* renamed from: d */
        private final String f4441d;

        /* renamed from: e */
        private final Object f4442e;

        /* synthetic */ d(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private d(String str) {
            this.f4442e = new Object();
            this.f4441d = str;
        }

        /* renamed from: c */
        public String m6471c() {
            return this.f4441d;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.b
        /* renamed from: b */
        public InterfaceC0669a mo6087b() {
            InterfaceC0669a interfaceC0669a;
            synchronized (this.f4442e) {
                m6468d();
                if (this.f4439b == null) {
                    this.f4439b = new ByteArrayOutputStream();
                }
                if (this.f4438a == null) {
                    this.f4438a = AbstractC0670b.m6332a(this.f4439b);
                }
                interfaceC0669a = this.f4438a;
            }
            return interfaceC0669a;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.b
        /* renamed from: a */
        public void mo6086a() {
            synchronized (this.f4442e) {
                if (!this.f4440c) {
                    this.f4440c = true;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public boolean m6470f() {
            boolean z;
            synchronized (this.f4442e) {
                z = this.f4440c;
            }
            return z;
        }

        /* renamed from: d */
        private void m6468d() {
            synchronized (this.f4442e) {
                if (this.f4440c) {
                    throw new IllegalStateException("Already done");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public byte[] m6469e() {
            byte[] byteArray;
            synchronized (this.f4442e) {
                if (!this.f4440c) {
                    throw new IllegalStateException("Not yet done");
                }
                ByteArrayOutputStream byteArrayOutputStream = this.f4439b;
                byteArray = byteArrayOutputStream != null ? byteArrayOutputStream.toByteArray() : new byte[0];
            }
            return byteArray;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$c */
    private static class c implements InterfaceC0585b.b {

        /* renamed from: a */
        private InterfaceC0669a f4431a;

        /* renamed from: b */
        private byte[] f4432b;

        /* renamed from: c */
        private boolean f4433c;

        /* renamed from: d */
        private final String f4434d;

        /* renamed from: e */
        private final String f4435e;

        /* renamed from: f */
        private final Object f4436f;

        /* renamed from: g */
        private MessageDigest f4437g;

        private c(String str, String str2) {
            this.f4436f = new Object();
            this.f4434d = str;
            this.f4435e = str2;
        }

        /* renamed from: c */
        public String m6465c() {
            return this.f4434d;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.b
        /* renamed from: b */
        public InterfaceC0669a mo6087b() {
            InterfaceC0669a interfaceC0669a;
            synchronized (this.f4436f) {
                m6461d();
                if (this.f4431a == null) {
                    this.f4431a = AbstractC0670b.m6334a(m6463f());
                }
                interfaceC0669a = this.f4431a;
            }
            return interfaceC0669a;
        }

        /* renamed from: f */
        private MessageDigest m6463f() {
            MessageDigest messageDigest;
            synchronized (this.f4436f) {
                if (this.f4437g == null) {
                    try {
                        this.f4437g = MessageDigest.getInstance(this.f4435e);
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(this.f4435e + " MessageDigest not available", e2);
                    }
                }
                messageDigest = this.f4437g;
            }
            return messageDigest;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.b
        /* renamed from: a */
        public void mo6086a() {
            synchronized (this.f4436f) {
                if (!this.f4433c) {
                    this.f4433c = true;
                    this.f4432b = m6463f().digest();
                    this.f4437g = null;
                    this.f4431a = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public boolean m6464g() {
            boolean z;
            synchronized (this.f4436f) {
                z = this.f4433c;
            }
            return z;
        }

        /* renamed from: d */
        private void m6461d() {
            synchronized (this.f4436f) {
                if (this.f4433c) {
                    throw new IllegalStateException("Already done");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public byte[] m6462e() {
            byte[] bArr;
            synchronized (this.f4436f) {
                if (!this.f4433c) {
                    throw new IllegalStateException("Not yet done");
                }
                bArr = (byte[]) this.f4432b.clone();
            }
            return bArr;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$b */
    private static class b implements InterfaceC0585b.b {

        /* renamed from: a */
        private final String f4427a;

        /* renamed from: b */
        private final Object f4428b;

        /* renamed from: c */
        private final InterfaceC0585b.b[] f4429c;

        /* renamed from: d */
        private InterfaceC0669a f4430d;

        private b(String str, InterfaceC0585b.b... bVarArr) {
            this.f4428b = new Object();
            this.f4427a = str;
            this.f4429c = bVarArr;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.b
        /* renamed from: b */
        public InterfaceC0669a mo6087b() {
            InterfaceC0669a interfaceC0669a;
            synchronized (this.f4428b) {
                if (this.f4430d == null) {
                    int length = this.f4429c.length;
                    InterfaceC0669a[] interfaceC0669aArr = new InterfaceC0669a[length];
                    for (int i = 0; i < length; i++) {
                        interfaceC0669aArr[i] = this.f4429c[i].mo6087b();
                    }
                    this.f4430d = new C0654m(interfaceC0669aArr);
                }
                interfaceC0669a = this.f4430d;
            }
            return interfaceC0669a;
        }

        @Override // com.p065b.p066a.InterfaceC0585b.b
        /* renamed from: a */
        public void mo6086a() {
            for (InterfaceC0585b.b bVar : this.f4429c) {
                bVar.mo6086a();
            }
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$g */
    public static class g {

        /* renamed from: a */
        private final List<X509Certificate> f4448a;

        /* renamed from: b */
        private final boolean f4449b;

        /* renamed from: c */
        private final String f4450c;

        /* renamed from: d */
        private final PrivateKey f4451d;

        private g(String str, PrivateKey privateKey, List<X509Certificate> list, boolean z) {
            this.f4450c = str;
            this.f4451d = privateKey;
            this.f4448a = Collections.unmodifiableList(new ArrayList(list));
            this.f4449b = z;
        }

        /* renamed from: c */
        public String m6479c() {
            return this.f4450c;
        }

        /* renamed from: d */
        public PrivateKey m6480d() {
            return this.f4451d;
        }

        /* renamed from: a */
        public List<X509Certificate> m6477a() {
            return this.f4448a;
        }

        /* renamed from: b */
        public boolean m6478b() {
            return this.f4449b;
        }

        /* compiled from: DefaultApkSignerEngine.java */
        /* renamed from: com.b.a.e$g$a */
        public static class a {

            /* renamed from: a */
            private final List<X509Certificate> f4452a;

            /* renamed from: b */
            private final boolean f4453b;

            /* renamed from: c */
            private final String f4454c;

            /* renamed from: d */
            private final PrivateKey f4455d;

            public a(String str, PrivateKey privateKey, List<X509Certificate> list) {
                this(str, privateKey, list, false);
            }

            public a(String str, PrivateKey privateKey, List<X509Certificate> list, boolean z) {
                if (str.isEmpty()) {
                    throw new IllegalArgumentException("Empty name");
                }
                this.f4454c = str;
                this.f4455d = privateKey;
                this.f4452a = new ArrayList(list);
                this.f4453b = z;
            }

            /* renamed from: a */
            public g m6481a() {
                return new g(this.f4454c, this.f4455d, this.f4452a, this.f4453b);
            }
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.a.e$a */
    public static class a {

        /* renamed from: c */
        private final int f4413c;

        /* renamed from: d */
        private boolean f4414d;

        /* renamed from: g */
        private List<g> f4417g;

        /* renamed from: h */
        private C0680g f4418h;

        /* renamed from: i */
        private C0680g f4419i;

        /* renamed from: j */
        private g f4420j;

        /* renamed from: m */
        private boolean f4423m;

        /* renamed from: k */
        private boolean f4421k = true;

        /* renamed from: l */
        private boolean f4422l = true;

        /* renamed from: e */
        private int f4415e = 33;

        /* renamed from: f */
        private boolean f4416f = false;

        /* renamed from: p */
        private boolean f4426p = false;

        /* renamed from: b */
        private boolean f4412b = true;

        /* renamed from: a */
        private String f4411a = "1.0 (Android)";

        /* renamed from: n */
        private boolean f4424n = false;

        /* renamed from: o */
        private boolean f4425o = false;

        public a(List<g> list, int i) {
            this.f4423m = true;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one signer config must be provided");
            }
            if (list.size() > 1) {
                this.f4423m = false;
            }
            this.f4417g = new ArrayList(list);
            this.f4413c = i;
        }

        /* renamed from: a */
        public C0678e m6451a() {
            boolean z = this.f4424n;
            if (!z || !this.f4425o) {
                if (z) {
                    this.f4423m = false;
                } else if (this.f4425o) {
                    this.f4423m = true;
                }
                C0680g c0680g = this.f4418h;
                if (c0680g != null) {
                    try {
                        List<g> m6493b = c0680g.m6493b(this.f4417g);
                        this.f4417g = m6493b;
                        if (!this.f4423m && m6493b.size() > 1) {
                            throw new IllegalStateException("Provided multiple signers which are part of the SigningCertificateLineage, but not signing with APK Signature Scheme v3");
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new IllegalStateException("Provided signer configs do not match the provided SigningCertificateLineage", e2);
                    }
                } else if (this.f4423m && this.f4417g.size() > 1) {
                    throw new IllegalStateException("Multiple signing certificates provided for use with APK Signature Scheme v3 without an accompanying SigningCertificateLineage");
                }
                return new C0678e(this.f4417g, this.f4420j, this.f4419i, this.f4413c, this.f4415e, this.f4416f, this.f4421k, this.f4422l, this.f4423m, this.f4426p, this.f4412b, this.f4414d, this.f4411a, this.f4418h);
            }
            throw new IllegalStateException("Builder configured to both enable and disable APK Signature Scheme v3 signing");
        }

        /* renamed from: a */
        public a m6447a(g gVar) {
            this.f4420j = gVar;
            return this;
        }

        /* renamed from: b */
        public a m6452b(C0680g c0680g) {
            this.f4419i = c0680g;
            return this;
        }

        /* renamed from: d */
        public a m6455d(boolean z) {
            this.f4421k = z;
            return this;
        }

        /* renamed from: e */
        public a m6456e(boolean z) {
            this.f4422l = z;
            return this;
        }

        /* renamed from: f */
        public a m6457f(boolean z) {
            this.f4423m = z;
            if (z) {
                this.f4425o = true;
            } else {
                this.f4424n = true;
            }
            return this;
        }

        /* renamed from: g */
        public a m6458g(boolean z) {
            this.f4426p = z;
            return this;
        }

        /* renamed from: a */
        public a m6450a(boolean z) {
            this.f4412b = z;
            return this;
        }

        /* renamed from: b */
        public a m6453b(boolean z) {
            this.f4414d = z;
            return this;
        }

        /* renamed from: a */
        public a m6449a(String str) {
            str.getClass();
            this.f4411a = str;
            return this;
        }

        /* renamed from: a */
        public a m6448a(C0680g c0680g) {
            if (c0680g != null) {
                this.f4423m = true;
                this.f4418h = c0680g;
            }
            return this;
        }

        /* renamed from: a */
        public a m6446a(int i) {
            if (i < 33) {
                this.f4415e = 28;
            } else {
                this.f4415e = i;
            }
            return this;
        }

        /* renamed from: c */
        public a m6454c(boolean z) {
            this.f4416f = z;
            return this;
        }
    }
}
