package com.p129f.p130a.p131a;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Objects.java */
/* renamed from: com.f.a.a.k */
/* loaded from: classes.dex */
public final class C1116k extends AbstractC1111f {
    /* renamed from: a */
    public static boolean m9538a(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m9537a(@NullableDecl Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
