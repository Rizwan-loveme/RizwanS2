package com.p126e.p127a.p128a;

import android.widget.ImageView;

/* compiled from: Util.java */
/* renamed from: com.e.a.a.m */
/* loaded from: classes.dex */
class C1105m {
    /* renamed from: a */
    static void m9494a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    /* renamed from: a */
    static boolean m9496a(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* renamed from: a */
    static boolean m9495a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (scaleType) {
            case MATRIX:
                throw new IllegalStateException("Matrix scale type is not supported");
            default:
                return true;
        }
    }

    /* renamed from: a */
    static int m9493a(int i) {
        return (65280 & i) >> 8;
    }
}
