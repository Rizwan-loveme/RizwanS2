package p165d.p167b.p173f;

import android.provider.Contacts;
import android.provider.DocumentsContract;
import java.math.BigInteger;
import java.p209io.IOException;
import java.p209io.OutputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import javax.security.auth.x500.X500Principal;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p172e.InterfaceC1445h;

/* compiled from: X509CertImpl.java */
/* renamed from: d.b.f.br */
/* loaded from: classes.dex */
public class C1500br extends X509Certificate implements InterfaceC1445h {

    /* renamed from: a */
    protected C1505e f9597a;

    /* renamed from: b */
    protected C1501bs f9598b;

    /* renamed from: c */
    protected byte[] f9599c;

    /* renamed from: d */
    private List<String> f9600d;

    /* renamed from: e */
    private ConcurrentHashMap<String, String> f9601e;

    /* renamed from: f */
    private Collection<List<?>> f9602f;

    /* renamed from: g */
    private boolean f9603g;

    /* renamed from: h */
    private byte[] f9604h;

    /* renamed from: i */
    private Collection<List<?>> f9605i;

    /* renamed from: j */
    private boolean f9606j;

    /* renamed from: k */
    private String f9607k;

    /* renamed from: l */
    private PublicKey f9608l;

    public C1500br() {
        this.f9603g = false;
        this.f9604h = null;
        this.f9598b = null;
        this.f9597a = null;
        this.f9599c = null;
        this.f9601e = new ConcurrentHashMap<>(2);
    }

    public C1500br(byte[] bArr) {
        this.f9603g = false;
        this.f9604h = null;
        this.f9598b = null;
        this.f9597a = null;
        this.f9599c = null;
        this.f9601e = new ConcurrentHashMap<>(2);
        try {
            m11585a(new C1450m(bArr));
        } catch (IOException e2) {
            this.f9604h = null;
            CertificateException certificateException = new CertificateException("Unable to initialize, " + e2);
            certificateException.initCause(e2);
            throw certificateException;
        }
    }

    public C1500br(C1501bs c1501bs) {
        this.f9603g = false;
        this.f9604h = null;
        this.f9598b = null;
        this.f9597a = null;
        this.f9599c = null;
        this.f9601e = new ConcurrentHashMap<>(2);
        this.f9598b = c1501bs;
    }

    public C1500br(C1450m c1450m) {
        this.f9603g = false;
        this.f9604h = null;
        this.f9598b = null;
        this.f9597a = null;
        this.f9599c = null;
        this.f9601e = new ConcurrentHashMap<>(2);
        try {
            m11585a(c1450m);
        } catch (IOException e2) {
            this.f9604h = null;
            CertificateException certificateException = new CertificateException("Unable to initialize, " + e2);
            certificateException.initCause(e2);
            throw certificateException;
        }
    }

    @Override // p165d.p167b.p172e.InterfaceC1445h
    /* renamed from: a */
    public void mo11272a(OutputStream outputStream) {
        if (this.f9604h == null) {
            throw new IOException("Null certificate to encode");
        }
        outputStream.write((byte[]) this.f9604h.clone());
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        return (byte[]) m11590a().clone();
    }

    /* renamed from: a */
    public byte[] m11590a() {
        if (this.f9604h == null) {
            throw new CertificateEncodingException("Null certificate to encode");
        }
        return this.f9604h;
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) {
        verify(publicKey, "");
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) {
        Signature signature;
        synchronized (this) {
            if (str == null) {
                str = "";
            }
            if (this.f9608l != null && this.f9608l.equals(publicKey) && str.equals(this.f9607k)) {
                if (!this.f9606j) {
                    throw new SignatureException("Signature does not match.");
                }
            } else {
                if (this.f9604h == null) {
                    throw new CertificateEncodingException("Uninitialized certificate");
                }
                if (str.length() == 0) {
                    signature = Signature.getInstance(this.f9597a.m11642d());
                } else {
                    signature = Signature.getInstance(this.f9597a.m11642d(), str);
                }
                signature.initVerify(publicKey);
                byte[] m11612b = this.f9598b.m11612b();
                signature.update(m11612b, 0, m11612b.length);
                this.f9606j = signature.verify(this.f9599c);
                this.f9608l = publicKey;
                this.f9607k = str;
                if (!this.f9606j) {
                    throw new SignatureException("Signature does not match.");
                }
            }
        }
    }

