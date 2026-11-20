package ru.maximoff.apktool.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import ru.maximoff.apktool.util.C3102bd;

/* loaded from: classes.dex */
public class SnowfallView extends FrameLayout {

    /* renamed from: a */
    private final List<C3275a> f20797a;

    /* renamed from: b */
    private final Random f20798b;

    /* renamed from: c */
    private Bitmap f20799c;

    /* renamed from: d */
    private boolean f20800d;

    public SnowfallView(Context context) {
        super(context);
        this.f20797a = new ArrayList();
        this.f20798b = new Random();
        m19760a(context);
    }

    public SnowfallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20797a = new ArrayList();
        this.f20798b = new Random();
        m19760a(context);
    }

    public SnowfallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20797a = new ArrayList();
        this.f20798b = new Random();
        m19760a(context);
    }

    /* renamed from: a */
    private void m19760a(Context context) {
        this.f20800d = (C3102bd.m18925a(context, "snowfall", true) && C3102bd.m18925a(context, "nyholidays", false)) || C3102bd.m18925a(context, "snowfall_force", false);
        if (this.f20800d) {
            setWillNotDraw(false);
            if (C3102bd.m18925a(context, "snowfall_sfr", true)) {
                this.f20799c = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.snowflake), 20, 20, true);
            } else {
                this.f20799c = m19758a(20);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20800d) {
            for (C3275a c3275a : this.f20797a) {
                c3275a.m19766a(getWidth(), getHeight());
                c3275a.m19767a(canvas, this.f20799c);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                postInvalidateDelayed(16L);
            }
        }
    }

    /* renamed from: a */
    private Bitmap m19758a(int i) {
        int i2 = i / 5;
        int i3 = i + (i2 * 2);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(Color.GRAY);
        paint.setMaskFilter(new BlurMaskFilter(i2 / 2.0f, BlurMaskFilter.Blur.NORMAL));
        m19761a(canvas, paint, i3 / 2.0f, i3 / 2.0f, i / 2.0f);
        paint.setColor(-1);
        paint.setMaskFilter((MaskFilter) null);
        m19761a(canvas, paint, i3 / 2.0f, i3 / 2.0f, i / 2.0f);
        return createBitmap;
    }

    /* renamed from: a */
    private void m19761a(Canvas canvas, Paint paint, float f2, float f3, float f4) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                return;
            }
            float radians = (float) Math.toRadians(i2 * 60);
            canvas.drawLine(f2, f3, f2 + (((float) Math.cos(radians)) * f4), f3 + (((float) Math.sin(radians)) * f4), paint);
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f20800d) {
            this.f20797a.clear();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < 100) {
                    float nextFloat = this.f20798b.nextFloat() + 0.5f;
                    this.f20797a.add(new C3275a(this, this.f20798b.nextFloat() * i, this.f20798b.nextFloat() * i2, 1.1f + (this.f20798b.nextFloat() * 2), 20.0f * nextFloat, this.f20798b.nextFloat() * DisplayMetrics.DENSITY_360, 1.1f * (0.5f + this.f20798b.nextFloat()), 17.0f * nextFloat, i6 % 4));
                    i5 = i6 + 1;
                } else {
                    Collections.sort(this.f20797a, new Comparator<C3275a>(this) { // from class: ru.maximoff.apktool.view.SnowfallView.1

                        /* renamed from: a */
                        private final SnowfallView f20801a;

                        {
                            this.f20801a = this;
                        }

                        @Override // java.util.Comparator
                        public int compare(C3275a c3275a, C3275a c3275a2) {
                            return m19762a(c3275a, c3275a2);
                        }

                        /* renamed from: a */
                        public int m19762a(C3275a c3275a, C3275a c3275a2) {
                            return Float.compare(c3275a.f20805d, c3275a2.f20805d);
                        }
                    });
                    return;
                }
            }
        }
    }

    /* renamed from: ru.maximoff.apktool.view.SnowfallView$a */
    private class C3275a {

        /* renamed from: a */
        private float f20802a;

        /* renamed from: b */
        private float f20803b;

        /* renamed from: c */
        private final float f20804c;

        /* renamed from: d */
        private final float f20805d;

        /* renamed from: e */
        private final float f20806e;

        /* renamed from: f */
        private final float f20807f;

        /* renamed from: g */
        private float f20808g;

        /* renamed from: h */
        private final float f20809h;

        /* renamed from: i */
        private float f20810i;

        /* renamed from: j */
        private float f20811j;

        /* renamed from: k */
        private final int f20812k;

        /* renamed from: l */
        private final float f20813l;

        /* renamed from: m */
        private float f20814m;

        /* renamed from: n */
        private float f20815n;

        /* renamed from: o */
        private final SnowfallView f20816o;

        C3275a(SnowfallView snowfallView, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i) {
            this.f20816o = snowfallView;
            this.f20802a = f2;
            this.f20803b = f3;
            this.f20804c = f4;
            this.f20805d = f5;
            this.f20808g = f6;
            this.f20809h = (Math.random() > 0.5d ? 1 : -1) * f7;
            this.f20806e = f8;
            this.f20807f = (float) (Math.random() * 2 * 3.141592653589793d);
            this.f20812k = i;
            this.f20810i = 0;
            this.f20811j = i < 2 ? 1.0f : 0.0f;
            this.f20813l = (((float) Math.random()) * 0.01f) + 0.01f;
            m19764a();
        }

        /* renamed from: a */
        void m19766a(int i, int i2) {
            this.f20803b += this.f20804c;
            this.f20808g += this.f20809h;
            this.f20810i += 0.02f;
            float f2 = this.f20803b / i2;
            switch (this.f20812k) {
                case 0:
                case 1:
                    if (f2 > this.f20815n) {
                        this.f20811j -= this.f20813l;
                        break;
                    }
                    break;
                case 2:
                    if (f2 > this.f20814m) {
                        this.f20811j += this.f20813l;
                        if (this.f20811j > 1.0f) {
                            this.f20811j = 1.0f;
                            break;
                        }
                    }
                    break;
                case 3:
                    if (f2 <= this.f20814m) {
                        if (f2 > this.f20815n) {
                            this.f20811j -= this.f20813l;
                            break;
                        }
                    } else {
                        this.f20811j += this.f20813l;
                        if (this.f20811j > 1.0f) {
                            this.f20811j = 1.0f;
                            break;
                        }
                    }
                    break;
            }
            if ((this.f20811j > 0.0f || f2 <= this.f20814m) && f2 <= 1.0f) {
                return;
            }
            m19765b(i, i2);
        }

        /* renamed from: a */
        void m19767a(Canvas canvas, Bitmap bitmap) {
            float sin = ((float) Math.sin(this.f20810i + this.f20807f)) * this.f20806e;
            Paint paint = new Paint();
            paint.setAlpha((int) (this.f20811j * 255));
            canvas.save();
            canvas.translate(sin + this.f20802a, this.f20803b);
            canvas.rotate(this.f20808g, this.f20805d / 2.0f, this.f20805d / 2.0f);
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0, 0, this.f20805d, this.f20805d), paint);
            canvas.restore();
        }

        /* renamed from: b */
        private void m19765b(int i, int i2) {
            this.f20803b = -this.f20805d;
            this.f20802a = this.f20816o.f20798b.nextFloat() * i;
            this.f20810i = 0;
            switch (this.f20812k) {
                case 0:
                case 1:
                    this.f20811j = 1.0f;
                    break;
                case 2:
                case 3:
                    this.f20811j = 0.0f;
                    break;
            }
            m19764a();
        }

        /* renamed from: a */
        private void m19764a() {
            this.f20814m = 0.1f + (this.f20816o.f20798b.nextFloat() * 0.3f);
            this.f20815n = 0.5f + (this.f20816o.f20798b.nextFloat() * 0.3f);
        }
    }
}
