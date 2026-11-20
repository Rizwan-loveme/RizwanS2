package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.content.p028a.C0261f;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.p033b.C0284a;
import androidx.core.widget.C0339i;
import androidx.core.widget.InterfaceC0332b;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: AppCompatTextHelper.java */
/* renamed from: androidx.appcompat.widget.aa */
/* loaded from: classes.dex */
class C0159aa {

    /* renamed from: a */
    private final TextView f1368a;

    /* renamed from: b */
    private C0182ax f1369b;

    /* renamed from: c */
    private C0182ax f1370c;

    /* renamed from: d */
    private C0182ax f1371d;

    /* renamed from: e */
    private C0182ax f1372e;

    /* renamed from: f */
    private C0182ax f1373f;

    /* renamed from: g */
    private C0182ax f1374g;

    /* renamed from: h */
    private C0182ax f1375h;

    /* renamed from: i */
    private final C0161ac f1376i;

    /* renamed from: j */
    private int f1377j = 0;

    /* renamed from: k */
    private int f1378k = -1;

    /* renamed from: l */
    private Typeface f1379l;

    /* renamed from: m */
    private boolean f1380m;

    C0159aa(TextView textView) {
        this.f1368a = textView;
        this.f1376i = new C0161ac(this.f1368a);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    void m1176a(AttributeSet attributeSet, int i) {
        Context context = this.f1368a.getContext();
        C0201k m1545b = C0201k.m1545b();
        C0184az m1432a = C0184az.m1432a(context, attributeSet, C0059a.j.AppCompatTextHelper, i, 0);
        C0308x.m2230a(this.f1368a, this.f1368a.getContext(), C0059a.j.AppCompatTextHelper, attributeSet, m1432a.m1435a(), i, 0);
        int m1450g = m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (m1432a.m1451g(C0059a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f1369b = m1163a(context, m1545b, m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (m1432a.m1451g(C0059a.j.AppCompatTextHelper_android_drawableTop)) {
            this.f1370c = m1163a(context, m1545b, m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (m1432a.m1451g(C0059a.j.AppCompatTextHelper_android_drawableRight)) {
            this.f1371d = m1163a(context, m1545b, m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (m1432a.m1451g(C0059a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.f1372e = m1163a(context, m1545b, m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (m1432a.m1451g(C0059a.j.AppCompatTextHelper_android_drawableStart)) {
                this.f1373f = m1163a(context, m1545b, m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (m1432a.m1451g(C0059a.j.AppCompatTextHelper_android_drawableEnd)) {
                this.f1374g = m1163a(context, m1545b, m1432a.m1450g(C0059a.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        m1432a.m1441b();
        boolean z = this.f1368a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z2 = false;
        boolean z3 = false;
        ColorStateList colorStateList = null;
        ColorStateList colorStateList2 = null;
        ColorStateList colorStateList3 = null;
        String str = null;
        String str2 = null;
        if (m1450g != -1) {
            C0184az m1430a = C0184az.m1430a(context, m1450g, C0059a.j.TextAppearance);
            if (!z && m1430a.m1451g(C0059a.j.TextAppearance_textAllCaps)) {
                z3 = true;
                z2 = m1430a.m1438a(C0059a.j.TextAppearance_textAllCaps, false);
            }
            m1164a(context, m1430a);
            if (Build.VERSION.SDK_INT < 23) {
                if (m1430a.m1451g(C0059a.j.TextAppearance_android_textColor)) {
                    colorStateList = m1430a.m1447e(C0059a.j.TextAppearance_android_textColor);
                }
                if (m1430a.m1451g(C0059a.j.TextAppearance_android_textColorHint)) {
                    colorStateList2 = m1430a.m1447e(C0059a.j.TextAppearance_android_textColorHint);
                }
                if (m1430a.m1451g(C0059a.j.TextAppearance_android_textColorLink)) {
                    colorStateList3 = m1430a.m1447e(C0059a.j.TextAppearance_android_textColorLink);
                }
            }
            if (m1430a.m1451g(C0059a.j.TextAppearance_textLocale)) {
                str2 = m1430a.m1445d(C0059a.j.TextAppearance_textLocale);
            }
            if (Build.VERSION.SDK_INT >= 26 && m1430a.m1451g(C0059a.j.TextAppearance_fontVariationSettings)) {
                str = m1430a.m1445d(C0059a.j.TextAppearance_fontVariationSettings);
            }
            m1430a.m1441b();
        }
        C0184az m1432a2 = C0184az.m1432a(context, attributeSet, C0059a.j.TextAppearance, i, 0);
        if (!z && m1432a2.m1451g(C0059a.j.TextAppearance_textAllCaps)) {
            z3 = true;
            z2 = m1432a2.m1438a(C0059a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (m1432a2.m1451g(C0059a.j.TextAppearance_android_textColor)) {
                colorStateList = m1432a2.m1447e(C0059a.j.TextAppearance_android_textColor);
            }
            if (m1432a2.m1451g(C0059a.j.TextAppearance_android_textColorHint)) {
                colorStateList2 = m1432a2.m1447e(C0059a.j.TextAppearance_android_textColorHint);
            }
            if (m1432a2.m1451g(C0059a.j.TextAppearance_android_textColorLink)) {
                colorStateList3 = m1432a2.m1447e(C0059a.j.TextAppearance_android_textColorLink);
            }
        }
        if (m1432a2.m1451g(C0059a.j.TextAppearance_textLocale)) {
            str2 = m1432a2.m1445d(C0059a.j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && m1432a2.m1451g(C0059a.j.TextAppearance_fontVariationSettings)) {
            str = m1432a2.m1445d(C0059a.j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && m1432a2.m1451g(C0059a.j.TextAppearance_android_textSize) && m1432a2.m1446e(C0059a.j.TextAppearance_android_textSize, -1) == 0) {
            this.f1368a.setTextSize(0, 0.0f);
        }
        m1164a(context, m1432a2);
        m1432a2.m1441b();
        if (colorStateList != null) {
            this.f1368a.setTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f1368a.setHintTextColor(colorStateList2);
        }
        if (colorStateList3 != null) {
            this.f1368a.setLinkTextColor(colorStateList3);
        }
        if (!z && z3) {
            m1179a(z2);
        }
        if (this.f1379l != null) {
            if (this.f1378k == -1) {
                this.f1368a.setTypeface(this.f1379l, this.f1377j);
            } else {
                this.f1368a.setTypeface(this.f1379l);
            }
        }
        if (str != null) {
            this.f1368a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1368a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f1368a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        this.f1376i.m1217a(attributeSet, i);
        if (InterfaceC0332b.f2352d && this.f1376i.m1212a() != 0) {
            int[] m1223e = this.f1376i.m1223e();
            if (m1223e.length > 0) {
                if (this.f1368a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f1368a.setAutoSizeTextTypeUniformWithConfiguration(this.f1376i.m1221c(), this.f1376i.m1222d(), this.f1376i.m1219b(), 0);
                } else {
                    this.f1368a.setAutoSizeTextTypeUniformWithPresetSizes(m1223e, 0);
                }
            }
        }
        C0184az m1431a = C0184az.m1431a(context, attributeSet, C0059a.j.AppCompatTextView);
        Drawable drawable = null;
        Drawable drawable2 = null;
        int m1450g2 = m1431a.m1450g(C0059a.j.AppCompatTextView_drawableLeftCompat, -1);
        if (m1450g2 != -1) {
            drawable = m1545b.m1547a(context, m1450g2);
        }
        int m1450g3 = m1431a.m1450g(C0059a.j.AppCompatTextView_drawableTopCompat, -1);
        Drawable m1547a = m1450g3 != -1 ? m1545b.m1547a(context, m1450g3) : null;
        int m1450g4 = m1431a.m1450g(C0059a.j.AppCompatTextView_drawableRightCompat, -1);
        Drawable m1547a2 = m1450g4 != -1 ? m1545b.m1547a(context, m1450g4) : null;
        int m1450g5 = m1431a.m1450g(C0059a.j.AppCompatTextView_drawableBottomCompat, -1);
        if (m1450g5 != -1) {
            drawable2 = m1545b.m1547a(context, m1450g5);
        }
        int m1450g6 = m1431a.m1450g(C0059a.j.AppCompatTextView_drawableStartCompat, -1);
        Drawable m1547a3 = m1450g6 != -1 ? m1545b.m1547a(context, m1450g6) : null;
        int m1450g7 = m1431a.m1450g(C0059a.j.AppCompatTextView_drawableEndCompat, -1);
        m1165a(drawable, m1547a, m1547a2, drawable2, m1547a3, m1450g7 != -1 ? m1545b.m1547a(context, m1450g7) : null);
        if (m1431a.m1451g(C0059a.j.AppCompatTextView_drawableTint)) {
            C0339i.m2515a(this.f1368a, m1431a.m1447e(C0059a.j.AppCompatTextView_drawableTint));
        }
        if (m1431a.m1451g(C0059a.j.AppCompatTextView_drawableTintMode)) {
            C0339i.m2516a(this.f1368a, C0165ag.m1261a(m1431a.m1434a(C0059a.j.AppCompatTextView_drawableTintMode, -1), null));
        }
        int m1446e = m1431a.m1446e(C0059a.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int m1446e2 = m1431a.m1446e(C0059a.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int m1446e3 = m1431a.m1446e(C0059a.j.AppCompatTextView_lineHeight, -1);
        m1431a.m1441b();
        if (m1446e != -1) {
            C0339i.m2520b(this.f1368a, m1446e);
        }
        if (m1446e2 != -1) {
            C0339i.m2522c(this.f1368a, m1446e2);
        }
        if (m1446e3 != -1) {
            C0339i.m2524d(this.f1368a, m1446e3);
        }
    }

    /* renamed from: a */
    private void m1164a(Context context, C0184az c0184az) {
        int i;
        String m1445d;
        this.f1377j = c0184az.m1434a(C0059a.j.TextAppearance_android_textStyle, this.f1377j);
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1378k = c0184az.m1434a(C0059a.j.TextAppearance_android_textFontWeight, -1);
            if (this.f1378k != -1) {
                this.f1377j = (this.f1377j & 2) | 0;
            }
        }
        if (c0184az.m1451g(C0059a.j.TextAppearance_android_fontFamily) || c0184az.m1451g(C0059a.j.TextAppearance_fontFamily)) {
            this.f1379l = null;
            if (c0184az.m1451g(C0059a.j.TextAppearance_fontFamily)) {
                i = C0059a.j.TextAppearance_fontFamily;
            } else {
                i = C0059a.j.TextAppearance_android_fontFamily;
            }
            final int i2 = this.f1378k;
            final int i3 = this.f1377j;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f1368a);
                try {
                    Typeface m1436a = c0184az.m1436a(i, this.f1377j, new C0261f.c() { // from class: androidx.appcompat.widget.aa.1
                        @Override // androidx.core.content.p028a.C0261f.c
                        /* renamed from: a */
                        public void mo1193a(Typeface typeface) {
                            if (Build.VERSION.SDK_INT >= 28 && i2 != -1) {
                                typeface = Typeface.create(typeface, i2, (i3 & 2) != 0);
                            }
                            C0159aa.this.m1178a(weakReference, typeface);
                        }

                        @Override // androidx.core.content.p028a.C0261f.c
                        /* renamed from: a */
                        public void mo1192a(int i4) {
                        }
                    });
                    if (m1436a != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.f1378k != -1) {
                            this.f1379l = Typeface.create(Typeface.create(m1436a, 0), this.f1378k, (this.f1377j & 2) != 0);
                        } else {
                            this.f1379l = m1436a;
                        }
                    }
                    this.f1380m = this.f1379l == null;
                } catch (Resources.NotFoundException e2) {
                } catch (UnsupportedOperationException e3) {
                }
            }
            if (this.f1379l == null && (m1445d = c0184az.m1445d(i)) != null) {
                if (Build.VERSION.SDK_INT >= 28 && this.f1378k != -1) {
                    this.f1379l = Typeface.create(Typeface.create(m1445d, 0), this.f1378k, (this.f1377j & 2) != 0);
                } else {
                    this.f1379l = Typeface.create(m1445d, this.f1377j);
                    return;
                }
            }
            return;
        }
        if (c0184az.m1451g(C0059a.j.TextAppearance_android_typeface)) {
            this.f1380m = false;
            switch (c0184az.m1434a(C0059a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.f1379l = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.f1379l = Typeface.SERIF;
                    break;
                case 3:
                    this.f1379l = Typeface.MONOSPACE;
                    break;
            }
        }
    }

    /* renamed from: a */
    void m1178a(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.f1380m) {
            this.f1379l = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (C0308x.m2276w(textView)) {
                    final int i = this.f1377j;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.aa.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i);
                        }
                    });
                } else {
                    textView.setTypeface(typeface, this.f1377j);
                }
            }
        }
    }

    /* renamed from: a */
    void m1173a(Context context, int i) {
        String m1445d;
        ColorStateList m1447e;
        ColorStateList m1447e2;
        ColorStateList m1447e3;
        C0184az m1430a = C0184az.m1430a(context, i, C0059a.j.TextAppearance);
        if (m1430a.m1451g(C0059a.j.TextAppearance_textAllCaps)) {
            m1179a(m1430a.m1438a(C0059a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (m1430a.m1451g(C0059a.j.TextAppearance_android_textColor) && (m1447e3 = m1430a.m1447e(C0059a.j.TextAppearance_android_textColor)) != null) {
                this.f1368a.setTextColor(m1447e3);
            }
            if (m1430a.m1451g(C0059a.j.TextAppearance_android_textColorLink) && (m1447e2 = m1430a.m1447e(C0059a.j.TextAppearance_android_textColorLink)) != null) {
                this.f1368a.setLinkTextColor(m1447e2);
            }
            if (m1430a.m1451g(C0059a.j.TextAppearance_android_textColorHint) && (m1447e = m1430a.m1447e(C0059a.j.TextAppearance_android_textColorHint)) != null) {
                this.f1368a.setHintTextColor(m1447e);
            }
        }
        if (m1430a.m1451g(C0059a.j.TextAppearance_android_textSize) && m1430a.m1446e(C0059a.j.TextAppearance_android_textSize, -1) == 0) {
            this.f1368a.setTextSize(0, 0.0f);
        }
        m1164a(context, m1430a);
        if (Build.VERSION.SDK_INT >= 26 && m1430a.m1451g(C0059a.j.TextAppearance_fontVariationSettings) && (m1445d = m1430a.m1445d(C0059a.j.TextAppearance_fontVariationSettings)) != null) {
            this.f1368a.setFontVariationSettings(m1445d);
        }
        m1430a.m1441b();
        if (this.f1379l != null) {
            this.f1368a.setTypeface(this.f1379l, this.f1377j);
        }
    }

    /* renamed from: a */
    void m1179a(boolean z) {
        this.f1368a.setAllCaps(z);
    }

    /* renamed from: a */
    void m1169a() {
        m1182b();
    }

    /* renamed from: b */
    void m1182b() {
        if (this.f1369b != null || this.f1370c != null || this.f1371d != null || this.f1372e != null) {
            Drawable[] compoundDrawables = this.f1368a.getCompoundDrawables();
            m1166a(compoundDrawables[0], this.f1369b);
            m1166a(compoundDrawables[1], this.f1370c);
            m1166a(compoundDrawables[2], this.f1371d);
            m1166a(compoundDrawables[3], this.f1372e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f1373f != null || this.f1374g != null) {
                Drawable[] compoundDrawablesRelative = this.f1368a.getCompoundDrawablesRelative();
                m1166a(compoundDrawablesRelative[0], this.f1373f);
                m1166a(compoundDrawablesRelative[2], this.f1374g);
            }
        }
    }

    /* renamed from: a */
    private void m1166a(Drawable drawable, C0182ax c0182ax) {
        if (drawable != null && c0182ax != null) {
            C0201k.m1544a(drawable, c0182ax, this.f1368a.getDrawableState());
        }
    }

    /* renamed from: a */
    private static C0182ax m1163a(Context context, C0201k c0201k, int i) {
        ColorStateList m1550b = c0201k.m1550b(context, i);
        if (m1550b == null) {
            return null;
        }
        C0182ax c0182ax = new C0182ax();
        c0182ax.f1587d = true;
        c0182ax.f1584a = m1550b;
        return c0182ax;
    }

    /* renamed from: a */
    void m1180a(boolean z, int i, int i2, int i3, int i4) {
        if (!InterfaceC0332b.f2352d) {
            m1183c();
        }
    }

    /* renamed from: a */
    void m1171a(int i, float f2) {
        if (!InterfaceC0332b.f2352d && !m1184d()) {
            m1167b(i, f2);
        }
    }

    /* renamed from: c */
    void m1183c() {
        this.f1376i.m1224f();
    }

    /* renamed from: d */
    boolean m1184d() {
        return this.f1376i.m1225g();
    }

    /* renamed from: b */
    private void m1167b(int i, float f2) {
        this.f1376i.m1215a(i, f2);
    }

    /* renamed from: a */
    void m1170a(int i) {
        this.f1376i.m1214a(i);
    }

    /* renamed from: a */
    void m1172a(int i, int i2, int i3, int i4) {
        this.f1376i.m1216a(i, i2, i3, i4);
    }

    /* renamed from: a */
    void m1181a(int[] iArr, int i) {
        this.f1376i.m1218a(iArr, i);
    }

    /* renamed from: e */
    int m1185e() {
        return this.f1376i.m1212a();
    }

    /* renamed from: f */
    int m1186f() {
        return this.f1376i.m1219b();
    }

    /* renamed from: g */
    int m1187g() {
        return this.f1376i.m1221c();
    }

    /* renamed from: h */
    int m1188h() {
        return this.f1376i.m1222d();
    }

    /* renamed from: i */
    int[] m1189i() {
        return this.f1376i.m1223e();
    }

    /* renamed from: j */
    ColorStateList m1190j() {
        if (this.f1375h != null) {
            return this.f1375h.f1584a;
        }
        return null;
    }

    /* renamed from: a */
    void m1174a(ColorStateList colorStateList) {
        if (this.f1375h == null) {
            this.f1375h = new C0182ax();
        }
        this.f1375h.f1584a = colorStateList;
        this.f1375h.f1587d = colorStateList != null;
        m1168l();
    }

    /* renamed from: k */
    PorterDuff.Mode m1191k() {
        if (this.f1375h != null) {
            return this.f1375h.f1585b;
        }
        return null;
    }

    /* renamed from: a */
    void m1175a(PorterDuff.Mode mode) {
        if (this.f1375h == null) {
            this.f1375h = new C0182ax();
        }
        this.f1375h.f1585b = mode;
        this.f1375h.f1586c = mode != null;
        m1168l();
    }

    /* renamed from: l */
    private void m1168l() {
        this.f1369b = this.f1375h;
        this.f1370c = this.f1375h;
        this.f1371d = this.f1375h;
        this.f1372e = this.f1375h;
        this.f1373f = this.f1375h;
        this.f1374g = this.f1375h;
    }

    /* renamed from: a */
    private void m1165a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1368a.getCompoundDrawablesRelative();
            TextView textView = this.f1368a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1368a.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                    TextView textView2 = this.f1368a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1368a.getCompoundDrawables();
            TextView textView3 = this.f1368a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: a */
    void m1177a(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            C0284a.m2131a(editorInfo, textView.getText());
        }
    }
}
