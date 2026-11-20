package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: FragmentStore.java */
/* renamed from: androidx.fragment.app.w */
/* loaded from: classes.dex */
class C0392w {

    /* renamed from: a */
    private final ArrayList<ComponentCallbacksC0374e> f2839a = new ArrayList<>();

    /* renamed from: b */
    private final HashMap<String, C0391v> f2840b = new HashMap<>();

    /* renamed from: c */
    private C0387r f2841c;

    C0392w() {
    }

    /* renamed from: a */
    void m3142a(C0387r c0387r) {
        this.f2841c = c0387r;
    }

    /* renamed from: a */
    C0387r m3139a() {
        return this.f2841c;
    }

    /* renamed from: b */
    void m3147b() {
        this.f2840b.clear();
    }

    /* renamed from: a */
    void m3145a(List<String> list) {
        this.f2839a.clear();
        if (list != null) {
            for (String str : list) {
                ComponentCallbacksC0374e m3156e = m3156e(str);
                if (m3156e == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "restoreSaveState: added (" + str + "): " + m3156e);
                }
                m3141a(m3156e);
            }
        }
    }

    /* renamed from: a */
    void m3143a(C0391v c0391v) {
        ComponentCallbacksC0374e m3118a = c0391v.m3118a();
        if (!m3150b(m3118a.f2643g)) {
            this.f2840b.put(m3118a.f2643g, c0391v);
            if (m3118a.f2613C) {
                if (m3118a.f2612B) {
                    this.f2841c.m3104a(m3118a);
                } else {
                    this.f2841c.m3109c(m3118a);
                }
                m3118a.f2613C = false;
            }
            if (AbstractC0384o.m2976a(2)) {
                Log.m188v("FragmentManager", "Added fragment to active set " + m3118a);
            }
        }
    }

    /* renamed from: a */
    void m3141a(ComponentCallbacksC0374e componentCallbacksC0374e) {
        if (this.f2839a.contains(componentCallbacksC0374e)) {
            throw new IllegalStateException("Fragment already added: " + componentCallbacksC0374e);
        }
        synchronized (this.f2839a) {
            this.f2839a.add(componentCallbacksC0374e);
        }
        componentCallbacksC0374e.f2648l = true;
    }

    /* renamed from: a */
    void m3140a(int i) {
        for (C0391v c0391v : this.f2840b.values()) {
            if (c0391v != null) {
                c0391v.m3119a(i);
            }
        }
    }

    /* renamed from: c */
    void m3153c() {
        Iterator<ComponentCallbacksC0374e> it = this.f2839a.iterator();
        while (it.hasNext()) {
            C0391v c0391v = this.f2840b.get(it.next().f2643g);
            if (c0391v != null) {
                c0391v.m3122c();
            }
        }
        for (C0391v c0391v2 : this.f2840b.values()) {
            if (c0391v2 != null) {
                c0391v2.m3122c();
                ComponentCallbacksC0374e m3118a = c0391v2.m3118a();
                if (m3118a.f2649m && !m3118a.m2869j()) {
                    m3149b(c0391v2);
                }
            }
        }
    }

    /* renamed from: b */
    void m3148b(ComponentCallbacksC0374e componentCallbacksC0374e) {
        synchronized (this.f2839a) {
            this.f2839a.remove(componentCallbacksC0374e);
        }
        componentCallbacksC0374e.f2648l = false;
    }

    /* renamed from: b */
    void m3149b(C0391v c0391v) {
        ComponentCallbacksC0374e m3118a = c0391v.m3118a();
        if (m3118a.f2612B) {
            this.f2841c.m3109c(m3118a);
        }
        if (this.f2840b.put(m3118a.f2643g, null) != null && AbstractC0384o.m2976a(2)) {
            Log.m188v("FragmentManager", "Removed fragment from active set " + m3118a);
        }
    }

    /* renamed from: d */
    void m3155d() {
        this.f2840b.values().removeAll(Collections.singleton(null));
    }

    /* renamed from: e */
    ArrayList<C0390u> m3157e() {
        ArrayList<C0390u> arrayList = new ArrayList<>(this.f2840b.size());
        for (C0391v c0391v : this.f2840b.values()) {
            if (c0391v != null) {
                ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                C0390u m3132m = c0391v.m3132m();
                arrayList.add(m3132m);
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "Saved state of " + m3118a + ": " + m3132m.f2830m);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    ArrayList<String> m3158f() {
        synchronized (this.f2839a) {
            if (this.f2839a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f2839a.size());
            Iterator<ComponentCallbacksC0374e> it = this.f2839a.iterator();
            while (it.hasNext()) {
                ComponentCallbacksC0374e next = it.next();
                arrayList.add(next.f2643g);
                if (AbstractC0384o.m2976a(2)) {
                    Log.m188v("FragmentManager", "saveAllState: adding fragment (" + next.f2643g + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* renamed from: g */
    List<C0391v> m3159g() {
        ArrayList arrayList = new ArrayList();
        for (C0391v c0391v : this.f2840b.values()) {
            if (c0391v != null) {
                arrayList.add(c0391v);
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    List<ComponentCallbacksC0374e> m3160h() {
        ArrayList arrayList;
        if (this.f2839a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2839a) {
            arrayList = new ArrayList(this.f2839a);
        }
        return arrayList;
    }

    /* renamed from: i */
    List<ComponentCallbacksC0374e> m3161i() {
        ArrayList arrayList = new ArrayList();
        for (C0391v c0391v : this.f2840b.values()) {
            if (c0391v != null) {
                arrayList.add(c0391v.m3118a());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    ComponentCallbacksC0374e m3146b(int i) {
        for (int size = this.f2839a.size() - 1; size >= 0; size--) {
            ComponentCallbacksC0374e componentCallbacksC0374e = this.f2839a.get(size);
            if (componentCallbacksC0374e != null && componentCallbacksC0374e.f2659w == i) {
                return componentCallbacksC0374e;
            }
        }
        for (C0391v c0391v : this.f2840b.values()) {
            if (c0391v != null) {
                ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                if (m3118a.f2659w == i) {
                    return m3118a;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    ComponentCallbacksC0374e m3138a(String str) {
        if (str != null) {
            for (int size = this.f2839a.size() - 1; size >= 0; size--) {
                ComponentCallbacksC0374e componentCallbacksC0374e = this.f2839a.get(size);
                if (componentCallbacksC0374e != null && str.equals(componentCallbacksC0374e.f2661y)) {
                    return componentCallbacksC0374e;
                }
            }
        }
        if (str != null) {
            for (C0391v c0391v : this.f2840b.values()) {
                if (c0391v != null) {
                    ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                    if (str.equals(m3118a.f2661y)) {
                        return m3118a;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    boolean m3150b(String str) {
        return this.f2840b.get(str) != null;
    }

    /* renamed from: c */
    C0391v m3152c(String str) {
        return this.f2840b.get(str);
    }

    /* renamed from: d */
    ComponentCallbacksC0374e m3154d(String str) {
        ComponentCallbacksC0374e m2843b;
        for (C0391v c0391v : this.f2840b.values()) {
            if (c0391v != null && (m2843b = c0391v.m3118a().m2843b(str)) != null) {
                return m2843b;
            }
        }
        return null;
    }

    /* renamed from: e */
    ComponentCallbacksC0374e m3156e(String str) {
        C0391v c0391v = this.f2840b.get(str);
        if (c0391v != null) {
            return c0391v.m3118a();
        }
        return null;
    }

    /* renamed from: c */
    int m3151c(ComponentCallbacksC0374e componentCallbacksC0374e) {
        ViewGroup viewGroup = componentCallbacksC0374e.f2616F;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f2839a.indexOf(componentCallbacksC0374e);
        for (int i = indexOf - 1; i >= 0; i--) {
            ComponentCallbacksC0374e componentCallbacksC0374e2 = this.f2839a.get(i);
            if (componentCallbacksC0374e2.f2616F == viewGroup && componentCallbacksC0374e2.f2617G != null) {
                return viewGroup.indexOfChild(componentCallbacksC0374e2.f2617G) + 1;
            }
        }
        int i2 = indexOf + 1;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f2839a.size()) {
                return -1;
            }
            ComponentCallbacksC0374e componentCallbacksC0374e3 = this.f2839a.get(i3);
            if (componentCallbacksC0374e3.f2616F != viewGroup || componentCallbacksC0374e3.f2617G == null) {
                i2 = i3 + 1;
            } else {
                return viewGroup.indexOfChild(componentCallbacksC0374e3.f2617G);
            }
        }
    }

    /* renamed from: a */
    void m3144a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f2840b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C0391v c0391v : this.f2840b.values()) {
                printWriter.print(str);
                if (c0391v != null) {
                    ComponentCallbacksC0374e m3118a = c0391v.m3118a();
                    printWriter.println(m3118a);
                    m3118a.m2816a(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f2839a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                ComponentCallbacksC0374e componentCallbacksC0374e = this.f2839a.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0374e.toString());
            }
        }
    }
}
