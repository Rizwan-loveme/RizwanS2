package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.p008os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0308x;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* renamed from: androidx.appcompat.widget.ac */
/* loaded from: classes.dex */
class C0161ac {

    /* renamed from: a */
    private static final RectF f1394a = new RectF();

    /* renamed from: b */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> f1395b = new ConcurrentHashMap<>();

    /* renamed from: c */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> f1396c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private int f1397d = 0;

    /* renamed from: e */
    private boolean f1398e = false;

    /* renamed from: f */
    private float f1399f = -1.0f;

    /* renamed from: g */
    private float f1400g = -1.0f;

    /* renamed from: h */
    private float f1401h = -1.0f;

    /* renamed from: i */
    private int[] f1402i = new int[0];

    /* renamed from: j */
    private boolean f1403j = false;

    /* renamed from: k */
    private TextPaint f1404k;

    /* renamed from: l */
    private final TextView f1405l;

    /* renamed from: m */
    private final Context f1406m;

    /* renamed from: n */
    private final a f1407n;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: androidx.appcompat.widget.ac$a */
    private static class a {
        a() {
        }

        /* renamed from: a */
        boolean mo1227a(TextView textView) {
            return ((Boolean) C0161ac.m1197a(textView, "getHorizontallyScrolling", false)).booleanValue();
        }

