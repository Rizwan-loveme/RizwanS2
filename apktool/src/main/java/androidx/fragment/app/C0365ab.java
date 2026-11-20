package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.p008os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.C0433b;
import androidx.savedstate.C0434c;
import androidx.savedstate.InterfaceC0435d;

/* compiled from: FragmentViewLifecycleOwner.java */
/* renamed from: androidx.fragment.app.ab */
/* loaded from: classes.dex */
class C0365ab implements HasDefaultViewModelProviderFactory, ViewModelStoreOwner, InterfaceC0435d {

    /* renamed from: a */
    private final ComponentCallbacksC0374e f2483a;

    /* renamed from: b */
    private final ViewModelStore f2484b;

    /* renamed from: c */
    private ViewModelProvider.Factory f2485c;

    /* renamed from: d */
    private LifecycleRegistry f2486d = null;

    /* renamed from: e */
    private C0434c f2487e = null;

    C0365ab(ComponentCallbacksC0374e componentCallbacksC0374e, ViewModelStore viewModelStore) {
        this.f2483a = componentCallbacksC0374e;
        this.f2484b = viewModelStore;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        m2680a();
        return this.f2484b;
    }

    /* renamed from: a */
    void m2680a() {
        if (this.f2486d == null) {
            this.f2486d = new LifecycleRegistry(this);
            this.f2487e = C0434c.m3349a(this);
        }
    }

    /* renamed from: b */
    boolean m2685b() {
        return this.f2486d != null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        m2680a();
        return this.f2486d;
    }

    /* renamed from: a */
    void m2683a(Lifecycle.State state) {
        this.f2486d.setCurrentState(state);
    }

    /* renamed from: a */
    void m2682a(Lifecycle.Event event) {
        this.f2486d.handleLifecycleEvent(event);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f2483a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f2483a.f2631U)) {
            this.f2485c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f2485c == null) {
            Context applicationContext = this.f2483a.m2878o().getApplicationContext();
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
            this.f2485c = new SavedStateViewModelFactory(application, this, this.f2483a.m2870k());
        }
        return this.f2485c;
    }

    @Override // androidx.savedstate.InterfaceC0435d
    /* renamed from: d */
    public C0433b mo300d() {
        m2680a();
        return this.f2487e.m3350a();
    }

    /* renamed from: a */
    void m2681a(Bundle bundle) {
        this.f2487e.m3351a(bundle);
    }

    /* renamed from: b */
    void m2684b(Bundle bundle) {
        this.f2487e.m3352b(bundle);
    }
}
