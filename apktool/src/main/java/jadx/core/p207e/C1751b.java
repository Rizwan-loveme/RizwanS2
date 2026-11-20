package jadx.core.p207e;

import java.p209io.IOException;
import java.util.Arrays;

/* compiled from: CommonBinaryParser.java */
/* renamed from: jadx.core.e.b */
/* loaded from: classes.dex */
public class C1751b extends C1752c {

    /* renamed from: a */
    protected C1753d f10631a;

    /* renamed from: a */
    protected String[] m13344a() {
        this.f10631a.m13354b(1, "String pool expected");
        return m13345b();
    }

    /* renamed from: b */
    protected String[] m13345b() {
        long m13348a = this.f10631a.m13348a() - 2;
        this.f10631a.m13354b(28, "String pool header size not 0x001c");
        long m13360e = m13348a + this.f10631a.m13360e();
        int m13359d = this.f10631a.m13359d();
        int m13359d2 = this.f10631a.m13359d();
        int m13359d3 = this.f10631a.m13359d();
        long m13359d4 = this.f10631a.m13359d();
        long m13359d5 = this.f10631a.m13359d();
        int[] m13356b = this.f10631a.m13356b(m13359d);
        this.f10631a.m13356b(m13359d2);
        this.f10631a.m13352a(m13359d4 + m13348a, "Expected strings start");
        String[] strArr = new String[m13359d];
        byte[] m13358c = this.f10631a.m13358c((int) ((m13359d5 == 0 ? m13360e : m13348a + m13359d5) - this.f10631a.m13348a()));
        if ((m13359d3 & 256) != 0) {
            for (int i = 0; i < m13359d; i++) {
                strArr[i] = m13339a(m13358c, m13356b[i]);
            }
        } else {
            for (int i2 = 0; i2 < m13359d; i2++) {
                strArr[i2] = m13340b(m13358c, m13356b[i2]);
            }
        }
        if (m13359d5 != 0) {
            this.f10631a.m13352a(m13348a + m13359d5, "Expected styles start");
        }
        this.f10631a.m13355b(m13360e, "Skip string pool padding");
        return strArr;
    }

    /* renamed from: a */
    private static String m13339a(byte[] bArr, int i) {
        int i2;
        int m13341c = m13341c(bArr, i) + i;
        int i3 = m13341c + 1;
        int i4 = bArr[m13341c];
        if (i4 == 0) {
            return "";
        }
        if ((i4 & 128) != 0) {
            i2 = i3 + 1;
            i4 = ((i4 & 127) << 8) | (bArr[i3] & 255);
        } else {
            i2 = i3;
        }
        return new String(Arrays.copyOfRange(bArr, i2, i4 + i2), C1753d.f10645b);
    }

    /* renamed from: b */
    private static String m13340b(byte[] bArr, int i) {
        int length = bArr.length;
        int m13342d = i + m13342d(bArr, i);
        int i2 = m13342d;
        while (i2 + 1 < length && (bArr[i2] != 0 || bArr[i2 + 1] != 0)) {
            i2 += 2;
        }
        return new String(Arrays.copyOfRange(bArr, m13342d, i2), C1753d.f10644a);
    }

    /* renamed from: c */
    private static int m13341c(byte[] bArr, int i) {
        return (bArr[i] & 128) == 0 ? 1 : 2;
    }

    /* renamed from: d */
    private static int m13342d(byte[] bArr, int i) {
        return (bArr[i + 1] & 128) == 0 ? 2 : 4;
    }

    /* renamed from: a */
    protected void m13343a(String str) {
        throw new IOException("Decode error: " + str + ", position: 0x" + Long.toHexString(this.f10631a.m13348a()));
    }
}
