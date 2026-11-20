package androidx.core.graphics;

import android.graphics.Color;

/* compiled from: ColorUtils.java */
/* renamed from: androidx.core.graphics.a */
/* loaded from: classes.dex */
public final class C0311a {

    /* renamed from: a */
    private static final ThreadLocal<double[]> f2234a = new ThreadLocal<>();

    /* renamed from: a */
    public static int m2307a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int m2310c = m2310c(alpha2, alpha);
        return Color.argb(m2310c, m2308a(Color.red(i), alpha2, Color.red(i2), alpha, m2310c), m2308a(Color.green(i), alpha2, Color.green(i2), alpha, m2310c), m2308a(Color.blue(i), alpha2, Color.blue(i2), alpha, m2310c));
    }

    /* renamed from: c */
    private static int m2310c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    /* renamed from: a */
    private static int m2308a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    /* renamed from: b */
    public static int m2309b(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (16777215 & i) | (i2 << 24);
    }
}
