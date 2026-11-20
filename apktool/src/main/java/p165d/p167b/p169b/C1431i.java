package p165d.p167b.p169b;

import java.math.BigInteger;
import java.p209io.IOException;
import java.p209io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1451n;
import p165d.p167b.p172e.C1452o;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p172e.EnumC1443f;
import p165d.p167b.p172e.InterfaceC1445h;
import p165d.p167b.p173f.C1475at;
import p165d.p167b.p173f.C1496bn;
import p165d.p167b.p173f.C1505e;

/* compiled from: SignerInfo.java */
/* renamed from: d.b.b.i */
/* loaded from: classes.dex */
public class C1431i implements InterfaceC1445h {

    /* renamed from: a */
    C1429g f9265a;

    /* renamed from: b */
    BigInteger f9266b;

    /* renamed from: c */
    C1505e f9267c;

    /* renamed from: d */
    C1505e f9268d;

    /* renamed from: e */
    byte[] f9269e;

    /* renamed from: f */
    C1496bn f9270f;

    /* renamed from: g */
    C1429g f9271g;

    /* renamed from: h */
    BigInteger f9272h;

    /* renamed from: m */
    private boolean f9273m;

    /* renamed from: i */
    private static final Set<EnumC1443f> f9261i = Collections.unmodifiableSet(EnumSet.m13452of(EnumC1443f.MESSAGE_DIGEST));

    /* renamed from: k */
    private static final Set<EnumC1443f> f9263k = Collections.unmodifiableSet(EnumSet.m13452of(EnumC1443f.SIGNATURE));

    /* renamed from: j */
    private static final C1451n f9262j = new C1451n("jdk.jar.disabledAlgorithms");

    /* renamed from: l */
    private static final C1444g f9264l = C1444g.m11327a("jar");

    public C1431i(C1496bn c1496bn, BigInteger bigInteger, C1505e c1505e, C1505e c1505e2, byte[] bArr) {
        this.f9273m = true;
        this.f9272h = BigInteger.ONE;
        this.f9270f = c1496bn;
        this.f9266b = bigInteger;
        this.f9267c = c1505e;
        this.f9268d = c1505e2;
        this.f9269e = bArr;
    }

    public C1431i(C1448k c1448k) {
        this(c1448k, false);
    }

    public C1431i(C1448k c1448k, boolean z) {
        this.f9273m = true;
        this.f9272h = c1448k.m11367b();
        C1450m[] m11364a = c1448k.m11364a(2);
        this.f9270f = new C1496bn(new C1450m((byte) 48, m11364a[0].m11440u()));
        this.f9266b = m11364a[1].m11421c();
        this.f9267c = C1505e.m11630a(c1448k.m11371d());
        if (z) {
            c1448k.m11368b(0);
        } else if (((byte) c1448k.m11380l()) == -96) {
            this.f9265a = new C1429g(c1448k);
        }
        this.f9268d = C1505e.m11630a(c1448k.m11371d());
        this.f9269e = c1448k.m11377i();
        if (z) {
            c1448k.m11368b(0);
        } else if (c1448k.m11362a() != 0 && ((byte) c1448k.m11380l()) == -95) {
            this.f9271g = new C1429g(c1448k, true);
        }
        if (c1448k.m11362a() != 0) {
            throw new C1430h("extra data at the end");
        }
    }

