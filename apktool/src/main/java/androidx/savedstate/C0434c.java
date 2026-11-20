package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: SavedStateRegistryController.java */
/* renamed from: androidx.savedstate.c */
/* loaded from: classes.dex */
public final class C0434c {

    /* renamed from: a */
    private final InterfaceC0435d f3154a;

    /* renamed from: b */
    private final C0433b f3155b = new C0433b();

    private C0434c(InterfaceC0435d interfaceC0435d) {
        this.f3154a = interfaceC0435d;
    }

    /* renamed from: a */
    public C0433b m3350a() {
        return this.f3155b;
    }

    /* renamed from: a */
    public void m3351a(Bundle bundle) {
        Lifecycle lifecycle = this.f3154a.getLifecycle();
        if (lifecycle.getCurrentState() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.addObserver(new Recreator(this.f3154a));
        this.f3155b.m3346a(lifecycle, bundle);
    }

    /* renamed from: b */
    public void m3352b(Bundle bundle) {
        this.f3155b.m3345a(bundle);
    }

    /* renamed from: a */
    public static C0434c m3349a(InterfaceC0435d interfaceC0435d) {
        return new C0434c(interfaceC0435d);
    }
}
