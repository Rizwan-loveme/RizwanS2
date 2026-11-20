package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.AbstractC0384o;
import androidx.fragment.app.AbstractC0393x;
import androidx.fragment.app.ComponentCallbacksC0374e;
import java.p209io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* renamed from: androidx.fragment.app.a */
/* loaded from: classes.dex */
final class C0363a extends AbstractC0393x implements AbstractC0384o.e {

    /* renamed from: a */
    final AbstractC0384o f2468a;

    /* renamed from: b */
    boolean f2469b;

    /* renamed from: c */
    int f2470c;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2470c >= 0) {
            sb.append(" #");
            sb.append(this.f2470c);
        }
        if (this.f2852l != null) {
            sb.append(" ");
            sb.append(this.f2852l);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m2639a(String str, PrintWriter printWriter) {
        m2640a(str, printWriter, true);
    }

    /* renamed from: a */
    public void m2640a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2852l);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2470c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2469b);
            if (this.f2849i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2849i));
            }
            if (this.f2845e != 0 || this.f2846f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2845e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2846f));
            }
            if (this.f2847g != 0 || this.f2848h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2847g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2848h));
            }
            if (this.f2853m != 0 || this.f2854n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2853m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2854n);
            }
            if (this.f2855o != 0 || this.f2856p != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2855o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2856p);
            }
        }
        if (!this.f2844d.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f2844d.size();
            for (int i = 0; i < size; i++) {
                AbstractC0393x.a aVar = this.f2844d.get(i);
                switch (aVar.f2861a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f2861a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f2862b);
                if (z) {
                    if (aVar.f2863c != 0 || aVar.f2864d != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2863c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2864d));
                    }
                    if (aVar.f2865e != 0 || aVar.f2866f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f2865e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f2866f));
                    }
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    C0363a(AbstractC0384o abstractC0384o) {
        super(r1, r0);
        ClassLoader classLoader;
        C0380k m2997C = abstractC0384o.m2997C();
        if (abstractC0384o.m3056k() != null) {
            classLoader = abstractC0384o.m3056k().m2944i().getClassLoader();
        } else {
            classLoader = null;
        }
        this.f2470c = -1;
        this.f2468a = abstractC0384o;
    }

    @Override // androidx.fragment.app.AbstractC0393x
    /* renamed from: a */
    void mo2637a(int i, ComponentCallbacksC0374e componentCallbacksC0374e, String str, int i2) {
        super.mo2637a(i, componentCallbacksC0374e, str, i2);
        componentCallbacksC0374e.f2655s = this.f2468a;
    }

    @Override // androidx.fragment.app.AbstractC0393x
    /* renamed from: a */
    public AbstractC0393x mo2634a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (componentCallbacksC0374e.f2655s != null && componentCallbacksC0374e.f2655s != this.f2468a) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + componentCallbacksC0374e.toString() + " is already attached to a FragmentManager.");
        }
        return super.mo2634a(componentCallbacksC0374e);
    }

    /* renamed from: a */
    void m2636a(int i) {
        if (this.f2850j) {
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f2844d.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0393x.a aVar = this.f2844d.get(i2);
                if (aVar.f2862b != null) {
                    aVar.f2862b.f2654r += i;
                    if (AbstractC0384o.m2976a(2)) {
                        Log.m188v("FragmentManager", "Bump nesting of " + aVar.f2862b + " to " + aVar.f2862b.f2654r);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m2635a() {
        if (this.f2860t != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2860t.size()) {
                    this.f2860t.get(i2).run();
                    i = i2 + 1;
                } else {
                    this.f2860t = null;
                    return;
                }
            }
        }
    }

    @Override // androidx.fragment.app.AbstractC0393x
    /* renamed from: b */
    public int mo2643b() {
        return m2632a(false);
    }

    @Override // androidx.fragment.app.AbstractC0393x
    /* renamed from: c */
    public int mo2647c() {
        return m2632a(true);
    }

    @Override // androidx.fragment.app.AbstractC0393x
    /* renamed from: d */
    public void mo2648d() {
        m3168h();
        this.f2468a.m3031b((AbstractC0384o.e) this, true);
    }

    /* renamed from: a */
    int m2632a(boolean z) {
        if (this.f2469b) {
            throw new IllegalStateException("commit already called");
        }
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C0367ad("FragmentManager"));
            m2639a("  ", printWriter);
            printWriter.close();
        }
        this.f2469b = true;
        if (this.f2850j) {
            this.f2470c = this.f2468a.m3052i();
        } else {
            this.f2470c = -1;
        }
        this.f2468a.m3016a(this, z);
        return this.f2470c;
    }

    @Override // androidx.fragment.app.AbstractC0384o.e
    /* renamed from: a */
    public boolean mo2642a(ArrayList<C0363a> arrayList, ArrayList<Boolean> arrayList2) {
        if (AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.f2850j) {
            this.f2468a.m3007a(this);
            return true;
        }
        return true;
    }

    /* renamed from: b */
    boolean m2646b(int i) {
        int size = this.f2844d.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0393x.a aVar = this.f2844d.get(i2);
            int i3 = aVar.f2862b != null ? aVar.f2862b.f2660x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    boolean m2641a(ArrayList<C0363a> arrayList, int i, int i2) {
        int i3;
        if (i2 == i) {
            return false;
        }
        int size = this.f2844d.size();
        int i4 = -1;
        int i5 = 0;
        while (i5 < size) {
            AbstractC0393x.a aVar = this.f2844d.get(i5);
            int i6 = aVar.f2862b != null ? aVar.f2862b.f2660x : 0;
            if (i6 == 0 || i6 == i4) {
                i3 = i4;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    C0363a c0363a = arrayList.get(i7);
                    int size2 = c0363a.f2844d.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        AbstractC0393x.a aVar2 = c0363a.f2844d.get(i8);
                        if ((aVar2.f2862b != null ? aVar2.f2862b.f2660x : 0) == i6) {
                            return true;
                        }
                    }
                }
                i3 = i6;
            }
            i5++;
            i4 = i3;
        }
        return false;
    }

    /* renamed from: e */
    void m2649e() {
        int size = this.f2844d.size();
        for (int i = 0; i < size; i++) {
            AbstractC0393x.a aVar = this.f2844d.get(i);
            ComponentCallbacksC0374e componentCallbacksC0374e = aVar.f2862b;
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e.m2866i(false);
                componentCallbacksC0374e.m2853d(this.f2849i);
                componentCallbacksC0374e.m2817a(this.f2857q, this.f2858r);
            }
            switch (aVar.f2861a) {
                case 1:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3012a(componentCallbacksC0374e, false);
                    this.f2468a.m3048g(componentCallbacksC0374e);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2861a);
                case 3:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3051h(componentCallbacksC0374e);
                    break;
                case 4:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3053i(componentCallbacksC0374e);
                    break;
                case 5:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3012a(componentCallbacksC0374e, false);
                    this.f2468a.m3055j(componentCallbacksC0374e);
                    break;
                case 6:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3057k(componentCallbacksC0374e);
                    break;
                case 7:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3012a(componentCallbacksC0374e, false);
                    this.f2468a.m3059l(componentCallbacksC0374e);
                    break;
                case 8:
                    this.f2468a.m3061m(componentCallbacksC0374e);
                    break;
                case 9:
                    this.f2468a.m3061m(null);
                    break;
                case 10:
                    this.f2468a.m3011a(componentCallbacksC0374e, aVar.f2868h);
                    break;
            }
            if (!this.f2859s && aVar.f2861a != 1 && componentCallbacksC0374e != null && !AbstractC0384o.f2737a) {
                this.f2468a.m3045e(componentCallbacksC0374e);
            }
        }
        if (!this.f2859s && !AbstractC0384o.f2737a) {
            this.f2468a.m3004a(this.f2468a.f2756c, true);
        }
    }

    /* renamed from: b */
    void m2645b(boolean z) {
        for (int size = this.f2844d.size() - 1; size >= 0; size--) {
            AbstractC0393x.a aVar = this.f2844d.get(size);
            ComponentCallbacksC0374e componentCallbacksC0374e = aVar.f2862b;
            if (componentCallbacksC0374e != null) {
                componentCallbacksC0374e.m2866i(true);
                componentCallbacksC0374e.m2853d(AbstractC0384o.m2984d(this.f2849i));
                componentCallbacksC0374e.m2817a(this.f2858r, this.f2857q);
            }
            switch (aVar.f2861a) {
                case 1:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3012a(componentCallbacksC0374e, true);
                    this.f2468a.m3051h(componentCallbacksC0374e);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f2861a);
                case 3:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3048g(componentCallbacksC0374e);
                    break;
                case 4:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3055j(componentCallbacksC0374e);
                    break;
                case 5:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3012a(componentCallbacksC0374e, true);
                    this.f2468a.m3053i(componentCallbacksC0374e);
                    break;
                case 6:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3059l(componentCallbacksC0374e);
                    break;
                case 7:
                    componentCallbacksC0374e.m2803a(aVar.f2863c, aVar.f2864d, aVar.f2865e, aVar.f2866f);
                    this.f2468a.m3012a(componentCallbacksC0374e, true);
                    this.f2468a.m3057k(componentCallbacksC0374e);
                    break;
                case 8:
                    this.f2468a.m3061m(null);
                    break;
                case 9:
                    this.f2468a.m3061m(componentCallbacksC0374e);
                    break;
                case 10:
                    this.f2468a.m3011a(componentCallbacksC0374e, aVar.f2867g);
                    break;
            }
            if (!this.f2859s && aVar.f2861a != 3 && componentCallbacksC0374e != null && !AbstractC0384o.f2737a) {
                this.f2468a.m3045e(componentCallbacksC0374e);
            }
        }
        if (!this.f2859s && z && !AbstractC0384o.f2737a) {
            this.f2468a.m3004a(this.f2468a.f2756c, true);
        }
    }

    /* renamed from: a */
    ComponentCallbacksC0374e m2633a(ArrayList<ComponentCallbacksC0374e> arrayList, ComponentCallbacksC0374e componentCallbacksC0374e) {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2844d.size()) {
                AbstractC0393x.a aVar = this.f2844d.get(i2);
                switch (aVar.f2861a) {
                    case 1:
                    case 7:
                        arrayList.add(aVar.f2862b);
                        break;
                    case 2:
                        ComponentCallbacksC0374e componentCallbacksC0374e2 = aVar.f2862b;
                        int i3 = componentCallbacksC0374e2.f2660x;
                        boolean z2 = false;
                        int size = arrayList.size() - 1;
                        int i4 = i2;
                        ComponentCallbacksC0374e componentCallbacksC0374e3 = componentCallbacksC0374e;
                        while (size >= 0) {
                            ComponentCallbacksC0374e componentCallbacksC0374e4 = arrayList.get(size);
                            if (componentCallbacksC0374e4.f2660x != i3) {
                                z = z2;
                            } else if (componentCallbacksC0374e4 == componentCallbacksC0374e2) {
                                z = true;
                            } else {
                                if (componentCallbacksC0374e4 == componentCallbacksC0374e3) {
                                    this.f2844d.add(i4, new AbstractC0393x.a(9, componentCallbacksC0374e4));
                                    i4++;
                                    componentCallbacksC0374e3 = null;
                                }
                                AbstractC0393x.a aVar2 = new AbstractC0393x.a(3, componentCallbacksC0374e4);
                                aVar2.f2863c = aVar.f2863c;
                                aVar2.f2865e = aVar.f2865e;
                                aVar2.f2864d = aVar.f2864d;
                                aVar2.f2866f = aVar.f2866f;
                                this.f2844d.add(i4, aVar2);
                                arrayList.remove(componentCallbacksC0374e4);
                                i4++;
                                z = z2;
                            }
                            size--;
                            z2 = z;
                        }
                        if (z2) {
                            this.f2844d.remove(i4);
                            i4--;
                        } else {
                            aVar.f2861a = 1;
                            arrayList.add(componentCallbacksC0374e2);
                        }
                        i2 = i4;
                        componentCallbacksC0374e = componentCallbacksC0374e3;
                        break;
                    case 3:
                    case 6:
                        arrayList.remove(aVar.f2862b);
                        if (aVar.f2862b != componentCallbacksC0374e) {
                            break;
                        } else {
                            this.f2844d.add(i2, new AbstractC0393x.a(9, aVar.f2862b));
                            i2++;
                            componentCallbacksC0374e = null;
                            break;
                        }
                    case 8:
                        this.f2844d.add(i2, new AbstractC0393x.a(9, componentCallbacksC0374e));
                        i2++;
                        componentCallbacksC0374e = aVar.f2862b;
                        break;
                }
                i = i2 + 1;
            } else {
                return componentCallbacksC0374e;
            }
        }
    }

    /* renamed from: b */
    ComponentCallbacksC0374e m2644b(ArrayList<ComponentCallbacksC0374e> arrayList, ComponentCallbacksC0374e componentCallbacksC0374e) {
        ComponentCallbacksC0374e componentCallbacksC0374e2;
        int size = this.f2844d.size() - 1;
        ComponentCallbacksC0374e componentCallbacksC0374e3 = componentCallbacksC0374e;
        while (size >= 0) {
            AbstractC0393x.a aVar = this.f2844d.get(size);
            switch (aVar.f2861a) {
                case 1:
                case 7:
                    arrayList.remove(aVar.f2862b);
                    componentCallbacksC0374e2 = componentCallbacksC0374e3;
                    continue;
                case 3:
                case 6:
                    arrayList.add(aVar.f2862b);
                    componentCallbacksC0374e2 = componentCallbacksC0374e3;
                    continue;
                case 8:
                    componentCallbacksC0374e2 = null;
                    continue;
                case 9:
                    componentCallbacksC0374e2 = aVar.f2862b;
                    continue;
                case 10:
                    aVar.f2868h = aVar.f2867g;
                    break;
            }
            componentCallbacksC0374e2 = componentCallbacksC0374e3;
            size--;
            componentCallbacksC0374e3 = componentCallbacksC0374e2;
        }
        return componentCallbacksC0374e3;
    }

    /* renamed from: f */
    boolean m2650f() {
        for (int i = 0; i < this.f2844d.size(); i++) {
            if (m2631b(this.f2844d.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m2638a(ComponentCallbacksC0374e.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2844d.size()) {
                AbstractC0393x.a aVar = this.f2844d.get(i2);
                if (m2631b(aVar)) {
                    aVar.f2862b.m2814a(dVar);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private static boolean m2631b(AbstractC0393x.a aVar) {
        ComponentCallbacksC0374e componentCallbacksC0374e = aVar.f2862b;
        return (componentCallbacksC0374e == null || !componentCallbacksC0374e.f2648l || componentCallbacksC0374e.f2617G == null || componentCallbacksC0374e.f2611A || componentCallbacksC0374e.f2662z || !componentCallbacksC0374e.m2840as()) ? false : true;
    }

    /* renamed from: g */
    public String m2651g() {
        return this.f2852l;
    }
}
