package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: WrappedDrawableApi14.java */
/* renamed from: androidx.core.graphics.drawable.d */
/* loaded from: classes.dex */
class C0318d extends Drawable implements Drawable.Callback, InterfaceC0316b, InterfaceC0317c {

    /* renamed from: a */
    static final PorterDuff.Mode f2262a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    C0320f f2263b;

    /* renamed from: c */
    Drawable f2264c;

    /* renamed from: d */
    private int f2265d;

    /* renamed from: e */
    private PorterDuff.Mode f2266e;

    /* renamed from: f */
    private boolean f2267f;

    /* renamed from: g */
    private boolean f2268g;

    C0318d(C0320f c0320f, Resources resources) {
        this.f2263b = c0320f;
        m2373a(resources);
    }

    C0318d(Drawable drawable) {
        this.f2263b = m2375c();
        mo2372a(drawable);
    }

    /* renamed from: a */
    private void m2373a(Resources resources) {
        if (this.f2263b != null && this.f2263b.f2271b != null) {
            mo2372a(this.f2263b.f2271b.newDrawable(resources));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f2264c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2264c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f2264c != null) {
            this.f2264c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f2264c.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return (this.f2263b != null ? this.f2263b.getChangingConfigurations() : 0) | super.getChangingConfigurations() | this.f2264c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f2264c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f2264c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2264c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2264c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (mo2376b() && this.f2263b != null) {
            colorStateList = this.f2263b.f2272c;
        } else {
            colorStateList = null;
        }
        return (colorStateList != null && colorStateList.isStateful()) || this.f2264c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m2374a(iArr) || this.f2264c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f2264c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2264c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2264c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f2264c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f2264c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f2264c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f2264c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f2264c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f2264c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f2264c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        C0315a.m2363a(this.f2264c, z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return C0315a.m2364b(this.f2264c);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return C0315a.m2365b(this.f2264c, i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return C0315a.m2370g(this.f2264c);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f2263b == null || !this.f2263b.m2378a()) {
            return null;
        }
        this.f2263b.f2270a = getChangingConfigurations();
        return this.f2263b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2268g && super.mutate() == this) {
            this.f2263b = m2375c();
            if (this.f2264c != null) {
                this.f2264c.mutate();
            }
            if (this.f2263b != null) {
                this.f2263b.f2271b = this.f2264c != null ? this.f2264c.getConstantState() : null;
            }
            this.f2268g = true;
        }
        return this;
    }

    /* renamed from: c */
    private C0320f m2375c() {
        return new C0320f(this.f2263b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f2264c.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2263b.f2272c = colorStateList;
        m2374a(getState());
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.InterfaceC0316b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2263b.f2273d = mode;
        m2374a(getState());
    }

    /* renamed from: a */
    private boolean m2374a(int[] iArr) {
        if (!mo2376b()) {
            return false;
        }
        ColorStateList colorStateList = this.f2263b.f2272c;
        PorterDuff.Mode mode = this.f2263b.f2273d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (this.f2267f && colorForState == this.f2265d && mode == this.f2266e) {
                return false;
            }
            setColorFilter(colorForState, mode);
            this.f2265d = colorForState;
            this.f2266e = mode;
            this.f2267f = true;
            return true;
        }
        this.f2267f = false;
        clearColorFilter();
        return false;
    }

    @Override // androidx.core.graphics.drawable.InterfaceC0317c
    /* renamed from: a */
    public final Drawable mo2371a() {
        return this.f2264c;
    }

    @Override // androidx.core.graphics.drawable.InterfaceC0317c
    /* renamed from: a */
    public final void mo2372a(Drawable drawable) {
        if (this.f2264c != null) {
            this.f2264c.setCallback(null);
        }
        this.f2264c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f2263b != null) {
                this.f2263b.f2271b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* renamed from: b */
    protected boolean mo2376b() {
        return true;
    }
}
