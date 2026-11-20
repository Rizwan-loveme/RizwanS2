package org.p210a.p211a.p212a.p215c;

/* compiled from: MurmurHash.java */
/* renamed from: org.a.a.a.c.k */
/* loaded from: classes.dex */
public final class C1841k {
    /* renamed from: a */
    public static int m13770a() {
        return m13771a(0);
    }

    /* renamed from: a */
    public static int m13771a(int i) {
        return i;
    }

    /* renamed from: a */
    public static int m13772a(int i, int i2) {
        int i3 = (-862048943) * i2;
        int i4 = (((i3 >>> 17) | (i3 << 15)) * 461845907) ^ i;
        return (((i4 >>> 19) | (i4 << 13)) * 5) - 430675100;
    }

    /* renamed from: a */
    public static int m13773a(int i, Object obj) {
        return m13772a(i, obj != null ? obj.hashCode() : 0);
    }

    /* renamed from: b */
    public static int m13775b(int i, int i2) {
        int i3 = (i2 * 4) ^ i;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return i5 ^ (i5 >>> 16);
    }

    /* renamed from: a */
    public static <T> int m13774a(T[] tArr, int i) {
        int m13771a = m13771a(i);
        for (T t : tArr) {
            m13771a = m13773a(m13771a, t);
        }
        return m13775b(m13771a, tArr.length);
    }
}
