package com.p129f.p130a.p133c;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Platform.java */
/* renamed from: com.f.a.c.ar */
/* loaded from: classes.dex */
final class C1165ar {
    /* renamed from: a */
    static <K, V> Map<K, V> m9963a(int i) {
        return C1199n.m10063a(i);
    }

    /* renamed from: a */
    static <T> T[] m9964a(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    /* renamed from: a */
    static <T> T[] m9965a(Object[] objArr, int i, int i2, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }
}
