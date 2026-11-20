package com.p065b.p066a.p068b.p069a.p073d;

import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p081g.C0648g;
import com.p065b.p066a.p068b.p081g.C0656o;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.p209io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: V3SigningCertificateLineage.java */
/* renamed from: com.b.a.b.a.d.c */
/* loaded from: classes.dex */
public class C0601c {
    private static final int CURRENT_VERSION = 1;
    private static final int FIRST_VERSION = 1;

    /* renamed from: a */
    public static List<a> m6010a(ByteBuffer byteBuffer) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i2;
        C0648g c0648g = null;
        int i3 = 0;
        ArrayList arrayList = new ArrayList();
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            return null;
        }
        C0598d.m5958a(byteBuffer);
        try {
            try {
                if (byteBuffer.getInt() != 1) {
                    try {
                        throw new IllegalArgumentException("Encoded SigningCertificateLineage has a version different than any of which we are aware");
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        i = 0;
                        str11 = " when parsing V3SigningCertificateLineage object";
                        str7 = str11;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        i = 0;
                        str10 = " when parsing V3SigningCertificateLineage object";
                        str7 = str10;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (NoSuchAlgorithmException e4) {
                        e = e4;
                        str9 = " when parsing V3SigningCertificateLineage object";
                        i = 0;
                        str7 = str9;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (SignatureException e5) {
                        e = e5;
                        i = 0;
                        str8 = " when parsing V3SigningCertificateLineage object";
                        str7 = str8;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (CertificateException e6) {
                        e = e6;
                        str6 = " when parsing V3SigningCertificateLineage object";
                        e = e;
                        throw new SecurityException("Failed to decode certificate #" + i3 + str6, e);
                    }
                }
                HashSet hashSet = new HashSet();
                i = 0;
                int i4 = 0;
                while (byteBuffer.hasRemaining()) {
                    try {
                        i2 = i + 1;
                    } catch (InvalidAlgorithmParameterException e7) {
                        e = e7;
                        str5 = " when parsing V3SigningCertificateLineage object";
                    } catch (InvalidKeyException e8) {
                        e = e8;
                        str4 = " when parsing V3SigningCertificateLineage object";
                    } catch (NoSuchAlgorithmException e9) {
                        e = e9;
                        str3 = " when parsing V3SigningCertificateLineage object";
                    } catch (SignatureException e10) {
                        e = e10;
                        str2 = " when parsing V3SigningCertificateLineage object";
                    } catch (CertificateException e11) {
                        e = e11;
                        i3 = i;
                        str = " when parsing V3SigningCertificateLineage object";
                    }
                    try {
                        ByteBuffer m5966b = C0598d.m5966b(byteBuffer);
                        ByteBuffer m5966b2 = C0598d.m5966b(m5966b);
                        int i5 = m5966b.getInt();
                        int i6 = m5966b.getInt();
                        EnumC0609i m6078a = EnumC0609i.m6078a(i4);
                        byte[] m5973c = C0598d.m5973c(m5966b);
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
                                signature.update(m5966b2);
                                if (!signature.verify(m5973c)) {
                                    throw new SecurityException("Unable to verify signature of certificate #" + i2 + " using " + m6251a + " when verifying V3SigningCertificateLineage object");
                                }
                            } catch (InvalidAlgorithmParameterException e12) {
                                e = e12;
                                i = i2;
                                str11 = " when parsing V3SigningCertificateLineage object";
                                str7 = str11;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                            } catch (InvalidKeyException e13) {
                                e = e13;
                                i = i2;
                                str10 = " when parsing V3SigningCertificateLineage object";
                                str7 = str10;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                            } catch (NoSuchAlgorithmException e14) {
                                e = e14;
                                str9 = " when parsing V3SigningCertificateLineage object";
                                i = i2;
                                str7 = str9;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                            } catch (SignatureException e15) {
                                e = e15;
                                i = i2;
                                str8 = " when parsing V3SigningCertificateLineage object";
                                str7 = str8;
                                throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                            } catch (CertificateException e16) {
                                e = e16;
                                str6 = " when parsing V3SigningCertificateLineage object";
                                i3 = i2;
                                e = e;
                                throw new SecurityException("Failed to decode certificate #" + i3 + str6, e);
                            }
                        }
                        m5966b2.rewind();
                        byte[] m5973c2 = C0598d.m5973c(m5966b2);
                        int i7 = m5966b2.getInt();
                        if (c0648g != null && i4 != i7) {
                            throw new SecurityException("Signing algorithm ID mismatch for certificate #" + m5966b + " when verifying V3SigningCertificateLineage object");
                        }
                        C0648g c0648g2 = new C0648g(C0656o.m6269a(m5973c2), m5973c2);
                        if (hashSet.contains(c0648g2)) {
                            throw new SecurityException("Encountered duplicate entries in SigningCertificateLineage at certificate #" + i2 + ".  All signing certificates should be unique");
                        }
                        hashSet.add(c0648g2);
                        arrayList.add(new a(c0648g2, EnumC0609i.m6078a(i7), EnumC0609i.m6078a(i6), m5973c, i5));
                        i = i2;
                        i4 = i6;
                        c0648g = c0648g2;
                    } catch (InvalidAlgorithmParameterException e17) {
                        e = e17;
                        i = i2;
                        str5 = " when parsing V3SigningCertificateLineage object";
                        str7 = str5;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (InvalidKeyException e18) {
                        e = e18;
                        i = i2;
                        str4 = " when parsing V3SigningCertificateLineage object";
                        str7 = str4;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (NoSuchAlgorithmException e19) {
                        e = e19;
                        i = i2;
                        str3 = " when parsing V3SigningCertificateLineage object";
                        str7 = str3;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (SignatureException e20) {
                        e = e20;
                        i = i2;
                        str2 = " when parsing V3SigningCertificateLineage object";
                        str7 = str2;
                        throw new SecurityException("Failed to verify signature over signed data for certificate #" + i + str7, e);
                    } catch (CertificateException e21) {
                        e = e21;
                        i3 = i2;
                        str = " when parsing V3SigningCertificateLineage object";
                        str6 = str;
                        throw new SecurityException("Failed to decode certificate #" + i3 + str6, e);
                    }
                }
                return arrayList;
            } catch (C0579a e22) {
                e = e22;
                throw new IOException("Failed to parse V3SigningCertificateLineage object", e);
            } catch (BufferUnderflowException e23) {
                e = e23;
                throw new IOException("Failed to parse V3SigningCertificateLineage object", e);
            }
        } catch (InvalidAlgorithmParameterException e24) {
            e = e24;
            i = 0;
            str5 = " when parsing V3SigningCertificateLineage object";
        } catch (InvalidKeyException e25) {
            e = e25;
            i = 0;
            str4 = " when parsing V3SigningCertificateLineage object";
        } catch (NoSuchAlgorithmException e26) {
            e = e26;
            i = 0;
            str3 = " when parsing V3SigningCertificateLineage object";
        } catch (SignatureException e27) {
            e = e27;
            i = 0;
            str2 = " when parsing V3SigningCertificateLineage object";
        } catch (CertificateException e28) {
            e = e28;
            str = " when parsing V3SigningCertificateLineage object";
        }
    }

    /* renamed from: a */
    public static byte[] m6013a(List<a> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m6011a(it.next()));
        }
        byte[] m5960a = C0598d.m5960a(arrayList);
        ByteBuffer allocate = ByteBuffer.allocate(m5960a.length + 4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(1);
        allocate.put(m5960a);
        return allocate.array();
    }

    /* renamed from: a */
    public static byte[] m6011a(a aVar) {
        int m6081b = aVar.f4124b != null ? aVar.f4124b.m6081b() : 0;
        int m6081b2 = aVar.f4125c != null ? aVar.f4125c.m6081b() : 0;
        byte[] m6012a = m6012a(aVar.f4127e, m6081b);
        byte[] m5962a = C0598d.m5962a(aVar.f4126d);
        ByteBuffer allocate = ByteBuffer.allocate(m6012a.length + 4 + 4 + m5962a.length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(m6012a);
        allocate.putInt(aVar.f4123a);
        allocate.putInt(m6081b2);
        allocate.put(m5962a);
        return allocate.array();
    }

    /* renamed from: a */
    public static byte[] m6012a(X509Certificate x509Certificate, int i) {
        try {
            byte[] m5962a = C0598d.m5962a(x509Certificate.getEncoded());
            ByteBuffer allocate = ByteBuffer.allocate(m5962a.length + 4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.put(m5962a);
            allocate.putInt(i);
            return C0598d.m5962a(allocate.array());
        } catch (CertificateEncodingException e2) {
            throw new RuntimeException("Failed to encode V3SigningCertificateLineage certificate", e2);
        }
    }

    /* compiled from: V3SigningCertificateLineage.java */
    /* renamed from: com.b.a.b.a.d.c$a */
    public static class a {

        /* renamed from: a */
        public int f4123a;

        /* renamed from: b */
        public final EnumC0609i f4124b;

        /* renamed from: c */
        public EnumC0609i f4125c;

        /* renamed from: d */
        public final byte[] f4126d;

        /* renamed from: e */
        public final X509Certificate f4127e;

        public a(X509Certificate x509Certificate, EnumC0609i enumC0609i, EnumC0609i enumC0609i2, byte[] bArr, int i) {
            this.f4127e = x509Certificate;
            this.f4124b = enumC0609i;
            this.f4125c = enumC0609i2;
            this.f4126d = bArr;
            this.f4123a = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4127e.equals(aVar.f4127e) && this.f4124b == aVar.f4124b && this.f4125c == aVar.f4125c && Arrays.equals(this.f4126d, aVar.f4126d) && this.f4123a == aVar.f4123a;
        }

        public int hashCode() {
            return (Objects.hash(this.f4127e, this.f4124b, this.f4125c, Integer.valueOf(this.f4123a)) * 31) + Arrays.hashCode(this.f4126d);
        }
    }
}
