package ru.maximoff.apktool.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import ru.maximoff.apktool.util.C3067ab;
import ru.maximoff.apktool.util.p304b.C3097b;

/* compiled from: FloatingButton.java */
/* renamed from: ru.maximoff.apktool.view.e */
/* loaded from: classes.dex */
public class C3303e extends View {

    /* renamed from: a */
    private final OvershootInterpolator f20970a;

    /* renamed from: b */
    private final AccelerateInterpolator f20971b;

    /* renamed from: c */
    private Context f20972c;

    /* renamed from: d */
    private Paint f20973d;

    /* renamed from: e */
    private Paint f20974e;

    /* renamed from: f */
    private Bitmap f20975f;

    /* renamed from: g */
    private boolean f20976g;

    /* renamed from: h */
    private float f20977h;

    /* renamed from: i */
    private boolean f20978i;

    /* renamed from: j */
    private b f20979j;

    /* renamed from: k */
    private int f20980k;

    /* renamed from: l */
    private int f20981l;

    /* compiled from: FloatingButton.java */
    /* renamed from: ru.maximoff.apktool.view.e$b */
    public interface b {
        /* renamed from: a */
        void mo16646a(int i, int i2);
    }

    public C3303e(Context context) {
        super(context);
        this.f20970a = new OvershootInterpolator();
        this.f20971b = new AccelerateInterpolator();
        this.f20976g = false;
        this.f20977h = 3.5f;
        this.f20978i = false;
        this.f20972c = context;
        m19852a(-1);
    }

    public void setMovingMode(boolean z) {
        this.f20978i = z;
    }

    public void setMovingInterface(b bVar) {
        this.f20979j = bVar;
    }

    public void setScaleFactor(float f2) {
        if (f2 > 2.0f) {
            this.f20977h = f2;
        }
    }

    public void setFloatingActionButtonColor(int i) {
        m19852a(i);
    }

    public void setFloatingActionButtonDrawable(Drawable drawable) {
        this.f20975f = C3067ab.m18372a(drawable);
        m19851a();
    }

