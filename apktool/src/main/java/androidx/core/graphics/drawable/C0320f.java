package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.p008os.Build;

/* compiled from: WrappedDrawableState.java */
/* renamed from: androidx.core.graphics.drawable.f */
/* loaded from: classes.dex */
final class C0320f extends Drawable.ConstantState {

    /* renamed from: a */
    int f2270a;

    /* renamed from: b */
    Drawable.ConstantState f2271b;

    /* renamed from: c */
    ColorStateList f2272c;

    /* renamed from: d */
    PorterDuff.Mode f2273d;

    C0320f(C0320f c0320f) {
        this.f2272c = null;
        this.f2273d = C0318d.f2262a;
        if (c0320f != null) {
            this.f2270a = c0320f.f2270a;
            this.f2271b = c0320f.f2271b;
            this.f2272c = c0320f.f2272c;
            this.f2273d = c0320f.f2273d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new C0319e(this, resources) : new C0318d(this, resources);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return (this.f2271b != null ? this.f2271b.getChangingConfigurations() : 0) | this.f2270a;
    }

    /* renamed from: a */
    boolean m2378a() {
        return this.f2271b != null;
    }
}
