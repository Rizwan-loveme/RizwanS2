package com.p065b.p111c;

import com.p065b.p111c.InterfaceC1041b;
import com.p065b.p111c.p113b.p114a.p115a.AbstractC1044b;
import com.p065b.p111c.p113b.p114a.p115a.EnumC1043a;
import com.p065b.p111c.p113b.p114a.p116b.AbstractC1048c;
import com.p065b.p111c.p113b.p118c.C1057e;
import com.p065b.p111c.p113b.p118c.C1059g;
import com.p065b.p111c.p120c.AbstractC1068b;
import com.p065b.p111c.p120c.InterfaceC1067a;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.p209io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: DefaultApkSignerEngine.java */
/* renamed from: com.b.c.d */
/* loaded from: classes.dex */
public class C1071d implements InterfaceC1041b {

    /* renamed from: a */
    private static int[] f6826a;

    /* renamed from: b */
    private e f6827b;

    /* renamed from: c */
    private d f6828c;

    /* renamed from: d */
    private boolean f6829d;

    /* renamed from: e */
    private final String f6830e;

    /* renamed from: f */
    private final Map<String, byte[]> f6831f;

    /* renamed from: g */
    private c f6832g;

    /* renamed from: h */
    private final boolean f6833h;

    /* renamed from: i */
    private final Map<String, b> f6834i;

    /* renamed from: j */
    private final Map<String, byte[]> f6835j;

    /* renamed from: k */
    private final Map<String, c> f6836k;

    /* renamed from: l */
    private final Set<String> f6837l;

    /* renamed from: m */
    private final EnumC1043a f6838m;

    /* renamed from: n */
    private boolean f6839n;

    /* renamed from: o */
    private final List<AbstractC1044b.b> f6840o;

    /* renamed from: p */
    private final boolean f6841p;

    /* renamed from: q */
    private boolean f6842q;

    /* renamed from: r */
    private final List<AbstractC1048c.a> f6843r;

    /* renamed from: s */
    private final boolean f6844s;

