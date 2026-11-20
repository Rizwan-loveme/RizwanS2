package p165d.p167b.p173f;

import android.bluetooth.BluetoothHidDevice;
import java.math.BigInteger;
import java.io.IOException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.security.auth.x500.X500Principal;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: X509CRLImpl.java */
/* renamed from: d.b.f.bq */
/* loaded from: classes.dex */
public class C1499bq extends X509CRL {

    /* renamed from: a */
    private C1510j f9578a;

    /* renamed from: b */
    private C1505e f9579b;

    /* renamed from: c */
    private C1496bn f9580c;

    /* renamed from: d */
    private X500Principal f9581d;

    /* renamed from: e */
    private Date f9582e;

    /* renamed from: f */
    private boolean f9583f;

    /* renamed from: g */
    private List<X509CRLEntry> f9584g;

    /* renamed from: h */
    private Map<a, X509CRLEntry> f9585h;

    /* renamed from: i */
    private C1505e f9586i;

    /* renamed from: j */
    private byte[] f9587j;

    /* renamed from: k */
    private byte[] f9588k;

    /* renamed from: l */
    private byte[] f9589l;

    /* renamed from: m */
    private Date f9590m;

    /* renamed from: n */
    private String f9591n;

    /* renamed from: o */
    private PublicKey f9592o;

    /* renamed from: p */
    private int f9593p;

    private C1499bq() {
        this.f9588k = null;
        this.f9587j = null;
        this.f9589l = null;
        this.f9586i = null;
        this.f9580c = null;
        this.f9581d = null;
        this.f9590m = null;
        this.f9582e = null;
        this.f9585h = new TreeMap();
        this.f9584g = new LinkedList();
        this.f9578a = null;
        this.f9583f = false;
    }

    public C1499bq(C1450m c1450m) {
        this.f9588k = null;
        this.f9587j = null;
        this.f9589l = null;
        this.f9586i = null;
        this.f9580c = null;
        this.f9581d = null;
        this.f9590m = null;
        this.f9582e = null;
        this.f9585h = new TreeMap();
        this.f9584g = new LinkedList();
        this.f9578a = null;
        this.f9583f = false;
        try {
            m11578a(c1450m);
        } catch (IOException e2) {
            this.f9588k = null;
            throw new CRLException("Parsing error: " + e2.getMessage());
        }
    }

