package p165d.p167b.p173f;

import android.provider.Contacts;
import android.provider.DocumentsContract;
import android.provider.Telephony;
import java.p209io.IOException;
import java.p209io.OutputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: X509CertInfo.java */
/* renamed from: d.b.f.bs */
/* loaded from: classes.dex */
public class C1501bs implements InterfaceC1513m<String> {

    /* renamed from: k */
    private static final Map<String, Integer> f9609k = new HashMap();

    /* renamed from: j */
    protected C1526z f9619j = new C1526z();

    /* renamed from: g */
    protected C1522v f9616g = null;

    /* renamed from: a */
    protected C1514n f9610a = null;

    /* renamed from: d */
    protected C1517q f9613d = null;

    /* renamed from: c */
    protected C1525y f9612c = null;

    /* renamed from: h */
    protected C1523w f9617h = null;

    /* renamed from: f */
    protected C1456aa f9615f = null;

    /* renamed from: e */
    protected C1518r f9614e = null;

    /* renamed from: i */
    protected C1524x f9618i = null;

    /* renamed from: b */
    protected C1515o f9611b = null;

    /* renamed from: l */
    private byte[] f9620l = null;

    static {
        f9609k.put("version", 1);
        f9609k.put("serialNumber", 2);
        f9609k.put("algorithmID", 3);
        f9609k.put("issuer", 4);
        f9609k.put("validity", 5);
        f9609k.put(Telephony.TextBasedSmsColumns.SUBJECT, 6);
        f9609k.put("key", 7);
        f9609k.put("issuerID", 8);
        f9609k.put("subjectID", 9);
        f9609k.put(Contacts.People.Extensions.CONTENT_DIRECTORY, 10);
    }

    public C1501bs() {
    }

    public C1501bs(byte[] bArr) {
        try {
            m11596a(new C1450m(bArr));
        } catch (IOException e2) {
            throw new CertificateParsingException(e2);
        }
    }

