package com.p065b.p066a.p068b.p069a.p073d;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.C0680g;
import com.p065b.p066a.p068b.p069a.C0598d;
import com.p065b.p066a.p068b.p069a.EnumC0607g;
import com.p065b.p066a.p068b.p069a.EnumC0609i;
import com.p065b.p066a.p068b.p077c.C0628b;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p084c.InterfaceC0673e;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: V3SchemeSigner.java */
/* renamed from: com.b.a.b.a.d.a */
/* loaded from: classes.dex */
public class C0599a {
    public static final int APK_SIGNATURE_SCHEME_V3_BLOCK_ID = -262969152;
    public static final int PROOF_OF_ROTATION_ATTR_ID = 1000370060;

    /* renamed from: a */
    private final InterfaceC0671c f4061a;

    /* renamed from: b */
    private final int f4062b;

    /* renamed from: c */
    private final InterfaceC0671c f4063c;

    /* renamed from: d */
    private final InterfaceC0671c f4064d;

    /* renamed from: e */
    private final InterfaceC0673e f4065e;

    /* renamed from: f */
    private final C0628b f4066f;

    /* renamed from: g */
    private final boolean f4067g;

    /* renamed from: h */
    private final List<C0598d.g> f4068h;

    private C0599a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3, List<C0598d.g> list, InterfaceC0673e interfaceC0673e, int i, C0628b c0628b, boolean z) {
        this.f4061a = interfaceC0671c;
        this.f4063c = interfaceC0671c2;
        this.f4064d = interfaceC0671c3;
        this.f4068h = list;
        this.f4065e = interfaceC0673e;
        this.f4062b = i;
        this.f4066f = c0628b;
        this.f4067g = z;
    }

    /* renamed from: a */
    public static List<EnumC0609i> m5977a(PublicKey publicKey, int i, boolean z, boolean z2) {
        EnumC0609i enumC0609i;
        String algorithm = publicKey.getAlgorithm();
        if (KeyProperties.KEY_ALGORITHM_RSA.equalsIgnoreCase(algorithm)) {
            if (((RSAKey) publicKey).getModulus().bitLength() <= 3072) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(EnumC0609i.RSA_PKCS1_V1_5_WITH_SHA256);
                if (z) {
                    arrayList.add(EnumC0609i.VERITY_RSA_PKCS1_V1_5_WITH_SHA256);
                    return arrayList;
                }
                return arrayList;
            }
            return Collections.singletonList(EnumC0609i.RSA_PKCS1_V1_5_WITH_SHA512);
        }
        if ("DSA".equalsIgnoreCase(algorithm)) {
            ArrayList arrayList2 = new ArrayList();
            if (z2) {
                enumC0609i = EnumC0609i.DETDSA_WITH_SHA256;
            } else {
                enumC0609i = EnumC0609i.DSA_WITH_SHA256;
            }
            arrayList2.add(enumC0609i);
            if (z) {
                arrayList2.add(EnumC0609i.VERITY_DSA_WITH_SHA256);
            }
            return arrayList2;
        }
        if (KeyProperties.KEY_ALGORITHM_EC.equalsIgnoreCase(algorithm)) {
            if (((ECKey) publicKey).getParams().getOrder().bitLength() <= 256) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(EnumC0609i.ECDSA_WITH_SHA256);
                if (z) {
                    arrayList3.add(EnumC0609i.VERITY_ECDSA_WITH_SHA256);
                    return arrayList3;
                }
                return arrayList3;
            }
            return Collections.singletonList(EnumC0609i.ECDSA_WITH_SHA512);
        }
        throw new InvalidKeyException("Unsupported key algorithm: " + algorithm);
    }

    /* renamed from: a */
    public static byte[] m5983a(C0680g c0680g) {
        byte[] m6491a = c0680g.m6491a();
        ByteBuffer allocate = ByteBuffer.allocate(m6491a.length + 8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(m6491a.length + 4);
        allocate.putInt(PROOF_OF_ROTATION_ATTR_ID);
        allocate.put(m6491a);
        return allocate.array();
    }

    /* renamed from: a */
    private static byte[] m5978a(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(8);
        allocate.putInt(1436519170);
        allocate.putInt(i);
        return allocate.array();
    }

    /* renamed from: b */
    private static byte[] m5984b() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(4);
        allocate.putInt(-1029262406);
        return allocate.array();
    }

    /* renamed from: a */
    public C0598d.h m5985a() {
        C0652k<List<C0598d.g>, Map<EnumC0607g, byte[]>> m5947a = C0598d.m5947a(this.f4065e, this.f4061a, this.f4063c, this.f4064d, this.f4068h);
        return new C0598d.h(m5976a(m5947a.m6252b()), m5947a.m6252b());
    }

    /* renamed from: a */
    private C0652k<byte[], Integer> m5976a(Map<EnumC0607g, byte[]> map) {
        ArrayList arrayList = new ArrayList(this.f4068h.size());
        Iterator<C0598d.g> it = this.f4068h.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            try {
                arrayList.add(m5980a(it.next(), map));
            } catch (InvalidKeyException e2) {
                throw new InvalidKeyException("Signer #" + i + " failed", e2);
            } catch (SignatureException e3) {
                throw new SignatureException("Signer #" + i + " failed", e3);
            }
        }
        return C0652k.m6250a(C0598d.m5964a(new byte[][]{C0598d.m5960a(arrayList)}), Integer.valueOf(this.f4062b));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private byte[] m5980a(C0598d.g gVar, Map<EnumC0607g, byte[]> map) {
        Object[] objArr = 0;
        if (gVar.f4149a.isEmpty()) {
            throw new SignatureException("No certificates configured for signer");
        }
        byte[] m5959a = C0598d.m5959a(gVar.f4149a.get(0).getPublicKey());
        b.a aVar = new b.a();
        try {
            aVar.f4082b = C0598d.m5972c(gVar.f4149a);
            ArrayList arrayList = new ArrayList(gVar.f4154f.size());
            for (EnumC0609i enumC0609i : gVar.f4154f) {
                EnumC0607g m6080a = enumC0609i.m6080a();
                byte[] bArr = map.get(m6080a);
                if (bArr == null) {
                    throw new RuntimeException(m6080a + " content digest for " + enumC0609i + " not computed");
                }
                arrayList.add(C0652k.m6250a(Integer.valueOf(enumC0609i.m6081b()), bArr));
            }
            aVar.f4083c = arrayList;
            aVar.f4085e = gVar.f4152d;
            aVar.f4084d = gVar.f4151c;
            aVar.f4081a = m5979a(gVar);
            b.C3329b c3329b = new b.C3329b();
            c3329b.f4090e = m5981a(aVar);
            c3329b.f4087b = gVar.f4152d;
            c3329b.f4086a = gVar.f4151c;
            c3329b.f4088c = m5959a;
            c3329b.f4089d = C0598d.m5950a(gVar, c3329b.f4090e);
            return m5982a(c3329b);
        } catch (CertificateEncodingException e2) {
            throw new SignatureException("Failed to encode certificates", e2);
        }
    }

    /* renamed from: a */
    private byte[] m5982a(b.C3329b c3329b) {
        byte[] m5962a = C0598d.m5962a(c3329b.f4090e);
        byte[] m5962a2 = C0598d.m5962a(C0598d.m5970b(c3329b.f4089d));
        byte[] m5962a3 = C0598d.m5962a(c3329b.f4088c);
        int length = m5962a.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4 + 4 + m5962a2.length + m5962a3.length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(m5962a);
        allocate.putInt(c3329b.f4087b);
        allocate.putInt(c3329b.f4086a);
        allocate.put(m5962a2);
        allocate.put(m5962a3);
        return allocate.array();
    }

    /* renamed from: a */
    private byte[] m5981a(b.a aVar) {
        byte[] m5962a = C0598d.m5962a(C0598d.m5970b(aVar.f4083c));
        byte[] m5962a2 = C0598d.m5962a(C0598d.m5960a(aVar.f4082b));
        byte[] m5962a3 = C0598d.m5962a(aVar.f4081a);
        ByteBuffer allocate = ByteBuffer.allocate(m5962a.length + m5962a2.length + 4 + 4 + m5962a3.length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put(m5962a);
        allocate.put(m5962a2);
        allocate.putInt(aVar.f4085e);
        allocate.putInt(aVar.f4084d);
        allocate.put(m5962a3);
        return allocate.array();
    }

    /* renamed from: a */
    private byte[] m5979a(C0598d.g gVar) {
        if (gVar.f4150b == null) {
            return this.f4066f.m6195c() ? m5978a(this.f4066f.m6194b()) : new byte[0];
        }
        byte[] m5983a = m5983a(gVar.f4150b);
        if (!this.f4067g || this.f4062b != 462663009) {
            return m5983a;
        }
        byte[] m5984b = m5984b();
        byte[] bArr = new byte[m5983a.length + m5984b.length];
        System.arraycopy(m5983a, 0, bArr, 0, m5983a.length);
        System.arraycopy(m5984b, 0, bArr, m5983a.length, m5984b.length);
        return bArr;
    }

    /* compiled from: V3SchemeSigner.java */
    /* renamed from: com.b.a.b.a.d.a$b */
    private static final class b {

        /* compiled from: V3SchemeSigner.java */
        /* renamed from: com.b.a.b.a.d.a$b$b, reason: collision with other inner class name */
        private static final class C3329b {

            /* renamed from: a */
            public int f4086a;

            /* renamed from: b */
            public int f4087b;

            /* renamed from: c */
            public byte[] f4088c;

            /* renamed from: d */
            public List<C0652k<Integer, byte[]>> f4089d;

            /* renamed from: e */
            public byte[] f4090e;

            private C3329b() {
            }
        }

        private b() {
        }

        /* compiled from: V3SchemeSigner.java */
        /* renamed from: com.b.a.b.a.d.a$b$a */
        private static final class a {

            /* renamed from: a */
            public byte[] f4081a;

            /* renamed from: b */
            public List<byte[]> f4082b;

            /* renamed from: c */
            public List<C0652k<Integer, byte[]>> f4083c;

            /* renamed from: d */
            public int f4084d;

            /* renamed from: e */
            public int f4085e;

            private a() {
            }
        }
    }

    /* compiled from: V3SchemeSigner.java */
    /* renamed from: com.b.a.b.a.d.a$a */
    public static class a {

        /* renamed from: a */
        private final InterfaceC0671c f4073a;

        /* renamed from: c */
        private final InterfaceC0671c f4075c;

        /* renamed from: d */
        private final InterfaceC0671c f4076d;

        /* renamed from: h */
        private final List<C0598d.g> f4080h;

        /* renamed from: e */
        private InterfaceC0673e f4077e = InterfaceC0673e.MULTI_THREADED;

        /* renamed from: b */
        private int f4074b = C0599a.APK_SIGNATURE_SCHEME_V3_BLOCK_ID;

        /* renamed from: f */
        private C0628b f4078f = C0628b.m6192a();

        /* renamed from: g */
        private boolean f4079g = false;

        public a(InterfaceC0671c interfaceC0671c, InterfaceC0671c interfaceC0671c2, InterfaceC0671c interfaceC0671c3, List<C0598d.g> list) {
            this.f4073a = interfaceC0671c;
            this.f4075c = interfaceC0671c2;
            this.f4076d = interfaceC0671c3;
            this.f4080h = list;
        }

        /* renamed from: a */
        public a m5987a(InterfaceC0673e interfaceC0673e) {
            this.f4077e = interfaceC0673e;
            return this;
        }

        /* renamed from: a */
        public a m5986a(int i) {
            this.f4074b = i;
            return this;
        }

        /* renamed from: b */
        public a m5990b(int i) {
            this.f4078f = C0628b.m6193a(i);
            return this;
        }

        /* renamed from: a */
        public a m5988a(boolean z) {
            this.f4079g = z;
            return this;
        }

        /* renamed from: a */
        public C0599a m5989a() {
            return new C0599a(this.f4073a, this.f4075c, this.f4076d, this.f4080h, this.f4077e, this.f4074b, this.f4078f, this.f4079g);
        }
    }
}
