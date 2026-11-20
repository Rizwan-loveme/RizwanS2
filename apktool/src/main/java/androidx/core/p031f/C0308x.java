package androidx.core.p031f;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.C0225a;
import androidx.core.p031f.C0271a;
import androidx.core.p031f.C0282af;
import androidx.core.p031f.p032a.C0273b;
import androidx.core.p031f.p032a.InterfaceC0276e;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: androidx.core.f.x */
/* loaded from: classes.dex */
public class C0308x {

    /* renamed from: b */
    private static Field f2211b;

    /* renamed from: c */
    private static boolean f2212c;

    /* renamed from: d */
    private static WeakHashMap<View, String> f2213d;

    /* renamed from: f */
    private static Field f2215f;

    /* renamed from: h */
    private static ThreadLocal<Rect> f2217h;

    /* renamed from: a */
    private static final AtomicInteger f2210a = new AtomicInteger(1);

    /* renamed from: e */
    private static WeakHashMap<View, C0278ab> f2214e = null;

    /* renamed from: g */
    private static boolean f2216g = false;

    /* renamed from: i */
    private static final int[] f2218i = {C0225a.c.accessibility_custom_action_0, C0225a.c.accessibility_custom_action_1, C0225a.c.accessibility_custom_action_2, C0225a.c.accessibility_custom_action_3, C0225a.c.accessibility_custom_action_4, C0225a.c.accessibility_custom_action_5, C0225a.c.accessibility_custom_action_6, C0225a.c.accessibility_custom_action_7, C0225a.c.accessibility_custom_action_8, C0225a.c.accessibility_custom_action_9, C0225a.c.accessibility_custom_action_10, C0225a.c.accessibility_custom_action_11, C0225a.c.accessibility_custom_action_12, C0225a.c.accessibility_custom_action_13, C0225a.c.accessibility_custom_action_14, C0225a.c.accessibility_custom_action_15, C0225a.c.accessibility_custom_action_16, C0225a.c.accessibility_custom_action_17, C0225a.c.accessibility_custom_action_18, C0225a.c.accessibility_custom_action_19, C0225a.c.accessibility_custom_action_20, C0225a.c.accessibility_custom_action_21, C0225a.c.accessibility_custom_action_22, C0225a.c.accessibility_custom_action_23, C0225a.c.accessibility_custom_action_24, C0225a.c.accessibility_custom_action_25, C0225a.c.accessibility_custom_action_26, C0225a.c.accessibility_custom_action_27, C0225a.c.accessibility_custom_action_28, C0225a.c.accessibility_custom_action_29, C0225a.c.accessibility_custom_action_30, C0225a.c.accessibility_custom_action_31};

    /* renamed from: j */
    private static final InterfaceC0304t f2219j = new InterfaceC0304t() { // from class: androidx.core.f.x.1
        @Override // androidx.core.p031f.InterfaceC0304t
        /* renamed from: a */
        public C0287c mo1559a(C0287c c0287c) {
            return c0287c;
        }
    };

    /* renamed from: k */
    private static a f2220k = new a();

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$f */
    public interface f {
        /* renamed from: a */
        boolean m2296a(View view, KeyEvent keyEvent);
    }

