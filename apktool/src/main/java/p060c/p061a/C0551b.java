package p060c.p061a;

import java.nio.ByteBuffer;
import java.p209io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: StringItems.java */
@SuppressWarnings("serial")
/* renamed from: c.a.b */
/* loaded from: classes.dex */
public class C0551b extends ArrayList<C0544a> {

    /* renamed from: a */
    byte[] f3696a;

    /* renamed from: b */
    private boolean f3697b = true;

    /* renamed from: a */
    public static String[] m4037a(ByteBuffer byteBuffer) {
        String str;
        int position = byteBuffer.position() - 8;
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        int i3 = byteBuffer.getInt();
        byteBuffer.getInt();
        int[] iArr = new int[i];
        String[] strArr = new String[i];
        int i4 = i3 + position;
        for (int i5 = 0; i5 < i && byteBuffer.position() < i4; i5++) {
            iArr[i5] = byteBuffer.getInt();
        }
        for (int i6 = 0; i6 < iArr.length; i6++) {
            byteBuffer.position(iArr[i6] + i4);
            if ((i2 & 256) != 0) {
                m4039c(byteBuffer);
                int m4039c = m4039c(byteBuffer);
                int position2 = byteBuffer.position();
                while (byteBuffer.get(position2 + m4039c) != 0) {
                    m4039c++;
                }
                str = new String(byteBuffer.array(), position2, m4039c, "UTF-8");
            } else {
                str = new String(byteBuffer.array(), byteBuffer.position(), m4038b(byteBuffer) * 2, "UTF-16LE");
            }
            strArr[i6] = str;
        }
        return strArr;
    }

    /* renamed from: b */
    static int m4038b(ByteBuffer byteBuffer) {
        int i = byteBuffer.getShort() & 65535;
        if (i > 32767) {
            return ((i & 32767) << 8) | (byteBuffer.getShort() & 65535);
        }
        return i;
    }

    /* renamed from: c */
    static int m4039c(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & 255;
        if ((i & 128) != 0) {
            return ((i & 127) << 8) | (byteBuffer.get() & 255);
        }
        return i;
    }

    /* renamed from: a */
    public int m4040a() {
        return (size() * 4) + 20 + this.f3696a.length + 0;
    }

    /* renamed from: b */
    public void m4041b() {
        Iterator<C0544a> it = iterator();
        while (it.hasNext()) {
            if (it.next().f3643a.length() > 32767) {
                this.f3697b = false;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.reset();
        HashMap hashMap = new HashMap();
        int i = 0;
        int i2 = 0;
        for (C0544a c0544a : this) {
            int i3 = i2 + 1;
            c0544a.f3645c = i2;
            String str = c0544a.f3643a;
            Integer num = (Integer) hashMap.get(str);
            if (num != null) {
                c0544a.f3644b = num.intValue();
                i2 = i3;
            } else {
                c0544a.f3644b = i;
                hashMap.put(str, new Integer(i));
                if (this.f3697b) {
                    int length = str.length();
                    byte[] bytes = str.getBytes("UTF-8");
                    int length2 = bytes.length;
                    if (length > 127) {
                        i++;
                        byteArrayOutputStream.write((length >> 8) | 128);
                    }
                    byteArrayOutputStream.write(length);
                    if (length2 > 127) {
                        i++;
                        byteArrayOutputStream.write((length2 >> 8) | 128);
                    }
                    byteArrayOutputStream.write(length2);
                    byteArrayOutputStream.write(bytes);
                    byteArrayOutputStream.write(0);
                    i = length2 + 3 + i;
                    i2 = i3;
                } else {
                    int length3 = str.length();
                    byte[] bytes2 = str.getBytes("UTF-16LE");
                    if (length3 > 32767) {
                        int i4 = (length3 >> 16) | 32768;
                        byteArrayOutputStream.write(i4);
                        byteArrayOutputStream.write(i4 >> 8);
                        i += 2;
                    }
                    byteArrayOutputStream.write(length3);
                    byteArrayOutputStream.write(length3 >> 8);
                    byteArrayOutputStream.write(bytes2);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    i = bytes2.length + 4 + i;
                    i2 = i3;
                }
            }
        }
        this.f3696a = byteArrayOutputStream.toByteArray();
    }

    /* renamed from: d */
    public void m4042d(ByteBuffer byteBuffer) {
        byteBuffer.putInt(size());
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f3697b ? 256 : 0);
        byteBuffer.putInt((size() * 4) + 28);
        byteBuffer.putInt(0);
        Iterator<C0544a> it = iterator();
        while (it.hasNext()) {
            byteBuffer.putInt(it.next().f3644b);
        }
        byteBuffer.put(this.f3696a);
    }
}
