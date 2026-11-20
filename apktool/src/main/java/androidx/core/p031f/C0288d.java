package androidx.core.p031f;

import android.p008os.Build;
import android.view.DisplayCutout;
import androidx.core.p030e.C0268c;

/* compiled from: DisplayCutoutCompat.java */
/* renamed from: androidx.core.f.d */
/* loaded from: classes.dex */
public final class C0288d {

    /* renamed from: a */
    private final Object f2192a;

    private C0288d(Object obj) {
        this.f2192a = obj;
    }

    /* renamed from: a */
    public int m2163a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2192a).getSafeInsetTop();
        }
        return 0;
    }

    /* renamed from: b */
    public int m2164b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2192a).getSafeInsetBottom();
        }
        return 0;
    }

    /* renamed from: c */
    public int m2165c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2192a).getSafeInsetLeft();
        }
        return 0;
    }

    /* renamed from: d */
    public int m2166d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2192a).getSafeInsetRight();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C0268c.m1953a(this.f2192a, ((C0288d) obj).f2192a);
    }

    public int hashCode() {
        if (this.f2192a == null) {
            return 0;
        }
        return this.f2192a.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f2192a + "}";
    }

    /* renamed from: a */
    static C0288d m2162a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0288d(obj);
    }
}