    @Override // p165d.p167b.p172e.InterfaceC1445h
    /* renamed from: a */
    public void mo11272a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        c1449l.m11396a(this.f9272h);
        C1449l c1449l2 = new C1449l();
        this.f9270f.mo11479a(c1449l2);
        c1449l2.m11396a(this.f9266b);
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9267c.m11637a(c1449l);
        if (this.f9265a != null) {
            this.f9265a.m11279a((byte) -96, c1449l);
        }
        this.f9268d.m11637a(c1449l);
        c1449l.m11405b(this.f9269e);
        if (this.f9271g != null) {
            this.f9271g.m11279a((byte) -95, c1449l);
        }
        C1449l c1449l3 = new C1449l();
        c1449l3.m11388a((byte) 48, c1449l);
        outputStream.write(c1449l3.toByteArray());
    }

    /* renamed from: a */
    public X509Certificate m11284a(C1426d c1426d) {
        return c1426d.m11256a(this.f9266b, this.f9270f);
    }

    /* renamed from: b */
    public ArrayList<X509Certificate> m11286b(C1426d c1426d) {
        boolean z;
        X509Certificate m11256a = c1426d.m11256a(this.f9266b, this.f9270f);
        if (m11256a == null) {
            return null;
        }
        ArrayList<X509Certificate> arrayList = new ArrayList<>();
        arrayList.add(m11256a);
        X509Certificate[] m11259a = c1426d.m11259a();
        if (m11259a == null || m11256a.getSubjectDN().equals(m11256a.getIssuerDN())) {
            return arrayList;
        }
        Principal issuerDN = m11256a.getIssuerDN();
        int i = 0;
        do {
            int i2 = i;
            while (true) {
                if (i2 >= m11259a.length) {
                    z = false;
                    break;
                }
                if (issuerDN.equals(m11259a[i2].getSubjectDN())) {
                    arrayList.add(m11259a[i2]);
                    if (m11259a[i2].getSubjectDN().equals(m11259a[i2].getIssuerDN())) {
                        i = m11259a.length;
                    } else {
                        issuerDN = m11259a[i2].getIssuerDN();
                        X509Certificate x509Certificate = m11259a[i];
                        m11259a[i] = m11259a[i2];
                        m11259a[i2] = x509Certificate;
                        i++;
                    }
                    z = true;
                } else {
                    i2++;
                }
            }
        } while (z);
        return arrayList;
    }

    /* renamed from: a */
    C1431i m11282a(C1426d c1426d, byte[] bArr) {
        byte[] m11280a;
        try {
            try {
                C1423a m11260b = c1426d.m11260b();
                byte[] m11243b = bArr == null ? m11260b.m11243b() : bArr;
                String m11642d = m11283a().m11642d();
                if (this.f9265a == null) {
                    m11280a = m11243b;
                } else {
                    C1454q c1454q = (C1454q) this.f9265a.m11281b(C1428f.f9235b);
                    if (c1454q == null || !c1454q.equals(m11260b.f9213m)) {
                        return null;
                    }
                    byte[] bArr2 = (byte[]) this.f9265a.m11281b(C1428f.f9241h);
                    if (bArr2 == null) {
                        return null;
                    }
                    if (!f9262j.m11444a(f9261i, m11642d, (AlgorithmParameters) null)) {
                        throw new SignatureException("Digest check failed. Disabled algorithm used: " + m11642d);
                    }
                    byte[] digest = MessageDigest.getInstance(C1505e.m11634c(m11642d)).digest(m11243b);
                    if (bArr2.length != digest.length) {
                        return null;
                    }
                    for (int i = 0; i < bArr2.length; i++) {
                        if (bArr2[i] != digest[i]) {
                            return null;
                        }
                    }
                    m11280a = this.f9265a.m11280a();
                }
                String m11642d2 = m11285b().m11642d();
                String m11633b = C1505e.m11633b(m11642d2);
                if (m11633b == null) {
                    m11633b = m11642d2;
                }
                String m11632a = C1505e.m11632a(m11642d, m11633b);
                if (!f9262j.m11444a(f9263k, m11632a, (AlgorithmParameters) null)) {
                    throw new SignatureException("Signature check failed. Disabled algorithm used: " + m11632a);
                }
                X509Certificate m11284a = m11284a(c1426d);
                PublicKey publicKey = m11284a.getPublicKey();
                if (m11284a == null) {
                    return null;
                }
                if (!f9262j.m11445a(f9263k, publicKey)) {
                    throw new SignatureException("Public key check failed. Disabled key used: " + C1452o.m11451a(publicKey) + " bit " + publicKey.getAlgorithm());
                }
                if (m11284a.hasUnsupportedCriticalExtension()) {
                    throw new SignatureException("Certificate has unsupported critical extension(s)");
                }
                boolean[] keyUsage = m11284a.getKeyUsage();
                if (keyUsage != null) {
                    try {
                        C1475at c1475at = new C1475at(keyUsage);
                        boolean booleanValue = c1475at.m11515a("digital_signature").booleanValue();
                        boolean booleanValue2 = c1475at.m11515a("non_repudiation").booleanValue();
                        if (!booleanValue && !booleanValue2) {
                            throw new SignatureException("Key usage restricted: cannot be used for digital signatures");
                        }
                    } catch (IOException e2) {
                        throw new SignatureException("Failed to parse keyUsage extension");
                    }
                }
                Signature signature = Signature.getInstance(m11632a);
                signature.initVerify(publicKey);
                signature.update(m11280a);
                if (signature.verify(this.f9269e)) {
                    return this;
                }
                return null;
            } catch (IOException e3) {
                throw new SignatureException("IO error verifying signature:\n" + e3.getMessage());
            }
        } catch (InvalidKeyException e4) {
            throw new SignatureException("InvalidKey: " + e4.getMessage());
        }
    }

    /* renamed from: a */
    public C1505e m11283a() {
        return this.f9267c;
    }

    /* renamed from: b */
    public C1505e m11285b() {
        return this.f9268d;
    }

    public String toString() {
        C1420b c1420b = new C1420b();
        String str = String.valueOf(String.valueOf(String.valueOf(String.valueOf("") + "Signer Info for (issuer): " + this.f9270f + "\n") + "\tversion: " + C1444g.m11329a(this.f9272h) + "\n") + "\tcertificateSerialNumber: " + C1444g.m11329a(this.f9266b) + "\n") + "\tdigestAlgorithmId: " + this.f9267c + "\n";
        if (this.f9265a != null) {
            str = String.valueOf(str) + "\tauthenticatedAttributes: " + this.f9265a + "\n";
        }
        String str2 = String.valueOf(String.valueOf(str) + "\tdigestEncryptionAlgorithmId: " + this.f9268d + "\n") + "\tencryptedDigest: \n" + c1420b.m11234b(this.f9269e) + "\n";
        if (this.f9271g != null) {
            return String.valueOf(str2) + "\tunauthenticatedAttributes: " + this.f9271g + "\n";
        }
        return str2;
    }
}
