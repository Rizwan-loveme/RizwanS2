package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    final ArrayDeque<AbstractC0049c> f354a;

    /* renamed from: b */
    private final Runnable f355b;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f354a = new ArrayDeque<>();
        this.f355b = runnable;
    }

    /* renamed from: a */
    InterfaceC0045a m285a(AbstractC0049c abstractC0049c) {
        this.f354a.add(abstractC0049c);
        C0044a c0044a = new C0044a(abstractC0049c);
        abstractC0049c.m303a(c0044a);
        return c0044a;
    }

    @SuppressLint({"LambdaLast"})
    /* renamed from: a */
    public void m287a(LifecycleOwner lifecycleOwner, AbstractC0049c abstractC0049c) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            abstractC0049c.m303a(new LifecycleOnBackPressedCancellable(lifecycle, abstractC0049c));
        }
    }

    /* renamed from: a */
    public void m286a() {
        Iterator<AbstractC0049c> descendingIterator = this.f354a.descendingIterator();
        while (descendingIterator.hasNext()) {
            AbstractC0049c next = descendingIterator.next();
            if (next.m305a()) {
                next.mo308c();
                return;
            }
        }
        if (this.f355b != null) {
            this.f355b.run();
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$a */
    private class C0044a implements InterfaceC0045a {

        /* renamed from: b */
        private final AbstractC0049c f361b;

        C0044a(AbstractC0049c abstractC0049c) {
            this.f361b = abstractC0049c;
        }

        @Override // androidx.activity.InterfaceC0045a
        /* renamed from: a */
        public void mo288a() {
            OnBackPressedDispatcher.this.f354a.remove(this.f361b);
            this.f361b.m307b(this);
        }
    }

    private class LifecycleOnBackPressedCancellable implements InterfaceC0045a, LifecycleEventObserver {

        /* renamed from: b */
        private final Lifecycle f357b;

        /* renamed from: c */
        private final AbstractC0049c f358c;

        /* renamed from: d */
        private InterfaceC0045a f359d;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, AbstractC0049c abstractC0049c) {
            this.f357b = lifecycle;
            this.f358c = abstractC0049c;
            lifecycle.addObserver(this);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f359d = OnBackPressedDispatcher.this.m285a(this.f358c);
                return;
            }
            if (event == Lifecycle.Event.ON_STOP) {
                if (this.f359d != null) {
                    this.f359d.mo288a();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                mo288a();
            }
        }

        @Override // androidx.activity.InterfaceC0045a
        /* renamed from: a */
        public void mo288a() {
            this.f357b.removeObserver(this);
            this.f358c.m307b(this);
            if (this.f359d != null) {
                this.f359d.mo288a();
                this.f359d = null;
            }
        }
    }
}
