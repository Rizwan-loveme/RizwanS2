package ru.p294a;

import android.text.Spanned;
import java.math.BigInteger;

/* compiled from: ZipEightByteInteger.java */
/* renamed from: ru.a.r */
/* loaded from: classes.dex */
public final class C2599r {

    /* renamed from: a */
    public static final C2599r f13468a = new C2599r(0);

    /* renamed from: b */
    private final BigInteger f13469b;

    public C2599r(long j) {
        this(BigInteger.valueOf(j));
    }

    public C2599r(BigInteger bigInteger) {
        this.f13469b = bigInteger;
    }

    public C2599r(byte[] bArr, int i) {
        this.f13469b = m16109b(bArr, i);
    }

    /* renamed from: a */
    public byte[] m16110a() {
        return m16108a(this.f13469b);
    }

    /* renamed from: b */
    public long m16111b() {
        return this.f13469b.longValue();
    }

    /* renamed from: c */
    public BigInteger m16112c() {
        return this.f13469b;
    }

    /* renamed from: a */
    public static byte[] m16107a(long j) {
        return m16108a(BigInteger.valueOf(j));
    }

    /* renamed from: a */
    public static byte[] m16108a(BigInteger bigInteger) {
        long longValue = bigInteger.longValue();
        byte[] bArr = {(byte) (255 & longValue), (byte) ((65280 & longValue) >> 8), (byte) ((Spanned.SPAN_PRIORITY & longValue) >> 16), (byte) ((4278190080L & longValue) >> 24), (byte) ((1095216660480L & longValue) >> 32), (byte) ((280375465082880L & longValue) >> 40), (byte) ((71776119061217280L & longValue) >> 48), (byte) ((longValue & 9151314442816847872L) >> 56)};
        if (bigInteger.testBit(63)) {
            bArr[7] = (byte) (bArr[7] | Byte.MIN_VALUE);
        }
        return bArr;
    }

    /* renamed from: a */
    public static long m16106a(byte[] bArr, int i) {
        return m16109b(bArr, i).longValue();
    }

    /* renamed from: b */
    public static BigInteger m16109b(byte[] bArr, int i) {
        BigInteger valueOf = BigInteger.valueOf(((bArr[i + 7] << 56) & 9151314442816847872L) + ((bArr[i + 6] << 48) & 71776119061217280L) + ((bArr[i + 5] << 40) & 280375465082880L) + ((bArr[i + 4] << 32) & 1095216660480L) + ((bArr[i + 3] << 24) & 4278190080L) + ((bArr[i + 2] << 16) & Spanned.SPAN_PRIORITY) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255));
        return (bArr[i + 7] & Byte.MIN_VALUE) == -128 ? valueOf.setBit(63) : valueOf;
    }

    /* renamed from: a */
    public static long m16105a(byte[] bArr) {
        return m16106a(bArr, 0);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2599r) && this.f13469b.equals(((C2599r) obj).m16112c());
    }

    public int hashCode() {
        return this.f13469b.hashCode();
    }

    public String toString() {
        return new StringBuffer().append("ZipEightByteInteger value: ").append(this.f13469b).toString();
    }
}