    /* renamed from: a */
    public void m11588a(PrivateKey privateKey, String str) {
        m11589a(privateKey, str, null);
    }

    /* renamed from: a */
    public void m11589a(PrivateKey privateKey, String str, String str2) {
        Signature signature;
        try {
            if (this.f9603g) {
                throw new CertificateEncodingException("cannot over-write existing certificate");
            }
            if (str2 == null || str2.length() == 0) {
                signature = Signature.getInstance(str);
            } else {
                signature = Signature.getInstance(str, str2);
            }
            signature.initSign(privateKey);
            this.f9597a = C1505e.m11631a(signature.getAlgorithm());
            C1449l c1449l = new C1449l();
            C1449l c1449l2 = new C1449l();
            this.f9598b.mo11475a((OutputStream) c1449l2);
            byte[] byteArray = c1449l2.toByteArray();
            this.f9597a.m11637a(c1449l2);
            signature.update(byteArray, 0, byteArray.length);
            this.f9599c = signature.sign();
            c1449l2.m11399a(this.f9599c);
            c1449l.m11388a((byte) 48, c1449l2);
            this.f9604h = c1449l.toByteArray();
            this.f9603g = true;
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) {
        try {
            C1525y c1525y = (C1525y) this.f9598b.m11609a("validity");
            if (c1525y == null) {
                throw new CertificateNotYetValidException("Null validity period");
            }
            c1525y.m11694a(date);
        } catch (Exception e2) {
            throw new CertificateNotYetValidException("Incorrect validity period");
        }
    }

    /* renamed from: a */
    public Object m11587a(String str) {
        C1497bo c1497bo = new C1497bo(str);
        String m11568a = c1497bo.m11568a();
        if (!m11568a.equalsIgnoreCase("x509")) {
            throw new CertificateParsingException("Invalid root of attribute name, expected [x509], received [" + m11568a + "]");
        }
        C1497bo c1497bo2 = new C1497bo(c1497bo.m11569b());
        String m11568a2 = c1497bo2.m11568a();
        if (m11568a2.equalsIgnoreCase(DocumentsContract.EXTRA_INFO)) {
            if (this.f9598b == null) {
                return null;
            }
            if (c1497bo2.m11569b() != null) {
                try {
                    return this.f9598b.m11609a(c1497bo2.m11569b());
                } catch (IOException e2) {
                    throw new CertificateParsingException(e2.toString());
                } catch (CertificateException e3) {
                    throw new CertificateParsingException(e3.toString());
                }
            }
            return this.f9598b;
        }
        if (m11568a2.equalsIgnoreCase("algorithm")) {
            return this.f9597a;
        }
        if (m11568a2.equalsIgnoreCase("signature")) {
            if (this.f9599c != null) {
                return this.f9599c.clone();
            }
            return null;
        }
        if (m11568a2.equalsIgnoreCase("signed_cert")) {
            if (this.f9604h != null) {
                return this.f9604h.clone();
            }
            return null;
        }
        throw new CertificateParsingException("Attribute name not recognized or get() not allowed for the same: " + m11568a2);
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        if (this.f9598b == null || this.f9597a == null || this.f9599c == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        sb.append(String.valueOf(this.f9598b.toString()) + "\n");
        sb.append("  Algorithm: [" + this.f9597a.toString() + "]\n");
        sb.append("  Signature:\n" + new C1420b().m11234b(this.f9599c));
        sb.append("\n]");
        return sb.toString();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (PublicKey) this.f9598b.m11609a("key.value");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        if (this.f9598b == null) {
            return -1;
        }
        try {
            return ((Integer) this.f9598b.m11609a("version.number")).intValue() + 1;
        } catch (Exception e2) {
            return -1;
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        C1490bh m11593d = m11593d();
        if (m11593d != null) {
            return m11593d.m11543a();
        }
        return null;
    }

    /* renamed from: d */
    public C1490bh m11593d() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (C1490bh) this.f9598b.m11609a("serialNumber.number");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (Principal) this.f9598b.m11609a("subject.dname");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (X500Principal) this.f9598b.m11609a("subject.x500principal");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (Principal) this.f9598b.m11609a("issuer.dname");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (X500Principal) this.f9598b.m11609a("issuer.x500principal");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (Date) this.f9598b.m11609a("validity.notBefore");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            return (Date) this.f9598b.m11609a("validity.notAfter");
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        if (this.f9598b != null) {
            return this.f9598b.m11612b();
        }
        throw new CertificateEncodingException("Uninitialized certificate");
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        if (this.f9599c == null) {
            return null;
        }
        return (byte[]) this.f9599c.clone();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        if (this.f9597a == null) {
            return null;
        }
        return this.f9597a.m11642d();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        if (this.f9597a == null) {
            return null;
        }
        return this.f9597a.m11643e().toString();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        if (this.f9597a == null) {
            return null;
        }
        try {
            return this.f9597a.m11641c();
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            C1494bl c1494bl = (C1494bl) this.f9598b.m11609a("issuerID.id");
            if (c1494bl != null) {
                return c1494bl.m11554a();
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            C1494bl c1494bl = (C1494bl) this.f9598b.m11609a("subjectID.id");
            if (c1494bl != null) {
                return c1494bl.m11554a();
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: b */
    public C1462ag m11591b() {
        return (C1462ag) m11586a(C1481az.f9490i);
    }

    /* renamed from: c */
    public C1472aq m11592c() {
        return (C1472aq) m11586a(C1481az.f9495n);
    }

    /* renamed from: e */
    public C1491bi m11594e() {
        return (C1491bi) m11586a(C1481az.f9503v);
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        if (this.f9598b == null) {
            return false;
        }
        try {
            C1515o c1515o = (C1515o) this.f9598b.m11609a(Contacts.People.Extensions.CONTENT_DIRECTORY);
            if (c1515o != null) {
                return c1515o.m11672d();
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            C1515o c1515o = (C1515o) this.f9598b.m11609a(Contacts.People.Extensions.CONTENT_DIRECTORY);
            if (c1515o == null) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            for (C1463ah c1463ah : c1515o.m11670b()) {
                if (c1463ah.m11491e()) {
                    treeSet.add(c1463ah.m11489c().toString());
                }
            }
            return treeSet;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        if (this.f9598b == null) {
            return null;
        }
        try {
            C1515o c1515o = (C1515o) this.f9598b.m11609a(Contacts.People.Extensions.CONTENT_DIRECTORY);
            if (c1515o == null) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            for (C1463ah c1463ah : c1515o.m11670b()) {
                if (!c1463ah.m11491e()) {
                    treeSet.add(c1463ah.m11489c().toString());
                }
            }
            treeSet.addAll(c1515o.m11671c().keySet());
            return treeSet;
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    public C1463ah m11586a(C1454q c1454q) {
        if (this.f9598b == null) {
            return null;
        }
        try {
            try {
                C1515o c1515o = (C1515o) this.f9598b.m11609a(Contacts.People.Extensions.CONTENT_DIRECTORY);
                if (c1515o == null) {
                    return null;
                }
                C1463ah m11669b = c1515o.m11669b(c1454q.toString());
                if (m11669b != null) {
                    return m11669b;
                }
                for (C1463ah c1463ah : c1515o.m11670b()) {
                    if (c1463ah.m11489c().equals(c1454q)) {
                        return c1463ah;
                    }
                }
                return null;
            } catch (IOException e2) {
                return null;
            }
        } catch (CertificateException e3) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        C1463ah c1463ah;
        C1463ah c1463ah2;
        try {
            C1454q c1454q = new C1454q(str);
            String m11522b = C1478aw.m11522b(c1454q);
            C1515o c1515o = (C1515o) this.f9598b.m11609a(Contacts.People.Extensions.CONTENT_DIRECTORY);
            if (m11522b == null) {
                if (c1515o == null) {
                    return null;
                }
                Iterator<C1463ah> it = c1515o.m11670b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        c1463ah = null;
                        break;
                    }
                    c1463ah = it.next();
                    if (c1463ah.m11489c().equals(c1454q)) {
                        break;
                    }
                }
            } else {
                try {
                    c1463ah = (C1463ah) m11587a(m11522b);
                } catch (CertificateException e2) {
                    c1463ah = null;
                }
            }
            if (c1463ah == null) {
                c1463ah2 = c1515o != null ? c1515o.m11671c().get(str) : c1463ah;
                if (c1463ah2 == null) {
                    return null;
                }
            } else {
                c1463ah2 = c1463ah;
            }
            byte[] m11490d = c1463ah2.m11490d();
            if (m11490d == null) {
                return null;
            }
            C1449l c1449l = new C1449l();
            c1449l.m11405b(m11490d);
            return c1449l.toByteArray();
        } catch (Exception e3) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        C1475at c1475at;
        try {
            String m11522b = C1478aw.m11522b(C1481az.f9497p);
            if (m11522b != null && (c1475at = (C1475at) m11587a(m11522b)) != null) {
                boolean[] m11516b = c1475at.m11516b();
                if (m11516b.length >= 9) {
                    return m11516b;
                }
                boolean[] zArr = new boolean[9];
                System.arraycopy(m11516b, 0, zArr, 0, m11516b.length);
                return zArr;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public List<String> getExtendedKeyUsage() {
        List<String> list;
        synchronized (this) {
            if (this.f9603g && this.f9600d != null) {
                list = this.f9600d;
            } else {
                C1462ag m11591b = m11591b();
                if (m11591b == null) {
                    list = null;
                } else {
                    this.f9600d = Collections.unmodifiableList(m11591b.m11487b());
                    list = this.f9600d;
                }
            }
        }
        return list;
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        C1508h c1508h;
        try {
            String m11522b = C1478aw.m11522b(C1481az.f9484c);
            if (m11522b != null && (c1508h = (C1508h) m11587a(m11522b)) != null && ((Boolean) c1508h.m11649a("is_ca")).booleanValue()) {
                return ((Integer) c1508h.m11649a("path_len")).intValue();
            }
            return -1;
        } catch (Exception e2) {
            return -1;
        }
    }

    /* renamed from: a */
    private static Collection<List<?>> m11583a(C1467al c1467al) {
        if (c1467al.m11497a()) {
            return Collections.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C1465aj> it = c1467al.m11498b().iterator();
        while (it.hasNext()) {
            InterfaceC1466ak m11492a = it.next().m11492a();
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(Integer.valueOf(m11492a.mo11480b()));
            switch (m11492a.mo11480b()) {
                case 1:
                    arrayList2.add(((C1488bf) m11492a).m11538a());
                    break;
                case 2:
                    arrayList2.add(((C1457ab) m11492a).m11478a());
                    break;
                case 3:
                case 5:
                default:
                    C1449l c1449l = new C1449l();
                    try {
                        m11492a.mo11479a(c1449l);
                        arrayList2.add(c1449l.toByteArray());
                        break;
                    } catch (IOException e2) {
                        throw new RuntimeException("name cannot be encoded", e2);
                    }
                case 4:
                    arrayList2.add(((C1496bn) m11492a).m11566d());
                    break;
                case 6:
                    arrayList2.add(((C1493bk) m11492a).m11551d());
                    break;
                case 7:
                    try {
                        arrayList2.add(((C1470ao) m11492a).m11506a());
                        break;
                    } catch (IOException e3) {
                        throw new RuntimeException("IPAddress cannot be parsed", e3);
                    }
                case 8:
                    arrayList2.add(((C1479ax) m11492a).m11524a().toString());
                    break;
            }
            arrayList.add(Collections.unmodifiableList(arrayList2));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* renamed from: a */
    private static Collection<List<?>> m11584a(Collection<List<?>> collection) {
        Iterator<List<?>> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().get(1) instanceof byte[]) {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (List<?> list : collection) {
                Object obj = list.get(1);
                if (obj instanceof byte[]) {
                    ArrayList arrayList2 = new ArrayList(list);
                    arrayList2.set(1, ((byte[]) obj).clone());
                    arrayList.add(Collections.unmodifiableList(arrayList2));
                } else {
                    arrayList.add(list);
                }
            }
            return Collections.unmodifiableCollection(arrayList);
        }
        return collection;
    }

    @Override // java.security.cert.X509Certificate
    public Collection<List<?>> getSubjectAlternativeNames() {
        Collection<List<?>> emptySet;
        synchronized (this) {
            if (this.f9603g && this.f9605i != null) {
                emptySet = m11584a(this.f9605i);
            } else {
                C1491bi m11594e = m11594e();
                if (m11594e == null) {
                    emptySet = null;
                } else {
                    try {
                        this.f9605i = m11583a(m11594e.m11546a("subject_name"));
                        emptySet = this.f9605i;
                    } catch (IOException e2) {
                        emptySet = Collections.emptySet();
                    }
                }
            }
        }
        return emptySet;
    }

    @Override // java.security.cert.X509Certificate
    public Collection<List<?>> getIssuerAlternativeNames() {
        Collection<List<?>> emptySet;
        synchronized (this) {
            if (this.f9603g && this.f9602f != null) {
                emptySet = m11584a(this.f9602f);
            } else {
                C1472aq m11592c = m11592c();
                if (m11592c == null) {
                    emptySet = null;
                } else {
                    try {
                        this.f9602f = m11583a(m11592c.m11509a("issuer_name"));
                        emptySet = this.f9602f;
                    } catch (IOException e2) {
                        emptySet = Collections.emptySet();
                    }
                }
            }
        }
        return emptySet;
    }

    /* renamed from: a */
    private void m11585a(C1450m c1450m) {
        if (this.f9603g) {
            throw new CertificateParsingException("cannot over-write existing certificate");
        }
        if (c1450m.f9356b == null || c1450m.f9357c != 48) {
            throw new CertificateParsingException("invalid DER-encoded certificate data");
        }
        this.f9604h = c1450m.m11440u();
        C1450m[] c1450mArr = {c1450m.f9356b.m11371d(), c1450m.f9356b.m11371d(), c1450m.f9356b.m11371d()};
        if (c1450m.f9356b.m11362a() != 0) {
            throw new CertificateParsingException("signed overrun, bytes = " + c1450m.f9356b.m11362a());
        }
        if (c1450mArr[0].f9357c != 48) {
            throw new CertificateParsingException("signed fields invalid");
        }
        this.f9597a = C1505e.m11630a(c1450mArr[1]);
        this.f9599c = c1450mArr[2].m11423d();
        if (c1450mArr[1].f9356b.m11362a() != 0) {
            throw new CertificateParsingException("algid field overrun");
        }
        if (c1450mArr[2].f9356b.m11362a() != 0) {
            throw new CertificateParsingException("signed fields overrun");
        }
        this.f9598b = new C1501bs(c1450mArr[0]);
        if (!this.f9597a.m11639a((C1505e) this.f9598b.m11609a("algorithmID.algorithm"))) {
            throw new CertificateException("Signature algorithm mismatch");
        }
        this.f9603g = true;
    }
}
