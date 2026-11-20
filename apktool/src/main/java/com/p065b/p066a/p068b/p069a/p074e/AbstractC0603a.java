package com.p065b.p066a.p068b.p069a.p074e;

import com.p065b.p066a.p067a.AbstractC0581c;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p069a.p072c.AbstractC0596a;
import com.p065b.p066a.p068b.p069a.p072c.AbstractC0597b;
import com.p065b.p066a.p068b.p069a.p073d.C0599a;
import com.p065b.p066a.p068b.p069a.p073d.C0600b;
import com.p065b.p066a.p068b.p069a.p074e.C0605c;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0676a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

/* compiled from: V4SchemeSigner.java */
/* renamed from: com.b.a.b.a.e.a */
/* loaded from: classes.dex */
public abstract class AbstractC0603a {
    private AbstractC0603a() {
    }

    /* compiled from: V4SchemeSigner.java */
    /* renamed from: com.b.a.b.a.e.a$a */
    public static class a {

        /* renamed from: a */
        public final C0598d.g f4162a;

        /* renamed from: b */
        public final C0598d.g f4163b;

        public a(List<C0598d.g> list, List<C0598d.g> list2) {
            if (list == null || list.size() != 1) {
                throw new InvalidKeyException("Only accepting one signer config for V4 Signature.");
            }
            if (list2 != null && list2.size() != 1) {
                throw new InvalidKeyException("Only accepting one signer config for V4.1 Signature.");
            }
            this.f4163b = list.get(0);
            this.f4162a = list2 != null ? list2.get(0) : null;
        }
    }

