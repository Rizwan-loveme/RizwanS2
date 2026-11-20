package com.p065b.p066a.p068b.p081g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: GuaranteedEncodedFormX509Certificate.java */
/* renamed from: com.b.a.b.g.g */
/* loaded from: classes.dex */
public class C0648g extends C0646e {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private final byte[] f4245a;

    /* renamed from: b */
    private int f4246b;

    public C0648g(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f4246b = -1;
        this.f4245a = bArr != null ? (byte[]) bArr.clone() : null;
    }

    @Override // com.p065b.p066a.p068b.p081g.C0646e, java.security.cert.Certificate
    public byte[] getEncoded() {
        byte[] bArr = this.f4245a;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X509Certificate)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((X509Certificate) obj).getEncoded());
        } catch (CertificateEncodingException e2) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.f4246b == -1) {
            try {
                this.f4246b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException e2) {
                this.f4246b = 0;
            }
        }
        return this.f4246b;
    }
}