    /* renamed from: a */
    public void m19851a() {
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(16L);
        }
    }

    /* renamed from: a */
    public void m19852a(int i) {
        int argb;
        setClickable(true);
        setWillNotDraw(false);
        if (C3097b.m18818a(i)) {
            argb = Color.argb(80, 255, 255, 255);
        } else {
            argb = Color.argb(80, 0, 0, 0);
        }
        this.f20973d = new Paint();
        this.f20973d.setAntiAlias(true);
        this.f20973d.setColor(i);
        this.f20973d.setStyle(Paint.Style.FILL);
        this.f20973d.setShadowLayer(10.0f, 0.0f, 0.0f, argb);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, this.f20973d);
        }
        this.f20974e = new Paint();
        this.f20974e.setAntiAlias(true);
        m19851a();
    }

    /* renamed from: b */
    public void m19853b() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams.rightMargin == 0 && layoutParams.bottomMargin == 0) {
            View view = (View) getParent();
            if (layoutParams.leftMargin > view.getWidth() - getWidth()) {
                layoutParams.leftMargin = view.getWidth() - getWidth();
            }
            if (layoutParams.topMargin > view.getHeight() - getHeight()) {
                layoutParams.topMargin = view.getHeight() - getHeight();
            }
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            layoutParams.gravity = 51;
            setLayoutParams(layoutParams);
            if (this.f20979j != null) {
                this.f20979j.mo16646a(layoutParams.leftMargin, layoutParams.topMargin);
            }
        }
        m19851a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) (getWidth() / 2.6d), this.f20973d);
        float width = getWidth() / this.f20977h;
        float width2 = getWidth() / this.f20977h;
        canvas.drawBitmap(this.f20975f, (Rect) null, new RectF(width, width2, getWidth() - width, getHeight() - width2), this.f20974e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                if (layoutParams.rightMargin > 0 && layoutParams.bottomMargin > 0) {
                    View view = (View) getParent();
                    layoutParams.leftMargin = (view.getWidth() - layoutParams.rightMargin) - getWidth();
                    layoutParams.topMargin = (view.getHeight() - layoutParams.bottomMargin) - getHeight();
                }
                this.f20980k = rawX - layoutParams.leftMargin;
                this.f20981l = rawY - layoutParams.topMargin;
                setAlpha(0.6f);
                break;
            case 1:
                this.f20978i = false;
                setAlpha(1.0f);
                break;
            case 2:
                if (this.f20978i) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
                    View view2 = (View) getParent();
                    int width = view2.getWidth();
                    int height = view2.getHeight();
                    int i = rawX - this.f20980k;
                    int i2 = rawY - this.f20981l;
                    if (i > width - getWidth()) {
                        i = width - getWidth();
                    } else if (i < 0) {
                        i = 0;
                    }
                    if (i2 > height - getHeight()) {
                        i2 = height - getHeight();
                    } else if (i2 < 0) {
                        i2 = 0;
                    }
                    layoutParams2.leftMargin = i;
                    layoutParams2.topMargin = i2;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    layoutParams2.gravity = 51;
                    setLayoutParams(layoutParams2);
                    if (this.f20979j != null) {
                        this.f20979j.mo16646a(layoutParams2.leftMargin, layoutParams2.topMargin);
                        break;
                    }
                }
                break;
        }
        m19851a();
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: c */
    public void m19854c() {
        if (this.f20976g) {
            return;
        }
        this.f20976g = true;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 1, 0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 1, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new Animator.AnimatorListener(this) { // from class: ru.maximoff.apktool.view.e.1

            /* renamed from: a */
            private final C3303e f20982a;

            {
                this.f20982a = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.f20982a.setVisibility(8);
            }
        });
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setInterpolator(this.f20971b);
        animatorSet.setDuration(100);
        animatorSet.start();
    }

    /* renamed from: d */
    public void m19855d() {
        if (this.f20976g) {
            this.f20976g = false;
            setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", 0, 1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", 0, 1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setInterpolator(this.f20970a);
            animatorSet.setDuration(100);
            animatorSet.start();
        }
    }

    /* compiled from: FloatingButton.java */
    /* renamed from: ru.maximoff.apktool.view.e$a */
    public static class a {

        /* renamed from: a */
        private FrameLayout.LayoutParams f20983a;

        /* renamed from: b */
        private final Activity f20984b;

        /* renamed from: d */
        private Drawable f20986d;

        /* renamed from: f */
        private int f20988f;

        /* renamed from: g */
        private float f20989g;

        /* renamed from: c */
        private int f20985c = 85;

        /* renamed from: e */
        private int f20987e = -1;

        public a(Activity activity) {
            this.f20988f = 0;
            this.f20989g = 0;
            this.f20989g = activity.getResources().getDisplayMetrics().density;
            this.f20988f = m19856a(72, this.f20989g);
            this.f20983a = new FrameLayout.LayoutParams(this.f20988f, this.f20988f);
            this.f20983a.gravity = this.f20985c;
            this.f20984b = activity;
        }

        /* renamed from: a */
        public a m19857a(int i) {
            this.f20985c = i;
            return this;
        }

        /* renamed from: a */
        public a m19858a(int i, int i2, int i3, int i4) {
            this.f20983a.setMargins(m19856a(i, this.f20989g), m19856a(i2, this.f20989g), m19856a(i3, this.f20989g), m19856a(i4, this.f20989g));
            return this;
        }

        /* renamed from: b */
        public a m19862b(int i, int i2, int i3, int i4) {
            this.f20983a.setMargins(i, i2, i3, i4);
            return this;
        }

        /* renamed from: a */
        public a m19859a(Drawable drawable) {
            this.f20986d = drawable;
            return this;
        }

        /* renamed from: b */
        public a m19861b(int i) {
            this.f20987e = i;
            return this;
        }

        /* renamed from: c */
        public a m19863c(int i) {
            int m19856a = m19856a(i, this.f20989g);
            this.f20983a = new FrameLayout.LayoutParams(m19856a, m19856a);
            return this;
        }

        /* renamed from: a */
        public C3303e m19860a() {
            C3303e c3303e = new C3303e(this.f20984b);
            c3303e.setFloatingActionButtonColor(this.f20987e);
            c3303e.setFloatingActionButtonDrawable(this.f20986d);
            this.f20983a.gravity = this.f20985c;
            ((ViewGroup) this.f20984b.findViewById(16908290)).addView(c3303e, this.f20983a);
            return c3303e;
        }

        /* renamed from: a */
        private int m19856a(int i, float f2) {
            return (int) ((i * f2) + 0.5f);
        }
    }
}
