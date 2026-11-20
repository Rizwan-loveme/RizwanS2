package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p026b.C0245b;
import androidx.core.p031f.C0308x;
import androidx.fragment.C0362a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: SpecialEffectsController.java */
/* renamed from: androidx.fragment.app.ae */
/* loaded from: classes.dex */
abstract class AbstractC0368ae {

    /* renamed from: a */
    final ArrayList<b> f2503a = new ArrayList<>();

    /* renamed from: b */
    final ArrayList<b> f2504b = new ArrayList<>();

    /* renamed from: c */
    boolean f2505c = false;

    /* renamed from: d */
    boolean f2506d = false;

    /* renamed from: e */
    private final ViewGroup f2507e;

    /* renamed from: a */
    abstract void mo2703a(List<b> list, boolean z);

    /* renamed from: a */
    static AbstractC0368ae m2696a(ViewGroup viewGroup, AbstractC0384o abstractC0384o) {
        return m2695a(viewGroup, abstractC0384o.m2998D());
    }

    /* renamed from: a */
    static AbstractC0368ae m2695a(ViewGroup viewGroup, InterfaceC0369af interfaceC0369af) {
        Object tag = viewGroup.getTag(C0362a.b.special_effects_controller_view_tag);
        if (tag instanceof AbstractC0368ae) {
            return (AbstractC0368ae) tag;
        }
        AbstractC0368ae mo2727a = interfaceC0369af.mo2727a(viewGroup);
        viewGroup.setTag(C0362a.b.special_effects_controller_view_tag, mo2727a);
        return mo2727a;
    }

    AbstractC0368ae(ViewGroup viewGroup) {
        this.f2507e = viewGroup;
    }

    /* renamed from: a */
    public ViewGroup m2700a() {
        return this.f2507e;
    }

    /* renamed from: a */
    b.a m2701a(C0391v c0391v) {
        b.a aVar = null;
        b m2694a = m2694a(c0391v.m3118a());
        if (m2694a != null) {
            aVar = m2694a.m2719d();
        }
        b m2698b = m2698b(c0391v.m3118a());
        if (m2698b == null) {
            return aVar;
        }
        if (aVar == null || aVar == b.a.NONE) {
            return m2698b.m2719d();
        }
        return aVar;
    }

