package androidx.core.content.p028a;

import java.lang.reflect.Array;

/* compiled from: GrowingArrayUtils.java */
/* renamed from: androidx.core.content.a.e */
/* loaded from: classes.dex */
final class C0260e {
    /* renamed from: a */
    public static <T> T[] m1907a(T[] tArr, int i, T t) {
        T[] tArr2;
        if (i + 1 > tArr.length) {
            tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), m1905a(i)));
            System.arraycopy(tArr, 0, tArr2, 0, i);
        } else {
            tArr2 = tArr;
        }
        tArr2[i] = t;
        return tArr2;
    }

    /* renamed from: a */
    public static int[] m1906a(int[] iArr, int i, int i2) {
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[m1905a(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    /* renamed from: a */
    public static int m1905a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }
}
