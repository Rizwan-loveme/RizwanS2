package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.p031f.C0282af;
import androidx.core.p031f.C0308x;
import androidx.fragment.C0362a;
import java.util.ArrayList;

/* compiled from: FragmentContainerView.java */
/* renamed from: androidx.fragment.app.i */
/* loaded from: classes.dex */
public final class C0378i extends FrameLayout {

    /* renamed from: a */
    private ArrayList<View> f2719a;

    /* renamed from: b */
    private ArrayList<View> f2720b;

    /* renamed from: c */
    private View.OnApplyWindowInsetsListener f2721c;

    /* renamed from: d */
    private boolean f2722d;

    C0378i(Context context, AttributeSet attributeSet, AbstractC0384o abstractC0384o) {
        super(context, attributeSet);
        String str;
        this.f2722d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0362a.c.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(C0362a.c.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(C0362a.c.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        ComponentCallbacksC0374e m3036c = abstractC0384o.m3036c(id);
        if (classAttribute != null && m3036c == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            ComponentCallbacksC0374e mo2941c = abstractC0384o.m2997C().mo2941c(context.getClassLoader(), classAttribute);
            mo2941c.m2809a(context, attributeSet, (Bundle) null);
            abstractC0384o.m3002a().m3167c(true).m3164a(this, mo2941c, string).mo2648d();
        }
        abstractC0384o.m3014a(this);
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f2721c = onApplyWindowInsetsListener;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C0282af m2222a;
        C0282af m2067a = C0282af.m2067a(windowInsets);
        if (this.f2721c != null) {
            m2222a = C0282af.m2067a(this.f2721c.onApplyWindowInsets(this, windowInsets));
        } else {
            m2222a = C0308x.m2222a(this, m2067a);
        }
        if (!m2222a.m2082e()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                C0308x.m2244b(getChildAt(i), m2222a);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f2722d && this.f2719a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f2719a.size()) {
                    break;
                }
                super.drawChild(canvas, this.f2719a.get(i2), getDrawingTime());
                i = i2 + 1;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!this.f2722d || this.f2719a == null || this.f2719a.size() <= 0 || !this.f2719a.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f2720b == null) {
                this.f2720b = new ArrayList<>();
            }
            this.f2720b.add(view);
        }
        super.startViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        if (this.f2720b != null) {
            this.f2720b.remove(view);
            if (this.f2719a != null && this.f2719a.remove(view)) {
                this.f2722d = true;
            }
        }
        super.endViewTransition(view);
    }

    void setDrawDisappearingViewsLast(boolean z) {
        this.f2722d = z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (AbstractC0384o.m2970a(view) == null) {
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (AbstractC0384o.m2970a(view) == null) {
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
        }
        return super.addViewInLayout(view, i, layoutParams, z);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        m2913a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        m2913a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        m2913a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            m2913a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            m2913a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            m2913a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        if (z) {
            m2913a(view);
        }
        super.removeDetachedView(view, z);
    }

    /* renamed from: a */
    private void m2913a(View view) {
        if (this.f2720b != null && this.f2720b.contains(view)) {
            if (this.f2719a == null) {
                this.f2719a = new ArrayList<>();
            }
            this.f2719a.add(view);
        }
    }
}
