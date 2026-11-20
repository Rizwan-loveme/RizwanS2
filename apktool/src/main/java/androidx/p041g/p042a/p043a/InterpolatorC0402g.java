package androidx.p041g.p042a.p043a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.p028a.C0262g;
import androidx.core.graphics.C0313c;
import org.xmlpull.p291v1.XmlPullParser;

/* compiled from: PathInterpolatorCompat.java */
/* renamed from: androidx.g.a.a.g */
/* loaded from: classes.dex */
public class InterpolatorC0402g implements Interpolator {

    /* renamed from: a */
    private float[] f2955a;

    /* renamed from: b */
    private float[] f2956b;

    public InterpolatorC0402g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public InterpolatorC0402g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2939l);
        m3228a(m1928a, xmlPullParser);
        m1928a.recycle();
    }

    /* renamed from: a */
    private void m3228a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (C0262g.m1932a(xmlPullParser, "pathData")) {
            String m1930a = C0262g.m1930a(typedArray, xmlPullParser, "pathData", 4);
            Path m2317a = C0313c.m2317a(m1930a);
            if (m2317a == null) {
                throw new InflateException("The path is null, which is created from " + m1930a);
            }
            m3229a(m2317a);
            return;
        }
        if (!C0262g.m1932a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!C0262g.m1932a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float m1924a = C0262g.m1924a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float m1924a2 = C0262g.m1924a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean m1932a = C0262g.m1932a(xmlPullParser, "controlX2");
        if (m1932a != C0262g.m1932a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (!m1932a) {
            m3226a(m1924a, m1924a2);
        } else {
            m3227a(m1924a, m1924a2, C0262g.m1924a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), C0262g.m1924a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        }
    }

    /* renamed from: a */
    private void m3226a(float f2, float f3) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f2, f3, 1.0f, 1.0f);
        m3229a(path);
    }

    /* renamed from: a */
    private void m3227a(float f2, float f3, float f4, float f5) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f2, f3, f4, f5, 1.0f, 1.0f);
        m3229a(path);
    }

    /* renamed from: a */
    private void m3229a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f2955a = new float[min];
        this.f2956b = new float[min];
        float[] fArr = new float[2];
        for (int i = 0; i < min; i++) {
            pathMeasure.getPosTan((i * length) / (min - 1), fArr, null);
            this.f2955a[i] = fArr[0];
            this.f2956b[i] = fArr[1];
        }
        if (Math.abs(this.f2955a[0]) > 1.0E-5d || Math.abs(this.f2956b[0]) > 1.0E-5d || Math.abs(this.f2955a[min - 1] - 1.0f) > 1.0E-5d || Math.abs(this.f2956b[min - 1] - 1.0f) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.f2955a[0] + "," + this.f2956b[0] + " end:" + this.f2955a[min - 1] + "," + this.f2956b[min - 1]);
        }
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            int i4 = i3 + 1;
            float f3 = this.f2955a[i3];
            if (f3 < f2) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f3);
            }
            this.f2955a[i2] = f3;
            i2++;
            i3 = i4;
            f2 = f3;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f2955a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f2 < this.f2955a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f3 = this.f2955a[length] - this.f2955a[i];
        if (f3 == 0.0f) {
            return this.f2956b[i];
        }
        float f4 = (f2 - this.f2955a[i]) / f3;
        float f5 = this.f2956b[i];
        return ((this.f2956b[length] - f5) * f4) + f5;
    }
}
