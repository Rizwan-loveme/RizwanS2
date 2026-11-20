package androidx.core.p031f;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.C0312b;
import androidx.core.p030e.C0268c;
import androidx.core.p030e.C0270e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* renamed from: androidx.core.f.af */
/* loaded from: classes.dex */
public class C0282af {

    /* renamed from: a */
    public static final C0282af f2137a;

    /* renamed from: b */
    private final g f2138b;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f2137a = l.f2170e;
        } else {
            f2137a = g.f2153a;
        }
    }

    private C0282af(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f2138b = new l(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2138b = new k(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2138b = new j(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2138b = new i(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f2138b = new h(this, windowInsets);
        } else {
            this.f2138b = new g(this);
        }
    }

    public C0282af(C0282af c0282af) {
        if (c0282af != null) {
            g gVar = c0282af.f2138b;
            if (Build.VERSION.SDK_INT >= 30 && (gVar instanceof l)) {
                this.f2138b = new l(this, (l) gVar);
            } else if (Build.VERSION.SDK_INT >= 29 && (gVar instanceof k)) {
                this.f2138b = new k(this, (k) gVar);
            } else if (Build.VERSION.SDK_INT >= 28 && (gVar instanceof j)) {
                this.f2138b = new j(this, (j) gVar);
            } else if (Build.VERSION.SDK_INT >= 21 && (gVar instanceof i)) {
                this.f2138b = new i(this, (i) gVar);
            } else if (Build.VERSION.SDK_INT >= 20 && (gVar instanceof h)) {
                this.f2138b = new h(this, (h) gVar);
            } else {
                this.f2138b = new g(this);
            }
            gVar.mo2109b(this);
            return;
        }
        this.f2138b = new g(this);
    }

    /* renamed from: a */
    public static C0282af m2067a(WindowInsets windowInsets) {
        return m2068a(windowInsets, null);
    }

    /* renamed from: a */
    public static C0282af m2068a(WindowInsets windowInsets, View view) {
        C0282af c0282af = new C0282af((WindowInsets) C0270e.m1960a(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c0282af.m2074a(C0308x.m2269p(view));
            c0282af.m2073a(view.getRootView());
        }
        return c0282af;
    }

    @Deprecated
    /* renamed from: a */
    public int m2070a() {
        return this.f2138b.mo2116g().f2236b;
    }

    @Deprecated
    /* renamed from: b */
    public int m2077b() {
        return this.f2138b.mo2116g().f2237c;
    }

    @Deprecated
    /* renamed from: c */
    public int m2080c() {
        return this.f2138b.mo2116g().f2238d;
    }

    @Deprecated
    /* renamed from: d */
    public int m2081d() {
        return this.f2138b.mo2116g().f2239e;
    }

    /* renamed from: e */
    public boolean m2082e() {
        return this.f2138b.mo2111b();
    }

    @Deprecated
    /* renamed from: f */
    public C0282af m2083f() {
        return this.f2138b.mo2112c();
    }

    @Deprecated
    /* renamed from: a */
    public C0282af m2071a(int i2, int i3, int i4, int i5) {
        return new b(this).m2091a(C0312b.m2311a(i2, i3, i4, i5)).m2092a();
    }

    @Deprecated
    /* renamed from: g */
    public C0282af m2084g() {
        return this.f2138b.mo2113d();
    }

    /* renamed from: h */
    public C0288d m2085h() {
        return this.f2138b.mo2114e();
    }

    @Deprecated
    /* renamed from: i */
    public C0282af m2086i() {
        return this.f2138b.mo2115f();
    }

    @Deprecated
    /* renamed from: j */
    public C0312b m2087j() {
        return this.f2138b.mo2117h();
    }

    @Deprecated
    /* renamed from: k */
    public C0312b m2088k() {
        return this.f2138b.mo2118i();
    }

    /* renamed from: b */
    public C0282af m2078b(int i2, int i3, int i4, int i5) {
        return this.f2138b.mo2102a(i2, i3, i4, i5);
    }

    /* renamed from: a */
    public C0312b m2072a(int i2) {
        return this.f2138b.mo2103a(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0282af)) {
            return false;
        }
        return C0268c.m1953a(this.f2138b, ((C0282af) obj).f2138b);
    }

    public int hashCode() {
        if (this.f2138b == null) {
            return 0;
        }
        return this.f2138b.hashCode();
    }

    /* renamed from: l */
    public WindowInsets m2089l() {
        if (this.f2138b instanceof h) {
            return ((h) this.f2138b).f2161c;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$g */
    private static class g {

        /* renamed from: a */
        static final C0282af f2153a = new b().m2092a().m2086i().m2084g().m2083f();

        /* renamed from: b */
        final C0282af f2154b;

        g(C0282af c0282af) {
            this.f2154b = c0282af;
        }

        /* renamed from: a */
        boolean mo2108a() {
            return false;
        }

        /* renamed from: b */
        boolean mo2111b() {
            return false;
        }

        /* renamed from: c */
        C0282af mo2112c() {
            return this.f2154b;
        }

        /* renamed from: d */
        C0282af mo2113d() {
            return this.f2154b;
        }

        /* renamed from: e */
        C0288d mo2114e() {
            return null;
        }

        /* renamed from: f */
        C0282af mo2115f() {
            return this.f2154b;
        }

        /* renamed from: g */
        C0312b mo2116g() {
            return C0312b.f2235a;
        }

        /* renamed from: h */
        C0312b mo2117h() {
            return C0312b.f2235a;
        }

        /* renamed from: i */
        C0312b mo2118i() {
            return mo2116g();
        }

        /* renamed from: j */
        C0312b mo2119j() {
            return mo2116g();
        }

        /* renamed from: k */
        C0312b mo2120k() {
            return mo2116g();
        }

        /* renamed from: a */
        C0282af mo2102a(int i, int i2, int i3, int i4) {
            return f2153a;
        }

        /* renamed from: a */
        C0312b mo2103a(int i) {
            return C0312b.f2235a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return mo2108a() == gVar.mo2108a() && mo2111b() == gVar.mo2111b() && C0268c.m1953a(mo2116g(), gVar.mo2116g()) && C0268c.m1953a(mo2117h(), gVar.mo2117h()) && C0268c.m1953a(mo2114e(), gVar.mo2114e());
        }

        public int hashCode() {
            return C0268c.m1952a(Boolean.valueOf(mo2108a()), Boolean.valueOf(mo2111b()), mo2116g(), mo2117h(), mo2114e());
        }

        /* renamed from: a */
        void mo2105a(C0282af c0282af) {
        }

        /* renamed from: a */
        void mo2106a(C0312b c0312b) {
        }

        /* renamed from: a */
        void mo2104a(View view) {
        }

        /* renamed from: b */
        void mo2109b(C0282af c0282af) {
        }

        /* renamed from: a */
        public void mo2107a(C0312b[] c0312bArr) {
        }

        /* renamed from: b */
        public void mo2110b(C0312b c0312b) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$h */
    private static class h extends g {

        /* renamed from: e */
        private static boolean f2155e = false;

        /* renamed from: f */
        private static Method f2156f;

        /* renamed from: g */
        private static Class<?> f2157g;

        /* renamed from: h */
        private static Class<?> f2158h;

        /* renamed from: i */
        private static Field f2159i;

        /* renamed from: j */
        private static Field f2160j;

        /* renamed from: c */
        final WindowInsets f2161c;

        /* renamed from: d */
        C0312b f2162d;

        /* renamed from: k */
        private C0312b[] f2163k;

        /* renamed from: l */
        private C0312b f2164l;

        /* renamed from: m */
        private C0282af f2165m;

        h(C0282af c0282af, WindowInsets windowInsets) {
            super(c0282af);
            this.f2164l = null;
            this.f2161c = windowInsets;
        }

        h(C0282af c0282af, h hVar) {
            this(c0282af, new WindowInsets(hVar.f2161c));
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        boolean mo2108a() {
            return this.f2161c.isRound();
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        public C0312b mo2103a(int i) {
            return m2121b(i, false);
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: b */
        private C0312b m2121b(int i, boolean z) {
            C0312b c0312b = C0312b.f2235a;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    c0312b = C0312b.m2314a(c0312b, m2125a(i2, z));
                }
            }
            return c0312b;
        }

        /* renamed from: a */
        protected C0312b m2125a(int i, boolean z) {
            C0288d e2;
            C0312b c0312b;
            switch (i) {
                case 1:
                    if (z) {
                        return C0312b.m2311a(0, Math.max(m2123l().f2237c, mo2116g().f2237c), 0, 0);
                    }
                    return C0312b.m2311a(0, mo2116g().f2237c, 0, 0);
                case 2:
                    if (z) {
                        C0312b m2123l = m2123l();
                        C0312b h = mo2117h();
                        return C0312b.m2311a(Math.max(m2123l.f2236b, h.f2236b), 0, Math.max(m2123l.f2238d, h.f2238d), Math.max(m2123l.f2239e, h.f2239e));
                    }
                    C0312b mo2116g = mo2116g();
                    c0312b = this.f2165m != null ? this.f2165m.m2087j() : null;
                    int i2 = mo2116g.f2239e;
                    return C0312b.m2311a(mo2116g.f2236b, 0, mo2116g.f2238d, c0312b != null ? Math.min(i2, c0312b.f2239e) : i2);
                case 8:
                    c0312b = this.f2163k != null ? this.f2163k[m.m2126a(8)] : null;
                    if (c0312b != null) {
                        return c0312b;
                    }
                    C0312b mo2116g2 = mo2116g();
                    C0312b m2123l2 = m2123l();
                    if (mo2116g2.f2239e > m2123l2.f2239e) {
                        return C0312b.m2311a(0, 0, 0, mo2116g2.f2239e);
                    }
                    if (this.f2162d != null && !this.f2162d.equals(C0312b.f2235a) && this.f2162d.f2239e > m2123l2.f2239e) {
                        return C0312b.m2311a(0, 0, 0, this.f2162d.f2239e);
                    }
                    return C0312b.f2235a;
                case 16:
                    return mo2118i();
                case 32:
                    return mo2119j();
                case 64:
                    return mo2120k();
                case 128:
                    if (this.f2165m != null) {
                        e2 = this.f2165m.m2085h();
                    } else {
                        e2 = mo2114e();
                    }
                    if (e2 != null) {
                        return C0312b.m2311a(e2.m2165c(), e2.m2163a(), e2.m2166d(), e2.m2164b());
                    }
                    return C0312b.f2235a;
                default:
                    return C0312b.f2235a;
            }
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: g */
        final C0312b mo2116g() {
            if (this.f2164l == null) {
                this.f2164l = C0312b.m2311a(this.f2161c.getSystemWindowInsetLeft(), this.f2161c.getSystemWindowInsetTop(), this.f2161c.getSystemWindowInsetRight(), this.f2161c.getSystemWindowInsetBottom());
            }
            return this.f2164l;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        C0282af mo2102a(int i, int i2, int i3, int i4) {
            b bVar = new b(C0282af.m2067a(this.f2161c));
            bVar.m2091a(C0282af.m2069a(mo2116g(), i, i2, i3, i4));
            bVar.m2093b(C0282af.m2069a(mo2117h(), i, i2, i3, i4));
            return bVar.m2092a();
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: b */
        void mo2109b(C0282af c0282af) {
            c0282af.m2074a(this.f2165m);
            c0282af.m2079b(this.f2162d);
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        void mo2105a(C0282af c0282af) {
            this.f2165m = c0282af;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        void mo2106a(C0312b c0312b) {
            this.f2162d = c0312b;
        }

        /* renamed from: l */
        private C0312b m2123l() {
            return this.f2165m != null ? this.f2165m.m2087j() : C0312b.f2235a;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        void mo2104a(View view) {
            C0312b m2122b = m2122b(view);
            if (m2122b == null) {
                m2122b = C0312b.f2235a;
            }
            mo2106a(m2122b);
        }

        /* renamed from: b */
        private C0312b m2122b(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f2155e) {
                m2124m();
            }
            if (f2156f == null || f2158h == null || f2159i == null) {
                return null;
            }
            try {
                Object invoke = f2156f.invoke(view, new Object[0]);
                if (invoke == null) {
                    Log.m191w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f2159i.get(f2160j.get(invoke));
                return rect != null ? C0312b.m2313a(rect) : null;
            } catch (ReflectiveOperationException e2) {
                Log.m185e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                return null;
            }
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: a */
        public void mo2107a(C0312b[] c0312bArr) {
            this.f2163k = c0312bArr;
        }

        @SuppressLint({"PrivateApi"})
        /* renamed from: m */
        private static void m2124m() {
            try {
                f2156f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f2157g = Class.forName("android.view.ViewRootImpl");
                f2158h = Class.forName("android.view.View$AttachInfo");
                f2159i = f2158h.getDeclaredField("mVisibleInsets");
                f2160j = f2157g.getDeclaredField("mAttachInfo");
                f2159i.setAccessible(true);
                f2160j.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.m185e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f2155e = true;
        }

        @Override // androidx.core.p031f.C0282af.g
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f2162d, ((h) obj).f2162d);
            }
            return false;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$i */
    private static class i extends h {

        /* renamed from: e */
        private C0312b f2166e;

        i(C0282af c0282af, WindowInsets windowInsets) {
            super(c0282af, windowInsets);
            this.f2166e = null;
        }

        i(C0282af c0282af, i iVar) {
            super(c0282af, iVar);
            this.f2166e = null;
            this.f2166e = iVar.f2166e;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: b */
        boolean mo2111b() {
            return this.f2161c.isConsumed();
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: d */
        C0282af mo2113d() {
            return C0282af.m2067a(this.f2161c.consumeStableInsets());
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: c */
        C0282af mo2112c() {
            return C0282af.m2067a(this.f2161c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: h */
        final C0312b mo2117h() {
            if (this.f2166e == null) {
                this.f2166e = C0312b.m2311a(this.f2161c.getStableInsetLeft(), this.f2161c.getStableInsetTop(), this.f2161c.getStableInsetRight(), this.f2161c.getStableInsetBottom());
            }
            return this.f2166e;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: b */
        public void mo2110b(C0312b c0312b) {
            this.f2166e = c0312b;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$j */
    private static class j extends i {
        j(C0282af c0282af, WindowInsets windowInsets) {
            super(c0282af, windowInsets);
        }

        j(C0282af c0282af, j jVar) {
            super(c0282af, jVar);
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: e */
        C0288d mo2114e() {
            return C0288d.m2162a(this.f2161c.getDisplayCutout());
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: f */
        C0282af mo2115f() {
            return C0282af.m2067a(this.f2161c.consumeDisplayCutout());
        }

        @Override // androidx.core.p031f.C0282af.h, androidx.core.p031f.C0282af.g
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return Objects.equals(this.f2161c, jVar.f2161c) && Objects.equals(this.f2162d, jVar.f2162d);
        }

        @Override // androidx.core.p031f.C0282af.g
        public int hashCode() {
            return this.f2161c.hashCode();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$k */
    private static class k extends j {

        /* renamed from: e */
        private C0312b f2167e;

        /* renamed from: f */
        private C0312b f2168f;

        /* renamed from: g */
        private C0312b f2169g;

        k(C0282af c0282af, WindowInsets windowInsets) {
            super(c0282af, windowInsets);
            this.f2167e = null;
            this.f2168f = null;
            this.f2169g = null;
        }

        k(C0282af c0282af, k kVar) {
            super(c0282af, kVar);
            this.f2167e = null;
            this.f2168f = null;
            this.f2169g = null;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: i */
        C0312b mo2118i() {
            if (this.f2167e == null) {
                this.f2167e = C0312b.m2312a(this.f2161c.getSystemGestureInsets());
            }
            return this.f2167e;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: j */
        C0312b mo2119j() {
            if (this.f2168f == null) {
                this.f2168f = C0312b.m2312a(this.f2161c.getMandatorySystemGestureInsets());
            }
            return this.f2168f;
        }

        @Override // androidx.core.p031f.C0282af.g
        /* renamed from: k */
        C0312b mo2120k() {
            if (this.f2169g == null) {
                this.f2169g = C0312b.m2312a(this.f2161c.getTappableElementInsets());
            }
            return this.f2169g;
        }

        @Override // androidx.core.p031f.C0282af.h, androidx.core.p031f.C0282af.g
        /* renamed from: a */
        C0282af mo2102a(int i, int i2, int i3, int i4) {
            return C0282af.m2067a(this.f2161c.inset(i, i2, i3, i4));
        }

        @Override // androidx.core.p031f.C0282af.i, androidx.core.p031f.C0282af.g
        /* renamed from: b */
        public void mo2110b(C0312b c0312b) {
        }
    }

    /* renamed from: a */
    static C0312b m2069a(C0312b c0312b, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, c0312b.f2236b - i2);
        int max2 = Math.max(0, c0312b.f2237c - i3);
        int max3 = Math.max(0, c0312b.f2238d - i4);
        int max4 = Math.max(0, c0312b.f2239e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? c0312b : C0312b.m2311a(max, max2, max3, max4);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$l */
    private static class l extends k {

        /* renamed from: e */
        static final C0282af f2170e = C0282af.m2067a(WindowInsets.CONSUMED);

        l(C0282af c0282af, WindowInsets windowInsets) {
            super(c0282af, windowInsets);
        }

        l(C0282af c0282af, l lVar) {
            super(c0282af, lVar);
        }

        @Override // androidx.core.p031f.C0282af.h, androidx.core.p031f.C0282af.g
        /* renamed from: a */
        public C0312b mo2103a(int i) {
            return C0312b.m2312a(this.f2161c.getInsets(n.m2127a(i)));
        }

        @Override // androidx.core.p031f.C0282af.h, androidx.core.p031f.C0282af.g
        /* renamed from: a */
        final void mo2104a(View view) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$b */
    public static final class b {

        /* renamed from: a */
        private final c f2143a;

        public b() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2143a = new f();
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2143a = new e();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f2143a = new d();
            } else {
                this.f2143a = new c();
            }
        }

        public b(C0282af c0282af) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f2143a = new f(c0282af);
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2143a = new e(c0282af);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f2143a = new d(c0282af);
            } else {
                this.f2143a = new c(c0282af);
            }
        }

        @Deprecated
        /* renamed from: a */
        public b m2091a(C0312b c0312b) {
            this.f2143a.mo2095a(c0312b);
            return this;
        }

        @Deprecated
        /* renamed from: b */
        public b m2093b(C0312b c0312b) {
            this.f2143a.mo2100e(c0312b);
            return this;
        }

        /* renamed from: a */
        public C0282af m2092a() {
            return this.f2143a.mo2096b();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$c */
    private static class c {

        /* renamed from: a */
        C0312b[] f2144a;

        /* renamed from: b */
        private final C0282af f2145b;

        c() {
            this(new C0282af((C0282af) null));
        }

        c(C0282af c0282af) {
            this.f2145b = c0282af;
        }

        /* renamed from: a */
        void mo2095a(C0312b c0312b) {
        }

        /* renamed from: b */
        void mo2097b(C0312b c0312b) {
        }

        /* renamed from: c */
        void mo2098c(C0312b c0312b) {
        }

        /* renamed from: d */
        void mo2099d(C0312b c0312b) {
        }

        /* renamed from: e */
        void mo2100e(C0312b c0312b) {
        }

        /* renamed from: a */
        protected final void m2094a() {
            if (this.f2144a != null) {
                C0312b c0312b = this.f2144a[m.m2126a(1)];
                C0312b c0312b2 = this.f2144a[m.m2126a(2)];
                if (c0312b2 == null) {
                    c0312b2 = this.f2145b.m2072a(2);
                }
                if (c0312b == null) {
                    c0312b = this.f2145b.m2072a(1);
                }
                mo2095a(C0312b.m2314a(c0312b, c0312b2));
                C0312b c0312b3 = this.f2144a[m.m2126a(16)];
                if (c0312b3 != null) {
                    mo2097b(c0312b3);
                }
                C0312b c0312b4 = this.f2144a[m.m2126a(32)];
                if (c0312b4 != null) {
                    mo2098c(c0312b4);
                }
                C0312b c0312b5 = this.f2144a[m.m2126a(64)];
                if (c0312b5 != null) {
                    mo2099d(c0312b5);
                }
            }
        }

        /* renamed from: b */
        C0282af mo2096b() {
            m2094a();
            return this.f2145b;
        }
    }

    /* renamed from: a */
    void m2076a(C0312b[] c0312bArr) {
        this.f2138b.mo2107a(c0312bArr);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$d */
    private static class d extends c {

        /* renamed from: b */
        private static Field f2146b;

        /* renamed from: d */
        private static Constructor<WindowInsets> f2148d;

        /* renamed from: f */
        private WindowInsets f2150f;

        /* renamed from: g */
        private C0312b f2151g;

        /* renamed from: c */
        private static boolean f2147c = false;

        /* renamed from: e */
        private static boolean f2149e = false;

        d() {
            this.f2150f = m2101c();
        }

        d(C0282af c0282af) {
            super(c0282af);
            this.f2150f = c0282af.m2089l();
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: a */
        void mo2095a(C0312b c0312b) {
            if (this.f2150f != null) {
                this.f2150f = this.f2150f.replaceSystemWindowInsets(c0312b.f2236b, c0312b.f2237c, c0312b.f2238d, c0312b.f2239e);
            }
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: e */
        void mo2100e(C0312b c0312b) {
            this.f2151g = c0312b;
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: b */
        C0282af mo2096b() {
            m2094a();
            C0282af m2067a = C0282af.m2067a(this.f2150f);
            m2067a.m2076a(this.f2144a);
            m2067a.m2075a(this.f2151g);
            return m2067a;
        }

        /* renamed from: c */
        private static WindowInsets m2101c() {
            if (!f2147c) {
                try {
                    f2146b = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.m187i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f2147c = true;
            }
            if (f2146b != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) f2146b.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.m187i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f2149e) {
                try {
                    f2148d = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.m187i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f2149e = true;
            }
            if (f2148d != null) {
                try {
                    return f2148d.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.m187i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    void m2075a(C0312b c0312b) {
        this.f2138b.mo2110b(c0312b);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$e */
    private static class e extends c {

        /* renamed from: b */
        final WindowInsets.Builder f2152b;

        e() {
            this.f2152b = new WindowInsets.Builder();
        }

        e(C0282af c0282af) {
            super(c0282af);
            WindowInsets.Builder builder;
            WindowInsets m2089l = c0282af.m2089l();
            if (m2089l != null) {
                builder = new WindowInsets.Builder(m2089l);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f2152b = builder;
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: a */
        void mo2095a(C0312b c0312b) {
            this.f2152b.setSystemWindowInsets(c0312b.m2315a());
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: b */
        void mo2097b(C0312b c0312b) {
            this.f2152b.setSystemGestureInsets(c0312b.m2315a());
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: c */
        void mo2098c(C0312b c0312b) {
            this.f2152b.setMandatorySystemGestureInsets(c0312b.m2315a());
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: d */
        void mo2099d(C0312b c0312b) {
            this.f2152b.setTappableElementInsets(c0312b.m2315a());
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: e */
        void mo2100e(C0312b c0312b) {
            this.f2152b.setStableInsets(c0312b.m2315a());
        }

        @Override // androidx.core.p031f.C0282af.c
        /* renamed from: b */
        C0282af mo2096b() {
            m2094a();
            C0282af m2067a = C0282af.m2067a(this.f2152b.build());
            m2067a.m2076a(this.f2144a);
            return m2067a;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$f */
    private static class f extends e {
        f() {
        }

        f(C0282af c0282af) {
            super(c0282af);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$m */
    public static final class m {
        /* renamed from: a */
        static int m2126a(int i) {
            switch (i) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 4:
                    return 2;
                case 8:
                    return 3;
                case 16:
                    return 4;
                case 32:
                    return 5;
                case 64:
                    return 6;
                case 128:
                    return 7;
                case 256:
                    return 8;
                default:
                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
            }
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$n */
    private static final class n {
        /* renamed from: a */
        static int m2127a(int i) {
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    switch (i3) {
                        case 1:
                            i2 |= WindowInsets.Type.statusBars();
                            break;
                        case 2:
                            i2 |= WindowInsets.Type.navigationBars();
                            break;
                        case 4:
                            i2 |= WindowInsets.Type.captionBar();
                            break;
                        case 8:
                            i2 |= WindowInsets.Type.ime();
                            break;
                        case 16:
                            i2 |= WindowInsets.Type.systemGestures();
                            break;
                        case 32:
                            i2 |= WindowInsets.Type.mandatorySystemGestures();
                            break;
                        case 64:
                            i2 |= WindowInsets.Type.tappableElement();
                            break;
                        case 128:
                            i2 |= WindowInsets.Type.displayCutout();
                            break;
                    }
                }
            }
            return i2;
        }
    }

    /* renamed from: a */
    void m2074a(C0282af c0282af) {
        this.f2138b.mo2105a(c0282af);
    }

    /* renamed from: b */
    void m2079b(C0312b c0312b) {
        this.f2138b.mo2106a(c0312b);
    }

    /* renamed from: a */
    void m2073a(View view) {
        this.f2138b.mo2104a(view);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: androidx.core.f.af$a */
    static class a {

        /* renamed from: a */
        private static Field f2139a;

        /* renamed from: b */
        private static Field f2140b;

        /* renamed from: c */
        private static Field f2141c;

        /* renamed from: d */
        private static boolean f2142d;

        static {
            try {
                f2139a = View.class.getDeclaredField("mAttachInfo");
                f2139a.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2140b = cls.getDeclaredField("mStableInsets");
                f2140b.setAccessible(true);
                f2141c = cls.getDeclaredField("mContentInsets");
                f2141c.setAccessible(true);
                f2142d = true;
            } catch (ReflectiveOperationException e2) {
                Log.m191w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        /* renamed from: a */
        public static C0282af m2090a(View view) {
            if (!f2142d || !view.isAttachedToWindow()) {
                return null;
            }
            try {
                Object obj = f2139a.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) f2140b.get(obj);
                    Rect rect2 = (Rect) f2141c.get(obj);
                    if (rect != null && rect2 != null) {
                        C0282af m2092a = new b().m2093b(C0312b.m2313a(rect)).m2091a(C0312b.m2313a(rect2)).m2092a();
                        m2092a.m2074a(m2092a);
                        m2092a.m2073a(view.getRootView());
                        return m2092a;
                    }
                }
            } catch (IllegalAccessException e2) {
                Log.m191w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
            }
            return null;
        }
    }
}
