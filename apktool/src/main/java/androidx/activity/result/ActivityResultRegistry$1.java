package androidx.activity.result;

import androidx.activity.result.AbstractC0056d;
import androidx.activity.result.p013a.AbstractC0052a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements LifecycleEventObserver {

    /* renamed from: a */
    final /* synthetic */ String f387a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC0054b f388b;

    /* renamed from: c */
    final /* synthetic */ AbstractC0052a f389c;

    /* renamed from: d */
    final /* synthetic */ AbstractC0056d f390d;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (Lifecycle.Event.ON_START.equals(event)) {
            this.f390d.f397d.put(this.f387a, new AbstractC0056d.a<>(this.f388b, this.f389c));
            if (this.f390d.f398e.containsKey(this.f387a)) {
                Object obj = this.f390d.f398e.get(this.f387a);
                this.f390d.f398e.remove(this.f387a);
                this.f388b.mo321a(obj);
            }
            C0051a c0051a = (C0051a) this.f390d.f399f.getParcelable(this.f387a);
            if (c0051a != null) {
                this.f390d.f399f.remove(this.f387a);
                this.f388b.mo321a(this.f389c.mo315a(c0051a.m310a(), c0051a.m311b()));
                return;
            }
            return;
        }
        if (Lifecycle.Event.ON_STOP.equals(event)) {
            this.f390d.f397d.remove(this.f387a);
        } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
            this.f390d.m331a(this.f387a);
        }
    }
}
