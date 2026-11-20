package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.C0433b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements GenericLifecycleObserver {

    /* renamed from: a */
    private final InterfaceC0435d f3144a;

    Recreator(InterfaceC0435d interfaceC0435d) {
        this.f3144a = interfaceC0435d;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        Bundle m3344a = this.f3144a.mo300d().m3344a("androidx.savedstate.Restarter");
        if (m3344a != null) {
            ArrayList<String> stringArrayList = m3344a.getStringArrayList("classes_to_restore");
            if (stringArrayList == null) {
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                m3342a(it.next());
            }
        }
    }

    /* renamed from: a */
    private void m3342a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(C0433b.a.class);
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((C0433b.a) declaredConstructor.newInstance(new Object[0])).onRecreated(this.f3144a);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }

    /* renamed from: androidx.savedstate.Recreator$a */
    static final class C0431a implements C0433b.b {

        /* renamed from: a */
        final Set<String> f3145a = new HashSet();

        C0431a(C0433b c0433b) {
            c0433b.m3348a("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.C0433b.b
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f3145a));
            return bundle;
        }

        /* renamed from: a */
        void m3343a(String str) {
            this.f3145a.add(str);
        }
    }
}