    /* renamed from: a */
    public byte[] m11579a() {
        if (this.f9588k == null) {
            throw new CRLException("Null CRL to encode");
        }
        return this.f9588k;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() {
        return (byte[]) m11579a().clone();
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey) {
        verify(publicKey, "");
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, String str) {
        Signature signature;
        synchronized (this) {
            if (str == null) {
                str = "";
            }
            if (this.f9592o == null || !this.f9592o.equals(publicKey) || !str.equals(this.f9591n)) {
                if (this.f9588k == null) {
                    throw new CRLException("Uninitialized CRL");
                }
                if (str.length() == 0) {
                    signature = Signature.getInstance(this.f9586i.m11642d());
                } else {
                    signature = Signature.getInstance(this.f9586i.m11642d(), str);
                }
                signature.initVerify(publicKey);
                if (this.f9589l == null) {
                    throw new CRLException("Uninitialized CRL");
                }
                signature.update(this.f9589l, 0, this.f9589l.length);
                if (!signature.verify(this.f9587j)) {
                    throw new SignatureException("Signature does not match.");
                }
                this.f9592o = publicKey;
                this.f9591n = str;
            }
        }
    }

    @Override // java.security.cert.CRL
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X.509 CRL v" + (this.f9593p + 1) + "\n");
        if (this.f9586i != null) {
            stringBuffer.append("Signature Algorithm: " + this.f9586i.toString() + ", OID=" + this.f9586i.m11643e().toString() + "\n");
        }
        if (this.f9580c != null) {
            stringBuffer.append("Issuer: " + this.f9580c.toString() + "\n");
        }
        if (this.f9590m != null) {
            stringBuffer.append("\nThis Update: " + this.f9590m.toString() + "\n");
        }
        if (this.f9582e != null) {
            stringBuffer.append("Next Update: " + this.f9582e.toString() + "\n");
        }
        if (this.f9584g.isEmpty()) {
            stringBuffer.append("\nNO certificates have been revoked\n");
        } else {
            stringBuffer.append("\nRevoked Certificates: " + this.f9584g.size());
            int i = 1;
            Iterator<X509CRLEntry> it = this.f9584g.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                stringBuffer.append("\n[" + i2 + "] " + it.next().toString());
                i = i2 + 1;
            }
        }
        if (this.f9578a != null) {
            Object[] array = this.f9578a.m11655a().toArray();
            stringBuffer.append("\nCRL Extensions: " + array.length);
            for (int i3 = 0; i3 < array.length; i3++) {
                stringBuffer.append("\n[" + (i3 + 1) + "]: ");
                C1463ah c1463ah = (C1463ah) array[i3];
                try {
                    if (C1478aw.m11520a(c1463ah.m11489c()) == null) {
                        stringBuffer.append(c1463ah.toString());
                        byte[] m11490d = c1463ah.m11490d();
                        if (m11490d != null) {
                            C1449l c1449l = new C1449l();
                            c1449l.m11405b(m11490d);
                            stringBuffer.append("Extension unknown: DER encoded OCTET string =\n" + new C1420b().m11234b(c1449l.toByteArray()) + "\n");
                        }
                    } else {
                        stringBuffer.append(c1463ah.toString());
                    }
                } catch (Exception e2) {
                    stringBuffer.append(", Error parsing this extension");
                }
            }
        }
        if (this.f9587j != null) {
            stringBuffer.append("\nSignature:\n" + new C1420b().m11234b(this.f9587j) + "\n");
        } else {
            stringBuffer.append("NOT signed yet\n");
        }
        return stringBuffer.toString();
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate certificate) {
        if (this.f9585h.isEmpty() || !(certificate instanceof X509Certificate)) {
            return false;
        }
        return this.f9585h.containsKey(new a((X509Certificate) certificate));
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.f9593p + 1;
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return this.f9580c;
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        if (this.f9581d == null) {
            this.f9581d = this.f9580c.m11564a();
        }
        return this.f9581d;
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return new Date(this.f9590m.getTime());
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        if (this.f9582e == null) {
            return null;
        }
        return new Date(this.f9582e.getTime());
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        if (this.f9585h.isEmpty()) {
            return null;
        }
        return this.f9585h.get(new a(getIssuerX500Principal(), bigInteger));
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(X509Certificate x509Certificate) {
        if (this.f9585h.isEmpty()) {
            return null;
        }
        return this.f9585h.get(new a(x509Certificate));
    }

    @Override // java.security.cert.X509CRL
    public Set<X509CRLEntry> getRevokedCertificates() {
        if (this.f9584g.isEmpty()) {
            return null;
        }
        return new TreeSet(this.f9584g);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() {
        if (this.f9589l == null) {
            throw new CRLException("Uninitialized CRL");
        }
        return (byte[]) this.f9589l.clone();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        if (this.f9587j == null) {
            return null;
        }
        return (byte[]) this.f9587j.clone();
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        if (this.f9586i == null) {
            return null;
        }
        return this.f9586i.m11642d();
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        if (this.f9586i == null) {
            return null;
        }
        return this.f9586i.m11643e().toString();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        if (this.f9586i == null) {
            return null;
        }
        try {
            return this.f9586i.m11641c();
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        if (this.f9578a == null) {
            return false;
        }
        return this.f9578a.m11658c();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        if (this.f9578a == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        for (C1463ah c1463ah : this.f9578a.m11655a()) {
            if (c1463ah.m11491e()) {
                treeSet.add(c1463ah.m11489c().toString());
            }
        }
        return treeSet;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        if (this.f9578a == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        for (C1463ah c1463ah : this.f9578a.m11655a()) {
            if (!c1463ah.m11491e()) {
                treeSet.add(c1463ah.m11489c().toString());
            }
        }
        return treeSet;
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        C1463ah m11654a;
        byte[] m11490d;
        if (this.f9578a == null) {
            return null;
        }
        try {
            String m11522b = C1478aw.m11522b(new C1454q(str));
            if (m11522b == null) {
                C1454q c1454q = new C1454q(str);
                Enumeration<C1463ah> m11657b = this.f9578a.m11657b();
                while (true) {
                    if (!m11657b.hasMoreElements()) {
                        m11654a = null;
                        break;
                    }
                    m11654a = m11657b.nextElement();
                    if (m11654a.m11489c().equals(c1454q)) {
                        break;
                    }
                }
            } else {
                m11654a = this.f9578a.m11654a(m11522b);
            }
            if (m11654a == null || (m11490d = m11654a.m11490d()) == null) {
                return null;
            }
            C1449l c1449l = new C1449l();
            c1449l.m11405b(m11490d);
            return c1449l.toByteArray();
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    private void m11578a(C1450m c1450m) {
        if (this.f9583f) {
            throw new CRLException("cannot over-write existing CRL");
        }
        if (c1450m.m11425f() == null || c1450m.f9357c != 48) {
            throw new CRLException("Invalid DER-encoded CRL data");
        }
        this.f9588k = c1450m.m11440u();
        C1450m[] c1450mArr = {c1450m.f9356b.m11371d(), c1450m.f9356b.m11371d(), c1450m.f9356b.m11371d()};
        if (c1450m.f9356b.m11362a() != 0) {
            throw new CRLException("signed overrun, bytes = " + c1450m.f9356b.m11362a());
        }
        if (c1450mArr[0].f9357c != 48) {
            throw new CRLException("signed CRL fields invalid");
        }
        this.f9586i = C1505e.m11630a(c1450mArr[1]);
        this.f9587j = c1450mArr[2].m11423d();
        if (c1450mArr[1].f9356b.m11362a() != 0) {
            throw new CRLException("AlgorithmId field overrun");
        }
        if (c1450mArr[2].f9356b.m11362a() != 0) {
            throw new CRLException("Signature field overrun");
        }
        this.f9589l = c1450mArr[0].m11440u();
        C1448k c1448k = c1450mArr[0].f9356b;
        this.f9593p = 0;
        if (((byte) c1448k.m11380l()) == 2) {
            this.f9593p = c1448k.m11374f();
            if (this.f9593p != 1) {
                throw new CRLException("Invalid version");
            }
        }
        C1505e m11630a = C1505e.m11630a(c1448k.m11371d());
        if (!m11630a.m11639a(this.f9586i)) {
            throw new CRLException("Signature algorithm mismatch");
        }
        this.f9579b = m11630a;
        this.f9580c = new C1496bn(c1448k);
        if (this.f9580c.m11567e()) {
            throw new CRLException("Empty issuer DN not allowed in X509CRLs");
        }
        byte m11380l = (byte) c1448k.m11380l();
        if (m11380l == 23) {
            this.f9590m = c1448k.m11378j();
        } else if (m11380l == 24) {
            this.f9590m = c1448k.m11373e();
        } else {
            throw new CRLException("Invalid encoding for thisUpdate (tag=" + ((int) m11380l) + ")");
        }
        if (c1448k.m11362a() != 0) {
            byte m11380l2 = (byte) c1448k.m11380l();
            if (m11380l2 == 23) {
                this.f9582e = c1448k.m11378j();
            } else if (m11380l2 == 24) {
                this.f9582e = c1448k.m11373e();
            }
            if (c1448k.m11362a() != 0) {
                byte m11380l3 = (byte) c1448k.m11380l();
                if (m11380l3 == 48 && (m11380l3 & BluetoothHidDevice.SUBCLASS1_COMBO) != 128) {
                    C1450m[] m11364a = c1448k.m11364a(4);
                    X500Principal issuerX500Principal = getIssuerX500Principal();
                    X500Principal x500Principal = issuerX500Principal;
                    for (C1450m c1450m2 : m11364a) {
                        C1498bp c1498bp = new C1498bp(c1450m2);
                        x500Principal = m11577a(c1498bp, x500Principal);
                        c1498bp.m11576a(issuerX500Principal, x500Principal);
                        this.f9585h.put(new a(x500Principal, c1498bp.getSerialNumber()), c1498bp);
                        this.f9584g.add(c1498bp);
                    }
                }
                if (c1448k.m11362a() != 0) {
                    C1450m m11371d = c1448k.m11371d();
                    if (m11371d.m11437r() && m11371d.m11420b((byte) 0)) {
                        this.f9578a = new C1510j(m11371d.f9356b);
                    }
                    this.f9583f = true;
                }
            }
        }
    }

    /* renamed from: a */
    private X500Principal m11577a(C1498bp c1498bp, X500Principal x500Principal) {
        C1516p m11574a = c1498bp.m11574a();
        if (m11574a != null) {
            return ((C1496bn) m11574a.m11674a("issuer").m11494a(0).m11492a()).m11564a();
        }
        return x500Principal;
    }

    /* compiled from: X509CRLImpl.java */
    /* renamed from: d.b.f.bq$a */
    private static final class a implements Comparable<a> {

        /* renamed from: a */
        volatile int f9594a;

        /* renamed from: b */
        final X500Principal f9595b;

        /* renamed from: c */
        final BigInteger f9596c;

        a(X500Principal x500Principal, BigInteger bigInteger) {
            this.f9594a = 0;
            this.f9595b = x500Principal;
            this.f9596c = bigInteger;
        }

        a(X509Certificate x509Certificate) {
            this(x509Certificate.getIssuerX500Principal(), x509Certificate.getSerialNumber());
        }

        /* renamed from: a */
        X500Principal m11581a() {
            return this.f9595b;
        }

        /* renamed from: b */
        BigInteger m11582b() {
            return this.f9596c;
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                if (!this.f9596c.equals(aVar.m11582b()) || !this.f9595b.equals(aVar.m11581a())) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            if (this.f9594a == 0) {
                this.f9594a = ((this.f9595b.hashCode() + 629) * 37) + this.f9596c.hashCode();
            }
            return this.f9594a;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int compareTo = this.f9595b.toString().compareTo(aVar.f9595b.toString());
            return compareTo != 0 ? compareTo : this.f9596c.compareTo(aVar.f9596c);
        }
    }
}
