package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.AbstractC0242m;
import androidx.core.p026b.C0245b;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.ViewOnAttachStateChangeListenerC0305u;
import androidx.fragment.app.AbstractC0393x;
import androidx.p011a.C0036a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition.java */
/* renamed from: androidx.fragment.app.y */
/* loaded from: classes.dex */
class C0394y {

    /* renamed from: a */
    static final AbstractC0364aa f2869a;

    /* renamed from: b */
    static final AbstractC0364aa f2870b;

    /* renamed from: c */
    private static final int[] f2871c = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* compiled from: FragmentTransition.java */
    /* renamed from: androidx.fragment.app.y$a */
    interface a {
        /* renamed from: a */
        void mo3077a(ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b);

        /* renamed from: b */
        void mo3078b(ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b);
    }

    static {
        C0395z c0395z;
        if (Build.VERSION.SDK_INT >= 21) {
            c0395z = new C0395z();
        } else {
            c0395z = null;
        }
        f2869a = c0395z;
        f2870b = m3172a();
    }

    /* renamed from: a */
    private static AbstractC0364aa m3172a() {
        try {
            return (AbstractC0364aa) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            return null;
        }
    }

    /* renamed from: a */
    static void m3181a(Context context, AbstractC0377h abstractC0377h, ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z, a aVar) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            C0363a c0363a = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                m3197b(c0363a, (SparseArray<b>) sparseArray, z);
            } else {
                m3184a(c0363a, (SparseArray<b>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                C0036a<String, String> m3170a = m3170a(keyAt, arrayList, arrayList2, i, i2);
                b bVar = (b) sparseArray.valueAt(i4);
                if (abstractC0377h.mo2768a() && (viewGroup = (ViewGroup) abstractC0377h.mo2767a(keyAt)) != null) {
                    if (z) {
                        m3182a(viewGroup, bVar, view, m3170a, aVar);
                    } else {
                        m3196b(viewGroup, bVar, view, m3170a, aVar);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C0036a<String, String> m3170a(int i, ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        C0036a<String, String> c0036a = new C0036a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0363a c0363a = arrayList.get(i4);
            if (c0363a.m2646b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (c0363a.f2857q != null) {
                    int size = c0363a.f2857q.size();
                    if (booleanValue) {
                        arrayList3 = c0363a.f2857q;
                        arrayList4 = c0363a.f2858r;
                    } else {
                        ArrayList<String> arrayList5 = c0363a.f2857q;
                        arrayList3 = c0363a.f2858r;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = c0036a.remove(str2);
                        if (remove != null) {
                            c0036a.put(str, remove);
                        } else {
                            c0036a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c0036a;
    }

    /* renamed from: a */
    private static void m3182a(ViewGroup viewGroup, b bVar, View view, C0036a<String, String> c0036a, final a aVar) {
        ComponentCallbacksC0374e componentCallbacksC0374e = bVar.f2906a;
        final ComponentCallbacksC0374e componentCallbacksC0374e2 = bVar.f2909d;
        AbstractC0364aa m3173a = m3173a(componentCallbacksC0374e2, componentCallbacksC0374e);
        if (m3173a != null) {
            boolean z = bVar.f2907b;
            boolean z2 = bVar.f2910e;
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object m3177a = m3177a(m3173a, componentCallbacksC0374e, z);
            Object m3195b = m3195b(m3173a, componentCallbacksC0374e2, z2);
            Object m3175a = m3175a(m3173a, viewGroup, view, c0036a, bVar, arrayList2, arrayList, m3177a, m3195b);
            if (m3177a != null || m3175a != null || m3195b != null) {
                ArrayList<View> m3180a = m3180a(m3173a, m3195b, componentCallbacksC0374e2, arrayList2, view);
                ArrayList<View> m3180a2 = m3180a(m3173a, m3177a, componentCallbacksC0374e, arrayList, view);
                m3190a(m3180a2, 4);
                Object m3178a = m3178a(m3173a, m3177a, m3195b, m3175a, componentCallbacksC0374e, z);
                if (componentCallbacksC0374e2 != null && m3180a != null && (m3180a.size() > 0 || arrayList2.size() > 0)) {
                    final C0245b c0245b = new C0245b();
                    aVar.mo3077a(componentCallbacksC0374e2, c0245b);
                    m3173a.mo2663a(componentCallbacksC0374e2, m3178a, c0245b, new Runnable() { // from class: androidx.fragment.app.y.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.mo3078b(componentCallbacksC0374e2, c0245b);
                        }
                    });
                }
                if (m3178a != null) {
                    m3187a(m3173a, m3195b, componentCallbacksC0374e2, m3180a);
                    ArrayList<String> m2657a = m3173a.m2657a(arrayList);
                    m3173a.mo2667a(m3178a, m3177a, m3180a2, m3195b, m3180a, m3175a, arrayList);
                    m3173a.mo2661a(viewGroup, m3178a);
                    m3173a.m2659a(viewGroup, arrayList2, arrayList, m2657a, c0036a);
                    m3190a(m3180a2, 0);
                    m3173a.mo2669a(m3175a, arrayList2, arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3187a(AbstractC0364aa abstractC0364aa, Object obj, ComponentCallbacksC0374e componentCallbacksC0374e, final ArrayList<View> arrayList) {
        if (componentCallbacksC0374e != null && obj != null && componentCallbacksC0374e.f2648l && componentCallbacksC0374e.f2662z && componentCallbacksC0374e.f2623M) {
            componentCallbacksC0374e.m2868j(true);
            abstractC0364aa.mo2676b(obj, componentCallbacksC0374e.m2776C(), arrayList);
            ViewOnAttachStateChangeListenerC0305u.m2209a(componentCallbacksC0374e.f2616F, new Runnable() { // from class: androidx.fragment.app.y.2
                @Override // java.lang.Runnable
                public void run() {
                    C0394y.m3190a((ArrayList<View>) ArrayList.this, 4);
                }
            });
        }
    }

    /* renamed from: b */
    private static void m3196b(ViewGroup viewGroup, b bVar, View view, C0036a<String, String> c0036a, final a aVar) {
        ComponentCallbacksC0374e componentCallbacksC0374e = bVar.f2906a;
        final ComponentCallbacksC0374e componentCallbacksC0374e2 = bVar.f2909d;
        AbstractC0364aa m3173a = m3173a(componentCallbacksC0374e2, componentCallbacksC0374e);
        if (m3173a != null) {
            boolean z = bVar.f2907b;
            boolean z2 = bVar.f2910e;
            Object m3177a = m3177a(m3173a, componentCallbacksC0374e, z);
            Object m3195b = m3195b(m3173a, componentCallbacksC0374e2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList<View> arrayList2 = new ArrayList<>();
            Object m3194b = m3194b(m3173a, viewGroup, view, c0036a, bVar, arrayList, arrayList2, m3177a, m3195b);
            if (m3177a != null || m3194b != null || m3195b != null) {
                ArrayList<View> m3180a = m3180a(m3173a, m3195b, componentCallbacksC0374e2, (ArrayList<View>) arrayList, view);
                Object obj = (m3180a == null || m3180a.isEmpty()) ? null : m3195b;
                m3173a.mo2675b(m3177a, view);
                Object m3178a = m3178a(m3173a, m3177a, obj, m3194b, componentCallbacksC0374e, bVar.f2907b);
                if (componentCallbacksC0374e2 != null && m3180a != null && (m3180a.size() > 0 || arrayList.size() > 0)) {
                    final C0245b c0245b = new C0245b();
                    aVar.mo3077a(componentCallbacksC0374e2, c0245b);
                    m3173a.mo2663a(componentCallbacksC0374e2, m3178a, c0245b, new Runnable() { // from class: androidx.fragment.app.y.3
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.mo3078b(componentCallbacksC0374e2, c0245b);
                        }
                    });
                }
                if (m3178a != null) {
                    ArrayList<View> arrayList3 = new ArrayList<>();
                    m3173a.mo2667a(m3178a, m3177a, arrayList3, obj, m3180a, m3194b, arrayList2);
                    m3186a(m3173a, viewGroup, componentCallbacksC0374e, view, arrayList2, m3177a, arrayList3, obj, m3180a);
                    m3173a.m2660a((View) viewGroup, arrayList2, (Map<String, String>) c0036a);
                    m3173a.mo2661a(viewGroup, m3178a);
                    m3173a.m2662a(viewGroup, arrayList2, (Map<String, String>) c0036a);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3186a(final AbstractC0364aa abstractC0364aa, ViewGroup viewGroup, final ComponentCallbacksC0374e componentCallbacksC0374e, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        ViewOnAttachStateChangeListenerC0305u.m2209a(viewGroup, new Runnable() { // from class: androidx.fragment.app.y.4
            @Override // java.lang.Runnable
            public void run() {
                if (Object.this != null) {
                    abstractC0364aa.mo2679c(Object.this, view);
                    arrayList2.addAll(C0394y.m3180a(abstractC0364aa, Object.this, componentCallbacksC0374e, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        abstractC0364aa.mo2677b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    /* renamed from: a */
    private static AbstractC0364aa m3173a(ComponentCallbacksC0374e componentCallbacksC0374e, ComponentCallbacksC0374e componentCallbacksC0374e2) {
        ArrayList arrayList = new ArrayList();
        if (componentCallbacksC0374e != null) {
            Object m2785L = componentCallbacksC0374e.m2785L();
            if (m2785L != null) {
                arrayList.add(m2785L);
            }
            Object m2784K = componentCallbacksC0374e.m2784K();
            if (m2784K != null) {
                arrayList.add(m2784K);
            }
            Object m2788O = componentCallbacksC0374e.m2788O();
            if (m2788O != null) {
                arrayList.add(m2788O);
            }
        }
        if (componentCallbacksC0374e2 != null) {
            Object m2783J = componentCallbacksC0374e2.m2783J();
            if (m2783J != null) {
                arrayList.add(m2783J);
            }
            Object m2786M = componentCallbacksC0374e2.m2786M();
            if (m2786M != null) {
                arrayList.add(m2786M);
            }
            Object m2787N = componentCallbacksC0374e2.m2787N();
            if (m2787N != null) {
                arrayList.add(m2787N);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (f2869a != null && m3192a(f2869a, arrayList)) {
            return f2869a;
        }
        if (f2870b != null && m3192a(f2870b, arrayList)) {
            return f2870b;
        }
        if (f2869a == null && f2870b == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* renamed from: a */
    private static boolean m3192a(AbstractC0364aa abstractC0364aa, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!abstractC0364aa.mo2672a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Object m3176a(AbstractC0364aa abstractC0364aa, ComponentCallbacksC0374e componentCallbacksC0374e, ComponentCallbacksC0374e componentCallbacksC0374e2, boolean z) {
        Object m2787N;
        if (componentCallbacksC0374e == null || componentCallbacksC0374e2 == null) {
            return null;
        }
        if (z) {
            m2787N = componentCallbacksC0374e2.m2788O();
        } else {
            m2787N = componentCallbacksC0374e.m2787N();
        }
        return abstractC0364aa.mo2678c(abstractC0364aa.mo2673b(m2787N));
    }

    /* renamed from: a */
    private static Object m3177a(AbstractC0364aa abstractC0364aa, ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        Object m2783J;
        if (componentCallbacksC0374e == null) {
            return null;
        }
        if (z) {
            m2783J = componentCallbacksC0374e.m2786M();
        } else {
            m2783J = componentCallbacksC0374e.m2783J();
        }
        return abstractC0364aa.mo2673b(m2783J);
    }

    /* renamed from: b */
    private static Object m3195b(AbstractC0364aa abstractC0364aa, ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        Object m2785L;
        if (componentCallbacksC0374e == null) {
            return null;
        }
        if (z) {
            m2785L = componentCallbacksC0374e.m2784K();
        } else {
            m2785L = componentCallbacksC0374e.m2785L();
        }
        return abstractC0364aa.mo2673b(m2785L);
    }

    /* renamed from: a */
    private static Object m3175a(final AbstractC0364aa abstractC0364aa, ViewGroup viewGroup, View view, C0036a<String, String> c0036a, b bVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final View view2;
        final ComponentCallbacksC0374e componentCallbacksC0374e = bVar.f2906a;
        final ComponentCallbacksC0374e componentCallbacksC0374e2 = bVar.f2909d;
        if (componentCallbacksC0374e != null) {
            componentCallbacksC0374e.m2777D().setVisibility(0);
        }
        if (componentCallbacksC0374e == null || componentCallbacksC0374e2 == null) {
            return null;
        }
        final boolean z = bVar.f2907b;
        Object m3176a = c0036a.isEmpty() ? null : m3176a(abstractC0364aa, componentCallbacksC0374e, componentCallbacksC0374e2, z);
        C0036a<String, View> m3193b = m3193b(abstractC0364aa, c0036a, m3176a, bVar);
        final C0036a<String, View> m3171a = m3171a(abstractC0364aa, c0036a, m3176a, bVar);
        if (c0036a.isEmpty()) {
            obj3 = null;
            if (m3193b != null) {
                m3193b.clear();
            }
            if (m3171a != null) {
                m3171a.clear();
            }
        } else {
            m3191a(arrayList, m3193b, c0036a.keySet());
            m3191a(arrayList2, m3171a, c0036a.values());
            obj3 = m3176a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m3189a(componentCallbacksC0374e, componentCallbacksC0374e2, z, m3193b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            abstractC0364aa.mo2666a(obj3, view, arrayList);
            m3188a(abstractC0364aa, obj3, obj2, m3193b, bVar.f2910e, bVar.f2911f);
            rect = new Rect();
            view2 = m3169a(m3171a, bVar, obj, z);
            if (view2 != null) {
                abstractC0364aa.mo2664a(obj, rect);
            }
        } else {
            rect = null;
            view2 = null;
        }
        ViewOnAttachStateChangeListenerC0305u.m2209a(viewGroup, new Runnable() { // from class: androidx.fragment.app.y.5
            @Override // java.lang.Runnable
            public void run() {
                C0394y.m3189a(ComponentCallbacksC0374e.this, componentCallbacksC0374e2, z, (C0036a<String, View>) m3171a, false);
                if (view2 != null) {
                    abstractC0364aa.m2658a(view2, rect);
                }
            }
        });
        return obj3;
    }

    /* renamed from: a */
    private static void m3191a(ArrayList<View> arrayList, C0036a<String, View> c0036a, Collection<String> collection) {
        for (int size = c0036a.size() - 1; size >= 0; size--) {
            View c2 = c0036a.m272c(size);
            if (collection.contains(C0308x.m2265l(c2))) {
                arrayList.add(c2);
            }
        }
    }

    /* renamed from: b */
    private static Object m3194b(final AbstractC0364aa abstractC0364aa, ViewGroup viewGroup, final View view, final C0036a<String, String> c0036a, final b bVar, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object obj3;
        final Rect rect;
        final ComponentCallbacksC0374e componentCallbacksC0374e = bVar.f2906a;
        final ComponentCallbacksC0374e componentCallbacksC0374e2 = bVar.f2909d;
        if (componentCallbacksC0374e == null || componentCallbacksC0374e2 == null) {
            return null;
        }
        final boolean z = bVar.f2907b;
        Object m3176a = c0036a.isEmpty() ? null : m3176a(abstractC0364aa, componentCallbacksC0374e, componentCallbacksC0374e2, z);
        C0036a<String, View> m3193b = m3193b(abstractC0364aa, c0036a, m3176a, bVar);
        if (c0036a.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(m3193b.values());
            obj3 = m3176a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m3189a(componentCallbacksC0374e, componentCallbacksC0374e2, z, m3193b, true);
        if (obj3 != null) {
            rect = new Rect();
            abstractC0364aa.mo2666a(obj3, view, arrayList);
            m3188a(abstractC0364aa, obj3, obj2, m3193b, bVar.f2910e, bVar.f2911f);
            if (obj != null) {
                abstractC0364aa.mo2664a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        ViewOnAttachStateChangeListenerC0305u.m2209a(viewGroup, new Runnable() { // from class: androidx.fragment.app.y.6
            @Override // java.lang.Runnable
            public void run() {
                C0036a<String, View> m3171a = C0394y.m3171a(AbstractC0364aa.this, (C0036a<String, String>) c0036a, obj4, bVar);
                if (m3171a != null) {
                    arrayList2.addAll(m3171a.values());
                    arrayList2.add(view);
                }
                C0394y.m3189a(componentCallbacksC0374e, componentCallbacksC0374e2, z, m3171a, false);
                if (obj4 != null) {
                    AbstractC0364aa.this.mo2669a(obj4, arrayList, arrayList2);
                    View m3169a = C0394y.m3169a(m3171a, bVar, obj, z);
                    if (m3169a != null) {
                        AbstractC0364aa.this.m2658a(m3169a, rect);
                    }
                }
            }
        });
        return obj3;
    }

    /* renamed from: b */
    private static C0036a<String, View> m3193b(AbstractC0364aa abstractC0364aa, C0036a<String, String> c0036a, Object obj, b bVar) {
        AbstractC0242m m2835an;
        ArrayList<String> arrayList;
        if (c0036a.isEmpty() || obj == null) {
            c0036a.clear();
            return null;
        }
        ComponentCallbacksC0374e componentCallbacksC0374e = bVar.f2909d;
        C0036a<String, View> c0036a2 = new C0036a<>();
        abstractC0364aa.m2671a((Map<String, View>) c0036a2, componentCallbacksC0374e.m2777D());
        C0363a c0363a = bVar.f2911f;
        if (bVar.f2910e) {
            m2835an = componentCallbacksC0374e.m2834am();
            arrayList = c0363a.f2858r;
        } else {
            m2835an = componentCallbacksC0374e.m2835an();
            arrayList = c0363a.f2857q;
        }
        if (arrayList != null) {
            c0036a2.m208a((Collection<?>) arrayList);
        }
        if (m2835an != null) {
            m2835an.m1781a(arrayList, c0036a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = c0036a2.get(str);
                if (view == null) {
                    c0036a.remove(str);
                } else if (!str.equals(C0308x.m2265l(view))) {
                    c0036a.put(C0308x.m2265l(view), c0036a.remove(str));
                }
            }
        } else {
            c0036a.m208a((Collection<?>) c0036a2.keySet());
        }
        return c0036a2;
    }

    /* renamed from: a */
    static C0036a<String, View> m3171a(AbstractC0364aa abstractC0364aa, C0036a<String, String> c0036a, Object obj, b bVar) {
        AbstractC0242m m2834am;
        ArrayList<String> arrayList;
        String m3179a;
        ComponentCallbacksC0374e componentCallbacksC0374e = bVar.f2906a;
        View m2776C = componentCallbacksC0374e.m2776C();
        if (c0036a.isEmpty() || obj == null || m2776C == null) {
            c0036a.clear();
            return null;
        }
        C0036a<String, View> c0036a2 = new C0036a<>();
        abstractC0364aa.m2671a((Map<String, View>) c0036a2, m2776C);
        C0363a c0363a = bVar.f2908c;
        if (bVar.f2907b) {
            m2834am = componentCallbacksC0374e.m2835an();
            arrayList = c0363a.f2857q;
        } else {
            m2834am = componentCallbacksC0374e.m2834am();
            arrayList = c0363a.f2858r;
        }
        if (arrayList != null) {
            c0036a2.m208a((Collection<?>) arrayList);
            c0036a2.m208a((Collection<?>) c0036a.values());
        }
        if (m2834am != null) {
            m2834am.m1781a(arrayList, c0036a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = c0036a2.get(str);
                if (view == null) {
                    String m3179a2 = m3179a(c0036a, str);
                    if (m3179a2 != null) {
                        c0036a.remove(m3179a2);
                    }
                } else if (!str.equals(C0308x.m2265l(view)) && (m3179a = m3179a(c0036a, str)) != null) {
                    c0036a.put(m3179a, C0308x.m2265l(view));
                }
            }
        } else {
            m3183a(c0036a, c0036a2);
        }
        return c0036a2;
    }

    /* renamed from: a */
    static String m3179a(C0036a<String, String> c0036a, String str) {
        int size = c0036a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c0036a.m272c(i))) {
                return c0036a.m271b(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    static View m3169a(C0036a<String, View> c0036a, b bVar, Object obj, boolean z) {
        String str;
        C0363a c0363a = bVar.f2908c;
        if (obj != null && c0036a != null && c0363a.f2857q != null && !c0363a.f2857q.isEmpty()) {
            if (z) {
                str = c0363a.f2857q.get(0);
            } else {
                str = c0363a.f2858r.get(0);
            }
            return c0036a.get(str);
        }
        return null;
    }

    /* renamed from: a */
    private static void m3188a(AbstractC0364aa abstractC0364aa, Object obj, Object obj2, C0036a<String, View> c0036a, boolean z, C0363a c0363a) {
        String str;
        if (c0363a.f2857q != null && !c0363a.f2857q.isEmpty()) {
            if (z) {
                str = c0363a.f2858r.get(0);
            } else {
                str = c0363a.f2857q.get(0);
            }
            View view = c0036a.get(str);
            abstractC0364aa.mo2665a(obj, view);
            if (obj2 != null) {
                abstractC0364aa.mo2665a(obj2, view);
            }
        }
    }

    /* renamed from: a */
    static void m3183a(C0036a<String, String> c0036a, C0036a<String, View> c0036a2) {
        for (int size = c0036a.size() - 1; size >= 0; size--) {
            if (!c0036a2.containsKey(c0036a.m272c(size))) {
                c0036a.m273d(size);
            }
        }
    }

    /* renamed from: a */
    static void m3189a(ComponentCallbacksC0374e componentCallbacksC0374e, ComponentCallbacksC0374e componentCallbacksC0374e2, boolean z, C0036a<String, View> c0036a, boolean z2) {
        AbstractC0242m m2834am;
        if (z) {
            m2834am = componentCallbacksC0374e2.m2834am();
        } else {
            m2834am = componentCallbacksC0374e.m2834am();
        }
        if (m2834am != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = c0036a == null ? 0 : c0036a.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(c0036a.m271b(i));
                arrayList.add(c0036a.m272c(i));
            }
            if (z2) {
                m2834am.m1780a(arrayList2, arrayList, null);
            } else {
                m2834am.m1782b(arrayList2, arrayList, null);
            }
        }
    }

    /* renamed from: a */
    static ArrayList<View> m3180a(AbstractC0364aa abstractC0364aa, Object obj, ComponentCallbacksC0374e componentCallbacksC0374e, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList<>();
            View m2776C = componentCallbacksC0374e.m2776C();
            if (m2776C != null) {
                abstractC0364aa.m2670a(arrayList2, m2776C);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                abstractC0364aa.mo2668a(obj, arrayList2);
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    static void m3190a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static Object m3178a(AbstractC0364aa abstractC0364aa, Object obj, Object obj2, Object obj3, ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        boolean z2 = true;
        if (obj != null && obj2 != null && componentCallbacksC0374e != null) {
            z2 = z ? componentCallbacksC0374e.m2790Q() : componentCallbacksC0374e.m2789P();
        }
        if (z2) {
            return abstractC0364aa.mo2656a(obj2, obj, obj3);
        }
        return abstractC0364aa.mo2674b(obj2, obj, obj3);
    }

    /* renamed from: a */
    public static void m3184a(C0363a c0363a, SparseArray<b> sparseArray, boolean z) {
        int size = c0363a.f2844d.size();
        for (int i = 0; i < size; i++) {
            m3185a(c0363a, c0363a.f2844d.get(i), sparseArray, false, z);
        }
    }

    /* renamed from: b */
    public static void m3197b(C0363a c0363a, SparseArray<b> sparseArray, boolean z) {
        if (c0363a.f2468a.m3060m().mo2768a()) {
            for (int size = c0363a.f2844d.size() - 1; size >= 0; size--) {
                m3185a(c0363a, c0363a.f2844d.get(size), sparseArray, true, z);
            }
        }
    }

    /* renamed from: a */
    private static void m3185a(C0363a c0363a, AbstractC0393x.a aVar, SparseArray<b> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        ComponentCallbacksC0374e componentCallbacksC0374e = aVar.f2862b;
        if (componentCallbacksC0374e != null && (i = componentCallbacksC0374e.f2660x) != 0) {
            switch (z ? f2871c[aVar.f2861a] : aVar.f2861a) {
                case 1:
                case 7:
                    if (z2) {
                        z9 = componentCallbacksC0374e.f2622L;
                    } else {
                        z9 = (componentCallbacksC0374e.f2648l || componentCallbacksC0374e.f2662z) ? false : true;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z9;
                    break;
                case 2:
                default:
                    z4 = false;
                    z5 = false;
                    z6 = false;
                    z7 = false;
                    break;
                case 3:
                case 6:
                    if (z2) {
                        z3 = !componentCallbacksC0374e.f2648l && componentCallbacksC0374e.f2617G != null && componentCallbacksC0374e.f2617G.getVisibility() == 0 && componentCallbacksC0374e.f2624N >= 0.0f;
                    } else {
                        z3 = componentCallbacksC0374e.f2648l && !componentCallbacksC0374e.f2662z;
                    }
                    z4 = false;
                    z5 = z3;
                    z6 = true;
                    z7 = false;
                    break;
                case 4:
                    if (z2) {
                        z8 = componentCallbacksC0374e.f2623M && componentCallbacksC0374e.f2648l && componentCallbacksC0374e.f2662z;
                    } else {
                        z8 = componentCallbacksC0374e.f2648l && !componentCallbacksC0374e.f2662z;
                    }
                    z4 = false;
                    z5 = z8;
                    z6 = true;
                    z7 = false;
                    break;
                case 5:
                    if (z2) {
                        z10 = componentCallbacksC0374e.f2623M && !componentCallbacksC0374e.f2662z && componentCallbacksC0374e.f2648l;
                    } else {
                        z10 = componentCallbacksC0374e.f2662z;
                    }
                    z4 = true;
                    z5 = false;
                    z6 = false;
                    z7 = z10;
                    break;
            }
            b bVar = sparseArray.get(i);
            if (z7) {
                bVar = m3174a(bVar, sparseArray, i);
                bVar.f2906a = componentCallbacksC0374e;
                bVar.f2907b = z;
                bVar.f2908c = c0363a;
            }
            if (!z2 && z4) {
                if (bVar != null && bVar.f2909d == componentCallbacksC0374e) {
                    bVar.f2909d = null;
                }
                if (!c0363a.f2859s) {
                    AbstractC0384o abstractC0384o = c0363a.f2468a;
                    abstractC0384o.m3062n().m3143a(abstractC0384o.m3046f(componentCallbacksC0374e));
                    abstractC0384o.m3043d(componentCallbacksC0374e);
                }
            }
            if (z5 && (bVar == null || bVar.f2909d == null)) {
                bVar = m3174a(bVar, sparseArray, i);
                bVar.f2909d = componentCallbacksC0374e;
                bVar.f2910e = z;
                bVar.f2911f = c0363a;
            }
            if (!z2 && z6 && bVar != null && bVar.f2906a == componentCallbacksC0374e) {
                bVar.f2906a = null;
            }
        }
    }

    /* renamed from: a */
    private static b m3174a(b bVar, SparseArray<b> sparseArray, int i) {
        if (bVar == null) {
            b bVar2 = new b();
            sparseArray.put(i, bVar2);
            return bVar2;
        }
        return bVar;
    }

    /* compiled from: FragmentTransition.java */
    /* renamed from: androidx.fragment.app.y$b */
    static class b {

        /* renamed from: a */
        public ComponentCallbacksC0374e f2906a;

        /* renamed from: b */
        public boolean f2907b;

        /* renamed from: c */
        public C0363a f2908c;

        /* renamed from: d */
        public ComponentCallbacksC0374e f2909d;

        /* renamed from: e */
        public boolean f2910e;

        /* renamed from: f */
        public C0363a f2911f;

        b() {
        }
    }
}