    /* renamed from: a */
    private b m2694a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        Iterator<b> it = this.f2503a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.m2720e().equals(componentCallbacksC0374e) && !next.m2721f()) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    private b m2698b(ComponentCallbacksC0374e componentCallbacksC0374e) {
        Iterator<b> it = this.f2504b.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.m2720e().equals(componentCallbacksC0374e) && !next.m2721f()) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    void m2702a(b.EnumC3326b enumC3326b, C0391v c0391v) {
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + c0391v.m3118a());
        }
        m2697a(enumC3326b, b.a.ADDING, c0391v);
    }

    /* renamed from: b */
    void m2706b(C0391v c0391v) {
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + c0391v.m3118a());
        }
        m2697a(b.EnumC3326b.VISIBLE, b.a.NONE, c0391v);
    }

    /* renamed from: c */
    void m2708c(C0391v c0391v) {
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + c0391v.m3118a());
        }
        m2697a(b.EnumC3326b.GONE, b.a.NONE, c0391v);
    }

    /* renamed from: d */
    void m2710d(C0391v c0391v) {
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + c0391v.m3118a());
        }
        m2697a(b.EnumC3326b.REMOVED, b.a.REMOVING, c0391v);
    }

    /* renamed from: a */
    private void m2697a(b.EnumC3326b enumC3326b, b.a aVar, C0391v c0391v) {
        synchronized (this.f2503a) {
            C0245b c0245b = new C0245b();
            b m2694a = m2694a(c0391v.m3118a());
            if (m2694a != null) {
                m2694a.m2715a(enumC3326b, aVar);
                return;
            }
            final a aVar2 = new a(enumC3326b, aVar, c0391v, c0245b);
            this.f2503a.add(aVar2);
            aVar2.m2716a(new Runnable() { // from class: androidx.fragment.app.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AbstractC0368ae.this.f2503a.contains(aVar2)) {
                        aVar2.m2718c().m2726b(aVar2.m2720e().f2617G);
                    }
                }
            });
            aVar2.m2716a(new Runnable() { // from class: androidx.fragment.app.ae.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC0368ae.this.f2503a.remove(aVar2);
                    AbstractC0368ae.this.f2504b.remove(aVar2);
                }
            });
        }
    }

    /* renamed from: a */
    void m2704a(boolean z) {
        this.f2505c = z;
    }

    /* renamed from: b */
    void m2705b() {
        synchronized (this.f2503a) {
            m2699f();
            this.f2506d = false;
            int size = this.f2503a.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                b bVar = this.f2503a.get(size);
                b.EnumC3326b m2725a = b.EnumC3326b.m2725a(bVar.m2720e().f2617G);
                if (bVar.m2718c() != b.EnumC3326b.VISIBLE || m2725a == b.EnumC3326b.VISIBLE) {
                    size--;
                } else {
                    this.f2506d = bVar.m2720e().m2840as();
                    break;
                }
            }
        }
    }

    /* renamed from: c */
    void m2707c() {
        if (this.f2506d) {
            this.f2506d = false;
            m2709d();
        }
    }

    /* renamed from: d */
    void m2709d() {
        if (!this.f2506d) {
            if (!C0308x.m2276w(this.f2507e)) {
                m2711e();
                this.f2505c = false;
                return;
            }
            synchronized (this.f2503a) {
                if (!this.f2503a.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2504b);
                    this.f2504b.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: Cancelling operation " + bVar);
                        }
                        bVar.m2722g();
                        if (!bVar.m2723h()) {
                            this.f2504b.add(bVar);
                        }
                    }
                    m2699f();
                    ArrayList arrayList2 = new ArrayList(this.f2503a);
                    this.f2503a.clear();
                    this.f2504b.addAll(arrayList2);
                    Iterator<b> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().mo2712a();
                    }
                    mo2703a(arrayList2, this.f2505c);
                    this.f2505c = false;
                }
            }
        }
    }

    /* renamed from: e */
    void m2711e() {
        boolean m2276w = C0308x.m2276w(this.f2507e);
        synchronized (this.f2503a) {
            m2699f();
            Iterator<b> it = this.f2503a.iterator();
            while (it.hasNext()) {
                it.next().mo2712a();
            }
            Iterator it2 = new ArrayList(this.f2504b).iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "SpecialEffectsController: " + (m2276w ? "" : "Container " + this.f2507e + " is not attached to window. ") + "Cancelling running operation " + bVar);
                }
                bVar.m2722g();
            }
            Iterator it3 = new ArrayList(this.f2503a).iterator();
            while (it3.hasNext()) {
                b bVar2 = (b) it3.next();
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "SpecialEffectsController: " + (m2276w ? "" : "Container " + this.f2507e + " is not attached to window. ") + "Cancelling pending operation " + bVar2);
                }
                bVar2.m2722g();
            }
        }
    }

    /* renamed from: f */
    private void m2699f() {
        Iterator<b> it = this.f2503a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.m2719d() == b.a.ADDING) {
                next.m2715a(b.EnumC3326b.m2724a(next.m2720e().m2777D().getVisibility()), b.a.NONE);
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.ae$b */
    static class b {

        /* renamed from: a */
        private EnumC3326b f2515a;

        /* renamed from: b */
        private a f2516b;

        /* renamed from: c */
        private final ComponentCallbacksC0374e f2517c;

        /* renamed from: d */
        private final List<Runnable> f2518d = new ArrayList();

        /* renamed from: e */
        private final HashSet<C0245b> f2519e = new HashSet<>();

        /* renamed from: f */
        private boolean f2520f = false;

        /* renamed from: g */
        private boolean f2521g = false;

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: androidx.fragment.app.ae$b$a */
        enum a {
            NONE,
            ADDING,
            REMOVING
        }

        /* compiled from: SpecialEffectsController.java */
        /* renamed from: androidx.fragment.app.ae$b$b, reason: collision with other inner class name */
        enum EnumC3326b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* renamed from: a */
            static EnumC3326b m2725a(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : m2724a(view.getVisibility());
            }

            /* renamed from: a */
            static EnumC3326b m2724a(int i) {
                switch (i) {
                    case 0:
                        return VISIBLE;
                    case 4:
                        return INVISIBLE;
                    case 8:
                        return GONE;
                    default:
                        throw new IllegalArgumentException("Unknown visibility " + i);
                }
            }

            /* renamed from: b */
            void m2726b(View view) {
                switch (this) {
                    case REMOVED:
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        if (viewGroup != null) {
                            if (AbstractC0384o.m2976a(2)) {
                                Log.m188v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                            }
                            viewGroup.removeView(view);
                            break;
                        }
                        break;
                    case VISIBLE:
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                        }
                        view.setVisibility(0);
                        break;
                    case GONE:
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        view.setVisibility(8);
                        break;
                    case INVISIBLE:
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                        }
                        view.setVisibility(4);
                        break;
                }
            }
        }

        b(EnumC3326b enumC3326b, a aVar, ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b) {
            this.f2515a = enumC3326b;
            this.f2516b = aVar;
            this.f2517c = componentCallbacksC0374e;
            c0245b.m1791a(new C0245b.a() { // from class: androidx.fragment.app.ae.b.1
                @Override // androidx.core.p026b.C0245b.a
                /* renamed from: a */
                public void mo1794a() {
                    b.this.m2722g();
                }
            });
        }

        /* renamed from: c */
        public EnumC3326b m2718c() {
            return this.f2515a;
        }

        /* renamed from: d */
        a m2719d() {
            return this.f2516b;
        }

        /* renamed from: e */
        public final ComponentCallbacksC0374e m2720e() {
            return this.f2517c;
        }

        /* renamed from: f */
        final boolean m2721f() {
            return this.f2520f;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2515a + "} {mLifecycleImpact = " + this.f2516b + "} {mFragment = " + this.f2517c + "}";
        }

        /* renamed from: g */
        final void m2722g() {
            if (!m2721f()) {
                this.f2520f = true;
                if (this.f2519e.isEmpty()) {
                    mo2713b();
                    return;
                }
                Iterator it = new ArrayList(this.f2519e).iterator();
                while (it.hasNext()) {
                    ((C0245b) it.next()).m1793b();
                }
            }
        }

        /* renamed from: a */
        final void m2715a(EnumC3326b enumC3326b, a aVar) {
            switch (aVar) {
                case ADDING:
                    if (this.f2515a == EnumC3326b.REMOVED) {
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2517c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2516b + " to ADDING.");
                        }
                        this.f2515a = EnumC3326b.VISIBLE;
                        this.f2516b = a.ADDING;
                        break;
                    }
                    break;
                case REMOVING:
                    if (AbstractC0384o.m2976a(2)) {
                        Log.m188v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2517c + " mFinalState = " + this.f2515a + " -> REMOVED. mLifecycleImpact  = " + this.f2516b + " to REMOVING.");
                    }
                    this.f2515a = EnumC3326b.REMOVED;
                    this.f2516b = a.REMOVING;
                    break;
                case NONE:
                    if (this.f2515a != EnumC3326b.REMOVED) {
                        if (AbstractC0384o.m2976a(2)) {
                            Log.m188v("FragmentManager", "SpecialEffectsController: For fragment " + this.f2517c + " mFinalState = " + this.f2515a + " -> " + enumC3326b + ". ");
                        }
                        this.f2515a = enumC3326b;
                        break;
                    }
                    break;
            }
        }

        /* renamed from: a */
        final void m2716a(Runnable runnable) {
            this.f2518d.add(runnable);
        }

        /* renamed from: a */
        void mo2712a() {
        }

        /* renamed from: a */
        public final void m2714a(C0245b c0245b) {
            mo2712a();
            this.f2519e.add(c0245b);
        }

        /* renamed from: b */
        public final void m2717b(C0245b c0245b) {
            if (this.f2519e.remove(c0245b) && this.f2519e.isEmpty()) {
                mo2713b();
            }
        }

        /* renamed from: h */
        final boolean m2723h() {
            return this.f2521g;
        }

        /* renamed from: b */
        public void mo2713b() {
            if (!this.f2521g) {
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
                }
                this.f2521g = true;
                Iterator<Runnable> it = this.f2518d.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
            }
        }
    }

    /* compiled from: SpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.ae$a */
    private static class a extends b {

        /* renamed from: a */
        private final C0391v f2514a;

        a(b.EnumC3326b enumC3326b, b.a aVar, C0391v c0391v, C0245b c0245b) {
            super(enumC3326b, aVar, c0391v.m3118a(), c0245b);
            this.f2514a = c0391v;
        }

        @Override // androidx.fragment.app.AbstractC0368ae.b
        /* renamed from: a */
        void mo2712a() {
            if (m2719d() == b.a.ADDING) {
                ComponentCallbacksC0374e m3118a = this.f2514a.m3118a();
                View findFocus = m3118a.f2617G.findFocus();
                if (findFocus != null) {
                    m3118a.m2845b(findFocus);
                    if (AbstractC0384o.m2976a(2)) {
                        Log.m188v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + m3118a);
                    }
                }
                View m2777D = m2720e().m2777D();
                if (m2777D.getParent() == null) {
                    this.f2514a.m3137r();
                    m2777D.setAlpha(0.0f);
                }
                if (m2777D.getAlpha() == 0.0f && m2777D.getVisibility() == 0) {
                    m2777D.setVisibility(4);
                }
                m2777D.setAlpha(m3118a.m2838aq());
            }
        }

        @Override // androidx.fragment.app.AbstractC0368ae.b
        /* renamed from: b */
        public void mo2713b() {
            super.mo2713b();
            this.f2514a.m3122c();
        }
    }
}
