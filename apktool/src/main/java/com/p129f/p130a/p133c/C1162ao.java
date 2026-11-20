package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: ObjectArrays.java */
/* renamed from: com.f.a.c.ao */
/* loaded from: classes.dex */
public final class C1162ao {
    /* renamed from: a */
    public static <T> T[] m9954a(T[] tArr, int i) {
        return (T[]) C1165ar.m9964a(tArr, i);
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    static Object[] m9953a(Object... objArr) {
        return m9955b(objArr, objArr.length);
    }

    @CanIgnoreReturnValue
    /* renamed from: b */
    static Object[] m9955b(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            m9952a(objArr[i2], i2);
        }
        return objArr;
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    static Object m9952a(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException("at index " + i);
        }
        return obj;
    }
}
