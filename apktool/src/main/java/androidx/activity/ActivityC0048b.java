package androidx.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.p012a.C0046a;
import androidx.activity.p012a.InterfaceC0047b;
import androidx.activity.result.AbstractC0056d;
import androidx.activity.result.C0058f;
import androidx.activity.result.InterfaceC0057e;
import androidx.activity.result.p013a.AbstractC0052a;
import androidx.core.app.ActivityC0234e;
import androidx.core.app.C0230a;
import androidx.core.app.C0231b;
import androidx.core.content.C0255a;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.p040f.C0360a;
import androidx.savedstate.C0433b;
import androidx.savedstate.C0434c;
import androidx.savedstate.C0436e;
import androidx.savedstate.InterfaceC0435d;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ComponentActivity.java */
/* renamed from: androidx.activity.b */
/* loaded from: classes.dex */
public class ActivityC0048b extends ActivityC0234e implements InterfaceC0050d, InterfaceC0057e, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, InterfaceC0435d {

    /* renamed from: a */
    final C0046a f364a;

    /* renamed from: b */
    final C0434c f365b;

    /* renamed from: c */
    private final LifecycleRegistry f366c;

    /* renamed from: d */
    private ViewModelStore f367d;

    /* renamed from: e */
    private ViewModelProvider.Factory f368e;

    /* renamed from: f */
    private final OnBackPressedDispatcher f369f;

    /* renamed from: g */
    private int f370g;

    /* renamed from: h */
    private final AtomicInteger f371h;

    /* renamed from: i */
    private final AbstractC0056d f372i;

    /* compiled from: ComponentActivity.java */
    /* renamed from: androidx.activity.b$a */
    static final class a {

        /* renamed from: a */
        Object f383a;

        /* renamed from: b */
        ViewModelStore f384b;

        a() {
        }
    }

