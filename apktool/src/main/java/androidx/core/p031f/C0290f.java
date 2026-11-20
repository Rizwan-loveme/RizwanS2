package androidx.core.p031f;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: KeyEventDispatcher.java */
/* renamed from: androidx.core.f.f */
/* loaded from: classes.dex */
public class C0290f {

    /* renamed from: a */
    private static boolean f2193a = false;

    /* renamed from: b */
    private static Method f2194b = null;

    /* renamed from: c */
    private static boolean f2195c = false;

    /* renamed from: d */
    private static Field f2196d = null;

    /* compiled from: KeyEventDispatcher.java */
    /* renamed from: androidx.core.f.f$a */
    public interface a {
        /* renamed from: a */
        boolean mo585a(KeyEvent keyEvent);
    }

    /* renamed from: a */
    public static boolean m2172a(View view, KeyEvent keyEvent) {
        return C0308x.m2242a(view, keyEvent);
    }

    /* renamed from: a */
    public static boolean m2173a(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return aVar.mo585a(keyEvent);
        }
        if (callback instanceof Activity) {
            return m2170a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return m2171a((Dialog) callback, keyEvent);
        }
        return (view != null && C0308x.m2247b(view, keyEvent)) || aVar.mo585a(keyEvent);
    }

    /* renamed from: a */
    private static boolean m2169a(ActionBar actionBar, KeyEvent keyEvent) {
        if (!f2193a) {
            try {
                f2194b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException e2) {
            }
            f2193a = true;
        }
        if (f2194b != null) {
            try {
                return ((Boolean) f2194b.invoke(actionBar, keyEvent)).booleanValue();
            } catch (IllegalAccessException e3) {
            } catch (InvocationTargetException e4) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m2170a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m2169a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0308x.m2247b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    /* renamed from: a */
    private static DialogInterface.OnKeyListener m2168a(Dialog dialog) {
        if (!f2195c) {
            try {
                f2196d = Dialog.class.getDeclaredField("mOnKeyListener");
                f2196d.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            f2195c = true;
        }
        if (f2196d != null) {
            try {
                return (DialogInterface.OnKeyListener) f2196d.get(dialog);
            } catch (IllegalAccessException e3) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m2171a(Dialog dialog, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener m2168a = m2168a(dialog);
        if (m2168a != null && m2168a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (C0308x.m2247b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }
}
