package p165d.p167b.p173f;

import java.p209io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: X509Key.java */
/* renamed from: d.b.f.bt */
/* loaded from: classes.dex */
public class C1502bt implements PublicKey {

    /* renamed from: a */
    protected C1505e f9621a;

    /* renamed from: b */
    protected byte[] f9622b;

    /* renamed from: c */
    @Deprecated
    protected byte[] f9623c = null;

    /* renamed from: e */
    private int f9625e = 0;

    /* renamed from: d */
    private C1440c f9624d = null;

    public C1502bt() {
    }

    private C1502bt(C1505e c1505e, C1440c c1440c) {
        this.f9621a = c1505e;
        m11616a(c1440c);
        m11618a();
    }

    /* renamed from: a */
    protected void m11616a(C1440c c1440c) {
        this.f9624d = (C1440c) c1440c.clone();
        this.f9623c = c1440c.m11323c();
        int m11319a = c1440c.m11319a() % 8;
        this.f9625e = m11319a == 0 ? 0 : 8 - m11319a;
    }

    /* renamed from: c */
    protected C1440c m11620c() {
        this.f9624d = new C1440c((this.f9623c.length * 8) - this.f9625e, this.f9623c);
        return (C1440c) this.f9624d.clone();
    }

    /* renamed from: a */
    public static PublicKey m11613a(C1450m c1450m) {
        if (c1450m.f9357c != 48) {
            throw new IOException("corrupt subject key");
        }
        try {
            PublicKey m11614a = m11614a(C1505e.m11630a(c1450m.f9356b.m11371d()), c1450m.f9356b.m11379k());
            if (c1450m.f9356b.m11362a() != 0) {
                throw new IOException("excess subject key");
            }
            return m11614a;
        } catch (InvalidKeyException e2) {
            throw new IOException("subject key, " + e2.getMessage(), e2);
        }
    }

    /* renamed from: d */
    protected void m11621d() {
        m11618a();
    }

    /* renamed from: a */
    static PublicKey m11614a(C1505e c1505e, C1440c c1440c) {
        Provider provider;
        Class<?> loadClass;
        C1449l c1449l = new C1449l();
        m11615a(c1449l, c1505e, c1440c);
        try {
            return KeyFactory.getInstance(c1505e.m11642d()).generatePublic(new X509EncodedKeySpec(c1449l.toByteArray()));
        } catch (NoSuchAlgorithmException e2) {
            try {
                try {
                    provider = Security.getProvider("SUN");
                } catch (ClassNotFoundException e3) {
                }
            } catch (IllegalAccessException e4) {
                throw new IOException(String.valueOf("") + " [internal error]");
            } catch (InstantiationException e5) {
            }
            if (provider == null) {
                throw new InstantiationException();
            }
            String property = provider.getProperty("PublicKey.X.509." + c1505e.m11642d());
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
            if (newInstance instanceof C1502bt) {
                C1502bt c1502bt = (C1502bt) newInstance;
                c1502bt.f9621a = c1505e;
                c1502bt.m11616a(c1440c);
                c1502bt.m11621d();
                return c1502bt;
            }
            return new C1502bt(c1505e, c1440c);
        } catch (InvalidKeySpecException e7) {
            throw new InvalidKeyException(e7.getMessage(), e7);
        }
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f9621a.m11642d();
    }

    /* renamed from: a */
    public final void m11617a(C1449l c1449l) {
        m11615a(c1449l, this.f9621a, m11620c());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (byte[]) m11619b().clone();
        } catch (InvalidKeyException e2) {
            return null;
        }
    }

    /* renamed from: b */
    public byte[] m11619b() {
        byte[] bArr = this.f9622b;
        if (bArr == null) {
            try {
                C1449l c1449l = new C1449l();
                m11617a(c1449l);
                bArr = c1449l.toByteArray();
                this.f9622b = bArr;
            } catch (IOException e2) {
                throw new InvalidKeyException("IOException : " + e2.getMessage());
            }
        }
        return bArr;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    /* renamed from: a */
    public byte[] m11618a() {
        return (byte[]) m11619b().clone();
    }

    public String toString() {
        return "algorithm = " + this.f9621a.toString() + ", unparsed keybits = \n" + new C1420b().m11234b(this.f9623c);
    }

    public boolean equals(Object obj) {
        byte[] encoded;
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Key)) {
            return false;
        }
        try {
            byte[] m11619b = m11619b();
            if (obj instanceof C1502bt) {
                encoded = ((C1502bt) obj).m11619b();
            } else {
                encoded = ((Key) obj).getEncoded();
            }
            z = Arrays.equals(m11619b, encoded);
            return z;
        } catch (InvalidKeyException e2) {
            return z;
        }
    }

    public int hashCode() {
        try {
            byte[] m11619b = m11619b();
            int length = m11619b.length;
            for (byte b2 : m11619b) {
                length += (b2 & 255) * 37;
            }
            return length;
        } catch (InvalidKeyException e2) {
            return 0;
        }
    }

    /* renamed from: a */
    static void m11615a(C1449l c1449l, C1505e c1505e, C1440c c1440c) {
        C1449l c1449l2 = new C1449l();
        c1505e.m11637a(c1449l2);
        c1449l2.m11402b(c1440c);
        c1449l.m11388a((byte) 48, c1449l2);
    }
}
