package p046b.p047a.p050c.p053b;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import p046b.p047a.p050c.p053b.C0511k;
import p046b.p047a.p050c.p055d.C0516b;
import p046b.p059d.C0539d;
import p046b.p059d.InterfaceC0541f;

/* compiled from: StringBlock.java */
/* renamed from: b.a.c.b.j */
/* loaded from: classes.dex */
public class C0510j {

    /* renamed from: a */
    private int[] f3551a;

    /* renamed from: b */
    private byte[] f3552b;

    /* renamed from: c */
    private int[] f3553c;

    /* renamed from: d */
    private int[] f3554d;

    /* renamed from: e */
    private boolean f3555e;

    /* renamed from: f */
    private final CharsetDecoder f3556f = Charset.forName("UTF-16LE").newDecoder();

    /* renamed from: g */
    private final CharsetDecoder f3557g = Charset.forName("UTF-8").newDecoder();

    /* renamed from: h */
    private final CharsetDecoder f3558h = Charset.forName("CESU8").newDecoder();

    /* renamed from: a */
    public static C0510j m3840a(C0539d c0539d, InterfaceC0541f interfaceC0541f) {
        return m3841a(c0539d, false, interfaceC0541f);
    }

    /* renamed from: a */
    public static C0510j m3841a(C0539d c0539d, boolean z, InterfaceC0541f interfaceC0541f) {
        boolean z2 = false;
        int m3969a = c0539d.m3969a();
        try {
            c0539d.m3974a(1835009, 0, interfaceC0541f);
            if (!z) {
                m3969a = c0539d.m3969a();
            }
            int readInt = c0539d.readInt();
            int readInt2 = c0539d.readInt();
            int readInt3 = c0539d.readInt();
            int readInt4 = c0539d.readInt();
            int readInt5 = c0539d.readInt();
            int readInt6 = c0539d.readInt();
            C0510j c0510j = new C0510j();
            c0510j.f3555e = (readInt4 & 256) != 0;
            c0510j.f3551a = c0539d.m3971a(readInt2, m3969a + readInt5);
            if (readInt3 != 0) {
                c0510j.f3553c = c0539d.m3971a(readInt3, m3969a + readInt6);
            }
            if (readInt6 != 0 && readInt3 != 0) {
                z2 = true;
            }
            int i = readInt - readInt5;
            if (readInt3 > 0) {
                i = readInt6 - readInt5;
            }
            c0510j.f3552b = new byte[i];
            c0539d.readFully(c0510j.f3552b);
            if (z2) {
                i = readInt - readInt6;
                c0510j.f3554d = c0539d.m3976b(i / 4);
            }
            int i2 = i % 4;
            if (i2 >= 1) {
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    c0539d.readByte();
                    i2 = i3;
                }
            }
            return c0510j;
        } catch (Exception e2) {
            throw new IOException(e2);
        } catch (StackOverflowError e3) {
            throw new IOException(e3);
        }
    }

    /* renamed from: a */
    public String m3849a(int i) {
        int[] m3847c;
        int i2;
        if (i < 0 || this.f3551a == null || i >= this.f3551a.length) {
            return (String) null;
        }
        int i3 = this.f3551a[i];
        if (this.f3555e) {
            m3847c = m3846b(this.f3552b, i3);
            i2 = m3847c[0];
        } else {
            m3847c = m3847c(this.f3552b, i3);
            i2 = i3 + m3847c[0];
        }
        return m3842a(i2, m3847c[1]);
    }

    /* renamed from: a */
    public String m3850a(int i, InterfaceC0541f interfaceC0541f) {
        String m3849a = m3849a(i);
        if (m3849a == null) {
            return (String) null;
        }
        int[] m3845b = m3845b(i);
        if (m3845b == null) {
            return C0516b.m3870a(m3849a);
        }
        if (m3845b[1] > m3849a.length()) {
            return C0516b.m3870a(m3849a);
        }
        ArrayList arrayList = new ArrayList(m3845b.length / 3);
        for (int i2 = 0; i2 < m3845b.length; i2 += 3) {
            arrayList.add(new C0511k.b(m3849a(m3845b[i2]), m3845b[i2 + 1], m3845b[i2 + 2]));
        }
        Collections.sort(arrayList);
        return new C0511k(m3849a, arrayList, interfaceC0541f).toString();
    }

    /* renamed from: a */
    public int m3848a(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i != this.f3551a.length; i++) {
            int i2 = this.f3551a[i];
            int m3839a = m3839a(this.f3552b, i2);
            if (m3839a == str.length()) {
                int i3 = 0;
                while (i3 != m3839a) {
                    i2 += 2;
                    if (str.charAt(i3) != m3839a(this.f3552b, i2)) {
                        break;
                    }
                    i3++;
                }
                if (i3 == m3839a) {
                    return i;
                }
            }
        }
        return -1;
    }

    C0510j() {
    }

    /* renamed from: b */
    private int[] m3845b(int i) {
        int i2 = 0;
        if (this.f3553c == null || this.f3554d == null || i >= this.f3553c.length) {
            return (int[]) null;
        }
        int i3 = this.f3553c[i] / 4;
        int i4 = 0;
        for (int i5 = i3; i5 < this.f3554d.length && this.f3554d[i5] != -1; i5++) {
            i4++;
        }
        if (i4 == 0 || i4 % 3 != 0) {
            return (int[]) null;
        }
        int[] iArr = new int[i4];
        while (i3 < this.f3554d.length && this.f3554d[i3] != -1) {
            iArr[i2] = this.f3554d[i3];
            i2++;
            i3++;
        }
        return iArr;
    }

    /* renamed from: a */
    private String m3842a(int i, int i2) {
        String str = null;
        try {
            str = (this.f3555e ? this.f3557g : this.f3556f).decode(ByteBuffer.wrap(this.f3552b, i, i2)).toString();
            return str;
        } catch (CharacterCodingException e2) {
            if (!this.f3555e) {
                return str;
            }
            try {
                return m3844b(i, i2);
            } catch (CharacterCodingException e3) {
                return str;
            }
        }
    }

    /* renamed from: b */
    private String m3844b(int i, int i2) {
        int i3;
        byte[] copyOfRange = Arrays.copyOfRange(this.f3552b, i, i + i2);
        byte[] bArr = new byte[i2];
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        int i5 = 0;
        while (i5 < i2) {
            if (copyOfRange[i5] != -19 || ((copyOfRange.length - i5 > 1 && copyOfRange[i5 + 1] < -96) || ((copyOfRange.length - i5 > 1 && copyOfRange[i5 + 1] > -81) || ((copyOfRange.length - i5 > 3 && copyOfRange[i5 + 3] != -19) || ((copyOfRange.length - i5 > 4 && copyOfRange[i5 + 4] < -80) || (copyOfRange.length - i5 > 4 && copyOfRange[i5 + 4] > -65)))))) {
                i3 = i4 + 1;
                bArr[i4] = copyOfRange[i5];
            } else {
                if (bArr[0] != 0) {
                    byte[] m3843a = m3843a(bArr);
                    sb.append(this.f3557g.decode(ByteBuffer.wrap(m3843a, 0, m3843a.length)).toString());
                }
                sb.append(this.f3558h.decode(ByteBuffer.wrap(copyOfRange, i5, 6)).toString());
                i5 += 5;
                Arrays.fill(bArr, (byte) 0);
                i3 = 0;
            }
            i5++;
            i4 = i3;
        }
        if (bArr[0] != 0) {
            byte[] m3843a2 = m3843a(bArr);
            sb.append(this.f3557g.decode(ByteBuffer.wrap(m3843a2, 0, m3843a2.length)).toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private byte[] m3843a(byte[] bArr) {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        return Arrays.copyOf(bArr, length + 1);
    }

    /* renamed from: a */
    private static int m3839a(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* renamed from: b */
    private static int[] m3846b(byte[] bArr, int i) {
        int i2;
        int i3;
        if ((bArr[i] & 128) != 0) {
            i2 = i + 2;
        } else {
            i2 = i + 1;
        }
        byte b2 = bArr[i2];
        int i4 = i2 + 1;
        if ((b2 & 128) != 0) {
            i3 = (bArr[i4] & 255) + ((b2 & Byte.MAX_VALUE) << 8);
            i4++;
        } else {
            i3 = b2;
        }
        return new int[]{i4, i3};
    }

    /* renamed from: c */
    private static int[] m3847c(byte[] bArr, int i) {
        int i2 = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
        return (32768 & i2) != 0 ? new int[]{4, (((i2 & 32767) << 16) + ((bArr[i + 3] & 255) << 8) + (bArr[i + 2] & 255)) * 2} : new int[]{2, i2 * 2};
    }
}
