package androidx.appcompat.widget;

import android.C0012R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.core.graphics.C0311a;

/* compiled from: ThemeUtils.java */
/* renamed from: androidx.appcompat.widget.au */
/* loaded from: classes.dex */
public class C0179au {

    /* renamed from: i */
    private static final ThreadLocal<TypedValue> f1578i = new ThreadLocal<>();

    /* renamed from: a */
    static final int[] f1570a = {-16842910};

    /* renamed from: b */
    static final int[] f1571b = {C0012R.attr.state_focused};

    /* renamed from: c */
    static final int[] f1572c = {C0012R.attr.state_activated};

    /* renamed from: d */
    static final int[] f1573d = {C0012R.attr.state_pressed};

    /* renamed from: e */
    static final int[] f1574e = {C0012R.attr.state_checked};

    /* renamed from: f */
    static final int[] f1575f = {C0012R.attr.state_selected};

    /* renamed from: g */
    static final int[] f1576g = {-16842919, -16842908};

    /* renamed from: h */
    static final int[] f1577h = new int[0];

    /* renamed from: j */
    private static final int[] f1579j = new int[1];

    /* renamed from: a */
    public static int m1419a(Context context, int i) {
        f1579j[0] = i;
        C0184az m1431a = C0184az.m1431a(context, (AttributeSet) null, f1579j);
        try {
            return m1431a.m1439b(0, 0);
        } finally {
            m1431a.m1441b();
        }
    }

    /* renamed from: b */
    public static ColorStateList m1423b(Context context, int i) {
        f1579j[0] = i;
        C0184az m1431a = C0184az.m1431a(context, (AttributeSet) null, f1579j);
        try {
            return m1431a.m1447e(0);
        } finally {
            m1431a.m1441b();
        }
    }

    /* renamed from: c */
    public static int m1424c(Context context, int i) {
        ColorStateList m1423b = m1423b(context, i);
        if (m1423b != null && m1423b.isStateful()) {
            return m1423b.getColorForState(f1570a, m1423b.getDefaultColor());
        }
        TypedValue m1421a = m1421a();
        context.getTheme().resolveAttribute(C0012R.attr.disabledAlpha, m1421a, true);
        return m1420a(context, i, m1421a.getFloat());
    }

    /* renamed from: a */
    private static TypedValue m1421a() {
        TypedValue typedValue = f1578i.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f1578i.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* renamed from: a */
    static int m1420a(Context context, int i, float f2) {
        return C0311a.m2309b(m1419a(context, i), Math.round(Color.alpha(r0) * f2));
    }

    /* renamed from: a */
    public static void m1422a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C0059a.j.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(C0059a.j.AppCompatTheme_windowActionBar)) {
                Log.m184e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
