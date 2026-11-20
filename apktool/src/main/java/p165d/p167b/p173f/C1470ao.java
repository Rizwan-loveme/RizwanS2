package p165d.p167b.p173f;

import java.net.InetAddress;
import java.p209io.IOException;
import java.util.Arrays;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: IPAddressName.java */
/* renamed from: d.b.f.ao */
/* loaded from: classes.dex */
public class C1470ao implements InterfaceC1466ak {

    /* renamed from: a */
    private byte[] f9420a;

    /* renamed from: b */
    private boolean f9421b;

    /* renamed from: c */
    private String f9422c;

    public C1470ao(C1450m c1450m) {
        this(c1450m.m11432m());
    }

    public C1470ao(byte[] bArr) {
        if (bArr.length == 4 || bArr.length == 8) {
            this.f9421b = true;
        } else if (bArr.length == 16 || bArr.length == 32) {
            this.f9421b = false;
        } else {
            throw new IOException("Invalid IPAddressName");
        }
        this.f9420a = bArr;
    }

    public C1470ao(String str) {
        if (str == null || str.length() == 0) {
            throw new IOException("IPAddress cannot be null or empty");
        }
        if (str.charAt(str.length() - 1) == '/') {
            throw new IOException("Invalid IPAddress: " + str);
        }
        if (str.indexOf(58) >= 0) {
            m11505b(str);
            this.f9421b = false;
        } else {
            if (str.indexOf(46) >= 0) {
                m11504a(str);
                this.f9421b = true;
                return;
            }
            throw new IOException("Invalid IPAddress: " + str);
        }
    }

