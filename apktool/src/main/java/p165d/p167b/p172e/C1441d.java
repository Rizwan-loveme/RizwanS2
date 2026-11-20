package p165d.p167b.p172e;

import java.util.Comparator;

/* compiled from: ByteArrayLexOrder.java */
/* renamed from: d.b.e.d */
/* loaded from: classes.dex */
public class C1441d implements Comparator<byte[]> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length && i < bArr2.length; i++) {
            int i2 = (bArr[i] & 255) - (bArr2[i] & 255);
            if (i2 != 0) {
                return i2;
            }
        }
        return bArr.length - bArr2.length;
    }
}
