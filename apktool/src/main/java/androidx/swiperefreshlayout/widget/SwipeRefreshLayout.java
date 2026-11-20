package androidx.swiperefreshlayout.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.TypedArray;
import android.p008os.Build;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.C0255a;
import androidx.core.p031f.C0297m;
import androidx.core.p031f.C0301q;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0294j;
import androidx.core.p031f.InterfaceC0295k;
import androidx.core.p031f.InterfaceC0296l;
import androidx.core.p031f.InterfaceC0298n;
import androidx.core.p031f.InterfaceC0299o;
import androidx.core.p031f.InterfaceC0300p;
import androidx.core.widget.C0337g;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC0294j, InterfaceC0295k, InterfaceC0296l, InterfaceC0298n, InterfaceC0299o, InterfaceC0300p {

    /* renamed from: A */
    private float f3159A;

    /* renamed from: B */
    private boolean f3160B;

    /* renamed from: C */
    private int f3161C;

    /* renamed from: D */
    private boolean f3162D;

    /* renamed from: E */
    private final DecelerateInterpolator f3163E;

    /* renamed from: G */
    private int f3164G;

    /* renamed from: H */
    private Animation f3165H;

    /* renamed from: I */
    private Animation f3166I;

    /* renamed from: J */
    private Animation f3167J;

    /* renamed from: K */
    private Animation f3168K;

    /* renamed from: L */
    private Animation f3169L;

    /* renamed from: M */
    private int f3170M;

    /* renamed from: N */
    private InterfaceC0446a f3171N;

    /* renamed from: O */
    private boolean f3172O;

    /* renamed from: P */
    private Animation.AnimationListener f3173P;

    /* renamed from: Q */
    private final Animation f3174Q;

    /* renamed from: R */
    private final Animation f3175R;

    /* renamed from: a */
    InterfaceC0447b f3176a;

    /* renamed from: b */
    boolean f3177b;

    /* renamed from: c */
    int f3178c;

    /* renamed from: d */
    boolean f3179d;

    /* renamed from: e */
    C0449a f3180e;

    /* renamed from: f */
    protected int f3181f;

    /* renamed from: g */
    float f3182g;

    /* renamed from: h */
    protected int f3183h;

    /* renamed from: i */
    int f3184i;

    /* renamed from: j */
    int f3185j;

    /* renamed from: k */
    C0450b f3186k;

    /* renamed from: l */
    boolean f3187l;

    /* renamed from: m */
    boolean f3188m;

    /* renamed from: o */
    private View f3189o;

    /* renamed from: p */
    private int f3190p;

    /* renamed from: q */
    private float f3191q;

    /* renamed from: r */
    private float f3192r;

    /* renamed from: s */
    private final C0301q f3193s;

    /* renamed from: t */
    private final C0297m f3194t;

    /* renamed from: u */
    private final int[] f3195u;

    /* renamed from: v */
    private final int[] f3196v;

    /* renamed from: w */
    private final int[] f3197w;

    /* renamed from: x */
    private boolean f3198x;

    /* renamed from: y */
    private int f3199y;

    /* renamed from: z */
    private float f3200z;

    /* renamed from: n */
    private static final String f3158n = SwipeRefreshLayout.class.getSimpleName();

    /* renamed from: F */
    private static final int[] f3157F = {C0012R.attr.enabled};

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$a */
    public interface InterfaceC0446a {
        /* renamed from: a */
        boolean m3374a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$b */
    public interface InterfaceC0447b {
        /* renamed from: a */
        void mo3375a();
    }

    /* renamed from: a */
    void m3369a() {
        this.f3180e.clearAnimation();
        this.f3186k.stop();
        this.f3180e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f3179d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f3183h - this.f3178c);
        }
        this.f3178c = this.f3180e.getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            m3369a();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$c */
    static class C0448c extends View.BaseSavedState {
        public static final Parcelable.Creator<C0448c> CREATOR = new Parcelable.Creator<C0448c>() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.c.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0448c createFromParcel(Parcel parcel) {
                return new C0448c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0448c[] newArray(int i) {
                return new C0448c[i];
            }
        };

        /* renamed from: a */
        final boolean f3211a;

        C0448c(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f3211a = z;
        }

        C0448c(Parcel parcel) {
            super(parcel);
            this.f3211a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.p008os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f3211a ? (byte) 1 : (byte) 0);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new C0448c(super.onSaveInstanceState(), this.f3177b);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        C0448c c0448c = (C0448c) parcelable;
        super.onRestoreInstanceState(c0448c.getSuperState());
        setRefreshing(c0448c.f3211a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3369a();
    }

    private void setColorViewAlpha(int i) {
        this.f3180e.getBackground().setAlpha(i);
        this.f3186k.setAlpha(i);
    }

    public int getProgressViewStartOffset() {
        return this.f3183h;
    }

    public int getProgressViewEndOffset() {
        return this.f3184i;
    }

    public void setSlingshotDistance(int i) {
        this.f3185j = i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f3170M = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f3170M = (int) (displayMetrics.density * 40.0f);
            }
            this.f3180e.setImageDrawable(null);
            this.f3186k.m3390a(i);
            this.f3180e.setImageDrawable(this.f3186k);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3177b = false;
        this.f3191q = -1.0f;
        this.f3195u = new int[2];
        this.f3196v = new int[2];
        this.f3197w = new int[2];
        this.f3161C = -1;
        this.f3164G = -1;
        this.f3173P = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f3177b) {
                    SwipeRefreshLayout.this.f3186k.setAlpha(255);
                    SwipeRefreshLayout.this.f3186k.start();
                    if (SwipeRefreshLayout.this.f3187l && SwipeRefreshLayout.this.f3176a != null) {
                        SwipeRefreshLayout.this.f3176a.mo3375a();
                    }
                    SwipeRefreshLayout.this.f3178c = SwipeRefreshLayout.this.f3180e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.m3369a();
            }
        };
        this.f3174Q = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                int i;
                if (!SwipeRefreshLayout.this.f3188m) {
                    i = SwipeRefreshLayout.this.f3184i - Math.abs(SwipeRefreshLayout.this.f3183h);
                } else {
                    i = SwipeRefreshLayout.this.f3184i;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int) ((i - SwipeRefreshLayout.this.f3181f) * f2)) + SwipeRefreshLayout.this.f3181f) - SwipeRefreshLayout.this.f3180e.getTop());
                SwipeRefreshLayout.this.f3186k.m3393b(1.0f - f2);
            }
        };
        this.f3175R = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.m3370a(f2);
            }
        };
        this.f3190p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3199y = getResources().getInteger(C0012R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f3163E = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3170M = (int) (40.0f * displayMetrics.density);
        m3362c();
        setChildrenDrawingOrderEnabled(true);
        this.f3184i = (int) (displayMetrics.density * 64.0f);
        this.f3191q = this.f3184i;
        this.f3193s = new C0301q(this);
        this.f3194t = new C0297m(this);
        setNestedScrollingEnabled(true);
        int i = -this.f3170M;
        this.f3178c = i;
        this.f3183h = i;
        m3370a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3157F);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f3164G >= 0) {
            if (i2 == i - 1) {
                return this.f3164G;
            }
            if (i2 >= this.f3164G) {
                return i2 + 1;
            }
            return i2;
        }
        return i2;
    }

    /* renamed from: c */
    private void m3362c() {
        this.f3180e = new C0449a(getContext());
        this.f3186k = new C0450b(getContext());
        this.f3186k.m3390a(1);
        this.f3180e.setImageDrawable(this.f3186k);
        this.f3180e.setVisibility(8);
        addView(this.f3180e);
    }

    public void setOnRefreshListener(InterfaceC0447b interfaceC0447b) {
        this.f3176a = interfaceC0447b;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.f3177b != z) {
            this.f3177b = z;
            if (!this.f3188m) {
                i = this.f3184i + this.f3183h;
            } else {
                i = this.f3184i;
            }
            setTargetOffsetTopAndBottom(i - this.f3178c);
            this.f3187l = false;
            m3361b(this.f3173P);
            return;
        }
        m3357a(z, false);
    }

    /* renamed from: b */
    private void m3361b(Animation.AnimationListener animationListener) {
        this.f3180e.setVisibility(0);
        this.f3186k.setAlpha(255);
        this.f3165H = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.f3165H.setDuration(this.f3199y);
        if (animationListener != null) {
            this.f3180e.m3379a(animationListener);
        }
        this.f3180e.clearAnimation();
        this.f3180e.startAnimation(this.f3165H);
    }

    void setAnimationProgress(float f2) {
        this.f3180e.setScaleX(f2);
        this.f3180e.setScaleY(f2);
    }

    /* renamed from: a */
    private void m3357a(boolean z, boolean z2) {
        if (this.f3177b != z) {
            this.f3187l = z2;
            m3368f();
            this.f3177b = z;
            if (this.f3177b) {
                m3355a(this.f3178c, this.f3173P);
            } else {
                m3372a(this.f3173P);
            }
        }
    }

    /* renamed from: a */
    void m3372a(Animation.AnimationListener animationListener) {
        this.f3166I = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.f3166I.setDuration(150L);
        this.f3180e.m3379a(animationListener);
        this.f3180e.clearAnimation();
        this.f3180e.startAnimation(this.f3166I);
    }

    /* renamed from: d */
    private void m3365d() {
        this.f3167J = m3354a(this.f3186k.getAlpha(), 76);
    }

    /* renamed from: e */
    private void m3367e() {
        this.f3168K = m3354a(this.f3186k.getAlpha(), 255);
    }

    /* renamed from: a */
    private Animation m3354a(final int i, final int i2) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.f3186k.setAlpha((int) (i + ((i2 - i) * f2)));
            }
        };
        animation.setDuration(300L);
        this.f3180e.m3379a(null);
        this.f3180e.clearAnimation();
        this.f3180e.startAnimation(animation);
        return animation;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(C0255a.m1855c(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f3180e.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = C0255a.m1855c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m3368f();
        this.f3186k.m3392a(iArr);
    }

    /* renamed from: f */
    private void m3368f() {
        if (this.f3189o == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f3180e)) {
                    this.f3189o = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f3191q = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f3189o == null) {
                m3368f();
            }
            if (this.f3189o != null) {
                View view = this.f3189o;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f3180e.getMeasuredWidth();
                this.f3180e.layout((measuredWidth / 2) - (measuredWidth2 / 2), this.f3178c, (measuredWidth / 2) + (measuredWidth2 / 2), this.f3178c + this.f3180e.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3189o == null) {
            m3368f();
        }
        if (this.f3189o != null) {
            this.f3189o.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f3180e.measure(View.MeasureSpec.makeMeasureSpec(this.f3170M, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f3170M, 1073741824));
            this.f3164G = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f3180e) {
                    this.f3164G = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f3170M;
    }

    /* renamed from: b */
    public boolean m3373b() {
        if (this.f3171N != null) {
            return this.f3171N.m3374a(this, this.f3189o);
        }
        if (this.f3189o instanceof ListView) {
            return C0337g.m2505b((ListView) this.f3189o, -1);
        }
        return this.f3189o.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(InterfaceC0446a interfaceC0446a) {
        this.f3171N = interfaceC0446a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m3368f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3162D && actionMasked == 0) {
            this.f3162D = false;
        }
        if (!isEnabled() || this.f3162D || m3373b() || this.f3177b || this.f3198x) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                setTargetOffsetTopAndBottom(this.f3183h - this.f3180e.getTop());
                this.f3161C = motionEvent.getPointerId(0);
                this.f3160B = false;
                int findPointerIndex = motionEvent.findPointerIndex(this.f3161C);
                if (findPointerIndex < 0) {
                    return false;
                }
                this.f3159A = motionEvent.getY(findPointerIndex);
                break;
            case 1:
            case 3:
                this.f3160B = false;
                this.f3161C = -1;
                break;
            case 2:
                if (this.f3161C == -1) {
                    Log.m184e(f3158n, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f3161C);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                m3366d(motionEvent.getY(findPointerIndex2));
                break;
            case 6:
                m3356a(motionEvent);
                break;
        }
        return this.f3160B;
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.f3172O = z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        if ((Build.VERSION.SDK_INT < 21 && (this.f3189o instanceof AbsListView)) || (this.f3189o != null && !C0308x.m2273t(this.f3189o))) {
            if (!this.f3172O && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(z);
                return;
            }
            return;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // androidx.core.p031f.InterfaceC0300p
    /* renamed from: a */
    public void mo998a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i5 == 0) {
            int i6 = iArr[1];
            m3371a(i, i2, i3, i4, this.f3196v, i5, iArr);
            int i7 = i4 - (iArr[1] - i6);
            if ((i7 == 0 ? this.f3196v[1] + i4 : i7) < 0 && !m3373b()) {
                this.f3192r = Math.abs(r0) + this.f3192r;
                m3359b(this.f3192r);
                iArr[1] = i7 + iArr[1];
            }
        }
    }

    @Override // androidx.core.p031f.InterfaceC0299o
    /* renamed from: a */
    public boolean mo1001a(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
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
        mo998a(view, i, i2, i3, i4, i5, this.f3197w);
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
        return (!isEnabled() || this.f3162D || this.f3177b || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f3193s.m2206a(view, view2, i);
        startNestedScroll(i & 2);
        this.f3192r = 0.0f;
        this.f3198x = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f3192r > 0.0f) {
            if (i2 > this.f3192r) {
                iArr[1] = (int) this.f3192r;
                this.f3192r = 0.0f;
            } else {
                this.f3192r -= i2;
                iArr[1] = i2;
            }
            m3359b(this.f3192r);
        }
        if (this.f3188m && i2 > 0 && this.f3192r == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f3180e.setVisibility(8);
        }
        int[] iArr2 = this.f3195u;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3193s.m2203a();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f3193s.m2204a(view);
        this.f3198x = false;
        if (this.f3192r > 0.0f) {
            m3363c(this.f3192r);
            this.f3192r = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo998a(view, i, i2, i3, i4, 0, this.f3197w);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    /* renamed from: a */
    public void m3371a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        if (i5 == 0) {
            this.f3194t.m2189a(i, i2, i3, i4, iArr, i5, iArr2);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f3194t.m2190a(z);
    }

    @Override // android.view.View, androidx.core.p031f.InterfaceC0294j
    public boolean isNestedScrollingEnabled() {
        return this.f3194t.m2191a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f3194t.m2200b(i);
    }

    @Override // android.view.View, androidx.core.p031f.InterfaceC0294j
    public void stopNestedScroll() {
        this.f3194t.m2201c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f3194t.m2199b();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f3194t.m2196a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f3194t.m2197a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f3194t.m2193a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f3194t.m2192a(f2, f3);
    }

    /* renamed from: a */
    private boolean m3358a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    /* renamed from: b */
    private void m3359b(float f2) {
        float f3;
        this.f3186k.m3391a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f3191q));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f3191q;
        if (this.f3185j > 0) {
            f3 = this.f3185j;
        } else {
            f3 = this.f3188m ? this.f3184i - this.f3183h : this.f3184i;
        }
        float max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3);
        float pow = ((float) ((max2 / 4.0f) - Math.pow(max2 / 4.0f, 2.0d))) * 2.0f;
        int i = ((int) ((f3 * min) + (f3 * pow * 2.0f))) + this.f3183h;
        if (this.f3180e.getVisibility() != 0) {
            this.f3180e.setVisibility(0);
        }
        if (!this.f3179d) {
            this.f3180e.setScaleX(1.0f);
            this.f3180e.setScaleY(1.0f);
        }
        if (this.f3179d) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f3191q));
        }
        if (f2 < this.f3191q) {
            if (this.f3186k.getAlpha() > 76 && !m3358a(this.f3167J)) {
                m3365d();
            }
        } else if (this.f3186k.getAlpha() < 255 && !m3358a(this.f3168K)) {
            m3367e();
        }
        this.f3186k.m3387a(0.0f, Math.min(0.8f, max * 0.8f));
        this.f3186k.m3393b(Math.min(1.0f, max));
        this.f3186k.m3394c(((-0.25f) + (max * 0.4f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.f3178c);
    }

    /* renamed from: c */
    private void m3363c(float f2) {
        if (f2 > this.f3191q) {
            m3357a(true, true);
            return;
        }
        this.f3177b = false;
        this.f3186k.m3387a(0.0f, 0.0f);
        Animation.AnimationListener animationListener = null;
        if (!this.f3179d) {
            animationListener = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f3179d) {
                        SwipeRefreshLayout.this.m3372a((Animation.AnimationListener) null);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            };
        }
        m3360b(this.f3178c, animationListener);
        this.f3186k.m3391a(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f3162D && actionMasked == 0) {
            this.f3162D = false;
        }
        if (!isEnabled() || this.f3162D || m3373b() || this.f3177b || this.f3198x) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.f3161C = motionEvent.getPointerId(0);
                this.f3160B = false;
                break;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.f3161C);
                if (findPointerIndex < 0) {
                    Log.m184e(f3158n, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f3160B) {
                    float y = (motionEvent.getY(findPointerIndex) - this.f3200z) * 0.5f;
                    this.f3160B = false;
                    m3363c(y);
                }
                this.f3161C = -1;
                return false;
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f3161C);
                if (findPointerIndex2 < 0) {
                    Log.m184e(f3158n, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                m3366d(y2);
                if (this.f3160B) {
                    float f2 = (y2 - this.f3200z) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    m3359b(f2);
                    break;
                }
                break;
            case 3:
                return false;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.m184e(f3158n, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f3161C = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                m3356a(motionEvent);
                break;
        }
        return true;
    }

    /* renamed from: d */
    private void m3366d(float f2) {
        if (f2 - this.f3159A > this.f3190p && !this.f3160B) {
            this.f3200z = this.f3159A + this.f3190p;
            this.f3160B = true;
            this.f3186k.setAlpha(76);
        }
    }

    /* renamed from: a */
    private void m3355a(int i, Animation.AnimationListener animationListener) {
        this.f3181f = i;
        this.f3174Q.reset();
        this.f3174Q.setDuration(200L);
        this.f3174Q.setInterpolator(this.f3163E);
        if (animationListener != null) {
            this.f3180e.m3379a(animationListener);
        }
        this.f3180e.clearAnimation();
        this.f3180e.startAnimation(this.f3174Q);
    }

    /* renamed from: b */
    private void m3360b(int i, Animation.AnimationListener animationListener) {
        if (this.f3179d) {
            m3364c(i, animationListener);
            return;
        }
        this.f3181f = i;
        this.f3175R.reset();
        this.f3175R.setDuration(200L);
        this.f3175R.setInterpolator(this.f3163E);
        if (animationListener != null) {
            this.f3180e.m3379a(animationListener);
        }
        this.f3180e.clearAnimation();
        this.f3180e.startAnimation(this.f3175R);
    }

    /* renamed from: a */
    void m3370a(float f2) {
        setTargetOffsetTopAndBottom((this.f3181f + ((int) ((this.f3183h - this.f3181f) * f2))) - this.f3180e.getTop());
    }

    /* renamed from: c */
    private void m3364c(int i, Animation.AnimationListener animationListener) {
        this.f3181f = i;
        this.f3182g = this.f3180e.getScaleX();
        this.f3169L = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f3182g + ((-SwipeRefreshLayout.this.f3182g) * f2));
                SwipeRefreshLayout.this.m3370a(f2);
            }
        };
        this.f3169L.setDuration(150L);
        if (animationListener != null) {
            this.f3180e.m3379a(animationListener);
        }
        this.f3180e.clearAnimation();
        this.f3180e.startAnimation(this.f3169L);
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.f3180e.bringToFront();
        C0308x.m2250c(this.f3180e, i);
        this.f3178c = this.f3180e.getTop();
    }

    /* renamed from: a */
    private void m3356a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3161C) {
            this.f3161C = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
