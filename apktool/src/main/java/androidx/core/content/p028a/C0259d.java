package androidx.core.content.p028a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.C0225a;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: GradientColorInflaterCompat.java */
/* renamed from: androidx.core.content.a.d */
/* loaded from: classes.dex */
final class C0259d {
    /* renamed from: a */
    static Shader m1902a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0225a.d.GradientColor);
        float m1924a = C0262g.m1924a(m1928a, xmlPullParser, "startX", C0225a.d.GradientColor_android_startX, 0.0f);
        float m1924a2 = C0262g.m1924a(m1928a, xmlPullParser, "startY", C0225a.d.GradientColor_android_startY, 0.0f);
        float m1924a3 = C0262g.m1924a(m1928a, xmlPullParser, "endX", C0225a.d.GradientColor_android_endX, 0.0f);
        float m1924a4 = C0262g.m1924a(m1928a, xmlPullParser, "endY", C0225a.d.GradientColor_android_endY, 0.0f);
        float m1924a5 = C0262g.m1924a(m1928a, xmlPullParser, "centerX", C0225a.d.GradientColor_android_centerX, 0.0f);
        float m1924a6 = C0262g.m1924a(m1928a, xmlPullParser, "centerY", C0225a.d.GradientColor_android_centerY, 0.0f);
        int m1925a = C0262g.m1925a(m1928a, xmlPullParser, "type", C0225a.d.GradientColor_android_type, 0);
        int m1933b = C0262g.m1933b(m1928a, xmlPullParser, "startColor", C0225a.d.GradientColor_android_startColor, 0);
        boolean m1932a = C0262g.m1932a(xmlPullParser, "centerColor");
        int m1933b2 = C0262g.m1933b(m1928a, xmlPullParser, "centerColor", C0225a.d.GradientColor_android_centerColor, 0);
        int m1933b3 = C0262g.m1933b(m1928a, xmlPullParser, "endColor", C0225a.d.GradientColor_android_endColor, 0);
        int m1925a2 = C0262g.m1925a(m1928a, xmlPullParser, "tileMode", C0225a.d.GradientColor_android_tileMode, 0);
        float m1924a7 = C0262g.m1924a(m1928a, xmlPullParser, "gradientRadius", C0225a.d.GradientColor_android_gradientRadius, 0.0f);
        m1928a.recycle();
        a m1903a = m1903a(m1904b(resources, xmlPullParser, attributeSet, theme), m1933b, m1933b3, m1932a, m1933b2);
        switch (m1925a) {
            case 1:
                if (m1924a7 <= 0.0f) {
                    throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                }
                return new RadialGradient(m1924a5, m1924a6, m1924a7, m1903a.f2032a, m1903a.f2033b, m1901a(m1925a2));
            case 2:
                return new SweepGradient(m1924a5, m1924a6, m1903a.f2032a, m1903a.f2033b);
            default:
                return new LinearGradient(m1924a, m1924a2, m1924a3, m1924a4, m1903a.f2032a, m1903a.f2033b, m1901a(m1925a2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        throw new org.xmlpull.p291v1.XmlPullParserException(r8.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a m1904b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0225a.d.GradientColorItem);
                boolean hasValue = m1928a.hasValue(C0225a.d.GradientColorItem_android_color);
                boolean hasValue2 = m1928a.hasValue(C0225a.d.GradientColorItem_android_offset);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = m1928a.getColor(C0225a.d.GradientColorItem_android_color, 0);
                float f2 = m1928a.getFloat(C0225a.d.GradientColorItem_android_offset, 0.0f);
                m1928a.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f2));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    /* renamed from: a */
    private static a m1903a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar == null) {
            if (z) {
                return new a(i, i3, i2);
            }
            return new a(i, i2);
        }
        return aVar;
    }

    /* renamed from: a */
    private static Shader.TileMode m1901a(int i) {
        switch (i) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }

    /* compiled from: GradientColorInflaterCompat.java */
    /* renamed from: androidx.core.content.a.d$a */
    static final class a {

        /* renamed from: a */
        final int[] f2032a;

        /* renamed from: b */
        final float[] f2033b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f2032a = new int[size];
            this.f2033b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f2032a[i] = list.get(i).intValue();
                this.f2033b[i] = list2.get(i).floatValue();
            }
        }

        a(int i, int i2) {
            this.f2032a = new int[]{i, i2};
            this.f2033b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.f2032a = new int[]{i, i2, i3};
            this.f2033b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
