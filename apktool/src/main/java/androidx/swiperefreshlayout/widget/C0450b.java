package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.p030e.C0270e;
import androidx.p034d.p035a.p036a.C0345b;

/* compiled from: CircularProgressDrawable.java */
/* renamed from: androidx.swiperefreshlayout.widget.b */
/* loaded from: classes.dex */
public class C0450b extends Drawable implements Animatable {

    /* renamed from: c */
    private static final Interpolator f3218c = new LinearInterpolator();

    /* renamed from: d */
    private static final Interpolator f3219d = new C0345b();

    /* renamed from: e */
    private static final int[] f3220e = {-16777216};

    /* renamed from: a */
    float f3221a;

    /* renamed from: b */
    boolean f3222b;

    /* renamed from: f */
    private final a f3223f = new a();

    /* renamed from: g */
    private float f3224g;

    /* renamed from: h */
    private Resources f3225h;

    /* renamed from: i */
    private Animator f3226i;

    public C0450b(Context context) {
        this.f3225h = ((Context) C0270e.m1960a(context)).getResources();
        this.f3223f.m3403a(f3220e);
        m3386a(2.5f);
        m3382a();
    }

    /* renamed from: a */
    private void m3383a(float f2, float f3, float f4, float f5) {
        a aVar = this.f3223f;
        float f6 = this.f3225h.getDisplayMetrics().density;
        aVar.m3396a(f3 * f6);
        aVar.m3413e(f2 * f6);
        aVar.m3406b(0);
        aVar.m3397a(f4 * f6, f6 * f5);
    }

