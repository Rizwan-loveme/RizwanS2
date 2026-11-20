package p165d.p167b.p169b;

import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Hashtable;
import javax.xml.datatype.DatatypeConstants;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p172e.InterfaceC1445h;
import p165d.p167b.p173f.C1515o;

/* compiled from: PKCS9Attribute.java */
/* renamed from: d.b.b.f */
/* loaded from: classes.dex */
public class C1428f implements InterfaceC1445h {

    /* renamed from: a */
    public static final C1454q f9234a;

    /* renamed from: b */
    public static final C1454q f9235b;

    /* renamed from: c */
    public static final C1454q f9236c;

    /* renamed from: d */
    public static final C1454q f9237d;

    /* renamed from: e */
    public static final C1454q f9238e;

    /* renamed from: f */
    public static final C1454q f9239f;

    /* renamed from: g */
    public static final C1454q f9240g;

    /* renamed from: h */
    public static final C1454q f9241h;

    /* renamed from: j */
    public static final C1454q f9243j;

    /* renamed from: k */
    public static final C1454q f9244k;

    /* renamed from: l */
    public static final C1454q f9245l;

    /* renamed from: m */
    public static final C1454q f9246m;

    /* renamed from: n */
    public static final C1454q f9247n;

    /* renamed from: o */
    public static final C1454q f9248o;

    /* renamed from: p */
    private static final Hashtable<String, C1454q> f9249p;

    /* renamed from: q */
    private static final Hashtable<C1454q, String> f9250q;

    /* renamed from: r */
    private static final Byte[][] f9251r;

    /* renamed from: s */
    private static final boolean[] f9252s;

    /* renamed from: t */
    private static final Class<?>[] f9253t;

    /* renamed from: v */
    private int f9255v;

    /* renamed from: w */
    private Object f9256w;

    /* renamed from: u */
    private static final C1444g f9254u = C1444g.m11327a("jar");

    /* renamed from: i */
    static final C1454q[] f9242i = new C1454q[18];

