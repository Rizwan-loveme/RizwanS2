package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.AbstractC0242m;
import androidx.core.p026b.C0245b;
import androidx.core.p030e.C0270e;
import androidx.core.p031f.C0308x;
import androidx.core.p031f.C0310z;
import androidx.core.p031f.ViewOnAttachStateChangeListenerC0305u;
import androidx.fragment.app.AbstractC0368ae;
import androidx.fragment.app.C0376g;
import androidx.p011a.C0036a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: androidx.fragment.app.c */
/* loaded from: classes.dex */
class C0372c extends AbstractC0368ae {
    C0372c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // androidx.fragment.app.AbstractC0368ae
    /* renamed from: a */
    void mo2703a(List<AbstractC0368ae.b> list, boolean z) {
        AbstractC0368ae.b bVar = null;
        AbstractC0368ae.b bVar2 = null;
        for (AbstractC0368ae.b bVar3 : list) {
            AbstractC0368ae.b.EnumC3326b m2725a = AbstractC0368ae.b.EnumC3326b.m2725a(bVar3.m2720e().f2617G);
            switch (bVar3.m2718c()) {
                case GONE:
                case INVISIBLE:
                case REMOVED:
                    if (m2725a == AbstractC0368ae.b.EnumC3326b.VISIBLE && bVar2 == null) {
                        bVar2 = bVar3;
                        break;
                    }
                    break;
                case VISIBLE:
                    if (m2725a != AbstractC0368ae.b.EnumC3326b.VISIBLE) {
                        bVar = bVar3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        Iterator<AbstractC0368ae.b> it = list.iterator();
        while (it.hasNext()) {
            final AbstractC0368ae.b next = it.next();
            C0245b c0245b = new C0245b();
            next.m2714a(c0245b);
            arrayList.add(new a(next, c0245b, z));
            C0245b c0245b2 = new C0245b();
            next.m2714a(c0245b2);
            arrayList2.add(new c(next, c0245b2, z, z ? next == bVar2 : next == bVar));
            next.m2716a(new Runnable() { // from class: androidx.fragment.app.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (arrayList3.contains(next)) {
                        arrayList3.remove(next);
                        C0372c.this.m2734a(next);
                    }
                }
            });
        }
        Map<AbstractC0368ae.b, Boolean> m2731a = m2731a(arrayList2, arrayList3, z, bVar2, bVar);
        m2732a(arrayList, arrayList3, m2731a.containsValue(true), m2731a);
        Iterator<AbstractC0368ae.b> it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            m2734a(it2.next());
        }
        arrayList3.clear();
    }

