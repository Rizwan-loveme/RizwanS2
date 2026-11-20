package androidx.core.p031f.p032a;

import android.C0012R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.C0225a;
import androidx.core.p026b.C0244a;
import androidx.core.p031f.p032a.InterfaceC0276e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: androidx.core.f.a.b */
/* loaded from: classes.dex */
public class C0273b {

    /* renamed from: d */
    private static int f2074d = 0;

    /* renamed from: b */
    private final AccessibilityNodeInfo f2076b;

    /* renamed from: a */
    public int f2075a = -1;

    /* renamed from: c */
    private int f2077c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: androidx.core.f.a.b$a */
    public static class a {

        /* renamed from: A */
        public static final a f2078A;

        /* renamed from: B */
        public static final a f2079B;

        /* renamed from: C */
        public static final a f2080C;

        /* renamed from: D */
        public static final a f2081D;

        /* renamed from: E */
        public static final a f2082E;

        /* renamed from: F */
        public static final a f2083F;

        /* renamed from: G */
        public static final a f2084G;

        /* renamed from: H */
        public static final a f2085H;

        /* renamed from: I */
        public static final a f2086I;

        /* renamed from: J */
        public static final a f2087J;

        /* renamed from: K */
        public static final a f2088K;

        /* renamed from: L */
        public static final a f2089L;

        /* renamed from: M */
        public static final a f2090M;

        /* renamed from: a */
        public static final a f2091a = new a(1, null);

        /* renamed from: b */
        public static final a f2092b = new a(2, null);

        /* renamed from: c */
        public static final a f2093c = new a(4, null);

        /* renamed from: d */
        public static final a f2094d = new a(8, null);

        /* renamed from: e */
        public static final a f2095e = new a(16, null);

        /* renamed from: f */
        public static final a f2096f = new a(32, null);

        /* renamed from: g */
        public static final a f2097g = new a(64, null);

        /* renamed from: h */
        public static final a f2098h = new a(128, null);

        /* renamed from: i */
        public static final a f2099i = new a(256, null, InterfaceC0276e.b.class);

        /* renamed from: j */
        public static final a f2100j = new a(512, null, InterfaceC0276e.b.class);

        /* renamed from: k */
        public static final a f2101k = new a(1024, null, InterfaceC0276e.c.class);

        /* renamed from: l */
        public static final a f2102l = new a(2048, null, InterfaceC0276e.c.class);

        /* renamed from: m */
        public static final a f2103m = new a(4096, null);

        /* renamed from: n */
        public static final a f2104n = new a(8192, null);

        /* renamed from: o */
        public static final a f2105o = new a(16384, null);

        /* renamed from: p */
        public static final a f2106p = new a(32768, null);

        /* renamed from: q */
        public static final a f2107q = new a(65536, null);

        /* renamed from: r */
        public static final a f2108r = new a(131072, null, InterfaceC0276e.g.class);

        /* renamed from: s */
        public static final a f2109s = new a(262144, null);

        /* renamed from: t */
        public static final a f2110t = new a(524288, null);

        /* renamed from: u */
        public static final a f2111u = new a(1048576, null);

        /* renamed from: v */
        public static final a f2112v = new a(2097152, null, InterfaceC0276e.h.class);

        /* renamed from: w */
        public static final a f2113w;

        /* renamed from: x */
        public static final a f2114x;

        /* renamed from: y */
        public static final a f2115y;

        /* renamed from: z */
        public static final a f2116z;

        /* renamed from: N */
        final Object f2117N;

        /* renamed from: O */
        protected final InterfaceC0276e f2118O;

        /* renamed from: P */
        private final int f2119P;

        /* renamed from: Q */
        private final Class<? extends InterfaceC0276e.a> f2120Q;

