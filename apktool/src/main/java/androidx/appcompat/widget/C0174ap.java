package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.p016b.p017a.C0084a;
import androidx.appcompat.p018c.C0088a;
import androidx.core.content.C0255a;
import androidx.core.graphics.drawable.C0315a;
import androidx.p011a.C0039d;
import androidx.p011a.C0040e;
import androidx.p011a.C0042g;
import androidx.p011a.C0043h;
import androidx.p041g.p042a.p043a.C0398c;
import androidx.p041g.p042a.p043a.C0404i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlPullParserException;

/* compiled from: ResourceManagerInternal.java */
/* renamed from: androidx.appcompat.widget.ap */
/* loaded from: classes.dex */
public final class C0174ap {

    /* renamed from: b */
    private static C0174ap f1513b;

    /* renamed from: d */
    private WeakHashMap<Context, C0043h<ColorStateList>> f1515d;

    /* renamed from: e */
    private C0042g<String, e> f1516e;

    /* renamed from: f */
    private C0043h<String> f1517f;

    /* renamed from: g */
    private final WeakHashMap<Context, C0039d<WeakReference<Drawable.ConstantState>>> f1518g = new WeakHashMap<>(0);

    /* renamed from: h */
    private TypedValue f1519h;

    /* renamed from: i */
    private boolean f1520i;

    /* renamed from: j */
    private f f1521j;

    /* renamed from: a */
    private static final PorterDuff.Mode f1512a = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    private static final c f1514c = new c(6);

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$e */
    private interface e {
        /* renamed from: a */
        Drawable mo1371a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$f */
    public interface f {
        /* renamed from: a */
        ColorStateList mo1375a(Context context, int i);

        /* renamed from: a */
        PorterDuff.Mode mo1376a(int i);

        /* renamed from: a */
        Drawable mo1377a(C0174ap c0174ap, Context context, int i);

        /* renamed from: a */
        boolean mo1378a(Context context, int i, Drawable drawable);

        /* renamed from: b */
        boolean mo1379b(Context context, int i, Drawable drawable);
    }

    /* renamed from: a */
    public static synchronized C0174ap m1352a() {
        C0174ap c0174ap;
        synchronized (C0174ap.class) {
            if (f1513b == null) {
                f1513b = new C0174ap();
                m1355a(f1513b);
            }
            c0174ap = f1513b;
        }
        return c0174ap;
    }

    /* renamed from: a */
    private static void m1355a(C0174ap c0174ap) {
        if (Build.VERSION.SDK_INT < 24) {
            c0174ap.m1356a("vector", new g());
            c0174ap.m1356a("animated-vector", new b());
            c0174ap.m1356a("animated-selector", new a());
            c0174ap.m1356a("drawable", new d());
        }
    }

    /* renamed from: a */
    public synchronized void m1368a(f fVar) {
        this.f1521j = fVar;
    }

    /* renamed from: a */
    public synchronized Drawable m1364a(Context context, int i) {
        return m1365a(context, i, false);
    }

    /* renamed from: a */
    synchronized Drawable m1365a(Context context, int i, boolean z) {
        Drawable m1361d;
        m1359b(context);
        m1361d = m1361d(context, i);
        if (m1361d == null) {
            m1361d = m1360c(context, i);
        }
        if (m1361d == null) {
            m1361d = C0255a.m1847a(context, i);
        }
        if (m1361d != null) {
            m1361d = m1350a(context, i, z, m1361d);
        }
        if (m1361d != null) {
            C0165ag.m1262a(m1361d);
        }
        return m1361d;
    }

    /* renamed from: a */
    public synchronized void m1367a(Context context) {
        C0039d<WeakReference<Drawable.ConstantState>> c0039d = this.f1518g.get(context);
        if (c0039d != null) {
            c0039d.m242c();
        }
    }

