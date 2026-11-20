package p165d.p167b.p172e;

import java.util.Comparator;

/* compiled from: ByteArrayTagOrder.java */
/* renamed from: d.b.e.e */
/* loaded from: classes.dex */
public class C1442e implements Comparator<byte[]> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(byte[] bArr, byte[] bArr2) {
        return (bArr[0] | 32) - (bArr2[0] | 32);
    }
}