    /* renamed from: a */
    public static List<EnumC0609i> m6043a(PublicKey publicKey, int i, boolean z, boolean z2) {
        List<EnumC0609i> m5977a = C0599a.m5977a(publicKey, i, z, z2);
        ListIterator<EnumC0609i> listIterator = m5977a.listIterator();
        while (listIterator.hasNext()) {
            if (!m6045a(listIterator.next().m6080a(), false)) {
                listIterator.remove();
            }
        }
        return m5977a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0024  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m6044a(InterfaceC0671c interfaceC0671c, a aVar, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        C0652k<C0605c, byte[]> m6042a = m6042a(interfaceC0671c, aVar);
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = fileOutputStream2;
            if (fileOutputStream != null) {
            }
            throw th;
        }
        try {
            m6042a.m6251a().m6064a(fileOutputStream);
            C0605c.m6057a(fileOutputStream, m6042a.m6252b());
            fileOutputStream.close();
        } catch (IOException e3) {
            e = e3;
            try {
                file.delete();
                throw e;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static C0652k<C0605c, byte[]> m6042a(InterfaceC0671c interfaceC0671c, a aVar) {
        long mo6233a = interfaceC0671c.mo6233a();
        byte[] m6046a = m6046a(interfaceC0671c);
        C0598d.j m5944a = C0598d.m5944a(interfaceC0671c);
        EnumC0607g enumC0607g = m5944a.f4157a;
        byte[] bArr = m5944a.f4158b;
        byte[] bArr2 = m5944a.f4159c;
        C0652k<Integer, Byte> m6049b = m6049b(enumC0607g);
        try {
            return C0652k.m6250a(m6041a(aVar, new C0605c.a(m6049b.m6251a().intValue(), m6049b.m6252b().byteValue(), null, bArr), m6046a, (byte[]) null, mo6233a), bArr2);
        } catch (InvalidKeyException | SignatureException | CertificateEncodingException e2) {
            throw new InvalidKeyException("Signer failed", e2);
        }
    }

    /* renamed from: a */
    private static C0605c.b m6040a(C0598d.g gVar, C0605c.a aVar, byte[] bArr, byte[] bArr2, long j) {
        if (gVar.f4149a.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        if (gVar.f4149a.size() != 1) {
            throw new CertificateEncodingException("Should only have one certificate");
        }
        PublicKey publicKey = gVar.f4149a.get(0).getPublicKey();
        byte[] bArr3 = C0598d.m5972c(gVar.f4149a).get(0);
        List<C0652k<Integer, byte[]>> m5950a = C0598d.m5950a(gVar, C0605c.m6059a(j, aVar, new C0605c.b(bArr, bArr3, bArr2, publicKey.getEncoded(), -1, null)));
        if (m5950a.size() != 1) {
            throw new SignatureException("Should only be one signature generated");
        }
        return new C0605c.b(bArr, bArr3, bArr2, publicKey.getEncoded(), m5950a.get(0).m6251a().intValue(), m5950a.get(0).m6252b());
    }

    /* renamed from: a */
    private static C0605c m6041a(a aVar, C0605c.a aVar2, byte[] bArr, byte[] bArr2, long j) {
        C0605c.d dVar;
        C0605c.b m6040a = m6040a(aVar.f4163b, aVar2, bArr, bArr2, j);
        if (aVar.f4162a != null) {
            dVar = new C0605c.d(m6040a, new C0605c.c(462663009, m6040a(aVar.f4162a, aVar2, bArr, bArr2, j).m6069a()));
        } else {
            dVar = new C0605c.d(m6040a);
        }
        return new C0605c(2, aVar2.m6066a(), dVar.m6073a());
    }

    /* renamed from: a */
    private static byte[] m6046a(InterfaceC0671c interfaceC0671c) {
        try {
            AbstractC0581c.c m5771a = AbstractC0581c.m5771a(interfaceC0671c);
            try {
                return m6050b(interfaceC0671c, m5771a);
            } catch (SignatureException e2) {
                try {
                    return m6047a(interfaceC0671c, m5771a);
                } catch (SignatureException e3) {
                    throw new IOException("Failed to obtain v2/v3 digest, v3 exception: " + e2 + ", v2 exception: " + e3);
                }
            }
        } catch (C0676a e4) {
            throw new IOException("Malformed APK: not a ZIP archive", e4);
        }
    }

    /* renamed from: b */
    private static byte[] m6050b(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        HashSet hashSet = new HashSet(1);
        C0598d.e eVar = new C0598d.e(3);
        try {
            C0600b.m5993a(C0598d.m5945a(interfaceC0671c, cVar, C0599a.APK_SIGNATURE_SCHEME_V3_BLOCK_ID, eVar).f4196e, hashSet, eVar);
            if (eVar.f4128d.size() != 1) {
                throw new SignatureException("Should only have one signer, errors: " + eVar.mo5857c());
            }
            C0598d.e.a aVar = eVar.f4128d.get(0);
            if (aVar.mo5930a()) {
                throw new SignatureException("Parsing failed: " + aVar.mo5932c());
            }
            return m6048a(eVar.f4128d.get(0).f4133f);
        } catch (Exception e2) {
            throw new SignatureException("Failed to extract and parse v3 block", e2);
        }
    }

    /* renamed from: a */
    private static byte[] m6047a(InterfaceC0671c interfaceC0671c, AbstractC0581c.c cVar) {
        HashSet hashSet = new HashSet(1);
        HashSet hashSet2 = new HashSet(1);
        C0598d.e eVar = new C0598d.e(2);
        try {
            AbstractC0597b.m5942a(C0598d.m5945a(interfaceC0671c, cVar, AbstractC0596a.APK_SIGNATURE_SCHEME_V2_BLOCK_ID, eVar).f4196e, hashSet, new HashMap(), hashSet2, Integer.MAX_VALUE, Integer.MAX_VALUE, eVar);
            if (eVar.f4128d.size() != 1) {
                throw new SignatureException("Should only have one signer, errors: " + eVar.mo5857c());
            }
            C0598d.e.a aVar = eVar.f4128d.get(0);
            if (aVar.mo5930a()) {
                throw new SignatureException("Parsing failed: " + aVar.mo5932c());
            }
            return m6048a(aVar.f4133f);
        } catch (Exception e2) {
            throw new SignatureException("Failed to extract and parse v2 block", e2);
        }
    }

    /* renamed from: a */
    private static byte[] m6048a(List<C0598d.e.a.b> list) {
        int m6039a;
        if (list == null || list.isEmpty()) {
            throw new SignatureException("Should have at least one digest");
        }
        int i = -1;
        byte[] bArr = null;
        for (C0598d.e.a.b bVar : list) {
            EnumC0607g m6080a = EnumC0609i.m6078a(bVar.m6023a()).m6080a();
            if (m6045a(m6080a, true) && i < (m6039a = m6039a(m6080a))) {
                i = m6039a;
                bArr = bVar.m6024b();
            }
        }
        if (bArr != null) {
            return bArr;
        }
        throw new SignatureException("Failed to find a supported digest in the source APK");
    }

    /* compiled from: V4SchemeSigner.java */
    /* renamed from: com.b.a.b.a.e.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$android$apksig$internal$apk$ContentDigestAlgorithm */
        static final int[] f4161x5cfc638a;

        static {
            int[] iArr = new int[EnumC0607g.values().length];
            f4161x5cfc638a = iArr;
            try {
                iArr[EnumC0607g.CHUNKED_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4161x5cfc638a[EnumC0607g.VERITY_CHUNKED_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4161x5cfc638a[EnumC0607g.CHUNKED_SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: a */
    public static int m6039a(EnumC0607g enumC0607g) {
        int i = AnonymousClass1.f4161x5cfc638a[enumC0607g.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? -1 : 2;
        }
        return 1;
    }

    /* renamed from: a */
    private static boolean m6045a(EnumC0607g enumC0607g, boolean z) {
        if (enumC0607g == null) {
            return false;
        }
        return enumC0607g == EnumC0607g.CHUNKED_SHA256 || enumC0607g == EnumC0607g.CHUNKED_SHA512 || (z && enumC0607g == EnumC0607g.VERITY_CHUNKED_SHA256);
    }

    /* renamed from: b */
    private static C0652k<Integer, Byte> m6049b(EnumC0607g enumC0607g) {
        if (AnonymousClass1.f4161x5cfc638a[enumC0607g.ordinal()] == 2) {
            return C0652k.m6250a(1, (byte) 12);
        }
        throw new NoSuchAlgorithmException("Invalid hash algorithm, only SHA2-256 over 4 KB chunks supported.");
    }
}
