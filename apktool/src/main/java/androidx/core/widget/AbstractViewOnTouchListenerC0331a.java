package androidx.core.widget;

import android.content.res.Resources;
import android.p008os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.p031f.C0308x;

/* compiled from: AutoScrollHelper.java */
/* renamed from: androidx.core.widget.a */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0331a implements View.OnTouchListener {

    /* renamed from: r */
    private static final int f2322r = ViewConfiguration.getTapTimeout();

    /* renamed from: b */
    final View f2324b;

    /* renamed from: c */
    boolean f2325c;

    /* renamed from: d */
    boolean f2326d;

    /* renamed from: e */
    boolean f2327e;

    /* renamed from: g */
    private Runnable f2329g;

    /* renamed from: j */
    private int f2332j;

    /* renamed from: k */
    private int f2333k;

    /* renamed from: o */
    private boolean f2337o;

    /* renamed from: p */
    private boolean f2338p;

    /* renamed from: q */
    private boolean f2339q;

    /* renamed from: a */
    final a f2323a = new a();

    /* renamed from: f */
    private final Interpolator f2328f = new AccelerateInterpolator();

    /* renamed from: h */
    private float[] f2330h = {0.0f, 0.0f};

    /* renamed from: i */
    private float[] f2331i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    private float[] f2334l = {0.0f, 0.0f};

    /* renamed from: m */
    private float[] f2335m = {0.0f, 0.0f};

    /* renamed from: n */
    private float[] f2336n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: a */
    public abstract void mo2471a(int i, int i2);

    /* renamed from: e */
    public abstract boolean mo2481e(int i);

    /* renamed from: f */
    public abstract boolean mo2482f(int i);

    public AbstractViewOnTouchListenerC0331a(View view) {
        this.f2324b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2468a(i, i);
        m2473b(i2, i2);
        m2469a(1);
        m2480e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2478d(0.2f, 0.2f);
        m2476c(1.0f, 1.0f);
        m2474b(f2322r);
        m2477c(500);
        m2479d(500);
    }

    /* renamed from: a */
    public AbstractViewOnTouchListenerC0331a m2470a(boolean z) {
        if (this.f2338p && !z) {
            m2466d();
        }
        this.f2338p = z;
        return this;
    }

    /* renamed from: a */
    public AbstractViewOnTouchListenerC0331a m2468a(float f2, float f3) {
        this.f2336n[0] = f2 / 1000.0f;
        this.f2336n[1] = f3 / 1000.0f;
        return this;
    }

    /* renamed from: b */
    public AbstractViewOnTouchListenerC0331a m2473b(float f2, float f3) {
        this.f2335m[0] = f2 / 1000.0f;
        this.f2335m[1] = f3 / 1000.0f;
        return this;
    }

    /* renamed from: c */
    public AbstractViewOnTouchListenerC0331a m2476c(float f2, float f3) {
        this.f2334l[0] = f2 / 1000.0f;
        this.f2334l[1] = f3 / 1000.0f;
        return this;
    }

    /* renamed from: a */
    public AbstractViewOnTouchListenerC0331a m2469a(int i) {
        this.f2332j = i;
        return this;
    }

    /* renamed from: d */
    public AbstractViewOnTouchListenerC0331a m2478d(float f2, float f3) {
        this.f2330h[0] = f2;
        this.f2330h[1] = f3;
        return this;
    }

    /* renamed from: e */
    public AbstractViewOnTouchListenerC0331a m2480e(float f2, float f3) {
        this.f2331i[0] = f2;
        this.f2331i[1] = f3;
        return this;
    }

    /* renamed from: b */
    public AbstractViewOnTouchListenerC0331a m2474b(int i) {
        this.f2333k = i;
        return this;
    }

    /* renamed from: c */
    public AbstractViewOnTouchListenerC0331a m2477c(int i) {
        this.f2323a.m2487a(i);
        return this;
    }

    /* renamed from: d */
    public AbstractViewOnTouchListenerC0331a m2479d(int i) {
        this.f2323a.m2489b(i);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f2338p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f2326d = true;
                this.f2337o = false;
                this.f2323a.m2486a(m2463a(0, motionEvent.getX(), view.getWidth(), this.f2324b.getWidth()), m2463a(1, motionEvent.getY(), view.getHeight(), this.f2324b.getHeight()));
                if (!this.f2327e && m2472a()) {
                    m2465c();
                    break;
                }
                break;
            case 1:
            case 3:
                m2466d();
                break;
            case 2:
                this.f2323a.m2486a(m2463a(0, motionEvent.getX(), view.getWidth(), this.f2324b.getWidth()), m2463a(1, motionEvent.getY(), view.getHeight(), this.f2324b.getHeight()));
                if (!this.f2327e) {
                    m2465c();
                    break;
                }
                break;
        }
        return this.f2339q && this.f2327e;
    }

    /* renamed from: a */
    boolean m2472a() {
        a aVar = this.f2323a;
        int m2493f = aVar.m2493f();
        int m2492e = aVar.m2492e();
        return (m2493f != 0 && mo2482f(m2493f)) || (m2492e != 0 && mo2481e(m2492e));
    }

    /* renamed from: c */
    private void m2465c() {
        if (this.f2329g == null) {
            this.f2329g = new b();
        }
        this.f2327e = true;
        this.f2325c = true;
        if (!this.f2337o && this.f2333k > 0) {
            C0308x.m2240a(this.f2324b, this.f2329g, this.f2333k);
        } else {
            this.f2329g.run();
        }
        this.f2337o = true;
    }

    /* renamed from: d */
    private void m2466d() {
        if (this.f2325c) {
            this.f2327e = false;
        } else {
            this.f2323a.m2488b();
        }
    }

    /* renamed from: a */
    private float m2463a(int i, float f2, float f3, float f4) {
        float m2462a = m2462a(this.f2330h[i], f3, this.f2331i[i], f2);
        if (m2462a == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f2334l[i];
        float f6 = this.f2335m[i];
        float f7 = this.f2336n[i];
        float f8 = f5 * f4;
        if (m2462a > 0.0f) {
            return m2461a(m2462a * f8, f6, f7);
        }
        return -m2461a((-m2462a) * f8, f6, f7);
    }

    /* renamed from: a */
    private float m2462a(float f2, float f3, float f4, float f5) {
        float interpolation;
        float m2461a = m2461a(f2 * f3, 0.0f, f4);
        float m2467f = m2467f(f3 - f5, m2461a) - m2467f(f5, m2461a);
        if (m2467f < 0.0f) {
            interpolation = -this.f2328f.getInterpolation(-m2467f);
        } else {
            if (m2467f <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f2328f.getInterpolation(m2467f);
        }
        return m2461a(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: f */
    private float m2467f(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        switch (this.f2332j) {
            case 0:
            case 1:
                if (f2 < f3) {
                    if (f2 < 0.0f) {
                        if (this.f2327e && this.f2332j == 1) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            case 2:
                if (f2 < 0.0f) {
                    break;
                }
                break;
        }
        return 0.0f;
    }

    /* renamed from: a */
    static int m2464a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    /* renamed from: a */
    static float m2461a(float f2, float f3, float f4) {
        if (f2 > f4) {
            return f4;
        }
        return f2 < f3 ? f3 : f2;
    }

    /* renamed from: b */
    void m2475b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2324b.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$b */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractViewOnTouchListenerC0331a.this.f2327e) {
                if (AbstractViewOnTouchListenerC0331a.this.f2325c) {
                    AbstractViewOnTouchListenerC0331a.this.f2325c = false;
                    AbstractViewOnTouchListenerC0331a.this.f2323a.m2485a();
                }
                a aVar = AbstractViewOnTouchListenerC0331a.this.f2323a;
                if (aVar.m2490c() || !AbstractViewOnTouchListenerC0331a.this.m2472a()) {
                    AbstractViewOnTouchListenerC0331a.this.f2327e = false;
                    return;
                }
                if (AbstractViewOnTouchListenerC0331a.this.f2326d) {
                    AbstractViewOnTouchListenerC0331a.this.f2326d = false;
                    AbstractViewOnTouchListenerC0331a.this.m2475b();
                }
                aVar.m2491d();
                AbstractViewOnTouchListenerC0331a.this.mo2471a(aVar.m2494g(), aVar.m2495h());
                C0308x.m2239a(AbstractViewOnTouchListenerC0331a.this.f2324b, this);
            }
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a */
    private static class a {

        /* renamed from: a */
        private int f2340a;

        /* renamed from: b */
        private int f2341b;

        /* renamed from: c */
        private float f2342c;

        /* renamed from: d */
        private float f2343d;

        /* renamed from: j */
        private float f2349j;

        /* renamed from: k */
        private int f2350k;

        /* renamed from: e */
        private long f2344e = Long.MIN_VALUE;

        /* renamed from: i */
        private long f2348i = -1;

        /* renamed from: f */
        private long f2345f = 0;

        /* renamed from: g */
        private int f2346g = 0;

        /* renamed from: h */
        private int f2347h = 0;

        a() {
        }

        /* renamed from: a */
        public void m2487a(int i) {
            this.f2340a = i;
        }

        /* renamed from: b */
        public void m2489b(int i) {
            this.f2341b = i;
        }

        /* renamed from: a */
        public void m2485a() {
            this.f2344e = AnimationUtils.currentAnimationTimeMillis();
            this.f2348i = -1L;
            this.f2345f = this.f2344e;
            this.f2349j = 0.5f;
            this.f2346g = 0;
            this.f2347h = 0;
        }

        /* renamed from: b */
        public void m2488b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2350k = AbstractViewOnTouchListenerC0331a.m2464a((int) (currentAnimationTimeMillis - this.f2344e), 0, this.f2341b);
            this.f2349j = m2484a(currentAnimationTimeMillis);
            this.f2348i = currentAnimationTimeMillis;
        }

        /* renamed from: c */
        public boolean m2490c() {
            return this.f2348i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2348i + ((long) this.f2350k);
        }

        /* renamed from: a */
        private float m2484a(long j) {
            if (j < this.f2344e) {
                return 0.0f;
            }
            if (this.f2348i < 0 || j < this.f2348i) {
                return AbstractViewOnTouchListenerC0331a.m2461a((j - this.f2344e) / this.f2340a, 0.0f, 1.0f) * 0.5f;
            }
            return (AbstractViewOnTouchListenerC0331a.m2461a((j - this.f2348i) / this.f2350k, 0.0f, 1.0f) * this.f2349j) + (1.0f - this.f2349j);
        }

        /* renamed from: a */
        private float m2483a(float f2) {
            return ((-4.0f) * f2 * f2) + (4.0f * f2);
        }

        /* renamed from: d */
        public void m2491d() {
            if (this.f2345f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float m2483a = m2483a(m2484a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f2345f;
            this.f2345f = currentAnimationTimeMillis;
            this.f2346g = (int) (j * m2483a * this.f2342c);
            this.f2347h = (int) (j * m2483a * this.f2343d);
        }

        /* renamed from: a */
        public void m2486a(float f2, float f3) {
            this.f2342c = f2;
            this.f2343d = f3;
        }

        /* renamed from: e */
        public int m2492e() {
            return (int) (this.f2342c / Math.abs(this.f2342c));
        }

        /* renamed from: f */
        public int m2493f() {
            return (int) (this.f2343d / Math.abs(this.f2343d));
        }

        /* renamed from: g */
        public int m2494g() {
            return this.f2346g;
        }

        /* renamed from: h */
        public int m2495h() {
            return this.f2347h;
        }
    }
}
