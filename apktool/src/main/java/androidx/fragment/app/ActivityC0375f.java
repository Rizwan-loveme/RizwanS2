package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.p008os.Bundle;
import android.p008os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ActivityC0048b;
import androidx.activity.InterfaceC0050d;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.p012a.InterfaceC0047b;
import androidx.activity.result.AbstractC0056d;
import androidx.activity.result.InterfaceC0057e;
import androidx.core.app.C0230a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.p037e.p038a.AbstractC0357a;
import androidx.savedstate.C0433b;
import java.p209io.FileDescriptor;
import java.p209io.PrintWriter;

/* compiled from: FragmentActivity.java */
/* renamed from: androidx.fragment.app.f */
/* loaded from: classes.dex */
public class ActivityC0375f extends ActivityC0048b implements C0230a.a, C0230a.c {

    /* renamed from: c */
    final C0379j f2693c;

    /* renamed from: d */
    final LifecycleRegistry f2694d;

    /* renamed from: e */
    boolean f2695e;

    /* renamed from: f */
    boolean f2696f;

    /* renamed from: g */
    boolean f2697g;

    public ActivityC0375f() {
        this.f2693c = C0379j.m2914a(new a());
        this.f2694d = new LifecycleRegistry(this);
        this.f2697g = true;
        m2894f();
    }

    public ActivityC0375f(int i) {
        super(i);
        this.f2693c = C0379j.m2914a(new a());
        this.f2694d = new LifecycleRegistry(this);
        this.f2697g = true;
        m2894f();
    }

    /* renamed from: f */
    private void m2894f() {
        mo300d().m3348a("android:support:fragments", new C0433b.b() { // from class: androidx.fragment.app.f.1
            @Override // androidx.savedstate.C0433b.b
            public Bundle saveState() {
                Bundle bundle = new Bundle();
                ActivityC0375f.this.m2900n();
                ActivityC0375f.this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                Parcelable m2928c = ActivityC0375f.this.f2693c.m2928c();
                if (m2928c != null) {
                    bundle.putParcelable("android:support:fragments", m2928c);
                }
                return bundle;
            }
        });
        m297a(new InterfaceC0047b() { // from class: androidx.fragment.app.f.2
            @Override // androidx.activity.p012a.InterfaceC0047b
            /* renamed from: a */
            public void mo292a(Context context) {
                ActivityC0375f.this.f2693c.m2919a((ComponentCallbacksC0374e) null);
                Bundle m3344a = ActivityC0375f.this.mo300d().m3344a("android:support:fragments");
                if (m3344a != null) {
                    ActivityC0375f.this.f2693c.m2918a(m3344a.getParcelable("android:support:fragments"));
                }
            }
        });
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f2693c.m2924b();
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f2693c.m2920a(z);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f2693c.m2926b(z);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f2693c.m2924b();
        super.onConfigurationChanged(configuration);
        this.f2693c.m2917a(configuration);
    }