    public ActivityC0048b() {
        this.f364a = new C0046a();
        this.f366c = new LifecycleRegistry(this);
        this.f365b = C0434c.m3349a(this);
        this.f369f = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ActivityC0048b.super.onBackPressed();
                } catch (IllegalStateException e2) {
                    if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e2;
                    }
                }
            }
        });
        this.f371h = new AtomicInteger();
        this.f372i = new AbstractC0056d() { // from class: androidx.activity.b.2
            @Override // androidx.activity.result.AbstractC0056d
            /* renamed from: a */
            public <I, O> void mo302a(final int i, AbstractC0052a<I, O> abstractC0052a, I i2, C0231b c0231b) {
                ActivityC0048b activityC0048b = ActivityC0048b.this;
                final AbstractC0052a.a<O> mo316b = abstractC0052a.mo316b(activityC0048b, i2);
                if (mo316b != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            m333a(i, (int) mo316b.m317a());
                        }
                    });
                    return;
                }
                Intent mo314a = abstractC0052a.mo314a((Context) activityC0048b, (ActivityC0048b) i2);
                Bundle bundle = null;
                if (mo314a.getExtras() != null && mo314a.getExtras().getClassLoader() == null) {
                    mo314a.setExtrasClassLoader(activityC0048b.getClassLoader());
                }
                if (mo314a.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    bundle = mo314a.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    mo314a.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                } else if (c0231b != null) {
                    bundle = c0231b.m1687a();
                }
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(mo314a.getAction())) {
                    String[] stringArrayExtra = mo314a.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    C0230a.m1682a(activityC0048b, stringArrayExtra, i);
                    return;
                }
                if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(mo314a.getAction())) {
                    C0058f c0058f = (C0058f) mo314a.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        C0230a.m1681a(activityC0048b, c0058f.m336a(), i, c0058f.m337b(), c0058f.m338c(), c0058f.m339d(), 0, bundle);
                        return;
                    } catch (IntentSender.SendIntentException e2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.b.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                m332a(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e2));
                            }
                        });
                        return;
                    }
                }
                C0230a.m1680a(activityC0048b, mo314a, i, bundle);
            }
        };
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$3
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ActivityC0048b.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView != null) {
                            peekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ActivityC0048b.this.f364a.m289a();
                    if (!ActivityC0048b.this.isChangingConfigurations()) {
                        ActivityC0048b.this.getViewModelStore().clear();
                    }
                }
            }
        });
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ActivityC0048b.this.m298b();
                ActivityC0048b.this.getLifecycle().removeObserver(this);
            }
        });
        if (19 <= Build.VERSION.SDK_INT && Build.VERSION.SDK_INT <= 23) {
            getLifecycle().addObserver(new ImmLeaksCleaner(this));
        }
        mo300d().m3348a("android:support:activity-result", new C0433b.b() { // from class: androidx.activity.b.3
            @Override // androidx.savedstate.C0433b.b
            @SuppressLint({"SyntheticAccessor"})
            public Bundle saveState() {
                Bundle bundle = new Bundle();
                ActivityC0048b.this.f372i.m330a(bundle);
                return bundle;
            }
        });
        m297a(new InterfaceC0047b() { // from class: androidx.activity.b.4
            @Override // androidx.activity.p012a.InterfaceC0047b
            @SuppressLint({"SyntheticAccessor"})
            /* renamed from: a */
            public void mo292a(Context context) {
                Bundle m3344a = ActivityC0048b.this.mo300d().m3344a("android:support:activity-result");
                if (m3344a != null) {
                    ActivityC0048b.this.f372i.m334b(m3344a);
                }
            }
        });
    }

    public ActivityC0048b(int i) {
        this();
        this.f370g = i;
    }

    @Override // androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f365b.m3351a(bundle);
        this.f364a.m290a(this);
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
        if (this.f370g != 0) {
            setContentView(this.f370g);
        }
    }

    @Override // androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f365b.m3352b(bundle);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object m296a = m296a();
        ViewModelStore viewModelStore = this.f367d;
        if (viewModelStore == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            viewModelStore = aVar.f384b;
        }
        if (viewModelStore == null && m296a == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f383a = m296a;
        aVar2.f384b = viewModelStore;
        return aVar2;
    }

    @Deprecated
    /* renamed from: a */
    public Object m296a() {
        return null;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        m295f();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        m295f();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        m295f();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        m295f();
        super.addContentView(view, layoutParams);
    }

    /* renamed from: f */
    private void m295f() {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        C0436e.m3353a(getWindow().getDecorView(), this);
    }

    /* renamed from: a */
    public final void m297a(InterfaceC0047b interfaceC0047b) {
        this.f364a.m291a(interfaceC0047b);
    }

    @Override // androidx.core.app.ActivityC0234e, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f366c;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        m298b();
        return this.f367d;
    }

    /* renamed from: b */
    void m298b() {
        if (this.f367d == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.f367d = aVar.f384b;
            }
            if (this.f367d == null) {
                this.f367d = new ViewModelStore();
            }
        }
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f368e == null) {
            this.f368e = new SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f368e;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f369f.m286a();
    }

    @Override // androidx.activity.InterfaceC0050d
    /* renamed from: c */
    public final OnBackPressedDispatcher mo299c() {
        return this.f369f;
    }

    @Override // androidx.savedstate.InterfaceC0435d
    /* renamed from: d */
    public final C0433b mo300d() {
        return this.f365b.m3350a();
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f372i.m332a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.f372i.m332a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // androidx.activity.result.InterfaceC0057e
    /* renamed from: e */
    public final AbstractC0056d mo301e() {
        return this.f372i;
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C0360a.m2626a()) {
                C0360a.m2624a("reportFullyDrawn() for " + getComponentName());
            }
            if (Build.VERSION.SDK_INT > 19) {
                super.reportFullyDrawn();
            } else if (Build.VERSION.SDK_INT == 19 && C0255a.m1852b(this, Manifest.permission.UPDATE_DEVICE_STATS) == 0) {
                super.reportFullyDrawn();
            }
        } finally {
            C0360a.m2627b();
        }
    }
}
