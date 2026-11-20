package androidx.fragment.app;

import android.content.Context;
import android.p008os.Bundle;
import android.view.View;
import androidx.fragment.app.AbstractC0384o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentLifecycleCallbacksDispatcher.java */
/* renamed from: androidx.fragment.app.n */
/* loaded from: classes.dex */
class C0383n {

    /* renamed from: a */
    private final CopyOnWriteArrayList<a> f2733a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private final AbstractC0384o f2734b;

    /* compiled from: FragmentLifecycleCallbacksDispatcher.java */
    /* renamed from: androidx.fragment.app.n$a */
    private static final class a {

        /* renamed from: a */
        final AbstractC0384o.b f2735a;

        /* renamed from: b */
        final boolean f2736b;
    }

    C0383n(AbstractC0384o abstractC0384o) {
        this.f2734b = abstractC0384o;
    }

    /* renamed from: a */
    void m2948a(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        Context m2944i = this.f2734b.m3056k().m2944i();
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2948a(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3081a(this.f2734b, componentCallbacksC0374e, m2944i);
            }
        }
    }

    /* renamed from: b */
    void m2950b(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        Context m2944i = this.f2734b.m3056k().m2944i();
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2950b(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3085b(this.f2734b, componentCallbacksC0374e, m2944i);
            }
        }
    }

    /* renamed from: a */
    void m2946a(ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2946a(componentCallbacksC0374e, bundle, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3082a(this.f2734b, componentCallbacksC0374e, bundle);
            }
        }
    }

    /* renamed from: b */
    void m2949b(ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2949b(componentCallbacksC0374e, bundle, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3086b(this.f2734b, componentCallbacksC0374e, bundle);
            }
        }
    }

    /* renamed from: c */
    void m2951c(ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2951c(componentCallbacksC0374e, bundle, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3088c(this.f2734b, componentCallbacksC0374e, bundle);
            }
        }
    }

    /* renamed from: a */
    void m2947a(ComponentCallbacksC0374e componentCallbacksC0374e, View view, Bundle bundle, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2947a(componentCallbacksC0374e, view, bundle, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3083a(this.f2734b, componentCallbacksC0374e, view, bundle);
            }
        }
    }

    /* renamed from: c */
    void m2952c(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2952c(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3080a(this.f2734b, componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: d */
    void m2954d(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2954d(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3084b(this.f2734b, componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: e */
    void m2955e(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2955e(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3087c(this.f2734b, componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: f */
    void m2956f(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2956f(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3089d(this.f2734b, componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: d */
    void m2953d(ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2953d(componentCallbacksC0374e, bundle, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3090d(this.f2734b, componentCallbacksC0374e, bundle);
            }
        }
    }

    /* renamed from: g */
    void m2957g(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2957g(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3091e(this.f2734b, componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: h */
    void m2958h(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2958h(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3092f(this.f2734b, componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: i */
    void m2959i(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ComponentCallbacksC0374e m3058l = this.f2734b.m3058l();
        if (m3058l != null) {
            m3058l.m2883t().m2999E().m2959i(componentCallbacksC0374e, true);
        }
        Iterator<a> it = this.f2733a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2736b) {
                next.f2735a.m3093g(this.f2734b, componentCallbacksC0374e);
            }
        }
    }
}
