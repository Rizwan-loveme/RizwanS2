package androidx.drawerlayout.widget;

import android.C0012R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.p008os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.C0255a;
import androidx.core.graphics.C0312b;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p031f.C0271a;
import androidx.core.p031f.C0282af;
import androidx.core.p031f.C0289e;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.p032a.C0273b;
import androidx.core.p031f.p032a.InterfaceC0276e;
import androidx.drawerlayout.C0348a;
import androidx.p021c.p022a.AbstractC0223a;
import androidx.p021c.p023b.C0224a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: O */
    private static boolean f2376O;

    /* renamed from: b */
    static final boolean f2378b;

    /* renamed from: d */
    private static final boolean f2380d;

    /* renamed from: A */
    private Drawable f2381A;

    /* renamed from: B */
    private Drawable f2382B;

    /* renamed from: C */
    private Drawable f2383C;

    /* renamed from: D */
    private CharSequence f2384D;

    /* renamed from: E */
    private CharSequence f2385E;

    /* renamed from: F */
    private Object f2386F;

    /* renamed from: G */
    private boolean f2387G;

    /* renamed from: H */
    private Drawable f2388H;

    /* renamed from: I */
    private Drawable f2389I;

    /* renamed from: J */
    private Drawable f2390J;

    /* renamed from: K */
    private Drawable f2391K;

    /* renamed from: L */
    private final ArrayList<View> f2392L;

    /* renamed from: M */
    private Rect f2393M;

    /* renamed from: N */
    private Matrix f2394N;

    /* renamed from: P */
    private final InterfaceC0276e f2395P;

    /* renamed from: e */
    private final C0352b f2396e;

    /* renamed from: f */
    private float f2397f;

    /* renamed from: g */
    private int f2398g;

    /* renamed from: h */
    private int f2399h;

    /* renamed from: i */
    private float f2400i;

    /* renamed from: j */
    private Paint f2401j;

    /* renamed from: k */
    private final C0224a f2402k;

    /* renamed from: l */
    private final C0224a f2403l;

    /* renamed from: m */
    private final C0356f f2404m;

    /* renamed from: n */
    private final C0356f f2405n;

    /* renamed from: o */
    private int f2406o;

    /* renamed from: p */
    private boolean f2407p;

    /* renamed from: q */
    private boolean f2408q;

    /* renamed from: r */
    private int f2409r;

    /* renamed from: s */
    private int f2410s;

    /* renamed from: t */
    private int f2411t;

    /* renamed from: u */
    private int f2412u;

    /* renamed from: v */
    private boolean f2413v;

    /* renamed from: w */
    private InterfaceC0353c f2414w;

    /* renamed from: x */
    private List<InterfaceC0353c> f2415x;

    /* renamed from: y */
    private float f2416y;

    /* renamed from: z */
    private float f2417z;

    /* renamed from: c */
    private static final int[] f2379c = {C0012R.attr.colorPrimaryDark};

    /* renamed from: a */
    static final int[] f2377a = {C0012R.attr.layout_gravity};

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$c */
    public interface InterfaceC0353c {
        /* renamed from: a */
        void mo2587a(int i);

        /* renamed from: a */
        void mo2588a(View view, float f2);

        void onDrawerClosed(View view);

        void onDrawerOpened(View view);
    }

    static {
        f2378b = Build.VERSION.SDK_INT >= 19;
        f2380d = Build.VERSION.SDK_INT >= 21;
        f2376O = Build.VERSION.SDK_INT >= 29;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0348a.a.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2396e = new C0352b();
        this.f2399h = -1728053248;
        this.f2401j = new Paint();
        this.f2408q = true;
        this.f2409r = 3;
        this.f2410s = 3;
        this.f2411t = 3;
        this.f2412u = 3;
        this.f2388H = null;
        this.f2389I = null;
        this.f2390J = null;
        this.f2391K = null;
        this.f2395P = new InterfaceC0276e() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            @Override // androidx.core.p031f.p032a.InterfaceC0276e
            /* renamed from: a */
            public boolean mo2047a(View view, InterfaceC0276e.a aVar) {
                if (!DrawerLayout.this.m2583j(view) || DrawerLayout.this.m2551a(view) == 2) {
                    return false;
                }
                DrawerLayout.this.m2582i(view);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f2398g = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        this.f2404m = new C0356f(3);
        this.f2405n = new C0356f(5);
        this.f2402k = C0224a.m1624a(this, 1.0f, this.f2404m);
        this.f2402k.m1644a(1);
        this.f2402k.m1643a(f3);
        this.f2404m.m2594a(this.f2402k);
        this.f2403l = C0224a.m1624a(this, 1.0f, this.f2405n);
        this.f2403l.m1644a(2);
        this.f2403l.m1643a(f3);
        this.f2405n.m2594a(this.f2403l);
        setFocusableInTouchMode(true);
        C0308x.m2227a((View) this, 1);
        C0308x.m2236a(this, new C0351a());
        setMotionEventSplittingEnabled(false);
        if (C0308x.m2268o(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).m2559a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2379c);
                try {
                    this.f2381A = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f2381A = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C0348a.c.DrawerLayout, i, 0);
        try {
            if (obtainStyledAttributes2.hasValue(C0348a.c.DrawerLayout_elevation)) {
                this.f2397f = obtainStyledAttributes2.getDimension(C0348a.c.DrawerLayout_elevation, 0.0f);
            } else {
                this.f2397f = getResources().getDimension(C0348a.b.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.f2392L = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setDrawerElevation(float f2) {
        this.f2397f = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m2580g(childAt)) {
                C0308x.m2226a(childAt, this.f2397f);
            }
        }
    }

    public float getDrawerElevation() {
        if (f2380d) {
            return this.f2397f;
        }
        return 0.0f;
    }

    /* renamed from: a */
    public void m2559a(Object obj, boolean z) {
        this.f2386F = obj;
        this.f2387G = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.f2399h = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(InterfaceC0353c interfaceC0353c) {
        if (this.f2414w != null) {
            m2568b(this.f2414w);
        }
        if (interfaceC0353c != null) {
            m2558a(interfaceC0353c);
        }
        this.f2414w = interfaceC0353c;
    }

    /* renamed from: a */
    public void m2558a(InterfaceC0353c interfaceC0353c) {
        if (interfaceC0353c != null) {
            if (this.f2415x == null) {
                this.f2415x = new ArrayList();
            }
            this.f2415x.add(interfaceC0353c);
        }
    }

    /* renamed from: b */
    public void m2568b(InterfaceC0353c interfaceC0353c) {
        if (interfaceC0353c != null && this.f2415x != null) {
            this.f2415x.remove(interfaceC0353c);
        }
    }

    public void setDrawerLockMode(int i) {
        m2553a(i, 3);
        m2553a(i, 5);
    }

    /* renamed from: a */
    public void m2553a(int i, int i2) {
        int m2167a = C0289e.m2167a(i2, C0308x.m2257f(this));
        switch (i2) {
            case 3:
                this.f2409r = i;
                break;
            case 5:
                this.f2410s = i;
                break;
            case Gravity.START /* 8388611 */:
                this.f2411t = i;
                break;
            case Gravity.END /* 8388613 */:
                this.f2412u = i;
                break;
        }
        if (i != 0) {
            (m2167a == 3 ? this.f2402k : this.f2403l).m1664f();
        }
        switch (i) {
            case 1:
                View m2570c = m2570c(m2167a);
                if (m2570c != null) {
                    m2582i(m2570c);
                    break;
                }
                break;
            case 2:
                View m2570c2 = m2570c(m2167a);
                if (m2570c2 != null) {
                    m2581h(m2570c2);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0008 A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m2550a(int i) {
        int m2257f = C0308x.m2257f(this);
        switch (i) {
            case 3:
                if (this.f2409r != 3) {
                    return this.f2409r;
                }
                int i2 = m2257f == 0 ? this.f2411t : this.f2412u;
                if (i2 != 3) {
                    return i2;
                }
                return 0;
            case 5:
                if (this.f2410s != 3) {
                    return this.f2410s;
                }
                int i3 = m2257f == 0 ? this.f2412u : this.f2411t;
                if (i3 != 3) {
                    return i3;
                }
                break;
            case Gravity.START /* 8388611 */:
                if (this.f2411t != 3) {
                    return this.f2411t;
                }
                int i4 = m2257f == 0 ? this.f2409r : this.f2410s;
                if (i4 != 3) {
                    return i4;
                }
                break;
            case Gravity.END /* 8388613 */:
                if (this.f2412u != 3) {
                    return this.f2412u;
                }
                int i5 = m2257f == 0 ? this.f2410s : this.f2409r;
                if (i5 != 3) {
                    return i5;
                }
                break;
        }
    }

    /* renamed from: a */
    public int m2551a(View view) {
        if (!m2580g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return m2550a(((C0354d) view.getLayoutParams()).f2422a);
    }

    /* renamed from: b */
    public CharSequence m2562b(int i) {
        int m2167a = C0289e.m2167a(i, C0308x.m2257f(this));
        if (m2167a == 3) {
            return this.f2384D;
        }
        if (m2167a == 5) {
            return this.f2385E;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m2537a(float f2, float f3, View view) {
        if (this.f2393M == null) {
            this.f2393M = new Rect();
        }
        view.getHitRect(this.f2393M);
        return this.f2393M.contains((int) f2, (int) f3);
    }

    /* renamed from: a */
    private boolean m2538a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent m2539b = m2539b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(m2539b);
            m2539b.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    /* renamed from: b */
    private MotionEvent m2539b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f2394N == null) {
                this.f2394N = new Matrix();
            }
            matrix.invert(this.f2394N);
            obtain.transform(this.f2394N);
        }
        return obtain;
    }

    /* renamed from: a */
    void m2554a(int i, View view) {
        int i2;
        int m1642a = this.f2402k.m1642a();
        int m1642a2 = this.f2403l.m1642a();
        if (m1642a == 1 || m1642a2 == 1) {
            i2 = 1;
        } else {
            i2 = (m1642a == 2 || m1642a2 == 2) ? 2 : 0;
        }
        if (view != null && i == 0) {
            C0354d c0354d = (C0354d) view.getLayoutParams();
            if (c0354d.f2423b == 0.0f) {
                m2565b(view);
            } else if (c0354d.f2423b == 1.0f) {
                m2571c(view);
            }
        }
        if (i2 != this.f2406o) {
            this.f2406o = i2;
            if (this.f2415x != null) {
                for (int size = this.f2415x.size() - 1; size >= 0; size--) {
                    this.f2415x.get(size).mo2587a(i2);
                }
            }
        }
    }

    /* renamed from: b */
    void m2565b(View view) {
        View rootView;
        C0354d c0354d = (C0354d) view.getLayoutParams();
        if ((c0354d.f2425d & 1) == 1) {
            c0354d.f2425d = 0;
            if (this.f2415x != null) {
                for (int size = this.f2415x.size() - 1; size >= 0; size--) {
                    this.f2415x.get(size).onDrawerClosed(view);
                }
            }
            m2540c(view, false);
            m2548m(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* renamed from: c */
    void m2571c(View view) {
        C0354d c0354d = (C0354d) view.getLayoutParams();
        if ((c0354d.f2425d & 1) == 0) {
            c0354d.f2425d = 1;
            if (this.f2415x != null) {
                for (int size = this.f2415x.size() - 1; size >= 0; size--) {
                    this.f2415x.get(size).onDrawerOpened(view);
                }
            }
            m2540c(view, true);
            m2548m(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* renamed from: c */
    private void m2540c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !m2580g(childAt)) || (z && childAt == view)) {
                C0308x.m2227a(childAt, 1);
            } else {
                C0308x.m2227a(childAt, 4);
            }
        }
    }

    /* renamed from: m */
    private void m2548m(View view) {
        C0308x.m2246b(view, C0273b.a.f2111u.m2035a());
        if (m2583j(view) && m2551a(view) != 2) {
            C0308x.m2235a(view, C0273b.a.f2111u, null, this.f2395P);
        }
    }

    /* renamed from: a */
    void m2556a(View view, float f2) {
        if (this.f2415x != null) {
            for (int size = this.f2415x.size() - 1; size >= 0; size--) {
                this.f2415x.get(size).mo2588a(view, f2);
            }
        }
    }

    /* renamed from: b */
    void m2566b(View view, float f2) {
        C0354d c0354d = (C0354d) view.getLayoutParams();
        if (f2 != c0354d.f2423b) {
            c0354d.f2423b = f2;
            m2556a(view, f2);
        }
    }

    /* renamed from: d */
    float m2573d(View view) {
        return ((C0354d) view.getLayoutParams()).f2423b;
    }

    /* renamed from: e */
    int m2575e(View view) {
        return C0289e.m2167a(((C0354d) view.getLayoutParams()).f2422a, C0308x.m2257f(this));
    }

    /* renamed from: a */
    boolean m2561a(View view, int i) {
        return (m2575e(view) & i) == i;
    }

    /* renamed from: a */
    View m2552a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0354d) childAt.getLayoutParams()).f2425d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: c */
    void m2572c(View view, float f2) {
        float m2573d = m2573d(view);
        int width = view.getWidth();
        int i = ((int) (width * f2)) - ((int) (m2573d * width));
        if (!m2561a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m2566b(view, f2);
    }

    /* renamed from: c */
    View m2570c(int i) {
        int m2167a = C0289e.m2167a(i, C0308x.m2257f(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m2575e(childAt) & 7) == m2167a) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    static String m2541d(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2408q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2408q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int childCount;
        int i5;
        boolean z;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    i3 = 300;
                    i4 = size;
                    setMeasuredDimension(i4, i3);
                    boolean z2 = this.f2386F == null && C0308x.m2268o(this);
                    int m2257f = C0308x.m2257f(this);
                    boolean z3 = false;
                    boolean z4 = false;
                    childCount = getChildCount();
                    for (i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() != 8) {
                            C0354d c0354d = (C0354d) childAt.getLayoutParams();
                            if (z2) {
                                int m2167a = C0289e.m2167a(c0354d.f2422a, m2257f);
                                if (C0308x.m2268o(childAt)) {
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        WindowInsets windowInsets = (WindowInsets) this.f2386F;
                                        if (m2167a == 3) {
                                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                                        } else if (m2167a == 5) {
                                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                        }
                                        childAt.dispatchApplyWindowInsets(windowInsets);
                                    }
                                } else if (Build.VERSION.SDK_INT >= 21) {
                                    WindowInsets windowInsets2 = (WindowInsets) this.f2386F;
                                    if (m2167a == 3) {
                                        windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                                    } else if (m2167a == 5) {
                                        windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                                    }
                                    c0354d.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                                    c0354d.topMargin = windowInsets2.getSystemWindowInsetTop();
                                    c0354d.rightMargin = windowInsets2.getSystemWindowInsetRight();
                                    c0354d.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                                }
                            }
                            if (m2578f(childAt)) {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec((i4 - c0354d.leftMargin) - c0354d.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((i3 - c0354d.topMargin) - c0354d.bottomMargin, 1073741824));
                            } else if (m2580g(childAt)) {
                                if (f2380d && C0308x.m2264k(childAt) != this.f2397f) {
                                    C0308x.m2226a(childAt, this.f2397f);
                                }
                                int m2575e = m2575e(childAt) & 7;
                                boolean z5 = m2575e == 3;
                                if ((z5 && z3) || (!z5 && z4)) {
                                    throw new IllegalStateException("Child drawer has absolute gravity " + m2541d(m2575e) + " but this DrawerLayout already has a drawer view along that edge");
                                }
                                if (z5) {
                                    z3 = true;
                                    z = z4;
                                } else {
                                    z = true;
                                }
                                childAt.measure(getChildMeasureSpec(i, this.f2398g + c0354d.leftMargin + c0354d.rightMargin, c0354d.width), getChildMeasureSpec(i2, c0354d.topMargin + c0354d.bottomMargin, c0354d.height));
                                z4 = z;
                            } else {
                                throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        i3 = size2;
        i4 = size;
        setMeasuredDimension(i4, i3);
        if (this.f2386F == null) {
        }
        int m2257f2 = C0308x.m2257f(this);
        boolean z32 = false;
        boolean z42 = false;
        childCount = getChildCount();
        while (i5 < childCount) {
        }
    }

    /* renamed from: e */
    private void m2542e() {
        if (!f2380d) {
            this.f2382B = m2543f();
            this.f2383C = m2544g();
        }
    }

    /* renamed from: f */
    private Drawable m2543f() {
        int m2257f = C0308x.m2257f(this);
        if (m2257f == 0) {
            if (this.f2388H != null) {
                m2536a(this.f2388H, m2257f);
                return this.f2388H;
            }
        } else if (this.f2389I != null) {
            m2536a(this.f2389I, m2257f);
            return this.f2389I;
        }
        return this.f2390J;
    }

    /* renamed from: g */
    private Drawable m2544g() {
        int m2257f = C0308x.m2257f(this);
        if (m2257f == 0) {
            if (this.f2389I != null) {
                m2536a(this.f2389I, m2257f);
                return this.f2389I;
            }
        } else if (this.f2388H != null) {
            m2536a(this.f2388H, m2257f);
            return this.f2388H;
        }
        return this.f2391K;
    }

    /* renamed from: a */
    private void m2536a(Drawable drawable, int i) {
        if (drawable != null && C0315a.m2364b(drawable)) {
            C0315a.m2365b(drawable, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        int i5;
        float f2;
        this.f2407p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C0354d c0354d = (C0354d) childAt.getLayoutParams();
                if (m2578f(childAt)) {
                    childAt.layout(c0354d.leftMargin, c0354d.topMargin, c0354d.leftMargin + childAt.getMeasuredWidth(), c0354d.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m2561a(childAt, 3)) {
                        i5 = ((int) (measuredWidth * c0354d.f2423b)) + (-measuredWidth);
                        f2 = (measuredWidth + i5) / measuredWidth;
                    } else {
                        i5 = i6 - ((int) (measuredWidth * c0354d.f2423b));
                        f2 = (i6 - i5) / measuredWidth;
                    }
                    boolean z2 = f2 != c0354d.f2423b;
                    switch (c0354d.f2422a & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            int i9 = (i8 - measuredHeight) / 2;
                            if (i9 < c0354d.topMargin) {
                                i9 = c0354d.topMargin;
                            } else if (i9 + measuredHeight > i8 - c0354d.bottomMargin) {
                                i9 = (i8 - c0354d.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
                            break;
                        case 80:
                            int i10 = i4 - i2;
                            childAt.layout(i5, (i10 - c0354d.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i10 - c0354d.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, c0354d.topMargin, measuredWidth + i5, measuredHeight + c0354d.topMargin);
                            break;
                    }
                    if (z2) {
                        m2566b(childAt, f2);
                    }
                    int i11 = c0354d.f2423b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        if (f2376O && (rootWindowInsets = getRootWindowInsets()) != null) {
            C0312b m2088k = C0282af.m2067a(rootWindowInsets).m2088k();
            this.f2402k.m1651b(Math.max(this.f2402k.m1656c(), m2088k.f2236b));
            this.f2403l.m1651b(Math.max(this.f2403l.m1656c(), m2088k.f2238d));
        }
        this.f2407p = false;
        this.f2408q = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f2407p) {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f2 = Math.max(f2, ((C0354d) getChildAt(i).getLayoutParams()).f2423b);
        }
        this.f2400i = f2;
        boolean m1649a = this.f2402k.m1649a(true);
        boolean m1649a2 = this.f2403l.m1649a(true);
        if (m1649a || m1649a2) {
            C0308x.m2249c(this);
        }
    }

    /* renamed from: n */
    private static boolean m2549n(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2381A = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2381A;
    }

    public void setStatusBarBackground(int i) {
        this.f2381A = i != 0 ? C0255a.m1847a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f2381A = new ColorDrawable(i);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        m2542e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f2387G && this.f2381A != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                i = this.f2386F != null ? ((WindowInsets) this.f2386F).getSystemWindowInsetTop() : 0;
            } else {
                i = 0;
            }
            if (i > 0) {
                this.f2381A.setBounds(0, 0, getWidth(), i);
                this.f2381A.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean m2578f = m2578f(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (m2578f) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0 && m2549n(childAt) && m2580g(childAt) && childAt.getHeight() >= height) {
                    if (m2561a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right <= i) {
                            right = i;
                        }
                        i = right;
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        int i3 = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f2400i > 0.0f && m2578f) {
            this.f2401j.setColor((((int) (((this.f2399h & (-16777216)) >>> 24) * this.f2400i)) << 24) | (this.f2399h & 16777215));
            canvas.drawRect(i, 0.0f, i3, getHeight(), this.f2401j);
        } else if (this.f2382B != null && m2561a(view, 3)) {
            int intrinsicWidth = this.f2382B.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f2402k.m1650b(), 1.0f));
            this.f2382B.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f2382B.setAlpha((int) (255.0f * max));
            this.f2382B.draw(canvas);
        } else if (this.f2383C != null && m2561a(view, 5)) {
            int intrinsicWidth2 = this.f2383C.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2403l.m1650b(), 1.0f));
            this.f2383C.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f2383C.setAlpha((int) (255.0f * max2));
            this.f2383C.draw(canvas);
        }
        return drawChild;
    }

    /* renamed from: f */
    boolean m2578f(View view) {
        return ((C0354d) view.getLayoutParams()).f2422a == 0;
    }

    /* renamed from: g */
    boolean m2580g(View view) {
        int m2167a = C0289e.m2167a(((C0354d) view.getLayoutParams()).f2422a, C0308x.m2257f(view));
        return ((m2167a & 3) == 0 && (m2167a & 5) == 0) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View m1660d;
        int actionMasked = motionEvent.getActionMasked();
        boolean m1647a = this.f2402k.m1647a(motionEvent) | this.f2403l.m1647a(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f2416y = x;
                this.f2417z = y;
                z = this.f2400i > 0.0f && (m1660d = this.f2402k.m1660d((int) x, (int) y)) != null && m2578f(m1660d);
                this.f2413v = false;
                break;
            case 1:
            case 3:
                m2560a(true);
                this.f2413v = false;
                z = false;
                break;
            case 2:
                if (this.f2402k.m1663e(3)) {
                    this.f2404m.m2593a();
                    this.f2405n.m2593a();
                    z = false;
                    break;
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        return m1647a || z || m2545h() || this.f2413v;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2400i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            for (int i = childCount - 1; i >= 0; i--) {
                View childAt = getChildAt(i);
                if (m2537a(x, y, childAt) && !m2578f(childAt) && m2538a(motionEvent, childAt)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0015, code lost:
    
        return true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View m2552a;
        boolean z = false;
        this.f2402k.m1652b(motionEvent);
        this.f2403l.m1652b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f2416y = x;
                this.f2417z = y;
                this.f2413v = false;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View m1660d = this.f2402k.m1660d((int) x2, (int) y2);
                if (m1660d != null && m2578f(m1660d)) {
                    float f2 = x2 - this.f2416y;
                    float f3 = y2 - this.f2417z;
                    int m1662e = this.f2402k.m1662e();
                    if ((f2 * f2) + (f3 * f3) < m1662e * m1662e && (m2552a = m2552a()) != null) {
                        if (m2551a(m2552a) == 2) {
                            z = true;
                        }
                        m2560a(z);
                        break;
                    }
                }
                z = true;
                m2560a(z);
                break;
            case 3:
                m2560a(true);
                this.f2413v = false;
                break;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            m2560a(true);
        }
    }

    /* renamed from: b */
    public void m2563b() {
        m2560a(false);
    }

    /* renamed from: a */
    void m2560a(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0354d c0354d = (C0354d) childAt.getLayoutParams();
            if (m2580g(childAt) && (!z || c0354d.f2424c)) {
                int width = childAt.getWidth();
                if (m2561a(childAt, 3)) {
                    z2 |= this.f2402k.m1648a(childAt, -width, childAt.getTop());
                } else {
                    z2 |= this.f2403l.m1648a(childAt, getWidth(), childAt.getTop());
                }
                c0354d.f2424c = false;
            }
        }
        this.f2404m.m2593a();
        this.f2405n.m2593a();
        if (z2) {
            invalidate();
        }
    }

    /* renamed from: h */
    public void m2581h(View view) {
        m2557a(view, true);
    }

    /* renamed from: a */
    public void m2557a(View view, boolean z) {
        if (!m2580g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        C0354d c0354d = (C0354d) view.getLayoutParams();
        if (this.f2408q) {
            c0354d.f2423b = 1.0f;
            c0354d.f2425d = 1;
            m2540c(view, true);
            m2548m(view);
        } else if (z) {
            c0354d.f2425d |= 2;
            if (m2561a(view, 3)) {
                this.f2402k.m1648a(view, 0, view.getTop());
            } else {
                this.f2403l.m1648a(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            m2572c(view, 1.0f);
            m2554a(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    /* renamed from: e */
    public void m2576e(int i) {
        m2555a(i, true);
    }

    /* renamed from: a */
    public void m2555a(int i, boolean z) {
        View m2570c = m2570c(i);
        if (m2570c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2541d(i));
        }
        m2557a(m2570c, z);
    }

    /* renamed from: i */
    public void m2582i(View view) {
        m2567b(view, true);
    }

    /* renamed from: b */
    public void m2567b(View view, boolean z) {
        if (!m2580g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        C0354d c0354d = (C0354d) view.getLayoutParams();
        if (this.f2408q) {
            c0354d.f2423b = 0.0f;
            c0354d.f2425d = 0;
        } else if (z) {
            c0354d.f2425d |= 4;
            if (m2561a(view, 3)) {
                this.f2402k.m1648a(view, -view.getWidth(), view.getTop());
            } else {
                this.f2403l.m1648a(view, getWidth(), view.getTop());
            }
        } else {
            m2572c(view, 0.0f);
            m2554a(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    /* renamed from: f */
    public void m2577f(int i) {
        m2564b(i, true);
    }

    /* renamed from: b */
    public void m2564b(int i, boolean z) {
        View m2570c = m2570c(i);
        if (m2570c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + m2541d(i));
        }
        m2567b(m2570c, z);
    }

    /* renamed from: j */
    public boolean m2583j(View view) {
        if (m2580g(view)) {
            return (((C0354d) view.getLayoutParams()).f2425d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: g */
    public boolean m2579g(int i) {
        View m2570c = m2570c(i);
        if (m2570c != null) {
            return m2583j(m2570c);
        }
        return false;
    }

    /* renamed from: k */
    public boolean m2584k(View view) {
        if (m2580g(view)) {
            return ((C0354d) view.getLayoutParams()).f2423b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* renamed from: h */
    private boolean m2545h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0354d) getChildAt(i).getLayoutParams()).f2424c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0354d(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0354d) {
            return new C0354d((C0354d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0354d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0354d(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0354d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0354d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (m2580g(childAt)) {
                    if (m2583j(childAt)) {
                        z = true;
                        childAt.addFocusables(arrayList, i, i2);
                    }
                } else {
                    this.f2392L.add(childAt);
                }
            }
            if (!z) {
                int size = this.f2392L.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.f2392L.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f2392L.clear();
        }
    }

    /* renamed from: i */
    private boolean m2546i() {
        return m2569c() != null;
    }

    /* renamed from: c */
    View m2569c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2580g(childAt) && m2584k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: d */
    void m2574d() {
        if (!this.f2413v) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f2413v = true;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2546i()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View m2569c = m2569c();
            if (m2569c != null && m2551a(m2569c) == 0) {
                m2563b();
            }
            return m2569c != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View m2570c;
        if (!(parcelable instanceof C0355e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0355e c0355e = (C0355e) parcelable;
        super.onRestoreInstanceState(c0355e.m1617a());
        if (c0355e.f2426a != 0 && (m2570c = m2570c(c0355e.f2426a)) != null) {
            m2581h(m2570c);
        }
        if (c0355e.f2427b != 3) {
            m2553a(c0355e.f2427b, 3);
        }
        if (c0355e.f2428d != 3) {
            m2553a(c0355e.f2428d, 5);
        }
        if (c0355e.f2429e != 3) {
            m2553a(c0355e.f2429e, Gravity.START);
        }
        if (c0355e.f2430f != 3) {
            m2553a(c0355e.f2430f, Gravity.END);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0355e c0355e = new C0355e(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0354d c0354d = (C0354d) getChildAt(i).getLayoutParams();
            boolean z = c0354d.f2425d == 1;
            boolean z2 = c0354d.f2425d == 2;
            if (z || z2) {
                c0355e.f2426a = c0354d.f2422a;
                break;
            }
        }
        c0355e.f2427b = this.f2409r;
        c0355e.f2428d = this.f2410s;
        c0355e.f2429e = this.f2411t;
        c0355e.f2430f = this.f2412u;
        return c0355e;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m2552a() != null || m2580g(view)) {
            C0308x.m2227a(view, 4);
        } else {
            C0308x.m2227a(view, 1);
        }
        if (!f2378b) {
            C0308x.m2236a(view, this.f2396e);
        }
    }

    /* renamed from: l */
    static boolean m2547l(View view) {
        return (C0308x.m2251d(view) == 4 || C0308x.m2251d(view) == 2) ? false : true;
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$e */
    protected static class C0355e extends AbstractC0223a {
        public static final Parcelable.Creator<C0355e> CREATOR = new Parcelable.ClassLoaderCreator<C0355e>() { // from class: androidx.drawerlayout.widget.DrawerLayout.e.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0355e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0355e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0355e createFromParcel(Parcel parcel) {
                return new C0355e(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0355e[] newArray(int i) {
                return new C0355e[i];
            }
        };

        /* renamed from: a */
        int f2426a;

        /* renamed from: b */
        int f2427b;

        /* renamed from: d */
        int f2428d;

        /* renamed from: e */
        int f2429e;

        /* renamed from: f */
        int f2430f;

        public C0355e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2426a = 0;
            this.f2426a = parcel.readInt();
            this.f2427b = parcel.readInt();
            this.f2428d = parcel.readInt();
            this.f2429e = parcel.readInt();
            this.f2430f = parcel.readInt();
        }

        public C0355e(Parcelable parcelable) {
            super(parcelable);
            this.f2426a = 0;
        }

        @Override // androidx.p021c.p022a.AbstractC0223a, android.p008os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2426a);
            parcel.writeInt(this.f2427b);
            parcel.writeInt(this.f2428d);
            parcel.writeInt(this.f2429e);
            parcel.writeInt(this.f2430f);
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$f */
    private class C0356f extends C0224a.a {

        /* renamed from: b */
        private final int f2432b;

        /* renamed from: c */
        private C0224a f2433c;

        /* renamed from: d */
        private final Runnable f2434d = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.f.1
            @Override // java.lang.Runnable
            public void run() {
                C0356f.this.m2595b();
            }
        };

        C0356f(int i) {
            this.f2432b = i;
        }

        /* renamed from: a */
        public void m2594a(C0224a c0224a) {
            this.f2433c = c0224a;
        }

        /* renamed from: a */
        public void m2593a() {
            DrawerLayout.this.removeCallbacks(this.f2434d);
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: b */
        public boolean mo1676b(View view, int i) {
            return DrawerLayout.this.m2580g(view) && DrawerLayout.this.m2561a(view, this.f2432b) && DrawerLayout.this.m2551a(view) == 0;
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public void mo1667a(int i) {
            DrawerLayout.this.m2554a(i, this.f2433c.m1659d());
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public void mo1671a(View view, int i, int i2, int i3, int i4) {
            float width;
            int width2 = view.getWidth();
            if (DrawerLayout.this.m2561a(view, 3)) {
                width = (width2 + i) / width2;
            } else {
                width = (DrawerLayout.this.getWidth() - i) / width2;
            }
            DrawerLayout.this.m2566b(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public void mo1670a(View view, int i) {
            ((C0354d) view.getLayoutParams()).f2424c = false;
            m2592c();
        }

        /* renamed from: c */
        private void m2592c() {
            View m2570c = DrawerLayout.this.m2570c(this.f2432b == 3 ? 5 : 3);
            if (m2570c != null) {
                DrawerLayout.this.m2582i(m2570c);
            }
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public void mo1669a(View view, float f2, float f3) {
            int width;
            float m2573d = DrawerLayout.this.m2573d(view);
            int width2 = view.getWidth();
            if (DrawerLayout.this.m2561a(view, 3)) {
                width = (f2 > 0.0f || (f2 == 0.0f && m2573d > 0.5f)) ? 0 : -width2;
            } else {
                width = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && m2573d > 0.5f)) {
                    width -= width2;
                }
            }
            this.f2433c.m1646a(width, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public void mo1668a(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f2434d, 160L);
        }

        /* renamed from: b */
        void m2595b() {
            View m2570c;
            int width;
            int m1650b = this.f2433c.m1650b();
            boolean z = this.f2432b == 3;
            if (z) {
                m2570c = DrawerLayout.this.m2570c(3);
                width = (m2570c != null ? -m2570c.getWidth() : 0) + m1650b;
            } else {
                m2570c = DrawerLayout.this.m2570c(5);
                width = DrawerLayout.this.getWidth() - m1650b;
            }
            if (m2570c != null) {
                if (((z && m2570c.getLeft() < width) || (!z && m2570c.getLeft() > width)) && DrawerLayout.this.m2551a(m2570c) == 0) {
                    C0354d c0354d = (C0354d) m2570c.getLayoutParams();
                    this.f2433c.m1648a(m2570c, width, m2570c.getTop());
                    c0354d.f2424c = true;
                    DrawerLayout.this.invalidate();
                    m2592c();
                    DrawerLayout.this.m2574d();
                }
            }
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: b */
        public boolean mo1675b(int i) {
            return false;
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: b */
        public void mo1674b(int i, int i2) {
            View m2570c;
            if ((i & 1) == 1) {
                m2570c = DrawerLayout.this.m2570c(3);
            } else {
                m2570c = DrawerLayout.this.m2570c(5);
            }
            if (m2570c != null && DrawerLayout.this.m2551a(m2570c) == 0) {
                this.f2433c.m1645a(m2570c, i2);
            }
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public int mo1665a(View view) {
            if (DrawerLayout.this.m2580g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: a */
        public int mo1666a(View view, int i, int i2) {
            if (DrawerLayout.this.m2561a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // androidx.p021c.p023b.C0224a.a
        /* renamed from: b */
        public int mo1673b(View view, int i, int i2) {
            return view.getTop();
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$d */
    public static class C0354d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f2422a;

        /* renamed from: b */
        float f2423b;

        /* renamed from: c */
        boolean f2424c;

        /* renamed from: d */
        int f2425d;

        public C0354d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2422a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2377a);
            this.f2422a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C0354d(int i, int i2) {
            super(i, i2);
            this.f2422a = 0;
        }

        public C0354d(C0354d c0354d) {
            super((ViewGroup.MarginLayoutParams) c0354d);
            this.f2422a = 0;
            this.f2422a = c0354d.f2422a;
        }

        public C0354d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2422a = 0;
        }

        public C0354d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2422a = 0;
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$a */
    class C0351a extends C0271a {

        /* renamed from: b */
        private final Rect f2421b = new Rect();

        C0351a() {
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public void mo1969a(View view, C0273b c0273b) {
            if (DrawerLayout.f2378b) {
                super.mo1969a(view, c0273b);
            } else {
                C0273b m1977a = C0273b.m1977a(c0273b);
                super.mo1969a(view, m1977a);
                c0273b.m1991a(view);
                Object m2259g = C0308x.m2259g(view);
                if (m2259g instanceof View) {
                    c0273b.m2004c((View) m2259g);
                }
                m2586a(c0273b, m1977a);
                m1977a.m2031s();
                m2585a(c0273b, (ViewGroup) view);
            }
            c0273b.m2000b("androidx.drawerlayout.widget.DrawerLayout");
            c0273b.m1995a(false);
            c0273b.m2001b(false);
            c0273b.m2002b(C0273b.a.f2091a);
            c0273b.m2002b(C0273b.a.f2092b);
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: d */
        public void mo1974d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo1974d(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: b */
        public boolean mo1972b(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.mo1972b(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View m2569c = DrawerLayout.this.m2569c();
            if (m2569c != null) {
                CharSequence m2562b = DrawerLayout.this.m2562b(DrawerLayout.this.m2575e(m2569c));
                if (m2562b != null) {
                    text.add(m2562b);
                }
            }
            return true;
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public boolean mo1971a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2378b || DrawerLayout.m2547l(view)) {
                return super.mo1971a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        /* renamed from: a */
        private void m2585a(C0273b c0273b, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m2547l(childAt)) {
                    c0273b.m1999b(childAt);
                }
            }
        }

        /* renamed from: a */
        private void m2586a(C0273b c0273b, C0273b c0273b2) {
            Rect rect = this.f2421b;
            c0273b2.m1998b(rect);
            c0273b.m2003c(rect);
            c0273b.m2005c(c0273b2.m2017g());
            c0273b.m1993a(c0273b2.m2027o());
            c0273b.m2000b(c0273b2.m2028p());
            c0273b.m2007d(c0273b2.m2030r());
            c0273b.m2014f(c0273b2.m2024l());
            c0273b.m2001b(c0273b2.m2015f());
            c0273b.m2008d(c0273b2.m2019h());
            c0273b.m2011e(c0273b2.m2021i());
            c0273b.m1989a(c0273b2.m1997b());
        }
    }

    /* renamed from: androidx.drawerlayout.widget.DrawerLayout$b */
    static final class C0352b extends C0271a {
        C0352b() {
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public void mo1969a(View view, C0273b c0273b) {
            super.mo1969a(view, c0273b);
            if (!DrawerLayout.m2547l(view)) {
                c0273b.m2004c((View) null);
            }
        }
    }
}
