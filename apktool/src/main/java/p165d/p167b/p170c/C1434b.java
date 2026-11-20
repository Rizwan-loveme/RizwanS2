package p165d.p167b.p170c;

import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.KeyProperties;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.security.auth.x500.X500Principal;
import javax.xml.datatype.DatatypeConstants;
import p165d.p167b.p169b.C1423a;
import p165d.p167b.p169b.C1425c;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p173f.C1505e;

/* compiled from: PKCS12KeyStore.java */
/* renamed from: d.b.c.b */
/* loaded from: classes.dex */
public final class C1434b extends KeyStoreSpi {

    /* renamed from: a */
    private static C1454q f9282a;

    /* renamed from: b */
    private static C1454q f9283b;

    /* renamed from: c */
    private static C1454q f9284c;

    /* renamed from: d */
    private static C1454q f9285d;

    /* renamed from: e */
    private static C1454q f9286e;

    /* renamed from: j */
    private static C1454q f9291j;

    /* renamed from: l */
    private static C1454q f9293l;

    /* renamed from: v */
    private SecureRandom f9303v;

    /* renamed from: g */
    private static final C1444g f9288g = C1444g.m11327a("pkcs12");

    /* renamed from: h */
    private static final int[] f9289h = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 12, 10, 1, 2};

    /* renamed from: f */
    private static final int[] f9287f = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 12, 10, 1, 3};

    /* renamed from: n */
    private static final int[] f9295n = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 20};

    /* renamed from: m */
    private static final int[] f9294m = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 21};

    /* renamed from: o */
    private static final int[] f9296o = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 22, 1};

    /* renamed from: k */
    private static final int[] f9292k = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 12, 1, 6};

    /* renamed from: i */
    private static final int[] f9290i = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 12, 1, 3};

    /* renamed from: r */
    private int f9299r = 0;

    /* renamed from: u */
    private int f9302u = 0;

    /* renamed from: s */
    private Hashtable<String, b> f9300s = new Hashtable<>();

    /* renamed from: t */
    private ArrayList<b> f9301t = new ArrayList<>();

    /* renamed from: q */
    private LinkedHashMap<X500Principal, X509Certificate> f9298q = new LinkedHashMap<>();

    /* renamed from: p */
    private ArrayList<a> f9297p = new ArrayList<>();

    static {
        try {
            f9283b = new C1454q(f9289h);
            f9282a = new C1454q(f9287f);
            f9285d = new C1454q(f9295n);
            f9286e = new C1454q(f9294m);
            f9284c = new C1454q(f9296o);
            f9293l = new C1454q(f9292k);
            f9291j = new C1454q(f9290i);
        } catch (IOException e2) {
        }
    }

    /* compiled from: PKCS12KeyStore.java */
    /* renamed from: d.b.c.b$b */
    private static class b {

        /* renamed from: a */
        String f9307a;

        /* renamed from: b */
        Certificate[] f9308b;

        /* renamed from: c */
        Date f9309c;

        /* renamed from: d */
        byte[] f9310d;

        /* renamed from: e */
        byte[] f9311e;

        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }
    }

    /* compiled from: PKCS12KeyStore.java */
    /* renamed from: d.b.c.b$a */
    private static class a {

        /* renamed from: a */
        final String f9304a;

        /* renamed from: b */
        final X509Certificate f9305b;

        /* renamed from: c */
        final byte[] f9306c;

        a(X509Certificate x509Certificate, byte[] bArr, String str) {
            this.f9305b = x509Certificate;
            this.f9306c = bArr;
            this.f9304a = str;
        }
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) {
        b bVar = this.f9300s.get(str.toLowerCase());
        if (bVar == null) {
            return null;
        }
        try {
            C1425c c1425c = new C1425c(bVar.f9311e);
            byte[] m11248c = c1425c.m11248c();
            C1448k m11441v = new C1450m(c1425c.m11246a().m11640b()).m11441v();
            C1454q m11376h = m11441v.m11376h();
            AlgorithmParameters m11293a = m11293a(m11441v);
            try {
                if (m11293a != null) {
                    try {
                        if (((PBEParameterSpec) m11293a.getParameterSpec(PBEParameterSpec.class)).getIterationCount() > 5000000) {
                            throw new IOException("PBE iteration count too large");
                        }
                    } catch (InvalidParameterSpecException e2) {
                        throw new IOException("Invalid PBE algorithm parameters");
                    }
                }
                SecretKey m11303b = m11303b(cArr);
                Cipher cipher = Cipher.getInstance(m11376h.toString());
                cipher.init(2, m11303b, m11293a);
                byte[] doFinal = cipher.doFinal(m11248c);
                PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(doFinal);
                C1448k m11441v2 = new C1450m(doFinal).m11441v();
                m11441v2.m11374f();
                return KeyFactory.getInstance(new C1505e(m11441v2.m11364a(2)[0].m11431l()).m11642d()).generatePrivate(pKCS8EncodedKeySpec);
            } catch (Exception e3) {
                UnrecoverableKeyException unrecoverableKeyException = new UnrecoverableKeyException("Get Key failed: " + e3.getMessage());
                unrecoverableKeyException.initCause(e3);
                throw unrecoverableKeyException;
            }
        } catch (IOException e4) {
            UnrecoverableKeyException unrecoverableKeyException2 = new UnrecoverableKeyException("Private key not stored as PKCS#8 EncryptedPrivateKeyInfo: " + e4);
            unrecoverableKeyException2.initCause(e4);
            throw unrecoverableKeyException2;
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        b bVar = this.f9300s.get(str.toLowerCase());
        if (bVar != null && bVar.f9308b != null) {
            return (Certificate[]) bVar.f9308b.clone();
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        b bVar = this.f9300s.get(str.toLowerCase());
        if (bVar != null && bVar.f9308b != null) {
            return bVar.f9308b[0];
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        b bVar = this.f9300s.get(str.toLowerCase());
        if (bVar != null) {
            return new Date(bVar.f9309c.getTime());
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        synchronized (this) {
            try {
                b bVar = new b(null);
                bVar.f9309c = new Date();
                if (key instanceof PrivateKey) {
                    if (key.getFormat().equals("PKCS#8") || key.getFormat().equals("PKCS8")) {
                        bVar.f9311e = m11305b(key.getEncoded(), cArr);
                        if (certificateArr != null) {
                            if (certificateArr.length > 1 && !m11297a(certificateArr)) {
                                throw new KeyStoreException("Certificate chain is not validate");
                            }
                            bVar.f9308b = (Certificate[]) certificateArr.clone();
                        }
                        bVar.f9310d = ("Time " + bVar.f9309c.getTime()).getBytes("UTF8");
                        bVar.f9307a = str.toLowerCase();
                        this.f9300s.put(str.toLowerCase(), bVar);
                    } else {
                        throw new KeyStoreException("Private key is not encodedas PKCS#8");
                    }
                } else {
                    throw new KeyStoreException("Key is not a PrivateKey");
                }
            } catch (Exception e2) {
                throw new KeyStoreException("Key protection  algorithm not found: " + e2, e2);
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        synchronized (this) {
            try {
                new C1425c(bArr);
                b bVar = new b(null);
                bVar.f9309c = new Date();
                try {
                    bVar.f9310d = ("Time " + bVar.f9309c.getTime()).getBytes("UTF8");
                } catch (UnsupportedEncodingException e2) {
                }
                bVar.f9307a = str.toLowerCase();
                bVar.f9311e = (byte[]) bArr.clone();
                if (certificateArr != null) {
                    if (certificateArr.length > 1 && !m11297a(certificateArr)) {
                        throw new KeyStoreException("Certificate chain is not valid");
                    }
                    bVar.f9308b = (Certificate[]) certificateArr.clone();
                }
                this.f9300s.put(str.toLowerCase(), bVar);
            } catch (IOException e3) {
                throw new KeyStoreException("Private key is not stored as PKCS#8 EncryptedPrivateKeyInfo: " + e3, e3);
            }
        }
    }

    /* renamed from: b */
    private byte[] m11304b() {
        byte[] bArr = new byte[20];
        if (this.f9303v == null) {
            this.f9303v = new SecureRandom();
        }
        this.f9303v.nextBytes(bArr);
        return bArr;
    }

    /* renamed from: a */
    private AlgorithmParameters m11294a(String str) {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(m11304b(), SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(str);
            algorithmParameters.init(pBEParameterSpec);
            return algorithmParameters;
        } catch (Exception e2) {
            throw new IOException("getPBEAlgorithmParameters failed: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: a */
    private AlgorithmParameters m11293a(C1448k c1448k) {
        C1450m m11371d;
        try {
            if (c1448k.m11362a() == 0) {
                m11371d = null;
            } else {
                m11371d = c1448k.m11371d();
                if (m11371d.f9357c == 5) {
                    m11371d = null;
                }
            }
            if (m11371d == null) {
                return null;
            }
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("PBE");
            algorithmParameters.init(m11371d.m11440u());
            return algorithmParameters;
        } catch (Exception e2) {
            throw new IOException("parseAlgParameters failed: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: b */
    private SecretKey m11303b(char[] cArr) {
        try {
            return SecretKeyFactory.getInstance("PBE").generateSecret(new PBEKeySpec(cArr));
        } catch (Exception e2) {
            throw new IOException("getSecretKey failed: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: b */
    private byte[] m11305b(byte[] bArr, char[] cArr) {
        try {
            AlgorithmParameters m11294a = m11294a("PBEWithSHA1AndDESede");
            SecretKey m11303b = m11303b(cArr);
            Cipher cipher = Cipher.getInstance("PBEWithSHA1AndDESede");
            cipher.init(1, m11303b, m11294a);
            return new C1425c(new C1505e(f9291j, m11294a), cipher.doFinal(bArr)).m11247b();
        } catch (Exception e2) {
            UnrecoverableKeyException unrecoverableKeyException = new UnrecoverableKeyException("Encrypt Private Key failed: " + e2.getMessage());
            unrecoverableKeyException.initCause(e2);
            throw unrecoverableKeyException;
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) {
        synchronized (this) {
            if (this.f9300s.get(str.toLowerCase()) != null) {
                throw new KeyStoreException("Cannot overwrite own certificate");
            }
            throw new KeyStoreException("TrustedCertEntry not supported");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) {
        synchronized (this) {
            this.f9300s.remove(str.toLowerCase());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        return this.f9300s.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return this.f9300s.containsKey(str.toLowerCase());
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f9300s.size();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.f9300s.get(str.toLowerCase()) != null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration<String> keys = this.f9300s.keys();
        Certificate certificate2 = null;
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            b bVar = this.f9300s.get(nextElement);
            Certificate certificate3 = bVar.f9308b != null ? bVar.f9308b[0] : certificate2;
            if (certificate3.equals(certificate)) {
                return nextElement;
            }
            certificate2 = certificate3;
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) {
        synchronized (this) {
            if (cArr == null) {
                throw new IllegalArgumentException("password can't be null");
            }
            C1449l c1449l = new C1449l();
            C1449l c1449l2 = new C1449l();
            c1449l2.m11401b(3);
            c1449l.write(c1449l2.toByteArray());
            C1449l c1449l3 = new C1449l();
            C1449l c1449l4 = new C1449l();
            new C1423a(m11298a()).m11242a(c1449l4);
            new C1423a(C1423a.f9192c, new C1450m(m11301a(cArr))).m11242a(c1449l4);
            C1449l c1449l5 = new C1449l();
            c1449l5.m11388a((byte) 48, c1449l4);
            byte[] byteArray = c1449l5.toByteArray();
            new C1423a(byteArray).m11242a(c1449l3);
            c1449l.write(c1449l3.toByteArray());
            c1449l.write(m11302a(cArr, byteArray));
            C1449l c1449l6 = new C1449l();
            c1449l6.m11388a((byte) 48, c1449l);
            outputStream.write(c1449l6.toByteArray());
            outputStream.flush();
        }
    }

    /* renamed from: a */
    private byte[] m11302a(char[] cArr, byte[] bArr) {
        try {
            byte[] m11304b = m11304b();
            Mac mac = Mac.getInstance("HmacPBESHA1");
            mac.init(m11303b(cArr), new PBEParameterSpec(m11304b, 100000));
            mac.update(bArr);
            C1433a c1433a = new C1433a("SHA1", mac.doFinal(), m11304b, 100000);
            C1449l c1449l = new C1449l();
            c1449l.write(c1433a.m11290c());
            return c1449l.toByteArray();
        } catch (Exception e2) {
            throw new IOException("calculateMac failed: " + e2, e2);
        }
    }

    /* renamed from: a */
    private boolean m11297a(Certificate[] certificateArr) {
        for (int i = 0; i < certificateArr.length - 1; i++) {
            if (!((X509Certificate) certificateArr[i]).getIssuerX500Principal().equals(((X509Certificate) certificateArr[i + 1]).getSubjectX500Principal())) {
                return false;
            }
        }
        return new HashSet(Arrays.asList(certificateArr)).size() == certificateArr.length;
    }

    /* renamed from: a */
    private byte[] m11299a(String str, byte[] bArr) {
        byte[] bArr2;
        byte[] bArr3 = null;
        if (str == null && bArr == null) {
            return null;
        }
        C1449l c1449l = new C1449l();
        if (str != null) {
            C1449l c1449l2 = new C1449l();
            c1449l2.m11394a(f9285d);
            C1449l c1449l3 = new C1449l();
            C1449l c1449l4 = new C1449l();
            c1449l3.m11395a(str);
            c1449l2.m11388a((byte) 49, c1449l3);
            c1449l4.m11388a((byte) 48, c1449l2);
            bArr2 = c1449l4.toByteArray();
        } else {
            bArr2 = null;
        }
        if (bArr != null) {
            C1449l c1449l5 = new C1449l();
            c1449l5.m11394a(f9286e);
            C1449l c1449l6 = new C1449l();
            C1449l c1449l7 = new C1449l();
            c1449l6.m11405b(bArr);
            c1449l5.m11388a((byte) 49, c1449l6);
            c1449l7.m11388a((byte) 48, c1449l5);
            bArr3 = c1449l7.toByteArray();
        }
        C1449l c1449l8 = new C1449l();
        if (bArr2 != null) {
            c1449l8.write(bArr2);
        }
        if (bArr3 != null) {
            c1449l8.write(bArr3);
        }
        c1449l.m11388a((byte) 49, c1449l8);
        return c1449l.toByteArray();
    }

    /* renamed from: a */
    private byte[] m11301a(char[] cArr) {
        byte[] m11299a;
        C1449l c1449l = new C1449l();
        Enumeration<String> keys = this.f9300s.keys();
        while (keys.hasMoreElements()) {
            b bVar = this.f9300s.get(keys.nextElement());
            int length = bVar.f9308b == null ? 0 : bVar.f9308b.length;
            for (int i = 0; i < length; i++) {
                C1449l c1449l2 = new C1449l();
                c1449l2.m11394a(f9282a);
                C1449l c1449l3 = new C1449l();
                c1449l3.m11394a(f9284c);
                C1449l c1449l4 = new C1449l();
                X509Certificate x509Certificate = (X509Certificate) bVar.f9308b[i];
                c1449l4.m11405b(x509Certificate.getEncoded());
                c1449l3.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l4);
                C1449l c1449l5 = new C1449l();
                c1449l5.m11388a((byte) 48, c1449l3);
                byte[] byteArray = c1449l5.toByteArray();
                C1449l c1449l6 = new C1449l();
                c1449l6.write(byteArray);
                c1449l2.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l6);
                if (i == 0) {
                    m11299a = m11299a(bVar.f9307a, bVar.f9310d);
                } else {
                    m11299a = m11299a(x509Certificate.getSubjectX500Principal().getName(), (byte[]) null);
                }
                if (m11299a != null) {
                    c1449l2.write(m11299a);
                }
                c1449l.m11388a((byte) 48, c1449l2);
            }
        }
        C1449l c1449l7 = new C1449l();
        c1449l7.m11388a((byte) 48, c1449l);
        byte[] m11300a = m11300a(c1449l7.toByteArray(), cArr);
        C1449l c1449l8 = new C1449l();
        C1449l c1449l9 = new C1449l();
        c1449l8.m11401b(0);
        c1449l8.write(m11300a);
        c1449l9.m11388a((byte) 48, c1449l8);
        return c1449l9.toByteArray();
    }

    /* renamed from: a */
    private byte[] m11298a() {
        C1449l c1449l = new C1449l();
        Enumeration<String> keys = this.f9300s.keys();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            b bVar = this.f9300s.get(nextElement);
            C1449l c1449l2 = new C1449l();
            c1449l2.m11394a(f9283b);
            try {
                C1425c c1425c = new C1425c(bVar.f9311e);
                C1449l c1449l3 = new C1449l();
                c1449l3.write(c1425c.m11247b());
                c1449l2.m11388a(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 0), c1449l3);
                c1449l2.write(m11299a(nextElement, bVar.f9310d));
                c1449l.m11388a((byte) 48, c1449l2);
            } catch (IOException e2) {
                throw new IOException("Private key not stored as PKCS#8 EncryptedPrivateKeyInfo" + e2.getMessage());
            }
        }
        C1449l c1449l4 = new C1449l();
        c1449l4.m11388a((byte) 48, c1449l);
        return c1449l4.toByteArray();
    }

    /* renamed from: a */
    private byte[] m11300a(byte[] bArr, char[] cArr) {
        AlgorithmParameters m11294a = m11294a("PBEWithSHA1AndRC2_40");
        C1449l c1449l = new C1449l();
        new C1505e(f9293l, m11294a).m11637a(c1449l);
        byte[] byteArray = c1449l.toByteArray();
        try {
            SecretKey m11303b = m11303b(cArr);
            Cipher cipher = Cipher.getInstance("PBEWithSHA1AndRC2_40");
            cipher.init(1, m11303b, m11294a);
            byte[] doFinal = cipher.doFinal(bArr);
            C1449l c1449l2 = new C1449l();
            c1449l2.m11394a(C1423a.f9190a);
            c1449l2.write(byteArray);
            C1449l c1449l3 = new C1449l();
            c1449l3.m11405b(doFinal);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 0), c1449l3);
            C1449l c1449l4 = new C1449l();
            c1449l4.m11388a((byte) 48, c1449l2);
            return c1449l4.toByteArray();
        } catch (Exception e2) {
            throw new IOException("Failed to encrypt safe contents entry: " + e2, e2);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) {
        byte[] doFinal;
        synchronized (this) {
            if (inputStream != null) {
                this.f9299r = 0;
                C1448k m11441v = new C1450m(inputStream).m11441v();
                if (m11441v.m11374f() != 3) {
                    throw new IOException("PKCS12 keystore not in version 3 format");
                }
                this.f9300s.clear();
                C1423a c1423a = new C1423a(m11441v);
                if (c1423a.m11244c().equals(C1423a.f9190a)) {
                    byte[] m11245d = c1423a.m11245d();
                    C1450m[] m11364a = new C1448k(m11245d).m11364a(2);
                    this.f9302u = 0;
                    for (C1450m c1450m : m11364a) {
                        C1423a c1423a2 = new C1423a(new C1448k(c1450m.m11440u()));
                        C1454q m11244c = c1423a2.m11244c();
                        if (m11244c.equals(C1423a.f9190a)) {
                            doFinal = c1423a2.m11245d();
                        } else if (m11244c.equals(C1423a.f9192c)) {
                            if (cArr == null) {
                                continue;
                            } else {
                                C1448k m11441v2 = c1423a2.m11241a().m11441v();
                                m11441v2.m11374f();
                                C1450m[] m11364a2 = m11441v2.m11364a(2);
                                m11364a2[0].m11431l();
                                m11364a2[1].m11440u();
                                if (!m11364a2[2].m11420b((byte) 0)) {
                                    throw new IOException("encrypted content not present!");
                                }
                                byte b2 = 4;
                                if (m11364a2[2].m11437r()) {
                                    b2 = (byte) 36;
                                }
                                m11364a2[2].m11422c(b2);
                                byte[] m11432m = m11364a2[2].m11432m();
                                C1448k m11441v3 = m11364a2[1].m11441v();
                                C1454q m11376h = m11441v3.m11376h();
                                AlgorithmParameters m11293a = m11293a(m11441v3);
                                int i = 0;
                                if (m11293a != null) {
                                    try {
                                        i = ((PBEParameterSpec) m11293a.getParameterSpec(PBEParameterSpec.class)).getIterationCount();
                                        if (i > 5000000) {
                                            throw new IOException("PBE iteration count too large");
                                        }
                                    } catch (InvalidParameterSpecException e2) {
                                        throw new IOException("Invalid PBE algorithm parameters");
                                    }
                                }
                                if (f9288g != null) {
                                    f9288g.m11333c("Loading PKCS#7 encryptedData (" + new C1505e(m11376h).m11642d() + " iterations: " + i + ")");
                                }
                                try {
                                    SecretKey m11303b = m11303b(cArr);
                                    Cipher cipher = Cipher.getInstance(m11376h.toString());
                                    cipher.init(2, m11303b, m11293a);
                                    doFinal = cipher.doFinal(m11432m);
                                } catch (Exception e3) {
                                    IOException iOException = new IOException("failed to decrypt safe contents entry: " + e3);
                                    iOException.initCause(e3);
                                    throw iOException;
                                }
                            }
                        } else {
                            throw new IOException("public key protected PKCS12 not supported");
                        }
                        m11296a(new C1448k(doFinal), cArr);
                    }
                    if (cArr != null && m11441v.m11362a() > 0) {
                        C1433a c1433a = new C1433a(m11441v);
                        int m11291d = c1433a.m11291d();
                        try {
                            if (m11291d > 5000000) {
                                throw new InvalidAlgorithmParameterException("MAC iteration count too large: " + m11291d);
                            }
                            String upperCase = c1433a.m11289b().toUpperCase();
                            if (upperCase.equals("SHA") || upperCase.equals("SHA1") || upperCase.equals(KeyProperties.DIGEST_SHA1)) {
                                upperCase = "SHA1";
                            }
                            Mac mac = Mac.getInstance("HmacPBE" + upperCase);
                            mac.init(m11303b(cArr), new PBEParameterSpec(c1433a.m11292e(), m11291d));
                            mac.update(m11245d);
                            if (!MessageDigest.isEqual(c1433a.m11288a(), mac.doFinal())) {
                                throw new SecurityException("Failed PKCS12 integrity checking");
                            }
                        } catch (Exception e4) {
                            throw new IOException("Integrity check failed: " + e4, e4);
                        }
                    }
                    for (b bVar : (b[]) this.f9301t.toArray(new b[this.f9301t.size()])) {
                        if (bVar.f9310d != null) {
                            ArrayList arrayList = new ArrayList();
                            X509Certificate m11295a = m11295a(bVar);
                            while (true) {
                                if (m11295a == null) {
                                    break;
                                }
                                if (!arrayList.isEmpty()) {
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        if (m11295a.equals((X509Certificate) it.next())) {
                                            if (f9288g != null) {
                                                f9288g.m11333c("Loop detected in certificate chain. Skip adding repeated cert to chain. Subject: " + m11295a.getSubjectX500Principal().toString());
                                            }
                                        }
                                    }
                                }
                                arrayList.add(m11295a);
                                X500Principal issuerX500Principal = m11295a.getIssuerX500Principal();
                                if (issuerX500Principal.equals(m11295a.getSubjectX500Principal())) {
                                    break;
                                } else {
                                    m11295a = this.f9298q.get(issuerX500Principal);
                                }
                            }
                            if (arrayList.size() > 0) {
                                bVar.f9308b = (Certificate[]) arrayList.toArray(new Certificate[arrayList.size()]);
                            }
                        }
                    }
                    this.f9297p.clear();
                    this.f9298q.clear();
                    this.f9301t.clear();
                } else {
                    throw new IOException("public key protected PKCS12 not supported");
                }
            }
        }
    }

    /* renamed from: a */
    private X509Certificate m11295a(b bVar) {
        Iterator<a> it = this.f9297p.iterator();
        a aVar = null;
        a aVar2 = null;
        while (it.hasNext()) {
            a next = it.next();
            if (Arrays.equals(bVar.f9310d, next.f9306c)) {
                if (bVar.f9307a.equalsIgnoreCase(next.f9304a)) {
                    return next.f9305b;
                }
                aVar2 = next;
            } else if (bVar.f9307a.equalsIgnoreCase(next.f9304a)) {
                aVar = next;
            }
        }
        if (aVar2 != null) {
            return aVar2.f9305b;
        }
        if (aVar != null) {
            return aVar.f9305b;
        }
        return null;
    }

    /* renamed from: a */
    private void m11296a(C1448k c1448k, char[] cArr) {
        C1450m[] c1450mArr;
        byte[] m11432m;
        C1450m[] m11364a = c1448k.m11364a(2);
        int length = m11364a.length;
        for (int i = 0; i < length; i++) {
            Object obj = null;
            C1448k m11441v = m11364a[i].m11441v();
            C1454q m11376h = m11441v.m11376h();
            C1450m m11371d = m11441v.m11371d();
            if (!m11371d.m11420b((byte) 0)) {
                throw new IOException("unsupported PKCS12 bag value type " + ((int) m11371d.f9357c));
            }
            C1450m m11371d2 = m11371d.f9356b.m11371d();
            if (m11376h.equals(f9283b)) {
                b bVar = new b(null);
                bVar.f9311e = m11371d2.m11440u();
                this.f9302u++;
                obj = bVar;
            } else if (m11376h.equals(f9282a)) {
                C1450m[] m11364a2 = new C1448k(m11371d2.m11440u()).m11364a(2);
                m11364a2[0].m11431l();
                if (!m11364a2[1].m11420b((byte) 0)) {
                    throw new IOException("unsupported PKCS12 cert value type " + ((int) m11364a2[1].f9357c));
                }
                obj = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(m11364a2[1].f9356b.m11371d().m11432m()));
            }
            try {
                c1450mArr = m11441v.m11368b(2);
            } catch (IOException e2) {
                c1450mArr = null;
            }
            String str = null;
            String str2 = null;
            byte[] bArr = null;
            if (c1450mArr == null) {
                bArr = null;
            } else {
                int i2 = 0;
                while (i2 < c1450mArr.length) {
                    C1450m[] m11364a3 = new C1448k(c1450mArr[i2].m11440u()).m11364a(2);
                    C1454q m11431l = m11364a3[0].m11431l();
                    try {
                        C1450m[] m11368b = new C1448k(m11364a3[1].m11440u()).m11368b(1);
                        if (m11431l.equals(f9285d)) {
                            str2 = m11368b[0].m11419b();
                            m11432m = bArr;
                        } else {
                            m11432m = m11431l.equals(f9286e) ? m11368b[0].m11432m() : bArr;
                        }
                        i2++;
                        bArr = m11432m;
                    } catch (IOException e3) {
                        throw new IOException("Attribute " + m11431l + " should have a value " + e3.getMessage());
                    }
                }
                str = str2;
            }
            if (obj instanceof b) {
                b bVar2 = (b) obj;
                if (bArr == null) {
                    if (this.f9302u == 1) {
                        bArr = "01".getBytes("UTF8");
                    }
                }
                bVar2.f9310d = bArr;
                String str3 = new String(bArr, "UTF8");
                Date date = null;
                if (str3.startsWith("Time ")) {
                    try {
                        date = new Date(Long.parseLong(str3.substring(5)));
                    } catch (Exception e4) {
                        date = null;
                    }
                }
                if (date == null) {
                    date = new Date();
                }
                bVar2.f9309c = date;
                this.f9301t.add(bVar2);
                String m11306c = str == null ? m11306c() : str;
                bVar2.f9307a = m11306c;
                this.f9300s.put(m11306c.toLowerCase(), bVar2);
            } else if (obj instanceof X509Certificate) {
                X509Certificate x509Certificate = (X509Certificate) obj;
                if (bArr == null && this.f9302u == 1 && i == 0) {
                    bArr = "01".getBytes("UTF8");
                }
                this.f9297p.add(new a(x509Certificate, bArr, str));
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                if (subjectX500Principal != null && !this.f9298q.containsKey(subjectX500Principal)) {
                    this.f9298q.put(subjectX500Principal, x509Certificate);
                }
            }
        }
    }

    /* renamed from: c */
    private String m11306c() {
        this.f9299r++;
        return String.valueOf(this.f9299r);
    }
}
