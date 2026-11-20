package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: a */
    private static int f349a = 0;

    /* renamed from: b */
    private static Field f350b;

    /* renamed from: c */
    private static Field f351c;

    /* renamed from: d */
    private static Field f352d;

    /* renamed from: e */
    private Activity f353e;

    ImmLeaksCleaner(Activity activity) {
        this.f353e = activity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (f349a == 0) {
                m284a();
            }
            if (f349a == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f353e.getSystemService(Context.INPUT_METHOD_SERVICE);
                try {
                    Object obj = f350b.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                try {
                                    View view = (View) f351c.get(inputMethodManager);
                                    if (view != null) {
                                        if (!view.isAttachedToWindow()) {
                                            try {
                                                f352d.set(inputMethodManager, null);
                                                inputMethodManager.isActive();
                                            } catch (IllegalAccessException e2) {
                                            }
                                        }
                                    }
                                } catch (IllegalAccessException e3) {
                                }
                            } catch (ClassCastException e4) {
                            }
                        }
                    }
                } catch (IllegalAccessException e5) {
                }
            }
        }
    }

    /* renamed from: a */
    private static void m284a() {
        try {
            f349a = 2;
            f351c = InputMethodManager.class.getDeclaredField("mServedView");
            f351c.setAccessible(true);
            f352d = InputMethodManager.class.getDeclaredField("mNextServedView");
            f352d.setAccessible(true);
            f350b = InputMethodManager.class.getDeclaredField("mH");
            f350b.setAccessible(true);
            f349a = 1;
        } catch (NoSuchFieldException e2) {
        }
    }
}