    /* renamed from: a */
    public void m3390a(int i) {
        if (i == 0) {
            m3383a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m3383a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: a */
    public void m3386a(float f2) {
        this.f3223f.m3396a(f2);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m3391a(boolean z) {
        this.f3223f.m3402a(z);
        invalidateSelf();
    }

    /* renamed from: b */
    public void m3393b(float f2) {
        this.f3223f.m3415f(f2);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m3387a(float f2, float f3) {
        this.f3223f.m3405b(f2);
        this.f3223f.m3408c(f3);
        invalidateSelf();
    }

    /* renamed from: c */
    public void m3394c(float f2) {
        this.f3223f.m3411d(f2);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m3392a(int... iArr) {
        this.f3223f.m3403a(iArr);
        this.f3223f.m3406b(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f3224g, bounds.exactCenterX(), bounds.exactCenterY());
        this.f3223f.m3400a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3223f.m3409c(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3223f.m3410d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3223f.m3401a(colorFilter);
        invalidateSelf();
    }

    /* renamed from: d */
    private void m3385d(float f2) {
        this.f3224g = f2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3226i.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f3226i.cancel();
        this.f3223f.m3420k();
        if (this.f3223f.m3418i() != this.f3223f.m3412e()) {
            this.f3222b = true;
            this.f3226i.setDuration(666L);
            this.f3226i.start();
        } else {
            this.f3223f.m3406b(0);
            this.f3223f.m3421l();
            this.f3226i.setDuration(1332L);
            this.f3226i.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f3226i.cancel();
        m3385d(0.0f);
        this.f3223f.m3402a(false);
        this.f3223f.m3406b(0);
        this.f3223f.m3421l();
        invalidateSelf();
    }

    /* renamed from: a */
    private int m3381a(float f2, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f2))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f2))) << 16) | ((((int) ((((i2 >> 8) & 255) - r2) * f2)) + ((i >> 8) & 255)) << 8) | (((int) (((i2 & 255) - r3) * f2)) + (i & 255));
    }

    /* renamed from: a */
    void m3388a(float f2, a aVar) {
        if (f2 > 0.75f) {
            aVar.m3398a(m3381a((f2 - 0.75f) / 0.25f, aVar.m3417h(), aVar.m3395a()));
        } else {
            aVar.m3398a(aVar.m3417h());
        }
    }

    /* renamed from: b */
    private void m3384b(float f2, a aVar) {
        m3388a(f2, aVar);
        float floor = (float) (Math.floor(aVar.m3419j() / 0.8f) + 1.0d);
        aVar.m3405b(aVar.m3414f() + (((aVar.m3416g() - 0.01f) - aVar.m3414f()) * f2));
        aVar.m3408c(aVar.m3416g());
        aVar.m3411d(((floor - aVar.m3419j()) * f2) + aVar.m3419j());
    }

    /* renamed from: a */
    void m3389a(float f2, a aVar, boolean z) {
        float m3414f;
        float interpolation;
        if (this.f3222b) {
            m3384b(f2, aVar);
            return;
        }
        if (f2 != 1.0f || z) {
            float m3419j = aVar.m3419j();
            if (f2 < 0.5f) {
                interpolation = aVar.m3414f();
                m3414f = (f3219d.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                m3414f = aVar.m3414f() + 0.79f;
                interpolation = m3414f - (((1.0f - f3219d.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f3 = 216.0f * (this.f3221a + f2);
            aVar.m3405b(interpolation);
            aVar.m3408c(m3414f);
            aVar.m3411d(m3419j + (0.20999998f * f2));
            m3385d(f3);
        }
    }

    /* renamed from: a */
    private void m3382a() {
        final a aVar = this.f3223f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C0450b.this.m3388a(floatValue, aVar);
                C0450b.this.m3389a(floatValue, aVar, false);
                C0450b.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f3218c);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                C0450b.this.f3221a = 0.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                C0450b.this.m3389a(1.0f, aVar, true);
                aVar.m3420k();
                aVar.m3407c();
                if (C0450b.this.f3222b) {
                    C0450b.this.f3222b = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    aVar.m3402a(false);
                    return;
                }
                C0450b.this.f3221a += 1.0f;
            }
        });
        this.f3226i = ofFloat;
    }

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: androidx.swiperefreshlayout.widget.b$a */
    private static class a {

        /* renamed from: i */
        int[] f3239i;

        /* renamed from: j */
        int f3240j;

        /* renamed from: k */
        float f3241k;

        /* renamed from: l */
        float f3242l;

        /* renamed from: m */
        float f3243m;

        /* renamed from: n */
        boolean f3244n;

        /* renamed from: o */
        Path f3245o;

        /* renamed from: q */
        float f3247q;

        /* renamed from: r */
        int f3248r;

        /* renamed from: s */
        int f3249s;

        /* renamed from: u */
        int f3251u;

        /* renamed from: a */
        final RectF f3231a = new RectF();

        /* renamed from: b */
        final Paint f3232b = new Paint();

        /* renamed from: c */
        final Paint f3233c = new Paint();

        /* renamed from: d */
        final Paint f3234d = new Paint();

        /* renamed from: e */
        float f3235e = 0.0f;

        /* renamed from: f */
        float f3236f = 0.0f;

        /* renamed from: g */
        float f3237g = 0.0f;

        /* renamed from: h */
        float f3238h = 5.0f;

        /* renamed from: p */
        float f3246p = 1.0f;

        /* renamed from: t */
        int f3250t = 255;

        a() {
            this.f3232b.setStrokeCap(Paint.Cap.SQUARE);
            this.f3232b.setAntiAlias(true);
            this.f3232b.setStyle(Paint.Style.STROKE);
            this.f3233c.setStyle(Paint.Style.FILL);
            this.f3233c.setAntiAlias(true);
            this.f3234d.setColor(0);
        }

        /* renamed from: a */
        void m3397a(float f2, float f3) {
            this.f3248r = (int) f2;
            this.f3249s = (int) f3;
        }

        /* renamed from: a */
        void m3400a(Canvas canvas, Rect rect) {
            RectF rectF = this.f3231a;
            float f2 = this.f3247q + (this.f3238h / 2.0f);
            if (this.f3247q <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f3248r * this.f3246p) / 2.0f, this.f3238h / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, f2 + rect.centerY());
            float f3 = (this.f3235e + this.f3237g) * 360.0f;
            float f4 = ((this.f3236f + this.f3237g) * 360.0f) - f3;
            this.f3232b.setColor(this.f3251u);
            this.f3232b.setAlpha(this.f3250t);
            float f5 = this.f3238h / 2.0f;
            rectF.inset(f5, f5);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f3234d);
            rectF.inset(-f5, -f5);
            canvas.drawArc(rectF, f3, f4, false, this.f3232b);
            m3399a(canvas, f3, f4, rectF);
        }

        /* renamed from: a */
        void m3399a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.f3244n) {
                if (this.f3245o == null) {
                    this.f3245o = new Path();
                    this.f3245o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.f3245o.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.f3248r * this.f3246p) / 2.0f;
                this.f3245o.moveTo(0.0f, 0.0f);
                this.f3245o.lineTo(this.f3248r * this.f3246p, 0.0f);
                this.f3245o.lineTo((this.f3248r * this.f3246p) / 2.0f, this.f3249s * this.f3246p);
                this.f3245o.offset((min + rectF.centerX()) - f4, rectF.centerY() + (this.f3238h / 2.0f));
                this.f3245o.close();
                this.f3233c.setColor(this.f3251u);
                this.f3233c.setAlpha(this.f3250t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f3245o, this.f3233c);
                canvas.restore();
            }
        }

        /* renamed from: a */
        void m3403a(int[] iArr) {
            this.f3239i = iArr;
            m3406b(0);
        }

        /* renamed from: a */
        void m3398a(int i) {
            this.f3251u = i;
        }

        /* renamed from: b */
        void m3406b(int i) {
            this.f3240j = i;
            this.f3251u = this.f3239i[this.f3240j];
        }

        /* renamed from: a */
        int m3395a() {
            return this.f3239i[m3404b()];
        }

        /* renamed from: b */
        int m3404b() {
            return (this.f3240j + 1) % this.f3239i.length;
        }

        /* renamed from: c */
        void m3407c() {
            m3406b(m3404b());
        }

        /* renamed from: a */
        void m3401a(ColorFilter colorFilter) {
            this.f3232b.setColorFilter(colorFilter);
        }

        /* renamed from: c */
        void m3409c(int i) {
            this.f3250t = i;
        }

        /* renamed from: d */
        int m3410d() {
            return this.f3250t;
        }

        /* renamed from: a */
        void m3396a(float f2) {
            this.f3238h = f2;
            this.f3232b.setStrokeWidth(f2);
        }

        /* renamed from: b */
        void m3405b(float f2) {
            this.f3235e = f2;
        }

        /* renamed from: e */
        float m3412e() {
            return this.f3235e;
        }

        /* renamed from: f */
        float m3414f() {
            return this.f3241k;
        }

        /* renamed from: g */
        float m3416g() {
            return this.f3242l;
        }

        /* renamed from: h */
        int m3417h() {
            return this.f3239i[this.f3240j];
        }

        /* renamed from: c */
        void m3408c(float f2) {
            this.f3236f = f2;
        }

        /* renamed from: i */
        float m3418i() {
            return this.f3236f;
        }

        /* renamed from: d */
        void m3411d(float f2) {
            this.f3237g = f2;
        }

        /* renamed from: e */
        void m3413e(float f2) {
            this.f3247q = f2;
        }

        /* renamed from: a */
        void m3402a(boolean z) {
            if (this.f3244n != z) {
                this.f3244n = z;
            }
        }

        /* renamed from: f */
        void m3415f(float f2) {
            if (f2 != this.f3246p) {
                this.f3246p = f2;
            }
        }

        /* renamed from: j */
        float m3419j() {
            return this.f3243m;
        }

        /* renamed from: k */
        void m3420k() {
            this.f3241k = this.f3235e;
            this.f3242l = this.f3236f;
            this.f3243m = this.f3237g;
        }

        /* renamed from: l */
        void m3421l() {
            this.f3241k = 0.0f;
            this.f3242l = 0.0f;
            this.f3243m = 0.0f;
            m3405b(0.0f);
            m3408c(0.0f);
            m3411d(0.0f);
        }
    }
}
