package androidx.core.p030e;

import java.util.Locale;

/* compiled from: Preconditions.java */
/* renamed from: androidx.core.e.e */
/* loaded from: classes.dex */
public final class C0270e {
    /* renamed from: a */
    public static <T> T m1960a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    /* renamed from: a */
    public static <T> T m1961a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    /* renamed from: a */
    public static int m1958a(int i, int i2) {
        if ((i & i2) != i) {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i2) + " are allowed");
        }
        return i;
    }

    /* renamed from: a */
    public static int m1957a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return i;
    }

    /* renamed from: a */
    public static int m1959a(int i, int i2, int i3, String str) {
        if (i < i2) {
            throw new IllegalArgumentException(String.format(Locale.f10688US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i > i3) {
            throw new IllegalArgumentException(String.format(Locale.f10688US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        return i;
    }
}
