package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.p030e.C0270e;

/* compiled from: FragmentHostCallback.java */
/* renamed from: androidx.fragment.app.l */
/* loaded from: classes.dex */
public abstract class AbstractC0381l<E> extends AbstractC0377h {

    /* renamed from: a */
    private final Activity f2725a;

    /* renamed from: b */
    final AbstractC0384o f2726b;

    /* renamed from: c */
    private final Context f2727c;

    /* renamed from: d */
    private final Handler f2728d;

    /* renamed from: e */
    private final int f2729e;

    /* renamed from: g */
    public abstract E mo2907g();

    AbstractC0381l(ActivityC0375f activityC0375f) {
        this(activityC0375f, activityC0375f, new Handler(), 0);
    }

    AbstractC0381l(Activity activity, Context context, Handler handler, int i) {
        this.f2726b = new C0385p();
        this.f2725a = activity;
        this.f2727c = (Context) C0270e.m1961a(context, "context == null");
        this.f2728d = (Handler) C0270e.m1961a(handler, "handler == null");
        this.f2729e = i;
    }

    /* renamed from: a */
    public boolean mo2902a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        return true;
    }

    /* renamed from: b */
    public LayoutInflater mo2904b() {
        return LayoutInflater.from(this.f2727c);
    }

    /* renamed from: f */
    public void mo2906f() {
    }

    @Deprecated
    /* renamed from: a */
    public void m2942a(ComponentCallbacksC0374e componentCallbacksC0374e, String[] strArr, int i) {
    }

    /* renamed from: a */
    public boolean mo2903a(String str) {
        return false;
    }

    @Override // androidx.fragment.app.AbstractC0377h
    /* renamed from: a */
    public View mo2767a(int i) {
        return null;
    }

    @Override // androidx.fragment.app.AbstractC0377h
    /* renamed from: a */
    public boolean mo2768a() {
        return true;
    }

    /* renamed from: h */
    Activity m2943h() {
        return this.f2725a;
    }

    /* renamed from: i */
    Context m2944i() {
        return this.f2727c;
    }

    /* renamed from: j */
    Handler m2945j() {
        return this.f2728d;
    }
}