    @Override // androidx.activity.ActivityC0048b, androidx.core.app.ActivityC0234e, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f2693c.m2929d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.f2693c.m2922a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View m2895a = m2895a(view, str, context, attributeSet);
        if (m2895a == null) {
            return super.onCreateView(view, str, context, attributeSet);
        }
        return m2895a;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View m2895a = m2895a(null, str, context, attributeSet);
        if (m2895a == null) {
            return super.onCreateView(str, context, attributeSet);
        }
        return m2895a;
    }

    /* renamed from: a */
    final View m2895a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2693c.m2915a(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f2693c.m2935j();
        this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f2693c.m2936k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f2693c.m2923a(menuItem);
            case 6:
                return this.f2693c.m2927b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f2693c.m2925b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f2696f = false;
        this.f2693c.m2933h();
        this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.f2693c.m2924b();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f2693c.m2924b();
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f2693c.m2924b();
        super.onResume();
        this.f2696f = true;
        this.f2693c.m2937l();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        m2898l();
    }

    /* renamed from: l */
    protected void m2898l() {
        this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        this.f2693c.m2932g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? m2897a(view, menu) | this.f2693c.m2921a(menu) : super.onPreparePanel(i, view, menu);
    }

    @Deprecated
    /* renamed from: a */
    protected boolean m2897a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.f2693c.m2924b();
        super.onStart();
        this.f2697g = false;
        if (!this.f2695e) {
            this.f2695e = true;
            this.f2693c.m2930e();
        }
        this.f2693c.m2937l();
        this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_START);
        this.f2693c.m2931f();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f2697g = true;
        m2900n();
        this.f2693c.m2934i();
        this.f2694d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Deprecated
    /* renamed from: g */
    public void mo455g() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f2695e);
        printWriter.print(" mResumed=");
        printWriter.print(this.f2696f);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2697g);
        if (getApplication() != null) {
            AbstractC0357a.m2596a(this).mo2598a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f2693c.m2916a().m3020a(str, fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    /* renamed from: a */
    public void m2896a(ComponentCallbacksC0374e componentCallbacksC0374e) {
    }

    /* renamed from: m */
    public AbstractC0384o m2899m() {
        return this.f2693c.m2916a();
    }

    @Override // androidx.core.app.C0230a.c
    @Deprecated
    /* renamed from: b */
    public final void mo1686b(int i) {
    }

    @Override // androidx.activity.ActivityC0048b, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f2693c.m2924b();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* compiled from: FragmentActivity.java */
    /* renamed from: androidx.fragment.app.f$a */
    class a extends AbstractC0381l<ActivityC0375f> implements InterfaceC0050d, InterfaceC0057e, InterfaceC0388s, ViewModelStoreOwner {
        public a() {
            super(ActivityC0375f.this);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return ActivityC0375f.this.f2694d;
        }

        @Override // androidx.lifecycle.ViewModelStoreOwner
        public ViewModelStore getViewModelStore() {
            return ActivityC0375f.this.getViewModelStore();
        }

        @Override // androidx.activity.InterfaceC0050d
        /* renamed from: c */
        public OnBackPressedDispatcher mo299c() {
            return ActivityC0375f.this.mo299c();
        }

        @Override // androidx.fragment.app.AbstractC0381l
        /* renamed from: a */
        public boolean mo2902a(ComponentCallbacksC0374e componentCallbacksC0374e) {
            return !ActivityC0375f.this.isFinishing();
        }

        @Override // androidx.fragment.app.AbstractC0381l
        /* renamed from: b */
        public LayoutInflater mo2904b() {
            return ActivityC0375f.this.getLayoutInflater().cloneInContext(ActivityC0375f.this);
        }

        @Override // androidx.fragment.app.AbstractC0381l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ActivityC0375f mo2907g() {
            return ActivityC0375f.this;
        }

        @Override // androidx.fragment.app.AbstractC0381l
        /* renamed from: f */
        public void mo2906f() {
            ActivityC0375f.this.mo455g();
        }

        @Override // androidx.fragment.app.AbstractC0381l
        /* renamed from: a */
        public boolean mo2903a(String str) {
            return C0230a.m1683a((Activity) ActivityC0375f.this, str);
        }

        @Override // androidx.fragment.app.InterfaceC0388s
        /* renamed from: a */
        public void mo2901a(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
            ActivityC0375f.this.m2896a(componentCallbacksC0374e);
        }

        @Override // androidx.fragment.app.AbstractC0381l, androidx.fragment.app.AbstractC0377h
        /* renamed from: a */
        public View mo2767a(int i) {
            return ActivityC0375f.this.findViewById(i);
        }

        @Override // androidx.fragment.app.AbstractC0381l, androidx.fragment.app.AbstractC0377h
        /* renamed from: a */
        public boolean mo2768a() {
            Window window = ActivityC0375f.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.InterfaceC0057e
        /* renamed from: e */
        public AbstractC0056d mo301e() {
            return ActivityC0375f.this.mo301e();
        }
    }

    /* renamed from: n */
    void m2900n() {
        while (m2893a(m2899m(), Lifecycle.State.CREATED)) {
        }
    }

    /* renamed from: a */
    private static boolean m2893a(AbstractC0384o abstractC0384o, Lifecycle.State state) {
        boolean z;
        boolean z2 = false;
        for (ComponentCallbacksC0374e componentCallbacksC0374e : abstractC0384o.m3044e()) {
            if (componentCallbacksC0374e != null) {
                if (componentCallbacksC0374e.m2881r() != null) {
                    z2 |= m2893a(componentCallbacksC0374e.m2884u(), state);
                }
                if (componentCallbacksC0374e.f2629S != null && componentCallbacksC0374e.f2629S.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    componentCallbacksC0374e.f2629S.m2683a(state);
                    z2 = true;
                }
                if (componentCallbacksC0374e.f2628R.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    componentCallbacksC0374e.f2628R.setCurrentState(state);
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        return z2;
    }
}