        static {
            f2113w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, C0012R.id.accessibilityActionShowOnScreen, null, null, null);
            f2114x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, C0012R.id.accessibilityActionScrollToPosition, null, null, InterfaceC0276e.e.class);
            f2115y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, C0012R.id.accessibilityActionScrollUp, null, null, null);
            f2116z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, C0012R.id.accessibilityActionScrollLeft, null, null, null);
            f2078A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, C0012R.id.accessibilityActionScrollDown, null, null, null);
            f2079B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, C0012R.id.accessibilityActionScrollRight, null, null, null);
            f2080C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, C0012R.id.accessibilityActionPageUp, null, null, null);
            f2081D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, C0012R.id.accessibilityActionPageDown, null, null, null);
            f2082E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, C0012R.id.accessibilityActionPageLeft, null, null, null);
            f2083F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, C0012R.id.accessibilityActionPageRight, null, null, null);
            f2084G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, C0012R.id.accessibilityActionContextClick, null, null, null);
            f2085H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, C0012R.id.accessibilityActionSetProgress, null, null, InterfaceC0276e.f.class);
            f2086I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, C0012R.id.accessibilityActionMoveWindow, null, null, InterfaceC0276e.d.class);
            f2087J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, C0012R.id.accessibilityActionShowTooltip, null, null, null);
            f2088K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, C0012R.id.accessibilityActionHideTooltip, null, null, null);
            f2089L = new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            f2090M = new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
        }

        public a(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i, CharSequence charSequence, Class<? extends InterfaceC0276e.a> cls) {
            this(null, i, charSequence, null, cls);
        }

        a(Object obj, int i, CharSequence charSequence, InterfaceC0276e interfaceC0276e, Class<? extends InterfaceC0276e.a> cls) {
            this.f2119P = i;
            this.f2118O = interfaceC0276e;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.f2117N = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.f2117N = obj;
            }
            this.f2120Q = cls;
        }

        /* renamed from: a */
        public int m2035a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2117N).getId();
            }
            return 0;
        }

        /* renamed from: b */
        public CharSequence m2038b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.f2117N).getLabel();
            }
            return null;
        }

        /* renamed from: a */
        public boolean m2037a(View view, Bundle bundle) {
            Exception e2;
            InterfaceC0276e.a aVar;
            if (this.f2118O == null) {
                return false;
            }
            InterfaceC0276e.a aVar2 = null;
            if (this.f2120Q == null) {
                aVar = null;
            } else {
                try {
                    aVar = this.f2120Q.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVar.m2048a(bundle);
                    } catch (Exception e3) {
                        e2 = e3;
                        aVar2 = aVar;
                        Log.m185e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (this.f2120Q == null ? "null" : this.f2120Q.getName()), e2);
                        aVar = aVar2;
                        return this.f2118O.mo2047a(view, aVar);
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
            return this.f2118O.mo2047a(view, aVar);
        }

        /* renamed from: a */
        public a m2036a(CharSequence charSequence, InterfaceC0276e interfaceC0276e) {
            return new a(null, this.f2119P, charSequence, interfaceC0276e, this.f2120Q);
        }

        public int hashCode() {
            if (this.f2117N != null) {
                return this.f2117N.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f2117N == null) {
                if (aVar.f2117N != null) {
                    return false;
                }
            } else if (!this.f2117N.equals(aVar.f2117N)) {
                return false;
            }
            return true;
        }
    }

    private C0273b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2076b = accessibilityNodeInfo;
    }

    /* renamed from: a */
    public static C0273b m1976a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0273b(accessibilityNodeInfo);
    }

    /* renamed from: a */
    public AccessibilityNodeInfo m1988a() {
        return this.f2076b;
    }

    /* renamed from: a */
    public static C0273b m1977a(C0273b c0273b) {
        return m1976a(AccessibilityNodeInfo.obtain(c0273b.f2076b));
    }

    /* renamed from: a */
    public void m1991a(View view) {
        this.f2077c = -1;
        this.f2076b.setSource(view);
    }

    /* renamed from: b */
    public void m1999b(View view) {
        this.f2076b.addChild(view);
    }

    /* renamed from: b */
    public int m1997b() {
        return this.f2076b.getActions();
    }

    /* renamed from: a */
    public void m1989a(int i) {
        this.f2076b.addAction(i);
    }

    /* renamed from: a */
    private List<Integer> m1978a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f2076b.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f2076b.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    /* renamed from: a */
    public void m1992a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2076b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2117N);
        }
    }

    /* renamed from: b */
    public boolean m2002b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f2076b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f2117N);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m1996a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2076b.performAction(i, bundle);
        }
        return false;
    }

    /* renamed from: c */
    public void m2004c(View view) {
        this.f2075a = -1;
        this.f2076b.setParent(view);
    }

    @Deprecated
    /* renamed from: a */
    public void m1990a(Rect rect) {
        this.f2076b.getBoundsInParent(rect);
    }

    /* renamed from: b */
    public void m1998b(Rect rect) {
        this.f2076b.getBoundsInScreen(rect);
    }

    /* renamed from: c */
    public void m2003c(Rect rect) {
        this.f2076b.setBoundsInScreen(rect);
    }

    /* renamed from: c */
    public boolean m2006c() {
        return this.f2076b.isCheckable();
    }

    /* renamed from: d */
    public boolean m2009d() {
        return this.f2076b.isChecked();
    }

    /* renamed from: e */
    public boolean m2012e() {
        return this.f2076b.isFocusable();
    }

    /* renamed from: a */
    public void m1995a(boolean z) {
        this.f2076b.setFocusable(z);
    }

    /* renamed from: f */
    public boolean m2015f() {
        return this.f2076b.isFocused();
    }

    /* renamed from: b */
    public void m2001b(boolean z) {
        this.f2076b.setFocused(z);
    }

    /* renamed from: g */
    public boolean m2017g() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2076b.isVisibleToUser();
        }
        return false;
    }

    /* renamed from: c */
    public void m2005c(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2076b.setVisibleToUser(z);
        }
    }

    /* renamed from: h */
    public boolean m2019h() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f2076b.isAccessibilityFocused();
        }
        return false;
    }

    /* renamed from: d */
    public void m2008d(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2076b.setAccessibilityFocused(z);
        }
    }

    /* renamed from: i */
    public boolean m2021i() {
        return this.f2076b.isSelected();
    }

    /* renamed from: e */
    public void m2011e(boolean z) {
        this.f2076b.setSelected(z);
    }

    /* renamed from: j */
    public boolean m2022j() {
        return this.f2076b.isClickable();
    }

    /* renamed from: k */
    public boolean m2023k() {
        return this.f2076b.isLongClickable();
    }

    /* renamed from: l */
    public boolean m2024l() {
        return this.f2076b.isEnabled();
    }

    /* renamed from: f */
    public void m2014f(boolean z) {
        this.f2076b.setEnabled(z);
    }

    /* renamed from: m */
    public boolean m2025m() {
        return this.f2076b.isPassword();
    }

    /* renamed from: n */
    public boolean m2026n() {
        return this.f2076b.isScrollable();
    }

    /* renamed from: g */
    public void m2016g(boolean z) {
        this.f2076b.setScrollable(z);
    }

    /* renamed from: o */
    public CharSequence m2027o() {
        return this.f2076b.getPackageName();
    }

    /* renamed from: a */
    public void m1993a(CharSequence charSequence) {
        this.f2076b.setPackageName(charSequence);
    }

    /* renamed from: p */
    public CharSequence m2028p() {
        return this.f2076b.getClassName();
    }

    /* renamed from: b */
    public void m2000b(CharSequence charSequence) {
        this.f2076b.setClassName(charSequence);
    }

    /* renamed from: q */
    public CharSequence m2029q() {
        int i = 0;
        if (!m1986w()) {
            return this.f2076b.getText();
        }
        List<Integer> m1978a = m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> m1978a2 = m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> m1978a3 = m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> m1978a4 = m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f2076b.getText(), 0, this.f2076b.getText().length()));
        while (true) {
            int i2 = i;
            if (i2 >= m1978a.size()) {
                return spannableString;
            }
            spannableString.setSpan(new C0272a(m1978a4.get(i2).intValue(), this, m2034v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), m1978a.get(i2).intValue(), m1978a2.get(i2).intValue(), m1978a3.get(i2).intValue());
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public void m1994a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
            m1987x();
            m1985f(view);
            ClickableSpan[] m1982c = m1982c(charSequence);
            if (m1982c != null && m1982c.length > 0) {
                m2034v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", C0225a.c.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> m1983d = m1983d(view);
                for (int i = 0; m1982c != null && i < m1982c.length; i++) {
                    int m1975a = m1975a(m1982c[i], m1983d);
                    m1983d.put(m1975a, new WeakReference<>(m1982c[i]));
                    m1980a(m1982c[i], (Spanned) charSequence, m1975a);
                }
            }
        }
    }

    /* renamed from: d */
    private SparseArray<WeakReference<ClickableSpan>> m1983d(View view) {
        SparseArray<WeakReference<ClickableSpan>> m1984e = m1984e(view);
        if (m1984e == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(C0225a.c.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return m1984e;
    }

    /* renamed from: e */
    private SparseArray<WeakReference<ClickableSpan>> m1984e(View view) {
        return (SparseArray) view.getTag(C0225a.c.tag_accessibility_clickable_spans);
    }

    /* renamed from: c */
    public static ClickableSpan[] m1982c(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: a */
    private int m1975a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                if (!clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    i = i2 + 1;
                } else {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = f2074d;
        f2074d = i3 + 1;
        return i3;
    }

    /* renamed from: w */
    private boolean m1986w() {
        return !m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    /* renamed from: x */
    private void m1987x() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2076b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f2076b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f2076b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f2076b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    /* renamed from: a */
    private void m1980a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        m1978a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    private void m1985f(View view) {
        SparseArray<WeakReference<ClickableSpan>> m1984e = m1984e(view);
        if (m1984e != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < m1984e.size(); i++) {
                if (m1984e.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                m1984e.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    /* renamed from: r */
    public CharSequence m2030r() {
        return this.f2076b.getContentDescription();
    }

    /* renamed from: d */
    public void m2007d(CharSequence charSequence) {
        this.f2076b.setContentDescription(charSequence);
    }

    /* renamed from: e */
    public void m2010e(CharSequence charSequence) {
        if (C0244a.m1789a()) {
            this.f2076b.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2076b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    /* renamed from: s */
    public void m2031s() {
        this.f2076b.recycle();
    }

    /* renamed from: t */
    public String m2032t() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f2076b.getViewIdResourceName();
        }
        return null;
    }

    /* renamed from: u */
    public List<a> m2033u() {
        List<AccessibilityNodeInfo.AccessibilityAction> list;
        if (Build.VERSION.SDK_INT < 21) {
            list = null;
        } else {
            list = this.f2076b.getActionList();
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new a(list.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* renamed from: v */
    public Bundle m2034v() {
        return Build.VERSION.SDK_INT >= 19 ? this.f2076b.getExtras() : new Bundle();
    }

    /* renamed from: f */
    public void m2013f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2076b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f2076b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    /* renamed from: h */
    public void m2018h(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2076b.setScreenReaderFocusable(z);
        } else {
            m1979a(1, z);
        }
    }

    /* renamed from: i */
    public void m2020i(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2076b.setHeading(z);
        } else {
            m1979a(2, z);
        }
    }

    public int hashCode() {
        if (this.f2076b == null) {
            return 0;
        }
        return this.f2076b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof C0273b)) {
            C0273b c0273b = (C0273b) obj;
            if (this.f2076b == null) {
                if (c0273b.f2076b != null) {
                    return false;
                }
            } else if (!this.f2076b.equals(c0273b.f2076b)) {
                return false;
            }
            return this.f2077c == c0273b.f2077c && this.f2075a == c0273b.f2075a;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m1990a(rect);
        sb.append("; boundsInParent: " + rect);
        m1998b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(m2027o());
        sb.append("; className: ").append(m2028p());
        sb.append("; text: ").append(m2029q());
        sb.append("; contentDescription: ").append(m2030r());
        sb.append("; viewId: ").append(m2032t());
        sb.append("; checkable: ").append(m2006c());
        sb.append("; checked: ").append(m2009d());
        sb.append("; focusable: ").append(m2012e());
        sb.append("; focused: ").append(m2015f());
        sb.append("; selected: ").append(m2021i());
        sb.append("; clickable: ").append(m2022j());
        sb.append("; longClickable: ").append(m2023k());
        sb.append("; enabled: ").append(m2024l());
        sb.append("; password: ").append(m2025m());
        sb.append("; scrollable: " + m2026n());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> m2033u = m2033u();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= m2033u.size()) {
                    break;
                }
                a aVar = m2033u.get(i2);
                String m1981b = m1981b(aVar.m2035a());
                sb.append((!m1981b.equals("ACTION_UNKNOWN") || aVar.m2038b() == null) ? m1981b : aVar.m2038b().toString());
                if (i2 != m2033u.size() - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            }
        } else {
            int m1997b = m1997b();
            while (m1997b != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(m1997b);
                m1997b &= numberOfTrailingZeros ^ (-1);
                sb.append(m1981b(numberOfTrailingZeros));
                if (m1997b != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    private void m1979a(int i, boolean z) {
        Bundle m2034v = m2034v();
        if (m2034v != null) {
            int i2 = m2034v.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (i ^ (-1));
            if (!z) {
                i = 0;
            }
            m2034v.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i);
        }
    }

    /* renamed from: b */
    private static String m1981b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case C0012R.id.accessibilityActionShowOnScreen /* 16908342 */:
                return "ACTION_SHOW_ON_SCREEN";
            case C0012R.id.accessibilityActionScrollToPosition /* 16908343 */:
                return "ACTION_SCROLL_TO_POSITION";
            case C0012R.id.accessibilityActionScrollUp /* 16908344 */:
                return "ACTION_SCROLL_UP";
            case C0012R.id.accessibilityActionScrollLeft /* 16908345 */:
                return "ACTION_SCROLL_LEFT";
            case C0012R.id.accessibilityActionScrollDown /* 16908346 */:
                return "ACTION_SCROLL_DOWN";
            case C0012R.id.accessibilityActionScrollRight /* 16908347 */:
                return "ACTION_SCROLL_RIGHT";
            case C0012R.id.accessibilityActionContextClick /* 16908348 */:
                return "ACTION_CONTEXT_CLICK";
            case C0012R.id.accessibilityActionSetProgress /* 16908349 */:
                return "ACTION_SET_PROGRESS";
            case C0012R.id.accessibilityActionMoveWindow /* 16908354 */:
                return "ACTION_MOVE_WINDOW";
            case C0012R.id.accessibilityActionShowTooltip /* 16908356 */:
                return "ACTION_SHOW_TOOLTIP";
            case C0012R.id.accessibilityActionHideTooltip /* 16908357 */:
                return "ACTION_HIDE_TOOLTIP";
            case C0012R.id.accessibilityActionPageUp /* 16908358 */:
                return "ACTION_PAGE_UP";
            case C0012R.id.accessibilityActionPageDown /* 16908359 */:
                return "ACTION_PAGE_DOWN";
            case C0012R.id.accessibilityActionPageLeft /* 16908360 */:
                return "ACTION_PAGE_LEFT";
            case C0012R.id.accessibilityActionPageRight /* 16908361 */:
                return "ACTION_PAGE_RIGHT";
            case 16908362:
                return "ACTION_PRESS_AND_HOLD";
            case 16908372:
                return "ACTION_IME_ENTER";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
