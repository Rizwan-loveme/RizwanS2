package com.p065b.p066a.p068b.p081g;

import android.util.Base64;
import com.p065b.p066a.p068b.p075b.C0612a;
import com.p065b.p066a.p068b.p075b.C0619c;
import com.p065b.p066a.p068b.p075b.C0620d;
import com.p065b.p066a.p068b.p075b.C0621e;
import com.p065b.p066a.p068b.p082h.C0657a;
import java.nio.ByteBuffer;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* compiled from: X509CertificateUtils.java */
/* renamed from: com.b.a.b.g.o */
/* loaded from: classes.dex */
public class C0656o {
    public static final byte[] BEGIN_CERT_HEADER = "-----BEGIN CERTIFICATE-----".getBytes();
    public static final byte[] END_CERT_FOOTER = "-----END CERTIFICATE-----".getBytes();
    private static CertificateFactory sCertFactory;

    /* renamed from: a */
    private static void m6271a() {
        if (sCertFactory != null) {
            return;
        }
        try {
            sCertFactory = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e2) {
            throw new RuntimeException("Failed to create X.509 CertificateFactory", e2);
        }
    }

    /* renamed from: a */
    public static X509Certificate m6269a(byte[] bArr) {
        if (sCertFactory == null) {
            m6271a();
        }
        return m6270a(bArr, sCertFactory);
    }

    /* renamed from: a */
    public static X509Certificate m6270a(byte[] bArr, CertificateFactory certificateFactory) {
        try {
            return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e2) {
            try {
                ByteBuffer m6268a = m6268a(ByteBuffer.wrap(bArr));
                int position = m6268a.position();
                X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(C0620d.m6164c((C0657a) C0612a.m6091a(m6268a, C0657a.class))));
                byte[] bArr2 = new byte[m6268a.position() - position];
                m6268a.position(position);
                m6268a.get(bArr2);
                return new C0648g(x509Certificate, bArr2);
            } catch (C0619c | C0621e | CertificateException e3) {
                throw new CertificateException("Failed to parse certificate", e3);
            }
        }
    }

    /* renamed from: a */
    private static ByteBuffer m6268a(ByteBuffer byteBuffer) {
        char c2;
        if (byteBuffer == null) {
            throw new NullPointerException("The certificateBuffer cannot be null");
        }
        if (byteBuffer.remaining() >= BEGIN_CERT_HEADER.length) {
            byteBuffer.mark();
            int i = 0;
            while (true) {
                byte[] bArr = BEGIN_CERT_HEADER;
                if (i < bArr.length) {
                    if (byteBuffer.get() != bArr[i]) {
                        byteBuffer.reset();
                        return byteBuffer;
                    }
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (byteBuffer.hasRemaining() && (c2 = (char) byteBuffer.get()) != '-') {
                        if (!Character.isWhitespace(c2)) {
                            sb.append(c2);
                        }
                    }
                    int i2 = 1;
                    while (true) {
                        byte[] bArr2 = END_CERT_FOOTER;
                        if (i2 < bArr2.length) {
                            if (!byteBuffer.hasRemaining()) {
                                throw new CertificateException("The provided input contains the PEM certificate header but does not contain sufficient data for the footer");
                            }
                            if (byteBuffer.get() != bArr2[i2]) {
                                throw new CertificateException("The provided input contains the PEM certificate header without a valid certificate footer");
                            }
                            i2++;
                        } else {
                            byte[] decode = Base64.decode(sb.toString(), 2);
                            int position = byteBuffer.position();
                            while (byteBuffer.hasRemaining() && Character.isWhitespace((char) byteBuffer.get())) {
                                position++;
                            }
                            byteBuffer.position(position);
                            return ByteBuffer.wrap(decode);
                        }
                    }
                }
            }
        } else {
            return byteBuffer;
        }
    }
}
