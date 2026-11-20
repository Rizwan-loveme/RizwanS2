package p165d.p167b.p169b;

import java.math.BigInteger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p173f.C1496bn;
import p165d.p167b.p173f.C1499bq;
import p165d.p167b.p173f.C1500br;
import p165d.p167b.p173f.C1501bs;
import p165d.p167b.p173f.C1505e;

/* compiled from: PKCS7.java */
/* renamed from: d.b.b.d */
/* loaded from: classes.dex */
public class C1426d {

    /* renamed from: a */
    private Principal[] f9221a;

    /* renamed from: b */
    private X509Certificate[] f9222b;

    /* renamed from: c */
    private C1423a f9223c;

    /* renamed from: d */
    private C1454q f9224d;

    /* renamed from: e */
    private X509CRL[] f9225e;

    /* renamed from: f */
    private C1505e[] f9226f;

    /* renamed from: g */
    private boolean f9227g;

    /* renamed from: h */
    private C1431i[] f9228h;

    /* renamed from: i */
    private BigInteger f9229i;

    public C1426d(byte[] bArr) {
        this.f9229i = null;
        this.f9226f = null;
        this.f9223c = null;
        this.f9222b = null;
        this.f9225e = null;
        this.f9228h = null;
        this.f9227g = false;
        try {
            m11249a(new C1448k(bArr));
        } catch (IOException e2) {
            C1430h c1430h = new C1430h("Unable to parse the encoded bytes");
            c1430h.initCause(e2);
            throw c1430h;
        }
    }

    /* renamed from: a */
    private void m11249a(C1448k c1448k) {
        try {
            c1448k.m11370c(c1448k.m11362a());
            m11250a(c1448k, false);
        } catch (IOException e2) {
            try {
                c1448k.m11381m();
                m11250a(c1448k, true);
                this.f9227g = true;
            } catch (IOException e3) {
                C1430h c1430h = new C1430h(e3.getMessage());
                c1430h.initCause(e3);
                throw c1430h;
            }
        }
    }

    /* renamed from: a */
    private void m11250a(C1448k c1448k, boolean z) {
        this.f9223c = new C1423a(c1448k, z);
        this.f9224d = this.f9223c.f9213m;
        C1450m m11241a = this.f9223c.m11241a();
        if (this.f9224d.equals(C1423a.f9199j)) {
            m11253c(m11241a);
        } else if (this.f9224d.equals(C1423a.f9196g)) {
            m11252b(m11241a);
        } else {
            if (this.f9224d.equals(C1423a.f9194e)) {
                m11251a(m11241a);
                return;
            }
            throw new C1430h("content type " + this.f9224d + " not supported.");
        }
    }