    /* renamed from: a */
    private void m2732a(List<a> list, List<AbstractC0368ae.b> list2, boolean z, Map<AbstractC0368ae.b, Boolean> map) {
        final ViewGroup a2 = m2700a();
        Context context = a2.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (final a aVar : list) {
            if (aVar.m2740c()) {
                aVar.m2741d();
            } else {
                C0376g.a m2737a = aVar.m2737a(context);
                if (m2737a == null) {
                    aVar.m2741d();
                } else {
                    final Animator animator = m2737a.f2713b;
                    if (animator == null) {
                        arrayList.add(aVar);
                    } else {
                        final AbstractC0368ae.b a3 = aVar.m2738a();
                        ComponentCallbacksC0374e m2720e = a3.m2720e();
                        if (Boolean.TRUE.equals(map.get(a3))) {
                            if (AbstractC0384o.m2976a(2)) {
                                Log.m188v("FragmentManager", "Ignoring Animator set on " + m2720e + " as this Fragment was involved in a Transition.");
                            }
                            aVar.m2741d();
                        } else {
                            final boolean z3 = a3.m2718c() == AbstractC0368ae.b.EnumC3326b.GONE;
                            if (z3) {
                                list2.remove(a3);
                            }
                            final View view = m2720e.f2617G;
                            a2.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.c.3
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    a2.endViewTransition(view);
                                    if (z3) {
                                        a3.m2718c().m2726b(view);
                                    }
                                    aVar.m2741d();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            aVar.m2739b().m1791a(new C0245b.a() { // from class: androidx.fragment.app.c.4
                                @Override // androidx.core.p026b.C0245b.a
                                /* renamed from: a */
                                public void mo1794a() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final a aVar2 = (a) it.next();
            AbstractC0368ae.b a4 = aVar2.m2738a();
            ComponentCallbacksC0374e m2720e2 = a4.m2720e();
            if (z) {
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "Ignoring Animation set on " + m2720e2 + " as Animations cannot run alongside Transitions.");
                }
                aVar2.m2741d();
            } else if (z2) {
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "Ignoring Animation set on " + m2720e2 + " as Animations cannot run alongside Animators.");
                }
                aVar2.m2741d();
            } else {
                final View view2 = m2720e2.f2617G;
                Animation animation = (Animation) C0270e.m1960a(((C0376g.a) C0270e.m1960a(aVar2.m2737a(context))).f2712a);
                if (a4.m2718c() != AbstractC0368ae.b.EnumC3326b.REMOVED) {
                    view2.startAnimation(animation);
                    aVar2.m2741d();
                } else {
                    a2.startViewTransition(view2);
                    C0376g.b bVar = new C0376g.b(animation, a2, view2);
                    bVar.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.c.5
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            a2.post(new Runnable() { // from class: androidx.fragment.app.c.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a2.endViewTransition(view2);
                                    aVar2.m2741d();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }
                    });
                    view2.startAnimation(bVar);
                }
                aVar2.m2739b().m1791a(new C0245b.a() { // from class: androidx.fragment.app.c.6
                    @Override // androidx.core.p026b.C0245b.a
                    /* renamed from: a */
                    public void mo1794a() {
                        view2.clearAnimation();
                        a2.endViewTransition(view2);
                        aVar2.m2741d();
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private Map<AbstractC0368ae.b, Boolean> m2731a(List<c> list, List<AbstractC0368ae.b> list2, final boolean z, final AbstractC0368ae.b bVar, final AbstractC0368ae.b bVar2) {
        Object mo2656a;
        Object obj;
        AbstractC0242m m2835an;
        AbstractC0242m abstractC0242m;
        View view;
        boolean z2;
        final View view2;
        String m3179a;
        HashMap hashMap = new HashMap();
        final AbstractC0364aa abstractC0364aa = null;
        for (c cVar : list) {
            if (!cVar.m2740c()) {
                AbstractC0364aa m2747i = cVar.m2747i();
                if (abstractC0364aa == null) {
                    abstractC0364aa = m2747i;
                } else if (m2747i != null && abstractC0364aa != m2747i) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + cVar.m2738a().m2720e() + " returned Transition " + cVar.m2743e() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (abstractC0364aa == null) {
            for (c cVar2 : list) {
                hashMap.put(cVar2.m2738a(), false);
                cVar2.m2741d();
            }
            return hashMap;
        }
        View view3 = new View(m2700a().getContext());
        Object obj2 = null;
        View view4 = null;
        boolean z3 = false;
        final Rect rect = new Rect();
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        C0036a c0036a = new C0036a();
        for (c cVar3 : list) {
            if (!cVar3.m2745g() || bVar == null || bVar2 == null) {
                obj = obj2;
            } else {
                obj = abstractC0364aa.mo2678c(abstractC0364aa.mo2673b(cVar3.m2746h()));
                ArrayList<String> m2832ak = bVar2.m2720e().m2832ak();
                ArrayList<String> m2832ak2 = bVar.m2720e().m2832ak();
                ArrayList<String> m2833al = bVar.m2720e().m2833al();
                for (int i = 0; i < m2833al.size(); i++) {
                    int indexOf = m2832ak.indexOf(m2833al.get(i));
                    if (indexOf != -1) {
                        m2832ak.set(indexOf, m2832ak2.get(i));
                    }
                }
                ArrayList<String> m2833al2 = bVar2.m2720e().m2833al();
                if (!z) {
                    AbstractC0242m m2835an2 = bVar.m2720e().m2835an();
                    m2835an = bVar2.m2720e().m2834am();
                    abstractC0242m = m2835an2;
                } else {
                    AbstractC0242m m2834am = bVar.m2720e().m2834am();
                    m2835an = bVar2.m2720e().m2835an();
                    abstractC0242m = m2834am;
                }
                int size = m2832ak.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c0036a.put(m2832ak.get(i2), m2833al2.get(i2));
                }
                C0036a<String, View> c0036a2 = new C0036a<>();
                m2736a(c0036a2, bVar.m2720e().f2617G);
                c0036a2.m208a((Collection<?>) m2832ak);
                if (abstractC0242m != null) {
                    abstractC0242m.m1781a(m2832ak, c0036a2);
                    for (int size2 = m2832ak.size() - 1; size2 >= 0; size2--) {
                        String str = m2832ak.get(size2);
                        View view5 = c0036a2.get(str);
                        if (view5 == null) {
                            c0036a.remove(str);
                        } else if (!str.equals(C0308x.m2265l(view5))) {
                            c0036a.put(C0308x.m2265l(view5), (String) c0036a.remove(str));
                        }
                    }
                } else {
                    c0036a.m208a((Collection<?>) c0036a2.keySet());
                }
                final C0036a<String, View> c0036a3 = new C0036a<>();
                m2736a(c0036a3, bVar2.m2720e().f2617G);
                c0036a3.m208a((Collection<?>) m2833al2);
                c0036a3.m208a(c0036a.values());
                if (m2835an != null) {
                    m2835an.m1781a(m2833al2, c0036a3);
                    for (int size3 = m2833al2.size() - 1; size3 >= 0; size3--) {
                        String str2 = m2833al2.get(size3);
                        View view6 = c0036a3.get(str2);
                        if (view6 == null) {
                            String m3179a2 = C0394y.m3179a((C0036a<String, String>) c0036a, str2);
                            if (m3179a2 != null) {
                                c0036a.remove(m3179a2);
                            }
                        } else if (!str2.equals(C0308x.m2265l(view6)) && (m3179a = C0394y.m3179a((C0036a<String, String>) c0036a, str2)) != null) {
                            c0036a.put(m3179a, C0308x.m2265l(view6));
                        }
                    }
                } else {
                    C0394y.m3183a((C0036a<String, String>) c0036a, c0036a3);
                }
                m2733a(c0036a2, c0036a.keySet());
                m2733a(c0036a3, c0036a.values());
                if (c0036a.isEmpty()) {
                    obj = null;
                    arrayList.clear();
                    arrayList2.clear();
                } else {
                    C0394y.m3189a(bVar2.m2720e(), bVar.m2720e(), z, c0036a2, true);
                    ViewOnAttachStateChangeListenerC0305u.m2209a(m2700a(), new Runnable() { // from class: androidx.fragment.app.c.7
                        @Override // java.lang.Runnable
                        public void run() {
                            C0394y.m3189a(bVar2.m2720e(), bVar.m2720e(), z, (C0036a<String, View>) c0036a3, false);
                        }
                    });
                    arrayList.addAll(c0036a2.values());
                    if (m2832ak.isEmpty()) {
                        view = view4;
                    } else {
                        View view7 = c0036a2.get(m2832ak.get(0));
                        abstractC0364aa.mo2665a(obj, view7);
                        view = view7;
                    }
                    arrayList2.addAll(c0036a3.values());
                    if (m2833al2.isEmpty() || (view2 = c0036a3.get(m2833al2.get(0))) == null) {
                        z2 = z3;
                    } else {
                        ViewOnAttachStateChangeListenerC0305u.m2209a(m2700a(), new Runnable() { // from class: androidx.fragment.app.c.8
                            @Override // java.lang.Runnable
                            public void run() {
                                abstractC0364aa.m2658a(view2, rect);
                            }
                        });
                        z2 = true;
                    }
                    abstractC0364aa.mo2666a(obj, view3, arrayList);
                    abstractC0364aa.mo2667a(obj, null, null, null, null, obj, arrayList2);
                    hashMap.put(bVar, true);
                    hashMap.put(bVar2, true);
                    z3 = z2;
                    view4 = view;
                }
            }
            obj2 = obj;
        }
        ArrayList arrayList3 = new ArrayList();
        Object obj3 = null;
        Object obj4 = null;
        for (c cVar4 : list) {
            if (cVar4.m2740c()) {
                hashMap.put(cVar4.m2738a(), false);
                cVar4.m2741d();
            } else {
                Object mo2673b = abstractC0364aa.mo2673b(cVar4.m2743e());
                AbstractC0368ae.b a2 = cVar4.m2738a();
                boolean z4 = obj2 != null && (a2 == bVar || a2 == bVar2);
                if (mo2673b == null) {
                    if (z4) {
                        mo2656a = obj4;
                    } else {
                        hashMap.put(a2, false);
                        cVar4.m2741d();
                        mo2656a = obj4;
                    }
                } else {
                    final ArrayList<View> arrayList4 = new ArrayList<>();
                    m2735a(arrayList4, a2.m2720e().f2617G);
                    if (z4) {
                        if (a2 == bVar) {
                            arrayList4.removeAll(arrayList);
                        } else {
                            arrayList4.removeAll(arrayList2);
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        abstractC0364aa.mo2675b(mo2673b, view3);
                    } else {
                        abstractC0364aa.mo2668a(mo2673b, arrayList4);
                        abstractC0364aa.mo2667a(mo2673b, mo2673b, arrayList4, null, null, null, null);
                        if (a2.m2718c() == AbstractC0368ae.b.EnumC3326b.GONE) {
                            list2.remove(a2);
                            ArrayList<View> arrayList5 = new ArrayList<>(arrayList4);
                            arrayList5.remove(a2.m2720e().f2617G);
                            abstractC0364aa.mo2676b(mo2673b, a2.m2720e().f2617G, arrayList5);
                            ViewOnAttachStateChangeListenerC0305u.m2209a(m2700a(), new Runnable() { // from class: androidx.fragment.app.c.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    C0394y.m3190a((ArrayList<View>) arrayList4, 4);
                                }
                            });
                        }
                    }
                    if (a2.m2718c() == AbstractC0368ae.b.EnumC3326b.VISIBLE) {
                        arrayList3.addAll(arrayList4);
                        if (z3) {
                            abstractC0364aa.mo2664a(mo2673b, rect);
                        }
                    } else {
                        abstractC0364aa.mo2665a(mo2673b, view4);
                    }
                    hashMap.put(a2, true);
                    if (cVar4.m2744f()) {
                        obj3 = abstractC0364aa.mo2656a(obj3, mo2673b, (Object) null);
                        mo2656a = obj4;
                    } else {
                        mo2656a = abstractC0364aa.mo2656a(obj4, mo2673b, (Object) null);
                    }
                }
                obj4 = mo2656a;
            }
        }
        Object mo2674b = abstractC0364aa.mo2674b(obj3, obj4, obj2);
        for (final c cVar5 : list) {
            if (!cVar5.m2740c()) {
                Object m2743e = cVar5.m2743e();
                AbstractC0368ae.b a3 = cVar5.m2738a();
                boolean z5 = obj2 != null && (a3 == bVar || a3 == bVar2);
                if (m2743e != null || z5) {
                    if (!C0308x.m2275v(m2700a())) {
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: Container " + m2700a() + " has not been laid out. Completing operation " + a3);
                        }
                        cVar5.m2741d();
                    } else {
                        abstractC0364aa.mo2663a(cVar5.m2738a().m2720e(), mo2674b, cVar5.m2739b(), new Runnable() { // from class: androidx.fragment.app.c.10
                            @Override // java.lang.Runnable
                            public void run() {
                                cVar5.m2741d();
                            }
                        });
                    }
                }
            }
        }
        if (!C0308x.m2275v(m2700a())) {
            return hashMap;
        }
        C0394y.m3190a((ArrayList<View>) arrayList3, 4);
        ArrayList<String> m2657a = abstractC0364aa.m2657a(arrayList2);
        abstractC0364aa.mo2661a(m2700a(), mo2674b);
        abstractC0364aa.m2659a(m2700a(), arrayList, arrayList2, m2657a, c0036a);
        C0394y.m3190a((ArrayList<View>) arrayList3, 0);
        abstractC0364aa.mo2669a(obj2, arrayList, arrayList2);
        return hashMap;
    }

    /* renamed from: a */
    void m2733a(C0036a<String, View> c0036a, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = c0036a.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(C0308x.m2265l(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    void m2735a(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (C0310z.m2306a(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add(viewGroup);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    m2735a(arrayList, childAt);
                }
            }
            return;
        }
        if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* renamed from: a */
    void m2736a(Map<String, View> map, View view) {
        String m2265l = C0308x.m2265l(view);
        if (m2265l != null) {
            map.put(m2265l, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    m2736a(map, childAt);
                }
            }
        }
    }

    /* renamed from: a */
    void m2734a(AbstractC0368ae.b bVar) {
        bVar.m2718c().m2726b(bVar.m2720e().f2617G);
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.c$b */
    private static class b {

        /* renamed from: a */
        private final AbstractC0368ae.b f2583a;

        /* renamed from: b */
        private final C0245b f2584b;

        b(AbstractC0368ae.b bVar, C0245b c0245b) {
            this.f2583a = bVar;
            this.f2584b = c0245b;
        }

        /* renamed from: a */
        AbstractC0368ae.b m2738a() {
            return this.f2583a;
        }

        /* renamed from: b */
        C0245b m2739b() {
            return this.f2584b;
        }

        /* renamed from: c */
        boolean m2740c() {
            AbstractC0368ae.b.EnumC3326b m2725a = AbstractC0368ae.b.EnumC3326b.m2725a(this.f2583a.m2720e().f2617G);
            AbstractC0368ae.b.EnumC3326b m2718c = this.f2583a.m2718c();
            return m2725a == m2718c || !(m2725a == AbstractC0368ae.b.EnumC3326b.VISIBLE || m2718c == AbstractC0368ae.b.EnumC3326b.VISIBLE);
        }

        /* renamed from: d */
        void m2741d() {
            this.f2583a.m2717b(this.f2584b);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.c$a */
    private static class a extends b {

        /* renamed from: a */
        private boolean f2580a;

        /* renamed from: b */
        private boolean f2581b;

        /* renamed from: c */
        private C0376g.a f2582c;

        a(AbstractC0368ae.b bVar, C0245b c0245b, boolean z) {
            super(bVar, c0245b);
            this.f2581b = false;
            this.f2580a = z;
        }

        /* renamed from: a */
        C0376g.a m2737a(Context context) {
            if (this.f2581b) {
                return this.f2582c;
            }
            this.f2582c = C0376g.m2910a(context, m2738a().m2720e(), m2738a().m2718c() == AbstractC0368ae.b.EnumC3326b.VISIBLE, this.f2580a);
            this.f2581b = true;
            return this.f2582c;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.c$c */
    private static class c extends b {

        /* renamed from: a */
        private final Object f2585a;

        /* renamed from: b */
        private final boolean f2586b;

        /* renamed from: c */
        private final Object f2587c;

        c(AbstractC0368ae.b bVar, C0245b c0245b, boolean z, boolean z2) {
            super(bVar, c0245b);
            Object m2785L;
            Object m2783J;
            boolean m2789P;
            if (bVar.m2718c() == AbstractC0368ae.b.EnumC3326b.VISIBLE) {
                if (z) {
                    m2783J = bVar.m2720e().m2786M();
                } else {
                    m2783J = bVar.m2720e().m2783J();
                }
                this.f2585a = m2783J;
                if (z) {
                    m2789P = bVar.m2720e().m2790Q();
                } else {
                    m2789P = bVar.m2720e().m2789P();
                }
                this.f2586b = m2789P;
            } else {
                if (z) {
                    m2785L = bVar.m2720e().m2784K();
                } else {
                    m2785L = bVar.m2720e().m2785L();
                }
                this.f2585a = m2785L;
                this.f2586b = true;
            }
            if (z2) {
                if (z) {
                    this.f2587c = bVar.m2720e().m2788O();
                    return;
                } else {
                    this.f2587c = bVar.m2720e().m2787N();
                    return;
                }
            }
            this.f2587c = null;
        }

        /* renamed from: e */
        Object m2743e() {
            return this.f2585a;
        }

        /* renamed from: f */
        boolean m2744f() {
            return this.f2586b;
        }

        /* renamed from: g */
        public boolean m2745g() {
            return this.f2587c != null;
        }

        /* renamed from: h */
        public Object m2746h() {
            return this.f2587c;
        }

        /* renamed from: i */
        AbstractC0364aa m2747i() {
            AbstractC0364aa m2742a = m2742a(this.f2585a);
            AbstractC0364aa m2742a2 = m2742a(this.f2587c);
            if (m2742a == null || m2742a2 == null || m2742a == m2742a2) {
                return m2742a != null ? m2742a : m2742a2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + m2738a().m2720e() + " returned Transition " + this.f2585a + " which uses a different Transition  type than its shared element transition " + this.f2587c);
        }

        /* renamed from: a */
        private AbstractC0364aa m2742a(Object obj) {
            if (obj == null) {
                return null;
            }
            if (C0394y.f2869a != null && C0394y.f2869a.mo2672a(obj)) {
                return C0394y.f2869a;
            }
            if (C0394y.f2870b != null && C0394y.f2870b.mo2672a(obj)) {
                return C0394y.f2870b;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + m2738a().m2720e() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