    /* renamed from: c */
    static /* synthetic */ int[] m8954c() {
        int[] iArr = f6826a;
        if (iArr == null) {
            iArr = new int[InterfaceC1041b.b.valuesCustom().length];
            try {
                iArr[InterfaceC1041b.b.OUTPUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[InterfaceC1041b.b.OUTPUT_BY_ENGINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[InterfaceC1041b.b.SKIP.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            f6826a = iArr;
        }
        return iArr;
    }

    private C1071d(List<f> list, int i, boolean z, boolean z2, boolean z3, String str) {
        Set<String> emptySet;
        this.f6834i = new HashMap();
        this.f6835j = new HashMap();
        this.f6831f = new HashMap();
        this.f6836k = new HashMap();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one signer config must be provided");
        }
        if (z3) {
            throw new UnsupportedOperationException("Preserving other signer's signatures is not yet implemented");
        }
        this.f6841p = z;
        this.f6844s = z2;
        this.f6839n = z;
        this.f6842q = z2;
        this.f6833h = z3;
        this.f6830e = str;
        this.f6840o = z ? new ArrayList<>(list.size()) : Collections.emptyList();
        this.f6843r = z2 ? new ArrayList<>(list.size()) : Collections.emptyList();
        Map hashMap = z ? new HashMap(list.size()) : Collections.emptyMap();
        int i2 = 0;
        EnumC1043a enumC1043a = null;
        while (true) {
            int i3 = i2;
            EnumC1043a enumC1043a2 = enumC1043a;
            if (i3 < list.size()) {
                f fVar = list.get(i3);
                List<X509Certificate> m8982a = fVar.m8982a();
                PublicKey publicKey = m8982a.get(0).getPublicKey();
                if (z) {
                    String m8682a = AbstractC1044b.m8682a(fVar.m8983b());
                    Integer num = (Integer) hashMap.put(m8682a, Integer.valueOf(i3));
                    if (num != null) {
                        throw new IllegalArgumentException("Signers #" + (num.intValue() + 1) + " and #" + (i3 + 1) + " have the same name: " + m8682a + ". v1 signer names must be unique");
                    }
                    EnumC1043a m8678a = AbstractC1044b.m8678a(publicKey, i);
                    AbstractC1044b.b bVar = new AbstractC1044b.b();
                    bVar.f6586b = m8682a;
                    bVar.f6587c = fVar.m8984c();
                    bVar.f6585a = m8982a;
                    bVar.f6588d = m8678a;
                    if (enumC1043a2 == null) {
                        enumC1043a2 = m8678a;
                    } else if (EnumC1043a.f6568a.compare(m8678a, enumC1043a2) > 0) {
                        enumC1043a2 = m8678a;
                    }
                    this.f6840o.add(bVar);
                }
                enumC1043a = enumC1043a2;
                if (z2) {
                    AbstractC1048c.a aVar = new AbstractC1048c.a();
                    aVar.f6639b = fVar.m8984c();
                    aVar.f6638a = m8982a;
                    aVar.f6640c = AbstractC1048c.m8761a(publicKey, i);
                    this.f6843r.add(aVar);
                }
                i2 = i3 + 1;
            } else {
                this.f6838m = enumC1043a2;
                if (z) {
                    emptySet = AbstractC1044b.m8685a(this.f6840o);
                } else {
                    emptySet = Collections.emptySet();
                }
                this.f6837l = emptySet;
                return;
            }
        }
    }

    /* synthetic */ C1071d(List list, int i, boolean z, boolean z2, boolean z3, String str, C1071d c1071d) {
        this(list, i, z, z2, z3, str);
    }

    @Override // com.p065b.p111c.InterfaceC1041b
    /* renamed from: a */
    public void mo8638a(InterfaceC1069c interfaceC1069c) {
        m8955d();
        if (interfaceC1069c == null || interfaceC1069c.mo8840a() == 0 || this.f6833h) {
        }
    }

    @Override // com.p065b.p111c.InterfaceC1041b
    /* renamed from: a */
    public InterfaceC1041b.a mo8635a(String str) {
        m8955d();
        InterfaceC1041b.b m8953c = m8953c(str);
        switch (m8954c()[m8953c.ordinal()]) {
            case 1:
                return new InterfaceC1041b.a(InterfaceC1041b.b.SKIP);
            case 2:
                return new InterfaceC1041b.a(InterfaceC1041b.b.OUTPUT);
            case 3:
                if ("META-INF/MANIFEST.MF".equals(str)) {
                    this.f6832g = new c(str, null);
                    return new InterfaceC1041b.a(InterfaceC1041b.b.OUTPUT_BY_ENGINE, this.f6832g);
                }
                return new InterfaceC1041b.a(InterfaceC1041b.b.OUTPUT_BY_ENGINE);
            default:
                throw new RuntimeException("Unsupported output policy: " + m8953c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p065b.p111c.InterfaceC1041b
    /* renamed from: b */
    public InterfaceC1041b.c mo8639b(String str) {
        c cVar = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        m8955d();
        m8959h();
        if (!this.f6841p) {
            return null;
        }
        if (AbstractC1044b.m8690b(str)) {
            m8958g();
            b bVar = new b(str, AbstractC1044b.m8681a(this.f6838m), objArr3 == true ? 1 : 0);
            this.f6834i.put(str, bVar);
            this.f6835j.remove(str);
            return bVar;
        }
        if (!this.f6837l.contains(str)) {
            return null;
        }
        m8958g();
        if ("META-INF/MANIFEST.MF".equals(str)) {
            c cVar2 = new c(str, objArr2 == true ? 1 : 0);
            this.f6832g = cVar2;
            cVar = cVar2;
        } else if (this.f6831f.containsKey(str)) {
            cVar = new c(str, objArr == true ? 1 : 0);
        }
        if (cVar != null) {
            this.f6836k.put(str, cVar);
            return cVar;
        }
        return cVar;
    }

    @Override // com.p065b.p111c.InterfaceC1041b
    /* renamed from: b */
    public InterfaceC1041b.e mo8640b() {
        List<C1059g<String, byte[]>> m8684a;
        e eVar = null;
        m8955d();
        if (!this.f6839n) {
            return null;
        }
        if (this.f6832g != null && !this.f6832g.m8976f()) {
            throw new IllegalStateException("Still waiting to inspect input APK's " + this.f6832g.m8977c());
        }
        for (b bVar : this.f6834i.values()) {
            String m8971c = bVar.m8971c();
            if (!bVar.m8970g()) {
                throw new IllegalStateException("Still waiting to inspect output APK's " + m8971c);
            }
            this.f6835j.put(m8971c, bVar.m8968e());
        }
        this.f6834i.clear();
        for (c cVar : this.f6836k.values()) {
            if (!cVar.m8976f()) {
                throw new IllegalStateException("Still waiting to inspect output APK's " + cVar.m8977c());
            }
        }
        List singletonList = this.f6844s ? Collections.singletonList(2) : Collections.emptyList();
        byte[] m8975e = this.f6832g != null ? this.f6832g.m8975e() : null;
        if (this.f6827b == null || !this.f6827b.m8981c()) {
            try {
                m8684a = AbstractC1044b.m8684a(this.f6840o, this.f6838m, this.f6835j, singletonList, m8975e, this.f6830e);
            } catch (CertificateException e2) {
                throw new SignatureException("Failed to generate v1 signature", e2);
            }
        } else {
            AbstractC1044b.a m8679a = AbstractC1044b.m8679a(this.f6838m, this.f6835j, m8975e);
            if (!Arrays.equals(m8679a.f6582a, this.f6831f.get("META-INF/MANIFEST.MF"))) {
                try {
                    m8684a = AbstractC1044b.m8683a(this.f6840o, this.f6838m, singletonList, this.f6830e, m8679a);
                } catch (CertificateException e3) {
                    throw new SignatureException("Failed to generate v1 signature", e3);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, byte[]> entry : this.f6831f.entrySet()) {
                    String key = entry.getKey();
                    byte[] value = entry.getValue();
                    c cVar2 = this.f6836k.get(key);
                    if (cVar2 == null) {
                        arrayList.add(C1059g.m8851a(key, value));
                    } else if (!Arrays.equals(value, cVar2.m8975e())) {
                        arrayList.add(C1059g.m8851a(key, value));
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                m8684a = arrayList;
            }
        }
        if (m8684a.isEmpty()) {
            this.f6839n = false;
            return null;
        }
        ArrayList arrayList2 = new ArrayList(m8684a.size());
        for (C1059g<String, byte[]> c1059g : m8684a) {
            String m8852a = c1059g.m8852a();
            byte[] m8853b = c1059g.m8853b();
            arrayList2.add(new InterfaceC1041b.f(m8852a, m8853b));
            this.f6831f.put(m8852a, m8853b);
        }
        this.f6827b = new e(arrayList2, eVar);
        return this.f6827b;
    }

    @Override // com.p065b.p111c.InterfaceC1041b
    /* renamed from: a */
    public InterfaceC1041b.d mo8636a(InterfaceC1069c interfaceC1069c, InterfaceC1069c interfaceC1069c2, InterfaceC1069c interfaceC1069c3) {
        d dVar = null;
        m8955d();
        m8956e();
        if (!this.f6844s) {
            return null;
        }
        m8959h();
        this.f6828c = new d(AbstractC1048c.m8765a(interfaceC1069c, interfaceC1069c2, interfaceC1069c3, this.f6843r), dVar);
        return this.f6828c;
    }

    @Override // com.p065b.p111c.InterfaceC1041b
    /* renamed from: a */
    public void mo8637a() {
        m8955d();
        m8956e();
        m8957f();
    }

    @Override // java.p209io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6829d = true;
        this.f6827b = null;
        this.f6832g = null;
        this.f6834i.clear();
        this.f6835j.clear();
        this.f6831f.clear();
        this.f6836k.clear();
        this.f6828c = null;
    }

    /* renamed from: g */
    private void m8958g() {
        if (this.f6841p) {
            this.f6839n = true;
        }
        m8959h();
    }

    /* renamed from: h */
    private void m8959h() {
        if (this.f6844s) {
            this.f6842q = true;
            this.f6828c = null;
        }
    }

    /* renamed from: d */
    private void m8955d() {
        if (this.f6829d) {
            throw new IllegalStateException("Engine closed");
        }
    }

    /* renamed from: e */
    private void m8956e() {
        if (this.f6839n) {
            if (this.f6827b == null) {
                throw new IllegalStateException("v1 signature (JAR signature) not yet generated. Skipped outputJarEntries()?");
            }
            if (!this.f6827b.m8981c()) {
                throw new IllegalStateException("v1 signature (JAR signature) addition requested by outputJarEntries() hasn't been fulfilled");
            }
            for (Map.Entry<String, byte[]> entry : this.f6831f.entrySet()) {
                String key = entry.getKey();
                byte[] value = entry.getValue();
                c cVar = this.f6836k.get(key);
                if (cVar == null) {
                    throw new IllegalStateException("APK entry " + key + " not yet output despite this having been requested");
                }
                if (!cVar.m8976f()) {
                    throw new IllegalStateException("Still waiting to inspect output APK's " + key);
                }
                if (!Arrays.equals(value, cVar.m8975e())) {
                    throw new IllegalStateException("Output APK entry " + key + " data differs from what was requested");
                }
            }
            this.f6839n = false;
        }
    }

    /* renamed from: f */
    private void m8957f() {
        if (this.f6842q) {
            if (this.f6828c == null) {
                throw new IllegalStateException("v2 signature (APK Signature Scheme v2 signature) not yet generated. Skipped outputZipSections()?");
            }
            if (!this.f6828c.m8979c()) {
                throw new IllegalStateException("v2 signature (APK Signature Scheme v2 signature) addition requested by outputZipSections() hasn't been fulfilled yet");
            }
            this.f6828c = null;
            this.f6842q = false;
        }
    }

    /* renamed from: c */
    private InterfaceC1041b.b m8953c(String str) {
        if (this.f6837l.contains(str)) {
            return InterfaceC1041b.b.OUTPUT_BY_ENGINE;
        }
        if (this.f6833h || AbstractC1044b.m8690b(str)) {
            return InterfaceC1041b.b.OUTPUT;
        }
        return InterfaceC1041b.b.SKIP;
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$e */
    private static class e implements InterfaceC1041b.e {

        /* renamed from: a */
        private final List<InterfaceC1041b.f> f6865a;

        /* renamed from: b */
        private volatile boolean f6866b;

        private e(List<InterfaceC1041b.f> list) {
            this.f6865a = Collections.unmodifiableList(new ArrayList(list));
        }

        /* synthetic */ e(List list, e eVar) {
            this(list);
        }

        @Override // com.p065b.p111c.InterfaceC1041b.e
        /* renamed from: b */
        public List<InterfaceC1041b.f> mo8911b() {
            return this.f6865a;
        }

        @Override // com.p065b.p111c.InterfaceC1041b.e
        /* renamed from: a */
        public void mo8910a() {
            this.f6866b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m8981c() {
            return this.f6866b;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$d */
    private static class d implements InterfaceC1041b.d {

        /* renamed from: a */
        private final byte[] f6863a;

        /* renamed from: b */
        private volatile boolean f6864b;

        private d(byte[] bArr) {
            this.f6863a = (byte[]) bArr.clone();
        }

        /* synthetic */ d(byte[] bArr, d dVar) {
            this(bArr);
        }

        @Override // com.p065b.p111c.InterfaceC1041b.d
        /* renamed from: b */
        public byte[] mo8857b() {
            return (byte[]) this.f6863a.clone();
        }

        @Override // com.p065b.p111c.InterfaceC1041b.d
        /* renamed from: a */
        public void mo8856a() {
            this.f6864b = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public boolean m8979c() {
            return this.f6864b;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$c */
    private static class c implements InterfaceC1041b.c {

        /* renamed from: a */
        private InterfaceC1067a f6858a;

        /* renamed from: b */
        private ByteArrayOutputStream f6859b;

        /* renamed from: c */
        private boolean f6860c;

        /* renamed from: d */
        private final String f6861d;

        /* renamed from: e */
        private final Object f6862e;

        private c(String str) {
            this.f6862e = new Object();
            this.f6861d = str;
        }

        /* synthetic */ c(String str, c cVar) {
            this(str);
        }

        /* renamed from: c */
        public String m8977c() {
            return this.f6861d;
        }

        @Override // com.p065b.p111c.InterfaceC1041b.c
        /* renamed from: b */
        public InterfaceC1067a mo8838b() {
            InterfaceC1067a interfaceC1067a;
            synchronized (this.f6862e) {
                m8974d();
                if (this.f6859b == null) {
                    this.f6859b = new ByteArrayOutputStream();
                }
                if (this.f6858a == null) {
                    this.f6858a = AbstractC1068b.m8921a(this.f6859b);
                }
                interfaceC1067a = this.f6858a;
            }
            return interfaceC1067a;
        }

        @Override // com.p065b.p111c.InterfaceC1041b.c
        /* renamed from: a */
        public void mo8837a() {
            synchronized (this.f6862e) {
                if (!this.f6860c) {
                    this.f6860c = true;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public boolean m8976f() {
            boolean z;
            synchronized (this.f6862e) {
                z = this.f6860c;
            }
            return z;
        }

        /* renamed from: d */
        private void m8974d() {
            synchronized (this.f6862e) {
                if (this.f6860c) {
                    throw new IllegalStateException("Already done");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public byte[] m8975e() {
            byte[] byteArray;
            synchronized (this.f6862e) {
                if (!this.f6860c) {
                    throw new IllegalStateException("Not yet done");
                }
                byteArray = this.f6859b != null ? this.f6859b.toByteArray() : new byte[0];
            }
            return byteArray;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$b */
    private static class b implements InterfaceC1041b.c {

        /* renamed from: a */
        private InterfaceC1067a f6851a;

        /* renamed from: b */
        private byte[] f6852b;

        /* renamed from: c */
        private boolean f6853c;

        /* renamed from: d */
        private final String f6854d;

        /* renamed from: e */
        private final String f6855e;

        /* renamed from: f */
        private final Object f6856f;

        /* renamed from: g */
        private MessageDigest f6857g;

        private b(String str, String str2) {
            this.f6856f = new Object();
            this.f6854d = str;
            this.f6855e = str2;
        }

        /* synthetic */ b(String str, String str2, b bVar) {
            this(str, str2);
        }

        /* renamed from: c */
        public String m8971c() {
            return this.f6854d;
        }

        @Override // com.p065b.p111c.InterfaceC1041b.c
        /* renamed from: b */
        public InterfaceC1067a mo8838b() {
            InterfaceC1067a interfaceC1067a;
            synchronized (this.f6856f) {
                m8967d();
                if (this.f6851a == null) {
                    this.f6851a = new C1057e(new MessageDigest[]{m8969f()});
                }
                interfaceC1067a = this.f6851a;
            }
            return interfaceC1067a;
        }

        /* renamed from: f */
        private MessageDigest m8969f() {
            MessageDigest messageDigest;
            synchronized (this.f6856f) {
                if (this.f6857g == null) {
                    try {
                        this.f6857g = MessageDigest.getInstance(this.f6855e);
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(String.valueOf(this.f6855e) + " MessageDigest not available", e2);
                    }
                }
                messageDigest = this.f6857g;
            }
            return messageDigest;
        }

        @Override // com.p065b.p111c.InterfaceC1041b.c
        /* renamed from: a */
        public void mo8837a() {
            synchronized (this.f6856f) {
                if (!this.f6853c) {
                    this.f6853c = true;
                    this.f6852b = m8969f().digest();
                    this.f6857g = null;
                    this.f6851a = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public boolean m8970g() {
            boolean z;
            synchronized (this.f6856f) {
                z = this.f6853c;
            }
            return z;
        }

        /* renamed from: d */
        private void m8967d() {
            synchronized (this.f6856f) {
                if (this.f6853c) {
                    throw new IllegalStateException("Already done");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public byte[] m8968e() {
            byte[] bArr;
            synchronized (this.f6856f) {
                if (!this.f6853c) {
                    throw new IllegalStateException("Not yet done");
                }
                bArr = (byte[]) this.f6852b.clone();
            }
            return bArr;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$f */
    public static class f {

        /* renamed from: a */
        private final List<X509Certificate> f6867a;

        /* renamed from: b */
        private final String f6868b;

        /* renamed from: c */
        private final PrivateKey f6869c;

        private f(String str, PrivateKey privateKey, List<X509Certificate> list) {
            this.f6868b = str;
            this.f6869c = privateKey;
            this.f6867a = Collections.unmodifiableList(new ArrayList(list));
        }

        /* synthetic */ f(String str, PrivateKey privateKey, List list, f fVar) {
            this(str, privateKey, list);
        }

        /* renamed from: b */
        public String m8983b() {
            return this.f6868b;
        }

        /* renamed from: c */
        public PrivateKey m8984c() {
            return this.f6869c;
        }

        /* renamed from: a */
        public List<X509Certificate> m8982a() {
            return this.f6867a;
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$g */
    public static class g {

        /* renamed from: a */
        private final List<X509Certificate> f6870a;

        /* renamed from: b */
        private final String f6871b;

        /* renamed from: c */
        private final PrivateKey f6872c;

        public g(String str, PrivateKey privateKey, List<X509Certificate> list) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Empty name");
            }
            this.f6871b = str;
            this.f6872c = privateKey;
            this.f6870a = new ArrayList(list);
        }

        /* renamed from: a */
        public f m8985a() {
            return new f(this.f6871b, this.f6872c, this.f6870a, null);
        }
    }

    /* compiled from: DefaultApkSignerEngine.java */
    /* renamed from: com.b.c.d$a */
    public static class a {

        /* renamed from: b */
        private final int f6846b;

        /* renamed from: c */
        private boolean f6847c;

        /* renamed from: d */
        private final List<f> f6848d;

        /* renamed from: e */
        private boolean f6849e = true;

        /* renamed from: f */
        private boolean f6850f = true;

        /* renamed from: a */
        private String f6845a = "1.0 (Android)";

        public a(List<f> list, int i) {
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one signer config must be provided");
            }
            this.f6848d = new ArrayList(list);
            this.f6846b = i;
        }

        /* renamed from: a */
        public C1071d m8962a() {
            return new C1071d(this.f6848d, this.f6846b, this.f6849e, this.f6850f, this.f6847c, this.f6845a, null);
        }

        /* renamed from: b */
        public a m8963b(boolean z) {
            this.f6849e = z;
            return this;
        }

        /* renamed from: c */
        public a m8964c(boolean z) {
            this.f6850f = z;
            return this;
        }

        /* renamed from: a */
        public a m8961a(boolean z) {
            this.f6847c = z;
            return this;
        }

        /* renamed from: a */
        public a m8960a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.f6845a = str;
            return this;
        }
    }
}
