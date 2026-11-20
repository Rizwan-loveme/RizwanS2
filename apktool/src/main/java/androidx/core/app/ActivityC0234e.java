package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.p008os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.p031f.C0290f;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.p011a.C0042g;

/* compiled from: ComponentActivity.java */
/* renamed from: androidx.core.app.e */
/* loaded from: classes.dex */
public class ActivityC0234e extends Activity implements C0290f.a, LifecycleOwner {

    /* renamed from: a */
    private C0042g<Class<? extends Object>, Object> f1858a = new C0042g<>();

    /* renamed from: b */
    private LifecycleRegistry f1859b = new LifecycleRegistry(this);

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f1859b.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public Lifecycle getLifecycle() {
        return this.f1859b;
    }

    @Override // androidx.core.p031f.C0290f.a
    /* renamed from: a */
    public boolean mo585a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0290f.m2172a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !C0290f.m2172a(decorView, keyEvent)) {
            return C0290f.m2173a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
