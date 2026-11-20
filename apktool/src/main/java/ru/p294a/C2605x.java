package ru.p294a;

import android.text.Spanned;
import android.widget.ExpandableListView;

/* compiled from: ZipLong.java */
/* renamed from: ru.a.x */
/* loaded from: classes.dex */
public final class C2605x implements Cloneable {

    /* renamed from: a */
    public static final C2605x f13516a = new C2605x(33639248);

    /* renamed from: b */
    public static final C2605x f13517b = new C2605x(67324752);

    /* renamed from: c */
    public static final C2605x f13518c = new C2605x(134695760);

    /* renamed from: d */
    static final C2605x f13519d = new C2605x(ExpandableListView.PACKED_POSITION_VALUE_NULL);

    /* renamed from: e */
    private final long f13520e;

    public C2605x(long j) {
        this.f13520e = j;
    }

    public C2605x(byte[] bArr, int i) {
        this.f13520e = m16177b(bArr, i);
    }

    /* renamed from: a */
    public byte[] m16179a() {
        return m16176a(this.f13520e);
    }

    /* renamed from: b */
    public long m16180b() {
        return this.f13520e;
    }

    /* renamed from: a */
    public static byte[] m16176a(long j) {
        byte[] bArr = new byte[4];
        m16175a(j, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static void m16175a(long j, byte[] bArr, int i) {
        int i2 = i + 1;
        bArr[i] = (byte) (255 & j);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((65280 & j) >> 8);
        bArr[i3] = (byte) ((Spanned.SPAN_PRIORITY & j) >> 16);
        bArr[i3 + 1] = (byte) ((4278190080L & j) >> 24);
    }

    /* renamed from: a */
    public void m16178a(byte[] bArr, int i) {
        m16175a(this.f13520e, bArr, i);
    }

    /* renamed from: b */
    public static long m16177b(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & 4278190080L) + ((bArr[i + 2] << 16) & Spanned.SPAN_PRIORITY) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255);
    }

    /* renamed from: a */
    public static long m16174a(byte[] bArr) {
        return m16177b(bArr, 0);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2605x) && this.f13520e == ((C2605x) obj).m16180b();
    }

    public int hashCode() {
        return (int) this.f13520e;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString() {
        return new StringBuffer().append("ZipLong value: ").append(this.f13520e).toString();
    }
}
