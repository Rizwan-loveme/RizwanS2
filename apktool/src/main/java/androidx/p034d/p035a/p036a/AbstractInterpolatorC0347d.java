package androidx.p034d.p035a.p036a;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator.java */
/* renamed from: androidx.d.a.a.d */
/* loaded from: classes.dex */
abstract class AbstractInterpolatorC0347d implements Interpolator {

    /* renamed from: a */
    private final float[] f2373a;

    /* renamed from: b */
    private final float f2374b;

    protected AbstractInterpolatorC0347d(float[] fArr) {
        this.f2373a = fArr;
        this.f2374b = 1.0f / (this.f2373a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) ((this.f2373a.length - 1) * f2), this.f2373a.length - 2);
        return ((this.f2373a[min + 1] - this.f2373a[min]) * ((f2 - (min * this.f2374b)) / this.f2374b)) + this.f2373a[min];
    }
}
