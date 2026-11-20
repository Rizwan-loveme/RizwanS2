package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: WrappedDrawableApi21.java */
/* renamed from: androidx.core.graphics.drawable.e */
/* loaded from: classes.dex */
class C0319e extends C0318d {

    /* renamed from: d */
    private static Method f2269d;

    C0319e(Drawable drawable) {
        super(drawable);
        m2377c();
    }

    C0319e(C0320f c0320f, Resources resources) {
        super(c0320f, resources);
        m2377c();
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        this.f2264c.setHotspot(f2, f3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f2264c.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f2264c.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f2264c.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.C0318d, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (mo2376b()) {
            super.setTintList(colorStateList);
        } else {
            this.f2264c.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.C0318d, android.graphics.drawable.Drawable
    public void setTint(int i) {
        if (mo2376b()) {
            super.setTint(i);
        } else {
            this.f2264c.setTint(i);
        }
    }

    @Override // androidx.core.graphics.drawable.C0318d, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.InterfaceC0316b
    public void setTintMode(PorterDuff.Mode mode) {
        if (mo2376b()) {
            super.setTintMode(mode);
        } else {
            this.f2264c.setTintMode(mode);
        }
    }

    @Override // androidx.core.graphics.drawable.C0318d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // androidx.core.graphics.drawable.C0318d
    /* renamed from: b */
    protected boolean mo2376b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f2264c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        if (this.f2264c != null && f2269d != null) {
            try {
                return ((Boolean) f2269d.invoke(this.f2264c, new Object[0])).booleanValue();
            } catch (Exception e2) {
                Log.m191w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e2);
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m2377c() {
        if (f2269d == null) {
            try {
                f2269d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e2) {
                Log.m191w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }
}
