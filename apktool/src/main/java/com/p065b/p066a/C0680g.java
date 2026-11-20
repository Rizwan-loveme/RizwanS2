package com.p065b.p066a;

import com.p065b.p066a.C0678e;
import com.p065b.p066a.p068b.p069a.p073d.C0601c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SigningCertificateLineage.java */
/* renamed from: com.b.a.g */
/* loaded from: classes.dex */
public class C0680g {
    private static final int CURRENT_VERSION = 1;
    private static final int FIRST_VERSION = 1;
    public static final int MAGIC = 1056913873;
    private static final int PAST_CERT_AUTH = 16;
    private static final int PAST_CERT_INSTALLED_DATA = 1;
    private static final int PAST_CERT_PERMISSION = 4;
    private static final int PAST_CERT_ROLLBACK = 8;
    private static final int PAST_CERT_SHARED_USER_ID = 2;

    /* renamed from: a */
    private final int f4461a;

    /* renamed from: b */
    private final List<C0601c.a> f4462b;

    private C0680g(int i, List<C0601c.a> list) {
        this.f4461a = i;
        this.f4462b = list;
    }

    /* renamed from: a */
    public static C0680g m6488a(byte[] bArr) {
        List<C0601c.a> m6010a = C0601c.m6010a(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
        return new C0680g(m6489c(m6010a), m6010a);
    }

    /* renamed from: b */
    public int m6492b() {
        return this.f4462b.size();
    }

    /* renamed from: c */
    private static int m6489c(List<C0601c.a> list) {
        int m6085f;
        if (list == null) {
            throw new IllegalArgumentException("Can't calculate minimum SDK version of null nodes");
        }
        int i = 28;
        for (C0601c.a aVar : list) {
            if (aVar.f4125c != null && (m6085f = aVar.f4125c.m6085f()) > i) {
                i = m6085f;
            }
        }
        return i;
    }

    /* renamed from: a */
    public byte[] m6491a() {
        return C0601c.m6013a(this.f4462b);
    }

    /* renamed from: b */
    public List<C0678e.g> m6493b(List<C0678e.g> list) {
        if (list == null) {
            throw new NullPointerException("signerConfigs == null");
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < this.f4462b.size(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 < list.size()) {
                    C0678e.g gVar = list.get(i2);
                    if (this.f4462b.get(i).f4127e.equals(gVar.m6477a().get(0))) {
                        arrayList.add(gVar);
                        break;
                    }
                    i2++;
                }
            }
        }
        if (arrayList.size() == list.size()) {
            return arrayList;
        }
        throw new IllegalArgumentException("SignerConfigs supplied which are not present in the SigningCertificateLineage");
    }

    /* renamed from: a */
    public C0680g m6490a(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            throw new NullPointerException("x509Certificate == null");
        }
        for (int i = 0; i < this.f4462b.size(); i++) {
            if (this.f4462b.get(i).f4127e.equals(x509Certificate)) {
                return new C0680g(this.f4461a, new ArrayList(this.f4462b.subList(0, i + 1)));
            }
        }
        throw new IllegalArgumentException("Certificate not found in SigningCertificateLineage");
    }

    /* renamed from: a */
    public static C0680g m6487a(List<C0680g> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i3 < list.size()) {
                int m6492b = list.get(i3).m6492b();
                if (m6492b > i) {
                    i2 = i3;
                } else {
                    m6492b = i;
                }
                i3++;
                i = m6492b;
            }
            List<C0601c.a> list2 = list.get(i2).f4462b;
            for (int i4 = 0; i4 < list.size(); i4++) {
                if (i4 != i2) {
                    List<C0601c.a> list3 = list.get(i4).f4462b;
                    if (!list3.equals(list2.subList(0, list3.size()))) {
                        throw new IllegalArgumentException("Inconsistent SigningCertificateLineages. Not all lineages are subsets of each other.");
                    }
                }
            }
            return list.get(i2);
        }
        return null;
    }
}
