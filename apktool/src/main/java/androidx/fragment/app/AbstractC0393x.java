package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* renamed from: androidx.fragment.app.x */
/* loaded from: classes.dex */
public abstract class AbstractC0393x {

    /* renamed from: a */
    private final C0380k f2842a;

    /* renamed from: b */
    private final ClassLoader f2843b;

    /* renamed from: e */
    int f2845e;

    /* renamed from: f */
    int f2846f;

    /* renamed from: g */
    int f2847g;

    /* renamed from: h */
    int f2848h;

    /* renamed from: i */
    int f2849i;

    /* renamed from: j */
    boolean f2850j;

    /* renamed from: l */
    String f2852l;

    /* renamed from: m */
    int f2853m;

    /* renamed from: n */
    CharSequence f2854n;

    /* renamed from: o */
    int f2855o;

    /* renamed from: p */
    CharSequence f2856p;

    /* renamed from: q */
    ArrayList<String> f2857q;

    /* renamed from: r */
    ArrayList<String> f2858r;

    /* renamed from: t */
    ArrayList<Runnable> f2860t;

    /* renamed from: d */
    ArrayList<a> f2844d = new ArrayList<>();

    /* renamed from: k */
    boolean f2851k = true;

    /* renamed from: s */
    boolean f2859s = false;

    /* renamed from: b */
    public abstract int mo2643b();

    /* renamed from: c */
    public abstract int mo2647c();

    /* renamed from: d */
    public abstract void mo2648d();

    /* compiled from: FragmentTransaction.java */
    /* renamed from: androidx.fragment.app.x$a */
    static final class a {

        /* renamed from: a */
        int f2861a;

        /* renamed from: b */
        ComponentCallbacksC0374e f2862b;

        /* renamed from: c */
        int f2863c;

        /* renamed from: d */
        int f2864d;

        /* renamed from: e */
        int f2865e;

        /* renamed from: f */
        int f2866f;

        /* renamed from: g */
        Lifecycle.State f2867g;

        /* renamed from: h */
        Lifecycle.State f2868h;

        a() {
        }

        a(int i, ComponentCallbacksC0374e componentCallbacksC0374e) {
            this.f2861a = i;
            this.f2862b = componentCallbacksC0374e;
            this.f2867g = Lifecycle.State.RESUMED;
            this.f2868h = Lifecycle.State.RESUMED;
        }
    }

    AbstractC0393x(C0380k c0380k, ClassLoader classLoader) {
        this.f2842a = c0380k;
        this.f2843b = classLoader;
    }

    /* renamed from: a */
    void m3165a(a aVar) {
        this.f2844d.add(aVar);
        aVar.f2863c = this.f2845e;
        aVar.f2864d = this.f2846f;
        aVar.f2865e = this.f2847g;
        aVar.f2866f = this.f2848h;
    }

    /* renamed from: a */
    public AbstractC0393x m3162a(int i, ComponentCallbacksC0374e componentCallbacksC0374e) {
        mo2637a(i, componentCallbacksC0374e, null, 1);
        return this;
    }

    /* renamed from: a */
    public AbstractC0393x m3163a(int i, ComponentCallbacksC0374e componentCallbacksC0374e, String str) {
        mo2637a(i, componentCallbacksC0374e, str, 1);
        return this;
    }

    /* renamed from: a */
    AbstractC0393x m3164a(ViewGroup viewGroup, ComponentCallbacksC0374e componentCallbacksC0374e, String str) {
        componentCallbacksC0374e.f2616F = viewGroup;
        return m3163a(viewGroup.getId(), componentCallbacksC0374e, str);
    }

    /* renamed from: a */
    void mo2637a(int i, ComponentCallbacksC0374e componentCallbacksC0374e, String str, int i2) {
        Class<?> cls = componentCallbacksC0374e.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (componentCallbacksC0374e.f2661y != null && !str.equals(componentCallbacksC0374e.f2661y)) {
                throw new IllegalStateException("Can't change tag of fragment " + componentCallbacksC0374e + ": was " + componentCallbacksC0374e.f2661y + " now " + str);
            }
            componentCallbacksC0374e.f2661y = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + componentCallbacksC0374e + " with tag " + str + " to container view with no id");
            }
            if (componentCallbacksC0374e.f2659w != 0 && componentCallbacksC0374e.f2659w != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + componentCallbacksC0374e + ": was " + componentCallbacksC0374e.f2659w + " now " + i);
            }
            componentCallbacksC0374e.f2659w = i;
            componentCallbacksC0374e.f2660x = i;
        }
        m3165a(new a(i2, componentCallbacksC0374e));
    }

    /* renamed from: a */
    public AbstractC0393x mo2634a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        m3165a(new a(3, componentCallbacksC0374e));
        return this;
    }

    /* renamed from: c */
    public AbstractC0393x m3166c(int i) {
        this.f2849i = i;
        return this;
    }

    /* renamed from: h */
    public AbstractC0393x m3168h() {
        if (this.f2850j) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f2851k = false;
        return this;
    }

    /* renamed from: c */
    public AbstractC0393x m3167c(boolean z) {
        this.f2859s = z;
        return this;
    }
}
