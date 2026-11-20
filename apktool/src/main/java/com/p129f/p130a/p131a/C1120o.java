package com.p129f.p130a.p131a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Preconditions.java */
/* renamed from: com.f.a.a.o */
/* loaded from: classes.dex */
public final class C1120o {
    /* renamed from: a */
    public static void m9550a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static void m9551a(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static void m9552a(boolean z, @NullableDecl String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(C1126u.m9590a(str, Integer.valueOf(i)));
        }
    }

    /* renamed from: a */
    public static void m9553a(boolean z, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(C1126u.m9590a(str, obj));
        }
    }

    /* renamed from: a */
    public static void m9554a(boolean z, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(C1126u.m9590a(str, obj, obj2));
        }
    }

    /* renamed from: b */
    public static void m9558b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public static void m9559b(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: b */
    public static void m9560b(boolean z, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(C1126u.m9590a(str, obj));
        }
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    /* renamed from: a */
    public static <T> T m9547a(@NonNullDecl T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    /* renamed from: a */
    public static <T> T m9548a(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public static int m9545a(int i, int i2) {
        return m9546a(i, i2, "index");
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public static int m9546a(int i, int i2, @NullableDecl String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(m9561c(i, i2, str));
        }
        return i;
    }

    /* renamed from: c */
    private static String m9561c(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return C1126u.m9590a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return C1126u.m9590a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    @CanIgnoreReturnValue
    /* renamed from: b */
    public static int m9555b(int i, int i2) {
        return m9556b(i, i2, "index");
    }

    @CanIgnoreReturnValue
    /* renamed from: b */
    public static int m9556b(int i, int i2, @NullableDecl String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m9562d(i, i2, str));
        }
        return i;
    }

    /* renamed from: d */
    private static String m9562d(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return C1126u.m9590a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return C1126u.m9590a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: a */
    public static void m9549a(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(m9557b(i, i2, i3));
        }
    }

    /* renamed from: b */
    private static String m9557b(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return m9562d(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return m9562d(i2, i3, "end index");
        }
        return C1126u.m9590a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }
}
