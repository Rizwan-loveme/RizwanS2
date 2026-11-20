package p165d.p167b.p172e;

import java.math.BigInteger;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Vector;

/* compiled from: DerInputStream.java */
/* renamed from: d.b.e.k */
/* loaded from: classes.dex */
public class C1448k {

    /* renamed from: a */
    C1447j f9351a;

    /* renamed from: b */
    public byte f9352b;

    public C1448k(byte[] bArr) {
        m11361a(bArr, 0, bArr.length, true);
    }

    public C1448k(byte[] bArr, int i, int i2, boolean z) {
        m11361a(bArr, i, i2, z);
    }

    /* renamed from: a */
    private void m11361a(byte[] bArr, int i, int i2, boolean z) {
        if (i + 2 > bArr.length || i + i2 > bArr.length) {
            throw new IOException("Encoding bytes too short");
        }
        if (C1446i.m11335a(bArr[i + 1])) {
            if (!z) {
                throw new IOException("Indefinite length BER encoding found");
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            this.f9351a = new C1447j(new C1446i().m11345a(bArr2), z);
        } else {
            this.f9351a = new C1447j(bArr, i, i2, z);
        }
        this.f9351a.mark(Integer.MAX_VALUE);
    }

    C1448k(C1447j c1447j) {
        this.f9351a = c1447j;
        this.f9351a.mark(Integer.MAX_VALUE);
    }

    /* renamed from: b */
    public C1448k m11366b(int i, boolean z) {
        C1447j m11347a = this.f9351a.m11347a();
        m11347a.m11357e(i);
        if (z) {
            this.f9351a.skip(i);
        }
        return new C1448k(m11347a);
    }

    /* renamed from: n */
    public byte[] m11382n() {
        return this.f9351a.m11358e();
    }

    /* renamed from: f */
    public int m11374f() {
        if (this.f9351a.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        return this.f9351a.m11353c(m11360a(this.f9351a));
    }

    /* renamed from: b */
    public BigInteger m11367b() {
        if (this.f9351a.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        return this.f9351a.m11348a(m11360a(this.f9351a), false);
    }

    /* renamed from: k */
    public C1440c m11379k() {
        if (this.f9351a.read() != 3) {
            throw new IOException("DER input not a bit string");
        }
        int m11360a = m11360a(this.f9351a) - 1;
        int read = this.f9351a.read();
        if (read < 0) {
            throw new IOException("Unused bits of bit string invalid");
        }
        int i = (m11360a * 8) - read;
        if (i < 0) {
            throw new IOException("Valid bits of bit string invalid");
        }
        byte[] bArr = new byte[m11360a];
        if (m11360a != 0 && this.f9351a.read(bArr) != m11360a) {
            throw new IOException("Short read of DER bit string");
        }
        return new C1440c(i, bArr);
    }

    /* renamed from: i */
    public byte[] m11377i() {
        if (this.f9351a.read() != 4) {
            throw new IOException("DER input not an octet string");
        }
        int m11360a = m11360a(this.f9351a);
        byte[] bArr = new byte[m11360a];
        if (m11360a != 0 && this.f9351a.read(bArr) != m11360a) {
            throw new IOException("Short read of DER octet string");
        }
        return bArr;
    }

    /* renamed from: a */
    public void m11363a(byte[] bArr) {
        if (bArr.length != 0 && this.f9351a.read(bArr) != bArr.length) {
            throw new IOException("Short read of DER octet string");
        }
    }

    /* renamed from: h */
    public C1454q m11376h() {
        return new C1454q(this);
    }

    /* renamed from: a */
    public C1450m[] m11364a(int i) {
        this.f9352b = (byte) this.f9351a.read();
        if (this.f9352b != 48) {
            throw new IOException("Sequence tag error");
        }
        return m11372d(i);
    }

    /* renamed from: b */
    public C1450m[] m11368b(int i) {
        this.f9352b = (byte) this.f9351a.read();
        if (this.f9352b != 49) {
            throw new IOException("Set tag error");
        }
        return m11372d(i);
    }

    /* renamed from: a */
    public C1450m[] m11365a(int i, boolean z) {
        this.f9352b = (byte) this.f9351a.read();
        if (!z && this.f9352b != 49) {
            throw new IOException("Set tag error");
        }
        return m11372d(i);
    }

    /* renamed from: d */
    protected C1450m[] m11372d(int i) {
        byte read = (byte) this.f9351a.read();
        int m11359a = m11359a(read, this.f9351a);
        if (m11359a == -1) {
            int available = this.f9351a.available();
            byte[] bArr = new byte[available + 2];
            bArr[0] = this.f9352b;
            bArr[1] = read;
            DataInputStream dataInputStream = new DataInputStream(this.f9351a);
            dataInputStream.readFully(bArr, 2, available);
            dataInputStream.close();
            this.f9351a = new C1447j(new C1446i().m11345a(bArr), this.f9351a.f9350a);
            if (this.f9352b != this.f9351a.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            m11359a = m11360a(this.f9351a);
        }
        if (m11359a == 0) {
            return new C1450m[0];
        }
        C1448k m11366b = this.f9351a.available() == m11359a ? this : m11366b(m11359a, true);
        Vector vector = new Vector(i);
        do {
            vector.addElement(new C1450m(m11366b.f9351a, this.f9351a.f9350a));
        } while (m11366b.m11362a() > 0);
        if (m11366b.m11362a() != 0) {
            throw new IOException("Extra data at end of vector");
        }
        int size = vector.size();
        C1450m[] c1450mArr = new C1450m[size];
        for (int i2 = 0; i2 < size; i2++) {
            c1450mArr[i2] = (C1450m) vector.elementAt(i2);
        }
        return c1450mArr;
    }

    /* renamed from: d */
    public C1450m m11371d() {
        return new C1450m(this.f9351a);
    }

    /* renamed from: j */
    public Date m11378j() {
        if (this.f9351a.read() != 23) {
            throw new IOException("DER input, UTCtime tag invalid ");
        }
        return this.f9351a.m11356d(m11360a(this.f9351a));
    }

    /* renamed from: e */
    public Date m11373e() {
        if (this.f9351a.read() != 24) {
            throw new IOException("DER input, GeneralizedTime tag invalid ");
        }
        return this.f9351a.m11351b(m11360a(this.f9351a));
    }

    /* renamed from: c */
    int m11369c() {
        return this.f9351a.read() & 255;
    }

    /* renamed from: l */
    public int m11380l() {
        return this.f9351a.m11355d();
    }

    /* renamed from: g */
    int m11375g() {
        return m11360a(this.f9351a);
    }

    /* renamed from: a */
    static int m11360a(InputStream inputStream) {
        return m11359a(inputStream.read(), inputStream);
    }

    /* renamed from: a */
    static int m11359a(int i, InputStream inputStream) {
        if (i == -1) {
            throw new IOException("Short read of DER length");
        }
        if ((i & 128) != 0) {
            int i2 = i & 127;
            if (i2 == 0) {
                return -1;
            }
            if (i2 < 0 || i2 > 4) {
                throw new IOException(String.valueOf("DerInputStream.getLength(): ") + "lengthTag=" + i2 + ", " + (i2 < 0 ? "incorrect DER encoding." : "too big."));
            }
            int read = inputStream.read() & 255;
            if (read == 0) {
                throw new IOException(String.valueOf("DerInputStream.getLength(): ") + "Redundant length bytes found");
            }
            for (int i3 = i2 - 1; i3 > 0; i3--) {
                read = (read << 8) + (inputStream.read() & 255);
            }
            if (read < 0) {
                throw new IOException(String.valueOf("DerInputStream.getLength(): ") + "Invalid length bytes");
            }
            if (read <= 127) {
                throw new IOException(String.valueOf("DerInputStream.getLength(): ") + "Should use short form for length");
            }
            return read;
        }
        return i;
    }

    /* renamed from: c */
    public void m11370c(int i) {
        this.f9351a.mark(i);
    }

    /* renamed from: m */
    public void m11381m() {
        this.f9351a.reset();
    }

    /* renamed from: a */
    public int m11362a() {
        return this.f9351a.available();
    }
}