    static {
        for (int i = 1; i < f9242i.length - 2; i++) {
            f9242i[i] = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, i});
        }
        f9242i[f9242i.length - 2] = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 16, 2, 12});
        f9242i[f9242i.length - 1] = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 9, 16, 2, 14});
        f9237d = f9242i[1];
        f9248o = f9242i[2];
        f9235b = f9242i[3];
        f9241h = f9242i[4];
        f9245l = f9242i[5];
        f9236c = f9242i[6];
        f9234a = f9242i[7];
        f9247n = f9242i[8];
        f9238e = f9242i[9];
        f9240g = f9242i[10];
        f9239f = f9242i[14];
        f9246m = f9242i[15];
        f9244k = f9242i[16];
        f9243j = f9242i[17];
        f9249p = new Hashtable<>(18);
        f9249p.put("emailaddress", f9242i[1]);
        f9249p.put("unstructuredname", f9242i[2]);
        f9249p.put("contenttype", f9242i[3]);
        f9249p.put("messagedigest", f9242i[4]);
        f9249p.put("signingtime", f9242i[5]);
        f9249p.put("countersignature", f9242i[6]);
        f9249p.put("challengepassword", f9242i[7]);
        f9249p.put("unstructuredaddress", f9242i[8]);
        f9249p.put("extendedcertificateattributes", f9242i[9]);
        f9249p.put("issuerandserialnumber", f9242i[10]);
        f9249p.put("rsaproprietary", f9242i[11]);
        f9249p.put("rsaproprietary", f9242i[12]);
        f9249p.put("signingdescription", f9242i[13]);
        f9249p.put("extensionrequest", f9242i[14]);
        f9249p.put("smimecapability", f9242i[15]);
        f9249p.put("signingcertificate", f9242i[16]);
        f9249p.put("signaturetimestamptoken", f9242i[17]);
        f9250q = new Hashtable<>(16);
        f9250q.put(f9242i[1], "EmailAddress");
        f9250q.put(f9242i[2], "UnstructuredName");
        f9250q.put(f9242i[3], "ContentType");
        f9250q.put(f9242i[4], "MessageDigest");
        f9250q.put(f9242i[5], "SigningTime");
        f9250q.put(f9242i[6], "Countersignature");
        f9250q.put(f9242i[7], "ChallengePassword");
        f9250q.put(f9242i[8], "UnstructuredAddress");
        f9250q.put(f9242i[9], "ExtendedCertificateAttributes");
        f9250q.put(f9242i[10], "IssuerAndSerialNumber");
        f9250q.put(f9242i[11], "RSAProprietary");
        f9250q.put(f9242i[12], "RSAProprietary");
        f9250q.put(f9242i[13], "SMIMESigningDesc");
        f9250q.put(f9242i[14], "ExtensionRequest");
        f9250q.put(f9242i[15], "SMIMECapability");
        f9250q.put(f9242i[16], "SigningCertificate");
        f9250q.put(f9242i[17], "SignatureTimestampToken");
        Byte[][] bArr = new Byte[18][];
        bArr[1] = new Byte[]{new Byte((byte) 22)};
        bArr[2] = new Byte[]{new Byte((byte) 22)};
        bArr[3] = new Byte[]{new Byte((byte) 6)};
        bArr[4] = new Byte[]{new Byte((byte) 4)};
        bArr[5] = new Byte[]{new Byte((byte) 23)};
        bArr[6] = new Byte[]{new Byte((byte) 48)};
        bArr[7] = new Byte[]{new Byte((byte) 19), new Byte((byte) 20)};
        bArr[8] = new Byte[]{new Byte((byte) 19), new Byte((byte) 20)};
        bArr[9] = new Byte[]{new Byte((byte) 49)};
        bArr[10] = new Byte[]{new Byte((byte) 48)};
        bArr[14] = new Byte[]{new Byte((byte) 48)};
        bArr[15] = new Byte[]{new Byte((byte) 48)};
        bArr[16] = new Byte[]{new Byte((byte) 48)};
        bArr[17] = new Byte[]{new Byte((byte) 48)};
        f9251r = bArr;
        f9253t = new Class[18];
        try {
            Class<?> cls = Class.forName("[Ljava.lang.String;");
            f9253t[0] = null;
            f9253t[1] = cls;
            f9253t[2] = cls;
            f9253t[3] = C1454q.class;
            f9253t[4] = Class.forName("[B");
            f9253t[5] = Date.class;
            f9253t[6] = Class.forName("[L" + C1431i.class.getName() + ";");
            f9253t[7] = String.class;
            f9253t[8] = cls;
            f9253t[9] = null;
            f9253t[10] = null;
            f9253t[11] = null;
            f9253t[12] = null;
            f9253t[13] = null;
            f9253t[14] = C1515o.class;
            f9253t[15] = null;
            f9253t[16] = null;
            f9253t[17] = Class.forName("[B");
            f9252s = new boolean[]{false, false, false, true, true, true, false, true, false, false, true, false, false, false, true, true, true, true};
        } catch (ClassNotFoundException e2) {
            throw new ExceptionInInitializerError(e2.toString());
        }
    }

    public C1428f(C1450m c1450m) {
        int i = 0;
        C1448k c1448k = new C1448k(c1450m.m11440u());
        C1450m[] m11364a = c1448k.m11364a(2);
        if (c1448k.m11362a() != 0) {
            throw new IOException("Excess data parsing PKCS9Attribute");
        }
        if (m11364a.length != 2) {
            throw new IOException("PKCS9Attribute doesn't have two components");
        }
        C1454q m11431l = m11364a[0].m11431l();
        this.f9255v = m11268a(m11431l, f9242i, 1);
        if (this.f9255v == -1) {
            if (f9254u != null) {
                f9254u.m11333c("ignoring unsupported signer attribute: " + m11431l);
            }
            throw new C1430h("Unsupported PKCS9 attribute: " + m11431l);
        }
        C1450m[] m11368b = new C1448k(m11364a[1].m11440u()).m11368b(1);
        if (f9252s[this.f9255v] && m11368b.length > 1) {
            m11270d();
        }
        for (C1450m c1450m2 : m11368b) {
            Byte b2 = new Byte(c1450m2.f9357c);
            if (m11268a(b2, f9251r[this.f9255v], 0) == -1) {
                m11269a(b2);
            }
        }
        switch (this.f9255v) {
            case 1:
            case 2:
            case 8:
                String[] strArr = new String[m11368b.length];
                while (i < m11368b.length) {
                    strArr[i] = m11368b[i].m11415a();
                    i++;
                }
                this.f9256w = strArr;
                return;
            case 3:
                this.f9256w = m11368b[0].m11431l();
                return;
            case 4:
                this.f9256w = m11368b[0].m11432m();
                return;
            case 5:
                this.f9256w = new C1448k(m11368b[0].m11440u()).m11378j();
                return;
            case 6:
                C1431i[] c1431iArr = new C1431i[m11368b.length];
                while (i < m11368b.length) {
                    c1431iArr[i] = new C1431i(m11368b[i].m11441v());
                    i++;
                }
                this.f9256w = c1431iArr;
                return;
            case 7:
                this.f9256w = m11368b[0].m11415a();
                return;
            case 9:
                throw new IOException("PKCS9 extended-certificate attribute not supported.");
            case 10:
                throw new IOException("PKCS9 IssuerAndSerialNumberattribute not supported.");
            case 11:
            case 12:
                throw new IOException("PKCS9 RSA DSI attributes11 and 12, not supported.");
            case 13:
                throw new IOException("PKCS9 attribute #13 not supported.");
            case 14:
                this.f9256w = new C1515o(new C1448k(m11368b[0].m11440u()));
                return;
            case 15:
                throw new IOException("PKCS9 SMIMECapability attribute not supported.");
            case 16:
                this.f9256w = new C1432j(m11368b[0].m11440u());
                return;
            case 17:
                this.f9256w = m11368b[0].m11440u();
                return;
            default:
                return;
        }
    }

    @Override // p165d.p167b.p172e.InterfaceC1445h
    /* renamed from: a */
    public void mo11272a(OutputStream outputStream) {
        int i = 0;
        C1449l c1449l = new C1449l();
        c1449l.m11394a(m11273b());
        switch (this.f9255v) {
            case 1:
            case 2:
                String[] strArr = (String[]) this.f9256w;
                C1449l[] c1449lArr = new C1449l[strArr.length];
                while (i < strArr.length) {
                    c1449lArr[i] = new C1449l();
                    c1449lArr[i].m11403b(strArr[i]);
                    i++;
                }
                c1449l.m11390a((byte) 49, c1449lArr);
                break;
            case 3:
                C1449l c1449l2 = new C1449l();
                c1449l2.m11394a((C1454q) this.f9256w);
                c1449l.m11389a((byte) 49, c1449l2.toByteArray());
                break;
            case 4:
                C1449l c1449l3 = new C1449l();
                c1449l3.m11405b((byte[]) this.f9256w);
                c1449l.m11389a((byte) 49, c1449l3.toByteArray());
                break;
            case 5:
                C1449l c1449l4 = new C1449l();
                c1449l4.m11404b((Date) this.f9256w);
                c1449l.m11389a((byte) 49, c1449l4.toByteArray());
                break;
            case 6:
                c1449l.m11390a((byte) 49, (InterfaceC1445h[]) this.f9256w);
                break;
            case 7:
                C1449l c1449l5 = new C1449l();
                c1449l5.m11407c((String) this.f9256w);
                c1449l.m11389a((byte) 49, c1449l5.toByteArray());
                break;
            case 8:
                String[] strArr2 = (String[]) this.f9256w;
                C1449l[] c1449lArr2 = new C1449l[strArr2.length];
                while (i < strArr2.length) {
                    c1449lArr2[i] = new C1449l();
                    c1449lArr2[i].m11407c(strArr2[i]);
                    i++;
                }
                c1449l.m11390a((byte) 49, c1449lArr2);
                break;
            case 9:
                throw new IOException("PKCS9 extended-certificate attribute not supported.");
            case 10:
                throw new IOException("PKCS9 IssuerAndSerialNumberattribute not supported.");
            case 11:
            case 12:
                throw new IOException("PKCS9 RSA DSI attributes11 and 12, not supported.");
            case 13:
                throw new IOException("PKCS9 attribute #13 not supported.");
            case 14:
                C1449l c1449l6 = new C1449l();
                try {
                    ((C1515o) this.f9256w).m11667a((OutputStream) c1449l6, true);
                    c1449l.m11389a((byte) 49, c1449l6.toByteArray());
                    break;
                } catch (CertificateException e2) {
                    throw new IOException(e2.toString());
                }
            case 15:
                throw new IOException("PKCS9 attribute #15 not supported.");
            case 16:
                throw new IOException("PKCS9 SigningCertificate attribute not supported.");
            case 17:
                c1449l.m11389a((byte) 49, (byte[]) this.f9256w);
                break;
        }
        C1449l c1449l7 = new C1449l();
        c1449l7.m11389a((byte) 48, c1449l.toByteArray());
        outputStream.write(c1449l7.toByteArray());
    }

    /* renamed from: c */
    public Object m11274c() {
        return this.f9256w;
    }

    /* renamed from: b */
    public C1454q m11273b() {
        return f9242i[this.f9255v];
    }

    /* renamed from: a */
    public String m11271a() {
        return f9250q.get(f9242i[this.f9255v]);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("[");
        stringBuffer.append(f9250q.get(f9242i[this.f9255v]));
        stringBuffer.append(": ");
        if (f9252s[this.f9255v]) {
            if (this.f9256w instanceof byte[]) {
                stringBuffer.append(new C1420b().m11234b((byte[]) this.f9256w));
            } else {
                stringBuffer.append(this.f9256w.toString());
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
        boolean z = true;
        for (Object obj : (Object[]) this.f9256w) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(obj.toString());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static int m11268a(Object obj, Object[] objArr, int i) {
        while (i < objArr.length) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: d */
    private void m11270d() {
        throw new IOException("Single-value attribute " + m11273b() + " (" + m11271a() + ") has multiple values.");
    }

    /* renamed from: a */
    private void m11269a(Byte b2) {
        Byte[] bArr = f9251r[this.f9255v];
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("Value of attribute ");
        stringBuffer.append(m11273b().toString());
        stringBuffer.append(" (");
        stringBuffer.append(m11271a());
        stringBuffer.append(") has wrong tag: ");
        stringBuffer.append(b2.toString());
        stringBuffer.append(".  Expected tags: ");
        stringBuffer.append(bArr[0].toString());
        for (int i = 1; i < bArr.length; i++) {
            stringBuffer.append(", ");
            stringBuffer.append(bArr[i].toString());
        }
        stringBuffer.append(".");
        throw new IOException(stringBuffer.toString());
    }
}
