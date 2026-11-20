package com.p129f.p130a.p133c;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Hashing.java */
/* renamed from: com.f.a.c.s */
/* loaded from: classes.dex */
final class C1204s {
    /* renamed from: a */
    static int m10117a(int i) {
        return (int) (461845907 * Integer.rotateLeft((int) (i * (-862048943)), 15));
    }

    /* renamed from: a */
    static int m10119a(@NullableDecl Object obj) {
        return m10117a(obj == null ? 0 : obj.hashCode());
    }

    /* renamed from: a */
    static int m10118a(int i, double d2) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > ((int) (highestOneBit * d2))) {
            int i2 = highestOneBit << 1;
            if (i2 <= 0) {
                return 1073741824;
            }
            return i2;
        }
        return highestOneBit;
    }
}
