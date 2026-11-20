package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Map;

/* compiled from: SavedStateRegistry.java */
@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.savedstate.b */
/* loaded from: classes.dex */
public final class C0433b {

    /* renamed from: c */
    private Bundle f3151c;

    /* renamed from: d */
    private boolean f3152d;

    /* renamed from: e */
    private Recreator.C0431a f3153e;

    /* renamed from: b */
    private SafeIterableMap<String, b> f3150b = new SafeIterableMap<>();

    /* renamed from: a */
    boolean f3149a = true;

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: androidx.savedstate.b$a */
    public interface a {
        void onRecreated(InterfaceC0435d interfaceC0435d);
    }

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: androidx.savedstate.b$b */
    public interface b {
        Bundle saveState();
    }

    C0433b() {
    }

    /* renamed from: a */
    public Bundle m3344a(String str) {
        if (!this.f3152d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        if (this.f3151c == null) {
            return null;
        }
        Bundle bundle = this.f3151c.getBundle(str);
        this.f3151c.remove(str);
        if (this.f3151c.isEmpty()) {
            this.f3151c = null;
            return bundle;
        }
        return bundle;
    }

    /* renamed from: a */
    public void m3348a(String str, b bVar) {
        if (this.f3150b.putIfAbsent(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    /* renamed from: a */
    public void m3347a(Class<? extends a> cls) {
        if (!this.f3149a) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3153e == null) {
            this.f3153e = new Recreator.C0431a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f3153e.m3343a(cls.getName());
        } catch (NoSuchMethodException e2) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
        }
    }

    /* renamed from: a */
    void m3346a(Lifecycle lifecycle, Bundle bundle) {
        if (this.f3152d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f3151c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        lifecycle.addObserver(new GenericLifecycleObserver() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_START) {
                    C0433b.this.f3149a = true;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    C0433b.this.f3149a = false;
                }
            }
        });
        this.f3152d = true;
    }

    /* renamed from: a */
    void m3345a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (this.f3151c != null) {
            bundle2.putAll(this.f3151c);
        }
        SafeIterableMap<String, b>.IteratorWithAdditions iteratorWithAdditions = this.f3150b.iteratorWithAdditions();
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).saveState());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
