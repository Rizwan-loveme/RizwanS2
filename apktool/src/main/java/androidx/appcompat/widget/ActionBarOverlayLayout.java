package androidx.appcompat.widget;

import android.C0012R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.InterfaceC0112m;
import androidx.core.graphics.C0312b;
import androidx.core.p031f.C0282af;
import androidx.core.p031f.C0301q;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0298n;
import androidx.core.p031f.InterfaceC0299o;
import androidx.core.p031f.InterfaceC0300p;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0163ae, InterfaceC0298n, InterfaceC0299o, InterfaceC0300p {

    /* renamed from: e */
    static final int[] f1135e = {C0059a.a.actionBarSize, C0012R.attr.windowContentOverlay};

    /* renamed from: A */
    private C0282af f1136A;

    /* renamed from: B */
    private InterfaceC0123a f1137B;

    /* renamed from: C */
    private OverScroller f1138C;

    /* renamed from: D */
    private final Runnable f1139D;

    /* renamed from: E */
    private final Runnable f1140E;

    /* renamed from: F */
    private final C0301q f1141F;

    /* renamed from: a */
    ActionBarContainer f1142a;

    /* renamed from: b */
    boolean f1143b;

    /* renamed from: c */
    ViewPropertyAnimator f1144c;

    /* renamed from: d */
    final AnimatorListenerAdapter f1145d;

    /* renamed from: f */
    private int f1146f;

    /* renamed from: g */
    private int f1147g;

    /* renamed from: h */
    private ContentFrameLayout f1148h;

    /* renamed from: i */
    private InterfaceC0164af f1149i;

    /* renamed from: j */
    private Drawable f1150j;

    /* renamed from: k */
    private boolean f1151k;

    /* renamed from: l */
    private boolean f1152l;

    /* renamed from: m */
    private boolean f1153m;

    /* renamed from: n */
    private boolean f1154n;

    /* renamed from: o */
    private int f1155o;

    /* renamed from: p */
    private int f1156p;

    /* renamed from: q */
    private final Rect f1157q;

    /* renamed from: r */
    private final Rect f1158r;

    /* renamed from: s */
    private final Rect f1159s;

    /* renamed from: t */
    private final Rect f1160t;

    /* renamed from: u */
    private final Rect f1161u;

    /* renamed from: v */
    private final Rect f1162v;

    /* renamed from: w */
    private final Rect f1163w;

    /* renamed from: x */
    private C0282af f1164x;

    /* renamed from: y */
    private C0282af f1165y;

    /* renamed from: z */
    private C0282af f1166z;

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    public interface InterfaceC0123a {
        /* renamed from: b */
        void mo639b(int i);

        /* renamed from: g */
        void mo641g(boolean z);

        /* renamed from: l */
        void mo647l();

        /* renamed from: m */
        void mo648m();

        /* renamed from: n */
        void mo649n();

        /* renamed from: o */
        void mo650o();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1147g = 0;
        this.f1157q = new Rect();
        this.f1158r = new Rect();
        this.f1159s = new Rect();
        this.f1160t = new Rect();
        this.f1161u = new Rect();
        this.f1162v = new Rect();
        this.f1163w = new Rect();
        this.f1164x = C0282af.f2137a;
        this.f1165y = C0282af.f2137a;
        this.f1166z = C0282af.f2137a;
        this.f1136A = C0282af.f2137a;
        this.f1145d = new AnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f1144c = null;
                ActionBarOverlayLayout.this.f1143b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f1144c = null;
                ActionBarOverlayLayout.this.f1143b = false;
            }
        };
        this.f1139D = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m1005d();
                ActionBarOverlayLayout.this.f1144c = ActionBarOverlayLayout.this.f1142a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1145d);
            }
        };
        this.f1140E = new Runnable() { // from class: androidx.appcompat.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m1005d();
                ActionBarOverlayLayout.this.f1144c = ActionBarOverlayLayout.this.f1142a.animate().translationY(-ActionBarOverlayLayout.this.f1142a.getHeight()).setListener(ActionBarOverlayLayout.this.f1145d);
            }
        };
        m986a(context);
        this.f1141F = new C0301q(this);
    }

    /* renamed from: a */
    private void m986a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1135e);
        this.f1146f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1150j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1150j == null);
        obtainStyledAttributes.recycle();
        this.f1151k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1138C = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1005d();
    }

    public void setActionBarVisibilityCallback(InterfaceC0123a interfaceC0123a) {
        this.f1137B = interfaceC0123a;
        if (getWindowToken() != null) {
            this.f1137B.mo639b(this.f1147g);
            if (this.f1156p != 0) {
                onWindowSystemUiVisibilityChanged(this.f1156p);
                C0308x.m2267n(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1152l = z;
        this.f1151k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    /* renamed from: a */
    public boolean m1000a() {
        return this.f1152l;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1153m = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m986a(getContext());
        C0308x.m2267n(this);
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m1004c();
        int i2 = this.f1156p ^ i;
        this.f1156p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.f1137B != null) {
            this.f1137B.mo641g(z2 ? false : true);
            if (z || !z2) {
                this.f1137B.mo647l();
            } else {
                this.f1137B.mo648m();
            }
        }
        if ((i2 & 256) != 0 && this.f1137B != null) {
            C0308x.m2267n(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1147g = i;
        if (this.f1137B != null) {
            this.f1137B.mo639b(i);
        }
    }

    /* renamed from: a */
    private boolean m988a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0124b c0124b = (C0124b) view.getLayoutParams();
        if (z && c0124b.leftMargin != rect.left) {
            c0124b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0124b.topMargin != rect.top) {
            c0124b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0124b.rightMargin != rect.right) {
            c0124b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0124b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0124b.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        m1004c();
        boolean m988a = m988a((View) this.f1142a, rect, true, true, false, true);
        this.f1160t.set(rect);
        C0191bf.m1480a(this, this.f1160t, this.f1157q);
        if (!this.f1161u.equals(this.f1160t)) {
            this.f1161u.set(this.f1160t);
            m988a = true;
        }
        if (!this.f1158r.equals(this.f1157q)) {
            this.f1158r.set(this.f1157q);
            m988a = true;
        }
        if (!m988a) {
            return true;
        }
        requestLayout();
        return true;
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean z = true;
        m1004c();
        C0282af m2068a = C0282af.m2068a(windowInsets, this);
        boolean m988a = m988a((View) this.f1142a, new Rect(m2068a.m2070a(), m2068a.m2077b(), m2068a.m2080c(), m2068a.m2081d()), true, true, false, true);
        C0308x.m2223a(this, m2068a, this.f1157q);
        this.f1164x = m2068a.m2078b(this.f1157q.left, this.f1157q.top, this.f1157q.right, this.f1157q.bottom);
        if (!this.f1165y.equals(this.f1164x)) {
            this.f1165y = this.f1164x;
            m988a = true;
        }
        if (this.f1158r.equals(this.f1157q)) {
            z = m988a;
        } else {
            this.f1158r.set(this.f1157q);
        }
        if (z) {
            requestLayout();
        }
        return m2068a.m2086i().m2083f().m2084g().m2089l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0124b generateDefaultLayoutParams() {
        return new C0124b(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0124b generateLayoutParams(AttributeSet attributeSet) {
        return new C0124b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0124b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0124b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        m1004c();
        measureChildWithMargins(this.f1142a, i, 0, i2, 0);
        C0124b c0124b = (C0124b) this.f1142a.getLayoutParams();
        int max = Math.max(0, this.f1142a.getMeasuredWidth() + c0124b.leftMargin + c0124b.rightMargin);
        int max2 = Math.max(0, c0124b.bottomMargin + this.f1142a.getMeasuredHeight() + c0124b.topMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1142a.getMeasuredState());
        boolean z = (C0308x.m2266m(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f1146f;
            if (this.f1153m && this.f1142a.getTabContainer() != null) {
                measuredHeight += this.f1146f;
            }
        } else {
            measuredHeight = this.f1142a.getVisibility() != 8 ? this.f1142a.getMeasuredHeight() : 0;
        }
        this.f1159s.set(this.f1157q);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1166z = this.f1164x;
        } else {
            this.f1162v.set(this.f1160t);
        }
        if (!this.f1152l && !z) {
            this.f1159s.top += measuredHeight;
            this.f1159s.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1166z = this.f1166z.m2078b(0, measuredHeight, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f1166z = new C0282af.b(this.f1166z).m2091a(C0312b.m2311a(this.f1166z.m2070a(), measuredHeight + this.f1166z.m2077b(), this.f1166z.m2080c(), this.f1166z.m2081d() + 0)).m2092a();
        } else {
            Rect rect = this.f1162v;
            rect.top = measuredHeight + rect.top;
            this.f1162v.bottom += 0;
        }
        m988a((View) this.f1148h, this.f1159s, true, true, true, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.f1136A.equals(this.f1166z)) {
            this.f1136A = this.f1166z;
            C0308x.m2244b(this.f1148h, this.f1166z);
        } else if (Build.VERSION.SDK_INT < 21 && !this.f1163w.equals(this.f1162v)) {
            this.f1163w.set(this.f1162v);
            this.f1148h.m1053a(this.f1162v);
        }
        measureChildWithMargins(this.f1148h, i, 0, i2, 0);
        C0124b c0124b2 = (C0124b) this.f1148h.getLayoutParams();
        int max3 = Math.max(max, this.f1148h.getMeasuredWidth() + c0124b2.leftMargin + c0124b2.rightMargin);
        int max4 = Math.max(max2, c0124b2.bottomMargin + this.f1148h.getMeasuredHeight() + c0124b2.topMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1148h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0124b c0124b = (C0124b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = c0124b.leftMargin + paddingLeft;
                int i7 = c0124b.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1150j != null && !this.f1151k) {
            int bottom = this.f1142a.getVisibility() == 0 ? (int) (this.f1142a.getBottom() + this.f1142a.getTranslationY() + 0.5f) : 0;
            this.f1150j.setBounds(0, bottom, getWidth(), this.f1150j.getIntrinsicHeight() + bottom);
            this.f1150j.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.core.p031f.InterfaceC0300p
    /* renamed from: a */
    public void mo998a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        mo997a(view, i, i2, i3, i4, i5);
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public boolean mo1001a(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: b */
    public void mo1003b(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public void mo996a(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public void mo997a(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public void mo999a(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1142a.getVisibility() != 0) {
            return false;
        }
        return this.f1154n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1141F.m2206a(view, view2, i);
        this.f1155o = getActionBarHideOffset();
        m1005d();
        if (this.f1137B != null) {
            this.f1137B.mo649n();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1155o += i2;
        setActionBarHideOffset(this.f1155o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1154n && !this.f1143b) {
            if (this.f1155o <= this.f1142a.getHeight()) {
                m989l();
            } else {
                m990m();
            }
        }
        if (this.f1137B != null) {
            this.f1137B.mo650o();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.f1154n || !z) {
            return false;
        }
        if (m987a(f3)) {
            m992o();
        } else {
            m991n();
        }
        this.f1143b = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1141F.m2203a();
    }

    /* renamed from: c */
    void m1004c() {
        if (this.f1148h == null) {
            this.f1148h = (ContentFrameLayout) findViewById(C0059a.f.action_bar_activity_content);
            this.f1142a = (ActionBarContainer) findViewById(C0059a.f.action_bar_container);
            this.f1149i = m985a(findViewById(C0059a.f.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private InterfaceC0164af m985a(View view) {
        if (view instanceof InterfaceC0164af) {
            return (InterfaceC0164af) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1154n) {
            this.f1154n = z;
            if (!z) {
                m1005d();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        if (this.f1142a != null) {
            return -((int) this.f1142a.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        m1005d();
        this.f1142a.setTranslationY(-Math.max(0, Math.min(i, this.f1142a.getHeight())));
    }

    /* renamed from: d */
    void m1005d() {
        removeCallbacks(this.f1139D);
        removeCallbacks(this.f1140E);
        if (this.f1144c != null) {
            this.f1144c.cancel();
        }
    }

    /* renamed from: l */
    private void m989l() {
        m1005d();
        postDelayed(this.f1139D, 600L);
    }

    /* renamed from: m */
    private void m990m() {
        m1005d();
        postDelayed(this.f1140E, 600L);
    }

    /* renamed from: n */
    private void m991n() {
        m1005d();
        this.f1139D.run();
    }

    /* renamed from: o */
    private void m992o() {
        m1005d();
        this.f1140E.run();
    }

    /* renamed from: a */
    private boolean m987a(float f2) {
        this.f1138C.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1138C.getFinalY() > this.f1142a.getHeight();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    public void setWindowCallback(Window.Callback callback) {
        m1004c();
        this.f1149i.mo1234a(callback);
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    public void setWindowTitle(CharSequence charSequence) {
        m1004c();
        this.f1149i.mo1237a(charSequence);
    }

    public CharSequence getTitle() {
        m1004c();
        return this.f1149i.mo1247e();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: a */
    public void mo994a(int i) {
        m1004c();
        switch (i) {
            case 2:
                this.f1149i.mo1248f();
                break;
            case 5:
                this.f1149i.mo1249g();
                break;
            case 109:
                setOverlayMode(true);
                break;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m1004c();
        this.f1149i.mo1230a(i);
    }

    public void setIcon(Drawable drawable) {
        m1004c();
        this.f1149i.mo1231a(drawable);
    }

    public void setLogo(int i) {
        m1004c();
        this.f1149i.mo1240b(i);
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: e */
    public boolean mo1006e() {
        m1004c();
        return this.f1149i.mo1250h();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: f */
    public boolean mo1007f() {
        m1004c();
        return this.f1149i.mo1251i();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: g */
    public boolean mo1008g() {
        m1004c();
        return this.f1149i.mo1252j();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: h */
    public boolean mo1009h() {
        m1004c();
        return this.f1149i.mo1253k();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: i */
    public boolean mo1010i() {
        m1004c();
        return this.f1149i.mo1254l();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: j */
    public void mo1011j() {
        m1004c();
        this.f1149i.mo1255m();
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: a */
    public void mo995a(Menu menu, InterfaceC0112m.a aVar) {
        m1004c();
        this.f1149i.mo1232a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.InterfaceC0163ae
    /* renamed from: k */
    public void mo1012k() {
        m1004c();
        this.f1149i.mo1256n();
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    public static class C0124b extends ViewGroup.MarginLayoutParams {
        public C0124b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0124b(int i, int i2) {
            super(i, i2);
        }

        public C0124b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
