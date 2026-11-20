package androidx.p044h.p045a;

import android.C0012R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.p008os.Bundle;
import android.p008os.Parcel;
import android.p008os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.C0255a;
import androidx.core.p031f.C0271a;
import androidx.core.p031f.C0282af;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.InterfaceC0302r;
import androidx.core.p031f.p032a.C0273b;
import androidx.p021c.p022a.AbstractC0223a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: ViewPager.java */
/* renamed from: androidx.h.a.b */
/* loaded from: classes.dex */
public class C0406b extends ViewGroup {

    /* renamed from: A */
    private int f3033A;

    /* renamed from: B */
    private boolean f3034B;

    /* renamed from: C */
    private boolean f3035C;

    /* renamed from: D */
    private int f3036D;

    /* renamed from: E */
    private int f3037E;

    /* renamed from: F */
    private int f3038F;

    /* renamed from: G */
    private float f3039G;

    /* renamed from: H */
    private float f3040H;

    /* renamed from: I */
    private float f3041I;

    /* renamed from: J */
    private float f3042J;

    /* renamed from: K */
    private int f3043K;

    /* renamed from: L */
    private VelocityTracker f3044L;

    /* renamed from: M */
    private int f3045M;

    /* renamed from: N */
    private int f3046N;

    /* renamed from: O */
    private int f3047O;

    /* renamed from: P */
    private int f3048P;

    /* renamed from: Q */
    private boolean f3049Q;

    /* renamed from: R */
    private EdgeEffect f3050R;

    /* renamed from: S */
    private EdgeEffect f3051S;

    /* renamed from: T */
    private boolean f3052T;

    /* renamed from: U */
    private boolean f3053U;

    /* renamed from: V */
    private boolean f3054V;

    /* renamed from: W */
    private int f3055W;

    /* renamed from: aa */
    private List<f> f3056aa;

    /* renamed from: ab */
    private f f3057ab;

    /* renamed from: ac */
    private f f3058ac;

    /* renamed from: ad */
    private List<e> f3059ad;

    /* renamed from: ae */
    private g f3060ae;

    /* renamed from: af */
    private int f3061af;

    /* renamed from: ag */
    private int f3062ag;

    /* renamed from: ah */
    private ArrayList<View> f3063ah;

    /* renamed from: aj */
    private final Runnable f3064aj;

    /* renamed from: ak */
    private int f3065ak;

    /* renamed from: b */
    AbstractC0405a f3066b;

    /* renamed from: c */
    int f3067c;

    /* renamed from: d */
    private int f3068d;

    /* renamed from: g */
    private final ArrayList<b> f3069g;

    /* renamed from: h */
    private final b f3070h;

    /* renamed from: i */
    private final Rect f3071i;

    /* renamed from: j */
    private int f3072j;

    /* renamed from: k */
    private Parcelable f3073k;

    /* renamed from: l */
    private ClassLoader f3074l;

    /* renamed from: m */
    private Scroller f3075m;

    /* renamed from: n */
    private boolean f3076n;

    /* renamed from: o */
    private h f3077o;

    /* renamed from: p */
    private int f3078p;

    /* renamed from: q */
    private Drawable f3079q;

    /* renamed from: r */
    private int f3080r;

    /* renamed from: s */
    private int f3081s;

    /* renamed from: t */
    private float f3082t;

    /* renamed from: u */
    private float f3083u;

    /* renamed from: v */
    private int f3084v;

    /* renamed from: w */
    private int f3085w;

    /* renamed from: x */
    private boolean f3086x;

    /* renamed from: y */
    private boolean f3087y;

    /* renamed from: z */
    private boolean f3088z;

    /* renamed from: a */
    static final int[] f3029a = {C0012R.attr.layout_gravity};

