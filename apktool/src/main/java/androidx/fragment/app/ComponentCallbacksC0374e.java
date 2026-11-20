package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Looper;
import android.p008os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.AbstractC0242m;
import androidx.core.p031f.C0291g;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.p037e.p038a.AbstractC0357a;
import androidx.savedstate.C0433b;
import androidx.savedstate.C0434c;
import androidx.savedstate.C0436e;
import androidx.savedstate.InterfaceC0435d;
import java.lang.reflect.InvocationTargetException;
import java.p209io.FileDescriptor;
import java.p209io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Fragment.java */
/* renamed from: androidx.fragment.app.e */
/* loaded from: classes.dex */
public class ComponentCallbacksC0374e implements ComponentCallbacks, View.OnCreateContextMenuListener, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, InterfaceC0435d {

    /* renamed from: a */
    static final Object f2610a = new Object();

    /* renamed from: A */
    boolean f2611A;

    /* renamed from: B */
    boolean f2612B;

    /* renamed from: C */
    boolean f2613C;

    /* renamed from: D */
    boolean f2614D;

    /* renamed from: F */
    ViewGroup f2616F;

    /* renamed from: G */
    View f2617G;

    /* renamed from: H */
    boolean f2618H;

    /* renamed from: J */
    a f2620J;

    /* renamed from: L */
    boolean f2622L;

    /* renamed from: M */
    boolean f2623M;

    /* renamed from: N */
    float f2624N;

    /* renamed from: O */
    LayoutInflater f2625O;

    /* renamed from: P */
    boolean f2626P;

    /* renamed from: R */
    LifecycleRegistry f2628R;

    /* renamed from: S */
    C0365ab f2629S;

    /* renamed from: U */
    ViewModelProvider.Factory f2631U;

    /* renamed from: V */
    C0434c f2632V;

    /* renamed from: X */
    private boolean f2634X;

    /* renamed from: Y */
    private int f2635Y;

    /* renamed from: c */
    Bundle f2639c;

    /* renamed from: d */
    SparseArray<Parcelable> f2640d;

    /* renamed from: e */
    Bundle f2641e;

    /* renamed from: f */
    Boolean f2642f;

    /* renamed from: h */
    Bundle f2644h;

    /* renamed from: i */
    ComponentCallbacksC0374e f2645i;

    /* renamed from: k */
    int f2647k;

    /* renamed from: l */
    boolean f2648l;

    /* renamed from: m */
    boolean f2649m;

    /* renamed from: n */
    boolean f2650n;

    /* renamed from: o */
    boolean f2651o;

    /* renamed from: p */
    boolean f2652p;

    /* renamed from: q */
    boolean f2653q;

    /* renamed from: r */
    int f2654r;

    /* renamed from: s */
    AbstractC0384o f2655s;

    /* renamed from: t */
    AbstractC0381l<?> f2656t;

    /* renamed from: v */
    ComponentCallbacksC0374e f2658v;

    /* renamed from: w */
    int f2659w;

    /* renamed from: x */
    int f2660x;

    /* renamed from: y */
    String f2661y;

    /* renamed from: z */
    boolean f2662z;

    /* renamed from: b */
    int f2638b = -1;

    /* renamed from: g */
    String f2643g = UUID.randomUUID().toString();

    /* renamed from: j */
    String f2646j = null;

    /* renamed from: W */
    private Boolean f2633W = null;

    /* renamed from: u */
    AbstractC0384o f2657u = new C0385p();

    /* renamed from: E */
    boolean f2615E = true;

    /* renamed from: I */
    boolean f2619I = true;

    /* renamed from: K */
    Runnable f2621K = new Runnable() { // from class: androidx.fragment.app.e.1
        @Override // java.lang.Runnable
        public void run() {
            ComponentCallbacksC0374e.this.m2791R();
        }
    };

    /* renamed from: Q */
    Lifecycle.State f2627Q = Lifecycle.State.RESUMED;

    /* renamed from: T */
    MutableLiveData<LifecycleOwner> f2630T = new MutableLiveData<>();

    /* renamed from: Z */
    private final AtomicInteger f2636Z = new AtomicInteger();

    /* renamed from: aa */
    private final ArrayList<c> f2637aa = new ArrayList<>();

