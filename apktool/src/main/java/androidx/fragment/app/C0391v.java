package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.p008os.Bundle;
import android.p008os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.p031f.C0308x;
import androidx.fragment.C0362a;
import androidx.fragment.app.AbstractC0368ae;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;

/* compiled from: FragmentStateManager.java */
/* renamed from: androidx.fragment.app.v */
/* loaded from: classes.dex */
class C0391v {

    /* renamed from: a */
    private final C0383n f2831a;

    /* renamed from: b */
    private final C0392w f2832b;

    /* renamed from: c */
    private final ComponentCallbacksC0374e f2833c;

    /* renamed from: d */
    private boolean f2834d = false;

    /* renamed from: e */
    private int f2835e = -1;

    C0391v(C0383n c0383n, C0392w c0392w, ComponentCallbacksC0374e componentCallbacksC0374e) {
        this.f2831a = c0383n;
        this.f2832b = c0392w;
        this.f2833c = componentCallbacksC0374e;
    }

    C0391v(C0383n c0383n, C0392w c0392w, ClassLoader classLoader, C0380k c0380k, C0390u c0390u) {
        this.f2831a = c0383n;
        this.f2832b = c0392w;
        this.f2833c = c0380k.mo2941c(classLoader, c0390u.f2818a);
        if (c0390u.f2827j != null) {
            c0390u.f2827j.setClassLoader(classLoader);
        }
        this.f2833c.m2860g(c0390u.f2827j);
        this.f2833c.f2643g = c0390u.f2819b;
        this.f2833c.f2650n = c0390u.f2820c;
        this.f2833c.f2652p = true;
        this.f2833c.f2659w = c0390u.f2821d;
        this.f2833c.f2660x = c0390u.f2822e;
        this.f2833c.f2661y = c0390u.f2823f;
        this.f2833c.f2612B = c0390u.f2824g;
        this.f2833c.f2649m = c0390u.f2825h;
        this.f2833c.f2611A = c0390u.f2826i;
        this.f2833c.f2662z = c0390u.f2828k;
        this.f2833c.f2627Q = Lifecycle.State.values()[c0390u.f2829l];
        if (c0390u.f2830m != null) {
            this.f2833c.f2639c = c0390u.f2830m;
        } else {
            this.f2833c.f2639c = new Bundle();
        }
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "Instantiated fragment " + this.f2833c);
        }
    }

    C0391v(C0383n c0383n, C0392w c0392w, ComponentCallbacksC0374e componentCallbacksC0374e, C0390u c0390u) {
        this.f2831a = c0383n;
        this.f2832b = c0392w;
        this.f2833c = componentCallbacksC0374e;
        this.f2833c.f2640d = null;
        this.f2833c.f2641e = null;
        this.f2833c.f2654r = 0;
        this.f2833c.f2651o = false;
        this.f2833c.f2648l = false;
        this.f2833c.f2646j = this.f2833c.f2645i != null ? this.f2833c.f2645i.f2643g : null;
        this.f2833c.f2645i = null;
        if (c0390u.f2830m != null) {
            this.f2833c.f2639c = c0390u.f2830m;
        } else {
            this.f2833c.f2639c = new Bundle();
        }
    }

    /* renamed from: a */
    ComponentCallbacksC0374e m3118a() {
        return this.f2833c;
    }

    /* renamed from: a */
    void m3119a(int i) {
        this.f2835e = i;
    }

    /* renamed from: b */
    int m3121b() {
        if (this.f2833c.f2655s == null) {
            return this.f2833c.f2638b;
        }
        int i = this.f2835e;
        switch (this.f2833c.f2627Q) {
            case RESUMED:
                break;
            case STARTED:
                i = Math.min(i, 5);
                break;
            case CREATED:
                i = Math.min(i, 1);
                break;
            case INITIALIZED:
                i = Math.min(i, 0);
                break;
            default:
                i = Math.min(i, -1);
                break;
        }
        if (this.f2833c.f2650n) {
            if (this.f2833c.f2651o) {
                i = Math.max(this.f2835e, 2);
                if (this.f2833c.f2617G != null && this.f2833c.f2617G.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.f2835e < 4 ? Math.min(i, this.f2833c.f2638b) : Math.min(i, 1);
            }
        }
        if (!this.f2833c.f2648l) {
            i = Math.min(i, 1);
        }
        AbstractC0368ae.b.a aVar = null;
        if (AbstractC0384o.f2737a && this.f2833c.f2616F != null) {
            aVar = AbstractC0368ae.m2696a(this.f2833c.f2616F, this.f2833c.m2883t()).m2701a(this);
        }
        if (aVar == AbstractC0368ae.b.a.ADDING) {
            i = Math.min(i, 6);
        } else if (aVar == AbstractC0368ae.b.a.REMOVING) {
            i = Math.max(i, 3);
        } else if (this.f2833c.f2649m) {
            if (this.f2833c.m2869j()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.f2833c.f2618H && this.f2833c.f2638b < 5) {
            i = Math.min(i, 4);
        }
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "computeExpectedState() of " + i + " for " + this.f2833c);
            return i;
        }
        return i;
    }

    /* renamed from: c */
    void m3122c() {
        if (this.f2834d) {
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + m3118a());
                return;
            }
            return;
        }
        try {
            this.f2834d = true;
            while (true) {
                int m3121b = m3121b();
                if (m3121b != this.f2833c.f2638b) {
                    if (m3121b > this.f2833c.f2638b) {
                        switch (this.f2833c.f2638b + 1) {
                            case 0:
                                m3124e();
                                break;
                            case 1:
                                m3125f();
                                break;
                            case 2:
                                m3123d();
                                m3126g();
                                break;
                            case 3:
                                m3127h();
                                break;
                            case 4:
                                if (this.f2833c.f2617G != null && this.f2833c.f2616F != null) {
                                    AbstractC0368ae.m2696a(this.f2833c.f2616F, this.f2833c.m2883t()).m2702a(AbstractC0368ae.b.EnumC3326b.m2724a(this.f2833c.f2617G.getVisibility()), this);
                                }
                                this.f2833c.f2638b = 4;
                                break;
                            case 5:
                                m3128i();
                                break;
                            case 6:
                                this.f2833c.f2638b = 6;
                                break;
                            case 7:
                                m3129j();
                                break;
                        }
                    } else {
                        switch (this.f2833c.f2638b - 1) {
                            case -1:
                                m3136q();
                                break;
                            case 0:
                                m3135p();
                                break;
                            case 1:
                                m3134o();
                                this.f2833c.f2638b = 1;
                                break;
                            case 2:
                                this.f2833c.f2651o = false;
                                this.f2833c.f2638b = 2;
                                break;
                            case 3:
                                if (AbstractC0384o.m2976a(3)) {
                                    Log.m182d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f2833c);
                                }
                                if (this.f2833c.f2617G != null && this.f2833c.f2640d == null) {
                                    m3133n();
                                }
                                if (this.f2833c.f2617G != null && this.f2833c.f2616F != null) {
                                    AbstractC0368ae.m2696a(this.f2833c.f2616F, this.f2833c.m2883t()).m2710d(this);
                                }
                                this.f2833c.f2638b = 3;
                                break;
                            case 4:
                                m3131l();
                                break;
                            case 5:
                                this.f2833c.f2638b = 5;
                                break;
                            case 6:
                                m3130k();
                                break;
                        }
                    }
                } else {
                    if (AbstractC0384o.f2737a && this.f2833c.f2623M) {
                        if (this.f2833c.f2617G != null && this.f2833c.f2616F != null) {
                            AbstractC0368ae m2696a = AbstractC0368ae.m2696a(this.f2833c.f2616F, this.f2833c.m2883t());
                            if (this.f2833c.f2662z) {
                                m2696a.m2708c(this);
                            } else {
                                m2696a.m2706b(this);
                            }
                        }
                        if (this.f2833c.f2655s != null) {
                            this.f2833c.f2655s.m3065o(this.f2833c);
                        }
                        this.f2833c.f2623M = false;
                        this.f2833c.m2818a(this.f2833c.f2662z);
                    }
                    return;
                }
            }
        } finally {
            this.f2834d = false;
        }
    }

    /* renamed from: d */
    void m3123d() {
        if (this.f2833c.f2650n && this.f2833c.f2651o && !this.f2833c.f2653q) {
            if (AbstractC0384o.m2976a(3)) {
                Log.m182d("FragmentManager", "moveto CREATE_VIEW: " + this.f2833c);
            }
            this.f2833c.mo2756a(this.f2833c.m2862h(this.f2833c.f2639c), (ViewGroup) null, this.f2833c.f2639c);
            if (this.f2833c.f2617G != null) {
                this.f2833c.f2617G.setSaveFromParentEnabled(false);
                this.f2833c.f2617G.setTag(C0362a.b.fragment_container_view_tag, this.f2833c);
                if (this.f2833c.f2662z) {
                    this.f2833c.f2617G.setVisibility(8);
                }
                this.f2833c.m2793T();
                this.f2831a.m2947a(this.f2833c, this.f2833c.f2617G, this.f2833c.f2639c, false);
                this.f2833c.f2638b = 2;
            }
        }
    }

    /* renamed from: a */
    void m3120a(ClassLoader classLoader) {
        if (this.f2833c.f2639c != null) {
            this.f2833c.f2639c.setClassLoader(classLoader);
            this.f2833c.f2640d = this.f2833c.f2639c.getSparseParcelableArray("android:view_state");
            this.f2833c.f2641e = this.f2833c.f2639c.getBundle("android:view_registry_state");
            this.f2833c.f2646j = this.f2833c.f2639c.getString("android:target_state");
            if (this.f2833c.f2646j != null) {
                this.f2833c.f2647k = this.f2833c.f2639c.getInt("android:target_req_state", 0);
            }
            if (this.f2833c.f2642f != null) {
                this.f2833c.f2619I = this.f2833c.f2642f.booleanValue();
                this.f2833c.f2642f = null;
            } else {
                this.f2833c.f2619I = this.f2833c.f2639c.getBoolean("android:user_visible_hint", true);
            }
            if (!this.f2833c.f2619I) {
                this.f2833c.f2618H = true;
            }
        }
    }

    /* renamed from: e */
    void m3124e() {
        C0391v c0391v;
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "moveto ATTACHED: " + this.f2833c);
        }
        if (this.f2833c.f2645i != null) {
            c0391v = this.f2832b.m3152c(this.f2833c.f2645i.f2643g);
            if (c0391v == null) {
                throw new IllegalStateException("Fragment " + this.f2833c + " declared target fragment " + this.f2833c.f2645i + " that does not belong to this FragmentManager!");
            }
            this.f2833c.f2646j = this.f2833c.f2645i.f2643g;
            this.f2833c.f2645i = null;
        } else if (this.f2833c.f2646j != null) {
            c0391v = this.f2832b.m3152c(this.f2833c.f2646j);
            if (c0391v == null) {
                throw new IllegalStateException("Fragment " + this.f2833c + " declared target fragment " + this.f2833c.f2646j + " that does not belong to this FragmentManager!");
            }
        } else {
            c0391v = null;
        }
        if (c0391v != null && (AbstractC0384o.f2737a || c0391v.m3118a().f2638b < 1)) {
            c0391v.m3122c();
        }
        this.f2833c.f2656t = this.f2833c.f2655s.m3056k();
        this.f2833c.f2658v = this.f2833c.f2655s.m3058l();
        this.f2831a.m2948a(this.f2833c, false);
        this.f2833c.m2792S();
        this.f2831a.m2950b(this.f2833c, false);
    }

    /* renamed from: f */
    void m3125f() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "moveto CREATED: " + this.f2833c);
        }
        if (!this.f2833c.f2626P) {
            this.f2831a.m2946a(this.f2833c, this.f2833c.f2639c, false);
            this.f2833c.m2872l(this.f2833c.f2639c);
            this.f2831a.m2949b(this.f2833c, this.f2833c.f2639c, false);
        } else {
            this.f2833c.m2867j(this.f2833c.f2639c);
            this.f2833c.f2638b = 1;
        }
    }

    /* renamed from: g */
    void m3126g() {
        String str;
        if (!this.f2833c.f2650n) {
            if (AbstractC0384o.m2976a(3)) {
                Log.m182d("FragmentManager", "moveto CREATE_VIEW: " + this.f2833c);
            }
            LayoutInflater m2862h = this.f2833c.m2862h(this.f2833c.f2639c);
            ViewGroup viewGroup = null;
            if (this.f2833c.f2616F != null) {
                viewGroup = this.f2833c.f2616F;
            } else if (this.f2833c.f2660x != 0) {
                if (this.f2833c.f2660x == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f2833c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) this.f2833c.f2655s.m3060m().mo2767a(this.f2833c.f2660x);
                if (viewGroup == null && !this.f2833c.f2652p) {
                    try {
                        str = this.f2833c.m2882s().getResourceName(this.f2833c.f2660x);
                    } catch (Resources.NotFoundException e2) {
                        str = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f2833c.f2660x) + " (" + str + ") for fragment " + this.f2833c);
                }
            }
            this.f2833c.f2616F = viewGroup;
            this.f2833c.mo2756a(m2862h, viewGroup, this.f2833c.f2639c);
            if (this.f2833c.f2617G != null) {
                this.f2833c.f2617G.setSaveFromParentEnabled(false);
                this.f2833c.f2617G.setTag(C0362a.b.fragment_container_view_tag, this.f2833c);
                if (viewGroup != null) {
                    m3137r();
                }
                if (this.f2833c.f2662z) {
                    this.f2833c.f2617G.setVisibility(8);
                }
                if (C0308x.m2276w(this.f2833c.f2617G)) {
                    C0308x.m2267n(this.f2833c.f2617G);
                } else {
                    final View view = this.f2833c.f2617G;
                    view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.v.1
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View view2) {
                            view.removeOnAttachStateChangeListener(this);
                            C0308x.m2267n(view);
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View view2) {
                        }
                    });
                }
                this.f2833c.m2793T();
                this.f2831a.m2947a(this.f2833c, this.f2833c.f2617G, this.f2833c.f2639c, false);
                int visibility = this.f2833c.f2617G.getVisibility();
                float alpha = this.f2833c.f2617G.getAlpha();
                if (AbstractC0384o.f2737a) {
                    this.f2833c.m2802a(alpha);
                    if (this.f2833c.f2616F != null && visibility == 0) {
                        View findFocus = this.f2833c.f2617G.findFocus();
                        if (findFocus != null) {
                            this.f2833c.m2845b(findFocus);
                            if (AbstractC0384o.m2976a(2)) {
                                Log.m188v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f2833c);
                            }
                        }
                        this.f2833c.f2617G.setAlpha(0.0f);
                    }
                } else {
                    this.f2833c.f2622L = visibility == 0 && this.f2833c.f2616F != null;
                }
            }
            this.f2833c.f2638b = 2;
        }
    }

    /* renamed from: h */
    void m3127h() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f2833c);
        }
        this.f2833c.m2875m(this.f2833c.f2639c);
        this.f2831a.m2951c(this.f2833c, this.f2833c.f2639c, false);
    }

    /* renamed from: i */
    void m3128i() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "moveto STARTED: " + this.f2833c);
        }
        this.f2833c.m2794U();
        this.f2831a.m2952c(this.f2833c, false);
    }

    /* renamed from: j */
    void m3129j() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "moveto RESUMED: " + this.f2833c);
        }
        View m2839ar = this.f2833c.m2839ar();
        if (m2839ar != null && m3116a(m2839ar)) {
            boolean requestFocus = m2839ar.requestFocus();
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "requestFocus: Restoring focused view " + m2839ar + " " + (requestFocus ? "succeeded" : "failed") + " on Fragment " + this.f2833c + " resulting in focused view " + this.f2833c.f2617G.findFocus());
            }
        }
        this.f2833c.m2845b((View) null);
        this.f2833c.m2795V();
        this.f2831a.m2954d(this.f2833c, false);
        this.f2833c.f2639c = null;
        this.f2833c.f2640d = null;
        this.f2833c.f2641e = null;
    }

    /* renamed from: a */
    private boolean m3116a(View view) {
        if (view == this.f2833c.f2617G) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f2833c.f2617G) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    void m3130k() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "movefrom RESUMED: " + this.f2833c);
        }
        this.f2833c.m2799Z();
        this.f2831a.m2955e(this.f2833c, false);
    }

    /* renamed from: l */
    void m3131l() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "movefrom STARTED: " + this.f2833c);
        }
        this.f2833c.m2822aa();
        this.f2831a.m2956f(this.f2833c, false);
    }

    /* renamed from: m */
    C0390u m3132m() {
        C0390u c0390u = new C0390u(this.f2833c);
        if (this.f2833c.f2638b > -1 && c0390u.f2830m == null) {
            c0390u.f2830m = m3117s();
            if (this.f2833c.f2646j != null) {
                if (c0390u.f2830m == null) {
                    c0390u.f2830m = new Bundle();
                }
                c0390u.f2830m.putString("android:target_state", this.f2833c.f2646j);
                if (this.f2833c.f2647k != 0) {
                    c0390u.f2830m.putInt("android:target_req_state", this.f2833c.f2647k);
                }
            }
        } else {
            c0390u.f2830m = this.f2833c.f2639c;
        }
        return c0390u;
    }

    /* renamed from: s */
    private Bundle m3117s() {
        Bundle bundle = new Bundle();
        this.f2833c.m2877n(bundle);
        this.f2831a.m2953d(this.f2833c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f2833c.f2617G != null) {
            m3133n();
        }
        if (this.f2833c.f2640d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f2833c.f2640d);
        }
        if (this.f2833c.f2641e != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f2833c.f2641e);
        }
        if (!this.f2833c.f2619I) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f2833c.f2619I);
        }
        return bundle;
    }

    /* renamed from: n */
    void m3133n() {
        if (this.f2833c.f2617G != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f2833c.f2617G.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f2833c.f2640d = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f2833c.f2629S.m2684b(bundle);
            if (!bundle.isEmpty()) {
                this.f2833c.f2641e = bundle;
            }
        }
    }

    /* renamed from: o */
    void m3134o() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "movefrom CREATE_VIEW: " + this.f2833c);
        }
        if (this.f2833c.f2616F != null && this.f2833c.f2617G != null) {
            this.f2833c.f2616F.removeView(this.f2833c.f2617G);
        }
        this.f2833c.m2823ab();
        this.f2831a.m2957g(this.f2833c, false);
        this.f2833c.f2616F = null;
        this.f2833c.f2617G = null;
        this.f2833c.f2629S = null;
        this.f2833c.f2630T.setValue(null);
        this.f2833c.f2651o = false;
    }

    /* renamed from: p */
    void m3135p() {
        ComponentCallbacksC0374e m3156e;
        boolean z;
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "movefrom CREATED: " + this.f2833c);
        }
        boolean z2 = this.f2833c.f2649m && !this.f2833c.m2869j();
        if (z2 || this.f2832b.m3139a().m3108b(this.f2833c)) {
            AbstractC0381l<?> abstractC0381l = this.f2833c.f2656t;
            if (abstractC0381l instanceof ViewModelStoreOwner) {
                z = this.f2832b.m3139a().m3106a();
            } else if (abstractC0381l.m2944i() instanceof Activity) {
                z = !((Activity) abstractC0381l.m2944i()).isChangingConfigurations();
            } else {
                z = true;
            }
            if (z2 || z) {
                this.f2832b.m3139a().m3112f(this.f2833c);
            }
            this.f2833c.m2824ac();
            this.f2831a.m2958h(this.f2833c, false);
            for (C0391v c0391v : this.f2832b.m3159g()) {
                if (c0391v != null) {
                    ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                    if (this.f2833c.f2643g.equals(m3118a.f2646j)) {
                        m3118a.f2645i = this.f2833c;
                        m3118a.f2646j = null;
                    }
                }
            }
            if (this.f2833c.f2646j != null) {
                this.f2833c.f2645i = this.f2832b.m3156e(this.f2833c.f2646j);
            }
            this.f2832b.m3149b(this);
            return;
        }
        if (this.f2833c.f2646j != null && (m3156e = this.f2832b.m3156e(this.f2833c.f2646j)) != null && m3156e.f2612B) {
            this.f2833c.f2645i = m3156e;
        }
        this.f2833c.f2638b = 0;
    }

    /* renamed from: q */
    void m3136q() {
        boolean z = false;
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "movefrom ATTACHED: " + this.f2833c);
        }
        this.f2833c.m2825ad();
        this.f2831a.m2959i(this.f2833c, false);
        this.f2833c.f2638b = -1;
        this.f2833c.f2656t = null;
        this.f2833c.f2658v = null;
        this.f2833c.f2655s = null;
        if (this.f2833c.f2649m && !this.f2833c.m2869j()) {
            z = true;
        }
        if (z || this.f2832b.m3139a().m3108b(this.f2833c)) {
            if (AbstractC0384o.m2976a(3)) {
                Log.m182d("FragmentManager", "initState called for fragment: " + this.f2833c);
            }
            this.f2833c.m2781H();
        }
    }

    /* renamed from: r */
    void m3137r() {
        this.f2833c.f2616F.addView(this.f2833c.f2617G, this.f2832b.m3151c(this.f2833c));
    }
}
