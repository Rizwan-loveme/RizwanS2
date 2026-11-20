package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;

/* compiled from: CollectPreconditions.java */
/* renamed from: com.f.a.c.l */
/* loaded from: classes.dex */
final class C1197l {
    /* renamed from: a */
    static void m10053a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    static int m10052a(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
        }
        return i;
    }

    /* renamed from: a */
    static void m10054a(boolean z) {
        C1120o.m9559b(z, "no calls to next() since the last call to remove()");
    }
}
