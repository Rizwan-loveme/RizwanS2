package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0308x;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    Drawable f1111a;

    /* renamed from: b */
    Drawable f1112b;

    /* renamed from: c */
    Drawable f1113c;

    /* renamed from: d */
    boolean f1114d;

    /* renamed from: e */
    boolean f1115e;

    /* renamed from: f */
    private boolean f1116f;

    /* renamed from: g */
    private View f1117g;

    /* renamed from: h */
    private View f1118h;

    /* renamed from: i */
    private View f1119i;

    /* renamed from: j */
    private int f1120j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = true;
        C0308x.m2233a(this, new C0185b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.j.ActionBar);
        this.f1111a = obtainStyledAttributes.getDrawable(C0059a.j.ActionBar_background);
        this.f1112b = obtainStyledAttributes.getDrawable(C0059a.j.ActionBar_backgroundStacked);
        this.f1120j = obtainStyledAttributes.getDimensionPixelSize(C0059a.j.ActionBar_height, -1);
        if (getId() == C0059a.f.split_action_bar) {
            this.f1114d = true;
            this.f1113c = obtainStyledAttributes.getDrawable(C0059a.j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (this.f1114d) {
            if (this.f1113c != null) {
                z = false;
            }
        } else if (this.f1111a != null || this.f1112b != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1118h = findViewById(C0059a.f.action_bar);
        this.f1119i = findViewById(C0059a.f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1111a != null) {
            this.f1111a.setCallback(null);
            unscheduleDrawable(this.f1111a);
        }
        this.f1111a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1118h != null) {
                this.f1111a.setBounds(this.f1118h.getLeft(), this.f1118h.getTop(), this.f1118h.getRight(), this.f1118h.getBottom());
            }
        }
        if (this.f1114d) {
            if (this.f1113c != null) {
                z = false;
            }
        } else if (this.f1111a != null || this.f1112b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1112b != null) {
            this.f1112b.setCallback(null);
            unscheduleDrawable(this.f1112b);
        }
        this.f1112b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1115e && this.f1112b != null) {
                this.f1112b.setBounds(this.f1117g.getLeft(), this.f1117g.getTop(), this.f1117g.getRight(), this.f1117g.getBottom());
            }
        }
        if (this.f1114d) {
            if (this.f1113c != null) {
                z = false;
            }
        } else if (this.f1111a != null || this.f1112b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1113c != null) {
            this.f1113c.setCallback(null);
            unscheduleDrawable(this.f1113c);
        }
        this.f1113c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1114d && this.f1113c != null) {
                this.f1113c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1114d) {
            if (this.f1113c != null) {
                z = false;
            }
        } else if (this.f1111a != null || this.f1112b != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1111a != null) {
            this.f1111a.setVisible(z, false);
        }
        if (this.f1112b != null) {
            this.f1112b.setVisible(z, false);
        }
        if (this.f1113c != null) {
            this.f1113c.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1111a && !this.f1114d) || (drawable == this.f1112b && this.f1115e) || ((drawable == this.f1113c && this.f1114d) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1111a != null && this.f1111a.isStateful()) {
            this.f1111a.setState(getDrawableState());
        }
        if (this.f1112b != null && this.f1112b.isStateful()) {
            this.f1112b.setState(getDrawableState());
        }
        if (this.f1113c != null && this.f1113c.isStateful()) {
            this.f1113c.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f1111a != null) {
            this.f1111a.jumpToCurrentState();
        }
        if (this.f1112b != null) {
            this.f1112b.jumpToCurrentState();
        }
        if (this.f1113c != null) {
            this.f1113c.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f1116f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1116f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(C0177as c0177as) {
        if (this.f1117g != null) {
            removeView(this.f1117g);
        }
        this.f1117g = c0177as;
        if (c0177as != null) {
            addView(c0177as);
            ViewGroup.LayoutParams layoutParams = c0177as.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            c0177as.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1117g;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* renamed from: a */
    private boolean m976a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m977b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.f1118h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1120j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f1120j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1118h != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.f1117g != null && this.f1117g.getVisibility() != 8 && mode != 1073741824) {
                if (!m976a(this.f1118h)) {
                    i3 = m977b(this.f1118h);
                } else if (!m976a(this.f1119i)) {
                    i3 = m977b(this.f1119i);
                } else {
                    i3 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + m977b(this.f1117g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1117g;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f1114d) {
            if (this.f1113c != null) {
                this.f1113c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f1111a != null) {
                if (this.f1118h.getVisibility() == 0) {
                    this.f1111a.setBounds(this.f1118h.getLeft(), this.f1118h.getTop(), this.f1118h.getRight(), this.f1118h.getBottom());
                } else if (this.f1119i != null && this.f1119i.getVisibility() == 0) {
                    this.f1111a.setBounds(this.f1119i.getLeft(), this.f1119i.getTop(), this.f1119i.getRight(), this.f1119i.getBottom());
                } else {
                    this.f1111a.setBounds(0, 0, 0, 0);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.f1115e = z4;
            if (!z4 || this.f1112b == null) {
                z3 = z2;
            } else {
                this.f1112b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }
}
