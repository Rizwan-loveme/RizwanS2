package p000a.p002b.p003a;

/* compiled from: ByteArrayUtil.java */
/* renamed from: a.b.a.a */
/* loaded from: classes.dex */
public class C0005a {
    /* renamed from: a */
    public static void m22a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    /* renamed from: a */
    public static void m23a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (255 & j);
        bArr[i + 1] = (byte) ((j >> 8) & 255);
        bArr[i + 2] = (byte) ((j >> 16) & 255);
        bArr[i + 3] = (byte) ((j >> 24) & 255);
    }

    /* renamed from: a */
    public static long m21a(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }
}
