package org.p226d.p233b.p263h;

/* compiled from: AlignmentUtils.java */
/* renamed from: org.d.b.h.a */
/* loaded from: classes.dex */
public abstract class AbstractC2381a {

    /* renamed from: a */
    static final /* synthetic */ boolean f12734a;

    static {
        f12734a = !AbstractC2381a.class.desiredAssertionStatus();
    }

    /* renamed from: a */
    public static int m15070a(int i, int i2) {
        int i3 = i2 - 1;
        if (!f12734a && (i2 < 0 || (i3 & i2) != 0)) {
            throw new AssertionError();
        }
        return (i3 ^ (-1)) & (i + i3);
    }

    /* renamed from: b */
    public static boolean m15071b(int i, int i2) {
        return i % i2 == 0;
    }
}
