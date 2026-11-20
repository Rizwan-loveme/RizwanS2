package androidx.core.content.p028a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.p291v1.XmlPullParser;

/* compiled from: TypedArrayUtils.java */
/* renamed from: androidx.core.content.a.g */
/* loaded from: classes.dex */
public class C0262g {
    /* renamed from: a */
    public static boolean m1932a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: a */
    public static float m1924a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f2) {
        return !m1932a(xmlPullParser, str) ? f2 : typedArray.getFloat(i, f2);
    }

    /* renamed from: a */
    public static boolean m1931a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m1932a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static int m1925a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m1932a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    public static int m1933b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m1932a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    public static C0257b m1929a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (m1932a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return C0257b.m1867a(typedValue.data);
            }
            C0257b m1869a = C0257b.m1869a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (m1869a != null) {
                return m1869a;
            }
        }
        return C0257b.m1867a(i2);
    }

    /* renamed from: a */
    public static ColorStateList m1926a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        if (m1932a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
            }
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return m1927a(typedValue);
            }
            return C0256a.m1858a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
        }
        return null;
    }

    /* renamed from: a */
    private static ColorStateList m1927a(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    /* renamed from: c */
    public static int m1935c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m1932a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    /* renamed from: a */
    public static String m1930a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m1932a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* renamed from: b */
    public static TypedValue m1934b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m1932a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    /* renamed from: a */
    public static TypedArray m1928a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
