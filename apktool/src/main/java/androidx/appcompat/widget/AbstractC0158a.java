package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0278ab;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0279ac;

/* compiled from: AbsActionBarView.java */
/* renamed from: androidx.appcompat.widget.a */
/* loaded from: classes.dex */
abstract class AbstractC0158a extends ViewGroup {

    /* renamed from: a */
    protected final a f1357a;

    /* renamed from: b */
    protected final Context f1358b;

    /* renamed from: c */
    protected ActionMenuView f1359c;

    /* renamed from: d */
    protected C0193c f1360d;

    /* renamed from: e */
    protected int f1361e;

    /* renamed from: f */
    protected C0278ab f1362f;

    /* renamed from: g */
    private boolean f1363g;

    /* renamed from: h */
    private boolean f1364h;

    AbstractC0158a(Context context) {
        this(context, null);
    }

    AbstractC0158a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbstractC0158a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1357a = new a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C0059a.a.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f1358b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f1358b = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0059a.j.ActionBar, C0059a.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0059a.j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1360d != null) {
            this.f1360d.m1492a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1363g = false;
        }
        if (!this.f1363g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1363g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1363g = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1364h = false;
        }
        if (!this.f1364h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1364h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1364h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1361e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1361e;
    }

    public int getAnimatedVisibility() {
        return this.f1362f != null ? this.f1357a.f1365a : getVisibility();
    }

    /* renamed from: a */
    public C0278ab mo979a(int i, long j) {
        if (this.f1362f != null) {
            this.f1362f.m2065b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            C0278ab m2058a = C0308x.m2263j(this).m2058a(1.0f);
            m2058a.m2059a(j);
            m2058a.m2061a(this.f1357a.m1161a(m2058a, i));
            return m2058a;
        }
        C0278ab m2058a2 = C0308x.m2263j(this).m2058a(0.0f);
        m2058a2.m2059a(j);
        m2058a2.m2061a(this.f1357a.m1161a(m2058a2, i));
        return m2058a2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1362f != null) {
                this.f1362f.m2065b();
            }
            super.setVisibility(i);
        }
    }

    /* renamed from: a */
    public boolean mo981a() {
        if (this.f1360d != null) {
            return this.f1360d.m1499d();
        }
        return false;
    }

    /* renamed from: a */
    protected int m1159a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* renamed from: a */
    protected static int m1156a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* renamed from: a */
    protected int m1160a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* compiled from: AbsActionBarView.java */
    /* renamed from: androidx.appcompat.widget.a$a */
    protected class a implements InterfaceC0279ac {

        /* renamed from: a */
        int f1365a;

        /* renamed from: c */
        private boolean f1367c = false;

        protected a() {
        }

        /* renamed from: a */
        public a m1161a(C0278ab c0278ab, int i) {
            AbstractC0158a.this.f1362f = c0278ab;
            this.f1365a = i;
            return this;
        }

        @Override // androidx.core.p031f.InterfaceC0279ac
        /* renamed from: a */
        public void mo556a(View view) {
            AbstractC0158a.super.setVisibility(0);
            this.f1367c = false;
        }

        @Override // androidx.core.p031f.InterfaceC0279ac
        /* renamed from: b */
        public void mo557b(View view) {
            if (!this.f1367c) {
                AbstractC0158a.this.f1362f = null;
                AbstractC0158a.super.setVisibility(this.f1365a);
            }
        }

        @Override // androidx.core.p031f.InterfaceC0279ac
        /* renamed from: c */
        public void mo1162c(View view) {
            this.f1367c = true;
        }
    }
}
