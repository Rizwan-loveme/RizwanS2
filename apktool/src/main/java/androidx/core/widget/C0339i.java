package androidx.core.widget;

import android.app.Activity;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.PackageManager;
import android.content.p006pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.icu.text.DecimalFormatSymbols;
import android.p008os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.core.p029d.C0265a;
import androidx.core.p030e.C0270e;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextViewCompat.java */
/* renamed from: androidx.core.widget.i */
/* loaded from: classes.dex */
public final class C0339i {

    /* renamed from: a */
    private static Field f2360a;

    /* renamed from: b */
    private static boolean f2361b;

    /* renamed from: c */
    private static Field f2362c;

    /* renamed from: d */
    private static boolean f2363d;

    /* renamed from: a */
    private static Field m2513a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e2) {
            Log.m184e("TextViewCompat", "Could not retrieve " + str + " field.");
            return field;
        }
    }

    /* renamed from: a */
    private static int m2511a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e2) {
            Log.m182d("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    /* renamed from: a */
    public static int m2510a(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f2363d) {
            f2362c = m2513a("mMaxMode");
            f2363d = true;
        }
        if (f2362c != null && m2511a(f2362c, textView) == 1) {
            if (!f2361b) {
                f2360a = m2513a("mMaximum");
                f2361b = true;
            }
            if (f2360a != null) {
                return m2511a(f2360a, textView);
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m2514a(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    /* renamed from: a */
    public static ActionMode.Callback m2512a(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof a) || callback == null) ? callback : new a(callback, textView);
    }

    /* compiled from: TextViewCompat.java */
    /* renamed from: androidx.core.widget.i$a */
    private static class a implements ActionMode.Callback {

        /* renamed from: a */
        private final ActionMode.Callback f2364a;

        /* renamed from: b */
        private final TextView f2365b;

        /* renamed from: c */
        private Class<?> f2366c;

        /* renamed from: d */
        private Method f2367d;

        /* renamed from: e */
        private boolean f2368e;

        /* renamed from: f */
        private boolean f2369f = false;

        a(ActionMode.Callback callback, TextView textView) {
            this.f2364a = callback;
            this.f2365b = textView;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2364a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            m2529a(menu);
            return this.f2364a.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2364a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2364a.onDestroyActionMode(actionMode);
        }

        /* renamed from: a */
        private void m2529a(Menu menu) {
            Method declaredMethod;
            Context context = this.f2365b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f2369f) {
                this.f2369f = true;
                try {
                    this.f2366c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f2367d = this.f2366c.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f2368e = true;
                } catch (ClassNotFoundException | NoSuchMethodException e2) {
                    this.f2366c = null;
                    this.f2367d = null;
                    this.f2368e = false;
                }
            }
            try {
                if (this.f2368e && this.f2366c.isInstance(menu)) {
                    declaredMethod = this.f2367d;
                } else {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && Intent.ACTION_PROCESS_TEXT.equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> m2528a = m2528a(context, packageManager);
                for (int i = 0; i < m2528a.size(); i++) {
                    ResolveInfo resolveInfo = m2528a.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(m2527a(resolveInfo, this.f2365b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException e3) {
            } catch (NoSuchMethodException e4) {
            } catch (InvocationTargetException e5) {
            }
        }

        /* renamed from: a */
        private List<ResolveInfo> m2528a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(m2526a(), 0)) {
                if (m2530a(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        /* renamed from: a */
        private boolean m2530a(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                return resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0;
            }
            return false;
        }

        /* renamed from: a */
        private Intent m2527a(ResolveInfo resolveInfo, TextView textView) {
            return m2526a().putExtra(Intent.EXTRA_PROCESS_TEXT_READONLY, !m2531a(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        /* renamed from: a */
        private boolean m2531a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* renamed from: a */
        private Intent m2526a() {
            return new Intent().setAction(Intent.ACTION_PROCESS_TEXT).setType(ClipDescription.MIMETYPE_TEXT_PLAIN);
        }
    }

    /* renamed from: b */
    public static void m2520b(TextView textView, int i) {
        int i2;
        C0270e.m1957a(i);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* renamed from: c */
    public static void m2522c(TextView textView, int i) {
        int i2;
        C0270e.m1957a(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    /* renamed from: b */
    public static int m2519b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: c */
    public static int m2521c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: d */
    public static void m2524d(TextView textView, int i) {
        C0270e.m1957a(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    /* renamed from: d */
    public static C0265a.a m2523d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new C0265a.a(textView.getTextMetricsParams());
        }
        C0265a.a.C3325a c3325a = new C0265a.a.C3325a(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            c3325a.m1947a(textView.getBreakStrategy());
            c3325a.m1950b(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            c3325a.m1948a(m2525e(textView));
        }
        return c3325a.m1949a();
    }

    /* renamed from: a */
    public static void m2517a(TextView textView, C0265a.a aVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(m2509a(aVar.m1944b()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = aVar.m1942a().getTextScaleX();
            textView.getPaint().set(aVar.m1942a());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.m1942a());
        textView.setBreakStrategy(aVar.m1945c());
        textView.setHyphenationFrequency(aVar.m1946d());
    }

    /* renamed from: a */
    public static void m2518a(TextView textView, C0265a c0265a) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(c0265a.m1940a());
        } else {
            if (!m2523d(textView).m1943a(c0265a.m1941b())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(c0265a);
        }
    }

    /* renamed from: e */
    private static TextDirectionHeuristic m2525e(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
        boolean z = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                return z ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    /* renamed from: a */
    private static int m2509a(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2515a(TextView textView, ColorStateList colorStateList) {
        C0270e.m1960a(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof InterfaceC0342l) {
            ((InterfaceC0342l) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2516a(TextView textView, PorterDuff.Mode mode) {
        C0270e.m1960a(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof InterfaceC0342l) {
            ((InterfaceC0342l) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }
}