    /* renamed from: a */
    private void m11504a(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            this.f9420a = InetAddress.getByName(str).getAddress();
            return;
        }
        this.f9420a = new byte[8];
        byte[] address = InetAddress.getByName(str.substring(indexOf + 1)).getAddress();
        System.arraycopy(InetAddress.getByName(str.substring(0, indexOf)).getAddress(), 0, this.f9420a, 0, 4);
        System.arraycopy(address, 0, this.f9420a, 4, 4);
    }

    /* renamed from: b */
    private void m11505b(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf == -1) {
            this.f9420a = InetAddress.getByName(str).getAddress();
            return;
        }
        this.f9420a = new byte[32];
        System.arraycopy(InetAddress.getByName(str.substring(0, indexOf)).getAddress(), 0, this.f9420a, 0, 16);
        int parseInt = Integer.parseInt(str.substring(indexOf + 1));
        if (parseInt < 0 || parseInt > 128) {
            throw new IOException("IPv6Address prefix length (" + parseInt + ") in out of valid range [0,128]");
        }
        C1440c c1440c = new C1440c(128);
        for (int i = 0; i < parseInt; i++) {
            c1440c.m11320a(i, true);
        }
        byte[] m11323c = c1440c.m11323c();
        for (int i2 = 0; i2 < 16; i2++) {
            this.f9420a[i2 + 16] = m11323c[i2];
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 7;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        c1449l.m11405b(this.f9420a);
    }

    public String toString() {
        try {
            return "IPAddress: " + m11506a();
        } catch (IOException e2) {
            return "IPAddress: " + new C1420b().m11234b(this.f9420a);
        }
    }

    /* renamed from: a */
    public String m11506a() {
        int i = 0;
        if (this.f9422c != null) {
            return this.f9422c;
        }
        if (this.f9421b) {
            byte[] bArr = new byte[4];
            System.arraycopy(this.f9420a, 0, bArr, 0, 4);
            this.f9422c = InetAddress.getByAddress(bArr).getHostAddress();
            if (this.f9420a.length == 8) {
                byte[] bArr2 = new byte[4];
                System.arraycopy(this.f9420a, 4, bArr2, 0, 4);
                this.f9422c = String.valueOf(this.f9422c) + "/" + InetAddress.getByAddress(bArr2).getHostAddress();
            }
        } else {
            byte[] bArr3 = new byte[16];
            System.arraycopy(this.f9420a, 0, bArr3, 0, 16);
            this.f9422c = InetAddress.getByAddress(bArr3).getHostAddress();
            if (this.f9420a.length == 32) {
                byte[] bArr4 = new byte[16];
                for (int i2 = 16; i2 < 32; i2++) {
                    bArr4[i2 - 16] = this.f9420a[i2];
                }
                C1440c c1440c = new C1440c(128, bArr4);
                while (i < 128 && c1440c.m11321a(i)) {
                    i++;
                }
                this.f9422c = String.valueOf(this.f9422c) + "/" + i;
                while (i < 128) {
                    if (!c1440c.m11321a(i)) {
                        i++;
                    } else {
                        throw new IOException("Invalid IPv6 subdomain - set bit " + i + " not contiguous");
                    }
                }
            }
        }
        return this.f9422c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1470ao)) {
            return false;
        }
        byte[] bArr = ((C1470ao) obj).f9420a;
        if (bArr.length != this.f9420a.length) {
            return false;
        }
        if (this.f9420a.length == 8 || this.f9420a.length == 32) {
            int length = this.f9420a.length / 2;
            for (int i = 0; i < length; i++) {
                if (((byte) (this.f9420a[i] & this.f9420a[i + length])) != ((byte) (bArr[i] & bArr[i + length]))) {
                    return false;
                }
            }
            while (length < this.f9420a.length) {
                if (this.f9420a[length] != bArr[length]) {
                    return false;
                }
                length++;
            }
            return true;
        }
        return Arrays.equals(bArr, this.f9420a);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.f9420a.length) {
                i = (this.f9420a[i2] * i2) + i3;
                i2++;
            } else {
                return i3;
            }
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        int i = 0;
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 7) {
            return -1;
        }
        if (((C1470ao) interfaceC1466ak).equals(this)) {
            return 0;
        }
        byte[] bArr = ((C1470ao) interfaceC1466ak).f9420a;
        if (bArr.length == 4 && this.f9420a.length == 4) {
            return 3;
        }
        if ((bArr.length != 8 || this.f9420a.length != 8) && (bArr.length != 32 || this.f9420a.length != 32)) {
            if (bArr.length == 8 || bArr.length == 32) {
                int length = bArr.length / 2;
                while (i < length && (this.f9420a[i] & bArr[i + length]) == bArr[i]) {
                    i++;
                }
                return i == length ? 2 : 3;
            }
            if (this.f9420a.length != 8 && this.f9420a.length != 32) {
                return 3;
            }
            int length2 = this.f9420a.length / 2;
            while (i < length2 && (bArr[i] & this.f9420a[i + length2]) == this.f9420a[i]) {
                i++;
            }
            return i == length2 ? 1 : 3;
        }
        int length3 = this.f9420a.length / 2;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = true;
        for (int i2 = 0; i2 < length3; i2++) {
            if (((byte) (this.f9420a[i2] & this.f9420a[i2 + length3])) != this.f9420a[i2]) {
                z2 = true;
            }
            if (((byte) (bArr[i2] & bArr[i2 + length3])) != bArr[i2]) {
                z = true;
            }
            if (((byte) (this.f9420a[i2 + length3] & bArr[i2 + length3])) != this.f9420a[i2 + length3] || ((byte) (this.f9420a[i2] & this.f9420a[i2 + length3])) != ((byte) (bArr[i2] & this.f9420a[i2 + length3]))) {
                z3 = false;
            }
            if (((byte) (bArr[i2 + length3] & this.f9420a[i2 + length3])) != bArr[i2 + length3] || ((byte) (bArr[i2] & bArr[i2 + length3])) != ((byte) (this.f9420a[i2] & bArr[i2 + length3]))) {
                z4 = false;
            }
        }
        if (!z2 && !z) {
            if (z3) {
                return 1;
            }
            return z4 ? 2 : 3;
        }
        if (z2 && z) {
            return 0;
        }
        return z2 ? 2 : 1;
    }
}
