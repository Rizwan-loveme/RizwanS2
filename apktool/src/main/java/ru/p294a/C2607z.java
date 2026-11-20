package ru.p294a;

/* compiled from: ZipShort.java */
/* renamed from: ru.a.z */
/* loaded from: classes.dex */
public final class C2607z implements Cloneable {

    /* renamed from: a */
    private final int f13567a;

    public C2607z(int i) {
        this.f13567a = i;
    }

    public C2607z(byte[] bArr, int i) {
        this.f13567a = m16238a(bArr, i);
    }

    /* renamed from: a */
    public byte[] m16241a() {
        byte[] bArr = new byte[2];
        m16239a(this.f13567a, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static void m16239a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((65280 & i) >> 8);
    }

    /* renamed from: b */
    public int m16242b() {
        return this.f13567a;
    }

    /* renamed from: a */
    public static byte[] m16240a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8)};
    }

    /* renamed from: a */
    public static int m16238a(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255);
    }

    /* renamed from: a */
    public static int m16237a(byte[] bArr) {
        return m16238a(bArr, 0);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2607z) && this.f13567a == ((C2607z) obj).m16242b();
    }

    public int hashCode() {
        return this.f13567a;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return new StringBuffer().append("ZipShort value: ").append(this.f13567a).toString();
    }
}
