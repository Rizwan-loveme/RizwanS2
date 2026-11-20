package p046b.p047a.p050c.p053b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.p217b.p218a.p219a.C1887e;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0456a;
import p046b.p059d.C0540e;

/* compiled from: Res9patchStreamDecoder.java */
/* renamed from: b.a.c.b.d */
/* loaded from: classes.dex */
public class C0504d implements InterfaceC0508h {
    @Override // p046b.p047a.p050c.p053b.InterfaceC0508h
    /* renamed from: a */
    public void mo3822a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] m13984b = C1887e.m13984b(inputStream);
            if (m13984b.length != 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(m13984b, 0, m13984b.length, options);
                int width = decodeByteArray.getWidth();
                int height = decodeByteArray.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width + 2, height + 2, Bitmap.Config.ARGB_8888);
                for (int i = 0; i < width; i++) {
                    for (int i2 = 0; i2 < height; i2++) {
                        createBitmap.setPixel(i + 1, i2 + 1, decodeByteArray.getPixel(i, i2));
                    }
                }
                a m3817a = m3817a(m13984b);
                m3818a(createBitmap, height + 1, m3817a.f3535a + 1, width - m3817a.f3536b);
                m3821b(createBitmap, width + 1, m3817a.f3537c + 1, height - m3817a.f3538d);
                int[] iArr = m3817a.f3539e;
                if (iArr.length == 0) {
                    m3818a(createBitmap, 0, 1, width);
                } else {
                    for (int i3 = 0; i3 < iArr.length; i3 += 2) {
                        m3818a(createBitmap, 0, iArr[i3] + 1, iArr[i3 + 1]);
                    }
                }
                int[] iArr2 = m3817a.f3540f;
                if (iArr2.length == 0) {
                    m3821b(createBitmap, 0, 1, height);
                } else {
                    for (int i4 = 0; i4 < iArr2.length; i4 += 2) {
                        m3821b(createBitmap, 0, iArr2[i4] + 1, iArr2[i4 + 1]);
                    }
                }
                try {
                    b m3820b = m3820b(m13984b);
                    for (int i5 = 0; i5 < m3820b.f3541a; i5++) {
                        createBitmap.setPixel(i5 + 1, height + 1, Color.RED);
                    }
                    for (int i6 = 0; i6 < m3820b.f3543c; i6++) {
                        createBitmap.setPixel(width - i6, height + 1, Color.RED);
                    }
                    for (int i7 = 0; i7 < m3820b.f3542b; i7++) {
                        createBitmap.setPixel(width + 1, i7 + 1, Color.RED);
                    }
                    for (int i8 = 0; i8 < m3820b.f3544d; i8++) {
                        createBitmap.setPixel(width + 1, height - i8, Color.RED);
                    }
                } catch (C0456a e2) {
                }
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                decodeByteArray.recycle();
                createBitmap.recycle();
            }
        } catch (IOException e3) {
            throw new C0461b(e3);
        } catch (NullPointerException e4) {
            throw new C0461b(e4);
        }
    }

    /* renamed from: a */
    private a m3817a(byte[] bArr) {
        C0540e c0540e = new C0540e(new ByteArrayInputStream(bArr));
        m3819a(c0540e, 1852855395);
        return a.m3823a(c0540e);
    }

    /* renamed from: b */
    private b m3820b(byte[] bArr) {
        C0540e c0540e = new C0540e(new ByteArrayInputStream(bArr));
        m3819a(c0540e, 1852853346);
        return b.m3824a(c0540e);
    }

    /* renamed from: a */
    private void m3819a(DataInput dataInput, int i) {
        dataInput.skipBytes(8);
        while (true) {
            try {
                int readInt = dataInput.readInt();
                if (dataInput.readInt() == i) {
                    return;
                } else {
                    dataInput.skipBytes(readInt + 4);
                }
            } catch (IOException e2) {
                throw new C0456a("Cant find nine patch chunk", e2);
            }
        }
    }

    /* renamed from: a */
    private void m3818a(Bitmap bitmap, int i, int i2, int i3) {
        while (i2 <= i3) {
            bitmap.setPixel(i2, i, -16777216);
            i2++;
        }
    }

    /* renamed from: b */
    private void m3821b(Bitmap bitmap, int i, int i2, int i3) {
        while (i2 <= i3) {
            bitmap.setPixel(i, i2, -16777216);
            i2++;
        }
    }

    /* compiled from: Res9patchStreamDecoder.java */
    /* renamed from: b.a.c.b.d$a */
    private static class a {

        /* renamed from: a */
        public final int f3535a;

        /* renamed from: b */
        public final int f3536b;

        /* renamed from: c */
        public final int f3537c;

        /* renamed from: d */
        public final int f3538d;

        /* renamed from: e */
        public final int[] f3539e;

        /* renamed from: f */
        public final int[] f3540f;

        public a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
            this.f3535a = i;
            this.f3536b = i2;
            this.f3537c = i3;
            this.f3538d = i4;
            this.f3539e = iArr;
            this.f3540f = iArr2;
        }

        /* renamed from: a */
        public static a m3823a(C0540e c0540e) {
            c0540e.skipBytes(1);
            byte readByte = c0540e.readByte();
            byte readByte2 = c0540e.readByte();
            c0540e.skipBytes(1);
            c0540e.skipBytes(8);
            int readInt = c0540e.readInt();
            int readInt2 = c0540e.readInt();
            int readInt3 = c0540e.readInt();
            int readInt4 = c0540e.readInt();
            c0540e.skipBytes(4);
            return new a(readInt, readInt2, readInt3, readInt4, c0540e.m3976b(readByte), c0540e.m3976b(readByte2));
        }
    }

    /* compiled from: Res9patchStreamDecoder.java */
    /* renamed from: b.a.c.b.d$b */
    private static class b {

        /* renamed from: a */
        public final int f3541a;

        /* renamed from: b */
        public final int f3542b;

        /* renamed from: c */
        public final int f3543c;

        /* renamed from: d */
        public final int f3544d;

        public b(int i, int i2, int i3, int i4) {
            this.f3541a = i;
            this.f3542b = i2;
            this.f3543c = i3;
            this.f3544d = i4;
        }

        /* renamed from: a */
        public static b m3824a(C0540e c0540e) {
            return new b(Integer.reverseBytes(c0540e.readInt()), Integer.reverseBytes(c0540e.readInt()), Integer.reverseBytes(c0540e.readInt()), Integer.reverseBytes(c0540e.readInt()));
        }
    }
}
