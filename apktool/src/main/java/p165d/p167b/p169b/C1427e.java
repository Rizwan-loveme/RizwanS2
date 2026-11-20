package p165d.p167b.p169b;

import java.math.BigInteger;
import java.p209io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import p165d.p167b.p172e.C1444g;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p173f.C1505e;

/* compiled from: PKCS8Key.java */
/* renamed from: d.b.b.e */
/* loaded from: classes.dex */
public class C1427e implements PrivateKey {

    /* renamed from: a */
    public static final BigInteger f9230a = BigInteger.ZERO;

    /* renamed from: b */
    protected C1505e f9231b;

    /* renamed from: c */
    protected byte[] f9232c;

    /* renamed from: d */
    protected byte[] f9233d;

    /* renamed from: a */
    public static PrivateKey m11262a(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("corrupt private key");
        }
        BigInteger m11367b = c1450m.f9356b.m11367b();
        if (!f9230a.equals(m11367b)) {
            throw new IOException("version mismatch: (supported: " + C1444g.m11329a(f9230a) + ", parsed: " + C1444g.m11329a(m11367b));
        }
        try {
            PrivateKey m11263a = m11263a(C1505e.m11630a(c1450m.f9356b.m11371d()), c1450m.f9356b.m11377i());
            if (c1450m.f9356b.m11362a() != 0) {
                throw new IOException("excess private key");
            }
            return m11263a;
        } catch (InvalidKeyException e2) {
            throw new IOException("corrupt private key");
        }
    }

    /* renamed from: b */
    protected void m11267b() {
        m11266a();
    }

    /* renamed from: a */
    static PrivateKey m11263a(C1505e c1505e, byte[] bArr) {
        Provider provider;
        Class<?> loadClass;
        C1449l c1449l = new C1449l();
        m11264a(c1449l, c1505e, bArr);
        try {
            return KeyFactory.getInstance(c1505e.m11642d()).generatePrivate(new PKCS8EncodedKeySpec(c1449l.toByteArray()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            try {
                try {
                    provider = Security.getProvider("JKS");
                } catch (ClassNotFoundException e3) {
                }
            } catch (IllegalAccessException e4) {
                throw new IOException(String.valueOf("") + " [internal error]");
            } catch (InstantiationException e5) {
            }
            if (provider == null) {
                throw new InstantiationException();
            }
            String property = provider.getProperty("PrivateKey.PKCS#8." + c1505e.m11642d());
            if (property == null) {
                throw new InstantiationException();
            }
            try {
                loadClass = Class.forName(property);
            } catch (ClassNotFoundException e6) {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                loadClass = systemClassLoader != null ? systemClassLoader.loadClass(property) : null;
            }
            Object newInstance = loadClass != null ? loadClass.newInstance() : null;
            if (newInstance instanceof C1427e) {
                C1427e c1427e = (C1427e) newInstance;
                c1427e.f9231b = c1505e;
                c1427e.f9233d = bArr;
                c1427e.m11267b();
                return c1427e;
            }
            C1427e c1427e2 = new C1427e();
            c1427e2.f9231b = c1505e;
            c1427e2.f9233d = bArr;
            return c1427e2;
        }
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f9231b.m11642d();
    }

    /* renamed from: a */
    public final void m11265a(C1449l c1449l) {
        m11264a(c1449l, this.f9231b, this.f9233d);
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] bArr;
        synchronized (this) {
            bArr = null;
            try {
                bArr = m11266a();
            } catch (InvalidKeyException e2) {
            }
        }
        return bArr;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    /* renamed from: a */
    public byte[] m11266a() {
        if (this.f9232c == null) {
            try {
                C1449l c1449l = new C1449l();
                m11265a(c1449l);
                this.f9232c = c1449l.toByteArray();
            } catch (IOException e2) {
                throw new InvalidKeyException("IOException : " + e2.getMessage());
            }
        }
        return (byte[]) this.f9232c.clone();
    }

    /* renamed from: a */
    static void m11264a(C1449l c1449l, C1505e c1505e, byte[] bArr) {
        C1449l c1449l2 = new C1449l();
        c1449l2.m11396a(f9230a);
        c1505e.m11637a(c1449l2);
        c1449l2.m11405b(bArr);
        c1449l.m11388a((byte) 48, c1449l2);
    }

    public boolean equals(Object obj) {
        byte[] encoded;
        if (this == obj) {
            return true;
        }
        if (obj instanceof Key) {
            if (this.f9232c != null) {
                encoded = this.f9232c;
            } else {
                encoded = getEncoded();
            }
            return MessageDigest.isEqual(encoded, ((Key) obj).getEncoded());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        byte[] encoded = getEncoded();
        for (int i2 = 1; i2 < encoded.length; i2++) {
            i += encoded[i2] * i2;
        }
        return i;
    }
}
