package androidx.core.content.p028a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.C0225a;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: ColorStateListInflaterCompat.java */
/* renamed from: androidx.core.content.a.a */
/* loaded from: classes.dex */
public final class C0256a {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f2017a = new ThreadLocal<>();

    /* renamed from: a */
    public static ColorStateList m1858a(Resources resources, int i, Resources.Theme theme) {
        try {
            return m1859a(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.m185e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static ColorStateList m1859a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return m1860a(resources, xmlPullParser, asAttributeSet, theme);
    }

    /* renamed from: a */
    public static ColorStateList m1860a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        return m1864b(resources, xmlPullParser, attributeSet, theme);
    }

    /* renamed from: b */
    private static ColorStateList m1864b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        int i;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray m1861a = m1861a(resources, theme, attributeSet, C0225a.d.ColorStateListItem);
                int resourceId = m1861a.getResourceId(C0225a.d.ColorStateListItem_android_color, -1);
                if (resourceId != -1 && !m1863a(resources, resourceId)) {
                    try {
                        color = m1859a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception e2) {
                        color = m1861a.getColor(C0225a.d.ColorStateListItem_android_color, Color.MAGENTA);
                    }
                } else {
                    color = m1861a.getColor(C0225a.d.ColorStateListItem_android_color, Color.MAGENTA);
                }
                float f2 = 1.0f;
                if (m1861a.hasValue(C0225a.d.ColorStateListItem_android_alpha)) {
                    f2 = m1861a.getFloat(C0225a.d.ColorStateListItem_android_alpha, 1.0f);
                } else if (m1861a.hasValue(C0225a.d.ColorStateListItem_alpha)) {
                    f2 = m1861a.getFloat(C0225a.d.ColorStateListItem_alpha, 1.0f);
                }
                m1861a.recycle();
                int i3 = 0;
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i4 = 0;
                while (i4 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == C0225a.a.alpha) {
                        i = i3;
                    } else {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i3] = attributeNameResource;
                        i = i5;
                    }
                    i4++;
                    i3 = i;
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i3);
                iArr2 = C0260e.m1906a(iArr2, i2, m1857a(color, f2));
                int[][] iArr4 = (int[][]) C0260e.m1907a(iArr, i2, trimStateSet);
                i2++;
                iArr = iArr4;
            }
        }
        int[] iArr5 = new int[i2];
        int[][] iArr6 = new int[i2][];
        System.arraycopy(iArr2, 0, iArr5, 0, i2);
        System.arraycopy(iArr, 0, iArr6, 0, i2);
        return new ColorStateList(iArr6, iArr5);
    }

    /* renamed from: a */
    private static boolean m1863a(Resources resources, int i) {
        TypedValue m1862a = m1862a();
        resources.getValue(i, m1862a, true);
        return m1862a.type >= 28 && m1862a.type <= 31;
    }

    /* renamed from: a */
    private static TypedValue m1862a() {
        TypedValue typedValue = f2017a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f2017a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* renamed from: a */
    private static TypedArray m1861a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    private static int m1857a(int i, float f2) {
        return (Math.round(Color.alpha(i) * f2) << 24) | (16777215 & i);
    }
}
