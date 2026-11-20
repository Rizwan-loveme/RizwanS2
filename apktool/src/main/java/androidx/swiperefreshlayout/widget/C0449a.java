package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.p031f.C0308x;
import androidx.swiperefreshlayout.C0437a;

/* compiled from: CircleImageView.java */
/* renamed from: androidx.swiperefreshlayout.widget.a */
/* loaded from: classes.dex */
class C0449a extends ImageView {

    /* renamed from: a */
    private Animation.AnimationListener f3212a;

    /* renamed from: b */
    private int f3213b;

    /* renamed from: c */
    private int f3214c;

    C0449a(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (1.75f * f2);
        int i2 = (int) (0.0f * f2);
        this.f3213b = (int) (3.5f * f2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(C0437a.a.SwipeRefreshLayout);
        this.f3214c = obtainStyledAttributes.getColor(C0437a.a.f3156xaa980688, -328966);
        obtainStyledAttributes.recycle();
        if (m3378a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            C0308x.m2226a(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this, this.f3213b));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer(this.f3213b, i2, i, 503316480);
            int i3 = this.f3213b;
            setPadding(i3, i3, i3, i3);
        }
        shapeDrawable.getPaint().setColor(this.f3214c);
        C0308x.m2233a(this, shapeDrawable);
    }

    /* renamed from: a */
    private boolean m3378a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m3378a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f3213b * 2), getMeasuredHeight() + (this.f3213b * 2));
        }
    }

    /* renamed from: a */
    public void m3379a(Animation.AnimationListener animationListener) {
        this.f3212a = animationListener;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f3212a != null) {
            this.f3212a.onAnimationStart(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f3212a != null) {
            this.f3212a.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
            this.f3214c = i;
        }
    }

    /* compiled from: CircleImageView.java */
    /* renamed from: androidx.swiperefreshlayout.widget.a$a */
    private static class a extends OvalShape {

        /* renamed from: a */
        private Paint f3215a = new Paint();

        /* renamed from: b */
        private int f3216b;

        /* renamed from: c */
        private C0449a f3217c;

        a(C0449a c0449a, int i) {
            this.f3217c = c0449a;
            this.f3216b = i;
            m3380a((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            m3380a((int) f2);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width = this.f3217c.getWidth() / 2;
            int height = this.f3217c.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.f3215a);
            canvas.drawCircle(width, height, width - this.f3216b, paint);
        }

        /* renamed from: a */
        private void m3380a(int i) {
            this.f3215a.setShader(new RadialGradient(i / 2, i / 2, this.f3216b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }
    }
}
