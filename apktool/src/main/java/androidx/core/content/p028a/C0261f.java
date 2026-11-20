package androidx.core.content.p028a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.p028a.C0258c;
import androidx.core.graphics.C0314d;
import androidx.core.p030e.C0268c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: ResourcesCompat.java */
/* renamed from: androidx.core.content.a.f */
/* loaded from: classes.dex */
public final class C0261f {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f2034a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<b, SparseArray<a>> f2035b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f2036c = new Object();

    /* renamed from: a */
    public static Drawable m1912a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    /* renamed from: b */
    public static ColorStateList m1916b(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, theme);
        }
        b bVar = new b(resources, theme);
        ColorStateList m1908a = m1908a(bVar, i);
        if (m1908a == null) {
            ColorStateList m1917c = m1917c(resources, i, theme);
            if (m1917c != null) {
                m1914a(bVar, i, m1917c);
                return m1917c;
            }
            return resources.getColorStateList(i);
        }
        return m1908a;
    }

    /* renamed from: c */
    private static ColorStateList m1917c(Resources resources, int i, Resources.Theme theme) {
        if (m1915a(resources, i)) {
            return null;
        }
        try {
            return C0256a.m1859a(resources, resources.getXml(i), theme);
        } catch (Exception e2) {
            Log.m185e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    /* renamed from: a */
    private static ColorStateList m1908a(b bVar, int i) {
        a aVar;
        synchronized (f2036c) {
            SparseArray<a> sparseArray = f2035b.get(bVar);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.f2038b.equals(bVar.f2039a.getConfiguration())) {
                    return aVar.f2037a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    /* renamed from: a */
    private static void m1914a(b bVar, int i, ColorStateList colorStateList) {
        synchronized (f2036c) {
            SparseArray<a> sparseArray = f2035b.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f2035b.put(bVar, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, bVar.f2039a.getConfiguration()));
        }
    }

    /* renamed from: a */
    private static boolean m1915a(Resources resources, int i) {
        TypedValue m1913a = m1913a();
        resources.getValue(i, m1913a, true);
        return m1913a.type >= 28 && m1913a.type <= 31;
    }

    /* renamed from: a */
    private static TypedValue m1913a() {
        TypedValue typedValue = f2034a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f2034a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: androidx.core.content.a.f$b */
    private static final class b {

        /* renamed from: a */
        final Resources f2039a;

        /* renamed from: b */
        final Resources.Theme f2040b;

        b(Resources resources, Resources.Theme theme) {
            this.f2039a = resources;
            this.f2040b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f2039a.equals(bVar.f2039a) && C0268c.m1953a(this.f2040b, bVar.f2040b);
        }

        public int hashCode() {
            return C0268c.m1952a(this.f2039a, this.f2040b);
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: androidx.core.content.a.f$a */
    private static class a {

        /* renamed from: a */
        final ColorStateList f2037a;

        /* renamed from: b */
        final Configuration f2038b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f2037a = colorStateList;
            this.f2038b = configuration;
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: androidx.core.content.a.f$c */
    public static abstract class c {
        /* renamed from: a */
        public abstract void mo1192a(int i);

        /* renamed from: a */
        public abstract void mo1193a(Typeface typeface);

        /* renamed from: a */
        public final void m1920a(final Typeface typeface, Handler handler) {
            m1918a(handler).post(new Runnable() { // from class: androidx.core.content.a.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.mo1193a(typeface);
                }
            });
        }

        /* renamed from: a */
        public final void m1919a(final int i, Handler handler) {
            m1918a(handler).post(new Runnable() { // from class: androidx.core.content.a.f.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.mo1192a(i);
                }
            });
        }

        /* renamed from: a */
        public static Handler m1918a(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    /* renamed from: a */
    public static Typeface m1909a(Context context, int i, TypedValue typedValue, int i2, c cVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m1910a(context, i, typedValue, i2, cVar, null, true, false);
    }

    /* renamed from: a */
    private static Typeface m1910a(Context context, int i, TypedValue typedValue, int i2, c cVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface m1911a = m1911a(context, resources, typedValue, i, i2, cVar, handler, z, z2);
        if (m1911a == null && cVar == null && !z2) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return m1911a;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface m1911a(Context context, Resources resources, TypedValue typedValue, int i, int i2, c cVar, Handler handler, boolean z, boolean z2) {
        if (typedValue.string == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (!charSequence.startsWith("res/")) {
            if (cVar != null) {
                cVar.m1919a(-3, handler);
            }
            return null;
        }
        Typeface m2335a = C0314d.m2335a(resources, i, i2);
        if (m2335a != null) {
            if (cVar != null) {
                cVar.m1920a(m2335a, handler);
                return m2335a;
            }
            return m2335a;
        }
        if (z2) {
            return null;
        }
        try {
            if (charSequence.toLowerCase().endsWith(".xml")) {
                C0258c.a m1882a = C0258c.m1882a(resources.getXml(i), resources);
                if (m1882a == null) {
                    Log.m184e("ResourcesCompat", "Failed to find font-family tag");
                    if (cVar != null) {
                        cVar.m1919a(-3, handler);
                    }
                    return null;
                }
                return C0314d.m2334a(context, m1882a, resources, i, i2, cVar, handler, z);
            }
            Typeface m2331a = C0314d.m2331a(context, resources, i, charSequence, i2);
            if (cVar != null) {
                if (m2331a != null) {
                    cVar.m1920a(m2331a, handler);
                    return m2331a;
                }
                cVar.m1919a(-3, handler);
                return m2331a;
            }
            return m2331a;
        } catch (IOException e2) {
            Log.m185e("ResourcesCompat", "Failed to read xml resource " + charSequence, e2);
            if (cVar != null) {
                cVar.m1919a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e3) {
            Log.m185e("ResourcesCompat", "Failed to parse xml resource " + charSequence, e3);
            if (cVar != null) {
            }
            return null;
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: androidx.core.content.a.f$d */
    public static final class d {
        /* renamed from: a */
        public static void m1921a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.m1923a(theme);
            } else if (Build.VERSION.SDK_INT >= 23) {
                a.m1922a(theme);
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: androidx.core.content.a.f$d$b */
        static class b {
            /* renamed from: a */
            static void m1923a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: androidx.core.content.a.f$d$a */
        static class a {

            /* renamed from: a */
            private static final Object f2045a = new Object();

            /* renamed from: b */
            private static Method f2046b;

            /* renamed from: c */
            private static boolean f2047c;

            /* renamed from: a */
            static void m1922a(Resources.Theme theme) {
                synchronized (f2045a) {
                    if (!f2047c) {
                        try {
                            f2046b = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f2046b.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.m187i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f2047c = true;
                    }
                    if (f2046b != null) {
                        try {
                            f2046b.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.m187i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f2046b = null;
                        }
                    }
                }
            }
        }
    }
}
