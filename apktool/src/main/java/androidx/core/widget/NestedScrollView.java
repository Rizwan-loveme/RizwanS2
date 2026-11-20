package androidx.core.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.C0225a;
import androidx.core.p031f.C0271a;
import androidx.core.p031f.C0297m;
import androidx.core.p031f.C0301q;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0296l;
import androidx.core.p031f.InterfaceC0300p;
import androidx.core.p031f.p032a.C0273b;
import androidx.core.p031f.p032a.C0275d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0296l, InterfaceC0300p {

    /* renamed from: w */
    private static final C0328a f2293w = new C0328a();

    /* renamed from: x */
    private static final int[] f2294x = {C0012R.attr.fillViewport};

    /* renamed from: A */
    private float f2295A;

    /* renamed from: B */
    private InterfaceC0329b f2296B;

    /* renamed from: a */
    private long f2297a;

    /* renamed from: b */
    private final Rect f2298b;

    /* renamed from: c */
    private OverScroller f2299c;

    /* renamed from: d */
    private EdgeEffect f2300d;

    /* renamed from: e */
    private EdgeEffect f2301e;

    /* renamed from: f */
    private int f2302f;

    /* renamed from: g */
    private boolean f2303g;

    /* renamed from: h */
    private boolean f2304h;

    /* renamed from: i */
    private View f2305i;

    /* renamed from: j */
    private boolean f2306j;

    /* renamed from: k */
    private VelocityTracker f2307k;

    /* renamed from: l */
    private boolean f2308l;

    /* renamed from: m */
    private boolean f2309m;

    /* renamed from: n */
    private int f2310n;

    /* renamed from: o */
    private int f2311o;

    /* renamed from: p */
    private int f2312p;

    /* renamed from: q */
    private int f2313q;

    /* renamed from: r */
    private final int[] f2314r;

    /* renamed from: s */
    private final int[] f2315s;

    /* renamed from: t */
    private int f2316t;

    /* renamed from: u */
    private int f2317u;

    /* renamed from: v */
    private C0330c f2318v;

    /* renamed from: y */
    private final C0301q f2319y;

    /* renamed from: z */
    private final C0297m f2320z;

    /* renamed from: androidx.core.widget.NestedScrollView$b */
    public interface InterfaceC0329b {
        /* renamed from: a */
        void mo379a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0225a.a.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2298b = new Rect();
        this.f2303g = true;
        this.f2304h = false;
        this.f2305i = null;
        this.f2306j = false;
        this.f2309m = true;
        this.f2313q = -1;
        this.f2314r = new int[2];
        this.f2315s = new int[2];
        m2423a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2294x, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2319y = new C0301q(this);
        this.f2320z = new C0297m(this);
        setNestedScrollingEnabled(true);
        C0308x.m2236a(this, f2293w);
    }

    /* renamed from: a */
    public void m2446a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f2320z.m2189a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: a */
    public boolean m2449a(int i, int i2) {
        return this.f2320z.m2195a(i, i2);
    }

    /* renamed from: a */
    public void m2445a(int i) {
        this.f2320z.m2202c(i);
    }

    /* renamed from: b */
    public boolean m2454b(int i) {
        return this.f2320z.m2194a(i);
    }

    /* renamed from: a */
    public boolean m2451a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f2320z.m2198a(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f2320z.m2190a(z);
    }

    @Override // android.view.View, androidx.core.p031f.InterfaceC0294j
    public boolean isNestedScrollingEnabled() {
        return this.f2320z.m2191a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return m2449a(i, 0);
    }

    @Override // android.view.View, androidx.core.p031f.InterfaceC0294j
    public void stopNestedScroll() {
        m2445a(0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return m2454b(0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2320z.m2196a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return m2451a(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f2320z.m2193a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2320z.m2192a(f2, f3);
    }

    @Override // androidx.core.p031f.InterfaceC0300p
    /* renamed from: a */
    public void mo998a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        m2424a(i4, i5, iArr);
    }

    /* renamed from: a */
    private void m2424a(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2320z.m2189a(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public boolean mo1001a(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: b */
    public void mo1003b(View view, View view2, int i, int i2) {
        this.f2319y.m2207a(view, view2, i, i2);
        m2449a(2, i2);
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public void mo996a(View view, int i) {
        this.f2319y.m2205a(view, i);
        m2445a(i);
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public void mo997a(View view, int i, int i2, int i3, int i4, int i5) {
        m2424a(i4, i5, (int[]) null);
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public void mo999a(View view, int i, int i2, int[] iArr, int i3) {
        m2451a(i, i2, iArr, (int[]) null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo1001a(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo1003b(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        mo996a(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        m2424a(i4, 0, (int[]) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo999a(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        m2458f((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2319y.m2203a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((layoutParams.bottomMargin + childAt.getBottom()) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * getHeight());
    }

    /* renamed from: a */
    private void m2423a() {
        this.f2299c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2310n = viewConfiguration.getScaledTouchSlop();
        this.f2311o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2312p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(InterfaceC0329b interfaceC0329b) {
        this.f2296B = interfaceC0329b;
    }

    /* renamed from: b */
    private boolean m2435b() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin) > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public void setFillViewport(boolean z) {
        if (z != this.f2308l) {
            this.f2308l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f2309m = z;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f2296B != null) {
            this.f2296B.mo379a(this, i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2308l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2452a(keyEvent);
    }

    /* renamed from: a */
    public boolean m2452a(KeyEvent keyEvent) {
        this.f2298b.setEmpty();
        if (!m2435b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 19:
                if (!keyEvent.isAltPressed()) {
                    return m2457e(33);
                }
                return m2456d(33);
            case 20:
                if (!keyEvent.isAltPressed()) {
                    return m2457e(130);
                }
                return m2456d(130);
            case 62:
                m2455c(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            default:
                return false;
        }
    }

    /* renamed from: c */
    private boolean m2437c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* renamed from: c */
    private void m2436c() {
        if (this.f2307k == null) {
            this.f2307k = VelocityTracker.obtain();
        } else {
            this.f2307k.clear();
        }
    }

    /* renamed from: d */
    private void m2438d() {
        if (this.f2307k == null) {
            this.f2307k = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m2439e() {
        if (this.f2307k != null) {
            this.f2307k.recycle();
            this.f2307k = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2439e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f2306j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                int y = (int) motionEvent.getY();
                if (!m2437c((int) motionEvent.getX(), y)) {
                    this.f2306j = false;
                    m2439e();
                    break;
                } else {
                    this.f2302f = y;
                    this.f2313q = motionEvent.getPointerId(0);
                    m2436c();
                    this.f2307k.addMovement(motionEvent);
                    this.f2299c.computeScrollOffset();
                    this.f2306j = this.f2299c.isFinished() ? false : true;
                    m2449a(2, 0);
                    break;
                }
            case 1:
            case 3:
                this.f2306j = false;
                this.f2313q = -1;
                m2439e();
                if (this.f2299c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0308x.m2249c(this);
                }
                m2445a(0);
                break;
            case 2:
                int i = this.f2313q;
                if (i != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex == -1) {
                        Log.m184e("NestedScrollView", "Invalid pointerId=" + i + " in onInterceptTouchEvent");
                        break;
                    } else {
                        int y2 = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y2 - this.f2302f) > this.f2310n && (getNestedScrollAxes() & 2) == 0) {
                            this.f2306j = true;
                            this.f2302f = y2;
                            m2438d();
                            this.f2307k.addMovement(motionEvent);
                            this.f2316t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                }
                break;
            case 6:
                m2425a(motionEvent);
                break;
        }
        return this.f2306j;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        m2438d();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2316t = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f2316t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                boolean z = !this.f2299c.isFinished();
                this.f2306j = z;
                if (z && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.f2299c.isFinished()) {
                    m2440f();
                }
                this.f2302f = (int) motionEvent.getY();
                this.f2313q = motionEvent.getPointerId(0);
                m2449a(2, 0);
                break;
            case 1:
                VelocityTracker velocityTracker = this.f2307k;
                velocityTracker.computeCurrentVelocity(1000, this.f2312p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f2313q);
                if (Math.abs(yVelocity) >= this.f2311o) {
                    if (!dispatchNestedPreFling(0.0f, -yVelocity)) {
                        dispatchNestedFling(0.0f, -yVelocity, true);
                        m2458f(-yVelocity);
                    }
                } else if (this.f2299c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0308x.m2249c(this);
                }
                this.f2313q = -1;
                m2441g();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f2313q);
                if (findPointerIndex == -1) {
                    Log.m184e("NestedScrollView", "Invalid pointerId=" + this.f2313q + " in onTouchEvent");
                    break;
                } else {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i = this.f2302f - y;
                    if (!this.f2306j && Math.abs(i) > this.f2310n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f2306j = true;
                        i = i > 0 ? i - this.f2310n : i + this.f2310n;
                    }
                    if (this.f2306j) {
                        if (m2451a(0, i, this.f2315s, this.f2314r, 0)) {
                            i -= this.f2315s[1];
                            this.f2316t += this.f2314r[1];
                        }
                        this.f2302f = y - this.f2314r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (m2450a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !m2454b(0)) {
                            this.f2307k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        this.f2315s[1] = 0;
                        m2446a(0, scrollY2, 0, i - scrollY2, this.f2314r, 0, this.f2315s);
                        this.f2302f -= this.f2314r[1];
                        this.f2316t += this.f2314r[1];
                        if (z2) {
                            int i2 = i - this.f2315s[1];
                            m2443h();
                            int i3 = scrollY + i2;
                            if (i3 < 0) {
                                C0334d.m2499a(this.f2300d, i2 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                                if (!this.f2301e.isFinished()) {
                                    this.f2301e.onRelease();
                                }
                            } else if (i3 > scrollRange) {
                                C0334d.m2499a(this.f2301e, i2 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                                if (!this.f2300d.isFinished()) {
                                    this.f2300d.onRelease();
                                }
                            }
                            if (this.f2300d != null && (!this.f2300d.isFinished() || !this.f2301e.isFinished())) {
                                C0308x.m2249c(this);
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                if (this.f2306j && getChildCount() > 0 && this.f2299c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0308x.m2249c(this);
                }
                this.f2313q = -1;
                m2441g();
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.f2302f = (int) motionEvent.getY(actionIndex);
                this.f2313q = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                m2425a(motionEvent);
                this.f2302f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f2313q));
                break;
        }
        if (this.f2307k != null) {
            this.f2307k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* renamed from: a */
    private void m2425a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2313q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2302f = (int) motionEvent.getY(i);
            this.f2313q = motionEvent.getPointerId(i);
            if (this.f2307k != null) {
                this.f2307k.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (!this.f2306j) {
                    float axisValue = motionEvent.getAxisValue(9);
                    if (axisValue != 0.0f) {
                        int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                        int scrollRange = getScrollRange();
                        int scrollY = getScrollY();
                        int i = scrollY - verticalScrollFactorCompat;
                        if (i < 0) {
                            scrollRange = 0;
                        } else if (i <= scrollRange) {
                            scrollRange = i;
                        }
                        if (scrollRange != scrollY) {
                            super.scrollTo(getScrollX(), scrollRange);
                            break;
                        }
                    }
                }
                break;
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2295A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(C0012R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f2295A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f2295A;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    /* renamed from: a */
    boolean m2450a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        if (!z6) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (!z7) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        int i13 = -i8;
        int i14 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 >= i11) {
            z2 = false;
            i12 = i9;
        } else {
            z2 = true;
            i12 = i11;
        }
        if (i10 > i14) {
            z3 = true;
        } else if (i10 >= i13) {
            z3 = false;
            i14 = i10;
        } else {
            z3 = true;
            i14 = i13;
        }
        if (z3 && !m2454b(1)) {
            this.f2299c.springBack(i12, i14, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i14, z2, z3);
        return z2 || z3;
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    /* renamed from: a */
    private View m2422a(boolean z, int i, int i2) {
        boolean z2;
        ArrayList<View> focusables = getFocusables(2);
        View view = null;
        int size = focusables.size();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < size) {
            View view2 = focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                z2 = i < top && bottom < i2;
                if (view != null) {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z3) {
                        if (z2 && z4) {
                            z2 = z3;
                        }
                    } else if (z2) {
                        z2 = true;
                    } else if (z4) {
                        z2 = z3;
                    }
                }
                i3++;
                z3 = z2;
                view = view2;
            }
            z2 = z3;
            view2 = view;
            i3++;
            z3 = z2;
            view = view2;
        }
        return view;
    }

    /* renamed from: c */
    public boolean m2455c(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f2298b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom() + getPaddingBottom();
                if (this.f2298b.top + height > bottom) {
                    this.f2298b.top = bottom - height;
                }
            }
        } else {
            this.f2298b.top = getScrollY() - height;
            if (this.f2298b.top < 0) {
                this.f2298b.top = 0;
            }
        }
        this.f2298b.bottom = this.f2298b.top + height;
        return m2427a(i, this.f2298b.top, this.f2298b.bottom);
    }

    /* renamed from: d */
    public boolean m2456d(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.f2298b.top = 0;
        this.f2298b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2298b.bottom = ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom() + getPaddingBottom();
            this.f2298b.top = this.f2298b.bottom - height;
        }
        return m2427a(i, this.f2298b.top, this.f2298b.bottom);
    }

    /* renamed from: a */
    private boolean m2427a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View m2422a = m2422a(z2, i2, i3);
        if (m2422a == null) {
            m2422a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2442g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (m2422a != findFocus()) {
            m2422a.requestFocus(i);
        }
        return z;
    }

    /* renamed from: e */
    public boolean m2457e(int i) {
        int i2;
        View findFocus = findFocus();
        View view = findFocus == this ? null : findFocus;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && m2430a(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.f2298b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2298b);
            m2442g(m2444a(this.f2298b));
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                i2 = getScrollY();
            } else if (i != 130 || getChildCount() <= 0) {
                i2 = maxScrollAmount;
            } else {
                View childAt = getChildAt(0);
                i2 = Math.min((((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom()) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (i2 == 0) {
                return false;
            }
            if (i != 130) {
                i2 = -i2;
            }
            m2442g(i2);
        }
        if (view != null && view.isFocused() && m2429a(view)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m2429a(View view) {
        return !m2430a(view, 0, getHeight());
    }

    /* renamed from: a */
    private boolean m2430a(View view, int i, int i2) {
        view.getDrawingRect(this.f2298b);
        offsetDescendantRectToMyCoords(view, this.f2298b);
        return this.f2298b.bottom + i >= getScrollY() && this.f2298b.top - i <= getScrollY() + i2;
    }

    /* renamed from: g */
    private void m2442g(int i) {
        if (i != 0) {
            if (this.f2309m) {
                m2453b(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    /* renamed from: b */
    public final void m2453b(int i, int i2) {
        m2433b(i, i2, 250, false);
    }

    /* renamed from: b */
    private void m2433b(int i, int i2, int i3, boolean z) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f2297a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                this.f2299c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, Math.max(0, height - height2))) - scrollY, i3);
                m2426a(z);
            } else {
                if (!this.f2299c.isFinished()) {
                    m2440f();
                }
                scrollBy(i, i2);
            }
            this.f2297a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    /* renamed from: a */
    void m2448a(int i, int i2, boolean z) {
        m2447a(i, i2, 250, z);
    }

    /* renamed from: a */
    void m2447a(int i, int i2, int i3, boolean z) {
        m2433b(i - getScrollX(), i2 - getScrollY(), i3, z);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int bottom = layoutParams.bottomMargin + childAt.getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f2299c.isFinished()) {
            this.f2299c.computeScrollOffset();
            int currY = this.f2299c.getCurrY();
            int i = currY - this.f2317u;
            this.f2317u = currY;
            this.f2315s[1] = 0;
            m2451a(0, i, this.f2315s, (int[]) null, 1);
            int i2 = i - this.f2315s[1];
            int scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                m2450a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - scrollY;
                int i3 = i2 - scrollY2;
                this.f2315s[1] = 0;
                m2446a(0, scrollY2, 0, i3, this.f2314r, 1, this.f2315s);
                i2 = i3 - this.f2315s[1];
            }
            if (i2 != 0) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    m2443h();
                    if (i2 < 0) {
                        if (this.f2300d.isFinished()) {
                            this.f2300d.onAbsorb((int) this.f2299c.getCurrVelocity());
                        }
                    } else if (this.f2301e.isFinished()) {
                        this.f2301e.onAbsorb((int) this.f2299c.getCurrVelocity());
                    }
                }
                m2440f();
            }
            if (!this.f2299c.isFinished()) {
                C0308x.m2249c(this);
            } else {
                m2445a(1);
            }
        }
    }

    /* renamed from: a */
    private void m2426a(boolean z) {
        if (z) {
            m2449a(2, 1);
        } else {
            m2445a(1);
        }
        this.f2317u = getScrollY();
        C0308x.m2249c(this);
    }

    /* renamed from: f */
    private void m2440f() {
        this.f2299c.abortAnimation();
        m2445a(1);
    }

    /* renamed from: b */
    private void m2434b(View view) {
        view.getDrawingRect(this.f2298b);
        offsetDescendantRectToMyCoords(view, this.f2298b);
        int m2444a = m2444a(this.f2298b);
        if (m2444a != 0) {
            scrollBy(0, m2444a);
        }
    }

    /* renamed from: a */
    private boolean m2428a(Rect rect, boolean z) {
        int m2444a = m2444a(rect);
        boolean z2 = m2444a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, m2444a);
            } else {
                m2453b(0, m2444a);
            }
        }
        return z2;
    }

    /* renamed from: a */
    protected int m2444a(Rect rect) {
        int i;
        int i2;
        int i3;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i5 = rect.top > 0 ? scrollY + verticalFadingEdgeLength : scrollY;
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i6 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        if (rect.bottom > i6 && rect.top > i5) {
            if (rect.height() > height) {
                i3 = (rect.top - i5) + 0;
            } else {
                i3 = (rect.bottom - i6) + 0;
            }
            i = Math.min(i3, (layoutParams.bottomMargin + childAt.getBottom()) - i4);
        } else if (rect.top >= i5 || rect.bottom >= i6) {
            i = 0;
        } else {
            if (rect.height() > height) {
                i2 = 0 - (i6 - rect.bottom);
            } else {
                i2 = 0 - (i5 - rect.top);
            }
            i = Math.max(i2, -getScrollY());
        }
        return i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f2303g) {
            m2434b(view2);
        } else {
            this.f2305i = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || m2429a(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2428a(rect, z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2303g = true;
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        this.f2303g = false;
        if (this.f2305i != null && m2431a(this.f2305i, this)) {
            m2434b(this.f2305i);
        }
        this.f2305i = null;
        if (!this.f2304h) {
            if (this.f2318v != null) {
                scrollTo(getScrollX(), this.f2318v.f2321a);
                this.f2318v = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i5 = layoutParams.bottomMargin + childAt.getMeasuredHeight() + layoutParams.topMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int m2432b = m2432b(scrollY, paddingTop, i5);
            if (m2432b != scrollY) {
                scrollTo(getScrollX(), m2432b);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2304h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2304h = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2430a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f2298b);
            offsetDescendantRectToMyCoords(findFocus, this.f2298b);
            m2442g(m2444a(this.f2298b));
        }
    }

    /* renamed from: a */
    private static boolean m2431a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m2431a((View) parent, view2);
    }

    /* renamed from: f */
    public void m2458f(int i) {
        if (getChildCount() > 0) {
            this.f2299c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m2426a(true);
        }
    }

    /* renamed from: g */
    private void m2441g() {
        this.f2306j = false;
        m2439e();
        m2445a(0);
        if (this.f2300d != null) {
            this.f2300d.onRelease();
            this.f2301e.onRelease();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = layoutParams.bottomMargin + childAt.getHeight() + layoutParams.topMargin;
            int m2432b = m2432b(i, width, width2);
            int m2432b2 = m2432b(i2, height, height2);
            if (m2432b != getScrollX() || m2432b2 != getScrollY()) {
                super.scrollTo(m2432b, m2432b2);
            }
        }
    }

    /* renamed from: h */
    private void m2443h() {
        if (getOverScrollMode() != 2) {
            if (this.f2300d == null) {
                Context context = getContext();
                this.f2300d = new EdgeEffect(context);
                this.f2301e = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.f2300d = null;
        this.f2301e = null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        int i = 0;
        super.draw(canvas);
        if (this.f2300d != null) {
            int scrollY = getScrollY();
            if (!this.f2300d.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(paddingLeft, min);
                this.f2300d.setSize(width, height);
                if (this.f2300d.draw(canvas)) {
                    C0308x.m2249c(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f2301e.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int max = Math.max(getScrollRange(), scrollY) + height2;
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i = 0 + getPaddingLeft();
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    max -= getPaddingBottom();
                }
                canvas.translate(i - width2, max);
                canvas.rotate(180.0f, width2, 0.0f);
                this.f2301e.setSize(width2, height2);
                if (this.f2301e.draw(canvas)) {
                    C0308x.m2249c(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* renamed from: b */
    private static int m2432b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0330c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0330c c0330c = (C0330c) parcelable;
        super.onRestoreInstanceState(c0330c.getSuperState());
        this.f2318v = c0330c;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0330c c0330c = new C0330c(super.onSaveInstanceState());
        c0330c.f2321a = getScrollY();
        return c0330c;
    }

    /* renamed from: androidx.core.widget.NestedScrollView$c */
    static class C0330c extends View.BaseSavedState {
        public static final Parcelable.Creator<C0330c> CREATOR = new Parcelable.Creator<C0330c>() { // from class: androidx.core.widget.NestedScrollView.c.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0330c createFromParcel(Parcel parcel) {
                return new C0330c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0330c[] newArray(int i) {
                return new C0330c[i];
            }
        };

        /* renamed from: a */
        public int f2321a;

        C0330c(Parcelable parcelable) {
            super(parcelable);
        }

        C0330c(Parcel parcel) {
            super(parcel);
            this.f2321a = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2321a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f2321a + "}";
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$a */
    static class C0328a extends C0271a {
        C0328a() {
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public boolean mo1970a(View view, int i, Bundle bundle) {
            if (super.mo1970a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            switch (i) {
                case 4096:
                case C0012R.id.accessibilityActionScrollDown /* 16908346 */:
                    int min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2448a(0, min, true);
                    return true;
                case 8192:
                case C0012R.id.accessibilityActionScrollUp /* 16908344 */:
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2448a(0, max, true);
                    return true;
                default:
                    return false;
            }
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public void mo1969a(View view, C0273b c0273b) {
            int scrollRange;
            super.mo1969a(view, c0273b);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0273b.m2000b(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                c0273b.m2016g(true);
                if (nestedScrollView.getScrollY() > 0) {
                    c0273b.m1992a(C0273b.a.f2104n);
                    c0273b.m1992a(C0273b.a.f2115y);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    c0273b.m1992a(C0273b.a.f2103m);
                    c0273b.m1992a(C0273b.a.f2078A);
                }
            }
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: d */
        public void mo1974d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo1974d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0275d.m2045a(accessibilityEvent, nestedScrollView.getScrollX());
            C0275d.m2046b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }
}
