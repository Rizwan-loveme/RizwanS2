package com.p065b.p066a.p068b.p082h;

import com.p065b.p066a.p068b.p075b.C0623g;
import com.p065b.p066a.p068b.p075b.EnumC0626j;
import com.p065b.p066a.p068b.p075b.InterfaceC0618b;
import com.p065b.p066a.p068b.p075b.InterfaceC0622f;
import com.p065b.p066a.p068b.p080f.C0633a;
import com.p065b.p066a.p068b.p080f.C0637e;
import com.p065b.p066a.p068b.p080f.C0640h;
import com.p065b.p066a.p068b.p081g.C0644c;
import com.p065b.p066a.p068b.p081g.C0648g;
import com.p065b.p066a.p068b.p081g.C0656o;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* compiled from: Certificate.java */
@InterfaceC0618b(m6143a = EnumC0626j.SEQUENCE)
/* renamed from: com.b.a.b.h.a */
/* loaded from: classes.dex */
public class C0657a {

    @InterfaceC0622f(m6179c = 0, m6183g = EnumC0626j.SEQUENCE)
    public C0661e certificate;

    @InterfaceC0622f(m6179c = 2, m6183g = EnumC0626j.BIT_STRING)
    public ByteBuffer signature;

    @InterfaceC0622f(m6179c = 1, m6183g = EnumC0626j.SEQUENCE)
    public C0633a signatureAlgorithm;

    /* renamed from: a */
    public static X509Certificate m6272a(Collection<X509Certificate> collection, C0640h c0640h) {
        for (X509Certificate x509Certificate : collection) {
            if (m6274a(x509Certificate, c0640h)) {
                return x509Certificate;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m6274a(X509Certificate x509Certificate, C0640h c0640h) {
        if (c0640h.issuerAndSerialNumber == null) {
            return false;
        }
        C0637e c0637e = c0640h.issuerAndSerialNumber;
        return c0637e.certificateSerialNumber.equals(x509Certificate.getSerialNumber()) && new X500Principal(C0644c.m6241a(c0637e.issuer.m6184a())).equals(x509Certificate.getIssuerX500Principal());
    }

    /* renamed from: a */
    public static List<X509Certificate> m6273a(List<C0623g> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            byte[] m6241a = C0644c.m6241a(list.get(i2).m6184a());
            try {
                arrayList.add(new C0648g(C0656o.m6269a(m6241a), m6241a));
                i = i2 + 1;
            } catch (CertificateException e2) {
                throw new CertificateException("Failed to parse certificate #" + (i2 + 1), e2);
            }
        }
    }
}
