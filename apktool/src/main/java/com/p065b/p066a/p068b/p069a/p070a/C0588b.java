package com.p065b.p066a.p068b.p069a.p070a;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p067a.C0579a;
import com.p065b.p066a.p068b.p069a.C0595c;
import com.p065b.p066a.p068b.p069a.C0602e;
import com.p065b.p066a.p068b.p069a.C0606f;
import com.p065b.p066a.p068b.p069a.C0608h;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p069a.p070a.C0587a;
import com.p065b.p066a.p068b.p081g.C0644c;
import com.p065b.p066a.p068b.p081g.C0648g;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.ByteArrayInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SourceStampVerifier.java */
/* renamed from: com.b.a.b.a.a.b */
/* loaded from: classes.dex */
class C0588b {
    private C0588b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m5832a(ByteBuffer byteBuffer, CertificateFactory certificateFactory, C0595c c0595c, Map<Integer, byte[]> map, byte[] bArr, int i, int i2) {
        X509Certificate m5831a = m5831a(byteBuffer, certificateFactory, bArr, c0595c);
        if (!c0595c.mo5931b() && !c0595c.mo5930a()) {
            ByteBuffer m6035b = C0602e.m6035b(byteBuffer);
            HashMap hashMap = new HashMap();
            while (m6035b.hasRemaining()) {
                ByteBuffer m6035b2 = C0602e.m6035b(m6035b);
                int i3 = m6035b2.getInt();
                hashMap.put(Integer.valueOf(i3), C0602e.m6035b(m6035b2));
            }
            for (Map.Entry<Integer, byte[]> entry : map.entrySet()) {
                if (entry.getKey().intValue() != 31) {
                    if (!hashMap.containsKey(entry.getKey())) {
                        c0595c.m5929a(17, new Object[0]);
                        return;
                    }
                    m5834a(entry.getValue(), i, i2, m5831a, (ByteBuffer) hashMap.get(entry.getKey()), c0595c);
                    if (c0595c.mo5931b() || c0595c.mo5930a()) {
                        return;
                    }
                }
            }
            if (byteBuffer.hasRemaining()) {
                ByteBuffer m6035b3 = C0602e.m6035b(byteBuffer);
                ByteBuffer m6035b4 = C0602e.m6035b(byteBuffer);
                byte[] bArr2 = new byte[m6035b3.remaining()];
                m6035b3.get(bArr2);
                m6035b3.flip();
                m5834a(bArr2, i, i2, m5831a, m6035b4, c0595c);
                if (c0595c.mo5930a() || c0595c.mo5931b()) {
                    return;
                }
                m5833a(m6035b3, m5831a, c0595c);
            }
        }
    }

    /* renamed from: a */
    private static X509Certificate m5831a(ByteBuffer byteBuffer, CertificateFactory certificateFactory, byte[] bArr, C0595c c0595c) {
        byte[] m6037c = C0602e.m6037c(byteBuffer);
        try {
            C0648g c0648g = new C0648g((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(m6037c)), m6037c);
            c0595c.f4048b.add(c0648g);
            MessageDigest messageDigest = MessageDigest.getInstance(KeyProperties.DIGEST_SHA256);
            messageDigest.update(m6037c);
            byte[] digest = messageDigest.digest();
            if (Arrays.equals(bArr, digest)) {
                return c0648g;
            }
            c0595c.m5929a(27, C0602e.m6029a(digest), C0602e.m6029a(bArr));
            return null;
        } catch (CertificateException e2) {
            c0595c.m5929a(18, e2);
            return null;
        }
    }

    /* renamed from: a */
    private static void m5834a(byte[] bArr, int i, int i2, X509Certificate x509Certificate, ByteBuffer byteBuffer, C0595c c0595c) {
        ArrayList<C0606f> arrayList = new ArrayList(1);
        int i3 = 0;
        while (byteBuffer.hasRemaining()) {
            i3++;
            try {
                ByteBuffer m6035b = C0602e.m6035b(byteBuffer);
                int i4 = m6035b.getInt();
                byte[] m6037c = C0602e.m6037c(m6035b);
                EnumC0609i m6078a = EnumC0609i.m6078a(i4);
                if (m6078a == null) {
                    c0595c.m5929a(19, Integer.valueOf(i4));
                } else {
                    arrayList.add(new C0606f(m6078a, m6037c));
                }
            } catch (C0579a | BufferUnderflowException e2) {
                c0595c.m5929a(20, Integer.valueOf(i3));
                return;
            }
        }
        if (arrayList.isEmpty()) {
            c0595c.m5929a(17, new Object[0]);
            return;
        }
        try {
            for (C0606f c0606f : C0602e.m6032a(arrayList, i, i2, true)) {
                EnumC0609i enumC0609i = c0606f.f4181a;
                String m6251a = enumC0609i.m6084e().m6251a();
                AlgorithmParameterSpec m6252b = enumC0609i.m6084e().m6252b();
                PublicKey publicKey = x509Certificate.getPublicKey();
                try {
                    Signature signature = Signature.getInstance(m6251a);
                    signature.initVerify(publicKey);
                    if (m6252b != null) {
                        signature.setParameter(m6252b);
                    }
                    signature.update(bArr);
                    if (!signature.verify(c0606f.f4182b)) {
                        c0595c.m5929a(21, enumC0609i);
                        return;
                    }
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException e3) {
                    c0595c.m5929a(22, enumC0609i, e3);
                    return;
                }
            }
        } catch (C0608h e4) {
            StringBuilder sb = new StringBuilder();
            for (C0606f c0606f2 : arrayList) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(c0606f2.f4181a);
            }
            c0595c.m5929a(26, sb.toString(), e4);
        }
    }

    /* renamed from: a */
    private static void m5833a(ByteBuffer byteBuffer, X509Certificate x509Certificate, C0595c c0595c) {
        ByteBuffer m6035b = C0602e.m6035b(byteBuffer);
        int i = 0;
        while (m6035b.hasRemaining()) {
            i++;
            try {
                ByteBuffer m6035b2 = C0602e.m6035b(m6035b);
                int i2 = m6035b2.getInt();
                byte[] m6241a = C0644c.m6241a(m6035b2);
                if (i2 == -1654455305) {
                    m5835a(m6241a, x509Certificate, c0595c);
                } else if (i2 == -465807034) {
                    long j = ByteBuffer.wrap(m6241a).order(ByteOrder.LITTLE_ENDIAN).getLong();
                    if (j > 0) {
                        c0595c.f4050d = j;
                    } else {
                        c0595c.m5929a(38, Long.valueOf(j));
                    }
                } else {
                    c0595c.m5929a(32, Integer.valueOf(i2));
                }
            } catch (C0579a e2) {
                c0595c.m5929a(31, Integer.valueOf(i));
                return;
            } catch (BufferUnderflowException e3) {
                c0595c.m5929a(31, Integer.valueOf(i));
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m5835a(byte[] bArr, X509Certificate x509Certificate, C0595c c0595c) {
        try {
            List<C0587a.a> m5826a = C0587a.m5826a(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
            for (int i = 0; i < m5826a.size(); i++) {
                c0595c.f4047a.add(m5826a.get(i).f3997e);
            }
            if (!x509Certificate.equals(c0595c.f4047a.get(c0595c.f4047a.size() - 1))) {
                c0595c.m5929a(34, new Object[0]);
            }
        } catch (IllegalArgumentException e2) {
            c0595c.m5929a(34, new Object[0]);
        } catch (SecurityException e3) {
            c0595c.m5929a(35, new Object[0]);
        } catch (Exception e4) {
            c0595c.m5929a(33, new Object[0]);
        }
    }
}
