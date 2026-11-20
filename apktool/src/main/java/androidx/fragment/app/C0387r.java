package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: FragmentManagerViewModel.java */
/* renamed from: androidx.fragment.app.r */
/* loaded from: classes.dex */
final class C0387r extends ViewModel {

    /* renamed from: a */
    private static final ViewModelProvider.Factory f2810a = new ViewModelProvider.Factory() { // from class: androidx.fragment.app.r.1
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            return new C0387r(true);
        }
    };

    /* renamed from: e */
    private final boolean f2814e;

    /* renamed from: b */
    private final HashMap<String, ComponentCallbacksC0374e> f2811b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, C0387r> f2812c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<String, ViewModelStore> f2813d = new HashMap<>();

    /* renamed from: f */
    private boolean f2815f = false;

    /* renamed from: g */
    private boolean f2816g = false;

    /* renamed from: h */
    private boolean f2817h = false;

    /* renamed from: a */
    static C0387r m3102a(ViewModelStore viewModelStore) {
        return (C0387r) new ViewModelProvider(viewModelStore, f2810a).get(C0387r.class);
    }

    C0387r(boolean z) {
        this.f2814e = z;
    }

    /* renamed from: a */
    void m3105a(boolean z) {
        this.f2817h = z;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "onCleared called for " + this);
        }
        this.f2815f = true;
    }

    /* renamed from: a */
    boolean m3106a() {
        return this.f2815f;
    }

    /* renamed from: a */
    void m3104a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (this.f2817h) {
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f2811b.containsKey(componentCallbacksC0374e.f2643g)) {
            this.f2811b.put(componentCallbacksC0374e.f2643g, componentCallbacksC0374e);
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Updating retained Fragments: Added " + componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: a */
    ComponentCallbacksC0374e m3103a(String str) {
        return this.f2811b.get(str);
    }

    /* renamed from: b */
    Collection<ComponentCallbacksC0374e> m3107b() {
        return new ArrayList(this.f2811b.values());
    }

    /* renamed from: b */
    boolean m3108b(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (!this.f2811b.containsKey(componentCallbacksC0374e.f2643g)) {
            return true;
        }
        if (this.f2814e) {
            return this.f2815f;
        }
        return !this.f2816g;
    }

    /* renamed from: c */
    void m3109c(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (this.f2817h) {
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if ((this.f2811b.remove(componentCallbacksC0374e.f2643g) != null) && AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Updating retained Fragments: Removed " + componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: d */
    C0387r m3110d(ComponentCallbacksC0374e componentCallbacksC0374e) {
        C0387r c0387r = this.f2812c.get(componentCallbacksC0374e.f2643g);
        if (c0387r == null) {
            C0387r c0387r2 = new C0387r(this.f2814e);
            this.f2812c.put(componentCallbacksC0374e.f2643g, c0387r2);
            return c0387r2;
        }
        return c0387r;
    }

    /* renamed from: e */
    ViewModelStore m3111e(ComponentCallbacksC0374e componentCallbacksC0374e) {
        ViewModelStore viewModelStore = this.f2813d.get(componentCallbacksC0374e.f2643g);
        if (viewModelStore == null) {
            ViewModelStore viewModelStore2 = new ViewModelStore();
            this.f2813d.put(componentCallbacksC0374e.f2643g, viewModelStore2);
            return viewModelStore2;
        }
        return viewModelStore;
    }

    /* renamed from: f */
    void m3112f(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (AbstractC0384o.m2976a(3)) {
            Log.m182d("FragmentManager", "Clearing non-config state for " + componentCallbacksC0374e);
        }
        C0387r c0387r = this.f2812c.get(componentCallbacksC0374e.f2643g);
        if (c0387r != null) {
            c0387r.onCleared();
            this.f2812c.remove(componentCallbacksC0374e.f2643g);
        }
        ViewModelStore viewModelStore = this.f2813d.get(componentCallbacksC0374e.f2643g);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.f2813d.remove(componentCallbacksC0374e.f2643g);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0387r c0387r = (C0387r) obj;
        return this.f2811b.equals(c0387r.f2811b) && this.f2812c.equals(c0387r.f2812c) && this.f2813d.equals(c0387r.f2813d);
    }

    public int hashCode() {
        return (((this.f2811b.hashCode() * 31) + this.f2812c.hashCode()) * 31) + this.f2813d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<ComponentCallbacksC0374e> it = this.f2811b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2812c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2813d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
