package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.p008os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.AbstractC0090b;
import androidx.p011a.C0037b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: AppCompatDelegate.java */
/* renamed from: androidx.appcompat.app.e */
/* loaded from: classes.dex */
public abstract class AbstractC0073e {

    /* renamed from: a */
    private static int f552a = -100;

    /* renamed from: b */
    private static final C0037b<WeakReference<AbstractC0073e>> f553b = new C0037b<>();

    /* renamed from: c */
    private static final Object f554c = new Object();

    /* renamed from: a */
    public abstract AbstractC0069a mo466a();

    /* renamed from: a */
    public abstract AbstractC0090b mo467a(AbstractC0090b.a aVar);

    /* renamed from: a */
    public abstract void mo470a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo471a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo472a(View view);

    /* renamed from: a */
    public abstract void mo473a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo474a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo476b();

    /* renamed from: b */
    public abstract <T extends View> T mo477b(int i);

    /* renamed from: b */
    public abstract void mo478b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo479b(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: c */
    public abstract void mo480c();

    /* renamed from: c */
    public abstract void mo481c(int i);

    /* renamed from: c */
    public abstract void mo482c(Bundle bundle);

    /* renamed from: d */
    public abstract void mo483d();

    /* renamed from: d */
    public abstract boolean mo484d(int i);

    /* renamed from: e */
    public abstract void mo485e();

    /* renamed from: f */
    public abstract void mo486f();

    /* renamed from: g */
    public abstract void mo487g();

    /* renamed from: h */
    public abstract void mo488h();

    /* renamed from: a */
    public static AbstractC0073e m460a(Activity activity, InterfaceC0072d interfaceC0072d) {
        return new LayoutInflaterFactory2C0074f(activity, interfaceC0072d);
    }

    /* renamed from: a */
    public static AbstractC0073e m461a(Dialog dialog, InterfaceC0072d interfaceC0072d) {
        return new LayoutInflaterFactory2C0074f(dialog, interfaceC0072d);
    }

    AbstractC0073e() {
    }

    /* renamed from: a */
    public void mo468a(int i) {
    }

    @Deprecated
    /* renamed from: a */
    public void m469a(Context context) {
    }

    /* renamed from: b */
    public Context mo475b(Context context) {
        m469a(context);
        return context;
    }

    /* renamed from: i */
    public int mo489i() {
        return -100;
    }

    /* renamed from: j */
    public static int m465j() {
        return f552a;
    }

    /* renamed from: a */
    static void m462a(AbstractC0073e abstractC0073e) {
        synchronized (f554c) {
            m464c(abstractC0073e);
            f553b.add(new WeakReference<>(abstractC0073e));
        }
    }

    /* renamed from: b */
    static void m463b(AbstractC0073e abstractC0073e) {
        synchronized (f554c) {
            m464c(abstractC0073e);
        }
    }

    /* renamed from: c */
    private static void m464c(AbstractC0073e abstractC0073e) {
        synchronized (f554c) {
            Iterator<WeakReference<AbstractC0073e>> it = f553b.iterator();
            while (it.hasNext()) {
                AbstractC0073e abstractC0073e2 = it.next().get();
                if (abstractC0073e2 == abstractC0073e || abstractC0073e2 == null) {
                    it.remove();
                }
            }
        }
    }
}
