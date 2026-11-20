package androidx.fragment.app;

import android.p008os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Map;

/* loaded from: classes.dex */
class FragmentManager$6 implements LifecycleEventObserver {

    /* renamed from: a */
    final /* synthetic */ String f2464a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC0389t f2465b;

    /* renamed from: c */
    final /* synthetic */ Lifecycle f2466c;

    /* renamed from: d */
    final /* synthetic */ AbstractC0384o f2467d;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Map map;
        Map map2;
        if (event == Lifecycle.Event.ON_START) {
            map2 = this.f2467d.f2767o;
            Bundle bundle = (Bundle) map2.get(this.f2464a);
            if (bundle != null) {
                this.f2465b.m3113a(this.f2464a, bundle);
                this.f2467d.m3019a(this.f2464a);
            }
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f2466c.removeObserver(this);
            map = this.f2467d.f2768p;
            map.remove(this.f2464a);
        }
    }
}
