package androidx.core.p031f;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* renamed from: androidx.core.f.u */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0305u implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    private final View f2206a;

    /* renamed from: b */
    private ViewTreeObserver f2207b;

    /* renamed from: c */
    private final Runnable f2208c;

    private ViewOnAttachStateChangeListenerC0305u(View view, Runnable runnable) {
        this.f2206a = view;
        this.f2207b = view.getViewTreeObserver();
        this.f2208c = runnable;
    }

    /* renamed from: a */
    public static ViewOnAttachStateChangeListenerC0305u m2209a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewOnAttachStateChangeListenerC0305u viewOnAttachStateChangeListenerC0305u = new ViewOnAttachStateChangeListenerC0305u(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewOnAttachStateChangeListenerC0305u);
        view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC0305u);
        return viewOnAttachStateChangeListenerC0305u;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m2210a();
        this.f2208c.run();
        return true;
    }

    /* renamed from: a */
    public void m2210a() {
        if (this.f2207b.isAlive()) {
            this.f2207b.removeOnPreDrawListener(this);
        } else {
            this.f2206a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2206a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f2207b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m2210a();
    }
}