        /* renamed from: a */
        void mo1226a(StaticLayout.Builder builder, TextView textView) {
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: androidx.appcompat.widget.ac$b */
    private static class b extends a {
        b() {
        }

        @Override // androidx.appcompat.widget.C0161ac.a
        /* renamed from: a */
        void mo1226a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) C0161ac.m1197a(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: androidx.appcompat.widget.ac$c */
    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.C0161ac.a
        /* renamed from: a */
        boolean mo1227a(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // androidx.appcompat.widget.C0161ac.b, androidx.appcompat.widget.C0161ac.a
        /* renamed from: a */
        void mo1226a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    C0161ac(TextView textView) {
        this.f1405l = textView;
        this.f1406m = this.f1405l.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1407n = new c();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.f1407n = new b();
        } else {
            this.f1407n = new a();
        }
    }

    /* renamed from: a */
    void m1217a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1406m.obtainStyledAttributes(attributeSet, C0059a.j.AppCompatTextView, i, 0);
        C0308x.m2230a(this.f1405l, this.f1405l.getContext(), C0059a.j.AppCompatTextView, attributeSet, obtainStyledAttributes, i, 0);
        if (obtainStyledAttributes.hasValue(C0059a.j.AppCompatTextView_autoSizeTextType)) {
            this.f1397d = obtainStyledAttributes.getInt(C0059a.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(C0059a.j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(C0059a.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(C0059a.j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(C0059a.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(C0059a.j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(C0059a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(C0059a.j.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(C0059a.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m1201a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (m1211k()) {
            if (this.f1397d == 1) {
                if (!this.f1403j) {
                    DisplayMetrics displayMetrics = this.f1406m.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    m1200a(dimension2, dimension3, dimension);
                }
                m1209i();
                return;
            }
            return;
        }
        this.f1397d = 0;
    }

    /* renamed from: a */
    void m1214a(int i) {
        if (m1211k()) {
            switch (i) {
                case 0:
                    m1210j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f1406m.getResources().getDisplayMetrics();
                    m1200a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m1209i()) {
                        m1224f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    /* renamed from: a */
    void m1216a(int i, int i2, int i3, int i4) {
        if (m1211k()) {
            DisplayMetrics displayMetrics = this.f1406m.getResources().getDisplayMetrics();
            m1200a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m1209i()) {
                m1224f();
            }
        }
    }

    /* renamed from: a */
    void m1218a(int[] iArr, int i) {
        if (m1211k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1406m.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f1402i = m1203a(iArr2);
                if (!m1208h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1403j = false;
            }
            if (m1209i()) {
                m1224f();
            }
        }
    }

    /* renamed from: a */
    int m1212a() {
        return this.f1397d;
    }

    /* renamed from: b */
    int m1219b() {
        return Math.round(this.f1399f);
    }

    /* renamed from: c */
    int m1221c() {
        return Math.round(this.f1400g);
    }

    /* renamed from: d */
    int m1222d() {
        return Math.round(this.f1401h);
    }

    /* renamed from: e */
    int[] m1223e() {
        return this.f1402i;
    }

    /* renamed from: a */
    private void m1201a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1402i = m1203a(iArr);
            m1208h();
        }
    }

    /* renamed from: h */
    private boolean m1208h() {
        this.f1403j = this.f1402i.length > 0;
        if (this.f1403j) {
            this.f1397d = 1;
            this.f1400g = this.f1402i[0];
            this.f1401h = this.f1402i[r3 - 1];
            this.f1399f = -1.0f;
        }
        return this.f1403j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private int[] m1203a(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
            }
        }
        return iArr;
    }

    /* renamed from: a */
    private void m1200a(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
        this.f1397d = 1;
        this.f1400g = f2;
        this.f1401h = f3;
        this.f1399f = f4;
        this.f1403j = false;
    }

    /* renamed from: i */
    private boolean m1209i() {
        if (m1211k() && this.f1397d == 1) {
            if (!this.f1403j || this.f1402i.length == 0) {
                int floor = ((int) Math.floor((this.f1401h - this.f1400g) / this.f1399f)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.f1400g + (i * this.f1399f));
                }
                this.f1402i = m1203a(iArr);
            }
            this.f1398e = true;
        } else {
            this.f1398e = false;
        }
        return this.f1398e;
    }

    /* renamed from: f */
    void m1224f() {
        int measuredWidth;
        if (m1225g()) {
            if (this.f1398e) {
                if (this.f1405l.getMeasuredHeight() > 0 && this.f1405l.getMeasuredWidth() > 0) {
                    if (this.f1407n.mo1227a(this.f1405l)) {
                        measuredWidth = 1048576;
                    } else {
                        measuredWidth = (this.f1405l.getMeasuredWidth() - this.f1405l.getTotalPaddingLeft()) - this.f1405l.getTotalPaddingRight();
                    }
                    int height = (this.f1405l.getHeight() - this.f1405l.getCompoundPaddingBottom()) - this.f1405l.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (f1394a) {
                            f1394a.setEmpty();
                            f1394a.right = measuredWidth;
                            f1394a.bottom = height;
                            float m1195a = m1195a(f1394a);
                            if (m1195a != this.f1405l.getTextSize()) {
                                m1215a(0, m1195a);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1398e = true;
        }
    }

    /* renamed from: j */
    private void m1210j() {
        this.f1397d = 0;
        this.f1400g = -1.0f;
        this.f1401h = -1.0f;
        this.f1399f = -1.0f;
        this.f1402i = new int[0];
        this.f1398e = false;
    }

    /* renamed from: a */
    void m1215a(int i, float f2) {
        Resources resources;
        if (this.f1406m == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.f1406m.getResources();
        }
        m1199a(TypedValue.applyDimension(i, f2, resources.getDisplayMetrics()));
    }

    /* renamed from: a */
    private void m1199a(float f2) {
        if (f2 != this.f1405l.getPaint().getTextSize()) {
            this.f1405l.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1405l.isInLayout() : false;
            if (this.f1405l.getLayout() != null) {
                this.f1398e = false;
                try {
                    Method m1198a = m1198a("nullLayouts");
                    if (m1198a != null) {
                        m1198a.invoke(this.f1405l, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.m191w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f1405l.requestLayout();
                } else {
                    this.f1405l.forceLayout();
                }
                this.f1405l.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m1195a(RectF rectF) {
        int length = this.f1402i.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 0;
        int i2 = length - 1;
        int i3 = 1;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            if (m1202a(this.f1402i[i4], rectF)) {
                i = i3;
                i3 = i4 + 1;
            } else {
                int i5 = i4 - 1;
                i2 = i5;
                i = i5;
            }
        }
        return this.f1402i[i];
    }

    /* renamed from: b */
    void m1220b(int i) {
        if (this.f1404k == null) {
            this.f1404k = new TextPaint();
        } else {
            this.f1404k.reset();
        }
        this.f1404k.set(this.f1405l.getPaint());
        this.f1404k.setTextSize(i);
    }

    /* renamed from: a */
    StaticLayout m1213a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return m1205b(charSequence, alignment, i, i2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return m1196a(charSequence, alignment, i);
        }
        return m1204b(charSequence, alignment, i);
    }

    /* renamed from: a */
    private boolean m1202a(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1405l.getText();
        TransformationMethod transformationMethod = this.f1405l.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1405l)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1405l.getMaxLines() : -1;
        m1220b(i);
        StaticLayout m1213a = m1213a(text, (Layout.Alignment) m1197a(this.f1405l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        if (maxLines == -1 || (m1213a.getLineCount() <= maxLines && m1213a.getLineEnd(m1213a.getLineCount() - 1) == text.length())) {
            return ((float) m1213a.getHeight()) <= rectF.bottom;
        }
        return false;
    }

    /* renamed from: b */
    private StaticLayout m1205b(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1404k, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f1405l.getLineSpacingExtra(), this.f1405l.getLineSpacingMultiplier()).setIncludePad(this.f1405l.getIncludeFontPadding()).setBreakStrategy(this.f1405l.getBreakStrategy()).setHyphenationFrequency(this.f1405l.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            this.f1407n.mo1226a(obtain, this.f1405l);
        } catch (ClassCastException e2) {
            Log.m190w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    /* renamed from: a */
    private StaticLayout m1196a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1404k, i, alignment, this.f1405l.getLineSpacingMultiplier(), this.f1405l.getLineSpacingExtra(), this.f1405l.getIncludeFontPadding());
    }

    /* renamed from: b */
    private StaticLayout m1204b(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f1404k, i, alignment, ((Float) m1206b(this.f1405l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) m1206b(this.f1405l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) m1206b(this.f1405l, "mIncludePad", true)).booleanValue());
    }

    /* renamed from: a */
    static <T> T m1197a(Object obj, String str, T t) {
        boolean z = false;
        try {
            try {
                T t2 = (T) m1198a(str).invoke(obj, new Object[0]);
                if (t2 == null) {
                }
                return t2;
            } catch (Exception e2) {
                z = true;
                Log.m191w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
                if (0 != 0) {
                    return null;
                }
                return t;
            }
        } catch (Throwable th) {
            if (0 != 0 || z) {
            }
            throw th;
        }
    }

    /* renamed from: b */
    private static <T> T m1206b(Object obj, String str, T t) {
        try {
            Field m1207b = m1207b(str);
            if (m1207b != null) {
                return (T) m1207b.get(obj);
            }
            return t;
        } catch (IllegalAccessException e2) {
            Log.m191w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return t;
        }
    }

    /* renamed from: a */
    private static Method m1198a(String str) {
        try {
            Method method = f1395b.get(str);
            if (method == null) {
                Method declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    f1395b.put(str, declaredMethod);
                    return declaredMethod;
                }
                return declaredMethod;
            }
            return method;
        } catch (Exception e2) {
            Log.m191w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    /* renamed from: b */
    private static Field m1207b(String str) {
        try {
            Field field = f1396c.get(str);
            if (field == null) {
                Field declaredField = TextView.class.getDeclaredField(str);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    f1396c.put(str, declaredField);
                    return declaredField;
                }
                return declaredField;
            }
            return field;
        } catch (NoSuchFieldException e2) {
            Log.m191w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }

    /* renamed from: g */
    boolean m1225g() {
        return m1211k() && this.f1397d != 0;
    }

    /* renamed from: k */
    private boolean m1211k() {
        return !(this.f1405l instanceof C0202l);
    }
}
