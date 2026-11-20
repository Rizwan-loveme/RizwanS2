package com.p065b.p066a.p068b.p069a.p070a;

import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0602e;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p081g.C0648g;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.p209io.ByteArrayInputStream;
import java.p209io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* compiled from: SourceStampCertificateLineage.java */
/* renamed from: com.b.a.b.a.a.a */
/* loaded from: classes.dex */
public class C0587a {
    private static final int CURRENT_VERSION = 1;
    private static final int FIRST_VERSION = 1;

    /* renamed from: a */
    public static List<a> m5826a(ByteBuffer byteBuffer) {
        String str;
        String str2;
        String str3;
        int i;
        ArrayList arrayList = new ArrayList();
        C0648g c0648g = null;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            return null;
        }
        C0602e.m6033a(byteBuffer);
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            int i2 = 0;
            int i3 = 0;
            try {
                try {
                    if (byteBuffer.getInt() != 1) {
                        try {
                            throw new IllegalArgumentException("Encoded SigningCertificateLineage has a version different than any of which we are aware");
                        } catch (InvalidAlgorithmParameterException e2) {
                            e = e2;
                            i3 = 0;
                            str2 = " when parsing SourceStampCertificateLineage object";
                            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                        } catch (InvalidKeyException e3) {
                            e = e3;
                            i3 = 0;
                            str2 = " when parsing SourceStampCertificateLineage object";
                            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                        } catch (NoSuchAlgorithmException e4) {
                            e = e4;
                            str2 = " when parsing SourceStampCertificateLineage object";
                            i3 = 0;
                            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                        } catch (SignatureException e5) {
                            e = e5;
                            str2 = " when parsing SourceStampCertificateLineage object";
                            i3 = 0;
                            throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                        } catch (CertificateException e6) {
                            e = e6;
                            i = 0;
                            str3 = " when parsing SourceStampCertificateLineage object";
                            i2 = i;
                            throw new SecurityException("Failed to decode certificate #" + i2 + str3, e);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    int i4 = 0;
                    while (byteBuffer.hasRemaining()) {
                        try {
                            int i5 = i3 + 1;
                            try {
                                ByteBuffer m6035b = C0602e.m6035b(byteBuffer);
                                ByteBuffer m6035b2 = C0602e.m6035b(m6035b);
                                int i6 = m6035b.getInt();
                                int i7 = m6035b.getInt();
                                EnumC0609i m6078a = EnumC0609i.m6078a(i4);
                                byte[] m6037c = C0602e.m6037c(m6035b);
                                if (c0648g != null) {
                                    String m6251a = m6078a.m6084e().m6251a();
                                    AlgorithmParameterSpec m6252b = m6078a.m6084e().m6252b();
                                    PublicKey publicKey = c0648g.getPublicKey();
                                    try {
                                        Signature signature = Signature.getInstance(m6251a);
                                        signature.initVerify(publicKey);
                                        if (m6252b != null) {
                                            signature.setParameter(m6252b);
                                        }
                                        signature.update(m6035b2);
                                        if (!signature.verify(m6037c)) {
                                            throw new SecurityException("Unable to verify signature of certificate #" + i5 + " using " + m6251a + " when verifying SourceStampCertificateLineage object");
                                        }
                                    } catch (InvalidAlgorithmParameterException e7) {
                                        e = e7;
                                        i3 = i5;
                                        str2 = " when parsing SourceStampCertificateLineage object";
                                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                                    } catch (InvalidKeyException e8) {
                                        e = e8;
                                        i3 = i5;
                                        str2 = " when parsing SourceStampCertificateLineage object";
                                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                                    } catch (NoSuchAlgorithmException e9) {
                                        e = e9;
                                        str2 = " when parsing SourceStampCertificateLineage object";
                                        i3 = i5;
                                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                                    } catch (SignatureException e10) {
                                        e = e10;
                                        str2 = " when parsing SourceStampCertificateLineage object";
                                        i3 = i5;
                                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i3 + str2, e);
                                    } catch (CertificateException e11) {
                                        e = e11;
                                        i = i5;
                                        str3 = " when parsing SourceStampCertificateLineage object";
                                        i2 = i;
                                        throw new SecurityException("Failed to decode certificate #" + i2 + str3, e);
                                    }
                                }
                                m6035b2.rewind();
                                byte[] m6037c2 = C0602e.m6037c(m6035b2);
                                int i8 = m6035b2.getInt();
                                if (c0648g != null && i4 != i8) {
                                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + m6035b + " when verifying SourceStampCertificateLineage object");
                                }
                                C0648g c0648g2 = new C0648g((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(m6037c2)), m6037c2);
                                if (hashSet.contains(c0648g2)) {
                                    throw new SecurityException("Encountered duplicate entries in SigningCertificateLineage at certificate #" + i5 + ".  All signing certificates should be unique");
                                }
                                hashSet.add(c0648g2);
                                arrayList.add(new a(c0648g2, EnumC0609i.m6078a(i8), EnumC0609i.m6078a(i7), m6037c, i6));
                                i3 = i5;
                                i4 = i7;
                                c0648g = c0648g2;
                            } catch (InvalidAlgorithmParameterException e12) {
                                e = e12;
                                i3 = i5;
                                str2 = " when parsing SourceStampCertificateLineage object";
                            } catch (InvalidKeyException e13) {
                                e = e13;
                                i3 = i5;
                                str2 = " when parsing SourceStampCertificateLineage object";
                            } catch (NoSuchAlgorithmException e14) {
                                e = e14;
                                i3 = i5;
                                str2 = " when parsing SourceStampCertificateLineage object";
                            } catch (SignatureException e15) {
                                e = e15;
                                i3 = i5;
                                str2 = " when parsing SourceStampCertificateLineage object";
                            } catch (CertificateException e16) {
                                e = e16;
                                i2 = i5;
                                str = " when parsing SourceStampCertificateLineage object";
                                str3 = str;
                                throw new SecurityException("Failed to decode certificate #" + i2 + str3, e);
                            }
                        } catch (InvalidAlgorithmParameterException e17) {
                            e = e17;
                            str2 = " when parsing SourceStampCertificateLineage object";
                        } catch (InvalidKeyException e18) {
                            e = e18;
                            str2 = " when parsing SourceStampCertificateLineage object";
                        } catch (NoSuchAlgorithmException e19) {
                            e = e19;
                            str2 = " when parsing SourceStampCertificateLineage object";
                        } catch (SignatureException e20) {
                            e = e20;
                            str2 = " when parsing SourceStampCertificateLineage object";
                        } catch (CertificateException e21) {
                            e = e21;
                            i2 = i3;
                            str = " when parsing SourceStampCertificateLineage object";
                        }
                    }
                    return arrayList;
                } catch (C0579a e22) {
                    e = e22;
                    throw new IOException("Failed to parse SourceStampCertificateLineage object", e);
                } catch (BufferUnderflowException e23) {
                    e = e23;
                    throw new IOException("Failed to parse SourceStampCertificateLineage object", e);
                }
            } catch (InvalidAlgorithmParameterException e24) {
                e = e24;
                i3 = 0;
                str2 = " when parsing SourceStampCertificateLineage object";
            } catch (InvalidKeyException e25) {
                e = e25;
                i3 = 0;
                str2 = " when parsing SourceStampCertificateLineage object";
            } catch (NoSuchAlgorithmException e26) {
                e = e26;
                i3 = 0;
                str2 = " when parsing SourceStampCertificateLineage object";
            } catch (SignatureException e27) {
                e = e27;
                i3 = 0;
                str2 = " when parsing SourceStampCertificateLineage object";
            } catch (CertificateException e28) {
                e = e28;
                str = " when parsing SourceStampCertificateLineage object";
            }
        } catch (CertificateException e29) {
            throw new IllegalStateException("Failed to obtain X.509 CertificateFactory", e29);
        }
    }

    /* compiled from: SourceStampCertificateLineage.java */
    /* renamed from: com.b.a.b.a.a.a$a */
    public static class a {

        /* renamed from: a */
        public int f3993a;

        /* renamed from: b */
        public final EnumC0609i f3994b;

        /* renamed from: c */
        public EnumC0609i f3995c;

        /* renamed from: d */
        public final byte[] f3996d;

        /* renamed from: e */
        public final X509Certificate f3997e;

        public a(X509Certificate x509Certificate, EnumC0609i enumC0609i, EnumC0609i enumC0609i2, byte[] bArr, int i) {
            this.f3997e = x509Certificate;
            this.f3994b = enumC0609i;
            this.f3995c = enumC0609i2;
            this.f3996d = bArr;
            this.f3993a = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f3997e.equals(aVar.f3997e) && this.f3994b == aVar.f3994b && this.f3995c == aVar.f3995c && Arrays.equals(this.f3996d, aVar.f3996d) && this.f3993a == aVar.f3993a;
        }

        public int hashCode() {
            X509Certificate x509Certificate = this.f3997e;
            int hashCode = x509Certificate == null ? 0 : x509Certificate.hashCode();
            EnumC0609i enumC0609i = this.f3994b;
            int hashCode2 = enumC0609i == null ? 0 : enumC0609i.hashCode();
            EnumC0609i enumC0609i2 = this.f3995c;
            return ((((((((hashCode + 31) * 31) + hashCode2) * 31) + (enumC0609i2 != null ? enumC0609i2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f3996d)) * 31) + this.f3993a;
        }
    }
}