    public C1501bs(C1450m c1450m) {
        try {
            m11596a(c1450m);
        } catch (IOException e2) {
            throw new CertificateParsingException(e2);
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        if (this.f9620l == null) {
            C1449l c1449l = new C1449l();
            m11595a(c1449l);
            this.f9620l = c1449l.toByteArray();
        }
        outputStream.write((byte[]) this.f9620l.clone());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return DocumentsContract.EXTRA_INFO;
    }

    /* renamed from: b */
    public byte[] m11612b() {
        try {
            if (this.f9620l == null) {
                C1449l c1449l = new C1449l();
                m11595a(c1449l);
                this.f9620l = c1449l.toByteArray();
            }
            return (byte[]) this.f9620l.clone();
        } catch (IOException e2) {
            throw new CertificateEncodingException(e2.toString());
        } catch (CertificateException e3) {
            throw new CertificateEncodingException(e3.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1501bs) {
            return m11611a((C1501bs) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m11611a(C1501bs c1501bs) {
        if (this == c1501bs) {
            return true;
        }
        if (this.f9620l == null || c1501bs.f9620l == null) {
            return false;
        }
        if (this.f9620l.length != c1501bs.f9620l.length) {
            return false;
        }
        for (int i = 0; i < this.f9620l.length; i++) {
            if (this.f9620l[i] != c1501bs.f9620l[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 1; i2 < this.f9620l.length; i2++) {
            i += this.f9620l[i2] * i2;
        }
        return i;
    }

    public String toString() {
        if (this.f9617h == null || this.f9615f == null || this.f9612c == null || this.f9613d == null || this.f9610a == null || this.f9616g == null) {
            throw new NullPointerException("X.509 cert is incomplete");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        sb.append("  " + this.f9619j.toString() + "\n");
        sb.append("  Subject: " + this.f9617h.toString() + "\n");
        sb.append("  Signature Algorithm: " + this.f9610a.toString() + "\n");
        sb.append("  Key:  " + this.f9615f.toString() + "\n");
        sb.append("  " + this.f9612c.toString() + "\n");
        sb.append("  Issuer: " + this.f9613d.toString() + "\n");
        sb.append("  " + this.f9616g.toString() + "\n");
        if (this.f9614e != null) {
            sb.append("  Issuer Id:\n" + this.f9614e.toString() + "\n");
        }
        if (this.f9618i != null) {
            sb.append("  Subject Id:\n" + this.f9618i.toString() + "\n");
        }
        if (this.f9611b != null) {
            C1463ah[] c1463ahArr = (C1463ah[]) this.f9611b.m11670b().toArray(new C1463ah[0]);
            sb.append("\nCertificate Extensions: " + c1463ahArr.length);
            for (int i = 0; i < c1463ahArr.length; i++) {
                sb.append("\n[" + (i + 1) + "]: ");
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
            Map<String, C1463ah> m11671c = this.f9611b.m11671c();
            if (!m11671c.isEmpty()) {
                sb.append("\nUnparseable certificate extensions: " + m11671c.size());
                int i2 = 1;
                Iterator<C1463ah> it = m11671c.values().iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    C1463ah next = it.next();
                    sb.append("\n[" + i3 + "]: ");
                    sb.append(next);
                    i2 = i3 + 1;
                }
            }
        }
        sb.append("\n]");
        return sb.toString();
    }

    /* renamed from: a */
    public void m11610a(String str, Object obj) {
        C1497bo c1497bo = new C1497bo(str);
        int m11599b = m11599b(c1497bo.m11568a());
        if (m11599b == 0) {
            throw new CertificateException("Attribute name not recognized: " + str);
        }
        this.f9620l = null;
        String m11569b = c1497bo.m11569b();
        switch (m11599b) {
            case 1:
                if (m11569b == null) {
                    m11608j(obj);
                    return;
                } else {
                    this.f9619j.m11699a(m11569b, obj);
                    return;
                }
            case 2:
                if (m11569b == null) {
                    m11604f(obj);
                    return;
                } else {
                    this.f9616g.m11684a(m11569b, obj);
                    return;
                }
            case 3:
                if (m11569b == null) {
                    m11598a(obj);
                    return;
                } else {
                    this.f9610a.m11663a(m11569b, obj);
                    return;
                }
            case 4:
                if (m11569b == null) {
                    m11601c(obj);
                    return;
                } else {
                    this.f9613d.m11676a(m11569b, obj);
                    return;
                }
            case 5:
                if (m11569b == null) {
                    m11607i(obj);
                    return;
                } else {
                    this.f9612c.m11693a(m11569b, obj);
                    return;
                }
            case 6:
                if (m11569b == null) {
                    m11605g(obj);
                    return;
                } else {
                    this.f9617h.m11686a(m11569b, obj);
                    return;
                }
            case 7:
                if (m11569b == null) {
                    m11603e(obj);
                    return;
                } else {
                    this.f9615f.m11476a(m11569b, obj);
                    return;
                }
            case 8:
                if (m11569b == null) {
                    m11602d(obj);
                    return;
                } else {
                    this.f9614e.m11678a(m11569b, obj);
                    return;
                }
            case 9:
                if (m11569b == null) {
                    m11606h(obj);
                    return;
                } else {
                    this.f9618i.m11688a(m11569b, obj);
                    return;
                }
            case 10:
                if (m11569b == null) {
                    m11600b(obj);
                    return;
                }
                if (this.f9611b == null) {
                    this.f9611b = new C1515o();
                }
                this.f9611b.m11668a(m11569b, obj);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public Object m11609a(String str) {
        C1497bo c1497bo = new C1497bo(str);
        int m11599b = m11599b(c1497bo.m11568a());
        if (m11599b == 0) {
            throw new CertificateParsingException("Attribute name not recognized: " + str);
        }
        String m11569b = c1497bo.m11569b();
        switch (m11599b) {
            case 1:
                if (m11569b == null) {
                    return this.f9619j;
                }
                return this.f9619j.m11698a(m11569b);
            case 2:
                if (m11569b == null) {
                    return this.f9616g;
                }
                return this.f9616g.m11683a(m11569b);
            case 3:
                if (m11569b == null) {
                    return this.f9610a;
                }
                return this.f9610a.m11662a(m11569b);
            case 4:
                if (m11569b == null) {
                    return this.f9613d;
                }
                return this.f9613d.m11675a(m11569b);
            case 5:
                if (m11569b == null) {
                    return this.f9612c;
                }
                return this.f9612c.m11692a(m11569b);
            case 6:
                if (m11569b == null) {
                    return this.f9617h;
                }
                return this.f9617h.m11685a(m11569b);
            case 7:
                if (m11569b == null) {
                    return this.f9615f;
                }
                return this.f9615f.m11474a(m11569b);
            case 8:
                if (m11569b == null) {
                    return this.f9614e;
                }
                if (this.f9614e != null) {
                    return this.f9614e.m11677a(m11569b);
                }
                return null;
            case 9:
                if (m11569b == null) {
                    return this.f9618i;
                }
                if (this.f9618i != null) {
                    return this.f9618i.m11687a(m11569b);
                }
                return null;
            case 10:
                if (m11569b == null) {
                    return this.f9611b;
                }
                if (this.f9611b != null) {
                    return this.f9611b.m11666a(m11569b);
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m11596a(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new CertificateParsingException("signed fields invalid");
        }
        this.f9620l = c1450m.m11440u();
        C1448k c1448k = c1450m.f9356b;
        C1450m m11371d = c1448k.m11371d();
        if (m11371d.m11420b((byte) 0)) {
            this.f9619j = new C1526z(m11371d);
            m11371d = c1448k.m11371d();
        }
        this.f9616g = new C1522v(m11371d);
        this.f9610a = new C1514n(c1448k);
        this.f9613d = new C1517q(c1448k);
        if (((C1496bn) this.f9613d.m11675a("dname")).m11567e()) {
            throw new CertificateParsingException("Empty issuer DN not allowed in X509Certificates");
        }
        this.f9612c = new C1525y(c1448k);
        this.f9617h = new C1523w(c1448k);
        C1496bn c1496bn = (C1496bn) this.f9617h.m11685a("dname");
        if (this.f9619j.m11697a(0) == 0 && c1496bn.m11567e()) {
            throw new CertificateParsingException("Empty subject DN not allowed in v1 certificate");
        }
        this.f9615f = new C1456aa(c1448k);
        if (c1448k.m11362a() != 0) {
            if (this.f9619j.m11697a(0) == 0) {
                throw new CertificateParsingException("no more data allowed for version 1 certificate");
            }
            C1450m m11371d2 = c1448k.m11371d();
            if (m11371d2.m11420b((byte) 1)) {
                this.f9614e = new C1518r(m11371d2);
                if (c1448k.m11362a() != 0) {
                    m11371d2 = c1448k.m11371d();
                } else {
                    return;
                }
            }
            if (m11371d2.m11420b((byte) 2)) {
                this.f9618i = new C1524x(m11371d2);
                if (c1448k.m11362a() != 0) {
                    m11371d2 = c1448k.m11371d();
                } else {
                    return;
                }
            }
            if (this.f9619j.m11697a(2) != 0) {
                throw new CertificateParsingException("Extensions not allowed in v2 certificate");
            }
            if (m11371d2.m11437r() && m11371d2.m11420b((byte) 3)) {
                this.f9611b = new C1515o(m11371d2.f9356b);
            }
            m11597a(this.f9617h, this.f9611b);
        }
    }

    /* renamed from: a */
    private void m11597a(C1523w c1523w, C1515o c1515o) {
        if (((C1496bn) c1523w.m11685a("dname")).m11567e()) {
            if (c1515o == null) {
                throw new CertificateParsingException("X.509 Certificate is incomplete: subject field is empty, and certificate has no extensions");
            }
            try {
                C1491bi c1491bi = (C1491bi) c1515o.m11666a("SubjectAlternativeName");
                C1467al m11546a = c1491bi.m11546a("subject_name");
                if (m11546a == null || m11546a.m11497a()) {
                    throw new CertificateParsingException("X.509 Certificate is incomplete: subject field is empty, and SubjectAlternativeName extension is empty");
                }
                if (!c1491bi.m11491e()) {
                    throw new CertificateParsingException("X.509 Certificate is incomplete: SubjectAlternativeName extension MUST be marked critical when subject field is empty");
                }
            } catch (IOException e2) {
                throw new CertificateParsingException("X.509 Certificate is incomplete: subject field is empty, and SubjectAlternativeName extension is absent");
            }
        }
    }

    /* renamed from: a */
    private void m11595a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        this.f9619j.mo11475a(c1449l2);
        this.f9616g.mo11475a(c1449l2);
        this.f9610a.mo11475a(c1449l2);
        if (this.f9619j.m11697a(0) == 0 && this.f9613d.toString() == null) {
            throw new CertificateParsingException("Null issuer DN not allowed in v1 certificate");
        }
        this.f9613d.mo11475a(c1449l2);
        this.f9612c.mo11475a(c1449l2);
        if (this.f9619j.m11697a(0) == 0 && this.f9617h.toString() == null) {
            throw new CertificateParsingException("Null subject DN not allowed in v1 certificate");
        }
        this.f9617h.mo11475a(c1449l2);
        this.f9615f.mo11475a(c1449l2);
        if (this.f9614e != null) {
            this.f9614e.mo11475a(c1449l2);
        }
        if (this.f9618i != null) {
            this.f9618i.mo11475a(c1449l2);
        }
        if (this.f9611b != null) {
            this.f9611b.mo11475a(c1449l2);
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }

    /* renamed from: b */
    private int m11599b(String str) {
        Integer num = f9609k.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: j */
    private void m11608j(Object obj) {
        if (!(obj instanceof C1526z)) {
            throw new CertificateException("Version class type invalid.");
        }
        this.f9619j = (C1526z) obj;
    }

    /* renamed from: f */
    private void m11604f(Object obj) {
        if (!(obj instanceof C1522v)) {
            throw new CertificateException("SerialNumber class type invalid.");
        }
        this.f9616g = (C1522v) obj;
    }

    /* renamed from: a */
    private void m11598a(Object obj) {
        if (!(obj instanceof C1514n)) {
            throw new CertificateException("AlgorithmId class type invalid.");
        }
        this.f9610a = (C1514n) obj;
    }

    /* renamed from: c */
    private void m11601c(Object obj) {
        if (!(obj instanceof C1517q)) {
            throw new CertificateException("Issuer class type invalid.");
        }
        this.f9613d = (C1517q) obj;
    }

    /* renamed from: i */
    private void m11607i(Object obj) {
        if (!(obj instanceof C1525y)) {
            throw new CertificateException("CertificateValidity class type invalid.");
        }
        this.f9612c = (C1525y) obj;
    }

    /* renamed from: g */
    private void m11605g(Object obj) {
        if (!(obj instanceof C1523w)) {
            throw new CertificateException("Subject class type invalid.");
        }
        this.f9617h = (C1523w) obj;
    }

    /* renamed from: e */
    private void m11603e(Object obj) {
        if (!(obj instanceof C1456aa)) {
            throw new CertificateException("Key class type invalid.");
        }
        this.f9615f = (C1456aa) obj;
    }

    /* renamed from: d */
    private void m11602d(Object obj) {
        if (this.f9619j.m11697a(1) < 0) {
            throw new CertificateException("Invalid version");
        }
        if (!(obj instanceof C1518r)) {
            throw new CertificateException("IssuerUniqueId class type invalid.");
        }
        this.f9614e = (C1518r) obj;
    }

    /* renamed from: h */
    private void m11606h(Object obj) {
        if (this.f9619j.m11697a(1) < 0) {
            throw new CertificateException("Invalid version");
        }
        if (!(obj instanceof C1524x)) {
            throw new CertificateException("SubjectUniqueId class type invalid.");
        }
        this.f9618i = (C1524x) obj;
    }

    /* renamed from: b */
    private void m11600b(Object obj) {
        if (this.f9619j.m11697a(2) < 0) {
            throw new CertificateException("Invalid version");
        }
        if (!(obj instanceof C1515o)) {
            throw new CertificateException("Extensions class type invalid.");
        }
        this.f9611b = (C1515o) obj;
    }
}
