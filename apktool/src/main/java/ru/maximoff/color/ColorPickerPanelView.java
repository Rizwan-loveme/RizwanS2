package ru.maximoff.color;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.p008os.Build;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
public class ColorPickerPanelView extends View {

    /* renamed from: a */
    private float f21288a;

    /* renamed from: b */
    private int f21289b;

    /* renamed from: c */
    private int f21290c;

    /* renamed from: d */
    private Paint f21291d;

    /* renamed from: e */
    private Paint f21292e;

    /* renamed from: f */
    private RectF f21293f;

    /* renamed from: g */
    private RectF f21294g;

    /* renamed from: h */
    private C3319a f21295h;

    public ColorPickerPanelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorPickerPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerPanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21288a = 1.0f;
        this.f21289b = -9539986;
        this.f21290c = -16777216;
        m20056b();
    }

    /* renamed from: b */
    private void m20056b() {
        this.f21291d = new Paint();
        this.f21292e = new Paint();
        this.f21288a = getContext().getResources().getDisplayMetrics().density;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f21294g;
        this.f21291d.setColor(this.f21289b);
        canvas.drawRect(this.f21293f, this.f21291d);
        if (this.f21295h != null) {
            this.f21295h.draw(canvas);
        }
        this.f21292e.setColor(this.f21290c);
        canvas.drawRect(rectF, this.f21292e);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f21293f = new RectF();
        this.f21293f.left = getPaddingLeft();
        this.f21293f.right = i - getPaddingRight();
        this.f21293f.top = getPaddingTop();
        this.f21293f.bottom = i2 - getPaddingBottom();
        m20057c();
    }

    /* renamed from: c */
    private void m20057c() {
        RectF rectF = this.f21293f;
        this.f21294g = new RectF(rectF.left + 1.0f, rectF.top + 1.0f, rectF.right - 1.0f, rectF.bottom - 1.0f);
        this.f21295h = new C3319a((int) (5 * this.f21288a));
        this.f21295h.setBounds(Math.round(this.f21294g.left), Math.round(this.f21294g.top), Math.round(this.f21294g.right), Math.round(this.f21294g.bottom));
    }

    public void setColor(int i) {
        this.f21290c = i;
        m20058a();
    }

    public int getColor() {
        return this.f21290c;
    }

    public void setBorderColor(int i) {
        this.f21289b = i;
        m20058a();
    }

    public int getBorderColor() {
        return this.f21289b;
    }

    /* renamed from: a */
    public void m20058a() {
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(16L);
        }
    }
}
