package p165d.p167b.p173f;

import java.math.BigInteger;
import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeSet;
import javax.security.auth.x500.X500Principal;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: X509CRLEntryImpl.java */
/* renamed from: d.b.f.bp */
/* loaded from: classes.dex */
public class C1498bp extends X509CRLEntry implements Comparable<C1498bp> {

    /* renamed from: a */
    private X500Principal f9573a;

    /* renamed from: d */
    private byte[] f9576d;

    /* renamed from: e */
    private C1490bh f9577e = null;

    /* renamed from: c */
    private Date f9575c = null;

    /* renamed from: b */
    private C1510j f9574b = null;

    public C1498bp(C1450m c1450m) {
        this.f9576d = null;
        try {
            m11570a(c1450m);
        } catch (IOException e2) {
            this.f9576d = null;
            throw new CRLException("Parsing error: " + e2.toString());
        }
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean hasExtensions() {
        return this.f9574b != null;
    }

    /* renamed from: a */
    public void m11575a(C1449l c1449l) {
        try {
            if (this.f9576d == null) {
                C1449l c1449l2 = new C1449l();
                this.f9577e.m11544a(c1449l2);
                if (this.f9575c.getTime() < 2524636800000L) {
                    c1449l2.m11404b(this.f9575c);
                } else {
                    c1449l2.m11397a(this.f9575c);
                }
                if (this.f9574b != null) {
                    this.f9574b.m11656a(c1449l2, false);
                }
                C1449l c1449l3 = new C1449l();
                c1449l3.m11388a((byte) 48, c1449l2);
                this.f9576d = c1449l3.toByteArray();
            }
            c1449l.write(this.f9576d);
        } catch (IOException e2) {
            throw new CRLException("Encoding error: " + e2.toString());
        }
    }

    @Override // java.security.cert.X509CRLEntry
    public byte[] getEncoded() {
        return (byte[]) m11571b().clone();
    }

    /* renamed from: b */
    private byte[] m11571b() {
        if (this.f9576d == null) {
            m11575a(new C1449l());
        }
        return this.f9576d;
    }

    @Override // java.security.cert.X509CRLEntry
    public X500Principal getCertificateIssuer() {
        return this.f9573a;
    }

    /* renamed from: a */
    void m11576a(X500Principal x500Principal, X500Principal x500Principal2) {
        if (x500Principal.equals(x500Principal2)) {
            this.f9573a = null;
        } else {
            this.f9573a = x500Principal2;
        }
    }

    @Override // java.security.cert.X509CRLEntry
    public BigInteger getSerialNumber() {
        return this.f9577e.m11543a();
    }

    @Override // java.security.cert.X509CRLEntry
    public Date getRevocationDate() {
        return new Date(this.f9575c.getTime());
    }

    @Override // java.security.cert.X509CRLEntry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9577e.toString());
        sb.append("  On: " + this.f9575c.toString());
        if (this.f9573a != null) {
            sb.append("\n    Certificate issuer: " + this.f9573a);
        }
        if (this.f9574b != null) {
            C1463ah[] c1463ahArr = (C1463ah[]) this.f9574b.m11655a().toArray(new C1463ah[0]);
            sb.append("\n    CRL Entry Extensions: " + c1463ahArr.length);
            for (int i = 0; i < c1463ahArr.length; i++) {
                sb.append("\n    [" + (i + 1) + "]: ");
                C1463ah c1463ah = c1463ahArr[i];
                try {
                    if (C1478aw.m11520a(c1463ah.m11489c()) == null) {
                        sb.append(c1463ah.toString());
                        byte[] m11490d = c1463ah.m11490d();
                        if (m11490d != null) {
                            C1449l c1449l = new C1449l();
                            c1449l.m11405b(m11490d);
                            sb.append("Extension unknown: DER encoded OCTET string =\n" + new C1420b().m11234b(c1449l.toByteArray()) + "\n");
                        }
                    } else {
                        sb.append(c1463ah.toString());
                    }
                } catch (Exception e2) {
                    sb.append(", Error parsing this extension");
                }
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        if (this.f9574b == null) {
            return false;
        }
        return this.f9574b.m11658c();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        if (this.f9574b == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        for (C1463ah c1463ah : this.f9574b.m11655a()) {
            if (c1463ah.m11491e()) {
                treeSet.add(c1463ah.m11489c().toString());
            }
        }
        return treeSet;
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        if (this.f9574b == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        for (C1463ah c1463ah : this.f9574b.m11655a()) {
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
        if (this.f9574b == null) {
            return null;
        }
        try {
            String m11522b = C1478aw.m11522b(new C1454q(str));
            if (m11522b == null) {
                C1454q c1454q = new C1454q(str);
                Enumeration<C1463ah> m11657b = this.f9574b.m11657b();
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
                m11654a = this.f9574b.m11654a(m11522b);
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
    public C1463ah m11573a(C1454q c1454q) {
        if (this.f9574b == null) {
            return null;
        }
        return this.f9574b.m11654a(C1478aw.m11522b(c1454q));
    }

    /* renamed from: a */
    private void m11570a(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new CRLException("Invalid encoded RevokedCertificate, starting sequence tag missing.");
        }
        if (c1450m.f9356b.m11362a() == 0) {
            throw new CRLException("No data encoded for RevokedCertificates");
        }
        this.f9576d = c1450m.m11440u();
        this.f9577e = new C1490bh(c1450m.m11441v().m11371d());
        int m11380l = c1450m.f9356b.m11380l();
        if (((byte) m11380l) == 23) {
            this.f9575c = c1450m.f9356b.m11378j();
        } else if (((byte) m11380l) == 24) {
            this.f9575c = c1450m.f9356b.m11373e();
        } else {
            throw new CRLException("Invalid encoding for revocation date");
        }
        if (c1450m.f9356b.m11362a() != 0) {
            this.f9574b = new C1510j(c1450m.m11441v());
        }
    }

    /* renamed from: a */
    C1516p m11574a() {
        return (C1516p) m11573a(C1481az.f9487f);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1498bp c1498bp) {
        int compareTo = getSerialNumber().compareTo(c1498bp.getSerialNumber());
        if (compareTo == 0) {
            try {
                byte[] m11571b = m11571b();
                byte[] m11571b2 = c1498bp.m11571b();
                for (int i = 0; i < m11571b.length && i < m11571b2.length; i++) {
                    int i2 = m11571b[i] & 255;
                    int i3 = m11571b2[i] & 255;
                    if (i2 != i3) {
                        return i2 - i3;
                    }
                }
                return m11571b.length - m11571b2.length;
            } catch (CRLException e2) {
                return -1;
            }
        }
        return compareTo;
    }
}
