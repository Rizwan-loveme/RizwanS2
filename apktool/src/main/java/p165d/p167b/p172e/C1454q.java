package p165d.p167b.p172e;

import java.io.IOException;
import java.io.Serializable;

/* compiled from: ObjectIdentifier.java */
/* renamed from: d.b.e.q */
/* loaded from: classes.dex */
public final class C1454q implements Serializable {

    /* renamed from: a */
    private int f9377a;

    /* renamed from: b */
    private int[] f9378b;

    /* renamed from: c */
    private volatile transient String f9379c;

    public C1454q(String str) {
        this.f9377a = 0;
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(46, i);
            if (indexOf == -1) {
                break;
            }
            i = indexOf + 1;
            this.f9377a++;
        }
        this.f9377a++;
        this.f9378b = new int[this.f9377a];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                int indexOf2 = str.indexOf(46, i3);
                if (indexOf2 != -1) {
                    try {
                        this.f9378b[i2] = Integer.valueOf(str.substring(i3, indexOf2)).intValue();
                        i3 = indexOf2 + 1;
                        i2++;
                    } catch (Exception e2) {
                        e = e2;
                        throw new IOException("ObjectIdentifier() -- Invalid format: " + e.toString(), e);
                    }
                } else {
                    this.f9378b[i2] = Integer.valueOf(str.substring(i3)).intValue();
                    m11457a(this.f9378b, this.f9377a);
                    this.f9379c = str;
                    return;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    /* renamed from: a */
    private void m11457a(int[] iArr, int i) {
        if (iArr == null || i < 2) {
            throw new IOException("ObjectIdentifier() -- Must be at least two oid components ");
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] < 0) {
                throw new IOException("ObjectIdentifier() -- oid component #" + (i2 + 1) + " must be non-negative ");
            }
        }
        if (iArr[0] > 2) {
            throw new IOException("ObjectIdentifier() -- First oid component is invalid ");
        }
        if (iArr[0] < 2 && iArr[1] > 39) {
            throw new IOException("ObjectIdentifier() -- Second oid component is invalid ");
        }
    }

    public C1454q(int[] iArr) {
        m11457a(iArr, iArr.length);
        this.f9378b = (int[]) iArr.clone();
        this.f9377a = iArr.length;
    }

    public C1454q(C1448k c1448k) {
        byte m11369c = (byte) c1448k.m11369c();
        if (m11369c != 6) {
            throw new IOException("ObjectIdentifier() -- data isn't an object ID (tag = " + ((int) m11369c) + ")");
        }
        int m11362a = (c1448k.m11362a() - c1448k.m11375g()) - 1;
        if (m11362a < 0) {
            throw new IOException("ObjectIdentifier() -- not enough data");
        }
        m11455a(c1448k, m11362a);
    }

    C1454q(C1447j c1447j) {
        m11455a(new C1448k(c1447j), 0);
    }

    private C1454q(int[] iArr, boolean z) {
        this.f9378b = iArr;
        this.f9377a = iArr.length;
    }

    /* renamed from: a */
    public static C1454q m11454a(int[] iArr) {
        return new C1454q(iArr, true);
    }

    /* renamed from: a */
    private void m11455a(C1448k c1448k, int i) {
        int i2;
        this.f9378b = new int[5];
        this.f9377a = 0;
        boolean z = true;
        while (c1448k.m11362a() > i) {
            int m11453a = m11453a(c1448k);
            if (m11453a < 0) {
                throw new IOException("ObjectIdentifier() -- component values must be nonnegative");
            }
            if (z) {
                if (m11453a < 40) {
                    i2 = 0;
                } else {
                    i2 = m11453a < 80 ? 1 : 2;
                }
                this.f9378b[0] = i2;
                this.f9378b[1] = m11453a - (i2 * 40);
                this.f9377a = 2;
                z = false;
            } else {
                if (this.f9377a >= this.f9378b.length) {
                    int[] iArr = new int[this.f9378b.length + 5];
                    System.arraycopy(this.f9378b, 0, iArr, 0, this.f9378b.length);
                    this.f9378b = iArr;
                }
                int[] iArr2 = this.f9378b;
                int i3 = this.f9377a;
                this.f9377a = i3 + 1;
                iArr2[i3] = m11453a;
            }
        }
        m11457a(this.f9378b, this.f9377a);
        if (c1448k.m11362a() != i) {
            throw new IOException("ObjectIdentifier() -- malformed input data");
        }
    }

    /* renamed from: a */
    void m11458a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        if (this.f9378b[0] < 2) {
            c1449l2.write((this.f9378b[0] * 40) + this.f9378b[1]);
        } else {
            m11456a(c1449l2, (this.f9378b[0] * 40) + this.f9378b[1]);
        }
        for (int i = 2; i < this.f9377a; i++) {
            m11456a(c1449l2, this.f9378b[i]);
        }
        c1449l.m11388a((byte) 6, c1449l2);
    }

    /* renamed from: a */
    private static int m11453a(C1448k c1448k) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < 4) {
                int m11369c = c1448k.m11369c();
                if (i3 == 0 && m11369c == 128) {
                    throw new IOException("ObjectIdentifier() -- sub component starts with 0x80");
                }
                i2 = (i2 << 7) | (m11369c & 127);
                if ((m11369c & 128) != 0) {
                    i = i3 + 1;
                } else {
                    return i2;
                }
            } else {
                throw new IOException("ObjectIdentifier() -- component value too big");
            }
        }
    }

    /* renamed from: a */
    private static void m11456a(C1449l c1449l, int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (i2 < 4) {
            bArr[i2] = (byte) (i & 127);
            i >>>= 7;
            if (i == 0) {
                break;
            } else {
                i2++;
            }
        }
        while (i2 > 0) {
            c1449l.write(bArr[i2] | 128);
            i2--;
        }
        c1449l.write(bArr[0]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1454q)) {
            return false;
        }
        C1454q c1454q = (C1454q) obj;
        if (this.f9377a != c1454q.f9377a) {
            return false;
        }
        for (int i = 0; i < this.f9377a; i++) {
            if (this.f9378b[i] != c1454q.f9378b[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f9377a;
        for (int i2 = 0; i2 < this.f9377a; i2++) {
            i += this.f9378b[i2] * 37;
        }
        return i;
    }

    public String toString() {
        String str = this.f9379c;
        if (str == null) {
            StringBuffer stringBuffer = new StringBuffer(this.f9377a * 4);
            for (int i = 0; i < this.f9377a; i++) {
                if (i != 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(this.f9378b[i]);
            }
            String stringBuffer2 = stringBuffer.toString();
            this.f9379c = stringBuffer2;
            return stringBuffer2;
        }
        return str;
    }
}
