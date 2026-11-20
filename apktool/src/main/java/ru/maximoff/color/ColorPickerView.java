package ru.maximoff.color;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.p008os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public class ColorPickerView extends View {

    /* renamed from: A */
    private boolean f21296A;

    /* renamed from: B */
    private int f21297B;

    /* renamed from: C */
    private float f21298C;

    /* renamed from: D */
    private RectF f21299D;

    /* renamed from: E */
    private RectF f21300E;

    /* renamed from: F */
    private RectF f21301F;

    /* renamed from: G */
    private RectF f21302G;

    /* renamed from: H */
    private C3319a f21303H;

    /* renamed from: I */
    private Point f21304I;

    /* renamed from: a */
    private float f21305a;

    /* renamed from: b */
    private float f21306b;

    /* renamed from: c */
    private float f21307c;

    /* renamed from: d */
    private float f21308d;

    /* renamed from: e */
    private float f21309e;

    /* renamed from: f */
    private float f21310f;

    /* renamed from: g */
    private InterfaceC3318a f21311g;

    /* renamed from: h */
    private Paint f21312h;

    /* renamed from: i */
    private Paint f21313i;

    /* renamed from: j */
    private Paint f21314j;

    /* renamed from: k */
    private Paint f21315k;

    /* renamed from: l */
    private Paint f21316l;

    /* renamed from: m */
    private Paint f21317m;

    /* renamed from: n */
    private Paint f21318n;

    /* renamed from: o */
    private Shader f21319o;

    /* renamed from: p */
    private Shader f21320p;

    /* renamed from: q */
    private Shader f21321q;

    /* renamed from: r */
    private Shader f21322r;

    /* renamed from: s */
    private int f21323s;

    /* renamed from: t */
    private float f21324t;

    /* renamed from: u */
    private float f21325u;

    /* renamed from: v */
    private float f21326v;

    /* renamed from: w */
    private String f21327w;

    /* renamed from: x */
    private int f21328x;

    /* renamed from: y */
    private int f21329y;

    /* renamed from: z */
    private boolean f21330z;

    /* renamed from: ru.maximoff.color.ColorPickerView$a */
    public interface InterfaceC3318a {
        /* renamed from: a */
        void mo20080a(int i);
    }

    public ColorPickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21305a = 30.0f;
        this.f21306b = 20.0f;
        this.f21307c = 10.0f;
        this.f21308d = 5.0f;
        this.f21309e = 2.0f;
        this.f21310f = 1.0f;
        this.f21323s = 255;
        this.f21324t = 360.0f;
        this.f21325u = 0.0f;
        this.f21326v = 0.0f;
        this.f21327w = "";
        this.f21328x = -14935012;
        this.f21329y = -9539986;
        this.f21330z = false;
        this.f21296A = false;
        this.f21297B = 0;
        this.f21304I = (Point) null;
        m20068b();
    }

    /* renamed from: b */
    private void m20068b() {
        this.f21310f = getContext().getResources().getDisplayMetrics().density;
        this.f21308d *= this.f21310f;
        this.f21309e *= this.f21310f;
        this.f21305a *= this.f21310f;
        this.f21306b *= this.f21310f;
        this.f21307c *= this.f21310f;
        this.f21298C = m20073d();
        m20071c();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: c */
    private void m20071c() {
        this.f21312h = new Paint();
        this.f21313i = new Paint();
        this.f21314j = new Paint();
        this.f21315k = new Paint();
        this.f21316l = new Paint();
        this.f21317m = new Paint();
        this.f21318n = new Paint();
        this.f21313i.setStyle(Paint.Style.STROKE);
        this.f21313i.setStrokeWidth(this.f21310f * 2.0f);
        this.f21313i.setAntiAlias(true);
        this.f21315k.setColor(this.f21328x);
        this.f21315k.setStyle(Paint.Style.STROKE);
        this.f21315k.setStrokeWidth(this.f21310f * 2.0f);
        this.f21315k.setAntiAlias(true);
        this.f21317m.setColor(-14935012);
        this.f21317m.setTextSize(14.0f * this.f21310f);
        this.f21317m.setAntiAlias(true);
        this.f21317m.setTextAlign(Paint.Align.CENTER);
        this.f21317m.setFakeBoldText(true);
    }

    /* renamed from: d */
    private float m20073d() {
        return Math.max(Math.max(this.f21308d, this.f21309e), 1.0f * this.f21310f) * 1.5f;
    }

    /* renamed from: e */
    private int[] m20074e() {
        int[] iArr = new int[361];
        int length = iArr.length - 1;
        int i = 0;
        while (length >= 0) {
            iArr[i] = Color.HSVToColor(new float[]{length, 1.0f, 1.0f});
            length--;
            i++;
        }
        return iArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f21299D.width() > 0 && this.f21299D.height() > 0) {
            m20063a(canvas);
            m20069b(canvas);
            m20072c(canvas);
        }
    }

    /* renamed from: a */
    private void m20063a(Canvas canvas) {
        RectF rectF = this.f21300E;
        this.f21318n.setColor(this.f21329y);
        canvas.drawRect(this.f21299D.left, this.f21299D.top, 1.0f + rectF.right, 1.0f + rectF.bottom, this.f21318n);
        if (this.f21319o == null) {
            this.f21319o = new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, -1, -16777216, Shader.TileMode.CLAMP);
        }
        this.f21320p = new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.top, -1, Color.HSVToColor(new float[]{this.f21324t, 1.0f, 1.0f}), Shader.TileMode.CLAMP);
        this.f21312h.setShader(new ComposeShader(this.f21319o, this.f21320p, PorterDuff.Mode.MULTIPLY));
        canvas.drawRect(rectF, this.f21312h);
        Point m20061a = m20061a(this.f21325u, this.f21326v);
        this.f21313i.setColor(-16777216);
        canvas.drawCircle(m20061a.f60x, m20061a.f61y, this.f21308d - (1.0f * this.f21310f), this.f21313i);
        this.f21313i.setColor(-2236963);
        canvas.drawCircle(m20061a.f60x, m20061a.f61y, this.f21308d, this.f21313i);
    }

    /* renamed from: b */
    private void m20069b(Canvas canvas) {
        RectF rectF = this.f21301F;
        this.f21318n.setColor(this.f21329y);
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, 1.0f + rectF.bottom, this.f21318n);
        if (this.f21321q == null) {
            this.f21321q = new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, m20074e(), (float[]) null, Shader.TileMode.CLAMP);
            this.f21314j.setShader(this.f21321q);
        }
        canvas.drawRect(rectF, this.f21314j);
        float f2 = (4 * this.f21310f) / 2;
        Point m20060a = m20060a(this.f21324t);
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left - this.f21309e;
        rectF2.right = rectF.right + this.f21309e;
        rectF2.top = m20060a.f61y - f2;
        rectF2.bottom = f2 + m20060a.f61y;
        canvas.drawRoundRect(rectF2, 2, 2, this.f21315k);
    }

    /* renamed from: c */
    private void m20072c(Canvas canvas) {
        if (this.f21330z && this.f21302G != null && this.f21303H != null) {
            RectF rectF = this.f21302G;
            this.f21318n.setColor(this.f21329y);
            canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, 1.0f + rectF.bottom, this.f21318n);
            this.f21303H.draw(canvas);
            float[] fArr = {this.f21324t, this.f21325u, this.f21326v};
            this.f21322r = new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.top, Color.HSVToColor(fArr), Color.HSVToColor(0, fArr), Shader.TileMode.CLAMP);
            this.f21316l.setShader(this.f21322r);
            canvas.drawRect(rectF, this.f21316l);
            if (this.f21327w != null && this.f21327w != "") {
                canvas.drawText(this.f21327w, rectF.centerX(), rectF.centerY() + (4 * this.f21310f), this.f21317m);
            }
            float f2 = (4 * this.f21310f) / 2;
            Point m20062a = m20062a(this.f21323s);
            RectF rectF2 = new RectF();
            rectF2.left = m20062a.f60x - f2;
            rectF2.right = f2 + m20062a.f60x;
            rectF2.top = rectF.top - this.f21309e;
            rectF2.bottom = rectF.bottom + this.f21309e;
            canvas.drawRoundRect(rectF2, 2, 2, this.f21315k);
        }
    }

    /* renamed from: a */
    private Point m20060a(float f2) {
        RectF rectF = this.f21301F;
        float height = rectF.height();
        Point point = new Point();
        point.f61y = (int) ((height - ((f2 * height) / 360.0f)) + rectF.top);
        point.f60x = (int) rectF.left;
        return point;
    }

    /* renamed from: a */
    private Point m20061a(float f2, float f3) {
        RectF rectF = this.f21300E;
        float height = rectF.height();
        float width = rectF.width();
        Point point = new Point();
        point.f60x = (int) ((width * f2) + rectF.left);
        point.f61y = (int) (rectF.top + (height * (1.0f - f3)));
        return point;
    }

    /* renamed from: a */
    private Point m20062a(int i) {
        RectF rectF = this.f21302G;
        float width = rectF.width();
        Point point = new Point();
        point.f60x = (int) ((width - ((i * width) / 255)) + rectF.left);
        point.f61y = (int) rectF.top;
        return point;
    }

    /* renamed from: b */
    private float[] m20070b(float f2, float f3) {
        float f4;
        float f5 = 0.0f;
        RectF rectF = this.f21300E;
        float[] fArr = new float[2];
        float width = rectF.width();
        float height = rectF.height();
        if (f2 < rectF.left) {
            f4 = 0.0f;
        } else {
            f4 = f2 > rectF.right ? width : f2 - rectF.left;
        }
        if (f3 >= rectF.top) {
            f5 = f3 > rectF.bottom ? height : f3 - rectF.top;
        }
        fArr[0] = f4 * (1.0f / width);
        fArr[1] = 1.0f - (f5 * (1.0f / height));
        return fArr;
    }

    /* renamed from: b */
    private float m20065b(float f2) {
        float f3;
        RectF rectF = this.f21301F;
        float height = rectF.height();
        if (f2 < rectF.top) {
            f3 = 0.0f;
        } else {
            f3 = f2 > rectF.bottom ? height : f2 - rectF.top;
        }
        return 360.0f - ((f3 * 360.0f) / height);
    }

    /* renamed from: b */
    private int m20066b(int i) {
        int i2;
        RectF rectF = this.f21302G;
        int width = (int) rectF.width();
        if (i < rectF.left) {
            i2 = 0;
        } else {
            i2 = ((float) i) > rectF.right ? width : i - ((int) rectF.left);
        }
        return 255 - ((i2 * 255) / width);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        boolean z;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        ViewParent parent = getParent();
        if (motionEvent.getAction() == 2) {
            parent.requestDisallowInterceptTouchEvent(true);
            switch (this.f21297B) {
                case 0:
                    float f2 = this.f21325u + (x / 50.0f);
                    float f3 = this.f21326v - (y / 50.0f);
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    } else if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    r0 = f3 >= 0.0f ? f3 > 1.0f ? 1.0f : f3 : 0.0f;
                    this.f21325u = f2;
                    this.f21326v = r0;
                    z = true;
                    break;
                case 1:
                    float f4 = this.f21324t - (10.0f * y);
                    if (f4 >= 0.0f) {
                        r0 = f4 > 360.0f ? 360.0f : f4;
                    }
                    this.f21324t = r0;
                    z = true;
                    break;
                case 2:
                    if (this.f21330z && this.f21302G != null) {
                        int i = (int) (this.f21323s - (10 * x));
                        if (i < 0) {
                            i = 0;
                        } else if (i > 255) {
                            i = 255;
                        }
                        this.f21323s = i;
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                    break;
            }
            if (!z) {
                if (this.f21311g != null) {
                    this.f21311g.mo20080a(Color.HSVToColor(this.f21323s, new float[]{this.f21324t, this.f21325u, this.f21326v}));
                }
                m20078a();
                return true;
            }
            return super.onTrackballEvent(motionEvent);
        }
        parent.requestDisallowInterceptTouchEvent(false);
        z = false;
        if (!z) {
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean m20064a;
        ViewParent parent = getParent();
        switch (motionEvent.getAction()) {
            case 0:
                this.f21296A = true;
                parent.requestDisallowInterceptTouchEvent(true);
                this.f21304I = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
                m20064a = m20064a(motionEvent);
                break;
            case 1:
                this.f21296A = false;
                parent.requestDisallowInterceptTouchEvent(false);
                this.f21304I = (Point) null;
                m20064a = m20064a(motionEvent);
                break;
            case 2:
                parent.requestDisallowInterceptTouchEvent(true);
                m20064a = m20064a(motionEvent);
                break;
            default:
                m20064a = false;
                break;
        }
        if (m20064a) {
            if (this.f21311g != null) {
                this.f21311g.mo20080a(Color.HSVToColor(this.f21323s, new float[]{this.f21324t, this.f21325u, this.f21326v}));
            }
            m20078a();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    public void m20078a() {
        if (Build.VERSION.SDK_INT >= 16) {
            postInvalidateOnAnimation();
        } else {
            postInvalidateDelayed(16L);
        }
    }

    /* renamed from: a */
    private boolean m20064a(MotionEvent motionEvent) {
        boolean z = true;
        if (this.f21304I == null) {
            return false;
        }
        int i = this.f21304I.f60x;
        int i2 = this.f21304I.f61y;
        if (this.f21301F.contains(i, i2)) {
            this.f21297B = 1;
            this.f21324t = m20065b(motionEvent.getY());
        } else if (this.f21300E.contains(i, i2)) {
            this.f21297B = 0;
            float[] m20070b = m20070b(motionEvent.getX(), motionEvent.getY());
            this.f21325u = m20070b[0];
            this.f21326v = m20070b[1];
        } else if (this.f21302G == null || !this.f21302G.contains(i, i2)) {
            z = false;
        } else {
            this.f21297B = 2;
            this.f21323s = m20066b((int) motionEvent.getX());
        }
        return z;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int m20059a = m20059a(mode, size);
        int m20067b = m20067b(mode2, size2);
        if (!this.f21330z) {
            int i3 = (int) ((m20059a - this.f21307c) - this.f21305a);
            if (i3 > m20067b) {
                m20059a = (int) (m20067b + this.f21307c + this.f21305a);
            } else {
                m20067b = i3;
            }
        } else {
            int i4 = (int) ((m20067b - this.f21306b) + this.f21305a);
            if (i4 > m20059a) {
                m20067b = (int) ((m20059a - this.f21305a) + this.f21306b);
            } else {
                m20059a = i4;
            }
        }
        setMeasuredDimension(m20059a, m20067b);
    }

    /* renamed from: a */
    private int m20059a(int i, int i2) {
        int prefferedWidth = getPrefferedWidth();
        return (i2 > prefferedWidth || i == Integer.MIN_VALUE || i == 1073741824) ? i2 : prefferedWidth;
    }

    /* renamed from: b */
    private int m20067b(int i, int i2) {
        int prefferedHeight = getPrefferedHeight();
        return (i2 > prefferedHeight || i == Integer.MIN_VALUE || i == 1073741824) ? i2 : prefferedHeight;
    }

    private int getPrefferedWidth() {
        int prefferedHeight = getPrefferedHeight();
        if (this.f21330z) {
            prefferedHeight = (int) (prefferedHeight - (this.f21307c + this.f21306b));
        }
        return (int) (prefferedHeight + this.f21305a + this.f21307c);
    }

    private int getPrefferedHeight() {
        int i = (int) (200 * this.f21310f);
        if (this.f21330z) {
            return (int) (i + this.f21307c + this.f21306b);
        }
        return i;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f21299D = new RectF();
        this.f21299D.left = this.f21298C + getPaddingLeft();
        this.f21299D.right = (i - this.f21298C) - getPaddingRight();
        this.f21299D.top = this.f21298C + getPaddingTop();
        this.f21299D.bottom = (i2 - this.f21298C) - getPaddingBottom();
        m20075f();
        m20076g();
        m20077h();
    }

    /* renamed from: f */
    private void m20075f() {
        RectF rectF = this.f21299D;
        float height = rectF.height() - 2.0f;
        if (this.f21330z) {
            height -= this.f21307c + this.f21306b;
        }
        float f2 = rectF.left + 1.0f;
        float f3 = rectF.top + 1.0f;
        this.f21300E = new RectF(f2, f3, height + f2, f3 + height);
    }

    /* renamed from: g */
    private void m20076g() {
        RectF rectF = this.f21299D;
        this.f21301F = new RectF((rectF.right - this.f21305a) + 1.0f, rectF.top + 1.0f, rectF.right - 1.0f, (rectF.bottom - 1.0f) - (this.f21330z ? this.f21307c + this.f21306b : 0));
    }

    /* renamed from: h */
    private void m20077h() {
        if (this.f21330z) {
            RectF rectF = this.f21299D;
            this.f21302G = new RectF(rectF.left + 1.0f, (rectF.bottom - this.f21306b) + 1.0f, rectF.right - 1.0f, rectF.bottom - 1.0f);
            this.f21303H = new C3319a((int) (5 * this.f21310f));
            this.f21303H.setBounds(Math.round(this.f21302G.left), Math.round(this.f21302G.top), Math.round(this.f21302G.right), Math.round(this.f21302G.bottom));
        }
    }

    public void setOnColorChangedListener(InterfaceC3318a interfaceC3318a) {
        this.f21311g = interfaceC3318a;
    }

    public void setBorderColor(int i) {
        this.f21329y = i;
        m20078a();
    }

    public int getBorderColor() {
        return this.f21329y;
    }

    public int getColor() {
        return Color.HSVToColor(this.f21323s, new float[]{this.f21324t, this.f21325u, this.f21326v});
    }

    public void setColor(int i) {
        m20079a(i, false);
    }

    /* renamed from: a */
    public void m20079a(int i, boolean z) {
        int alpha = Color.alpha(i);
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        this.f21323s = alpha;
        this.f21324t = fArr[0];
        this.f21325u = fArr[1];
        this.f21326v = fArr[2];
        if (z && this.f21311g != null) {
            this.f21311g.mo20080a(Color.HSVToColor(this.f21323s, new float[]{this.f21324t, this.f21325u, this.f21326v}));
        }
        m20078a();
    }

    public float getDrawingOffset() {
        return this.f21298C;
    }

    public void setAlphaSliderVisible(boolean z) {
        if (this.f21330z) {
            if (z) {
                return;
            }
        } else if (!z) {
            return;
        }
        this.f21330z = z;
        this.f21319o = (Shader) null;
        this.f21320p = (Shader) null;
        this.f21321q = (Shader) null;
        this.f21322r = (Shader) null;
        requestLayout();
    }

    public boolean getAlphaSliderVisible() {
        return this.f21330z;
    }

    public void setSliderTrackerColor(int i) {
        this.f21328x = i;
        this.f21315k.setColor(this.f21328x);
        m20078a();
    }

    public int getSliderTrackerColor() {
        return this.f21328x;
    }

    public void setAlphaSliderText(int i) {
        setAlphaSliderText(getContext().getString(i));
    }

    public void setAlphaSliderText(String str) {
        this.f21327w = str;
        m20078a();
    }

    public String getAlphaSliderText() {
        return this.f21327w;
    }
}
