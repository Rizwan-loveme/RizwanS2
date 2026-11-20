package androidx.appcompat.p014a.p015a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0174ap;
import androidx.core.content.C0255a;
import androidx.core.content.p028a.C0256a;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.a.a.a */
/* loaded from: classes.dex */
public final class C0060a {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f418a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<a>> f419b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f420c = new Object();

    /* renamed from: a */
    public static ColorStateList m345a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList m350d = m350d(context, i);
        if (m350d == null) {
            ColorStateList m349c = m349c(context, i);
            if (m349c != null) {
                m347a(context, i, m349c);
                return m349c;
            }
            return C0255a.m1853b(context, i);
        }
        return m350d;
    }

    /* renamed from: b */
    public static Drawable m348b(Context context, int i) {
        return C0174ap.m1352a().m1364a(context, i);
    }

    /* renamed from: c */
    private static ColorStateList m349c(Context context, int i) {
        if (m351e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0256a.m1859a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e2) {
            Log.m185e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    /* renamed from: d */
    private static ColorStateList m350d(Context context, int i) {
        a aVar;
        synchronized (f420c) {
            SparseArray<a> sparseArray = f419b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.f422b.equals(context.getResources().getConfiguration())) {
                    return aVar.f421a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static void m347a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f420c) {
            SparseArray<a> sparseArray = f419b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f419b.put(context, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: e */
    private static boolean m351e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue m346a = m346a();
        resources.getValue(i, m346a, true);
        return m346a.type >= 28 && m346a.type <= 31;
    }

    /* renamed from: a */
    private static TypedValue m346a() {
        TypedValue typedValue = f418a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f418a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* compiled from: AppCompatResources.java */
    /* renamed from: androidx.appcompat.a.a.a$a */
    private static class a {

        /* renamed from: a */
        final ColorStateList f421a;

        /* renamed from: b */
        final Configuration f422b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f421a = colorStateList;
            this.f422b = configuration;
        }
    }
}
