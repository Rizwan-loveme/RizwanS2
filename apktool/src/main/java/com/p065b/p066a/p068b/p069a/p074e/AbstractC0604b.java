package com.p065b.p066a.p068b.p069a.p074e;

import com.p065b.p066a.C0675d;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p069a.p074e.C0605c;
import com.p065b.p066a.p068b.p081g.C0648g;
import com.p065b.p066a.p068b.p081g.C0656o;
import com.p065b.p066a.p084c.InterfaceC0671c;
import java.io.File;
import java.io.FileInputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

/* compiled from: V4SchemeVerifier.java */
/* renamed from: com.b.a.b.a.e.b */
/* loaded from: classes.dex */
public abstract class AbstractC0604b {
    private AbstractC0604b() {
    }

    /* renamed from: a */
    public static C0598d.e m6052a(InterfaceC0671c interfaceC0671c, File file) {
        int i = 0;
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            C0605c m6062b = C0605c.m6062b(fileInputStream);
            byte[] m6060a = C0605c.m6060a(fileInputStream);
            fileInputStream.close();
            C0598d.e eVar = new C0598d.e(4);
            if (m6062b == null) {
                eVar.m6018a(C0675d.d.V4_SIG_NO_SIGNATURES, "Signature file does not contain a v4 signature.");
            } else {
                if (m6062b.f4166c != 2) {
                    eVar.m6019b(C0675d.d.V4_SIG_VERSION_NOT_CURRENT, Integer.valueOf(m6062b.f4166c), 2);
                }
                C0605c.a m6065a = C0605c.a.m6065a(m6062b.f4164a);
                C0605c.d m6072a = C0605c.d.m6072a(m6062b.f4165b);
                C0605c.b bVar = m6072a.f4179a;
                C0598d.e.a m6051a = m6051a(bVar, C0605c.m6059a(interfaceC0671c.mo6233a(), m6065a, bVar));
                eVar.f4128d.add(m6051a);
                if (!eVar.mo5855a()) {
                    C0605c.c[] cVarArr = m6072a.f4180b;
                    int length = cVarArr.length;
                    while (true) {
                        if (i < length) {
                            C0605c.b m6068a = C0605c.b.m6068a(cVarArr[i].f4178b);
                            eVar.f4128d.add(m6051a(m6068a, C0605c.m6059a(interfaceC0671c.mo6233a(), m6065a, m6068a)));
                            if (eVar.mo5855a()) {
                                break;
                            }
                            i++;
                        } else {
                            m6053a(interfaceC0671c, m6051a, m6065a.f4169c, m6060a);
                            if (!eVar.mo5855a()) {
                                eVar.f4014c = true;
                            }
                        }
                    }
                }
            }
            return eVar;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static C0598d.e.a m6051a(C0605c.b bVar, byte[] bArr) {
        byte[] encoded;
        C0598d.e.a aVar = new C0598d.e.a();
        aVar.f4049c = 0;
        int i = bVar.f4176f;
        byte[] bArr2 = bVar.f4175e;
        aVar.f4136i.add(new C0598d.e.a.c(i, bArr2));
        EnumC0609i m6078a = EnumC0609i.m6078a(i);
        if (m6078a == null) {
            aVar.m6020a(C0675d.d.V4_SIG_UNKNOWN_SIG_ALGORITHM, Integer.valueOf(i));
            return aVar;
        }
        String m6251a = m6078a.m6084e().m6251a();
        AlgorithmParameterSpec m6252b = m6078a.m6084e().m6252b();
        String m6082c = m6078a.m6082c();
        byte[] bArr3 = bVar.f4174d;
        try {
            PublicKey generatePublic = KeyFactory.getInstance(m6082c).generatePublic(new X509EncodedKeySpec(bArr3));
            try {
                Signature signature = Signature.getInstance(m6251a);
                signature.initVerify(generatePublic);
                if (m6252b != null) {
                    signature.setParameter(m6252b);
                }
                signature.update(bArr);
                if (!signature.verify(bArr2)) {
                    aVar.m6020a(C0675d.d.V4_SIG_DID_NOT_VERIFY, m6078a);
                    return aVar;
                }
                aVar.f4140m.put(m6078a, bArr2);
                if (bVar.f4173c == null) {
                    aVar.m6020a(C0675d.d.V4_SIG_NO_CERTIFICATE, new Object[0]);
                    return aVar;
                }
                try {
                    C0648g c0648g = new C0648g(C0656o.m6269a(bVar.f4173c), bVar.f4173c);
                    aVar.f4048b.add(c0648g);
                    try {
                        encoded = C0598d.m5959a(c0648g.getPublicKey());
                    } catch (InvalidKeyException e2) {
                        System.out.println("Caught an exception encoding the public key: " + e2);
                        e2.printStackTrace();
                        encoded = c0648g.getPublicKey().getEncoded();
                    }
                    if (!Arrays.equals(bArr3, encoded)) {
                        aVar.m6020a(C0675d.d.V4_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD, C0598d.m5971c(encoded), C0598d.m5971c(bArr3));
                        return aVar;
                    }
                    aVar.f4133f.add(new C0598d.e.a.b(0, bVar.f4172b));
                    return aVar;
                } catch (CertificateException e3) {
                    aVar.m6020a(C0675d.d.V4_SIG_MALFORMED_CERTIFICATE, e3);
                    return aVar;
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | SignatureException e4) {
                aVar.m6020a(C0675d.d.V4_SIG_VERIFY_EXCEPTION, m6078a, e4);
                return aVar;
            }
        } catch (Exception e5) {
            aVar.m6020a(C0675d.d.V4_SIG_MALFORMED_PUBLIC_KEY, e5);
            return aVar;
        }
    }

    /* renamed from: a */
    private static void m6053a(InterfaceC0671c interfaceC0671c, C0598d.e.a aVar, byte[] bArr, byte[] bArr2) {
        C0598d.j m5944a = C0598d.m5944a(interfaceC0671c);
        EnumC0607g enumC0607g = m5944a.f4157a;
        byte[] bArr3 = m5944a.f4158b;
        byte[] bArr4 = m5944a.f4159c;
        if (!Arrays.equals(bArr, bArr3)) {
            aVar.m6020a(C0675d.d.V4_SIG_APK_ROOT_DID_NOT_VERIFY, enumC0607g, C0598d.m5971c(bArr), C0598d.m5971c(bArr3));
        } else if (bArr2 != null && !Arrays.equals(bArr2, bArr4)) {
            aVar.m6020a(C0675d.d.V4_SIG_APK_TREE_DID_NOT_VERIFY, enumC0607g, C0598d.m5971c(bArr), C0598d.m5971c(bArr3));
        } else {
            aVar.f4139l.put(enumC0607g, bArr3);
        }
    }
}
