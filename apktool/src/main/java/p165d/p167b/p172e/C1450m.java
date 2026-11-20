package p165d.p167b.p172e;

import android.bluetooth.BluetoothHidDevice;
import java.math.BigInteger;
import java.p209io.ByteArrayInputStream;
import java.p209io.DataInputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import org.p217b.p218a.p219a.C1887e;

/* compiled from: DerValue.java */
/* renamed from: d.b.e.m */
/* loaded from: classes.dex */
public class C1450m {

    /* renamed from: a */
    protected C1447j f9355a;

    /* renamed from: b */
    public final C1448k f9356b;

    /* renamed from: c */
    public byte f9357c;

    /* renamed from: d */
    private int f9358d;

    /* renamed from: s */
    public boolean m11438s() {
        return (this.f9357c & BluetoothHidDevice.SUBCLASS1_COMBO) == 128;
    }

    /* renamed from: b */
    public boolean m11420b(byte b2) {
        return m11438s() && (this.f9357c & 31) == b2;
    }

    /* renamed from: r */
    public boolean m11437r() {
        return (this.f9357c & 32) == 32;
    }

    /* renamed from: a */
    public boolean m11417a(byte b2) {
        return m11437r() && (this.f9357c & 31) == b2;
    }

    public C1450m(String str) {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            } else if (!m11411a(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        this.f9356b = m11409a(z ? (byte) 19 : (byte) 12, str);
    }

    public C1450m(byte b2, String str) {
        this.f9356b = m11409a(b2, str);
    }

    C1450m(byte b2, byte[] bArr, boolean z) {
        this.f9357c = b2;
        this.f9355a = new C1447j((byte[]) bArr.clone(), z);
        this.f9358d = bArr.length;
        this.f9356b = new C1448k(this.f9355a);
        this.f9356b.m11370c(Integer.MAX_VALUE);
    }

    public C1450m(byte b2, byte[] bArr) {
        this(b2, bArr, true);
    }

    C1450m(C1447j c1447j) {
        this.f9357c = (byte) c1447j.read();
        byte read = (byte) c1447j.read();
        this.f9358d = C1448k.m11359a(read, c1447j);
        if (this.f9358d == -1) {
            C1447j m11347a = c1447j.m11347a();
            int available = m11347a.available();
            byte[] bArr = new byte[available + 2];
            bArr[0] = this.f9357c;
            bArr[1] = read;
            DataInputStream dataInputStream = new DataInputStream(m11347a);
            dataInputStream.readFully(bArr, 2, available);
            dataInputStream.close();
            C1447j c1447j2 = new C1447j(new C1446i().m11345a(bArr), c1447j.f9350a);
            if (this.f9357c != c1447j2.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            this.f9358d = C1448k.m11360a(c1447j2);
            this.f9355a = c1447j2.m11347a();
            this.f9355a.m11357e(this.f9358d);
            this.f9356b = new C1448k(this.f9355a);
            c1447j.skip(this.f9358d + 2);
            return;
        }
        this.f9355a = c1447j.m11347a();
        this.f9355a.m11357e(this.f9358d);
        this.f9356b = new C1448k(this.f9355a);
        c1447j.skip(this.f9358d);
    }

    C1450m(byte[] bArr, boolean z) {
        this.f9356b = m11410a(true, (InputStream) new ByteArrayInputStream(bArr), z);
    }

    public C1450m(byte[] bArr) {
        this(bArr, true);
    }

    C1450m(InputStream inputStream, boolean z) {
        this.f9356b = m11410a(false, inputStream, z);
    }

    public C1450m(InputStream inputStream) {
        this(inputStream, true);
    }

    /* renamed from: a */
    private C1448k m11409a(byte b2, String str) {
        String str2;
        this.f9357c = b2;
        switch (b2) {
            case 12:
                str2 = "UTF8";
                break;
            case 19:
            case 22:
            case 27:
                str2 = "ASCII";
                break;
            case 20:
                str2 = "ISO-8859-1";
                break;
            case 30:
                str2 = "UnicodeBigUnmarked";
                break;
            default:
                throw new IllegalArgumentException("Unsupported DER string type");
        }
        byte[] bytes = str.getBytes(str2);
        this.f9358d = bytes.length;
        this.f9355a = new C1447j(bytes, true);
        C1448k c1448k = new C1448k(this.f9355a);
        c1448k.m11370c(Integer.MAX_VALUE);
        return c1448k;
    }

    /* renamed from: a */
    private C1448k m11410a(boolean z, InputStream inputStream, boolean z2) {
        this.f9357c = (byte) inputStream.read();
        byte read = (byte) inputStream.read();
        this.f9358d = C1448k.m11359a(read, inputStream);
        if (this.f9358d == -1) {
            int available = inputStream.available();
            byte[] bArr = new byte[available + 2];
            bArr[0] = this.f9357c;
            bArr[1] = read;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            dataInputStream.readFully(bArr, 2, available);
            dataInputStream.close();
            inputStream = new ByteArrayInputStream(new C1446i().m11345a(bArr));
            if (this.f9357c != inputStream.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            this.f9358d = C1448k.m11360a(inputStream);
        }
        if (this.f9358d == 0) {
            return null;
        }
        if (z && inputStream.available() != this.f9358d) {
            throw new IOException("extra data given to DerValue constructor");
        }
        this.f9355a = new C1447j(C1887e.m13978a(inputStream, this.f9358d), z2);
        return new C1448k(this.f9355a);
    }

    /* renamed from: a */
    public void m11416a(C1449l c1449l) {
        c1449l.write(this.f9357c);
        c1449l.m11406c(this.f9358d);
        if (this.f9358d > 0) {
            byte[] bArr = new byte[this.f9358d];
            synchronized (this.f9356b) {
                this.f9355a.reset();
                if (this.f9355a.read(bArr) != this.f9358d) {
                    throw new IOException("short DER value read (encode)");
                }
                c1449l.write(bArr);
            }
        }
    }

    /* renamed from: f */
    public final C1448k m11425f() {
        return this.f9356b;
    }

    /* renamed from: e */
    public boolean m11424e() {
        if (this.f9357c != 1) {
            throw new IOException("DerValue.getBoolean, not a BOOLEAN " + ((int) this.f9357c));
        }
        if (this.f9358d != 1) {
            throw new IOException("DerValue.getBoolean, invalid length " + this.f9358d);
        }
        return this.f9355a.read() != 0;
    }

    /* renamed from: l */
    public C1454q m11431l() {
        if (this.f9357c != 6) {
            throw new IOException("DerValue.getOID, not an OID " + ((int) this.f9357c));
        }
        return new C1454q(this.f9355a);
    }

    /* renamed from: a */
    private byte[] m11413a(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        return bArr2;
    }

    /* renamed from: m */
    public byte[] m11432m() {
        if (this.f9357c != 4 && !m11417a((byte) 4)) {
            throw new IOException("DerValue.getOctetString, not an Octet String: " + ((int) this.f9357c));
        }
        byte[] bArr = new byte[this.f9358d];
        if (this.f9355a.read(bArr) != this.f9358d) {
            throw new IOException("short read on DerValue buffer");
        }
        if (m11437r()) {
            C1448k c1448k = new C1448k(bArr, 0, bArr.length, this.f9355a.f9350a);
            bArr = null;
            while (c1448k.m11362a() != 0) {
                bArr = m11413a(bArr, c1448k.m11377i());
            }
        }
        return bArr;
    }

    /* renamed from: k */
    public int m11430k() {
        if (this.f9357c != 2) {
            throw new IOException("DerValue.getInteger, not an int " + ((int) this.f9357c));
        }
        return this.f9355a.m11353c(this.f9356b.m11362a());
    }

    /* renamed from: c */
    public BigInteger m11421c() {
        if (this.f9357c != 2) {
            throw new IOException("DerValue.getBigInteger, not an int " + ((int) this.f9357c));
        }
        return this.f9355a.m11348a(this.f9356b.m11362a(), false);
    }

    /* renamed from: h */
    public int m11427h() {
        if (this.f9357c != 10) {
            throw new IOException("DerValue.getEnumerated, incorrect tag: " + ((int) this.f9357c));
        }
        return this.f9355a.m11353c(this.f9356b.m11362a());
    }

    /* renamed from: d */
    public byte[] m11423d() {
        if (this.f9357c != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.f9357c));
        }
        return this.f9355a.m11352b();
    }

    /* renamed from: q */
    public C1440c m11436q() {
        if (this.f9357c != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.f9357c));
        }
        return this.f9355a.m11354c();
    }

    /* renamed from: a */
    public String m11415a() {
        if (this.f9357c == 12) {
            return m11435p();
        }
        if (this.f9357c == 19) {
            return m11433n();
        }
        if (this.f9357c == 20) {
            return m11434o();
        }
        if (this.f9357c == 22) {
            return m11429j();
        }
        if (this.f9357c == 30) {
            return m11419b();
        }
        if (this.f9357c == 27) {
            return m11428i();
        }
        return null;
    }

    /* renamed from: a */
    public C1440c m11414a(boolean z) {
        if (!z && this.f9357c != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + ((int) this.f9357c));
        }
        return this.f9355a.m11354c();
    }

    /* renamed from: g */
    public byte[] m11426g() {
        byte[] bArr = new byte[this.f9358d];
        synchronized (this.f9356b) {
            this.f9356b.m11381m();
            this.f9356b.m11363a(bArr);
        }
        return bArr;
    }

    /* renamed from: n */
    public String m11433n() {
        if (this.f9357c != 19) {
            throw new IOException("DerValue.getPrintableString, not a string " + ((int) this.f9357c));
        }
        return new String(m11426g(), "ASCII");
    }

    /* renamed from: o */
    public String m11434o() {
        if (this.f9357c != 20) {
            throw new IOException("DerValue.getT61String, not T61 " + ((int) this.f9357c));
        }
        return new String(m11426g(), "ISO-8859-1");
    }

    /* renamed from: j */
    public String m11429j() {
        if (this.f9357c != 22) {
            throw new IOException("DerValue.getIA5String, not IA5 " + ((int) this.f9357c));
        }
        return new String(m11426g(), "ASCII");
    }

    /* renamed from: b */
    public String m11419b() {
        if (this.f9357c != 30) {
            throw new IOException("DerValue.getBMPString, not BMP " + ((int) this.f9357c));
        }
        return new String(m11426g(), "UnicodeBigUnmarked");
    }

    /* renamed from: p */
    public String m11435p() {
        if (this.f9357c != 12) {
            throw new IOException("DerValue.getUTF8String, not UTF-8 " + ((int) this.f9357c));
        }
        return new String(m11426g(), "UTF8");
    }

    /* renamed from: i */
    public String m11428i() {
        if (this.f9357c != 27) {
            throw new IOException("DerValue.getGeneralString, not GeneralString " + ((int) this.f9357c));
        }
        return new String(m11426g(), "ASCII");
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1450m) {
            return m11418a((C1450m) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m11418a(C1450m c1450m) {
        if (this == c1450m) {
            return true;
        }
        if (this.f9357c != c1450m.f9357c) {
            return false;
        }
        if (this.f9356b == c1450m.f9356b) {
            return true;
        }
        if (System.identityHashCode(this.f9356b) > System.identityHashCode(c1450m.f9356b)) {
            return m11412a(this, c1450m);
        }
        return m11412a(c1450m, this);
    }

    /* renamed from: a */
    private static boolean m11412a(C1450m c1450m, C1450m c1450m2) {
        boolean m11349a;
        synchronized (c1450m.f9356b) {
            synchronized (c1450m2.f9356b) {
                c1450m.f9356b.m11381m();
                c1450m2.f9356b.m11381m();
                m11349a = c1450m.f9355a.m11349a(c1450m2.f9355a);
            }
        }
        return m11349a;
    }

    public String toString() {
        try {
            String m11415a = m11415a();
            if (m11415a != null) {
                return "\"" + m11415a + "\"";
            }
            if (this.f9357c == 5) {
                return "[DerValue, null]";
            }
            if (this.f9357c == 6) {
                return "OID." + m11431l();
            }
            return "[DerValue, tag = " + ((int) this.f9357c) + ", length = " + this.f9358d + "]";
        } catch (IOException e2) {
            throw new IllegalArgumentException("misformatted DER value");
        }
    }

    /* renamed from: u */
    public byte[] m11440u() {
        C1449l c1449l = new C1449l();
        m11416a(c1449l);
        this.f9356b.m11381m();
        return c1449l.toByteArray();
    }

    /* renamed from: v */
    public C1448k m11441v() {
        if (this.f9357c == 48 || this.f9357c == 49) {
            return new C1448k(this.f9355a);
        }
        throw new IOException("toDerInputStream rejects tag type " + ((int) this.f9357c));
    }

    /* renamed from: t */
    public int m11439t() {
        return this.f9358d;
    }

    /* renamed from: a */
    public static boolean m11411a(char c2) {
        if (c2 >= 'a' && c2 <= 'z') {
            return true;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            return true;
        }
        if (c2 >= '0' && c2 <= '9') {
            return true;
        }
        switch (c2) {
            case ' ':
            case '\'':
            case '(':
            case ')':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
            case ':':
            case '=':
            case '?':
                break;
        }
        return true;
    }

    /* renamed from: a */
    public static byte m11408a(byte b2, boolean z, byte b3) {
        byte b4 = (byte) (b2 | b3);
        if (z) {
            return (byte) (b4 | 32);
        }
        return b4;
    }

    /* renamed from: c */
    public void m11422c(byte b2) {
        this.f9357c = b2;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
