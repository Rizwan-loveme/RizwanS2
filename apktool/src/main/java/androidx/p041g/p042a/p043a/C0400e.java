package androidx.p041g.p042a.p043a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.p028a.C0262g;
import androidx.core.graphics.C0313c;
import java.p209io.IOException;
import java.util.ArrayList;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: AnimatorInflaterCompat.java */
/* renamed from: androidx.g.a.a.e */
/* loaded from: classes.dex */
public class C0400e {
    /* renamed from: a */
    public static Animator m3207a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return m3208a(context, context.getResources(), context.getTheme(), i);
    }

    /* renamed from: a */
    public static Animator m3208a(Context context, Resources resources, Resources.Theme theme, int i) {
        return m3209a(context, resources, theme, i, 1.0f);
    }

    /* renamed from: a */
    public static Animator m3209a(Context context, Resources resources, Resources.Theme theme, int i, float f2) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    return m3210a(context, resources, theme, xmlResourceParser, f2);
                } catch (IOException e2) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e2);
                    throw notFoundException;
                }
            } catch (XmlPullParserException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    /* compiled from: AnimatorInflaterCompat.java */
    /* renamed from: androidx.g.a.a.e$a */
    private static class a implements TypeEvaluator<C0313c.b[]> {

        /* renamed from: a */
        private C0313c.b[] f2953a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0313c.b[] evaluate(float f2, C0313c.b[] bVarArr, C0313c.b[] bVarArr2) {
            if (!C0313c.m2320a(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!C0313c.m2320a(this.f2953a, bVarArr)) {
                this.f2953a = C0313c.m2322a(bVarArr);
            }
            for (int i = 0; i < bVarArr.length; i++) {
                this.f2953a[i].m2330a(bVarArr[i], bVarArr2[i], f2);
            }
            return this.f2953a;
        }
    }

    /* renamed from: a */
    private static PropertyValuesHolder m3216a(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolder;
        int i4;
        int i5;
        int i6;
        float f2;
        float f3;
        float f4;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i7 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i8 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            if ((z && m3222a(i7)) || (z2 && m3222a(i8))) {
                i = 3;
            } else {
                i = 0;
            }
        }
        boolean z3 = i == 0;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            C0313c.b[] m2324b = C0313c.m2324b(string);
            C0313c.b[] m2324b2 = C0313c.m2324b(string2);
            if (m2324b != null || m2324b2 != null) {
                if (m2324b != null) {
                    a aVar = new a();
                    if (m2324b2 == null) {
                        return PropertyValuesHolder.ofObject(str, aVar, m2324b);
                    }
                    if (C0313c.m2320a(m2324b, m2324b2)) {
                        return PropertyValuesHolder.ofObject(str, aVar, m2324b, m2324b2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                if (m2324b2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), m2324b2);
                }
            }
            return null;
        }
        C0401f c0401f = null;
        if (i == 3) {
            c0401f = C0401f.m3225a();
        }
        if (z3) {
            if (z) {
                if (i7 == 5) {
                    f3 = typedArray.getDimension(i2, 0.0f);
                } else {
                    f3 = typedArray.getFloat(i2, 0.0f);
                }
                if (z2) {
                    if (i8 == 5) {
                        f4 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f4 = typedArray.getFloat(i3, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f3, f4);
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f3);
                }
            } else {
                if (i8 == 5) {
                    f2 = typedArray.getDimension(i3, 0.0f);
                } else {
                    f2 = typedArray.getFloat(i3, 0.0f);
                }
                propertyValuesHolder = PropertyValuesHolder.ofFloat(str, f2);
            }
        } else if (z) {
            if (i7 == 5) {
                i5 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (m3222a(i7)) {
                i5 = typedArray.getColor(i2, 0);
            } else {
                i5 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (m3222a(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5, i6);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i5);
            }
        } else if (!z2) {
            propertyValuesHolder = null;
        } else {
            if (i8 == 5) {
                i4 = (int) typedArray.getDimension(i3, 0.0f);
            } else if (m3222a(i8)) {
                i4 = typedArray.getColor(i3, 0);
            } else {
                i4 = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i4);
        }
        if (propertyValuesHolder != null && c0401f != null) {
            propertyValuesHolder.setEvaluator(c0401f);
            return propertyValuesHolder;
        }
        return propertyValuesHolder;
    }

    /* renamed from: a */
    private static void m3219a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long m1925a = C0262g.m1925a(typedArray, xmlPullParser, "duration", 1, 300);
        long m1925a2 = C0262g.m1925a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int m1925a3 = C0262g.m1925a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (C0262g.m1932a(xmlPullParser, "valueFrom") && C0262g.m1932a(xmlPullParser, "valueTo")) {
            if (m1925a3 == 4) {
                m1925a3 = m3206a(typedArray, 5, 6);
            }
            PropertyValuesHolder m3216a = m3216a(typedArray, m1925a3, 5, 6, "");
            if (m3216a != null) {
                valueAnimator.setValues(m3216a);
            }
        }
        valueAnimator.setDuration(m1925a);
        valueAnimator.setStartDelay(m1925a2);
        valueAnimator.setRepeatCount(C0262g.m1925a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(C0262g.m1925a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m3218a(valueAnimator, typedArray2, m1925a3, f2, xmlPullParser);
        }
    }

    /* renamed from: a */
    private static void m3218a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String m1930a = C0262g.m1930a(typedArray, xmlPullParser, "pathData", 1);
        if (m1930a != null) {
            String m1930a2 = C0262g.m1930a(typedArray, xmlPullParser, "propertyXName", 2);
            String m1930a3 = C0262g.m1930a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i == 2 || i == 4) {
            }
            if (m1930a2 == null && m1930a3 == null) {
                throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
            }
            m3220a(C0313c.m2317a(m1930a), objectAnimator, 0.5f * f2, m1930a2, m1930a3);
            return;
        }
        objectAnimator.setPropertyName(C0262g.m1930a(typedArray, xmlPullParser, "propertyName", 0));
    }

    /* renamed from: a */
    private static void m3220a(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        int i;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f3 = 0.0f;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        do {
            f3 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f3));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int min = Math.min(100, ((int) (f3 / f2)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        int i2 = 0;
        float f4 = f3 / (min - 1);
        float f5 = 0.0f;
        int i3 = 0;
        while (i3 < min) {
            pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i3] = fArr3[0];
            fArr2[i3] = fArr3[1];
            f5 += f4;
            if (i2 + 1 >= arrayList.size() || f5 <= ((Float) arrayList.get(i2 + 1)).floatValue()) {
                i = i2;
            } else {
                i = i2 + 1;
                pathMeasure2.nextContour();
            }
            i3++;
            i2 = i;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (str != null) {
            propertyValuesHolder = PropertyValuesHolder.ofFloat(str, fArr);
        }
        if (str2 != null) {
            propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str2, fArr2);
        }
        if (propertyValuesHolder == null) {
            objectAnimator.setValues(propertyValuesHolder2);
        } else if (propertyValuesHolder2 == null) {
            objectAnimator.setValues(propertyValuesHolder);
        } else {
            objectAnimator.setValues(propertyValuesHolder, propertyValuesHolder2);
        }
    }

    /* renamed from: a */
    private static Animator m3210a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) {
        return m3211a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00f7, code lost:
    
        if (r9.hasNext() == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x00f9, code lost:
    
        r8[r6] = (android.animation.Animator) r9.next();
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0105, code lost:
    
        if (r23 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0107, code lost:
    
        r22.playTogether(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x010d, code lost:
    
        r22.playSequentially(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x010c, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00e3, code lost:
    
        if (r22 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00e5, code lost:
    
        if (r13 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00e7, code lost:
    
        r8 = new android.animation.Animator[r13.size()];
        r9 = r13.iterator();
        r6 = 0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animator m3211a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f2) {
        boolean z;
        Animator animator = null;
        ArrayList arrayList = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = m3214a(context, resources, theme, attributeSet, f2, xmlPullParser);
                        z = false;
                    } else if (name.equals("animator")) {
                        animator = m3217a(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                        z = false;
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2935h);
                        m3211a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, C0262g.m1925a(m1928a, xmlPullParser, "ordering", 0, 0), f2);
                        m1928a.recycle();
                        z = false;
                        animator = animatorSet2;
                    } else if (name.equals("propertyValuesHolder")) {
                        PropertyValuesHolder[] m3223a = m3223a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (m3223a != null && (animator instanceof ValueAnimator)) {
                            ((ValueAnimator) animator).setValues(m3223a);
                        }
                        z = true;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet != null && !z) {
                        ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                        arrayList2.add(animator);
                        arrayList = arrayList2;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static PropertyValuesHolder[] m3223a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2936i);
                    String m1930a = C0262g.m1930a(m1928a, xmlPullParser, "propertyName", 3);
                    int m1925a = C0262g.m1925a(m1928a, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder m3215a = m3215a(context, resources, theme, xmlPullParser, m1930a, m1925a);
                    PropertyValuesHolder m3216a = m3215a == null ? m3216a(m1928a, m1925a, 0, 1, m1930a) : m3215a;
                    if (m3216a != null) {
                        arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList.add(m3216a);
                    } else {
                        arrayList = arrayList2;
                    }
                    m1928a.recycle();
                } else {
                    arrayList = arrayList2;
                }
                xmlPullParser.next();
                arrayList2 = arrayList;
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        int size = arrayList2.size();
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
        for (int i = 0; i < size; i++) {
            propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList2.get(i);
        }
        return propertyValuesHolderArr;
    }

    /* renamed from: a */
    private static int m3205a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int i = 0;
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2937j);
        TypedValue m1934b = C0262g.m1934b(m1928a, xmlPullParser, "value", 0);
        if ((m1934b != null) && m3222a(m1934b.type)) {
            i = 3;
        }
        m1928a.recycle();
        return i;
    }

    /* renamed from: a */
    private static int m3206a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        boolean z = peekValue != null;
        int i3 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        boolean z2 = peekValue2 != null;
        return ((z && m3222a(i3)) || (z2 && m3222a(z2 ? peekValue2.type : 0))) ? 3 : 0;
    }

    /* renamed from: a */
    private static PropertyValuesHolder m3215a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int size;
        int i2;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        int i3 = i;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = m3205a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe m3213a = m3213a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (m3213a != null) {
                    arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList.add(m3213a);
                } else {
                    arrayList = arrayList2;
                }
                xmlPullParser.next();
            } else {
                arrayList = arrayList2;
            }
            arrayList2 = arrayList;
        }
        if (arrayList2 == null || (size = arrayList2.size()) <= 0) {
            return null;
        }
        Keyframe keyframe = (Keyframe) arrayList2.get(0);
        Keyframe keyframe2 = (Keyframe) arrayList2.get(size - 1);
        float fraction = keyframe2.getFraction();
        if (fraction >= 1.0f) {
            i2 = size;
        } else if (fraction < 0.0f) {
            keyframe2.setFraction(1.0f);
            i2 = size;
        } else {
            arrayList2.add(arrayList2.size(), m3212a(keyframe2, 1.0f));
            i2 = size + 1;
        }
        float fraction2 = keyframe.getFraction();
        if (fraction2 != 0.0f) {
            if (fraction2 < 0.0f) {
                keyframe.setFraction(0.0f);
            } else {
                arrayList2.add(0, m3212a(keyframe, 0.0f));
                i2++;
            }
        }
        Keyframe[] keyframeArr = new Keyframe[i2];
        arrayList2.toArray(keyframeArr);
        for (int i4 = 0; i4 < i2; i4++) {
            Keyframe keyframe3 = keyframeArr[i4];
            if (keyframe3.getFraction() < 0.0f) {
                if (i4 == 0) {
                    keyframe3.setFraction(0.0f);
                } else if (i4 == i2 - 1) {
                    keyframe3.setFraction(1.0f);
                } else {
                    int i5 = i4;
                    for (int i6 = i4 + 1; i6 < i2 - 1 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                        i5 = i6;
                    }
                    m3221a(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i4 - 1].getFraction(), i4, i5);
                }
            }
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
        if (i3 == 3) {
            ofKeyframe.setEvaluator(C0401f.m3225a());
            return ofKeyframe;
        }
        return ofKeyframe;
    }

    /* renamed from: a */
    private static Keyframe m3212a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    /* renamed from: a */
    private static void m3221a(Keyframe[] keyframeArr, float f2, int i, int i2) {
        float f3 = f2 / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f3);
            i++;
        }
    }

    /* renamed from: a */
    private static Keyframe m3213a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2937j);
        Keyframe keyframe = null;
        float m1924a = C0262g.m1924a(m1928a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue m1934b = C0262g.m1934b(m1928a, xmlPullParser, "value", 0);
        boolean z = m1934b != null;
        if (i == 4) {
            i = (z && m3222a(m1934b.type)) ? 3 : 0;
        }
        if (z) {
            switch (i) {
                case 0:
                    keyframe = Keyframe.ofFloat(m1924a, C0262g.m1924a(m1928a, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                case 3:
                    keyframe = Keyframe.ofInt(m1924a, C0262g.m1925a(m1928a, xmlPullParser, "value", 0, 0));
                    break;
            }
        } else {
            keyframe = i == 0 ? Keyframe.ofFloat(m1924a) : Keyframe.ofInt(m1924a);
        }
        int m1935c = C0262g.m1935c(m1928a, xmlPullParser, "interpolator", 1, 0);
        if (m1935c > 0) {
            keyframe.setInterpolator(C0399d.m3203a(context, m1935c));
        }
        m1928a.recycle();
        return keyframe;
    }

    /* renamed from: a */
    private static ObjectAnimator m3214a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m3217a(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    /* renamed from: a */
    private static ValueAnimator m3217a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray m1928a = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2934g);
        TypedArray m1928a2 = C0262g.m1928a(resources, theme, attributeSet, C0396a.f2938k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m3219a(valueAnimator, m1928a, m1928a2, f2, xmlPullParser);
        int m1935c = C0262g.m1935c(m1928a, xmlPullParser, "interpolator", 0, 0);
        if (m1935c > 0) {
            valueAnimator.setInterpolator(C0399d.m3203a(context, m1935c));
        }
        m1928a.recycle();
        if (m1928a2 != null) {
            m1928a2.recycle();
        }
        return valueAnimator;
    }

    /* renamed from: a */
    private static boolean m3222a(int i) {
        return i >= 28 && i <= 31;
    }
}
