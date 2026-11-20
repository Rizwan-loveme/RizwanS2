package ru.maximoff.apktool.util;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: BmpUtil.java */
/* renamed from: ru.maximoff.apktool.util.d */
/* loaded from: classes.dex */
public class C3210d {

    /* renamed from: a */
    private final int f18926a = 4;

    /* renamed from: b */
    private final int f18927b = 3;

    /* renamed from: a */
    public boolean m19113a(Bitmap bitmap, String str) {
        boolean z;
        byte[] bArr;
        int i;
        if (bitmap == null || str == null) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        byte[] bArr2 = (byte[]) null;
        if (!m19108a(width)) {
            z = false;
            bArr = bArr2;
            i = 0;
        } else {
            i = 4 - (width % 4);
            byte[] bArr3 = new byte[i * 3];
            for (int i2 = 0; i2 < bArr3.length; i2++) {
                bArr3[i2] = -1;
            }
            z = true;
            bArr = bArr3;
        }
        int[] iArr = new int[width * height];
        int length = (iArr.length * 3) + (height * i * 3);
        int i3 = length + 54;
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        try {
            allocate.put((byte) 66);
            allocate.put((byte) 77);
            allocate.put(m19111b(i3));
            allocate.put(m19110a((short) 0));
            allocate.put(m19110a((short) 0));
            allocate.put(m19111b(54));
            allocate.put(m19111b(40));
            allocate.put(m19111b(width));
            allocate.put(m19111b(height));
            allocate.put(m19110a((short) 1));
            allocate.put(m19110a((short) 24));
            allocate.put(m19111b(0));
            allocate.put(m19111b(length));
            allocate.put(m19111b(0));
            allocate.put(m19111b(0));
            allocate.put(m19111b(0));
            allocate.put(m19111b(0));
            while (height > 0) {
                int i4 = height * width;
                for (int i5 = (height - 1) * width; i5 < i4; i5++) {
                    allocate.put(m19112c(iArr[i5]));
                    if (z && m19109a(width, i5)) {
                        allocate.put(bArr);
                    }
                }
                height--;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(allocate.array());
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private boolean m19109a(int i, int i2) {
        return i2 > 0 && i2 % (i + (-1)) == 0;
    }

    /* renamed from: a */
    private boolean m19108a(int i) {
        return i % 4 > 0;
    }

    /* renamed from: b */
    private byte[] m19111b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) (((-16777216) & i) >> 24)};
    }

    /* renamed from: c */
    private byte[] m19112c(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16)};
    }

    /* renamed from: a */
    private byte[] m19110a(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((65280 & s) >> 8)};
    }
}