    /* compiled from: Fragment.java */
    /* renamed from: androidx.fragment.app.e$d */
    interface d {
        /* renamed from: a */
        void mo2891a();

        /* renamed from: b */
        void mo2892b();
    }

    /* compiled from: Fragment.java */
    /* renamed from: androidx.fragment.app.e$c */
    private static abstract class c {
        /* renamed from: a */
        abstract void m2890a();

        private c() {
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f2628R;
    }

    /* renamed from: i */
    public LiveData<LifecycleOwner> m2865i() {
        return this.f2630T;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.f2655s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (m2769a() == Lifecycle.State.INITIALIZED.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        return this.f2655s.m3038c(this);
    }

    /* renamed from: a */
    private int m2769a() {
        return (this.f2627Q == Lifecycle.State.INITIALIZED || this.f2658v == null) ? this.f2627Q.ordinal() : Math.min(this.f2627Q.ordinal(), this.f2658v.m2769a());
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.f2655s == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f2631U == null) {
            Context applicationContext = m2878o().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && AbstractC0384o.m2976a(3)) {
                Log.m182d("FragmentManager", "Could not find Application instance from Context " + m2878o().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f2631U = new SavedStateViewModelFactory(application, this, m2870k());
        }
        return this.f2631U;
    }

    @Override // androidx.savedstate.InterfaceC0435d
    /* renamed from: d */
    public final C0433b mo300d() {
        return this.f2632V.m3350a();
    }

    /* compiled from: Fragment.java */
    /* renamed from: androidx.fragment.app.e$b */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    public ComponentCallbacksC0374e() {
        m2773e();
    }

    /* renamed from: e */
    private void m2773e() {
        this.f2628R = new LifecycleRegistry(this);
        this.f2632V = C0434c.m3349a(this);
        this.f2631U = null;
    }

    @Deprecated
    /* renamed from: a */
    public static ComponentCallbacksC0374e m2770a(Context context, String str, Bundle bundle) {
        try {
            ComponentCallbacksC0374e newInstance = C0380k.m2939b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.m2860g(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    /* renamed from: f */
    final void m2858f(Bundle bundle) {
        if (this.f2640d != null) {
            this.f2617G.restoreHierarchyState(this.f2640d);
            this.f2640d = null;
        }
        if (this.f2617G != null) {
            this.f2629S.m2681a(this.f2641e);
            this.f2641e = null;
        }
        this.f2634X = false;
        mo2761d(bundle);
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.f2617G != null) {
            this.f2629S.m2682a(Lifecycle.Event.ON_CREATE);
        }
    }

    /* renamed from: j */
    final boolean m2869j() {
        return this.f2654r > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f2643g);
        if (this.f2659w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2659w));
        }
        if (this.f2661y != null) {
            sb.append(" tag=");
            sb.append(this.f2661y);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: g */
    public void m2860g(Bundle bundle) {
        if (this.f2655s != null && m2873l()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f2644h = bundle;
    }

    /* renamed from: k */
    public final Bundle m2870k() {
        return this.f2644h;
    }

    /* renamed from: l */
    public final boolean m2873l() {
        if (this.f2655s == null) {
            return false;
        }
        return this.f2655s.m3049g();
    }

    @Deprecated
    /* renamed from: m */
    public final ComponentCallbacksC0374e m2874m() {
        if (this.f2645i != null) {
            return this.f2645i;
        }
        if (this.f2655s != null && this.f2646j != null) {
            return this.f2655s.m3042d(this.f2646j);
        }
        return null;
    }

    /* renamed from: n */
    public Context m2876n() {
        if (this.f2656t == null) {
            return null;
        }
        return this.f2656t.m2944i();
    }

    /* renamed from: o */
    public final Context m2878o() {
        Context m2876n = m2876n();
        if (m2876n == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to a context.");
        }
        return m2876n;
    }

    /* renamed from: p */
    public final ActivityC0375f m2879p() {
        if (this.f2656t == null) {
            return null;
        }
        return (ActivityC0375f) this.f2656t.m2943h();
    }

    /* renamed from: q */
    public final ActivityC0375f m2880q() {
        ActivityC0375f m2879p = m2879p();
        if (m2879p == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
        }
        return m2879p;
    }

    /* renamed from: r */
    public final Object m2881r() {
        if (this.f2656t == null) {
            return null;
        }
        return this.f2656t.mo2907g();
    }

    /* renamed from: s */
    public final Resources m2882s() {
        return m2878o().getResources();
    }

    /* renamed from: c */
    public final String m2849c(int i) {
        return m2882s().getString(i);
    }

    /* renamed from: a */
    public final String m2801a(int i, Object... objArr) {
        return m2882s().getString(i, objArr);
    }

    /* renamed from: t */
    public final AbstractC0384o m2883t() {
        AbstractC0384o abstractC0384o = this.f2655s;
        if (abstractC0384o == null) {
            throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
        }
        return abstractC0384o;
    }

    /* renamed from: u */
    public final AbstractC0384o m2884u() {
        if (this.f2656t == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.f2657u;
    }

    /* renamed from: v */
    public final ComponentCallbacksC0374e m2885v() {
        return this.f2658v;
    }

    /* renamed from: w */
    public final boolean m2886w() {
        return this.f2656t != null && this.f2648l;
    }

    /* renamed from: x */
    public final boolean m2887x() {
        return this.f2649m;
    }

    /* renamed from: y */
    final boolean m2888y() {
        ComponentCallbacksC0374e m2885v = m2885v();
        return m2885v != null && (m2885v.m2887x() || m2885v.m2888y());
    }

    /* renamed from: z */
    public final boolean m2889z() {
        return this.f2662z;
    }

    /* renamed from: A */
    public final boolean m2774A() {
        return this.f2615E && (this.f2655s == null || this.f2655s.m3035b(this.f2658v));
    }

    /* renamed from: a */
    public void m2818a(boolean z) {
    }

    /* renamed from: b */
    public void m2846b(boolean z) {
        if (this.f2614D != z) {
            this.f2614D = z;
            if (m2886w() && !m2889z()) {
                this.f2656t.mo2906f();
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m2804a(int i, int i2, Intent intent) {
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    @Deprecated
    /* renamed from: a */
    public final void m2819a(String[] strArr, int i) {
        if (this.f2656t == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        m2883t().m3013a(this, strArr, i);
    }

    @Deprecated
    /* renamed from: a */
    public void mo2805a(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: a */
    public boolean m2821a(String str) {
        if (this.f2656t != null) {
            return this.f2656t.mo2903a(str);
        }
        return false;
    }

    /* renamed from: c */
    public LayoutInflater mo2759c(Bundle bundle) {
        return m2864i(bundle);
    }

    /* renamed from: B */
    public final LayoutInflater m2775B() {
        return this.f2625O == null ? m2862h((Bundle) null) : this.f2625O;
    }

    /* renamed from: h */
    LayoutInflater m2862h(Bundle bundle) {
        this.f2625O = mo2759c(bundle);
        return this.f2625O;
    }

    @Deprecated
    /* renamed from: i */
    public LayoutInflater m2864i(Bundle bundle) {
        if (this.f2656t == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater mo2904b = this.f2656t.mo2904b();
        C0291g.m2174a(mo2904b, this.f2657u.m3001G());
        return mo2904b;
    }

    /* renamed from: a */
    public void m2809a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f2634X = true;
        Activity m2943h = this.f2656t == null ? null : this.f2656t.m2943h();
        if (m2943h != null) {
            this.f2634X = false;
            m2808a(m2943h, attributeSet, bundle);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m2808a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f2634X = true;
    }

    @Deprecated
    /* renamed from: a */
    public void m2815a(ComponentCallbacksC0374e componentCallbacksC0374e) {
    }

    /* renamed from: a */
    public void mo2755a(Context context) {
        this.f2634X = true;
        Activity m2943h = this.f2656t == null ? null : this.f2656t.m2943h();
        if (m2943h != null) {
            this.f2634X = false;
            m2807a(m2943h);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m2807a(Activity activity) {
        this.f2634X = true;
    }

    /* renamed from: a */
    public Animation m2800a(int i, boolean z, int i2) {
        return null;
    }

    /* renamed from: b */
    public Animator m2842b(int i, boolean z, int i2) {
        return null;
    }

    /* renamed from: b */
    public void mo2758b(Bundle bundle) {
        this.f2634X = true;
        m2867j(bundle);
        if (!this.f2657u.m3033b(1)) {
            this.f2657u.m3067q();
        }
    }

    /* renamed from: j */
    void m2867j(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.f2657u.m3006a(parcelable);
            this.f2657u.m3067q();
        }
    }

    /* renamed from: b */
    public View mo2691b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f2635Y != 0) {
            return layoutInflater.inflate(this.f2635Y, viewGroup, false);
        }
        return null;
    }

    /* renamed from: a */
    public void mo2688a(View view, Bundle bundle) {
    }

    /* renamed from: C */
    public View m2776C() {
        return this.f2617G;
    }

    /* renamed from: D */
    public final View m2777D() {
        View m2776C = m2776C();
        if (m2776C == null) {
            throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
        }
        return m2776C;
    }

    @Deprecated
    /* renamed from: k */
    public void mo2871k(Bundle bundle) {
        this.f2634X = true;
    }

    /* renamed from: d */
    public void mo2761d(Bundle bundle) {
        this.f2634X = true;
    }

    /* renamed from: f */
    public void mo2764f() {
        this.f2634X = true;
    }

    /* renamed from: E */
    public void mo2778E() {
        this.f2634X = true;
    }

    /* renamed from: e */
    public void mo2762e(Bundle bundle) {
    }

    /* renamed from: c */
    public void m2850c(boolean z) {
    }

    /* renamed from: d */
    public void m2855d(boolean z) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f2634X = true;
    }

    /* renamed from: e */
    public void m2857e(boolean z) {
    }

    /* renamed from: F */
    public void m2779F() {
        this.f2634X = true;
    }

    /* renamed from: g */
    public void mo2765g() {
        this.f2634X = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f2634X = true;
    }

    /* renamed from: h */
    public void mo2692h() {
        this.f2634X = true;
    }

    /* renamed from: G */
    public void m2780G() {
        this.f2634X = true;
    }

    /* renamed from: H */
    void m2781H() {
        m2773e();
        this.f2643g = UUID.randomUUID().toString();
        this.f2648l = false;
        this.f2649m = false;
        this.f2650n = false;
        this.f2651o = false;
        this.f2652p = false;
        this.f2654r = 0;
        this.f2655s = null;
        this.f2657u = new C0385p();
        this.f2656t = null;
        this.f2659w = 0;
        this.f2660x = 0;
        this.f2661y = null;
        this.f2662z = false;
        this.f2611A = false;
    }

    /* renamed from: b */
    public void mo2757b() {
        this.f2634X = true;
    }

    /* renamed from: a */
    public void mo2812a(Menu menu, MenuInflater menuInflater) {
    }

    /* renamed from: a */
    public void mo2811a(Menu menu) {
    }

    /* renamed from: I */
    public void m2782I() {
    }

    /* renamed from: a */
    public boolean mo2820a(MenuItem menuItem) {
        return false;
    }

    /* renamed from: b */
    public void m2844b(Menu menu) {
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m2880q().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    /* renamed from: b */
    public boolean m2848b(MenuItem menuItem) {
        return false;
    }

    /* renamed from: J */
    public Object m2783J() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2678k;
    }

    /* renamed from: K */
    public Object m2784K() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2679l == f2610a ? m2783J() : this.f2620J.f2679l;
    }

    /* renamed from: L */
    public Object m2785L() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2680m;
    }

    /* renamed from: M */
    public Object m2786M() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2681n == f2610a ? m2785L() : this.f2620J.f2681n;
    }

    /* renamed from: N */
    public Object m2787N() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2682o;
    }

    /* renamed from: O */
    public Object m2788O() {
        if (this.f2620J == null) {
            return null;
        }
        if (this.f2620J.f2683p == f2610a) {
            return m2787N();
        }
        return this.f2620J.f2683p;
    }

    /* renamed from: P */
    public boolean m2789P() {
        if (this.f2620J == null || this.f2620J.f2685r == null) {
            return true;
        }
        return this.f2620J.f2685r.booleanValue();
    }

    /* renamed from: Q */
    public boolean m2790Q() {
        if (this.f2620J == null || this.f2620J.f2684q == null) {
            return true;
        }
        return this.f2620J.f2684q.booleanValue();
    }

    /* renamed from: R */
    public void m2791R() {
        if (this.f2620J != null && m2772av().f2690w) {
            if (this.f2656t == null) {
                m2772av().f2690w = false;
            } else if (Looper.myLooper() != this.f2656t.m2945j().getLooper()) {
                this.f2656t.m2945j().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ComponentCallbacksC0374e.this.m2859f(false);
                    }
                });
            } else {
                m2859f(true);
            }
        }
    }

    /* renamed from: f */
    void m2859f(boolean z) {
        d dVar = null;
        if (this.f2620J != null) {
            this.f2620J.f2690w = false;
            d dVar2 = this.f2620J.f2691x;
            this.f2620J.f2691x = null;
            dVar = dVar2;
        }
        if (dVar != null) {
            dVar.mo2891a();
            return;
        }
        if (AbstractC0384o.f2737a && this.f2617G != null && this.f2616F != null && this.f2655s != null) {
            final AbstractC0368ae m2696a = AbstractC0368ae.m2696a(this.f2616F, this.f2655s);
            m2696a.m2705b();
            if (z) {
                this.f2656t.m2945j().post(new Runnable() { // from class: androidx.fragment.app.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        m2696a.m2709d();
                    }
                });
            } else {
                m2696a.m2709d();
            }
        }
    }

    /* renamed from: a */
    public void m2816a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f2659w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f2660x));
        printWriter.print(" mTag=");
        printWriter.println(this.f2661y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f2638b);
        printWriter.print(" mWho=");
        printWriter.print(this.f2643g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f2654r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f2648l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f2649m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f2650n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f2651o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f2662z);
        printWriter.print(" mDetached=");
        printWriter.print(this.f2611A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f2615E);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f2614D);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f2612B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f2619I);
        if (this.f2655s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f2655s);
        }
        if (this.f2656t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f2656t);
        }
        if (this.f2658v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f2658v);
        }
        if (this.f2644h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f2644h);
        }
        if (this.f2639c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f2639c);
        }
        if (this.f2640d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f2640d);
        }
        if (this.f2641e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f2641e);
        }
        ComponentCallbacksC0374e m2874m = m2874m();
        if (m2874m != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(m2874m);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f2647k);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(m2830ai());
        if (m2826ae() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(m2826ae());
        }
        if (m2827af() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(m2827af());
        }
        if (m2828ag() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(m2828ag());
        }
        if (m2829ah() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(m2829ah());
        }
        if (this.f2616F != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f2616F);
        }
        if (this.f2617G != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f2617G);
        }
        if (m2836ao() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m2836ao());
        }
        if (m2876n() != null) {
            AbstractC0357a.m2596a(this).mo2598a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f2657u + ":");
        this.f2657u.m3020a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* renamed from: b */
    ComponentCallbacksC0374e m2843b(String str) {
        return str.equals(this.f2643g) ? this : this.f2657u.m3037c(str);
    }

    /* renamed from: c */
    AbstractC0377h mo2760c() {
        return new AbstractC0377h() { // from class: androidx.fragment.app.e.4
            @Override // androidx.fragment.app.AbstractC0377h
            /* renamed from: a */
            public View mo2767a(int i) {
                if (ComponentCallbacksC0374e.this.f2617G == null) {
                    throw new IllegalStateException("Fragment " + ComponentCallbacksC0374e.this + " does not have a view");
                }
                return ComponentCallbacksC0374e.this.f2617G.findViewById(i);
            }

            @Override // androidx.fragment.app.AbstractC0377h
            /* renamed from: a */
            public boolean mo2768a() {
                return ComponentCallbacksC0374e.this.f2617G != null;
            }
        };
    }

    /* renamed from: S */
    void m2792S() {
        Iterator<c> it = this.f2637aa.iterator();
        while (it.hasNext()) {
            it.next().m2890a();
        }
        this.f2637aa.clear();
        this.f2657u.m3015a(this.f2656t, mo2760c(), this);
        this.f2638b = 0;
        this.f2634X = false;
        mo2755a(this.f2656t.m2944i());
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onAttach()");
        }
        this.f2655s.m3063n(this);
        this.f2657u.m3066p();
    }

    /* renamed from: l */
    void m2872l(Bundle bundle) {
        this.f2657u.m3064o();
        this.f2638b = 1;
        this.f2634X = false;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2628R.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment$5
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP && ComponentCallbacksC0374e.this.f2617G != null) {
                        ComponentCallbacksC0374e.this.f2617G.cancelPendingInputEvents();
                    }
                }
            });
        }
        this.f2632V.m3351a(bundle);
        mo2758b(bundle);
        this.f2626P = true;
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.f2628R.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    /* renamed from: a */
    void mo2756a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2657u.m3064o();
        this.f2653q = true;
        this.f2629S = new C0365ab(this, getViewModelStore());
        this.f2617G = mo2691b(layoutInflater, viewGroup, bundle);
        if (this.f2617G != null) {
            this.f2629S.m2680a();
            ViewTreeLifecycleOwner.set(this.f2617G, this.f2629S);
            ViewTreeViewModelStoreOwner.set(this.f2617G, this.f2629S);
            C0436e.m3353a(this.f2617G, this.f2629S);
            this.f2630T.setValue(this.f2629S);
            return;
        }
        if (this.f2629S.m2685b()) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
        this.f2629S = null;
    }

    /* renamed from: T */
    void m2793T() {
        mo2688a(this.f2617G, this.f2639c);
        this.f2657u.m3068r();
    }

    /* renamed from: m */
    void m2875m(Bundle bundle) {
        this.f2657u.m3064o();
        this.f2638b = 3;
        this.f2634X = false;
        mo2871k(bundle);
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        m2771au();
        this.f2657u.m3069s();
    }

    /* renamed from: au */
    private void m2771au() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f2617G != null) {
            m2858f(this.f2639c);
        }
        this.f2639c = null;
    }

    /* renamed from: U */
    void m2794U() {
        this.f2657u.m3064o();
        this.f2657u.m3026a(true);
        this.f2638b = 5;
        this.f2634X = false;
        mo2764f();
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onStart()");
        }
        this.f2628R.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (this.f2617G != null) {
            this.f2629S.m2682a(Lifecycle.Event.ON_START);
        }
        this.f2657u.m3070t();
    }

    /* renamed from: V */
    void m2795V() {
        this.f2657u.m3064o();
        this.f2657u.m3026a(true);
        this.f2638b = 7;
        this.f2634X = false;
        mo2778E();
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onResume()");
        }
        this.f2628R.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (this.f2617G != null) {
            this.f2629S.m2682a(Lifecycle.Event.ON_RESUME);
        }
        this.f2657u.m3071u();
    }

    /* renamed from: W */
    void m2796W() {
        this.f2657u.m3064o();
    }

    /* renamed from: X */
    void m2797X() {
        boolean m3024a = this.f2655s.m3024a(this);
        if (this.f2633W == null || this.f2633W.booleanValue() != m3024a) {
            this.f2633W = Boolean.valueOf(m3024a);
            m2857e(m3024a);
            this.f2657u.m2995A();
        }
    }

    /* renamed from: g */
    void m2861g(boolean z) {
        m2850c(z);
        this.f2657u.m3032b(z);
    }

    /* renamed from: h */
    void m2863h(boolean z) {
        m2855d(z);
        this.f2657u.m3039c(z);
    }

    /* renamed from: a */
    void m2810a(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f2657u.m3005a(configuration);
    }

    /* renamed from: Y */
    void m2798Y() {
        onLowMemory();
        this.f2657u.m3076z();
    }

    /* renamed from: b */
    boolean m2847b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f2662z) {
            return false;
        }
        if (this.f2614D && this.f2615E) {
            z = true;
            mo2812a(menu, menuInflater);
        }
        return z | this.f2657u.m3022a(menu, menuInflater);
    }

    /* renamed from: c */
    boolean m2851c(Menu menu) {
        boolean z = false;
        if (this.f2662z) {
            return false;
        }
        if (this.f2614D && this.f2615E) {
            z = true;
            mo2811a(menu);
        }
        return z | this.f2657u.m3021a(menu);
    }

    /* renamed from: c */
    boolean m2852c(MenuItem menuItem) {
        if (!this.f2662z) {
            if (this.f2614D && this.f2615E && mo2820a(menuItem)) {
                return true;
            }
            return this.f2657u.m3023a(menuItem);
        }
        return false;
    }

    /* renamed from: d */
    boolean m2856d(MenuItem menuItem) {
        if (!this.f2662z) {
            if (m2848b(menuItem)) {
                return true;
            }
            return this.f2657u.m3034b(menuItem);
        }
        return false;
    }

    /* renamed from: d */
    void m2854d(Menu menu) {
        if (!this.f2662z) {
            if (this.f2614D && this.f2615E) {
                m2844b(menu);
            }
            this.f2657u.m3029b(menu);
        }
    }

    /* renamed from: n */
    void m2877n(Bundle bundle) {
        mo2762e(bundle);
        this.f2632V.m3352b(bundle);
        Parcelable m3054j = this.f2657u.m3054j();
        if (m3054j != null) {
            bundle.putParcelable("android:support:fragments", m3054j);
        }
    }

    /* renamed from: Z */
    void m2799Z() {
        this.f2657u.m3072v();
        if (this.f2617G != null) {
            this.f2629S.m2682a(Lifecycle.Event.ON_PAUSE);
        }
        this.f2628R.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.f2638b = 6;
        this.f2634X = false;
        m2779F();
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* renamed from: aa */
    void m2822aa() {
        this.f2657u.m3073w();
        if (this.f2617G != null) {
            this.f2629S.m2682a(Lifecycle.Event.ON_STOP);
        }
        this.f2628R.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.f2638b = 4;
        this.f2634X = false;
        mo2765g();
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    /* renamed from: ab */
    void m2823ab() {
        this.f2657u.m3074x();
        if (this.f2617G != null && this.f2629S.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            this.f2629S.m2682a(Lifecycle.Event.ON_DESTROY);
        }
        this.f2638b = 1;
        this.f2634X = false;
        mo2692h();
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        AbstractC0357a.m2596a(this).mo2597a();
        this.f2653q = false;
    }

    /* renamed from: ac */
    void m2824ac() {
        this.f2657u.m3075y();
        this.f2628R.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f2638b = 0;
        this.f2634X = false;
        this.f2626P = false;
        m2780G();
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    /* renamed from: ad */
    void m2825ad() {
        this.f2638b = -1;
        this.f2634X = false;
        mo2757b();
        this.f2625O = null;
        if (!this.f2634X) {
            throw new C0370ag("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (!this.f2657u.m3047f()) {
            this.f2657u.m3075y();
            this.f2657u = new C0385p();
        }
    }

    /* renamed from: a */
    void m2814a(d dVar) {
        m2772av();
        if (dVar != this.f2620J.f2691x) {
            if (dVar != null && this.f2620J.f2691x != null) {
                throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
            }
            if (this.f2620J.f2690w) {
                this.f2620J.f2691x = dVar;
            }
            if (dVar != null) {
                dVar.mo2892b();
            }
        }
    }

    /* renamed from: av */
    private a m2772av() {
        if (this.f2620J == null) {
            this.f2620J = new a();
        }
        return this.f2620J;
    }

    /* renamed from: a */
    void m2803a(int i, int i2, int i3, int i4) {
        if (this.f2620J != null || i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            m2772av().f2671d = i;
            m2772av().f2672e = i2;
            m2772av().f2673f = i3;
            m2772av().f2674g = i4;
        }
    }

    /* renamed from: ae */
    int m2826ae() {
        if (this.f2620J == null) {
            return 0;
        }
        return this.f2620J.f2671d;
    }

    /* renamed from: af */
    int m2827af() {
        if (this.f2620J == null) {
            return 0;
        }
        return this.f2620J.f2672e;
    }

    /* renamed from: ag */
    int m2828ag() {
        if (this.f2620J == null) {
            return 0;
        }
        return this.f2620J.f2673f;
    }

    /* renamed from: ah */
    int m2829ah() {
        if (this.f2620J == null) {
            return 0;
        }
        return this.f2620J.f2674g;
    }

    /* renamed from: ai */
    boolean m2830ai() {
        if (this.f2620J == null) {
            return false;
        }
        return this.f2620J.f2670c;
    }

    /* renamed from: i */
    void m2866i(boolean z) {
        if (this.f2620J != null) {
            m2772av().f2670c = z;
        }
    }

    /* renamed from: aj */
    int m2831aj() {
        if (this.f2620J == null) {
            return 0;
        }
        return this.f2620J.f2675h;
    }

    /* renamed from: d */
    void m2853d(int i) {
        if (this.f2620J != null || i != 0) {
            m2772av();
            this.f2620J.f2675h = i;
        }
    }

    /* renamed from: ak */
    ArrayList<String> m2832ak() {
        return (this.f2620J == null || this.f2620J.f2676i == null) ? new ArrayList<>() : this.f2620J.f2676i;
    }

    /* renamed from: al */
    ArrayList<String> m2833al() {
        return (this.f2620J == null || this.f2620J.f2677j == null) ? new ArrayList<>() : this.f2620J.f2677j;
    }

    /* renamed from: a */
    void m2817a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        m2772av();
        this.f2620J.f2676i = arrayList;
        this.f2620J.f2677j = arrayList2;
    }

    /* renamed from: am */
    AbstractC0242m m2834am() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2686s;
    }

    /* renamed from: an */
    AbstractC0242m m2835an() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2687t;
    }

    /* renamed from: ao */
    View m2836ao() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2668a;
    }

    /* renamed from: a */
    void m2813a(View view) {
        m2772av().f2668a = view;
    }

    /* renamed from: a */
    void m2806a(Animator animator) {
        m2772av().f2669b = animator;
    }

    /* renamed from: ap */
    Animator m2837ap() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2669b;
    }

    /* renamed from: a */
    void m2802a(float f2) {
        m2772av().f2688u = f2;
    }

    /* renamed from: aq */
    float m2838aq() {
        if (this.f2620J == null) {
            return 1.0f;
        }
        return this.f2620J.f2688u;
    }

    /* renamed from: b */
    void m2845b(View view) {
        m2772av().f2689v = view;
    }

    /* renamed from: ar */
    View m2839ar() {
        if (this.f2620J == null) {
            return null;
        }
        return this.f2620J.f2689v;
    }

    /* renamed from: as */
    boolean m2840as() {
        if (this.f2620J == null) {
            return false;
        }
        return this.f2620J.f2690w;
    }

    /* renamed from: at */
    boolean m2841at() {
        if (this.f2620J == null) {
            return false;
        }
        return this.f2620J.f2692y;
    }

    /* renamed from: j */
    void m2868j(boolean z) {
        m2772av().f2692y = z;
    }

    /* compiled from: Fragment.java */
    /* renamed from: androidx.fragment.app.e$a */
    static class a {

        /* renamed from: a */
        View f2668a;

        /* renamed from: b */
        Animator f2669b;

        /* renamed from: c */
        boolean f2670c;

        /* renamed from: d */
        int f2671d;

        /* renamed from: e */
        int f2672e;

        /* renamed from: f */
        int f2673f;

        /* renamed from: g */
        int f2674g;

        /* renamed from: h */
        int f2675h;

        /* renamed from: i */
        ArrayList<String> f2676i;

        /* renamed from: j */
        ArrayList<String> f2677j;

        /* renamed from: q */
        Boolean f2684q;

        /* renamed from: r */
        Boolean f2685r;

        /* renamed from: w */
        boolean f2690w;

        /* renamed from: x */
        d f2691x;

        /* renamed from: y */
        boolean f2692y;

        /* renamed from: k */
        Object f2678k = null;

        /* renamed from: l */
        Object f2679l = ComponentCallbacksC0374e.f2610a;

        /* renamed from: m */
        Object f2680m = null;

        /* renamed from: n */
        Object f2681n = ComponentCallbacksC0374e.f2610a;

        /* renamed from: o */
        Object f2682o = null;

        /* renamed from: p */
        Object f2683p = ComponentCallbacksC0374e.f2610a;

        /* renamed from: s */
        AbstractC0242m f2686s = null;

        /* renamed from: t */
        AbstractC0242m f2687t = null;

        /* renamed from: u */
        float f2688u = 1.0f;

        /* renamed from: v */
        View f2689v = null;

        a() {
        }
    }
}