    /* renamed from: e */
    private static final Comparator<b> f3031e = new Comparator<b>() { // from class: androidx.h.a.b.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f3093b - bVar2.f3093b;
        }
    };

    /* renamed from: f */
    private static final Interpolator f3032f = new Interpolator() { // from class: androidx.h.a.b.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: ai */
    private static final j f3030ai = new j();

    /* compiled from: ViewPager.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: androidx.h.a.b$a */
    public @interface a {
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$e */
    public interface e {
        /* renamed from: a */
        void mo100a(C0406b c0406b, AbstractC0405a abstractC0405a, AbstractC0405a abstractC0405a2);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$f */
    public interface f {
        /* renamed from: a */
        void mo130a(int i);

        /* renamed from: a */
        void mo131a(int i, float f2, int i2);

        /* renamed from: b */
        void mo132b(int i);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$g */
    public interface g {
        /* renamed from: a */
        void m3337a(View view, float f2);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$b */
    static class b {

        /* renamed from: a */
        Object f3092a;

        /* renamed from: b */
        int f3093b;

        /* renamed from: c */
        boolean f3094c;

        /* renamed from: d */
        float f3095d;

        /* renamed from: e */
        float f3096e;

        b() {
        }
    }

    public C0406b(Context context) {
        super(context);
        this.f3069g = new ArrayList<>();
        this.f3070h = new b();
        this.f3071i = new Rect();
        this.f3072j = -1;
        this.f3073k = null;
        this.f3074l = null;
        this.f3082t = -3.4028235E38f;
        this.f3083u = Float.MAX_VALUE;
        this.f3033A = 1;
        this.f3043K = -1;
        this.f3052T = true;
        this.f3053U = false;
        this.f3064aj = new Runnable() { // from class: androidx.h.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                C0406b.this.setScrollState(0);
                C0406b.this.m3331c();
            }
        };
        this.f3065ak = 0;
        m3315a();
    }

    public C0406b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3069g = new ArrayList<>();
        this.f3070h = new b();
        this.f3071i = new Rect();
        this.f3072j = -1;
        this.f3073k = null;
        this.f3074l = null;
        this.f3082t = -3.4028235E38f;
        this.f3083u = Float.MAX_VALUE;
        this.f3033A = 1;
        this.f3043K = -1;
        this.f3052T = true;
        this.f3053U = false;
        this.f3064aj = new Runnable() { // from class: androidx.h.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                C0406b.this.setScrollState(0);
                C0406b.this.m3331c();
            }
        };
        this.f3065ak = 0;
        m3315a();
    }

    /* renamed from: a */
    void m3315a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f3075m = new Scroller(context, f3032f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f3038F = viewConfiguration.getScaledPagingTouchSlop();
        this.f3045M = (int) (400.0f * f2);
        this.f3046N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3050R = new EdgeEffect(context);
        this.f3051S = new EdgeEffect(context);
        this.f3047O = (int) (25.0f * f2);
        this.f3048P = (int) (2.0f * f2);
        this.f3036D = (int) (16.0f * f2);
        C0308x.m2236a(this, new d());
        if (C0308x.m2251d(this) == 0) {
            C0308x.m2227a((View) this, 1);
        }
        C0308x.m2237a(this, new InterfaceC0302r() { // from class: androidx.h.a.b.4

            /* renamed from: b */
            private final Rect f3091b = new Rect();

            @Override // androidx.core.p031f.InterfaceC0302r
            /* renamed from: a */
            public C0282af mo552a(View view, C0282af c0282af) {
                C0282af m2222a = C0308x.m2222a(view, c0282af);
                if (!m2222a.m2082e()) {
                    Rect rect = this.f3091b;
                    rect.left = m2222a.m2070a();
                    rect.top = m2222a.m2077b();
                    rect.right = m2222a.m2080c();
                    rect.bottom = m2222a.m2081d();
                    int childCount = C0406b.this.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        C0282af m2244b = C0308x.m2244b(C0406b.this.getChildAt(i2), m2222a);
                        rect.left = Math.min(m2244b.m2070a(), rect.left);
                        rect.top = Math.min(m2244b.m2077b(), rect.top);
                        rect.right = Math.min(m2244b.m2080c(), rect.right);
                        rect.bottom = Math.min(m2244b.m2081d(), rect.bottom);
                    }
                    return m2222a.m2071a(rect.left, rect.top, rect.right, rect.bottom);
                }
                return m2222a;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f3064aj);
        if (this.f3075m != null && !this.f3075m.isFinished()) {
            this.f3075m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i2) {
        if (this.f3065ak != i2) {
            this.f3065ak = i2;
            if (this.f3060ae != null) {
                m3300b(i2 != 0);
            }
            m3307f(i2);
        }
    }

    public void setAdapter(AbstractC0405a abstractC0405a) {
        if (this.f3066b != null) {
            this.f3066b.m3290c(null);
            this.f3066b.m3279a((ViewGroup) this);
            for (int i2 = 0; i2 < this.f3069g.size(); i2++) {
                b bVar = this.f3069g.get(i2);
                this.f3066b.mo3280a((ViewGroup) this, bVar.f3093b, bVar.f3092a);
            }
            this.f3066b.m3287b((ViewGroup) this);
            this.f3069g.clear();
            m3306f();
            this.f3067c = 0;
            scrollTo(0, 0);
        }
        AbstractC0405a abstractC0405a2 = this.f3066b;
        this.f3066b = abstractC0405a;
        this.f3068d = 0;
        if (this.f3066b != null) {
            if (this.f3077o == null) {
                this.f3077o = new h();
            }
            this.f3066b.m3290c(this.f3077o);
            this.f3088z = false;
            boolean z = this.f3052T;
            this.f3052T = true;
            this.f3068d = this.f3066b.mo3270a();
            if (this.f3072j >= 0) {
                this.f3066b.m3276a(this.f3073k, this.f3074l);
                m3320a(this.f3072j, false, true);
                this.f3072j = -1;
                this.f3073k = null;
                this.f3074l = null;
            } else if (!z) {
                m3331c();
            } else {
                requestLayout();
            }
        }
        if (this.f3059ad != null && !this.f3059ad.isEmpty()) {
            int size = this.f3059ad.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f3059ad.get(i3).mo100a(this, abstractC0405a2, abstractC0405a);
            }
        }
    }

    /* renamed from: f */
    private void m3306f() {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < getChildCount()) {
                if (!((c) getChildAt(i3).getLayoutParams()).f3097a) {
                    removeViewAt(i3);
                    i3--;
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public AbstractC0405a getAdapter() {
        return this.f3066b;
    }

    /* renamed from: a */
    public void m3322a(e eVar) {
        if (this.f3059ad == null) {
            this.f3059ad = new ArrayList();
        }
        this.f3059ad.add(eVar);
    }

    /* renamed from: b */
    public void m3329b(e eVar) {
        if (this.f3059ad != null) {
            this.f3059ad.remove(eVar);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i2) {
        this.f3088z = false;
        m3320a(i2, !this.f3052T, false);
    }

    /* renamed from: a */
    public void m3319a(int i2, boolean z) {
        this.f3088z = false;
        m3320a(i2, z, false);
    }

    public int getCurrentItem() {
        return this.f3067c;
    }

    /* renamed from: a */
    void m3320a(int i2, boolean z, boolean z2) {
        m3321a(i2, z, z2, 0);
    }

    /* renamed from: a */
    void m3321a(int i2, boolean z, boolean z2, int i3) {
        if (this.f3066b == null || this.f3066b.mo3270a() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f3067c == i2 && this.f3069g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.f3066b.mo3270a()) {
            i2 = this.f3066b.mo3270a() - 1;
        }
        int i4 = this.f3033A;
        if (i2 > this.f3067c + i4 || i2 < this.f3067c - i4) {
            for (int i5 = 0; i5 < this.f3069g.size(); i5++) {
                this.f3069g.get(i5).f3094c = true;
            }
        }
        boolean z3 = this.f3067c != i2;
        if (this.f3052T) {
            this.f3067c = i2;
            if (z3) {
                m3305e(i2);
            }
            requestLayout();
            return;
        }
        m3316a(i2);
        m3294a(i2, z, i3, z3);
    }

    /* renamed from: a */
    private void m3294a(int i2, boolean z, int i3, boolean z2) {
        int i4;
        b m3326b = m3326b(i2);
        if (m3326b != null) {
            i4 = (int) (Math.max(this.f3082t, Math.min(m3326b.f3096e, this.f3083u)) * getClientWidth());
        } else {
            i4 = 0;
        }
        if (z) {
            m3318a(i4, 0, i3);
            if (z2) {
                m3305e(i2);
                return;
            }
            return;
        }
        if (z2) {
            m3305e(i2);
        }
        m3297a(false);
        scrollTo(i4, 0);
        m3304d(i4);
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.f3057ab = fVar;
    }

    /* renamed from: a */
    public void m3323a(f fVar) {
        if (this.f3056aa == null) {
            this.f3056aa = new ArrayList();
        }
        this.f3056aa.add(fVar);
    }

    /* renamed from: b */
    public void m3330b(f fVar) {
        if (this.f3056aa != null) {
            this.f3056aa.remove(fVar);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.f3062ag == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.f3063ah.get(i3).getLayoutParams()).f3102f;
    }

    public int getOffscreenPageLimit() {
        return this.f3033A;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.m190w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.f3033A) {
            this.f3033A = i2;
            m3331c();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.f3078p;
        this.f3078p = i2;
        int width = getWidth();
        m3293a(width, width, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f3078p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f3079q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(C0255a.m1847a(getContext(), i2));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3079q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3079q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    float m3312a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    /* renamed from: a */
    void m3318a(int i2, int i3, int i4) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.f3075m == null || this.f3075m.isFinished()) ? false : true) {
            int currX = this.f3076n ? this.f3075m.getCurrX() : this.f3075m.getStartX();
            this.f3075m.abortAnimation();
            setScrollingCacheEnabled(false);
            scrollX = currX;
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m3297a(false);
            m3331c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float m3312a = (i7 * m3312a(Math.min(1.0f, (Math.abs(i5) * 1.0f) / clientWidth))) + i7;
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(1000.0f * Math.abs(m3312a / abs2)) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((clientWidth * this.f3066b.m3282b(this.f3067c)) + this.f3078p)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.f3076n = false;
        this.f3075m.startScroll(scrollX, scrollY, i5, i6, min);
        C0308x.m2249c(this);
    }

    /* renamed from: a */
    b m3313a(int i2, int i3) {
        b bVar = new b();
        bVar.f3093b = i2;
        bVar.f3092a = this.f3066b.mo3274a((ViewGroup) this, i2);
        bVar.f3095d = this.f3066b.m3282b(i2);
        if (i3 < 0 || i3 >= this.f3069g.size()) {
            this.f3069g.add(bVar);
        } else {
            this.f3069g.add(i3, bVar);
        }
        return bVar;
    }

    /* renamed from: b */
    void m3328b() {
        int mo3270a = this.f3066b.mo3270a();
        this.f3068d = mo3270a;
        boolean z = this.f3069g.size() < (this.f3033A * 2) + 1 && this.f3069g.size() < mo3270a;
        int i2 = this.f3067c;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = z;
        while (i3 < this.f3069g.size()) {
            b bVar = this.f3069g.get(i3);
            int mo3271a = this.f3066b.mo3271a(bVar.f3092a);
            if (mo3271a != -1) {
                if (mo3271a == -2) {
                    this.f3069g.remove(i3);
                    i3--;
                    if (!z2) {
                        this.f3066b.m3279a((ViewGroup) this);
                        z2 = true;
                    }
                    this.f3066b.mo3280a((ViewGroup) this, bVar.f3093b, bVar.f3092a);
                    if (this.f3067c == bVar.f3093b) {
                        i2 = Math.max(0, Math.min(this.f3067c, mo3270a - 1));
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                } else if (bVar.f3093b != mo3271a) {
                    if (bVar.f3093b == this.f3067c) {
                        i2 = mo3271a;
                    }
                    bVar.f3093b = mo3271a;
                    z3 = true;
                }
            }
            i3++;
        }
        if (z2) {
            this.f3066b.m3287b((ViewGroup) this);
        }
        Collections.sort(this.f3069g, f3031e);
        if (z3) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                c cVar = (c) getChildAt(i4).getLayoutParams();
                if (!cVar.f3097a) {
                    cVar.f3099c = 0.0f;
                }
            }
            m3320a(i2, false, true);
            requestLayout();
        }
    }

    /* renamed from: c */
    void m3331c() {
        m3316a(this.f3067c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c6, code lost:
    
        if (r0.f3093b == r13.f3067c) goto L28;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m3316a(int i2) {
        b bVar;
        String hexString;
        int i3;
        b bVar2;
        b m3314a;
        int i4;
        if (this.f3067c == i2) {
            bVar = null;
        } else {
            b m3326b = m3326b(this.f3067c);
            this.f3067c = i2;
            bVar = m3326b;
        }
        if (this.f3066b == null) {
            m3308g();
            return;
        }
        if (this.f3088z) {
            m3308g();
            return;
        }
        if (getWindowToken() != null) {
            this.f3066b.m3279a((ViewGroup) this);
            int i5 = this.f3033A;
            int max = Math.max(0, this.f3067c - i5);
            int mo3270a = this.f3066b.mo3270a();
            int min = Math.min(mo3270a - 1, i5 + this.f3067c);
            if (mo3270a != this.f3068d) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e2) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f3068d + ", found: " + mo3270a + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f3066b.getClass());
            }
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (i3 >= this.f3069g.size()) {
                    break;
                }
                bVar2 = this.f3069g.get(i3);
                if (bVar2.f3093b < this.f3067c) {
                    i6 = i3 + 1;
                }
            }
            bVar2 = null;
            b m3313a = (bVar2 != null || mo3270a <= 0) ? bVar2 : m3313a(this.f3067c, i3);
            if (m3313a != null) {
                float f2 = 0.0f;
                int i7 = i3 - 1;
                b bVar3 = i7 >= 0 ? this.f3069g.get(i7) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - m3313a.f3095d) + (getPaddingLeft() / clientWidth);
                int i8 = this.f3067c - 1;
                int i9 = i3;
                while (i8 >= 0) {
                    if (f2 >= paddingLeft && i8 < max) {
                        if (bVar3 == null) {
                            break;
                        }
                        if (i8 != bVar3.f3093b || bVar3.f3094c) {
                            i4 = i7;
                        } else {
                            this.f3069g.remove(i7);
                            this.f3066b.mo3280a((ViewGroup) this, i8, bVar3.f3092a);
                            i4 = i7 - 1;
                            int i10 = i9 - 1;
                            bVar3 = i4 >= 0 ? this.f3069g.get(i4) : null;
                            i9 = i10;
                        }
                    } else if (bVar3 != null && i8 == bVar3.f3093b) {
                        f2 += bVar3.f3095d;
                        i4 = i7 - 1;
                        bVar3 = i4 >= 0 ? this.f3069g.get(i4) : null;
                    } else {
                        f2 += m3313a(i8, i7 + 1).f3095d;
                        i9++;
                        bVar3 = i7 >= 0 ? this.f3069g.get(i7) : null;
                        i4 = i7;
                    }
                    i8--;
                    i7 = i4;
                }
                float f3 = m3313a.f3095d;
                int i11 = i9 + 1;
                if (f3 < 2.0f) {
                    b bVar4 = i11 < this.f3069g.size() ? this.f3069g.get(i11) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    b bVar5 = bVar4;
                    for (int i12 = this.f3067c + 1; i12 < mo3270a; i12++) {
                        if (f3 >= paddingRight && i12 > min) {
                            if (bVar5 == null) {
                                break;
                            }
                            if (i12 == bVar5.f3093b && !bVar5.f3094c) {
                                this.f3069g.remove(i11);
                                this.f3066b.mo3280a((ViewGroup) this, i12, bVar5.f3092a);
                                bVar5 = i11 < this.f3069g.size() ? this.f3069g.get(i11) : null;
                            }
                        } else if (bVar5 != null && i12 == bVar5.f3093b) {
                            f3 += bVar5.f3095d;
                            i11++;
                            bVar5 = i11 < this.f3069g.size() ? this.f3069g.get(i11) : null;
                        } else {
                            b m3313a2 = m3313a(i12, i11);
                            i11++;
                            f3 += m3313a2.f3095d;
                            bVar5 = i11 < this.f3069g.size() ? this.f3069g.get(i11) : null;
                        }
                    }
                }
                m3296a(m3313a, i9, bVar);
                this.f3066b.m3288b((ViewGroup) this, this.f3067c, m3313a.f3092a);
            }
            this.f3066b.m3287b((ViewGroup) this);
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                c cVar = (c) childAt.getLayoutParams();
                cVar.f3102f = i13;
                if (!cVar.f3097a && cVar.f3099c == 0.0f && (m3314a = m3314a(childAt)) != null) {
                    cVar.f3099c = m3314a.f3095d;
                    cVar.f3101e = m3314a.f3093b;
                }
            }
            m3308g();
            if (hasFocus()) {
                View findFocus = findFocus();
                b m3327b = findFocus != null ? m3327b(findFocus) : null;
                if (m3327b == null || m3327b.f3093b != this.f3067c) {
                    for (int i14 = 0; i14 < getChildCount(); i14++) {
                        View childAt2 = getChildAt(i14);
                        b m3314a2 = m3314a(childAt2);
                        if (m3314a2 != null && m3314a2.f3093b == this.f3067c && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: g */
    private void m3308g() {
        if (this.f3062ag != 0) {
            if (this.f3063ah == null) {
                this.f3063ah = new ArrayList<>();
            } else {
                this.f3063ah.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f3063ah.add(getChildAt(i2));
            }
            Collections.sort(this.f3063ah, f3030ai);
        }
    }

    /* renamed from: a */
    private void m3296a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int mo3270a = this.f3066b.mo3270a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.f3078p / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.f3093b;
            if (i3 < bVar.f3093b) {
                float f3 = bVar2.f3096e + bVar2.f3095d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.f3093b && i5 < this.f3069g.size()) {
                    b bVar5 = this.f3069g.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.f3093b || i5 >= this.f3069g.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.f3069g.get(i5);
                    }
                    while (i4 < bVar4.f3093b) {
                        f3 += this.f3066b.m3282b(i4) + f2;
                        i4++;
                    }
                    bVar4.f3096e = f3;
                    f3 += bVar4.f3095d + f2;
                    i4++;
                }
            } else if (i3 > bVar.f3093b) {
                int size = this.f3069g.size() - 1;
                float f4 = bVar2.f3096e;
                int i6 = i3 - 1;
                while (i6 >= bVar.f3093b && size >= 0) {
                    b bVar6 = this.f3069g.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i6 >= bVar3.f3093b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.f3069g.get(size);
                    }
                    while (i6 > bVar3.f3093b) {
                        f4 -= this.f3066b.m3282b(i6) + f2;
                        i6--;
                    }
                    f4 -= bVar3.f3095d + f2;
                    bVar3.f3096e = f4;
                    i6--;
                }
            }
        }
        int size2 = this.f3069g.size();
        float f5 = bVar.f3096e;
        int i7 = bVar.f3093b - 1;
        this.f3082t = bVar.f3093b == 0 ? bVar.f3096e : -3.4028235E38f;
        this.f3083u = bVar.f3093b == mo3270a + (-1) ? (bVar.f3096e + bVar.f3095d) - 1.0f : Float.MAX_VALUE;
        for (int i8 = i2 - 1; i8 >= 0; i8--) {
            b bVar7 = this.f3069g.get(i8);
            float f6 = f5;
            while (i7 > bVar7.f3093b) {
                f6 -= this.f3066b.m3282b(i7) + f2;
                i7--;
            }
            f5 = f6 - (bVar7.f3095d + f2);
            bVar7.f3096e = f5;
            if (bVar7.f3093b == 0) {
                this.f3082t = f5;
            }
            i7--;
        }
        float f7 = bVar.f3096e + bVar.f3095d + f2;
        int i9 = bVar.f3093b + 1;
        for (int i10 = i2 + 1; i10 < size2; i10++) {
            b bVar8 = this.f3069g.get(i10);
            float f8 = f7;
            while (i9 < bVar8.f3093b) {
                f8 += this.f3066b.m3282b(i9) + f2;
                i9++;
            }
            if (bVar8.f3093b == mo3270a - 1) {
                this.f3083u = (bVar8.f3095d + f8) - 1.0f;
            }
            bVar8.f3096e = f8;
            f7 = f8 + bVar8.f3095d + f2;
            i9++;
        }
        this.f3053U = false;
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$i */
    public static class i extends AbstractC0223a {
        public static final Parcelable.Creator<i> CREATOR = new Parcelable.ClassLoaderCreator<i>() { // from class: androidx.h.a.b.i.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i) {
                return new i[i];
            }
        };

        /* renamed from: a */
        int f3105a;

        /* renamed from: b */
        Parcelable f3106b;

        /* renamed from: d */
        ClassLoader f3107d;

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.p021c.p022a.AbstractC0223a, android.p008os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3105a);
            parcel.writeParcelable(this.f3106b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3105a + "}";
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f3105a = parcel.readInt();
            this.f3106b = parcel.readParcelable(classLoader);
            this.f3107d = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f3105a = this.f3067c;
        if (this.f3066b != null) {
            iVar.f3106b = this.f3066b.m3283b();
        }
        return iVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.m1617a());
        if (this.f3066b != null) {
            this.f3066b.m3276a(iVar.f3106b, iVar.f3107d);
            m3320a(iVar.f3105a, false, true);
        } else {
            this.f3072j = iVar.f3105a;
            this.f3073k = iVar.f3106b;
            this.f3074l = iVar.f3107d;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        c cVar = (c) generateLayoutParams;
        cVar.f3097a |= m3303c(view);
        if (this.f3086x) {
            if (cVar != null && cVar.f3097a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.f3100d = true;
            addViewInLayout(view, i2, generateLayoutParams);
            return;
        }
        super.addView(view, i2, generateLayoutParams);
    }

    /* renamed from: c */
    private static boolean m3303c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f3086x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* renamed from: a */
    b m3314a(View view) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f3069g.size()) {
                b bVar = this.f3069g.get(i3);
                if (!this.f3066b.mo3281a(view, bVar.f3092a)) {
                    i2 = i3 + 1;
                } else {
                    return bVar;
                }
            } else {
                return null;
            }
        }
    }

    /* renamed from: b */
    b m3327b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return m3314a(view);
            }
        }
        return null;
    }

    /* renamed from: b */
    b m3326b(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < this.f3069g.size()) {
                b bVar = this.f3069g.get(i4);
                if (bVar.f3093b != i2) {
                    i3 = i4 + 1;
                } else {
                    return bVar;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3052T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.f3037E = Math.min(measuredWidth / 10, this.f3036D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f3097a) {
                int i8 = cVar2.f3098b & 7;
                int i9 = cVar2.f3098b & 112;
                int i10 = Integer.MIN_VALUE;
                int i11 = Integer.MIN_VALUE;
                boolean z = i9 == 48 || i9 == 80;
                boolean z2 = i8 == 3 || i8 == 5;
                if (z) {
                    i10 = 1073741824;
                } else if (z2) {
                    i11 = 1073741824;
                }
                if (cVar2.width != -2) {
                    i5 = 1073741824;
                    i4 = cVar2.width != -1 ? cVar2.width : paddingLeft;
                } else {
                    i4 = paddingLeft;
                    i5 = i10;
                }
                if (cVar2.height != -2) {
                    i11 = 1073741824;
                    if (cVar2.height != -1) {
                        i6 = cVar2.height;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i5), View.MeasureSpec.makeMeasureSpec(i6, i11));
                        if (!z) {
                            measuredHeight -= childAt.getMeasuredHeight();
                        } else if (z2) {
                            paddingLeft -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i6 = measuredHeight;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i5), View.MeasureSpec.makeMeasureSpec(i6, i11));
                if (!z) {
                }
            }
        }
        this.f3084v = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f3085w = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f3086x = true;
        m3331c();
        this.f3086x = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f3097a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (cVar.f3099c * paddingLeft), 1073741824), this.f3085w);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            m3293a(i2, i4, this.f3078p, this.f3078p);
        }
    }

    /* renamed from: a */
    private void m3293a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.f3069g.isEmpty()) {
            if (!this.f3075m.isFinished()) {
                this.f3075m.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            scrollTo((int) ((((i2 - getPaddingLeft()) - getPaddingRight()) + i4) * (getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))), getScrollY());
            return;
        }
        b m3326b = m3326b(this.f3067c);
        int min = (int) ((m3326b != null ? Math.min(m3326b.f3096e, this.f3083u) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (min != getScrollX()) {
            m3297a(false);
            scrollTo(min, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b m3314a;
        int i6;
        int i7;
        int i8;
        int measuredWidth;
        int measuredHeight;
        int i9;
        int childCount = getChildCount();
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i12 = 0;
        int i13 = 0;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f3097a) {
                    int i14 = cVar.f3098b & 7;
                    int i15 = cVar.f3098b & 112;
                    switch (i14) {
                        case 1:
                            measuredWidth = Math.max((i10 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i7 = paddingRight;
                            i8 = paddingLeft;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            i7 = paddingRight;
                            i8 = paddingLeft;
                            break;
                        case 3:
                            i8 = paddingLeft + childAt.getMeasuredWidth();
                            measuredWidth = paddingLeft;
                            i7 = paddingRight;
                            break;
                        case 5:
                            measuredWidth = (i10 - paddingRight) - childAt.getMeasuredWidth();
                            i7 = paddingRight + childAt.getMeasuredWidth();
                            i8 = paddingLeft;
                            break;
                    }
                    switch (i15) {
                        case 16:
                            measuredHeight = Math.max((i11 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i9 = paddingTop;
                            break;
                        case 48:
                            i9 = paddingTop + childAt.getMeasuredHeight();
                            measuredHeight = paddingTop;
                            break;
                        case 80:
                            measuredHeight = (i11 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            i9 = paddingTop;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            i9 = paddingTop;
                            break;
                    }
                    int i16 = measuredWidth + scrollX;
                    childAt.layout(i16, measuredHeight, childAt.getMeasuredWidth() + i16, childAt.getMeasuredHeight() + measuredHeight);
                    i6 = i12 + 1;
                    paddingTop = i9;
                    i13++;
                    i12 = i6;
                    paddingRight = i7;
                    paddingLeft = i8;
                }
            }
            i6 = i12;
            i7 = paddingRight;
            i8 = paddingLeft;
            i13++;
            i12 = i6;
            paddingRight = i7;
            paddingLeft = i8;
        }
        int i17 = (i10 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f3097a && (m3314a = m3314a(childAt2)) != null) {
                    int i19 = ((int) (m3314a.f3096e * i17)) + paddingLeft;
                    if (cVar2.f3100d) {
                        cVar2.f3100d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (cVar2.f3099c * i17), 1073741824), View.MeasureSpec.makeMeasureSpec((i11 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.f3080r = paddingTop;
        this.f3081s = i11 - paddingBottom;
        this.f3055W = i12;
        if (this.f3052T) {
            m3294a(this.f3067c, false, 0, false);
        }
        this.f3052T = false;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f3076n = true;
        if (!this.f3075m.isFinished() && this.f3075m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f3075m.getCurrX();
            int currY = this.f3075m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m3304d(currX)) {
                    this.f3075m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            C0308x.m2249c(this);
            return;
        }
        m3297a(true);
    }

    /* renamed from: d */
    private boolean m3304d(int i2) {
        if (this.f3069g.size() == 0) {
            if (this.f3052T) {
                return false;
            }
            this.f3054V = false;
            m3317a(0, 0.0f, 0);
            if (this.f3054V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b m3310i = m3310i();
        int clientWidth = getClientWidth();
        int i3 = this.f3078p + clientWidth;
        int i4 = m3310i.f3093b;
        float f2 = ((i2 / clientWidth) - m3310i.f3096e) / (m3310i.f3095d + (this.f3078p / clientWidth));
        this.f3054V = false;
        m3317a(i4, f2, (int) (i3 * f2));
        if (!this.f3054V) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    /* renamed from: a */
    protected void m3317a(int i2, float f2, int i3) {
        int measuredWidth;
        int i4;
        if (this.f3055W > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f3097a) {
                    switch (cVar.f3098b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingLeft;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            i4 = paddingLeft;
                            break;
                        case 3:
                            i4 = paddingLeft + childAt.getWidth();
                            measuredWidth = paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            i4 = paddingLeft;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    i4 = paddingLeft;
                }
                i5++;
                paddingLeft = i4;
            }
        }
        m3299b(i2, f2, i3);
        if (this.f3060ae != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((c) childAt2.getLayoutParams()).f3097a) {
                    this.f3060ae.m3337a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.f3054V = true;
    }

    /* renamed from: b */
    private void m3299b(int i2, float f2, int i3) {
        if (this.f3057ab != null) {
            this.f3057ab.mo131a(i2, f2, i3);
        }
        if (this.f3056aa != null) {
            int size = this.f3056aa.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.f3056aa.get(i4);
                if (fVar != null) {
                    fVar.mo131a(i2, f2, i3);
                }
            }
        }
        if (this.f3058ac != null) {
            this.f3058ac.mo131a(i2, f2, i3);
        }
    }

    /* renamed from: e */
    private void m3305e(int i2) {
        if (this.f3057ab != null) {
            this.f3057ab.mo132b(i2);
        }
        if (this.f3056aa != null) {
            int size = this.f3056aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.f3056aa.get(i3);
                if (fVar != null) {
                    fVar.mo132b(i2);
                }
            }
        }
        if (this.f3058ac != null) {
            this.f3058ac.mo132b(i2);
        }
    }

    /* renamed from: f */
    private void m3307f(int i2) {
        if (this.f3057ab != null) {
            this.f3057ab.mo130a(i2);
        }
        if (this.f3056aa != null) {
            int size = this.f3056aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.f3056aa.get(i3);
                if (fVar != null) {
                    fVar.mo130a(i2);
                }
            }
        }
        if (this.f3058ac != null) {
            this.f3058ac.mo130a(i2);
        }
    }

    /* renamed from: a */
    private void m3297a(boolean z) {
        boolean z2 = this.f3065ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f3075m.isFinished()) {
                this.f3075m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f3075m.getCurrX();
                int currY = this.f3075m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m3304d(currX);
                    }
                }
            }
        }
        this.f3088z = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.f3069g.size(); i2++) {
            b bVar = this.f3069g.get(i2);
            if (bVar.f3094c) {
                bVar.f3094c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                C0308x.m2239a(this, this.f3064aj);
            } else {
                this.f3064aj.run();
            }
        }
    }

    /* renamed from: a */
    private boolean m3298a(float f2, float f3) {
        return (f2 < ((float) this.f3037E) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.f3037E)) && f3 < 0.0f);
    }

    /* renamed from: b */
    private void m3300b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.f3061af : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m3309h();
            return false;
        }
        if (action != 0) {
            if (this.f3034B) {
                return true;
            }
            if (this.f3035C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f3041I = x;
                this.f3039G = x;
                float y = motionEvent.getY();
                this.f3042J = y;
                this.f3040H = y;
                this.f3043K = motionEvent.getPointerId(0);
                this.f3035C = false;
                this.f3076n = true;
                this.f3075m.computeScrollOffset();
                if (this.f3065ak == 2 && Math.abs(this.f3075m.getFinalX() - this.f3075m.getCurrX()) > this.f3048P) {
                    this.f3075m.abortAnimation();
                    this.f3088z = false;
                    m3331c();
                    this.f3034B = true;
                    m3302c(true);
                    setScrollState(1);
                    break;
                } else {
                    m3297a(false);
                    this.f3034B = false;
                    break;
                }
            case 2:
                int i2 = this.f3043K;
                if (i2 != -1) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float f2 = x2 - this.f3039G;
                    float abs = Math.abs(f2);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float abs2 = Math.abs(y2 - this.f3042J);
                    if (f2 != 0.0f && !m3298a(this.f3039G, f2) && m3325a(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.f3039G = x2;
                        this.f3040H = y2;
                        this.f3035C = true;
                        return false;
                    }
                    if (abs > this.f3038F && 0.5f * abs > abs2) {
                        this.f3034B = true;
                        m3302c(true);
                        setScrollState(1);
                        this.f3039G = f2 > 0.0f ? this.f3041I + this.f3038F : this.f3041I - this.f3038F;
                        this.f3040H = y2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.f3038F) {
                        this.f3035C = true;
                    }
                    if (this.f3034B && m3301b(x2)) {
                        C0308x.m2249c(this);
                        break;
                    }
                }
                break;
            case 6:
                m3295a(motionEvent);
                break;
        }
        if (this.f3044L == null) {
            this.f3044L = VelocityTracker.obtain();
        }
        this.f3044L.addMovement(motionEvent);
        return this.f3034B;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f3049Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f3066b == null || this.f3066b.mo3270a() == 0) {
            return false;
        }
        if (this.f3044L == null) {
            this.f3044L = VelocityTracker.obtain();
        }
        this.f3044L.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f3075m.abortAnimation();
                this.f3088z = false;
                m3331c();
                float x = motionEvent.getX();
                this.f3041I = x;
                this.f3039G = x;
                float y = motionEvent.getY();
                this.f3042J = y;
                this.f3040H = y;
                this.f3043K = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.f3034B) {
                    VelocityTracker velocityTracker = this.f3044L;
                    velocityTracker.computeCurrentVelocity(1000, this.f3046N);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.f3043K);
                    this.f3088z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b m3310i = m3310i();
                    m3321a(m3291a(m3310i.f3093b, ((scrollX / clientWidth) - m3310i.f3096e) / (m3310i.f3095d + (this.f3078p / clientWidth)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f3043K)) - this.f3041I)), true, true, xVelocity);
                    z = m3309h();
                    break;
                }
                break;
            case 2:
                if (!this.f3034B) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f3043K);
                    if (findPointerIndex == -1) {
                        z = m3309h();
                        break;
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.f3039G);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f3040H);
                        if (abs > this.f3038F && abs > abs2) {
                            this.f3034B = true;
                            m3302c(true);
                            this.f3039G = x2 - this.f3041I > 0.0f ? this.f3041I + this.f3038F : this.f3041I - this.f3038F;
                            this.f3040H = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f3034B) {
                    z = false | m3301b(motionEvent.getX(motionEvent.findPointerIndex(this.f3043K)));
                    break;
                }
                break;
            case 3:
                if (this.f3034B) {
                    m3294a(this.f3067c, true, 0, false);
                    z = m3309h();
                    break;
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.f3039G = motionEvent.getX(actionIndex);
                this.f3043K = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                m3295a(motionEvent);
                this.f3039G = motionEvent.getX(motionEvent.findPointerIndex(this.f3043K));
                break;
        }
        if (z) {
            C0308x.m2249c(this);
        }
        return true;
    }

    /* renamed from: h */
    private boolean m3309h() {
        this.f3043K = -1;
        m3311j();
        this.f3050R.onRelease();
        this.f3051S.onRelease();
        return this.f3050R.isFinished() || this.f3051S.isFinished();
    }

    /* renamed from: c */
    private void m3302c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: b */
    private boolean m3301b(float f2) {
        boolean z;
        boolean z2;
        float f3;
        boolean z3 = true;
        float f4 = this.f3039G - f2;
        this.f3039G = f2;
        float scrollX = getScrollX() + f4;
        int clientWidth = getClientWidth();
        float f5 = clientWidth * this.f3082t;
        float f6 = clientWidth * this.f3083u;
        b bVar = this.f3069g.get(0);
        b bVar2 = this.f3069g.get(this.f3069g.size() - 1);
        if (bVar.f3093b != 0) {
            f5 = clientWidth * bVar.f3096e;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f3093b != this.f3066b.mo3270a() - 1) {
            f3 = bVar2.f3096e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
            f3 = f6;
        }
        if (scrollX < f5) {
            if (z) {
                this.f3050R.onPull(Math.abs(f5 - scrollX) / clientWidth);
            } else {
                z3 = false;
            }
        } else if (scrollX > f3) {
            if (z2) {
                this.f3051S.onPull(Math.abs(scrollX - f3) / clientWidth);
            } else {
                z3 = false;
            }
            f5 = f3;
        } else {
            f5 = scrollX;
            z3 = false;
        }
        this.f3039G += f5 - ((int) f5);
        scrollTo((int) f5, getScrollY());
        m3304d((int) f5);
        return z3;
    }

    /* renamed from: i */
    private b m3310i() {
        b bVar;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.f3078p / clientWidth : 0.0f;
        int i2 = -1;
        boolean z = true;
        int i3 = 0;
        b bVar2 = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.f3069g.size()) {
            b bVar3 = this.f3069g.get(i3);
            if (z || bVar3.f3093b == i2 + 1) {
                bVar = bVar3;
            } else {
                b bVar4 = this.f3070h;
                bVar4.f3096e = f4 + f3 + f2;
                bVar4.f3093b = i2 + 1;
                bVar4.f3095d = this.f3066b.m3282b(bVar4.f3093b);
                i3--;
                bVar = bVar4;
            }
            f4 = bVar.f3096e;
            float f5 = bVar.f3095d + f4 + f2;
            if (!z && scrollX < f4) {
                return bVar2;
            }
            if (scrollX < f5 || i3 == this.f3069g.size() - 1) {
                return bVar;
            }
            i2 = bVar.f3093b;
            f3 = bVar.f3095d;
            i3++;
            bVar2 = bVar;
            z = false;
        }
        return bVar2;
    }

    /* renamed from: a */
    private int m3291a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) > this.f3047O && Math.abs(i3) > this.f3045M) {
            if (i3 <= 0) {
                i2++;
            }
        } else {
            i2 += (int) ((i2 >= this.f3067c ? 0.4f : 0.6f) + f2);
        }
        if (this.f3069g.size() > 0) {
            return Math.max(this.f3069g.get(0).f3093b, Math.min(i2, this.f3069g.get(this.f3069g.size() - 1).f3093b));
        }
        return i2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z = false;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f3066b != null && this.f3066b.mo3270a() > 1)) {
            if (!this.f3050R.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f3082t * width);
                this.f3050R.setSize(height, width);
                z = false | this.f3050R.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f3051S.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f3083u + 1.0f)) * width2);
                this.f3051S.setSize(height2, width2);
                z |= this.f3051S.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f3050R.finish();
            this.f3051S.finish();
        }
        if (z) {
            C0308x.m2249c(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        super.onDraw(canvas);
        if (this.f3078p > 0 && this.f3079q != null && this.f3069g.size() > 0 && this.f3066b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f3 = this.f3078p / width;
            b bVar = this.f3069g.get(0);
            float f4 = bVar.f3096e;
            int size = this.f3069g.size();
            int i2 = bVar.f3093b;
            int i3 = this.f3069g.get(size - 1).f3093b;
            int i4 = 0;
            for (int i5 = i2; i5 < i3; i5++) {
                while (i5 > bVar.f3093b && i4 < size) {
                    i4++;
                    bVar = this.f3069g.get(i4);
                }
                if (i5 == bVar.f3093b) {
                    f2 = (bVar.f3096e + bVar.f3095d) * width;
                    f4 = bVar.f3096e + bVar.f3095d + f3;
                } else {
                    float m3282b = this.f3066b.m3282b(i5);
                    f2 = (f4 + m3282b) * width;
                    f4 += m3282b + f3;
                }
                if (this.f3078p + f2 > scrollX) {
                    this.f3079q.setBounds(Math.round(f2), this.f3080r, Math.round(this.f3078p + f2), this.f3081s);
                    this.f3079q.draw(canvas);
                }
                if (f2 > scrollX + width) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m3295a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3043K) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3039G = motionEvent.getX(i2);
            this.f3043K = motionEvent.getPointerId(i2);
            if (this.f3044L != null) {
                this.f3044L.clear();
            }
        }
    }

    /* renamed from: j */
    private void m3311j() {
        this.f3034B = false;
        this.f3035C = false;
        if (this.f3044L != null) {
            this.f3044L.recycle();
            this.f3044L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f3087y != z) {
            this.f3087y = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f3066b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.f3082t));
        }
        if (i2 > 0) {
            return scrollX < ((int) (((float) clientWidth) * this.f3083u));
        }
        return false;
    }

    /* renamed from: a */
    protected boolean m3325a(View view, boolean z, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom() && m3325a(childAt, true, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m3324a(keyEvent);
    }

    /* renamed from: a */
    public boolean m3324a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                if (!keyEvent.hasModifiers(2)) {
                    break;
                } else {
                    break;
                }
            case 22:
                if (!keyEvent.hasModifiers(2)) {
                    break;
                } else {
                    break;
                }
            case 61:
                if (!keyEvent.hasNoModifiers()) {
                    if (keyEvent.hasModifiers(1)) {
                        break;
                    }
                } else {
                    break;
                }
                break;
        }
        return false;
    }

    /* renamed from: c */
    public boolean m3332c(int i2) {
        View view;
        boolean z;
        boolean m3333d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    }
                    if (parent == this) {
                        z = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.m184e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = m3292a(this.f3071i, findNextFocus).left;
                int i4 = m3292a(this.f3071i, view).left;
                if (view != null && i3 >= i4) {
                    m3333d = m3333d();
                } else {
                    m3333d = findNextFocus.requestFocus();
                }
            } else {
                if (i2 == 66) {
                    int i5 = m3292a(this.f3071i, findNextFocus).left;
                    int i6 = m3292a(this.f3071i, view).left;
                    if (view != null && i5 <= i6) {
                        m3333d = m3334e();
                    } else {
                        m3333d = findNextFocus.requestFocus();
                    }
                }
                m3333d = false;
            }
        } else if (i2 == 17 || i2 == 1) {
            m3333d = m3333d();
        } else {
            if (i2 == 66 || i2 == 2) {
                m3333d = m3334e();
            }
            m3333d = false;
        }
        if (m3333d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return m3333d;
    }

    /* renamed from: a */
    private Rect m3292a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    /* renamed from: d */
    boolean m3333d() {
        if (this.f3067c <= 0) {
            return false;
        }
        m3319a(this.f3067c - 1, true);
        return true;
    }

    /* renamed from: e */
    boolean m3334e() {
        if (this.f3066b == null || this.f3067c >= this.f3066b.mo3270a() - 1) {
            return false;
        }
        m3319a(this.f3067c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b m3314a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (m3314a = m3314a(childAt)) != null && m3314a.f3093b == this.f3067c) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b m3314a;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (m3314a = m3314a(childAt)) != null && m3314a.f3093b == this.f3067c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b m3314a;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = childCount - 1;
            childCount = -1;
            i4 = -1;
        }
        while (i3 != childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (m3314a = m3314a(childAt)) != null && m3314a.f3093b == this.f3067c && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b m3314a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (m3314a = m3314a(childAt)) != null && m3314a.f3093b == this.f3067c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$d */
    class d extends C0271a {
        d() {
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: d */
        public void mo1974d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo1974d(view, accessibilityEvent);
            accessibilityEvent.setClassName(C0406b.class.getName());
            accessibilityEvent.setScrollable(m3336b());
            if (accessibilityEvent.getEventType() == 4096 && C0406b.this.f3066b != null) {
                accessibilityEvent.setItemCount(C0406b.this.f3066b.mo3270a());
                accessibilityEvent.setFromIndex(C0406b.this.f3067c);
                accessibilityEvent.setToIndex(C0406b.this.f3067c);
            }
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public void mo1969a(View view, C0273b c0273b) {
            super.mo1969a(view, c0273b);
            c0273b.m2000b(C0406b.class.getName());
            c0273b.m2016g(m3336b());
            if (C0406b.this.canScrollHorizontally(1)) {
                c0273b.m1989a(4096);
            }
            if (C0406b.this.canScrollHorizontally(-1)) {
                c0273b.m1989a(8192);
            }
        }

        @Override // androidx.core.p031f.C0271a
        /* renamed from: a */
        public boolean mo1970a(View view, int i, Bundle bundle) {
            if (super.mo1970a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!C0406b.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    C0406b.this.setCurrentItem(C0406b.this.f3067c + 1);
                    return true;
                case 8192:
                    if (!C0406b.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    C0406b.this.setCurrentItem(C0406b.this.f3067c - 1);
                    return true;
                default:
                    return false;
            }
        }

        /* renamed from: b */
        private boolean m3336b() {
            return C0406b.this.f3066b != null && C0406b.this.f3066b.mo3270a() > 1;
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$h */
    private class h extends DataSetObserver {
        h() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            C0406b.this.m3328b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            C0406b.this.m3328b();
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$c */
    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a */
        public boolean f3097a;

        /* renamed from: b */
        public int f3098b;

        /* renamed from: c */
        float f3099c;

        /* renamed from: d */
        boolean f3100d;

        /* renamed from: e */
        int f3101e;

        /* renamed from: f */
        int f3102f;

        public c() {
            super(-1, -1);
            this.f3099c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3099c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0406b.f3029a);
            this.f3098b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ViewPager.java */
    /* renamed from: androidx.h.a.b$j */
    static class j implements Comparator<View> {
        j() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f3097a != cVar2.f3097a) {
                return cVar.f3097a ? 1 : -1;
            }
            return cVar.f3101e - cVar2.f3101e;
        }
    }
}
