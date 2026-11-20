package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.AbstractC0049c;
import androidx.activity.InterfaceC0050d;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.AbstractC0055c;
import androidx.activity.result.AbstractC0056d;
import androidx.activity.result.C0051a;
import androidx.activity.result.C0058f;
import androidx.activity.result.InterfaceC0054b;
import androidx.activity.result.InterfaceC0057e;
import androidx.activity.result.p013a.AbstractC0052a;
import androidx.activity.result.p013a.C0053b;
import androidx.core.p026b.C0245b;
import androidx.fragment.C0362a;
import androidx.fragment.app.AbstractC0393x;
import androidx.fragment.app.C0376g;
import androidx.fragment.app.C0394y;
import androidx.fragment.app.ComponentCallbacksC0374e;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.p011a.C0037b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FragmentManager.java */
/* renamed from: androidx.fragment.app.o */
/* loaded from: classes.dex */
public abstract class AbstractC0384o {

    /* renamed from: C */
    private AbstractC0055c<Intent> f2741C;

    /* renamed from: D */
    private AbstractC0055c<C0058f> f2742D;

    /* renamed from: E */
    private AbstractC0055c<String[]> f2743E;

    /* renamed from: F */
    private boolean f2744F;

    /* renamed from: G */
    private boolean f2745G;

    /* renamed from: H */
    private boolean f2746H;

    /* renamed from: I */
    private boolean f2747I;

    /* renamed from: J */
    private boolean f2748J;

    /* renamed from: K */
    private ArrayList<C0363a> f2749K;

    /* renamed from: L */
    private ArrayList<Boolean> f2750L;

    /* renamed from: M */
    private ArrayList<ComponentCallbacksC0374e> f2751M;

    /* renamed from: N */
    private ArrayList<g> f2752N;

    /* renamed from: O */
    private C0387r f2753O;

    /* renamed from: b */
    ArrayList<C0363a> f2755b;

    /* renamed from: d */
    ComponentCallbacksC0374e f2757d;

    /* renamed from: h */
    private boolean f2760h;

    /* renamed from: j */
    private ArrayList<ComponentCallbacksC0374e> f2762j;

    /* renamed from: l */
    private OnBackPressedDispatcher f2764l;

    /* renamed from: q */
    private ArrayList<d> f2769q;

    /* renamed from: v */
    private AbstractC0381l<?> f2774v;

    /* renamed from: w */
    private AbstractC0377h f2775w;

    /* renamed from: x */
    private ComponentCallbacksC0374e f2776x;

    /* renamed from: f */
    private static boolean f2738f = false;

    /* renamed from: a */
    static boolean f2737a = true;

    /* renamed from: g */
    private final ArrayList<e> f2759g = new ArrayList<>();

    /* renamed from: i */
    private final C0392w f2761i = new C0392w();

    /* renamed from: k */
    private final LayoutInflaterFactory2C0382m f2763k = new LayoutInflaterFactory2C0382m(this);

    /* renamed from: m */
    private final AbstractC0049c f2765m = new AbstractC0049c(false) { // from class: androidx.fragment.app.o.1
        @Override // androidx.activity.AbstractC0049c
        /* renamed from: c */
        public void mo308c() {
            AbstractC0384o.this.m3028b();
        }
    };

    /* renamed from: n */
    private final AtomicInteger f2766n = new AtomicInteger();

    /* renamed from: o */
    private final Map<String, Bundle> f2767o = Collections.synchronizedMap(new HashMap());

    /* renamed from: p */
    private final Map<String, Object> f2768p = Collections.synchronizedMap(new HashMap());

    /* renamed from: r */
    private Map<ComponentCallbacksC0374e, HashSet<C0245b>> f2770r = Collections.synchronizedMap(new HashMap());

    /* renamed from: s */
    private final C0394y.a f2771s = new C0394y.a() { // from class: androidx.fragment.app.o.4
        @Override // androidx.fragment.app.C0394y.a
        /* renamed from: a */
        public void mo3077a(ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b) {
            AbstractC0384o.this.m3010a(componentCallbacksC0374e, c0245b);
        }

        @Override // androidx.fragment.app.C0394y.a
        /* renamed from: b */
        public void mo3078b(ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b) {
            if (!c0245b.m1792a()) {
                AbstractC0384o.this.m3030b(componentCallbacksC0374e, c0245b);
            }
        }
    };

    /* renamed from: t */
    private final C0383n f2772t = new C0383n(this);

    /* renamed from: u */
    private final CopyOnWriteArrayList<InterfaceC0388s> f2773u = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    int f2756c = -1;

    /* renamed from: y */
    private C0380k f2777y = null;

    /* renamed from: z */
    private C0380k f2778z = new C0380k() { // from class: androidx.fragment.app.o.5
        @Override // androidx.fragment.app.C0380k
        /* renamed from: c */
        public ComponentCallbacksC0374e mo2941c(ClassLoader classLoader, String str) {
            return AbstractC0384o.this.m3056k().m2912a(AbstractC0384o.this.m3056k().m2944i(), str, (Bundle) null);
        }
    };

    /* renamed from: A */
    private InterfaceC0369af f2739A = null;

    /* renamed from: B */
    private InterfaceC0369af f2740B = new InterfaceC0369af() { // from class: androidx.fragment.app.o.6
        @Override // androidx.fragment.app.InterfaceC0369af
        /* renamed from: a */
        public AbstractC0368ae mo2727a(ViewGroup viewGroup) {
            return new C0372c(viewGroup);
        }
    };

    /* renamed from: e */
    ArrayDeque<c> f2758e = new ArrayDeque<>();

    /* renamed from: P */
    private Runnable f2754P = new Runnable() { // from class: androidx.fragment.app.o.7
        @Override // java.lang.Runnable
        public void run() {
            AbstractC0384o.this.m3026a(true);
        }
    };

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.o$d */
    public interface d {
        /* renamed from: a */
        void m3096a();
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.o$e */
    interface e {
        /* renamed from: a */
        boolean mo2642a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: a */
    static boolean m2976a(int i) {
        return f2738f || Log.isLoggable("FragmentManager", i);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.o$b */
    public static abstract class b {
        /* renamed from: a */
        public void m3081a(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, Context context) {
        }

        /* renamed from: b */
        public void m3085b(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, Context context) {
        }

        /* renamed from: a */
        public void m3082a(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle) {
        }

        /* renamed from: b */
        public void m3086b(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle) {
        }

        @Deprecated
        /* renamed from: c */
        public void m3088c(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle) {
        }

        /* renamed from: a */
        public void m3083a(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, View view, Bundle bundle) {
        }

        /* renamed from: a */
        public void m3080a(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }

        /* renamed from: b */
        public void m3084b(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }

        /* renamed from: c */
        public void m3087c(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }

        /* renamed from: d */
        public void m3089d(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }

        /* renamed from: d */
        public void m3090d(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e, Bundle bundle) {
        }

        /* renamed from: e */
        public void m3091e(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }

        /* renamed from: f */
        public void m3092f(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }

        /* renamed from: g */
        public void m3093g(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e) {
        }
    }

    /* renamed from: a */
    public AbstractC0393x m3002a() {
        return new C0363a(this);
    }

    /* renamed from: H */
    private void m2960H() {
        synchronized (this.f2759g) {
            if (!this.f2759g.isEmpty()) {
                this.f2765m.m304a(true);
            } else {
                this.f2765m.m304a(m3041d() > 0 && m3024a(this.f2776x));
            }
        }
    }

    /* renamed from: a */
    boolean m3024a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e == null) {
            return true;
        }
        AbstractC0384o abstractC0384o = componentCallbacksC0374e.f2655s;
        return componentCallbacksC0374e.equals(abstractC0384o.m2996B()) && m3024a(abstractC0384o.f2776x);
    }

    /* renamed from: b */
    boolean m3035b(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e == null) {
            return true;
        }
        return componentCallbacksC0374e.m2774A();
    }

    /* renamed from: b */
    void m3028b() {
        m3026a(true);
        if (this.f2765m.m305a()) {
            m3040c();
        } else {
            this.f2764l.m286a();
        }
    }

    /* renamed from: c */
    public boolean m3040c() {
        return m2977a((String) null, -1, 0);
    }

