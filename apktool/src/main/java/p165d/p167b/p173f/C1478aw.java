package p165d.p167b.p173f;

import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.DatatypeConstants;
import p165d.p167b.p172e.C1454q;

/* compiled from: OIDMap.java */
/* renamed from: d.b.f.aw */
/* loaded from: classes.dex */
public class C1478aw {

    /* renamed from: a */
    private static final int[] f9445a = {2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 113730, 1, 1};

    /* renamed from: c */
    private static final Map<C1454q, a> f9447c = new HashMap();

    /* renamed from: b */
    private static final Map<String, a> f9446b = new HashMap();

    static {
        m11521a("x509.info.extensions.SubjectKeyIdentifier", C1481az.f9506y, C1492bj.class);
        m11521a("x509.info.extensions.KeyUsage", C1481az.f9497p, C1475at.class);
        m11521a("x509.info.extensions.PrivateKeyUsage", C1481az.f9501t, C1486bd.class);
        m11521a("x509.info.extensions.SubjectAlternativeName", C1481az.f9503v, C1491bi.class);
        m11521a("x509.info.extensions.IssuerAlternativeName", C1481az.f9495n, C1472aq.class);
        m11521a("x509.info.extensions.BasicConstraints", C1481az.f9484c, C1508h.class);
        m11521a("x509.info.extensions.CRLNumber", C1481az.f9486e, C1511k.class);
        m11521a("x509.info.extensions.CRLReasonCode", C1481az.f9502u, C1512l.class);
        m11521a("x509.info.extensions.NameConstraints", C1481az.f9498q, C1476au.class);
        m11521a("x509.info.extensions.PolicyMappings", C1481az.f9500s, C1485bc.class);
        m11521a("x509.info.extensions.AuthorityKeyIdentifier", C1481az.f9483b, C1507g.class);
        m11521a("x509.info.extensions.PolicyConstraints", C1481az.f9499r, C1483ba.class);
        m11521a("x509.info.extensions.NetscapeCertType", C1454q.m11454a(new int[]{2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 113730, 1, 1}), C1477av.class);
        m11521a("x509.info.extensions.CertificatePolicies", C1481az.f9488g, C1519s.class);
        m11521a("x509.info.extensions.ExtendedKeyUsage", C1481az.f9490i, C1462ag.class);
        m11521a("x509.info.extensions.InhibitAnyPolicy", C1481az.f9493l, C1471ap.class);
        m11521a("x509.info.extensions.CRLDistributionPoints", C1481az.f9485d, C1509i.class);
        m11521a("x509.info.extensions.CertificateIssuer", C1481az.f9487f, C1516p.class);
        m11521a("x509.info.extensions.AuthorityInfoAccess", C1481az.f9482a, C1506f.class);
        m11521a("x509.info.extensions.IssuingDistributionPoint", C1481az.f9496o, C1473ar.class);
        m11521a("x509.info.extensions.DeltaCRLIndicator", C1481az.f9489h, C1458ac.class);
        m11521a("x509.info.extensions.FreshestCRL", C1481az.f9491j, C1464ai.class);
    }

    /* renamed from: a */
    private static void m11521a(String str, C1454q c1454q, Class<?> cls) {
        a aVar = new a(str, c1454q, cls);
        f9447c.put(c1454q, aVar);
        f9446b.put(str, aVar);
    }

    /* compiled from: OIDMap.java */
    /* renamed from: d.b.f.aw$a */
    private static class a {

        /* renamed from: a */
        final String f9448a;

        /* renamed from: b */
        final String f9449b;

        /* renamed from: c */
        final C1454q f9450c;

        /* renamed from: d */
        private volatile Class<?> f9451d;

        a(String str, C1454q c1454q, Class<?> cls) {
            this.f9449b = str;
            this.f9450c = c1454q;
            this.f9448a = cls.getName();
            this.f9451d = cls;
        }

        /* renamed from: a */
        Class<?> m11523a() {
            try {
                Class<?> cls = this.f9451d;
                if (cls == null) {
                    Class<?> cls2 = Class.forName(this.f9448a);
                    this.f9451d = cls2;
                    return cls2;
                }
                return cls;
            } catch (ClassNotFoundException e2) {
                throw new CertificateException("Could not load class: " + e2, e2);
            }
        }
    }

    /* renamed from: b */
    public static String m11522b(C1454q c1454q) {
        a aVar = f9447c.get(c1454q);
        if (aVar == null) {
            return null;
        }
        return aVar.f9449b;
    }

    /* renamed from: a */
    public static Class<?> m11520a(C1454q c1454q) {
        a aVar = f9447c.get(c1454q);
        if (aVar == null) {
            return null;
        }
        return aVar.m11523a();
    }
}