    public C1426d(C1505e[] c1505eArr, C1423a c1423a, X509Certificate[] x509CertificateArr, C1431i[] c1431iArr) {
        this.f9229i = null;
        this.f9226f = null;
        this.f9223c = null;
        this.f9222b = null;
        this.f9225e = null;
        this.f9228h = null;
        this.f9227g = false;
        this.f9229i = BigInteger.ONE;
        this.f9226f = c1505eArr;
        this.f9223c = c1423a;
        this.f9222b = x509CertificateArr;
        this.f9228h = c1431iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m11251a(C1450m c1450m) {
        CertificateFactory certificateFactory;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        CertificateException e2;
        Throwable th2;
        IOException e3;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3 = null;
        C1450m[] m11364a = new C1448k(c1450m.m11440u()).m11364a(2);
        this.f9222b = new X509Certificate[m11364a.length];
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e4) {
            certificateFactory = null;
        }
        for (int i = 0; i < m11364a.length; i++) {
            if (certificateFactory == null) {
                try {
                    this.f9222b[i] = new C1500br(m11364a[i]);
                } catch (IOException e5) {
                    e3 = e5;
                    byteArrayInputStream2 = null;
                    try {
                        C1430h c1430h = new C1430h(e3.getMessage());
                        c1430h.initCause(e3);
                        throw c1430h;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream3 = byteArrayInputStream2;
                        th2 = th;
                        byteArrayInputStream = byteArrayInputStream3;
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        throw th2;
                    }
                } catch (CertificateException e6) {
                    e2 = e6;
                    byteArrayInputStream = null;
                    try {
                        C1430h c1430h2 = new C1430h(e2.getMessage());
                        c1430h2.initCause(e2);
                        throw c1430h2;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream3 = byteArrayInputStream;
                        th2 = th;
                        byteArrayInputStream = byteArrayInputStream3;
                        if (byteArrayInputStream != null) {
                        }
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    th2 = th;
                    byteArrayInputStream = byteArrayInputStream3;
                    if (byteArrayInputStream != null) {
                    }
                    throw th2;
                }
            } else {
                byteArrayInputStream = new ByteArrayInputStream(m11364a[i].m11440u());
                try {
                    this.f9222b[i] = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                    byteArrayInputStream.close();
                } catch (IOException e7) {
                    e3 = e7;
                    byteArrayInputStream2 = byteArrayInputStream;
                    C1430h c1430h3 = new C1430h(e3.getMessage());
                    c1430h3.initCause(e3);
                    throw c1430h3;
                } catch (CertificateException e8) {
                    e2 = e8;
                    C1430h c1430h22 = new C1430h(e2.getMessage());
                    c1430h22.initCause(e2);
                    throw c1430h22;
                } catch (Throwable th6) {
                    th2 = th6;
                    if (byteArrayInputStream != null) {
                    }
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m11253c(C1450m c1450m) {
        CertificateFactory certificateFactory;
        ByteArrayInputStream byteArrayInputStream;
        CRLException e2;
        ByteArrayInputStream byteArrayInputStream2;
        CertificateException e3;
        IOException e4;
        ByteArrayInputStream byteArrayInputStream3 = null;
        C1448k m11441v = c1450m.m11441v();
        this.f9229i = m11441v.m11367b();
        C1450m[] m11368b = m11441v.m11368b(1);
        int length = m11368b.length;
        this.f9226f = new C1505e[length];
        for (int i = 0; i < length; i++) {
            try {
                this.f9226f[i] = C1505e.m11630a(m11368b[i]);
            } catch (IOException e5) {
                C1430h c1430h = new C1430h("Error parsing digest AlgorithmId IDs: " + e5.getMessage());
                c1430h.initCause(e5);
                throw c1430h;
            }
        }
        this.f9223c = new C1423a(m11441v);
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e6) {
            certificateFactory = null;
        }
        if (((byte) m11441v.m11380l()) == -96) {
            C1450m[] m11365a = m11441v.m11365a(2, true);
            int length2 = m11365a.length;
            this.f9222b = new X509Certificate[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                if (certificateFactory == null) {
                    try {
                        try {
                            this.f9222b[i2] = new C1500br(m11365a[i2]);
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream2 = byteArrayInputStream3;
                            if (byteArrayInputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        e4 = e7;
                        C1430h c1430h2 = new C1430h(e4.getMessage());
                        c1430h2.initCause(e4);
                        throw c1430h2;
                    } catch (CertificateException e8) {
                        e3 = e8;
                        byteArrayInputStream2 = null;
                        try {
                            C1430h c1430h3 = new C1430h(e3.getMessage());
                            c1430h3.initCause(e3);
                            throw c1430h3;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayInputStream3 = byteArrayInputStream2;
                            byteArrayInputStream2 = byteArrayInputStream3;
                            if (byteArrayInputStream2 != null) {
                                byteArrayInputStream2.close();
                            }
                            throw th;
                        }
                    }
                } else {
                    byteArrayInputStream2 = new ByteArrayInputStream(m11365a[i2].m11440u());
                    try {
                        this.f9222b[i2] = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream2);
                        byteArrayInputStream2.close();
                    } catch (IOException e9) {
                        e4 = e9;
                        byteArrayInputStream3 = byteArrayInputStream2;
                        C1430h c1430h22 = new C1430h(e4.getMessage());
                        c1430h22.initCause(e4);
                        throw c1430h22;
                    } catch (CertificateException e10) {
                        e3 = e10;
                        C1430h c1430h32 = new C1430h(e3.getMessage());
                        c1430h32.initCause(e3);
                        throw c1430h32;
                    } catch (Throwable th3) {
                        th = th3;
                        if (byteArrayInputStream2 != null) {
                        }
                        throw th;
                    }
                }
            }
        }
        if (((byte) m11441v.m11380l()) == -95) {
            C1450m[] m11365a2 = m11441v.m11365a(1, true);
            int length3 = m11365a2.length;
            this.f9225e = new X509CRL[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                if (certificateFactory == null) {
                    try {
                        this.f9225e[i3] = new C1499bq(m11365a2[i3]);
                    } catch (CRLException e11) {
                        e2 = e11;
                        byteArrayInputStream = null;
                        try {
                            C1430h c1430h4 = new C1430h(e2.getMessage());
                            c1430h4.initCause(e2);
                            throw c1430h4;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayInputStream3 = byteArrayInputStream;
                            byteArrayInputStream = byteArrayInputStream3;
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        byteArrayInputStream = byteArrayInputStream3;
                        if (byteArrayInputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    byteArrayInputStream = new ByteArrayInputStream(m11365a2[i3].m11440u());
                    try {
                        this.f9225e[i3] = (X509CRL) certificateFactory.generateCRL(byteArrayInputStream);
                        byteArrayInputStream.close();
                    } catch (CRLException e12) {
                        e2 = e12;
                        C1430h c1430h42 = new C1430h(e2.getMessage());
                        c1430h42.initCause(e2);
                        throw c1430h42;
                    } catch (Throwable th6) {
                        th = th6;
                        if (byteArrayInputStream != null) {
                        }
                        throw th;
                    }
                }
            }
        }
        C1450m[] m11368b2 = m11441v.m11368b(1);
        int length4 = m11368b2.length;
        this.f9228h = new C1431i[length4];
        for (int i4 = 0; i4 < length4; i4++) {
            this.f9228h[i4] = new C1431i(m11368b2[i4].m11441v());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m11252b(C1450m c1450m) {
        CertificateFactory certificateFactory;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream;
        CertificateException e2;
        Throwable th2;
        IOException iOException;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3 = null;
        C1448k m11441v = c1450m.m11441v();
        this.f9229i = m11441v.m11367b();
        C1450m[] m11368b = m11441v.m11368b(1);
        int length = m11368b.length;
        this.f9226f = new C1505e[length];
        for (int i = 0; i < length; i++) {
            try {
                this.f9226f[i] = C1505e.m11630a(m11368b[i]);
            } catch (IOException e3) {
                throw new C1430h("Error parsing digest AlgorithmId IDs");
            }
        }
        this.f9223c = new C1423a(m11441v, true);
        try {
            certificateFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e4) {
            certificateFactory = null;
        }
        C1450m[] m11368b2 = m11441v.m11368b(2);
        int length2 = m11368b2.length;
        this.f9222b = new X509Certificate[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            if (certificateFactory == null) {
                try {
                    this.f9222b[i2] = new C1500br(m11368b2[i2]);
                } catch (IOException e5) {
                    byteArrayInputStream2 = null;
                    iOException = e5;
                    try {
                        C1430h c1430h = new C1430h(iOException.getMessage());
                        c1430h.initCause(iOException);
                        throw c1430h;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream3 = byteArrayInputStream2;
                        byteArrayInputStream = byteArrayInputStream3;
                        th2 = th;
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        throw th2;
                    }
                } catch (CertificateException e6) {
                    e2 = e6;
                    byteArrayInputStream = null;
                    try {
                        C1430h c1430h2 = new C1430h(e2.getMessage());
                        c1430h2.initCause(e2);
                        throw c1430h2;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream3 = byteArrayInputStream;
                        byteArrayInputStream = byteArrayInputStream3;
                        th2 = th;
                        if (byteArrayInputStream != null) {
                        }
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = byteArrayInputStream3;
                    th2 = th;
                    if (byteArrayInputStream != null) {
                    }
                    throw th2;
                }
            } else {
                byteArrayInputStream = new ByteArrayInputStream(m11368b2[i2].m11440u());
                try {
                    this.f9222b[i2] = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                    byteArrayInputStream.close();
                } catch (IOException e7) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    iOException = e7;
                    C1430h c1430h3 = new C1430h(iOException.getMessage());
                    c1430h3.initCause(iOException);
                    throw c1430h3;
                } catch (CertificateException e8) {
                    e2 = e8;
                    C1430h c1430h22 = new C1430h(e2.getMessage());
                    c1430h22.initCause(e2);
                    throw c1430h22;
                } catch (Throwable th6) {
                    th2 = th6;
                    if (byteArrayInputStream != null) {
                    }
                    throw th2;
                }
            }
        }
        m11441v.m11368b(0);
        C1450m[] m11368b3 = m11441v.m11368b(1);
        int length3 = m11368b3.length;
        this.f9228h = new C1431i[length3];
        for (int i3 = 0; i3 < length3; i3++) {
            this.f9228h[i3] = new C1431i(m11368b3[i3].m11441v(), true);
        }
    }

    /* renamed from: a */
    public void m11258a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        m11257a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11257a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        c1449l2.m11396a(this.f9229i);
        c1449l2.m11390a((byte) 49, this.f9226f);
        this.f9223c.m11242a(c1449l2);
        if (this.f9222b != null && this.f9222b.length != 0) {
            C1500br[] c1500brArr = new C1500br[this.f9222b.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f9222b.length) {
                    break;
                }
                if (this.f9222b[i2] instanceof C1500br) {
                    c1500brArr[i2] = (C1500br) this.f9222b[i2];
                } else {
                    try {
                        c1500brArr[i2] = new C1500br(this.f9222b[i2].getEncoded());
                    } catch (CertificateException e2) {
                        throw new IOException(e2);
                    }
                }
                i = i2 + 1;
            }
            c1449l2.m11390a((byte) -96, c1500brArr);
        }
        c1449l2.m11390a((byte) 49, this.f9228h);
        new C1423a(C1423a.f9199j, new C1450m((byte) 48, c1449l2.toByteArray())).m11242a(c1449l);
    }

    /* renamed from: a */
    public C1431i m11255a(C1431i c1431i, byte[] bArr) {
        return c1431i.m11282a(this, bArr);
    }

    /* renamed from: b */
    public C1423a m11260b() {
        return this.f9223c;
    }

    /* renamed from: a */
    public X509Certificate[] m11259a() {
        if (this.f9222b != null) {
            return (X509Certificate[]) this.f9222b.clone();
        }
        return null;
    }

    /* renamed from: c */
    public C1431i[] m11261c() {
        return this.f9228h;
    }

    /* renamed from: a */
    public X509Certificate m11256a(BigInteger bigInteger, C1496bn c1496bn) {
        if (this.f9222b != null) {
            if (this.f9221a == null) {
                m11254d();
            }
            for (int i = 0; i < this.f9222b.length; i++) {
                X509Certificate x509Certificate = this.f9222b[i];
                if (bigInteger.equals(x509Certificate.getSerialNumber()) && c1496bn.equals(this.f9221a[i])) {
                    return x509Certificate;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    private void m11254d() {
        Principal principal;
        if (this.f9222b != null) {
            this.f9221a = new Principal[this.f9222b.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f9222b.length) {
                    X509Certificate x509Certificate = this.f9222b[i2];
                    Principal issuerDN = x509Certificate.getIssuerDN();
                    if (issuerDN instanceof C1496bn) {
                        principal = issuerDN;
                    } else {
                        try {
                            principal = (Principal) new C1501bs(x509Certificate.getTBSCertificate()).m11609a("issuer.dname");
                        } catch (Exception e2) {
                            principal = issuerDN;
                        }
                    }
                    this.f9221a[i2] = principal;
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public String toString() {
        String str;
        String str2 = String.valueOf("") + this.f9223c + "\n";
        if (this.f9229i != null) {
            str2 = String.valueOf(str2) + "PKCS7 :: version: " + C1444g.m11329a(this.f9229i) + "\n";
        }
        if (this.f9226f != null) {
            str = String.valueOf(str2) + "PKCS7 :: digest AlgorithmIds: \n";
            for (int i = 0; i < this.f9226f.length; i++) {
                str = String.valueOf(str) + "\t" + this.f9226f[i] + "\n";
            }
        } else {
            str = str2;
        }
        if (this.f9222b != null) {
            str = String.valueOf(str) + "PKCS7 :: certificates: \n";
            for (int i2 = 0; i2 < this.f9222b.length; i2++) {
                str = String.valueOf(str) + "\t" + i2 + ".   " + this.f9222b[i2] + "\n";
            }
        }
        if (this.f9225e != null) {
            str = String.valueOf(str) + "PKCS7 :: crls: \n";
            for (int i3 = 0; i3 < this.f9225e.length; i3++) {
                str = String.valueOf(str) + "\t" + i3 + ".   " + this.f9225e[i3] + "\n";
            }
        }
        if (this.f9228h == null) {
            return str;
        }
        String str3 = String.valueOf(str) + "PKCS7 :: signer infos: \n";
        for (int i4 = 0; i4 < this.f9228h.length; i4++) {
            str3 = String.valueOf(str3) + "\t" + i4 + ".  " + this.f9228h[i4] + "\n";
        }
        return str3;
    }
}
