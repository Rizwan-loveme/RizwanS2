package com.p124d.p125a;

import android.graphics.Canvas;
import java.lang.reflect.Method;

/* compiled from: CanvasLegacy.java */
/* renamed from: com.d.a.c */
/* loaded from: classes.dex */
class C1083c {

    /* renamed from: a */
    static final int f6979a;

    /* renamed from: b */
    private static final Method f6980b;

    static {
        try {
            f6979a = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            f6980b = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th) {
            throw m9054a(th);
        }
    }

    /* renamed from: a */
    static void m9055a(Canvas canvas, int i) {
        try {
            f6980b.invoke(canvas, Integer.valueOf(i));
        } catch (Throwable th) {
            throw m9054a(th);
        }
    }

    /* renamed from: a */
    private static RuntimeException m9054a(Throwable th) {
        if (th == null) {
            throw new NullPointerException("t");
        }
        return (RuntimeException) m9056b(th);
    }

    /* renamed from: b */
    private static <T extends Throwable> T m9056b(Throwable th) {
        throw th;
    }
}