    /* renamed from: a */
    private static Rect m2220a() {
        if (f2217h == null) {
            f2217h = new ThreadLocal<>();
        }
        Rect rect = f2217h.get();
        if (rect == null) {
            rect = new Rect();
            f2217h.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* renamed from: a */
    public static void m2230a(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.m2295a(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    /* renamed from: a */
    public static void m2236a(View view, C0271a c0271a) {
        if (c0271a == null && (m2214B(view) instanceof C0271a.a)) {
            c0271a = new C0271a();
        }
        view.setAccessibilityDelegate(c0271a == null ? null : c0271a.m1965a());
    }

    /* renamed from: a */
    public static C0271a m2221a(View view) {
        View.AccessibilityDelegate m2214B = m2214B(view);
        if (m2214B == null) {
            return null;
        }
        if (m2214B instanceof C0271a.a) {
            return ((C0271a.a) m2214B).f2070a;
        }
        return new C0271a(m2214B);
    }

    /* renamed from: b */
    static C0271a m2243b(View view) {
        C0271a m2221a = m2221a(view);
        if (m2221a == null) {
            m2221a = new C0271a();
        }
        m2236a(view, m2221a);
        return m2221a;
    }

    /* renamed from: B */
    private static View.AccessibilityDelegate m2214B(View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : m2215C(view);
    }

    /* renamed from: C */
    private static View.AccessibilityDelegate m2215C(View view) {
        if (f2216g) {
            return null;
        }
        if (f2215f == null) {
            try {
                f2215f = View.class.getDeclaredField("mAccessibilityDelegate");
                f2215f.setAccessible(true);
            } catch (Throwable th) {
                f2216g = true;
                return null;
            }
        }
        try {
            Object obj = f2215f.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable th2) {
            f2216g = true;
            return null;
        }
    }

    /* renamed from: c */
    public static void m2249c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* renamed from: a */
    public static void m2239a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* renamed from: a */
    public static void m2240a(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* renamed from: d */
    public static int m2251d(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m2227a(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    /* renamed from: a */
    public static void m2235a(View view, C0273b.a aVar, CharSequence charSequence, InterfaceC0276e interfaceC0276e) {
        if (interfaceC0276e == null && charSequence == null) {
            m2246b(view, aVar.m2035a());
        } else {
            m2234a(view, aVar.m2036a(charSequence, interfaceC0276e));
        }
    }

    /* renamed from: a */
    private static void m2234a(View view, C0273b.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2243b(view);
            m2225a(aVar.m2035a(), view);
            m2216D(view).add(aVar);
            m2256e(view, 0);
        }
    }

    /* renamed from: b */
    public static void m2246b(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            m2225a(i, view);
            m2256e(view, 0);
        }
    }

    /* renamed from: a */
    private static void m2225a(int i, View view) {
        List<C0273b.a> m2216D = m2216D(view);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < m2216D.size()) {
                if (m2216D.get(i3).m2035a() != i) {
                    i2 = i3 + 1;
                } else {
                    m2216D.remove(i3);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: D */
    private static List<C0273b.a> m2216D(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(C0225a.c.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(C0225a.c.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    /* renamed from: e */
    public static final CharSequence m2255e(View view) {
        return m2252d().m2289c(view);
    }

    /* renamed from: f */
    public static int m2257f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    /* renamed from: g */
    public static ViewParent m2259g(View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    /* renamed from: h */
    public static int m2261h(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m2229a(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    /* renamed from: i */
    public static int m2262i(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f2212c) {
            try {
                f2211b = View.class.getDeclaredField("mMinHeight");
                f2211b.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            f2212c = true;
        }
        if (f2211b != null) {
            try {
                return ((Integer) f2211b.get(view)).intValue();
            } catch (Exception e3) {
            }
        }
        return 0;
    }

    /* renamed from: j */
    public static C0278ab m2263j(View view) {
        if (f2214e == null) {
            f2214e = new WeakHashMap<>();
        }
        C0278ab c0278ab = f2214e.get(view);
        if (c0278ab == null) {
            C0278ab c0278ab2 = new C0278ab(view);
            f2214e.put(view, c0278ab2);
            return c0278ab2;
        }
        return c0278ab;
    }

    /* renamed from: a */
    public static void m2226a(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    /* renamed from: k */
    public static float m2264k(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    /* renamed from: a */
    public static void m2241a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f2213d == null) {
            f2213d = new WeakHashMap<>();
        }
        f2213d.put(view, str);
    }

    /* renamed from: l */
    public static String m2265l(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        if (f2213d == null) {
            return null;
        }
        return f2213d.get(view);
    }

    /* renamed from: m */
    public static int m2266m(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* renamed from: n */
    public static void m2267n(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* renamed from: o */
    public static boolean m2268o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    /* renamed from: a */
    public static void m2237a(View view, InterfaceC0302r interfaceC0302r) {
        if (Build.VERSION.SDK_INT >= 21) {
            c.m2292a(view, interfaceC0302r);
        }
    }

    /* renamed from: a */
    public static C0282af m2222a(View view, C0282af c0282af) {
        WindowInsets m2089l;
        if (Build.VERSION.SDK_INT >= 21 && (m2089l = c0282af.m2089l()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(m2089l);
            if (!onApplyWindowInsets.equals(m2089l)) {
                return C0282af.m2068a(onApplyWindowInsets, view);
            }
            return c0282af;
        }
        return c0282af;
    }

    /* renamed from: b */
    public static C0282af m2244b(View view, C0282af c0282af) {
        WindowInsets m2089l;
        if (Build.VERSION.SDK_INT >= 21 && (m2089l = c0282af.m2089l()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(m2089l);
            if (!dispatchApplyWindowInsets.equals(m2089l)) {
                return C0282af.m2068a(dispatchApplyWindowInsets, view);
            }
            return c0282af;
        }
        return c0282af;
    }

    /* renamed from: p */
    public static C0282af m2269p(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.m2294a(view);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return c.m2290a(view);
        }
        return null;
    }

    /* renamed from: a */
    public static C0282af m2223a(View view, C0282af c0282af, Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return c.m2291a(view, c0282af, rect);
        }
        return c0282af;
    }

    /* renamed from: q */
    public static String[] m2270q(View view) {
        return (String[]) view.getTag(C0225a.c.tag_on_receive_content_mime_types);
    }

    /* renamed from: a */
    public static C0287c m2224a(View view, C0287c c0287c) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.m182d("ViewCompat", "performReceiveContent: " + c0287c + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        InterfaceC0303s interfaceC0303s = (InterfaceC0303s) view.getTag(C0225a.c.tag_on_receive_content_listener);
        if (interfaceC0303s != null) {
            C0287c mo2208a = interfaceC0303s.mo2208a(view, c0287c);
            if (mo2208a == null) {
                return null;
            }
            return m2217E(view).mo1559a(mo2208a);
        }
        return m2217E(view).mo1559a(c0287c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: E */
    private static InterfaceC0304t m2217E(View view) {
        return view instanceof InterfaceC0304t ? (InterfaceC0304t) view : f2219j;
    }

    /* renamed from: a */
    public static void m2233a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: r */
    public static ColorStateList m2271r(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof InterfaceC0307w) {
            return ((InterfaceC0307w) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2231a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                    return;
                }
                return;
            }
            return;
        }
        if (view instanceof InterfaceC0307w) {
            ((InterfaceC0307w) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: s */
    public static PorterDuff.Mode m2272s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof InterfaceC0307w) {
            return ((InterfaceC0307w) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m2232a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                    return;
                }
                return;
            }
            return;
        }
        if (view instanceof InterfaceC0307w) {
            ((InterfaceC0307w) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: t */
    public static boolean m2273t(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof InterfaceC0294j) {
            return ((InterfaceC0294j) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: u */
    public static void m2274u(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof InterfaceC0294j) {
            ((InterfaceC0294j) view).stopNestedScroll();
        }
    }

    /* renamed from: v */
    public static boolean m2275v(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: c */
    public static void m2250c(View view, int i) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect m2220a = m2220a();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                m2220a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !m2220a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            m2258f(view, i);
            if (z && m2220a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(m2220a);
                return;
            }
            return;
        }
        m2258f(view, i);
    }

    /* renamed from: f */
    private static void m2258f(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            m2218F(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                m2218F((View) parent);
            }
        }
    }

    /* renamed from: d */
    public static void m2253d(View view, int i) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Rect m2220a = m2220a();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                m2220a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !m2220a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            m2260g(view, i);
            if (z && m2220a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(m2220a);
                return;
            }
            return;
        }
        m2260g(view, i);
    }

    /* renamed from: g */
    private static void m2260g(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            m2218F(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                m2218F((View) parent);
            }
        }
    }

    /* renamed from: F */
    private static void m2218F(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: w */
    public static boolean m2276w(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* renamed from: x */
    public static boolean m2277x(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    /* renamed from: a */
    public static void m2228a(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: a */
    public static void m2238a(View view, C0306v c0306v) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (c0306v != null ? c0306v.m2212a() : null));
        }
    }

    /* renamed from: a */
    static boolean m2242a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.m2298a(view).m2302a(keyEvent);
    }

    /* renamed from: b */
    static boolean m2247b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return g.m2298a(view).m2303a(view, keyEvent);
    }

    /* renamed from: y */
    public static boolean m2278y(View view) {
        Boolean m2289c = m2245b().m2289c(view);
        if (m2289c == null) {
            return false;
        }
        return m2289c.booleanValue();
    }

    /* renamed from: b */
    private static b<Boolean> m2245b() {
        return new b<Boolean>(C0225a.c.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.f.x.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p031f.C0308x.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean mo2281b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        };
    }

    /* renamed from: z */
    public static CharSequence m2279z(View view) {
        return m2248c().m2289c(view);
    }

    /* renamed from: c */
    private static b<CharSequence> m2248c() {
        return new b<CharSequence>(C0225a.c.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.f.x.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p031f.C0308x.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharSequence mo2281b(View view) {
                return view.getAccessibilityPaneTitle();
            }
        };
    }

    /* renamed from: d */
    private static b<CharSequence> m2252d() {
        return new b<CharSequence>(C0225a.c.tag_state_description, CharSequence.class, 64, 30) { // from class: androidx.core.f.x.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p031f.C0308x.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharSequence mo2281b(View view) {
                return view.getStateDescription();
            }
        };
    }

    /* renamed from: A */
    public static boolean m2213A(View view) {
        Boolean m2289c = m2254e().m2289c(view);
        if (m2289c == null) {
            return false;
        }
        return m2289c.booleanValue();
    }

    /* renamed from: e */
    private static b<Boolean> m2254e() {
        return new b<Boolean>(C0225a.c.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.f.x.5
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.p031f.C0308x.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean mo2281b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$b */
    static abstract class b<T> {

        /* renamed from: a */
        private final int f2222a;

        /* renamed from: b */
        private final Class<T> f2223b;

        /* renamed from: c */
        private final int f2224c;

        /* renamed from: d */
        private final int f2225d;

        /* renamed from: b */
        abstract T mo2281b(View view);

        b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        b(int i, Class<T> cls, int i2, int i3) {
            this.f2222a = i;
            this.f2223b = cls;
            this.f2225d = i2;
            this.f2224c = i3;
        }

        /* renamed from: c */
        T m2289c(View view) {
            if (m2287a()) {
                return mo2281b(view);
            }
            if (m2288b()) {
                T t = (T) view.getTag(this.f2222a);
                if (this.f2223b.isInstance(t)) {
                    return t;
                }
            }
            return null;
        }

        /* renamed from: a */
        private boolean m2287a() {
            return Build.VERSION.SDK_INT >= this.f2224c;
        }

        /* renamed from: b */
        private boolean m2288b() {
            return Build.VERSION.SDK_INT >= 19;
        }
    }

    /* renamed from: e */
    static void m2256e(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager.isEnabled()) {
            boolean z = m2279z(view) != null && view.getVisibility() == 0;
            if (m2261h(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(m2279z(view));
                    m2219G(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(m2279z(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e2) {
                    Log.m185e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    /* renamed from: G */
    private static void m2219G(View view) {
        if (m2251d(view) == 0) {
            m2227a(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (m2251d((View) parent) == 4) {
                m2227a(view, 2);
                return;
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$a */
    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        private WeakHashMap<View, Boolean> f2221a = new WeakHashMap<>();

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f2221a.entrySet()) {
                    m2286a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m2285a(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        /* renamed from: a */
        private void m2286a(View view, boolean z) {
            int i;
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    i = 16;
                } else {
                    i = 32;
                }
                C0308x.m2256e(view, i);
                this.f2221a.put(view, Boolean.valueOf(z2));
            }
        }

        /* renamed from: a */
        private void m2285a(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$g */
    static class g {

        /* renamed from: a */
        private static final ArrayList<WeakReference<View>> f2229a = new ArrayList<>();

        /* renamed from: b */
        private WeakHashMap<View, Boolean> f2230b = null;

        /* renamed from: c */
        private SparseArray<WeakReference<View>> f2231c = null;

        /* renamed from: d */
        private WeakReference<KeyEvent> f2232d = null;

        g() {
        }

        /* renamed from: a */
        private SparseArray<WeakReference<View>> m2297a() {
            if (this.f2231c == null) {
                this.f2231c = new SparseArray<>();
            }
            return this.f2231c;
        }

        /* renamed from: a */
        static g m2298a(View view) {
            g gVar = (g) view.getTag(C0225a.c.tag_unhandled_key_event_manager);
            if (gVar == null) {
                g gVar2 = new g();
                view.setTag(C0225a.c.tag_unhandled_key_event_manager, gVar2);
                return gVar2;
            }
            return gVar;
        }

        /* renamed from: a */
        boolean m2303a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m2300b();
            }
            View m2299b = m2299b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (m2299b != null && !KeyEvent.isModifierKey(keyCode)) {
                    m2297a().put(keyCode, new WeakReference<>(m2299b));
                }
            }
            return m2299b != null;
        }

        /* renamed from: b */
        private View m2299b(View view, KeyEvent keyEvent) {
            if (this.f2230b == null || !this.f2230b.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View m2299b = m2299b(viewGroup.getChildAt(childCount), keyEvent);
                    if (m2299b != null) {
                        return m2299b;
                    }
                }
            }
            if (m2301c(view, keyEvent)) {
                return view;
            }
            return null;
        }

        /* renamed from: a */
        boolean m2302a(KeyEvent keyEvent) {
            int indexOfKey;
            if (this.f2232d != null && this.f2232d.get() == keyEvent) {
                return false;
            }
            this.f2232d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReference = null;
            SparseArray<WeakReference<View>> m2297a = m2297a();
            if (keyEvent.getAction() == 1 && (indexOfKey = m2297a.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = m2297a.valueAt(indexOfKey);
                m2297a.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = m2297a.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = weakReference.get();
            if (view != null && C0308x.m2276w(view)) {
                m2301c(view, keyEvent);
            }
            return true;
        }

        /* renamed from: c */
        private boolean m2301c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(C0225a.c.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((f) arrayList.get(size)).m2296a(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: b */
        private void m2300b() {
            if (this.f2230b != null) {
                this.f2230b.clear();
            }
            if (!f2229a.isEmpty()) {
                synchronized (f2229a) {
                    if (this.f2230b == null) {
                        this.f2230b = new WeakHashMap<>();
                    }
                    for (int size = f2229a.size() - 1; size >= 0; size--) {
                        View view = f2229a.get(size).get();
                        if (view == null) {
                            f2229a.remove(size);
                        } else {
                            this.f2230b.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f2230b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$c */
    private static class c {
        /* renamed from: a */
        public static C0282af m2290a(View view) {
            return C0282af.a.m2090a(view);
        }

        /* renamed from: a */
        static C0282af m2291a(View view, C0282af c0282af, Rect rect) {
            WindowInsets m2089l = c0282af.m2089l();
            if (m2089l != null) {
                return C0282af.m2068a(view.computeSystemWindowInsets(m2089l, rect), view);
            }
            rect.setEmpty();
            return c0282af;
        }

        /* renamed from: a */
        static void m2292a(final View view, final InterfaceC0302r interfaceC0302r) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(C0225a.c.tag_on_apply_window_listener, interfaceC0302r);
            }
            if (interfaceC0302r == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(C0225a.c.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.f.x.c.1

                    /* renamed from: a */
                    C0282af f2226a = null;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        C0282af m2068a = C0282af.m2068a(windowInsets, view2);
                        if (Build.VERSION.SDK_INT < 30) {
                            c.m2293a(windowInsets, View.this);
                            if (m2068a.equals(this.f2226a)) {
                                return interfaceC0302r.mo552a(view2, m2068a).m2089l();
                            }
                        }
                        this.f2226a = m2068a;
                        C0282af mo552a = interfaceC0302r.mo552a(view2, m2068a);
                        if (Build.VERSION.SDK_INT >= 30) {
                            return mo552a.m2089l();
                        }
                        C0308x.m2267n(view2);
                        return mo552a.m2089l();
                    }
                });
            }
        }

        /* renamed from: a */
        static void m2293a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(C0225a.c.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$d */
    private static class d {
        /* renamed from: a */
        public static C0282af m2294a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C0282af m2067a = C0282af.m2067a(rootWindowInsets);
            m2067a.m2074a(m2067a);
            m2067a.m2073a(view.getRootView());
            return m2067a;
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: androidx.core.f.x$e */
    private static class e {
        /* renamed from: a */
        static void m2295a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }
}
