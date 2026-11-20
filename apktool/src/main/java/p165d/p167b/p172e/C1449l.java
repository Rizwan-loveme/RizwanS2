package p165d.p167b.p172e;

import android.bluetooth.p005le.AdvertisingSetParameters;
import java.math.BigInteger;
import java.p209io.ByteArrayOutputStream;
import java.p209io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: DerOutputStream.java */
/* renamed from: d.b.e.l */
/* loaded from: classes.dex */
public class C1449l extends ByteArrayOutputStream implements InterfaceC1445h {

    /* renamed from: a */
    private static C1441d f9353a = new C1441d();

    /* renamed from: b */
    private static C1442e f9354b = new C1442e();

    /* renamed from: a */
    public void m11389a(byte b2, byte[] bArr) {
        write(b2);
        m11406c(bArr.length);
        write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m11388a(byte b2, C1449l c1449l) {
        write(b2);
        m11406c(c1449l.count);
        write(c1449l.buf, 0, c1449l.count);
    }

    /* renamed from: b */
    public void m11400b(byte b2, C1449l c1449l) {
        write(b2);
        write(c1449l.buf, 1, c1449l.count - 1);
    }

    /* renamed from: a */
    public void m11393a(C1450m c1450m) {
        c1450m.m11416a(this);
    }

    /* renamed from: a */
    public void m11398a(boolean z) {
        write(1);
        m11406c(1);
        if (z) {
            write(255);
        } else {
            write(0);
        }
    }

    /* renamed from: a */
    public void m11391a(int i) {
        write(10);
        m11386d(i);
    }

    /* renamed from: a */
    public void m11396a(BigInteger bigInteger) {
        write(2);
        byte[] byteArray = bigInteger.toByteArray();
        m11406c(byteArray.length);
        write(byteArray, 0, byteArray.length);
    }

    /* renamed from: b */
    public void m11401b(int i) {
        write(2);
        m11386d(i);
    }

    /* renamed from: d */
    private void m11386d(int i) {
        int i2;
        byte[] bArr = {(byte) (((-16777216) & i) >>> 24), (byte) ((16711680 & i) >>> 16), (byte) ((65280 & i) >>> 8), (byte) (i & 255)};
        if (bArr[0] == 255) {
            i2 = 0;
            for (int i3 = 0; i3 < 3 && bArr[i3] == 255 && (bArr[i3 + 1] & 128) == 128; i3++) {
                i2++;
            }
        } else if (bArr[0] == 0) {
            i2 = 0;
            for (int i4 = 0; i4 < 3 && bArr[i4] == 0 && (bArr[i4 + 1] & 128) == 0; i4++) {
                i2++;
            }
        } else {
            i2 = 0;
        }
        m11406c(4 - i2);
        while (i2 < 4) {
            write(bArr[i2]);
            i2++;
        }
    }

    /* renamed from: a */
    public void m11399a(byte[] bArr) {
        write(3);
        m11406c(bArr.length + 1);
        write(0);
        write(bArr);
    }

    /* renamed from: b */
    public void m11402b(C1440c c1440c) {
        byte[] m11323c = c1440c.m11323c();
        write(3);
        m11406c(m11323c.length + 1);
        write((m11323c.length * 8) - c1440c.m11319a());
        write(m11323c);
    }

    /* renamed from: a */
    public void m11392a(C1440c c1440c) {
        m11402b(c1440c.m11324d());
    }

    /* renamed from: b */
    public void m11405b(byte[] bArr) {
        m11389a((byte) 4, bArr);
    }

    /* renamed from: a */
    public void m11387a() {
        write(5);
        m11406c(0);
    }

    /* renamed from: a */
    public void m11394a(C1454q c1454q) {
        c1454q.m11458a(this);
    }

    /* renamed from: a */
    public void m11390a(byte b2, InterfaceC1445h[] interfaceC1445hArr) {
        m11383a(b2, interfaceC1445hArr, f9353a);
    }

    /* renamed from: a */
    private void m11383a(byte b2, InterfaceC1445h[] interfaceC1445hArr, Comparator<byte[]> comparator) {
        C1449l[] c1449lArr = new C1449l[interfaceC1445hArr.length];
        for (int i = 0; i < interfaceC1445hArr.length; i++) {
            c1449lArr[i] = new C1449l();
            interfaceC1445hArr[i].mo11272a(c1449lArr[i]);
        }
        byte[][] bArr = new byte[c1449lArr.length][];
        for (int i2 = 0; i2 < c1449lArr.length; i2++) {
            bArr[i2] = c1449lArr[i2].toByteArray();
        }
        Arrays.sort(bArr, comparator);
        C1449l c1449l = new C1449l();
        for (int i3 = 0; i3 < c1449lArr.length; i3++) {
            c1449l.write(bArr[i3]);
        }
        m11388a(b2, c1449l);
    }

    /* renamed from: c */
    public void m11407c(String str) {
        m11384a(str, (byte) 19, "ASCII");
    }

    /* renamed from: b */
    public void m11403b(String str) {
        m11384a(str, (byte) 22, "ASCII");
    }

    /* renamed from: a */
    public void m11395a(String str) {
        m11384a(str, Character.FINAL_QUOTE_PUNCTUATION, "UnicodeBigUnmarked");
    }

    /* renamed from: a */
    private void m11384a(String str, byte b2, String str2) {
        byte[] bytes = str.getBytes(str2);
        write(b2);
        m11406c(bytes.length);
        write(bytes);
    }

    /* renamed from: b */
    public void m11404b(Date date) {
        m11385a(date, (byte) 23);
    }

    /* renamed from: a */
    public void m11397a(Date date) {
        m11385a(date, (byte) 24);
    }

    /* renamed from: a */
    private void m11385a(Date date, byte b2) {
        String str;
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (b2 == 23) {
            str = "yyMMddHHmmss'Z'";
        } else {
            b2 = 24;
            str = "yyyyMMddHHmmss'Z'";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(timeZone);
        byte[] bytes = simpleDateFormat.format(date).getBytes("ISO-8859-1");
        write(b2);
        m11406c(bytes.length);
        write(bytes);
    }

    /* renamed from: c */
    public void m11406c(int i) {
        if (i < 128) {
            write((byte) i);
            return;
        }
        if (i < 256) {
            write(AdvertisingSetParameters.TX_POWER_MIN);
            write((byte) i);
            return;
        }
        if (i < 65536) {
            write(Float.MIN_EXPONENT);
            write((byte) (i >> 8));
            write((byte) i);
        } else {
            if (i < 16777216) {
                write(-125);
                write((byte) (i >> 16));
                write((byte) (i >> 8));
                write((byte) i);
                return;
            }
            write(-124);
            write((byte) (i >> 24));
            write((byte) (i >> 16));
            write((byte) (i >> 8));
            write((byte) i);
        }
    }

    @Override // p165d.p167b.p172e.InterfaceC1445h
    /* renamed from: a */
    public void mo11272a(OutputStream outputStream) {
        outputStream.write(toByteArray());
    }
}