    /* renamed from: a */
    public void m3003a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m3016a((e) new f(null, i, i2), false);
    }

    /* renamed from: a */
    private boolean m2977a(String str, int i, int i2) {
        m3026a(false);
        m2985d(true);
        if (this.f2757d != null && i < 0 && str == null && this.f2757d.m2884u().m3040c()) {
            return true;
        }
        boolean m3025a = m3025a(this.f2749K, this.f2750L, str, i, i2);
        if (m3025a) {
            this.f2760h = true;
            try {
                m2980b(this.f2749K, this.f2750L);
            } finally {
                m2963K();
            }
        }
        m2960H();
        m2967O();
        this.f2761i.m3155d();
        return m3025a;
    }

    /* renamed from: d */
    public int m3041d() {
        if (this.f2755b != null) {
            return this.f2755b.size();
        }
        return 0;
    }

    /* renamed from: a */
    void m3010a(ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b) {
        if (this.f2770r.get(componentCallbacksC0374e) == null) {
            this.f2770r.put(componentCallbacksC0374e, new HashSet<>());
        }
        this.f2770r.get(componentCallbacksC0374e).add(c0245b);
    }

    /* renamed from: b */
    void m3030b(ComponentCallbacksC0374e componentCallbacksC0374e, C0245b c0245b) {
        HashSet<C0245b> hashSet = this.f2770r.get(componentCallbacksC0374e);
        if (hashSet != null && hashSet.remove(c0245b) && hashSet.isEmpty()) {
            this.f2770r.remove(componentCallbacksC0374e);
            if (componentCallbacksC0374e.f2638b < 5) {
                m2989r(componentCallbacksC0374e);
                m3043d(componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: a */
    public final void m3019a(String str) {
        this.f2767o.remove(str);
    }

    /* renamed from: a */
    static ComponentCallbacksC0374e m2970a(View view) {
        Object tag = view.getTag(C0362a.b.fragment_container_view_tag);
        if (tag instanceof ComponentCallbacksC0374e) {
            return (ComponentCallbacksC0374e) tag;
        }
        return null;
    }

    /* renamed from: a */
    void m3014a(C0378i c0378i) {
        for (C0391v c0391v : this.f2761i.m3159g()) {
            ComponentCallbacksC0374e m3118a = c0391v.m3118a();
            if (m3118a.f2660x == c0378i.getId() && m3118a.f2617G != null && m3118a.f2617G.getParent() == null) {
                m3118a.f2616F = c0378i;
                c0391v.m3137r();
            }
        }
    }

    /* renamed from: e */
    public List<ComponentCallbacksC0374e> m3044e() {
        return this.f2761i.m3160h();
    }

    /* renamed from: c */
    ViewModelStore m3038c(ComponentCallbacksC0374e componentCallbacksC0374e) {
        return this.f2753O.m3111e(componentCallbacksC0374e);
    }

    /* renamed from: p */
    private C0387r m2987p(ComponentCallbacksC0374e componentCallbacksC0374e) {
        return this.f2753O.m3110d(componentCallbacksC0374e);
    }

    /* renamed from: f */
    public boolean m3047f() {
        return this.f2747I;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f2776x != null) {
            sb.append(this.f2776x.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2776x)));
            sb.append("}");
        } else if (this.f2774v != null) {
            sb.append(this.f2774v.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f2774v)));
            sb.append("}");
        } else {
            sb.append("null");
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m3020a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f2761i.m3144a(str, fileDescriptor, printWriter, strArr);
        if (this.f2762j != null && (size2 = this.f2762j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                ComponentCallbacksC0374e componentCallbacksC0374e = this.f2762j.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0374e.toString());
            }
        }
        if (this.f2755b != null && (size = this.f2755b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                C0363a c0363a = this.f2755b.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(c0363a.toString());
                c0363a.m2639a(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2766n.get());
        synchronized (this.f2759g) {
            int size3 = this.f2759g.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size3; i3++) {
                    e eVar = this.f2759g.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(eVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2774v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2775w);
        if (this.f2776x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2776x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2756c);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2745G);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2746H);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f2747I);
        if (this.f2744F) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2744F);
        }
    }

    /* renamed from: a */
    void m3018a(C0391v c0391v) {
        ComponentCallbacksC0374e m3118a = c0391v.m3118a();
        if (m3118a.f2618H) {
            if (this.f2760h) {
                this.f2748J = true;
                return;
            }
            m3118a.f2618H = false;
            if (f2737a) {
                c0391v.m3122c();
            } else {
                m3043d(m3118a);
            }
        }
    }

    /* renamed from: b */
    boolean m3033b(int i) {
        return this.f2756c >= i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m3009a(ComponentCallbacksC0374e componentCallbacksC0374e, int i) {
        int i2;
        int i3;
        C0391v m3152c = this.f2761i.m3152c(componentCallbacksC0374e.f2643g);
        if (m3152c == null) {
            m3152c = new C0391v(this.f2772t, this.f2761i, componentCallbacksC0374e);
            m3152c.m3119a(1);
        }
        if (componentCallbacksC0374e.f2650n && componentCallbacksC0374e.f2651o && componentCallbacksC0374e.f2638b == 2) {
            i = Math.max(i, 2);
        }
        int min = Math.min(i, m3152c.m3121b());
        if (componentCallbacksC0374e.f2638b <= min) {
            if (componentCallbacksC0374e.f2638b < min && !this.f2770r.isEmpty()) {
                m2988q(componentCallbacksC0374e);
            }
            switch (componentCallbacksC0374e.f2638b) {
                case -1:
                    if (min > -1) {
                        m3152c.m3124e();
                    }
                    if (min > 0) {
                        m3152c.m3125f();
                    }
                    if (min > -1) {
                        m3152c.m3123d();
                    }
                    if (min > 1) {
                        m3152c.m3126g();
                    }
                    if (min > 2) {
                        m3152c.m3127h();
                    }
                    if (min > 4) {
                        m3152c.m3128i();
                    }
                    if (min > 5) {
                        m3152c.m3129j();
                        break;
                    }
                    break;
                case 0:
                    if (min > 0) {
                    }
                    if (min > -1) {
                    }
                    if (min > 1) {
                    }
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                    break;
                case 1:
                    if (min > -1) {
                    }
                    if (min > 1) {
                    }
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                    break;
                case 2:
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                    break;
                case 4:
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                    break;
                case 5:
                    if (min > 5) {
                    }
                    break;
            }
            i2 = min;
        } else {
            if (componentCallbacksC0374e.f2638b > min) {
                switch (componentCallbacksC0374e.f2638b) {
                    case 0:
                        i3 = min;
                        if (i3 < 0) {
                            m3152c.m3136q();
                        }
                        i2 = i3;
                        break;
                    case 1:
                        if (min < 1) {
                            if (this.f2770r.get(componentCallbacksC0374e) == null) {
                                m3152c.m3135p();
                            } else {
                                i3 = 1;
                                if (i3 < 0) {
                                }
                                i2 = i3;
                                break;
                            }
                        }
                        i3 = min;
                        if (i3 < 0) {
                        }
                        i2 = i3;
                        break;
                    case 2:
                        if (min < 2) {
                            C0376g.a aVar = null;
                            if (componentCallbacksC0374e.f2617G != null && componentCallbacksC0374e.f2616F != null) {
                                componentCallbacksC0374e.f2616F.endViewTransition(componentCallbacksC0374e.f2617G);
                                componentCallbacksC0374e.f2617G.clearAnimation();
                                if (!componentCallbacksC0374e.m2888y()) {
                                    if (this.f2756c > -1 && !this.f2747I && componentCallbacksC0374e.f2617G.getVisibility() == 0 && componentCallbacksC0374e.f2624N >= 0.0f) {
                                        aVar = C0376g.m2910a(this.f2774v.m2944i(), componentCallbacksC0374e, false, componentCallbacksC0374e.m2830ai());
                                    }
                                    componentCallbacksC0374e.f2624N = 0.0f;
                                    ViewGroup viewGroup = componentCallbacksC0374e.f2616F;
                                    View view = componentCallbacksC0374e.f2617G;
                                    if (aVar != null) {
                                        C0376g.m2911a(componentCallbacksC0374e, aVar, this.f2771s);
                                    }
                                    viewGroup.removeView(view);
                                    if (m2976a(2)) {
                                        Log.m188v("FragmentManager", "Removing view " + view + " for fragment " + componentCallbacksC0374e + " from container " + viewGroup);
                                    }
                                    if (viewGroup != componentCallbacksC0374e.f2616F) {
                                    }
                                }
                            }
                            if (this.f2770r.get(componentCallbacksC0374e) == null) {
                                m3152c.m3134o();
                            }
                        }
                        if (min < 1) {
                        }
                        i3 = min;
                        if (i3 < 0) {
                        }
                        i2 = i3;
                        break;
                    case 4:
                        if (min < 4) {
                            if (m2976a(3)) {
                                Log.m182d("FragmentManager", "movefrom ACTIVITY_CREATED: " + componentCallbacksC0374e);
                            }
                            if (componentCallbacksC0374e.f2617G != null && this.f2774v.mo2902a(componentCallbacksC0374e) && componentCallbacksC0374e.f2640d == null) {
                                m3152c.m3133n();
                            }
                        }
                        if (min < 2) {
                        }
                        if (min < 1) {
                        }
                        i3 = min;
                        if (i3 < 0) {
                        }
                        i2 = i3;
                        break;
                    case 5:
                        if (min < 5) {
                            m3152c.m3131l();
                        }
                        if (min < 4) {
                        }
                        if (min < 2) {
                        }
                        if (min < 1) {
                        }
                        i3 = min;
                        if (i3 < 0) {
                        }
                        i2 = i3;
                        break;
                    case 7:
                        if (min < 7) {
                            m3152c.m3130k();
                        }
                        if (min < 5) {
                        }
                        if (min < 4) {
                        }
                        if (min < 2) {
                        }
                        if (min < 1) {
                        }
                        i3 = min;
                        if (i3 < 0) {
                        }
                        i2 = i3;
                        break;
                }
            }
            i2 = min;
        }
        if (componentCallbacksC0374e.f2638b != i2) {
            if (m2976a(3)) {
                Log.m182d("FragmentManager", "moveToState: Fragment state for " + componentCallbacksC0374e + " not updated inline; expected state " + i2 + " found " + componentCallbacksC0374e.f2638b);
            }
            componentCallbacksC0374e.f2638b = i2;
        }
    }

    /* renamed from: q */
    private void m2988q(ComponentCallbacksC0374e componentCallbacksC0374e) {
        HashSet<C0245b> hashSet = this.f2770r.get(componentCallbacksC0374e);
        if (hashSet != null) {
            Iterator<C0245b> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().m1793b();
            }
            hashSet.clear();
            m2989r(componentCallbacksC0374e);
            this.f2770r.remove(componentCallbacksC0374e);
        }
    }

    /* renamed from: a */
    void m3012a(ComponentCallbacksC0374e componentCallbacksC0374e, boolean z) {
        ViewGroup m2992u = m2992u(componentCallbacksC0374e);
        if (m2992u != null && (m2992u instanceof C0378i)) {
            ((C0378i) m2992u).setDrawDisappearingViewsLast(!z);
        }
    }

    /* renamed from: r */
    private void m2989r(ComponentCallbacksC0374e componentCallbacksC0374e) {
        componentCallbacksC0374e.m2823ab();
        this.f2772t.m2957g(componentCallbacksC0374e, false);
        componentCallbacksC0374e.f2616F = null;
        componentCallbacksC0374e.f2617G = null;
        componentCallbacksC0374e.f2629S = null;
        componentCallbacksC0374e.f2630T.setValue(null);
        componentCallbacksC0374e.f2651o = false;
    }

    /* renamed from: d */
    void m3043d(ComponentCallbacksC0374e componentCallbacksC0374e) {
        m3009a(componentCallbacksC0374e, this.f2756c);
    }

    /* renamed from: s */
    private void m2990s(final ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e.f2617G != null) {
            C0376g.a m2910a = C0376g.m2910a(this.f2774v.m2944i(), componentCallbacksC0374e, !componentCallbacksC0374e.f2662z, componentCallbacksC0374e.m2830ai());
            if (m2910a != null && m2910a.f2713b != null) {
                m2910a.f2713b.setTarget(componentCallbacksC0374e.f2617G);
                if (componentCallbacksC0374e.f2662z) {
                    if (componentCallbacksC0374e.m2841at()) {
                        componentCallbacksC0374e.m2868j(false);
                    } else {
                        final ViewGroup viewGroup = componentCallbacksC0374e.f2616F;
                        final View view = componentCallbacksC0374e.f2617G;
                        viewGroup.startViewTransition(view);
                        m2910a.f2713b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.o.8
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (componentCallbacksC0374e.f2617G != null && componentCallbacksC0374e.f2662z) {
                                    componentCallbacksC0374e.f2617G.setVisibility(8);
                                }
                            }
                        });
                    }
                } else {
                    componentCallbacksC0374e.f2617G.setVisibility(0);
                }
                m2910a.f2713b.start();
            } else {
                if (m2910a != null) {
                    componentCallbacksC0374e.f2617G.startAnimation(m2910a.f2712a);
                    m2910a.f2712a.start();
                }
                componentCallbacksC0374e.f2617G.setVisibility((!componentCallbacksC0374e.f2662z || componentCallbacksC0374e.m2841at()) ? 0 : 8);
                if (componentCallbacksC0374e.m2841at()) {
                    componentCallbacksC0374e.m2868j(false);
                }
            }
        }
        m3065o(componentCallbacksC0374e);
        componentCallbacksC0374e.f2623M = false;
        componentCallbacksC0374e.m2818a(componentCallbacksC0374e.f2662z);
    }

    /* renamed from: e */
    void m3045e(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (!this.f2761i.m3150b(componentCallbacksC0374e.f2643g)) {
            if (m2976a(3)) {
                Log.m182d("FragmentManager", "Ignoring moving " + componentCallbacksC0374e + " to state " + this.f2756c + "since it is not added to " + this);
                return;
            }
            return;
        }
        m3043d(componentCallbacksC0374e);
        if (componentCallbacksC0374e.f2617G != null && componentCallbacksC0374e.f2622L && componentCallbacksC0374e.f2616F != null) {
            if (componentCallbacksC0374e.f2624N > 0.0f) {
                componentCallbacksC0374e.f2617G.setAlpha(componentCallbacksC0374e.f2624N);
            }
            componentCallbacksC0374e.f2624N = 0.0f;
            componentCallbacksC0374e.f2622L = false;
            C0376g.a m2910a = C0376g.m2910a(this.f2774v.m2944i(), componentCallbacksC0374e, true, componentCallbacksC0374e.m2830ai());
            if (m2910a != null) {
                if (m2910a.f2712a != null) {
                    componentCallbacksC0374e.f2617G.startAnimation(m2910a.f2712a);
                } else {
                    m2910a.f2713b.setTarget(componentCallbacksC0374e.f2617G);
                    m2910a.f2713b.start();
                }
            }
        }
        if (componentCallbacksC0374e.f2623M) {
            m2990s(componentCallbacksC0374e);
        }
    }

    /* renamed from: a */
    void m3004a(int i, boolean z) {
        if (this.f2774v == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f2756c) {
            this.f2756c = i;
            if (f2737a) {
                this.f2761i.m3153c();
            } else {
                Iterator<ComponentCallbacksC0374e> it = this.f2761i.m3160h().iterator();
                while (it.hasNext()) {
                    m3045e(it.next());
                }
                for (C0391v c0391v : this.f2761i.m3159g()) {
                    ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                    if (!m3118a.f2622L) {
                        m3045e(m3118a);
                    }
                    if (m3118a.f2649m && !m3118a.m2869j()) {
                        this.f2761i.m3149b(c0391v);
                    }
                }
            }
            m2961I();
            if (this.f2744F && this.f2774v != null && this.f2756c == 7) {
                this.f2774v.mo2906f();
                this.f2744F = false;
            }
        }
    }

    /* renamed from: I */
    private void m2961I() {
        Iterator<C0391v> it = this.f2761i.m3159g().iterator();
        while (it.hasNext()) {
            m3018a(it.next());
        }
    }

    /* renamed from: f */
    C0391v m3046f(ComponentCallbacksC0374e componentCallbacksC0374e) {
        C0391v m3152c = this.f2761i.m3152c(componentCallbacksC0374e.f2643g);
        if (m3152c == null) {
            C0391v c0391v = new C0391v(this.f2772t, this.f2761i, componentCallbacksC0374e);
            c0391v.m3120a(this.f2774v.m2944i().getClassLoader());
            c0391v.m3119a(this.f2756c);
            return c0391v;
        }
        return m3152c;
    }

    /* renamed from: g */
    C0391v m3048g(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (m2976a(2)) {
            Log.m188v("FragmentManager", "add: " + componentCallbacksC0374e);
        }
        C0391v m3046f = m3046f(componentCallbacksC0374e);
        componentCallbacksC0374e.f2655s = this;
        this.f2761i.m3143a(m3046f);
        if (!componentCallbacksC0374e.f2611A) {
            this.f2761i.m3141a(componentCallbacksC0374e);
            componentCallbacksC0374e.f2649m = false;
            if (componentCallbacksC0374e.f2617G == null) {
                componentCallbacksC0374e.f2623M = false;
            }
            if (m2994w(componentCallbacksC0374e)) {
                this.f2744F = true;
            }
        }
        return m3046f;
    }

    /* renamed from: h */
    void m3051h(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (m2976a(2)) {
            Log.m188v("FragmentManager", "remove: " + componentCallbacksC0374e + " nesting=" + componentCallbacksC0374e.f2654r);
        }
        boolean z = !componentCallbacksC0374e.m2869j();
        if (!componentCallbacksC0374e.f2611A || z) {
            this.f2761i.m3148b(componentCallbacksC0374e);
            if (m2994w(componentCallbacksC0374e)) {
                this.f2744F = true;
            }
            componentCallbacksC0374e.f2649m = true;
            m2991t(componentCallbacksC0374e);
        }
    }

    /* renamed from: i */
    void m3053i(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (m2976a(2)) {
            Log.m188v("FragmentManager", "hide: " + componentCallbacksC0374e);
        }
        if (!componentCallbacksC0374e.f2662z) {
            componentCallbacksC0374e.f2662z = true;
            componentCallbacksC0374e.f2623M = componentCallbacksC0374e.f2623M ? false : true;
            m2991t(componentCallbacksC0374e);
        }
    }

    /* renamed from: j */
    void m3055j(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (m2976a(2)) {
            Log.m188v("FragmentManager", "show: " + componentCallbacksC0374e);
        }
        if (componentCallbacksC0374e.f2662z) {
            componentCallbacksC0374e.f2662z = false;
            componentCallbacksC0374e.f2623M = componentCallbacksC0374e.f2623M ? false : true;
        }
    }

    /* renamed from: k */
    void m3057k(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (m2976a(2)) {
            Log.m188v("FragmentManager", "detach: " + componentCallbacksC0374e);
        }
        if (!componentCallbacksC0374e.f2611A) {
            componentCallbacksC0374e.f2611A = true;
            if (componentCallbacksC0374e.f2648l) {
                if (m2976a(2)) {
                    Log.m188v("FragmentManager", "remove from detach: " + componentCallbacksC0374e);
                }
                this.f2761i.m3148b(componentCallbacksC0374e);
                if (m2994w(componentCallbacksC0374e)) {
                    this.f2744F = true;
                }
                m2991t(componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: l */
    void m3059l(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (m2976a(2)) {
            Log.m188v("FragmentManager", "attach: " + componentCallbacksC0374e);
        }
        if (componentCallbacksC0374e.f2611A) {
            componentCallbacksC0374e.f2611A = false;
            if (!componentCallbacksC0374e.f2648l) {
                this.f2761i.m3141a(componentCallbacksC0374e);
                if (m2976a(2)) {
                    Log.m188v("FragmentManager", "add from attach: " + componentCallbacksC0374e);
                }
                if (m2994w(componentCallbacksC0374e)) {
                    this.f2744F = true;
                }
            }
        }
    }

    /* renamed from: c */
    public ComponentCallbacksC0374e m3036c(int i) {
        return this.f2761i.m3146b(i);
    }

    /* renamed from: b */
    public ComponentCallbacksC0374e m3027b(String str) {
        return this.f2761i.m3138a(str);
    }

    /* renamed from: c */
    ComponentCallbacksC0374e m3037c(String str) {
        return this.f2761i.m3154d(str);
    }

    /* renamed from: d */
    ComponentCallbacksC0374e m3042d(String str) {
        return this.f2761i.m3156e(str);
    }

    /* renamed from: J */
    private void m2962J() {
        if (m3049g()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* renamed from: g */
    public boolean m3049g() {
        return this.f2745G || this.f2746H;
    }

    /* renamed from: a */
    void m3016a(e eVar, boolean z) {
        if (!z) {
            if (this.f2774v == null) {
                if (this.f2747I) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            m2962J();
        }
        synchronized (this.f2759g) {
            if (this.f2774v == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f2759g.add(eVar);
                m3050h();
            }
        }
    }

    /* renamed from: h */
    void m3050h() {
        synchronized (this.f2759g) {
            boolean z = (this.f2752N == null || this.f2752N.isEmpty()) ? false : true;
            boolean z2 = this.f2759g.size() == 1;
            if (z || z2) {
                this.f2774v.m2945j().removeCallbacks(this.f2754P);
                this.f2774v.m2945j().post(this.f2754P);
                m2960H();
            }
        }
    }

    /* renamed from: i */
    int m3052i() {
        return this.f2766n.getAndIncrement();
    }

    /* renamed from: d */
    private void m2985d(boolean z) {
        if (this.f2760h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2774v == null) {
            if (this.f2747I) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        if (Looper.myLooper() != this.f2774v.m2945j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            m2962J();
        }
        if (this.f2749K == null) {
            this.f2749K = new ArrayList<>();
            this.f2750L = new ArrayList<>();
        }
        this.f2760h = true;
        try {
            m2974a((ArrayList<C0363a>) null, (ArrayList<Boolean>) null);
        } finally {
            this.f2760h = false;
        }
    }

    /* renamed from: b */
    void m3031b(e eVar, boolean z) {
        if (!z || (this.f2774v != null && !this.f2747I)) {
            m2985d(z);
            if (eVar.mo2642a(this.f2749K, this.f2750L)) {
                this.f2760h = true;
                try {
                    m2980b(this.f2749K, this.f2750L);
                } finally {
                    m2963K();
                }
            }
            m2960H();
            m2967O();
            this.f2761i.m3155d();
        }
    }

    /* renamed from: K */
    private void m2963K() {
        this.f2760h = false;
        this.f2750L.clear();
        this.f2749K.clear();
    }

    /* renamed from: a */
    boolean m3026a(boolean z) {
        m2985d(z);
        boolean z2 = false;
        while (m2983c(this.f2749K, this.f2750L)) {
            this.f2760h = true;
            try {
                m2980b(this.f2749K, this.f2750L);
                m2963K();
                z2 = true;
            } catch (Throwable th) {
                m2963K();
                throw th;
            }
        }
        m2960H();
        m2967O();
        this.f2761i.m3155d();
        return z2;
    }

    /* renamed from: a */
    private void m2974a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int i;
        int indexOf2;
        int i2 = 0;
        int size = this.f2752N == null ? 0 : this.f2752N.size();
        while (i2 < size) {
            g gVar = this.f2752N.get(i2);
            if (arrayList != null && !gVar.f2799a && (indexOf2 = arrayList.indexOf(gVar.f2800b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.f2752N.remove(i2);
                gVar.m3099e();
                i = i2 - 1;
                size--;
            } else {
                if (gVar.m3097c() || (arrayList != null && gVar.f2800b.m2641a(arrayList, 0, arrayList.size()))) {
                    this.f2752N.remove(i2);
                    i2--;
                    size--;
                    if (arrayList != null && !gVar.f2799a && (indexOf = arrayList.indexOf(gVar.f2800b)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                        gVar.m3099e();
                        i = i2;
                    } else {
                        gVar.m3098d();
                    }
                }
                i = i2;
            }
            i2 = i + 1;
        }
    }

    /* renamed from: b */
    private void m2980b(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2) {
        int i;
        int i2;
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m2974a(arrayList, arrayList2);
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                if (arrayList.get(i3).f2859s) {
                    i = i3;
                    i2 = i4;
                } else {
                    if (i4 != i3) {
                        m2975a(arrayList, arrayList2, i4, i3);
                    }
                    int i5 = i3 + 1;
                    if (arrayList2.get(i3).booleanValue()) {
                        while (i5 < size && arrayList2.get(i5).booleanValue() && !arrayList.get(i5).f2859s) {
                            i5++;
                        }
                    }
                    i2 = i5;
                    m2975a(arrayList, arrayList2, i3, i2);
                    i = i2 - 1;
                }
                i3 = i + 1;
                i4 = i2;
            }
            if (i4 != size) {
                m2975a(arrayList, arrayList2, i4, size);
            }
        }
    }

    /* renamed from: a */
    private void m2975a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        ComponentCallbacksC0374e m2644b;
        boolean z = arrayList.get(i).f2859s;
        if (this.f2751M == null) {
            this.f2751M = new ArrayList<>();
        } else {
            this.f2751M.clear();
        }
        this.f2751M.addAll(this.f2761i.m3160h());
        int i4 = i;
        ComponentCallbacksC0374e m2996B = m2996B();
        boolean z2 = false;
        while (i4 < i2) {
            C0363a c0363a = arrayList.get(i4);
            if (!arrayList2.get(i4).booleanValue()) {
                m2644b = c0363a.m2633a(this.f2751M, m2996B);
            } else {
                m2644b = c0363a.m2644b(this.f2751M, m2996B);
            }
            i4++;
            m2996B = m2644b;
            z2 = z2 || c0363a.f2850j;
        }
        this.f2751M.clear();
        if (!z && this.f2756c >= 1) {
            if (f2737a) {
                for (int i5 = i; i5 < i2; i5++) {
                    Iterator<AbstractC0393x.a> it = arrayList.get(i5).f2844d.iterator();
                    while (it.hasNext()) {
                        ComponentCallbacksC0374e componentCallbacksC0374e = it.next().f2862b;
                        if (componentCallbacksC0374e != null && componentCallbacksC0374e.f2655s != null) {
                            this.f2761i.m3143a(m3046f(componentCallbacksC0374e));
                        }
                    }
                }
            } else {
                C0394y.m3181a(this.f2774v.m2944i(), this.f2775w, arrayList, arrayList2, i, i2, false, this.f2771s);
            }
        }
        m2981b(arrayList, arrayList2, i, i2);
        if (f2737a) {
            boolean booleanValue = arrayList2.get(i2 - 1).booleanValue();
            for (int i6 = i; i6 < i2; i6++) {
                C0363a c0363a2 = arrayList.get(i6);
                if (booleanValue) {
                    for (int size = c0363a2.f2844d.size() - 1; size >= 0; size--) {
                        ComponentCallbacksC0374e componentCallbacksC0374e2 = c0363a2.f2844d.get(size).f2862b;
                        if (componentCallbacksC0374e2 != null) {
                            m3046f(componentCallbacksC0374e2).m3122c();
                        }
                    }
                } else {
                    Iterator<AbstractC0393x.a> it2 = c0363a2.f2844d.iterator();
                    while (it2.hasNext()) {
                        ComponentCallbacksC0374e componentCallbacksC0374e3 = it2.next().f2862b;
                        if (componentCallbacksC0374e3 != null) {
                            m3046f(componentCallbacksC0374e3).m3122c();
                        }
                    }
                }
            }
            m3004a(this.f2756c, true);
            for (AbstractC0368ae abstractC0368ae : m2972a(arrayList, i, i2)) {
                abstractC0368ae.m2704a(booleanValue);
                abstractC0368ae.m2705b();
                abstractC0368ae.m2709d();
            }
        } else {
            if (z) {
                C0037b<ComponentCallbacksC0374e> c0037b = new C0037b<>();
                m2979b(c0037b);
                int m2969a = m2969a(arrayList, arrayList2, i, i2, c0037b);
                m2973a(c0037b);
                i3 = m2969a;
            } else {
                i3 = i2;
            }
            if (i3 != i && z) {
                if (this.f2756c >= 1) {
                    C0394y.m3181a(this.f2774v.m2944i(), this.f2775w, arrayList, arrayList2, i, i3, true, this.f2771s);
                }
                m3004a(this.f2756c, true);
            }
        }
        while (i < i2) {
            C0363a c0363a3 = arrayList.get(i);
            if (arrayList2.get(i).booleanValue() && c0363a3.f2470c >= 0) {
                c0363a3.f2470c = -1;
            }
            c0363a3.m2635a();
            i++;
        }
        if (z2) {
            m2968P();
        }
    }

    /* renamed from: a */
    private Set<AbstractC0368ae> m2972a(ArrayList<C0363a> arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator<AbstractC0393x.a> it = arrayList.get(i).f2844d.iterator();
            while (it.hasNext()) {
                ComponentCallbacksC0374e componentCallbacksC0374e = it.next().f2862b;
                if (componentCallbacksC0374e != null && (viewGroup = componentCallbacksC0374e.f2616F) != null) {
                    hashSet.add(AbstractC0368ae.m2696a(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    /* renamed from: a */
    private void m2973a(C0037b<ComponentCallbacksC0374e> c0037b) {
        int size = c0037b.size();
        for (int i = 0; i < size; i++) {
            ComponentCallbacksC0374e m225b = c0037b.m225b(i);
            if (!m225b.f2648l) {
                View m2777D = m225b.m2777D();
                m225b.f2624N = m2777D.getAlpha();
                m2777D.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: a */
    private int m2969a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0037b<ComponentCallbacksC0374e> c0037b) {
        int i3;
        int i4 = i2 - 1;
        int i5 = i2;
        while (i4 >= i) {
            C0363a c0363a = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (c0363a.m2650f() && !c0363a.m2641a(arrayList, i4 + 1, i2)) {
                if (this.f2752N == null) {
                    this.f2752N = new ArrayList<>();
                }
                g gVar = new g(c0363a, booleanValue);
                this.f2752N.add(gVar);
                c0363a.m2638a(gVar);
                if (booleanValue) {
                    c0363a.m2649e();
                } else {
                    c0363a.m2645b(false);
                }
                int i6 = i5 - 1;
                if (i4 != i6) {
                    arrayList.remove(i4);
                    arrayList.add(i6, c0363a);
                }
                m2979b(c0037b);
                i3 = i6;
            } else {
                i3 = i5;
            }
            i4--;
            i5 = i3;
        }
        return i5;
    }

    /* renamed from: a */
    void m3008a(C0363a c0363a, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0363a.m2645b(z3);
        } else {
            c0363a.m2649e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0363a);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.f2756c >= 1) {
            C0394y.m3181a(this.f2774v.m2944i(), this.f2775w, arrayList, arrayList2, 0, 1, true, this.f2771s);
        }
        if (z3) {
            m3004a(this.f2756c, true);
        }
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3161i()) {
            if (componentCallbacksC0374e != null && componentCallbacksC0374e.f2617G != null && componentCallbacksC0374e.f2622L && c0363a.m2646b(componentCallbacksC0374e.f2660x)) {
                if (componentCallbacksC0374e.f2624N > 0.0f) {
                    componentCallbacksC0374e.f2617G.setAlpha(componentCallbacksC0374e.f2624N);
                }
                if (z3) {
                    componentCallbacksC0374e.f2624N = 0.0f;
                } else {
                    componentCallbacksC0374e.f2624N = -1.0f;
                    componentCallbacksC0374e.f2622L = false;
                }
            }
        }
    }

    /* renamed from: b */
    private static void m2981b(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0363a c0363a = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                c0363a.m2636a(-1);
                c0363a.m2645b(i == i2 + (-1));
            } else {
                c0363a.m2636a(1);
                c0363a.m2649e();
            }
            i++;
        }
    }

    /* renamed from: t */
    private void m2991t(ComponentCallbacksC0374e componentCallbacksC0374e) {
        ViewGroup m2992u = m2992u(componentCallbacksC0374e);
        if (m2992u != null && componentCallbacksC0374e.m2826ae() + componentCallbacksC0374e.m2827af() + componentCallbacksC0374e.m2828ag() + componentCallbacksC0374e.m2829ah() > 0) {
            if (m2992u.getTag(C0362a.b.visible_removing_fragment_view_tag) == null) {
                m2992u.setTag(C0362a.b.visible_removing_fragment_view_tag, componentCallbacksC0374e);
            }
            ((ComponentCallbacksC0374e) m2992u.getTag(C0362a.b.visible_removing_fragment_view_tag)).m2866i(componentCallbacksC0374e.m2830ai());
        }
    }

    /* renamed from: u */
    private ViewGroup m2992u(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e.f2616F != null) {
            return componentCallbacksC0374e.f2616F;
        }
        if (componentCallbacksC0374e.f2660x <= 0) {
            return null;
        }
        if (this.f2775w.mo2768a()) {
            View mo2767a = this.f2775w.mo2767a(componentCallbacksC0374e.f2660x);
            if (mo2767a instanceof ViewGroup) {
                return (ViewGroup) mo2767a;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m2979b(C0037b<ComponentCallbacksC0374e> c0037b) {
        if (this.f2756c >= 1) {
            int min = Math.min(this.f2756c, 5);
            for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
                if (componentCallbacksC0374e.f2638b < min) {
                    m3009a(componentCallbacksC0374e, min);
                    if (componentCallbacksC0374e.f2617G != null && !componentCallbacksC0374e.f2662z && componentCallbacksC0374e.f2622L) {
                        c0037b.add(componentCallbacksC0374e);
                    }
                }
            }
        }
    }

    /* renamed from: L */
    private void m2964L() {
        if (f2737a) {
            Iterator<AbstractC0368ae> it = m2966N().iterator();
            while (it.hasNext()) {
                it.next().m2707c();
            }
        } else if (this.f2752N != null) {
            while (!this.f2752N.isEmpty()) {
                this.f2752N.remove(0).m3098d();
            }
        }
    }

    /* renamed from: M */
    private void m2965M() {
        if (f2737a) {
            Iterator<AbstractC0368ae> it = m2966N().iterator();
            while (it.hasNext()) {
                it.next().m2711e();
            }
        } else if (!this.f2770r.isEmpty()) {
            for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2770r.keySet()) {
                m2988q(componentCallbacksC0374e);
                m3043d(componentCallbacksC0374e);
            }
        }
    }

    /* renamed from: N */
    private Set<AbstractC0368ae> m2966N() {
        HashSet hashSet = new HashSet();
        Iterator<C0391v> it = this.f2761i.m3159g().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().m3118a().f2616F;
            if (viewGroup != null) {
                hashSet.add(AbstractC0368ae.m2695a(viewGroup, m2998D()));
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    private boolean m2983c(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f2759g) {
            if (this.f2759g.isEmpty()) {
                return false;
            }
            int size = this.f2759g.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.f2759g.get(i).mo2642a(arrayList, arrayList2);
            }
            this.f2759g.clear();
            this.f2774v.m2945j().removeCallbacks(this.f2754P);
            return z;
        }
    }

    /* renamed from: O */
    private void m2967O() {
        if (this.f2748J) {
            this.f2748J = false;
            m2961I();
        }
    }

    /* renamed from: P */
    private void m2968P() {
        if (this.f2769q != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2769q.size()) {
                    this.f2769q.get(i2).m3096a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    void m3007a(C0363a c0363a) {
        if (this.f2755b == null) {
            this.f2755b = new ArrayList<>();
        }
        this.f2755b.add(c0363a);
    }

    /* renamed from: a */
    boolean m3025a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.f2755b == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f2755b.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2755b.remove(size));
            arrayList2.add(true);
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.f2755b.size() - 1;
                while (size2 >= 0) {
                    C0363a c0363a = this.f2755b.get(size2);
                    if ((str != null && str.equals(c0363a.m2651g())) || (i >= 0 && i == c0363a.f2470c)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        C0363a c0363a2 = this.f2755b.get(size2);
                        if ((str == null || !str.equals(c0363a2.m2651g())) && (i < 0 || i != c0363a2.f2470c)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.f2755b.size() - 1) {
                return false;
            }
            for (int size3 = this.f2755b.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f2755b.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* renamed from: j */
    Parcelable m3054j() {
        int size;
        C0371b[] c0371bArr = null;
        m2964L();
        m2965M();
        m3026a(true);
        this.f2745G = true;
        this.f2753O.m3105a(true);
        ArrayList<C0390u> m3157e = this.f2761i.m3157e();
        if (m3157e.isEmpty()) {
            if (!m2976a(2)) {
                return null;
            }
            Log.m188v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        ArrayList<String> m3158f = this.f2761i.m3158f();
        if (this.f2755b != null && (size = this.f2755b.size()) > 0) {
            C0371b[] c0371bArr2 = new C0371b[size];
            for (int i = 0; i < size; i++) {
                c0371bArr2[i] = new C0371b(this.f2755b.get(i));
                if (m2976a(2)) {
                    Log.m188v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.f2755b.get(i));
                }
            }
            c0371bArr = c0371bArr2;
        }
        C0386q c0386q = new C0386q();
        c0386q.f2802a = m3157e;
        c0386q.f2803b = m3158f;
        c0386q.f2804c = c0371bArr;
        c0386q.f2805d = this.f2766n.get();
        if (this.f2757d != null) {
            c0386q.f2806e = this.f2757d.f2643g;
        }
        c0386q.f2807f.addAll(this.f2767o.keySet());
        c0386q.f2808g.addAll(this.f2767o.values());
        c0386q.f2809h = new ArrayList<>(this.f2758e);
        return c0386q;
    }

    /* renamed from: a */
    void m3006a(Parcelable parcelable) {
        C0391v c0391v;
        if (parcelable != null) {
            C0386q c0386q = (C0386q) parcelable;
            if (c0386q.f2802a != null) {
                this.f2761i.m3147b();
                Iterator<C0390u> it = c0386q.f2802a.iterator();
                while (it.hasNext()) {
                    C0390u next = it.next();
                    if (next != null) {
                        ComponentCallbacksC0374e m3103a = this.f2753O.m3103a(next.f2819b);
                        if (m3103a != null) {
                            if (m2976a(2)) {
                                Log.m188v("FragmentManager", "restoreSaveState: re-attaching retained " + m3103a);
                            }
                            c0391v = new C0391v(this.f2772t, this.f2761i, m3103a, next);
                        } else {
                            c0391v = new C0391v(this.f2772t, this.f2761i, this.f2774v.m2944i().getClassLoader(), m2997C(), next);
                        }
                        ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                        m3118a.f2655s = this;
                        if (m2976a(2)) {
                            Log.m188v("FragmentManager", "restoreSaveState: active (" + m3118a.f2643g + "): " + m3118a);
                        }
                        c0391v.m3120a(this.f2774v.m2944i().getClassLoader());
                        this.f2761i.m3143a(c0391v);
                        c0391v.m3119a(this.f2756c);
                    }
                }
                for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2753O.m3107b()) {
                    if (!this.f2761i.m3150b(componentCallbacksC0374e.f2643g)) {
                        if (m2976a(2)) {
                            Log.m188v("FragmentManager", "Discarding retained Fragment " + componentCallbacksC0374e + " that was not found in the set of active Fragments " + c0386q.f2802a);
                        }
                        this.f2753O.m3109c(componentCallbacksC0374e);
                        componentCallbacksC0374e.f2655s = this;
                        C0391v c0391v2 = new C0391v(this.f2772t, this.f2761i, componentCallbacksC0374e);
                        c0391v2.m3119a(1);
                        c0391v2.m3122c();
                        componentCallbacksC0374e.f2649m = true;
                        c0391v2.m3122c();
                    }
                }
                this.f2761i.m3145a(c0386q.f2803b);
                if (c0386q.f2804c != null) {
                    this.f2755b = new ArrayList<>(c0386q.f2804c.length);
                    for (int i = 0; i < c0386q.f2804c.length; i++) {
                        C0363a m2728a = c0386q.f2804c[i].m2728a(this);
                        if (m2976a(2)) {
                            Log.m188v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + m2728a.f2470c + "): " + m2728a);
                            PrintWriter printWriter = new PrintWriter(new C0367ad("FragmentManager"));
                            m2728a.m2640a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2755b.add(m2728a);
                    }
                } else {
                    this.f2755b = null;
                }
                this.f2766n.set(c0386q.f2805d);
                if (c0386q.f2806e != null) {
                    this.f2757d = m3042d(c0386q.f2806e);
                    m2993v(this.f2757d);
                }
                ArrayList<String> arrayList = c0386q.f2807f;
                if (arrayList != null) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        Bundle bundle = c0386q.f2808g.get(i2);
                        bundle.setClassLoader(this.f2774v.m2944i().getClassLoader());
                        this.f2767o.put(arrayList.get(i2), bundle);
                    }
                }
                this.f2758e = new ArrayDeque<>(c0386q.f2809h);
            }
        }
    }

    /* renamed from: k */
    AbstractC0381l<?> m3056k() {
        return this.f2774v;
    }

    /* renamed from: l */
    ComponentCallbacksC0374e m3058l() {
        return this.f2776x;
    }

    /* renamed from: m */
    AbstractC0377h m3060m() {
        return this.f2775w;
    }

    /* renamed from: n */
    C0392w m3062n() {
        return this.f2761i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    /* renamed from: a */
    void m3015a(AbstractC0381l<?> abstractC0381l, AbstractC0377h abstractC0377h, final ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (this.f2774v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2774v = abstractC0381l;
        this.f2775w = abstractC0377h;
        this.f2776x = componentCallbacksC0374e;
        if (this.f2776x != null) {
            m3017a(new InterfaceC0388s() { // from class: androidx.fragment.app.o.9
                @Override // androidx.fragment.app.InterfaceC0388s
                /* renamed from: a */
                public void mo2901a(AbstractC0384o abstractC0384o, ComponentCallbacksC0374e componentCallbacksC0374e2) {
                    componentCallbacksC0374e.m2815a(componentCallbacksC0374e2);
                }
            });
        } else if (abstractC0381l instanceof InterfaceC0388s) {
            m3017a((InterfaceC0388s) abstractC0381l);
        }
        if (this.f2776x != null) {
            m2960H();
        }
        if (abstractC0381l instanceof InterfaceC0050d) {
            InterfaceC0050d interfaceC0050d = (InterfaceC0050d) abstractC0381l;
            this.f2764l = interfaceC0050d.mo299c();
            ComponentCallbacksC0374e componentCallbacksC0374e2 = interfaceC0050d;
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e2 = componentCallbacksC0374e;
            }
            this.f2764l.m287a(componentCallbacksC0374e2, this.f2765m);
        }
        if (componentCallbacksC0374e != null) {
            this.f2753O = componentCallbacksC0374e.f2655s.m2987p(componentCallbacksC0374e);
        } else if (abstractC0381l instanceof ViewModelStoreOwner) {
            this.f2753O = C0387r.m3102a(((ViewModelStoreOwner) abstractC0381l).getViewModelStore());
        } else {
            this.f2753O = new C0387r(false);
        }
        this.f2753O.m3105a(m3049g());
        this.f2761i.m3142a(this.f2753O);
        if (this.f2774v instanceof InterfaceC0057e) {
            AbstractC0056d mo301e = ((InterfaceC0057e) this.f2774v).mo301e();
            String str = "FragmentManager:" + (componentCallbacksC0374e != null ? componentCallbacksC0374e.f2643g + ":" : "");
            this.f2741C = mo301e.m329a(str + "StartActivityForResult", new C0053b.b(), new InterfaceC0054b<C0051a>() { // from class: androidx.fragment.app.o.10
                @Override // androidx.activity.result.InterfaceC0054b
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo321a(C0051a c0051a) {
                    c pollFirst = AbstractC0384o.this.f2758e.pollFirst();
                    if (pollFirst == null) {
                        Log.m190w("FragmentManager", "No Activities were started for result for " + this);
                        return;
                    }
                    String str2 = pollFirst.f2793a;
                    int i = pollFirst.f2794b;
                    ComponentCallbacksC0374e m3154d = AbstractC0384o.this.f2761i.m3154d(str2);
                    if (m3154d == null) {
                        Log.m190w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    } else {
                        m3154d.m2804a(i, c0051a.m310a(), c0051a.m311b());
                    }
                }
            });
            this.f2742D = mo301e.m329a(str + "StartIntentSenderForResult", new a(), new InterfaceC0054b<C0051a>() { // from class: androidx.fragment.app.o.2
                @Override // androidx.activity.result.InterfaceC0054b
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo321a(C0051a c0051a) {
                    c pollFirst = AbstractC0384o.this.f2758e.pollFirst();
                    if (pollFirst == null) {
                        Log.m190w("FragmentManager", "No IntentSenders were started for " + this);
                        return;
                    }
                    String str2 = pollFirst.f2793a;
                    int i = pollFirst.f2794b;
                    ComponentCallbacksC0374e m3154d = AbstractC0384o.this.f2761i.m3154d(str2);
                    if (m3154d == null) {
                        Log.m190w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str2);
                    } else {
                        m3154d.m2804a(i, c0051a.m310a(), c0051a.m311b());
                    }
                }
            });
            this.f2743E = mo301e.m329a(str + "RequestPermissions", new C0053b.a(), new InterfaceC0054b<Map<String, Boolean>>() { // from class: androidx.fragment.app.o.3
                @Override // androidx.activity.result.InterfaceC0054b
                @SuppressLint({"SyntheticAccessor"})
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo321a(Map<String, Boolean> map) {
                    String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                    ArrayList arrayList = new ArrayList(map.values());
                    int[] iArr = new int[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                    }
                    c pollFirst = AbstractC0384o.this.f2758e.pollFirst();
                    if (pollFirst == null) {
                        Log.m190w("FragmentManager", "No permissions were requested for " + this);
                        return;
                    }
                    String str2 = pollFirst.f2793a;
                    int i2 = pollFirst.f2794b;
                    ComponentCallbacksC0374e m3154d = AbstractC0384o.this.f2761i.m3154d(str2);
                    if (m3154d == null) {
                        Log.m190w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                    } else {
                        m3154d.mo2805a(i2, strArr, iArr);
                    }
                }
            });
        }
    }

    /* renamed from: o */
    void m3064o() {
        if (this.f2774v != null) {
            this.f2745G = false;
            this.f2746H = false;
            this.f2753O.m3105a(false);
            for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
                if (componentCallbacksC0374e != null) {
                    componentCallbacksC0374e.m2796W();
                }
            }
        }
    }

    /* renamed from: a */
    void m3013a(ComponentCallbacksC0374e componentCallbacksC0374e, String[] strArr, int i) {
        if (this.f2743E != null) {
            this.f2758e.addLast(new c(componentCallbacksC0374e.f2643g, i));
            this.f2743E.m323a(strArr);
            return;
        }
        this.f2774v.m2942a(componentCallbacksC0374e, strArr, i);
    }

    /* renamed from: p */
    void m3066p() {
        this.f2745G = false;
        this.f2746H = false;
        this.f2753O.m3105a(false);
        m2986e(0);
    }

    /* renamed from: q */
    void m3067q() {
        this.f2745G = false;
        this.f2746H = false;
        this.f2753O.m3105a(false);
        m2986e(1);
    }

    /* renamed from: r */
    void m3068r() {
        m2986e(2);
    }

    /* renamed from: s */
    void m3069s() {
        this.f2745G = false;
        this.f2746H = false;
        this.f2753O.m3105a(false);
        m2986e(4);
    }

    /* renamed from: t */
    void m3070t() {
        this.f2745G = false;
        this.f2746H = false;
        this.f2753O.m3105a(false);
        m2986e(5);
    }

    /* renamed from: u */
    void m3071u() {
        this.f2745G = false;
        this.f2746H = false;
        this.f2753O.m3105a(false);
        m2986e(7);
    }

    /* renamed from: v */
    void m3072v() {
        m2986e(5);
    }

    /* renamed from: w */
    void m3073w() {
        this.f2746H = true;
        this.f2753O.m3105a(true);
        m2986e(4);
    }

    /* renamed from: x */
    void m3074x() {
        m2986e(1);
    }

    /* renamed from: y */
    void m3075y() {
        this.f2747I = true;
        m3026a(true);
        m2965M();
        m2986e(-1);
        this.f2774v = null;
        this.f2775w = null;
        this.f2776x = null;
        if (this.f2764l != null) {
            this.f2765m.m306b();
            this.f2764l = null;
        }
        if (this.f2741C != null) {
            this.f2741C.mo322a();
            this.f2742D.mo322a();
            this.f2743E.mo322a();
        }
    }

    /* renamed from: e */
    private void m2986e(int i) {
        try {
            this.f2760h = true;
            this.f2761i.m3140a(i);
            m3004a(i, false);
            if (f2737a) {
                Iterator<AbstractC0368ae> it = m2966N().iterator();
                while (it.hasNext()) {
                    it.next().m2711e();
                }
            }
            this.f2760h = false;
            m3026a(true);
        } catch (Throwable th) {
            this.f2760h = false;
            throw th;
        }
    }

    /* renamed from: b */
    void m3032b(boolean z) {
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e.m2861g(z);
            }
        }
    }

    /* renamed from: c */
    void m3039c(boolean z) {
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e.m2863h(z);
            }
        }
    }

    /* renamed from: a */
    void m3005a(Configuration configuration) {
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e.m2810a(configuration);
            }
        }
    }

    /* renamed from: z */
    void m3076z() {
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e.m2798Y();
            }
        }
    }

    /* renamed from: a */
    boolean m3022a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        if (this.f2756c < 1) {
            return false;
        }
        ArrayList<ComponentCallbacksC0374e> arrayList = null;
        boolean z2 = false;
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null && m3035b(componentCallbacksC0374e) && componentCallbacksC0374e.m2847b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(componentCallbacksC0374e);
                z = true;
            } else {
                z = z2;
            }
            z2 = z;
        }
        if (this.f2762j != null) {
            for (int i = 0; i < this.f2762j.size(); i++) {
                ComponentCallbacksC0374e componentCallbacksC0374e2 = this.f2762j.get(i);
                if (arrayList == null || !arrayList.contains(componentCallbacksC0374e2)) {
                    componentCallbacksC0374e2.m2782I();
                }
            }
        }
        this.f2762j = arrayList;
        return z2;
    }

    /* renamed from: a */
    boolean m3021a(Menu menu) {
        boolean z = false;
        if (this.f2756c < 1) {
            return false;
        }
        Iterator<ComponentCallbacksC0374e> it = this.f2761i.m3160h().iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            ComponentCallbacksC0374e next = it.next();
            z = (next != null && m3035b(next) && next.m2851c(menu)) ? true : z2;
        }
    }

    /* renamed from: a */
    boolean m3023a(MenuItem menuItem) {
        if (this.f2756c < 1) {
            return false;
        }
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null && componentCallbacksC0374e.m2852c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    boolean m3034b(MenuItem menuItem) {
        if (this.f2756c < 1) {
            return false;
        }
        for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
            if (componentCallbacksC0374e != null && componentCallbacksC0374e.m2856d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    void m3029b(Menu menu) {
        if (this.f2756c >= 1) {
            for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2761i.m3160h()) {
                if (componentCallbacksC0374e != null) {
                    componentCallbacksC0374e.m2854d(menu);
                }
            }
        }
    }

    /* renamed from: m */
    void m3061m(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e != null && (!componentCallbacksC0374e.equals(m3042d(componentCallbacksC0374e.f2643g)) || (componentCallbacksC0374e.f2656t != null && componentCallbacksC0374e.f2655s != this))) {
            throw new IllegalArgumentException("Fragment " + componentCallbacksC0374e + " is not an active fragment of FragmentManager " + this);
        }
        ComponentCallbacksC0374e componentCallbacksC0374e2 = this.f2757d;
        this.f2757d = componentCallbacksC0374e;
        m2993v(componentCallbacksC0374e2);
        m2993v(this.f2757d);
    }

    /* renamed from: v */
    private void m2993v(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e != null && componentCallbacksC0374e.equals(m3042d(componentCallbacksC0374e.f2643g))) {
            componentCallbacksC0374e.m2797X();
        }
    }

    /* renamed from: A */
    void m2995A() {
        m2960H();
        m2993v(this.f2757d);
    }

    /* renamed from: B */
    public ComponentCallbacksC0374e m2996B() {
        return this.f2757d;
    }

    /* renamed from: a */
    void m3011a(ComponentCallbacksC0374e componentCallbacksC0374e, Lifecycle.State state) {
        if (!componentCallbacksC0374e.equals(m3042d(componentCallbacksC0374e.f2643g)) || (componentCallbacksC0374e.f2656t != null && componentCallbacksC0374e.f2655s != this)) {
            throw new IllegalArgumentException("Fragment " + componentCallbacksC0374e + " is not an active fragment of FragmentManager " + this);
        }
        componentCallbacksC0374e.f2627Q = state;
    }

    /* renamed from: C */
    public C0380k m2997C() {
        if (this.f2777y != null) {
            return this.f2777y;
        }
        if (this.f2776x != null) {
            return this.f2776x.f2655s.m2997C();
        }
        return this.f2778z;
    }

    /* renamed from: D */
    InterfaceC0369af m2998D() {
        if (this.f2739A != null) {
            return this.f2739A;
        }
        if (this.f2776x != null) {
            return this.f2776x.f2655s.m2998D();
        }
        return this.f2740B;
    }

    /* renamed from: E */
    C0383n m2999E() {
        return this.f2772t;
    }

    /* renamed from: a */
    public void m3017a(InterfaceC0388s interfaceC0388s) {
        this.f2773u.add(interfaceC0388s);
    }

    /* renamed from: n */
    void m3063n(ComponentCallbacksC0374e componentCallbacksC0374e) {
        Iterator<InterfaceC0388s> it = this.f2773u.iterator();
        while (it.hasNext()) {
            it.next().mo2901a(this, componentCallbacksC0374e);
        }
    }

    /* renamed from: F */
    boolean m3000F() {
        Iterator<ComponentCallbacksC0374e> it = this.f2761i.m3161i().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ComponentCallbacksC0374e next = it.next();
            boolean m2994w = next != null ? m2994w(next) : z;
            if (m2994w) {
                return true;
            }
            z = m2994w;
        }
        return false;
    }

    /* renamed from: w */
    private boolean m2994w(ComponentCallbacksC0374e componentCallbacksC0374e) {
        return (componentCallbacksC0374e.f2614D && componentCallbacksC0374e.f2615E) || componentCallbacksC0374e.f2657u.m3000F();
    }

    /* renamed from: o */
    void m3065o(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e.f2648l && m2994w(componentCallbacksC0374e)) {
            this.f2744F = true;
        }
    }

    /* renamed from: d */
    static int m2984d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    /* renamed from: G */
    LayoutInflater.Factory2 m3001G() {
        return this.f2763k;
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.o$f */
    private class f implements e {

        /* renamed from: a */
        final String f2795a;

        /* renamed from: b */
        final int f2796b;

        /* renamed from: c */
        final int f2797c;

        f(String str, int i, int i2) {
            this.f2795a = str;
            this.f2796b = i;
            this.f2797c = i2;
        }

        @Override // androidx.fragment.app.AbstractC0384o.e
        /* renamed from: a */
        public boolean mo2642a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2) {
            if (AbstractC0384o.this.f2757d == null || this.f2796b >= 0 || this.f2795a != null || !AbstractC0384o.this.f2757d.m2884u().m3040c()) {
                return AbstractC0384o.this.m3025a(arrayList, arrayList2, this.f2795a, this.f2796b, this.f2797c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.o$g */
    static class g implements ComponentCallbacksC0374e.d {

        /* renamed from: a */
        final boolean f2799a;

        /* renamed from: b */
        final C0363a f2800b;

        /* renamed from: c */
        private int f2801c;

        g(C0363a c0363a, boolean z) {
            this.f2799a = z;
            this.f2800b = c0363a;
        }

        @Override // androidx.fragment.app.ComponentCallbacksC0374e.d
        /* renamed from: a */
        public void mo2891a() {
            this.f2801c--;
            if (this.f2801c == 0) {
                this.f2800b.f2468a.m3050h();
            }
        }

        @Override // androidx.fragment.app.ComponentCallbacksC0374e.d
        /* renamed from: b */
        public void mo2892b() {
            this.f2801c++;
        }

        /* renamed from: c */
        public boolean m3097c() {
            return this.f2801c == 0;
        }

        /* renamed from: d */
        void m3098d() {
            boolean z = this.f2801c > 0;
            for (ComponentCallbacksC0374e componentCallbacksC0374e : this.f2800b.f2468a.m3044e()) {
                componentCallbacksC0374e.m2814a((ComponentCallbacksC0374e.d) null);
                if (z && componentCallbacksC0374e.m2840as()) {
                    componentCallbacksC0374e.m2791R();
                }
            }
            this.f2800b.f2468a.m3008a(this.f2800b, this.f2799a, z ? false : true, true);
        }

        /* renamed from: e */
        void m3099e() {
            this.f2800b.f2468a.m3008a(this.f2800b, this.f2799a, false, false);
        }
    }

    /* compiled from: FragmentManager.java */
    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: androidx.fragment.app.o$c */
    static class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: androidx.fragment.app.o.c.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        };

        /* renamed from: a */
        String f2793a;

        /* renamed from: b */
        int f2794b;

        c(String str, int i) {
            this.f2793a = str;
            this.f2794b = i;
        }

        c(Parcel parcel) {
            this.f2793a = parcel.readString();
            this.f2794b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f2793a);
            parcel.writeInt(this.f2794b);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.o$a */
    static class a extends AbstractC0052a<C0058f, C0051a> {
        a() {
        }

        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public Intent mo314a(Context context, C0058f c0058f) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent m337b = c0058f.m337b();
            if (m337b != null && (bundleExtra = m337b.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                m337b.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (m337b.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    c0058f = new C0058f.a(c0058f.m336a()).m343a(null).m342a(c0058f.m339d(), c0058f.m338c()).m344a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c0058f);
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // androidx.activity.result.p013a.AbstractC0052a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0051a mo315a(int i, Intent intent) {
            return new C0051a(i, intent);
        }
    }
}