    /* renamed from: a */
    private static long m1347a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    /* renamed from: c */
    private Drawable m1360c(Context context, int i) {
        if (this.f1519h == null) {
            this.f1519h = new TypedValue();
        }
        TypedValue typedValue = this.f1519h;
        context.getResources().getValue(i, typedValue, true);
        long m1347a = m1347a(typedValue);
        Drawable m1351a = m1351a(context, m1347a);
        if (m1351a == null) {
            m1351a = this.f1521j == null ? null : this.f1521j.mo1377a(this, context, i);
            if (m1351a != null) {
                m1351a.setChangingConfigurations(typedValue.changingConfigurations);
                m1357a(context, m1347a, m1351a);
            }
        }
        return m1351a;
    }

    /* renamed from: a */
    private Drawable m1350a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList m1370b = m1370b(context, i);
        if (m1370b != null) {
            if (C0165ag.m1263b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable m2369f = C0315a.m2369f(drawable);
            C0315a.m2359a(m2369f, m1370b);
            PorterDuff.Mode m1363a = m1363a(i);
            if (m1363a != null) {
                C0315a.m2362a(m2369f, m1363a);
                return m2369f;
            }
            return m2369f;
        }
        if ((this.f1521j == null || !this.f1521j.mo1378a(context, i, drawable)) && !m1369a(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Drawable m1361d(Context context, int i) {
        Drawable drawable;
        XmlResourceParser xml;
        AttributeSet asAttributeSet;
        int next;
        if (this.f1516e == null || this.f1516e.isEmpty()) {
            return null;
        }
        if (this.f1517f != null) {
            String m276a = this.f1517f.m276a(i);
            if ("appcompat_skip_skip".equals(m276a) || (m276a != null && this.f1516e.get(m276a) == null)) {
                return null;
            }
        } else {
            this.f1517f = new C0043h<>();
        }
        if (this.f1519h == null) {
            this.f1519h = new TypedValue();
        }
        TypedValue typedValue = this.f1519h;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long m1347a = m1347a(typedValue);
        Drawable m1351a = m1351a(context, m1347a);
        if (m1351a != null) {
            return m1351a;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                xml = resources.getXml(i);
                asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
            } catch (Exception e2) {
                Log.m185e("ResourceManagerInternal", "Exception while inflating drawable", e2);
            }
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            String name = xml.getName();
            this.f1517f.m283c(i, name);
            e eVar = this.f1516e.get(name);
            if (eVar != null) {
                m1351a = eVar.mo1371a(context, xml, asAttributeSet, context.getTheme());
            }
            if (m1351a != null) {
                m1351a.setChangingConfigurations(typedValue.changingConfigurations);
                if (m1357a(context, m1347a, m1351a)) {
                }
            }
            drawable = m1351a;
            if (drawable != null) {
                this.f1517f.m283c(i, "appcompat_skip_skip");
                return drawable;
            }
            return drawable;
        }
        drawable = m1351a;
        if (drawable != null) {
        }
    }

    /* renamed from: a */
    private synchronized Drawable m1351a(Context context, long j) {
        Drawable drawable;
        C0039d<WeakReference<Drawable.ConstantState>> c0039d = this.f1518g.get(context);
        if (c0039d == null) {
            drawable = null;
        } else {
            WeakReference<Drawable.ConstantState> m236a = c0039d.m236a(j);
            if (m236a != null) {
                Drawable.ConstantState constantState = m236a.get();
                if (constantState != null) {
                    drawable = constantState.newDrawable(context.getResources());
                } else {
                    c0039d.m240b(j);
                }
            }
            drawable = null;
        }
        return drawable;
    }

    /* renamed from: a */
    private synchronized boolean m1357a(Context context, long j, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            C0039d<WeakReference<Drawable.ConstantState>> c0039d = this.f1518g.get(context);
            if (c0039d == null) {
                c0039d = new C0039d<>();
                this.f1518g.put(context, c0039d);
            }
            c0039d.m241b(j, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    synchronized Drawable m1366a(Context context, C0190be c0190be, int i) {
        Drawable m1361d;
        m1361d = m1361d(context, i);
        if (m1361d == null) {
            m1361d = c0190be.m1479a(i);
        }
        return m1361d != null ? m1350a(context, i, false, m1361d) : null;
    }

    /* renamed from: a */
    boolean m1369a(Context context, int i, Drawable drawable) {
        return this.f1521j != null && this.f1521j.mo1379b(context, i, drawable);
    }

    /* renamed from: a */
    private void m1356a(String str, e eVar) {
        if (this.f1516e == null) {
            this.f1516e = new C0042g<>();
        }
        this.f1516e.put(str, eVar);
    }

    /* renamed from: a */
    PorterDuff.Mode m1363a(int i) {
        if (this.f1521j == null) {
            return null;
        }
        return this.f1521j.mo1376a(i);
    }

    /* renamed from: b */
    synchronized ColorStateList m1370b(Context context, int i) {
        ColorStateList m1362e;
        m1362e = m1362e(context, i);
        if (m1362e == null) {
            m1362e = this.f1521j == null ? null : this.f1521j.mo1375a(context, i);
            if (m1362e != null) {
                m1353a(context, i, m1362e);
            }
        }
        return m1362e;
    }

    /* renamed from: e */
    private ColorStateList m1362e(Context context, int i) {
        C0043h<ColorStateList> c0043h;
        if (this.f1515d != null && (c0043h = this.f1515d.get(context)) != null) {
            return c0043h.m276a(i);
        }
        return null;
    }

    /* renamed from: a */
    private void m1353a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1515d == null) {
            this.f1515d = new WeakHashMap<>();
        }
        C0043h<ColorStateList> c0043h = this.f1515d.get(context);
        if (c0043h == null) {
            c0043h = new C0043h<>();
            this.f1515d.put(context, c0043h);
        }
        c0043h.m283c(i, colorStateList);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$c */
    private static class c extends C0040e<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        /* renamed from: a */
        PorterDuffColorFilter m1373a(int i, PorterDuff.Mode mode) {
            return m245a((c) Integer.valueOf(m1372b(i, mode)));
        }

        /* renamed from: a */
        PorterDuffColorFilter m1374a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return m246a((c) Integer.valueOf(m1372b(i, mode)), (Integer) porterDuffColorFilter);
        }

        /* renamed from: b */
        private static int m1372b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    /* renamed from: a */
    static void m1354a(Drawable drawable, C0182ax c0182ax, int[] iArr) {
        if (C0165ag.m1263b(drawable) && drawable.mutate() != drawable) {
            Log.m182d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (c0182ax.f1587d || c0182ax.f1586c) {
            drawable.setColorFilter(m1349a(c0182ax.f1587d ? c0182ax.f1584a : null, c0182ax.f1586c ? c0182ax.f1585b : f1512a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m1349a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m1348a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m1348a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter m1373a;
        synchronized (C0174ap.class) {
            m1373a = f1514c.m1373a(i, mode);
            if (m1373a == null) {
                m1373a = new PorterDuffColorFilter(i, mode);
                f1514c.m1374a(i, mode, m1373a);
            }
        }
        return m1373a;
    }

    /* renamed from: b */
    private void m1359b(Context context) {
        if (!this.f1520i) {
            this.f1520i = true;
            Drawable m1364a = m1364a(context, C0088a.a.abc_vector_test);
            if (m1364a == null || !m1358a(m1364a)) {
                this.f1520i = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: a */
    private static boolean m1358a(Drawable drawable) {
        return (drawable instanceof C0404i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$g */
    private static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.C0174ap.e
        /* renamed from: a */
        public Drawable mo1371a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0404i.m3233a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.m185e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$b */
    private static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.C0174ap.e
        /* renamed from: a */
        public Drawable mo1371a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0398c.m3199a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.m185e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$a */
    static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.C0174ap.e
        /* renamed from: a */
        public Drawable mo1371a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0084a.m667a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.m185e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: androidx.appcompat.widget.ap$d */
    static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.C0174ap.e
        /* renamed from: a */
        public Drawable mo1371a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute == null) {
                return null;
            }
            try {
                Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                } else {
                    drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                }
                return drawable;
            } catch (Exception e2) {
                Log.m185e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                return null;
            }
        }
    }
}
